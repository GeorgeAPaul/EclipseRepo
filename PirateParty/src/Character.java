
public abstract class Character extends GameObject implements Attackable, HasInventory {
	
	private String name;
	private int health;
	private int[] coordinates;
	protected int attackPower;
	
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
	public void takeDamage(int attackPower) {
		health -= attackPower;
		
	}

	@Override
	public void attack(Character e) {
		System.out.println("You attack!");
		e.takeDamage(attackPower);
	}

	@Override
	public void defend() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cry(Character e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void warCry(Character e) {
		System.out.println("WAARRARAGARHHARHARHARH!!!!!!!!!");
		
	}
	
	public int[] getCoordinates() {
		return coordinates;
	}

	@Override
	public int getHealth() {
		return health;
	}
	
	

}
