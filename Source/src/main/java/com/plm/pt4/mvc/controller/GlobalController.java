package com.plm.pt4.mvc.controller;



import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.plm.pt4.mvc.bean.BeanGeneralSettings;
import com.plm.pt4.mvc.model.CustomUser;
import com.plm.pt4.mvc.model.TotalResult;
import com.plm.pt4.mvc.service.CalculatorsResponse;



@ControllerAdvice
public class GlobalController {
	
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/WEB-INF/spring/spring-import.xml");
	BeanGeneralSettings gSettings = (BeanGeneralSettings) context.getBean("beanGeneralSettings");
	
	@ModelAttribute
    public void addAttributes(Model model, HttpServletRequest request) {
		CalculatorsResponse calculatorsResponse = new CalculatorsResponse();
		model.addAttribute("calculators", calculatorsResponse.getCalculatorsByCategories());
        /*CAR */
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			try{
				CustomUser userDetails = (CustomUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			    model.addAttribute("UserNamePrincipal",userDetails.getFirstName()+ " "+userDetails.getLastName());
				model.addAttribute("gSettings",gSettings);
				model.addAttribute("uuid", userDetails.getUuid());
				model.addAttribute("isAddAddres",userDetails.isAddAddres());
				model.addAttribute("isUrlcompanyClient",userDetails.getUrlCompanyClient());
				
				if( request.getRequestURI().equals(request.getContextPath()+"/e-learning/pubmed")==false )
					userDetails.setListGetScientificArticlesResult( null );
				
				if(userDetails!=null){
					model.addAttribute("totalResult",userDetails);
					
				}else{
					TotalResult totalResultTmp = new TotalResult();
					//Medicamentos
					totalResultTmp.setTotalProducts( 0 );
					//Sustancias
					totalResultTmp.setTotalSubstances( 0 );
					//Laboratorios
					totalResultTmp.setTotalLabs( 0 );
					//ICD
					totalResultTmp.setTotalICD( 0 );
					//ATC
					totalResultTmp.setTotalATC( 0 );
					//Guias Clinicas
					totalResultTmp.setTotalGuideLines( 0 );
					//Prescripcion IM
					totalResultTmp.setTotalInteractions( 0 );
					//Prescripcion IM
					totalResultTmp.setTotalDDI( 0 );
					//Check Drugs
					totalResultTmp.setTotalSelectedDrugs( 0 );
					model.addAttribute("totalResult",totalResultTmp);
				}
				
			}catch(Exception ex){
				System.out.println(ex);
			}
		
		}else{
			model.addAttribute("gSettings",gSettings);
		}
		
	
	}

}
