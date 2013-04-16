package com.wesleyreisz.battlebot;

import com.wesleyreisz.battlebot.armor.IArmor;
import com.wesleyreisz.battlebot.armor.NoArmor;
import com.wesleyreisz.battlebot.utils.CharacterUtil;
import com.wesleyreisz.battlebot.utils.DiceUtil;
import com.wesleyreisz.battlebot.weapon.IWeapon;

public class Character {
	private String name;
	private int hp;
	private volatile int initative;
	
	//stats
	private int strength;
	private int dexerity;
	
	//equip
	private IArmor armor = new NoArmor();
	private IWeapon weapon;
	
	public Character(String name, int strength, int dexerity){
		this.name = name;
		this.strength = strength;
		this.dexerity = dexerity;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHp() {
		return hp;
	}
	public int getInitative() {
		return initative;
	}
	public void setInitative(int initative) {
		this.initative = initative;
	}
	public int getStrength() {
		return strength;
	}
	public void setStrength(int strength) {
		this.strength = strength;
	}
	public int getDexerity() {
		return dexerity;
	}
	public void setDexerity(int dexerity) {
		this.dexerity = dexerity;
	}
	public IArmor getArmor() {
		return armor;
	}
	public void setArmor(IArmor armor) {
		this.armor = armor;
	}
	public IWeapon getWeapon() {
		return weapon;
	}
	public void setWeapon(IWeapon weapon) {
		this.weapon = weapon;
	}
	public void healCharacter(int hp) {
		this.hp = this.hp + hp;
	}
	public void damageCharacter(int hp) {
		this.hp = this.hp - hp;
	}
	public int getCharacterArmorClass(){
		//Get Armor Modifier ie Leather +2
		int acModifier = armor.getArmorClassModifer();
		//Get Armor Dex Modifier ie no dex mod from armor
		int acDexerityHinderence = armor.getArmorDexerityHinderenceModifier();
		//Get Character Dex Modifier and substract armor dex modifier (character 18 = +4 -0=+4)
		int acBonus = CharacterUtil.getBonusFromCharacterStat(dexerity);
		int diceRoll = DiceUtil.rollDice(Dice.D20);
		//dex modifier is roll defense die + 2 + 4
		return diceRoll + acModifier + acDexerityHinderence +acBonus;
	}

	@Override
	public String toString() {
		return "Character [name=" + name + ", strength=" + strength
				+ ", dexerity=" + dexerity + "]";
	}
	
}
