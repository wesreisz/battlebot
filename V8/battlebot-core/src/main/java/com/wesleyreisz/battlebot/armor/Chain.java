package com.wesleyreisz.battlebot.armor;

public class Chain implements IArmor {
	private static final int AC_MODIFIER = 3;
	private static final int AC_DEXERITY_HINDERENCE = -2;

	@Override
	public int getArmorDexerityHinderenceModifier() {
		return AC_DEXERITY_HINDERENCE;
	}

	@Override
	public int getArmorClassModifer() {
		return AC_MODIFIER;
	}

}
