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
	 * Second constructor method starts recruitments.
	 * 
	 * @param player The player object
	 * @param ally The ally object
	 * @param location The current location
	 */
	public Encounter(Player player, Ally ally, Location location) {
		this.player = player;
		this.character = ally;
		
		this.currentLocation = location;
		
		//For user input
		sc = new Scanner(System.in);
		
		recruit(); //Start recruitment
		
	}
	
	/**
	 * A method that prompts the user for input on choices that they want to make during the battle
	 * as well as handling the attacks between the characters.
	 */
	private void battle() {
		
		//Keeping track of whose turn it is
		boolean playerTurn = true;
		
		//Prompt for user input
		System.out.println("\nBattle commenced! Try attack/war cry/cry or use a weapon!");
		Ally[] allies = player.getAllies();
		
		//While both player and enemy health is over 0
		while (player.getHealth() > 0 && character.getHealth() > 0)
		{
			//Inform user of how much health player and enemy has
			System.out.println("\nYour health: " + player.getHealth());
			System.out.println("Enemy health: " + character.getHealth());
			
			//If its players turn prompt for input to choose action
			if (playerTurn) {
				System.out.println("\nEn garde! Your opponent beckons you forward...");
				String input = sc.nextLine();
				
				
				if (input.matches("(?i).*[a][t][t][a][c][k].*")) { //Basic attack
					System.out.println("Attacking with fists!");
					player.attack(character,player.getAttackPower());
				} 
				else if (input.matches("(?i).*[f][i][s][t].*")) {
					System.out.println("Attacking with fists!");
					player.attack(character,player.getAttackPower());
				}
				else if (input.matches("(?i).*[w][a][r].*[c][r][y].*")) { //War cry is used to lower defence
					player.warCry(character);
				} 
				else if (input.matches("(?i).*[c][r][y].*")) {//Cry raises enemy defence
					player.cry(character);
				}
				else if (input.matches("(?i).*[u][s][e].*")) {//For using weapons
					String[] split = input.split(" ");
					Item[] items = player.getInventory();
					
					if(split.length == 2) {//User must type 2 words or miss a turn
						
						//Iterate over items
						for(int i = 0; i < items.length; i++) {
							
							//If item is not null and matches the user input
							if(items[i] != null && split[1].matches("(?i)"+items[i].toString())) {
								//Can only attack with a weapon not an item
								if(items[i] instanceof Weapon) {
									System.out.println("Using " + items[i].toString());
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
				
				//Iterate over allies so they attack the enemy
				for (int i = 0; i < allies.length; i++) {
					
					if(allies[i] != null) {
						System.out.println(allies[i].getName() + " is attacking!");
						allies[i].attack(character,allies[i].getAttackPower());
					}
					
				}
				playerTurn = false; //Switching to enemy turn
			}
			else {//Enemy turn
				System.out.println("\nYour opponent is attacking!");
				Helpers.wait(2000);
				character.attack(player,character.getAttackPower());
				playerTurn = true;
			}
		}
		
		
		//When loop is finished either player or enemy was killed. If player still alive continue else quit game.
		if(player.getHealth() > 0) {
			System.out.println("You win!");
			Item[] inventory = character.removeAllFromInventory(); //Enemy drops all items
			
			//Iterate over dropped items, add them to location inventory
			for(int j = 0; j < inventory.length; j++) {
				currentLocation.addToInventory(inventory[j]);
				if(inventory[j] != null) {
					System.out.println("It looks like they dropped something!"); //Alert user to dropped items
				}
			}
		}
		else {
			System.out.println("You died!");
			System.out.println("GAME OVER");
			System.exit(0);
		}
	}
	
	
	/**
	 * A method that prompts the user for input on the recruitment quiz
	 */
	private void recruit() {
		
		System.out.println("Answer the question correctly to recruit an Ally!"); //Prompt user
		int guesses = 3;
		
		//Random int for choosing random question
		int i = (int)(riddleArray.length* Math.random());
		
		while(guesses > 0) {
			
			System.out.println(riddleArray[i]);
			System.out.println("\nYou have " + guesses + " guesses remaining...");
			
			//Input for user answer
			String answer = sc.nextLine();

			if (answer.matches(riddleAnswers[i])) { //If correct answer break out of loop
				System.out.println("Correct!");
				break;
			} 
			else{
				System.out.println("Wrong!"); //If not continue with loop, decrease guesses
				guesses--;
			}
		}
		
		//If guesses = 0 recruitment failed
		if (guesses == 0) {
			System.out.println("Recruitment failed!");
			System.out.println("Your potential ally has wandered off...");
		}
		else {
			System.out.println("Recruitment successful!");
			System.out.println("What would you like to name your new ally?");
			
			String name = sc.nextLine();//Prompt user for ally name
			character.setName(name);
			
			Item[] inventory = character.removeAllFromInventory();//Ally drops all items
			
			//Iterate over dropped items, add them to location inventory
			for(int j = 0; j < inventory.length; j++) {
				currentLocation.addToInventory(inventory[j]);
				if(inventory[j] != null) {
					System.out.println("It looks like they dropped something!");
				}
			}
			
			player.addAlly((Ally)character); //Add ally to player ally list
		}
		
	}
}
