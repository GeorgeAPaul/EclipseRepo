public class spc2 {
	
	public static int calculateSum(int number) {
		int sum = 0;
		
		for(int i = 0; i <= number; i++)
			sum += i;
		
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(calculateSum(5));
		System.out.println(calculateSum(10));

	}

}
