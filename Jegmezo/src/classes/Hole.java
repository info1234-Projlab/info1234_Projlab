package classes;




/**
 * Egy �lyukas� mez�t reprezent�l, teh�t egy j�t�kost se b�r el ez a mez�.
 *
 */
public class Hole extends Field {
	
	public Hole(int tab) {
		super(0, 0, tab);
		for(int i=0; i<tab; i++)
			System.out.print("\t");
		System.out.println("A Hole osztaly konstruktora hivodott meg.");
	}
	
	
	/**
	 * A luk mindig borul ez�rt isFall() true-al t�r vissza.
	 */
	public boolean IsFall(int tab) {
		for(int i=0; i<tab; i++)
			System.out.print("\t");
		System.out.println("Az Hole osztaly IsFall() fuggvenye hivodott meg.");
		return true;
	}
	
	
	public void CanBuildIglu() {
	}
	
	public void AddItem(Inventory item) {
	}
	
	public void DigItems(int layers) {
	}
	
	/*public boolean IsFull() {
	}*/
	
	public void RemoveItem(Inventory item) {
	}
}
