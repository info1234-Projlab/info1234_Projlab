package classes;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class GamePanel extends JPanel{
	
	private JButton actionButton;
	private JLabel InventoryLabel;
	private inventoryPanel iP;
	private BoardView board;
	
	public GamePanel(BoardView b){
		/*actionButton = new JButton("Use Ability");
		actionButton.setBounds(330, 600, 100, 30);
		this.add(actionButton);*/
		
		this.setLayout(null);
		iP = new inventoryPanel();
		iP.setBounds(0, 0, 300, 680);
		this.add(iP);
		
		board=b;
		//bP = new BoardPanel();
		this.add(board);
	}
	
	public void mouseClicked(MouseEvent e) {
		System.out.println(e.getPoint().x + ", " + e.getPoint().y);
		if (SwingUtilities.isLeftMouseButton(e)) {
			for (FieldView fv : board.getBoard().GetFieldViews()) {
				if (fv.CheckClicked(e.getPoint())) {
					iP.SetCurrentField(fv.GetField());
					iP.repaint();
					break;
				}
			}
		}
	}
}
