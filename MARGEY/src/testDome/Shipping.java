package testDome;

public class Shipping {
    public static int minimalNumberOfPackages(int items, int availableLargePackages, int availableSmallPackages) {
        //throw new UnsupportedOperationException("Waiting to be implemented.");
    	int answer = 0;
    	int capacity = 0;
    	int availablePackages = availableLargePackages + availableSmallPackages;
    	
    	for (int i = 0; i < availablePackages && capacity < items; i++)
    	{
    		if (availableLargePackages > 0)
    		{
    			capacity = capacity + 5;
    			availableLargePackages--;
    			answer++;
    			//System.out.println("testlarge " + capacity);
    		}
    		else
    		{
    			capacity = capacity + 1;
    			availableSmallPackages--;
    			answer++;
    			//System.out.println("testsmall " + capacity);
    			
    		}
    		
    		//System.out.println(i);
 
    	}
    	
//    	System.out.println(availableLargePackages + availableSmallPackages);
//    	System.out.println(capacity);
//    	System.out.println(items);
    	
    	if(capacity < items)
    	{
    		answer = -1;
    	}
    	
    	return answer;
    }
    
    public static void main(String[] args) {
        System.out.println(minimalNumberOfPackages(0, 2, 10));
    }
}
