import java.util.Arrays;

public class Matrix<E extends Comparable<E>> {

	private int[][] matrix;
	
	public Matrix(int nrNodes) {

		matrix = new int[nrNodes][nrNodes];
		
	}
//	public void set(int row , int col , Comparable weight) {
//// store the weight at the given row and column.
//	}
//	public E get(int row , int col) {
//// return the weight at the given row and column.
//	}
	
	public String toString() {
		String s = "";
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix.length; j++) {
				s += matrix[i][j];
			}
		}
		return s;
	}
}
