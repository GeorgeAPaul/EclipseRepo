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
	
	/**
	 * Constructor method.
	 * @param id Unique id of the publication, is determined externally in the Library class.
	 * @param title Title of publication
	 * @param yearOfPub Year that the publication was published.
	 */
	public Publication(int id, String title, int yearOfPub) {
		this.title = title;
		this.yearOfPub = yearOfPub;
		this.id = id;
		waitingList = new PriorityQueue<Integer,Integer>();
	}
	
	/**
	 * Constructor method for creating dummy publications for use when searching the shelves in the library.
	 * @param id id to search for
	 */
	public Publication(int id) {
		this.id = id;
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
		//System.out.println(waitingList);
		this.currentOwner = newOwner;
	}
}
