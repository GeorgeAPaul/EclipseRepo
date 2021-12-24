import java.util.Arrays;
import java.util.Scanner;

public class Encounter {
	private Map m;
	private Player p;
	private Enemy e;
	private Ally a;
	private Scanner sc;
	private static String[] riddleArray = {"Who is the best Java teacher?", "Who is the best Java student?", 
			"What is the best country in the world?", "What is 2 + 3?", "Were the moon landings faked?", "What is a student's favorite lunch?"};
	private static String[] riddleAnswers = {"(?i).*[l][e][s][l][e][y].*", "(?i).*[g][e][o][r][g][e].*", "(?i).*[b][e][l][g][i][u][m].*", 
			"5|(?i).*[f][i][v][e].*", "(?i).*[n][o].*", "(?i).*[r][a][m][e][n].*"};
	
	public Encounter(Player p, Enemy e, Map m) {
		this.p = p;
		this.e = e;
		this.m = m;
		sc = new Scanner(System.in);
		
		battle();
		
	}
	
	public Encounter(Player p, Ally a, Map m) {
		this.p = p;
		this.a = a;
		this.m = m;
		sc = new Scanner(System.in);
		
		recruit();
		
	}
	
	private void battle() {
		
		boolean playerTurn = true;
		System.out.println("\nBattle commenced! try attack/war cry/cry");
		
		while (p.getHealth() > 0 && e.getHealth() > 0)
		{
			System.out.println("\nYour health: " + p.getHealth());
			System.out.println("Enemy health: " + e.getHealth());
			if (playerTurn) {
				System.out.println("\nEn garde! Your opponent beckons you forward...");
				String l = sc.nextLine();
				if (l.matches(".*[aA][tT][tT][aA][cC][kK].*")) {
					System.out.println("Attacking!");
					p.attack(e);
				} else if (l.matches(".*[wW][aA][rR].*[cC][rR][yY].*")) {
					p.warCry(e);
				} else if (l.matches("[cC][rR][yY].*")) {
					p.cry(e);
				}
				for (int i = 0; i < p.getNoOfRecruitedAllies(); i++) {
					System.out.println(p.getAlly(i).getName() + " is attacking!");
					p.getAlly(i).attack(e);
				}
				playerTurn = false;
			}
			else {
				System.out.println("\nYour opponent is attacking!");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				e.attack(p);
				playerTurn = true;
			}
		}
		if(p.getHealth() > 0) {
			System.out.println("You win!");
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
		}
		else {
			System.out.println("Recruitment successful!");
			System.out.println("What would you like to name your new ally?");
			String name = sc.nextLine();
			a.setName(name);
			
			Item[] inventory = a.removeAllFromInventory();
			
			System.out.println(Arrays.toString(inventory));
			
			for(int j = 0; j < inventory.length; j++) {
				m.addItem(inventory[j]);
			}
			
			p.addAlly(a);
		}
		
	}
}
