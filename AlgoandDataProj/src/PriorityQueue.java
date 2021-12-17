
public class PriorityQueue<E, T extends Comparable<T>> 
{       
	private class PriorityPair<P, U extends Comparable<U>> implements Comparable<PriorityPair<?,U>> {
		
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
		public int compareTo(PriorityPair<?,U> o) {
			return priority.compareTo((T) o.priority);
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
		Object tmp = data.getFirst().getElement();
		data.removeFirst();
		return (E)tmp;
	}
	public E top()
	{
		return (E)data.getFirst().getElement();
	}
}
