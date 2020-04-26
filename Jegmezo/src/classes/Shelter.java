package classes;

public interface Shelter {
	/**
	 * Visszaadja, hogy a jelenlegi menedék véd-e a jegesmedve ellen.
	 */
	public boolean DefendFromBear();
	/**
	 * Megsemmisíti a menedéket, ha az egy sátor.
	 * @param num a kör száma
	 */
	public void DestroyTent(int num);

}
