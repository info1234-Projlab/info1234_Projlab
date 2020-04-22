package classes;

public class ShelterTent implements Shelter {

private int round;
private Field field;

public boolean DefendFromBear() {
	return false;
}

public void DestroyTent(int num) {
	if(round+1==num)
		field.RemoveShelter();
}

}
