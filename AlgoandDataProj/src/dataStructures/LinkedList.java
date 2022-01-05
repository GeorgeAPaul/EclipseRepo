package dataStructures;

/**
 * 
 * @author George Paul
 *
 * @param <E> data type to be stored
 */
public class LinkedList<E extends Comparable<E>> {
	
	/**
	 * Class to represent the list elements
	 * 
	 * @param P the data type to be stored
	 */
	private class ListElement<P extends Comparable<P>> implements Comparable<ListElement<P>> {
		
		/**
		 * Holds the data
		 */
		private P el1;
		
		/**
		 * Points to the next element in the list
		 */
		private ListElement<P> el2;

		/**
		 * Constructor method
		 * @param el data to be stored
		 * @param nextElement pointer to the next element
		 */
		public ListElement(P el, ListElement<P> nextElement) {
			el1 = el;
			el2 = nextElement;
		}

		/**
		 * Constructor method for when no next element is defined
		 * @param el data to be stored
		 */
		public ListElement(P el) {
			this(el, null);
		}

		/**
		 * Method to return the data stored in element
		 * @return el1 data stored in list element
		 */
		public P first() {
			return el1;
		}

		/**
		 * Method to return the next list element
		 * @return el2 the next list element
		 */
		public ListElement<P> rest() {
			return el2;
		}

		/**
		 * Method to set the data element
		 * @param value new value for the data element
		 */
		public void setFirst(P value) {
			el1 = value;
		}

		/**
		 * Method to set the pointer to the next element
		 * @param value next list element
		 */
		public void setRest(ListElement<P> value) {
			el2 = value;
		}

		/**
		 * CompareTo method to compare list elements
		 * @return  -ve if o is less, +ve if o is greater, 0 if the elements are equal
		 */
		@Override
		public int compareTo(ListElement<P> o) {
			return this.first().compareTo(o.first());
		}
	}
	
	/**
	 * To store the first element in the list
	 */
	private ListElement<E> head;
	
	/**
	 * To store the size of the list
	 */
	private int count;

	/**
	 * Constructor method
	 */
	public LinkedList() {
		head = null;
	}

	/**
	 * Method to add list element to beginning of list
	 * @param o data to put in element
	 */
	public void addFirst(E o) {
		head = new ListElement<E>(o, head);
		count++;
	}
	
	/**
	 * Method to add elements to a list in a sorted fashion, this method was taken from the course slides
	 * @param o element to add to a list
	 */
	public void addSorted (E o)
	{
		// an empty list , add element in front
		if(head == null) head = new ListElement<E>(o, null);
		else if(head.first().compareTo(o) > 0)
		{
			// we have to add the element in front
			head = new ListElement<E>(o , head);
		}
		else
		{
			// we have to find the first element which is bigger
			ListElement<E> d = head ;
			while ((d.rest() != null) && ((d.rest().first()).compareTo(o) <= 0))
			{
				d = d.rest();
			}
			ListElement<E> next = d.rest();
			d.setRest(new ListElement<E>(o, next));
		}
		count ++;
	}

	/**
	 * Method to return the first element of the list
	 * @return first element of the list
	 */
	public E getFirst() {
		return head.first();
	}
	
	/**
	 * Method to remove the first element of the list
	 */
	public void removeFirst() {
		head = head.rest();
		count--;
	}

	/**
	 * Method to get an element by position in the list
	 * @param n position in the list
	 * @return found data
	 */
	public E get(int n) {
		ListElement<E> d = head; //Start from head
		while (n > 0) { //Traverse list until position is reached
			d = d.rest();
			n--;
		}
		return d.first();
	}
	
	/**
	 * Method to set the value of an element at a given position
	 * @param n position at which to set the value
	 * @param o value to update to
	 */
	public void set(int n, E o) {
		ListElement<E> d = head;
		while (n > 0) {
			d = d.rest();
			n--;
		}
		d.setFirst(o);
	}
	
	/**
	 * Method to get the last element in the list
	 * @return last element in the list
	 */
	public E getLast() {
		ListElement<E> d = head;
		while (d.rest() != null) {
			d = d.rest();
		}
		return d.first();
	}
	
	/**
	 * Method to remove the last element in the list
	 */
	public void removeLast() {
		
		if (size() == 1) {
			head = null;
		}
		else {
			ListElement<E> d = head;
			while (d.rest().rest() != null) {
				d = d.rest();
			}
			d.setRest(null);
		}
		count--;
	}
	
	/**
	 * Method to add an element to the end of a list
	 * @param o data to add to end of list
	 */
	public void addLast(E o) {
		ListElement<E> d = head;
		while (d.rest() != null) {
			d = d.rest();
		}
		
		ListElement<E> l = new ListElement<E>(o);
		d.setRest(l);
		count++;
	}
	
	/**
	 * Method to check whether list contains element
	 * @param obj data to search for
	 * @return true if element is found, else false
	 */
	public boolean contains(E obj)
	{
		if(isEmpty()) {
			return false;
			
		}
		ListElement<E> d = head;
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
	
	/**
	 * toString method
	 * @return string representation of List
	 */
	public String toString() {
		String s = "(";
		ListElement<E> d = head;
		while (d != null) {
			s += d.first();
			s += ", ";
			d = d.rest();
		}
		s += ")";
		return s;
	}
	
	/**
	 * Method to return number of elements in list
	 * @return count size of list
	 */
	public int size() {
		return count;
	}
	
	//Below are methods made for exercises
	
	
	public void fropple(){
		
		if(isEmpty()) {
			return;
		}
		
		ListElement<E> d = head;
		boolean first = true;
		while (d.rest() != null) {
			ListElement<E> tmp = d.rest().rest();
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
		ListElement<E> d = list2.head;
		
		if(list2.isEmpty()) {
			return;
		}
		
		while(d != null) {
			addLast(d.first());
			d = d.rest();
		}
	}

}

