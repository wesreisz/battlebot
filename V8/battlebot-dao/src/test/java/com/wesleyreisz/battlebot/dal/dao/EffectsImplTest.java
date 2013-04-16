package com.wesleyreisz.battlebot.dal.dao;

import java.util.Date;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wesleyreisz.battlebot.dal.beans.EffectBean;

public class EffectsImplTest {

	@Test
	public void testEffect() {
		ApplicationContext context = 
	    		new ClassPathXmlApplicationContext("applicationContext-test.xml");
		EffectImpl dao =  (EffectImpl) context.getBean("effectImplDAO");
		List<EffectBean>effects = dao.list();
		int origSize = effects.size();
		
		EffectBean effect = new EffectBean();
		effect.setEffectName("Fire");
		effect.setModDT(new Date());
		
		
		
		EffectBean effect1 = dao.addEffect(effect);
		Assert.assertEquals(effect, effect1);
		
		effect = new EffectBean();
		effect.setEffectName("Ice");
		effect.setModDT(new Date());
		EffectBean effect2 = dao.addEffect(effect);
		
		List<EffectBean>effects1 = dao.list();
		Assert.assertEquals(origSize+2, effects1.size());
		
		dao.removeEffect(effect);
		dao.removeEffect(effect2);	
	}
}
