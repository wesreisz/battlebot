package com.wesleyreisz.battlebot.dal.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.wesleyreisz.battlebot.dal.beans.WeaponBean;

public class WeaponRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		WeaponBean w = new WeaponBean();
		w.setWeaponId(rs.getLong("weaponId"));
		w.setModDt(rs.getDate("modDT"));
		w.setWeaponName(rs.getString("weaponNameTX"));
		return w;
	}

}
