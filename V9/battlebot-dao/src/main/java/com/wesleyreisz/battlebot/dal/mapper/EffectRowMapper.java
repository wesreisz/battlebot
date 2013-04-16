package com.wesleyreisz.battlebot.dal.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.wesleyreisz.battlebot.dal.beans.EffectBean;

public class EffectRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		EffectBean effect = new EffectBean();
		effect.setEffectId(rs.getLong("effectId"));
		effect.setEffectName(rs.getString("effectName"));
		effect.setModDT(rs.getDate("modDT"));
		return effect;
	}

}
