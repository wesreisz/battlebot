package com.wesleyreisz.battlebot.effect;

import com.wesleyreisz.battlebot.Dice;
import com.wesleyreisz.battlebot.PlayerCharacter;
import com.wesleyreisz.battlebot.utils.DiceUtil;
import com.wesleyreisz.battlebot.utils.StringUtils;
import com.wesleyreisz.battlebot.weapon.IWeapon;

public class Acid implements IEffect {
	private IWeapon weapon;
	private Dice effectDamageDice = Dice.D6;
	private static final String DESCRIPTION = "blisters with Acid";
	
	public  Acid(IWeapon weapon){
		this.weapon=weapon;
	}
	@Override
	public int attack(PlayerCharacter c) {
		return weapon.attack(c);
	}

	@Override
	public int damage(PlayerCharacter c) {
		return weapon.damage(c) + DiceUtil.rollDice(effectDamageDice);
	}
	@Override
	public String getDescription() {
		return weapon.getDescription() + StringUtils.addSeparator() + Acid.DESCRIPTION;
	}
}
