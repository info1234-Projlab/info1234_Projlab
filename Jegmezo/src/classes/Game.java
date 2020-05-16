package classes;

import java.util.ArrayList;
import java.util.Collections;


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
	private static Board board = new Board();
	private static int turn;
	/**
	 * Visszaadja a jelenlegi játékost.
	 */
	public static CanMove GetCurrentPlayer() {
		return currentPlayer;
	}
	/**
	 * Beállítja a jelenlegi játékost.
	 */
	public static void SetCurrentPlayer(CanMove player) {
		currentPlayer=player;
	}
	/**
	 * Visszaadja a mostani kör számát.
	 */
	public static int GetTurn() {
		return turn;
	}
	public static void Init(ArrayList<CanMove> players, Board board) {
	}
	
	public void InitBoard(int rows, int columns, int numOfPlayers) {
		board.Init(rows, columns, numOfPlayers);
		board.AddCreatures(cM);
		currentPlayer = cM.get(0);
	}
	
	public static void StartGame() {
		currentPlayer.StartTurn(4);
		int indexOfCurrentPlayer = cM.indexOf(currentPlayer);
		if(indexOfCurrentPlayer == cM.size()-1)
			currentPlayer= cM.get(0);
		else
			currentPlayer = cM.get(indexOfCurrentPlayer+1);
	}
	
	/**
	 * Igazzal tér vissza, ha valakinek az élete 0-ra csökkent.
	 */
	public static boolean SomeoneDied() {
		for(int i=0; i<cM.size();i++) {
			if(cM.get(i).IsDead())
				return true;
		}
		return false;
	}
	
	public BoardView GetBoardView() {
		return board.GetBoardView();
	}
	
	public static void LoseGame() {
	}
	
	/**
	 * Minden játékos win attribútumot igazra állítja.
	 */
	public static boolean Win() {
		for(int i=0; i<cM.size(); i++) {
			if(cM.get(i).Win())
				return true;
		}
		return false;
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
	
	public static void MixCanMoves() {
		Collections.shuffle(cM);
	}
	/**
	 * Hozzáad egy CanMove-ot a listába.
	 * @param cm a hozzáadot CanMove.
	 */
	public static void AddCreature(CanMove cm) {
		cM.add(cm);
	}
}
