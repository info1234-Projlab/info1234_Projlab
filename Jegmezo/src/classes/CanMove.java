package classes;

public interface CanMove {
	
	public void Move(Field f);
	public void StepOnBear();
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
	public void List();
	public boolean Win();
}
