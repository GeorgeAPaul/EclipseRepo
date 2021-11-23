public class spc15 {
	
	public static boolean isPrime(int number) {
		boolean isPrime = true;
		
		for(int i = number - 1; i > 1; i--) {
			if(number % i == 0) {
				return false;
			}
		}
			
		return isPrime;
	}

	public static void main(String[] args ) {
		System.out.println(isPrime(17));
		System.out.println(isPrime(141));
	}
}
