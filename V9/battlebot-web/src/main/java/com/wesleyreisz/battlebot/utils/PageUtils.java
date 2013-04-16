package com.wesleyreisz.battlebot.utils;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class PageUtils {
	public static String getTime(Locale locale){
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		return dateFormat.format(date);
	}
	public static String getSelectedTab(String uri){
		if (uri == null){return "MAIN";} //check for npe
		
		if (uri.contains("/battlebot-web/weapons")){
			return "WEAPONS";
		}else if(uri.contains("/battlebot-web/armor")){
			return "ARMOR";
		}else if(uri.contains("/battlebot-web/players")){
			return "PLAYERS";
		}else if(uri.contains("/battlebot-web/battle")){
			return "BATTLE";
		}else{
			return "MAIN";
		}
	}
}
