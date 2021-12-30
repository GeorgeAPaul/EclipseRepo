package dataStructures;

public class PriorityQueue<E, T extends Comparable<T>> 
{       
	private class PriorityPair<P, U extends Comparable<U>> implements Comparable<PriorityPair<P,U>> {
		
		private E element;
		private T priority;
		
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
