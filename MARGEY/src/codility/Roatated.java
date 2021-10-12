package codility;

import java.util.Arrays;

public class Roatated {

	public static void main(String[] args) 
	{
		Roatated o = new Roatated();
		
		int[] testArr = {};
		int K = 99;
		
		System.out.println(Arrays.toString(o.solution(testArr, K)));
	}

	public int[] solution(int A[], int K)
	{
		while(K > A.length && A.length != 0)
		{
			K = K - A.length;
		}
		
		int[] answer = new int[A.length];
		
		for(int i = 0; i < A.length; i++)
		{
			if (i + K < A.length)
			{
			answer[i + K] = A[i];
			}
			else
			{
				answer[i + K - A.length] = A[i];
			}
		}
	
		return answer;
	}
}
