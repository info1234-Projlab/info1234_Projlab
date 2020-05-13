package classes;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

abstract public class ShelterView {
	protected Image img;
	
	public void Draw(Point coordinates, Graphics g) {
		g.drawImage(img, coordinates.x, coordinates.y, null);
	}
}
