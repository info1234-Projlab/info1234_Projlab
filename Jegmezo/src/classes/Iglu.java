package classes;

public class Iglu implements Shelter{

private String name;
	
public Iglu(String name){
	this.name = name;
}
	
public boolean DefendFromBear() {
	return true;
}

public void DestroyTent(int num) {
	return;
}

@Override
public String GetName() {
	return name;
}

}
