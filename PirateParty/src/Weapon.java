
public class Weapon extends Item {

	private int damage;
	private String[] weaponList = {"Sword", "Gun", "Sausage", "Bow", "Whip", "Bazooka"};
	private int[] weaponDamageList = {50, 90, 0, 75, 20, 500};
	
	public Weapon(String name) {
		super(name);
		
		for(int i = 0; i < weaponList.length; i++) {
			if(name == weaponList[i]) {
				this.damage = weaponDamageList[i];
			}
		}
		
		
	}
	
	public int getDamage() {
		return damage;
	}

}
