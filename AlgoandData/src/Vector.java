import java.util.Arrays;

public class Vector<E>
{
	private Object data[];
	private int count;
	
	public Vector(int capacity)
	{
		data = new Object[capacity];
		count = 0;
	}

	public int size()
	{
		return count;
	}
 
	public boolean isEmpty()
	{
		return size() == 0;
	}

	public Object get(int index)
	{
		return (E)data[index];
	}

	public void set(int index, Object obj)
	{
		data[index] = obj;
	}

	public boolean contains(Object obj)
	{
		for(int i=0;i<count;i++)
		{
			if(data[i] == obj) return true;
		}
		return false;
	}
	
	public void addFirst(Object item)
	{
		if (size() == data.length) {
			extendCapacity();
			for (int i = size(); i > 0; i--) {
				data[i] = data[i-1];
			}
			data[0] = item;
			count ++;
		}
		else {
			for (int i = size(); i > 0; i--) {
				data[i] = data[i-1];
			}
			data[0] = item;
			count ++;
		}
	}

	public void addLast(Object o)
	{
		if(size() == data.length) {
			extendCapacity();
			data[count] = o;
			count++;
		}
		else {
			data[count] = o;
			count++;
		}
	}
	
	/*
	public boolean binarySearch(Object key)
	{
	int start = 0;
	int end = count - 1;
	while(start <= end)
	{
		int middle = (start + end + 1) / 2;
		if(key < data[middle]) end = middle -1;
		else if(key > data[middle]) start = middle + 1;
		else return true;
	}
	return false;
	}
	*/

	public Object getFirst()
	{
		return (E)data[0];
	}

	public Object getLast()
	{
		return (E)data[size() - 1];
	}

	public void removeLast()
	{
		data[count - 1] = null;
		count--;
	} 

	public void removeFirst()
	{
		data[0] = null;
		for (int i = 1; i < size(); i++) {
			data[i - 1] = data[i];
		}
		count --;
	}
	
	public String toString()
	{
		String s = "[ ";
		for (int i = 0; i < size(); i ++) {
			s += String.valueOf(data[i]) + " ";
		}
		s += "]";
		return s;
	}
	
	public void reverse()
	{
		Object tmp[] = new Object[data.length];
		
		for(int i = 0; i < size(); i++) {
			
			tmp[i] = data[size() - i - 1];
			
		}
		
		data = tmp;
	}
	
	//O(n) time complexity, as only 1 for loop so time scales linearly with size.
	public Vector<E> repeat()
	{
		Vector<E> repeatVector = new Vector<E>(size() * 2);
		
		for(int i = 0; i < size(); i += 1) {
			
			repeatVector.addLast(data[i]);
			repeatVector.addLast(data[i]);
			
		}
		
		return repeatVector;
	}
	
	public Vector<E> interleave(Vector<?> v2)
	{
		int newSize = size() + v2.size();
		Vector<E> interleavedVector = new Vector<E>(newSize);
		Vector<E> temp1 = this;
		Vector<?> temp2 = v2;
		
		
		int i = 0;
		while (i < newSize){
			
			if (i % 2 == 0 && 0 < temp1.size()) {
				interleavedVector.addLast(temp1.getFirst());
				temp1.removeFirst();
			}
			else {
				interleavedVector.addLast(temp2.getFirst());
				temp2.removeFirst();
			}
			
			i++;
		}
		
		return interleavedVector;
	}
	
	private void extendCapacity() {
		
		Object[] data2 = new Object[2*data.length];
		
		for(int i = 0; i < data.length; i++) {
			
			data2[i] = data[i];
		}
		data = data2;
	}
	
}