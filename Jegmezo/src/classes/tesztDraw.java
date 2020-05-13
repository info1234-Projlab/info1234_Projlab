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



public class tesztDraw {
	
	private Image image;
	public tesztDraw(){
		try{
			image = ImageIO.read(new File("divingsuit.png"));
		} 
		catch(IOException ex){
			
		}
	}
	
	public void draw(Graphics g){
		g.drawImage(image, 123, 103, null);
	}
}
