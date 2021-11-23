import java.util.Arrays;

public class spc7 {
	
	public static String removeOccurences(String sentence, char[] c) {
		StringBuilder newSentence = new StringBuilder();
		
		for(int j = 0; j < c.length; j++) {
			char character = c[j];
			for(int i = 0; i < sentence.length(); i++) {
				if (sentence.charAt(i) != character) {
					newSentence.append(sentence.charAt(i));
				}
			}
			sentence = newSentence.toString();
			newSentence.setLength(0);
		}
		
		return sentence;
	}

	public static void main(String[] args) {
		
		char[] array = {'e','A','p'};
		System.out.println(removeOccurences("AppliedComputerScience", array));


	}

}
