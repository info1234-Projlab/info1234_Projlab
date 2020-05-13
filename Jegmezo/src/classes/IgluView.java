package classes;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class IgluView extends ShelterView{
	public IgluView(){
		try {
			img = ImageIO.read(new File("iglu.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
