package dataStructures;

/**
 * 
 * @author George Paul
 *
 * @param <E> datatype to be stored in the stack
 */
public class Stack<E extends Comparable<E>> {
	
	/**
	 * Storing data in a Vector
	 */
	private Vector<E> data;
	
	/**
	 * Constructor method
	 */
	public Stack() {
		data = new Vector<E>(10);
	}
	
	/**
	 * Method to add data to stack
	 * @param o data to be added
	 */
	public void push(E o) {
		data.addLast(o);
	}	
	
	/**
	 * Method to remove and return top element from the stack
	 * @return element top of stack
	 */
	public E pop() {
		E tmp = data.getLast();
		data.removeLast();
		return tmp;
	}
	
	/**
	 * Method to return top of stack without removing
	 * @return element to be returned
	 */
	public E top() {
		return data.getLast();
	}
	
	/**
	 * Method to return number of objects in stack
	 * @return number of objects in stack
	 */
	public int size() {
		return data.size();
	}
	/**
	 * Method to determine if Stack is empty.
	 * @return True if there are no objects stored in the Vector, else False.
	 */
	public boolean isEmpty()
	{
		return data.isEmpty();
	}

//Method for testing but a bit ridiculous to use since every element has to be removed then added back again
//	public String toString()
//	{
//		if(isEmpty()) {
//			return "[]";
//		}
//		
//		Stack<E> tmp = new Stack<E>();
//		String s = "[";
//		while(!isEmpty()){
//			s += top() + ",";
//			tmp.push(pop());
//		}
//		
//		while(!tmp.isEmpty()) {
//			push(tmp.pop());
//		}
//		return s.substring(0, s.length() - 1) + "]";
//	}
}