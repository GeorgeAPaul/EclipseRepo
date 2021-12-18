/**
 * Class to represent a Library. The shelves and the clients are represented and there are methods to add publications/clients
 * to the library. 
 * 
 * @author George Paul
 *
 */
public class Library implements ILibraryManagement {
	
	/**
	 * Tree to store the publications in so that id's can be searched for in O(log(n)) time (if tree is balanced).
	 */
	private Tree<Publication> shelves;
	// Since publication id's are now a hash of the input strings we can expect a reasonably 
	//balanced tree but perhaps a red black tree would be better?
	
	/**
	 * Vector to represent the list of clients of the Library. Vector was so that clients can be address in O(1) time by id
	 * which is just their index + 1.
	 */
	private Vector<AbstractClient> clientList;
	
	/**
	 * int to represent the next available id for publications.  
	 */
	private int nextAvailableClientId;

	/**
	 * Constructor method.
	 * @param shelfSpace the initial number of spaces on the shelves available to hold publications.
	 * @param clientSpace the initial space on the client list available to hold clients.
	 */
	public Library(int shelfSpace, int clientSpace) {
			
		shelves = new Tree<Publication>();
		clientList = new Vector<AbstractClient>(clientSpace);
		nextAvailableClientId = 1;
		
	}
	
	/**
	 * Method to add a Book to the Library
	 * @param author Name of the author
	 * @param title Title of the book
	 * @param yearOfPublication Year the book was published
	 */
	@Override
	public int addBook(String author, String title, int yearOfPublication) {
		int id = (author+title).hashCode(); //Create a hash int out of input strings, possible risk of collisions but very rare.
		Book b = new Book(id, title, yearOfPublication, author); // Instantiating book object
		shelves.insert(b); // Adding book to shelves, 
		
		return b.getId(); // Return's id of added Book.
	}

	/**
	 * Method to add a Magazine to the Library
	 * @param title Title of the magazine
	 * @param yearOfPublication Year the magazine was published
	 * @param issue Issue number of the magazine
	 */
	@Override
	public int addMagazine(String title, int yearOfPublication, int issue) { // Follows same logic as addBook.
		int id = (title+yearOfPublication+issue).hashCode();
		Magazine m = new Magazine(id, title, yearOfPublication, issue);
		shelves.insert(m);

		
		return m.getId();
	}

	/**
	 * Method to add a Blueray to the Library
	 * @param title Title of the Blueray
	 * @param yearOfPublication Year the Blueray was published
	 */
	@Override
	public int addBlueRay(String title, int yearOfPublication) { // Follows same logic as addBook.
		int id = (title+yearOfPublication).hashCode();
		Blueray br = new Blueray(id, title, yearOfPublication);
		shelves.insert(br);
		
		return br.getId();
	}

	/**
	 * Method to add a CD to the Library
	 * @param author Name of the artist
	 * @param title Title of the CD
	 * @param yearOfPublication Year the CD was published
	 */
	@Override
	public int addCD(String author, String title, int yearOfPublication) { // Follows same logic as addBook.
		int id = (author+title).hashCode();
		CD c = new CD(id, title, yearOfPublication, author);
		shelves.insert(c);
		
		return c.getId();
	}

	/**
	 * Method to add a Client to the Library
	 * @param name Name of Client
	 * @param email Email address of Client
	 */
	@Override
	public int addClient(String name, String email) { // Follows same logic as addBook.
		
		Client c = new Client(nextAvailableClientId, name, email);
		clientList.addLast(c);
		nextAvailableClientId++;
		
		return c.getId();
	}

	/**
	 * Method to add a VIPClient to the Library
	 * @param name Name of VIP Client
	 * @param email Email address of VIP Client
	 */
	@Override
	public int addVIPClient(String name, String email) { // Follows same logic as addBook.
		
		VIPClient v = new VIPClient(nextAvailableClientId, name, email);
		clientList.addLast(v);
		nextAvailableClientId++;
		
		return v.getId();
	}

	/**
	 * Method to prettily print all Publications in the Library.
	 */
	@Override
	public void printAllPublications() {
		System.out.println(shelves);
	}

	/**
	 * Method to prettily print all Clients of the Library.
	 */
	@Override
	public void printAllClients() {
		
		String outString = clientList.toString();
		System.out.println(outString.substring(2, outString.length() -2));
	}

