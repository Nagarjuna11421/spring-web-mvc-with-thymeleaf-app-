package com.spring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MessageController {
	
	@GetMapping("/welcome")
	public ModelAndView getWelcome() {
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("message","Welcome to AshokIT. Welcome to Spring Web MVC Sessions");
		mav.setViewName("display");
		return mav;
	}
	
	@GetMapping("/greet")
//	@ResponseBody
	public String getGreet(Model model) {
		
		model.addAttribute("message", "Hello Hi, Good Morning Nagarjuna");
		
		return "display";
	}
	
	@GetMapping("/welcom")
	@ResponseBody
	public String getMessage() {
		
		return "Welcome to AshokIT - AND - welcome to Spring Web MVC";
	}

}
