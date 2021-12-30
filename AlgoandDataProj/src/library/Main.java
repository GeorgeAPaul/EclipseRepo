package library;
public class Main {

	public static void main(String[] args) {
		
		// Instatiating Library with shelf space of 2 and clientList space of 2.
		Library l = new Library(2, 2);
		
		// Adding one of each type of publication
		l.addCD("George", "GCD", 1994, "section1");
		l.addBook("George", "Gbook", 1994, "section1");
		l.addMagazine("GMag", 1994, 12, "section1");
		l.addBlueRay("GRay", 1994, "section1");
		
		// Adding one of each type of client
		l.addClient("George", "george@gib.com");
		l.addClient("George", "george@gib.com");
		l.addClient("George", "george@gib.com");
		l.addClient("George", "george@gib.com");
		l.addClient("George", "george@gib.com");
		l.addClient("George", "george@gib.com");
		l.addVIPClient("VIPGeorge", "george@gibVIP.com");
		l.addVIPClient("VIPGeorge", "george@gibVIP.com");
		l.addVIPClient("VIPGeorge", "george@gibVIP.com");
		l.addVIPClient("VIPGeorge", "george@gibVIP.com");
		l.addVIPClient("VIPGeorge", "george@gibVIP.com");
		l.addVIPClient("VIPGeorge", "george@gibVIP.com");

		
		
		// Printing all contents of library
		l.printAllPublications();
		l.printAllClients();
	
		l.borrowBook(1, "George", "Gbook");
//		l.borrowBook(2, "George", "Gbook");
//		l.borrowBook(3, "George", "Gbook");
//		l.borrowBook(4, "George", "Gbook");
//		l.borrowBook(5, "George", "Gbook");
//		l.borrowBook(6, "George", "Gbook");
//		l.borrowBook(7, "George", "Gbook");
//		l.borrowBook(8, "George", "Gbook");
		
		System.out.println(l.returnItem(829120273));
		System.out.println(l.returnItem(829120273));
		System.out.println(l.returnItem(829120273));
		System.out.println(l.returnItem(829120273));
		System.out.println(l.returnItem(829120273));
		System.out.println(l.returnItem(829120273));
		System.out.println(l.returnItem(829120273));
		System.out.println(l.returnItem(829120273));
		
		l.borrowBook(7, "George", "Gbook");
		
		System.out.println(l.returnItem(829120273));
		
		l.borrowBook(8, "George", "Gbook");
		
		System.out.println(l.returnItem(829120273));
		
		
	}

}
