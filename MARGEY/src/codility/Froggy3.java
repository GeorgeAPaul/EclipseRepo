package codility;

import java.util.Arrays;

public class Froggy3 {

	public static void main(String[] args) {
		
		Froggy3 c = new Froggy3();

//		int[] test = {1,2,3,4,5,6,8};
		
		int[] test = new int[100000];
		
		for(int i = 0; i < 100000; i++)
		{
			test[i] = i + 1;
		}
		
		test[99999] += 1;
			
		System.out.println(c.solution(test));

	}
	
	public int solution(int[] A) {
		
//		boolean[] map = new boolean[A.length + 2];
//		int answer = 0;
//		
//		for(int i = 0; i < A.length; i++)
//		{
//			map[A[i]] = true;
//		}
//		
//		System.out.println(Arrays.toString(map));
//		
//		for(int i = 1; i < map.length; i++)
//		{
//			if (map[i] == false)
//			{
//				answer = i;
//				return answer;
//			}
//		}
		int answer = 0;
		long complete = ((long)A.length * ((long)A.length + 1)) / 2;
		long nplus1 = A.length + 1;
		long sum = 0;
		
//		System.out.println(complete);
//		System.out.println(nplus1);
		
		for(int i = 0; i < A.length; i++)
		{
			sum += (long) A[i];
		}
		
//		System.out.println(A[0]);
//		System.out.println(A[99999]);
//		System.out.println(complete  + nplus1);
//		System.out.println(sum);
//		System.out.println(complete  + nplus1 - sum);
		answer = (int)(complete + nplus1 - sum);
		
	//	System.out.println(answer);
		
		return answer;
	}
}
