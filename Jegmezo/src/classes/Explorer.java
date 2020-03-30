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
	
	public Explorer(Field field,int tab) {
		super(4, field, tab+1);
		for(int i=0; i<tab; i++)
			System.out.print("\t");
		System.out.println("Az Explorer osztaly konstruktora hivodott meg.");
		
	}
	
	/**
	 * A kutato UseAbility fuggvenye egy megnezi, hogy az adott mezo kapacitasa mekkora. Ez egy munkaba kerul.
	 * @param tab	Az indentalast jelzi.
	 */
	public void UseAbility(int tab) {
		for(int i=0; i<tab; i++)
			System.out.print("\t");
		System.out.println("Az Explorer osztaly UseAbility() fuggvenye hivodott meg.");
		int a = this.GetNumOfAction(tab+1);
		if(a == 0 ) { System.out.printf("Nem tud akciót végrehajtani! \n");}
		if(a > 0 ) {
			this.GetField(tab+1).SetVisibleCapacity(true,tab+1);
			this.DecreaseAction(tab+1);
			}
	}
		
	
}

