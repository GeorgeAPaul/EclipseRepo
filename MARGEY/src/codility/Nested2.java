package codility;

import java.util.Stack;

public class Nested2 {
	
	public static void main(String[] args) {
		
		Nested2 c = new Nested2();
		
		String S = "((((((()))))))";
		
		System.out.println(c.solution(S));

	}
	
	public int solution(String S)
	{
		Stack<Character> stack = new Stack<Character>();
		
		for (int i = 0; i < S.length(); i++)
		{
			Character c = S.charAt(i);
			
			if(c.equals('(') || c.equals('{') || c.equals('['))
			{
				stack.push(c);
			}
			
			else
			{
				if(stack.empty())
				{
					return 0;
				}
				
				Character open = stack.pop();
				
				switch (c)
				{
				case (')'):
					if (!open.equals('('))
					{
						return 0;
					}
					break;
					
				case ('}'):
					if (!open.equals('{'))
					{
						return 0;
					}
					break;
					
				case (']'):
					if (!open.equals('['))
					{
						return 0;
					}
					break;
					
				}
			}
			
			System.out.println(stack);
			
		}
		
		if (!stack.empty())
		{
			return 0;
		}
		
		return 1;
		
	}
	

}
