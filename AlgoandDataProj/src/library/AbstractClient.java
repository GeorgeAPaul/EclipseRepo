package library;
/**
 * Abstract class to represent clients of a library. Implements Comparable so that clients can be
 * sorted/searched.
 * 
 * @author George Paul
 *
 */
public abstract class AbstractClient implements Comparable<AbstractClient> {
	
	/**
	 * Unique id of the client.
	 */
	private final int id;
	
	/**
	 * Client's name.
	 */
	private String name;
	
	/**
	 * Client's email.
	 */
	private String email;
	
	
	/**
	 * Constructor method.
	 * @param id Unique id of the client, is determined externally in the Library class.
	 * @param name Client's name.
	 * @param email Client's email.
	 */
	public AbstractClient(int id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;	
	}
	
	/**
	 * Returns contents of Publication as a formatted String.  
	 */
	public String toString() {
		return "-" + this.id + ": " + "[" + this.name + ", " + this.email + "]";
	}
	
	/**
	 * Getter method to return the id of the client.
	 * @return id of publication.
	 */
	public int getId() {
		return this.id;
	}
	
	/**
	 * Method for comparing clients, for sorting/searching.
	 * @param client Client to be compared to.
	 * @return Negative int if class client id is smaller than compared client id. Positive if greater, 0 if equal.
	 */
	public int compareTo(AbstractClient client) {	
		return this.id - client.id;
	}

}
