
public class Player extends Character {
	
	private Ally[] allies;
	private int noOfRecruitedAllies;
	
	public Player(int noOfAllies){
		super();
		setAttackPower(30);
		setDefence(1);
		allies = new Ally[noOfAllies];
		setInventory(new Item[3]);
	}
	
	public void addAlly(Ally a) {
		allies[noOfRecruitedAllies] = a;
		noOfRecruitedAllies++;
	}
	
	public Ally[] getAllies() {
		return allies;
	}
	
	public int getNoOfRecruitedAllies() {
		return noOfRecruitedAllies;
	}
	
	public String toString() {
		return "P";
	}

}
