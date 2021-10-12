package codility;

import java.util.Arrays;

public class LowestInteger {
	
public static void main(String[] args) {
		
		LowestInteger c = new LowestInteger();
		
		int[] test = {1, 2, 3};
		
		System.out.println(c.solution(test));

	}

public int solution(int[] A)
{
	boolean[] map = new boolean[A.length];
	int answer = 0;
	int noFalse = 0;
	
	for (int i = 0; i < A.length; i++)
	{
		if (A[i] <= A.length && A[i] > 0)
		{
		map[A[i] - 1] = true;
		}
	}
	
	System.out.println(Arrays.toString(map));
	
	for (int i = 0; i < map.length; i++)
	{
		if (map[i] == false)
		{
			answer = i + 1;
			noFalse++;
			return answer;
		}
	}
	
	System.out.println(noFalse);
	
	if (noFalse == 0)
	{
		answer = map.length + 1;
	}
	
	return answer;
}

}
