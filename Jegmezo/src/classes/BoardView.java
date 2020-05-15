package classes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

public class BoardView extends JPanel{
	private Board board;
	
	public BoardView(Board b) {
		this.setBounds(300, 0, 700, 680);
		board = b;
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
}
