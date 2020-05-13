package iceField;
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
		
		playerLabel = new JLabel("XY Játékos");
		playerLabel.setBounds(10, 20, 250, 50);
		playerLabel.setFont(playerLabel.getFont().deriveFont(40f));
		playerLabel.setForeground(Color.getHSBColor(191, 18, 255));
		this.add(playerLabel);
		
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
			}
		}
		
		g.drawImage(food, 33, 103, null);
		
		tesztDraw tD = new tesztDraw();
		tD.draw(g);
	}
}
