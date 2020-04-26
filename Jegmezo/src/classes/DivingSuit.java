package classes;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * B�rmelyik t�pus� j�t�kos felveheti vagy eldobhatja. 
 * Ha ezzel a t�rggyal rendelkezik a j�t�kos akkor v�zbe es�s eset�n 
 * ki tud menek�lni valamelyik szomsz�dos mez�re, legyen az ak�r egy lyuk is, 
 * �gy lehets�ges a szigetekre val� eljut�s is. 
 * A j�t�k sor�n v�gig megv�di a gazd�j�t, t�bbsz�r felhaszn�lhat�.
 */

public class DivingSuit extends Item {
	private boolean isOn=false;
	
	public DivingSuit(int layer, boolean visible) {
		super(layer, visible);
	}
	
	/**
	 * A buvarruha felveteleert felelos. Egy munkat vesz igenybe.
	 * @param p A jatekos aki felveszi a ruhat
	 * @param tab indentalas
	 * @return mindig igazzal terunk vissza, ezzel jelezve, hogy meghivodott a DivingSuit PutOn() fuggvenye
	 */
	
	public boolean PutOn(Player p) {
		int nActions= p.GetNumOfAction();
		if(nActions>0 && isOn==false) {
			isOn=true;
			p.SetNumOfAction(nActions-1);
		}
		return true;
	}
	
	/**
	 * Ez a fuggveny felelos a vizbe esett jatekosok atuszasaert egy masik mezore, ha mar felvettek a buvarruhat.
	 * @param p A jatekos aki uszni akar
	 * @param tab indentalas
	 * @return igazzal ter vissza ha sikerult atuszni (van rajta ruha), ezzel jelezve, hogy meghivodott, viszont hamissal ha nem
	 * sikerult hatha van a jatekosnal masik buvarruha ami rajta van igy tudja majd hasznalni
	 */
	
	public boolean Swim(Player p) {
			if(this.isOn){
				p.field.neighbourFields.get(0).AddCreature(p);
				p.field.RemoveCreature(p);
				p.SetField(p.field.neighbourFields.get(0));				
				return true;
			}
			else
		return false;
	}
	
	public void Drop(Player p) {
		p.RemoveItem(this);
		isOn=false;
	}
}
