package com.wesleyreisz.battlebot.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.wesleyreisz.battlebot.models.WeaponModel;
import com.wesleyreisz.battlebot.service.IWeaponService;
import com.wesleyreisz.battlebot.utils.PageUtils;

@Controller
public class WeaponController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Inject
	private IWeaponService weaponService;
	
	@RequestMapping(value = "/weapons", method = RequestMethod.GET)
	public String listWeapon(HttpServletRequest request, Locale locale, Model model) {
		logger.info("Inside controller for weapon view");
		model.addAttribute("serverTime", PageUtils.getTime(locale));
		model.addAttribute("selectedTab", PageUtils.getSelectedTab(request.getRequestURI()));
		logger.info("selectedTab: " + PageUtils.getSelectedTab(request.getRequestURI()));
		
		model.addAttribute("weaponsList", weaponService.getList());
		
		return "weapons/view";
	}
	
	@RequestMapping(value = "/weapons/edit", method = RequestMethod.GET)
	public ModelAndView editWeapon(HttpServletRequest request, Locale locale, Model model) {
		logger.info("Inside controller for weapon view");
		model.addAttribute("serverTime", PageUtils.getTime(locale));
		model.addAttribute("selectedTab", PageUtils.getSelectedTab(request.getRequestURI()));
		logger.info("selectedTab: " + PageUtils.getSelectedTab(request.getRequestURI()));
		
		model.addAttribute("weaponsList", weaponService.getList());
		
		return new ModelAndView("weapons/edit", "command", new WeaponModel());
	}
	
	@RequestMapping(value = "/weapons/add", method = RequestMethod.GET)
	public String add(HttpServletRequest request, Locale locale, Model model) {
		logger.info("Inside controller for weapon view");
		model.addAttribute("serverTime", PageUtils.getTime(locale));
		model.addAttribute("selectedTab", PageUtils.getSelectedTab(request.getRequestURI()));
		logger.info("selectedTab: " + PageUtils.getSelectedTab(request.getRequestURI()));
		
		model.addAttribute("command", new WeaponModel());
		model.addAttribute("weaponTypes", weaponService.getList());
		String[] effects = {"Fire", "Cold"};
		model.addAttribute("weaponEffects", effects);
		
		return "weapons/add";
	}
	
	@RequestMapping(value = "/weapons/addWeapon", method = RequestMethod.POST)
	public String addWeapon(@ModelAttribute("weapon")WeaponModel weapon, Locale locale, Model model) {
		logger.info("Inside controller for saving weapon");
		
		model.addAttribute("serverTime", PageUtils.getTime(locale));
		model.addAttribute("weaponsList", weaponService.getList());
		return "weapons/view";
	}

	
	public void setWeaponService(IWeaponService weaponService) {
		this.weaponService = weaponService;
	}
}
