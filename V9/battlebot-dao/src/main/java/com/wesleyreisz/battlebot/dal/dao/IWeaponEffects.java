package com.wesleyreisz.battlebot.dal.dao;

import com.wesleyreisz.battlebot.dal.beans.EffectBean;
import com.wesleyreisz.battlebot.dal.beans.WeaponBean;

public interface IWeaponEffects {
	public Boolean checkEffectOnWeapon(WeaponBean weapon, EffectBean effect);
	public Boolean addEffectToWeapon(WeaponBean weapon, EffectBean effect);
	public Boolean removeEffectFromWeapon(WeaponBean weapon, EffectBean effect);
}
