public class Main {

	public static void main(String[] args) {
		
		Client a = new Client(1, "George", "George@poop.com");
//		Book b = new Book("Gbook", 1984, "George");
//		Magazine m = new Magazine("Gbook", 1984, 6);
//		Book c = new CD("Gbook", 1984, "George");
		
//		System.out.println(a);
//		System.out.println(b);
//		System.out.println(m);
//		System.out.println(c);
		
		Library l = new Library(2, 100);
		
		l.addBook("George", "Gbook", 1994);
		l.addBook("George", "Gbook", 1994);
		l.addBook("George", "Gbook", 1994);
		l.addBook("George", "Gbook", 1994);
		l.printAllPublications();
	}

}
