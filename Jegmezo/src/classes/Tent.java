package classes;
/**
 * 
 * A sator targy birtoklasanak es elvesztesenek kovetkezmenyeinek kezelese. Fel lehet
venni a mezorol ha kiastuk a ho alol es le is lehet tenni egy mezore ahol
menedekkent hasznalhato. Ved a hovihar ellen azonban a jegesmedve tamadas
ellen nem hasznal. Ebben az esetben a sator eszkozkent viselkedik. Fel lehet venni,
el lehet dobni es hasznalni lehet. 
 * 
 */
public class Tent extends Item {

	public Tent(int layer, boolean visible) {
		super(layer, visible);
	}
	
	/**
	 * 
	 * @param p
	 * @return
	 */
	public boolean PutOnField(Player p) {
		if(p.GetNumOfAction()<=0)
			return false;
		ShelterTent tent=new ShelterTent(p.GetField());
		p.GetField().AddShelter(tent);
		p.SetNumOfAction(p.GetNumOfAction()-1);
		p.RemoveItem(this);
		return true;
	}

}
