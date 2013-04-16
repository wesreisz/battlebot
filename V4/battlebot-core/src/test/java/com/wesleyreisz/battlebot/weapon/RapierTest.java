package com.wesleyreisz.battlebot.weapon;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;

import com.wesleyreisz.battlebot.PlayerCharacter;
import com.wesleyreisz.battlebot.effect.*;

public class RapierTest {
	private static IWeapon weapon;
	private static PlayerCharacter player;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		player = new PlayerCharacter("Maylar", 8, 18);
		weapon = new Acid(new Acid(new Rapier()));
	}

	@Test
	public void testAttack() {
		int min = 1;
		int max = 30;
		int val = weapon.damage(player);
		Assert.assertEquals(true,val>=min);
		Assert.assertEquals(true,val<=max);
	}

	@Test
	public void testDamage() {
		int min = 3;
		int max = 30;
		int val = weapon.damage(player);
		Assert.assertEquals(true,val>=min);
		Assert.assertEquals(true,val<=max);
	}

	@Test
	public void testGetDescription() {
		Assert.assertEquals("Jabs with his rapier blisters with Acid blisters with Acid", weapon.getDescription());
	}

}
