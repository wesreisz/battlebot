package com.wesleyreisz.battlebot.weapon;

import com.wesleyreisz.battlebot.PlayerCharacter;

public interface IWeapon {
	public int attack(PlayerCharacter c);
	public int damage(PlayerCharacter c);
	public String getDescription();
}