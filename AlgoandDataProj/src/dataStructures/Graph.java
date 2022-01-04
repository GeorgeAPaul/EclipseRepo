package dataStructures;

/**
 * 
 * @author George Paul
 *
 * @param <E> Data type to be stored in the Graph.
 */
public class Graph<E extends Comparable<E>>
{
	/**
	 * 
	 * Nodes store the data in the graph
	 * @param <P> Data type to be stored in the Node.
	 */
    public class Node<P extends Comparable<P>> implements Comparable<Node<P>>
    {
    	/**
    	 * Stores the data in the node
    	 */
        private P info;
        
        /**
         * Vector for the edges that connect to other Nodes
         */
        private Vector<Edge<P>> edges;
        
        /**
         * Flag for checking whether the Node has been visited already on path finding algorithms
         */
        private boolean visited;
        
        /**
         * For keeping track of the distance to the source Node during the Bellman-Ford algorithm
         */
        private int bFordDistance;
        
        /**
         * For keeping track of the current calculated Node which is previous in the shortest path
         */
        private Node<P> bFordPi;
        
        /**
         * Constructor method
         * @param label Data to be stored in the node
         */
        public Node(P label)
        {
            info = label;
            edges = new Vector<Edge<P>>(1);
            visited = false; //All nodes are unvisited to begin with
            bFordDistance = Integer.MAX_VALUE; //When finding the shortest route, only update when the calculated distance is shorter than the current distance
        } 									   //therefore set to the max distance to begin with.
        
        /**
         * Method to add an edge to the Node
         * @param e Edge to be added
         */
        public void addEdge(Edge<P> e)
        {
            edges.addLast(e); //O(1) for a Vector
        }
        
        /**
         * Method to compare nodes
         * @param o Node to be compared
         * @return -ve if o is less, +ve if o is greater, 0 if the nodes are equal
         */
        public int compareTo(Node<P> o)
        {
            // two nodes are equal if they have the same label
            Node<P> n = (Node<P>)o;
            return n.info.compareTo(info);
        }
        
        /**
         * toString Method
         * @return String to represent the node
         */
        public String toString() {
        	return info.toString() + " " + edges;
        }
        
        /**
         * Method to return the data stored in the node
         * @return info the data stored in the node
         */
        public P getLabel()
        {
            return info;
        }
        
    }
    
    /**
     *
     *Edges store the connections between nodes
     * @param <P> Data type to be stored in the Edge
     */
    private class Edge<P extends Comparable<P>> implements Comparable<Edge<P>>
    {
    	/**
    	 * The node that this Edge connects to
    	 */
        private Node<P> toNode;
        
        /**
         * The distance between the edges
         */
        private int weight;
        
        /**
         * Constructor method
         * @param to The node that this Edge connects to
         * @param w The distance between the edges
         */
        public Edge(Node<P> to, int w){
            toNode = to;
            weight = w;
        }
        
        /**
         * Method to compare two edges
         * @return -ve if o is less, +ve if o is greater, 0 if the edges are equal
         */
        public int compareTo(Edge<P> o){
            Edge<P> n = o;
            return n.toNode.compareTo(toNode);
        }
        
        /**
         * toString method
         * @return String representation of the edge
         */
        public String toString() {
        	return "(" + toNode.getLabel() + " " + weight + ")";
        }
        
    }
    
    /**
     * Tree to store the nodes on the graph
     */
    private Tree<Node<E>> nodes;
    
    /**
     * Constructor method
     */
    public Graph(){
        nodes = new Tree<Node<E>>();
    }
    
    /**
     * Method to add a node to the graph
     * @param label data to store in the node
     */
    public void addNode(E label){
        nodes.insert(new Node<E>(label)); //O(logn)
    }
    
    /**
     * Method to find a node in the tree
     * @param nodeLabel data which the node contains
     * @return The node in the tree
     */
    private Node<E> findNode(E nodeLabel){
        return nodes.find(new Node<E>((nodeLabel))); //O(logn)
    }
    
    /**
     * Method to add an edge to the graph
     * @param nodeLabel1 Node to start from
     * @param nodeLabel2 Node to end at
     * @param weight Length of the edge
     */
    public void addEdge(E nodeLabel1, E nodeLabel2, int weight){
    	
        Node<E> n1 = findNode(nodeLabel1);
        Node<E> n2 = findNode(nodeLabel2);
        n1.addEdge(new Edge<E>(n2, weight));
    }
    
    /**
     * strinTo method
     * @return string representation of the graph
     */
    public String toString() {
    	return nodes.toString();
    }
    
