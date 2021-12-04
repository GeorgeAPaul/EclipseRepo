
import java.util.Comparator;
public class PriorityQueue<E extends Comparable> 
{       
	private class PriorityPair<E> implements Comparable {
		
		private Object element;
		private Object priority;
		
		public PriorityPair(Object element, Object priority) {
			this.element = element;
			this.priority = priority;
		}
		public int compareTo(Object o) {
			PriorityPair p2 = (PriorityPair) o;
			return ((Comparable) priority).compareTo(p2.priority);
		}
	}
	
	private LinkedList data;
	public PriorityQueue()
	{
		data = new LinkedList();
	}
	public void push(Object o, int priority)
	{
		// make a pair of o and priority
		// add this pair to the sorted linked list.
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
