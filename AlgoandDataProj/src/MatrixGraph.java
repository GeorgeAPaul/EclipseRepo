public class MatrixGraph<T extends Comparable<T>> {

	private Matrix<T> data;
	private int nrNodes;

	public MatrixGraph(int nrNodes) {
		data = new Matrix<T>(nrNodes);
		this.nrNodes = nrNodes;
	}
	
	public void addEdge(int from, int to, T w) {
		data.set(from, to, w);
		}
	
	public T getEdge(int from, int to) {
		return (T)data.get(from, to);
	}
	
	public String toString() {
		String s = "   ";
        for(int i = 0; i < nrNodes; i++) {
        	s += i + "||";
        }
        s += "\n";
		for(int i = 0; i < nrNodes; i++) {
			s += i + "||";
			for(int j = 0; j < nrNodes; j++) {
				s += data.get(i,j) + "||";
			}
			s += "\n";
		}
		
		return s;
	}
}
