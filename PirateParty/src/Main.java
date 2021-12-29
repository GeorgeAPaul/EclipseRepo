import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * 
 * Main class for running main method.
 * 
 * @author George Paul 2021
 *
 */
public class Main {
	
	/**
	 * The main method for playing the game. Contains the main game loop and prompts user for input.
	 * @param args Command line arguments - none required
	 **/
	public static void main(String[] args) {
		
		//Buffered reader for reading files
		BufferedReader br;
		
		//Reading intro file.
		try {
			br = new BufferedReader(new FileReader("Intro.txt"));
			String nextLine = br.readLine();
			
			//Read line one at a time from file then print
			while (nextLine != null) {
			      System.out.println(nextLine);
			      nextLine = br.readLine();
			}
			br.close();
		} 
		catch (FileNotFoundException e1) {
			System.out.println("Intro.txt is missing please place in the project folder");
		} 	
		catch (IOException e) {
			System.out.println("Guide.txt is corrupted");
		}
		
		//Declaring constants used for generating map
		final int MAP_WIDTH = 5;
		final int NO_OF_ALLIES = 3;
		
		//Used for generating map but needs to change to signal end of game
		int noOfEnemies = 3;
		
		//Used for reading user input
		Scanner sc = new Scanner(System.in);
		
		//Create new map for game
		Map map = new Map(MAP_WIDTH, noOfEnemies, NO_OF_ALLIES);
		
		//Get a pointer to the player and player inventory so that the player can be used
		Player player = map.getPlayer();
		Item [] playerItems = player.getInventory();
		
		//Needed for starting encounters with other characters
		Character character = null;
		
		//Variable for user input
		String input;
		
		//Select difficultly level or load saved game, lower difficulty starts with extra items.
		while(true) {
						
			System.out.println("Would you like to start in easy, medium or hard difficulty?\r\n" + 
					"\r\n" + 
					"Easy: Start game with map and compass\r\n" + 
					"Medium: Start game with map\r\n" + 
					"Hard: Start game with nothing\r\n" + 
					"\r\n" + 
					"You can load a saved game with \"load\"\r\n" +
					"\r\n" + 
					"You can quit by typing \"quit\" (you cannot quit during a battle or recruitment)");
			
			input = sc.nextLine();
			
			//Use regex to match with input, allows for capitalisation or extra words/spaces e.g. "easy mode" will still work
			if(input.matches("(?i).*[e][a][s][y].*")) { 
				System.out.println("Playing in easy difficulty!");
				player.addToInventory(new Item("Map"));
				player.addToInventory(new Item("Compass"));
				break;
			}
			else if(input.matches("(?i).*[m][e][d][i][u][m].*")) {
				System.out.println("Playing in medium difficulty!");
				player.addToInventory(new Item("Map"));
				break;
			}
			else if(input.matches("(?i).*[h][a][r][d].*")) {
				System.out.println("Playing in hard difficulty! Good luck!");
				break;
			}
			else if(input.matches("(?i).*[l][o][a][d].*")) { //Load game from file, map is overwritten with data from file
				
				//Prompt user for file name and save filename to variable
				System.out.println("Enter file name to load from (include filepath if save file is not in project folder):");
				String filename = sc.nextLine();
				
				//Read file
				try {
					br = new BufferedReader(new FileReader(filename));
					
					//First and second lines of the file are always for the locations and characters respectively
					String locationString = br.readLine();
					String characterString = br.readLine();
					
					//Call map loading methods with data from save file
					map.loadLocationGrid(locationString);
					map.loadCharacterGrid(characterString, NO_OF_ALLIES, MAP_WIDTH);
					
					//Each inventory item is stored in a separate line
					String inventoryString = br.readLine();
					
					//Loop over inventory lines and load inventories
					while (inventoryString != null) {
						map.loadInventory(inventoryString);
						inventoryString = br.readLine();
					}
					br.close();
					player = map.getPlayer(); //Update pointer to new player
					System.out.println("Game has been loaded from save file: " + filename);
					break;
				} 
				catch (FileNotFoundException e1) { //If file not found start loop again
					System.out.println("File not found!");
				} 	
				catch (IOException e) { //Save file is potentially corrupted
					System.out.println("Save file corrupted!");
				}
				
			}
			else if(input.matches("(?i).*[q][u][i][t].*")) { //Quit program
				System.out.println("Quitting");
				System.exit(0);
			}
			else{
				System.out.println("Easy, medium, hard or load... try again");
			}
			
			
		}
		
		
		//Main play loop, keeps going until number of enemies is 0
		while(noOfEnemies > 0) {
			
			input = sc.nextLine(); //Prompt for user input
			
			int [] playerLocation = map.getPlayerLocation(); //Get player current map coordinates
			Location currentLocation = map.getLocation(); //Get the actual location object where player is	
			Item [] locationItems = currentLocation.getInventory(); //Get the items which are in the location
			
			try {
				if(input.matches("(?i).*[n][o][r][t][h].*")) { //If user types north, update player location accordingly				
					System.out.println("You head north...");
					Helpers.wait(1000); //Wait 1 second to add to suspense
					character = map.setPlayerLocation(playerLocation[0] - 1, playerLocation[1]); //Update player location
				}
				else if(input.matches("(?i).*[s][o][u][t][h].*")) { //Follows same logic as north
					System.out.println("You head south...");
					Helpers.wait(1000);
					character = map.setPlayerLocation(playerLocation[0] + 1, playerLocation[1]);
				}
				else if(input.matches("(?i).*[e][a][s][t].*")) { //Follows same logic as north
					System.out.println("You head east...");
					Helpers.wait(1000);
					character = map.setPlayerLocation(playerLocation[0], playerLocation[1] + 1);
				}
				else if(input.matches("(?i).*[w][e][s][t].*")) { //Follows same logic as north
					System.out.println("You head west...");
					Helpers.wait(1000);
					character = map.setPlayerLocation(playerLocation[0], playerLocation[1] - 1);
				}
				else if(input.matches("(?i).*[l][o][o][k].*")) { //Inform user whether player is on land or sea and what items are nearby
					
					System.out.println("You cast your eye about and see...");
					
					boolean empty = true; //For checking whether there are no items in this location
					
					Helpers.wait(1000);
					
					if(currentLocation.getIsSea()) { //Print whether player is in sea or on land
						System.out.println("You are floating in the water.");
					}
					else {
						System.out.println("You are standing on an island.");
					}
					
					for(int i = 0; i < locationItems.length; i++) { //Iterate over locations inventory
						Item item = locationItems[i];
						if(item != null) { //If inventory slot does not contain null print it's name
							System.out.println("You can see a " + item + " nearby.");
							empty = false; //If there are any items present update flag
						}
					}
					if(empty) { //If empty flag is still true tell user there are no items
						System.out.println("There are no items here!\nMaybe you should go somewhere else?");
					}
				}
				else if(input.matches("(?i).*[t][a][k][e].*")) { //Moves items from location inventory to player inventory
					
					String[] split = input.split(" "); //Split user input into words
					boolean nothingTaken = true; //For checking whether the "take" was successful
					
					if(split.length == 2) { //If user entered 2 words continue, else do nothing and prompt user
						for(int i = 0; i < locationItems.length; i++) { //Loop over items at location
							
							//If item slot is not null and matches the user input continue, else prompt user
							if(locationItems[i] != null && split[1].matches("(?i)"+locationItems[i].toString())) { 
								
								//If player inventory if not full continue, else prompt user
								if(!player.isInventoryfull()) {
									player.addToInventory(currentLocation.removeFromInventory(locationItems[i].toString()));
									System.out.println("Taking " + split[1]);
									nothingTaken = false; //Updating taken flag
								}
								else {
									System.out.print("Inventory full!");
								}
							}
						}
						if(nothingTaken) { //Prompt user for potential spelling mistakes
							System.out.println(split[1] + " has not been picked up, did you spell it correctly? Is your inventory full?");
						}
					}
					else { //If user did not enter 2 words
						System.out.println("Take what?");
					}
				}
				else if(input.matches("(?i).*[d][r][o][p].*")) { //Moves items from player inventory to location inventory
					
					String[] split = input.split(" "); //Same logic as "take" case except item is moved the opposite direction
					boolean nothingDropped = true; 
					
					if(split.length == 2) { 
						for(int i = 0; i < playerItems.length; i++) {
							if(playerItems[i] != null && split[1].matches("(?i)"+playerItems[i].toString())) {
								if (!currentLocation.isInventoryfull()) {
									currentLocation.addToInventory(player.removeFromInventory(playerItems[i].toString()));
									System.out.println("Dropping " + split[1]);
									nothingDropped = false;
								}
								else {
									System.out.print("Location full!"); //This should never happen as there are not enough items.
								}
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
				else if(input.matches("(?i).*[i][n][v][e][n][t][o][r][y].*")) { // For printing contents of player inventory
					
					System.out.println("You look in your pocket and see...");
					boolean empty = true; //If no items found
					
					Helpers.wait(1000);
					
					for(int i = 0; i < playerItems.length; i++) { //Loop over inventory
						Item item = playerItems[i];
						if(item != null) { //If item slot is not null print item and update empty flag to false
							System.out.println(item);//Print item
							empty = false; 
						}
					}
					if(empty) { //If empty inventory print
						System.out.println("Nothing!\n");
					}
				}
				else if(input.matches("(?i).*[m][a][p].*")) { // For printing map
					//For checking whether player has a map or compass
					boolean hasMap = false;
					boolean hasCompass = false;
					
					//Loop over player inventory
					for(int i = 0; i < playerItems.length; i++)
					{
						//If player has the relevant item update the respective flag
						if(playerItems[i] != null && playerItems[i].toString() == "Map") {
							hasMap = true;
						}
						if(playerItems[i] != null && playerItems[i].toString() == "Compass") {
							hasCompass = true;
						}
					}
					System.out.println(map.toString(hasMap, hasCompass)); //Print map
				}
				else if(input.matches("(?i).*[g][u][i][d][e].*")) { // For printing guide
					
					//Reading guide file
					try {
						br = new BufferedReader(new FileReader("Guide.txt"));
						String nextLine = br.readLine();
						while (nextLine != null) {
						      System.out.println(nextLine); //Print lines one by one
						      nextLine = br.readLine();
						}
						br.close();
					} 
					catch (FileNotFoundException e1) {
						System.out.println("Guide.txt is missing please place in the project folder");
					} 	
					catch (IOException e) {
						System.out.println("Guide.txt is corrupted");
					} 
					
				}
				else if(input.matches("(?i).*[s][a][v][e].*")) { //For saving state of game to a file
					
					//Prompts user for filename and saves to variable
					System.out.println("Enter name for save file:"); 
					String filename = sc.nextLine();
					
					//PrintWriter for writing file
					try {
						PrintWriter pr = new PrintWriter(filename);
						
						//First two lines of file are the map
						pr.println(map.getLocationGridString());
						pr.println(map.getCharacterGridString());
						
						//Subsequent lines are the inventory
						pr.print(map.getInventoryString().substring(0, map.getInventoryString().length() - 1)); //Substring is used to remove a final carriage return
						System.out.println("Saving game as: " + filename);
						pr.close();
					} 
					catch (FileNotFoundException e) {
						e.printStackTrace();
					}
					
				}
				else if(input.matches("(?i).*[q][u][i][t].*")) { //For exiting the game
					System.out.println("Quitting");
					System.exit(0);
				}
				else { //If user enters anything that does not match with the above cases
					System.out.println(input+"?");
					System.out.println("That doesn't mean anything, use the guide if you don't know what you're doing!");
				}
			}
			catch(IndexOutOfBoundsException e) { //If player reaches edge of map
				System.out.println("You feel as if that's the wrong way, maybe you've reached an edge of some sort?");
			}
			
			if(character != null) { //If player encounters another character
				
				//If character is an Enemy start battle
				if(character instanceof Enemy) {
					Enemy e = (Enemy)character;
					Encounter encounter = new Encounter(player, e, map);
					character = null;
					noOfEnemies--;
				}
				else if(character instanceof Ally) { //If character is an Ally start recruitment
					Ally a = (Ally)character;
					Encounter encounter = new Encounter(player, a, map);
					character = null;
				}
			}
		}
		
		sc.close();
		
		//Only way to get here is if you killed all enemies
		System.out.println("CONGRATULATIONS YOU BEAT THE GAME");
		
	}
	
	

}
