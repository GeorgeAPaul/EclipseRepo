package dataStructures;

/**
 * 
 * @author George Paul
 *
 * @param <E> Data type tree action which tree action acts on
 */
public abstract class TreeAction<E extends Comparable<E>>
{
	/**
	 * Run method to be performed on tree node, is overridden when tree action is instantiated as an anoymous class
	 * @param n Tree node to be actioned on
	 */
	public abstract void run(Tree<E>.TreeNode<E> n);
}
