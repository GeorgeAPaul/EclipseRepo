
public class Client extends AbstractClient {
	
	public Client(int id, String name, String email) {
		super(id, name, email);
	}
	
	public String toString() {
		String pubString = super.toString();
		return "Client" + pubString;
	}

}
