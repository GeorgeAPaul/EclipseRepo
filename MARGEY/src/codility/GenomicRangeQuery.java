package codility;

import java.util.Arrays;

public class GenomicRangeQuery {

	public static void main(String[] args) {
		
		GenomicRangeQuery g = new GenomicRangeQuery();
		
		String testS = "CAGCCTA";
		int[] testP = {2, 5, 0};
		int[] testQ = {4, 5, 6};
		
		System.out.println(Arrays.toString(g.solution(testS, testP, testQ)));

	}
	
	public int[] solution(String S, int[] P, int[] Q)
	{
		int[] answer = new int[P.length];
		
		//String[] splitS = S.split("");
		
		int[] sumA = new int[S.length() + 1];
		int[] sumC = new int[S.length() + 1];
		int[] sumG = new int[S.length() + 1];
		int[] sumT = new int[S.length() + 1];
		
		int a;
		int c;
		int g;
		int t;
		
		for (int i = 0; i < S.length(); i++)
		{
			a = 0;
			c = 0;
			g = 0;
			t = 0;
			
			switch (S.charAt(i))
			{
			case('A'):
				a = 1;
			break;
			
			case('C'):
				c = 1;
			break;
			
			case('G'):
				g = 1;
			break;
			
			case('T'):
				t = 1;
			break;
			}
			
			sumA[i + 1] = sumA[i] + a;
			sumC[i + 1] = sumC[i] + c;
			sumG[i + 1] = sumG[i] + g;
			sumT[i + 1] = sumT[i] + t;
			
		}
		
		for (int i = 0; i < P.length; i++)
		{
			if(sumA[Q[i] + 1] > sumA[P[i]]) 
			{
				answer[i] = 1;
			}
			
			else if(sumC[Q[i] + 1] > sumC[P[i]]) 
			{
				answer[i] = 2;
			}
			
			else if(sumG[Q[i] + 1] > sumG[P[i]]) 
			{
				answer[i] = 3;
			}
			
//			else
//			{
//				answer[i] = 4;
//			}
			
			else if(sumT[Q[i] + 1] > sumT[P[i]]) 
			{
				answer[i] = 4;
			}
			
		}
		
		return answer;
	}

}
