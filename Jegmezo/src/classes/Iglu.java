package classes;

public class Iglu implements Shelter{
	private IgluView view;
	/**
	 * Visszaadja, hogy a jelenlegi menedék véd-e a jegesmedve ellen, ez mindig igaz lesz, mert igluról van szó.
	 */
	public boolean DefendFromBear() {
		return true;
	}
	
	/**
	 * A ShelterTentben van jelentősége a függvénynek;
	 */
	public void DestroyTent(int num) {
		return;
	}

	@Override
	public ShelterView GetShelterView() {
		return view;
	}
}
