package com.plm.pt4.mvc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
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

import com.plm.pt4.mvc.bean.BeanGeneralSettings;
import com.plm.pt4.mvc.model.CustomUser;
import com.plm.pt4.mvc.model.MedicalInteractions;
import com.plm.pt4.mvc.model.SearchGeneral;
import com.plm.pt4.mvc.model.SelectedDrugs;
import com.plm.pt4.mvc.model.TotalResult;
import com.plm.pt4.mvc.service.UtilitiesService;
import com.plmlatina.model.Attribute;
import com.plmlatina.model.GetAllAttributesByProductInfo;
import com.plmlatina.model.GetAllAttributesByProductResult;
import com.plmlatina.model.GetICDByDrugsResult;
import com.plmlatina.model.ICD;
import com.plmlatina.model.Substance;
import com.plmlatina.model.Therapeutic;
import com.plmlatina.result.InteractionsByEditionProductsResponse;

@Controller
public class ProductDetailController {
	@Autowired
	UtilitiesService uService;

	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	MedicalInteractions ippa = new MedicalInteractions();
	int opc = 0;
	
	// Atributos e ICD del Producto
	@RequestMapping(value = "/descripcion-medicamento/{divisionId}-{categoryId}-{productId}-{pharmaFormId}/{opc}", method = RequestMethod.GET)
	public String getView(@PathVariable("divisionId") int divisionId, @PathVariable("categoryId") int categoryId,
						  @PathVariable("productId") int productId, @PathVariable("pharmaFormId") int pharmaFormId, 
						  @PathVariable("opc") int opc,Model model) {
		this.opc = opc;
		ippa = new MedicalInteractions();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			CustomUser userDetails = (CustomUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			GetAllAttributesByProductResult getAllAttributesByProductResult = uService.pharmaGetAllAttributesByProductResult(divisionId, categoryId, productId, pharmaFormId);
			List<GetICDByDrugsResult> icdResult = uService.pharmaGetICDByDrugs(productId);
			
			List<ICD> listICD = new ArrayList<ICD>();
			for(GetICDByDrugsResult item:icdResult){
				ICD icd = new ICD();
				icd.setICDId( item.getICDId() );
				icd.setICDKey( item.getICDKey() );
				icd.setSpanishDescription( item.getSpanishDescription() );
				icd.setEnglishDescription( item.getEnglishDescription() );
				listICD.add(icd);
			}
	
			List<Substance> listSubstance = new ArrayList<Substance>();
			for(Substance s:getAllAttributesByProductResult.getSubstances()){
				Substance substance = new Substance();
				substance.setActiveSubstanceId( s.getActiveSubstanceId() );
				substance.setDescription( s.getDescription() );
				substance.setEnglishDescription( s.getEnglishDescription() );
				listSubstance.add( substance );
			}
			
			List<Therapeutic> listATC = new ArrayList<Therapeutic>();
			for(Therapeutic t:getAllAttributesByProductResult.getTherapeutics()){
				Therapeutic therapeutic = new Therapeutic();
				therapeutic.setDescription( t.getDescription() );
				therapeutic.setSpanishDescription( t.getSpanishDescription() );
				therapeutic.setTherapeuticId( t.getTherapeuticId() );
				therapeutic.setParentId( t.getParentId() );
				therapeutic.setTherapeuticKey( t.getTherapeuticKey() );
				listATC.add( therapeutic );
			}
			
			userDetails.setIcd( listICD );
			userDetails.setSubstances( listSubstance );
			userDetails.setAtc( listATC );
			
			model.addAttribute("contentHeaderTitle", getAllAttributesByProductResult.getBrand());
			model.addAttribute("contentHeaderSubtitle", getAllAttributesByProductResult.getPharmaForm());
	
			model.addAttribute("totalResult", userDetails);
			model.addAttribute("getICDByDrugsResult", userDetails.getIcd());
			model.addAttribute("substancesResult", userDetails.getSubstances());
			model.addAttribute("atcResult", userDetails.getAtc());
			model.addAttribute("getAllAttributesByProductResult", getAllAttributesByProductResult);
		

		}
			return "descripcion-medicamento";
	}

	
	@RequestMapping(value = "/descripcion-medicamento/{divisionId}-{categoryId}-{productId}-{pharmaFormId}/{opc}", method = RequestMethod.POST)
	public String getIPP(@PathVariable(value="divisionId") int divisionId, @PathVariable(value="categoryId") int categoryId,
						  @PathVariable(value="productId") int productId, @PathVariable(value="pharmaFormId") int pharmaFormId,
						  @PathVariable("opc") int opc,@RequestBody MedicalInteractions mi,
						  Model model) {
		this.opc = opc;
		ippa = mi;
		if ( !(auth instanceof AnonymousAuthenticationToken) ) {
			CustomUser userDetails = (CustomUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			GetAllAttributesByProductResult getAllAttributesByProductResult = uService.pharmaGetAllAttributesByProductResult(divisionId, categoryId, productId, pharmaFormId);
			List<GetICDByDrugsResult> icdResult = uService.pharmaGetICDByDrugs(productId);
			
			List<ICD> listICD = new ArrayList<ICD>();
			for(GetICDByDrugsResult item:icdResult){
				ICD icd = new ICD();
				icd.setICDId( item.getICDId() );
				icd.setICDKey( item.getICDKey() );
				icd.setSpanishDescription( item.getSpanishDescription() );
				icd.setEnglishDescription( item.getEnglishDescription() );
				listICD.add(icd);
			}
	
			List<Substance> listSubstance = new ArrayList<Substance>();
			for(Substance s:getAllAttributesByProductResult.getSubstances()){
				Substance substance = new Substance();
				substance.setActiveSubstanceId( s.getActiveSubstanceId() );
				substance.setDescription( s.getDescription() );
				substance.setEnglishDescription( s.getEnglishDescription() );
				listSubstance.add( substance );
			}
			
			List<Therapeutic> listATC = new ArrayList<Therapeutic>();
			for(Therapeutic t:getAllAttributesByProductResult.getTherapeutics()){
				Therapeutic therapeutic = new Therapeutic();
				therapeutic.setDescription( t.getDescription() );
				therapeutic.setSpanishDescription( t.getSpanishDescription() );
				therapeutic.setTherapeuticId( t.getTherapeuticId() );
				therapeutic.setParentId( t.getParentId() );
				therapeutic.setTherapeuticKey( t.getTherapeuticKey() );
				listATC.add( therapeutic );
			}
			
			userDetails.setIcd( listICD );
			userDetails.setSubstances( listSubstance );
			userDetails.setAtc( listATC );
			userDetails.setMedicalInteractions( mi );
			
			model.addAttribute("contentHeaderTitle", getAllAttributesByProductResult.getBrand());
			model.addAttribute("contentHeaderSubtitle", getAllAttributesByProductResult.getPharmaForm());
	
			model.addAttribute("totalResult", userDetails);
			model.addAttribute("getICDByDrugsResult", userDetails.getIcd());
			model.addAttribute("substancesResult", userDetails.getSubstances());
			model.addAttribute("atcResult", userDetails.getAtc());
			model.addAttribute("getAllAttributesByProductResult", getAllAttributesByProductResult);
			
		}
			return "descripcion-medicamento";
	}
	
	
	//Atributos del producto POST 
	@RequestMapping(value = "/detalle-medicamento/", method = RequestMethod.POST)
	public @ResponseBody GetAllAttributesByProductResult getProductDetail(
			@RequestParam(value = "divisionId") int divisionId, @RequestParam(value = "categoryId") int categoryId,
			@RequestParam(value = "productId") int productId, @RequestParam(value = "pharmaFormId") int pharmaFormId,
			final GetAllAttributesByProductInfo json) {

		GetAllAttributesByProductResult getAllAttributesByProductResult = uService.pharmaGetAllAttributesByProductResult(json.getDivisionId(), json.getCategoryId(), json.getProductId(),json.getPharmaFormId());
		return getAllAttributesByProductResult;
	}
	
	@RequestMapping(value = "/descripcion-medicamento/getIPP", method = RequestMethod.GET)
	public @ResponseBody MedicalInteractions getIPP() {
		MedicalInteractions me = new MedicalInteractions();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			CustomUser userDetails = (CustomUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			if(opc==1){
				me.setSubstances("#body-5");
				me.setPharmacologicalGroup("#botonera-5");
			}else if( opc==2 ){ 
				if( userDetails.getMedicalInteractions()!=null ){
					me = userDetails.getMedicalInteractions();
				}
			}
		}
		 return me;
	}
	

}
