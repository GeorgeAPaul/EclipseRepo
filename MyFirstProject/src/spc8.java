public class spc8 {
	
	public static String removeWords(String sentence, String word) {
		
		StringBuilder newSentence = new StringBuilder();
		
		String[] splitSentence = sentence.split(" ");
		
		for(int i = 0 ; i < splitSentence.length; i++) {
			if(!splitSentence[i].equals(word)) {
				newSentence.append(splitSentence[i] + " ");
			}
		}
		
		newSentence.setLength(newSentence.length() - 1);
		
		return newSentence.toString();
	}

	public static void main(String[] args) {
		
		System.out.println(removeWords("The Sheeps Ship Cheap Sheets by Ship", "Ship"));


	}

}
