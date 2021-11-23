public interface ILibraryManagement {

	
	/******************************************** PART 1 ***************************************************/
	/*
	 * Add a new book with given parameters - author's name, title of the book,
	 * and year of publication - to the library management system. 
	 * 
	 * @param author - author's name
	 * @param title of the book
	 * @param year of the publication of the book 
	 * @return ID of the book
	 */
	public int addBook(String author, String title, int yearOfPublication);
	
	
	/*
	 * Add a new magazine with given parameters - title, year and issue 
	 * of publication - to the library management system. 
	 * 
	 * @param title or name of the magazine
	 * @param year of publication
	 * @param issue of the magazine 
	 * @return ID of the magazine
	 */
	public int addMagazine(String title, int yearOfPublication, int issue);
	
	
	/*
	 * Add a new BlueRay with given parameters - title, year of publication
	 * - to the library management system. 
	 * 
	 * @param title or name of the movie
	 * @param year of publication
	 * @return ID of the BlueRay
	 */
	public int addBlueRay(String title, int yearOfPublication);
	
	/*
	 * Add a new CD with given parameters - author, title, year of publication
	 * - to the library management system. 
	 * 
	 * @param author's name
	 * @param title or name of the CD
	 * @param year of publication
	 * @return ID of the CD
	 */
	public int addCD(String author, String title, int yearOfPublication);
	
	/*
	 * Add a new client with given parameters - name and email address
	 * - to the library management system. 
	 * 
	 * @param client's name
	 * @param client's email address
	 * @return ID of the Client
	 */
	public int addClient(String name, String email);
	
	/*
	 * Add a new VIP client with given parameters - name and email address
	 * - to the library management system. 
	 * 
	 * @param client's name
	 * @param client's email address
	 * @return ID of the VIP Client
	 */
	public int addVIPClient(String name, String email);
	
	
	/*
	 * Print all publications existing in the library management system. 
	 */
	public void printAllPublications();
	
	
	/*
	 * Print all clients registered in the library management system. 
	 */
	public void printAllClients();
	
	/******************************************** end of PART 1 ***************************************************/
	

}
