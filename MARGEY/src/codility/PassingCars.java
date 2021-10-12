package codility;

import java.util.Arrays;

public class PassingCars {

	public static void main(String[] args) {
		
		PassingCars p = new PassingCars();
		
		int[] test = {1,0,0,1,0,1,0,0,0,1};
//		int[] test = new int[1000000000];
		
		System.out.println(p.solution(test));

	}
	public long solution(int[] A)
	{
		long answer = 0;
		int zeroCount = 0;
		int[] csum = new int[A.length];
		int lastVal = 0;
		
		for (int i = A.length - 1; i >= 0; i--)
		{
			if(i == A.length - 1)
			{
				csum[i] = A[A.length - 1];
				lastVal = A[A.length - 1];
			}
			else
			{
				if(A[i] == 1)
				{
					
					csum[i] = A[i] + lastVal;
					lastVal = csum[i];
				}
			}
		}
		
		System.out.println(Arrays.toString(csum));
		
		for (int i = 0; i  < csum.length; i++)
		{
			if (csum[i] == 0)
			{
				zeroCount++;
			}
			
			if (csum[i] != 0)
			{
				answer = zeroCount * csum[i] + answer;
				zeroCount = 0;
			}
			
			if(answer > 1000000000 || answer < 0)
			{
				answer = -1;
				return answer;
			}
		}		
		
		return answer;
	}
}
