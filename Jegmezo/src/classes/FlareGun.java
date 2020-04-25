package classes;
import java.util.ArrayList;

//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : FlareGun.java
//  @ Date : 3/27/2020
//  @ Author : 
//
//

/**
 * Az oszt�ly felel�ss�ge a jelz�fegyver menedzsel�se.
 * Figyelnie kell, hogy felvett�k-e az alkatr�szeket, kigy�lt-e m�r mind a h�rom �s a fegyver els�t�s��rt is ez felel�s.
 *
 */


public class FlareGun implements Inventory {
	protected int layer;
	protected boolean visible;
	protected static ArrayList<FlareGun> components;
	
	/**
	 * 
	 * @param layer mennyi r�teg h� van a t�rgy felett
	 * @param visible ez akkor igaz ha l�that�a t�rgy(nincs rajta h�
	 * @param  indent�l�s
	 * m�g van egy ArrayList v�ltaz�ja is amiben a pisztolytartoz�kokat fogjuk pakolni, ha felvett�k
	 */
	public FlareGun(int layer, boolean visible) {
		this.layer=layer;
		this.visible=visible;
		this.components=new ArrayList<FlareGun>();
	}
	
	
	public boolean Shoot(Player p) {
		if (p.GetNumOfAction() <= 0)
			return false;
		if (components.size() == 3) {
			return false;
		}
		p.SetWin(true);
		return true;
		
	}
	
	public boolean Eat(Player p) {
		return false;
	}
	
	public boolean Dig(CanMove p) {
		return false;
	}
	
	public boolean PutOn(Player p) {
		return false;
	}
	
	public boolean Swim(Player p) {
		return false;
	}
	
	/**
	 * Ha valaki el szeretne dobni egy t�rgyat akkor h�v�dik ez a f�ggv�ny. 
	 * Ilyenkor, a param�ter�l kapott Player items t�rol�j�b�l kiveszi az adott t�rgyat �s �leteszi� a f�ldre,
	 *  azaz a Player field-j�nek az items t�rol�j�ba, ezen k�v�l a saj�t components t�rol�j�b�l is kiveszi mag�t.
	 */
	public void Drop(CanMove p) {
		p.RemoveItem(this);
	}
	
	/**
	 *  Ez a f�ggv�ny pedig a t�rgyak felv�tel�re szolg�l.
	 *   Teh�t, ha valaki felvesz egy t�rgyat, a Field items t�rol�j�b�l �tker�l a Player items t�rol�j�ba.
	 *    Ezen k�v�l beteszi mag�t a saj�t components t�rol�j�ba is.
	 */
	public void PickUp(Player p) {
		p.AddItem(this);
		components.add(this);
	}
	
	public void DecreaseLayer(int i) {
		layer -= i;
	}

	public boolean Pull(Player p, Field to) {
		return false;
	}


	public void SetLayer(int num) {
		this.layer=num;
	}

	public int GetLayer() {
		return layer;
	}

	public void SetVisible(boolean b) {
		visible = b;
		
	}
	
	public boolean GetVisible() {
		return visible;
	}

}
