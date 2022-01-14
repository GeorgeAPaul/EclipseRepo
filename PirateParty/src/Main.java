import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * ~~Unnamed Pirate Game 3~~
 * Read the guide in game for instructions on how to play!
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
			System.out.println("Intro.txt is corrupted");
		}
		
		//Declaring constants used for generating map
		final int MAP_WIDTH = 5;
		final int NO_OF_ALLIES = 3;
		
		//Used for generating map but needs to decline to 0 to signal end of game
		int noOfEnemies = 3;
		
		//Used for reading user input
		Scanner sc = new Scanner(System.in);
		
		//Create new map for game
		Map map = new Map(MAP_WIDTH, noOfEnemies, NO_OF_ALLIES);
		
		//Select difficultly level or load saved game, lower difficulty starts with extra items.
		UserPrompt.chooseDifficulty(map, NO_OF_ALLIES, sc);
		
		//More intro text
//		System.out.println("You open your eyes and find yourself in a strange land...");
//		Helpers.wait(3000);
//		System.out.println("It truly is a huge world! It must be " + MAP_WIDTH + "km across!");
//		Helpers.wait(3000);
//		System.out.println("All you can remember of your past life is that...");
//		Helpers.wait(3000);
//		System.out.println("YOU ARE THE UNNAMED PIRATE!");
//		Helpers.wait(3000);
//		System.out.println("And you will defeat your sworn enemies...");
//		Helpers.wait(3000);
//		System.out.println("...all " + noOfEnemies + " of them!");
//		Helpers.wait(3000);
//		System.out.println("If you ever get stuck you can consult the guide by typing 'guide'");
		System.out.print("Good luck!");
		
		//Main play loop, keeps going until number of enemies is 0
		UserPrompt.gameLoop(noOfEnemies, map, sc);
	
		sc.close();
		
		//Only way to get here is if you killed all enemies
		System.out.println("CONGRATULATIONS YOU BEAT THE GAME");
		
	}
	
	

}
