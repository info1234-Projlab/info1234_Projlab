package classes;

public class Tent extends Item {

	public Tent(int layer, boolean visible) {
		super(layer, visible);
	}
	
	public boolean PutOnField(Player p) {
		if(p.GetNumOfAction()<=0)
			return false;
		ShelterTent tent=new ShelterTent(p.GetField());
		p.GetField().AddShelter(tent);
		p.SetNumOfAction(p.GetNumOfAction()-1);
		p.RemoveItem(this);
	}

}
