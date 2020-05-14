package classes;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ItemView {
	protected Image img;
	
	public ItemView(String path){
		try {
			img = ImageIO.read(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void Draw(Point coordinates, Graphics g) {
		g.drawImage(img, coordinates.x, coordinates.y, null);
	}
}
