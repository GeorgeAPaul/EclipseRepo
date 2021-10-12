package codility;

import java.util.*;

public class TriangleC {

	public static void main(String[] args) {
		int[] test = {1,3,4,5,6};

		TriangleC t = new TriangleC();
		
		System.out.println(t.solution(test));
	}

public int solution(int[] A) {
        
        //Arrays.sort(A);
        int answer = 0;
        for(int i = A.length; i >= 3; i--)
        {
        if((long)A[i - 3] + (long)A[i - 2] > (long)A[i - 1])
        {
            answer = 1;
        }  
        }
        
        if (A.length == 0)
        {
            return 0;
        }
        
        return answer;
    }

}
