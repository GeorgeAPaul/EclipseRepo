import java.io.IOException;

/**
 * 
 * Class to represent the game Map
 * 
 * @author George Paul
 *
 */
public class Map {
	
	/**
	 *  2d array for storing the locations that make up the Map.
	 */
	private Location[][] locationGrid;
	
	/**
	 * 2d array for storing the characters on the map.
	 */
	private Character[][] characterGrid;
	//I see your point about characters being stored in locations somehow, the reason they are not was because originally there were going to
	//be events where the map moves around but characters stay still. I'm leaving this the way it is so that the option to implement this in
	//the future remains.
	
	/**
	 * Array to store the players coordinates so that this can be retrieved easily and not searched for each time they are needed.
	 */
	private int[] playerLocation;
	
	/**
	 * Width of the map.
	 */
	private int mapWidth;
	
	/**
	 * Constructor method.
	 * 
	 * @param mapWidth Width of the map
	 * @param noOfEnemies Number of enemies to populate
	 * @param noOfAllies Number of allies to populate
	 */
	public Map(int mapWidth, int noOfEnemies, int noOfAllies) {
		
		//Detect if there are more characters than spaces in the grid. The character numbers are hard coded in Main.java so
		//shouldn't be a problem, unless the code is changed.
		int space = mapWidth*mapWidth - (noOfEnemies + noOfAllies + 1);
		if(space < 0) {
			System.out.println("Arrgahrhhrah! There be too many characters in the map!");
			System.out.println("Reduce number of characters by " + (-space));
			System.exit(0);
		}
		
		
		this.mapWidth = mapWidth;
		
		//Generate random map and items using class methods
		generateRandomMap();
		generateCharacters(noOfEnemies, noOfAllies);
		generateItems();
	
	}
	
	/**
	 * toString method with extra parameters so that map is printed differently depending on whether player has map and compass.
	 * 
	 * @param hasMap Flag indicating user has a map
	 * @param hasCompass Flag indicating user has a compass
	 * @return mapString String to represent the map
	 */
	public String toString(boolean hasMap, boolean hasCompass) {
		
		//Initialising return string
		String mapString = "";
		
		//If player has map and compass
		if (hasMap && hasCompass) {
			
			//Loop over i axis of locationGrid
			for(int i = 0; i < locationGrid.length ; i++) {
				
				//Loop over j axis of locationGrid
				for(int j = 0; j < locationGrid[0].length; j++) {
					
					//Get character at grid location
					Character character = characterGrid[i][j];
					
					//If there is no character add empty map location to string
					if(character == null) {
						mapString += locationGrid[i][j];
					}
					else { 
						String locationString = locationGrid[i][j].toString();
						
						//If there is a character present take first char of locationString, concat
						//character toString then concat last character of locationString
						mapString += locationString.substring(0,1) + character + locationString.substring(2,3);
					}
				}
				mapString += "\n";

			}
			mapString += "Using your map and compass the map makes a lot of sense!\n"; //Some instructions for reading the map
			mapString += "Perhaps squiggles are the sea and chevrons are the land...\n";
			mapString += "Enemies could be E and maybe allies are A? I wonder what P is?\n";
		}
		
		//If player has map but no compass, just return map without characters inserted
		else if (hasMap && !hasCompass) {
			for(int i = 0; i < locationGrid.length; i++) {
				for(int j = 0; j < locationGrid[0].length; j++) {
					mapString += locationGrid[i][j];
				}
				mapString += "\n";
			}
			mapString += "Perhaps squiggles are the sea and chevrons are the land...";
		}
		//If player has neither map nor compass
		else {
			mapString = "You need to find a map!";
		}
		return mapString;
	}
	
	
	/**
	 * Method to populate the location grid with locations.
	 */
	private void generateRandomMap(){
		
		//Define new array of Locations of correct size
		locationGrid = new Location[mapWidth][mapWidth];
		
		//Populating locationGrid with Locations
		for(int i = 0; i < mapWidth; i++) {
			for(int j = 0; j < mapWidth; j++) {
				locationGrid[i][j] =  new Location();
			}
		}
				
		//Getting rid of a few single space islands
		for(int i = 0; i < mapWidth; i++) {
			for(int j = 1; j < mapWidth - 1; j++) {
				//If location is land and locations to left and right are sea make current location sea
				if(!locationGrid[i][j].getIsSea() && locationGrid[i][j - 1].getIsSea() && locationGrid[i][j + 1].getIsSea()) {
					locationGrid[i][j].setIsSea(true);
				}
			}
		}
		
	}
	
