package codility;

import java.util.*;

public class LowestInt 
{

	public static void main(String[] args) 
	{
		ArrayList<Integer> intArgs = new ArrayList<Integer>();
		
		for (String i : args) 
		{
			intArgs.add(Integer.parseInt(i));
		}
		
		Collections.sort(intArgs);
		
		extra:
		for (int i=0; i < intArgs.size(); i++) 
		{
			//System.out.println(intArgs.get(i));
			if(intArgs.get(i) < 0)
			{
				//System.out.println(intArgs.get(i));
				intArgs.remove(i);
				i--;
			}
			
		}
		System.out.println(Arrays.toString(args));
		System.out.println(intArgs);
		
		test:
		for (int i=0; i < intArgs.size(); i++) 
		{
			if(i == intArgs.size()-1)
			{
			    System.out.println(intArgs.get(i) + 1);
			    break test;
			}

			if(intArgs.get(i) == intArgs.get(i+1) || intArgs.get(i) == intArgs.get(i+1) - 1)
			{
			}
			else
			{
				System.out.println(intArgs.get(i) + 1);
				break test;
			}
		}
	}

}
