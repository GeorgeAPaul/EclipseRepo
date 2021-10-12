package codility;

import java.util.Arrays;

public class HomeTest2 {
	
	public static void main(String[] args)
	{
		HomeTest2 m = new HomeTest2();
		int[] testArr = {3, 4, 3, 0, 2, 2, 3, 0, 0};
		
		System.out.println(m.solution(testArr));
	}

	public int solution(int[] ranks)
	{
		Arrays.sort(ranks);
		System.out.println(Arrays.toString(ranks));
		
		int rankCount = 0;
		int reports = 0;
		
		for(int i = 0; i < ranks.length - 1; i++)
		{
			if(ranks[i] == ranks[i + 1])
			{
				rankCount++;
				//System.out.println("test");
			}
			
			else if(ranks[i + 1] == ranks[i] + 1)
			{
				rankCount++;
				reports = reports + rankCount;
				
				//System.out.println("i"  + i);
				//System.out.println(rankCount);
				//System.out.println(reports);
				rankCount = 0;
			}
			else
			{
				rankCount = 0;
				//System.out.println("else" + i);
			}
		}
		
		return reports;
	}
}
