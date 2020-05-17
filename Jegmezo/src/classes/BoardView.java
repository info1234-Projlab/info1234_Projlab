package classes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class BoardView extends JPanel implements ActionListener, MouseListener{
	private Board board;
	private JButton actionButton;
	private JButton endTurnButton;
	private JButton digButton;
	private inventoryPanel inventory;
	private Field lastClicked;
	
	public BoardView(Board b) {
		this.setBounds(0, 0, 1000, 1000);
		this.setLayout(null);
		
		actionButton = new JButton("Use Ability");
		actionButton.setBounds(30, 600, 100, 30);
		this.add(actionButton);
		actionButton.addActionListener(this);
		
		endTurnButton = new JButton("End Turn");
		endTurnButton.setBounds(160,600,100,30);
		this.add(endTurnButton);
		endTurnButton.addActionListener(this);
		
		digButton = new JButton("DIG");
		digButton.setBounds(290, 600, 100, 30);
		this.add(digButton);
		digButton.addActionListener(this);
		
		board = b;
		this.addMouseListener(this);
	}
	
	 protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(51,204,255));
        g2d.fillRect(0,0,700,680);
        ArrayList<FieldView> fw = board.GetFieldViews();
        for(int i=0; i < fw.size(); i++) {
        	fw.get(i).Draw(g);
        }
	 }
	 
	 public inventoryPanel GetInventoryPanel() {
		 return inventory;
	 }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch(e.getActionCommand()){
		case "Use Ability" :
			Game.GetCurrentPlayer().UseAbility(lastClicked);
			this.repaint();
			break;
		case "End Turn" : 
			Game.NextPlayer();
			this.repaint();
			inventory.repaint();
			break;
		case "DIG" : 
			Game.GetCurrentPlayer().DigPlayer(1);
			inventory.repaint();
			this.repaint();
			break;
		}
	}
	
	public Board getBoard(){
		return board;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		//System.out.println(e.getPoint().x + ", " + e.getPoint().y);
		if (SwingUtilities.isRightMouseButton(e)) {
			for (FieldView fv : board.GetFieldViews()) {
				if (fv.CheckClicked(e.getPoint())) {
					Game.GetCurrentPlayer().Move(fv.GetField());
					System.out.println(Game.GetCurrentPlayer().toString());
					//System.out.println("akart mozogni");
					this.repaint();
					inventory.repaint();
					break;
				}
			}
			for(Inventory inv : Game.GetCurrentPlayer().GetItems()) {
				if(inv.getView().CheckClicked(e.getPoint())) {
					// call inventory method (e g eat)
					Game.GetCurrentPlayer().RemoveItem(inv);
					inventory.repaint();
					break;
				}
			}
		}else if (SwingUtilities.isLeftMouseButton(e)) {
			for (FieldView fv : board.GetFieldViews()) {
				if (fv.CheckClicked(e.getPoint())) {
					inventory.SetCurrentField(fv.GetField());
					lastClicked = fv.GetField();
					inventory.repaint();
					break;
				}
			}
			/*if (inventory.GetCurrentField() != null) {
				for(Inventory inv : inventory.GetCurrentField().GetItems()) {
					if(inv.getView().CheckClicked(e.getPoint())) {
						Game.GetCurrentPlayer().AddItem(inv);
						inventory.repaint();
						break;
					}
				}
			}*/
			
		}
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void SetInventory(inventoryPanel ip) {
		this.inventory = ip;
		this.add(inventory);
	}
}
