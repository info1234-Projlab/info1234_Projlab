package classes;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class PolarBearView extends CanMoveView {
	
	
public PolarBearView() {
	try {
		img = ImageIO.read(new File("polarbear.png"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public void DrawInformation(Point coordinates) {
		
}


}
