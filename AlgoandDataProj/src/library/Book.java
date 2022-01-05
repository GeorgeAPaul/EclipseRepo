package library;
/**
 * Class to represent a Book in the library.
 * 
 * @author George Paul
 *
 */
public class Book extends Publication {
	
	/**
	 *  Name of the author.
	 */
	private String author;

	/**
	 * Constructor method inherited from Publication.
	 * @param id Unique id of the Book, is determined externally in the Library class.
	 * @param title Title of the Book.
	 * @param yearOfPub Year that the Book was published.
	 * @param author Name of the author.
	 * @param sectionName The name of the section that Book is added to
	 */
	public Book(int id, String title, int yearOfPub, String author, String sectionName) {
		super(id, title, yearOfPub, sectionName);
		this.author = author;	
	}
	
	/**
	 * Returns contents of Book as a formatted String.  
	 */
	@Override
	public String toString() {
		return "Book" + super.toString() + ", Author: " + this.author + "]";
	}

}
