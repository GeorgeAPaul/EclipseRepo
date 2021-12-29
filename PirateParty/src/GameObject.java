
/**
 * Class to represent basic game object, i.e. something with a name and an inventory.
 * 
 * @author George Paul
 *
 */
public class GameObject implements HasInventory {
	
	/**
	 * Name of object
	 */
	private String name;
	
	/**
	 * Inventory for storing items
	 */
	private Item[] inventory;
	
	/**
	 * Running total of items
	 */
	private int noOfItems;
		
	/**
	 * Constructor method
	 */
	public GameObject() {
		inventory = new Item[50]; 
		//All objects by default have space for 50 items well above whats needed but not ideal for 
		//when game gets bigger as code would have to be updated
	}
	
	/**
	 * Method for setting the name of an object
	 * 
	 * @param name Desired name of object
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Method for returning the name of he object
	 * 
	 * @return name Name of object
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Method allows for subclasses to override inventory size.
	 * 
	 * @param inventory New inventory for object
	 */
	@Override
	public void setInventory(Item[] inventory) {
		this.inventory = inventory;
	}
	
	/**
	 * Method for adding an item to the inventory
	 * 
	 * @param item Item to be added
	 */
	@Override
	public void addToInventory(Item item) {
		for(int i = 0; i < inventory.length; i++) { //Loop over inventory to find a space
			if(inventory[i] == null && item != null) {//Only add item if its not null!
				inventory[i] = item;
				noOfItems++;
				break; // Only add item once
			}
		}
	}
	
	/**
	 * Method for removing items from the inventory
	 * 
	 * @param itemName Name of item to be removed
	 * @return item Item to be returned
	 */
	@Override
	public Item removeFromInventory(String itemName) {
		Item item = null;
		for(int i = 0; i < inventory.length; i++) {//Loop over inventory to find item
			if(inventory[i] != null && inventory[i].toString() == itemName) { //If item is found and not null
				item = inventory[i];//Save item to temp variable
				inventory[i] = null; //Remove item from inventory
				break; //Only remove 1 item
			}
		}
		noOfItems--;
		return item;
	}
	
	/**
	 * Method for removing all items from an inventory.
	 * 
	 * @return items Array of all items in inventory
	 */
	@Override
	public Item[] removeAllFromInventory() {
		Item[] items = new Item[inventory.length];
		
		for(int i = 0; i < inventory.length; i++) {
			items[i] = inventory[i]; //Add item to array
			inventory[i] = null; //Remove item from inventory
		}
		
		noOfItems =  0;
		return items;
	}
	
	/**
	 * Method for returning the whole inventory
	 * 
	 * @return inventory as an array
	 */
	@Override
	public Item[] getInventory() {
		return inventory;
	}
	
	/**
	 * Method for checking whether the inventory is full
	 * 
	 * @return true or false
	 */
	@Override
	public boolean isInventoryfull() {
		if(noOfItems == inventory.length) { //If noOfItems = inventory size inventory is full
			return true;
		}
		return false;
	}
	
}
