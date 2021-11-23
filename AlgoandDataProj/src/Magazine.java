
public class Magazine extends Publication{
	
	private int issue;
	
	public Magazine(int id, String title, int yearOfPub, int issue) {
		super(id, title, yearOfPub);
		this.issue = issue;
	}

	@Override
	public String toString() {
		String pubString = super.toString();
		return "Magazine" + pubString.substring(0,pubString.length() - 1) + ", " + this.issue + "]";
	}

}
