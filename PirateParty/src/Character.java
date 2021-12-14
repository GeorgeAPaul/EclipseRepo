
public abstract class Character extends GameObject implements Attackable, HasInventory  {
	
	private String name;
	private int health;
	private int[] coordinates;
	protected int attackPower;
	protected int defence;
	
	public Character() {
		health = 100;
	}

	public void take(Item i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drop(Item i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void use(Item i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void takeDamage(int attackPower){
		int damage = attackPower/defence;
		System.out.println( damage + " damage inflicted!");
		health -= damage;
		
	}

	@Override
	public void attack(Character e) {
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
		e.adjustDefence(-1);
		
	}

	@Override
	public void warCry(Character e) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		System.out.println("WAARRARAGARHHARHARHARH!!!!!!!!!");
		System.out.println("Looks like you scared them!");
		System.out.println("Enemy defence down!");
		e.adjustDefence(1);
		
	}
	
	public int[] getCoordinates() {
		return coordinates;
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
	
	

}
