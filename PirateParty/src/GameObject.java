import java.util.Arrays;

public class GameObject implements HasInventory {
	
	private String name;
	private Item[] inventory;
	private int noOfItems;
		
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
	public void setInventory(Item[] inventory) {
		this.inventory = inventory;
	}
	
	@Override
	public void addToInventory(Item item) {
		for(int i = 0; i < inventory.length; i++) {
			if(inventory[i] == null && item != null) {
				inventory[i] = item;
				noOfItems++;
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
				break;
			}
		}
		noOfItems--;
		return item;
	}
	
	@Override
	public Item[] removeAllFromInventory() {
		Item[] items = new Item[inventory.length];
		
		for(int i = 0; i < inventory.length; i++) {
			items[i] = inventory[i];
			inventory[i] = null;
		}
		
		noOfItems =  0;
		return items;
	}
	
	@Override
	public Item[] getInventory() {
		return inventory;
	}
	
	@Override
	public boolean isInventoryfull() {
		if(noOfItems == inventory.length) {
			return true;
		}
		return false;
	}
	
}
