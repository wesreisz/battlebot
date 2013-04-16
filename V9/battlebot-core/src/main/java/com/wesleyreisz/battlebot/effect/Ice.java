package com.wesleyreisz.battlebot.effect;

import java.util.Date;
import java.util.List;

import com.wesleyreisz.battlebot.Dice;
import com.wesleyreisz.battlebot.PlayerCharacter;
import com.wesleyreisz.battlebot.utils.DiceUtil;
import com.wesleyreisz.battlebot.utils.StringUtils;
import com.wesleyreisz.battlebot.weapon.IWeapon;

public class Ice implements IEffect {
	private IWeapon weapon;
	private Dice effectDamageDice = Dice.D4;
	private static final String DESCRIPTION = "adds freezing ice";
	
	public  Ice(IWeapon weapon){
		this.weapon=weapon;
	}
	@Override
	public int attack(PlayerCharacter c) {
		return weapon.attack(c);
	}

	@Override
	public int damage(PlayerCharacter c) {
		return weapon.damage(c) + DiceUtil.rollDice(effectDamageDice);
	}
	@Override
	public String getDescription() {
		return weapon.getDescription() + StringUtils.addSeparator() + Ice.DESCRIPTION;
	}
	@Override
	public long getWeaponId() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public Date getLastModifiedDate() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<IEffect> getEffectsList() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setWeaponId(long id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setLastModifiedDate(Date modDt) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setEffectsList(List<IEffect> effects) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
}