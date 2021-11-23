public class spc16 {
	
	public static boolean isPerfect(int number) {
		boolean isPerfect = false;
		int divisorsSum = 0;
		
		for(int i = number - 1; i >= 1; i--) {
			if(number % i == 0) {
				divisorsSum += i;
			}
		}
		
		if(divisorsSum == number) {
			isPerfect = true;
		}
		
		return isPerfect;
	}

	public static void main(String[] args ) {
		//System.out.println(isPerfect(17));
		//System.out.println(isPerfect(141));
		System.out.println(isPerfect(8128));
	}
}
