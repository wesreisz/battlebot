package com.wesleyreisz.battlebot.dal.dao;

import java.util.List;

import com.wesleyreisz.battlebot.dal.beans.EffectBean;
import com.wesleyreisz.battlebot.dal.beans.WeaponBean;

public interface IEffect {
	public EffectBean addEffect(EffectBean effect);
	public boolean removeEffect(EffectBean effect);
	public List<EffectBean> list();
}
