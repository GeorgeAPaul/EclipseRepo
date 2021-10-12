package codility;

public class CountDiv {
	
	public static void main(String[] args)
	{
		CountDiv c = new CountDiv();
		
		int A = 11;
		int B = 14;
		int K = 11;
		
		System.out.println(c.solution(A, B, K));
	}

	public int solution(int A, int B, int K)
	{		
		System.out.println(A / K + " " + B / K);
		
		
		if (A % K == 0)
		{
			return (B / K) - (A / K) + 1;
		}
		
		else
		{
			return (B / K) - (A / K);
		}
	}
}
