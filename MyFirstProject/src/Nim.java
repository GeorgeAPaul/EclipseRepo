import java.util.InputMismatchException;
import java.util.Scanner;

public class Nim {
	
	public static void main(String args[]) {
		
		System.out.println("~~WELCOME TO GAME OF NIM~~\n");
		
		int total = (int)(Math.random()*90 + 10);
		System.out.println("Starting total "+total);
		
		int whostart = (int)(Math.random() + 0.5);
		int smart = (int)(Math.random() + 0.5);
		
		if(whostart == 1) {
			System.out.println("Computer goes first"+ "\n");
		}
		else {
			System.out.println("Your go first"+ "\n");
		}
		
		if(smart == 1) {
			System.out.println("WARNING! Computer is playing in smart mode, it's nearly impossible to beat..."+ "\n");
		}
		else {
			System.out.println("Great news! The computer is playing in dumb mode"+ "\n");
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
					int[] targets = {63,31,15,7,3,1};
					for(int i = 0; i < targets.length; i++){
						
						if(total == targets[i])
						{
							int subtract = (int)(Math.random()*(total / 2) + 1);
							total -= subtract;
							
							System.out.println("Computer subtracts " + subtract);
							System.out.println("Remaining "+total+ "\n");
							
							whostart = 0;
							break;
						}
						
						int testval = total - targets[i];
						
						if(testval <= total/2 && testval > 0 )
						{
							int subtract = total - targets[i];
							total -= subtract;
							
							System.out.println("Computer cleverly subtracts " + subtract);
							System.out.println("Remaining "+total+ "\n");
							
							whostart = 0;
							break;
						}
					}
				}
			}	
			else {
				System.out.print("Your go!" + "\n");
				Scanner in = new Scanner(System.in);
				
				int subtract = 0;
				try {
					subtract = in.nextInt();
				}
				catch(InputMismatchException e) {
					System.out.println("Enter an integer please");
					subtract = -1;
				}
				
				if(subtract > total / 2 && total != 1) {
					System.out.println("You can't take more that half of the remaining total");
				}
				else if(subtract <= 0) {
					System.out.println("Do you not know the rules?");
				}
				else {
				total -= subtract;
				System.out.println("You subtract " + subtract);
				System.out.println("Remaining "+ total + "\n");
				whostart = 1;
				}
			}
			
		}
			
		if(whostart == 1) {
			System.out.println("Computer wins!");
		}
		else {
			System.out.println("You win!");
		}
		
	}

}
