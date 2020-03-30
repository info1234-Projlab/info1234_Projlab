package classes;
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : Food.java
//  @ Date : 3/27/2020
//  @ Author : 
//
//

/**
 * Ez az osztály egy felvehető és eldobható tárgyat reprezentál. Aki felhasználja a tárgyat, 
 * annak életereje megnő eggyel.  A tárgyat csak egyszer lehet használni, tehát használat után megsemmisül. 
 *
 */



public class Food extends Item {

	public Food(int layer,boolean visible, int tab) {
		super(layer, visible);
		for(int i=0; i<tab; i++)
			System.out.print("\t");
		System.out.println("A Food osztály konstruktora hivodott meg");
		
	}
	
	/**
	 * 
	 * A függvény meghívására a játékosnak egyel megnő a testhője, hogyha ez lehetséges (nem érte még el a maximumot).
	 * @param p     Az a játékos, aki megeszi az ételt. 
	 * @param tab	Indentálást jelzi. 
	 */
	public boolean Eat(Player p, int tab) {
		for(int i=0; i<tab; i++)
			System.out.print("\t");
		System.out.println("A Food osztály Eat(p: Player) fuggvenye hivodott meg");
		if (p.GetNumOfAction(tab + 1) <= 0)
			return false;
		if (p.GetHP(tab + 1) == p.GetMaxHP(tab + 1)) {
			return false;
		}
		p.IncreaseHp(tab + 1);
		p.SetNumOfAction(p.GetNumOfAction(tab + 1) - 1, tab + 1);
		p.RemoveItem(this, tab + 1);
		return true;
	}
}
