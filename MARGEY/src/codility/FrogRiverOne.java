package codility;
import java.util.Arrays;

public class FrogRiverOne {

	public static void main(String[] args) {
		
		FrogRiverOne f = new FrogRiverOne();
		
		int[] testArr = {3};
		int testN = 1;
		
		f.solution(testN, testArr);
	}

	public int solution (int X, int[] A)
	{
		int answer = 0;
		boolean[] map = new boolean [X];
		int countIf = X;
		
		for (int i = 0; countIf > 0 && i < A.length; i++)
		{
			if (A[i] <= X && (map[A[i] - 1] != true))
			{
				map[A[i] - 1] = true;
				countIf--;
			}
			answer++;
		}
		
		answer--;
		
		for (int i = 0; i < map.length && answer >= 0; i++)
		{
			if (map[i] == false)
			{
				answer = -1;
			}
		}
		
//		System.out.println(Arrays.toString(map));
//		System.out.println(answer);
		return answer;
		
	}
}
