package structural;

import java.util.EnumMap;
import java.util.Map;

// Structural | Performance

//Real world Example (https://java-design-patterns.com/patterns/flyweight/)
/* Alchemist's shop has shelves full of magic potions(Liquid with healing properties). 
 * Many of the potions are the same so there is no need to create new object for each of them. 
 * Instead one object instance can represent multiple shelf items so memory footprint remains small.
 */
public class FlyWeight {
	public static void main(String[] s) {
		PotionFactory factory = new PotionFactory();
		factory.createPotion(PotionType.INVISIBILITY).drink();
		factory.createPotion(PotionType.HEALING).drink();
		factory.createPotion(PotionType.INVISIBILITY).drink();
	}
}

interface Potion {
	void drink();
}

class HealingPotion implements Potion {
	@Override
	public void drink() {
		System.out.println("You feel HEALED");
	}
}

class HolyWaterPotion implements Potion {
	@Override
	public void drink() {
		System.out.println("You feel BLESSED");
	}
}

class InvisibilityPotion implements Potion {
	@Override
	public void drink() {
		System.out.println("You feel INVISIBLE");
	}
}

class PotionFactory {

	private final  Map<PotionType, Potion> potions = new EnumMap<>(PotionType.class); //IMP: to store

	Potion createPotion(PotionType type) {

		Potion potion = potions.get(type);//Check in store first.
		
		if (potion == null) {
			switch (type) {
			case HEALING:
				potion = new HealingPotion();
				potions.put(type, potion);
				break;
			case HOLY_WATER:
				potion = new HolyWaterPotion();
				potions.put(type, potion);
				break;
			case INVISIBILITY:
				potion = new InvisibilityPotion();
				potions.put(type, potion);
				break;
			default:
				break;
			}
		}
		return potion;
	}
}

enum PotionType {
	HEALING, HOLY_WATER, INVISIBILITY
}


/*
 * A FlyWeight is an object that minimizes memory.
 * When we need a large number of similar objects that are unique in terms of only a few parameters and most of the stuffs are common in general.
 * We need to control the memory consumption by large number of objects – by creating fewer objects and sharing them across.
 * 
 * Example:
 * 
 * 1> **** java.lang.String ******* 2> Connection Pool
 * All strings are stored in string pool and if we need a string with certain content then runtime return the reference to already existing 
 * string constant from the pool – if available.
 * 
 * 
 * Best Example is Cache.
 * 
 * When we need some data 
 * 1- Check in Cache, if available use that.
 * 2- Else get it from DS, Cache it, use that. 
 * 
 */