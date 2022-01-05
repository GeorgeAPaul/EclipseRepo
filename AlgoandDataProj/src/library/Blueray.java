package library;
/**
 * Class to represent a Blueray in the library.
 * 
 * @author George Paul
 *
 */
public class Blueray extends Publication {

	/**
	 * Constructor method inherited from Publication.
	 * @param id Unique id of the Blueray, is determined externally in the Library class.
	 * @param title Title of Blueray
	 * @param yearOfPub Year that the Blueray was published.
	 * @param sectionName The name of the section that Blueray is added to
	 */
	public Blueray(int id, String title, int yearOfPub, String sectionName) {
		super(id, title, yearOfPub, sectionName);
	}

	/**
	 * Returns contents of Blueray as a formatted String.  
	 */
	@Override
	public String toString() {
		return "Blueray" + super.toString() + "]";
	}

	
}
