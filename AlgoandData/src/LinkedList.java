public class LinkedList<E> {
	
	
	private class ListElement {
		private E el1;
		private ListElement el2;

		public ListElement(E el, ListElement nextElement) {
			el1 = el;
			el2 = nextElement;
		}

		public ListElement(E el) {
			this(el, null);
		}

		public E first() {
			return el1;
		}

		public ListElement rest() {
			return el2;
		}

		public void setFirst(E value) {
			el1 = value;
		}

		public void setRest(ListElement value) {
			el2 = value;
		}
	}
	
	private ListElement head;
	private int count;

	public LinkedList() {
		head = null;
	}

	public void addFirst(E o) {
		head = new ListElement(o, head);
		count++;
	}

	public E getFirst() {
		return head.first();
	}
	
	public void removeFirst() {
		head = head.rest();
		count--;
	}

	public E get(int n) {
		ListElement d = head;
		while (n > 0) {
			d = d.rest();
			n--;
		}
		return d.first();
	}
	
	public void set(int n, E o) {
		ListElement d = head;
		while (n > 0) {
			d = d.rest();
			n--;
		}
		d.setFirst(o);
	}
	
	public E getLast() {
		ListElement d = head;
		while (d.rest() != null) {
			d = d.rest();
		}
		return d.first();
	}
	
	public void removeLast() {
		
		if (size() == 1) {
			head = null;
		}
		else {
			ListElement d = head;
			int n = size() - 2;
			while (n > 0) {
				d = d.rest();
				n--;
			}
			d.setRest(null);
		}
		count--;
	}
	
	public void addLast(E o) {
		ListElement d = head;
		while (d.rest() != null) {
			d = d.rest();
		}
		
		ListElement l = new ListElement(o);
		d.setRest(l);
		count++;
	}
	
	public boolean contains(E obj)
	{
		ListElement d = head;
		while(d.rest() != null) {
			if(d.first() == obj) {
				return true;
			}
			d = d.rest();
			if(d.rest() == null && d.first() == obj) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Method to determine if Vector is empty.
	 * @return True if there are no objects stored in the Vector, else False.
	 */
	public boolean isEmpty()
	{
		//System.out.println("called from LL");
		return size() == 0;
	}
	
	public String toString() {
		String s = "(";
		ListElement d = head;
		while (d != null) {
			s += d.first().toString();
			s += " ";
			d = d.rest();
		}
		s += ")";
		return s;
	}
	
	public int size() {
		return count;
	}
	
	public void fropple(){
		ListElement d = head;
		boolean first = true;
		while (d.rest() != null) {
			//ListElement tmp1 = d;
			ListElement tmp = d.rest();
			if(first) {
				head = new ListElement(d.rest().first(), d);
				first = false;
			}
			d.rest().setRest(d);
			
			d.setRest(tmp.rest());
			d = d.rest();
		}
	}

}

