package codility;

import java.util.*;

public class MissingInt {
	
	public static void main (String[] args)
	{
		MissingInt m = new MissingInt();
		int[] testArr = {-100,2,3};
		
		System.out.println(m.solution(testArr));
		
	}

	public int solution(int[] A) 
	{
		int answer = 0;
        boolean[] map = new boolean[A.length + 1];
        
        for(int i = 0; i < A.length; i++)
        {
            if (A[i] <= A.length && A[i] > 0)
            {
                map[A[i] - 1] = true;
            }
        }
        
        for(int i = 0; i < map.length; i++)
        {
        	if (map[i] == false)
        	{
        		answer = i + 1;
        		break;
        	}
        }
        System.out.println(Arrays.toString(map));
        return answer;
    }
}
