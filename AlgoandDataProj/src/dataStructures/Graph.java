package dataStructures;
public class Graph<E extends Comparable<E>>
{
    public class Node<P extends Comparable<P>> implements Comparable<Node<P>>
    {
        private P info;
        private Vector<Edge<P>> edges;
        
        public Node(P label)
        {
            info = label;
            edges = new Vector<Edge<P>>(10);
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
        
        public Vector<Edge<P>> getEdges()
        {
            return edges;
        }
        
        public P getLabel()
        {
            return info;
        }
        
    }
    
    private class Edge<P extends Comparable<P>> implements Comparable<Edge<P>>
    {
        private Node<P> toNode;
        
        public Edge(Node<P> to)
        {
            toNode = to;
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
        
    }
    
    private Vector<Node<E>> nodes;
    
    public Graph()
    {
        nodes = new Vector<Node<E>>(10);
    }
    
    public void addNode(E label)
    {
        nodes.addLast(new Node<E>(label));
    }
    
    private Node<E> findNode(E nodeLabel)
    {
        Node<E> res = null;
        for (int i=0; i<nodes.size(); i++)
        {
            Node<E> n = (Node<E>)nodes.get(i);
            if(n.getLabel() == nodeLabel)
            {
                res = n;
                break;
            }
        }
        return res;
    }
    
    public void addEdge(E nodeLabel1,
                        E nodeLabel2)
    {
        Node<E> n1 = findNode(nodeLabel1);
        Node<E> n2 = findNode(nodeLabel2);
        n1.addEdge(new Edge<E>(n2));
    }
    
    public String toString() {
    	
    	String s = "";
    	
    	for(int i = 0; i < nodes.size(); i++) {
    		
    		Node<E> node = nodes.get(i);
    		Vector<Edge<E>> edges = node.getEdges();
    		
    		s += "Node: " + node.getLabel() + ", Edges: ";
    		
    		for(int j = 0; j < edges.size(); j++) {
    			s += edges.get(j) + ",";
    		}
    	}
    	
    	return s;
    }
}