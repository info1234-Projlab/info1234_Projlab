package classes;
/**
 * A törékeny ásó tárgy birtoklásának és elvesztésének következményeinek kezelése.
Ha valaki használja akkor két réteg havat takarít el a mezőről azonban három
használat után eltörik és nem lehet használni. Megjegyzés: ezt az ásót akkor
használja a játékos ha nincs nála rendes ásó.
 *
 */

public class FragileShovel extends Item{
	
	private int lifetime;

	public FragileShovel(int layer, boolean visible) {
		super(layer, visible);
		lifetime = 3;
		view = new ItemView("Fragileshovel.png");
	}
	
	/**
	 * A függvény meghívására, ha a törékeny
ásónknak még nem nulla a lifetime értéke, akkor a játékos két réteg
havat/jeget takaríthat el a mezőről. Ezen kívül a lifetime értéke eggyel
csökken. (a többi item esetében false-al tér vissza).
	 */
	public boolean Dig(CanMove p) {
			if (p.GetNumOfAction() <= 0)
				return false;
			p.SetNumOfAction(p.GetNumOfAction() - 1);
			p.DigPlayer(2);
			this.DeceaseLifeTime();
			if(this.lifetime==0)
				p.RemoveItem(this);
			return true;
	}
	/**
	 * eggyel csökkenti a lifetime attribútumának értékét.
	 *	Többit lásd Item ősosztálynál	
	 */
	public void DeceaseLifeTime() {
		lifetime--;
	}

}
