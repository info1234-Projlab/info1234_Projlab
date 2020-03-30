package classes;



/**
 * Az osztály felelőssége az eszkimó hős menedzselése. Ide tartozik az összes
tevékenység (ásás, tárgy felvétele stb…), beleértve a különleges képességét
(igluépítés) is, amit egy eszkimó a játék során végezhet.
Ezen kívül, ez az osztály felügyeli az eszkimó testhőjét, figyeli, hogy maximum csak
4 munkát végezhessen egy körön belül, valamint tárolja, hogy éppen melyik
jégmezőn tartózkodik, illetve az elérhető maximális testő értékét (5).
 *
 */


public class Eskimo extends Player {
	/**
	 * 
	 * @param field	Ahova az eszkimót ledobjuk a pályán. 
	 * @param tab	Indentálást jelzi. 
	 */
	public Eskimo(Field field, int tab) {
		super(5, field,tab+1);
		for(int i=0; i<tab; i++)
			System.out.print("\t");
		System.out.println("Az Eskimo osztaly konstruktora hivodott meg.");
	}
	
	/**
	 * Az eszkimo UseAbility fuggvenye egy iglut epit a mezore, amennyiben azon meg nincsen. Ez egy munkaba kerul.
	 * @param tab	Az indentalast jelzi.
	 */
	public void UseAbility(int tab) {
		for(int i=0; i<tab; i++)
			System.out.print("\t");
		System.out.println("Az Eskimo osztaly UseAbility() fuggvenye hivodott meg.");
		int a = this.GetNumOfAction(tab+1);
		if(a == 0 ) { System.out.printf("Nem tud akciot vegrehajtani! \n");}
		if(a > 0 ) {
			if(this.GetField(tab+1).CanBuildIglu(tab+1)) {
			this.GetField(tab+1).SetHasIglu(true,tab+1);
			this.DecreaseAction(tab+1);
			}	
		}
	}
}
