/**
 * Class to represent storable items in the game
 * 
 * @author George Paul
 *
 */
public class Item extends GameObject {
	
	/**
	 * Constructor method
	 * @param name name of item
	 */
	public Item(String name) {
		setName(name);
	}

	/**
	 * toString method that returns the name of the item
	 * 
	 * @return name of item
	 */
	@Override
	public String toString() {
		return getName();
		
	}

}
