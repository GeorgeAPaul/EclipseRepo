package library;
import dataStructures.PriorityQueue;

/**
 * Abstract class to represent publications held in a library. Implements Comparable so that Publications can be
 * sorted/searched.
 * 
 * @author George Paul
 *
 */
public class Publication implements Comparable<Publication> {
	
	/**
	 * Title of publication.
	 */
	private String title;
	
	/**
	 * Year that the publication was published.
	 */
	private int yearOfPub;
	
	/**
	 * Unique id of the publication in the library.
	 */
	private final int id;
	
	/**
	 * Waiting list for publication, Priority Queue to allow for special treatment of VIPClients.
	 */
	private PriorityQueue<Integer,Integer> waitingList;
	
	/**
	 * Current owner
	 */
	private int currentOwner;
	
	private String sectionName;
	
	/**
	 * Constructor method
	 * @param id Unique id of the Blueray, is determined externally in the Library class.
	 * @param title Title of Publication
	 * @param yearOfPub Year that the Publication was published.
	 * @param sectionName The name of the section that Publication is added to
	 */
	public Publication(int id, String title, int yearOfPub, String sectionName) {
		this.title = title;
		this.yearOfPub = yearOfPub;
		this.id = id;
		waitingList = new PriorityQueue<Integer,Integer>();
		this.sectionName = sectionName;
	}
	
	/**
	 * Returns contents of Publication as a formatted String.  
	 */
	public String toString() {
		return "-" + this.id + ": [Title: " + this.title + ", Year of Publication: " + this.yearOfPub;
	}
	
	/**
	 * Getter method to return the id of the publication.
	 * @return id of publication.
	 */
	public int getId() {
		return this.id;
	}
	
	/**
	 * Method for comparing publications, for sorting/searching.
	 * @param pub Publication to be compared to.
	 * @return Negative int if class publication id is smaller than compared publication id. Positive if greater, 0 if equal.
	 */
	public int compareTo(Publication pub) {	
		return this.id - pub.getId(); 
	}
	
	/**
	 * Method for pushing a client id onto the waiting list
	 * @param id Client id.
	 * @param priority 0 for VIPClients, 1 for Clients.
	 */
	public void addToWaitingList(int id, int priority) {
		waitingList.push(id, priority);
	}
	
	/**
	 * Method to remove the next in line on the waiting list and return their id.
	 * @return id of the client.
	 */
	public int removeFromWaitingList() {	
		return waitingList.pop();
		
	}
	
	/**
	 * Method to return the next in line from the waiting list.
	 * @return id of the next in line client.
	 */
	public int getNextInLine() {
		return waitingList.top();
	}
	
	/**
	 * Method to check whether the waiting list is empty.
	 * @return true if waiting list is empty, else false.
	 */
	public boolean isWaitingListEmpty() {
		return waitingList.isEmpty();
	}
	
	/**
	 * Method to return the current owner of the publication.
	 * @return id of the current owner.
	 */
	public int getCurrentOwner() {	
		return currentOwner;
	}
	
	/**
	 * Method to set the current owner of the the publication
	 * @param newOwner Client id of the new owner.
	 */
	public void setCurrentOwner(int newOwner) {
		this.currentOwner = newOwner;
	}
	
	/**
	 * Method to borrow a publication add clients to waiting list depending on client priority and who is in waitinglist
	 * @param client id of client that wants to borrow publication
	 * @param priority priority specifying whether they are VIP or normal client
	 */
	public void borrow(int client, int priority) {
		
		//If no one currently owns the book and client/no one is next in line, allow client to borrow book. Else add client to waiting list.
		if (getCurrentOwner() == 0 && (isWaitingListEmpty() || getNextInLine() == client)) {
			setCurrentOwner(client);
			if(!isWaitingListEmpty()) { // If waiting list was not empty remove client from waiting list as they now have the book.
				removeFromWaitingList();
			}	
		}			
		else {
			addToWaitingList(client, priority);
		}
	}
	
	/**
	 * Method to return the name of the section that the Publication is in
	 * @return sectionName name of the section that the Publication is in
	 */
	public String getSection() {
		return sectionName;
	}
}
