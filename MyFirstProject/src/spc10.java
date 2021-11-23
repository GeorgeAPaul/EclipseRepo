public class spc10 {
	
	public static int fib (int n) {
		int calculatedFib = 0;
			if (n == 0 ) {
				return 0;
			}
			else if (n == 1 ) {
				return 1 ;
			}
		 
			else {
				int loopCounter = n - 1;
				
				int fib1 = 0;
				int fib2 = 1;

				for (int i = 0 ; i < loopCounter ; i++){
					calculatedFib = fib1 + fib2;
					fib1 = fib2;
					fib2 = calculatedFib;
				}
			}
			
		 return calculatedFib;
	}

	public static void main(String[] args ) {
		 System.out.println(fib(0));
		 System.out.println(fib(1));
		 System.out.println(fib(2));
		 System.out.println(fib(3));
		 System.out.println(fib(5));
		 System.out.println(fib(6));
		 System.out.println(fib(10));

	}
}
