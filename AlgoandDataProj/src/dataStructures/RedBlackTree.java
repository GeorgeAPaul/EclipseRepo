package dataStructures;

import dataStructures.Tree.TreeNode;

public class RedBlackTree<E extends Comparable<E>> {
	
	public enum TreeNodeColor {
		Red, Black
	}

	protected class ColouredTreeNode<P extends Comparable<P>> implements Comparable<ColouredTreeNode<P>> {
		protected TreeNodeColor color;
		protected P value;
		protected ColouredTreeNode<P> leftNode;
		protected ColouredTreeNode<P> rightNode;
		protected ColouredTreeNode<P> parentNode;

		public ColouredTreeNode(P value, TreeNodeColor color) {
			this.value = value;
			this.color = color;
		}

		public String toString() {
			if (value == null)
				return "nil : " + color;
			else
				return value.toString() + " : " + color;
		}

		public int compareTo(ColouredTreeNode<P> arg0) {
			ColouredTreeNode<P> node2 = arg0;
			return value.compareTo(node2.value);
		}
		
		public ColouredTreeNode<P> getLeftTree(){
			return this.leftNode;
		}
		
		public ColouredTreeNode<P> getRightTree(){
			return this.rightNode;
		}
	}

	protected ColouredTreeNode root;
	protected ColouredTreeNode nilNode;

	public RedBlackTree() {
		nilNode = new ColouredTreeNode(null, TreeNodeColor.Black);
		root = nilNode;
	}

	private void rotateLeft(ColouredTreeNode x) {
		ColouredTreeNode y = x.rightNode;
		x.rightNode = y.leftNode;
		if (y.leftNode != nilNode)
			y.leftNode.parentNode = x;
		y.parentNode = x.parentNode;
		if (x.parentNode == nilNode)
			root = y;
		else if (x == x.parentNode.leftNode)
			x.parentNode.leftNode = y;
		else
			x.parentNode.rightNode = y;
		y.leftNode = x;
		x.parentNode = y;
	}

	private void rotateRight(ColouredTreeNode y) {
		ColouredTreeNode x = y.leftNode;
		y.leftNode = x.rightNode;
		if (x.rightNode != nilNode)
			x.rightNode.parentNode = y;
		x.parentNode = y.parentNode;
		if (y.parentNode == nilNode)
			root = x;
		else if (y == y.parentNode.rightNode)
			y.parentNode.rightNode = x;
		else
			y.parentNode.leftNode = x;
		x.rightNode = y;
		y.parentNode = x;
	}

	public void rbInsert(E element) {
		ColouredTreeNode z = new ColouredTreeNode(element, TreeNodeColor.Red);
		ColouredTreeNode y = nilNode;
		ColouredTreeNode x = root;
		while (!(x == nilNode)) {
			y = x;
			if (z.compareTo(x) < 0)
				x = x.leftNode;
			else
				x = x.rightNode;
		}
		z.parentNode = y;
		if (y == nilNode)
			root = z;
		else if (z.compareTo(y) < 0)
			y.leftNode = z;
		else
			y.rightNode = z;
		z.leftNode = nilNode;
		z.rightNode = nilNode;
		fixUpInsert(z);
	}

	private void fixUpInsert(ColouredTreeNode z) {
		while ((z.parentNode != null) && (z.parentNode.parentNode != null)
				&& z.parentNode.color == TreeNodeColor.Red) {
			if (z.parentNode == z.parentNode.parentNode.leftNode) {
				ColouredTreeNode y = z.parentNode.parentNode.rightNode;
				if (y.color == TreeNodeColor.Red) {
					z.parentNode.color = TreeNodeColor.Black;
					y.color = TreeNodeColor.Black;
					z.parentNode.parentNode.color = TreeNodeColor.Red;
					z = z.parentNode.parentNode;
				} else {
					if (z == z.parentNode.rightNode) {
						z = z.parentNode;
						rotateLeft(z);
					}
					z.parentNode.color = TreeNodeColor.Black;
					z.parentNode.parentNode.color = TreeNodeColor.Red;
					rotateRight(z.parentNode.parentNode);
				}
			} else {
				ColouredTreeNode y = z.parentNode.parentNode.leftNode;
				if (y.color == TreeNodeColor.Red) {
					z.parentNode.color = TreeNodeColor.Black;
					y.color = TreeNodeColor.Black;
					z.parentNode.parentNode.color = TreeNodeColor.Red;
					z = z.parentNode.parentNode;
				} else {
					if (z == z.parentNode.leftNode) {
						z = z.parentNode;
						rotateRight(z);
					}
					z.parentNode.color = TreeNodeColor.Black;
					z.parentNode.parentNode.color = TreeNodeColor.Red;
					rotateLeft(z.parentNode.parentNode);
				}
			}
		}
		if (z == root)
			root.color = TreeNodeColor.Black;
	}

	public void recPrint() {
		Queue t = new Queue();
		// Stack t = new Stack();
		t.push(root);
		while (!t.isEmpty()) {
			ColouredTreeNode n = (ColouredTreeNode) t.pop();
			System.out.println(n);

			if (n.leftNode != nilNode)
				t.push(n.leftNode);
			if (n.rightNode != nilNode)
				t.push(n.rightNode);

		}
	}
	
	private E findNode (E element, ColouredTreeNode<E> current) {
		if (current == null) return null;
		else if (element.compareTo(current.value) == 0)
			return (E)current.value;
		else if (element.compareTo(current.value) < 0) {
			return findNode (element, current.getLeftTree( )) ;
		}
		else return findNode(element, current.getRightTree()) ;
	}
	
//	public E find (E element) {
//		return findNode(element, root);
//	}

}
