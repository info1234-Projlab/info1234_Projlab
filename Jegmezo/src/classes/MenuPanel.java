package classes;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;

import java.awt.*;

public class MenuPanel extends JPanel implements ActionListener{
	
	private JLabel jL= new JLabel("Hány játékos játszik: ");
	private JComboBox<String> setPlayer = new JComboBox<String>();
	private JButton start = new JButton("START");
	PlayerSelectPanel psP = new PlayerSelectPanel(1);
	
	public MenuPanel(){
		super(new BorderLayout());
		
		this.setSize(1000, 680);
		
		
		
		setPlayer = new JComboBox();
		setPlayer.setPreferredSize(new Dimension(200,30));
		
		for(int i = 1; i <= 5; i++){
			setPlayer.addItem(Integer.toString(i) + " Játékos");
		}
		setPlayer.addActionListener(this);
		JPanel setPlayerPanel = new JPanel();
		setPlayerPanel.add(jL);
		setPlayerPanel.add(setPlayer);
		this.add(setPlayerPanel,BorderLayout.NORTH);
		
		
		start.setPreferredSize(new Dimension(150,30));
		
		start.addActionListener(this);
		JPanel startPanel = new JPanel();
		startPanel.add(start);
		this.add(startPanel,BorderLayout.SOUTH);
		
		this.add(psP,BorderLayout.CENTER);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		switch(e.getActionCommand()){
		case "START" : myFrame mF = (myFrame) SwingUtilities.getWindowAncestor(this);
						mF.remove(this);
						mF.add(new GamePanel());
						mF.setVisible(true);
			break;
		default: JComboBox cb = (JComboBox)e.getSource();
				int playerNum = (Integer) cb.getSelectedIndex() +1;
				psP.setNum_of_player(playerNum);
				psP.repaint();
			break;
		}
		
		

	}
		
}
