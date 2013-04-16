package com.wesleyreisz.battlebot.dal.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.wesleyreisz.battlebot.dal.beans.ArmorBean;
import com.wesleyreisz.battlebot.dal.beans.EffectBean;
import com.wesleyreisz.battlebot.dal.beans.WeaponBean;
import com.wesleyreisz.battlebot.dal.beans.WeaponEffectBean;
import com.wesleyreisz.battlebot.dal.mapper.ArmorRowMapper;
import com.wesleyreisz.battlebot.dal.mapper.WeaponEffectRowMapper;

public class WeaponEffectsImpl extends JdbcDaoSupport implements IWeaponEffects {
	private static final String SELECT_BY_IDS = 
			"select weaponId, effectId from WeaponEffects where weaponId=? and effectId=?";
	private static final String INSERT_WEAPON_EFFECT = 
			"insert into WeaponEffects (weaponId, effectId) values(?,?)";
	private static final String REMOVE_WEAPON_EFFECT = 
			"delete from WeaponEffects where weaponId = ? and effectId = ?";
	
	
	@Override
	public Boolean checkEffectOnWeapon(WeaponBean weapon, EffectBean effect) {
		try{
			@SuppressWarnings("unchecked")
			WeaponEffectBean bean = (WeaponEffectBean)getJdbcTemplate().queryForObject(
					SELECT_BY_IDS, new Object[]{weapon.getWeaponId(),effect.getEffectId()}, new WeaponEffectRowMapper());
			return true;
		}catch(Exception e){
			return false;
		}
	}

	@Override
	public Boolean addEffectToWeapon(WeaponBean weapon, EffectBean effect) {
		int result = getJdbcTemplate().update(INSERT_WEAPON_EFFECT,new Object[]{
				weapon.getWeaponId(),effect.getEffectId()
			});
		if (result > 0){ return true; }
		else {return false; }
	}

	@Override
	public Boolean removeEffectFromWeapon(WeaponBean weapon, EffectBean effect) {
		int result = getJdbcTemplate().update(REMOVE_WEAPON_EFFECT,new Object[]{
				weapon.getWeaponId(),effect.getEffectId()
			});
		if (result > 0){ return true; }
		else {return false; }
	}
}
