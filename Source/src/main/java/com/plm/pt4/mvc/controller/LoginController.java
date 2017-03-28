package com.plm.pt4.mvc.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.plm.pt4.mvc.authentication.CustomAuthenticationProvider;
import com.plm.pt4.mvc.bean.BeanGeneralSettings;
import com.plm.pt4.mvc.model.CustomUser;
import com.plm.pt4.mvc.service.PLMClientService;
import com.plm.pt4.mvc.service.UtilitiesService;
import com.plmlatina.model.ActivateCodeStringResult;
import com.plmlatina.model.GetClientDetailCompleteByEmailResult;
import com.plmlatina.model.SaveAppServerClientInfo;
import com.plmlatina.model.SaveAppServerClientWithouthLicenseInfo;
import com.plmlatina.model.SaveWebClientByPrefixByCode;
import com.plmlatina.model.SaveWebClientByPrefixByCodeResult;
import com.plmlatina.model.catalog.GetLocationsByStateInfo;
import com.plmlatina.model.catalog.GetSubspecialitiesResult;
import com.plmlatina.model.catalog.GetSuburbsByLocationInfo;
import com.plmlatina.model.catalog.GetSuburbsZipCodeByLocationInfo;
import com.plmlatina.result.GetClientInformationDetailByEmailResponse;
import com.plmlatina.result.SaveAppServerClientResponse;


@Controller
@RequestMapping(value ="/login")
public class LoginController {
	
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/WEB-INF/spring/spring-import.xml");
	BeanGeneralSettings gSettings = (BeanGeneralSettings) context.getBean("beanGeneralSettings");
	
	@Autowired
	PLMClientService _PLMClientService;
	
	@Autowired
	UtilitiesService uService;
	
	
	@Autowired
	CustomAuthenticationProvider _authenticationProvider;
	
	
	@RequestMapping(value="",method= RequestMethod.GET)
	public String  LoginInit(@RequestParam(value = "error", required = false) String error,
				            @RequestParam(value = "logout", required = false) String logout,
				            ModelMap model,
				            HttpServletRequest request,
				            HttpServletResponse response) {
		
		model.addAttribute("country",gSettings.getCountry());
		model.addAttribute("typeLogin",gSettings.getTypeLogin());
		
		
		if (error != null) {
			
		}

		if (logout != null) {
			
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			
			if (auth != null){    
		        new SecurityContextLogoutHandler().logout(request, response, auth);
		    }
			
		}
		
		 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			
			if (!(auth instanceof AnonymousAuthenticationToken)) {
				
			   return "redirect:/home";
			}
			
			if(gSettings.getTypeLogin()==1){
			
				 CustomUser user = new CustomUser();
				 String uuid = java.util.UUID.randomUUID().toString();
	         	 user.setUuid(uuid);
				 user.setUsername("contacto@plmlatina.com");
		         user.setFirstName("BANORTE");
		         user.setLastName("");
		         user.setPassword("plm2016");
//		         user.setCodeString("F9L46EHIJ7");
		         user.setCodeString("ZP1L733PUE");
//		         user.setCodeString("F9859FNNMG");
		         user.setCodeId(173365);
		         user.setClientId(745420);	
		         
		         _authenticationProvider.NoUserRegistration(user);
		         
		         return "redirect:/home";
			
			}else if(gSettings.getTypeLogin()==2 || gSettings.getTypeLogin()==3 || gSettings.getTypeLogin()==4 || gSettings.getTypeLogin()==5 ){
				return "login";
			}
	         
		
			return "login";
		
	}
	
	
	@RequestMapping(value="/registro-codigo/",method=RequestMethod.GET)
	public String RegisterInit(Model model){
		
		
		SaveWebClientByPrefixByCode saveWebClient = new SaveWebClientByPrefixByCode();
//		saveWebClient.setRegistrationCode("R7B1JMD2");
		
		
		model.addAttribute("saveWebClient",saveWebClient);
		model.addAttribute("getSpecialities",_PLMClientService.getSpecialities( gSettings.getProfesionId() ));
		model.addAttribute("getStates",_PLMClientService.getStatesByCountry( gSettings.getCountryIdClients() ));
		
		
		return "registrationByCode";
	}
	
