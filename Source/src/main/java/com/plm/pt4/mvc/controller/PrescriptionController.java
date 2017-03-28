package com.plm.pt4.mvc.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.plm.pt4.mvc.bean.BeanGeneralSettings;
import com.plm.pt4.mvc.model.CustomUser;
import com.plm.pt4.mvc.model.SearchGeneral;
import com.plm.pt4.mvc.model.SelectedDrugs;
import com.plm.pt4.mvc.model.SuitabilityGroup;
import com.plm.pt4.mvc.model.TotalResult;
import com.plm.pt4.mvc.service.UtilitiesService;
import com.plmlatina.model.GetContraindicationsByProductsInfo;
import com.plmlatina.model.GetIMDDIProductInteractionSubstancesInfo;
import com.plmlatina.model.GetInteractionsByEditionProductsInfo;
import com.plmlatina.model.GetMealInteractionsByProductsInfo;
import com.plmlatina.result.ContraindicationsByProductsResponse;
import com.plmlatina.result.GetDefinedDailyDoseByDrugsResponse;
import com.plmlatina.result.GetPregnancyRisksByDrugsResponse;
import com.plmlatina.result.GetSubstanceIncompatibilitiesByProductsResponse;
import com.plmlatina.result.GetTherapeuticDoublenessByDrugsResponse;
import com.plmlatina.result.IMDDIProductInteractionSubstancesResponse;
import com.plmlatina.result.InteractionsByEditionProductsResponse;
import com.plmlatina.result.MealInteractionsByProductsResponse;


@Controller
@RequestMapping(value = "/EnginePrescription/")
public class PrescriptionController {
	
	@Autowired
	UtilitiesService uService;
	
	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/WEB-INF/spring/spring-import.xml");
	BeanGeneralSettings gSettings = (BeanGeneralSettings) context.getBean("beanGeneralSettings");
	
	private InteractionsByEditionProductsResponse[] listIM;
	private IMDDIProductInteractionSubstancesResponse[] listDDI;
	
	//Devuelve la lista de Objetos Seleccionados
	@RequestMapping(value = "/getSelectedDrugs", method = RequestMethod.GET)
	public @ResponseBody SearchGeneral getDrugs() {
		SearchGeneral searchGeneral = new SearchGeneral();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			CustomUser userDetails = (CustomUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			searchGeneral.setSelectedDrugs( userDetails.getSelectedDrugs() );
			if( userDetails.getSelectedDrugs()!=null )
				searchGeneral.setTotalSelectedDrugs( userDetails.getSelectedDrugs().size() );
			else
				searchGeneral.setTotalSelectedDrugs( 0 );
			
			if( userDetails.getArrayInteractionsByEditionProductsResponse()!=null )
				searchGeneral.setTotalInteractions( userDetails.getTotalInteractions() );
			else
				searchGeneral.setTotalInteractions( 0 );
			
			if( userDetails.getArrayIMDDIProductInteractionSubstancesResponse()!=null )
				searchGeneral.setTotalDDI( userDetails.getTotalDDI() );
			else
				searchGeneral.setTotalDDI( 0 );
		}
        return searchGeneral;
	}
         
	//Guarda la lista de objetos seleccionados
	@RequestMapping(value = "/saveSelected", method = RequestMethod.POST)
    public @ResponseBody SearchGeneral setDrugs(@RequestBody SelectedDrugs selectedDrug) {
		SearchGeneral searchGeneral = new SearchGeneral();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			CustomUser userDetails = (CustomUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			boolean exist = false;
			
			if( userDetails.getSelectedDrugs()!=null==false ){
				List<SelectedDrugs> listSelectedDrugs = new ArrayList<SelectedDrugs>();
				listSelectedDrugs.add( selectedDrug );
				userDetails.setSelectedDrugs( listSelectedDrugs );
			}
			
			for(int i = 0; i<userDetails.getSelectedDrugs().size(); i++){
				if(userDetails.getSelectedDrugs().get(i).getIPPA().equals(selectedDrug.getIPPA())){
					userDetails.getSelectedDrugs().remove(i);
					userDetails.getSelectedDrugs().add(selectedDrug);
	                exist = true;
	                break;
				}
			}
			if(userDetails.getSelectedDrugs().size() == 0){
				userDetails.getSelectedDrugs().add(selectedDrug);
	          	exist = true;
			}
			if(exist == false){
	          	
				userDetails.getSelectedDrugs().add(selectedDrug);
				exist = true;
	              
			}

			searchGeneral.setTotalSelectedDrugs( userDetails.getSelectedDrugs().size() );
			searchGeneral.setSelectedDrugs( userDetails.getSelectedDrugs() );
			
			userDetails.setTotalSelectedDrugs( userDetails.getSelectedDrugs().size() );
			userDetails.setSelectedDrugs( userDetails.getSelectedDrugs() );
						
		}	
			
		return searchGeneral;
    }
      
