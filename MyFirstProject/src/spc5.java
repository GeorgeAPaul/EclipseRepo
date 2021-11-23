public class spc5 {
	
	public static void printDiamond(int number, char symbol) {
		
		for(int i = 1; i < number; i++) {
			if(i <= number / 2) {
				for(int j = 1; j <= number/2 - i; j++) {				
					System.out.print(" ");
				}
				for(int j = 1; j <= i * 2 - 1; j++) {				
					System.out.print(symbol);
				}
				System.out.println("");
			}
			else {
				for(int j = 1; j <= Math.abs(number - number/2 - i); j++) {				
					System.out.print(" ");
				}
				for(int j = 1; j <= number - (Math.abs(number - number/2 - i)) * 2 - 1; j++) {				
					System.out.print(symbol);
				}
				System.out.println("");
			}
		}
	}

	public static void main(String[] args) {
		printDiamond(8,'$');

	}

}
