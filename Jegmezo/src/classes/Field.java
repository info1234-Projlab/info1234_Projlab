

import java.util.ArrayList;

/**
 * 
 * Ez az objektum eltárolja a szomszédos jégtáblákat, ami segítségével megtudhatjuk,
hogy a rajta álló játékos hova léphet. Tudjuk róla hogy stabil-e vagy instabil illetve,
hogy mennyi hó van a tetején. Azt is el tudja tárolni, hogy építettek-e már rá iglut és
lehetnek rajta eszközök is. Igluból egy még eszközből bármennyi lehet rajta. A
stabilitása pedig meghatározza, hogy hány embert bír el anélkül, hogy kibillenjen és
a vízbe esnének a játékosok. A kibillenéstől nem szűnik meg a jégtábla. Tehát (ha a
játékosok túlélik és megy tovább a játék) a jégtábla paraméterei nem változnak és a
rajta lévő tárgyak is megmaradnak. Egyik mezőről a másikra lépni egy munkát vesz
igénybe.
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
	 * @param capacity	Megadja hány embert bír el a mező.
	 * @param snowLayer	Megadja hány réteg hó van a mezőn. 
	 */
	public Field(int capacity, int snowLayer, int tab) {
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
	
	public boolean IsFall() {
	}
	
	public void Fall() {
	}
	
	public boolean CanBuildIglu(int tab) {
		for(int i=0; i<tab; i++)
			System.out.print("\t");
		System.out.println("Az Field osztaly CanBuildIglu() fuggvenye hivodott meg.");
		if(this.capacity > 0 && this.hasIglu == false) {
			System.out.printf("Igen, lehet iglut építeni! \n");
			return true;
		}else {
			System.out.printf("Nem, sajnos ide nem lehet iglut építeni! \n");
			return false;	
		}
	}
	
	public void AddItem(Inventory item,int tab) {
		for(int i=0; i<tab; i++)
			System.out.print("\t");
		System.out.printf("A Field oszt�ly AddItem(item:Inventory):void h�v�dott meg \n");
		item.SetLayer(this.snowLayer);
		items.add(item);
	}
	
	public void RemoveItem(Player p) {
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
		if(bool==true)	System.out.printf("A mező kapacitása: %d \n" , this.capacity);
	}
	
	public boolean isNeighour(Field f, int tab){
		for(int i=0; i<tab; i++)
			System.out.print("\t");
		System.out.println("A Field osztaly isNeighbour(f: Field) fuggvenxe hivodott meg");
		
		return false;
	}
	
}
