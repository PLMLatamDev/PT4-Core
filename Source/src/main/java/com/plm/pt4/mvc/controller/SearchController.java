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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.plm.pt4.mvc.bean.BeanGeneralSettings;
import com.plm.pt4.mvc.model.CustomUser;
import com.plm.pt4.mvc.service.UtilitiesService;
import com.plmlatina.model.AveragePrice;
import com.plmlatina.model.GetDrugShortInformationResult;
import com.plmlatina.model.GetDrugsDetailByTherapeuticResult;
import com.plmlatina.model.GetDrugsShortDetailByICDResult;
import com.plmlatina.model.GetDrugsShortDetailByLabResult;
import com.plmlatina.model.GetDrugsShortDetailBySubstanceResult;
import com.plmlatina.model.GetICDResult;
import com.plmlatina.model.GetMedicalGuidelinesByTextResult;
import com.plmlatina.model.GetResultsDetailAndGetMedicalGuidelinesByTextAndGetTherapeuticsInfo;
import com.plmlatina.model.GetResultsDetailResult;
import com.plmlatina.model.ICD;
import com.plmlatina.model.Lab;
import com.plmlatina.model.Presentation;
import com.plmlatina.model.ProductInfo;
import com.plmlatina.model.Substance;
import com.plmlatina.model.Substance_;
import com.plmlatina.model.Therapeutic;

@Controller
@RequestMapping(value="/busqueda")
public class SearchController {
	
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/WEB-INF/spring/spring-import.xml");
	BeanGeneralSettings gSettings = (BeanGeneralSettings) context.getBean("beanGeneralSettings");
	
	@Autowired
	UtilitiesService uService;
	
	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
	//Producto por autocomplete
	@RequestMapping(value="/medicamentos-busqueda/{divisionId}/{categoryId}/{pharmaFormId}/{drugId}", method=RequestMethod.GET)
	public String searchDrugs(@PathVariable("divisionId") int divisionId,
							  @PathVariable("categoryId") int categoryId,
							  @PathVariable("pharmaFormId") int pharmaFormId,
							  @PathVariable("drugId") int drugId,
							  Model model
							  ){
	
		int p = 0, noP = 0;
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			CustomUser userDetails = (CustomUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			GetDrugShortInformationResult productsByDrug = uService.pharmaSearchGetDrugShortInformation(divisionId, categoryId,drugId,pharmaFormId);
			List<ProductInfo> listP = new ArrayList<ProductInfo>();
			ProductInfo product = new ProductInfo();
			
			if(productsByDrug!=null){
				
				
				userDetails.setProductInfo(null);
				
				userDetails.setLabs( null );
				userDetails.setSubstances( null );
				userDetails.setIcd( null );
				userDetails.setAtc( null );
				userDetails.setGuides( null );
				
				product.setCategotyId( productsByDrug.getCategotyId() );
				product.setDivisionId( productsByDrug.getDivisionId() );
				product.setProductId( productsByDrug.getProductId() );
				product.setPharmaFormId( productsByDrug.getPharmaFormId() );
				product.setBrand( productsByDrug.getBrand() );
				product.setSubstances( productsByDrug.getSubstances() );
				product.setPharmaForm( productsByDrug.getPharmaForm() );
				product.setDivisionShortName( productsByDrug.getDivisionShortName() );
				product.setPresentations( productsByDrug.getPresentations() );
			
			
				listP.add(product);
				userDetails.setProductInfo(listP);
				
				if( productsByDrug.getPresentations().size()<1 ){
					noP++;
				}else{
					p = productsByDrug.getPresentations().size();
				}
				
				userDetails.setTotalProducts( p+noP );
				userDetails.setTotalSubstances( 0 );
				userDetails.setTotalLabs( 0 );
				userDetails.setTotalICD( 0 );
				userDetails.setTotalATC( 0 );
				userDetails.setTotalGuideLines( 0 );
				
				model.addAttribute("totalResult", userDetails);
				model.addAttribute("productsResult",userDetails.getProductInfo());
			}
			
		}
		
		model.addAttribute("contentHeaderTitle", "Medicamentos");
		return "medicamentos-busqueda";
	}
		
