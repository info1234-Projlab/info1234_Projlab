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
	
	private int num_of_player;
	private BufferedImage eskimo;
	private BufferedImage explorer;
	private Image background;
	private ArrayList<Boolean> character;
	
	
	public PlayerSelectPanel(int i){
		this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
		num_of_player = i;
		character = new ArrayList<Boolean>();
		character.add(true);
		character.add(true);
		character.add(false);
		character.add(true);
		character.add(false);
		addMouseListener(this);
		
		try {                
    		eskimo = ImageIO.read(new File("eskimo.png"));
    		explorer = ImageIO.read(new File("explorer.png"));
    		background = ImageIO.read(new File("iceFieldBg.png"));
         } catch (IOException ex) {
             
         }
		System.out.println(num_of_player); 
		
	}
	
	public void paintComponent(Graphics g)
    { 
        super.paintComponent(g);
        
        //g.drawImage(background, 0, 0, null);
        for(int i = 0; i < num_of_player;i++){
        	JLabel playerL = new JLabel(Integer.toString(i) + ". Játékos");
        	playerL.setPreferredSize(new Dimension(100,50));
        	this.add(playerL);
        	g.drawString(Integer.toString(i+1) + ". Játékos", 400, 20+i*100);
        	g.drawImage(eskimo, 500, 20+i*100,100,100, this);
        	g.drawImage(explorer, 600, 20+i*100,100,100, this);
        	if(character.get(i)){
        		g.drawRect(510, 20+i*100, 80, 100);
        	}else{
        		g.drawRect(610, 20+i*100, 80, 100);
        	}
        	
        }
        
    }
	
	public void setNum_of_player(int i){
		num_of_player = i;
		System.out.println(num_of_player);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Point p = e.getPoint();
		if(p.y > 20 && p.y < 120){
			if(p.x > 510 && p.x < 590){
				System.out.println("1. jatekos eszkimo");
				character.set(0, true);
				this.repaint();
			}
			else{
				if(p.x > 610 && p.x < 690){
					System.out.println("1. jatekos explorer");
					character.set(0, false);
					this.repaint();
				}
			}
		}
		else{
			if(p.y > 120 && p.y < 220){
				if(num_of_player >= 2){
					if(p.x > 510 && p.x < 590){
						System.out.println("2. jatekos eszkimo");
						character.set(1, true);
						this.repaint();
					}
					else{
						if(p.x > 610 && p.x < 690){
							System.out.println("2. jatekos explorer");
							character.set(1, false);
							this.repaint();
						}
					}
				}
			}
			else{
				if(p.y > 220 && p.y < 320){
					if(num_of_player >= 3){
						if(p.x > 510 && p.x < 590){
							System.out.println("3. jatekos eszkimo");
							character.set(2, true);
							this.repaint();
						}
						else{
							if(p.x > 610 && p.x < 690){
								System.out.println("3. jatekos explorer");
								character.set(2, false);
								this.repaint();
							}
						}
					}
				}
				else{
					if(p.y > 320 && p.y < 420){
						if(num_of_player >= 4){
							if(p.x > 510 && p.x < 590){
								System.out.println("4. jatekos eszkimo");
								character.set(3, true);
								this.repaint();
							}
							else{
								if(p.x > 610 && p.x < 690){
									System.out.println("4. jatekos explorer");
									character.set(3, false);
									this.repaint();
								}
							}
						}
					}
					else{
						if(p.y > 420 && p.y < 520){
							if(num_of_player >= 5){
								if(p.x > 510 && p.x < 590){
									System.out.println("5. jatekos eszkimo");
									character.set(4, true);
									this.repaint();
								}
								else{
									if(p.x > 610 && p.x < 690){
										System.out.println("5. jatekos explorer");
										character.set(4, false);
										this.repaint();
									}
								}
							}
						}
					}
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
