package com.wesleyreisz.battlebot.weapon;

import java.util.Date;
import java.util.List;

import com.wesleyreisz.battlebot.PlayerCharacter;
import com.wesleyreisz.battlebot.effect.IEffect;

public interface IWeapon {
	public int attack(PlayerCharacter c);
	public int damage(PlayerCharacter c);
	
	public String getName();

	public String getDescription();
	
	public long getWeaponId();
	public void setWeaponId(long id);
	
	public Date getLastModifiedDate();
	public void setLastModifiedDate(Date modDt);
	
	public List<IEffect> getEffectsList();
	public void setEffectsList(List<IEffect> effects);
}