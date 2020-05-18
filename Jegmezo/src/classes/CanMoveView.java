package classes;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

/**
 * Egy CanMove obijektum grafikus reprezentálása.
 * 
 *  */
public class CanMoveView {
	
	/**
	 * A CanMove-hoz tartozó kép tárolását végzi
	 */
	protected Image img;
	
	
	/**
	 * A kapott grafikus felületre kirajzolja a pont alapján a saját képét. Szükség esetén a képet átméretezi.
	 * @param coordinates
	 * @param g
	 * @param resize
	 */
	public void Draw(Point coordinates, Graphics g, double resize) {
		Image resizedImg = img.getScaledInstance((int)(img.getWidth(null) * resize), (int)(img.getHeight(null) * resize), Image.SCALE_DEFAULT);
		g.drawImage(resizedImg, coordinates.x, coordinates.y + 25 - resizedImg.getHeight(null) / 2, null);
	}
	
	
	public void DrawInformation(Point coordinates) {
		
	}

}
