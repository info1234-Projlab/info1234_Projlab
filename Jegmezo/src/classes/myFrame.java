package classes;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class myFrame extends JFrame implements ActionListener{
	
	MenuPanel mP= new MenuPanel();

	ImageIcon img = new ImageIcon("iglu.png");
	
	public myFrame(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(1000, 680));
		this.setTitle("IceField");
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		this.setIconImage(img.getImage());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("LLL");
		
	}
}
