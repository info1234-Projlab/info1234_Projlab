package classes;

public class ShelterTent implements Shelter {

private int round;
private Field field;
private String name;

public ShelterTent(Field f) {
	this.field = f;
}

public boolean DefendFromBear() {
	return false;
}

public void DestroyTent(int num) {
	if(round+1==num)
		field.RemoveShelter();
}

@Override
public String GetName() {
	return name;
}

}
