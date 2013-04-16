package com.wesleyreisz.battlebot.dal.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.wesleyreisz.battlebot.dal.beans.ArmorBean;

public class ArmorRowMapper implements RowMapper {
	@Override
	public ArmorBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		ArmorBean bean = new ArmorBean();
		bean.setArmorId(rs.getLong("armorId"));
		bean.setArmorName(rs.getString("armorNameTx"));
		bean.setBaseAc(rs.getInt("baseAcINT"));
		bean.setDexHinderance(rs.getInt("dexHinderenceINT"));
		bean.setModDt(rs.getDate("modDT"));
		
		return bean;
	}
}
