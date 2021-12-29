/**
 * Class to represent enemies in the game.
 * 
 * @author George Paul
 *
 */
public class Enemy extends Character {
	
	/**
	 * Constructor method
	 */
	public Enemy() {
		super();
		setAttackPower(10); 
		setDefence(2);
	}
	
	/**
	 * toString method that returns a string representation of an ally for the map.
	 * 
	 * @return E
	 */
	public String toString() {
		return "E";
	}

}
