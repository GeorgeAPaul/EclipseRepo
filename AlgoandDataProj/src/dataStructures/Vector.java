package dataStructures;
/**
 * 
 * @author George Paul
 *
 *The Vector class is based on an array but has a number of useful features such as the ability 
 *to extend its capacity. It is a generic class that can take the type contained as an argument.  
 *
 * @param <E> Data type to be stored in the Vector.
 */
public class Vector<E extends Comparable<E>> 
{
	/**
	 * An array to store the objects in the Vector.
	 */
	private Object data[];
	
	/**
	 *  To keep track of the number of objects in the Vector, also useful for finding the last object.
	 */
	private int count;
	
	/**
	 * Constructor method. 
	 * count is initialised to 0.
	 * @param capacity The desired capacity of the Vector.
	 */
	public Vector(int capacity)
	{
		data = new Object[capacity];
		count = 0;
	}
	
	/** Method to determine size of Vector.
	 * @return The number of elements in the Vector.
	 */
	public int size()
	{
		return count;
	}
 
	/**
	 * Method to determine if Vector is empty.
	 * @return True if there are no objects stored in the Vector, else False.
	 */
	public boolean isEmpty()
	{
		return size() == 0;
	}

	/**
	 * Method to return element at given index in Vector.
	 * @param index Index of Vector to return from.
	 * @return Object from data at given index.
	 */
	public E get(int index)
	{
		return (E)data[index];
	}

	/**
	 * Method to update the value of an element in Vector.
	 * @param index Index of Vector to update.
	 * @param obj Object to be stored at index.
	 */
	public void set(int index, E obj)
	{
		data[index] = obj;
	}

	/**
	 * Method to search Vector for given object.
	 * @param obj Object to search for.
	 * @return True if object is found, else False.
	 */
	public boolean contains(E obj)
	{
		for(int i=0;i<count;i++) // For loop iterates through array.
		{
			if(data[i] == obj) 
				return true;
		}
		return false;
	}
	
	/**
	 * Method to add element to the beginning of the Vector (index = 0).
	 * @param item Object to be added.
	 */
	public void addFirst(E item)
	{
		if (size() == data.length) { // Checks whether max size of data[] has been reached. Extends capacity if True.
			extendCapacity();
		}
		for (int i = size(); i > 0; i--) { // For loop to increment the index of each element by 1.
			data[i] = data[i-1];
		}
		data[0] = item; // Setting element 0 to new object.
		count ++; // Increasing object count.
	}

	/**
	 * Method to add element to the end of the Vector.
	 * @param o Object to be added.
	 */
	public void addLast(E o)
	{
		if(size() == data.length) { // Checks whether max size of data[] has been reached. Extends capacity if True.
			extendCapacity();
		}
		data[count] = o; // Setting last element to new object.
		count++; // Increasing object count.
	}
	
	public void addSorted(E o) {
		
		if(isEmpty()) {
			data[0] = o;
		}
		else {
			if(size() == data.length) { // Checks whether max size of data[] has been reached. Extends capacity if True.
				extendCapacity();
			}
		
			for(int i = 0; i < size(); i++) {
					
				if((o).compareTo((E)data[i]) < 0) {
				
					for (int j = size(); j > i; j--) { // For loop to increment the index of each element by 1.
						data[j] = data[j-1];
					}
					data[i] = o; // Setting element 0 to new object.
					break;
				}
				else {
					data[count] = o;
				}
			}
		}
		count++; // Increasing object count.
	}
	
	
	/**
	 * Method to check whether an element is present in the Vector, ONLY WORKS IF VECTOR CONTAINS SORTED DATA.
	 * @param key element to search for.
	 * @return true if key is found else return false.
	 */
	
	public E binarySearch(E key)
	{
	int start = 0; // Start of section of data[] to be searched. Initialised to be first element of data[].
	int end = count - 1; // End of section of data[] to be searched. Initialised to be last element of data[].
	while(start <= end) // Keep going until section is 1 element long
	{
		int middle = (start + end + 1) / 2; // Defining middle element of data[]. 
		if((key).compareTo((E)data[middle]) < 0) end = middle -1; // If key is less than middle element, move end to middle element - 1.
		else if((key).compareTo((E)data[middle]) > 0) start = middle + 1; // If key is more than middle element, move start to middle element + 1.
		else return (E)data[middle]; // If key equals middle element then element has been found.
	}
	return null; // Return false if element was not found.
	}
	
