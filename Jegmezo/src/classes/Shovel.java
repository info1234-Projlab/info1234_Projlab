package classes;
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : Shovel.java
//  @ Date : 3/27/2020
//  @ Author : 
//
//


/**
 * Felelőssége az ásó tárgy birtoklásának és elvesztésének következményeinek kezelése. 
 * Ez annyit takar, hogy ha valaki használni szeretné az ásót akkor két réteg havat/jeget takaríthat el a jégtábláról.
 *
 */



public class Shovel extends Item {
	
	public Shovel(int layer,boolean visible) {
		super(layer, visible);
	}
	
	/**
	 * 
	 *  A függvény meghívására a játékos két réteg havat/jeget takaríthat el a jégtábláról.
	 * @param p     Az a játékos, aki ás az ésóval. 
	 * @param tab	Indentálást jelzi. 
	 */
	public boolean Dig(Player p, int tab) {
		for(int i=0; i<tab; i++)
			System.out.print("\t");
		System.out.println("A Shovel osztaly Dig() fuggvenye hivodott meg");
		if (p.GetNumOfAction() <= 0)
			return false;
		p.SetNumOfAction(p.GetNumOfAction() - 1);
		p.DigPlayer(2);
		return true;
	}
}
