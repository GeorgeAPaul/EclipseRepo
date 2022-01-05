package library;
/**
 * Class to represent a Magazine in the library. 
 * 
 * @author George Paul
 *
 */
public class Magazine extends Publication{
	
	/**
	 * Issue number of the Magazine.
	 */
	private int issue;
	
	/**
	 * Constructor method inherited from Magazine.
	 * @param id Unique id of the Magazine, is determined externally in the Library class.
	 * @param title Title of the Magazine.
	 * @param yearOfPub Year that the Magazine was published.
	 * @param issue Issue number of the Magazine.
	 * @param sectionName The name of the section that Magazine is added to
	 */
	public Magazine(int id, String title, int yearOfPub, int issue, String sectionName) {
		super(id, title, yearOfPub, sectionName);
		this.issue = issue;
	}

	/**
	 * Returns contents of Magazine as a formatted String.  
	 */
	@Override
	public String toString() {
		return "Magazine" + super.toString() + ", Issue: " + this.issue + "]";
	}

}
