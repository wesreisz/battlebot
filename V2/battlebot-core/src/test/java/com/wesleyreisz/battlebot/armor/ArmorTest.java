package com.wesleyreisz.battlebot.armor;

import junit.framework.Assert;

import org.junit.Test;

import com.wesleyreisz.battlebot.armor.Leather;

public class ArmorTest {

	@Test
	public void testLeatherModifer_AC() {
		IArmor leather = new Leather();
		Assert.assertEquals(2, leather.getArmorClassModifer());
		Assert.assertEquals(0,leather.getArmorDexerityHinderenceModifier());
	}
	@Test
	public void testChainModifer_AC() {
		IArmor leather = new Chain();
		Assert.assertEquals(3, leather.getArmorClassModifer());
		Assert.assertEquals(-2,leather.getArmorDexerityHinderenceModifier());
	}
	@Test
	public void testPlateModifer_AC() {
		IArmor leather = new Plate();
		Assert.assertEquals(4, leather.getArmorClassModifer());
		Assert.assertEquals(-3,leather.getArmorDexerityHinderenceModifier());
	}
}
