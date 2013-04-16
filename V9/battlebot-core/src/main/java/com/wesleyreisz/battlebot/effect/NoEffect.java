package com.wesleyreisz.battlebot.effect;

import java.util.Date;
import java.util.List;

import com.wesleyreisz.battlebot.PlayerCharacter;
import com.wesleyreisz.battlebot.weapon.IWeapon;

public class NoEffect implements IEffect {
	private IWeapon weapon;
	
	public  NoEffect(IWeapon weapon){
		this.weapon=weapon;
	}
	@Override
	public int attack(PlayerCharacter c) {
		return weapon.attack(c);
	}

	@Override
	public int damage(PlayerCharacter c) {
		return weapon.damage(c);
	}
	@Override
	public String getDescription() {
		return weapon.getDescription() ;
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