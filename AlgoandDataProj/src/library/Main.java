package library;
public class Main {

	public static void main(String[] args) {
		
		// Instantiating Library with clientList space of 2.
		Library l = new Library();
		
		// Adding one of each type of publication
		int id1 = l.addCD("George", "GCD", 1994, "section1");
		int id2 = l.addCD("George", "GCD", 1994, "section1");
		int id3 = l.addBook("George", "Gbook", 1994, "section1");
		int id4 = l.addBook("George", "Gbook", 1994, "section1");
		int id5 = l.addMagazine("GMag", 1994, 12, "section1");
		int id7 = l.addMagazine("GMag", 1994, 12, "section1");
		int id6 = l.addBlueRay("GRay", 1994, "section1");
		int id8 = l.addBlueRay("GRay", 1994, "section1");
		
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
	
		System.out.println(l.borrowBook(1, "George", "Gbook"));
		System.out.println(l.borrowBook(2, "George", "Gbook"));
		l.borrowBook(3, "George", "Gbook");
		l.borrowBook(4, "George", "Gbook");
		l.borrowBook(5, "George", "Gbook");
		l.borrowBook(6, "George", "Gbook");
		l.borrowBook(7, "George", "Gbook");
		l.borrowBook(8, "George", "Gbook");
		
//		System.out.println(l.returnItem(id1));
//		System.out.println(l.returnItem(2));
//		System.out.println(l.returnItem(2));
////		System.out.println(l.returnItem(2));
////		System.out.println(l.returnItem(2));
////		System.out.println(l.returnItem(2));
////		System.out.println(l.returnItem(2));
////		System.out.println(l.returnItem(2));
		
		//l.borrowBook(7, "George", "Gbook");
		
		System.out.println(l.returnItem(id3));
		System.out.println(l.returnItem(id3));
		System.out.println(l.returnItem(id3));
		System.out.println(l.returnItem(id3));
		l.borrowBook(7, "George", "Gbook");
		System.out.println(l.returnItem(id3));
		System.out.println(l.returnItem(id3));
		System.out.println(l.returnItem(id3));
		
		
		l.borrowBook(8, "George", "Gbook");
		
		System.out.println(l.returnItem(id3));
		
		l.addSection("section1");
		l.addSection("section2");
		l.addSection("section3");
		l.addSection("section4");
		l.addSection("section5");
		l.addSection("section6");
		l.addSection("section7");
		l.addSection("section8");
		l.addSection("section9");
		l.addSection("section10");
		
		l.connectSections("section1", "section2");
		l.connectSections("section2", "section3");
		l.connectSections("section3", "section4");
		l.connectSections("section4", "section5");
		l.connectSections("section5", "section6");
		l.connectSections("section6", "section7");
		l.connectSections("section7", "section8");
//		l.connectSections("section8", "section9");
//		l.connectSections("section9", "section10");
		l.connectSections("section1", "section6");
		
		
		l.findShortestPath(id1, "section10");
		
		
		
	}

}
