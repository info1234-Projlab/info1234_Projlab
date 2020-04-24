package classes;


/**
 * Mindket tipusu jatekos felveheti es el is dobhatja, hogy a masik felvehesse. 
 * Ennek segetsegevel vizbe esett bajtarsakat lehet kimenteni. 
 * A kimentett jatekos a kotellel rendelkezo jatekos mezojere lep ki a vizbol. 
 * Felvetele egy egyseg munka.
 */
public class Rope extends Item {
	
	public Rope(int layer, boolean visible, int tab) {
		super(layer, visible);
		for(int i=0; i<tab; i++)
			System.out.print("\t");
		System.out.println("A Rope osztaly konstruktora hivodott meg.");
	}
	
	/**
	 * A jatekosok vizbol valo kimenteseert felelos
	 * @param p a jatekos akit ki kell menteni a vizbol
	 * @param to ahova kimentjuk a vizbol
	 * @param tab indentalas
	 * @return mindig igazzal ter vissza, ezzel jelezzuk, hogy meghivodott egy Rope osztalybeli Pull fuggveny
	 */
	
	public boolean Pull(Player p, Field to, int tab) {
		p.field.RemovePlayer(p);
		p.SetField(to);
		return true;
	}
}
