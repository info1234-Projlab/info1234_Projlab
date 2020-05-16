package classes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class BoardView extends JPanel implements MouseListener{
	private Board board;
	
	public BoardView(Board b) {
		this.setBounds(300, 0, 700, 680);
		board = b;
		this.addMouseListener(this);
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

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println(e.getPoint().x + ", " + e.getPoint().y);
		if (SwingUtilities.isRightMouseButton(e)) {
			for (FieldView fv : board.GetFieldViews()) {
				if (fv.CheckClicked(e.getPoint())) {
					Game.GetCurrentPlayer().Move(fv.GetField());
					System.out.println(Game.GetCurrentPlayer().toString());
					System.out.println("akart mozogni");
					this.repaint();
					break;
				}
			}
		}
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
