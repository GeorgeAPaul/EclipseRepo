package codility;

import java.util.Arrays;

public class Froggy2 {

	public static void main(String[] args) {
		
		Froggy2 c = new Froggy2();

		int[] test = {-3,-3,-4,-100,5000};
		System.out.println(c.solution(test));

	}
	
	public int solution(int[] A) {
		
		int answer = Integer.MAX_VALUE;
		
//		if(A.length == 2)
//		{
//			answer = Math.abs(A[1] - A[0]);
//			return answer;
//		}
		
		
		int[] pSum = new int[A.length - 1];
		int[] pSumRev = new int[A.length - 1];
		int test;
		
		for (int i = 0, j = A.length - 1; i < A.length - 1 && j > 0; i++, j--)
		{
			if(i == 0)
			{
				pSum[i] = A[i];
				pSumRev[j - 1] = A[j];
			}
			else
			{
				pSum[i] = A[i] + pSum[i - 1];
				pSumRev[j - 1] = A[j] + pSumRev[j];
			}
		}
		
//		System.out.println(Arrays.toString(pSum));
//		System.out.println(Arrays.toString(pSumRev));
		
		for(int i = 0; i < pSum.length; i++)
		{
			test = pSumRev[i] - pSum[i];
			if (Math.abs(test) < answer)
			{
				answer = Math.abs(test);
			}
		}
		
	
		return answer;
	}
}
