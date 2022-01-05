package dataStructures;

/**
 * 
 * @author George Paul
 *
 * @param <E> Data type of the stored data
 * @param <T> Data type of the priority
 */
public class PriorityQueue<E, T extends Comparable<T>> 
{       
	/**
	 * Class to store data with their priorities
	 * @param <P> Data type of the stored data
	 * @param <U> Data type of the priority
	 */
	private class PriorityPair<P, U extends Comparable<U>> implements Comparable<PriorityPair<P,U>> {
		
		/**
		 * Stored data
		 */
		private E element;
		
		/**
		 * Priority to be removed from the queue
		 */
		private T priority;
		
		/**
		 * Constructor method
		 * @param element
		 * @param priority
		 */
		public PriorityPair(E element, T priority) {
			this.element = element;
			this.priority = priority;
		}
		
		public E getElement() {
			return (E)element;
		}
		@Override
		public int compareTo(PriorityPair<P,U> o) {
			return priority.compareTo(o.priority);
		}
		
	}
	
	private LinkedList<PriorityPair<E,T>> data;
	
	public PriorityQueue()
	{
		data = new LinkedList<PriorityPair<E,T>>();
	}
	public void push(E o, T priority)
	{
		// make a pair of o and priority
		// add this pair to the sorted linked list.
		PriorityPair<E,T> pp = new PriorityPair<E,T>(o, priority);
		data.addSorted(pp);
		
	}
	public E pop()
	{
		E tmp = data.getFirst().getElement();
		data.removeFirst();
		return tmp;
	}
	public E top()
	{
		return data.getFirst().getElement();
	}
	
	public boolean isEmpty()
	{
		return data.isEmpty();
	}
	
	public String toString()
	{
		if(isEmpty()) {
			return "[]";
		}
		
		PriorityQueue<E,T> tmp = new PriorityQueue<E,T>();
		String s = "[";
		T sloo = null;
		while(!isEmpty()){
			s += top() + ",";
			tmp.push(pop(),sloo);
		}
		
		while(!tmp.isEmpty()) {
			push(tmp.pop(),sloo);
		}
		return s.substring(0, s.length() - 1) + "]";
	}
}
