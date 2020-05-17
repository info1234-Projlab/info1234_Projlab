package classes;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.*;

public inventoryPanel(BoardView b){
		this.setPreferredSize(new Dimension(300,680));
		try{
			background = ImageIO.read(new File("inventoryBg.png"));
			fullHp = ImageIO.read(new File("FullHp.png"));
			lostHp = ImageIO.read(new File("lostHp.png"));
		} 
		catch(IOException ex){
			
			
		}
		this.setLayout(null);
		
		playerLabel = new JLabel("Player items");
		playerLabel.setBounds(10, 10, 300, 30);
		playerLabel.setFont(playerLabel.getFont().deriveFont(25f));
		playerLabel.setForeground(Color.getHSBColor(191, 18, 255));
		this.add(playerLabel);
		
		fieldLabel = new JLabel("Selected field items");
		fieldLabel.setBounds(10, 350, 300, 30);
		fieldLabel.setFont(playerLabel.getFont().deriveFont(25f));
		fieldLabel.setForeground(Color.getHSBColor(191, 18, 255));
		this.add(fieldLabel);
		
		
		this.addMouseListener(this);
		
		board = b;
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.setFont(new Font("TimesRoman",Font.BOLD,20));
		g.setColor(Color.BLACK);
		g.drawString("Action: " , 150, 70);
		g.drawString(Integer.toString(Game.GetCurrentPlayer().GetNumOfAction()), 230, 70);
		
		g.drawImage(background, 0, 0, null);
		g.fillRect(294, 0, 6, 690);
		
		for(int i = 0; i < Game.GetCurrentPlayer().GetHP(); i++){
			g.drawImage(fullHp, 10+i*25, 50	, null);
		}
		for(int i = 0; i < Game.GetCurrentPlayer().GetMaxHP()- Game.GetCurrentPlayer().GetHP(); i++){
			g.drawImage(lostHp, 10 + Game.GetCurrentPlayer().GetHP()*25 + i*25, 50	, null);
		}
		
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3 ; j++)	{
				g.setColor(Color.BLACK);
				g.fillRect(30+j*90, 100+i*90, 56, 56);
				g.setColor(new Color(97, 61, 30));
				g.fillRect(33+j*90, 103+i*90, 50, 50);
				if (Game.GetCurrentPlayer() != null) {
					if (Game.GetCurrentPlayer().GetItems() != null) {
						if(Game.GetCurrentPlayer().GetItems().size() > 3*i+j){
							Game.GetCurrentPlayer().GetItems().get(3*i+j).getView().setPoint(new Point(33+j*90, 103+i*90));
							Game.GetCurrentPlayer().GetItems().get(3*i+j).getView().Draw(g);
						}
					}
				}
			}
		}
		
		
		for(int i = 0; i < 2; i++){
			for(int j = 0; j < 3 ; j++)	{
				g.setColor(Color.BLACK);
				g.fillRect(30+j*90, 420+i*90, 56, 56);
				g.setColor(new Color(97, 61, 30));
				g.fillRect(33+j*90, 423+i*90, 50, 50);
				
				if(currentField == null) {
					if(Game.GetCurrentPlayer().GetItems().size() > 3*i+j){
						Game.GetCurrentPlayer().GetItems().get(3*i+j).getView().setPoint(new Point(33+j*90, 103+i*90));
						Game.GetCurrentPlayer().GetItems().get(3*i+j).getView().Draw(g);
					}
				}else if(currentField.GetItems().size() > 3*i+j){
					currentField.GetItems().get(3*i+j).getView().setPoint(new Point(33+j*90, 423+i*90));
					if(currentField.GetItems().get(3*i+j).GetVisible())	currentField.GetItems().get(3*i+j).getView().Draw(g);
				}
			}
		}
	}

	public void SetCurrentField(Field f) {
		this.currentField = f ;
	}
	
	public Field GetCurrentField() {
		return this.currentField;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (SwingUtilities.isLeftMouseButton(e)){
			if(e.getPoint().y > 400){
				if (currentField != null) {
					for (Inventory iv : currentField.GetItems()) {
						if (iv.getView().CheckClicked(e.getPoint())) {
							//System.out.println(iv.toString() + "Felvesz");
							if(currentField.GetCreatures().contains(Game.GetCurrentPlayer())){
								System.out.println("Felveszi");
								iv.PickUp(Game.GetCurrentPlayer());
							}
							this.repaint();
							break;
						}
					}
				}
				
			}
			else{
				if(Game.GetCurrentPlayer().GetItems().size() > 0){
					Iterator<Inventory> iv = Game.GetCurrentPlayer().GetItems().iterator();
					Inventory it =  null;
					Boolean find = false;
					while(iv.hasNext()){
						it =  iv.next();
						if (it.getView().CheckClicked(e.getPoint())) {
							find = true;
							break;
						}
					}
					if(find){
						it.Eat((Player)Game.GetCurrentPlayer());
						it.Dig(Game.GetCurrentPlayer());
						it.PutOn((Player)Game.GetCurrentPlayer());
						it.Shoot((Player)Game.GetCurrentPlayer());
						it.Swim((Player)Game.GetCurrentPlayer());
						System.out.println(currentField.GetLayer());
					}
				}
			}
		}
		if (SwingUtilities.isRightMouseButton(e)){
			if(e.getPoint().y < 400){
				Iterator<Inventory> iv = Game.GetCurrentPlayer().GetItems().iterator();
				Inventory it = null ;
				Boolean find = false;
				while(iv.hasNext()){
					it =  iv.next();
					if (it.getView().CheckClicked(e.getPoint())) {
						find = true;
						break;
					}
				}
				
				if(find){
					it.Drop(Game.GetCurrentPlayer());
					Game.GetCurrentPlayer().GetField().AddItem(it);
				}
			}
		}
		this.repaint();
		board.repaint();
	}
		
	

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
