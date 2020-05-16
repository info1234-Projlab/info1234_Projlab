package classes;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.*;

public class inventoryPanel extends JPanel{
	private Image background ;
	private Image fullHp;
	private Image lostHp;
	private Image food;
	private JLabel playerLabel;
	private JLabel fieldLabel;
	private JLabel snowLayer;
	
	public inventoryPanel(){
		this.setPreferredSize(new Dimension(300,680));
		try{
			background = ImageIO.read(new File("inventoryBg.png"));
			fullHp = ImageIO.read(new File("fullHp.png"));
			lostHp = ImageIO.read(new File("lostHp.png"));
			food = ImageIO.read(new File("food.png"));
		} 
		catch(IOException ex){
			
			
		}
		this.setLayout(null);
		
		playerLabel = new JLabel("XY Játékos");
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
				if(Game.GetCurrentPlayer().GetItems().size() > i+j){
					Game.GetCurrentPlayer().GetItems().get(i+j).getView().Draw(new Point(33+j*90, 103+i*90), g);
				}
				
			}
		}
		
		
		for(int i = 0; i < 2; i++){
			for(int j = 0; j < 3 ; j++)	{
				g.setColor(Color.BLACK);
				g.fillRect(30+j*90, 420+i*90, 56, 56);
				g.setColor(new Color(97, 61, 30));
				g.fillRect(33+j*90, 423+i*90, 50, 50);
				
				if(Game.GetCurrentPlayer().GetField().GetItems().size() > i+j){
					Game.GetCurrentPlayer().GetField().GetItems().get(i+j).getView().Draw(new Point(33+j*90, 423+i*90), g);
				}
			}
		}
	}
}
