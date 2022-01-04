package dataStructures;
public class Graph<E extends Comparable<E>>
{
    public class Node<P extends Comparable<P>> implements Comparable<Node<P>>
    {
        private P info;
        private Vector<Edge<P>> edges;
        private boolean visited;
        private int bFordDistance;
        private Node<P> bFordPi;
        
        public Node(P label)
        {
            info = label;
            edges = new Vector<Edge<P>>(1);
            visited = false;
            bFordDistance = Integer.MAX_VALUE;
        }
        
        public void addEdge(Edge<P> e)
        {
            edges.addLast(e);
        }
        
        public int compareTo(Node<P> o)
        {
            // two nodes are equal if they have the same label
            Node<P> n = (Node<P>)o;
            return n.info.compareTo(info);
        }
        
//        public Vector<Edge<P,T>> getEdges()
//        {
//            return edges;
//        }
        
        public String toString() {
        	return info.toString() + " " + edges;
        }
        
        public P getLabel()
        {
            return info;
        }
        
    }
    
    private class Edge<P extends Comparable<P>> implements Comparable<Edge<P>>
    {
        private Node<P> toNode;
        private int weight;
        
        public Edge(Node<P> to, int w)
        {
            toNode = to;
            weight = w;
        }
        
        public int compareTo(Edge<P> o)
        {
            // two edges are equal if they point
            // to the same node.
            // this assumes that the edges are
            // starting from the same node !!!
            Edge<P> n = o;
            return n.toNode.compareTo(toNode);
        }
        
        public String toString() {
        	return "(" + toNode.getLabel() + " " + weight + ")";
        }
        
    }
    
    private Tree<Node<E>> nodes;
    
    public Graph()
    {
        nodes = new Tree<Node<E>>();
    }
    
    public void addNode(E label)
    {
        nodes.insert(new Node<E>(label));
    }
    
    private Node<E> findNode(E nodeLabel)
    {
        return nodes.find(new Node<E>((nodeLabel)));
    }
    
    public void addEdge(E nodeLabel1,
                        E nodeLabel2,
                        int weight)
    {
        Node<E> n1 = findNode(nodeLabel1);
        Node<E> n2 = findNode(nodeLabel2);
        n1.addEdge(new Edge<E>(n2, weight));
    }
    
    public String toString() {
    	
//    	String s = "";
//    	
//    	for(int i = 0; i < nodes.size(); i++) {
//    		
//    		Node<E,W> node = nodes.get(i);
//    		
//    		s += "Node: " + node + " Edges: ";
//    		
//    		for(int j = 0; j < node.edges.size(); j++) {
//    			s += node.edges.get(j) + ", ";
//    		}
//    		//s = s.substring(0,s.length() - 0);
//    		s += "\n";
//    	}
    	
    	return nodes.toString();
    }
    
    public Vector<Node<E>> findPath (E nodeLabel1 , E nodeLabel2) {
    	
    	Node<E> startState = findNode(nodeLabel1);
    	Node<E> endState = findNode(nodeLabel2);
    	
    	nodes.traverse(new TreeAction<Node<E>>() {	
			@Override
			public void run(Tree<Graph<E>.Node<E>>.TreeNode<Graph<E>.Node<E>> n) {
				Node<E> node = n.getValue();
				node.visited = false; 
				
			}
		});
    	
    	Vector<Node<E>> path = new Vector<Node<E>>(10);
    	
    	startState.visited = true;
    	Stack<Node<E>> toDoList = new Stack<Node<E>>();
    	
    	int distanceFromDivergence = 0;
    	
    	toDoList.push(startState);
    	
    	while (!toDoList.isEmpty()){
    		
    		Node<E> current = toDoList.pop();
    		path.addLast(current);
    		
    		if(current == endState) {
    			return path;
    		}
    		
    		else {
    			
    			if(current.edges.size() > 1) {
    				distanceFromDivergence = 0;
    			}
    			else {
    				distanceFromDivergence++;
    			}
    			
    			for(int i = 0; i < current.edges.size(); i++) {
    				Edge<E> e = current.edges.get(i);
    				
    				if(e.toNode.visited == false) {
    					toDoList.push(e.toNode);
    					e.toNode.visited = true;
    				}
    			}
    			
    			if(current.edges.size() == 0) {
    				for(int i = 0; i < distanceFromDivergence; i++) {
        				path.removeLast();
        			}
    				distanceFromDivergence = 0;
    			}
    		}
    	}
    	return new Vector<Node<E>>(10);
    }
    
    public LinkedList<Node<E>> findShortestPath(E nodeLabel1 , E nodeLabel2) {
    	
    	Node<E> startState = findNode(nodeLabel1);
    	Node<E> endState = findNode(nodeLabel2);
    	
    	nodes.traverse(new TreeAction<Node<E>>() {	
			@Override
			public void run(Tree<Graph<E>.Node<E>>.TreeNode<Graph<E>.Node<E>> n) {
				Node<E> node = n.getValue();
				node.visited = false; 
				
			}
		});
    	
    	
    	Vector<Node<E>> toDoList = new Vector<Node<E>>(10);
    	
    	LinkedList<Node<E>> path = new LinkedList<Node<E>>();
    		
    	toDoList.addLast(startState);
    	startState.bFordDistance = 0;
    	
    	for(int k = 0; k < nodes.size(); k++) {
    		
    		boolean updated = false;
    		
    		for(int i = 0; i < toDoList.size(); i++) {
    		
    			Node<E> current = toDoList.get(i);
    		
    			for(int j = 0; j < current.edges.size(); j++) {
    			
    				Edge<E> edge = current.edges.get(j);
    				Node<E> to = edge.toNode;
    			
    				if (to.visited == false) {
    					toDoList.addLast(to);
    					to.visited = true;
    				}
    			
    				int calculatedBFordDistance = edge.weight + current.bFordDistance;
    			
    				if(calculatedBFordDistance < to.bFordDistance) {
    					to.bFordDistance = calculatedBFordDistance;
    					to.bFordPi = current;
    					updated = true;
    				}
    			}
//    			System.out.println(i);
//    			System.out.println(current.edges.size());
//    			System.out.println(current + " " + current.bFordDistance);
//    			System.out.println(toDoList);
    		}
    		if(!updated) {
    			break;
    		}
    	}
    	
    	Node<E> pathNode = endState;
    	
    	while(pathNode != null) {
    		path.addFirst(pathNode);
    		pathNode = pathNode.bFordPi;
    	}
    	
		return path;
    }
}