	/**
	 * 
	 * Method to populate character grid.
	 * 
	 * @param noOfEnemies number of enemies to populate
	 * @param noOfAllies number of allies to populate
	 */
	private void generateCharacters(int noOfEnemies, int noOfAllies){
		
		//Define new array of Characters of correct size
		characterGrid = new Character[mapWidth][mapWidth];
		
		//Random coordinates for the player
		int i = (int)(Math.random() * mapWidth);
		int j = (int)(Math.random() * mapWidth);
		
		//Assign player to coordinates and update the stored playerLocation
		characterGrid[i][j] = new Player(noOfAllies);
		playerLocation = new int[]{i, j};
		
		//Generate enemies
		for(int k = 0; k < noOfEnemies; k++) {
			
			//Keep generating random numbers until an empty character slot is found
			while(characterGrid[i][j] != null) {
				i = (int)(Math.random() * mapWidth);
				j = (int)(Math.random() * mapWidth);				
			}
			
			//Assign enemy to slot
			characterGrid[i][j] = new Enemy();
		}
		
		//Same process for Allys
		for(int k = 0; k < noOfAllies; k++) {
			
			while(characterGrid[i][j] != null) {
				i = (int)(Math.random() * mapWidth);
				j = (int)(Math.random() * mapWidth);
			}
			characterGrid[i][j] = new Ally();
		}
	}
	
	/**
	 * Method to get the player coordinates
	 * 
	 * @return playerLocation Returns coordinates as a length 2 array with first element being i and second being j.
	 */
	public int[] getPlayerLocation() {
		return playerLocation;
	}
	
	/**
	 * Method to return the Player object.
	 * 
	 * @return Player object.
	 */
	public Player getPlayer() {
		return (Player)characterGrid[playerLocation[0]][playerLocation[1]];
	}
	
	/**
	 * Method to move the player object around the map
	 * 
	 * @param i New i coordinate to move the player to.
	 * @param j New j coordinate to move the player to.
	 * @return character If there was a character where the player moved to, return it to the main method.
	 * @throws IndexOutOfBoundsException For when the edge of the map is reached.
	 */
	public Character setPlayerLocation(int i, int j) throws IndexOutOfBoundsException {
		Character character = characterGrid[i][j]; //Temporary variable for displaced character
		characterGrid[i][j] = characterGrid[playerLocation[0]][playerLocation[1]]; //Copy Player to new coordinates
		characterGrid[playerLocation[0]][playerLocation[1]] = null; //Delete Player from old coordinates
		
		//Update playerLocation
		playerLocation[0] = i;
		playerLocation[1] = j;
		return character;
	}
	
	/**
	 * Method to generate Items and place them randomly on the map
	 */
	public void generateItems() {
		
		//Useful items
		String[] itemList = {"Map","Compass"};
		
		//Weapons
		String[] weaponList = {"Sword", "Gun", "Sausage", "Bow", "Whip", "Bazooka"};
		
		//Loop over item list
		for(int k = 0; k < itemList.length; k++) {
			
			//Generate random coordinates for the item
			int i = (int)(Math.random() * mapWidth);
			int j = (int)(Math.random() * mapWidth);
			
			//If there is a character at the coordinates put the item in the character inventory, else put it in the location.
			if (characterGrid[i][j] != null) {
				characterGrid[i][j].addToInventory(new Item(itemList[k]));
			}
			else {
				locationGrid[i][j].addToInventory(new Item(itemList[k]));
			}
		
		}
		
		//Same logic as for items but for the weapons
		for(int k = 0; k < weaponList.length; k++) {
			
			int i = (int)(Math.random() * mapWidth);
			int j = (int)(Math.random() * mapWidth);
			
			if (characterGrid[i][j] != null) {
				characterGrid[i][j].addToInventory(new Weapon(weaponList[k]));
			}
			else {
				locationGrid[i][j].addToInventory(new Weapon(weaponList[k]));
			}
			
		}
	}
	
