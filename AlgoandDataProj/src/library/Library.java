package library;
import dataStructures.Vector;
import dataStructures.Dictionary;
import dataStructures.Graph;
import dataStructures.LinkedList;

/**
 * Class to represent a Library. The shelves clients and sections are represented and there are methods to add publications/clients/sections
 * to the library. 
 * 
 * @author George Paul
 *
 */
public class Library implements ILibraryManagement {
	
	/**
	 * Dictionary to store the publications in so that strings can be searched for in O(log(n)) time (if tree is balanced).
	 * Disadvantage is that multiple copies of same publication cannot be stored unless different name used.
	 */
	private Dictionary<String,Publication> shelves;
	
	/**
	 * Dictionary so that searchStrings can be found from ids, this enables methods that take ids as arguments to search the shelves
	 * dictionary using a searchString. 
	 */
	private Dictionary<Integer,String> idToString;
	
	/**
	 * Vector to represent the list of clients of the Library. Vector so that clients can be address in O(1) time by id
	 * which is just their index + 1.
	 */
	private Vector<AbstractClient> clientList;
	
	/**
	 * Graph to store sections, graph allows linking of sections 
	 */
	private Graph<String> sections;
	
	/**
	 * int to represent the next available id for clients.  
	 */
	private int nextAvailableClientId;
	
	/**
	 * int to represent the next available id for publications.  
	 */

	/**
	 * Constructor method.
	 */
	public Library() {
			
		shelves = new Dictionary<String,Publication>();
		idToString = new Dictionary<Integer,String>();
		
		clientList = new Vector<AbstractClient>(10);
		nextAvailableClientId = 1;
		
		sections = new Graph<String>();
		
	}
	
	/**
	 * Method to add a Book to the Library
	 * @param author Name of the author
	 * @param title Title of the book
	 * @param yearOfPublication Year the book was published
	 * @return id of the book, -1 if book is already in library
	 */
	@Override
	public int addBook(String author, String title, int yearOfPublication, String section) { 
		//O(logn), goes to O(n) as number of items in library approaches max range of integer
		
		//Generating search key to use in the shelves dictionary
		String searchString = author+title+"BOOK";
		
		//Checks whether book already in library
		if(!shelves.contains(searchString)) {
			int id = 0;
			
			//Generating a random publication id, checks the idToString dictionary to avoid collisions
			//-1 is reserved for already present publications
			while(idToString.contains(id) && id != -1) { 
				id = (int)(Math.random()*(double)Integer.MAX_VALUE);
			}
			
			//Add new id and search string to idToString dictionary
			idToString.add(id, searchString);
			
			Book b = new Book(id, title, yearOfPublication, author, section); // Instantiating book object
			shelves.add(searchString,b); // Adding book to shelves, O(logn)
			
			return b.getId();// Return's id of added Book.
		}
		System.out.println("Library already contains this Book");
		return -1;
	}

	/**
	 * Method to add a Magazine to the Library
	 * @param title Title of the magazine
	 * @param yearOfPublication Year the magazine was published
	 * @param issue Issue number of the magazine
	 * @return id of the magazine, -1 if magazine is already in library
	 */
	@Override
	public int addMagazine(String title, int yearOfPublication, int issue, String section) { // Follows same logic as addBook.
		
		String searchString = title+yearOfPublication+issue+"MAGAZINE";
		
		if(!shelves.contains(searchString)) {
			int id = 0;
			while(idToString.contains(id) && id != -1) { 
				id = (int)(Math.random()*(double)Integer.MAX_VALUE);
			}
			idToString.add(id, searchString);
			
			Magazine m = new Magazine(id, title, yearOfPublication, issue, section);
			shelves.add(searchString,m);
			
			return m.getId();
		}
		System.out.println("Library already contains this Magazine");
		return -1;
	}

