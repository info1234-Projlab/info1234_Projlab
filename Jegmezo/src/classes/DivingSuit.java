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
		System.out.println("A DivingSuit osztaly Swim(p: Player):boolean fuggvenye hivodott meg.");
		System.out.println("Van a jatekoson buvarruha? Irjon be egy 1-est ha igen, 0-ast ha nem.");
		Scanner  in = new Scanner(System.in);
		int a = in.nextInt();
		if(a==1)
			isOn=true;
		else
			isOn=false;
		if(isOn==true) {
			Field from = p.GetField();
			/**
			 * Csunya sorok kovetkeznek. Ezt azert csinaltam, mert az inicializalast meg nem valositottuk meg, 
			 * ami feltoltene mezokkel a Field osztaly neighbourFields attributumat, 
			 * igy csunya modon most adok hozza random szomszedos mezoket.
			 */
			UnstableField neighbour1 = new UnstableField(4, 2);
			UnstableField neighbour2 = new UnstableField(5, 1);
			UnstableField neighbour3 = new UnstableField(3, 3);
			UnstableField neighbour4 = new UnstableField(1, 2);
			UnstableField neighbour5 = new UnstableField(4, 4);
			UnstableField neighbour6 = new UnstableField(4, 2);
			from.AddNeighbour(neighbour1);
			from.AddNeighbour(neighbour2);
			from.AddNeighbour(neighbour3);
			from.AddNeighbour(neighbour4);
			from.AddNeighbour(neighbour5);
			from.AddNeighbour(neighbour6);
			ArrayList<Field> options = from.GetNeighbouringFields();
			System.out.println("Hanyas szamu mezore szeretne lepni? (1-6)");
			Scanner in2 = new Scanner(System.in);
	        a = in2.nextInt();
	        p.Move(options.get(a - 1));
	        return true;
		}
		return false;
	}
	
	public void Drop(Player p, int tab) {
		for(int i=0; i<tab; i++)
			System.out.print("\t");
		System.out.printf("A DivngSuit osztaly Drop(p:Player):void hivodott meg\n");
		p.RemoveItem(this);
		isOn=false;
	}
}
