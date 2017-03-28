package com.plm.pt4.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerMapping;




@Controller
public class InteractionsController {

	Authentication auth = SecurityContextHolder.getContext().getAuthentication();

	@RequestMapping(value="/interacciones")
	public String getInteractions(Model model,HttpServletRequest request){
		
		model.addAttribute("urlIntrecations", request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE));
		
		return "interacciones";
	}

	

		
}
