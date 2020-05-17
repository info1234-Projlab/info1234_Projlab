package classes;
//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : UnstableField.java
//  @ Date : 3/27/2020
//  @ Author : 
//
//



/**
 * Egy instabil mezot reprezental, tehat nehany jatekost bir el az adott mezo, de nem
 * az osszeset.
 */
public class UnstableField extends Field {
	
	/**
	 * Konstruktor
	 * @param capacity : megmondja, hany jatekost bir el 
	 * @param snowLayer : a mezon levo ho retegeinek szama
	 * 
	 */
	public UnstableField(int capacity, int snowLayer) {
		super(capacity, snowLayer);
		view = new UnstableFieldView(this);
	}
	/**
	 * Ha tobben vannak a mezon, mint ahany jatekost elbir, akkor beleesnek a vizbe. 
	 */
	public boolean IsFall(){
		if(numOfPlayers > capacity){
			return true;
		}
		else{
			return false;
		}
	}
}
