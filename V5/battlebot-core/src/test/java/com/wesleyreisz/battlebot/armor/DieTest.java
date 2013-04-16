package com.wesleyreisz.battlebot.armor;

import junit.framework.Assert;

import org.junit.Test;

import com.wesleyreisz.battlebot.Dice;
import com.wesleyreisz.battlebot.utils.DiceUtil;

public class DieTest {

	@Test
	public void testDieRolls() {
		int val = DiceUtil.rollDice(Dice.D12);
		Assert.assertEquals(true, val>0);
		Assert.assertEquals(true, val<13);
		val = DiceUtil.rollDice(Dice.D12);
		Assert.assertEquals(true, val>0);
		Assert.assertEquals(true, val<13);
		val = DiceUtil.rollDice(Dice.D12);
		Assert.assertEquals(true, val>0);
		Assert.assertEquals(true, val<13);
		val = DiceUtil.rollDice(Dice.D12);
		Assert.assertEquals(true, val>0);
		Assert.assertEquals(true, val<13);
		val = DiceUtil.rollDice(Dice.D20);
		Assert.assertEquals(true, val>0);
		Assert.assertEquals(true, val<=20);
		val = DiceUtil.rollDice(Dice.D20);
		Assert.assertEquals(true, val>0);
		Assert.assertEquals(true, val<=20);
		val = DiceUtil.rollDice(Dice.D20);
		Assert.assertEquals(true, val>0);
		Assert.assertEquals(true, val<=20);
		val = DiceUtil.rollDice(Dice.D20);
		Assert.assertEquals(true, val>0);
		Assert.assertEquals(true, val<=20);
		val = DiceUtil.rollDice(Dice.D8);
		Assert.assertEquals(true, val>0);
		Assert.assertEquals(true, val<=8);
		val = DiceUtil.rollDice(Dice.D8);
		Assert.assertEquals(true, val>0);
		Assert.assertEquals(true, val<=8);
		val = DiceUtil.rollDice(Dice.D8);
		Assert.assertEquals(true, val>0);
		Assert.assertEquals(true, val<=8);
		val = DiceUtil.rollDice(Dice.D4);
		Assert.assertEquals(true, val>0);
		Assert.assertEquals(true, val<=Dice.D4.getSideNumber());
		val = DiceUtil.rollDice(Dice.D4);
		Assert.assertEquals(true, val>0);
		Assert.assertEquals(true, val<=Dice.D4.getSideNumber());
		val = DiceUtil.rollDice(Dice.D4);
		Assert.assertEquals(true, val>0);
		Assert.assertEquals(true, val<=Dice.D4.getSideNumber());
		val = DiceUtil.rollDice(Dice.D4);
		Assert.assertEquals(true, val>0);
		Assert.assertEquals(true, val<=Dice.D4.getSideNumber());
		
	}

}
