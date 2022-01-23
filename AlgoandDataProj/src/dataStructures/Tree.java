package dataStructures;

/**
 * 
 * @author George Paul
 *
 * @param <E> data type o be held in the tree
 */
public class Tree<E extends Comparable<E>> {
	
	/**
	 * Class to represent each node in the tree
	 *
	 * @param <P> data type to be held in the tree node
	 */
	public class TreeNode<P extends Comparable<P>> implements Comparable<TreeNode<P>>{
		/**
		 * Data to be stored in the tree node
		 */
		private P value;
		
		/**
		 * Pointer to the node to the left
		 */
		private TreeNode<P> leftNode;
		
		/**
		 * Pointer to the node to thr right
		 */
		private TreeNode<P> rightNode;
		
		/**
		 * Constructor method
		 * @param v Data to be held in the node
		 */
		public TreeNode(P v){
			value = v;
			leftNode = null;
			rightNode = null;
		}
	  
		/**
		 * Constructor method
		 * @param v Data to be held in the node
		 * @param left TreeNode to the left
		 * @param right TreeNode to the right
		 */
		public TreeNode(P v, TreeNode<P> left, TreeNode<P> right){
			value = v;
			leftNode = left;
			rightNode = right;
		}
		
		/**
		 * Method to return left tree node
		 * @return leftNode the left tree node
		 */
		public TreeNode<P> getLeftTree(){
			return leftNode;
		}
	 
		/**
		 * Method to return right tree node
		 * @return rightNode the right tree node
		 */
		public TreeNode<P> getRightTree(){
			return rightNode;
		}
	 
	 
		/**
		 * Method to return the data held in tree node
		 * @return value the data held in the node
		 */
		public P getValue(){
			return value;
		}
		
		/**
		 * Method to set the value in the tree node
		 * @param value new value of the node
		 */
		public void setValue(P value){
			this.value = value;
		}

		/**
		 * Compare to method
		 * @param arg0 node to be compared to current node
		 */
		@Override
		public int compareTo(TreeNode<P> arg0) {
			P val = arg0.value;
			return value.compareTo(val);
		}
	}
	// start of the actual tree class
	// the root of our tree
	
	/**
	 * Pointer to the root of the tree
	 */
	private TreeNode<E> root;
	
	/**
	 * Variable for storing the string in the toString method
	 */
	private String s = "";
	
	/**
	 * Variable for keeping track of the size of the tree
	 */
	private int count;
	
	/**
	 * Constructor method
	 */
	public Tree(){
		root = null;
	}
	
	/**
	 * Method to traverse the whole tree and perform action specified by the tree action
	 * @param action Tree action to perform to each node
	 */
	public void traverse(TreeAction<E> action){ //O(n)
		Stack<TreeNode<E>> t = new Stack<TreeNode<E>>();
		t.push(root);
		
		while(!t.isEmpty()) { //While stack is not empty push child nodes to stack
		
			TreeNode<E> n = t.pop(); 
			action.run(n); //Run action on popped node
			 
			if(n.getLeftTree() != null) {
				t.push(n.getLeftTree());
			}
			if(n.getRightTree() != null) {
				t.push(n.getRightTree());
			}
		}
	}
	
	/**
	 * Method to return number of nodes in the tree
	 * @return count number of nodes in tree
	 */
	public int size() {
		return count;
	}
	
	/**
	 * Method to insert a treenode
	 * @param element data to insert in the node
	 */
	public void insert(E element){ //O(logn)
		insertAtNode(element,root,null);
	}
	
	
	
	/**
	 * Method called by insert to insert the treenode
	 * @param element data to insert in the node
	 * @param current node from which to examine the children nodes
	 * @param parent pointer back to the parent node
	 */
	private void insertAtNode(E element,TreeNode<E> current,TreeNode<E> parent){ //O(logn)
		// we traverse the tree.
		// Current holds the pointer to the TreeNode we are currently checking
		// Parent holds the pointer to the parent of the current TreeNode
		// if the node we check is empty
		
		if(current == null){
			TreeNode<E> newNode = new TreeNode<E>(element);
			// the current node is empty, but we have a parent
			if(parent != null){
				// do we add it to the left?
				if(element.compareTo(parent.value) < 0){
					parent.leftNode = newNode;
					count++;
				}
				// or do we add it to the right?
				else{
					parent.rightNode = newNode;
					count++;
				}
			}
			// the current node is empty and it has no parent, we actually have an empty tree
			else {
				root = newNode;
				count++;
			}
		}
		else if(element.compareTo(current.value) == 0){
			// if the element is already in the tree do nothing
		}
		// if the element is smaller than current, go left
		else if(element.compareTo(current.value) < 0){
			insertAtNode(element,current.getLeftTree(),current);
		}
		// if the element is bigger than current, go right
		else insertAtNode(element,current.getRightTree(),current);
	}
	
	/**
	 *toString method
	 *@return string representation of the tree
	 */
	public String toString() { //O(n)
		traverse(new TreeAction<E>() {	
			public void run(Tree<E>.TreeNode<E> n) {	
				s += n.getValue() + "\n";	
			}
		});
		return s ;
	}

	
	/**
	 * Method called by find to return nodes searched for in the tree, calls itself recursively to search lower branches
	 * @param element element to search for
	 * @param current current node being examined
	 * @return null if node not found, the nodes data if the node is found
	 */
	private E findNode (E element ,TreeNode<E> current) { //O(logn)
		if (current == null) { //If node not found
			return null;
		}
		else if (element.compareTo(current.value) == 0) { //If node found
			return (E)current.value; 
		}
		else if (element.compareTo(current.value) < 0) { //If element is smaller than current search left tree
			return findNode (element, current.getLeftTree( )) ;
		}
		else {
			return findNode(element, current.getRightTree()) ; //If element is smaller than current search right tree
		}
	}
	
	/**
	 * Method to search for nodes in a tree, calls findNode
	 * @param element value of the node to search for
	 * @return the found value
	 */
	public E find (E element) {
		return findNode (element, root) ;
	}

	
}


