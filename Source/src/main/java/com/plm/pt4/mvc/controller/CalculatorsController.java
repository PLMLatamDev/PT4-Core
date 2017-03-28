package com.plm.pt4.mvc.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.plm.pt4.mvc.bean.BeanGeneralSettings;
import com.plm.pt4.mvc.service.CalculatorsResponse;

@Controller
@RequestMapping(value = "/calculadoras")
public class CalculatorsController {
  
	
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/WEB-INF/spring/spring-import.xml");
	BeanGeneralSettings gSettings = (BeanGeneralSettings) context.getBean("beanGeneralSettings");
	
	@RequestMapping(value="/{category}/{calculatorName}/{categoryId}/{calculatorId}", method=RequestMethod.GET)
	public String calculatorViewResolverByCategory(@PathVariable("calculatorName") String calculatorName, @PathVariable("category") String category, @PathVariable("categoryId") int categoryId, @PathVariable("calculatorId") int calculatorId, Model model, HttpServletRequest request, HttpServletResponse response, HttpSession dd) throws IOException{
        dd.setAttribute("name", gSettings.getCountry());
//		String urlContext = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
//				+ request.getContextPath() + "/resources/data/calculadoras.json";

		CalculatorsResponse calculatorsResponse = new CalculatorsResponse();
		
		for(int i =0 ; i<calculatorsResponse.getCalculatorsByCategories().size();i++){
		  for(int j = 0; j<calculatorsResponse.getCalculatorsByCategories().get(i).getCalculators().size();j++){
			if(calculatorsResponse.getCalculatorsByCategories().get(i).isCategoryActive()==true){
			  if(calculatorsResponse.getCalculatorsByCategories().get(i).getCategoryId() == categoryId){
				if(calculatorsResponse.getCalculatorsByCategories().get(i).getCalculators().get(j).getId() == calculatorId){
					model.addAttribute("contentHeaderTitle", calculatorsResponse.getCalculatorsByCategories().get(i).getCalculators().get(j).getName());
					model.addAttribute("contentHeaderSubtitle", calculatorsResponse.getCalculatorsByCategories().get(i).getCategoryName());
				}
			  }
			}else{
				if(calculatorsResponse.getCalculatorsByCategories().get(i).getCalculators().get(j).getId() == calculatorId){
					model.addAttribute("contentHeaderTitle", calculatorsResponse.getCalculatorsByCategories().get(i).getCalculators().get(j).getName());
					model.addAttribute("contentHeaderSubtitle", "");
				}
			}
		 }
		}
    		   
		return calculatorName;
	}
	
	@RequestMapping(value="/{calculatorName}/{categoryId}/{calculatorId}", method=RequestMethod.GET)
	public String calculatorViewResolver(@PathVariable("calculatorName") String calculatorName, @PathVariable("categoryId") int categoryId, @PathVariable("calculatorId") int calculatorId, Model model, HttpServletRequest request, HttpServletResponse response, HttpSession dd) throws IOException{
        dd.setAttribute("name", gSettings.getCountry());
//		String urlContext = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
//				+ request.getContextPath() + "/resources/data/calculadoras.json";

		CalculatorsResponse calculatorsResponse = new CalculatorsResponse();
		
		for(int i =0 ; i<calculatorsResponse.getCalculatorsByCategories().size();i++){
		  for(int j = 0; j<calculatorsResponse.getCalculatorsByCategories().get(i).getCalculators().size();j++){
			if(calculatorsResponse.getCalculatorsByCategories().get(i).isCategoryActive()==true){
			  if(calculatorsResponse.getCalculatorsByCategories().get(i).getCategoryId() == categoryId){
				if(calculatorsResponse.getCalculatorsByCategories().get(i).getCalculators().get(j).getId() == calculatorId){
					model.addAttribute("contentHeaderTitle", calculatorsResponse.getCalculatorsByCategories().get(i).getCalculators().get(j).getName());
					model.addAttribute("contentHeaderSubtitle", calculatorsResponse.getCalculatorsByCategories().get(i).getCategoryName());
				}
			  }
			}else{
				if(calculatorsResponse.getCalculatorsByCategories().get(i).getCalculators().get(j).getId() == calculatorId){
					model.addAttribute("contentHeaderTitle", calculatorsResponse.getCalculatorsByCategories().get(i).getCalculators().get(j).getName());
					model.addAttribute("contentHeaderSubtitle", "");
				}
			}
		 }
		}
    		   
		return calculatorName;
	}
}
