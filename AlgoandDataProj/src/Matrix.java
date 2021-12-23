public class Matrix<E extends Comparable<E>> {

	private Object[][] matrix;
	
	public Matrix(int nrNodes) {

		matrix = new Object[nrNodes][nrNodes];
		
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix.length; j++) {
				matrix[i][j] = 0;
			}
		}
		
	}
	public void set(int row , int col , E weight) {
		matrix[row][col] = weight;
	}
	
	public E get(int row , int col) {
		return (E)matrix[row][col];
	}
	
	public String toString() {
		String s = "";
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix.length; j++) {
				s += matrix[i][j];
			}
			s += "\n";
		}
		return s;
	}
}
