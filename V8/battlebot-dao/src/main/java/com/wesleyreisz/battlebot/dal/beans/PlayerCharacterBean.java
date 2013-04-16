package com.wesleyreisz.battlebot.dal.beans;

import java.util.Date;

public class PlayerCharacterBean {
	private long playerCharacterId;
	private String playerCharacterName;
	private Date modDt;
	private int maxHp;
	private int currentHp;
	private long armorId;
	private long weaponId;
	private long experience;
	private long gold;
	public long getPlayerCharacterId() {
		return playerCharacterId;
	}
	public void setPlayerCharacterId(long playerCharacterId) {
		this.playerCharacterId = playerCharacterId;
	}
	public String getPlayerCharacterName() {
		return playerCharacterName;
	}
	public void setPlayerCharacterName(String playerCharacterName) {
		this.playerCharacterName = playerCharacterName;
	}
	public Date getModDt() {
		return modDt;
	}
	public void setModDt(Date modDt) {
		this.modDt = modDt;
	}
	public int getMaxHp() {
		return maxHp;
	}
	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}
	public int getCurrentHp() {
		return currentHp;
	}
	public void setCurrentHp(int currentHp) {
		this.currentHp = currentHp;
	}
	public long getArmorId() {
		return armorId;
	}
	public void setArmorId(long armorId) {
		this.armorId = armorId;
	}
	public long getWeaponId() {
		return weaponId;
	}
	public void setWeaponId(long weaponId) {
		this.weaponId = weaponId;
	}
	public long getExperience() {
		return experience;
	}
	public void setExperience(long experience) {
		this.experience = experience;
	}
	public long getGold() {
		return gold;
	}
	public void setGold(long gold) {
		this.gold = gold;
	}
	@Override
	public String toString() {
		return "PlayerCharacterBean [playerCharacterId=" + playerCharacterId
				+ ", playerCharacterName=" + playerCharacterName + ", modDt="
				+ modDt + ", maxHp=" + maxHp + ", currentHp=" + currentHp
				+ ", armorId=" + armorId + ", weaponId=" + weaponId
				+ ", experience=" + experience + ", gold=" + gold + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (armorId ^ (armorId >>> 32));
		result = prime * result + currentHp;
		result = prime * result + (int) (experience ^ (experience >>> 32));
		result = prime * result + (int) (gold ^ (gold >>> 32));
		result = prime * result + maxHp;
		result = prime * result + ((modDt == null) ? 0 : modDt.hashCode());
		result = prime * result
				+ (int) (playerCharacterId ^ (playerCharacterId >>> 32));
		result = prime
				* result
				+ ((playerCharacterName == null) ? 0 : playerCharacterName
						.hashCode());
		result = prime * result + (int) (weaponId ^ (weaponId >>> 32));
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
		PlayerCharacterBean other = (PlayerCharacterBean) obj;
		if (armorId != other.armorId)
			return false;
		if (currentHp != other.currentHp)
			return false;
		if (experience != other.experience)
			return false;
		if (gold != other.gold)
			return false;
		if (maxHp != other.maxHp)
			return false;
		if (modDt == null) {
			if (other.modDt != null)
				return false;
		} else if (!modDt.equals(other.modDt))
			return false;
		if (playerCharacterId != other.playerCharacterId)
			return false;
		if (playerCharacterName == null) {
			if (other.playerCharacterName != null)
				return false;
		} else if (!playerCharacterName.equals(other.playerCharacterName))
			return false;
		if (weaponId != other.weaponId)
			return false;
		return true;
	}
}
