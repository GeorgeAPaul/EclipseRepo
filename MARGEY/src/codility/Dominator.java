package codility;

import java.util.Arrays;

public class Dominator {

public static void main(String[] args) {
		
		Dominator c = new Dominator();
		
		int[] array = {1};
		
		System.out.println(c.solution(array));

	}

public int solution(int[] A)
{
	if(A.length == 0)
	{
		return -1;
	}
	int answer = 0;
	int[] sorted = Arrays.stream(A).sorted().toArray();
	int count = 0;
	
	int test = sorted[(sorted.length) / 2];
	
	for (int i = 0; i < A.length; i++)
	{
		if (A[i] == test)
		{
			count++;
			answer = i;
		}
	}
	
	if (count <= (A.length / 2)) 
	{
		answer = -1;
	}	
	return answer;
}
}
