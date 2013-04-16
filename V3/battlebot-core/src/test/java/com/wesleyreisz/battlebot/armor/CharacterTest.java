package com.wesleyreisz.battlebot.armor;

import junit.framework.Assert;

import org.junit.Test;

import com.wesleyreisz.battlebot.Character;

public class CharacterTest {
	@Test
	public void testCharacterDefenseNoArmor() {
		Character c1 = new Character("Maylar", 17, 10);
		int i = 0;
		while(i++ < 10){
			int toHitAC = c1.getCharacterArmorClass();
			Assert.assertEquals(true, toHitAC>0);
			//System.out.println(toHitAC);
		}
	}
	@Test
	public void testCharacterDefenseLeather() {
		Character c1 = new Character("Maylar", 17, 10);
		c1.setArmor(new Leather());
		int i = 0;
		while(i++ < 10){
			int toHitAC = c1.getCharacterArmorClass();
			Assert.assertEquals(true, toHitAC>0);
			//System.out.println(toHitAC);
		}
	}
	@Test
	public void testCharacterDefensePlate() {
		Character c1 = new Character("Maylar", 17, 10);
		c1.setArmor(new Plate());
		int i = 0;
		while(i++ < 10){
			int toHitAC = c1.getCharacterArmorClass();
			Assert.assertEquals(true, toHitAC>0);
			//System.out.println(toHitAC);
		}
	}
	@Test
	public void testCharacterDefensePlateHighDex() {
		Character c1 = new Character("Maylar", 17, 18);
		c1.setArmor(new Plate());
		int i = 0;
		while(i++ < 10){
			int toHitAC = c1.getCharacterArmorClass();
			Assert.assertEquals(true, toHitAC>0);
			//System.out.println(toHitAC);
		}
	}
	@Test
	public void testCharacterDefenseLeatherHighDex() {
		Character c1 = new Character("Maylar", 17, 18);
		c1.setArmor(new Leather());
		int i = 0;
		while(i++ < 10){
			int toHitAC = c1.getCharacterArmorClass();
			Assert.assertEquals(true, toHitAC>0);
			//System.out.println(toHitAC);
		}
	}
}
