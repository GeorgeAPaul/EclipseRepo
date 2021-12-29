/**
 * Class to represent allies in the game.
 * 
 * @author George Paul
 *
 */
public class Ally extends Character {
	
	/**
	 * Constructor method
	 */
	public Ally() {
		super();
		setAttackPower((int)(Math.random()*20)); //Set attack power randomly between 0 and 20.
	}
	
	/**
	 * toString method that returns a string representation of an ally for the map.
	 * 
	 * @return A
	 */
	public String toString() {
		return "A";
	}

}
