package classes;
/**
 * Ez az interfész egységbe foglalja a menedék tárgyak vizsgálandó tulajdonságait.
 *
 */
public interface Shelter {

	/**
	 * A menedékeket vizsgálatáért felelős, hogy
védelmet nyújtanak-e a jegesmacitól.
	 * 
	 */
	public boolean DefendFromBear();
	/**
	 * Egy kör után a ShelterTent megszüntetésére szolgál.
Iglu esetében nem történik semmi.
	 */
	public void DestroyTent(int num);

}
