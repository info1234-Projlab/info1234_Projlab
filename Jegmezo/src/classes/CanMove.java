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
}
