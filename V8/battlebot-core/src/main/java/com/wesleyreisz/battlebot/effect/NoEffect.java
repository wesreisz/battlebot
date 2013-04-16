package com.wesleyreisz.battlebot.effect;

import com.wesleyreisz.battlebot.PlayerCharacter;
import com.wesleyreisz.battlebot.weapon.IWeapon;

public class NoEffect implements IEffect {
	private IWeapon weapon;
	
	public  NoEffect(IWeapon weapon){
		this.weapon=weapon;
	}
	@Override
	public int attack(PlayerCharacter c) {
		return weapon.attack(c);
	}

	@Override
	public int damage(PlayerCharacter c) {
		return weapon.damage(c);
	}
	@Override
	public String getDescription() {
		return weapon.getDescription() ;
	}
}