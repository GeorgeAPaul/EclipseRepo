package codility;

import java.util.Arrays;

public class MaxCounters {

	public static void main(String[] args) 
	{
		
		MaxCounters m = new MaxCounters();
		
		int counters = 5;
		int[] operations = {3, 4, 4, 6, 1, 4, 4};
		
		System.out.println(Arrays.toString(m.solution(counters, operations)));
	}

	public int[] solution (int N, int[] A)
	{
		int[] answer =  new int[N];
		int max = 0;
		int min = 0;
		
		for (int i = 0; i < A.length; i++)
		{
			if ((A[i]) <= N)
			{
				if(answer[A[i] - 1] < min)
				{
					answer[A[i] - 1] = min;
				}
				
				answer[A[i] - 1]++;
				
				if(answer[A[i] - 1] > max)
				{
					max = answer[A[i] - 1];
				}
			}
			
			if(A[i] == N + 1)
			{
				min = max;
			}
//			System.out.println(max);
//			System.out.println(Arrays.toString(answer));
		}
		
		for (int i = 0; i < answer.length; i++)
		{
			if (answer[i] < min)
			{
				answer[i] = min;
			}
		}
		
		
		return answer;
	}
}
