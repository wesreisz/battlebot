package com.wesleyreisz.battlebot.dal.beans;

import java.util.Date;
import java.util.List;

public class WeaponBean {
	private long weaponId;
	private String weaponName;
	private Date modDt;
	private List<EffectBean> effects;
	
	public WeaponBean(){
	}
	
	public WeaponBean(String name){
		this.weaponName = name;
	}
	
	public WeaponBean(long weaponId){
		this.weaponId = weaponId;
	}
	
	public long getWeaponId() {
		return weaponId;
	}
	public void setWeaponId(long weaponId) {
		this.weaponId = weaponId;
	}
	public String getWeaponName() {
		return weaponName;
	}
	public void setWeaponName(String weaponName) {
		this.weaponName = weaponName;
	}
	public Date getModDt() {
		return modDt;
	}
	public void setModDt(Date modDt) {
		this.modDt = modDt;
	}
	public List<EffectBean> getEffects() {
		return effects;
	}
	public void setEffects(List<EffectBean> effects) {
		this.effects = effects;
	}
	@Override
	public String toString() {
		return "WeaponBean [weaponId=" + weaponId + ", weaponName="
				+ weaponName + ", modDt=" + modDt + ", effects=" + effects
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((effects == null) ? 0 : effects.hashCode());
		result = prime * result + ((modDt == null) ? 0 : modDt.hashCode());
		result = prime * result + (int) (weaponId ^ (weaponId >>> 32));
		result = prime * result
				+ ((weaponName == null) ? 0 : weaponName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WeaponBean other = (WeaponBean) obj;
		if (effects == null) {
			if (other.effects != null)
				return false;
		} else if (!effects.equals(other.effects))
			return false;
		if (modDt == null) {
			if (other.modDt != null)
				return false;
		} else if (!modDt.equals(other.modDt))
			return false;
		if (weaponId != other.weaponId)
			return false;
		if (weaponName == null) {
			if (other.weaponName != null)
				return false;
		} else if (!weaponName.equals(other.weaponName))
			return false;
		return true;
	}
	
}
