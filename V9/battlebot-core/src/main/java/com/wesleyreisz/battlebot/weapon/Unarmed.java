package com.wesleyreisz.battlebot.weapon;

import java.util.Date;
import java.util.List;

import com.wesleyreisz.battlebot.Dice;
import com.wesleyreisz.battlebot.PlayerCharacter;
import com.wesleyreisz.battlebot.effect.IEffect;
import com.wesleyreisz.battlebot.utils.DiceUtil;

public class Unarmed implements IWeapon {
	private static final String NAME = "Unarmed";
	private static final String DESCRIPTION = "Flails with this fists";
	private long weaponId;
	private Dice baseDamageDice = Dice.D4;
	private Date lastModifiedDt;
	private List<IEffect>  effects;
	
	@Override
	public int attack(PlayerCharacter c){
		return DiceUtil.rollDice(Dice.D20) + c.getDexerityHitModifer();
	}

	@Override
	public int damage(PlayerCharacter c){
		return DiceUtil.rollDice(baseDamageDice) +c.getDexerityHitModifer();
	}

	@Override
	public String getName() {
		return NAME;
	}

	@Override
	public String getDescription() {
		return DESCRIPTION;
	}

	@Override
	public long getWeaponId() {
		return weaponId;
	}

	@Override
	public void setWeaponId(long id) {
		this.weaponId = id;
	}

	@Override
	public Date getLastModifiedDate() {
		return lastModifiedDt;
	}

	@Override
	public void setLastModifiedDate(Date modDt) {
		this.lastModifiedDt = modDt;
	}

	@Override
	public List<IEffect> getEffectsList() {
		return effects;
	}

	@Override
	public void setEffectsList(List<IEffect> effects) {
		this.effects= effects;

	}
	@Override
	public String toString(){
		return getName();
	}
}
