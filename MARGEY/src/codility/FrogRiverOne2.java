package codility;
import java.util.Arrays;

public class FrogRiverOne2 {

	public static void main(String[] args) {
		
		FrogRiverOne2 f = new FrogRiverOne2();
		
		int[] testArr = {1,8,9,7,6,5,4,3,2};
		int testN = 9;
		
		System.out.println(f.solution(testN, testArr));
	}

	public int solution (int X, int[] A)
	{
		int answer = 0;
		int count = 0;
		boolean[] map = new boolean[X];
		
		for (int i = 0; count < X && i < A.length; i++)
		{
			if (map[A[i] - 1] != true)
			{
				map[A[i] - 1] = true;
				count++;
			}
			answer = i;
			//System.out.println(i + "i");
			//System.out.println(count + "c");
		}
		
		//System.out.println(Arrays.toString(map));
		
		for(int i = 0; i < map.length; i++)
		{
			if(!map[i])
			{
				answer = -1;
				return answer;
			}
		}
		return answer;
		
	}
}
