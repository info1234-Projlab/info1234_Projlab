package classes;
import java.util.Scanner;

public class Main{
	public static void main(String args[]) {
		UseAbilityEskimo();
		
	}

/**
 * Az eszkimo UseAbility fuggvenyenek tesztelesere, fuggvenyek futasi sorrendjenek ellenorzesere letrehozott fuggveny.
 */
public static void UseAbilityEskimo() {
	Field f = new Field(3, 3, 0);
	Eskimo e = new Eskimo(f,0);
	System.out.printf("Add meg, hány akciója van még hátra a játékosnak (0-4), van-e iglu már a mezőn (0-1). \n");
	Scanner in = new Scanner(System.in);
	int actions = in.nextInt();
	int b = in.nextInt();
	boolean bool;
	if(b ==0) {bool = false;}	
		else	{bool=true;}
	e.SetNumOfAction(actions,0);
	f.SetHasIglu(bool,0);
	e.UseAbility(0);
	
}

/**
 * A kutato UseAbility fuggvenyenek tesztelesere, fuggvenyek futasi sorrendjenek ellenorzesere letrehozott fuggveny.
 */
public static void UseAbilityExplorer() {
	
	System.out.printf("Add meg, hány akciója van még hátra a játékosnak (0-4), mekkora legyen a mező kapacitása. \n");
	Scanner in = new Scanner(System.in);
	int actions = in.nextInt();
	int cap = in.nextInt();
	Field f = new Field(cap, 3, 0);	
	Explorer e = new Explorer(f,0);
	e.SetNumOfAction(actions,0);
	e.UseAbility(0);	
	
}





}