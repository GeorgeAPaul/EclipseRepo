
public abstract class AbstractClient {
	
	private int id;
	private String name;
	private String email;
	
	public AbstractClient(int id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;	
	}
	
	public String toString() {
		return "[" + this.id + ", " + this.name + ", " + this.email + "]";
	}

}
