package codility;

public class CyclicRotation1 {
	
	class Solution {
	    public int[] solution(int[] A, int K) {
	    
	        int[] answer = new int[A.length];
	        
	        if(A.length == 1)
	        {
	            return A;
	        }
	        
	        if(K == 0)
	        {
	            return A;
	        }
	        
	        if (K > A.length)
	        {
	            K = K % A.length;
	        }
	        
	        for(int i = 0; i < A.length; i++)
	        {
	            if(i+K < A.length)
	            {
	                answer[i+K] = A[i];
	            }
	            
	            else
	            {
	                answer[i+K-A.length] = A[i];
	            }
	        }
	        return answer;
	    }

	}
	
}
