
public class WeeklySXCasstime {
	

	public static void main(String[] args) {
		
		WeeklySXCasstime a = new WeeklySXCasstime();
		
		a.sxcdays();

	}

	private String[] sxcdays() { 
		
		String[] days = {"Monday", "Tuesday", "Wonsday", "Tursday", "Fruitday", "Saturday", "Darkday"};
		
		for(int i = 0; i < 3; i++)
		{
			int random = (int)(Math.random() * 7);
	        System.out.println(random); 
		
	        for(int j = 0 ; j < i ; j++)
	        {
	        	
	        }
		}
		
		
		return days;
		
	}
}
