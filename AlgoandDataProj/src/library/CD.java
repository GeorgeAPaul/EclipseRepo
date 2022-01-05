package library;
/**
 * Class to represent a CD in the library. Same required fields as Book so extends Book.
 * 
 * @author George Paul
 *
 */
public class CD extends Book {

	/**
	 * Constructor method inherited from Book.
	 * @param id Unique id of the CD, is determined externally in the Library class.
	 * @param title Title of the CD.
	 * @param yearOfPub Year that the CD was published.
	 * @param author Name of the author.
	 * @param sectionName The name of the section that CD is added to
	 */
	public CD(int id, String title, int yearOfPub, String author, String sectionName) {
		super(id, title, yearOfPub, author, sectionName);
	}

	/**
	 * Returns contents of CD as a formatted String.  
	 */
	@Override
	public String toString() {
		String pubString = super.toString();
		return "CD" + pubString.substring(4, pubString.length());
	}
}
