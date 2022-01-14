
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
	private String objectName;
	
	/**
	 * Inventory for storing items
	 */
	private Item[] objectInventory;
	
	/**
	 * Running total of items
	 */
	private int noOfItems;
		
	/**
	 * Constructor method
	 */
	public GameObject() {
		objectInventory = new Item[50]; 
		//All objects by default have space for 50 items, well above whats needed but not ideal for 
		//when game gets bigger as code would have to be updated
	}
	
	/**
	 * Method for setting the name of an object
	 * 
	 * @param name Desired name of object
	 */
	public void setName(String name) {
		this.objectName = name;
	}
	
	/**
	 * Method for returning the name of he object
	 * 
	 * @return name Name of object
	 */
	public String getName() {
		return objectName;
	}
	
	/**
	 * Method allows for subclasses to override inventory size.
	 * 
	 * @param inventory New inventory for object
	 */
	@Override
	public void setInventory(Item[] inventory) {
		this.objectInventory = inventory;
	}
	
	/**
	 * Method for adding an item to the inventory
	 * 
	 * @param item Item to be added
	 */
	@Override
	public void addToInventory(Item item) {
		for(int i = 0; i < objectInventory.length; i++) { //Loop over inventory to find a space
			if(objectInventory[i] == null && item != null) {//Only add item if its not null!
				objectInventory[i] = item;
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
		for(int i = 0; i < objectInventory.length; i++) {//Loop over inventory to find item
			if(objectInventory[i] != null && objectInventory[i].toString().matches("(?i)"+itemName)) { //If item is found and not null
				item = objectInventory[i];//Save item to temp variable
				objectInventory[i] = null; //Remove item from inventory
				break; //Only remove 1 item
			}
		}
		noOfItems--;
		return item;
	}
	
	/**
	 * Method for transferring items between inventories
	 * @param itemName item to transfer
	 * @param toInventory gameobject to transfer to
	 * @return success whether the transfer was successful or not
	 */
	@Override
	public boolean transferItem(String itemName, GameObject toInventory) {
		
		boolean success = false;
		
		if(!toInventory.isInventoryfull()) {
			Item itemToTransfer = removeFromInventory(itemName);
			if(itemToTransfer != null) {
				toInventory.addToInventory(itemToTransfer);
				success = true;
			}	
		}
		return success;
	}
	
	/**
	 * Method for removing all items from an inventory.
	 * 
	 * @return items Array of all items in inventory
	 */
	@Override
	public Item[] removeAllFromInventory() {
		Item[] items = new Item[objectInventory.length];
		
		for(int i = 0; i < objectInventory.length; i++) {
			items[i] = objectInventory[i]; //Add item to array
			objectInventory[i] = null; //Remove item from inventory
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
		return objectInventory;
	}
	
	/**
	 * Method for checking whether the inventory is full
	 * 
	 * @return true or false
	 */
	@Override
	public boolean isInventoryfull() {
		if(noOfItems == objectInventory.length) { //If noOfItems = inventory size inventory is full
			return true;
		}
		return false;
	}
	
	/**
	 * toString method that returns the name of the object
	 * 
	 * @return name of item
	 */
	@Override
	public String toString() {
		return getName();
		
	}
	
}
