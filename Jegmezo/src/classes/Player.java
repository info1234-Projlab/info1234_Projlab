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
	protected ArrayList<Inventory> items;	//ez is

	
	/**
	 * 
	 * @param maxHp	konstruktornak átadott maxHp érték
	 * @param field	konstruktornak átadott field, ide rakjuk le a játékost
	 */
	public Player(int maxHp, Field field, int tab) {	
		for(int i=0; i<tab; i++)
			System.out.print("\t");
		System.out.println("A Player osztaly konstruktor fuggvenye hivodott meg.");
		
		this.hp = maxHp;
		this.maxHp = maxHp;
		this.numberOfAction = 4;
		this.win = false;
		this.field = field;
		items = new ArrayList<Inventory>();
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
	 * 
	 *  A jelenlegi testhőt adja vissza
	 * @param tab	Indentálást jelzi. 
	 */
	public int GetHP(int tab) {
		for(int i=0; i<tab; i++)
			System.out.print("\t");
		System.out.println("A Player osztaly GetHP() fuggvenye hivodott meg.");
		return hp;
	}
	
	/**
	 * 
	 *  A maximális testhőt adja vissza
	 * @param tab	Indentálást jelzi. 
	 */
	public int GetMaxHP(int tab) {
		for(int i=0; i<tab; i++)
			System.out.print("\t");
		System.out.println("A Player osztaly GetMaxHP() fuggvenye hivodott meg");
		return maxHp;
	}
	
	/**
	 * A játékos használja a képességét. Az eszkimó iglut épít, a sarkkutató jeget kutat. 
	 */
	public void UseAbility(int tab) {
		for(int i=0; i<tab; i++)
			System.out.print("\t");
		System.out.println("A Player osztaly UseAbility() fuggvenye hivodott meg.");

	}
	/**
	 * Egy helyvaltoztatas es abbol adodo vizbeeses tesztelese
	 * @param f
	 * @param tab
	 */
	public void Move(Field f, int tab) {
		for(int i=0; i<tab; i++)
			System.out.print("\t");
		System.out.println("A Player osztaly Move(f: Field) fuggvenye hivodott meg.");
		
		//Szomszedos a celmezo
		if(this.field.isNeighour(f, tab+1)){
			f.AddPlayer(this, tab+1);
			this.field.RemovePlayer(this, tab+1);
			
			//Lukba lepett e a jatekos
			if(f.IsFall(tab+1)){
				f.Fall(tab+1);
				
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
	public void IncreaseHp(int tab) {
		for(int j=0; j<tab; j++)
			System.out.print("\t");
		System.out.printf("Az Player osztaly IncreaseHp fuggvenye hivodott meg \n");
		hp++;
	}
	
	public void DecreaseHp(int tab) {
		for(int i=0; i<tab; i++)
			System.out.print("\t");
		System.out.println("A Player osztaly DecreaseHp():void fuggvenye hivodott meg");
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
	public void AddItem(Inventory i,int tab) {
		for(int j=0; j<tab; j++)
			System.out.print("\t");
		System.out.println("A Player osztaly AddItem(i:Inventory) fuggvenye hivodott meg.");
		items.add(i);
	}
	
	/**
	 *  Eltávolít egy itemet a játékos inventoryjából.
	 *  @param i az eltávolítandó item.
	 *  @param tab	Indentálást jelzi. 
	 * A kapott Inventory-t kiveszi az items list�j�b�l.
	 */
	public void RemoveItem(Inventory i,int tab) {
		for(int j=0; j<tab; j++)
			System.out.print("\t");
		System.out.printf("Az Player osztaly RemoveItem(i:Inventory):void hivodott meg \n");
	}
	
	
	public void StartTurn(int numOfAction) {
	}
	
	/**
	 * 
	 *  Eltávolít pár hóréteget a mezőről.
	 *  @param layers A hórétegek száma.
	 * @param tab	Indentálást jelzi. 
	 */
	public void DigPlayer(int layers, int tab) {
		for(int i=0; i<tab; i++)
			System.out.print("\t");
		System.out.println("A Player osztaly DigPlayer fuggvenye hivodott meg");
		field.DigItems(layers, tab + 1);
	}
	
	/**
	 * A player osztaly SwimPlayer() metodusa, akkor hivodik meg, amikor beleesik egy jatekos a vizbe.
	 * @param tab
	 */
	public void SwimPlayer(int tab) {
		for(int i=0; i<tab; i++)
			System.out.print("\t");
		System.out.println("A Player osztaly SwimPlayer() fuggvenye hivodott meg");
		System.out.println("Az eszkimo V�zbe esett");
	}
	
	/**
	 * Egy jatekos kiment egy masik jatekost a vizbol.
	 * @param tab
	 * @param p
	 */
	public void PullPlayer(int tab, Player p) {
		for(int i=0; i<tab; i++)
			System.out.print("\t");
		System.out.println("A Player osztaly PullPlayer() fuggvenye hivodott meg");
		this.items.get(0).Pull(p,this.field,tab+1);
	}
	
	public void DecreaseAction(int tab) {
		for(int i=0; i<tab; i++)
			System.out.print("\t");
		if(this.numberOfAction > 0)	this.numberOfAction--; // a feltétel lehet felesleges
		System.out.printf("Akciók száma csökkent, így %d akció van hátra\n", this.numberOfAction);
	}
	
	/**
	 * 
	 *  Visszaadja a hátralévő lépések számát.
	 * @param tab	Indentálást jelzi. 
	 */
	public int GetNumOfAction(int tab) {
		for(int i=0; i<tab; i++)
			System.out.print("\t");
		System.out.println("A Player osztaly GetNumOfAction() fuggvenye hivodott meg.");
		return this.numberOfAction;
	}
	/**
	 * 
	 *  Beállítja a hátralévő lépések számát.
	 *  @param n a lépések száma.
	 *  @param tab	Indentálást jelzi. 
	 */
	public void SetNumOfAction(int n, int tab) {
		for(int i=0; i<tab; i++)
			System.out.print("\t");
		System.out.println("A Player osztaly SetNumOfAction(n: int) fuggvenye hivodott meg.");
		this.numberOfAction = n ;
	}
	
	/**
	 * 
	 *  Beálítja a játékos megnyerte-e már a játékot.
	 *  @param b Megnyerte-e a játékos a játékot.	
	 * @param tab	Indentálást jelzi. 
	 */
	public void SetWin(boolean b, int tab) {
		for(int i=0; i<tab; i++)
			System.out.print("\t");
		System.out.println("A Player osztaly SetWin(b: boolean) fuggvenye hivodott meg.");
		win = b;
	}
	
	public void SetHp(int hp, int tab){
		for(int i=0; i<tab; i++)
			System.out.print("\t");
		System.out.println("A Player osztaly SetHp(i: int) fuggvenye hivodott meg.");
		this.hp = hp;
	}
}
