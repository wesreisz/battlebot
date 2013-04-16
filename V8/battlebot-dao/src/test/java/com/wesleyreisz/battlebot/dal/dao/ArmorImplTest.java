package com.wesleyreisz.battlebot.dal.dao;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wesleyreisz.battlebot.dal.beans.ArmorBean;

public class ArmorImplTest {

	@Test
	public void testArmor() {
		ApplicationContext context = 
	    		new ClassPathXmlApplicationContext("applicationContext-test.xml");
		
		ArmorBean a1 = new ArmorBean();
		a1.setArmorName("Test");
		a1.setBaseAc(4);
		a1.setDexHinderance(2);
		
		ArmorImpl dao =  (ArmorImpl) context.getBean("armorImplDAO");
		dao.add(a1);
		
		ArmorBean a2 = dao.getByName("Test");
		a2.setArmorName("Pleather");
		ArmorBean a3 = dao.update(a2);
		Assert.assertEquals("Pleather", a3.getArmorName());
		
		boolean result = dao.remove(a3);
		Assert.assertEquals(true, result);	
	}

}
