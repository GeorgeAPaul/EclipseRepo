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
	 * Waiting list for publication
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
	
	public void addToWaitingList(int id) {	
		waitingList.push(id, 1);
	}
	
	public void removefromWaitingList() {	
		waitingList.pop();
	}
	
	public Integer getNextInLine() {
		//System.out.println(waitingList);
		if (waitingList.isEmpty()) {
			return -1;
		}
		return waitingList.top();
	}
	
	public int getCurrentOwner() {	
		return currentOwner;
	}
	
	public void setCurrentOwner(int newOwner) {	
		this.currentOwner = newOwner;
	}
}
