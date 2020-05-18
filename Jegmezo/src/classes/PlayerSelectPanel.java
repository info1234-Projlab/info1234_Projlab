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

/**
 * A menuPanelben levo jatekosvalasztas segedpanelja.
 *
 */
public class PlayerSelectPanel extends JPanel implements MouseListener {
	
	private int numOfPlayers = 0;
	private ArrayList<Images> images = new ArrayList<Images>();
	private Point click;
	
	public PlayerSelectPanel(int num){
		numOfPlayers = num;
		Point p = new Point(450,50);
		this.setPreferredSize(new Dimension(970, numOfPlayers*130));
		for(int i = 1; i <= numOfPlayers; i++){
        	images.add(new Images(new Point(p.x,p.y),i));
        	p.y+=100;
        }
		this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
		addMouseListener(this);	
		
	}
	
	public void paintComponent(Graphics g){ 
        super.paintComponent(g);
        
        for(int i = 0; i < images.size(); i++){
        	images.get(i).Draw(g, click);
        }
        
    }
	
	public void SetNumOfPlayer(int n){
		numOfPlayers = n;
		images.clear();
		Point p = new Point(450,50);
		for(int i = 1; i <= numOfPlayers; i++){
        	images.add(new Images(new Point(p.x,p.y),i));
        	p.y+=100;
        }
		this.repaint();
		this.setPreferredSize(new Dimension(970, numOfPlayers*100));
	}
	
	public int GetNumOfPlayers() {
		return numOfPlayers;
	}
	
	public void AddPlayersToGame(Game g) {
		for(int i=0; i<images.size(); i++)
			images.get(i).AddPlayerToGame(g);
	}

	public void mouseClicked(MouseEvent e) {
		click = e.getPoint();
		this.repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}
	
}
