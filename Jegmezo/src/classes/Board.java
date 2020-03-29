package classes;
import java.util.ArrayList;
import java.util.Scanner;

public class Board {
	private ArrayList<Field> fields; 
	
	public Board(ArrayList<Field> fields, int tab) {
		this.fields=fields;
		for(int i=0; i<tab; i++)
			System.out.print("\t");
		System.out.println("Az Board osztaly konstruktora hivodott meg.");
	}
	
	public void Storm(int tab) {
		for(int i=0; i<tab; i++)
			System.out.print("\t");
		System.out.println("A Board osztaly Storm():void fuggvenye hivodott meg.");
		for(int i=0; i<tab; i++)
			fields.get(i).SetLayer(fields.get(i).GetLayer(tab+1)+1,tab+2);
		
	}
	
	/*public void Init(Field [1..*] fields) {
	}*/
}
