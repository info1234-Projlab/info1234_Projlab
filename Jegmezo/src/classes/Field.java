package classes;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * Ez az objektum elt√°rolja a szomsz√©dos j√©gt√°bl√°kat, ami seg√≠ts√©g√©vel megtudhatjuk,
hogy a rajta √°ll√≥ j√°t√©kos hova l√©phet. Tudjuk r√≥la hogy stabil-e vagy instabil illetve,
hogy mennyi h√≥ van a tetej√©n. Azt is el tudja t√°rolni, hogy √©p√≠tettek-e m√°r r√° iglut √©s
lehetnek rajta eszk√∂z√∂k is. Iglub√≥l egy m√©g eszk√∂zb≈ël b√°rmennyi lehet rajta. A
stabilit√°sa pedig meghat√°rozza, hogy h√°ny embert b√≠r el an√©lk√ºl, hogy kibillenjen √©s
a v√≠zbe esn√©nek a j√°t√©kosok. A kibillen√©st≈ël nem sz≈±nik meg a j√©gt√°bla. Teh√°t (ha a
j√°t√©kosok t√∫l√©lik √©s megy tov√°bb a j√°t√©k) a j√©gt√°bla param√©terei nem v√°ltoznak √©s a
rajta l√©v≈ë t√°rgyak is megmaradnak. Egyik mez≈ër≈ël a m√°sikra l√©pni egy munk√°t vesz
ig√©nybe.
 *
 */



public class Field {
	protected int capacity;
	protected int snowLayer;
	protected boolean hasIglu;
	protected boolean visibleCapacity;
	protected int numOfPlayers;
	protected ArrayList<Field> neighbourFields;
	private ArrayList<Player> players;
	private ArrayList<Inventory> items;
	
	/**
	 * 
	 * @param capacity	Megadja h√°ny embert b√≠r el a mez≈ë.
	 * @param snowLayer	Megadja h√°ny r√©teg h√≥ van a mez≈ën. 
	 */
	public Field(int capacity, int snowLayer, int tab) {
		players = new ArrayList<Player>();
		for(int i=0; i<tab; i++)
			System.out.print("\t");
		System.out.println("A Field osztaly konstruktora hivodott meg.");
		this.capacity = capacity;
		this.snowLayer = snowLayer;
		this.hasIglu = false;
		this.visibleCapacity = false;
		this.numOfPlayers = 0;
	}
	
	public void AddNeighbour(Field neighbour) {
		neighbourFields.add(neighbour);
	}
	
	public ArrayList<Field> GetNeighbouringFields(int tab){
	for(int i=0; i<tab; i++)
		System.out.print("\t");
	System.out.println("A Field osztaly GetNeighbouringFields() fuggvenye hivodott meg.");
	
	return neighbourFields;
	}
	
	public boolean IsFall(int tab) {
		for(int i=0; i<tab; i++)
			System.out.print("\t");
		System.out.println("Az Field osztaly IsFall() fuggvenye hivodott meg.");
		return false;
	}
	
	public void Fall(int tab) {	
		for(int i=0; i<tab; i++)
			System.out.print("\t");
		System.out.println("Az Field osztaly Fall() fuggvenye hivodott meg.");
		for(Player p : players){
			p.SwimPlayer(tab+1);
		}

	}
	
	public boolean CanBuildIglu(int tab) {
		for(int i=0; i<tab; i++)
			System.out.print("\t");
		System.out.println("Az Field osztaly CanBuildIglu() fuggvenye hivodott meg.");
		if(this.capacity > 0 && this.hasIglu == false) {
			System.out.printf("Igen, lehet iglut √©p√≠teni! \n");
			return true;
		}else {
			System.out.printf("Nem, sajnos ide nem lehet iglut √©p√≠teni! \n");
			return false;	
		}
	}
	
	/**
	 * 
	 * @param item egy eszkˆz amit eldobunk a fˆldre
	 * @param tab indent·l·s
	 *  Hozz·adja az itemet a saj·t list·j·hoz Ès be·llÌtja annak layer v·ltozÛj·t.
	 *  majd meghÌvja az eszkˆzhˆz tartozÛ eldobÛ f¸ggvÈnyt
	 */
	public void AddItem(Inventory item,int tab) {
		for(int i=0; i<tab; i++)
			System.out.print("\t");
		System.out.printf("A Field oszt·ly AddItem(item:Inventory):void hÌvÛdott meg \n");
		item.SetLayer(this.snowLayer);
		items.add(item);
		Player player=Game.GetCurrentPlayer(tab+1);
		item.Drop(player,tab+1);
	}
	
