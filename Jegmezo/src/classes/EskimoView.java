package classes;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


/**
 * 
 * Az Eszkimo obijektum grafikus megjelenitese.
 */
public class EskimoView extends CanMoveView{

	public EskimoView() {
		try {
			img = ImageIO.read(new File("eskimo.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
