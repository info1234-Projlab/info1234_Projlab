package classes;
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : Cartridge.java
//  @ Date : 3/27/2020
//  @ Author : 
//
//

/**
 * 
 * Kulonleges targy, mert a jatek megnyeresehez elengedhetetlen. 
 * Barmely tipusu jatekos felveheti amely egy egys�g munkat vesz igenybe. A nyereshez a masik ket 
 * fontos alkatresszel kell osszeszerelni, ami szinten egy munka.
 *
 */


public class Cartridge extends FlareGun implements Inventory {
	/**
	 * 
	 * @param layer mennyi r�teg h� van a t�rgy felett
	 * @param visible ez akkor igaz ha l�that�a t�rgy(nincs rajta h�
	 */
	public Cartridge(int layer, boolean visible) {
		super(layer,visible);
	}
}
