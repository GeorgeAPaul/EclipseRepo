
public class Main {
	
	public static void main(String[] args) {

		Vector<Integer> v = new Vector<Integer>(100);
	
		for (int i = 0; i < 97; i++) {
		
			v.addLast(i+1);
		
		}
		
		System.out.println(v.size());
		System.out.println(v.contains(6));
		System.out.println(v.contains(101));
		System.out.println(v.getFirst());
		System.out.println(v.getLast());
		System.out.println(v);
		v.addFirst(20);
		v.addFirst(21);
		v.addLast(24);
		v.addLast(24);
		v.addLast(24);
		v.addLast(24);
		v.addLast(24);
		v.addLast(24);
		v.addLast(24);
		v.addLast(24);
		v.addLast(24);
		System.out.println(v);
		v.addFirst(22);
		v.addFirst(23);
		v.addFirst(24);
		v.addFirst(24);
		v.addFirst(24);
		v.addFirst(24);
		v.addFirst(24);
		v.addFirst(24);
		v.addFirst(24);
		v.removeLast();
		System.out.println(v);
		v.removeLast();
		System.out.println(v);
		v.removeFirst();
		System.out.println(v);
		v.reverse();
		System.out.println(v);
		
		System.out.println("Testing reverse");
		
		Vector<Integer> v1 = new Vector<Integer>(100);
		
		for (int i = 0; i < 20; i++) {
		
			v1.addLast(i+1);
		
		}
		System.out.println(v1);
		v1.reverse();
		System.out.println(v1);
		
		System.out.println("Testing repeat");
		System.out.println(v1);
		System.out.println(v1.repeat());
		System.out.println(v1);
		
		Vector<String> v2 = new Vector<String>(100);
		
		v2.addFirst("plop");
		v2.addLast("plopasdasd");
		v2.addFirst("ploasp");
		v2.addFirst("plasdsadop");
		v2.addFirst("plasdsadop");
		v2.addFirst("plasdsadop");
		v2.addFirst("plasdsadop");
		v2.addFirst("plasdsadop");
		
		
		System.out.println(v2);
		v2.reverse();
		
		System.out.println(v2);
		System.out.println(v2.repeat());
		System.out.println(v2);
		v2.removeFirst();
		v2.removeLast();
		System.out.println(v2);
		
		System.out.println("Testing interleave");
		
		Vector<Integer> v3 = new Vector<Integer>(100);
		Vector<Integer> v4 = new Vector<Integer>(100);
//		v3.addLast(1);
//		v3.addLast(2);
//		v3.addLast(3);
		v3.addLast(4);
////		v4.addLast(14);
////		v4.addLast(15);
////		v4.addLast(16);
////		v4.addLast(17);
//		v3.addLast(4);
		System.out.println(v3);
		System.out.println(v4);
		
		
		//System.out.println(v3.interleave(v2));
		Vector<Integer> v5 = v4.interleave(v3);
		
		System.out.println(v5);
		v5.reverse();
		System.out.println(v5);
		Vector<Integer> v6 = v5.repeat();
		System.out.println(v6);
		
		System.out.println(v5.binarySearch(4));
		
		
		
		
		
		
		
	}
}

