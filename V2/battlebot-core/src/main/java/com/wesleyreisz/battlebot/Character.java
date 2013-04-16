package com.wesleyreisz.battlebot;

import com.wesleyreisz.battlebot.armor.IArmor;
import com.wesleyreisz.battlebot.weapon.IWeapon;

public class Character {
	private String name;
	private int hp;
	private volatile int initative;
	
	//stats
	private int strength;
	private int dexerity;
	
	//equip
	private IArmor armor;
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
	public void getCharacterArmorClass(){
		//Get Armor Modifier ie Leather +2
		//Get Armor Dex Modifier ie no dex mod from armor (no negatives)
		//Get Character Dex Modifier and substract armor dex modifier (character 18 = +4 -0=+4)
		//dex modifier is roll defense die + 2 + 4
	}

	@Override
	public String toString() {
		return "Character [name=" + name + ", strength=" + strength
				+ ", dexerity=" + dexerity + "]";
	}
	
}
