package classes;


/**
 * Az osztály felelőssége a sarkkutató hős menedzselése. Ide tartozik az összes
tevékenység (ásás, tárgy felvétele stb…), beleértve a különleges képességét is, amit
egy sarkkutató a játék során végezhet.
Ezen kívül, ez az osztály felügyeli a sarkkutató testhőjét, figyeli, hogy maximum csak
4 munkát végezhessen egy körön belül, valamint tárolja, hogy éppen melyik
jégmezőn tartózkodik, illetve az elérhető maximális testő értékét (4).
 * 
 *
 */


public class Explorer extends Player {
	private ExplorerView view;
	public Explorer() {
		super(4);
		view = new ExplorerView();
		
	}
	
	/**
	 * A kutato UseAbility fuggvenye egy megnezi, hogy az adott mezo kapacitasa mekkora. Ez egy munkaba kerul.
	 * @param tab	Az indentalast jelzi.
	 */
	@Override
	public void UseAbility(Field f) {
		System.out.println("explorer useability");
		int a = this.GetNumOfAction();
		if(a > 0 && (this.field.isNeighour(f) || this.field == f)) {
			f.SetVisibleCapacity(true);
			this.DecreaseAction();
		}
		if (numberOfAction == 0) {
			Game.NextPlayer();
		}
	}
	
	@Override
	public CanMoveView GetCanMoveView() {
		return view;
	}
	
}

