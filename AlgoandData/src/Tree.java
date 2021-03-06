public class Tree<E extends Comparable<?>> {
	/*
	private class NaturalComparator implements Comparator
	{
		public int compare(Object a, Object b)
		{
			return ((Comparable)a).compareTo(b);
		}
	}
	*/
	// the class for implementing a node in the tree.
	// contains a value, a pointer to the left child and a pointer to the right child
	
	public class TreeNode<P extends Comparable<P>> implements Comparable<P>
	{
		private P value;
		private TreeNode<P> leftNode;
		private TreeNode<P> rightNode;
		public TreeNode(P v)
		{
			value = v;
			leftNode = null;
			rightNode = null;
		}
	  
		public TreeNode(P v, TreeNode<P> left, TreeNode<P> right)
		{
			value = v;
			leftNode = left;
			rightNode = right;
		}
		public TreeNode<P> getLeftTree()
		{
			return leftNode;
		}
	 
		public TreeNode<P> getRightTree()
		{
			return rightNode;
		}
	 
	 
		public P getValue()
		{
			return value;
		}
		
		public void setValue(P value)
		{
			this.value = value;
		}

		@Override
		public int compareTo(P arg0) {
			return value.compareTo(arg0);
		}
		
		public String toString() {
			return value.toString();
		}
	 

	}
	// start of the actual tree class
	
	// the root of our tree
	protected TreeNode root;
	private String s = "";
	
	public Tree()
	{
		root = null;
	}
	
	
	public void traverse(TreeAction action)
	{
		Queue<TreeNode> t = new Queue<TreeNode>();
		//Stack t = new Stack();
		t.push(root);
		while(!t.isEmpty())
		{
			TreeNode n = (TreeNode)t.pop();
			action.run(n);
			 
			if(n.getLeftTree() != null) t.push(n.getLeftTree());
			if(n.getRightTree() != null) t.push(n.getRightTree());
		}
	}
	
	public void traverseNode(TreeNode n,TreeAction action)
	{
		if(n != null)
		{
			if(n.getLeftTree() != null) traverseNode(n.getLeftTree(),action); 
			action.run(n);
			if(n.getRightTree() != null) traverseNode(n.getRightTree(),action);
		}
	}
	
	public void traverseInOrder(TreeAction action)
	{
		traverseNode(root,action);
	} 
	
	public void insert(Comparable element)
	{
		insertAtNode(element,root,null);
	}	
	
	// we traverse the tree.
	// Current holds the pointer to the TreeNode we are currently checking
	// Parent holds the pointer to the parent of the current TreeNode
	private void insertAtNode(Comparable element,TreeNode current,TreeNode parent)
	{
		// if the node we check is empty
		if(current == null)
		{
			TreeNode newNode = new TreeNode(element);
			// the current node is empty, but we have a parent
			if(parent != null)
			{
				// do we add it to the left?
				if(element.compareTo(parent.value) < 0)
				{
					parent.leftNode = newNode;
				}
				// or do we add it to the right?
				else
				{
					parent.rightNode = newNode;
				}
			}
			// the current node is empty and it has no parent, we actually have an empty tree
			else root = newNode;
		}
		else if(element.compareTo(current.value) == 0)
		{
			// if the element is already in the tree, what to do?
		}
		// if the element is smaller than current, go left
		else if(element.compareTo(current.value) < 0)
		{
			insertAtNode(element,current.getLeftTree(),current);
		}
		// if the element is bigger than current, go right
		else insertAtNode(element,current.getRightTree(),current);
	}
	
//	public int findDepth() {
//		int depth = 0;
//		
//		return depth;
//	}
	
//	public String toString ()
//	{
//		String s = "";
//		Queue<TreeNode> t = new Queue<TreeNode>();
//		t.push(root);
//		while (!t.isEmpty())
//		{
//			TreeNode n = (TreeNode)t.pop();
//			s += n;
//			if(n.getRightTree() != null)
//				t.push(n.getRightTree());
//			if(n.getLeftTree () != null)
//				t.push(n.getLeftTree());
//			s += "\n";
//		}
//		return s ;
//	}
	
	public String toString() {
		traverse(new TreeAction() {	
			public void run(Tree.TreeNode n) {	
				s += n.toString() + "\n";	
			}
		});
		return s ;
	}
	
	private E findNode (Comparable element ,TreeNode current) {
		if (current == null) return null;
		else if (element.compareTo(current.value) == 0)
			return (E)current.value;
		else if (element.compareTo(current.value) < 0) {
			return findNode (element, current.getLeftTree( )) ;
		}
		else return findNode(element, current.getRightTree()) ;
	}
	
	public E find (Comparable element) {
		return findNode (element, root) ;
	}

	
}


