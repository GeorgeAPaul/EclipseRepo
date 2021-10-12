package codility;

import java.util.*;

public class BetterOne {
	
	public static void main(String[] args) 
	{
		int test[] = {-1, -1, 2, 5, 5, 5}; 
		BetterOne b = new BetterOne();
		int result = b.solution(test);
		System.out.println(result);
	}
	
	public int solution(int[] A)
	{
		int result = 0;
		boolean[] map = new boolean[A.length + 1];
	
		for(int i = 0; i < A.length; i++)
		{
			if (A[i] > 0 &&  A[i] <= A.length) 
			{
				map[A[i]-1] = true;
			}
			
		}
		
		map:
		for (int i = 0; i < map.length; i++)
		{
			if(map[i] == false)
			{
				result = i + 1;
				break map;
			}
		}
		
		
		
		System.out.println(Arrays.toString(map));
		return result;
	}

}
