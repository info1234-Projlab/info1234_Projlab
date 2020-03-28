package classes;

public class Main {

}

public void UseAbilityEskimo() {
	Field f = new Field(3, 3);
	Eskimo e = new Eskimo(f);
	if(e.GetNumOfAction() > 0 ) {
		if(f.CanBuildIglu()) {
		f.SetHasIglu(true);
		e.DecreaseAction();
		}	
	}
}