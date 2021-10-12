package codility;

import java.util.Arrays;

public class NumberOfDiscIntersectionsImproved {

	public static void main(String[] args)
	{
	int[] test = {1,5,2,1,4,0};
	
	NumberOfDiscIntersectionsImproved n = new NumberOfDiscIntersectionsImproved();
	
	System.out.println(n.solution(test));
	}

	public int solution(int[] A)
	{
		int count = 0;
		int answer = 0;
		int[] Ai = new int[A.length];
		int[] Aj = new int[A.length];
		
		for (int y = 0; y < A.length; y++)
		{
			Ai[y] = A[y] + y;
			Aj[y] = y - A[y];
		}
		
		Arrays.sort(Ai);
		Arrays.sort(Aj);
		
		System.out.println(Arrays.toString(Ai));
		System.out.println(Arrays.toString(Aj));
		
		
		for (int z = 0; z < A.length; z++)
		{
		count =	Arrays.binarySearch(Aj, Ai[z]);
		
		if (count < 0)
		{
			count = -(count + 1);
		}
		
		System.out.println(count);
		
		answer = answer + count;
		}
		
		answer = answer - (A.length * ((A.length + 1) / 2));
		
		return answer;
	}
}