    /**
     * Method to find path between two nodes
     * @param nodeLabel1 Starting node
     * @param nodeLabel2 End node
     * @return the path between the two node that has been found, if no path is found and empty Vector is returned
     */
    public Vector<E> findPath (E nodeLabel1 , E nodeLabel2) {
    	
    	//Finding the start and end nodes
    	Node<E> startState = findNode(nodeLabel1);
    	Node<E> endState = findNode(nodeLabel2);
    	
    	//If startState is same as endState return a path
    	Vector<E> path = new Vector<E>(10);
    	
    	//If startState is same as endState return a path
    	if(startState == endState) {
    		path.addLast(startState.getLabel());
    		path.addLast(endState.getLabel());
    		return path;
    	}
    	
    	//Traverse the whole tree and make sure all nodes are set to unvisited
    	nodes.traverse(new TreeAction<Node<E>>() {	
			@Override
			public void run(Tree<Graph<E>.Node<E>>.TreeNode<Graph<E>.Node<E>> n) {
				Node<E> node = n.getValue();
				node.visited = false; 
				
			}
		});
    	
    	//Stack for adding nodes to examine
    	Stack<Node<E>> toDoList = new Stack<Node<E>>();
    
    	//Variable to keep track of how far "current" is from the last node where there were multiple edges
    	int distanceFromDivergence = 0;
    	
    	//Set first Node to visited
    	startState.visited = true;
    	toDoList.push(startState);
    	
    	while (!toDoList.isEmpty()){ //While there are still nodes to check
    		
    		Node<E> current = toDoList.pop();
    		path.addLast(current.getLabel()); // Add node to the path
    		
    		if(current == endState) { //If we have reached the end node, return the path
    			return path;
    		}
    		
    		else {
    			
    			if(current.edges.size() > 1) { //If there are multiple edges at current node reset counter
    				distanceFromDivergence = 0;
    			}
    			else {
    				distanceFromDivergence++;
    			}
    			
    			for(int i = 0; i < current.edges.size(); i++) { //Iterate over current nodes edges
    				Edge<E> e = current.edges.get(i);
    				
    				if(e.toNode.visited == false) {//If node has not been visited already add it to toDoList
    					toDoList.push(e.toNode);
    					e.toNode.visited = true;
    				}
    			}
    			
    			if(current.edges.size() == 0) { //If we reach a dead end remove all nodes from the path up to the last node with multiple edges
    				for(int i = 0; i < distanceFromDivergence; i++) {
        				path.removeLast();
        			}
    				distanceFromDivergence = 0;
    			}
    		}
    	}
    	return new Vector<E>(10); //Returning empty Vector if path never found
    }
    
    /**
     * Method to find the shortest path between two nodes using Bellman-Ford algorithm
     * @param nodeLabel1 Start node
     * @param nodeLabel2 End node
     * @return LinkedList containing the data from each node
     */
    public LinkedList<E> findShortestPath(E nodeLabel1 , E nodeLabel2) {
    	
    	//Finding the start and end nodes
    	Node<E> startState = findNode(nodeLabel1);
    	Node<E> endState = findNode(nodeLabel2);
    	
    	//Shortest path between two nodes
    	LinkedList<E> path = new LinkedList<E>();
    	
    	//If startState is same as endState return a path 
    	if(startState == endState) {
    		path.addFirst(startState.getLabel());
    		path.addFirst(endState.getLabel());
    		return path;
    	}
    	
    	//Traverse the whole tree and make sure all nodes are set to unvisited and bFordDistance is set to max
    	nodes.traverse(new TreeAction<Node<E>>() {	
			@Override
			public void run(Tree<Graph<E>.Node<E>>.TreeNode<Graph<E>.Node<E>> n) {
				Node<E> node = n.getValue();
				node.visited = false; 
				node.bFordDistance = Integer.MAX_VALUE;
				
			}
		});
    	
    	//Todolist for examining nodes, Once added they are not removed so Vector here is better than stack
    	Vector<Node<E>> toDoList = new Vector<Node<E>>(10);
    	
    	//Add start to toDoList
    	toDoList.addLast(startState);
    	startState.bFordDistance = 0;
    	
    	//Run the algorithm as many times as there are nodes
    	for(int k = 0; k < nodes.size(); k++) {
    		
    		//For checking whether any nodes were updated on this loop
    		boolean updated = false;
    		
    		//Iterate over all nodes ecountered so far
    		for(int i = 0; i < toDoList.size(); i++) {
    		
    			Node<E> current = toDoList.get(i);
    		
    			//Iterate over all edges on current node
    			for(int j = 0; j < current.edges.size(); j++) {
    			
    				Edge<E> edge = current.edges.get(j);
    				Node<E> to = edge.toNode;
    			
    				//Adding encountered nodes to toDoList
    				if (to.visited == false) {
    					toDoList.addLast(to);
    					to.visited = true;
    				}
    			
    				//Calculate the Bellman-Ford distance from the source node to the node to the end node
    				int calculatedBFordDistance = edge.weight + current.bFordDistance;
    			
    				//If calculated Bellman-Ford distance is less than currently then update the value, update bFordPi to current node
    				if(calculatedBFordDistance < to.bFordDistance) {
    					to.bFordDistance = calculatedBFordDistance;
    					to.bFordPi = current;
    					updated = true;
    				}
    			}
    		}
    		//If there were no updates on this iteration then no further iterations needed, break out of loop
    		if(!updated) {
    			break;
    		}
    	}
    	
    	//Constructing path in reverse starting from endState
    	Node<E> pathNode = endState;
    	
    	//Following path backwards through bFordPi values to find the path
    	while(pathNode != null) {
    		path.addFirst(pathNode.getLabel());//Adding at beginning of path so that path is in right order when returned
    		pathNode = pathNode.bFordPi;
    	}
    	
    	if(path.size() == 1) { //If only one element in path then no path found, return empty list
    		return new LinkedList<E>();
    	}
    	
		return path;
    }
}