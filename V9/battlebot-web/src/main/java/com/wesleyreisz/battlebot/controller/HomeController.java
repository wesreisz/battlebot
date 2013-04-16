package com.wesleyreisz.battlebot.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wesleyreisz.battlebot.utils.PageUtils;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest request,Locale locale, Model model) {
		logger.info("Welcome home! the client locale is "+ locale.toString());
		model.addAttribute("serverTime", PageUtils.getTime(locale));
		model.addAttribute("selectedTab", PageUtils.getSelectedTab(request.getRequestURI()));
		logger.info("selectedTab: " + PageUtils.getSelectedTab(request.getRequestURI()));
			
		return "home";
	}
	
}