	@RequestMapping(value="/registro-codigo/",method=RequestMethod.POST)
	public String RegisterInitSubmit(@Valid @ModelAttribute("saveWebClient") SaveWebClientByPrefixByCode saveWebClient, BindingResult result,ModelMap model){
		
		
		//model.addAttribute("getSpecialities",_PLMClientService.getSpecialities(7));
		//model.addAttribute("getStates",_PLMClientService.getStatesByCountry(2));
		
		if(result.hasErrors()) {
			
			model.addAttribute("erroFormlogin","Verifique sus Datos *");

			 return "registrationByCode"; 
		}
		
		String[] arraySpeciality = saveWebClient.getSpecialityName().split("%%");
		saveWebClient.setSpecialityName( arraySpeciality[0] );
		saveWebClient.setSpeciality( Integer.parseInt(arraySpeciality[1]) );
		
		
		SaveWebClientByPrefixByCodeResult _saveWebClientResult =	_PLMClientService.SaveWebClientByPrefixByCode(saveWebClient);
		
		if(_saveWebClientResult.getCodeId()>0&&_saveWebClientResult.getCodeString()!=null){
			
			CustomUser user = new CustomUser();
			
			    user.setUsername(saveWebClient.getEmail());
	            user.setFirstName(saveWebClient.getFirstName());
	            user.setLastName(saveWebClient.getLastName());
	            user.setPassword(saveWebClient.getPassword());
	          
			
	            _authenticationProvider.autologin(user);
	            return "redirect:/home";
			
		}
		
		
		return "registrationByCode";
	}
	
	  //RegistrationByLicense	
	
		@RequestMapping(value="/registro-licencia/",method=RequestMethod.GET)
		public String RegisterLicenseInit(Model model){
			
			
		   SaveAppServerClientInfo saveWebClient = new SaveAppServerClientInfo();
			
			
			model.addAttribute("saveWebClient",saveWebClient);
			model.addAttribute("getSpecialities",_PLMClientService.getSpecialities( gSettings.getProfesionId() ));
			model.addAttribute("getStates",_PLMClientService.getStatesByCountry( gSettings.getCountryIdClients() ));
			
			
			return "registrationByLicense";
		}
		
		@RequestMapping(value="/registro-licencia/",method=RequestMethod.POST)
		public String RegisterInitLicenseSubmit(@Valid @ModelAttribute("saveWebClient") SaveAppServerClientInfo saveWebClient, BindingResult result,ModelMap model){
			
			
			if(result.hasErrors()) {
				
				model.addAttribute("erroFormlogin","Verifique sus Datos *");

				 return "registrationByLicense"; 
			}
			
			if(saveWebClient.getSubspeciality()=="" || saveWebClient.getSubspeciality()==null){
							
							saveWebClient.setSubspeciality(null);
							saveWebClient.setSubspecialityLicense(null);
							
							
						}
			
			SaveAppServerClientResponse saveApp=_PLMClientService.saveAppServerClient(saveWebClient);
			
			
			if(saveApp!=null){
				
				CustomUser user = new CustomUser();
				
				    user.setUsername(saveWebClient.getEmail());
		            user.setFirstName(saveWebClient.getFirstName());
		            user.setLastName(saveWebClient.getLastName());
		            user.setPassword(saveWebClient.getPassword());
		            
		           
				
		            _authenticationProvider.autologin(user);
				
			}
			
			
			
		
			 return "redirect:/home";
		}
		
	//registration By Active By Email
		
		@RequestMapping(value="/registro-activacion-email/",method=RequestMethod.GET)
		public String RegisterActiveByEmailInit(Model model){
			
			
			SaveAppServerClientWithouthLicenseInfo saveWebClient = new SaveAppServerClientWithouthLicenseInfo();
			
			model.addAttribute("saveWebClient",saveWebClient);
			model.addAttribute("getSpecialities",_PLMClientService.getSpecialities( gSettings.getProfesionId() ));
			model.addAttribute("getStates",_PLMClientService.getStatesByCountry( gSettings.getCountryIdClients() ));
			
			
			return "registrationActiveByEmail";
		}
		
