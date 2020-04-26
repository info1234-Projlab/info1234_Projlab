package classes;

import java.util.ArrayList;

public class PolarBear implements CanMove {
	
	private Field field;
	private String name; 
	
	public PolarBear() {
		
		
	}

	@Override
	public void Move(Field f) {
		if(this.field.isNeighour(f)){
			this.field.RemoveCreature(this);
			f.AddCreature(this);
			for (CanMove cm : f.GetCreatures()) {
				cm.SetHp(0);
			}
		}
		
	}


	public void StepOn(CanMove cm) {
		cm.SetHp(0);
		
	}
	
	public boolean IsDead() {
		return false;
	}


	public void DecreaseHp() {
		return;
		
	}

	@Override
	public void StartTurn(int numOfAction) {
		// TODO Auto-generated method stub
		
	}

	public void SetHp(int num) {
		return;
		
	}
	
	public void Die() {
		
	}
	
	public void SwimPlayer() {
		
	}


	@Override
	public void PullPlayer(CanMove p) {
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

	@Override
	public int GetMaxHP() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setField(Field f) {
		this.field=f;	
	}

	@Override
	public void DigPlayer(int layers) {
		// TODO Auto-generated method stub
		
	}


}
