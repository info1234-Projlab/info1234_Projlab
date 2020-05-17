package classes;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GameOver extends JPanel {
	private BufferedImage img;
	
	public GameOver() {
		try {
			img = ImageIO.read(new File("GameOver.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.setSize(img.getWidth(), img.getHeight());
	}
	
	 protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        Graphics2D g2d = (Graphics2D) g;
	        g.drawImage(img,0,0,null);
	 }
}