    //Elimina los objetos selecccionados
	@RequestMapping(value = "/deleteSelectedDrugs/{IPPA}", method = RequestMethod.GET)
	public @ResponseBody SearchGeneral deleteDrugs(@PathVariable(value="IPPA") String IPPA) {
		SearchGeneral searchGeneral = new SearchGeneral();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			CustomUser userDetails = (CustomUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			for(int i = 0; i<userDetails.getSelectedDrugs().size(); i++){
				if( IPPA.equals(userDetails.getSelectedDrugs().get(i).getIPPA()) ){
					userDetails.getSelectedDrugs().remove(i);
					break;
				}
			}
			userDetails.setTotalSelectedDrugs( userDetails.getSelectedDrugs().size() );
			searchGeneral.setTotalSelectedDrugs( userDetails.getSelectedDrugs().size() );
			if( userDetails.getSelectedDrugs().size()>0 && userDetails.getSelectedDrugs()!=null ){
				searchGeneral.setSelectedDrugs( userDetails.getSelectedDrugs() );
			}else{
				searchGeneral.setSelectedDrugs( null );
				userDetails.setSelectedDrugs( null );
			}	
			userDetails.setArrayInteractionsByEditionProductsResponse( null );
			userDetails.setArrayIMDDIProductInteractionSubstancesResponse( null );
			userDetails.setArrayContraindications( null );
			userDetails.setArrayMealInteractionsByProductsResponse( null );
			
			userDetails.setTotalDDI(0 );
			userDetails.setTotalInteractions( 0 );
			
			
		}
		
		return searchGeneral;
    }
	
