package classes;

import java.util.ArrayList;


public class Game {
	private static Player currentPlayer;
	private static ArrayList<Player> players;
	private static Board board;
	
	public static Player GetCurrentPlayer(int tab) {
		for(int i=0; i<tab; i++)
			System.out.print("\t");
		System.out.printf("A Game osztály GetCurrentPlayer():Player hívódott meg \n");
		return currentPlayer;
	}
	public static void Init(ArrayList<Player> players, Board board) {
	}
	
	public static void StartGame() {
	}
	
	public static boolean SomeoneDied() {
	}
	
	public static void LoseGame() {
	}
	
	public static boolean Win() {
	}
}
