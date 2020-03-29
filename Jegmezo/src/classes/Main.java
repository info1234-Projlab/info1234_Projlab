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

public static void AddItemToField() {
	System.out.printf("Add meg, hany reteg h� legyen a mez�n\n");
	Scanner in = new Scanner(System.in);
	int layer=in.nextInt();
	Field f=new Field(1,layer);
	Explorer e=new Explorer(f); 
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