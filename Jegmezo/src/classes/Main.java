package classes;
import java.util.Scanner;

public class Main{
	public static void main(String args[]) {
		
		
	}


public static void UseAbilityEskimo() {
	Field f = new Field(3, 3);
	Eskimo e = new Eskimo(f);
	System.out.printf("Add meg, hány akciója van még hátra a játékosnak (0-4), van-e iglu már a mezőn (0-1). \n");
	Scanner in = new Scanner(System.in);
	int actions = in.nextInt();
	int b = in.nextInt();
	boolean bool;
	if(b ==0) {bool = false;}	
		else	{bool=true;}
	e.SetNumOfAction(actions);
	f.SetHasIglu(bool);
	if(e.GetNumOfAction() == 0 ) { System.out.printf("Nem tud akciót végrehajtani! \n");}
	if(e.GetNumOfAction() > 0 ) {
		if(f.CanBuildIglu()) {
		f.SetHasIglu(true);
		e.DecreaseAction();
		}	
	}
}

public static void UseAbilityExplorer() {
	
	System.out.printf("Add meg, hány akciója van még hátra a játékosnak (0-4), mekkora legyen a mező kapacitása. \n");
	Scanner in = new Scanner(System.in);
	int actions = in.nextInt();
	int cap = in.nextInt();
	Field f = new Field(cap, 3);	
	Explorer e = new Explorer(f);
	e.SetNumOfAction(actions);
	if(e.GetNumOfAction() == 0 ) { System.out.printf("Nem tud akciót végrehajtani! \n");}
	if(e.GetNumOfAction() > 0 ) {
		f.SetVisibleCapacity(true);
		e.DecreaseAction();
		}	
	
}





}