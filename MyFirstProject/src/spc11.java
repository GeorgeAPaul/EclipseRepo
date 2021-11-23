public class spc11 {
	
	public static int recursiveFib (int n) {
			if (n == 0 ) {
				return 0;
			}
			else if (n == 1 ) {
				return 1 ;
			}
		 
			else {
				return recursiveFib(n-1) + recursiveFib(n-2);	
			}
	}

	public static void main(String[] args ) {
		 System.out.println(recursiveFib(0));
		 System.out.println(recursiveFib(1));
		 System.out.println(recursiveFib(2));
		 System.out.println(recursiveFib(3));
		 System.out.println(recursiveFib(5));
		 System.out.println(recursiveFib(6));
		 System.out.println(recursiveFib(10));

	}
}
