/**
 * Interface for defining the methods needed for any attackable object in the game.
 * 
 * @author George Paul
 *
 */
public interface Attackable {
	
	/**
	 * Method for doing damage to the character
	 * 
	 * @param attackPower amount of damage to be dealt
	 */
	public void takeDamage(int attackPower);
	
	/**
	 * Method for adjusting the characters defence.
	 * 
	 * @param adjustment How much to adjust the defence by
	 */
	public void adjustDefence(int adjustment);
	
	/**
	 * Method for setting the defence of the character.
	 * 
	 * @param defence desired new defence.
	 */
	public void setDefence(int defence);
	
	/**
	 * Method for attacking other characters
	 * 
	 * @param enemy Enemy to be attacked
	 * @param attackPower Attack power to use (in case using weapon)
	 */
	public void attack(Character enemy, int attackPower);
	
	/**
	 * Useless method for increasing the enemies defence.
	 * 
	 * @param enemy Target enemy
	 */
	public void cry(Character enemy);
	
	/**
	 * Method for decreasing the enemies defence.
	 * 
	 * @param enemy Target enemy
	 */
	public void warCry(Character enemy);
	
	/**
	 * Method for returning health of character.
	 * 
	 * @return health of character
	 */
	public int getHealth();
	
	/**
	 * Method for returning the characters atackPower
	 * 
	 * @return attackPower The attack power of the character
	 */
	public int getAttackPower();
	
	/**
	 * Method for setting the attack power of the character.
	 * 
	 * @param attackPower desired new attack power.
	 */
	public void setAttackPower(int attackPower);
	

}
