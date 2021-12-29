
public class Character extends GameObject implements Attackable{
	
	private int health;
	private int attackPower;
	private int defence;
	
	
	public Character() {
		super();
		health = 100;
	}

	@Override
	public void takeDamage(int attackPower){
		int damage = attackPower/defence;
		System.out.println( damage + " damage inflicted!");
		health -= damage;
		
	}

	@Override
	public void attack(Character e, int attackPower) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		e.takeDamage(attackPower);
	}

	@Override
	public void cry(Character e) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		System.out.println("Enemy is emboldended by your pathetic wailing...");
		System.out.println("Enemy defence up!");
		e.adjustDefence(-1);	
	}

	@Override
	public void warCry(Character e) {
		System.out.println("WAARRARAGARHHARHARHARH!!!!!!!!!");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		System.out.println("Looks like you scared them!");
		System.out.println("Enemy defence down!");
		e.adjustDefence(1);
		
	}

	@Override
	public int getHealth() {
		return health;
	}
	
	@Override
	public void adjustDefence(int adjustment) {
		defence -= adjustment;
		if(defence < 1) {
			System.out.println("They can't get any more scared of you!");
			defence++;
		}
	}
	
	public int getAttackPower() {
		return attackPower;
	}

	@Override
	public void setAttackPower(int attackPower) {
		this.attackPower = attackPower;
	}

	@Override
	public void setDefence(int defence) {
		this.defence = defence;
	}
}
