package classes;

public class Main{

	
	public static void main(String args[]) {
		myFrame jF = new myFrame();
		
		MenuPanel mP= new MenuPanel();
	
		jF.add(mP);
		jF.pack();
	}
}