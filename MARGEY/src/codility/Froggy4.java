package codility;

import java.util.Arrays;

public class Froggy4 {

	public static void main(String[] args) {
		
		Froggy4 c = new Froggy4();

		int[] test = {4,1,2};
		System.out.println(c.solution(test));

	}
	
	public int solution(int[] A) {
		
		int answer = 1;
		
		Arrays.sort(A);
		
		for (int i = 0; i < A.length; i++)
		{
			if (i != A[i] - 1)
			{
				answer = 0;
				return answer;
			}
				
		}
		return answer;
	}
}
