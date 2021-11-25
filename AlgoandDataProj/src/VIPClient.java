
public class VIPClient extends AbstractClient {
	
	public VIPClient(int id, String name, String email) {
		super(id, name, email);
	}
	
	public String toString() {
		String pubString = super.toString();
		return "VIPClient" + pubString;
	}

}
