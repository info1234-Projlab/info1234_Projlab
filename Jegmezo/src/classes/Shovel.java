package classes;
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : Shovel.java
//  @ Date : 3/27/2020
//  @ Author : 
//
//




public class Shovel extends Item {
	
	public Shovel(int layer,boolean visible) {
		super(layer, visible);
	}
	
	public boolean Dig(Player p, int tab) {
		for(int i=0; i<tab; i++)
			System.out.print("\t");
		System.out.print("A Shovel osztaly Dig() fuggvenye hivodott meg");
		if (p.GetNumOfAction(tab + 1) <= 0)
			return false;
		p.SetNumOfAction(p.GetNumOfAction(tab + 1) - 1, tab + 1);
		p.DigPlayer(2, tab + 1);
		return true;
	}
}
