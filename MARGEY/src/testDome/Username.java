package testDome;

public class Username {
    public static boolean validate(String username) {
        //throw new UnsupportedOperationException("Waiting to be implemented.");
        boolean answer = true;
        int noOfHyphens = 0;
    	
        if (username.length() > 16 || username.length() < 6)
        {
        	return false;
        }
        
        for (int i = 0; i < username.length(); i++)
        {
        	Character t = username.charAt(i);
        	
        	if(i == 0 && !Character.toString(t).matches("[A-Za-z]"))
        	{
        		return false;
        	}
        	
        	if (i == username.length() - 1 && Character.toString(t).matches("-"))
        	{
        		return false;
        	}
        	
        	System.out.println(t);
        	
        	if (Character.toString(t).matches("-"))
        	{
        		noOfHyphens++;
        		
        		if (noOfHyphens > 1)
        		{
        			return false;
        		}
        	}
        	
        	if (!Character.toString(t).matches("[A-Za-z0-9-]"))
        	{
        		System.out.println(i);
        		return false;
        	}
        }
        
        return answer;
    }
    
    public static void main(String[] args) {
        System.out.println(validate("Mike-Standish-")); // Valid username
        System.out.println(validate("Mike Standish")); // Invalid username
    }
}
