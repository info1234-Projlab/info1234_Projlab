package classes;

import java.util.ArrayList;
/**
 * Egy “stabil” mezõt reprezentál, bármennyi játékost elbír.
 */
public class StableField extends Field {
	
	public StableField(int capacity, int snowLayer, int tab) {
		super(capacity, snowLayer, tab);
		for(int i=0; i<tab; i++)
			System.out.print("\t");
		System.out.println("A StableField osztaly konstruktora hivodott meg.");
	}
	
	/**
	 * A stabil mezõ sose borul ezért isFall() fasle-al tér vissza
	 */
	public boolean IsFall(int tab) {
		for(int i=0; i<tab; i++)
			System.out.print("\t");
		System.out.println("Az StableField osztaly IsFall() fuggvenye hivodott meg.");
		return false;
	}
	
	public void Fall() {
	}
}
