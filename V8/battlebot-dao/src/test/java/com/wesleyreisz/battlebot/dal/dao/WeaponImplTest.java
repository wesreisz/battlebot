package com.wesleyreisz.battlebot.dal.dao;

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
		
		WeaponBean w = new WeaponBean();
		w.setWeaponName("War Axe");
		
		IWeapon weaponImpl =  (IWeapon) context.getBean("weaponImplDAO");
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
		WeaponBean w = new WeaponBean();
		w.setWeaponName("War Axe");
		EffectBean effect = new EffectBean();
		effect.setEffectName("Flame");
		
		IWeapon weapDAO =  (IWeapon) context.getBean("weaponImplDAO");
		IEffect effectDAO =  (IEffect) context.getBean("effectImplDAO");
		
		WeaponBean weapon1 = weapDAO.add(w);
		EffectBean effect1 = effectDAO.addEffect(effect);
		weapDAO.addEffectToWeapon(weapon1, effect1);
		
		WeaponBean weapon2 = weapDAO.getById(weapon1);
		Assert.assertEquals(1,weapon2.getEffects().size());
		
		weapDAO.removeEffectFromWeapon(weapon2, effect1);
		effectDAO.removeEffect(effect1);
		weapDAO.remove(weapon2);
	}
	
	@Test
	public void testListEffectsByWeapon(){
		ApplicationContext context = 
	    		new ClassPathXmlApplicationContext("applicationContext-test.xml");
	
		IWeapon weapDAO =  (IWeapon) context.getBean("weaponImplDAO");
		WeaponBean weapon = new WeaponBean();
		weapon.setWeaponId(19);
		List<EffectBean> effects = weapDAO.listEffectsOnWeapon(weapon);
		Assert.assertEquals(1, effects.size());
	}

}
