package com.plm.pt4.mvc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.plm.pt4.mvc.bean.BeanGeneralSettings;
import com.plm.pt4.mvc.model.CustomUser;
import com.plm.pt4.mvc.service.PLMClientService;
import com.plm.pt4.mvc.service.UtilitiesService;
import com.plmlatina.model.Address;
import com.plmlatina.model.GetAddressesByClientResult;
import com.plmlatina.model.GetClientInformationDetailByEmailResult;
import com.plmlatina.model.SaveClientAddressesInfo;
import com.plmlatina.model.UpdateAddressByClientInfo;
import com.plmlatina.model.UpdateAddressInfo;
import com.plmlatina.model.UpdateAppServerClientInfo;
import com.plmlatina.model.catalog.GetSubspecialitiesResult;



/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/")
public class HomeController {
	
	@Autowired
	UtilitiesService uService;
	
	@Autowired
	PLMClientService _PLMClientService;
	
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/WEB-INF/spring/spring-import.xml");
	BeanGeneralSettings gSettings = (BeanGeneralSettings) context.getBean("beanGeneralSettings");	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String login(Model model){
		
		
		  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			
			if (!(auth instanceof AnonymousAuthenticationToken)) {
				
			   return "redirect:/home";
			}
		
		return "redirect:/cliente";
	}
	

