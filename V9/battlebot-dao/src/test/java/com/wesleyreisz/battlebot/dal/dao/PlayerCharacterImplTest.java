package com.wesleyreisz.battlebot.dal.dao;

import java.util.ArrayList;
import java.util.Date;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wesleyreisz.battlebot.dal.beans.EffectBean;
import com.wesleyreisz.battlebot.dal.beans.PlayerCharacterBean;
import com.wesleyreisz.battlebot.dal.beans.WeaponBean;

public class PlayerCharacterImplTest {

	@Test
	public void testPlayerCharacter() {
		ApplicationContext context = 
	    		new ClassPathXmlApplicationContext("applicationContext-test.xml");
		
		
		ArrayList<EffectBean> effects = new ArrayList<EffectBean>();
		EffectBean effect1 = new EffectBean();
		effect1.setEffectId(1);
		effects.add(effect1);
		
		//add a weapon first
		WeaponBean weapon = new WeaponBean();
		weapon.setModDt(new Date());
		weapon.setWeaponName("Raxe");
		weapon.setEffects(effects);
		
		WeaponImpl weapDao = (WeaponImpl) context.getBean("weaponImplDAO");
		weapon = weapDao.add(weapon);
		
		//add a player
		PlayerCharacterBean pc1 = new PlayerCharacterBean();
		pc1.setArmorId(1);
		pc1.setCurrentHp(25);
		pc1.setExperience(100);
		pc1.setGold(0);
		pc1.setMaxHp(25);
		pc1.setModDt(new Date());
		pc1.setPlayerCharacterName("Maylar");
		pc1.setWeaponId(weapon.getWeaponId());
		
		PlayerCharacterImpl daoCharacterImpl =  (PlayerCharacterImpl) context.getBean("playerCharacterImplDAO");
		daoCharacterImpl.add(pc1);
		
		PlayerCharacterBean pc2 = daoCharacterImpl.getByName("Maylar");
		Assert.assertEquals(pc1.getPlayerCharacterName(), pc2.getPlayerCharacterName());
		
		pc2.setCurrentHp(100);
		pc2.setGold(500);
		PlayerCharacterBean pc3 = daoCharacterImpl.update(pc2);
		Assert.assertEquals(100, pc3.getCurrentHp());
		Assert.assertEquals(500, pc3.getGold());
		
		pc3.setPlayerCharacterName("Deend");
		PlayerCharacterBean pc4 = daoCharacterImpl.update(pc3);
		Assert.assertEquals("Deend", pc4.getPlayerCharacterName());
		Assert.assertEquals(pc3.getPlayerCharacterName(), pc4.getPlayerCharacterName());

		boolean isCharacterDeleted = daoCharacterImpl.remove(pc4);
		boolean isWeaponDeleted = weapDao.remove(weapon);
		Assert.assertEquals(true, isWeaponDeleted);	
		Assert.assertEquals(true, isCharacterDeleted);		
	}

}
