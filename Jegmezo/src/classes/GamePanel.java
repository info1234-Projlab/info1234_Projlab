package classes;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class GamePanel extends JPanel{
	
	private BoardView board;
	
	public GamePanel(BoardView b){
		board=b;
		board.setBounds(300, 0, 700, 680);
		this.add(board);
		
		this.setLayout(null);
		inventoryPanel iP = new inventoryPanel(board);
		iP.setBounds(0, 0, 300, 680);
		board.SetInventory(iP);
		this.add(iP);
		
		
	}
	
	
}
