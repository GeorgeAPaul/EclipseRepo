
public class Book extends Publication {
	
	private String author;

	public Book(int id, String title, int yearOfPub, String author) {
		super(id, title, yearOfPub);
		this.author = author;	
	}
	
	@Override
	public String toString() {
		String pubString = super.toString();
		return "Book" + pubString.substring(0,pubString.length() - 2) + ", Author: " + this.author + "]" + "\n";
	}

}
