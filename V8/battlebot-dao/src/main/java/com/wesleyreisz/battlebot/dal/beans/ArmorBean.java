package com.wesleyreisz.battlebot.dal.beans;

import java.util.Date;

public class ArmorBean {
	private long armorId;
	private String armorName;
	private int baseAc;
	private int dexHinderance;
	private Date modDt;
	public long getArmorId() {
		return armorId;
	}
	public void setArmorId(long armorId) {
		this.armorId = armorId;
	}
	public String getArmorName() {
		return armorName;
	}
	public void setArmorName(String armorName) {
		this.armorName = armorName;
	}
	public int getBaseAc() {
		return baseAc;
	}
	public void setBaseAc(int baseAc) {
		this.baseAc = baseAc;
	}
	public int getDexHinderance() {
		return dexHinderance;
	}
	public void setDexHinderance(int dexHinderance) {
		this.dexHinderance = dexHinderance;
	}
	public Date getModDt() {
		return modDt;
	}
	public void setModDt(Date modDt) {
		this.modDt = modDt;
	}
	@Override
	public String toString() {
		return "ArmorBean [armorId=" + armorId + ", armorName=" + armorName
				+ ", baseAc=" + baseAc + ", dexHinderance=" + dexHinderance
				+ ", modDt=" + modDt + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (armorId ^ (armorId >>> 32));
		result = prime * result
				+ ((armorName == null) ? 0 : armorName.hashCode());
		result = prime * result + baseAc;
		result = prime * result + dexHinderance;
		result = prime * result + ((modDt == null) ? 0 : modDt.hashCode());
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
		ArmorBean other = (ArmorBean) obj;
		if (armorId != other.armorId)
			return false;
		if (armorName == null) {
			if (other.armorName != null)
				return false;
		} else if (!armorName.equals(other.armorName))
			return false;
		if (baseAc != other.baseAc)
			return false;
		if (dexHinderance != other.dexHinderance)
			return false;
		if (modDt == null) {
			if (other.modDt != null)
				return false;
		} else if (!modDt.equals(other.modDt))
			return false;
		return true;
	}
	
}
