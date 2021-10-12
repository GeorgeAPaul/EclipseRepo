package codility;

public class FrogJmp {

	public static void main(String[] args) {
		
		FrogJmp f = new FrogJmp();
		
		System.out.println(f.solution(1, 1000000000, 10));
	}
		
		public int solution(int X, int Y, int D)
		{
			int jumps = 0;
			double distance = Y - X;
			
			//System.out.print(Math.ceil(distance / D));
			
			jumps = (int)(Math.ceil(distance / D));
			
			return jumps;
		}

}
