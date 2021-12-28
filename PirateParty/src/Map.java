import java.util.Arrays;

public class Map {
	
	private Location[][] locationGrid;
	private Character[][] characterGrid;
	//private Item[][][] itemGrid;
	private int[] playerLocation;
	

	public Map(int mapWidth, int noOfEnemies, int noOfAllies) {
		
		int space = mapWidth*mapWidth - (noOfEnemies + noOfAllies + 1);
		
		if(space < 0) {
			System.out.println("Arrgahrhhrah! There be too many characters in the map!");
			System.out.println("Reduce number of characters by " + (-space));
		}
		
		generateRandomMap(mapWidth);
		generateCharacters(mapWidth, noOfEnemies, noOfAllies);
		generateItems(mapWidth);
	
	}
	
	public String toString(boolean hasMap, boolean hasCompass) {
		
		String s = "";
		
		if (hasMap && hasCompass) {
			for(int i = 0; i < locationGrid.length ; i++) {
				for(int j = 0; j < locationGrid[0].length; j++) {
					Character c = characterGrid[i][j];
					
					if(c == null) {
						s += locationGrid[i][j];
					}
					else {
						s += locationGrid[i][j].toString().substring(0,1) + c + locationGrid[i][j].toString().substring(2,3);
					}
				}
				s += "\n";

			}
			s += "Using your map and compass the map makes a lot of sense!\n";
			s += "Perhaps squiggles are the sea and chevrons are the land...\n";
			s += "Enemies could be E and maybe allies are A? I wonder what P is?\n";
		}
		
		else if (hasMap && !hasCompass) {
			for(int i = 0; i < locationGrid.length; i++) {
				for(int j = 0; j < locationGrid[0].length; j++) {
					s += locationGrid[i][j];
				}
				s += "\n";
			}
			s += "Perhaps squiggles are the sea and chevrons are the land...";
		}
		else {
			s = "You need to find a map!";
		}
		return s;
	}
	
	
	
	private void generateRandomMap(int mapWidth){
		
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
	
	private void generateCharacters(int mapWidth, int noOfEnemies, int noOfAllies){
		
		characterGrid = new Character[mapWidth][mapWidth];
		
		int i = 2;//(int)(Math.random() * mapWidth);
		int j = 3;//(int)(Math.random() * mapWidth);
		
		characterGrid[i][j] = new Player(noOfAllies);
		
		playerLocation = new int[]{i, j};
		
		//characterGrid[2][2] = new Enemy();
		for(int k = 0; k < noOfEnemies; k++) {
			
			while(characterGrid[i][j] != null) {
				i = (int)(Math.random() * mapWidth);
				j = (int)(Math.random() * mapWidth);				
			}
			characterGrid[i][j] = new Enemy();
		}
		
		//characterGrid[2][2] = new Ally();
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
	
	public void generateItems(int mapWidth) {
		
		
		String[] itemList = {"Map","Compass"};
		String[] weaponList = {"Sword","Gun","Sausage"};
		int[] weaponDamageList = {50, 100, 0};
		
		for(int k = 0; k < itemList.length; k++) {
			
			int i = 2;//(int)(Math.random() * mapWidth);
			int j = 2;//S(int)(Math.random() * mapWidth);
			//int z = 0;
			
			if (characterGrid[i][j] != null) {
				characterGrid[i][j].addToInventory(new Item(itemList[k]));
			}
			else {
				locationGrid[i][j].addToInventory(new Item(itemList[k]));
			}
		
		}
		
		for(int k = 0; k < weaponList.length; k++) {
			
			int i = 2;//(int)(Math.random() * mapWidth);
			int j = 2;//S(int)(Math.random() * mapWidth);
			//int z = 0;
			
			if (characterGrid[i][j] != null) {
				characterGrid[i][j].addToInventory(new Weapon(weaponList[k], weaponDamageList[k]));
			}
			else {
				locationGrid[i][j].addToInventory(new Weapon(weaponList[k], weaponDamageList[k]));
			}
		}
		
//		String s = "";
//		for(int i = 0; i < mapWidth; i++) {
//			for(int j = 0; j < mapWidth; j++) {
//				for(int k = 0; k < mapWidth; k++) {
//				s += itemGrid[i][j][k];
//				//System.out.println(itemGrid[i][j][0]);
//				}
//			}
//			s += "\n";
//			
//		}
//		System.out.println(s);
	}
//	public void addItem(Item item){
//		int i = playerLocation[0];
//		int j = playerLocation[1];
//		
//		locationGrid[i][j].addToInventory(item);
//		
//		//System.out.println("MAP inv" + Arrays.toString(locationGrid[i][j].getInventory()));
//	}
	
//	public Item[] getItems() {
//		
//		int i = playerLocation[0];
//		int j = playerLocation[1];
//		
//		return locationGrid[i][j].getInventory();
//	}
	
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
						s += i + " " + j + " " + "L" + " " + item.toString();
					}
				}
				
				if(characterGrid[i][j] != null) {
					Item[] inventory2 = characterGrid[i][j].getInventory();
					for(int k = 0; k < inventory2.length; k++) {
						Item item = inventory2[k];
						if(item != null) {
							s += i + " " + j + " " + "C" + " " + item.toString();
						}
					}
				}
			}
		}
		return s;
	}
	
	public void loadLocationGrid(String locationGridString) {
		int i = 0;
		int j = 0;
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
	      }
	}
	
	public void loadCharacterGrid(String characterGridString, int noOfAllies, int mapWidth) {
		int i = 0;
		int j = 0;
		characterGrid = new Character[mapWidth][mapWidth];
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
	    	  
	      }
	}
	
	public void loadInventory(String inventoryString) {
		String[] s = inventoryString.split(" ");
		System.out.println(Arrays.toString(s));
		int i  = Integer.parseInt(s[0]);
		int j  = Integer.parseInt(s[1]);
		char characterFlag = s[2].charAt(0);
		String name = s[3];
		
		if(characterFlag == 'C') {
			System.out.println(i);
			System.out.println(j);
			System.out.println(characterGrid[i][j]);
			characterGrid[i][j].addToInventory(new Item(name));
			System.out.println("Yep");
		}
		else if(characterFlag == 'L') {
			System.out.println(i);
			System.out.println(j);
			System.out.println(locationGrid[i][j]);
			locationGrid[i][j].addToInventory(new Item(name));
			System.out.println("Yep2");
		}
	}
	
//	public Item removeItem(String itemName) {
//		
//		int i = playerLocation[0];
//		int j = playerLocation[1];
//		
//		return locationGrid[i][j].removeFromInventory(itemName);
//	}
	
	
	
	private int[] generateRandomCoordinates(int mapWidth) {
		int[] coordinates = new int[2];
		
		coordinates[0] = (int)(Math.random() * mapWidth);
		coordinates[1] = (int)(Math.random() * mapWidth);
		
		return coordinates;
	}
	
}
