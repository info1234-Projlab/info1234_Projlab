package classes;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ItemView {
	protected Image img;
	private Point coordinates;
	private Point center;
	
	public ItemView(String path){
		try {
			img = ImageIO.read(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		coordinates = new Point(0,0);
		center = new Point(25,25);
	}
	
	public void Draw( Graphics g) {
		g.drawImage(img, coordinates.x, coordinates.y, null);
	}
	
	public void setPoint(Point p){
		coordinates = p;
		center.x = p.x+25;
		center.y = p.y+25;
	}
	
	public boolean CheckClicked(Point p) {
		Point center = new Point(coordinates.x + 25, coordinates.y + 25);
		double a = (p.x-center.x) * (p.x-center.x);
        double b = (p.y-center.y) * (p.y-center.y);
        double cp = 22 * 22;
        if(a + b < cp ){
        	return true;
        }
        return false;
	}
}
