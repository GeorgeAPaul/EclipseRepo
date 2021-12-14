
public interface Attackable {
	
	public void takeDamage(int attackPower);
	
	public void adjustDefence(int adjustment);
	
	public void attack(Character e);
	
	public void cry(Character e);
	
	public void warCry(Character e);
	
	public int getHealth();
	

}
