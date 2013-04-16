package com.wesleyreisz.battlebot.weapon;

import com.wesleyreisz.battlebot.Dice;
import com.wesleyreisz.battlebot.PlayerCharacter;
import com.wesleyreisz.battlebot.utils.DiceUtil;
import com.wesleyreisz.battlebot.utils.StringUtils;

public class Axe implements IWeapon {
	private Dice baseDamageDice = Dice.D10;
	private static final String DESCRIPTION = "Crushes with his Axe";
	
	@Override
	public int attack(PlayerCharacter c){
		return DiceUtil.rollDice(Dice.D20);
	}
	@Override
	public int damage(PlayerCharacter c){
		return DiceUtil.rollDice(baseDamageDice) + c.getStrengthDamageModifer();
	}
	@Override
	public String getDescription(){
		return DESCRIPTION;
	}
}
