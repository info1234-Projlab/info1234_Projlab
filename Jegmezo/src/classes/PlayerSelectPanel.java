package classes;

import java.awt.Graphics;
import java.awt.Graphics2D;
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

import java.awt.*;

public class PlayerSelectPanel extends JPanel implements MouseListener {
	
	private int numOfPlayers = 0;
	private ArrayList<Images> images = new ArrayList<Images>();
	private Point click;
	
	public PlayerSelectPanel(){
		
		this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
		addMouseListener(this);	
	}
	
	public void paintComponent(Graphics g){ 
        super.paintComponent(g);
        
        for(int i = 0; i < images.size(); i++){
        	images.get(i).Draw(g, click);
        }
        
    }
	
	public void setNum_of_player(int n){
		numOfPlayers = n;
		System.out.println(numOfPlayers);
		images.clear();
		Point p = new Point(100,100);
		for(int i = 1; i <= numOfPlayers; i++){
        	images.add(new Images(p,i));
        	p.y+=100;
        }
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		click = e.getPoint();
		System.out.println(click.x);
		this.repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	
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
