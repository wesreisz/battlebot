package com.wesleyreisz.battlebot.dal.dao;

import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.wesleyreisz.battlebot.dal.beans.ArmorBean;
import com.wesleyreisz.battlebot.dal.beans.PlayerCharacterBean;
import com.wesleyreisz.battlebot.dal.mapper.ArmorRowMapper;
import com.wesleyreisz.battlebot.dal.mapper.PlayerCharacterBeanMapper;

public class ArmorImpl extends JdbcDaoSupport implements IArmor {
	private static final String SELECT_BY_ID = "select armorId,armorNameTx,baseAcINT, dexHinderenceINT,modDT from Armor where armorId=?";
	private static final String SELECT_BY_NAME = "select armorId,armorNameTx,baseAcINT, dexHinderenceINT,modDT from Armor where armorNameTx=?";
	private static final String SELECT_ALL = "select armorId,armorNameTx,baseAcINT, dexHinderenceINT,modDT from Armor";
	private static final String INSERT_ARMOR = 
			"insert into Armor (armorNameTx,baseAcINT, dexHinderenceINT,modDT) " +
	        "values(?,?,?,?)";
	private static final String UPDATE_PLAYER = 
			"update Armor set  armorNameTx=?, baseAcINT=?, dexHinderenceINT=?, modDT=? where armorId=?";
	private static final String DELETE = 
			"delete from Armor where armorId=?";
	
	@SuppressWarnings("unchecked")
	@Override
	public ArmorBean getById(ArmorBean a) {
		return (ArmorBean)getJdbcTemplate().queryForObject(
			SELECT_BY_ID, new Object[]{a.getArmorId()}, new ArmorRowMapper());
	
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArmorBean getByName(String name) {
		return (ArmorBean)getJdbcTemplate().queryForObject(
				SELECT_BY_NAME, new Object[]{name}, new ArmorRowMapper());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ArmorBean> list() {
		List<ArmorBean> playerBeans = getJdbcTemplate().query(
				SELECT_ALL, new ArmorRowMapper());	
		return playerBeans;
	}

	@Override
	public ArmorBean add(ArmorBean a) {
		getJdbcTemplate().update(INSERT_ARMOR,new Object[]{
				a.getArmorName(),a.getBaseAc(),a.getDexHinderance(),new Date()
			});
		return a;
	}

	@Override
	public ArmorBean update(ArmorBean a) {
		ArmorBean a1 = getById(a);
		if (!"".equals(a.getArmorName())){a1.setArmorName(a.getArmorName());};
		if (a.getBaseAc()!=0){a1.setBaseAc(a.getBaseAc());}
		if (a.getDexHinderance()!=0){a1.setDexHinderance(a.getDexHinderance());}
		a.setModDt(new Date());
		
		getJdbcTemplate().update(UPDATE_PLAYER,new Object[]{
				a1.getArmorName(), a1.getBaseAc(), a1.getDexHinderance(), a1.getModDt(), a1.getArmorId()
			});
		return a1;
	}

	@Override
	public boolean remove(ArmorBean a) {
		try{
			getJdbcTemplate().update(DELETE,new Object[]{
					a.getArmorId()
				});
		}catch(Exception e){
			return false;
		}
		return true;
	}

}
