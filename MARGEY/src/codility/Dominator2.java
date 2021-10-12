package codility;

import java.util.Arrays;
import java.util.Stack;

public class Dominator2 {

public static void main(String[] args) {
		
		Dominator2 c = new Dominator2();
		
		int[] array = {2,1,1,1,1,1,1,1,1,2,1,2,2,2,2,2,2,2,1,2};
		
		System.out.println(c.solution(array));

	}

public int solution(int[] A)
{
	if (A.length == 0)
	{
		return -1;
	}
	
	int test = 0;
	int answer = 0;
	int count = 0;
	Stack<Integer> stack = new Stack<Integer>();
	int a;
	int b;
	
	for (int i = 0; i < A.length; i++)
	{
		if (!stack.empty())
		{
			a = stack.peek();
			stack.push(A[i]);
			b = stack.peek();
		
			if(a != b)
			{
				stack.pop();
				stack.pop();
			}
		}
		
		else
		{
			stack.push(A[i]);
		}
	}
	
	if (!stack.empty())
	{
		test = stack.peek();
	}
	
	else
	{
		answer = -1;
		return answer;
	}
	
	for(int i = 0; i < A.length; i++)
	{
		if (A[i] == test)
		{
			answer = i;
			count++;
		}
	}

	
	if (count < A.length / 2)
	{
		answer = -1;
	}
	
	return answer;
}

}

