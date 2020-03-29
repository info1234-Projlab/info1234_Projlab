package classes;

import java.util.ArrayList;
import java.util.Scanner;

public class DivingSuit extends Item {
	private boolean isOn=false;
	
	public DivingSuit(int layer, boolean visible, int tab) {
		super(layer, visible);
		for(int i=0; i<tab; i++)
			System.out.print("\t");
		System.out.println("A DivingSuit osztaly konstruktora hivodott meg.");
	}
	
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
		System.out.println("Van a jatekoson búvárruha? Irjon be egy 1-est ha igen, 0-ast ha nem.");
		Scanner  in = new Scanner(System.in);
		int a = in.nextInt();
		if(a==1)
			isOn=true;
		else
			isOn=false;
		in.close();
		if(isOn==true) {
			Field from = p.GetField(tab+1);
			UnstableField neighbour1 = new UnstableField(4, 2, tab+1);
			UnstableField neighbour2 = new UnstableField(5, 1, tab+1);
			UnstableField neighbour3 = new UnstableField(3, 3, tab+1);
			UnstableField neighbour4 = new UnstableField(1, 2, tab+1);
			UnstableField neighbour5 = new UnstableField(4, 4, tab+1);
			UnstableField neighbour6 = new UnstableField(4, 2, tab+1);
			from.AddNeighbour(neighbour1);
			from.AddNeighbour(neighbour2);
			from.AddNeighbour(neighbour3);
			from.AddNeighbour(neighbour4);
			from.AddNeighbour(neighbour5);
			from.AddNeighbour(neighbour6);
			ArrayList<Field> options = from.GetNeighbouringFields(tab+1);
			System.out.println("Hanyas szamu mezore szeretne lepni?");
			Scanner  in2 = new Scanner(System.in);
	        a = in2.nextInt();
	        p.Move(options.get(a), tab+1);
	        in2.close();
	        return true;
		}
		return false;
	}
	
	public void Drop(Player p, int tab) {
		for(int i=0; i<tab; i++)
			System.out.print("\t");
		System.out.printf("A DivngSuit osztály Drop(p:Player):void hívódott meg\n");
		p.RemoveItem(this,tab+1);
		isOn=false;
	}
}
