import java.util.Scanner;

/**
 * Class to handle encounters between the Player and other characters on the map.
 * 
 * @author George paul
 *
 */
public class Encounter {
		
	/**
	 * To store the player.
	 */
	private Player player;
	
	/**
	 * To store the character in the encounter.
	 */
	private Character character;
	
	/**
	 * For user input.
	 */
	private Scanner sc;
	
	/**
	 * List of riddles (kindof) to be posed to the user in order to recruit an Ally.
	 */
	private String[] riddleArray = {"Who is the best Java teacher?", "Who is the best Java student?", 
			"What is the best country in the world?", "What is 2 + 3?", "Were the moon landings faked?", "What is a student's favorite lunch?"};
	
	/**
	 * Answers to the riddles.
	 */
	private String[] riddleAnswers = {"(?i).*[l][e][s][l][e][y].*", "(?i).*[g][e][o][r][g][e].*", "(?i).*[b][e][l][g][i][u][m].*", 
			"5|(?i).*[f][i][v][e].*", "(?i).*[n][o].*", "(?i).*[r][a][m][e][n].*"};
	
	/**
	 * Location on the map where encounter takes place.
	 */
	private Location currentLocation;
	
	/**
	 * First constructor method starts battles.
	 * 
	 * @param player The player object
	 * @param enemy The enemy object
	 * @param location The current location
	 */
	public Encounter(Player player, Enemy enemy, Location location) {
		
		this.player = player;
		this.character = enemy;
		this.currentLocation = location;
		
		//For user input
		sc = new Scanner(System.in);
		
		if(currentLocation.getIsSea()) {
			System.out.println("A sea monster attacks you!");
		}
		else {
			System.out.println("A wolf attacks you!");
		}
		
		battle(); //Start battle
		
	}
	
	/**
	 * 
	 * @param player
	 * @param ally
	 * @param location
	 */
	public Encounter(Player player, Ally ally, Location location) {
		this.player = player;
		this.character = ally;
		
		this.currentLocation = location;
		
		sc = new Scanner(System.in);
		
		recruit();
		
	}
	
	private void battle() {
		
		boolean playerTurn = true;
		System.out.println("\nBattle commenced! Try attack/war cry/cry or use a weapon!");
		
		int noOfRecruitedAllies = player.getNoOfRecruitedAllies();
		
		while (player.getHealth() > 0 && character.getHealth() > 0)
		{
			System.out.println("\nYour health: " + player.getHealth());
			System.out.println("Enemy health: " + character.getHealth());
			if (playerTurn) {
				System.out.println("\nEn garde! Your opponent beckons you forward...");
				String l = sc.nextLine();
				if (l.matches("(?i).*[a][t][t][a][c][k].*")) {
					System.out.println("Attacking with fists!");
					player.attack(character,player.getAttackPower());
				} 
				else if (l.matches("(?i).*[f][i][s][t].*")) {
					System.out.println("Attacking with fists!");
					player.attack(character,1);
				} 
				else if (l.matches("(?i).*[w][a][r].*[c][r][y].*")) {
					player.warCry(character);
				} 
				else if (l.matches("(?i).*[c][r][y].*")) {
					player.cry(character);
				}
				else if (l.matches("(?i).*[c][r][y].*")) {
					player.cry(character);
				}
				else if (l.matches("(?i).*[u][s][e].*")) {
					String[] split = l.split(" ");
					Item[] items = player.getInventory();
					
					if(split.length == 2) {
						for(int i = 0; i < items.length; i++) {
							if(items[i] != null && split[1].matches("(?i)"+items[i].toString())) {
					
								if(items[i] instanceof Weapon) {
									player.attack(character, ((Weapon)items[i]).getDamage());
								}
								else {
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
					al.attack(character,al.getAttackPower());
				}
				playerTurn = false;
			}
			else {
				System.out.println("\nYour opponent is attacking!");
				Helpers.wait(2000);
				character.attack(player,character.getAttackPower());
				playerTurn = true;
			}
		}
		if(player.getHealth() > 0) {
			System.out.println("You win!");
			Item[] inventory = character.removeAllFromInventory();
			
			for(int j = 0; j < inventory.length; j++) {
				currentLocation.addToInventory(inventory[j]);
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
			character.setName(name);
			
			Item[] inventory = character.removeAllFromInventory();
			
			for(int j = 0; j < inventory.length; j++) {
				currentLocation.addToInventory(inventory[j]);
				if(inventory[j] != null) {
					System.out.println("It looks like they dropped something!");
				}
			}
			
			player.addAlly((Ally)character);
		}
		
	}
}
