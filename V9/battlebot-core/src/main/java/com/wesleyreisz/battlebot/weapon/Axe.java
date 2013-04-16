package com.wesleyreisz.battlebot.weapon;

import java.util.Date;
import java.util.List;

import com.wesleyreisz.battlebot.Dice;
import com.wesleyreisz.battlebot.PlayerCharacter;
import com.wesleyreisz.battlebot.effect.IEffect;
import com.wesleyreisz.battlebot.utils.DiceUtil;
import com.wesleyreisz.battlebot.utils.StringUtils;

public class Axe implements IWeapon {
	private static final String NAME = "Axe";
	private static final String DESCRIPTION = "Crushes with his Axe";
	private long weaponId;
	private Dice baseDamageDice = Dice.D10;
	private Date lastModifiedDt;
	private List<IEffect>  effects;
	
	
	@Override
	public int attack(PlayerCharacter c){
		return DiceUtil.rollDice(Dice.D20);
	}
	@Override
	public int damage(PlayerCharacter c){
		return DiceUtil.rollDice(baseDamageDice) + c.getStrengthDamageModifer();
	}
	@Override
	public String getDescription(){
		return DESCRIPTION;
	}
	@Override
	public long getWeaponId() {
		return this.weaponId;
	}
	@Override
	public Date getLastModifiedDate() {
		return this.lastModifiedDt;
	}
	@Override
	public List<IEffect> getEffectsList() {
		return this.effects;
	}
	@Override
	public void setWeaponId(long id) {
		this.weaponId = id;
		
	}
	@Override
	public void setLastModifiedDate(Date modDt) {
		this.lastModifiedDt = modDt;
		
	}
	@Override
	public void setEffectsList(List<IEffect> effects) {
		this.effects=effects;
		
	}
	@Override
	public String getName() {
		return this.NAME;
	}
	@Override
	public String toString(){
		return getName();
	}
}
