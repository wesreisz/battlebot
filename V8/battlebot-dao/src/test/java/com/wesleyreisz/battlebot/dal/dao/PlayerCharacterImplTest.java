package com.wesleyreisz.battlebot.dal.dao;

import java.util.Date;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wesleyreisz.battlebot.dal.beans.PlayerCharacterBean;

public class PlayerCharacterImplTest {

	@Test
	public void testPlayerCharacter() {
		ApplicationContext context = 
	    		new ClassPathXmlApplicationContext("applicationContext-test.xml");
		
		//add a player
		PlayerCharacterBean pc1 = new PlayerCharacterBean();
		pc1.setArmorId(1);
		pc1.setCurrentHp(25);
		pc1.setExperience(100);
		pc1.setGold(0);
		pc1.setMaxHp(25);
		pc1.setModDt(new Date());
		pc1.setPlayerCharacterName("Maylar");
		pc1.setWeaponId(30);
		
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
		
		boolean result = daoCharacterImpl.remove(pc4);
		Assert.assertEquals(true, result);		
	}

}
