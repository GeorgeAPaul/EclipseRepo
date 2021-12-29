import java.util.Arrays;
import java.util.Scanner;

public class Encounter {
	private Map map;
	private Player player;
	private Enemy enemy;
	private Ally ally;
	private Scanner sc;
	private String[] riddleArray = {"Who is the best Java teacher?", "Who is the best Java student?", 
			"What is the best country in the world?", "What is 2 + 3?", "Were the moon landings faked?", "What is a student's favorite lunch?"};
	private String[] riddleAnswers = {"(?i).*[l][e][s][l][e][y].*", "(?i).*[g][e][o][r][g][e].*", "(?i).*[b][e][l][g][i][u][m].*", 
			"5|(?i).*[f][i][v][e].*", "(?i).*[n][o].*", "(?i).*[r][a][m][e][n].*"};
	
	private Location currentLocation;
	
	public Encounter(Player p, Enemy e, Map m) {
		this.player = p;
		this.enemy = e;
		this.map = m;
		
		this.currentLocation = m.getLocation();
		
		sc = new Scanner(System.in);
		
		if(m.getLocation().getIsSea()) {
			System.out.println("A sea monster attacks you!");
		}
		else {
			System.out.println("A wolf attacks you!");
		}
		
		battle();
		
	}
	
	public Encounter(Player p, Ally a, Map m) {
		this.player = p;
		this.ally = a;
		this.map = m;
		
		this.currentLocation = m.getLocation();
		
		sc = new Scanner(System.in);
		
		recruit();
		
	}
	
	private void battle() {
		
		boolean playerTurn = true;
		System.out.println("\nBattle commenced! Try attack/war cry/cry or use a weapon!");
		
		int noOfRecruitedAllies = player.getNoOfRecruitedAllies();
		
		while (player.getHealth() > 0 && enemy.getHealth() > 0)
		{
			System.out.println("\nYour health: " + player.getHealth());
			System.out.println("Enemy health: " + enemy.getHealth());
			if (playerTurn) {
				System.out.println("\nEn garde! Your opponent beckons you forward...");
				String l = sc.nextLine();
				if (l.matches("(?i).*[a][t][t][a][c][k].*")) {
					System.out.println("Attacking with fists!");
					player.attack(enemy,player.getAttackPower());
				} 
				else if (l.matches("(?i).*[f][i][s][t].*")) {
					System.out.println("Attacking with fists!");
					player.attack(enemy,1);
				} 
				else if (l.matches("(?i).*[w][a][r].*[c][r][y].*")) {
					player.warCry(enemy);
				} 
				else if (l.matches("(?i).*[c][r][y].*")) {
					player.cry(enemy);
				}
				else if (l.matches("(?i).*[c][r][y].*")) {
					player.cry(enemy);
				}
				else if (l.matches("(?i).*[u][s][e].*")) {
					String[] split = l.split(" ");
					Item[] items = player.getInventory();
					
					if(split.length == 2) {
						for(int i = 0; i < items.length; i++) {
							if(items[i] != null && split[1].matches("(?i)"+items[i].toString())) {
								try {
									Weapon w = (Weapon)items[i];
									player.attack(enemy, w.getDamage());
								}
								catch(ClassCastException e) {
									System.out.println("You can't use that in a fight!");
									System.out.println("You fumbling around means you miss your turn!");
								}
							}
						}
					}
					else {
						System.out.println("Use what?");
						System.out.println("You fumbling around means you miss your turn!");
					}
				}
				for (int i = 0; i < noOfRecruitedAllies; i++) {
					System.out.println(player.getAlly(i).getName() + " is attacking!");
					Ally al = player.getAlly(i);
					al.attack(enemy,al.getAttackPower());
				}
				playerTurn = false;
			}
			else {
				System.out.println("\nYour opponent is attacking!");
				Helpers.wait(2000);
				enemy.attack(player,enemy.getAttackPower());
				playerTurn = true;
			}
		}
		if(player.getHealth() > 0) {
			System.out.println("You win!");
			Item[] inventory = enemy.removeAllFromInventory();
			
			for(int j = 0; j < inventory.length; j++) {
				map.getLocation().addToInventory(inventory[j]);
				if(inventory[j] != null) {
					System.out.println("It looks like they dropped something!");
				}
			}
		}
		else {
			System.out.println("You died!");
			System.out.println("GAME OVER");
			System.exit(0);
		}
	}
	
	
	
	private void recruit() {
		
		System.out.println("Answer the question correctly to recruit an Ally!");
		int guesses = 3;
		int i = (int)(riddleArray.length* Math.random());
		
		while(guesses > 0) {
			
			System.out.println(riddleArray[i]);
			System.out.println("\nYou have " + guesses + " guesses remaining...");
			String l = sc.nextLine();

			if (l.matches(riddleAnswers[i])) {
				System.out.println("Correct!");
				break;
			} 
			else{
				System.out.println("Wrong!");
				guesses--;
			}
		}
		if (guesses == 0) {
			System.out.println("Recruitment failed!");
			System.out.println("Your potential ally has wandered off...");
		}
		else {
			System.out.println("Recruitment successful!");
			System.out.println("What would you like to name your new ally?");
			String name = sc.nextLine();
			ally.setName(name);
			
			Item[] inventory = ally.removeAllFromInventory();
			
			for(int j = 0; j < inventory.length; j++) {
				map.getLocation().addToInventory(inventory[j]);
				if(inventory[j] != null) {
					System.out.println("It looks like they dropped something!");
				}
			}
			
			player.addAlly(ally);
		}
		
	}
}
