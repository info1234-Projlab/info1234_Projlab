package classes;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ExplorerView extends CanMoveView{
	
public ExplorerView(){
	try {
		img = ImageIO.read(new File("explorer.png"));
	} catch (IOException e) {
		e.printStackTrace();
	}
}

	
/*public void Draw(Point coordinates, Graphics g, double resize) {
	g.drawImage(img, coordinates.x, coordinates.y, null);
}*/
public void DrawInformation(Point coordinates) {
		
}


}
