package com.wesleyreisz.battlebot.armor;

public class Plate implements IArmor {
	private static final int AC_MODIFIER = 4;
	private static final int AC_DEXERITY_HINDERENCE = -3;

	@Override
	public int getArmorDexerityHinderenceModifier() {
		return AC_DEXERITY_HINDERENCE;
	}

	@Override
	public int getArmorClassModifer() {
		return AC_MODIFIER;
	}

}
