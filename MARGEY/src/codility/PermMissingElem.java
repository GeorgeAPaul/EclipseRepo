package codility;

import java.util.Arrays;

public class PermMissingElem {

	public static void main(String[] args) 
	{
		
		PermMissingElem p = new PermMissingElem();
		
		int[] test = {};
		
		System.out.println(p.solution(test));
	}

	public int solution (int[] A)
	{
		int missing = 0;
		
		boolean[] map = new boolean[A.length + 1];
		
		for (int i = 0; i < A.length; i++)
		{
			map[A[i] - 1] = true;
		}
		
		for (int i = 0; i < map.length; i++)
		{
			if(map[i] == false)
			{
				missing = i + 1;
			}
		}
		//System.out.println(Arrays.toString(map));
		
		return missing;
	}
	
}
