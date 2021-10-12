package codility;

public class Nested {
	
	public static void main(String[] args) {
		
		Nested c = new Nested();
		
		String S = "(((((())";
		
		System.out.println(c.solution(S));

	}
	
	public int solution(String S)
	{
		int answer = 1;
		if (S.matches(""))
		{
			return answer;
		}
		
		String[] stringArray = S.split("");
		String test = "";
		
		if (stringArray[0].matches("\\)") || stringArray[0].matches("\\]") || stringArray[0].matches("\\}"))
		{
			System.out.println("test 1");
			answer = 0;
			return answer;
		}
		
		else if (stringArray[stringArray.length -1].matches("\\(") || stringArray[stringArray.length -1].matches("\\[") 
				|| stringArray[stringArray.length -1].matches("\\{"))
		{
			System.out.println("test 2");
			answer = 0;
			return answer;
		}
		
		else
		{
		
		for (int i = 0; i < stringArray.length - 1; i++)
		{
			test = stringArray[i] + stringArray[i + 1];
			
			if(test.matches("\\(\\}") || test.matches("\\(\\]") || test.matches("\\{\\)") || test.matches("\\{\\]") ||
					test.matches("\\[\\)") || test.matches("\\[\\}"))
					{
						System.out.println("test 3");
						System.out.println(i);
						answer = 0;
						return answer;
					}
		} 
		
		return 1;
		
		}
		
		
	}

}
