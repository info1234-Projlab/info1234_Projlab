package classes;

import java.util.ArrayList;

/**
 * Mivel az uj szereplonk, a jegesmedve is egy mozgo szeplo azonban
 *  nem ugyan olyan tulajdonsaggal rendelkezik mint a tobbi karakter,
 *   hiszen csak move fuggvenye van. Ezert a kozos tulajdonsagaikat 
 *   ezzel az interfesszel foglaljuk ossze, de igy nem kell a 
 *   jegesmedvet karakternek tekintenunk, mint egy eszkimot vagy egy
 *    sakkutatot.
 *
 */

public interface CanMove {
	
	public void Move(Field f);
	public void StepOn(CanMove cm);
	public void DecreaseHp();
	public boolean StartTurn();
	public void SetHp(int num);
	public boolean IsDead();
	public boolean SwimPlayer();
	public void PullPlayer(Field from);
	public void UseAbility();
	public void RemoveItem(Inventory i);
	public void AddItem(Inventory i);
	public Field GetField();
	public void FireGun();
	public void PutOnDivingSuit();
	public void Eat();
	public void SetNumOfAction(int num);
	public boolean Win();
	public boolean GetWin();
	public ArrayList<Inventory> GetItems();
	public int GetHP();
	public int GetNumOfAction();
	public int GetMaxHP();
	public void setField(Field f);
	public void DigPlayer(int layers);
	public CanMoveView GetCanMoveView();

}
