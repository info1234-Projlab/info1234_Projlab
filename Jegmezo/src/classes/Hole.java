package classes;




/**
 * Egy lyukas mezot reprezental, tehet egy jatekost se bir el ez a mezo.
 *
 */
public class Hole extends Field {
	
	public Hole() {
		super(0, 0);
		view = new HoleView(this);
	}
	
	
	/**
	 * A lyuk mindig borul ezert isFall() true-val ter vissza.
	 */
	public boolean IsFall() {
		return true;
	}
	
	/**
	 * Visszaadja tudunk-e iglut építeni, mivel lyuk-ról van szó ezért nem.
	 */
	public boolean CanBuildIglu() {
		return false;
	}
	
	public void AddItem(Inventory item) {
	}
	
	public boolean InitInventory(Inventory item) {
		return false;
	}
	
	public boolean DigItems(int layers) {
		return false;
	}
	
	/*public boolean IsFull() {
	}*/
	
	public void RemoveItem(Inventory item) {
	}
}
