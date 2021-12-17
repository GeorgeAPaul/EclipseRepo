public class LinkedList<E extends Comparable<E>> {
	
	
	private class ListElement implements Comparable<E> {
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

		@Override
		public int compareTo(E o) {
			return this.compareTo(o);
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
	
	public void addSorted (E o)
	{
		// an empty list , add element in front
		if(head == null) head = new ListElement(o, null);
		else if(head.first().compareTo(o) > 0)
		{
			// we have to add the element in front
			head = new ListElement (o , head);
		}
		else
		{
			// we have to find the first element which is bigger
			ListElement d = head ;
			while ((d.rest() != null) && (((Comparable<E>)d.rest().first()).compareTo(o) <= 0))
			{
				d = d.rest();
			}
			ListElement next = d.rest();
			d.setRest(new ListElement (o, next));
		}
		count ++;
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
			while (d.rest().rest() != null) {
				d = d.rest();
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
		if(isEmpty()) {
			return false;
			
		}
		ListElement d = head;
		while(d != null) {
			if(d.first() == obj) {
				return true;
			}
			d = d.rest();
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
			s += d.first();
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
		
		if(isEmpty()) {
			return;
		}
		
		ListElement d = head;
		boolean first = true;
		while (d.rest() != null) {
			ListElement tmp = d.rest().rest();
			if (tmp == null) {
				return;
			}
			if(first) {
				head = d.rest();
				head.setRest(d);
				d.setRest(tmp);
				first = false;
			}
			else {
				d.rest().setRest(tmp.rest());
				tmp.setRest(d.rest());
				d.setRest(tmp);
				d = d.rest().rest();
			}
		}
	}
	
	public void append(LinkedList<E> list2) {
		ListElement d = list2.head;
		
		if(list2.isEmpty()) {
			return;
		}
		
		while(d != null) {
			addLast(d.first());
			d = d.rest();
		}
	}

}

