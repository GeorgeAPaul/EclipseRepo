import java.util.Arrays;

public class GameObject {
	
	protected String name;
	protected Item[] inventory;
	int coordinates[];
	
	public GameObject() {
		inventory = new Item[10];
	}
	
	public void addToInventory(Item item) {
		for(int i = 0; i < inventory.length; i++) {
			if(inventory[i] == null) {
				inventory[i] = item;
				break;
			}
		}
	}
	
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
	
	public Item[] removeAllFromInventory() {
		Item[] items = new Item[inventory.length];
		
		for(int i = 0; i < inventory.length; i++) {
			items[i] = inventory[i];
			inventory[i] = null;
		}
		return items;
	}
	
	public Item[] getInventory() {
		return inventory;
	}
	
}
