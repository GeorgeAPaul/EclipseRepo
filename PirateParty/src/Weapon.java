/**
 * Class to represent Weapons in the game
 * 
 * @author George Paul
 *
 */
public class Weapon extends Item {

	/**
	 * Represents how much damage the weapon does.
	 */
	private int damage;
	
	/**
	 * List of possible weapons in the game, used for assigning damage when weapon is created.
	 */
	private String[] weaponList = {"Sword", "Gun", "Sausage", "Bow", "Whip", "Bazooka"};
	//Not ideal as this list of weapons needs to be updated here and in map class.
	
	/**
	 * List of possible weapon damages in the game, used for assigning damage when weapon is created.
	 */
	private int[] weaponDamageList = {50, 90, 0, 75, 20, 500};
	
	
	/**
	 * Constructor method
	 * 
	 * @param name of weapon
	 */
	public Weapon(String name) {
		super(name);
		
		for(int i = 0; i < weaponList.length; i++) {//Loop over weapon list until weapon found, assign damage
			if(name.equals(weaponList[i])) {
				this.damage = weaponDamageList[i];
				break;
			}
		}
		
		
	}
	
	/**
	 * Method to return damage dealt by weapon
	 * 
	 * @return damage attackPower of weapon
	 */
	public int getDamage() {
		return damage;
	}

}