	/**
	 * Method to borrow a book
	 * @param client id of client who is borrowing the book.
	 * @param author author of the book
	 * @param title title of the book
	 * @return id of the book
	 */
	@Override
	public int borrowBook(int client, String author, String title) {
		int id  = (author+title).hashCode(); //Generate hash int
		Publication p = new Publication(id); //Dummy publication with id to search for.
		Book b = (Book)shelves.find(p); //Search shelves for book.
		
		//If no one currently owns the book and client/no one is next line, allow client to borrow book. Else add client to waiting list.
		if (b.getCurrentOwner() == 0 && (b.isWaitingListEmpty() || b.getNextInLine() == client)) {
			b.setCurrentOwner(client);
			if(! b.isWaitingListEmpty()) { // If waiting list was not empty remove client from waiting list as the now have the book.
				b.removeFromWaitingList();
			}	
		}
		else {
			try { //Try casting client to VIP client, if successful add them to waiting list with priority 0, if not add them with priority 1.
				VIPClient test = (VIPClient) clientList.get(client - 1);
				b.addToWaitingList(client, 0);
			}
			catch(ClassCastException e) {
				b.addToWaitingList(client, 1);
			}
		}
		return id;
	}

	/**
	 * Method to borrow a magazine
	 * @param client id of client who is borrowing the magazine.
	 * @param yearOfPublication year that the magazine was published
	 * @param title title of the magazine
	 * @param issue issue number of the magazine
	 * @return id of the book
	 */
	@Override
	public int lookAtMagazine(int client, String title, int yearOfPublication, int issue) { //Follows same logic as borrowBook.
		int id  = (title+yearOfPublication+issue).hashCode();
		Publication p = new Publication(id);
		Magazine m = (Magazine)shelves.find(p); 
		
		if (m.getCurrentOwner() == 0 && (m.isWaitingListEmpty() || m.getNextInLine() == client)) {
			m.setCurrentOwner(client);
			if(! m.isWaitingListEmpty()) {
				m.removeFromWaitingList();
			}	
		}
		else {
			try {
				VIPClient test = (VIPClient) clientList.get(client - 1);
				m.addToWaitingList(client, 0);
			}
			catch(ClassCastException e) {
				m.addToWaitingList(client, 1);
			}
		}
		return id;
	}

	/**
	 * Method to borrow a BlueRay
	 * @param client id of client who is borrowing the BlueRay.
	 * @param title title of the BlueRay
	 * @param yearOfPublication year that the blueray was published
	 * @return id of the book
	 */
	@Override
	public int borrowBlueRay(int client, String title, int yearOfPublication) { //Follows same logic as borrowBook.
		int id  = (title+yearOfPublication).hashCode();
		Publication p = new Publication(id);
		Blueray br = (Blueray)shelves.find(p); 

		if (br.getCurrentOwner() == 0 && (br.isWaitingListEmpty() || br.getNextInLine() == client)) {
			br.setCurrentOwner(client);
			if(! br.isWaitingListEmpty()) {
				br.removeFromWaitingList();
			}	
		}
		else {
			try {
				VIPClient test = (VIPClient) clientList.get(client - 1);
				br.addToWaitingList(client, 0);
			}
			catch(ClassCastException e) {
				br.addToWaitingList(client, 1);
			}
		}
		return id;
	}

	/**
	 * Method to borrow a CD
	 * @param client id of client who is borrowing the CD.
	 * @param author author of the CD
	 * @param title title of the CD
	 * @return id of the book
	 */
	@Override
	public int borrowCD(int client, String author, String title) { //Follows same logic as borrowBook.
		int id  = (author+title).hashCode();
		Publication p = new Publication(id);
		CD c = (CD)shelves.find(p); 

		if (c.getCurrentOwner() == 0 && (c.isWaitingListEmpty() || c.getNextInLine() == client)) {
			c.setCurrentOwner(client);
			if(! c.isWaitingListEmpty()) {
				c.removeFromWaitingList();
			}	
		}
		else {
			try {
				VIPClient test = (VIPClient) clientList.get(client - 1);
				c.addToWaitingList(client, 0);
			}
			catch(ClassCastException e) {
				c.addToWaitingList(client, 1);
			}
		}
		return id;
	}

	/**
	 * Method to return a publication, i.e set publication owner id back to 0.
	 * @param publicationID publication id to return.
	 * @return id of the next in line client
	 */
	@Override
	public int returnItem(int publicationID) {
		Publication p = new Publication(publicationID); //Dummy publication with id to search for.
		Publication pf = shelves.find(p); //Find the publication in the tree.
		int nextInLine = -1; // Return this if there is no one in the waiting list.
		if(!pf.isWaitingListEmpty()) {
			nextInLine = pf.getNextInLine();
		}
		pf.setCurrentOwner(0);
		return nextInLine;
	}

}
