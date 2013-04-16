package com.wesleyreisz.battlebot.dal.dao;

import java.util.List;

import javax.sql.DataSource;

import com.wesleyreisz.battlebot.dal.beans.ArmorBean;

public interface IArmor {
	public void setDataSource(DataSource dataSource); 
	public ArmorBean getById(ArmorBean pc);
	public ArmorBean getByName(String name);
	public List<ArmorBean> list();
	public ArmorBean add(ArmorBean pc);
	public ArmorBean update(ArmorBean pc);
	public boolean remove(ArmorBean pc);
}
