package com.wesleyreisz.battlebot.weapon;

import com.wesleyreisz.battlebot.Dice;
import com.wesleyreisz.battlebot.PlayerCharacter;
import com.wesleyreisz.battlebot.utils.DiceUtil;

public class Rapier implements IWeapon {
	private Dice baseDamageDice = Dice.D6;
	private static final String DESCRIPTION = "Jabs with his rapier";
	
	@Override
	public int attack(PlayerCharacter c){
		return DiceUtil.rollDice(Dice.D20) + c.getDexerityHitModifer();
	}
	@Override
	public int damage(PlayerCharacter c){
		return DiceUtil.rollDice(baseDamageDice) +c.getDexerityHitModifer();
	}
	@Override
	public String getDescription(){
		return DESCRIPTION;
	}
}