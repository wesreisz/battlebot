package com.wesleyreisz.battlebot.armor;

public class NoArmor implements IArmor {
	private static final int AC_MODIFIER = 0;
	private static final int AC_DEXERITY_HINDERENCE = -0;

	@Override
	public int getArmorDexerityHinderenceModifier() {
		return AC_DEXERITY_HINDERENCE;
	}

	@Override
	public int getArmorClassModifer() {
		return AC_MODIFIER;
	}

}
