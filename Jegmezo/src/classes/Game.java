package classes;

import java.util.ArrayList;


//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : Game.java
//  @ Date : 3/27/2020
//  @ Author : 
//
//
/**
 * Az oszt�ly egy j�t�k fel�p�t�s��rt �s lebonyol�t�s��rt felel. 
 * Statikusak a f�ggv�nyei �s a param�terei is, �gy tett�k lehet�v�, hogy ha a j�t�k folyam�n a
 * Game oszt�lyt haszn�ljuk, ne kelljen p�ld�nyos�tani, a v�ltoztat�sok az elej�n l�trehozott
 * Game-ben t�rt�njenek
 *
 */
public class Game {
	private static CanMove currentPlayer;
	private static ArrayList<CanMove> cM = new ArrayList<CanMove>();
	private static Board board;
	private static int turn;
	
	public static CanMove GetCurrentPlayer() {
		return currentPlayer;
	}
	public static void SetCurrentPlayer(CanMove player) {
		currentPlayer=player;
	}
	
	public static void Clear() {
		currentPlayer= null;
		cM.clear();
		board = null;
	}
	
	public static int GetTurn() {
		return turn;
	}
	public static void Init(ArrayList<CanMove> players, Board board) {
	}
	
	public static void StartGame() {
	}
	
	public static boolean SomeoneDied() {
		for(int i=0; i<cM.size();i++) {
			if(cM.IsDead())
				return true;
		}
		return false;
	}
	
	public static void LoseGame() {
	}
	
	public static boolean Win() {
		for(int i=0; i<cM.size(); i++) {
			
		}
	}
	
	public static void SetBoard(Board b) {
		board=b;
	}
	
	public static Board GetBoard() {
		return board;
	}
	
	public static void SetCanMove(ArrayList<CanMove> cMove) {
		cM=cMove;
	}
	
	public static void AddCreature(CanMove cm) {
		cM.add(cm);
	}
}
