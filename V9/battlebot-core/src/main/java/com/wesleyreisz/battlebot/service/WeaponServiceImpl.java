package com.wesleyreisz.battlebot.service;

import java.util.ArrayList;
import java.util.List;

import com.wesleyreisz.battlebot.dal.beans.WeaponBean;
import com.wesleyreisz.battlebot.dal.dao.IWeaponDAO;
import com.wesleyreisz.battlebot.weapon.IWeapon;
import com.wesleyreisz.battlebot.weapon.WeaponFactory;

public class WeaponServiceImpl implements IWeaponService {
	private IWeaponDAO weaponImpl;
	
	@Override
	public List<IWeapon> getList(){
		List<IWeapon>weapons = new ArrayList<IWeapon>();
		List<WeaponBean>weaponsDbList = weaponImpl.list();
		for(WeaponBean weaponDb: weaponsDbList){
			IWeapon weapon = WeaponFactory.getInstance(weaponDb.getWeaponName());
			weapon.setWeaponId(weaponDb.getWeaponId());
			weapon.setLastModifiedDate(weaponDb.getModDt());
			weapons.add(weapon);
		}
		return weapons;
	}
	
	@Override
	public IWeaponDAO getWeaponImpl() {
		return weaponImpl;
	}
	
	@Override
	public void setWeaponImpl(IWeaponDAO weaponImpl) {
		this.weaponImpl = weaponImpl;
	}
	
	
}
