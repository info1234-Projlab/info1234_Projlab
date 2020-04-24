package classes;

import java.util.ArrayList;
import java.util.Scanner;

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
	private ArrayList<CanMove> creatures;
	private ArrayList<Inventory> items;
	private ArrayList<Shelter> shelter;
	private ArrayList<Player> players;
	
	/**
	 * 
	 * @param capacity	Megadja hány embert bír el a mező.
	 * @param snowLayer	Megadja hány réteg hó van a mezőn. 
	 */
	public Field(int capacity, int snowLayer) {
		this.capacity = capacity;
		this.snowLayer = snowLayer;
		this.visibleCapacity = false;
		this.numOfPlayers = 0;
		this.items=new ArrayList<Inventory>();
		this.neighbourFields=new ArrayList<Field>();
		this.creatures=new ArrayList<CanMove>();
		this.shelter=new ArrayList<Shelter>();
		this.players=new ArrayList<Player>();
	}
	/**
	 * Hozzaad egy mezot a szomszedok listajahoz.
	 * @param neighbour	Szomszedos mezo, amit beallitunk egy szomszednak.
	 * @param tab	Indentalasra.
	 */
	public void AddNeighbour(Field neighbour) {
		neighbourFields.add(neighbour);
	}
	
	/**
	 * A szomszedos mezok listajanak lekerdezesere.
	 * @param tab	Indentalasra.
	 * @return	Visszaadja a szomszedos mezok listajat.
	 */
	public ArrayList<Field> GetNeighbouringFields(){
	
	return neighbourFields;
	}
	
	
	public boolean IsFall() {
		return false;
	}
	
	/**
	 * Egy borulas  tesztelese
	 * @param tab
	 */
	public void Fall() {
		for(CanMove p : creatures){
			p.SwimPlayer();
		}
		
		for(Field f : neighbourFields){
			for(Player p : f.players){
				for(Player resP : players){
					p.PullPlayer(resP);
				}
			}
		}
		
	}
	
	/**
	 * Igluepites ellenorzesere hasznalatos fuggveny.
	 * @param tab	Indentalasra
	 * @return	Visszaadja, hogy lehet e iglut epiteni az adott mezore. 
	 */
	public boolean CanBuildIglu() {
		if(this.capacity > 0 && this.hasIglu == false) {
			System.out.printf("Igen, lehet iglut építeni! \n");
			return true;
		}else {
			System.out.printf("Nem, sajnos ide nem lehet iglut építeni! \n");
			return false;	
		}
	}
	
	/**
	 * 
	 * @param item egy eszk�z amit eldobunk a f�ldre
	 * @param tab indent�l�s
	 *  Hozz�adja az itemet a saj�t list�j�hoz �s be�ll�tja annak layer v�ltoz�j�t.
	 *  majd megh�vja az eszk�zh�z tartoz� eldob� f�ggv�nyt
	 */
	public void AddItem(Inventory item) {
		item.SetLayer(this.snowLayer);
		items.add(item);
		Player player=Game.GetCurrentPlayer();
		item.Drop(player);
	}
	
	
	/**
	 * 
	 * @param p az a j�t�kos aki a t�rgyat felveszi
	 * @param tab indent�l�s
	 * Kiveszi a list�j�b�l azokat az Inventorykat amik a felsz�nen vannak �s visszaadja azokat.
	 * amik l�that�ak azokon megh�vja a felvev� f�ggv�nyt
	 */
	public void RemoveItem(Player p) {
		for(int i=0; i<items.size(); i++) {
			if(items.get(i).GetVisible()) {
				items.get(i).PickUp(p);
			}
		}
	}
	
	public void RemoveItem(Inventory i){
		items.remove(i);
	}
	
	/**
	 * 
	 *  Kiássa a mezőn lévő tárgyakat, és eltávolít pár hóréteget róla.
	 *  @param layers A hórétegek száma.
	 * @param tab	Indentálást jelzi. 
	 */
	public void DigItems(int layers) {
		for (Inventory i : items) {
			if (snowLayer - i.GetLayer() == 2) {
				i.SetVisible(true);
			}
			else if (snowLayer - i.GetLayer() == 1) {
				i.SetVisible(true);
				i.DecreaseLayer(1);
			}
			else if (snowLayer - i.GetLayer() == 0) {
				i.DecreaseLayer(2);
			}
		}
	}
	
	/*public boolean IsFull() {
	}*/
	/**
	 * Mezon tarolt jatekosok listajahoz hozzaad egy jatekos (aki eppen odament). 
	 * @param p	Akit hozzaadunk a mezon levo jatekosok listajahoz.
	 * @param tab	Indentalasra.
	 */
	public void AddCreature(CanMove c) {
		creatures.add(c);
		///Itt m�g vari�lni kell
		++numOfPlayers;
	}
	
	/**
	 * Mezon levo jatekosok kozul torlunk valakit (elment onnan).
	 * @param p	Mezot elhagyo jatekos.
	 * @param tab	Indentalasra.
	 */
	public void RemovePlayer(Player p) {
		creatures.remove(p);
		--numOfPlayers;
	}
	
	/**
	 * Mezo hasIglu valtozojanak valtoztatasara.
	 * @param b	Amennyiben valtozott a mezo iglu szempontjabol (pl. lett epitve ra), akkor megvaltoztatja a hasIglut valtozot.
	 * @param tab	Indentalasra.
	 */
	public void SetHasIglu(boolean b) {
		this.hasIglu = b ;
		if(b == true) {
			System.out.printf("Jelenleg van rajta iglu! \n");
		}
		else
			System.out.printf("Jelenleg nincs rajta iglu! \n");
	}
	
	/**
	 * A kutato kepessege hasznalata utan lathato, hogy hany embert bir el az adott mezo.
	 * @param bool	true, ha a kutato hasznalta kepesseget
	 * @param tab	Indentalasra.
	 */
	public void SetVisibleCapacity(boolean bool) {
		this.visibleCapacity = bool;
		if(bool==true)	System.out.printf("A mező kapacitása: %d \n" , this.capacity);
	}
	
	/**
	 * 
	 * @param layer hany reteg ho kerult a mezore
	 * @param tab indent�l�s
	 * Beallitja a horeteget, ha van iglu akkor a targyak lathatosaga nem szunik meg es a jatekos sertetlen marad
	 * Ha nincs akkor a jatekos elete csokken es rakodik egy reteg ho
	 */
	public void SetLayer(int layer) {
		snowLayer=layer;
	}
	
	public void IncreaseLayer() {
		if(shelter.size()==0) {
			snowLayer = snowLayer+1;
			for(int i=0; i<items.size(); i++) {
				items.get(i).SetVisible(false);
			}
		}
			
	}
	
	public void DecreaseLayer() {
		snowLayer = snowLayer+1;
		for(int i=0; i<items.size(); i++) {
			if(items.get(i).GetLayer()==snowLayer)
				items.get(i).SetVisible(true);
		}
	}
	
	
	
	/**
	 * @param tab indentalas
	 * visszaadja a mezo aktualis horeteget
	 */
	public int GetLayer() {		
		return snowLayer;
	}
	
	
	/**
	 * Ellenorzi, hogy szomszedos e a kapott mezo.
	 * @param f
	 * @param tab
	 * @return ture: szomszedos, false: nem szomszedos.
	 */
	public boolean isNeighour(Field f){
		return neighbourFields.contains(f);
	}
	
	public void RemoveShelter() {
		shelter.remove(0);
	}
	
	public boolean hasItem(Inventory i){
		return items.contains(i);
	}
	

	
}
