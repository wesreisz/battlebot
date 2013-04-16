package com.wesleyreisz.battlebot.dal.dao;

import java.util.List;

import javax.sql.DataSource;

import com.wesleyreisz.battlebot.dal.beans.PlayerCharacterBean;

public interface IPlayerCharacter {
	public void setDataSource(DataSource dataSource); 
	public PlayerCharacterBean getById(PlayerCharacterBean pc);
	public PlayerCharacterBean getByName(String name);
	public List<PlayerCharacterBean> list();
	public PlayerCharacterBean add(PlayerCharacterBean pc);
	public PlayerCharacterBean update(PlayerCharacterBean pc);
	public boolean remove(PlayerCharacterBean pc);
}
