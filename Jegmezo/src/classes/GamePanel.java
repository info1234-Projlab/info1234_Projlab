package classes;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.*;

public class GamePanel extends JPanel{
	
	private JButton actionButton;
	private JLabel InventoryLabel;
	private inventoryPanel iP;
	private BoardView boardView;
	private Game game;
	
	public GamePanel(Game g){
		actionButton = new JButton("Use Ability");
		actionButton.setBounds(330, 600, 100, 30);
		this.setLayout(null);
		this.add(actionButton);
		
		iP = new inventoryPanel();
		iP.setBounds(0, 0, 300, 680);
		this.add(iP);
		
		game = g;
		g.StartGame();
		//bP = new BoardPanel();
		//this.add(bP);
		
	}
}
