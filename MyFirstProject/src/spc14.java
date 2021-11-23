public class spc14 {
	
	public static String decimalToBinary(int decimal) {
		StringBuilder binaryForm = new StringBuilder();
		boolean leadingZero = true;

		for(int i = 100; i >= 0; i--) {
			double powerOf2 = Math.pow(2, i);
			
			if(decimal % powerOf2 != decimal) {
				binaryForm.append("1");
				decimal -= powerOf2;
				leadingZero = false;
			}
			else if (!leadingZero) {
				binaryForm.append("0");
			}
		}
			
		return binaryForm.toString();
	}

	public static void main(String[] args ) {
		System.out.println(decimalToBinary(17));
		System.out.println(decimalToBinary(141));


	}
}
