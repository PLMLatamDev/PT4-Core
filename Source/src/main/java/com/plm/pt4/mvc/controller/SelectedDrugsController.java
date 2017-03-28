package com.plm.pt4.mvc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.plm.pt4.mvc.bean.BeanGeneralSettings;
import com.plm.pt4.mvc.model.*;
import com.plmlatina.result.ContraindicationsByProductsResponse;
import com.plmlatina.result.IMDDIProductInteractionSubstancesResponse;
import com.plmlatina.result.InteractionsByEditionProductsResponse;
import com.plmlatina.result.MealInteractionsByProductsResponse;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController
@RequestMapping(value = "/ServiceSelectedDrugs")
@SessionAttributes("listSelectedDrugs")
public class SelectedDrugsController {
      
      
	@ModelAttribute("listSelectedDrugs")
	List<SelectedDrugs> getListSelectedDrugs() {
	  return new ArrayList<SelectedDrugs>();
	}
	
	@RequestMapping(value = "/getSelectedDrugs", method = RequestMethod.GET)
	public List<SelectedDrugs> getDrugs(@ModelAttribute("listSelectedDrugs") List<SelectedDrugs> selectedDrugs) {
	  
        return selectedDrugs;
	}
         
      @RequestMapping(value = "/saveSelectedDrugs", method = RequestMethod.POST)
      public List<SelectedDrugs> setDrugs(@RequestBody SelectedDrugs selectedDrug, HttpServletRequest request, HttpSession session, Model model,@ModelAttribute("listSelectedDrugs") List<SelectedDrugs> listSelectedDrugs) {
            boolean exist = false;
            for(int i = 0; i<listSelectedDrugs.size(); i++){
                if(listSelectedDrugs.get(i).getIPPA().equals(selectedDrug.getIPPA())){
                	listSelectedDrugs.remove(i);
                	listSelectedDrugs.add(selectedDrug);
                    exist = true;
                    break;
                }
            }
            if(listSelectedDrugs.size() == 0){
            	listSelectedDrugs.add(selectedDrug);
            	exist = true;
            }
            if(exist == false){
            	
            	listSelectedDrugs.add(selectedDrug);
                	exist = true;
                
            }
            SearchGeneral resultList = (SearchGeneral)request.getSession().getAttribute("sessionResultsDetailResult");
            TotalResult totalResult = (TotalResult)request.getSession().getAttribute("sessionTotalResult");
            totalResult.setTotalSelectedDrugs( listSelectedDrugs.size() );
            resultList.setSelectedDrugs( listSelectedDrugs );
            return listSelectedDrugs;
      }
      
      @RequestMapping(value = "/deleteSelectedDrugs/{IPPA}", method = RequestMethod.GET)
      public List<SelectedDrugs> deleteDrugs(@PathVariable(value="IPPA") String IPPA, @ModelAttribute("listSelectedDrugs") List<SelectedDrugs> selectedDrugs, HttpServletRequest request, HttpSession session) {
            for(int i = 0; i<selectedDrugs.size(); i++){
                  if(IPPA.equals(selectedDrugs.get(i).getIPPA())){
                        selectedDrugs.remove(i);
                        break;
                  }
            }
            TotalResult totalResult = (TotalResult)request.getSession().getAttribute("sessionTotalResult");
            SearchGeneral resultList = (SearchGeneral)request.getSession().getAttribute("sessionResultsDetailResult");
            totalResult.setTotalDDI( 0 );
            totalResult.setTotalInteractions( 0 );
            totalResult.setTotalSelectedDrugs( selectedDrugs.size() );
            resultList.setSelectedDrugs( selectedDrugs );
            
            if( selectedDrugs.size()<1 ){
            	ContraindicationsByProductsResponse[] con = {};
            	MealInteractionsByProductsResponse[]  meal = {};
            	InteractionsByEditionProductsResponse[] im = {};
            	IMDDIProductInteractionSubstancesResponse[] ddi= {};
            	resultList.setArrayContraindications( con );
            	resultList.setArrayMealInteractionsByProductsResponse( meal );
            	resultList.setArrayInteractionsByEditionProductsResponse( im );
            	resultList.setArrayIMDDIProductInteractionSubstancesResponse( ddi );
            }
            
            return selectedDrugs;
      }
      
}
