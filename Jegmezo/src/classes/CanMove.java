package classes;

import java.util.ArrayList;

public interface CanMove {
	
	public void Move(Field f);
	public void StepOn(CanMove cm);
	public void DecreaseHp();
	public void StartTurn(int numOfAction);
	public void SetHp(int num);
	public boolean IsDead();
	public void SwimPlayer();
	public void PullPlayer(CanMove p);
	public void UseAbility();
	public void RemoveItem(Inventory i);
	public void AddItem(Inventory i);
	public Field GetField();
	public void FireGun();
	public void PutOnDivingSuit();
	public void Eat();
	public void SetNumOfAction(int num);
//	public String List();
	public boolean Win();
//	public String GetName();
	public boolean GetWin();
	public ArrayList<Inventory> GetItems();
	public int GetHP();
	public int GetNumOfAction();
	public int GetMaxHP();
	public void setField(Field f);
	public void DigPlayer(int layers);

}
