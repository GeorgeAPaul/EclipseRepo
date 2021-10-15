import java.util.Scanner;

public class Nim {
	
	public static void main(String args[]) {
		
		int total = (int)(Math.random()*90 + 10);
		System.out.println("Start "+total);
		
		int whostart = (int)(Math.random() + 0.5);
		int smart = 0; //(int)(Math.random() + 0.5);
		
		Scanner in = new Scanner(System.in);
		
		if(whostart == 1) {
			System.out.println("Computer starts"+ "\n");
		}
		else {
			System.out.println("You start"+ "\n");
		}
		
		while(total > 0) {
			if(whostart == 1) {
				if(smart == 0) {
					int subtract = (int)(Math.random()*(total / 2) + 1);
					total -= subtract;
					System.out.println("Computer subtracts " + subtract);
					System.out.println("Remaining "+total+ "\n");
					whostart = 0;				
				}
				else {
					if (total ==)
				}
				
			}
			else {
				System.out.print("Your go!" + "\n");
				int subtract = in.nextInt();
				if(subtract > total / 2 && total != 1) {
					System.out.println("You can't take more that half of the remaining total");
				}
				else {
				total -= subtract;
				System.out.println("You subtract " + subtract);
				System.out.println("Remaining "+ total + "\n");
				whostart = 1;
				}
			}
			
		}
		
		in.close();
		
		if(whostart == 1) {
			System.out.println("Computer wins!");
		}
		else {
			System.out.println("You win!");
		}
		
	}

}
