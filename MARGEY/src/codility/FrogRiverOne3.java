package codility;

public class FrogRiverOne3 {

public static void main(String[] args) {
		
		FrogRiverOne3 f = new FrogRiverOne3();
		
		int[] testArr = {3,3,3,3};
		int testN = 3;
		
		System.out.println(f.solution(testN, testArr));
	}

	public int solution (int X, int[] A)
	{
		boolean[] map = new boolean[X];
		
		int time = 0;
		int spaces = X;
		for (int i = 0; i < A.length && spaces > 0; i ++)
		{
			if(!map[A[i] - 1] )
			{
			map[A[i] - 1] = true;
			spaces--;
			}
			
			time++;
			
			System.out.println(spaces);
		}
		
		time--;
		
		if (spaces != -1 && spaces != 0)
		{
			return -1;
		}
		
		return time;
	}
	}



