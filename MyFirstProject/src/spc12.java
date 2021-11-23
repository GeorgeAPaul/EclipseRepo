public class spc12 {
	
	public static int calculateFactorial (int n) {
			if (n == 0 ) {
				return 1;
			}
			else if (n < 0) {
				return -1 ;
			}
		 
			else {
				return n * calculateFactorial(n-1);	
			}
	}

	public static void main(String[] args ) {
		 System.out.println(calculateFactorial(0));
		 System.out.println(calculateFactorial(1));
		 System.out.println(calculateFactorial(2));
		 System.out.println(calculateFactorial(3));
		 System.out.println(calculateFactorial(5));
		 System.out.println(calculateFactorial(6));
		 System.out.println(calculateFactorial(10));

	}
}