	/**
	 * Method to add a Blueray to the Library
	 * @param title Title of the Blueray
	 * @param yearOfPublication Year the Blueray was published
	 * @return id of the blueray, -1 if blueray is already in library
	 */
	@Override
	public int addBlueRay(String title, int yearOfPublication, String section) { // Follows same logic as addBook.
		
		String searchString = title+yearOfPublication+"BLURAY";
		
		if(!shelves.contains(searchString)) {
			int id = 0;
			while(idToString.contains(id) && id != -1) { 
				id = (int)(Math.random()*(double)Integer.MAX_VALUE);
			}
			idToString.add(id, searchString);
			
			Blueray br = new Blueray(id, title, yearOfPublication, section);
			shelves.add(searchString,br);
			
			return br.getId();
		}
		System.out.println("Library already contains this Blueray");
		return -1;
	}

	/**
	 * Method to add a CD to the Library
	 * @param author Name of the artist
	 * @param title Title of the CD
	 * @param yearOfPublication Year the CD was published
	 * @return id of the CD, -1 if CD is already in library
	 */
	@Override
	public int addCD(String author, String title, int yearOfPublication, String section) { // Follows same logic as addBook.
		
		String searchString = author+title+"CD";
		
		if(!shelves.contains(searchString)) {
			int id = 0;
			while(idToString.contains(id) && id != -1) { 
				id = (int)(Math.random()*(double)Integer.MAX_VALUE);
			}
			idToString.add(id, searchString);
			
			CD c = new CD(id, title, yearOfPublication, author, section);
			shelves.add(searchString,c);
			
			return c.getId();
		}
		System.out.println("Library already contains this CD");
		return -1;
	}

	/**
	 * Method to add a Client to the Library
	 * @param name Name of Client
	 * @param email Email address of Client
	 */
	@Override
	public int addClient(String name, String email) { // Creates new client record then adds to clientList //O(1)
		
		Client c = new Client(nextAvailableClientId, name, email);
		clientList.addLast(c);
		nextAvailableClientId++; // Incrementing clientId
		
		return c.getId();
	}

	/**
	 * Method to add a VIPClient to the Library
	 * @param name Name of VIP Client
	 * @param email Email address of VIP Client
	 */
	@Override
	public int addVIPClient(String name, String email) { // Follows same logic as addClient.
		
		VIPClient v = new VIPClient(nextAvailableClientId, name, email);
		clientList.addLast(v);
		nextAvailableClientId++;
		
		return v.getId();
	}

	/**
	 * Method to prettily print all Publications in the Library.
	 */
	@Override
	public void printAllPublications() { //O(n) 
		System.out.println(shelves);
	}

	/**
	 * Method to prettily print all Clients of the Library.
	 */
	@Override
	public void printAllClients() { //O(n) 
		
		String outString = "";
		for(int i = 0; i < clientList.size(); i++) {
			outString += clientList.get(i) + "\n";
		}
		System.out.println(outString);
	}

	/**
	 * Method to borrow a book
	 * @param client id of client who is borrowing the book.
	 * @param author author of the book
	 * @param title title of the book
	 * @return id of the book, -1 if book not found
	 */
	@Override
	public int borrowBook(int client, String author, String title) {
		
		
		String searchString = author+title+"BOOK";
		Book b = (Book)shelves.find(searchString); //Search shelves for book.
		
		if(b == null) {
			System.out.println("Book not found");
			return -1;
		}
		
		//If client is VIP client add them to waiting list with priority 0, if not add them with priority 1.
		if(clientList.get(client - 1) instanceof VIPClient) {
			b.borrow(client, 0);
		}
		else {
			b.borrow(client, 1);
		}
		return b.getId();
	}

	/**
	 * Method to borrow a magazine
	 * @param client id of client who is borrowing the magazine.
	 * @param yearOfPublication year that the magazine was published
	 * @param title title of the magazine
	 * @param issue issue number of the magazine
	 * @return id of the magazine, -1 if magazine not found
	 */
	@Override
	public int lookAtMagazine(int client, String title, int yearOfPublication, int issue) { //Follows same logic as borrowBook.
		String searchString = title+yearOfPublication+issue+"MAGAZINE";
		Magazine m = (Magazine)shelves.find(searchString);
		
		if(m == null) {
			System.out.println("Magazine not found");
			return -1;
		}
		
		if(clientList.get(client - 1) instanceof VIPClient) {
			m.borrow(client, 0);
		}
		else {
			m.borrow(client, 1);
		}
		return m.getId();
	}

