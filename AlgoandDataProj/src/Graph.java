public class Graph<E extends Comparable<E>>
{
    public class Node<P extends Comparable<P>> implements Comparable<Node<P>>
    {
        private P info;
        private Vector edges;
        
        public Node(P label)
        {
            info = label;
            edges = new Vector<P>(10);
        }
        
        public void addEdge(Edge e)
        {
            edges.addLast(e);
        }
        
        public int compareTo(Node<P> o)
        {
            // two nodes are equal if they have the same label
            Node n = (Node)o;
            return n.info.compareTo(info);
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
    
    private Vector nodes;
    
    public Graph()
    {
        nodes = new Vector<E>(10);
    }
    
    public void addNode(Comparable label)
    {
        nodes.addLast(new Node(label));
    }
    
    private Node findNode(Comparable nodeLabel)
    {
        Node res = null;
        for (int i=0; i<nodes.size(); i++)
        {
            Node n = (Node)nodes.get(i);
            if(n.getLabel() == nodeLabel)
            {
                res = n;
                break;
            }
        }
        return res;
    }
    
    public void addEdge(Comparable nodeLabel1,
                        Comparable nodeLabel2)
    {
        Node n1 = findNode(nodeLabel1);
        Node n2 = findNode(nodeLabel2);
        n1.addEdge(new Edge(n2));
    }
}