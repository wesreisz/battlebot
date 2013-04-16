package com.wesleyreisz.battlebot.dal.dao;

import java.util.List;

import javax.sql.DataSource;

import com.wesleyreisz.battlebot.dal.beans.EffectBean;
import com.wesleyreisz.battlebot.dal.beans.WeaponBean;

public interface IWeapon {
	public void setDataSource(DataSource dataSource); 
	public WeaponBean getById(WeaponBean w);
	public List<WeaponBean> list();
	public WeaponBean add(WeaponBean w);
	public WeaponBean update(WeaponBean w);
	public boolean remove(WeaponBean w);
	
	public WeaponBean addEffectToWeapon(WeaponBean w,EffectBean e);
	public WeaponBean removeEffectFromWeapon(WeaponBean w,EffectBean e);
	public List<EffectBean> listEffectsOnWeapon(WeaponBean w);
}
