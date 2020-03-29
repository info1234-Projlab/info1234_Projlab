package classes;

import java.util.ArrayList;
import java.util.Scanner;


public class Main{
	public static void main(String args[]) {
		StepOnHoleButNoHelp();
	}

/**
 * Az eszkimo UseAbility fuggvenyenek tesztelesere, fuggvenyek futasi sorrendjenek ellenorzesere letrehozott fuggveny.
 */
public static void UseAbilityEskimo() {
	Field f = new Field(3, 3, 0);
	Eskimo e = new Eskimo(f,0);
	System.out.printf("Add meg, hÃ¡ny akciÃ³ja van mÃ©g hÃ¡tra a jÃ¡tÃ©kosnak (0-4), van-e iglu mÃ¡r a mezÅ‘n (0-1). \n");
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
	
	System.out.printf("Add meg, hÃ¡ny akciÃ³ja van mÃ©g hÃ¡tra a jÃ¡tÃ©kosnak (0-4), mekkora legyen a mezÅ‘ kapacitÃ¡sa. \n");
	Scanner in = new Scanner(System.in);
	int actions = in.nextInt();
	int cap = in.nextInt();
	Field f = new Field(cap, 3, 0);	
	Explorer e = new Explorer(f,0);
	e.SetNumOfAction(actions,0);
	e.UseAbility(0);	
	
}

/**
 * A Field AddItem függvényéhez tartozó forgatókönyv
 */
public static void AddItemToField() {
	Field f=new Field(1,0,1);
	Explorer e=new Explorer(f,1);
	Food food=new Food(0,true,1);
	DivingSuit dsuit=new DivingSuit(0,true,1);
	System.out.printf("A targy amit eldobsz, buvarruha legyen (1) vagy egyeb (2)?\n");
	Scanner in2 = new Scanner(System.in);
	int itemkind=in2.nextInt();
	if (itemkind==2) {
		f.AddItem(food,1);
	}
	if (itemkind==1) {
		
		f.AddItem(dsuit,1);
		}
}

/**
 * A Field RemoveItem függvényéhez tartozó forgatókönyv
 */
public static void RemoveItemFromFiled() {
	Field f=new Field(1,0,1);
	Explorer e=new Explorer(f,1);
		f.RemoveItem(e,1);	
}


public static void FieldNotNeighbour(){
	
	System.out.println("Egy nem szomszedos mezore lepesi kiserlet:");
	
	Field toField = new Field(1,0,1);
	Field fromField = new Field(1,0,2);
	
	Explorer explorer = new Explorer(fromField,3);
	explorer.Move(toField,4);
	
	System.out.println("Nem szomszedos a celmezo!");
}

public static void StepToNeighbourField(){
	
	System.out.println("Explorer a szomszedos mezore lep:");
	
	Field toField = new Field(1,0,1);
	Field fromField = new Field(1,0,2);
	
	Explorer explorer = new Explorer(fromField,3);
	explorer.Move(toField,4);
	
	toField.AddPlayer(explorer, 6);
	fromField.RemovePlayer(explorer,7);
	toField.IsFall(8);
	
	System.out.println("Explorer atlepett a szomszedos mezore!");
	
}

public static void StepOnHoleButNoHelp(){
	System.out.println("Eskimo egy lukba lep:");
	
	Field toField = new Field(1,0,1);
	Field fromField = new Field(1,0,2);
	
	Eskimo eskimo = new Eskimo(fromField,3);
	eskimo.Move(toField,4);
	
	toField.AddPlayer(eskimo, 6);
	fromField.RemovePlayer(eskimo,7);
	toField.IsFall(8);
	
	toField.Fall(9);
	eskimo.SetHp(0,11);
	
	System.out.println("Eskimo belefulladt a vizbe");
}

/**
 * A Board Storm függvényéhez tartozó forgatókönyv
 */
public static void StormOnBoard() {
	Field f=new Field(1,0,1);
	Explorer e=new Explorer(f,1);
	ArrayList<Field> fields=new ArrayList<>();
	fields.add(f);
	Board board=new Board(fields,1);
	board.Storm(1);
}

/**
 * Using a Rope forgatokonyv
 */

public static void UsingRope() {
	StableField to = new StableField(10, 2, 1);
	Hole from = new Hole(1);
	Eskimo rescuer = new Eskimo(to, 1);
	Explorer inDanger = new Explorer(from, 1);
	Rope r = new Rope(2, true, 1);
	r.Pull(inDanger, to);
}

/**
 * Buvarruha felvetele forgatokonyv
 */

public static void PuttingOnDivingSuit() {
	UnstableField field = new UnstableField(4, 2, 1);
	Eskimo player = new Eskimo(field, 1);
	DivingSuit suit = new DivingSuit(2, true, 1);
	suit.PutOn(player, 1);
}

/**
 * Uszas forgatokonyv
 */

public static void Swimming() {
	UnstableField field = new UnstableField(4, 2, 1);
	Explorer player = new Explorer(field, 1);
	DivingSuit suit = new DivingSuit(2, true, 1);
	suit.Swim(player, 1);
}


}