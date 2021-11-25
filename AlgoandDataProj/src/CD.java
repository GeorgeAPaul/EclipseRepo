
public class CD extends Book {

	public CD(int id, String title, int yearOfPub, String author) {
		super(id, title, yearOfPub, author);
	}

	public String toString() {
		String pubString = super.toString();
		return "CD" + pubString.substring(4, pubString.length());
	}
}
