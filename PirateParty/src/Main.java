import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		int mapWidth = 5;
		int noOfEnemies = 3;
		int noOfAllies = 3;
		Scanner sc = new Scanner(System.in);
		Character c = null;
		Player p = null;
		
		//Generate Map
		Map m = new Map(mapWidth, noOfEnemies, noOfAllies);
		p = m.getPlayer();
		
		
		//Play loop
		while(true) {
			System.out.println(m.toString(true, true));
			System.out.println("Player location marked as P, enemies are E");
			System.out.println("Try moving around (north, south, east, west)");
			String l = sc.nextLine();
			try {
				if(l.matches("(?i).*[n][o][r][t][h].*")) {
					c = m.setPlayerLocation(m.getPlayerLocation()[0] - 1, m.getPlayerLocation()[1]);
				}
				else if(l.matches("(?i).*[s][o][u][t][h].*")) {
					c = m.setPlayerLocation(m.getPlayerLocation()[0] + 1, m.getPlayerLocation()[1]);
				}
				else if(l.matches("(?i).*[e][a][s][t].*")) {
					c = m.setPlayerLocation(m.getPlayerLocation()[0], m.getPlayerLocation()[1] + 1);
				}
				else if(l.matches("(?i).*[w][e][s][t].*")) {
					c = m.setPlayerLocation(m.getPlayerLocation()[0], m.getPlayerLocation()[1] - 1);
				}
				else if(l.matches("(?i).*[l][o][o][k].*")) {
					System.out.println("You cast your eye about and see...");
					System.out.println(m.getVisibleItems());
				}
			}
			catch(IndexOutOfBoundsException e) {
				
				System.out.println("You feel as if that's the wrong way, maybe you've reached an edge of some sort?");
			}
			
			if(c != null) {
	
				try {
					Enemy e = (Enemy)c;
					Encounter en = new Encounter(p, e);
					c = null;
				}
				catch(ClassCastException e) {
					Ally a = (Ally)c;
					Encounter en = new Encounter(p, a);
					c = null;
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
