
public abstract class Publication implements Comparable<Publication> {
	
	private String title;
	private int yearOfPub;
	private int id;
	
	public Publication(int id, String title, int yearOfPub) {
		this.title = title;
		this.yearOfPub = yearOfPub;
		this.id = id;
	}
	
	public String toString() {
		return "-" + id + ": [Title: " + this.title + ", Year of Publication: " + this.yearOfPub +"]" + "\n";
	}
	
	public int getId() {
		return this.id;
	}
	
	public int compareTo(Publication pub) {	
		return this.id - pub.getId();
	}
}
