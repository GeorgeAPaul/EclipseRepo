package codility;

public class LowestBinaryGap {
	
	public static void main(String[] args) 
	{
		LowestBinaryGap g = new LowestBinaryGap();
		
		System.out.println(g.solution(561892));
	}

	public int solution(int N) {
		
		int binaryGapLength = 0;
		int binaryGapLengthTest = 0;
		
        String binary = Integer.toBinaryString(N);
        String[] stringArray = binary.split("");
        
        //System.out.println(binary);
        //System.out.println(Arrays.toString(stringArray));
        
        for (int i = 0; i < stringArray.length; i++)
        {
        	if (stringArray[i].matches("0") == true)
        	{
        		//if (stringArray[i+1].matches("0") == true)
        		//{
        		binaryGapLengthTest ++;
        		//System.out.println("test");
        		//}
        		if (i < (stringArray.length - 1) && stringArray[i+1].matches("1") == true)
        		{
        			if (binaryGapLengthTest > binaryGapLength)
        			{
        				binaryGapLength = binaryGapLengthTest;
            			binaryGapLengthTest = 0;
        			}
        			else 
        			{
        				binaryGapLengthTest = 0;
        			}
        			        		
        		}
        	}
        }
        return binaryGapLength;
    }
	
	
}
