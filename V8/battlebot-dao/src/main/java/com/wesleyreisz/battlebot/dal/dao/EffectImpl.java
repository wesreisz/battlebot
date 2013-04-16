package com.wesleyreisz.battlebot.dal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.wesleyreisz.battlebot.dal.beans.ArmorBean;
import com.wesleyreisz.battlebot.dal.beans.EffectBean;
import com.wesleyreisz.battlebot.dal.beans.WeaponBean;
import com.wesleyreisz.battlebot.dal.mapper.EffectRowMapper;
import com.wesleyreisz.battlebot.dal.mapper.WeaponRowMapper;

public class EffectImpl extends JdbcDaoSupport implements IEffect {
	private static final String INSERT_EFFECT= "insert into Effect (effectName,modDT) values(?,now())";
	private static final String DELETE_EFFECT= "delete from Effect where effectId=?";
	private static final String SELECT_ALL= "select effectId,effectName,modDT from BattleBotDb.Effect order by effectName";
	

	@Override
	public EffectBean addEffect(final EffectBean effect){
		 KeyHolder keyHolder = new GeneratedKeyHolder();
	     getJdbcTemplate().update(new PreparedStatementCreator() {
	            public PreparedStatement createPreparedStatement(
	                    Connection connection) throws SQLException {
	                PreparedStatement ps = connection.prepareStatement(INSERT_EFFECT,
	                        new String[] { "effectName", "modDT" });
	                ps.setString(1, effect.getEffectName());
	                return ps;
	            }
	        }, keyHolder);
	     	effect.setEffectId(keyHolder.getKey().longValue());
	        return effect;
	}


	@Override
	public boolean removeEffect(EffectBean effect) {
		try{
			getJdbcTemplate().update(DELETE_EFFECT,new Object[]{
					effect.getEffectId()
				});
		}catch(Exception e){
			return false;
		}
		return true;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<EffectBean> list() {
		List<EffectBean> effectBeans = getJdbcTemplate().query(
				SELECT_ALL, new EffectRowMapper());	
		return effectBeans;
	}

}
