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

public class Player implements CanMove{
	protected int hp;
	protected int numberOfAction;
	protected int maxHp;
	protected boolean win;
	protected Field field;				//ez eredetileg private volt de az szerintem hülyeség
	protected ArrayList<Inventory> items;	//ez is

	
	/**
	 * 
	 * @param maxHp	konstruktornak átadott maxHp érték
	 * @param field	konstruktornak átadott field, ide rakjuk le a játékost
	 */
	public Player(int maxHp) {	
		this.hp = maxHp;
		this.maxHp = maxHp;
		this.numberOfAction = 4;
		this.win = false;
		//this.field = field;
		items = new ArrayList<Inventory>();
	}
	
	public Field GetField() {
		return field;
	}
	
	public void SetField(Field f) {
		this.field=f;
	}
	
	public boolean IsDead() {
		if(hp==0)
			return true;
		return false;
	}
	
	
	/**
	 * 
	 *  A jelenlegi testhőt adja vissza
	 * @param tab	Indentálást jelzi. 
	 */
	public int GetHP() {
		return hp;
	}
	
	/**
	 * 
	 *  A maximális testhőt adja vissza
	 * @param tab	Indentálást jelzi. 
	 */
	public int GetMaxHP() {
		return maxHp;
	}
	
	/**
	 * A játékos használja a képességét. Az eszkimó iglut épít, a sarkkutató jeget kutat. 
	 */
	public void UseAbility() {
	}
	/**
	 * Egy helyvaltoztatas es abbol adodo vizbeeses tesztelese
	 * @param f
	 * @param tab
	 */
	public void Move(Field f) {	
		//Szomszedos a celmezo
		if(this.field.isNeighour(f)){
			this.field.RemovePlayer(this);
			f.AddCreature(this);
			this.field = f;
			
			//Lukba lepett e a jatekos
			if(f.IsFall()){
				f.Fall();
				
			}
			//Ha nem, a lepes sikeres
			else{
				System.out.println("A jatekos atlepett a mezore");
				return;
			}
		}
		//Ha nem szomszedos a celmezo
		else{
			System.out.println("Nem szomszedos mezore probalsz lepni.");
			return;
		}
	}
	
	/**
	 * 
	 *  A testhőt növeli
	 * @param tab	Indentálást jelzi. 
	 */
	public void IncreaseHp() {
		hp++;
	}
	
	public void DecreaseHp() {
		hp--;
	}
	
/*
	public void AddItem(Inventory i, int tab) {
		for(int j=0; j<tab; j++)
			System.out.print("\t");
		System.out.printf("Az Player osztaly AddItem(i:Inventory):void hivodott meg \n");
*/
	/**
	 * A kapott Inventory-t beteszi az items list�j�ba.
	 */
	public void AddItem(Inventory i) {
		items.add(i);
	}
	
	/**
	 *  Eltávolít egy itemet a játékos inventoryjából.
	 *  @param i az eltávolítandó item.
	 *  @param tab	Indentálást jelzi. 
	 * A kapott Inventory-t kiveszi az items list�j�b�l.
	 */
	public void RemoveItem(Inventory i) {
		items.remove(i);
	}
	
	
	public void StartTurn(int numOfAction) {
	}
	
	/**
	 * 
	 *  Eltávolít pár hóréteget a mezőről.
	 *  @param layers A hórétegek száma.
	 * @param tab	Indentálást jelzi. 
	 */
	public void DigPlayer(int layers) {
		field.DigItems(layers);
	}
	
	/**
	 * A player osztaly SwimPlayer() metodusa, akkor hivodik meg, amikor beleesik egy jatekos a vizbe.
	 * @param tab
	 */
	public void SwimPlayer() {
		for(Inventory i : items){
			i.Swim(this);
		}
	}
	
	
	/**
	 * Egy jatekos kiment egy masik jatekost a vizbol.
	 * @param tab
	 * @param p
	 */
	public void PullPlayer(Player p) {
		for(Inventory i : items)
			i.Pull(p, this.field);
	}
	
	public void DecreaseAction() {
		if(this.numberOfAction > 0)	
			this.numberOfAction--; // a feltétel lehet felesleges
	}
	
	/**
	 * 
	 *  Visszaadja a hátralévő lépések számát.
	 * @param tab	Indentálást jelzi. 
	 */
	public int GetNumOfAction() {
		return this.numberOfAction;
	}
	/**
	 * 
	 *  Beállítja a hátralévő lépések számát.
	 *  @param n a lépések száma.
	 *  @param tab	Indentálást jelzi. 
	 */
	public void SetNumOfAction(int n) {
		this.numberOfAction = n ;
	}
	
	/**
	 * 
	 *  Beálítja a játékos megnyerte-e már a játékot.
	 *  @param b Megnyerte-e a játékos a játékot.	
	 * @param tab	Indentálást jelzi. 
	 */
	public void SetWin(boolean b) {
		win = b;
	}
	
	public void SetHp(int hp){
		this.hp = hp;
	}


	@Override
	public void StepOnBear() {
		// TODO Auto-generated method stub
		
	}
	
	public void PutOnDivingSuit() {
		for(int i=0; i<items.size();i++) {
			items.get(i).PutOn(this);
		}
	}
	
	public void Eat() {
		for(int i=0; i<items.size();i++) {
			items.get(i).Eat(this);
		}
	}

	@Override
	public void PullPlayer(CanMove p) {
		// TODO Auto-generated method stub
		
	}
	
	public void FireGun() {
		for(Inventory i : items) {
			i.Shoot(this);
		}
	}
	
	public void List(String name) {
		System.out.println(name + " attributes:");
		System.out.println("hp: " + hp);
		System.out.println("numberOfAction: " + numberOfAction);
		System.out.println("maxHp: " + maxHp);
		System.out.println("maxHp: " + maxHp);
		String s ;
		if(win)	s="true";
		else	s="false";
		System.out.println("win: " + s);
		System.out.println("items: " + );
	}
	
	public boolean Win() {
		if(win==true)
			return true;
		return false;
	}


}
