package classes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Main{
	public static void main(String args[]) {
		Menu();
	}

	
	/**
	 * Egy lepes tesztelesere letrehozott fuggveny.
	 */
public static void MoveToAnotherField(){
	
	System.out.println("Stabil mez�re, vagy lukra lepjen az eszkimo? 1: Stabil, 0: Hole.");
	Scanner in = new Scanner(System.in);
	int answer = in.nextInt();
	if( answer == 1){
		StableField toSfield = new StableField(1,0,1);
		StableField fromField = new StableField(1,0,2);
		
		Eskimo eskimo = new Eskimo(fromField,3);
		eskimo.Move(toSfield,4);
		
		
	}else{
		if(answer == 0){
			Hole hole = new Hole(1);
			StableField fromField = new StableField(1,0,1);
			
			Eskimo eskimo = new Eskimo(fromField,1);
			eskimo.Move(hole,1);
			
			if(eskimo.GetHP(1) == 0){
				System.out.println("Az eszkimo a vizbe fulladt!");
			}else{
				System.out.println("A mentes sikeres");
			}
		}else{
			System.out.println("Ervenytelen valaszt adtal meg");
		}
	}
	System.out.println("A Scenario veget ert");
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

/**
 * A Field AddItem f�ggv�ny�hez tartoz� forgat�k�nyv
 */
public static void AddItemToField() {
	Field f=new Field(1,0,0);
	Explorer e=new Explorer(f,0);
	Food food=new Food(0,true,0);
	Game.SetCurrentPlayer(e, 0);
	DivingSuit dsuit=new DivingSuit(0,true,0);
	System.out.printf("A targy amit eldobsz, buvarruha legyen (1) vagy egyeb (2)?\n");
	Scanner in2 = new Scanner(System.in);
	int itemkind=in2.nextInt();
	if (itemkind==2) {

		Food todropitem=new Food(0,true, 0);
		f.AddItem(todropitem,0);
		todropitem.Drop(e,0);

		f.AddItem(food,0);
	}
	if (itemkind==1) {
		f.AddItem(dsuit,0);
		}
}

/**
 * A Field RemoveItem f�ggv�ny�hez tartoz� forgat�k�nyv
 */
public static void RemoveItemFromField() {
	Field f=new Field(1,0,0);
	Explorer e=new Explorer(f,0);
		f.RemoveItem(e,0);	

}


/**
 * A Board Storm f�ggv�ny�hez tartoz� forgat�k�nyv
 */
public static void StormOnBoard() {
	Field f=new Field(1,0,0);
	Explorer e=new Explorer(f,0);
	ArrayList<Field> fields=new ArrayList<>();
	fields.add(f);
	Board board=new Board(fields,0);
	board.Storm(0);
}

/**
 * Using a Rope forgatokonyv
 */

public static void UsingRope() {
	StableField to = new StableField(10, 2, 0);
	Hole from = new Hole(0);
	Eskimo rescuer = new Eskimo(to, 0);
	Explorer inDanger = new Explorer(from, 0);
	Rope r = new Rope(2, true, 0);
	r.Pull(inDanger, to);
}

/**
 * Buvarruha felvetele forgatokonyv
 */

public static void PuttingOnDivingSuit() {
	UnstableField field = new UnstableField(4, 2, 0);
	Eskimo player = new Eskimo(field, 0);
	DivingSuit suit = new DivingSuit(2, true, 0);
	suit.PutOn(player, 0);
}

/**
 * Uszas forgatokonyv
 */

public static void Swimming() {
	UnstableField field = new UnstableField(4, 2, 0);
	Explorer player = new Explorer(field, 0);
	DivingSuit suit = new DivingSuit(2, true, 0);
	suit.Swim(player, 0);
}

public static void Eat() {
	Field f = new Field(3, 0, 0);
	Eskimo e = new Eskimo(f, 0);
	Food food = new Food(0, true, 0);
	food.Eat(e,  0);
}

public static void Shovel() {
	Field f = new Field(3, 0, 0);
	Eskimo e = new Eskimo(f, 0);
	Shovel shovel = new Shovel(0, true, 0);
	shovel.Dig(e, 0);
}

public static void Shoot() {
	Field f = new Field(3, 0, 0);
	Eskimo e = new Eskimo(f, 0);
	Flare flare = new Flare(0, true, 0);
	e.AddItem(flare, 0);
	e.AddItem(new Gun(0, true, 0), 0);
	e.AddItem(new Cartridge(0, true, 0), 0);
	flare.Shoot(e, 0);
}

public static void Menu() {
	while (true) {
		System.out.printf("Valasszon a kovetkezo forgatokonyvek kozul: \n");
		System.out.printf("1: MoveToAnotherField \n 2: UseAbilityEskimo \n 3: UseAbilityExplorer\n 4:AddItemToField \n 5:RemoveItemFromField \n 6:StormOnBoard \n 7:UsingRope \n 8:PuttingOnDivingSuit \n 9:Swimming \n 10:Eat \n 11:Shovel \n 12:Shoot \n");  
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		switch(n) {
		case 1:
			MoveToAnotherField();
			break;
		case 2:
			UseAbilityEskimo();
			break;
		case 3:
			UseAbilityExplorer();
			break;
		case 4:
			AddItemToField();
			break;
		case 5:
			RemoveItemFromField();
			break;
		case 6:
			StormOnBoard();
			break;
		case 7:
			UsingRope();
			break;
		case 8:
			PuttingOnDivingSuit();
			break;
		case 9:
			Swimming();
			break;
		case 10:
			Eat();
			break;
		case 11: 
			Shovel();
			break;
		case 12:
			Shoot();
			break;
		default:
			System.out.printf("Valasszon a megadott lehetosegek alapjan! \n");
		
		}
		System.out.printf("Nyomj meg egy gombot a menübe való visszatéréshez \n");
		try {
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

}