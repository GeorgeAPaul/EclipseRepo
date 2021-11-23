public class spc13 {
	
	public static int binaryToDecimal(String binary) {
			int decimalForm = 0;
			
			for(int i = binary.length() - 1, j = 0; i >= 0 && j < binary.length() ; i--, j++) {
				System.out.println("i"+i);
				System.out.println("j"+j);
				System.out.println(binary.charAt(i));
				
				decimalForm += (binary.charAt(i) - '0') * Math.pow(2,j);
			}
			
			return decimalForm;
	}

	public static void main(String[] args ) {
		System.out.println(binaryToDecimal("10001"));
		System.out.println(binaryToDecimal("10001101"));


	}
}
