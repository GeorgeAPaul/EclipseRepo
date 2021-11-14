
public class Character implements Attackable, HasInventory {
	
	private String name;
	private int health;
	private int[] coordinates;
	
	public Character() {
		
		coordinates = new int[] {1,2};
	}

	@Override
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
	public void takeDamage() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void defend() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cry() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void warCry() {
		// TODO Auto-generated method stub
		
	}
	
	public int[] getCoordinates() {
		return coordinates;
	}
	

}
