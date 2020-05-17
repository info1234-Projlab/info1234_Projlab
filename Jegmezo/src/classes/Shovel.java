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
	/**
	 * Konstruktor
	 * @param layer : ezen a retegen van a targy 
	 * @param visible : lathato e a targy
	 */
	public Shovel(int layer,boolean visible) {
		super(layer, visible);
		view = new ShovelView("shovel.png");
	}
	
	/**
	 * 
	 *  A függvény meghívására a játékos két réteg havat/jeget takaríthat el a jégtábláról.
	 * @param p     Az a játékos, aki ás az ésóval. 
	 * @param tab	Indentálást jelzi. 
	 */
	public boolean Dig(CanMove p) {
		if (p.GetNumOfAction() <= 0)
			return false;
		p.DigPlayer(2);
		return true;
	}
}
