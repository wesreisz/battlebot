package com.wesleyreisz.battlebot.armor;

public class Leather implements IArmor {
	private static final int AC_MODIFIER = 2;
	private static final int AC_DEXERITY_HINDERENCE = 0;

	@Override
	public int getArmorDexerityHinderenceModifier() {
		return AC_DEXERITY_HINDERENCE;
	}

	@Override
	public int getArmorClassModifer() {
		return AC_MODIFIER;
	}

}
