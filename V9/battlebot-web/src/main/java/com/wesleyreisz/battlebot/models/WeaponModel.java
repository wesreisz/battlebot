package com.wesleyreisz.battlebot.models;

import java.util.ArrayList;
import java.util.List;

public class WeaponModel {
	private String weaponName;
	private String weaponDescription;
	private List<String> weaponTypes;
	private List<String> weaponEffects;

	public String getWeaponName() {
		return weaponName;
	}

	public void setWeaponName(String weaponName) {
		this.weaponName = weaponName;
	}

	public String getWeaponDescription() {
		return weaponDescription;
	}

	public void setWeaponDescription(String weaponDescription) {
		this.weaponDescription = weaponDescription;
	}

	public List<String> getWeaponTypes() {
		return weaponTypes;
	}

	public void setWeaponTypes(List<String> weaponTypes) {
		this.weaponTypes = weaponTypes;
	}

	public List<String> getWeaponEffects() {
		return weaponEffects;
	}

	public void setWeaponEffects(List<String> weaponEffects) {
		this.weaponEffects = weaponEffects;
	}
	
}
