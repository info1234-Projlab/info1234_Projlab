package classes;

/**
 * Mindk�t t�pus� j�t�kos felveheti �s el is dobhatja, hogy a m�sik felvehesse. 
 * Ennek seg�ts�g�vel v�zbe esett bajt�rsakat lehet kimenteni. 
 * A kimentett j�t�kos a k�t�llel rendelkez� j�t�kos mez�j�re l�p ki a v�zb�l. 
 * Felv�tele egy egys�g munka.
 */
public class Rope extends Item {
	
	public Rope(int layer, boolean visible, int tab) {
		super(layer, visible);
		for(int i=0; i<tab; i++)
			System.out.print("\t");
		System.out.println("A DivingSuit osztaly konstruktora hivodott meg.");
	}
	
	/**
	 * A jatekosok vizbol valo kimenteseert felelos
	 * @param p a jatekos akit ki kell menteni a vizbol
	 * @param to ahova kimentjuk a vizbol
	 * @param tab indentalas
	 * @return mindig igazzal ter vissza, ezzel jelezzuk, hogy meghivodott egy Rope osztalybeli Pull fuggveny
	 */
	
	public boolean Pull(Player p, Field to, int tab) {
		for(int i=0; i<tab; i++)
			System.out.print("\t");
		System.out.println("A Rope osztaly Pull(p: Player, to: Filed):boolean fuggvenye hivodott meg.");
		Field from = p.GetField(tab+1);
		from.RemovePlayer(p, tab+1);
		to.AddPlayer(p, tab+1);
		p.SetField(to, tab+1);
		return true;
	}
}
