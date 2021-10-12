package codility;

import java.util.Arrays;

public class OddOccur {
	
public static void main(String[] args) {
		
		OddOccur c = new OddOccur();
		
		int S[] = {9,3,9,3,9,7,9};
		
		System.out.println(c.solution(S));

	}

public int solution(int[] A)
{
	if (A.length == 1)
	{
		return A[0];
	}
	
	Arrays.sort(A);
	System.out.println(Arrays.toString(A));
	int count = 1;
	int answer = 0;
	
	for(int i = 1; i < A.length; i++)
	{
		if(A[i] == A[i - 1])
		{
			count++;
		}
		else
		{
			if (i == 1)
			{
				answer = A[i - 1];
				return answer;
			}
			
			if (count % 2 != 0)
			{
				answer = A[i - 1];
				return answer;
			}
			
			if (i == A.length - 1)
			{
				answer = A[i];
				return answer;
			}
			
			count = 1;
		}
	}
	
	return answer;
}

}
