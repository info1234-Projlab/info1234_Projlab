//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : Player.java
//  @ Date : 3/27/2020
//  @ Author : 
//
//

import java.util.ArrayList;

/**
 * A játékosokat egységbe foglalja, a felelőssége a különböző hősökkel történő lépések
 *	menedzselése és azok testhőjének, munkavégzésének figyelése.
 *	@param hp	  a játékos aktuális testhőjét tárolja.
 *	@param numOfAction	 A játékos által még elvégezhető tevékenységeknek a
 *	száma. Jellemzően 0-4 közötti értéket vehet fel. Kör elején 4 értékre állítódik
 *	be.
 *	@param field	 A játékos aktuális tartózkodási mezőjét tárolja.
 *	@param maxHp	 A játékos maximálisan elérhető testhőjét tárolja.
 *	
 *	@param items	 Tárolja a különböző itemeket.
 *	@param win	 Alapértéke false, akkor válik igazzá, ha elsütötték a
 *	jelzőfegyvert.
 *
 *
 */

public class Player {
	protected int hp;
	protected int numberOfAction;
	protected int maxHp;
	protected boolean win;
	private Field field;
	private ArrayList<Item> items;

	
	/**
	 * 
	 * @param maxHp	konstruktornak átadott maxHp érték
	 * @param field	konstruktornak átadott field, ide rakjuk le a játékost
	 */
	public Player(int maxHp, Field field) {	
		this.hp = maxHp;
		this.maxHp = maxHp;
		this.numberOfAction = 4;
		this.win = false;
		this.field = field;
	}
	
	/**
	 * A játékos használja a képességét. Az eszkimó iglut épít, a sarkkutató jeget kutat. 
	 */
	public void UseAbility() {
	}
	
	public void Move(Field f) {
	}
	
	public void IncreaseHp() {
	}
	
	public void DecreaseHp() {
	}
	
	public void AddItem(Inventory i) {
	}
	
	public void RemoveItem(Inventory i) {
	}
	
	public void StartTurn(int numOfAction) {
	}
	
	public void DigPlayer(int layers) {
	}
	
	public void SwimPlayer() {
	}
	
	public void PullPlayer() {
	}
}
