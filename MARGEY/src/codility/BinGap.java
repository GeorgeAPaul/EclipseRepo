package codility;

public class BinGap {
	
public static void main(String[] args) {
		
		BinGap c = new BinGap();
		
		int S = 1147483649;
		
		System.out.println(c.solution(S));

	}

public int solution(int A)
{
	String string = Integer.toBinaryString(A);
	System.out.println(string);
	int zeroCount = 0;
	int maxZero = 0;
	int gapLength = 0;
	
	for (int i = 0; i < string.length(); i++)
	{
		Character test = string.charAt(i);
		
		if (test.equals('1'))
		{
			gapLength = zeroCount;
			if (gapLength > maxZero)
			{
				maxZero = gapLength;
			}
			zeroCount = 0;
		}
		else
		{
			zeroCount++;
		}
	}
	
	return maxZero;
}

public int recentSolution(int N) 
{
    String binaryString = Integer.toBinaryString(N);
    int binaryGap = 0;
    int maxBinaryGap = 0;
    
    for(int i = 1; i < binaryString.length(); i++) 
    {
        char tt = binaryString.charAt(i-1);
        char t = binaryString.charAt(i);
        
        if (t == '0' && tt == '1')
        {
            binaryGap = 1;
        }
        
        if (t == '0' && tt == '0')
        {
            binaryGap++;
        }
        
        if ((t =='1' && tt == '0') && binaryGap > maxBinaryGap)
        {
            maxBinaryGap = binaryGap;
        }
    }
    
    return maxBinaryGap;
}

}
