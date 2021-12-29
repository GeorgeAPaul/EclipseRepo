
/**
 * Class to represent the player
 * 
 * @author George Paul
 *
 */
public class Player extends Character {
	
	/**
	 * For holding list of recruited allies.
	 */
	private Ally[] allies;
	
	/**
	 * Keeps track of how many allies have been recruited.
	 */
	private int noOfRecruitedAllies;
	
	/**
	 * Constructor method
	 * 
	 * @param noOfAllies Ensures ally array is the right size for number of allies in the game.
	 */
	public Player(int noOfAllies){
		
		super();
		setAttackPower(30);
		setDefence(1);
		
		allies = new Ally[noOfAllies];
		
		setInventory(new Item[3]); //Inventory for player is limited to only 3 items
	}
	
	/**
	 * Method to add allis to the player's recruited ally array.
	 * 
	 * @param ally Ally to add to ally recruited ally array
	 */
	public void addAlly(Ally ally) {
		allies[noOfRecruitedAllies] = ally;
		noOfRecruitedAllies++;
	}
	
	/**
	 * Method to return all recruited allies
	 * 
	 * @return all recruited allies
	 */
	public Ally[] getAllies() {
		return allies;
	}
	
	/**
	 * toString method that returns a string representation of a player for the map.
	 * 
	 * @return P
	 */
	public String toString() {
		return "P";
	}

}
