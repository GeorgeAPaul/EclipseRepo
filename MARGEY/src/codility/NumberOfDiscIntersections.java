package codility;

import java.util.Arrays;

public class NumberOfDiscIntersections {
	
	public static void main(String[] args)
	{
	int[] test = {1,5,2,1,4,0};
	
	NumberOfDiscIntersections n = new NumberOfDiscIntersections();
	
	System.out.println(n.solution(test));
	}
	
	
	public int solution(int[] A)
	{
		
		long count = 0;
		int answer = 0;
		long longI;
		long longJ;
		
		if (A.length == 0)
		{
			return 0;
		}
		
		for(int i = 0; i < A.length; i++)
		{
			for(int j = i + 1; j < A.length; j++)
			{
				longI = (long) A[i];
				longJ = (long) A[j];
				
				if (j - i <= longI + longJ)
				{
					count++;
					
					if (count > 10000000)
					{
						return -1;
					}
				}
			}
		}
		
		answer = (int)count;
		return answer;
	}

}
