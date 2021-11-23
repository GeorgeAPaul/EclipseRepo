public class spc4 {
	
	public static void printPyramid(int number) {
		
		for(int i = 1; i < number * 2; i++) {
			if(i <= number) {
				for(int j = 1; j <= i; j++) {				
					System.out.print("*");
				}
				System.out.println("");
			}
			else {
				for(int j = 1; j <= number * 2 - i; j++) {				
					System.out.print("*");
				}
				System.out.println("");
			}
		}
	}

	public static void main(String[] args) {
		printPyramid(50);

	}

}
