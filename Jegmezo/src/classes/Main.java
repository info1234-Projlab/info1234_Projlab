//package classes;
import java.util.Scanner;

public class Main{
	public static void main(String args[]) {

		
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

public static void AddItemToField() {
	System.out.printf("Add meg, hany reteg h� legyen a mez�n\n");
	Scanner in = new Scanner(System.in);
	int layer=in.nextInt();
	Field f=new Field(1,layer,1);
	Explorer e=new Explorer(f,1); 
	System.out.printf("A t�rgy b�v�rruha legyen (1) vagy egy�b (2)?\n");
	Scanner in2 = new Scanner(System.in);
	int itemkind=in2.nextInt();
	if (itemkind==2) {
		Food todropitem=new Food(0,true);
		f.AddItem(todropitem,1);
		todropitem.Drop(e,1);
	}
	if (itemkind==1) {
		DivingSuit todropitem=new DivingSuit(0,true,true);
		f.AddItem(todropitem,1);
		todropitem.Drop(e,1);
		}
	
}

}