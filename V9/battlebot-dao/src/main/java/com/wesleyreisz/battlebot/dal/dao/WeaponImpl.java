package com.wesleyreisz.battlebot.dal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.wesleyreisz.battlebot.dal.beans.EffectBean;
import com.wesleyreisz.battlebot.dal.beans.WeaponBean;
import com.wesleyreisz.battlebot.dal.mapper.EffectRowMapper;
import com.wesleyreisz.battlebot.dal.mapper.WeaponRowMapper;

public class WeaponImpl extends JdbcDaoSupport implements IWeaponDAO {
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
	private static final Logger logger = LoggerFactory.getLogger(WeaponImpl.class);
	
	private WeaponEffectsImpl weaponEffectsDAO;
	private EffectImpl effectDAO;
	
	
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
	public WeaponBean add(final WeaponBean weapon) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
	    getJdbcTemplate().update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(
                    Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(INSERT_WEAPON,
                        new String[] { "weaponNameTX", "modDT" });
                ps.setString(1, weapon.getWeaponName());
                return ps;
            }
        }, keyHolder);
	    weapon.setWeaponId(keyHolder.getKey().longValue());
	    
	    //now set effects on the weapon
	    if (!(weapon.getEffects().isEmpty())){
			for(EffectBean effect : weapon.getEffects()){
				if (!effectDAO.effectIsPresent(effect)){
					EffectBean newlyAddEffect = effectDAO.addEffect(effect);
					weaponEffectsDAO.addEffectToWeapon(weapon, newlyAddEffect);
				}else{
					weaponEffectsDAO.addEffectToWeapon(weapon, effect);
				}
			}
		}
        return weapon;
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
			logger.error(e.getMessage());
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
	

	public WeaponEffectsImpl getWeaponEffectsDAO() {
		return weaponEffectsDAO;
	}

	public void setWeaponEffectsDAO(WeaponEffectsImpl weaponEffectsDAO) {
		this.weaponEffectsDAO = weaponEffectsDAO;
	}

	public EffectImpl getEffectDAO() {
		return effectDAO;
	}

	public void setEffectDAO(EffectImpl effectDAO) {
		this.effectDAO = effectDAO;
	}

}
