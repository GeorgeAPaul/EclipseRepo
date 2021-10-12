package codility;

public class Test {
	
	public static void main (String[] args)
	{
		Test t = new Test();
		
//		t.testIntRange();
		t.multiply(50000, 5000);
		
	}
	
	public void testIntRange()
	{
		int count = 0;
		while (1 == 1)
		{
			System.out.println(count);
			count = count + 10000;
		}
	}
	
	public void multiply(int a, int b) 
	{
		int result = a * b;
		System.out.println(result);
		
	}

}
