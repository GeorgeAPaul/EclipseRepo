
import java.util.Comparator;
public class PriorityQueue<E extends Comparable<E>> 
{       
	private class PriorityPair<E extends Comparable<E>> implements Comparable<E> {
		
		private Object element;
		private Object priority;
		
		public PriorityPair(E element, Object priority) {
			this.element = element;
			this.priority = priority;
		}
		public int compareTo(E o) {
			PriorityPair<E> p2 = (PriorityPair<E>) o;
			return ((Comparable) priority).compareTo(p2.priority);
		}
	}
	
	private LinkedList<PriorityPair<E>> data;
	public PriorityQueue()
	{
		data = new LinkedList<PriorityPair<E>>();
	}
	public void push(E o, int priority)
	{
		// make a pair of o and priority
		// add this pair to the sorted linked list.
		PriorityPair pp = new PriorityPair(o, priority);
		data.addSorted(pp);
		
	}
	public Object pop()
	{
		// add your code here
	}
	public Object top()
	{
		// add your code here
	}
}
