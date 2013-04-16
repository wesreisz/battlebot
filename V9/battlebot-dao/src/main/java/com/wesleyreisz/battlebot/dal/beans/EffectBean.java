package com.wesleyreisz.battlebot.dal.beans;

import java.util.Date;

public class EffectBean {
	private long effectId;
	private String effectName;
	private Date modDT;
	
	public EffectBean(){}
	public EffectBean(long id){
		this.effectId = id;
	}
	public EffectBean(String name){
		this.effectName=name;
	}
	public long getEffectId() {
		return effectId;
	}
	public void setEffectId(long effectId) {
		this.effectId = effectId;
	}
	public String getEffectName() {
		return effectName;
	}
	public void setEffectName(String effectName) {
		this.effectName = effectName;
	}
	public Date getModDT() {
		return modDT;
	}
	public void setModDT(Date modDT) {
		this.modDT = modDT;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (effectId ^ (effectId >>> 32));
		result = prime * result
				+ ((effectName == null) ? 0 : effectName.hashCode());
		result = prime * result + ((modDT == null) ? 0 : modDT.hashCode());
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
		EffectBean other = (EffectBean) obj;
		if (effectId != other.effectId)
			return false;
		if (effectName == null) {
			if (other.effectName != null)
				return false;
		} else if (!effectName.equals(other.effectName))
			return false;
		if (modDT == null) {
			if (other.modDT != null)
				return false;
		} else if (!modDT.equals(other.modDT))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "EffectBean [effectId=" + effectId + ", effectName="
				+ effectName + ", modDT=" + modDT + "]";
	}
}
