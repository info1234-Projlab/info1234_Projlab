package classes;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class FieldView {
	protected Point coordinates;
	protected Image img;
	protected boolean isSelected;
	
	private Field field;
	
	public FieldView(Field _field) {
		field = _field;
		try {
			img = ImageIO.read(new File("IceField_2.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void SetCoordinates(Point p) {
		coordinates = p;
		
	}
	
	public Point GetCoordinates() {
		return coordinates;
	}
	
	public void Draw(Graphics g) {
		g.drawImage(img, coordinates.x, coordinates.y, null);
		int shift = 0;
		int numberOfCreatures = field.GetCreatures().size();
		if (field.GetShelter() != null) {
			field.GetShelter().GetShelterView().Draw(coordinates, g);
		}
		g.setFont(new Font("TimesRoman", Font.BOLD, 16));
		g.setColor(Color.BLACK);
		if (field.GetVisibleCapacity()) {
			g.drawString(Integer.toString(field.GetCapacity()), coordinates.x + 2, coordinates.y + 15);
		}
		g.setFont(new Font("TimesRoman", Font.PLAIN|Font.ITALIC, 16));
		g.setColor(Color.BLACK);
		g.drawString(Integer.toString(field.GetLayer()), coordinates.x + 37, coordinates.y + 15);
		for (CanMove cm : field.GetCreatures()) {
			cm.GetCanMoveView().Draw(new Point(coordinates.x + shift, coordinates.y), g,(double) 1 / numberOfCreatures);
			cm.GetCanMoveView().DrawInformation(coordinates);
			shift += 50 / numberOfCreatures;
		}
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
	
	public Field GetField() {
		return field;
	}
}
