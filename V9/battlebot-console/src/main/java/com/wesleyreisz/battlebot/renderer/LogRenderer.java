package com.wesleyreisz.battlebot.renderer;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class LogRenderer implements MessageRenderer{
	private String location = "/Users/reiszwt/classes/architecture/Fall2012 (Bellarmine)/spring/projectBattle/battle.log";
	
	@Override
	public void render(String input) {
		try {
			FileWriter outFile = new FileWriter(location,true);
			PrintWriter out = new PrintWriter(outFile);
			out.println(input);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}
