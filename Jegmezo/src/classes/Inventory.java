package classes;





public interface Inventory {
	public boolean Eat(Player p);
	
	public boolean Dig(Player p);
	
	public boolean Pull(Player p, Field to, int tab);
	
	public boolean PutOn(Player p);
	
	public boolean Shoot(Player p, int tab);
	
	public boolean Swim(Player p);
	
	public void Drop(Player p, int tab);
	
	public void DecreaseLayer(int i, int tab);
	
	public void PickUp(Player p,int tab);
	
	public int GetLayer();
	
	public void SetLayer(int num);
	
	public void SetVisible(boolean b);
	
	public boolean GetVisible(int tab);
}
