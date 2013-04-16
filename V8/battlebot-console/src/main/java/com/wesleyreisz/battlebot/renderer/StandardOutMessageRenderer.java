package com.wesleyreisz.battlebot.renderer;

import com.wesleyreisz.battlebot.renderer.MessageRenderer;

public class StandardOutMessageRenderer implements MessageRenderer {

	@Override
	public void render(String input) {
		System.out.println(input);
	}
}
