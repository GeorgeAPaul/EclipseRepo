package codility;

import java.util.*;

public class EquiLeader {
	
public int solution(int[] A) {
        
        int[] countF = new int[2000000001];
        int[] countB = new int[2000000001];
        
        int[] pSumF = new int[A.length];
        int[] pSumB = new int[A.length];
        
        int leaderF = 0;
        int leaderB = 0;
        
        for(int i = 0, j = A.length - 1; i < A.length && j >-1; i++, j--)
        {
            int indexF = A[i] + 1000000000;
            int indexB = A[j] + 1000000000;
            
            countF[indexF]++;
            countB[indexB]++;
            
            if(countF[indexF] > leaderF)
            {
                leaderF = A[i];
            }
            
            if(countB[indexB] > leaderB)
            {
                leaderB = A[j];
            }
            
            
            pSumF[i] = leaderF;
            pSumB[j] = leaderB;
        }
        
        System.out.println(Arrays.toString(pSumF));
        System.out.println(Arrays.toString(pSumB));
        
        
        return 0;
    }

}
