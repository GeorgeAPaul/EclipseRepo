package testDome;

public class Palindrome {
    public static boolean isPalindrome(String word) {
        //throw new UnsupportedOperationException("Waiting to be implemented.");
        boolean answer = false;
        String reverse = "";
        
        word = word.toLowerCase();
        
        for (int i = word.length() - 1; i >= 0; i--)
        {
            Character t = word.charAt(i);
            
            reverse = reverse + t;
        }
        
       // System.out.println(reverse);
        
        if (word.matches(reverse))
        {
        	answer = true;
        }
        
        return answer;
    }
    
    public static void main(String[] args) {
        System.out.println(Palindrome.isPalindrome("Deleveled"));
    }
}
