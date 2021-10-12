package codility;

public class Froggy {

	public static void main(String[] args) {
		
		Froggy c = new Froggy();

		
		System.out.println(c.solution(999999999, 1000000000, 1000000000));

	}
	
	public int solution(int i, int j, int k) {
		
		return (int) Math.ceil(((double)j - (double)i) / (double)k);
	}
}