	@RequestMapping(value = "/perfil", method = RequestMethod.GET)
	public String profile(Model model){
		
		
	  
			CustomUser userDetails = (CustomUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			GetClientInformationDetailByEmailResult getClient= uService.getClientInformationDetailByEmail(userDetails.getUsername()).getGetClientInformationDetailByEmailResult();
		    
		    UpdateAppServerClientInfo updateWebClient=new UpdateAppServerClientInfo();
		    
		    updateWebClient.setEmail(getClient.getEmail());
		    updateWebClient.setFirstName(getClient.getFirstName());
		    updateWebClient.setLastName(getClient.getLastName());
		    updateWebClient.setSlastName(getClient.getSecondLastName());
		    
		    if(getClient.getProfession()!=null){
			    updateWebClient.setProfessionLicense(getClient.getProfession().getProfessionalLicense());
		    }
		    if(getClient.getSpeciality()!=null){
			    updateWebClient.setSpeciality(String.valueOf(getClient.getSpeciality().getSpecialityId()));
		        updateWebClient.setSpecialityLicense(getClient.getSpeciality().getProfessionalLicense());
		    }
  		    updateWebClient.setState(getClient.getState().getShortName());
		    updateWebClient.setCodeString(userDetails.getCodeString());
		    
		    List<GetSubspecialitiesResult> subspeciality = new ArrayList<GetSubspecialitiesResult>();
		    
		    if(getClient.getSpeciality()!=null){
		    	
		    	subspeciality=	_PLMClientService.getSubspecialities((int)getClient.getSpeciality().getSpecialityId());
		    	if(getClient.getSubspeciality()!=null){
			    	updateWebClient.setSubspeciality(String.valueOf(getClient.getSubspeciality().getSubspecialityId()));
			    	updateWebClient.setSubspecialityLicense(getClient.getSubspeciality().getSubspecialityLicense());
			    	}
		    }
		    
		    
		    model.addAttribute("updateWebClient",updateWebClient);
		    
			model.addAttribute("getSpecialities",_PLMClientService.getSpecialities(7));
			model.addAttribute("getSubSpecialities",subspeciality);
			model.addAttribute("getStates",_PLMClientService.getStatesByCountry(1));
		
		
		
		return "profile";
	}
	
	@RequestMapping(value="/perfil",method=RequestMethod.POST)
	public String profileSubmit(@Valid @ModelAttribute("updateWebClient") UpdateAppServerClientInfo updateWebClient, BindingResult result,ModelMap model){
		
		CustomUser userDetails = (CustomUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		updateWebClient.setCodeString(userDetails.getCodeString());
		
        if(updateWebClient.getSubspeciality()=="" || updateWebClient.getSubspeciality()==null){
			
			updateWebClient.setSubspeciality(null);
			updateWebClient.setSubspecialityLicense(null);
			
			
		}
		
		boolean update= _PLMClientService.updateAppServerClient(updateWebClient);
		
		if(update!=true){
			
				
			model.addAttribute("getSpecialities",_PLMClientService.getSpecialities(7));
			model.addAttribute("getSubSpecialities",_PLMClientService.getSubspecialities(Integer.parseInt(updateWebClient.getSpeciality())));
			model.addAttribute("getStates",_PLMClientService.getStatesByCountry(1));
			
			model.addAttribute("erroFormlogin","Verifique sus Datos *");
			
			 return "profile"; 
		}
            
		
		
	
		 return "redirect:/home";
	}
	
	

	@RequestMapping(value = "/consultorios", method = RequestMethod.GET)
	public String consultorio(Model model){
		

		Address formAddress= new Address();
		model.addAttribute("formAddress",formAddress);
		model.addAttribute("getStates",_PLMClientService.getStatesByCountry(1));
		
		return "doctorOffice";
	}
	
	
	   @RequestMapping(value="/consultorios/getAddressesByClient", method = RequestMethod.POST)
	 	public @ResponseBody List<GetAddressesByClientResult> getAddressesByClient() {  
           
		   CustomUser userDetails = (CustomUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		   
		   return uService.getAddressesByClient(userDetails.getClientId());
	    }
	   
	   @RequestMapping(value="/consultorios/SaveClientAddresses", method = RequestMethod.POST)
	 	public @ResponseBody boolean SaveClientAddresses(@RequestBody final Address addresses) {  
		   
		   List<Address> _addresses = new ArrayList<Address>();
		   
		   _addresses.add(addresses);
		   
		   CustomUser userDetails = (CustomUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		   SaveClientAddressesInfo saveClient = new SaveClientAddressesInfo();
		   saveClient.setAddresses(_addresses);
		   saveClient.setClientId(String.valueOf(userDetails.getClientId()));
		   
		   boolean saveOk =uService.saveClientAddresses(saveClient);
	      
	       if(saveOk==true){
	    	   
	    	   userDetails.setAddAddres(true);
			   
			  
	    	   
	       }
		   
		   
		   return saveOk;
	    }
	   
	   @RequestMapping(value="/consultorios/updateAddressByClientInfo", method = RequestMethod.POST)
	 	public @ResponseBody boolean updateAddressByClientInfo(@RequestBody final UpdateAddressInfo updateAddressInfo) {  
		   
		   UpdateAddressByClientInfo updateAddressByClientInfo = new UpdateAddressByClientInfo();
		   updateAddressByClientInfo.setAddress(updateAddressInfo);
          
		   return uService.updateAddressInfo(updateAddressByClientInfo);
	    }
	
	
	
	@RequestMapping(value = "/farmacovigilance", method = RequestMethod.GET)
	public String goFarmacovigialcia(Model model){
		model.addAttribute("gSettings",gSettings);
		return "farmacovigilancia";
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(@RequestParam(value = "activacion", required = false) boolean activation,Model model) throws Exception{
		
	   CustomUser userDetails = (CustomUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		   
	   List<GetAddressesByClientResult> getAddressesByClient= uService.getAddressesByClient(userDetails.getClientId());
		
	   if(getAddressesByClient.size()>0){
		   userDetails.setAddAddres(true);
		   model.addAttribute("isAddAddres",true);
	   }
	  
		if(activation==true){
			
			model.addAttribute("successfulActivation",activation);
		}

		model.addAttribute("gSettings",gSettings);
		
		return "home";
	}
	

	@RequestMapping(value = "/error", method = RequestMethod.GET)
    public String errorPage(Model model) throws Exception{
          return "error";
    }
	

	
}
