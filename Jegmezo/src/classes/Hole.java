package classes;





public class Hole extends Field {
	
	public Hole(int tab) {
		super(0, 0, tab);
		for(int i=0; i<tab; i++)
			System.out.print("\t");
		System.out.println("A Hole osztaly konstruktora hivodott meg.");
	}
	
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
	
	public boolean IsFull() {
	}
	
	public void RemoveItem(Inventory item) {
	}
}
