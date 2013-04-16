package com.wesleyreisz.battlebot;

public enum Dice {
	D4(4), D6(6), D8(8), D10(10), D12(12), D20(20), D100(100);
	private int code;
	 
	 private Dice(int c) {
	   code = c;
	 }
	 
	 public int getSideNumber() {
	   return code;
	 }
}