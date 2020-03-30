package classes;
import java.util.ArrayList;
import java.util.Scanner;

//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : Board.java
//  @ Date : 3/27/2020
//  @ Author : 
//
//

/**A jegmezo jegtablakat tarol. Ez az osztaly felelos a hoviharokert, amely hatarozatlan idokozonkent sopor vegig a palyan.
 *  Ez a jelens�g a jatakosok testhojet egy egyseggel csokkenti es egy reteg ho kerul arra mezore ami felett elhaladt,
 *  azonban az iglun nem hatol at igy azok a jegtablak vedettek illetve a rajta levo jatekosok is.
 *
 */

public class Board {
	private ArrayList<Field> fields; 
	
	/**
	 * @param fields ezek a malyan levo jegtablak, amiket majd inicializalas soran megadunk
	 * @param tab indentalashoz kell
	 */
	public Board(ArrayList<Field> fields, int tab) {
		this.fields=fields;
		for(int i=0; i<tab; i++)
			System.out.print("\t");
		System.out.println("Az Board osztaly konstruktora hivodott meg.");
	}
	
	/**
	 * A Storm() fuggveny felelos a jatektablan idonkent atvonulo viharert.
	 */
	public void Storm(int tab) {
		for(int i=0; i<tab; i++)
			System.out.print("\t");
		System.out.println("A Board osztaly Storm():void fuggvenye hivodott meg.");
		for(int i=0; i<fields.size(); i++)
			fields.get(i).SetLayer(fields.get(i).GetLayer(tab+1)+1,tab+2);
	}
	
	/**
	 * A parameterkent kapott Field objektumokbol letrehozza a jatektablat. 
	 */
	/*public void Init(Field [1..*] fields) {
	}*/
}
