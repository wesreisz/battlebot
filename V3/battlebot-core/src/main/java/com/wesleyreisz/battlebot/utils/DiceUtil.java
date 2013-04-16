package com.wesleyreisz.battlebot.utils;

import java.util.Calendar;
import java.util.Random;

import com.wesleyreisz.battlebot.Dice;

public class DiceUtil {
	private static int _counter=0;
	public static int rollDice(Dice die){
		_counter += 1;
		Random generator = new Random(Calendar.getInstance().getTimeInMillis()+_counter);
		return generator.nextInt(die.getSideNumber())+1;
	}
}
