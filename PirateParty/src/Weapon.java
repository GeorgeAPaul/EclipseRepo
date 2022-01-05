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
	 * Constructor method
	 * 
	 * @param name of weapon
	 */
	public Weapon(String name) {
		super(name);
		
		for(WeaponList w : WeaponList.values()) {//Loop over weapon list until weapon found, assign damage
			if(name.equals(w.name())) {
				this.damage = w.getAttackDamage();
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
