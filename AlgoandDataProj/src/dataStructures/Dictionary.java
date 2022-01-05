package dataStructures;


	/**
	 * 
	 * @author George Paul
	 *
	 * @param <E> Datatype for the keys
	 * @param <T> Datatype for the values
	 */
	public class Dictionary<E extends Comparable<E>,T extends Comparable<T>> {
		
		/**
		 * Nested class for holding the key value pairs		 *
		 * @param <K> Datatype for the keys
		 * @param <V> Datatype for the values
		 */
		private class DictionaryPair<K extends Comparable<K>,V extends Comparable<V>> implements Comparable<DictionaryPair<K,V>> {
			
			/**
			 * Holds the key
			 */
			private K key;
			
			/**
			 * Holds the stored data
			 */
			private V value;
			
			/**
			 * Constructor method
			 * @param key The key value
			 * @param value The data to be stored
			 */
			public DictionaryPair(K key, V value) {
				this.key = key;
				this.value = value;
			}
			
			/**
			 * Method to get the key 
			 * @return key the key value
			 */
			public K getKey() {
				return key;
			}
			
			/**
			 * Method to set the key
			 * @param key the new key value
			 */
			public void setKey(K key) {
				this.key = key;
			}
			
			/**
			 * Method to get the stored data
			 * @return the stored ddata
			 */
			public V getValue() {
				return value;
			}
			
			/**
			 * Method to set the stored data
			 * @param value the new data to be stored
			 */
			public void setValue(V value) {
				this.value = value;
			}
			
			/**
			 * Compare to method
			 */
			public int compareTo(DictionaryPair<K,V> o) {
				return o.key.compareTo(key);
			}
			
			/**
			 * toString method
			 * @return string representation of the DictionaryPair
			 */
			public String toString() {
				return value.toString();
			}
		}
		
		/**
		 * Tree to hold the pairs
		 */
		private Tree<DictionaryPair<E,T>> data;
		
		/**
		 * Constructor method
		 */
		public Dictionary() {
			
			data = new Tree<DictionaryPair<E,T>>();
		}
		
		/**
		 * Method to add a key pair to the dictionary
		 * @param key key to be added
		 * @param value data to be added
		 */
		public void add(E key, T value) {
			
			if(contains(key)) {
				
			}
			
			DictionaryPair<E,T> dp = new DictionaryPair<E,T>(key, value);
			
			data.insert(dp);
		}
		
		/**
		 * Method to check whether key already exists in Dictionary
		 * @param key key to check
		 * @return true if key found, else false
		 */
		public boolean contains(E key) {
			DictionaryPair<E,T> dp = new DictionaryPair<E,T>(key, null);
			if(data.find(dp) != null) {
				return true;
			}
			return false;
		}
		
		/**
		 * Method to return data associated with a key
		 * @param key Key to search for
		 * @return data associated with key
		 */
		public T find(E key) {
			DictionaryPair<E,T> dp = new DictionaryPair<E,T>(key, null);
			return data.find(dp).getValue();
		}
		
		/**
		 * Method to return number of key pairs in Dictionary
		 * @return number of key pairs in dictionary
		 */
		public int size() {
			return data.size();
		}
		
		/**
		 * toString method
		 * @return String representation of dictionary
		 */
		public String toString() {
			return data.toString();
		}
	}
