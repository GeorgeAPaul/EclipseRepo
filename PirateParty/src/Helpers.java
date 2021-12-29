
/**
 * Class to store helper methods.
 * 
 * @author George Paul
 *
 */
public class Helpers {
	
	/**
	 * Method to pause program for specified waitime.
	 * @param waitTime Time to wait in ms.
	 */
	public static void wait(int waitTime) {
		try {
			Thread.sleep(waitTime);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}
}
