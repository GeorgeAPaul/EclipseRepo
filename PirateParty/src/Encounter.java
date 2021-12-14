import java.util.Scanner;

public class Encounter {
	
	private Player p;
	private Enemy e;
	private Ally a;
	private Scanner sc;
	
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
		while (p.getHealth() > 0 && e.getHealth() > 0)
		{
			System.out.println("En garde! Your opponent beckons you forward...");
			String l = sc.nextLine();
			if(l.matches(".*[aA][tT][tT][aA][cC][kK].*")) {
				p.attack(e);
			}
			else if(l.matches(".*[wW][aA][rR].*[cC][rR][yY].*")) {
				p.warCry(e);
			}
			else if(l.matches(".*[wW][aA][rR].*[cC][rR][yY].*")) {
				p.warCry(e);
			}
		}
	}
	
	private void recruit() {
		
		System.out.println("Recruitment");
		
	}
}
