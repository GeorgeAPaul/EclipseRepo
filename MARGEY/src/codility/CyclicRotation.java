package codility;

import java.util.Arrays;

public class CyclicRotation {

	public static void main(String[] args) {
		
		CyclicRotation c = new CyclicRotation();
		
		int[] array = {};
		int shift = 8;
		
		System.out.println(Arrays.toString(c.solution(array, shift)));

	}

	public int[] solution(int[] A, int K)
	{
		int[] rotated = new int[A.length];
		
		if (A.length == 0)
		{
			rotated = A;
			return rotated;
		}
		
		if (K > A.length)
		{
			K = K % A.length;
		}
		
		for (int i = 0; i < A.length; i++)
		{
			//System.out.println(i);
			//System.out.println( "array" + A[i]);
			//System.out.println(Integer.toString(A));
			if (i > A.length - K - 1)
			{
				rotated[(i + K) - (A.length)] = A[i];
			}
			else
			{
				rotated[i + K] = A[i];
			}
		}
		
		return rotated;
	}
}
