package classes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

public class BoardView extends JPanel{
	private ArrayList<FieldView> fieldViews = new ArrayList<FieldView>();
	
	public BoardView(ArrayList<FieldView> fw) {
		this.setBounds(300, 0, 700, 680);
		fieldViews = fw;
	}
	
	 protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(51,204,255));
        g2d.fillRect(0,0,700,680);
        for(int i=0; i< fieldViews.size();i++) {
        	fieldViews.get(i).Draw(g);
        }
	 }
}
