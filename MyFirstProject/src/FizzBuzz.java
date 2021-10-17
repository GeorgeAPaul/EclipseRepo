
public class FizzBuzz {
	
	public static void main(String args[]) {
		
		for(int i = 0; i <= 20; i++){
			
			String s = "";
			
			if(i % 3 == 0 && i != 0) {
				s = s + "Fizz!";
			}
			else if(i % 5 == 0 && i != 0) {
				s = s + "Buzz!";
			} 
			else {
				System.out.println(i);
			}
			if(s != "") {
			System.out.println(s);
			}
		}
		
	}
	
	

}
