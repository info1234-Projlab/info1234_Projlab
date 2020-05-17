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
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.*;

public class inventoryPanel extends JPanel implements MouseListener{
	private Image background ;
	private Image fullHp;
	private Image lostHp;
	private JLabel playerLabel;
	private JLabel fieldLabel;
	private JLabel snowLayer;
	private Field currentField;
	
	public inventoryPanel(){
		this.setPreferredSize(new Dimension(300,680));
		try{
			background = ImageIO.read(new File("inventoryBg.png"));
			fullHp = ImageIO.read(new File("fullHp.png"));
			lostHp = ImageIO.read(new File("lostHp.png"));
		} 
		catch(IOException ex){
			
			
		}
		this.setLayout(null);
		
		playerLabel = new JLabel("XY JĂˇtĂ©kos");
		playerLabel.setBounds(10, 10, 300, 30);
		playerLabel.setFont(playerLabel.getFont().deriveFont(40f));
		playerLabel.setForeground(Color.getHSBColor(191, 18, 255));
		this.add(playerLabel);
		
		fieldLabel = new JLabel("Selected Field");
		fieldLabel.setBounds(10, 350, 300, 30);
		fieldLabel.setFont(playerLabel.getFont().deriveFont(40f));
		fieldLabel.setForeground(Color.getHSBColor(191, 18, 255));
		this.add(fieldLabel);
		
		snowLayer = new JLabel();
		snowLayer.setText("Snow Layer: ");
		snowLayer.setBounds(10, 600, 300, 30);
		snowLayer.setFont(playerLabel.getFont().deriveFont(40f));
		snowLayer.setForeground(Color.getHSBColor(191, 18, 255));
		this.add(snowLayer);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.drawImage(background, 0, 0, null);
		g.fillRect(294, 0, 6, 690);
		for(int i = 0; i < 3; i++){
			g.drawImage(fullHp, 70+i*25, 50	, null);
		}
		for(int i = 0; i < 2; i++){
			g.drawImage(lostHp, 150+i*25, 50	, null);
		}
		
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3 ; j++)	{
				g.setColor(Color.BLACK);
				g.fillRect(30+j*90, 100+i*90, 56, 56);
				g.setColor(new Color(97, 61, 30));
				g.fillRect(33+j*90, 103+i*90, 50, 50);
				if (Game.GetCurrentPlayer() != null) {
					if (Game.GetCurrentPlayer().GetItems() != null) {
						if(Game.GetCurrentPlayer().GetItems().size() > i+j){
								Game.GetCurrentPlayer().GetItems().get(i+j).getView().setPoint(new Point(33+j*90, 103+i*90));
								Game.GetCurrentPlayer().GetItems().get(i+j).getView().Draw(g);
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
					if(Game.GetCurrentPlayer().GetItems().size() > i+j){
						Game.GetCurrentPlayer().GetItems().get(i+j).getView().setPoint(new Point(33+j*90, 103+i*90));
						Game.GetCurrentPlayer().GetItems().get(i+j).getView().Draw(g);
					}
				}else if(currentField.GetItems().size() > i+j){
					currentField.GetItems().get(i+j).getView().setPoint(new Point(33+j*90, 423+i*90));
					currentField.GetItems().get(i+j).getView().Draw(g);
				}
			}
		}
	}

	public void SetCurrentField(Field f) {
		this.currentField = f ;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (SwingUtilities.isRightMouseButton(e)) {
			for (Inventory iv : currentField.GetItems()) {
				if (iv.getView().CheckClicked(e.getPoint())) {
					System.out.println(iv.toString() + "Felvesz");
					this.repaint();
					break;
				}
			}
		}
		
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
