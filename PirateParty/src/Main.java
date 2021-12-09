public class Main {
	
	public static void main(String[] args) {
		
		int mapWidth = 10;
		int noOfEnemies = 3;
		int noOfAllies = 3;
		
		//Generate Map
		Map m = new Map(mapWidth, noOfEnemies, noOfAllies);
		
		//Generate enemies
		
		System.out.println(m.toString(true, true));
		
		m.setPlayerLocation(m.getPlayerLocation()[0] + 1, m.getPlayerLocation()[1]);
		
		System.out.println(m.toString(true, true));
		
		Player p = new Player();
		Enemy en = new Enemy();
		
		Encounter e = new Encounter(p, en);
		
		
	}
	
	

}
