package com.wesleyreisz.battlebot.service;

import java.util.List;

import com.wesleyreisz.battlebot.dal.dao.IWeaponDAO;
import com.wesleyreisz.battlebot.weapon.IWeapon;

public interface IWeaponService {

	public abstract List<IWeapon> getList();

	public abstract IWeaponDAO getWeaponImpl();

	public abstract void setWeaponImpl(IWeaponDAO weaponImpl);

}