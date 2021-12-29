
public interface HasInventory {

	public boolean isInventoryfull();

	public Item[] getInventory();

	public Item[] removeAllFromInventory();

	public Item removeFromInventory(String itemName);

	public void addToInventory(Item item);

}
