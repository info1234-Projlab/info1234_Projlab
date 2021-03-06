package classes;





public interface Inventory {
	public boolean Eat(Player p);
	
	public boolean Dig(CanMove canMove);
	
	public boolean Pull(Field  f, Field to);
	
	public boolean PutOn(Player p);
	
	public boolean Shoot(Player p);
	
	public boolean Swim(Player p);
	
	public void Drop(CanMove p);
	
	public void DecreaseLayer(int i);
	
	public void PickUp(CanMove p);
	
	public int GetLayer();
	
	public void SetLayer(int num);
	
	public void SetVisible(boolean b);
	
	public boolean GetVisible();
	
	public ItemView getView();
	
	public boolean PutOnField(Player p);
}