	/**
	 * Method to return the Location object at the coordinates where the player is.
	 * @return Location 
	 */
	public Location getLocation() {
		
		int i = playerLocation[0];
		int j = playerLocation[1];
		
		return locationGrid[i][j];
	}
	
	/**
	 * Method to generate a String to represent the locationGrid for saving the game state.
	 * @return locationGridString A single line String that represents the locationGrid.
	 */
	public String getLocationGridString() {
		String locationGridString = "";
		
		//Iterate over locationGrid
		for(int i = 0; i < locationGrid.length; i++) {
			for(int j = 0; j < locationGrid[0].length; j++) {
				if(locationGrid[i][j].getIsSea()) { //If Location is sea add "S" to locationGridString
					locationGridString += "S";
				}
				else { //Else Location is land and add "L"
					locationGridString += "L";
				}
			}
			locationGridString += "B"; //At the end of each line in j direction add "B"
		}
		return locationGridString;
	}
	
	/**
	 * Method to generate a String to represent the characterGrid for saving the game state.
	 * @return characterGridString A single line String that represents the characterGrid.
	 */
	public String getCharacterGridString() {
		String characterGridString = "";
		
		//Iterate over characterGrid
		for(int i = 0; i < characterGrid.length; i++) {
			for(int j = 0; j < characterGrid[0].length; j++) {
				
				Character character = characterGrid[i][j];
				
				//Add string representation of characters.
				if(character == null) {
					characterGridString += "N";
				}
				else {
					characterGridString += character.toString();
				}
			}
			characterGridString += "B"; //At the end of each line in j direction add "B"
		}
		return characterGridString;
	}
	
	/**
	 * Method to generate a String to represent the inventories for saving the game state.
	 * @return inventoryString String that represents the inventories, each item is on its own line.
	 */
	public String getInventoryString() {
		String inventoryString = "";
		
		//Iterate over map
		for(int i = 0; i < characterGrid.length; i++) {
			for(int j = 0; j < characterGrid[0].length; j++) {
				
				//Get location inventory
				Item[] locationInventory = locationGrid[i][j].getInventory();
				
				//Iterate over locationInventory
				for(int k = 0; k < locationInventory.length; k++) {
					
					Item item = locationInventory[k];
					
					//Check whether item is a weapon
					String itemType = "I";
					if(item instanceof Weapon) {
						itemType = "W";
					}
					
					if(item != null) { //If item is not null add line that contains coordinates + "L" + item name
						inventoryString += i + " " + j + " " + "L" + " " + itemType + " " + item.toString() + "\n";
					}
				}
				
				//Iterate over characterInventory
				if(characterGrid[i][j] != null) {
					
					//Get character inventory
					Item[] characterInventory = characterGrid[i][j].getInventory();
					
					//Iterate over characterInventory
					for(int k = 0; k < characterInventory.length; k++) {
						Item item = characterInventory[k];
						
						//Check whether item is a weapon
						String itemType = "I";
						if(item instanceof Weapon) {
							itemType = "W";
						}
						
						if(item != null) { //If item is not null add line that contains coordinates + "C" + item name
							inventoryString += i + " " + j + " " + "C" + " " + itemType + " " + item.toString() + "\n";
						}
					}
				}
			}
		}
		return inventoryString;
	}
	
