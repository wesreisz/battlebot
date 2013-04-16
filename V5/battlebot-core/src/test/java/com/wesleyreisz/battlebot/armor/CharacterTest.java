package com.wesleyreisz.battlebot.armor;

import junit.framework.Assert;

import org.junit.Test;

import com.wesleyreisz.battlebot.PlayerCharacter;

public class CharacterTest {
	@Test
	public void testCharacterDefenseNoArmor() {
		PlayerCharacter c1 = new PlayerCharacter("Maylar", 17, 10);
		int i = 0;
		while(i++ < 10){
			int toHitAC = c1.defend();
			Assert.assertEquals(true, toHitAC>0);
			//System.out.println(toHitAC);
		}
	}
	@Test
	public void testCharacterDefenseLeather() {
		PlayerCharacter c1 = new PlayerCharacter("Maylar", 17, 10);
		c1.setArmor(new Leather());
		int i = 0;
		while(i++ < 10){
			int toHitAC = c1.defend();
			Assert.assertEquals(true, toHitAC>0);
			//System.out.println(toHitAC);
		}
	}
	@Test
	public void testCharacterDefensePlate() {
		PlayerCharacter c1 = new PlayerCharacter("Maylar", 17, 10);
		c1.setArmor(new Plate());
		int i = 0;
		while(i++ < 10){
			int toHitAC = c1.defend();
			Assert.assertEquals(true, toHitAC>0);
			//System.out.println(toHitAC);
		}
	}
	@Test
	public void testCharacterDefensePlateHighDex() {
		PlayerCharacter c1 = new PlayerCharacter("Maylar", 17, 18);
		c1.setArmor(new Plate());
		int i = 0;
		while(i++ < 10){
			int toHitAC = c1.defend();
			Assert.assertEquals(true, toHitAC>0);
			//System.out.println(toHitAC);
		}
	}
	@Test
	public void testCharacterDefenseLeatherHighDex() {
		PlayerCharacter c1 = new PlayerCharacter("Maylar", 17, 18);
		c1.setArmor(new Leather());
		int i = 0;
		while(i++ < 10){
			int toHitAC = c1.defend();
			Assert.assertEquals(true, toHitAC>0);
			//System.out.println(toHitAC);
		}
	}
}
