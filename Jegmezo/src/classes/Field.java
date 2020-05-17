package classes;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Iterator;



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
	protected boolean visibleCapacity;
	protected int numOfPlayers;
	protected ArrayList<Field> neighbourFields;
	private ArrayList<CanMove> creatures;
	private ArrayList<Inventory> items;
	private BoardView boardView;
	private Shelter shelter;
	protected FieldView view;
	protected String name;
	
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
		this.view = new FieldView(this);
		this.name = name;
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
	
	public void SetFieldView(int x, int y) {
		view.SetCoordinates(new Point(x,y));
	}
	
	public ArrayList<CanMove> GetCreatures(){
		return creatures;
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
			if (p.SwimPlayer())
				return;
			
		}
		Field iterF;
		for(Field f : neighbourFields){
			for(CanMove p : f.creatures){
				p.PullPlayer(this);
			}
		}
		
		for(CanMove p : creatures){
			//p.SetHp(0);    ez itt szar valamiert..... ha kikommentezed akkor meghalunk mindig
		}
	}
	
	/**
	 * Igluepites ellenorzesere hasznalatos fuggveny.
	 * @param tab	Indentalasra
	 * @return	Visszaadja, hogy lehet e iglut epiteni az adott mezore. 
	 */
	public boolean CanBuildShelter() {
		if(this.capacity > 0 && this.shelter == null) {
			return true;
		}else {
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
		CanMove player= Game.GetCurrentPlayer();
		item.Drop(player);
	}
	
	public boolean InitInventory(Inventory item) {
		items.add(item);
		return true;
	}
	
	
	/**
	 * 
	 * @param p az a j�t�kos aki a t�rgyat felveszi
	 * @param tab indent�l�s
	 * Kiveszi a list�j�b�l azokat az Inventorykat amik a felsz�nen vannak �s visszaadja azokat.
	 * amik l�that�ak azokon megh�vja a felvev� f�ggv�nyt
	 */
	public void RemoveItem(CanMove p) {
		for(int i=0; i<items.size(); i++) {
			if(items.get(i).GetVisible()) {
				items.get(i).PickUp(p);
			}
		}
		p.SetNumOfAction(p.GetNumOfAction()-1);
	}
	
	/**
	 * Kiveszi a field tarolojabol a parameterkent kapott targyat
	 * @param i
	 */
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
			i.SetLayer(i.GetLayer()-layers);
			if(i.GetLayer() == 0)	i.SetVisible(true);
		}
	}
	
	
	/**
	 * Mezon tarolt jatekosok listajahoz hozzaad egy jatekos (aki eppen odament). 
	 * @param p	Akit hozzaadunk a mezon levo jatekosok listajahoz.
	 * @param tab	Indentalasra.
	 */
	public void AddCreature(CanMove c) {
		creatures.add(c);
		c.setField(this);
		++numOfPlayers;
	}
	
	/**
	 * Mezon levo jatekosok kozul torlunk valakit (elment onnan).
	 * @param p	Mezot elhagyo jatekos.
	 * @param tab	Indentalasra.
	 */
	public void RemoveCreature(CanMove cm) {		
		creatures.remove(cm);
		--numOfPlayers;
		
	}
	
	/**
	 * Mezo hasIglu valtozojanak valtoztatasara.
	 * @param b	Amennyiben valtozott a mezo iglu szempontjabol (pl. lett epitve ra), akkor megvaltoztatja a hasIglut valtozot.
	 * @param tab	Indentalasra.
	 */
	public void AddShelter(Shelter s) {
		if(CanBuildShelter()) {
			shelter = s;
		}
		else
			System.out.printf("Mar van rajta menedek! \n");
	}
	
	
	/**
	 * A kutato kepessege hasznalata utan lathato, hogy hany embert bir el az adott mezo.
	 * @param bool	true, ha a kutato hasznalta kepesseget
	 * @param tab	Indentalasra.
	 */
	public void SetVisibleCapacity(boolean bool) {
		this.visibleCapacity = bool;
	}
	
	public boolean GetVisibleCapacity() {
		return this.visibleCapacity;
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
		if(shelter != null) {
			snowLayer = snowLayer+1;
			for(int i=0; i<items.size(); i++) {
				items.get(i).SetVisible(false);
			}
		}
			
	}
	/**
	 * Csokkenti a mezo horeteget egyel és ha 
	 * targyak lathatova valtak akkor beallitja a 
	 * lathatosagukat true-ra
	 */
	public void DecreaseLayer() {
		snowLayer = snowLayer-1;
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
	
	public void AddBoardView(BoardView bv) {	
		boardView = bv;
	}
	
	public BoardView GetBoardView() {	
		return boardView;
	}
	
	
	/**
	 * Ellenorzi, hogy szomszedos e a kapott mezo.
	 * @param f
	 * @return ture: szomszedos, false: nem szomszedos.
	 */
	public boolean isNeighour(Field f){
		return neighbourFields.contains(f);
	}
	
	/**
	 * Eltavolitja a menedekhelyet a mezorol
	 */
	public void RemoveShelter() {
		shelter = null;
	}
	
	public boolean hasShelter() {
		return shelter != null;
	}
	
	/**
	 * Ha a parameterul kapott item benne van a field tarolojaban
	 * akkor igazzal ter vissza
	 * @param i
	 * @return
	 */
	public boolean hasItem(Inventory i){
		return items.contains(i);
	}
	
	public void SetCapacity(int num) {
		this.capacity=num;
	}
	
	public int GetCapacity() {
		return this.capacity;
	}
	
	/**
	 * A vihar megnöveli a horeteget egyel, ha nincs menedek akkor a mezon allo jatekosoknak
	 * csokkenti az eletet egyel, ha van menedek akkor nem
	 */
	public void Storm() {
		snowLayer += 1;
		if(!this.hasShelter()){
			for (int i = 0; i < creatures.size(); i++) {
				creatures.get(i).DecreaseHp();
			}
		}
	}
	
	
	public ArrayList<Inventory> GetItems() {
		return items;
		
	}
	
/**
 * A vizbe esett jatekost eltavolitjuk a Hole-bol
 */
	public void PullFromHole(){
		Iterator it = creatures.iterator();
		while(it.hasNext()){
				it.next();
				it.remove();
		}
	}
	
	public Shelter GetShelter() {
		return shelter;
	}
	
	public FieldView GetFieldView() {
		return view;
	}
	
}
