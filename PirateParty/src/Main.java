import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		int mapWidth = 10;
		int noOfEnemies = 3;
		int noOfAllies = 3;
		Scanner sc = new Scanner(System.in);
		Character c = null;
		Player p = null;
		
		//Generate Map
		Map m = new Map(mapWidth, noOfEnemies, noOfAllies);
		p = m.getPlayer();
		
		System.out.println(m.toString(true, true));
		
		System.out.println("Player location marked as P, enemies are E");
		//Play loop
		while(true) {
			System.out.println("Try moving around (north, south, east west)");
			String l = sc.nextLine();
			try {
				if(l.matches(".*[nN][oOT][rRT][tT][hH].*")) {
					c = m.setPlayerLocation(m.getPlayerLocation()[0] - 1, m.getPlayerLocation()[1]);
				}
				else if(l.matches(".*[sS][oOT][uU][tT][hH].*")) {
					c = m.setPlayerLocation(m.getPlayerLocation()[0] + 1, m.getPlayerLocation()[1]);
				}
				else if(l.matches(".*[eE][aA][sS][tT].*")) {
					c = m.setPlayerLocation(m.getPlayerLocation()[0], m.getPlayerLocation()[1] + 1);
				}
				else if(l.matches(".*[wW][eR][sS][tT].*")) {
					c = m.setPlayerLocation(m.getPlayerLocation()[0], m.getPlayerLocation()[1] - 1);
				}
				System.out.println(m.toString(true, true));
				
			}
			catch(IndexOutOfBoundsException e) {
				System.out.println(m.toString(true, true));
				System.out.println("You feel as if that's the wrong way, maybe you've reached an edge of some sort?");
			}
			
			if(c != null) {
	
				try {
					Enemy e = (Enemy)c;
					Encounter en = new Encounter(p, e);
				}
				catch(ClassCastException e) {
					Ally a = (Ally)c;
					Encounter en = new Encounter(p, a);
				}
				
				
				
			}
				

			
		}
		
		
//		System.out.println(m.toString(true, true));
//		
//		m.setPlayerLocation(m.getPlayerLocation()[0] + 1, m.getPlayerLocation()[1]);
//		
//		System.out.println(m.toString(true, true));
//		
//		Player p = new Player();
//		Enemy en = new Enemy();
//		
//		Encounter e = new Encounter(p, en);
		
		
	}
	
	

}
