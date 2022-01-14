
/**
 * 
 * @author George Paul
 * 
 * Enum to store the weapons and their attack damages
 *
 */
public enum WeaponList {
	Sword(50), 
	Gun(90), 
	Sausage(0), 
	Bow(75), 
	Whip(20), 
	Bazooka(500);
	
	/**
	 * Amount of damage each weapon does
	 */
	private int attackDamage;
	
	/**
	 * Constructor method
	 * @param damage Damage done to enemy when used
	 */
	WeaponList(int damage) {
        this.attackDamage = damage;
    }
	
	/**
	 * Method to return the weapons attack damage
	 * @return attackDamage Damage done to enemy when used
	 */
	public int getAttackDamage() {
        return attackDamage;
    }

}
