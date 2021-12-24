import java.util.Arrays;

public class Map {
	
	private Location[][] locationGrid;
	private Character[][] characterGrid;
	private Item[][][] itemGrid;
	private int[] playerLocation;
	

	public Map(int mapWidth, int noOfEnemies, int noOfAllies) {
		
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
			
		}
		
		else if (hasMap && !hasCompass) {
			for(int i = 0; i < locationGrid.length; i++) {
				for(int j = 0; j < locationGrid[0].length; j++) {
					s += locationGrid[i][j];
				}
				s += "\n";
			}
		}
		else {
			s = "You need a map!";
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
		
		for(int k = 0; k < noOfEnemies; k++) {
			
			while(characterGrid[i][j] != null) {
				i = (int)(Math.random() * mapWidth);
				j = (int)(Math.random() * mapWidth);				
			}
			characterGrid[i][j] = new Enemy();
		}
		
		characterGrid[2][2] = new Ally();
//		for(int k = 0; k < noOfAllies; k++) {
//			
//			while(characterGrid[i][j] != null) {
//				i = (int)(Math.random() * mapWidth);
//				j = (int)(Math.random() * mapWidth);
//			}
//			characterGrid[i][j] = new Ally();
//		}
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
		
		//itemGrid = new Item[mapWidth][mapWidth][mapWidth];
		
		String[] itemList = {"Map","Compass"};
		
		for(int k = 0; k < itemList.length; k++) {
			
			int i = 2;//(int)(Math.random() * mapWidth);
			int j = 2;//(int)(Math.random() * mapWidth);
			//int z = 0;
			
			if (characterGrid[i][j] != null) {
				characterGrid[i][j].addToInventory(new Item(itemList[k]));
			}
			else {
				locationGrid[i][j].addToInventory(new Item(itemList[k]));
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
	public void addItem(Item item){
		int i = playerLocation[0];
		int j = playerLocation[1];
		
		locationGrid[i][j].addToInventory(item);
		
		//System.out.println("MAP inv" + Arrays.toString(locationGrid[i][j].getInventory()));
	}
	
	public Item[] getItems() {
		
		int i = playerLocation[0];
		int j = playerLocation[1];
		
		return locationGrid[i][j].getInventory();
	}
	
	public Item removeItem(String itemName) {
		
		int i = playerLocation[0];
		int j = playerLocation[1];
		
		return locationGrid[i][j].removeFromInventory(itemName);
	}
	
	
	
	private int[] generateRandomCoordinates(int mapWidth) {
		int[] coordinates = new int[2];
		
		coordinates[0] = (int)(Math.random() * mapWidth);
		coordinates[1] = (int)(Math.random() * mapWidth);
		
		return coordinates;
	}
	
}
