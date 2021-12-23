
public class Player extends Character {
	
	Ally[] allies;
	int noOfRecruitedAllies;
	
	public Player(int noOfAllies){
		super();
		attackPower = 30;
		defence = 1;
		allies = new Ally[noOfAllies];
	}
	
	public void addAlly(Ally a) {
		allies[noOfRecruitedAllies] = a;
		noOfRecruitedAllies++;
	}
	
	public Ally getAlly(int i) {
		return allies[i];
	}
	
	public int getNoOfRecruitedAllies() {
		return noOfRecruitedAllies;
	}
	
	public String toString() {
		return "P";
	}

}
