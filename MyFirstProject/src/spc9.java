public class spc9 {
	
	public static double celsiusToFahrenheit(int cel) {
		
		double fahrenheit = 0;
		
		fahrenheit = cel * (9.0/5.0) + 32;
		
		return fahrenheit;
	}

	public static void main(String[] args) {
		
		double fahrentheitValueOne = celsiusToFahrenheit(5);
		System.out.println(fahrentheitValueOne);
		double fahrentheitValueTwo = celsiusToFahrenheit(21);
		System.out.println(fahrentheitValueTwo) ;

		
	}

}
