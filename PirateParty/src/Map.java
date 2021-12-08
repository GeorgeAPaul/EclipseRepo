
public class Map {
	
	private Location[][] locationGrid;
	private Character[][] characterGrid;
	private int[] playerLocation;

	public Map(int mapWidth, int noOfEnemies, int noOfAllies) {
		
		generateRandomMap(mapWidth);
		generateCharacters(mapWidth, noOfEnemies, noOfAllies);
	
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
	
	private Character[][] generateCharacters(int mapWidth, int noOfEnemies, int noOfAllies){
		
		characterGrid = new Character[mapWidth][mapWidth];
		
		int i = (int)(Math.random() * mapWidth);
		int j = (int)(Math.random() * mapWidth);
		
		characterGrid[i][j] = new Player();
		
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
		return characterGrid;
	}
	
	public int[] getPlayerLocation() {
		return playerLocation;
	}
	
	public void setPlayerLocation(int i, int j) {
		
		try {
			characterGrid[i][j] = characterGrid[playerLocation[0]][playerLocation[1]];
			characterGrid[playerLocation[0]][playerLocation[1]] = null;
			playerLocation[0] = i;
			playerLocation[1] = j;
		}
		catch (IndexOutOfBoundsException e) {
			System.out.println("You feel as if that's the wrong way, maybe you've reached an edge of some sort?");
		}
	}
	
	
	
	private int[] generateRandomCoordinates(int mapWidth) {
		int[] coordinates = new int[2];
		
		coordinates[0] = (int)(Math.random() * mapWidth);
		coordinates[1] = (int)(Math.random() * mapWidth);
		
		return coordinates;
	}
	
}
