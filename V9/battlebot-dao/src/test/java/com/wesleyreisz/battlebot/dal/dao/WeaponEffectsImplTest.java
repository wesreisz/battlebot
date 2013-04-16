package com.wesleyreisz.battlebot.dal.dao;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wesleyreisz.battlebot.dal.beans.EffectBean;
import com.wesleyreisz.battlebot.dal.beans.WeaponBean;

public class WeaponEffectsImplTest {

	@Test
	public void test() {
		ApplicationContext context = 
	    		new ClassPathXmlApplicationContext("applicationContext-test.xml");
		
		//see if mappoing exists
		IWeaponEffects weaponEffects =  (IWeaponEffects) context.getBean("weaponEffectsDAO");
		IEffect effectsDao =  (IEffect) context.getBean("effectDAO");
		IWeaponDAO weaponDao = (IWeaponDAO) context.getBean("weaponImplDAO");
		
		Boolean result = weaponEffects.checkEffectOnWeapon(new WeaponBean(1), new EffectBean(1));
		Assert.assertEquals(false, result);
		
		//add an effect independently
		EffectBean effect = new EffectBean("Test");
		effect = effectsDao.addEffect(effect);
		Assert.assertEquals(true, effectsDao.getEffectById(effect).getEffectId()>0);
		
		//create a weapon wiht this effect
		ArrayList<EffectBean> effects = new ArrayList<EffectBean>();
		effects.add(effect);
	
		WeaponBean weapon = new WeaponBean();
		weapon.setWeaponName("test");
		weapon.setModDt(new Date());
		weapon.setEffects(effects);
		weapon = weaponDao.add(weapon);
		Assert.assertEquals(true, weaponDao.getById(weapon).getWeaponId()>0);
		Assert.assertEquals(effect.getEffectName(), weaponDao.getById(weapon).getEffects().get(0).getEffectName());
		
		//see if mapping exists
		result = weaponEffects.checkEffectOnWeapon(weapon,effect);
		Assert.assertEquals(true, result);
		
		//delete the weapon
		Assert.assertEquals(true, weaponDao.remove(weapon));	
	}

}
