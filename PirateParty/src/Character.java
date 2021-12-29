/**
 * Base class for all types of character. 
 * 
 * @author George Paul
 *
 */
public class Character extends GameObject implements Attackable{
	
	/**
	 * Health of the character.
	 */
	private int health;
	
	/**
	 * How much damage can the character do in a battle.
	 */
	private int attackPower;
	
	/**
	 * How resistant the character is to damage. When character is attacked, actual damage received is divided by defence.
	 */
	private int defence;
	
	/**
	 * Constructor method, all characters health is set to initial value of 100;
	 */
	public Character() {
		super();
		health = 100;
	}

	/**
	 * Method for doing damage to the character
	 * 
	 * @param attackPower amount of damage to be dealt
	 */
	@Override
	public void takeDamage(int attackPower){
		
		//Damage dealt is divided by defence
		int damage = attackPower/defence;
		System.out.println( damage + " damage inflicted!");
		health -= damage;
		
	}

	/**
	 * Method for attacking other characters
	 * 
	 * @param enemy Enemy to be attacked
	 * @param attackPower Attack power to use (in case using weapon)
	 */
	@Override
	public void attack(Character enemy, int attackPower) {
		
		Helpers.wait(2000);
		enemy.takeDamage(attackPower);
	}

	/**
	 * Useless method for increasing the enemies defence.
	 * 
	 * @param enemy Target enemy
	 */
	@Override
	public void cry(Character enemy) {
		Helpers.wait(2000);
		System.out.println("Enemy is emboldended by your pathetic wailing...");
		System.out.println("Enemy defence up!");
		enemy.adjustDefence(-1);	
	}

	/**
	 * Method for decreasing the enemies defence.
	 * 
	 * @param enemy Target enemy
	 */
	@Override
	public void warCry(Character enemy) {
		System.out.println("WAARRARAGARHHARHARHARH!!!!!!!!!");
		
		Helpers.wait(2000);
		System.out.println("Looks like you scared them!");
		System.out.println("Enemy defence down!");
		enemy.adjustDefence(1);
		
	}

	/**
	 * Method for returning health of character.
	 * 
	 * @return health of character
	 */
	@Override
	public int getHealth() {
		return health;
	}
	
	/**
	 * Method for adjusting the characters defence.
	 * 
	 * @param adjustment How much to adjust the defence by
	 */
	@Override
	public void adjustDefence(int adjustment) {
		defence -= adjustment;
		
		//Defence cannot go lower than 1
		if(defence < 1) {
			System.out.println("They can't get any more scared of you!");
			defence++;
		}
	}
	
	/**
	 * Method for returning the characters atackPower
	 * 
	 * @return attackPower The attack power of the character
	 */
	@Override
	public int getAttackPower() {
		return attackPower;
	}

	/**
	 * Method for setting the attack power of the character.
	 * 
	 * @param attackPower desired new attack power.
	 */
	@Override
	public void setAttackPower(int attackPower) {
		this.attackPower = attackPower;
	}

	/**
	 * Method for setting the defence of the character.
	 * 
	 * @param defence desired new defence.
	 */
	@Override
	public void setDefence(int defence) {
		this.defence = defence;
	}
}
