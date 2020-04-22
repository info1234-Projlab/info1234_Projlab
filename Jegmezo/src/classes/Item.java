package classes;


/**
Felel�ss�ge a t�rgyak haszn�lat�nak, el�rhet�s�g�nek �s 
l�that�s�g�nak fel�gyelete. Ez az oszt�ly felel az�rt, hogy az adott t�rgy birtokl�sa 
a j�t�kosra milyen hat�ssal van. 
 *
 */


public class Item implements Inventory {
	protected int layer;
	protected boolean visible;
	
	public Item(int layer, boolean visible) {
		this.layer=layer;
		this.visible=visible;
	}
	
	public boolean Eat(Player p) {
		return false;
	}
	
	public boolean Dig(Player p) {
		return false;
	}
	
	public boolean Pull(Player p, Field to) {
		return false;
	}
	
	public boolean PutOn(Player p) {
		return false;
	}
	
	public boolean Shoot(Player p) {
		return false;
	}
	
	public boolean Swim(Player p) {
		return false;
	}
	
	/**
	 * Ha valaki el szeretne dobni egy t�rgyat akkor h�v�dik ez a 
	 * f�ggv�ny. Ilyenkor, a param�ter�l kapott Player items t�rol�j�b�l kiveszi az adott t�rgyat �s
	 *  �leteszi� a f�ldre, azaz a Player field-j�nek az items t�rol�j�ba.
	 */
	public void Drop(Player p) {
		p.RemoveItem(this,tab+1);
	}
	
	/**
	 * 
	 *  A hórétegeket csökkenti az itemen.
	 *  @param i Mennyivel csökken a hórétegek száma.
	 * @param tab	Indentálást jelzi. 
	 */
	public void DecreaseLayer(int i) {
		layer -= i;
	}
	
	/**
	 * Ez pedig a t�rgyak felv�tel�re szolg�l. Teh�t ha valaki felvesz egy t�rgyat, 
	 * a Field items t�rol�j�b�l �tker�l a Player items t�rol�j�ba.
	 */
	public void PickUp(Player p) {
		p.AddItem(this);
	}
	
	/**
	 * 
	 *  A rétegek számát adja vissza.
	 * @param tab	Indentálást jelzi. 
	 */
	public int GetLayer() {
		return layer;
	}
	
	public void SetLayer(int num) {
		this.layer=num;
	}
	
	/**
	 * 
	 *  A tárgy láthatóságát allítja be.
	 *  @param b A láthatósag.
	 * @param tab	Indentálást jelzi. 
	 */
	public void SetVisible(boolean b) {
		visible = b;
	}
	
	public boolean GetVisible() {
		return visible;
	}
	
	public boolean Pull(Player p) {
		return false;
	}

	public boolean Pull(Player p, Field to) {
		return false;
	}

}
