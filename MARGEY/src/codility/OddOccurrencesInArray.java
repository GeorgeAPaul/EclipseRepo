package codility;

import java.util.Arrays;

public class OddOccurrencesInArray {

	public static void main(String[] args) 
	{
		OddOccurrencesInArray o = new OddOccurrencesInArray();
		
		int[] testArr = {1,1,3,5,7,9,5,9,7,3,10};
		
		System.out.println(o.solution(testArr));
	}

	public int solution(int A[])
	{
		int answer = 0;
		
		Arrays.sort(A);
		System.out.println(Arrays.toString(A));
		for (int i = 0; i < A.length; i = i +2)
		{
			if ((i == (A.length - 1)) && answer == 0)
			{
				answer = A[i];
			}
			if ((i < (A.length - 1) && (A[i] != A[i+1])))
			{
				answer = A[i];
				break;
			}
		}
		
		return answer;
	}
}
