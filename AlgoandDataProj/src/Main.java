public class Main {

	public static void main(String[] args) {
		
		// Instatiating Library with shelf space of 2 and clientList space of 2.
		Library l = new Library(2, 2);
		
		// Adding one of each type of publication
		l.addCD("George", "GCD", 1994);
		l.addBook("George", "Gbook", 1994);
		l.addMagazine("GMag", 1994, 12);
		l.addBlueRay("GRay", 1994);
		
		// Adding one of each type of client
		l.addClient("George", "george@gib.com");
		l.addVIPClient("VIPGeorge", "george@gibVIP.com");
		
		// Printing all contents of library
		l.printAllPublications();
		l.printAllClients();
	}

}
