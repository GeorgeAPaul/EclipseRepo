public class Library implements ILibraryManagement {
	
	private Object[] shelves;
	private Object[] clientList;

	private int noOfPublications;
	private int noOfClients;

	public Library(int shelfSpace, int clientSpace) {
			
		shelves = new Publication[shelfSpace];
		clientList = new AbstractClient[clientSpace];
		
		noOfPublications = 0;
		
	}
	
	private void extendCapacity(Object[] list) {
		
		Object[] list2 = new Object[2 * list.length];
		
		for(int i = 0; i < list.length; i++) {
			
			list2[i] = list[i];
		}
		if (list instanceof Publication[]) {
			shelves = list2;
		}
		
		if (list instanceof AbstractClient[]) {
			clientList = list2;
		}
	
	}
	
	private void add(Object o) {
		
		if(o instanceof Publication) {
			if(noOfPublications == shelves.length) {
			
				extendCapacity(shelves);
				shelves[noOfPublications] = o;
			}
			else {
			
				shelves[noOfPublications] = o;
			}
			noOfPublications++;
		}
		
		if(o instanceof AbstractClient) {
			if(noOfClients == clientList.length) {
			
				extendCapacity(clientList);
				clientList[noOfClients] = o;
			}
			else {
			
				shelves[noOfClients] = o;
			}
			noOfClients++;
		}
		
	}
	
	@Override
	public int addBook(String author, String title, int yearOfPublication) {
		
		Book b = new Book(noOfPublications, title, yearOfPublication, author);
		add(b);
		
		return noOfPublications - 1;
	}

	@Override
	public int addMagazine(String title, int yearOfPublication, int issue) {
		Magazine m = new Magazine(noOfPublications, title, yearOfPublication, issue);
		add(m);
		return noOfPublications - 1;
	}

	@Override
	public int addBlueRay(String title, int yearOfPublication) {
		Blueray br = new Blueray(noOfPublications, title, yearOfPublication);
		add(br);
		return noOfPublications - 1;
	}

	@Override
	public int addCD(String author, String title, int yearOfPublication) {
		Book b = new Book(noOfPublications, title, yearOfPublication, author);
		add(b);
		return noOfPublications - 1;
	}

	@Override
	public int addClient(String name, String email) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addVIPClient(String name, String email) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void printAllPublications() {
		for(int i = 0; i < noOfPublications; i++) {
			System.out.println(shelves[i]);
		}
		
	}

	@Override
	public void printAllClients() {
		for(int i = 0; i < noOfClients; i++) {
			System.out.println(clientList[i]);
		}
		
	}

}
