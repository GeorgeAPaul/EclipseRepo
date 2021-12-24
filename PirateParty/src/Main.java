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
					boolean empty = true;
					
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					
					Item[] items = m.getItems();
					
					for(int i = 0; i < items.length; i++) {
						Item item = items[i];
						if(item != null) {
							System.out.println(item);
							empty = false;
						}
					}
					if(empty) {
						System.out.println("Nothing!\nMaybe I should go somewhere else?");
					}
				}
				else if(l.matches("(?i).*[t][a][k][e].*")) {
					
					String[] split = l.split(" ");
					Item[] items = m.getItems();
					
					for(int i = 0; i < items.length; i++) {
						if(items[i] != null) {
							if(split[1].matches("(?i)"+items[i].toString())) {
								System.out.println("plop");
								p.addToInventory(m.removeItem(items[i].toString()));
							}
						}
					}
				}
				else if(l.matches("(?i).*[i][n][v][e][n][t][o][r][y].*")) {
					
					System.out.println("You look in your pocket about and see...");
					boolean empty = true;
					
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					
					Item[] items = p.getInventory();
					
					for(int i = 0; i < items.length; i++) {
						Item item = items[i];
						if(item != null) {
							System.out.println(item);
							empty = false;
						}
					}
					if(empty) {
						System.out.println("Nothing!\n");
					}
				}
				else if(l.matches("(?i).*[m][a][p].*")) {
					Item [] inventory =  p.getInventory();
					boolean hasMap = false;
					boolean hasCompass = false;
					for(int i = 0; i < inventory.length; i++)
					{
						if(inventory[i] != null && inventory[i].toString() == "Map")
						{
							hasMap = true;
						}
						if(inventory[i] != null && inventory[i].toString() == "Compass");
						{
							hasCompass = true;
						}
					}
					System.out.println(m.toString(hasMap, hasCompass));
					System.out.println("Player location marked as P, enemies are E");		
				}
			}
			catch(IndexOutOfBoundsException e) {
				
				System.out.println("You feel as if that's the wrong way, maybe you've reached an edge of some sort?");
			}
			
			if(c != null) {
	
				try {
					Enemy e = (Enemy)c;
					Encounter en = new Encounter(p, e, m);
					c = null;
				}
				catch(ClassCastException e) {
					Ally a = (Ally)c;
					Encounter en = new Encounter(p, a, m);
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
