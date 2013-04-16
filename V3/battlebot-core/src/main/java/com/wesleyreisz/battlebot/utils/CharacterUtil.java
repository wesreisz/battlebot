package com.wesleyreisz.battlebot.utils;

import com.wesleyreisz.battlebot.exceptions.InvalidCharacterStatisticException;

public class CharacterUtil {
	public static int getBonusFromCharacterStat(int characterStat) throws InvalidCharacterStatisticException{
		if (characterStat<=0){ throw new InvalidCharacterStatisticException("Character Statistic may not be less than 1");}
		
		return (characterStat - 10) / 2;
	}
}
