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
		view = new TentView("tent.png");
	}
	
	/**
	 A sátor használata azt foglalja magába,
hogy a játékos leteheti a mezőre ahol éppen áll. A felállításával védelmet nyújt
a hóvihar ellen, de a jegesmedve támadással szemben nem.(A Többi item
esetében false-al tér vissza). Ha felépítettük a sátrat akkor kivesszük a player
items tárolójából. Majd létrehozunk egy ShelterTent (menedéksátor objektum
példányt) és azt beletesszük annak a mezőnek a shelter tárolójába ahol
éppen a játékos áll, természetesen akkor, ha a shelter tároló üres. Tehát nincs
rajta sem sátor sem iglu.
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
