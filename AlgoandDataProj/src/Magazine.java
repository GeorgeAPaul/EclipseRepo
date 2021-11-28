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
	 */
	public Magazine(int id, String title, int yearOfPub, int issue) {
		super(id, title, yearOfPub);
		this.issue = issue;
	}

	/**
	 * Returns contents of Magazine as a formatted String.  
	 */
	@Override
	public String toString() {
		String pubString = super.toString();
		return "Magazine" + pubString.substring(0,pubString.length() - 2) + ", Issue: " + this.issue + "]" + "\n";
	}

}
