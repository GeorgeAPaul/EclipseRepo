
public class Item extends GameObject {
		
	public Item(String name) {
		setName(name);
	}

	@Override
	public String toString() {
		return getName();
		
	}

}
