public class Library implements ILibraryManagement {
	
	private Vector<Publication> shelves;
	private Vector<AbstractClient> clientList;
	private int nextAvailablePubId;
	private int nextAvailableClientId;

	public Library(int shelfSpace, int clientSpace) {
			
		shelves = new Vector<Publication>(shelfSpace);
		clientList = new Vector<AbstractClient>(clientSpace);
		nextAvailablePubId = 0;
		nextAvailableClientId = 0;
		
	}
	
	@Override
	public int addBook(String author, String title, int yearOfPublication) {
		
		Book b = new Book(nextAvailablePubId, title, yearOfPublication, author);
		shelves.addLast(b);
		nextAvailablePubId++;
		
		return nextAvailablePubId - 1;
	}

	@Override
	public int addMagazine(String title, int yearOfPublication, int issue) {
		
		Magazine m = new Magazine(nextAvailablePubId, title, yearOfPublication, issue);
		shelves.addLast(m);
		nextAvailablePubId++;
		
		return nextAvailablePubId - 1;
	}

	@Override
	public int addBlueRay(String title, int yearOfPublication) {
		
		Blueray br = new Blueray(nextAvailablePubId, title, yearOfPublication);
		shelves.addLast(br);
		nextAvailablePubId++;
		
		return nextAvailablePubId - 1;
	}

	@Override
	public int addCD(String author, String title, int yearOfPublication) {
		
		CD b = new CD(nextAvailablePubId, title, yearOfPublication, author);
		shelves.addLast(b);
		nextAvailablePubId++;
		
		return nextAvailablePubId - 1;
	}

	@Override
	public int addClient(String name, String email) {
		
		Client c = new Client(nextAvailableClientId, name, email);
		clientList.addLast(c);
		nextAvailableClientId++;
		
		return nextAvailableClientId - 1;
	}

	@Override
	public int addVIPClient(String name, String email) {
		
		VIPClient v = new VIPClient(nextAvailableClientId, name, email);
		clientList.addLast(v);
		nextAvailableClientId++;
		
		return nextAvailableClientId - 1;
	}

	@Override
	public void printAllPublications() {
		
		String outString = shelves.toString();
		System.out.println(outString.substring(1, outString.length() -2));
	}

	@Override
	public void printAllClients() {
		
		String outString = clientList.toString();
		System.out.println(outString.substring(1, outString.length() -2));
	}

}
