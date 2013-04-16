package com.wesleyreisz.battlebot.dal.dao;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wesleyreisz.battlebot.dal.beans.EffectBean;
import com.wesleyreisz.battlebot.dal.beans.WeaponBean;

public class WeaponImplTest {

	@Test
	public void testWeapon() {
		ApplicationContext context = 
	    		new ClassPathXmlApplicationContext("applicationContext-test.xml");
		
		EffectBean effect = new EffectBean(1);
		ArrayList<EffectBean> effects = new ArrayList<EffectBean>();
		effects.add(effect);
		WeaponBean w = new WeaponBean("War Axe"); //weapon must have an effect. Use a non effect (id = 1) This needs to be implemented in the bl.
		w.setEffects(effects);
		
		IWeaponDAO weaponImpl =  (IWeaponDAO) context.getBean("weaponImplDAO");
		WeaponBean w1 = weaponImpl.add(w);
		w1.setWeaponName("Bigger Axe");
		WeaponBean w2 = weaponImpl.update(w1);
		WeaponBean w3 = weaponImpl.getById(w2);
		Assert.assertEquals(w2, w3);
		Assert.assertEquals(true, weaponImpl.remove(w3));
		
	}
	
	@Test
	public void testWeaponEffects() {
		ApplicationContext context = 
	    		new ClassPathXmlApplicationContext("applicationContext-test.xml");
		
		EffectBean effect = new EffectBean();
		effect.setEffectName("Flame");
		
		List<EffectBean>effects = new ArrayList<EffectBean>();
		effects.add(effect);
		
		WeaponBean w = new WeaponBean();
		w.setWeaponName("War Axe");
		w.setEffects(effects);
		
		IWeaponDAO weapDAO =  (IWeaponDAO) context.getBean("weaponImplDAO");
		WeaponBean weapon1 = weapDAO.add(w);
		
		WeaponBean weapon2 = weapDAO.getById(weapon1);
		Assert.assertEquals(1,weapon2.getEffects().size());
		
		effects = null;
		effects = weapDAO.listEffectsOnWeapon(weapon2);
		Assert.assertEquals(1,weapon2.getEffects().size());
		
		weapDAO.remove(weapon2);
	}

}
