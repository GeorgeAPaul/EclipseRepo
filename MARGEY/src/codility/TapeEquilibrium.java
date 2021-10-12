package codility;

import java.util.Arrays;

public class TapeEquilibrium {

	public static void main(String[] args) 
	{
		
		TapeEquilibrium t = new TapeEquilibrium();
		
		int[] test = {3, 1, 2, 4, 3};
		t.solution(test);
		//System.out.println(t.solution(test));
	}
	
	public int solution (int[] A)
	{
		int minDiff = 0;
		int diff = 0;
		int[] sumLowerArray = new int[A.length - 1];
		int[] sumUpperArray = new int[A.length - 1];
		 
		for(int i = 0; i < sumLowerArray.length; i++)
		{
			if (i == 0)
			{
				sumLowerArray[i] = A[i];
			}
			
			else
			{
				sumLowerArray[i] = A[i] + sumLowerArray[i - 1];
			}
		}
		
		for(int i = (sumUpperArray.length - 1); i >= 0; i--)
		{
			if (i == sumUpperArray.length - 1)
			{
				sumUpperArray[i] = A[i + 1];
			}
			
			else
			{
				sumUpperArray[i] = A[i + 1] + sumUpperArray[i + 1];
			}
		}
		System.out.println(Arrays.toString(A));
		System.out.println(Arrays.toString(sumLowerArray));
		System.out.println(Arrays.toString(sumUpperArray));
		
		for(int i = 0; i < sumLowerArray.length; i ++)
		{
			diff = Math.abs(sumUpperArray[i] - sumLowerArray[i]);
			
			if (i == 0)
			{
				minDiff = diff;
			}
			if (diff < minDiff)
				{
					minDiff = diff;
				}
		}
		
		if (A.length == 2)
		{
			minDiff = Math.abs(A[0] - A[1]);
		}
		
		System.out.println(minDiff);
		return minDiff;
		
//		int minDiff = 0;
//		
//		
//		for (int P = 1; P < A.length; P++)
//		{
//			int lowerSum = 0;
//			int upperSum = 0;
//			
//			for (int i = 0; i < (P); i++)
//			{
//				lowerSum = lowerSum + A[i];
//			}
//			
//			for (int i = P; i < A.length; i++)
//			{
//				upperSum = upperSum + A[i];
//			}
//			
//			if (P == 1)
//			{
//				minDiff = Math.abs(upperSum - lowerSum);
////				System.out.println(lowerSum);
////				System.out.println(upperSum);
////				System.out.println(minDiff);
//			}
//			
//			if (Math.abs(upperSum - lowerSum) < minDiff)
//			{
//				minDiff = Math.abs(upperSum - lowerSum);
//			}
//			
//		}
//		
//		return minDiff;
	}

}
