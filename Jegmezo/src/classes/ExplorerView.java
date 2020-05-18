package classes;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Az Explorer obijektum grafikus megjelenitese.
 *
 */
public class ExplorerView extends CanMoveView{
	
	public ExplorerView(){
		try {
			img = ImageIO.read(new File("explorer.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void DrawInformation(Point coordinates) {
			
	}


}
