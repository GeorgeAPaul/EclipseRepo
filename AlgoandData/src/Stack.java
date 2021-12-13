public class Stack<E> {
	
	private Vector<E> data;
	
	public Stack() {
		data = new Vector<E>(10);
	}
	
	public void push(E o) {
		data.addLast(o);
	}	
	public E pop() {
		Object tmp = data.getLast();
		data.removeLast();
		return (E)tmp;
	}
	public E top() {
		return (E)data.getLast();
	}
	public int size() {
		return data.size();
	}
	/**
	 * Method to determine if Vector is empty.
	 * @return True if there are no objects stored in the Vector, else False.
	 */
	public boolean isEmpty()
	{
		return data.isEmpty();
	}
	
	public String toString()
	{
		if(isEmpty()) {
			return "[]";
		}
		
		Stack<E> tmp = new Stack<E>();
		String s = "[";
		while(!isEmpty()){
			s += top() + ",";
			tmp.push(pop());
		}
		
		while(!tmp.isEmpty()) {
			push(tmp.pop());
		}
		return s.substring(0, s.length() - 1) + "]";
	}
}