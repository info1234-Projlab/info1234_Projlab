package classes;
/**
 * A sátor típusú menedék kezeléséért felelős. Ha egy mezőn van sátor az csak a
hóvihar ellen nyújt védelmet a medve ellen nem. Alatta lehet ásni és és a mezőn lévő
tárgyakon sem nől a hóréteg ha sátor van felettük.
 *
 */
public class ShelterTent implements Shelter {

private int round;
private Field field;
/**
 * 
 * @param f : erre a mezőre rakjuk le a fieldet
 */
public ShelterTent(Field f) {
	this.field = f;
}
/**
 * Mivel sátor, ezért nem jelent védelmet a medve ellen. 
 */
public boolean DefendFromBear() {
	return false;
}
/**
 * megszünteti a sátrat a mezőkön (amik már egy kör
óta fel vannak állítva) kiveszi magát a saját mezője tárolójából.
 */
public void DestroyTent(int num) {
	if(round+1==num)
		field.RemoveShelter();
}
}
