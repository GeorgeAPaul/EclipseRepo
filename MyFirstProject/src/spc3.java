public class spc3 {
	
	public static int calculateSum(int lowerBound, int upperBound) {
		int sum = 0;
		
		if (upperBound < lowerBound) {
			return -1;
		}
		
		for(int i = lowerBound; i <= upperBound; i++)
			sum += i;
		
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(calculateSum(5,10));
		System.out.println(calculateSum(5,2));

	}

}
