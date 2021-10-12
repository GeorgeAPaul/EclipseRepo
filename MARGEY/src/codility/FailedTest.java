package codility;

public class FailedTest {
	
	public static void main(String args[])
	{
	
	FailedTest i = new FailedTest();
	
	int testA = 1;
	int testB = 1;
	int testC = 2;
	
	System.out.println(i.solution(testA, testB, testC));
	
	}
	
	
	public String solution(int A, int B, int C)
	{
		String answer = "";
		char l = 'a';
		char o1 = 'b';
		char o2 = 'c';
		int nl = 0;
		int no1 = 0;
		int no2 = 0;
		
		if( A >= B && A >= C)
		{
			l = 'a';
			o1 = 'b';
			o2 = 'c';
			
			nl = A;
			no1 = B;
			no2 = C;
		}
		if( B >= A && B >= C)
		{
			l = 'b';
			o1 = 'a';
			o2 = 'c';
			
			nl = B;
			no1 = A;
			no2 = C;
		}
		if( C >= A && C >= A)
		{
			l = 'c';
			o1 = 'a';
			o2 = 'b';
			
			nl = C;
			no1 = A;
			no2 = B;
		}

		int index = 0;
		char t1 = 't';
		char t2 = 't';
		for (int i = 1; i <= (A + B + C); i++)
		{
			if (index < 2)
			{
				t1 = o1;
				t2 = o2;
			}
			else
			{
				t1 = answer.charAt(index - 1);
				t2 = answer.charAt(index - 2);
			}
			
			if (nl >= 2 && !(t1==l && t2==l))
			{
				answer = answer + l + l;
				nl = nl - 2;
				index = index + 2;
			}
			
			if (no1 >= 1 && !(t1==o1 && t2==o1))
			{
				answer = answer + o1;
				no1--;
				index = index + 1;
			}
			else if (no2 >= 1 && !(t1==o2 && t2==o2))
			{
				answer = answer + o2;
				no2--;
				index = index + 1;
			}
			
		}
		
		return answer;
	}

}
