
public class Item extends GameObject implements Storable {
	
	private String name;
	private boolean isTakeable;
	
	public Item(String name) {
		this.name = name;
//		this.isTakeable = true;
	}

//	@Override
//	public void setIsTakeable(boolean isTakeable) {
//		this.isTakeable = isTakeable;
//		
//	}
//	
//	@Override
//	public boolean getIsTakeable() {
//		return isTakeable;
//		
//	}

	@Override
	public String toString() {
		return name;
		
	}

}
