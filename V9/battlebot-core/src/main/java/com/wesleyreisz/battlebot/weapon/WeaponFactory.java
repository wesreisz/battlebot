package com.wesleyreisz.battlebot.weapon;

public class WeaponFactory {
	public static IWeapon getInstance(String weaponType){
		if ("Unarmed".equalsIgnoreCase(weaponType)){
			return new Unarmed();
		}else if("Longsword".equalsIgnoreCase(weaponType)){
			return new LongSword();
		}else if("Axe".equalsIgnoreCase(weaponType)){
			return new Axe();
		}else if("Rapier".equalsIgnoreCase(weaponType)){
			return new Rapier();
		}else{
			return new Unarmed();
		}
	}
}
