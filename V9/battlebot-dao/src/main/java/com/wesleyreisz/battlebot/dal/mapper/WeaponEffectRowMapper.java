package com.wesleyreisz.battlebot.dal.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.wesleyreisz.battlebot.dal.beans.WeaponEffectBean;


public class WeaponEffectRowMapper implements RowMapper  {
	
	@Override
	public WeaponEffectBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		WeaponEffectBean bean = new WeaponEffectBean();
		bean.setEffectId(rs.getLong("effectId"));
		bean.setWeaponId(rs.getLong("weaponId"));
		return bean;
	}
}
