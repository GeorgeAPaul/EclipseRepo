/**
 * Abstract class to represent publications held in a library. Implements Comparable so that Publications can be
 * sorted/searched.
 * 
 * @author George Paul
 *
 */
public abstract class Publication implements Comparable<Publication> {
	
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
	 * Constructor method.
	 * @param id Unique id of the publication, is determined externally in the Library class.
	 * @param title Title of publication
	 * @param yearOfPub Year that the publication was published.
	 */
	public Publication(int id, String title, int yearOfPub) {
		this.title = title;
		this.yearOfPub = yearOfPub;
		this.id = id;
	}
	
	/**
	 * Returns contents of Publication as a formatted String.  
	 */
	public String toString() {
		return "-" + this.id + ": [Title: " + this.title + ", Year of Publication: " + this.yearOfPub +"]" + "\n";
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
}
