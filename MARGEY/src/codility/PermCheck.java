package codility;

import java.util.*;

public class PermCheck {
	
	public static void main (String[] args)
	{
		PermCheck p = new PermCheck();
		
		int[] test = {};
		
		p.solution(test);
		System.out.println(p.solution(test));
		
	}

	public int solution (int[] A)
	{
		int answer = 1;
		
		Arrays.sort(A);
		
		for( int i = 0; i < A.length; i++)
		{
			if(A[i] != i + 1)
			{
				answer = 0;
			}
		}
		
		return answer;
	}
}
