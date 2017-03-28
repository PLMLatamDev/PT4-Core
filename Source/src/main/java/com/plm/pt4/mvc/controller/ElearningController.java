package com.plm.pt4.mvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.plm.pt4.mvc.bean.BeanGeneralSettings;
import com.plm.pt4.mvc.model.CustomUser;
import com.plm.pt4.mvc.service.UtilitiesService;
import com.plmlatina.model.GetInformationByPrefixByTypeResult;
import com.plmlatina.model.GetScientificArticlesResult;

@Controller
@RequestMapping(value="/e-learning")
public class ElearningController {
	
	@Autowired
	UtilitiesService uService;
	
	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
	@RequestMapping(value="/pubmed", method=RequestMethod.GET)
	public String pubmed(Model model){
		CustomUser userDetails = (CustomUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		if( userDetails!=null ){
			if( userDetails.getListGetScientificArticlesResult()!=null ){
				model.addAttribute("listPubmed", userDetails.getListGetScientificArticlesResult());
				model.addAttribute("contentHeaderTitle", "Pubmed");
			}else{
				model.addAttribute("listPubmed", null);
				model.addAttribute("contentHeaderTitle", "Para inciar, teclee la sustancia activa en el buscador en la parte superior");
			}
		}
		model.addAttribute("contentHeaderSubtitle", "");
		return "pubmed";
	}


	@RequestMapping(value="/articulos", method = RequestMethod.POST)
	public @ResponseBody List<GetScientificArticlesResult> searchPubmed(@RequestParam(value = "substance") String substance, Model model){
		List<GetScientificArticlesResult> listScientificArticles = new ArrayList<GetScientificArticlesResult>();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			CustomUser userDetails = (CustomUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			listScientificArticles = uService.metadataServiceGetScientificArticles(substance);
			userDetails.setListGetScientificArticlesResult( listScientificArticles );
		}
		return listScientificArticles;
	}
	
	
	@RequestMapping(value="/abstracts", method = RequestMethod.GET)
	public String searchAbstracts(Model model){
		List<GetInformationByPrefixByTypeResult> listGetInformationByPrefixByTypeResult = new ArrayList<GetInformationByPrefixByTypeResult>();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			CustomUser userDetails = (CustomUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			listGetInformationByPrefixByTypeResult = uService.getInformationByPrefixByType();
			model.addAttribute("contentHeaderTitle", "Abstracts");
			model.addAttribute("contentHeaderSubtitle", "Referencia");
		}
		model.addAttribute("GetInformationByPrefixByTypeResult", listGetInformationByPrefixByTypeResult);
		return "abstracts";
	}
	
}
