/**
 * Class to represent locations in the game.
 * 
 * @author George Paul
 *
 */
public class Location extends GameObject {
	
	/**
	 * Represents whether location is sea
	 */
	private boolean isSea;
	
	/**
	 * Constructor method
	 */
	public Location() {
		super();
		
		int decide = (int)(Math.random() + 0.5); //Location is randomly set to sea or land
		if(decide == 1) {
			isSea = true;
		}
		else {
			isSea = false;
		}
		
	}
	
	/**
	 * Method to return isSea flag
	 * 
	 * @return isSea whether Location is sea
	 */
	public boolean getIsSea() {
		return isSea;
	}
	
	/**
	 * Method to set isSea flag
	 * 
	 * @param isSea whether Location is sea
	 */
	public void setIsSea(boolean isSea) {
		this.isSea = isSea;
	}
	
	/**
	 * toString method to return string representation of Location for map
	 * 
	 * @return "~ ~" or "< >"
	 */
	public String toString() {
		if(isSea) {
			return "~ ~";
		}
		return "< >";		
	}

}
