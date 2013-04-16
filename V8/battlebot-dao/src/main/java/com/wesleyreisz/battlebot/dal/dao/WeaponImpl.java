package com.wesleyreisz.battlebot.dal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.wesleyreisz.battlebot.dal.beans.EffectBean;
import com.wesleyreisz.battlebot.dal.beans.WeaponBean;
import com.wesleyreisz.battlebot.dal.mapper.EffectRowMapper;
import com.wesleyreisz.battlebot.dal.mapper.WeaponRowMapper;

public class WeaponImpl extends JdbcDaoSupport implements IWeapon {
	private static final String SELECT_BY_ID = 
			"select weaponId,weaponNameTX,modDT from Weapon where weaponId=?";
	private static final String SELECT_ALL = 
			"select weaponId,weaponNameTX,modDT from Weapon order by weaponNameTX";
	private static final String INSERT_WEAPON = 
			"insert into Weapon (weaponNameTX,modDT) " +
			"values(?,now())";
	private static final String UPDATE_WEAPON_NAME = 
			"update Weapon set weaponNameTX=?,modDT=now() " +
			"where weaponId=?";
	private static final String DELETE = 
			"delete from Weapon where weaponId=?";
	private static final String INSERT_EFFECT_ON_WEAPON = 
			"insert into WeaponEffects (weaponId,effectId) values(?,?)";
	private static final String DELETE_EFFECT_ON_WEAPON = 
			"delete from WeaponEffects where weaponId=? and effectId=?";
	private static final String LIST_EFFECTS_ON_WEAPON =
			"select e.effectName as effectName, e.effectId as effectId, e.modDT as modDT " +
			"from Effect as e, WeaponEffects as we " +
			"where e.effectId=we.effectId and we.weaponId=?";
			
	@SuppressWarnings("unchecked")
	@Override
	public WeaponBean getById(WeaponBean w) {
		WeaponBean bean =  (WeaponBean)getJdbcTemplate().queryForObject(
				SELECT_BY_ID, new Object[]{w.getWeaponId()}, new WeaponRowMapper());
		bean.setEffects(listEffectsOnWeapon(w));
		return bean;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<WeaponBean> list() {
		List<WeaponBean> weaponBeans = getJdbcTemplate().query(
				SELECT_ALL, new WeaponRowMapper());
		return weaponBeans;
	}

	@Override
	public WeaponBean add(final WeaponBean w) {
		 KeyHolder keyHolder = new GeneratedKeyHolder();
	     getJdbcTemplate().update(new PreparedStatementCreator() {
	            public PreparedStatement createPreparedStatement(
	                    Connection connection) throws SQLException {
	                PreparedStatement ps = connection.prepareStatement(INSERT_WEAPON,
	                        new String[] { "weaponNameTX", "modDT" });
	                ps.setString(1, w.getWeaponName());
	                return ps;
	            }
	        }, keyHolder);
	        w.setWeaponId(keyHolder.getKey().longValue());
	        return w;
	}

	@Override
	public WeaponBean update(final WeaponBean w) {
		getJdbcTemplate().update(UPDATE_WEAPON_NAME,new Object[]{
				w.getWeaponName(), w.getWeaponId()
			});
		return getById(w);
	}

	@Override
	public boolean remove(WeaponBean w) {
		try{
			getJdbcTemplate().update(DELETE,new Object[]{
					w.getWeaponId()
				});
		}catch(Exception e){
			return false;
		}
		return true;
	}

	@Override
	public WeaponBean addEffectToWeapon(WeaponBean w,EffectBean e) {
		getJdbcTemplate().update(INSERT_EFFECT_ON_WEAPON,new Object[]{
				w.getWeaponId(),e.getEffectId()
			});
		return w;
	}

	@Override
	public WeaponBean removeEffectFromWeapon(WeaponBean w,EffectBean e) {
		getJdbcTemplate().update(DELETE_EFFECT_ON_WEAPON,new Object[]{
				w.getWeaponId(),e.getEffectId()
			});
		return w;
	}

	@Override
	public List<EffectBean> listEffectsOnWeapon(WeaponBean w) {
		@SuppressWarnings("unchecked")
		List<EffectBean> effects = getJdbcTemplate().query(
				LIST_EFFECTS_ON_WEAPON, new Object[]{w.getWeaponId()}, new EffectRowMapper());	
		return effects;
	}
}
