package classes;

import java.util.ArrayList;
/**
 * Egy �stabil� mez�t reprezent�l, b�rmennyi j�t�kost elb�r.
 */
public class StableField extends Field {
	
	/**
	 * Konstruktor
	 * @param capacity
	 * @param snowLayer
	 * @param tab
	 */
	public StableField(int capacity, int snowLayer, int tab) {
		super(capacity, snowLayer, tab);
		for(int i=0; i<tab; i++)
			System.out.print("\t");
		System.out.println("A StableField osztaly konstruktora hivodott meg.");
	}
	
	/**
	 * A stabil mez� sose borul ez�rt isFall() fasle-al t�r vissza
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
