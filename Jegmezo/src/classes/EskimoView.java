package classes;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class EskimoView {
private Image img ;

public EskimoView() {
	try {
		img = ImageIO.read(new File("eskimo.png"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

	public void Draw(Point coordinates, Graphics g) {
		g.drawImage(img, coordinates.x, coordinates.y, null);
	}
	public void DrawInformation(Point coordinates) {
		
	}
}
