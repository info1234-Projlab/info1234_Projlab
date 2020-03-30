package classes;

import java.util.ArrayList;

public class StableField extends Field {
	
	public StableField(int capacity, int snowLayer, int tab) {
		super(capacity, snowLayer, tab);
		for(int i=0; i<tab; i++)
			System.out.print("\t");
		System.out.println("A StableField osztaly konstruktora hivodott meg.");
	}
	
	public boolean IsFall(int tab) {
		for(int i=0; i<tab; i++)
			System.out.print("\t");
		System.out.println("Az StableField osztaly IsFall() fuggvenye hivodott meg.");
		return false;
	}
	
	public void Fall() {
	}
}
