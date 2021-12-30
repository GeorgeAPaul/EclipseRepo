package dataStructures;
public class Queue<E extends Comparable<E>> {
	
	private Vector<E> data;
	
	public Queue() {
		data = new Vector<E>(10);
	}
	public void push(E o) {
		data.addFirst(o);
	}
	public E pop() {
		E tmp = data.getLast();
		data.removeLast();
		return tmp;
	}
	public E top() {
		return data.getLast();
	}
	public int size() {
		return data.size();
	}
	public boolean isEmpty() {
		return data.isEmpty();
	}
}
