package classes;

public class Rope extends Item {
	
	public Rope(int layer,boolean visible) {
		super(layer, visible);
	}
	
	
	public boolean Pull(Player p, Field to, int tab) {
		
		for(int i=0; i<tab; i++)
			System.out.print("\t");
		System.out.println("A Rope osztaly Pull(p: Player, to: Filed):boolean fuggvenye hivodott meg.");
		Field from = p.GetField(tab+1);
		from.RemovePlayer(p, tab+1);
		to.AddPlayer(p, tab+1);
		p.SetField(to, tab+1);
		return true;
	}
}
