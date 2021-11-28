
public abstract class AbstractClient implements Comparable<AbstractClient> {
	
	private int id;
	private String name;
	private String email;
	
	public AbstractClient(int id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;	
	}
	
	public String toString() {
		return "-" + id + ": " + "[" + this.name + ", " + this.email + "]" + "\n";
	}
	
	public int compareTo(AbstractClient client) {	
		return this.id - client.id;
	}

}