	/**
	 * Method to borrow a BlueRay
	 * @param client id of client who is borrowing the BlueRay.
	 * @param title title of the BlueRay
	 * @param yearOfPublication year that the blueray was published
	 * @return id of the blueray, -1 if blueray not found
	 */
	@Override
	public int borrowBlueRay(int client, String title, int yearOfPublication) { //Follows same logic as borrowBook.
		String searchString = title+yearOfPublication+"BLURAY";
		Blueray br = (Blueray)shelves.find(searchString); 
		
		if(br == null) {
			System.out.println("Blueray not found");
			return -1;
		}

		if(clientList.get(client - 1) instanceof VIPClient) {
			br.borrow(client, 0);
		}
		else {
			br.borrow(client, 1);
		}
		return br.getId();
	}

	/**
	 * Method to borrow a CD
	 * @param client id of client who is borrowing the CD.
	 * @param author author of the CD
	 * @param title title of the CD
	 * @return id of the CD, -1 if CD not found
	 */
	@Override
	public int borrowCD(int client, String author, String title) { //Follows same logic as borrowBook.
		String searchString = author+title+"CD";
		CD c = (CD)shelves.find(searchString);
		
		if(c == null) {
			System.out.println("CD not found");
			return -1;
		}

		if(clientList.get(client - 1) instanceof VIPClient) {
			c.borrow(client, 0);
		}
		else {
			c.borrow(client, 1);
		}
		return c.getId();
	}

	/**
	 * Method to return a publication, i.e set publication owner id back to 0.
	 * @param publicationID publication id to return.
	 * @return id of the next in line client, -1 if the publication does not exist
	 */
	@Override
	public int returnItem(int publicationID) { //O(logn)
		
		String searchString = idToString.find(publicationID);
		
		if(searchString == null) {
			System.out.println("Publication does not exist");
			return -1;
		}
		
		Publication pf = shelves.find(searchString); //Find the publication in the dict.
		
		
		
		int nextInLine = -1; // Return this if there is no one in the waiting list.
		if(!pf.isWaitingListEmpty()) {
			nextInLine = pf.getNextInLine();
		}
		pf.setCurrentOwner(0);
		return nextInLine;
	}

	/**
	 * Method to add a section the library
	 * @param name Name of the section
	 */
	@Override
	public void addSection(String name) { //O(logn)
		sections.addNode(name);
		
	}

	/**
	 * Method to add a connection between sections, all connections are given equal weight and are bi-directional
	 * @param section1 Starting section
	 * @param section2 Ending section
	 */
	@Override
	public void connectSections(String section1, String section2) { //O(logn) because uses findNode
		sections.addEdge(section1, section2, 1); 
		sections.addEdge(section2, section1, 1);
		
	}

	/**
	 * Method to print the shortest path from a section to a section where a publication is held
	 * @param publicationID Id of the publication whose section is to be navigated to.
	 * @param startSection Name of the section to begin in
	 */
	@Override
	public void findShortestPath(int publicationID, String startSection) { //O(n) because has to traverse every node
		
		//Get search key from id O(logn)
		String searchString = idToString.find(publicationID);
		
		if(searchString == null) {
			System.out.println("Publication does not exist");
			return;
		}
		
		//Retrieve which section the publication is in O(logn)
		Publication pf = shelves.find(searchString);
		String endSection = pf.getSection();
		
		LinkedList<String> path = sections.findShortestPath(startSection, endSection); //O(n) 
		
		//If null returned the section does not exist
		if(path == null) {
			System.out.println("Section does not exist");
		}
		else {
			System.out.println(path);
		}
	}

}
