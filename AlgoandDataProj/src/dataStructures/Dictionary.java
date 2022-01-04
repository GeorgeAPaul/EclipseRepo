package dataStructures;

	public class Dictionary<E extends Comparable<E>,T extends Comparable<T>> {
		
		private class DictionaryPair<K extends Comparable<K>,V extends Comparable<V>> implements Comparable<DictionaryPair<K,V>> {
			private K key;
			private V value;
			
			public DictionaryPair(K key, V value) {
				this.key = key;
				this.value = value;
			}
			public K getKey() {
				return key;
			}
			public void setKey(K key) {
				this.key = key;
			}
			public V getValue() {
				return value;
			}
			public void setValue(V value) {
				this.value = value;
			}
			public int compareTo(DictionaryPair<K,V> o) {
				return o.key.compareTo(key);
			}
			public String toString() {
				return value.toString();
			}
		}
		private Tree<DictionaryPair<E,T>> data;
		
		public Dictionary() {
			
			data = new Tree<DictionaryPair<E,T>>();
		}
		
		public void add(E key, T value) {
			
			
			
			if(contains(key)) {
				
			}
			
			DictionaryPair<E,T> dp = new DictionaryPair<E,T>(key, value);
			
			data.insert(dp);
		}
		
		public boolean contains(E key) {
			DictionaryPair<E,T> dp = new DictionaryPair<E,T>(key, null);
			if(data.find(dp) != null) {
				return true;
			}
			return false;
		}
		
//		public int findPosition(E key) {
//		}
		public T find(E key) {
			DictionaryPair<E,T> dp = new DictionaryPair<E,T>(key, null);
			return data.find(dp).getValue();
		}
		
//		public void removeKey(E key) {
//			DictionaryPair<E,T> dp = new DictionaryPair<E,T>(key, null);
//			data.find(dp).setKey(null);
//		}
		
		public int size() {
			return data.size();
		}
		
		public String toString() {
			return data.toString();
		}
	}
