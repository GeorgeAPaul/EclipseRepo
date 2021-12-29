
public interface HasInventory {

	/**
	 * Method for checking whether the inventory is full
	 * 
	 * @return true or false
	 */
	public boolean isInventoryfull();

	/**
	 * Method for returning the whole inventory
	 * 
	 * @return inventory as an array
	 */
	public Item[] getInventory();

	/**
	 * Method for removing all items from an inventory.
	 * 
	 * @return items Array of all items in inventory
	 */
	public Item[] removeAllFromInventory();

	/**
	 * Method for removing items from the inventory
	 * 
	 * @param itemName Name of item to be removed
	 * @return item Item to be returned
	 */
	public Item removeFromInventory(String itemName);

	/**
	 * Method for adding an item to the inventory
	 * 
	 * @param item Item to be added
	 */
	public void addToInventory(Item item);

	/**
	 * Method allows for subclasses to override inventory size.
	 * 
	 * @param inventory New inventory for object
	 */
	public void setInventory(Item[] inventory);

}
