package classes;
import java.util.ArrayList;
import java.util.Iterator;


/**
 * Mindket tipusu jatekos felveheti es el is dobhatja, hogy a masik felvehesse. 
 * Ennek segetsegevel vizbe esett bajtarsakat lehet kimenteni. 
 * A kimentett jatekos a kotellel rendelkezo jatekos mezojere lep ki a vizbol. 
 * Felvetele egy egyseg munka.
 */
public class Rope extends Item {
	
	public Rope(int layer, boolean visible) {
		super(layer, visible);
	}
	
	/**
	 * A jatekosok vizbol valo kimenteseert felelos
	 * @param p a jatekos akit ki kell menteni a vizbol
	 * @param to ahova kimentjuk a vizbol
	 * @param tab indentalas
	 * @return mindig igazzal ter vissza, ezzel jelezzuk, hogy meghivodott egy Rope osztalybeli Pull fuggveny
	 */
	
	public boolean Pull(Field from, Field to) {

		for(Iterator it = from.GetCreatures().iterator();it.hasNext(); ){
			CanMove cm = (CanMove)it.next();
			cm.setField(to);
			//to.AddCreature(cm);
		}
		from.PullFromHole();
		return true;
	}
}
