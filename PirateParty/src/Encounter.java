import java.util.Scanner;

public class Encounter {
	
	private Player p;
	private Enemy e;
	private Ally a;
	private Scanner sc;
	private static String[] riddleArray = {"Who is the best Java teacher?", "Who is the best Java student?", 
			"What is the best country in the world?", "What is 2 + 3?", "Were the moon landings faked?", "What is a student's favorite lunch?"};
	private static String[] riddleAnswers = {".*[lL][eE][sS][lL][eE][yY].*", ".*[gG][eE][oO][rR][gG][eE].*", ".*[bB][eE][lL][gG][iI][uU][mM].*", 
			"5|five", ".*[nN][oO].*", ".*[rR][aA][mM][eE][nN].*"};
	
	public Encounter(Player p, Enemy e) {
		this.p = p;
		this.e = e;
		sc = new Scanner(System.in);
		
		battle();
		
	}
	
	public Encounter(Player p, Ally a) {
		this.p = p;
		this.a = a;
		sc = new Scanner(System.in);
		
		recruit();
		
	}
	
	private void battle() {
		
		boolean playerTurn = true;
		System.out.println("Battle commenced! try attack/war cry/cry");
		
		while (p.getHealth() > 0 && e.getHealth() > 0)
		{
			System.out.println("Your health: " + p.getHealth());
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
					System.out.println("Enemy is emboldended by your pathetic wailing...");
					p.cry(e);
					System.out.println("Enemy defence up!");
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
		}
		
	}
}
