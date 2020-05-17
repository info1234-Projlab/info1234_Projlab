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

	/**
	 *Ha a testhőnk 0 igaz értékkel tér vissza.
	 */
	public boolean IsDead() {
		if(hp==0)
			return true;
		return false;
	}
	
	
	/**
	 * 
	 *  A jelenlegi testhőt adja vissza
	 */
	@Override
	public int GetHP() {
		return hp;
	}
	
	/**
	 * 
	 *  A maximális testhőt adja vissza
	 */
	@Override
	public int GetMaxHP() {
		return maxHp;
	}
	
	/**
	 * A játékos használja a képességét. Az eszkimó iglut épít, a sarkkutató jeget kutat. 
	 */
	public void UseAbility() {
		System.out.println("player useability");
	}
	/**
	 * Egy helyvaltoztatas es abbol adodo vizbeeses tesztelese
	 * @param f Az a mező, amire lépni szeretnénk
	 */
	public void Move(Field f) {	
		
		if(this.field.isNeighour(f)&&this.GetNumOfAction()>0){
			this.field.RemoveCreature(this);
			f.AddCreature(this);
			for (CanMove cm : f.GetCreatures()) {
				cm.StepOn(this);
			}
			
			numberOfAction--;
			
			
			if(f.IsFall()){
				f.Fall();
				//this.field.AddCreature(this);
			}
		}
		if (numberOfAction == 0) {
			Game.NextPlayer();
		}
	}
	
	/**
	 * 
	 *  A testhőt növeli
	 */
	public void IncreaseHp() {
		hp++;
		field.GetBoardView().GetInventoryPanel().repaint();
	}
	
	/**
	 * 
	 *  A testhőt csökkenti
	 */
	public void DecreaseHp() {
		hp--;
		field.GetBoardView().GetInventoryPanel().repaint();
		if(hp==0) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Game.LooseGame();
		}
	}
	
	public void SetHp(int hp){
		System.out.println("meghivodtam");
		this.hp = hp;
		field.GetBoardView().GetInventoryPanel().repaint();
		if(this.hp==0) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Game.LooseGame();
		}
	}
	
	/**
	 * A kapott Inventory-t beteszi az items list�j�ba.
	 */
	public void AddItem(Inventory i) {
		items.add(i);
	}
	
	/**
	 *  Eltávolít egy itemet a játékos inventoryjából.
	 *  @param i az eltávolítandó item.
	 * A kapott Inventory-t kiveszi az items list�j�b�l.
	 */
	public void RemoveItem(Inventory i) {
		items.remove(i);
	}
	
	
	public boolean StartTurn() {
		return true;
		
	}
	
	/**
	 * 
	 *  Eltávolít pár hóréteget a mezőről.
	 *  @param layers A hórétegek száma.
	 * @param tab	Indentálást jelzi. 
	 */
	public void DigPlayer(int layers) {    //csökkenti a field layerét
		field.SetLayer(field.GetLayer()-layers);
		field.DigItems(layers);
	}
	
	/**
	 * A player osztaly SwimPlayer() metodusa, akkor hivodik meg, amikor beleesik egy jatekos a vizbe.
	 * @param tab
	 */
	public boolean SwimPlayer() {
		for(Inventory i : items){
			if(i.Swim(this)) {
				return true;
			}
		}
		return false;
	}
	
	
	/**
	 * Egy jatekos kiment egy masik jatekost a vizbol.
	 * @param tab
	 * @param p
	 */
	public void PullPlayer(Field from) {
		for(Inventory i : items)
			i.Pull(from, this.field);
	}
	
	public void DecreaseAction() {
		if(this.numberOfAction > 0)	
			this.numberOfAction--;
	}
	
	/**
	 * 
	 *  Visszaadja a hátralévő lépések számát.
	 */
	@Override
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
	
	


	@Override
	public void StepOn(CanMove cm) {
		
	}
	/**
	 * Felveszi a buvarruhat a jatekos
	 */
	public void PutOnDivingSuit() {
		for(int i=0; i<items.size();i++) {
			items.get(i).PutOn(this);
		}
	}
	/**
	 * A jatekos megeszi az etelt ami nala van 
	 */
	public void Eat() {
		for(int i=0; i<items.size();i++) {
			items.get(i).Eat(this);
		}
	}
	/**
	 * A jatekos elsuti a fegyvert
	 */
	public void FireGun() {
		this.numberOfAction--;
		for(Inventory i : items) {
			i.Shoot(this);
		}
	}
	

	/**
	 * Megadja, nyert e a jatekos. 
	 */
	public boolean Win() {
		if(win==true)
			return true;
		return false;
	}
	
	@Override
	public boolean GetWin() {
		return win;
	}

	/**
	 * Visszaadja a jatekosnal levo itemeket. 
	 */
	@Override
	public ArrayList<Inventory> GetItems(){
		return items;
	}
	
	public void setField(Field f) {
		this.field = f ;
	}

	public CanMoveView GetCanMoveView() {
		return null;
	}
	

}
