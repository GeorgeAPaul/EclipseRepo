/**
 * Class to represent a VIPClient of the library. 
 * 
 * @author George Paul
 *
 */
public class VIPClient extends AbstractClient {
	
	/**
	 * Constructor method inherited from AbstractClient.
	 * @param id Unique id of the VIPclient, is determined externally in the Library class.
	 * @param name VIPClient's name.
	 * @param email VIPClient's email.
	 */
	public VIPClient(int id, String name, String email) {
		super(id, name, email);
	}
	
	/**
	 * Returns contents of VIPClient as a formatted String.  
	 */
	public String toString() {
		String pubString = super.toString();
		return "VIPClient" + pubString;
	}

}
