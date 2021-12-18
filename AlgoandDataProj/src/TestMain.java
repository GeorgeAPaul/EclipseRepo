import java.util.Arrays;

public class TestMain {
	
	public static void main(String[] args) {

//		Vector<Integer> v = new Vector<Integer>(100);
//	
//		for (int i = 0; i < 97; i++) {
//		
//			v.addLast(i+1);
//		
//		}
//		
//		System.out.println(v.size());
//		System.out.println(v.contains(6));
//		System.out.println(v.contains(101));
//		System.out.println(v.getFirst());
//		System.out.println(v.getLast());
//		System.out.println(v);
//		v.addFirst(20);
//		v.addFirst(21);
//		v.addLast(24);
//		v.addLast(24);
//		v.addLast(24);
//		v.addLast(24);
//		v.addLast(24);
//		v.addLast(24);
//		v.addLast(24);
//		v.addLast(24);
//		v.addLast(24);
//		System.out.println(v);
//		v.addFirst(22);
//		v.addFirst(23);
//		v.addFirst(24);
//		v.addFirst(24);
//		v.addFirst(24);
//		v.addFirst(24);
//		v.addFirst(24);
//		v.addFirst(24);
//		v.addFirst(24);
//		v.removeLast();
//		System.out.println(v);
//		v.removeLast();
//		System.out.println(v);
//		v.removeFirst();
//		System.out.println(v);
//		v.reverse();
//		System.out.println(v);
//		
//		System.out.println("Testing reverse");
//		
//		Vector<Integer> v1 = new Vector<Integer>(100);
//		
//		for (int i = 0; i < 20; i++) {
//		
//			v1.addLast(i+1);
//		
//		}
//		System.out.println(v1);
//		v1.reverse();
//		System.out.println(v1);
//		
//		System.out.println("Testing repeat");
//		System.out.println(v1);
//		System.out.println(v1.repeat());
//		System.out.println(v1);
//		
//		Vector<String> v2 = new Vector<String>(100);
//		
//		v2.addFirst("plop");
//		v2.addLast("plopasdasd");
//		v2.addFirst("ploasp");
//		v2.addFirst("plasdsadop");
//		v2.addFirst("plasdsadop");
//		v2.addFirst("plasdsadop");
//		v2.addFirst("plasdsadop");
//		v2.addFirst("plasdsadop");
//		
//		
//		System.out.println(v2);
//		v2.reverse();
//		
//		System.out.println(v2);
//		System.out.println(v2.repeat());
//		System.out.println(v2);
//		v2.removeFirst();
//		v2.removeLast();
//		System.out.println(v2);
//		
//		System.out.println("Testing interleave");
//		
//		Vector<Integer> v3 = new Vector<Integer>(100);
//		Vector<Integer> v4 = new Vector<Integer>(100);
////		v3.addLast(1);
////		v3.addLast(2);
////		v3.addLast(3);
//		v3.addLast(4);
//////		v4.addLast(14);
//////		v4.addLast(15);
//////		v4.addLast(16);
//////		v4.addLast(17);
////		v3.addLast(4);
//		System.out.println(v3);
//		System.out.println(v4);
//		
//		
//		//System.out.println(v3.interleave(v2));
//		Vector<Integer> v5 = v4.interleave(v3);
//		
//		System.out.println(v5);
//		v5.reverse();
//		System.out.println(v5);
//		Vector<Integer> v6 = v5.repeat();
//		System.out.println(v6);
//		
//		System.out.println(v5.binarySearch(4));
		
//		LinkedList<Integer> l = new LinkedList<Integer>();
//		
//		l.addFirst(1);
//		l.addFirst(2);
//		l.addFirst(3);
//		l.addFirst(4);
//		
//		System.out.println(l);
//		System.out.println(l.get(2));
//		l.set(2, 99);
//		System.out.println(l.get(2));
//		System.out.println(l);
//		
//		l.addFirst(20);
//		System.out.println(l);
//		l.addLast(5);
//		System.out.println(l);
//		System.out.println(l.getLast());
//		System.out.println(l.contains(20));
//		System.out.println(l.contains(5));
//		System.out.println(l.isEmpty());
//		
//		System.out.println("Before" + l);
//		
//		l.fropple();
//		
//		System.out.println(l);
//		
//		LinkedList<String> s = new LinkedList<String>();
		
//		s.addFirst("plip");
//		s.addFirst("plap");
//		s.addFirst("plip");
//		s.addFirst("plap");
//		s.addFirst("plip");
		//s.addFirst("plap");
		
//		System.out.println("Before" + s);
//		
//		s.fropple();
//		
//		System.out.println(s);
//		
//		LinkedList<Integer> l2 = new LinkedList<Integer>();
//		
//		l2.addFirst(100);
//		l2.addFirst(200);
//		l2.addFirst(300);
//		
//		l.append(l2);
//		
//		System.out.println(l);
//		
//		l.removeLast();
//		
//		System.out.println(l);
//		
//		LinkedList<Integer> lSorted = new LinkedList<Integer>();
//		
//		lSorted.addSorted(6);
//		lSorted.addSorted(100);
//		lSorted.addSorted(3);
//		lSorted.addSorted(47);
//		lSorted.addSorted(12);
//		lSorted.addSorted(11);
//		lSorted.addSorted(47);
//		lSorted.addSorted(100);
//		lSorted.addSorted(3);
//		
//		System.out.println(lSorted);
//		
//		l.removeFirst();
//		System.out.println(l);
//		//l.removeFirst();
//		System.out.println(l);
//		System.out.println(l.getFirst());
		
//		StackLL<Integer> s = new StackLL<Integer>();
//		
//		s.push(1);
//		s.push(2);
//		s.push(3);
//		s.push(4);
//		
//		System.out.println(s.top());
//		System.out.println(s);
//		System.out.println(s.size());
//		System.out.println(s.pop());
//		System.out.println(s.pop());
//		System.out.println(s.pop());
//		System.out.println(s.pop());
//		System.out.println(s);
//		System.out.println(s.size());
		
		
		PriorityQueue<String,Integer> pq = new PriorityQueue<String,Integer>();
		
		pq.push("VIPClient1",0);
		pq.push("Client1",1);
		pq.push("Client2",1);
		pq.push("VIPClient2",0);
		pq.push("VIPClient3",0);
		pq.push("VIPClient4",0);
		pq.push("VIPClient5",0);
		
		
		pq.push("Client3",1);
		pq.push("Client4",1);
		pq.push("Client5",1);
		
		
		
		System.out.println(pq.pop());
		System.out.println(pq.pop());
		System.out.println(pq.pop());
		System.out.println(pq.pop());
		System.out.println(pq.pop());
		System.out.println(pq.pop());
		System.out.println(pq.pop());
		System.out.println(pq.pop());
		
		
//		Tree t = new Tree();
//		
//		t.insert(1);
//		t.insert(2);
//		t.insert(3);
//		t.insert(4);
//		t.insert(5);
//		t.insert(6);
//		
//		System.out.println(t.toString());
//		
//		t.traverse(new TreePrinter());
		
//		Matrix m = new Matrix(10);
//		
//		System.out.println(m);
		
		
		
		
		
		
		
		
		
	}
}

