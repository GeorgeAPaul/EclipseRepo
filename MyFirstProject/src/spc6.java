public class spc6 {
	
	public static String removeOccurences(String sentence, char c) {
		StringBuilder newSentence = new StringBuilder();
		
		for(int i = 0; i < sentence.length(); i++) {
			if (sentence.charAt(i) != c) {
				newSentence.append(sentence.charAt(i));
			}
		}
		
		return newSentence.toString();
	}

	public static void main(String[] args) {
		
		System.out.println(removeOccurences("AppliedComputerScience",'e'));


	}

}
