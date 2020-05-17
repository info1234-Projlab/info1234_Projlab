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
	
	private JLabel numOfPlayersLabel = new JLabel("H�ny j�t�kos j�ttszik: ");
	private JLabel rowsLabel = new JLabel("H�ny sorb�l �lljon a p�lya: ");
	private JLabel columnsLabel = new JLabel("H�ny oszlopb�l �lljon a p�lya: ");
	private JButton startButton = new JButton("Start");
	private JButton numOfPlayersButton = new JButton("Ok");
	PlayerSelectPanel psP = new PlayerSelectPanel(1);
	JTextField numOfPlayersText = new JTextField();
	JTextField rowsText = new JTextField();
	JTextField columnsText = new JTextField();
	
	private int rows = 0;
	private int columns = 0;
	
	
	public MenuPanel(){
        this.setLayout(new GridLayout(5,1)); 
        
		this.setSize(1000, 680);

		JPanel setPlayerPanel = new JPanel();
		numOfPlayersText.setPreferredSize(new Dimension(80,30));
		numOfPlayersButton.addActionListener(this);
		setPlayerPanel.add(numOfPlayersLabel);
		setPlayerPanel.add(numOfPlayersText);
		setPlayerPanel.add(numOfPlayersButton);
		
		JPanel setRowsPanel = new JPanel();
		rowsText.setPreferredSize(new Dimension(80,30));
		setRowsPanel.add(rowsLabel);
		setRowsPanel.add(rowsText);
		setRowsPanel.setLocation(250, 250);
		
		JPanel setColumnsPanel = new JPanel();
		columnsText.setPreferredSize(new Dimension(80,30));
		setColumnsPanel.add(columnsLabel);
		setColumnsPanel.add(columnsText);
		setColumnsPanel.setLocation(250, 300);
		
		JPanel startButtonPanel = new JPanel();
		startButton.setPreferredSize(new Dimension(150,30));
		startButton.addActionListener(this);
		startButtonPanel.add(startButton);
		
		/*JScrollPane scrollPane = new JScrollPane();
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(50, 30, 300, 50);*/
        

		
		
		this.add(setPlayerPanel);
		this.add(setRowsPanel);
		this.add(setColumnsPanel);
		
		this.add(startButtonPanel, BorderLayout.SOUTH);
		JScrollPane sP = new JScrollPane(psP);
		psP.setAutoscrolls(true);
		sP.setPreferredSize(new Dimension( 800,600));
		this.add(sP);
	}
	
	public void InitGame() {
		Game g = new Game();
		
		psP.AddPlayersToGame(g);
		int numOfPolarBears = psP.GetNumOfPlayers() / 3;
		if(numOfPolarBears == 0)
			numOfPolarBears = 1;
		for(int i = 0; i<numOfPolarBears; i++)
			g.AddCreature(new PolarBear());
		g.MixCanMoves();
		
		g.InitBoard(rows, columns, psP.GetNumOfPlayers());
		
		myFrame mF = (myFrame) SwingUtilities.getWindowAncestor(this);
		mF.remove(this);
		GamePanel gp = new GamePanel(g.GetBoardView());
		g.AddGamePanel(gp);
		mF.add(gp);
		mF.setVisible(true);
		
		g.StartGame();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()){
		case "Start" :
			if(!rowsText.getText().equals(""))
				rows = Integer.parseInt(rowsText.getText());
			else
				rows = 10;
			if(!columnsText.getText().equals(""))
				columns = Integer.parseInt(columnsText.getText());
			else
				columns = 10;
			InitGame();
		case "Ok":
			if(!numOfPlayersText.getText().equals("")) {
				psP.SetNumOfPlayer(Integer.parseInt(numOfPlayersText.getText()));
				psP.repaint();
			}
			else{
				psP.SetNumOfPlayer(1);
				psP.repaint();
			}
			break;
		}
	}
		
}
