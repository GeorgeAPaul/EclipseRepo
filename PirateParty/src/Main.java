import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
				
		BufferedReader br; 
		try {
			br = new BufferedReader(new FileReader("Intro.txt"));
			String nextLine = br.readLine();
			while (nextLine != null) {
			      System.out.println(nextLine);
			      nextLine = br.readLine();
			}
			br.close();
		} 
		catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} 	
		catch (IOException e) {
			e.printStackTrace();
		}
		
		int mapWidth = 5;
		int noOfEnemies = 3;
		int noOfAllies = 3;
		Scanner sc = new Scanner(System.in);
		Character c = null;
		Player p = null;
		
		//Generate Map
		Map m = new Map(mapWidth, noOfEnemies, noOfAllies);
		p = m.getPlayer();
		
		String l = sc.nextLine();
		
		while(true) {
			if(l.matches("(?i).*[e][a][s][y].*")) {
				System.out.println("Playing in easy difficulty!");
				p.addToInventory(new Item("Map"));
				p.addToInventory(new Item("Compass"));
				break;
			}
			else if(l.matches("(?i).*[m][e][d][i][u][m].*")) {
				System.out.println("Playing in medium difficulty!");
				p.addToInventory(new Item("Map"));
				break;
			}
			else if(l.matches("(?i).*[h][a][r][d].*")) {
				System.out.println("Playing in hard difficulty! Good luck!");
				break;
			}
			else if(l.matches("(?i).*[l][o][a][d].*")) {
				System.out.println("Enter file name to load from (include path if save file is not in project folder):");
				String filename = sc.nextLine();
				try {
					br = new BufferedReader(new FileReader(filename));
					String locationString = br.readLine();
					String characterString = br.readLine();
					
					System.out.println(locationString);
					System.out.println(characterString);
					
					m.loadLocationGrid(locationString);
					m.loadCharacterGrid(characterString, noOfAllies, mapWidth);
					
//					String inventoryLine = br.readLine();
//					
//					while (inventoryLine != null) {
//						
//						inventoryLine = br.readLine();
//					}
					br.close();
				} 
				catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} 	
				catch (IOException e) {
					e.printStackTrace();
				}
				break;
			}
			else if(l.matches("(?i).*[q][u][i][t].*")) {
				System.out.println("Quitting");
				System.exit(0);
			}
			else{
				System.out.println("Easy, medium or hard... try again");
				l = sc.nextLine();
			}
		}
		
		//Play loop
		while(noOfEnemies > 0) {
			//System.out.println(m.toString(true, true));
			//System.out.println("Try moving around (north, south, east, west)");
			l = sc.nextLine();
			
			try {
				if(l.matches("(?i).*[n][o][r][t][h].*")) {
					System.out.println("You head north...");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					c = m.setPlayerLocation(m.getPlayerLocation()[0] - 1, m.getPlayerLocation()[1]);
				}
				else if(l.matches("(?i).*[s][o][u][t][h].*")) {
					System.out.println("You head south...");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					c = m.setPlayerLocation(m.getPlayerLocation()[0] + 1, m.getPlayerLocation()[1]);
				}
				else if(l.matches("(?i).*[e][a][s][t].*")) {
					System.out.println("You head east...");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					c = m.setPlayerLocation(m.getPlayerLocation()[0], m.getPlayerLocation()[1] + 1);
				}
				else if(l.matches("(?i).*[w][e][s][t].*")) {
					System.out.println("You head west...");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
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
					
					if(m.getLocation().getIsSea()) {
						System.out.println("You are floating in the water.");
					}
					else {
						System.out.println("You are standing on an island.");
					}
					
					Item[] items = m.getLocation().getInventory();
					
					for(int i = 0; i < items.length; i++) {
						Item item = items[i];
						if(item != null) {
							System.out.println("You can see a " + item + " nearby.");
							empty = false;
						}
					}
					if(empty) {
						System.out.println("There are no items here!\nMaybe you should go somewhere else?");
					}
				}
				else if(l.matches("(?i).*[t][a][k][e].*")) {
					
					String[] split = l.split(" ");
					Item[] items = m.getLocation().getInventory();
					boolean nothingTaken = true;
					
					if(split.length == 2) {
						for(int i = 0; i < items.length; i++) {
							if(items[i] != null && split[1].matches("(?i)"+items[i].toString())) {
								if(!p.isInventoryfull()) {
									p.addToInventory(m.getLocation().removeFromInventory(items[i].toString()));
									nothingTaken = false;
								}
							}
						}
						if(nothingTaken) {
							System.out.println(split[1] + " has not been picked up, did you spell it correctly? Is your inventory full?");
						}
					}
					else {
						System.out.println("Take what?");
					}
				}
				else if(l.matches("(?i).*[d][r][o][p].*")) {
					
					String[] split = l.split(" ");
					Item[] items = p.getInventory();
					boolean nothingDropped = true;
					
					if(split.length == 2) {
						for(int i = 0; i < items.length; i++) {
							if(items[i] != null && split[1].matches("(?i)"+items[i].toString())) {
								m.getLocation().addToInventory(p.removeFromInventory(items[i].toString()));
								nothingDropped = false;
							}
						}
						if(nothingDropped) {
							System.out.println(split[1] + " has not been dropped, did you spell it correctly?");
						}
					}
					else {
						System.out.println("Drop what?");
					}
					
					
				}
				else if(l.matches("(?i).*[i][n][v][e][n][t][o][r][y].*")) {
					
					System.out.println("You look in your pocket and see...");
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
					boolean hasMap = true;
					boolean hasCompass = true;
					for(int i = 0; i < inventory.length; i++)
					{
						if(inventory[i] != null && inventory[i].toString() == "Map") {
							hasMap = true;
						}
						if(inventory[i] != null && inventory[i].toString() == "Compass") {
							hasCompass = true;
						}
					}
					System.out.println(m.toString(hasMap, hasCompass));		
				}
				else if(l.matches("(?i).*[g][u][i][d][e].*")) {
					try {
						br = new BufferedReader(new FileReader("Guide.txt"));
						String nextLine = br.readLine();
						while (nextLine != null) {
						      System.out.println(nextLine);
						      nextLine = br.readLine();
						}
						br.close();
					} 
					catch (FileNotFoundException e1) {
						e1.printStackTrace();
					} 	
					catch (IOException e) {
						e.printStackTrace();
					} 
					
				}
				else if(l.matches("(?i).*[s][a][v][e].*")) {
					
					System.out.println("Enter name for save file:");
					String filename = sc.nextLine();
					
					try {
						PrintWriter pr = new PrintWriter(filename);
						pr.println(m.getLocationGridString());
						pr.println(m.getCharacterGridString());
						pr.println(m.getInventoryString());
						System.out.println("Saving game as: " + filename);
						pr.close();
					} 
					catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				else if(l.matches("(?i).*[q][u][i][t].*")) {
					System.out.println("Quitting");
					System.exit(0);
				}
				else {
					System.out.println(l+"?");
					System.out.println("That doesn't mean anything, use the guide if you don't know what you're doing!");
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
					noOfEnemies--;
				}
				catch(ClassCastException e) {
					Ally a = (Ally)c;
					Encounter en = new Encounter(p, a, m);
					c = null;
				}	
			}
		}
		sc.close();
		
		System.out.println("CONGRATULATIONS YOU BEAT THE GAME");
		
	}
	
	

}