	/**
	 * Method to re-populate locationGrid based on a locationGridString
	 * 
	 * @param locationGridString String that represents a locationGrid.
	 * @throws IOException if any issues reading the file
	 */
	public void loadLocationGrid(String locationGridString) throws IOException {
		
		int i = 0;
		int j = 0;
		
		try {
			//Iterate over locationGridString
			for(int k = 0; k < locationGridString.length(); k++) {
				if(locationGridString.charAt(k) == 'S') { //If S is found set location to sea
					locationGrid[i][j] = new Location();
					locationGrid[i][j].setIsSea(true);
					j++;
				}
				else if(locationGridString.charAt(k) == 'L') { //If L is found set location to land
					locationGrid[i][j] = new Location();
					locationGrid[i][j].setIsSea(false);
					j++;
				}
				else if(locationGridString.charAt(k) == 'B') { //If B is found move to next row of locationGrid
					i++;
					j = 0;
				}
				else { //If anything else found, assume file is incorrect and throw error.
					throw new IOException();
				}
			}
		} catch (Exception e) { //If any exception at all with reading file or incorrect data in file throw IOException
			throw new IOException();
		}
	}
	
	/**
	 * Method to re-populate characterGrid based on a characterGridString
	 * 
	 * @param characterGridString String that represents a characterGrid.
	 * @param noOfAllies Number of allies to populate
	 * @param mapWidth width of map to load
	 * @throws IOException if any issues reading the file
	 */
	public void loadCharacterGrid(String characterGridString, int noOfAllies, int mapWidth) throws IOException {
		int i = 0;
		int j = 0;
		
		//Overwrite current characterGrid with nulls
		characterGrid = new Character[mapWidth][mapWidth];
		
		try {
			//Iterate over characterGridString
			for(int k = 0; k < characterGridString.length(); k++) {
				if(characterGridString.charAt(k) == 'E') {//If E is found set character to Enemy
					characterGrid[i][j] = new Enemy();
					j++;
				}
				else if(characterGridString.charAt(k) == 'A') {//If A is found set character to Ally
					characterGrid[i][j] = new Ally();
					j++;
				}
				else if(characterGridString.charAt(k) == 'P') {//If P is found set character to Player
					playerLocation[0] = i;
					playerLocation[1] = j;
					characterGrid[i][j] = new Player(noOfAllies);
					j++;
				}
				else if(characterGridString.charAt(k) == 'N') {//If N is found leave character as null
					j++;
				}
				else if(characterGridString.charAt(k) == 'B') {//If B is found move to next row of characterGrid
					i++;
					j = 0;
				}
				else { //If anything else found, assume file is incorrect and throw error.
					throw new IOException();
				}
			}
		} catch (Exception e) { //If any exception at all with reading file or incorrect data in file throw IOException
			throw new IOException();
		}
	}
	
	/**
	 * Method to re-populate inventories based on a inventoryString
	 * 
	 * @param inventoryString String that represents a item in an inventory
	 * @throws IOException if any issues reading the file
	 */
	public void loadInventory(String inventoryString) throws IOException {
		
		try {
			String[] s = inventoryString.split(" "); //Split string into array
			int i  = Integer.parseInt(s[0]); //First element is i coordinate
			int j  = Integer.parseInt(s[1]); //Second element is j coordinate
			char characterFlag = s[2].charAt(0); //Third element represents character or location
			char itemType = s[3].charAt(0); //Fourth element represents item type
			String name = s[4]; //5th element represents name of Item
			
			//If character flag is C add item to character inventory, else add to location inventory
			if(characterFlag == 'C') {
				if(itemType == 'I') {//If itemType is I add an item else add a weapon
					characterGrid[i][j].addToInventory(new Item(name));
				}
				else if(itemType == 'W') {
					characterGrid[i][j].addToInventory(new Weapon(name));
				}
			}
			else if(characterFlag == 'L') {
				if(itemType == 'I') {
					locationGrid[i][j].addToInventory(new Item(name));
				}
				else if(itemType == 'W') {
					locationGrid[i][j].addToInventory(new Weapon(name));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new IOException();
		}
	}
}
