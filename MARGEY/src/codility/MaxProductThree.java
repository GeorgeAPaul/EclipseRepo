package codility;

import java.util.Arrays;

public class MaxProductThree {

	public static void main(String[] args) {
		
		MaxProductThree c = new MaxProductThree();

		int[] test = {-5,5,-5,4};
		System.out.println(c.solution(test));

	}
	
public int solution(int[] A) {
        
        Arrays.sort(A);
        int length = A.length;
        int answer = A[length - 1] * A[length - 2] * A[length - 3];
        int negAnswer = A[0] * A[1] * A[length -1];
        
        if(negAnswer > answer)
        {
        	answer = negAnswer;
        }
        return answer;
    }
}
