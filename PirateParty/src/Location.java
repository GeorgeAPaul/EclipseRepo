
public class Location {
	
	private boolean isSea;
	
	public Location() {
		int decide = (int)(Math.random() + 0.5);
		
		if(decide == 1) {
			isSea = true;
		}
		else {
			isSea = false;
		}
		
	}
	
	public boolean getIsSea() {
		return isSea;
	}
	
	public void setIsSea(boolean isSea) {
		this.isSea = isSea;
	}
	
	public String toString() {
		if(isSea) {
			return "{ }";
		}
		return "| |";		
	}

}
