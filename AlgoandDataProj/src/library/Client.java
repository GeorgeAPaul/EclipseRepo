package library;
/**
 * Class to represent a Client of the library. 
 * 
 * @author George Paul
 *
 */
public class Client extends AbstractClient {
	
	/**
	 * Constructor method inherited from AbstractClient.
	 * @param id Unique id of the client, is determined externally in the Library class.
	 * @param name Client's name.
	 * @param email Client's email.
	 */
	public Client(int id, String name, String email) {
		super(id, name, email);
	}
	
	/**
	 * Returns contents of Client as a formatted String.  
	 */
	public String toString() {
		String pubString = super.toString();
		return "Client" + pubString;
	}

}