	//Elimina todos los medicamentos
	@RequestMapping(value="/deleteAllSelectedDrugs", method = RequestMethod.GET)
    public @ResponseBody Boolean deleteAllDrug(){

		 
		 if (!(auth instanceof AnonymousAuthenticationToken)) {
				CustomUser userDetails = (CustomUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
				
				userDetails.setSelectedDrugs( null );
				userDetails.setArrayContraindications( null );
				userDetails.setArrayMealInteractionsByProductsResponse( null );
				userDetails.setArrayInteractionsByEditionProductsResponse( null );
				userDetails.setArrayIMDDIProductInteractionSubstancesResponse( null );
				
				userDetails.setIcd( null );
				userDetails.setLabs( null );
				userDetails.setAtc( null );
				userDetails.setSubstance( null );
				userDetails.setSubstances( null );
				userDetails.setProductInfo( null );
				userDetails.setGuides( null );
				userDetails.setReport(null);
				
				userDetails.setTotalATC( 0 );
				userDetails.setTotalICD( 0 );
				userDetails.setTotalInteractions( 0 );
				userDetails.setTotalProducts( 0 );
				userDetails.setTotalSelectedDrugs( 0 );
				userDetails.setTotalSubstances( 0 );
				userDetails.setTotalGuideLines( 0 );
				userDetails.setTotalDDI( 0 );
				userDetails.setTotalLabs( 0 );
				
		 }
		 return true;
    }
   
    
  	
  	/*******************************************
  	 * Métodos Asincronos
  	 * 
  	 *******************************************/
  	//saveWebsocketResponse
  	
  	@RequestMapping(value="/asyncInteractionsByEditionProducts",method=RequestMethod.POST)
  	public @ResponseBody Callable<SearchGeneral> setSearchGeneralByInteractionsByEditionProducts(@RequestBody InteractionsByEditionProductsResponse[] suitabilityGroup){
  		return new Callable<SearchGeneral>(){ 
  			@Override
  			public SearchGeneral call() throws Exception{
  				SearchGeneral searchGeneral = new SearchGeneral();
  				InteractionsByEditionProductsResponse[] interactionByProduct = null;
  				if (!(auth instanceof AnonymousAuthenticationToken)) {
  					CustomUser userDetails = (CustomUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
  					
  					int totalIM=0;
  					if( gSettings.getInteracciones().get("im") ){
  						interactionByProduct = suitabilityGroup;
  						if(interactionByProduct!=null){
  							System.out.println("InteractionByProduct: " + interactionByProduct.length);
  							for(InteractionsByEditionProductsResponse im:interactionByProduct  ){
  								if(im.getInteractionSubstances().size()>0){
  									totalIM++;
  								}
  							}
  						}
  					}
  					
  					userDetails.setTotalInteractions(totalIM);
  					userDetails.setArrayInteractionsByEditionProductsResponse( interactionByProduct );
  					
  					
  					searchGeneral.setTotalSelectedDrugs( userDetails.getTotalSelectedDrugs() );
  					searchGeneral.setTotalInteractions( userDetails.getTotalInteractions() );
  					searchGeneral.setTotalDDI( userDetails.getTotalDDI() );
  					searchGeneral.setArrayMealInteractionsByProductsResponse( userDetails.getArrayMealInteractionsByProductsResponse() );
  					searchGeneral.setArrayInteractionsByEditionProductsResponse( userDetails.getArrayInteractionsByEditionProductsResponse() );
  					searchGeneral.setArrayIMDDIProductInteractionSubstancesResponse( userDetails.getArrayIMDDIProductInteractionSubstancesResponse() );
  					searchGeneral.setArrayContraindications( userDetails.getArrayContraindications() );
  					searchGeneral.setArrayPregnancyRisksByDrugs( userDetails.getArrayPregnancyRisksByDrugs() );
  					searchGeneral.setArrayDefinedDailyDoseByDrugs( userDetails.getArrayDefinedDailyDoseByDrugs() );
  					searchGeneral.setArraySubstanceIncompatibilitiesByProductsResponse( userDetails.getArraySubstanceIncompatibilitiesByProductsResponse() );
  					searchGeneral.setArrayTherapeuticDoublenessByDrugsResponse( userDetails.getArrayTherapeuticDoublenessByDrugsResponse() );
  					searchGeneral.setSelectedDrugs( userDetails.getSelectedDrugs() );
  				}
  				return searchGeneral;
  			}
  		};
  	}
  	@RequestMapping(value="/asyncIMDDIProductInteractionSubstances",method=RequestMethod.POST)
  	public @ResponseBody Callable<SearchGeneral> setSearchGeneralByIMDDIProductInteractionSubstances(@RequestBody IMDDIProductInteractionSubstancesResponse[] suitabilityGroup){
  		return new Callable<SearchGeneral>(){ 
  			@Override
  			public SearchGeneral call() throws Exception{
  				SearchGeneral searchGeneral = new SearchGeneral();
  				IMDDIProductInteractionSubstancesResponse[] ddi = null;
  				if (!(auth instanceof AnonymousAuthenticationToken)) {
  					CustomUser userDetails = (CustomUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
  					
  					int totalDDI=0;
  					if( gSettings.getInteracciones().get("ddi") ){
  						ddi =  suitabilityGroup;
  						if( ddi!=null ){
  							System.out.println("DDI:" + ddi.length);
  							
  							for(IMDDIProductInteractionSubstancesResponse itemDDI:ddi  ){
  								if( itemDDI.getInteractionSubstances().size()>0 ){
  									totalDDI ++;
  								}
  							}
  						}
  					}
  					
  					
  					userDetails.setArrayIMDDIProductInteractionSubstancesResponse( ddi );
  					userDetails.setTotalDDI( totalDDI );
  					
  					searchGeneral.setTotalSelectedDrugs( userDetails.getTotalSelectedDrugs() );
  					searchGeneral.setTotalInteractions( userDetails.getTotalInteractions() );
  					searchGeneral.setTotalDDI( userDetails.getTotalDDI() );
  					searchGeneral.setArrayMealInteractionsByProductsResponse( userDetails.getArrayMealInteractionsByProductsResponse() );
  					searchGeneral.setArrayInteractionsByEditionProductsResponse( userDetails.getArrayInteractionsByEditionProductsResponse() );
  					searchGeneral.setArrayIMDDIProductInteractionSubstancesResponse( userDetails.getArrayIMDDIProductInteractionSubstancesResponse() );
  					searchGeneral.setArrayContraindications( userDetails.getArrayContraindications() );
  					searchGeneral.setArrayPregnancyRisksByDrugs( userDetails.getArrayPregnancyRisksByDrugs() );
  					searchGeneral.setArrayDefinedDailyDoseByDrugs( userDetails.getArrayDefinedDailyDoseByDrugs() );
  					searchGeneral.setArraySubstanceIncompatibilitiesByProductsResponse( userDetails.getArraySubstanceIncompatibilitiesByProductsResponse() );
  					searchGeneral.setArrayTherapeuticDoublenessByDrugsResponse( userDetails.getArrayTherapeuticDoublenessByDrugsResponse() );
  					searchGeneral.setSelectedDrugs( userDetails.getSelectedDrugs() );
  				}
  				return searchGeneral;
  			}
  		};
  	}
  	@RequestMapping(value="/asyncMealInteractionsByProducts",method=RequestMethod.POST)
  	public @ResponseBody Callable<SearchGeneral> setSearchGeneralByMealInteractionsByProducts(@RequestBody MealInteractionsByProductsResponse[] suitabilityGroup){
  		return new Callable<SearchGeneral>(){ 
  			@Override
  			public SearchGeneral call() throws Exception{
  				SearchGeneral searchGeneral = new SearchGeneral();
  				MealInteractionsByProductsResponse[] mealInteraction = null;
  				if (!(auth instanceof AnonymousAuthenticationToken)) {
  					CustomUser userDetails = (CustomUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
  					
  					int totalIM=0;
  					int totalDDI=0;
  					
  					if( gSettings.getInteracciones().get("ima") )
  						mealInteraction = suitabilityGroup;
  					
  					userDetails.setTotalDDI( totalDDI );
  					userDetails.setTotalInteractions(totalIM);
  					userDetails.setArrayMealInteractionsByProductsResponse( mealInteraction );
  					
  					
  					searchGeneral.setTotalSelectedDrugs( userDetails.getTotalSelectedDrugs() );
//  					searchGeneral.setTotalInteractions( userDetails.getTotalInteractions() );
//  					searchGeneral.setTotalDDI( userDetails.getTotalDDI() );
  					searchGeneral.setArrayMealInteractionsByProductsResponse( userDetails.getArrayMealInteractionsByProductsResponse() );
  					searchGeneral.setArrayInteractionsByEditionProductsResponse( userDetails.getArrayInteractionsByEditionProductsResponse() );
  					searchGeneral.setArrayIMDDIProductInteractionSubstancesResponse( userDetails.getArrayIMDDIProductInteractionSubstancesResponse() );
  					searchGeneral.setArrayContraindications( userDetails.getArrayContraindications() );
  					searchGeneral.setArrayPregnancyRisksByDrugs( userDetails.getArrayPregnancyRisksByDrugs() );
  					searchGeneral.setArrayDefinedDailyDoseByDrugs( userDetails.getArrayDefinedDailyDoseByDrugs() );
  					searchGeneral.setArraySubstanceIncompatibilitiesByProductsResponse( userDetails.getArraySubstanceIncompatibilitiesByProductsResponse() );
  					searchGeneral.setArrayTherapeuticDoublenessByDrugsResponse( userDetails.getArrayTherapeuticDoublenessByDrugsResponse() );
  					searchGeneral.setSelectedDrugs( userDetails.getSelectedDrugs() );
  				}
  				return searchGeneral;
  			}
  		};
  	}
  	@RequestMapping(value="/asyncContraindicationsByProducts",method=RequestMethod.POST)
  	public @ResponseBody Callable<SearchGeneral> setSearchGeneralByContraindicationsByProducts(@RequestBody ContraindicationsByProductsResponse[] suitabilityGroup){
  		return new Callable<SearchGeneral>(){ 
  			@Override
  			public SearchGeneral call() throws Exception{
		  		SearchGeneral searchGeneral = new SearchGeneral();
		  		ContraindicationsByProductsResponse[] contraindications = null;
		  		if (!(auth instanceof AnonymousAuthenticationToken)) {
					CustomUser userDetails = (CustomUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
					
					int totalIM=0;
			  		int totalDDI=0;
			  		
			  		if( gSettings.getInteracciones().get("con") ){
				  		contraindications = suitabilityGroup;
				  		if( contraindications!=null ){
							System.out.println("Contraindicaciones: " + contraindications.length);
							
				  		}
		  			}
			  		
			  		userDetails.setTotalDDI( totalDDI );
			  		
			  		userDetails.setTotalInteractions(totalIM);
			  		userDetails.setArrayContraindications( contraindications );
			  		
			  		searchGeneral.setTotalSelectedDrugs( userDetails.getTotalSelectedDrugs() );
//			  		searchGeneral.setTotalInteractions( userDetails.getTotalInteractions() );
//			  		searchGeneral.setTotalDDI( userDetails.getTotalDDI() );
			  		searchGeneral.setArrayMealInteractionsByProductsResponse( userDetails.getArrayMealInteractionsByProductsResponse() );
			  		searchGeneral.setArrayInteractionsByEditionProductsResponse( userDetails.getArrayInteractionsByEditionProductsResponse() );
			  		searchGeneral.setArrayIMDDIProductInteractionSubstancesResponse( userDetails.getArrayIMDDIProductInteractionSubstancesResponse() );
			  		searchGeneral.setArrayContraindications( userDetails.getArrayContraindications() );
			  		searchGeneral.setArrayPregnancyRisksByDrugs( userDetails.getArrayPregnancyRisksByDrugs() );
			  		searchGeneral.setArrayDefinedDailyDoseByDrugs( userDetails.getArrayDefinedDailyDoseByDrugs() );
			  		searchGeneral.setArraySubstanceIncompatibilitiesByProductsResponse( userDetails.getArraySubstanceIncompatibilitiesByProductsResponse() );
			  		searchGeneral.setArrayTherapeuticDoublenessByDrugsResponse( userDetails.getArrayTherapeuticDoublenessByDrugsResponse() );
			  		searchGeneral.setSelectedDrugs( userDetails.getSelectedDrugs() );
		  		}
		  		return searchGeneral;
  			}
  		};
  	}
  	
  	
  	//PregnancyRiskByDrugs
  	@RequestMapping(value="/PregnancyRiskByDrugs",method=RequestMethod.POST)
  	public @ResponseBody Callable<SearchGeneral> setSearchGeneralByPregnancyRiskByDrugs(@RequestBody GetPregnancyRisksByDrugsResponse[] suitabilityGroup){
  		return new Callable<SearchGeneral>(){ 
  			@Override
  			public SearchGeneral call() throws Exception{
		  		SearchGeneral searchGeneral = new SearchGeneral();
		  		GetPregnancyRisksByDrugsResponse[] pregnancyRisksByDrugs = null;
		  		if (!(auth instanceof AnonymousAuthenticationToken)) {
					CustomUser userDetails = (CustomUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
					
			  		if( gSettings.getInteracciones().get("re") ){
			  			pregnancyRisksByDrugs = suitabilityGroup;
				  		if( pregnancyRisksByDrugs!=null ){
							System.out.println("Riesgo en el embarazo: " + pregnancyRisksByDrugs.length);
				  		}
		  			}
			  		
			  		userDetails.setArrayPregnancyRisksByDrugs( pregnancyRisksByDrugs );
			  		
			  		searchGeneral.setTotalSelectedDrugs( userDetails.getTotalSelectedDrugs() );
//			  		searchGeneral.setTotalInteractions( userDetails.getTotalInteractions() );
//			  		searchGeneral.setTotalDDI( userDetails.getTotalDDI() );
			  		searchGeneral.setArrayMealInteractionsByProductsResponse( userDetails.getArrayMealInteractionsByProductsResponse() );
			  		searchGeneral.setArrayInteractionsByEditionProductsResponse( userDetails.getArrayInteractionsByEditionProductsResponse() );
			  		searchGeneral.setArrayIMDDIProductInteractionSubstancesResponse( userDetails.getArrayIMDDIProductInteractionSubstancesResponse() );
			  		searchGeneral.setArrayContraindications( userDetails.getArrayContraindications() );
			  		searchGeneral.setArrayPregnancyRisksByDrugs( userDetails.getArrayPregnancyRisksByDrugs() );
			  		searchGeneral.setArrayDefinedDailyDoseByDrugs( userDetails.getArrayDefinedDailyDoseByDrugs() );
			  		searchGeneral.setArraySubstanceIncompatibilitiesByProductsResponse( userDetails.getArraySubstanceIncompatibilitiesByProductsResponse() );
			  		searchGeneral.setArrayTherapeuticDoublenessByDrugsResponse( userDetails.getArrayTherapeuticDoublenessByDrugsResponse() );
			  		searchGeneral.setSelectedDrugs( userDetails.getSelectedDrugs() );
		  		}
		  		return searchGeneral;
  			}
  		};
  	}
  	//DDD
  	@RequestMapping(value="/DefinedDailyDoseByDrugs",method=RequestMethod.POST)
  	public @ResponseBody Callable<SearchGeneral> setSearchGeneralByDefinedDailyDoseByDrugs(@RequestBody GetDefinedDailyDoseByDrugsResponse[] suitabilityGroup){
  		return new Callable<SearchGeneral>(){ 
  			@Override
  			public SearchGeneral call() throws Exception{
		  		SearchGeneral searchGeneral = new SearchGeneral();
		  		GetDefinedDailyDoseByDrugsResponse[] ddd = null;
		  		if (!(auth instanceof AnonymousAuthenticationToken)) {
					CustomUser userDetails = (CustomUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
					
					
			  		if( gSettings.getInteracciones().get("ddd") ){
			  			ddd = suitabilityGroup;
				  		if( ddd!=null ){
							System.out.println("Dosis Diaria Definida: " + ddd.length);
				  		}
		  			}
			  		
			  		
			  		
			  		userDetails.setArrayDefinedDailyDoseByDrugs(ddd);
			  		
			  		searchGeneral.setTotalSelectedDrugs( userDetails.getTotalSelectedDrugs() );
//			  		searchGeneral.setTotalInteractions( userDetails.getTotalInteractions() );
//			  		searchGeneral.setTotalDDI( userDetails.getTotalDDI() );
			  		searchGeneral.setArrayMealInteractionsByProductsResponse( userDetails.getArrayMealInteractionsByProductsResponse() );
			  		searchGeneral.setArrayInteractionsByEditionProductsResponse( userDetails.getArrayInteractionsByEditionProductsResponse() );
			  		searchGeneral.setArrayIMDDIProductInteractionSubstancesResponse( userDetails.getArrayIMDDIProductInteractionSubstancesResponse() );
			  		searchGeneral.setArrayContraindications( userDetails.getArrayContraindications() );
			  		searchGeneral.setArrayPregnancyRisksByDrugs( userDetails.getArrayPregnancyRisksByDrugs() );
			  		searchGeneral.setArrayDefinedDailyDoseByDrugs( userDetails.getArrayDefinedDailyDoseByDrugs() );
			  		searchGeneral.setArraySubstanceIncompatibilitiesByProductsResponse( userDetails.getArraySubstanceIncompatibilitiesByProductsResponse() );
			  		searchGeneral.setArrayTherapeuticDoublenessByDrugsResponse( userDetails.getArrayTherapeuticDoublenessByDrugsResponse() );
			  		searchGeneral.setSelectedDrugs( userDetails.getSelectedDrugs() );
		  		}
		  		return searchGeneral;
  			}
  		};
  	}
  	//SubstanceIncompatibilitiesByProducts
  	@RequestMapping(value="/SubstanceIncompatibilitiesByProducts",method=RequestMethod.POST)
  	public @ResponseBody Callable<SearchGeneral> setSubstanceIncompatibilitiesByProducts(@RequestBody GetSubstanceIncompatibilitiesByProductsResponse[] suitabilityGroup){
  		return new Callable<SearchGeneral>(){ 
  			@Override
  			public SearchGeneral call() throws Exception{
  				SearchGeneral searchGeneral = new SearchGeneral();
  				GetSubstanceIncompatibilitiesByProductsResponse[] substanceIncompatibilitiesByProductsResponse = null;
  				if (!(auth instanceof AnonymousAuthenticationToken)) {
  					CustomUser userDetails = (CustomUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
  					
  					
  					if( gSettings.getInteracciones().get("ifq") ){
  						substanceIncompatibilitiesByProductsResponse = suitabilityGroup;
  						if( substanceIncompatibilitiesByProductsResponse!=null ){
  							System.out.println("Incompatibilidades Fisico Quimicas: " + substanceIncompatibilitiesByProductsResponse.length);
  						}
  					}
  					
  					userDetails.setArraySubstanceIncompatibilitiesByProductsResponse( substanceIncompatibilitiesByProductsResponse );
  					
  					searchGeneral.setTotalSelectedDrugs( userDetails.getTotalSelectedDrugs() );
//  					searchGeneral.setTotalInteractions( userDetails.getTotalInteractions() );
//  					searchGeneral.setTotalDDI( userDetails.getTotalDDI() );
  					searchGeneral.setArrayMealInteractionsByProductsResponse( userDetails.getArrayMealInteractionsByProductsResponse() );
  					searchGeneral.setArrayInteractionsByEditionProductsResponse( userDetails.getArrayInteractionsByEditionProductsResponse() );
  					searchGeneral.setArrayIMDDIProductInteractionSubstancesResponse( userDetails.getArrayIMDDIProductInteractionSubstancesResponse() );
  					searchGeneral.setArrayContraindications( userDetails.getArrayContraindications() );
  					searchGeneral.setArrayPregnancyRisksByDrugs( userDetails.getArrayPregnancyRisksByDrugs() );
  					searchGeneral.setArrayDefinedDailyDoseByDrugs( userDetails.getArrayDefinedDailyDoseByDrugs() );
  					searchGeneral.setArraySubstanceIncompatibilitiesByProductsResponse( userDetails.getArraySubstanceIncompatibilitiesByProductsResponse() );
  					searchGeneral.setArrayTherapeuticDoublenessByDrugsResponse( userDetails.getArrayTherapeuticDoublenessByDrugsResponse() );
  					searchGeneral.setSelectedDrugs( userDetails.getSelectedDrugs() );
  				}
  				return searchGeneral;
  			}
  		};
  	}
  	//TherapeuticDoublenessByDrugs
  	@RequestMapping(value="/TherapeuticDoublenessByDrugs",method=RequestMethod.POST)
  	public @ResponseBody Callable<SearchGeneral> setSubstanceIncompatibilitiesByProducts(@RequestBody GetTherapeuticDoublenessByDrugsResponse[] suitabilityGroup){
  		return new Callable<SearchGeneral>(){ 
  			@Override
  			public SearchGeneral call() throws Exception{
  				SearchGeneral searchGeneral = new SearchGeneral();
  				GetTherapeuticDoublenessByDrugsResponse[] therapeuticDoublenessByDrugsResponse = null;
  				if (!(auth instanceof AnonymousAuthenticationToken)) {
  					CustomUser userDetails = (CustomUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
  					
  					if( gSettings.getInteracciones().get("dt") ){
  						therapeuticDoublenessByDrugsResponse = suitabilityGroup;
  						if( therapeuticDoublenessByDrugsResponse!=null ){
  							System.out.println("Duplicidad Terapeutica: " + therapeuticDoublenessByDrugsResponse.length);
  						}
  					}
  					
  					userDetails.setArrayTherapeuticDoublenessByDrugsResponse( therapeuticDoublenessByDrugsResponse );
  					
  					searchGeneral.setTotalSelectedDrugs( userDetails.getTotalSelectedDrugs() );
//  					searchGeneral.setTotalInteractions( userDetails.getTotalInteractions() );
//  					searchGeneral.setTotalDDI( userDetails.getTotalDDI() );
  					searchGeneral.setArrayMealInteractionsByProductsResponse( userDetails.getArrayMealInteractionsByProductsResponse() );
  					searchGeneral.setArrayInteractionsByEditionProductsResponse( userDetails.getArrayInteractionsByEditionProductsResponse() );
  					searchGeneral.setArrayIMDDIProductInteractionSubstancesResponse( userDetails.getArrayIMDDIProductInteractionSubstancesResponse() );
  					searchGeneral.setArrayContraindications( userDetails.getArrayContraindications() );
  					searchGeneral.setArrayPregnancyRisksByDrugs( userDetails.getArrayPregnancyRisksByDrugs() );
  					searchGeneral.setArrayDefinedDailyDoseByDrugs( userDetails.getArrayDefinedDailyDoseByDrugs() );
  					searchGeneral.setArraySubstanceIncompatibilitiesByProductsResponse( userDetails.getArraySubstanceIncompatibilitiesByProductsResponse() );
  					searchGeneral.setArrayTherapeuticDoublenessByDrugsResponse( userDetails.getArrayTherapeuticDoublenessByDrugsResponse() );
  					searchGeneral.setSelectedDrugs( userDetails.getSelectedDrugs() );
  				}
  				return searchGeneral;
  			}
  		};
  	}
  	
  	
  	//getuitabilityGroup
  	@RequestMapping(value="/getSuitabilityGroup",method=RequestMethod.POST)
  	public @ResponseBody SearchGeneral getSuitabilityGroup(){
  		
  		SearchGeneral searchGeneral = new SearchGeneral();
  		if (!(auth instanceof AnonymousAuthenticationToken)) {
			CustomUser userDetails = (CustomUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			searchGeneral.setTotalSelectedDrugs( userDetails.getTotalSelectedDrugs() );
	  		searchGeneral.setTotalInteractions( userDetails.getTotalInteractions() );
	  		searchGeneral.setTotalDDI( userDetails.getTotalDDI() );
	  		searchGeneral.setArrayMealInteractionsByProductsResponse( userDetails.getArrayMealInteractionsByProductsResponse() );
	  		searchGeneral.setArrayInteractionsByEditionProductsResponse( userDetails.getArrayInteractionsByEditionProductsResponse() );
	  		searchGeneral.setArrayIMDDIProductInteractionSubstancesResponse( userDetails.getArrayIMDDIProductInteractionSubstancesResponse() );
	  		searchGeneral.setArrayContraindications( userDetails.getArrayContraindications() );
	  		searchGeneral.setArrayPregnancyRisksByDrugs( userDetails.getArrayPregnancyRisksByDrugs() );
	  		searchGeneral.setArrayDefinedDailyDoseByDrugs( userDetails.getArrayDefinedDailyDoseByDrugs() );
	  		searchGeneral.setArraySubstanceIncompatibilitiesByProductsResponse( userDetails.getArraySubstanceIncompatibilitiesByProductsResponse() );
			searchGeneral.setArrayTherapeuticDoublenessByDrugsResponse( userDetails.getArrayTherapeuticDoublenessByDrugsResponse() );
	  		searchGeneral.setSelectedDrugs( userDetails.getSelectedDrugs() );
  		}
  		
  		return searchGeneral;
  	}

}