		@RequestMapping(value="/registro-activacion-email/",method=RequestMethod.POST)
		public String RegisterActiveByEmailInitSubmit(@Valid @ModelAttribute("saveWebClient") SaveAppServerClientWithouthLicenseInfo saveWebClient, BindingResult result,ModelMap model){
			
			
			if(result.hasErrors()) {
				
				model.addAttribute("erroFormlogin","Verifique sus Datos *");

				 return "registrationActiveByEmail"; 
			}
			
			if(saveWebClient.getSubspeciality()=="" || saveWebClient.getSubspeciality()==null){
				
				saveWebClient.setSubspeciality(null);
				saveWebClient.setSubspecialityLicense(null);
				
				
			}
			
			String  saveApp=_PLMClientService.saveAppLicenseServerClient(saveWebClient);
			
			
			if(saveApp!=null){
				
				model.addAttribute("clientName",saveWebClient.getFirstName()+" "+saveWebClient.getLastName()+" "+saveWebClient.getSlastName());
				model.addAttribute("clientEmail",saveWebClient.getEmail());
				
				return "registrationPreActive";
				
				
				
			}
			
			
			
		
			 return "redirect:/registrationActiveByEmail";
		}
		
		
		@RequestMapping(value ="/activacion-satisfactoria", method = RequestMethod.GET)
		public String initPremiumProcessing(@RequestParam(value = "code", required = true) String code,Model model) {
			
			
			String codeString= code;
			
			if(codeString!=null){
				 	
				ActivateCodeStringResult _activeCode=	_PLMClientService.activateClientByCodeString(codeString);
				
				if(_activeCode!=null){
					CustomUser user = new CustomUser();
					
				    user.setUsername(_activeCode.getEmail());
		            user.setFirstName(_activeCode.getFirstName());
		            user.setLastName(_activeCode.getLastName());
		            user.setPassword(_activeCode.getPassword());  
		            _authenticationProvider.autologin(user);
	            
				}
	          
				
				
			}
			
			//return "SuccessfulActivation";
			return "redirect:/home?activacion=true";
		}
		
		

	    @RequestMapping(value="/getClientDetailCompleteByEmail", method = RequestMethod.POST)
	 	public @ResponseBody GetClientDetailCompleteByEmailResult getClientDetailCompleteByEmail( @RequestParam(value = "email") String email) {  

		  
		 return uService.getClientDetailCompleteByEmail(email);
	    }
	    
	    @RequestMapping(value="/getClientInformationDetailByEmail", method = RequestMethod.POST)
	 	public @ResponseBody GetClientInformationDetailByEmailResponse getClientInformationDetailByEmail( @RequestParam(value = "email") String email) {  

		 return uService.getClientInformationDetailByEmail(email);
	    }
	    
	    
	    
	    @RequestMapping(value="/getLocationsByState", method = RequestMethod.POST)
	 	public @ResponseBody List<GetLocationsByStateInfo> getLocationsByState( @RequestParam(value = "stateId") int stateId) {  

		   return _PLMClientService.getLocationsByState(stateId);
	    }
	    
	    @RequestMapping(value="/getSuburbsByLocation", method = RequestMethod.POST)                      
	 	public @ResponseBody List<GetSuburbsByLocationInfo> getSuburbsByLocation( @RequestParam(value = "locationId") int locationId) {  

		   return _PLMClientService.getSuburbsByLocation(locationId);
	    }
	    
	    @RequestMapping(value="/getSuburbsZipCodeByLocation", method = RequestMethod.POST)                      
	 	public @ResponseBody List<GetSuburbsZipCodeByLocationInfo> getSuburbsZipCodeByLocation( @RequestParam(value = "locationSuburb") String locationSuburb) {  
	    	
	    	
	    	String [] ls = locationSuburb.split("-");
	    	
	    	int locationId = Integer.parseInt(ls[0]);
	    	int suburbId =   Integer.parseInt(ls[1]);

		   return _PLMClientService.getSuburbsZipCodeByLocation(locationId,suburbId);
	    }
	    
	    @RequestMapping(value="/getSubspecialities", method = RequestMethod.POST)
	 	public @ResponseBody List<GetSubspecialitiesResult> getSubspecialities( @RequestParam(value = "specialityId") int specialityId) {  

		   return _PLMClientService.getSubspecialities(specialityId);
	    }
	    
	    @RequestMapping(value="/recoveryClientPassword", method = RequestMethod.POST)
	 	public @ResponseBody String recoveryClientPassword( @RequestParam(value = "email") String email) {  

		   return _PLMClientService.recoveryClientPassword(email);
	    }
		
	

}
