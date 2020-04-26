package classes;

import java.util.ArrayList;
/**
 * Egy �stabil� mez�t reprezent�l, b�rmennyi j�t�kost elb�r.
 */
public class StableField extends Field {
	
	/**
	 * Konstruktor
	 * @param capacity : mezo kapacitasa
	 * @param snowLayer : mezon levo horeteg
	 */
	public StableField(int capacity, int snowLayer) {
		super(capacity, snowLayer);
	}
	
	/**
	 * A stabil mez� sose borul ez�rt isFall() fasle-al t�r vissza
	 */
	public boolean IsFall(int tab) {
		return false;
	}
	/**
	 * Nem valositjuk meg, stabilon soha nem esunk vizbe. 
	 */
	public void Fall() {
	}
}
