package classes;
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : Item.java
//  @ Date : 3/27/2020
//  @ Author : 
//
//




public class Item implements Inventory {
	protected int layer;
	protected boolean visible;
	
	public boolean Eat(Player p) {
		return false;
	}
	
	public boolean Dig(Player p) {
		return false;
	}
	
<<<<<<< HEAD
	public boolean Pull(Player p) {
=======
	public boolean Pull(Player p, Field to) {
>>>>>>> 6b304ea47f1e11ad222afc7039790040533f41dc
		return false;
	}
	
	public boolean PutOn(Player p) {
		return false;
	}
	
	public boolean Shoot(Player p) {
		return false;
	}
	
	public boolean Swim(Player p) {
		return false;
	}
	
	public void Drop(Player p) {

	}
	
	public void DecreaseLayer(int i) {
<<<<<<< HEAD
		layer -= 1;
	}
	
	public void PickUp(Player p) {
	}
	
	public int GetLayer() {
		return layer;
	}
	
	public void SetVisible(boolean b) {
		visible = b;
=======
		layer=layer-i;
	}
	
	public void PickUp(Player p) {
>>>>>>> 6b304ea47f1e11ad222afc7039790040533f41dc
	}
}
