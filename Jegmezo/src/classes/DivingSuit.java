package classes;

import java.util.ArrayList;
import java.util.Scanner;

public class DivingSuit extends Item {
	private boolean isOn=false;
	
	public boolean PutOn(Player p, int tab) {
		for(int i=0; i<tab; i++)
			System.out.print("\t");
		System.out.println("A DivingSuit osztaly PutOn(p: Player) fuggvenye hivodott meg.");
		int nActions= p.GetNumOfAction(tab+1);
		if(nActions>0 && isOn==false) {
			isOn=true;
			p.SetNumOfAction(nActions-1, tab+1);
		}
		return true;
	}
	
	public boolean Swim(Player p, int tab) {
		for(int i=0; i<tab; i++)
			System.out.print("\t");
		System.out.println("A DivingSuit osztaly Swim(p: Player):boolean fuggvenye hivodott meg.");
		if(isOn==true) {
			Field from = p.GetField(tab+1);
			ArrayList<Field> options = from.GetNeighbouringFields(tab+1);
			System.out.println("Hanyas szamu mezore szeretne lepni?");
			Scanner  in = new Scanner(System.in);
	        int a = in.nextInt();
	        p.Move(options.get(a), tab+1);
	        return true;
		}
		return false;
	}
	
	public void Drop(Player p) {
	}
}
