package classes;
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
	protected Field field;				//ez eredetileg private volt de az szerintem hülyeség
	protected ArrayList<Item> items;	//ez is

	
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
	
	public Field GetField(int tab) {
		for(int i=0; i<tab; i++)
			System.out.print("\t");
		System.out.println("A Player osztaly GetField():Field fuggvenye hivodott meg.");
		return field;
	}
	
	public void SetField(Field f, int tab) {
		for(int i=0; i<tab; i++)
			System.out.print("\t");
		System.out.println("A Player osztaly SetField(f: Field) fuggvenye hivodott meg.");
		this.field=f;
	}
	
	
	/**
	 * A játékos használja a képességét. Az eszkimó iglut épít, a sarkkutató jeget kutat. 
	 */
<<<<<<< HEAD
	public int GetHP() {
		return hp;
	}
	
	public int GetMaxHP() {
		return maxHp;
	}
	
	public void UseAbility() {
=======
	public void UseAbility(int tab) {
		for(int i=0; i<tab; i++)
			System.out.print("\t");
		System.out.println("A Player osztaly UseAbility() fuggvenye hivodott meg.");
>>>>>>> 6b304ea47f1e11ad222afc7039790040533f41dc
	}
	
	public void Move(Field f, int tab) {
		for(int i=0; i<tab; i++)
			System.out.print("\t");
		System.out.println("A Player osztaly Move(f: Field) fuggvenye hivodott meg.");
	}
	
	public void IncreaseHp() {
		hp += 1;
	}
	
	public void DecreaseHp() {
	}
	
	public void AddItem(Inventory i) {
	}
	
	public void RemoveItem(Inventory i,int tab) {
		for(int j=0; j<tab; j++)
			System.out.print("\t");
		System.out.printf("Az Player oszt�ly RemoveItem(i:Inventory):void h�v�dott meg \n");
	}
	
	
	public void StartTurn(int numOfAction) {
	}
	
	public void DigPlayer(int layers) {
		field.DigItems(layers);
	}
	
	public void SwimPlayer() {
	}
	
	public void PullPlayer() {
	}
	
	public void DecreaseAction(int tab) {
		for(int i=0; i<tab; i++)
			System.out.print("\t");
		if(this.numberOfAction > 0)	this.numberOfAction--; // a feltétel lehet felesleges
		System.out.printf("Akciók száma csökkent, így %d akció van hátra\n", this.numberOfAction);
	}
	public int GetNumOfAction(int tab) {
		for(int i=0; i<tab; i++)
			System.out.print("\t");
		System.out.println("A Player osztaly GetNumOfAction() fuggvenye hivodott meg.");
		return this.numberOfAction;
	}
	public void SetNumOfAction(int n, int tab) {
		for(int i=0; i<tab; i++)
			System.out.print("\t");
		System.out.println("A Player osztaly SetNumOfAction(n: int) fuggvenye hivodott meg.");
		this.numberOfAction = n ;
	}
	public void SetWin(boolean b) {
		win = b;
	}
}
