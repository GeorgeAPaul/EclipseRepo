/**
 * Class to represent a Library. The shelves and the clients are represented and there are methods to add publications/clients
 * to the library. 
 * 
 * @author George Paul
 *
 */
public class Library implements ILibraryManagement {
	
	/**
	 * Vector to represent the shelves of the Library. Vector was chosen as search is faster when data is sorted.
	 * Since the only way to add publications is via addLast, publications will inherently be sorted by id.
	 */
	private Tree<Publication> shelves;
	
	/**
	 * Vector to represent the list of clients of the Library. Vector was chosen for same reason as publications.
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
		int id = (author+title).hashCode();
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
	 */
	@Override
	public int borrowBook(int client, String author, String title) {
		int id  = (author+title).hashCode();
		Publication p = new Publication(id);
		Book b = (Book)shelves.find(p);
		
		if (b.getCurrentOwner() == 0 && (b.isWaitingListEmpty() || b.getNextInLine() == client)) {
			b.setCurrentOwner(client);
			if(! b.isWaitingListEmpty()) {
				b.removeFromWaitingList();
			}	
		}
		else {
			try {
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
	 */
	@Override
	public int lookAtMagazine(int client, String title, int yearOfPublication, int issue) {
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
	 */
	@Override
	public int borrowBlueRay(int client, String title, int yearOfPublication) {
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
	 */
	@Override
	public int borrowCD(int client, String author, String title) {
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
	 * Method to return a publication
	 */
	@Override
	public int returnItem(int publicationID) {
		Publication p = new Publication(publicationID);
		Publication pf = shelves.find(p);		
		int nextInLine = -1;
		try {
			nextInLine = pf.getNextInLine();
		}
		catch(NullPointerException n){
			//Do nothing
		}
		System.out.println(pf.getCurrentOwner());
		pf.setCurrentOwner(0);
		return nextInLine;
	}

}
