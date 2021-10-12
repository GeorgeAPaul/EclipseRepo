package codility;

public class TestEquals {
	
	public static void main (String[] args)
	{
		System.out.println("test" == "test");
		System.out.println(96.0 == 97.0);
		String s1 = new String("test");
		String s2 = new String("test");
		System.out.println(s1.matches(s2));
	}

}
