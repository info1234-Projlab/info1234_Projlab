package classes;

public class ShelterTent implements Shelter {

private int round;
private Field field;
private String name;

public ShelterTent(Field f, String s ) {
	this.field = f;
	this.name = s;
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
