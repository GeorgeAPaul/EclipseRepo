package randomDate;

public class RandomDateGenerator {

	public String dateGenerator()
	{
		int month = (int)(Math.random() * 12);
		int day = 0;
		String[] nameMonth = new String[] {"January","February","March","April","May","June","July","August","September","October","November","December"};
		String date;
		
		switch(month) 
		{
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			
			day = (int)(Math.random() * 31 + 1);
			break;
		
		case 4:
		case 6:
		case 9:
		case 11:
			
			day = (int)(Math.random() * 30 + 1);
			break;
			
		case 2:
			
			day = (int)(Math.random() * 28 + 1);
			break;
		}
		
		date = Integer.toString(day) + " " + nameMonth[month];
		
		return date;
	}
}
