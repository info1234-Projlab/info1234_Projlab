package classes;

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
		for (CanMove cm : field.GetCreatures()) {
			cm.GetCanMoveView().Draw(coordinates, g);
			cm.GetCanMoveView().DrawInformation(coordinates);
		}
		if (field.GetShelter() != null) {
			field.GetShelter().GetShelterView().Draw(coordinates, g);
		}
	}
}
