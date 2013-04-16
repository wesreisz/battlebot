package com.wesleyreisz.battlebot.armor;

import junit.framework.Assert;

import org.junit.Test;
import com.wesleyreisz.battlebot.exceptions.InvalidCharacterStatisticException;
import com.wesleyreisz.battlebot.utils.CharacterUtil;

public class CharacterUtilTest {

	@Test
	public void testGetBonusFromCharacterStat() throws InvalidCharacterStatisticException{
		Assert.assertEquals(2, CharacterUtil.getBonusFromCharacterStat(14));
		Assert.assertEquals(4, CharacterUtil.getBonusFromCharacterStat(18));
		Assert.assertEquals(-1, CharacterUtil.getBonusFromCharacterStat(8));
		Assert.assertEquals(-3, CharacterUtil.getBonusFromCharacterStat(4));
	}
	@Test
	public void testGetBonusOddNumberFromCharacterStat() throws InvalidCharacterStatisticException {
		Assert.assertEquals(2, CharacterUtil.getBonusFromCharacterStat(15));
		Assert.assertEquals(4, CharacterUtil.getBonusFromCharacterStat(19));
		Assert.assertEquals(-4, CharacterUtil.getBonusFromCharacterStat(1));
	}
	@Test(expected = InvalidCharacterStatisticException.class)
	public void testGetBonusZeroFromCharacterStat() throws InvalidCharacterStatisticException{
		Assert.assertEquals(0, CharacterUtil.getBonusFromCharacterStat(0));
	}
}
