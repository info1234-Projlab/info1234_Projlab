package classes;

import java.util.ArrayList;
import java.util.Random;

/**
 * Ugyan olyan szereplő mint a player azonban a jegesmedve véletlen 
 * szerűen mozog a pályán, körönként egyet lép. Ha egy mezőn tartózkodik 
 * egy játékossal akkor akkor elkapja és vége a játéknak. Az iglu megvédi 
 * ellene a játékosokat, de a sátorba be tud sétálni.  A jegesmedve bárhova 
 * léphet (bármilyen mezőfajtára), nem jelent többlet súlyt ha rálép egy mezőre. 
 *
 */

public class PolarBear implements CanMove {
	private PolarBearView view;
	private Field field;
	
	public PolarBear() {	
		view = new PolarBearView();
	}

	/**
	 * A jegesmedve mozgásáért felelős egyik mezőről a másikra lépés 
	 * során. A maci bármilyen mezőre léphet, úszni is tud. Illetve 
	 * a mackó nem jelent többlet súlyt egy mezőn, így miatta nem borulhat fel egy mező.

	 */
	@Override
	public void Move(Field f) {
		System.out.println("jeges");
		System.out.println(Game.GetCurrentPlayer().toString());
		if(this.field.isNeighour(f)){
			this.field.RemoveCreature(this);
			f.AddCreature(this);
			for (CanMove cm : f.GetCreatures()) {
				if(cm.GetField().GetShelter() != null) {
					if (!cm.GetField().GetShelter().DefendFromBear())
						cm.SetHp(0);
				}
				else
					cm.SetHp(0);
					
			}
		}
		
	}

/**
 * true-val ter vissza jegesmacira lepes eseteben
 */
	public void StepOn(CanMove cm) {
		System.out.println("jeges");
		if(cm.GetField().hasShelter()) {
			if(!cm.GetField().GetShelter().DefendFromBear())
				cm.SetHp(0);
		}
		else
			cm.SetHp(0);
	}
	
	public boolean IsDead() {
		return false;
	}


	public void DecreaseHp() {
		return;
		
	}

	@Override
	public boolean StartTurn() {
		ArrayList<Field> neighbours = field.GetNeighbouringFields();
		Random rand = new Random();
		int indexOfRandNeighbour = rand.nextInt(neighbours.size());
		Move(neighbours.get(indexOfRandNeighbour));
		return false;
		
	}

	public void SetHp(int num) {
		return;
		
	}
	
	public boolean SwimPlayer() {
		return false;
	}


	@Override
	public void PullPlayer(Field from) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void UseAbility() {
		// TODO Auto-generated method stub
		
	}
	

	public void RemoveItem(Inventory i) {
		
	}
	
	public void AddItem(Inventory i) {
		
	}
	
	public Field GetField() {
		return field;
	}
	
	public void FireGun() {
		
	}
	
	public void PutOnDivingSuit() {
		
	}
	
	public void Eat() {
		
	}
	
	public void SetNumOfAction(int num) {
		
	}
	
	public boolean Win() {
		return false;
	}


	@Override
	public boolean GetWin() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Inventory> GetItems() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int GetHP() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int GetNumOfAction() {
		// TODO Auto-generated method stub
		return 0;
	}

/**
 * A mackonak nem foglalkozunk az eletevel, nullara allitjuk
 */
	public int GetMaxHP() {
		// TODO Auto-generated method stub
		return 0;
	}

/**
 *Beallitja a maci mezojet a kapott mezore
 * 
 */
	public void setField(Field f) {
		this.field=f;	
	}

	@Override
	public void DigPlayer(int layers) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CanMoveView GetCanMoveView() {
		return view;
	}


}
