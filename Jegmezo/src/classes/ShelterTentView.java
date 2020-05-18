package classes;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * 
 *A Sheltertent osztaly grafikus valtozata
 *
 */
public class ShelterTentView extends ShelterView{
	public ShelterTentView(){
		try {
			img = ImageIO.read(new File("tent.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
