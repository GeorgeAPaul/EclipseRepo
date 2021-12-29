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
	 * @param noOfAllies Number of allies to poulate
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
						
						//If there is a character present take first char of map location string 
						mapString += locationString.substring(0,1) + character + locationString.substring(2,3);
					}
				}
				mapString += "\n";

			}
			mapString += "Using your map and compass the map makes a lot of sense!\n";
			mapString += "Perhaps squiggles are the sea and chevrons are the land...\n";
			mapString += "Enemies could be E and maybe allies are A? I wonder what P is?\n";
		}
		
		else if (hasMap && !hasCompass) {
			for(int i = 0; i < locationGrid.length; i++) {
				for(int j = 0; j < locationGrid[0].length; j++) {
					mapString += locationGrid[i][j];
				}
				mapString += "\n";
			}
			mapString += "Perhaps squiggles are the sea and chevrons are the land...";
		}
		else {
			mapString = "You need to find a map!";
		}
		return mapString;
	}
	
	
	
	private void generateRandomMap(){
		
		//Generating random map
		locationGrid = new Location[mapWidth][mapWidth];
		for(int i = 0; i < mapWidth; i++) {
			for(int j = 0; j < mapWidth; j++) {
				locationGrid[i][j] = new Location();
			}
		}
				
		//Getting rid of a few single space islands
		for(int i = 0; i < mapWidth; i++) {
			for(int j = 1; j < mapWidth - 1; j++) {
				if(!locationGrid[i][j].getIsSea() && locationGrid[i][j - 1].getIsSea() && locationGrid[i][j + 1].getIsSea()) {
					locationGrid[i][j].setIsSea(true);
				}
			}
		}
		
	}
	
	private void generateCharacters(int noOfEnemies, int noOfAllies){
		
		characterGrid = new Character[mapWidth][mapWidth];
		
		int i = (int)(Math.random() * mapWidth);
		int j = (int)(Math.random() * mapWidth);
		
		characterGrid[i][j] = new Player(noOfAllies);
		
		playerLocation = new int[]{i, j};
		
		for(int k = 0; k < noOfEnemies; k++) {
			
			while(characterGrid[i][j] != null) {
				i = (int)(Math.random() * mapWidth);
				j = (int)(Math.random() * mapWidth);				
			}
			characterGrid[i][j] = new Enemy();
		}
		
		for(int k = 0; k < noOfAllies; k++) {
			
			while(characterGrid[i][j] != null) {
				i = (int)(Math.random() * mapWidth);
				j = (int)(Math.random() * mapWidth);
			}
			characterGrid[i][j] = new Ally();
		}
	}
	
	public int[] getPlayerLocation() {
		return playerLocation;
	}
	
	public Player getPlayer() {
		return (Player)characterGrid[playerLocation[0]][playerLocation[1]];
	}
	
	public Character setPlayerLocation(int i, int j) throws IndexOutOfBoundsException {
		Character c = characterGrid[i][j];
		characterGrid[i][j] = characterGrid[playerLocation[0]][playerLocation[1]];
		characterGrid[playerLocation[0]][playerLocation[1]] = null;
		playerLocation[0] = i;
		playerLocation[1] = j;
		return c;
	}
	
	public void generateItems() {
		
		
		String[] itemList = {"Map","Compass"};
		String[] weaponList = {"Sword","Gun","Sausage","Sword","Gun","Sausage","Sword","Gun","Sausage","Sword","Gun","Sausage","Sword","Gun","Sausage","Sword","Gun","Sausage"};
		int[] weaponDamageList = {50, 100, 0,50, 100, 0,50, 100, 0,50, 100, 0,50, 100, 0,50, 100, 0,50, 100, 0,50, 100, 0,50, 100, 0};
		
		for(int k = 0; k < itemList.length; k++) {
			
			int i = (int)(Math.random() * mapWidth);
			int j = (int)(Math.random() * mapWidth);
			
			if (characterGrid[i][j] != null) {
				characterGrid[i][j].addToInventory(new Item(itemList[k]));
			}
			else {
				locationGrid[i][j].addToInventory(new Item(itemList[k]));
			}
		
		}
		
		for(int k = 0; k < weaponList.length; k++) {
			
			int i = (int)(Math.random() * mapWidth);
			int j = (int)(Math.random() * mapWidth);
			
			if (characterGrid[i][j] != null) {
				characterGrid[i][j].addToInventory(new Weapon(weaponList[k], weaponDamageList[k]));
			}
			else {
				//System.out.println(i+","+j);
				locationGrid[i][j].addToInventory(new Weapon(weaponList[k], weaponDamageList[k]));
			}
			
		}
	}
	
	public Location getLocation() {
		
		int i = playerLocation[0];
		int j = playerLocation[1];
		
		return locationGrid[i][j];
	}
	
	public String getLocationGridString() {
		String s = "";
		for(int i = 0; i < locationGrid.length; i++) {
			for(int j = 0; j < locationGrid[0].length; j++) {
				if(locationGrid[i][j].getIsSea()) {
					s += "S";
				}
				else {
					s += "L";
				}
			}
			s += "B";
		}
		return s;
	}
	
	public String getCharacterGridString() {
		String s = "";
		for(int i = 0; i < characterGrid.length; i++) {
			for(int j = 0; j < characterGrid[0].length; j++) {
				Character c = characterGrid[i][j];
				try {
					Enemy e = (Enemy)c;
					if(c == null) {
						s += "N";
					}
					else {
						s += "E";
					}
					
				}
				catch(ClassCastException e) {
					try {
						Player p = (Player)c;
						s += "P";
					}
					catch(ClassCastException e1){
						s += "A";
					}
				}
			}
			s += "B";
		}
		return s;
	}
	
	public String getInventoryString() {
		String s = "";
		for(int i = 0; i < characterGrid.length; i++) {
			for(int j = 0; j < characterGrid[0].length; j++) {
				Item[] inventory1 = locationGrid[i][j].getInventory();
				
				for(int k = 0; k < inventory1.length; k++) {
					Item item = inventory1[k];
					if(item != null) {
						s += i + " " + j + " " + "L" + " " + item.toString() + "\n";
					}
				}
				
				if(characterGrid[i][j] != null) {
					Item[] inventory2 = characterGrid[i][j].getInventory();
					for(int k = 0; k < inventory2.length; k++) {
						Item item = inventory2[k];
						if(item != null) {
							s += i + " " + j + " " + "C" + " " + item.toString() + "\n";
						}
					}
				}
			}
		}
		return s;
	}
	
	public void loadLocationGrid(String locationGridString) throws IOException {
		int i = 0;
		int j = 0;
		
		try {
			for(int k = 0; k < locationGridString.length(); k++) {
				if(locationGridString.charAt(k) == 'S') {
					locationGrid[i][j] = new Location();
					locationGrid[i][j].setIsSea(true);
					j++;
				}
				else if(locationGridString.charAt(k) == 'L') {
					locationGrid[i][j] = new Location();
					locationGrid[i][j].setIsSea(false);
					j++;
				}
				else if(locationGridString.charAt(k) == 'B') {
					i++;
					j = 0;
				}
				else {
					throw new IOException();
				}
			}
		} catch (Exception e) {
			throw new IOException();
		}
	}
	
	public void loadCharacterGrid(String characterGridString, int noOfAllies, int mapWidth) throws IOException {
		int i = 0;
		int j = 0;
		characterGrid = new Character[mapWidth][mapWidth];
		
		try {
			for(int k = 0; k < characterGridString.length(); k++) {
				if(characterGridString.charAt(k) == 'E') {
					characterGrid[i][j] = new Enemy();
					j++;
				}
				else if(characterGridString.charAt(k) == 'A') {
					characterGrid[i][j] = new Ally();
					j++;
				}
				else if(characterGridString.charAt(k) == 'P') {
					playerLocation[0] = i;
					playerLocation[1] = j;
					characterGrid[i][j] = new Player(noOfAllies);
					j++;
				}
				else if(characterGridString.charAt(k) == 'N') {
					j++;
				}
				else if(characterGridString.charAt(k) == 'B') {
					i++;
					j = 0;
				}
				else {
					throw new IOException();
				}
			}
		} catch (Exception e) {
			throw new IOException();
		}
	}
	
	public void loadInventory(String inventoryString) throws IOException {
		
		try {
			String[] s = inventoryString.split(" ");
			int i  = Integer.parseInt(s[0]);
			int j  = Integer.parseInt(s[1]);
			char characterFlag = s[2].charAt(0);
			String name = s[3];
			
			if(characterFlag == 'C') {
				characterGrid[i][j].addToInventory(new Item(name));
			}
			else if(characterFlag == 'L') {
				locationGrid[i][j].addToInventory(new Item(name));
			}
		} catch (Exception e) {
			throw new IOException();
		}
	}
}
