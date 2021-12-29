
public class GameObject implements HasInventory {
	
	protected String name;
	protected Item[] inventory;
		
	public GameObject() {
		inventory = new Item[10];
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public void addToInventory(Item item) {
		for(int i = 0; i < inventory.length; i++) {
			if(inventory[i] == null) {
				inventory[i] = item;
				break;
			}
		}
	}
	
	@Override
	public Item removeFromInventory(String itemName) {
		Item item = null;
		for(int i = 0; i < inventory.length; i++) {
			if(inventory[i] != null && inventory[i].toString() == itemName) {
				item = inventory[i];
				inventory[i] = null;
				return item;
			}
		}
		return item;
	}
	
	@Override
	public Item[] removeAllFromInventory() {
		Item[] items = new Item[inventory.length];
		
		for(int i = 0; i < inventory.length; i++) {
			items[i] = inventory[i];
			inventory[i] = null;
		}
		return items;
	}
	
	@Override
	public Item[] getInventory() {
		return inventory;
	}
	
	@Override
	public boolean isInventoryfull() {
		int noOfItems = 0;
		for(int i = 0; i < inventory.length; i++) {
			if(inventory[i] != null) {
				noOfItems++;
			}
		}
		
		if(noOfItems == inventory.length) {
			return true;
		}
		
		return false;
	}
	
}