	/**
	 * Method to return the first element in the Vector.
	 * @return first element of the Vector..
	 */
	public E getFirst()
	{
		return (E)data[0];
	}

	/**
	 * Method to return the last element in the Vector.
	 * @return last element of the Vector.
	 */
	public E getLast()
	{
		if(size() == 0) {
			return null;
		}
		return (E)data[size() - 1];
	}

	/**
	 * Method to remove the last element in the Vector.
	 */
	public void removeLast()
	{
		if(size() != 0) {
			data[count - 1] = null;
			count--;
		}
		
	} 

	/**
	 * Method to remove the first element in the Vector.
	 */
	public void removeFirst()
	{
		for (int i = 1; i < size(); i++) { // For loop to decrement the index of all elements by 1. First element is overwritten.
			data[i - 1] = data[i];
		}
		count --;
	}
	
	/**
	 * Returns contents of Vector as a formatted String.
	 */
	public String toString()
	{
		String s = "[";
		for (int i = 0; i < size(); i ++) { // For loop to iterate over contents of Vector and add them to the String.
			s += data[i].toString() + ",";
		}
		s += "]";
		return s;
	}
	
	/**
	 * Reverses the order of the Vector in place.
	 */
	public void reverse()
	{
		Object tmp[] = new Object[data.length]; // Temporary variable to store the new array.
		
		for(int i = 0; i < size(); i++) { // For loop iterates from last element to first adding elements to temporary tmp.
			
			tmp[i] = data[size() - i - 1];
			
		}
		
		data = tmp; //Replacing data with tmp.
	}
	
	/**
	 * Method to return a new Vector with each element repeated. O(n) time complexity, as only 1 for loop so time scales linearly with size.
	 * addLast() is O(1) time complexity.
	 * @return New Vector with repeated elements.
	 */
	public Vector<E> repeat()
	{
		Vector<E> repeatVector = new Vector<E>(size() * 2); // New Vector needs to be double the length.
		
		for(int i = 0; i < size(); i += 1) { // For loop to iterate over each element of the Vector.
			
			repeatVector.addLast((E)data[i]); // Adding each element twice.
			repeatVector.addLast((E)data[i]);
			
		}
		
		return repeatVector;
	}
	
	/**
	 * Method to interleave two Vectors. O(n) time complexity, as only 1 for loop so time scales linearly with size.
	 * addLast() is O(1) time complexity.
	 * @param v2 Second Vector to be interleaved.
	 * @return Interleaved Vector.
	 */
	public Vector<E> interleave(Vector<E> v2)
	{
		int newSize = size() + v2.size(); // Size of new Vector should be the sum of the two Vectors sizes.
		Vector<E> interleavedVector = new Vector<E>(newSize);
		
		int count = 0; // Used to alternate between the two Vectors using below if statement.
		int i = 0; // Index of class Vector.
		int j = 0; // Index of v2 Vector
		while (i < size() || j < v2.size()){ // While the loop is still in bound of at least one of the Vectors. 
			
			if (count % 2 == 0 && i < size()) { // If count is divisible by 2 and still in bounds, add element from class Vector.
				interleavedVector.addLast(this.get(i));
				i++; // Increment index of class Vector.
			}
			else if (j < v2.size()) { // Else if still in bounds of v2, add element from v2 Vector.
				interleavedVector.addLast(v2.get(j));
				j++; // Increment index of v2 Vector.
			}
			count++;
		}
		return interleavedVector;
	}
	
	/**
	 *  Method to double capacity of Vector if capacity is reached.
	 */
	private void extendCapacity() {
		
		Object[] data2 = new Object[2*data.length]; // New data array of double size.
		
		for(int i = 0; i < data.length; i++) { // Copying data into new array.
			
			data2[i] = data[i];
		}
		data = data2; // Overwriting data with extended capacity array.
	}
	
	public void oddFirst() {
		Object[] tmp = new Object[size()];
		int nextSlot = 0;
		
		for(int i = 0; i < size(); i++){
			if((int)data[i] % 2 != 0) {
				tmp[nextSlot] = data[i];
				nextSlot++;
			}
		}
		for(int i = 0; i < size(); i++){
			if((int)data[i] % 2 == 0) {
				tmp[nextSlot] = data[i];
				nextSlot++;
			}
		}
		data = tmp;
	}
}