	/**
	 * 
	 * @param p az a j·tÈkos aki a t·rgyat felveszi
	 * @param tab indent·l·s
	 * Kiveszi a list·j·bÛl azokat az Inventorykat amik a felszÌnen vannak Ès visszaadja azokat.
	 * amik l·thatÛak azokon meghÌvja a felvevı f¸ggvÈnyt
	 */
	public void RemoveItem(Player p,int tab) {
		for(int i=0; i<tab; i++)
			System.out.print("\t");
		System.out.printf("A Field oszt·ly RemoveItem(p:Player):void hÌvÛdott meg \n");
		for(int i=0; i<items.size(); i++) {
			if(items.get(i).GetVisible(tab+1)) {
				items.get(i).PickUp(p,tab+1);
			}
				
		}
	}
	
	public void DigItems(int layers, int tab) {
		for(int i=0; i<tab; i++)
			System.out.print("\t");
		System.out.print("A Field osztaly DigItems() fuggvenye hivodott meg");
		for (Inventory i : items) {
			if (snowLayer - i.GetLayer(tab + 1) == 2) {
				i.SetVisible(true, tab + 1);
			}
			else if (snowLayer - i.GetLayer(tab + 1) == 1) {
				i.SetVisible(true, tab + 1);
				i.DecreaseLayer(1, tab + 1);
			}
			else if (snowLayer - i.GetLayer(tab + 1) == 0) {
				i.DecreaseLayer(2, tab + 1);
			}
		}
	}
	
	public boolean IsFull() {
	}
	
	public void AddPlayer(Player p, int tab) {
		for(int i=0; i<tab; i++)
			System.out.print("\t");
		System.out.println("A Field osztaly AddPlayer(p: Player) fuggvenye hivodott meg.");
		players.add(p);
	}
	
	public void RemovePlayer(Player p, int tab) {
		for(int i=0; i<tab; i++)
			System.out.print("\t");
		System.out.println("A Field osztaly RemovePlayer(p: Player) fuggvenye hivodott meg.");
	}
	
	public void SetHasIglu(boolean b, int tab) {
		for(int i=0; i<tab; i++)
			System.out.print("\t");
		System.out.println("A Field osztaly SetHasIglu(b: boolean) fuggvenye hivodott meg");
		this.hasIglu = b ;
		if(b == true) {
			System.out.printf("Jelenleg van rajta iglu! \n");
		}
		else
			System.out.printf("Jelenleg nincs rajta iglu! \n");
	}
	
	public void SetVisibleCapacity(boolean bool, int tab) {
		for(int i=0; i<tab; i++)
			System.out.print("\t");
		System.out.println("A Field osztaly SetVisibleCapacity(b: boolean) fuggvenye hivodott meg");
		this.visibleCapacity = bool;
		if(bool==true)	System.out.printf("A mez≈ë kapacit√°sa: %d \n" , this.capacity);
	}
	
	/**
	 * 
	 * @param layer h·ny rÈteg hÛ ker¸lt a mezıre
	 * @param tab indent·l·s
	 * Be·llÌtja a hÛrÈteget, ha van iglu akkor a t·rgyak l·thatÛs·ga nem sz˚nik meg Ès a j·tÈkos sÈrtetlen marad
	 * Ha nincs akkor a j·tÈkos Èlete csˆkken Ès rakÛdik egy rÈteg hÛ 
	 */
	public void SetLayer(int layer, int tab) {
		for(int i=0; i<tab; i++)
			System.out.print("\t");
		System.out.println("A Field osztaly SetLayer(layer:int):void fuggvenye hivodott meg");
		
		snowLayer=layer;
		
		System.out.printf("Legyen iglu a mezon ahol allunk vagy ne? true/false\n");
		Scanner in = new Scanner(System.in);
		boolean hasiglu=in.hasNext();
		if (!hasiglu) {
			hasIglu=false;
			for(int i=0; i<items.size(); i++) {
				items.get(i).SetVisible(false, tab+1);
			}
			for(int i=0; i<players.size(); i++)
				players.get(i).DecreaseHp(tab+1);
		}
		else
			System.out.printf("Megmenek¸ltÈl a hÛvihartÛl, a mezıre sem ker¸lt plusz hÛ\n");
	}
	
	/**
	 * @param tabindent·l·s
	 * visszaadja a mezı aktu·lis hÛrÈtegÈt
	 */
	public int GetLayer(int tab) {
		for(int i=0; i<tab; i++)
			System.out.print("\t");
		System.out.println("A Field osztaly GetLayer():int fuggvenye hivodott meg");
		
		return snowLayer;
	}

	public boolean isNeighour(Field f, int tab){
		for(int i=0; i<tab; i++)
			System.out.print("\t");
		System.out.println("A Field osztaly isNeighbour(f: Field) fuggvenye hivodott meg.");
		
		return false;
	}
	
}
