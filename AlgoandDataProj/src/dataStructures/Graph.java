package dataStructures;
public class Graph<E extends Comparable<E>, W extends Comparable<W>>
{
    public class Node<P extends Comparable<P>, T extends Comparable<T>> implements Comparable<Node<P,T>>
    {
        private P info;
        private Vector<Edge<P,T>> edges;
        private boolean visited;
        
        public Node(P label)
        {
            info = label;
            edges = new Vector<Edge<P,T>>(1);
            visited = false;
        }
        
        public void addEdge(Edge<P,T> e)
        {
            edges.addLast(e);
        }
        
        public int compareTo(Node<P,T> o)
        {
            // two nodes are equal if they have the same label
            Node<P,T> n = (Node<P,T>)o;
            return n.info.compareTo(info);
        }
        
//        public Vector<Edge<P,T>> getEdges()
//        {
//            return edges;
//        }
        
        public String toString() {
        	return info.toString();
        }
        
        public P getLabel()
        {
            return info;
        }
        
    }
    
    private class Edge<P extends Comparable<P>, T extends Comparable<T>> implements Comparable<Edge<P,T>>
    {
        private Node<P,T> toNode;
        private T weight;
        
        public Edge(Node<P,T> to, T w)
        {
            toNode = to;
            weight = w;
        }
        
        public int compareTo(Edge<P,T> o)
        {
            // two edges are equal if they point
            // to the same node.
            // this assumes that the edges are
            // starting from the same node !!!
            Edge<P,T> n = o;
            return n.toNode.compareTo(toNode);
        }
        
//        public Node<P,T> getToNode() {
//        	return toNode;
//        }
//        
//        public T getWeight() {
//        	return weight;
//        }
        
        public String toString() {
        	return "(" + toNode.getLabel() + " " + weight + ")";
        }
        
    }
    
    private Vector<Node<E,W>> nodes;
    
    public Graph()
    {
        nodes = new Vector<Node<E,W>>(10);
    }
    
    public void addNode(E label)
    {
        nodes.addSorted(new Node<E,W>(label));
    }
    
    private Node<E,W> findNode(E nodeLabel)
    {
        return nodes.binarySearch(new Node<E,W>((nodeLabel)));
    }
    
    public void addEdge(E nodeLabel1,
                        E nodeLabel2,
                        W weight)
    {
        Node<E,W> n1 = findNode(nodeLabel1);
        Node<E,W> n2 = findNode(nodeLabel2);
//        System.out.println(n1);
//        System.out.println(n2);
        n1.addEdge(new Edge<E,W>(n2, weight));
    }
    
    public String toString() {
    	
    	String s = "";
    	
    	for(int i = 0; i < nodes.size(); i++) {
    		
    		Node<E,W> node = nodes.get(i);
    		
    		s += "Node: " + node + " Edges: ";
    		
    		for(int j = 0; j < node.edges.size(); j++) {
    			s += node.edges.get(j) + ", ";
    		}
    		//s = s.substring(0,s.length() - 0);
    		s += "\n";
    	}
    	
    	return s;
    }
    
    public Vector<Node<E,W>> findPath (E nodeLabel1 , E nodeLabel2) {
    	
    	Node<E,W> startState = findNode(nodeLabel1);
    	Node<E,W> endState = findNode(nodeLabel2);
    	
    	Vector<Node<E,W>> path = new Vector<Node<E,W>>(10);
    	
    	startState.visited = true;
    	Stack<Node<E,W>> toDoList = new Stack<Node<E,W>>();
    	
    	int distanceFromDivergence = 0;
    	
    	toDoList.push(startState);
    	
    	while (!toDoList.isEmpty()){
    		
    		Node<E,W> current = toDoList.pop();
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
    			
    			//System.out.println(current + " " + distanceFromDivergence);
    			
    			for(int i = 0; i < current.edges.size(); i++) {
    				Edge<E,W> e = current.edges.get(i);
    				
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
    	return new Vector<Node<E,W>>(10);
    }
}