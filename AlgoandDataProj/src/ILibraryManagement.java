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

	/******************************************** PART 2 ***************************************************/ 

	/* 
	 * Borrow a book.  
	 *  
	 * @param client id
	 * @param author's name 
	 * @param title of the book 
	 * @return ID of the book 
	 */ 
	public int borrowBook(int client, String author, String title); 

	/* 
	 * Borrow a magazine to look at.  
	 *  
	 * @param client id
	 * @param title of the magazine 
	 * @param year of the publication 
	 * @param issue  
	 *  
	 * @return ID of the magazine 
	 */ 
	public int lookAtMagazine(int client, String title, int yearOfPublication, int issue); 

	/* 
	 * Borrow a movie on a BlueRay.  
	 *  
	 * @param client id	 
	 * @param title of the magazine 
	 * @param year of the publication 
	 *  
	 * @return ID of the BlueRay 
	 */ 
	public int borrowBlueRay(int client, String title, int yearOfPublication); 
	 
	/* 
	 * Borrow a CD.  
	 *  
	 * @param client id 
	 * @param author's name 
	 * @param title of the CD 
	 *  
	 * @return ID of the CD 
	 */ 
	public int borrowCD(int client, String author, String title); 
	 

	/* 
	 * Return the publication back to the library.  
	 *  
	 * @param publicationID unique id of the publication  
	 * @return client ID of the next client the waiting list that borrowed the publication. Return -1 if no client was waiting.  
	 */ 
	public int returnItem(int publicationID); 
	/******************************************** end of PART 2 ***************************************************/ 
}