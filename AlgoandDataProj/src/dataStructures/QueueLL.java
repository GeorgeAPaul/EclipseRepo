package dataStructures;
public class QueueLL<E extends Comparable<E>> {
	
	private Vector<E> data;
	
	public QueueLL() {
		data = new Vector(10);
	}
	public void push(E o) {
		data.addFirst(o);
	}
	public Object pop() {
		Object tmp = data.getLast();
		data.removeLast();
		return tmp;
	}
	public Object top() {
		return data.getLast();
	}
	public int size() {
		return data.size();
	}
	public boolean isEmpty() {
		return data.isEmpty();
	}
}
