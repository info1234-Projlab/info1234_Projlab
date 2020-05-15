package classes;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Images {
	BufferedImage explorer;
	BufferedImage eskimo;
	private Point coordinates;
	int num;
	boolean esk = false;
	boolean exp = false;
	
	public Images(Point _coordinates, int n) {
		try {
			explorer = ImageIO.read(new File("explorer.png"));
			eskimo = ImageIO.read(new File("eskimo.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		coordinates = _coordinates;
		num = n;
	}
	
	public void Draw(Graphics g, Point click) {
		Point explorerCoord = new Point(coordinates.x+eskimo.getWidth()+30, coordinates.y);
		g.drawImage(eskimo, coordinates.x, coordinates.y, null);
		g.drawImage(explorer, explorerCoord.x, explorerCoord.y, null);
		g.drawString(Integer.toString(num) + ". Játékos", coordinates.x-40, coordinates.y -5);
		boolean inside = false;
		if(click!=null) {
			if(click.x >= coordinates.x && click.x <= (coordinates.x+eskimo.getWidth()) && click.y >= coordinates.y && click.y <= (coordinates.y+eskimo.getHeight())) {
				g.drawRect(coordinates.x, coordinates.y, eskimo.getWidth(), eskimo.getHeight());
				inside = true;
				exp=false;
				esk=true;
			}
			if(click.x >= explorerCoord.x && click.x <= (explorerCoord.x+explorer.getWidth()) && click.y >= explorerCoord.y && click.y <= (explorerCoord.y+explorer.getHeight())) {
				g.drawRect(explorerCoord.x, explorerCoord.y, explorer.getWidth(), explorer.getHeight());
				inside = true;
				exp=true;
				esk=false;
			}
			if(!inside) {
				if(exp)
					g.drawRect(explorerCoord.x, explorerCoord.y, explorer.getWidth(), explorer.getHeight());
				if(esk)
					g.drawRect(coordinates.x, coordinates.y, eskimo.getWidth(), eskimo.getHeight());
			}
			
		}
	}
}
