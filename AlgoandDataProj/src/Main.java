public class Main {

	public static void main(String[] args) {
		
		Book b = new Book(1, "Gbook", 1994, "Plop");
		Book b1 = new Book(3, "Gbook", 1994, "Plop");
		
		System.out.println(b.compareTo(b1));
		
		Library l = new Library(1, 100);
		
		l.addCD("George", "GCD", 1994);
		l.addBook("George", "Gbook", 1994);
		l.addMagazine("GMag", 1994, 12);
		l.addBlueRay("GRay", 1994);
		l.addClient("George", "george@gib.com");
		l.addVIPClient("VIPGeorge", "george@gibVIP.com");
		l.printAllPublications();
		l.printAllClients();
	}

}