	//Laboratorio por autocomplete
	@RequestMapping(value="/medicamentos-laboratorio/{divisionId}",method=RequestMethod.GET)
	public String searchLabs(@PathVariable("divisionId") int divisionId, Model model){

		if (!(auth instanceof AnonymousAuthenticationToken)) {
			CustomUser userDetails = (CustomUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			List<GetDrugsShortDetailByLabResult> productsByLab = uService.pharmaSearchGetDrugsShortDetailByLab(divisionId);
			List<ProductInfo> listP = new ArrayList<ProductInfo>();
			List<Lab> listL = new ArrayList<Lab>();
			int item=0,noP = 0;
			
			if( productsByLab!=null ){
				
				userDetails.setProductInfo( null );
				userDetails.setLabs( null );
				
				userDetails.setSubstances( null );
				userDetails.setIcd( null );
				userDetails.setAtc( null );
				userDetails.setGuides( null );
				
				for(GetDrugsShortDetailByLabResult product:productsByLab){
					
					ProductInfo p = new ProductInfo();
					p.setCategotyId( product.getCategotyId() );
					p.setDivisionId( product.getDivisionId() );
					p.setProductId( product.getProductId() );
					p.setPharmaFormId( product.getPharmaFormId() );
					p.setBrand( product.getBrand() );
					p.setSubstances( product.getSubstances() );
					p.setPharmaForm( product.getPharmaForm() );
					p.setDivisionShortName( product.getDivisionShortName() );
					p.setPresentations( product.getPresentations() );
					
					listP.add(p);
					
					if( product.getPresentations().size()>0 ){
						for(Presentation presentation:product.getPresentations())
							item++;
					}else{
						noP++;
					}
					
				}
				
				Lab l = new Lab();
				l.setShortName(productsByLab.get(0).getDivisionShortName());
				l.setDivisionId(productsByLab.get(0).getDivisionId());
				listL.add(l);
				
				userDetails.setProductInfo(listP);
				userDetails.setLabs(listL);
				
				userDetails.setTotalProducts( item+noP );
				userDetails.setTotalSubstances( 0 );
				userDetails.setTotalLabs( listL.size() );
				userDetails.setTotalICD( 0 );
				userDetails.setTotalATC( 0 );
				userDetails.setTotalGuideLines( 0 );
			    
				model.addAttribute("totalResult", userDetails);
				model.addAttribute("productsResult",productsByLab);
			}
		}
		model.addAttribute("contentHeaderTitle", "Medicamentos");
		return "medicamentos-laboratorio";
	}
	
	//Sustancia por autocomplete
	@RequestMapping(value="/medicamentos-sustancia/{substanceId}",method=RequestMethod.GET)
	public String searchSubstances(@PathVariable("substanceId") int substanceId,Model model){
		
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			CustomUser userDetails = (CustomUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			List<GetDrugsShortDetailBySubstanceResult> listSubstances = uService.pharmaSearchGetDrugsShortDetailBySubstance(substanceId);
			List<ProductInfo> listP = new ArrayList<ProductInfo>();
			List<Substance> listS = new ArrayList<Substance>();
			int item=0, noP = 0;
			if( listSubstances!=null ){
				
				userDetails.setProductInfo( null );
				userDetails.setSubstances( null );
				
				userDetails.setLabs( null );
				userDetails.setIcd( null );
				userDetails.setAtc( null );
				userDetails.setGuides( null );
				
				for(GetDrugsShortDetailBySubstanceResult product:listSubstances){
					ProductInfo p = new ProductInfo();
					p.setCategotyId( product.getCategotyId() );
					p.setDivisionId( product.getDivisionId() );
					p.setProductId( product.getProductId() );
					p.setPharmaFormId( product.getPharmaFormId() );
					p.setBrand( product.getBrand() );
					p.setSubstances( product.getSubstances() );
					p.setPharmaForm( product.getPharmaForm() );
					p.setDivisionShortName( product.getDivisionShortName() );
					p.setPresentations( product.getPresentations() );
					listP.add(p);
					
					if( product.getPresentations().size()>0 ){
						for( Presentation presentation:product.getPresentations() )
							item++;
					}else{
						noP++;
					}
				}
	
				Substance s = new Substance();
				s.setActiveSubstanceId(listSubstances.get(0).getSubstances().get(0).getActiveSubstanceId());
				s.setDescription(listSubstances.get(0).getSubstances().get(0).getDescription());
				listS.add(s);
				
				userDetails.setProductInfo( listP );
				userDetails.setSubstances(listS);
				
				userDetails.setTotalProducts( item+noP );
				userDetails.setTotalSubstances( listS.size() );
				userDetails.setTotalLabs( 0 );
				userDetails.setTotalICD( 0 );
				userDetails.setTotalATC( 0 );
				userDetails.setTotalGuideLines( 0 );
				
			    model.addAttribute("totalResult", userDetails);
			    model.addAttribute("productsResult", listSubstances);
			}
		}
		model.addAttribute("contentHeaderTitle", "Medicamentos");
		return "medicamentos-sustancia";
	}
	
	
	//ICD por autcomplete
	@RequestMapping(value="/medicamentos-cie/{icdId}",method=RequestMethod.GET)
	public String searchIcd(@PathVariable("icdId") int icdId,Model model){
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			CustomUser userDetails = (CustomUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			List<GetDrugsShortDetailByICDResult> listIcdResult = uService.pharmaSearchGetDrugsShortDetailByICD(icdId);
			GetICDResult icdResult = uService.pharmaSearchGetICD(icdId);
			List<ProductInfo> listP = new ArrayList<ProductInfo>();
			List<ICD> listICD = new ArrayList<ICD>();
			
			int item = 0, noP = 0;

			if( listIcdResult!=null ){
				userDetails.setIcd( null );
				userDetails.setProductInfo( null );
				
				userDetails.setSubstances( null );
				userDetails.setLabs( null );
				userDetails.setAtc( null );
				userDetails.setGuides( null );
				
				for(GetDrugsShortDetailByICDResult product:listIcdResult){
					ProductInfo p = new ProductInfo();
					p.setCategotyId( product.getCategotyId() );
					p.setDivisionId( product.getDivisionId() );
					p.setProductId( product.getProductId() );
					p.setPharmaFormId( product.getPharmaFormId() );
					p.setBrand( product.getBrand() );
					p.setSubstances( product.getSubstances() );
					p.setPharmaForm( product.getPharmaForm() );
					p.setDivisionShortName( product.getDivisionShortName() );
					p.setPresentations( product.getPresentations() );
					listP.add(p);
					
					if(product.getPresentations().size()>0){
						for(Presentation presentation:product.getPresentations())	
							item++;
					}else{
						noP++;
					}
				}
		
				if( icdResult!=null ){
					ICD icd = new ICD();
					icd.setICDId(icdResult.getICDId());
					icd.setSpanishDescription(icdResult.getSpanishDescription());
					icd.setICDKey(icdResult.getICDKey());
					listICD.add(icd);
					userDetails.setIcd( listICD );
				}	
				
				userDetails.setProductInfo( listP );
				
				
				userDetails.setTotalProducts( item+noP );
				userDetails.setTotalSubstances( 0 );
				userDetails.setTotalLabs( 0 );
				userDetails.setTotalICD( listICD.size() );
				userDetails.setTotalATC( 0 );
				userDetails.setTotalGuideLines( 0 );
			    
			    model.addAttribute("totalResult", userDetails);
			    model.addAttribute("productsResult", listIcdResult);
			}
		}
		model.addAttribute("contentHeaderTitle", "Medicamentos");
		
		
		return "medicamentos-cie";
	}
		
	
	//ATC por autocomplete
	@RequestMapping(value="/medicamentos-atc/{therapeuticId}",method=RequestMethod.GET)
	public String searchATC(@PathVariable("therapeuticId") int therapeuticId,Model model){
		
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			CustomUser userDetails = (CustomUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			List<GetDrugsDetailByTherapeuticResult> listAtc = uService.pharmaSeacrhGetDrugsDetailByTherapeutic(therapeuticId);
			List<ProductInfo> listP = new ArrayList<ProductInfo>();
			List<Therapeutic> listATC = new ArrayList<Therapeutic>();
			
			int item=0, noP = 0;
			
			if( listAtc!=null ){
				userDetails.setProductInfo( null );
				userDetails.setAtc( null );
				
				userDetails.setIcd( null );
				userDetails.setSubstances( null );
				userDetails.setLabs( null );
				userDetails.setGuides( null );
				
				for(GetDrugsDetailByTherapeuticResult product:listAtc){
					ProductInfo p = new ProductInfo();
					p.setCategotyId( product.getCategotyId() );
					p.setDivisionId( product.getDivisionId() );
					p.setProductId( product.getProductId() );
					p.setPharmaFormId( product.getPharmaFormId() );
					p.setBrand( product.getBrand() );
					p.setSubstances( product.getSubstances() );
					p.setPharmaForm( product.getPharmaForm() );
					p.setDivisionShortName( product.getDivisionShortName() );
					p.setPresentations( product.getPresentations() );
					listP.add(p);
					
					if( product.getPresentations().size()>0 ){
						for(Presentation presentation:product.getPresentations()){	
							item++;
						}
					}else{
						noP++;
					}
				}
		
				Therapeutic atc = new Therapeutic();
				atc.setTherapeuticId(listAtc.get(0).getTherapeutics().get(0).getTherapeuticId());
				atc.setSpanishDescription(listAtc.get(0).getTherapeutics().get(0).getSpanishDescription());
				atc.setTherapeuticKey(listAtc.get(0).getTherapeutics().get(0).getTherapeuticKey());
				listATC.add(atc);
				
				userDetails.setProductInfo( listP );
				userDetails.setAtc(listATC);
				
				userDetails.setTotalProducts( item+noP );
				userDetails.setTotalSubstances( 0 );
				userDetails.setTotalLabs( 0 );
				userDetails.setTotalICD( 0 );
				userDetails.setTotalATC( listATC.size() );
				userDetails.setTotalGuideLines( 0 );
			    
			    model.addAttribute("totalResult", userDetails);
				model.addAttribute("productsResult", listAtc);
			}
		}
		model.addAttribute("contentHeaderTitle", "Medicamentos");
		return "medicamentos-atc";
	}
	
	
	//Guías Clínicas por autocomplete
	@RequestMapping(value="/guias-clinicas-busqueda/{text}/{guideId}",method=RequestMethod.GET)
	public String searchClinicGuides(@PathVariable("text") String text,@PathVariable("guideId") int guideId,Model model){
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			CustomUser userDetails = (CustomUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			List<GetMedicalGuidelinesByTextResult> listMedicalGuides = uService.plmClientsGetMedicalGuideLines(text);
			List<GetMedicalGuidelinesByTextResult> listResultGuides = new ArrayList<>();
			if( listMedicalGuides!=null ){
				userDetails.setGuides( null );
				
				userDetails.setAtc( null );
				userDetails.setIcd( null );
				userDetails.setSubstances( null );
				userDetails.setLabs( null );
				
				for(GetMedicalGuidelinesByTextResult guideItem:listMedicalGuides){
					if(guideItem.getElectronicId()==guideId){
						listResultGuides.add( guideItem );
					}
				}
				
				userDetails.setGuides( listResultGuides );
				
				userDetails.setTotalProducts( 0 );
				userDetails.setTotalSubstances( 0 );
				userDetails.setTotalLabs( 0 );
				userDetails.setTotalICD( 0 );
				userDetails.setTotalATC( 0 );
			
				userDetails.setTotalGuideLines( listResultGuides.size() );
				
				
			    model.addAttribute("totalResult", userDetails);
			    model.addAttribute("resultGuides", listResultGuides);
			}
		}
	    
		model.addAttribute("contentHeaderTitle", "Guías Clínicas");
		
		return "guias-clinicas-busqueda";
	}
	
	
	//Palabra
	@RequestMapping(value="/buscador/{search}",method=RequestMethod.GET)
	public String searchGeneral(@PathVariable("search") String search,Model model){
		
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			CustomUser userDetails = (CustomUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
			GetResultsDetailAndGetMedicalGuidelinesByTextAndGetTherapeuticsInfo list = uService.pharmaSearchGetResultDetail(search);
			
			userDetails.setProductInfo(null);
			
			userDetails.setLabs( null );
			userDetails.setSubstances( null );
			userDetails.setIcd( null );
			userDetails.setAtc( null );
			userDetails.setGuides( null );
			
			int sumPresentations = 0, sumNoP = 0;
			List<Substance> listSubstances = new ArrayList<Substance>();
			
			
			for( ProductInfo contador:((GetResultsDetailResult) list.getGetResultsDetailResult()).getProducts() ){
				if( contador.getPresentations().size()>0 )
					sumPresentations = (sumPresentations+contador.getPresentations().size());
				else
					sumNoP++;
			}
			
			for( Substance_ substance_:((GetResultsDetailResult) list.getGetResultsDetailResult()).getSubstances() ){
				Substance substance = new Substance();
				substance.setActive( true );
				substance.setActiveSubstanceId( substance_.getActiveSubstanceId() );
				substance.setAdditionalProperty(null, null);
				substance.setDescription( substance_.getDescription() );
				substance.setEnglishDescription( substance_.getEnglishDescription() );
				substance.setEnunciative( true );
				substance.setJSONFormat( substance_.getJSONFormat() );
				substance.setSubstanceKey( substance_.getSubstanceKey() );
				substance.isEnunciative();
				listSubstances.add( substance );
			}
			
			userDetails.setTotalProducts( sumPresentations+sumNoP );
			userDetails.setTotalSubstances( list.getGetResultsDetailResult().getSubstances().size() );
			userDetails.setTotalLabs( list.getGetResultsDetailResult().getLabs().size() );
			userDetails.setTotalICD( list.getGetResultsDetailResult().getICD().size() );
			userDetails.setTotalATC( list.getGetResultsDetailResult().getTherapeutics().size() );
			userDetails.setTotalGuideLines((list.getListGetMedicalGuidelinesByTextResult()!=null)?list.getListGetMedicalGuidelinesByTextResult().size():0);
			
			userDetails.setProductInfo(  list.getGetResultsDetailResult().getProducts() );
			userDetails.setLabs( list.getGetResultsDetailResult().getLabs() );
			userDetails.setSubstances( listSubstances );
			userDetails.setIcd( list.getGetResultsDetailResult().getICD() );
			userDetails.setListGetTherapeuticsResult( list.getListGetTherapeuticsResult() );
			userDetails.setGuides( list.getListGetMedicalGuidelinesByTextResult() );
		    
			//Asigna vista
		    model.addAttribute("totalResult",userDetails);
			if( list.getGetResultsDetailResult().getProducts().size()>=1 ){
				model.addAttribute("contentHeaderTitle", "Medicamentos");
				model.addAttribute("productsResult",userDetails.getProductInfo());
				return "medicamentos";
			}else if( list.getGetResultsDetailResult().getSubstances().size()>=1 ){
				model.addAttribute("contentHeaderTitle", "Sustancias");
				model.addAttribute("substancesResult",userDetails.getSubstance());
				return "sustancias";
			}else if( list.getGetResultsDetailResult().getLabs().size()>=1 ){
				model.addAttribute("contentHeaderTitle", "Laboratorios");
				model.addAttribute("labsResult",userDetails.getLabs());
				return "laboratorios";
			}else if( list.getGetResultsDetailResult().getICD().size()>=1 ){
				model.addAttribute("contentHeaderTitle", "CIE-10");
				model.addAttribute("icdResult",userDetails.getIcd());
				return "cie";
			}else if( list.getGetResultsDetailResult().getTherapeutics().size()>=1 ){
				model.addAttribute("contentHeaderTitle", "ATC");
				model.addAttribute("atcResult",userDetails.getAtc());
				return "atc";
			}else if( list.getListGetMedicalGuidelinesByTextResult()!=null ){
				model.addAttribute("contentHeaderTitle", "Guías Clínicas");
				model.addAttribute("resultGuides",userDetails.getGuides());
				return "guias-clinicas";
			}
		}
		return "home";
		
	}
		
	//Palabra por POST
	@RequestMapping(value="/buscador/",method=RequestMethod.POST)
	public @ResponseBody GetResultsDetailAndGetMedicalGuidelinesByTextAndGetTherapeuticsInfo searchGeneral(@RequestParam(value = "search")String search){
		GetResultsDetailAndGetMedicalGuidelinesByTextAndGetTherapeuticsInfo l = uService.pharmaSearchGetResultDetail(search);
		return l;
	}
	
	//Vista Medicamentos
	
	
	//Medicamentos
	@RequestMapping(value="/medicamentos/",method=RequestMethod.GET)
	public String getDrugs(Model model){
		CustomUser userDetails = (CustomUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if( userDetails!=null ){		
			model.addAttribute( "productsResult",userDetails.getProductInfo());
			model.addAttribute( "totalResult",userDetails);
		}
		model.addAttribute("contentHeaderTitle", "Medicamentos");
		return "medicamentos";
	}
	
	//Vista Laboratorios
	
	
	//Laboratorios
	@RequestMapping(value="/laboratorios/",method=RequestMethod.GET)
	public String getLabs(Model model){
		CustomUser userDetails = (CustomUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if( userDetails!= null ){			
			model.addAttribute("productsResult",userDetails.getProductInfo());
			model.addAttribute("labsResult",userDetails.getLabs());
			model.addAttribute("totalResult",userDetails);
		}
		model.addAttribute("contentHeaderTitle", "Laboratorios");
		return "laboratorios";
	}
	
	//Vista Sustancias
	
	//Sustancias
	@RequestMapping(value="/sustancias/",method=RequestMethod.GET)
	public String getSubstances(Model model){
		CustomUser userDetails = (CustomUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if( userDetails !=null){			
			model.addAttribute("productsResult",userDetails.getProductInfo());
			if(userDetails.getSubstances()!=null)
				model.addAttribute("substancesResult",userDetails.getSubstances());
			else
				model.addAttribute("substancesResult",userDetails.getSubstance());
			model.addAttribute("totalResult",userDetails);
		}		
		model.addAttribute("contentHeaderTitle", "Sustancias");		
		
		return "sustancias";
	}
	
	//Vista CIE
	@RequestMapping(value="/cie/",method=RequestMethod.GET)
	public String getICD(Model model){
		CustomUser userDetails = (CustomUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if( userDetails!=null){			
			model.addAttribute( "productsResult",userDetails.getProductInfo());
			model.addAttribute("icdResult",userDetails.getIcd());
			model.addAttribute( "totalResult",userDetails);
		}
		
		model.addAttribute("contentHeaderTitle", "CIE-10");
		return "cie";
	}
	
	//Vista ATC
	@RequestMapping(value="/atc/",method=RequestMethod.GET)
	public String getATC(Model model){
		CustomUser userDetails = (CustomUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if( userDetails!=null ){			
			model.addAttribute( "productsResult",userDetails.getProductInfo());
			model.addAttribute("atcResult",userDetails.getAtc());
			model.addAttribute( "totalResult",userDetails);
		}
		
		model.addAttribute("contentHeaderTitle", "ATC");
		return "atc";
	}
	
	//Vista Guías Clínicas
	@RequestMapping(value="/guias-clinicas/",method=RequestMethod.GET)
	public String getMedicalGuideLine(Model model){
		CustomUser userDetails = (CustomUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		if( userDetails!=null){			
			model.addAttribute( "productsResult",userDetails.getProductInfo());
			model.addAttribute("resultGuides",userDetails.getGuides());
			model.addAttribute( "totalResult",userDetails);
		}
		
		model.addAttribute("contentHeaderTitle", "Guías Clínicas");
		return "guias-clinicas";
	}
	
	
}
