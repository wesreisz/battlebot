package com.wesleyreisz.battlebot.dal.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.wesleyreisz.battlebot.dal.beans.PlayerCharacterBean;

public class PlayerCharacterBeanMapper implements RowMapper {

	@Override
	public PlayerCharacterBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		PlayerCharacterBean bean = new PlayerCharacterBean();
		bean.setArmorId(rs.getLong("armorId"));
		bean.setCurrentHp(rs.getInt("currentHp_INT"));
		bean.setExperience(rs.getLong("experienceINT"));
		bean.setGold(rs.getLong("goldINT"));
		bean.setMaxHp(rs.getInt("maxHp_INT"));
		bean.setModDt(rs.getDate("modDT"));
		bean.setPlayerCharacterId(rs.getLong("playerId"));
		bean.setPlayerCharacterName(rs.getString("playerNameTX"));
		bean.setWeaponId(rs.getLong("weaponId"));
		return bean;
	}
}
