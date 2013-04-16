package com.wesleyreisz.battlebot.weapon;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;

import com.wesleyreisz.battlebot.PlayerCharacter;
import com.wesleyreisz.battlebot.effect.Fire;

public class AxeTest {
	private static IWeapon axe;
	private static PlayerCharacter player;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		player = new PlayerCharacter("Maylar", 14, 12);
		axe = new Fire(new Axe());
	}

	@Test
	public void testAttack() {
		int min = 1;
		int max = 30;
		int val = axe.damage(player);
		Assert.assertEquals(true,val>=min);
		Assert.assertEquals(true,val<=max);
	}

	@Test
	public void testDamage() {
		int min = 2;
		int max = 14;
		int val = axe.damage(player);
		Assert.assertEquals(true,val>=min);
		Assert.assertEquals(true,val<=max);
	}

	@Test
	public void testGetDescription() {
		Assert.assertEquals("Crushes with his Axe adds seering fire", axe.getDescription());
	}

}
