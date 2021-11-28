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
	private Vector<Publication> shelves;
	
	/**
	 * Vector to represent the list of clients of the Library. Vector was chosen for same reason as publications.
	 */
	private Vector<AbstractClient> clientList;
	
	/**
	 * int to represent the next available id for publications.  
	 */
	private int nextAvailablePubId;
	
	/**
	 * int to represent the next available id for clients.  
	 */
	private int nextAvailableClientId;

	/**
	 * Constructor method.
	 * @param shelfSpace the initial number of spaces on the shelves available to hold publications.
	 * @param clientSpace the initial space on the client list available to hold clients.
	 */
	public Library(int shelfSpace, int clientSpace) {
			
		shelves = new Vector<Publication>(shelfSpace);
		clientList = new Vector<AbstractClient>(clientSpace);
		nextAvailablePubId = 1; // Initialising the ids for first publication and client.
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
		
		Book b = new Book(nextAvailablePubId, title, yearOfPublication, author); // Instantiating book object
		shelves.addLast(b); // Adding book to shelves, 
		nextAvailablePubId++; // Incrementing so that the next Publication will have a correct id.
		
		return nextAvailablePubId - 1; // Return's id of added Book.
	}

	/**
	 * Method to add a Magazine to the Library
	 * @param title Title of the magazine
	 * @param yearOfPublication Year the magazine was published
	 * @param issue Issue number of the magazine
	 */
	@Override
	public int addMagazine(String title, int yearOfPublication, int issue) { // Follows same logic as addBook.
		
		Magazine m = new Magazine(nextAvailablePubId, title, yearOfPublication, issue);
		shelves.addLast(m);
		nextAvailablePubId++;
		
		return nextAvailablePubId - 1;
	}

	/**
	 * Method to add a Blueray to the Library
	 * @param title Title of the Blueray
	 * @param yearOfPublication Year the Blueray was published
	 */
	@Override
	public int addBlueRay(String title, int yearOfPublication) { // Follows same logic as addBook.
		
		Blueray br = new Blueray(nextAvailablePubId, title, yearOfPublication);
		shelves.addLast(br);
		nextAvailablePubId++;
		
		return nextAvailablePubId - 1;
	}

	/**
	 * Method to add a CD to the Library
	 * @param author Name of the artist
	 * @param title Title of the CD
	 * @param yearOfPublication Year the CD was published
	 */
	@Override
	public int addCD(String author, String title, int yearOfPublication) { // Follows same logic as addBook.
		
		CD b = new CD(nextAvailablePubId, title, yearOfPublication, author);
		shelves.addLast(b);
		nextAvailablePubId++;
		
		return nextAvailablePubId - 1;
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
		
		return nextAvailableClientId - 1;
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
		
		return nextAvailableClientId - 1;
	}

	/**
	 * Method to prettily print all Publications in the Library.
	 */
	@Override
	public void printAllPublications() {
		
		String outString = shelves.toString();
		System.out.println(outString.substring(1, outString.length() -2));
	}

	/**
	 * Method to prettily print all Clients of the Library.
	 */
	@Override
	public void printAllClients() {
		
		String outString = clientList.toString();
		System.out.println(outString.substring(1, outString.length() -2));
	}

}
