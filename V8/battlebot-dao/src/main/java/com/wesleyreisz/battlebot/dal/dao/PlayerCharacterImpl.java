package com.wesleyreisz.battlebot.dal.dao;

import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.wesleyreisz.battlebot.dal.beans.PlayerCharacterBean;
import com.wesleyreisz.battlebot.dal.mapper.PlayerCharacterBeanMapper;

public class PlayerCharacterImpl extends JdbcDaoSupport implements IPlayerCharacter {
	private static final String SELECT_BY_ID = 
			"select armorId, maxHp_INT, currentHp_INT, experienceINT, goldINT, modDT, playerId, playerNameTX, weaponId from PlayerCharacter where playerId=?";
	private static final String SELECT_BY_NAME = 
			"select armorId, maxHp_INT, currentHp_INT, experienceINT, goldINT, modDT, playerId, playerNameTX, weaponId from PlayerCharacter where playerNameTX=?";
	private static final String SELECT_ALL_PLAYERS = 
			"select armorId, maxHp_INT, currentHp_INT, experienceINT, goldINT, modDT, playerId, playerNameTX, weaponId from PlayerCharacter order by playerNameTX";
	private static final String INSERT_PLAYER = 
			"insert into PlayerCharacter (armorId, maxHp_INT, currentHp_INT, experienceINT, goldINT, modDT, playerNameTX, weaponId) " +
	        "values(?,?,?,?,?,?,?,?)";
	private static final String UPDATE_PLAYER = 
			"update PlayerCharacter set armorId=?, maxHp_INT=?, currentHp_INT=?, experienceINT=?, goldINT=?, modDT=?, playerNameTX=?, weaponId=? where playerId=?";
	private static final String DELETE_PLAYER = 
			"delete from PlayerCharacter where playerId=?";
	
	@SuppressWarnings("unchecked")
	@Override
	public PlayerCharacterBean getById(PlayerCharacterBean pc) {
		return (PlayerCharacterBean)getJdbcTemplate().queryForObject(
			SELECT_BY_ID, new Object[]{pc.getPlayerCharacterId()}, new PlayerCharacterBeanMapper());
	}

	@SuppressWarnings("unchecked")
	@Override
	public PlayerCharacterBean getByName(String name) {
		return (PlayerCharacterBean)getJdbcTemplate().queryForObject(
			SELECT_BY_NAME, new Object[]{name}, new PlayerCharacterBeanMapper());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PlayerCharacterBean> list() {
		List<PlayerCharacterBean> playerBeans = getJdbcTemplate().query(
				SELECT_ALL_PLAYERS, new PlayerCharacterBeanMapper());	
		return playerBeans;
	}

	@Override
	public PlayerCharacterBean add(PlayerCharacterBean pc) {
		getJdbcTemplate().update(INSERT_PLAYER,new Object[]{
				pc.getArmorId(),pc.getMaxHp(),pc.getCurrentHp(),pc.getExperience(),pc.getGold(),new Date(),pc.getPlayerCharacterName(),pc.getWeaponId()
			});
		return pc;
	}

	@Override
	public PlayerCharacterBean update(PlayerCharacterBean pc) {
		PlayerCharacterBean player = getById(pc);
		if (pc.getArmorId()!=0){player.setArmorId(pc.getArmorId());}
		if (pc.getMaxHp()!=0){player.setMaxHp(pc.getMaxHp());}
		if (pc.getCurrentHp()!=0){player.setCurrentHp(pc.getCurrentHp());}
		if (pc.getExperience()!=0){player.setExperience(pc.getExperience());}
		if (pc.getGold()!=0){player.setGold(pc.getGold());}
		if (!"".equals(pc.getPlayerCharacterName())){player.setPlayerCharacterName(pc.getPlayerCharacterName());}
		if (pc.getWeaponId()!=0){player.setWeaponId(pc.getWeaponId());}
		pc.setModDt(new Date());
		
		getJdbcTemplate().update(UPDATE_PLAYER,new Object[]{
				player.getArmorId(),player.getMaxHp(),player.getCurrentHp(),player.getExperience(),
				player.getGold(),player.getModDt(),player.getPlayerCharacterName(),player.getWeaponId(),
				player.getPlayerCharacterId()
			});
		return pc;
	}

	@Override
	public boolean remove(PlayerCharacterBean pc) {
		try{
			getJdbcTemplate().update(DELETE_PLAYER,new Object[]{
					pc.getPlayerCharacterId()
				});
		}catch(Exception e){
			return false;
		}
		return true;
	}
}
