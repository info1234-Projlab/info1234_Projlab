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
	public StableField(int capacity, int snowLayer) {
		super(capacity, snowLayer);
	}
	
	/**
	 * A stabil mez� sose borul ez�rt isFall() fasle-al t�r vissza
	 */
	public boolean IsFall(int tab) {
		return false;
	}
	
	public void Fall() {
	}
}
