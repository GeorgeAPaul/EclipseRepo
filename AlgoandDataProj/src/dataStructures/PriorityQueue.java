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
		 * @param element Data stored in the pair
		 * @param priority Priority to be removed from the queue
		 */
		public PriorityPair(E element, T priority) {
			this.element = element;
			this.priority = priority;
		}
		
		/**
		 * Method to return the data
		 * @return element the data in the pair
		 */
		public E getElement() {
			return element;
		}
		
		/**
		 * Method to compare two priority pairs
		 * @param o pair to compare to
		 */
		@Override
		public int compareTo(PriorityPair<P,U> o) {
			return priority.compareTo(o.priority);
		}
		
	}
	
	/**
	 * Linked list to hold the pairs in
	 */
	private LinkedList<PriorityPair<E,T>> data;
	
	/**
	 * Constructor method
	 */
	public PriorityQueue(){
		data = new LinkedList<PriorityPair<E,T>>();
	}
	
	/**
	 * Method to push data onto the queue
	 * @param o data to push
	 * @param priority priority of new data
	 */
	public void push(E o, T priority){
		// make a pair of o and priority
		// add this pair to the sorted linked list.
		PriorityPair<E,T> pp = new PriorityPair<E,T>(o, priority);
		data.addSorted(pp); //Add sorted by priority so that highest priority is popped first
		
	}
	
	/**
	 * Method to return highest priority element from queue
	 * @return tmp element to be popped
	 */
	public E pop(){
		E tmp = data.getFirst().getElement();
		data.removeFirst();
		return tmp;
	}
	
	/**
	 * Method to return highest priority element from queue without removing
	 * @return highest priority element from queue
	 */
	public E top(){
		return data.getFirst().getElement();
	}
	
	/**
	 * Method to check whether queue is empty
	 * @return true if queue is empty else false
	 */
	public boolean isEmpty(){
		return data.isEmpty();
	}
	
	
//	To string method for testing but cannot be used in production since priority queue is not returned to original state 
//	public String toString(){
//		if(isEmpty()) {
//			return "[]";
//		}
//		
//		PriorityQueue<E,T> tmp = new PriorityQueue<E,T>();
//		String s = "[";
//		T sloo = null;
//		while(!isEmpty()){
//			s += top() + ",";
//			tmp.push(pop(),sloo);
//		}
//		
//		while(!tmp.isEmpty()) {
//			push(tmp.pop(),sloo);
//		}
//		return s.substring(0, s.length() - 1) + "]";
//	}
}
