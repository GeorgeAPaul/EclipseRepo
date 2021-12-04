public class StackLL<E extends Comparable<E>>{
	
	private LinkedList<E> dataLL;
	
	public StackLL() {
		dataLL = new LinkedList<E>();
	}
	
	public void push(E o) {
		dataLL.addFirst(o);
	}
	public E pop() {
		Object tmp = dataLL.getFirst();
		dataLL.removeFirst();
		return (E)tmp;
	}
	public E top() {
		return (E)dataLL.getFirst();
	}
	public int size() {
		return dataLL.size();
	}
	/**
	 * Method to determine if Vector is empty.
	 * @return True if there are no objects stored in the Vector, else False.
	 */
	public boolean isEmpty()
	{
		return dataLL.isEmpty();
	}
	
	public String toString()
	{
		if(isEmpty()) {
			return "[]";
		}
		
		StackLL<E> tmp = new StackLL<E>();
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