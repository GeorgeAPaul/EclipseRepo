package codility;

import java.util.*;

public class Distinct {

	public static void main(String[] args) {
		
		Distinct d = new Distinct();
		
		int[] test = {2,1,1,2,3,-1};
//		int[] test = {0};
//		int[] test;
		
		System.out.println(d.solution(test));

	}

	
	public int solution(int[] A) 
    {
		if (A.length == 0)
		{
			return 0;
		}
		
        Arrays.sort(A);
        int range = A[A.length - 1] - A[0];    
        boolean[] map = new boolean[(range + 2)];
        int countDistinct = 0;
        int testValue;
        
        for(int i = 0; i < A.length; i++)
        {
            testValue = A[i];
            
            if(testValue < 0)
            {
            	testValue = Math.abs(testValue + range + 2);
            }
            
            if(map[testValue] == false)
            {
                map[testValue] = true;
                countDistinct++;
            }
        }
        
        System.out.println(Arrays.toString(map));
        
        return countDistinct;
    }

}
