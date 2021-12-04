
public class Queue<E extends Comparable<E>> {
	
	private Vector<E> data;
	
	public Queue() {
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
	public boolean empty() {
		return data.isEmpty();
	}
}