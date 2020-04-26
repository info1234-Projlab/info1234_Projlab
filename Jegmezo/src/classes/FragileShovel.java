package classes;

public class FragileShovel extends Item{
	
	private int lifetime;

	public FragileShovel(int layer, boolean visible) {
		super(layer, visible);
	}
	
	public boolean Dig(CanMove p) {
			System.out.println("fragiledig");
			if (p.GetNumOfAction() <= 0)
				return false;
			p.SetNumOfAction(p.GetNumOfAction() - 1);
			p.DigPlayer(2);
			this.DeceaseLifeTime();
			if(this.lifetime==0)
				p.RemoveItem(this);
			return true;
	}
		
	public void DeceaseLifeTime() {
		lifetime--;
	}

}
