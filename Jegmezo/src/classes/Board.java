package classes;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.SwingUtilities;

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
	private ArrayList<Field> fields = new ArrayList<Field>();
	private BoardView boardView;
	
	
	/**
	 * @param fields ezek a malyan levo jegtablak, amiket majd inicializalas soran megadunk
	 * @param tab indentalashoz kell
	 */
	public Board() {
		this.boardView = new BoardView(this);
	}
	
	public void repaint() {
		boardView.repaint();
	}
	/**
	 * A Storm() fuggveny felelos a jatektablan idonkent atvonulo viharert.
	 */
	public void Storm() {
		for(int i=0; i<fields.size(); i++) {
			fields.get(i).Storm();			
		}
			
	}
	
	public void Init(int rows, int columns, int numOfPlayers) {
		int randCapacity, randSnowLayer;
		Random rand = new Random(); 
		for(int i = 0; i < rows; i++) {
			for(int j=0; j < columns; j++) {
		        randCapacity = rand.nextInt(numOfPlayers+1);
		        randSnowLayer = rand.nextInt(10);
		        if(randCapacity == numOfPlayers)
		        	fields.add(new StableField(randCapacity, randSnowLayer));
		        else if(randCapacity == 0)
		        	fields.add(new Hole());
		        else
		        	fields.add(new UnstableField(randCapacity, randSnowLayer));
		        if(i%2==0)
		        	fields.get(fields.size()-1).SetFieldView(50*j, 43*i);
		        else
		        	fields.get(fields.size()-1).SetFieldView(25+50*j, 43*i);
			}
		}
		for(int i=0; i<fields.size();i++)
			fields.get(i).AddBoardView(boardView);
		for(int i = 0; i < fields.size(); i++) {
			Point fieldCoordinate = fields.get(i).GetFieldView().GetCoordinates();
			for(int j = 0; j < fields.size(); j++) {
				Point neighbourCoordinate = fields.get(j).GetFieldView().GetCoordinates();
				if(IsNeighbour(fieldCoordinate, neighbourCoordinate))
					fields.get(i).AddNeighbour(fields.get(j));
			}
		}
		InitInventory(numOfPlayers);
	}
	
	public boolean IsNeighbour(Point fieldCoord, Point neighbourCoord) {
		if(fieldCoord.y == neighbourCoord.y && Math.abs(neighbourCoord.x - fieldCoord.x) == 50)
			return true;
		if(Math.abs(neighbourCoord.x - fieldCoord.x) == 25 && Math.abs(neighbourCoord.y - fieldCoord.y) == 43)
			return true;
		return false;
	}
	
	public void InitInventory(int numOfPlayers) {
		Random random = new Random();
		int randFieldIndex;
		randFieldIndex = random.nextInt(fields.size());
		fields.get(randFieldIndex).InitInventory(new Flare(0, false));
		randFieldIndex = random.nextInt(fields.size());
		fields.get(randFieldIndex).InitInventory(new Cartridge(0, false));
		randFieldIndex = random.nextInt(fields.size());
		fields.get(randFieldIndex).InitInventory(new Gun(0, false));
		int numOfFood = numOfPlayers * 3;
		for(int i = 0; i < numOfFood; i++) {
			randFieldIndex = random.nextInt(fields.size());
			fields.get(randFieldIndex).InitInventory(new Food(0, false));
		}
		int numOfShovels = numOfPlayers - 1;
		for(int i = 0; i < numOfShovels; i++) {
			randFieldIndex = random.nextInt(fields.size());
			if(!fields.get(randFieldIndex).InitInventory(new Shovel(0, false)))
				i-=1;
		}
		int numOfFragileShovels = numOfPlayers - 1;
		for(int i = 0; i < numOfFragileShovels; i++) {
			randFieldIndex = random.nextInt(fields.size());
			if(!fields.get(randFieldIndex).InitInventory(new FragileShovel(0, false)))
				i-=1;
		}
		int numOfRopes = numOfPlayers - 2;
		if(numOfRopes < 1)
			numOfRopes = 1;
		for(int i = 0; i < numOfRopes; i++) {
			randFieldIndex = random.nextInt(fields.size());
			if(!fields.get(randFieldIndex).InitInventory(new Rope(0, false)))
				i-=1;
		}
		int numOfDivingSuits = numOfPlayers - 1;
		for(int i = 0; i < numOfDivingSuits; i++) {
			randFieldIndex = random.nextInt(fields.size());
			if(!fields.get(randFieldIndex).InitInventory(new DivingSuit(0, false)))
				i-=1;
		}
			
	}
	
	public void AddPlayer(Player p) {
		fields.get(0).AddCreature(p);
	}
	
	public void AddPolarBear(PolarBear b) {
		fields.get(fields.size()-1).AddCreature(b);
	}
	
	public BoardView GetBoardView() {
		return boardView;
	}
	
	public ArrayList<FieldView> GetFieldViews(){
		ArrayList<FieldView> fw = new ArrayList<FieldView>();
		for(int i = 0; i < fields.size(); i++) {
			fw.add(fields.get(i).GetFieldView());
		}
		return fw;
	}
	
	/**
	 * A parameterkent kapott Field objektumokbol letrehozza a jatektablat. 
	 */
	/*public void Init(Field [1..*] fields) {
	}*/
}
