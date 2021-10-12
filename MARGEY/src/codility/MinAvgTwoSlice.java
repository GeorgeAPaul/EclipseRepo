package codility;

import java.util.Arrays;

public class MinAvgTwoSlice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] test = {4,2,5,1,1,5,8};
		
		MinAvgTwoSlice m = new MinAvgTwoSlice();
		
		System.out.println(m.solution(test));

	}

	public int solution(int[] A)
	{
		int answer = 0;
		int[] prefixSum = new int[A.length + 1];
		
		for (int i = 0; i < A.length; i++)
		{
			prefixSum[i + 1] = prefixSum[i] + A[i];
		}
		
		System.out.println(Arrays.toString(A));
		System.out.println(Arrays.toString(prefixSum));
		
		double min = 200;
		int startPos = 0;
		double average;
		
		for (int i = 0; i < prefixSum.length; i++)
		{
			for(int j = i + 2; j < (prefixSum.length) && j <= (i + 3); j++)
			{
				average = ((double)prefixSum[j] - (double)prefixSum[i]) / (j - i);
				
//				System.out.println(average);
//				System.out.println(min);
				if(average < min)
				{
					min = average;
					startPos = i;
				}
			}
		}
		
		return startPos;
	}
	
}
