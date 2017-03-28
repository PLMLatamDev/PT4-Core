package com.plm.pt4.mvc.controller;



import java.util.Arrays;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.plm.pt4.mvc.authentication.CustomAuthenticationProvider;
import com.plm.pt4.mvc.bean.BeanCodePrefix;
import com.plm.pt4.mvc.bean.BeanGeneralSettings;
import com.plm.pt4.mvc.model.CustomUser;
import com.plm.pt4.mvc.service.PLMClientService;
import com.plmlatina.model.ActivateCodeStringResult;
import com.plmlatina.model.GetCodePrefixesByDistributionByCompanyClientResult;
import com.plmlatina.model.SaveAppServerClientWithouthLicenseInfo;
import com.plmlatina.model.SaveWebClientByPrefixByCode;
import com.plmlatina.model.SaveWebClientByPrefixByCodeResult;


@Controller
@RequestMapping(value = "/cliente")
public class CompanyController {
	

	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/WEB-INF/spring/spring-import.xml");
	BeanGeneralSettings gSettings = (BeanGeneralSettings) context.getBean("beanGeneralSettings");

	@Autowired
	BeanCodePrefix beanCodePrefix;

	@Autowired
	PLMClientService _PLMClientService;
	
	@Autowired
	CustomAuthenticationProvider _authenticationProvider;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String clientInit(@RequestParam(value = "auth", required = false) String auth,
						ModelMap model,
			            HttpServletRequest request,
			            HttpServletResponse response){
		
		
		 Cookie[] cookies = request.getCookies();
		 
		 String[] urlClients=null;
		 
		  if (cookies != null){
			  for (Cookie cook : cookies){
				  
			          // System.out.println(cookie.getName() + " : " + cookie.getValue());
				  
				     if(cook.getName().equals("isCookieListUrlCC")){
				    	 
				    	 urlClients=cook.getValue().split("\\|");
				    	 
				    	 if(urlClients.length==1){
				    		 
				    		 return "redirect:/cliente/"+urlClients[0];
				    	 }
				    	 
				    	 
				    	 
				     }
			      
			  }
	     }
		  
		 
		 
		  model.addAttribute("getUrlClients",urlClients);
	
		
		return "init";
	}
	
	@RequestMapping(value = "/authentication", method = RequestMethod.GET)
	public String clientAuth(@RequestParam(value = "auth", required = false) String auth,
						ModelMap model,
			            HttpServletRequest request,
			            HttpServletResponse response){
		
		
         
		 
		 String[] urlClients=null;
		
         if(auth!=null){
        	 
        	String urlclientBean= beanCodePrefix.getUrlClient();
        	
        	if(urlclientBean==null){
        		
        	  Cookie[] cookies = request.getCookies();
	      		  if (cookies != null){
	      			  for (Cookie cook : cookies){
	      				  
	      			          // System.out.println(cookie.getName() + " : " + cookie.getValue());
	      				  
	      				     if(cook.getName().equals("isCookieListUrlCC")){
	      				    	 
	      				    	 urlClients=cook.getValue().split("\\|");
	      				    	 
	      				    	 if(urlClients.length==1){
	      				    		 
	      				    		 return "redirect:/cliente/"+urlClients[0];
	      				    	 }
	      				    	 
	      				    	 
	      				    	 
	      				     }
	      			      
	      			  }
	      	     }
        		
        		
        	}else{
        		
        		return "redirect:/cliente/"+urlclientBean+"?auth=fail";
        	}
        	
        	
        	 

		}
		
       model.addAttribute("getUrlClients",urlClients);
		
		return "init";
	}
	
	
	
	@RequestMapping(value = "/{companyUserName}-{companyClientId}", method = RequestMethod.GET)
	public String login(@PathVariable("companyUserName") String companyUserName,
						@PathVariable("companyClientId") int companyClientId,
						@RequestParam(value = "auth", required = false) String auth,
			            @RequestParam(value = "logout", required = false) String logout,
			            ModelMap model,
			            HttpServletRequest request,
			            HttpServletResponse response
			           ){
		
		
		model.addAttribute("country",gSettings.getCountry());
		model.addAttribute("typeLogin",gSettings.getTypeLogin());
		
		int _distributionId=gSettings.getDistribution().get("distributionId");
		int _targetId = gSettings.getDistribution().get("targetId");
		int _countryId = gSettings.getDistribution().get("countryId");
		
		List<GetCodePrefixesByDistributionByCompanyClientResult> codePrefix= _PLMClientService.getCodePrefixesByDistributionByCountryByCompanyClientId(_distributionId,_targetId,_countryId, companyClientId);
		
		
		
		
	    
	    if(logout!=null){
	    	

            Authentication _authentication = SecurityContextHolder.getContext().getAuthentication();
			
			if (_authentication != null){    
		        new SecurityContextLogoutHandler().logout(request, response, _authentication);
		    }
			

		    beanCodePrefix.setCodePrefix(codePrefix.get(0).getPrefixName());
     	    beanCodePrefix.setUrlClient(companyUserName+"-"+companyClientId);
			
	
	    }
	    
	    

	    
	    
	    if(codePrefix.size()>0 && logout==null){
	    	
	    	
	    
		    beanCodePrefix.setCodePrefix(codePrefix.get(0).getPrefixName());
     	    beanCodePrefix.setUrlClient(companyUserName+"-"+companyClientId);
     	    
     	   Cookie[] cookies = request.getCookies();
     	    
	     	   if (cookies!=null && cookies.length>1){
	    			  for (Cookie cook : cookies){
	    				  
	    				     if(cook.getName().equals("isCookieListUrlCC")){
	    				    	 
	    				    	   String[] isCookieArray=cook.getValue().split("\\|");
	    				    	   
	    				    	   if( Arrays.asList(isCookieArray).contains(""+companyUserName+"-"+companyClientId+"") ) {
	    				    		   
	    				    		   
	    				    		}else{
	    				    			
	    				    			Cookie cookieURL = new Cookie("isCookieListUrlCC", cook.getValue()+companyUserName+"-"+companyClientId+"|");
			    				           cookieURL.setMaxAge(86400);
			    			           response.addCookie(cookieURL);
	    				    			
	    				    		}
	    				    	
	    				     }
	    			      
	    			  }
	    	     }else if(cookies == null || cookies[0].getName().equals("JSESSIONID")){
	    	    	 
	    	    	  Cookie cookieURL = new Cookie("isCookieListUrlCC", companyUserName+"-"+companyClientId+"|");
			           cookieURL.setMaxAge(86400);
		           response.addCookie(cookieURL);
	    	    	 
	    	     }
    
	    }
	    

	    System.out.println(beanCodePrefix.getCodePrefix());
        
        model.addAttribute("urlClient",beanCodePrefix.getUrlClient());
        
		return "login";
	}
	
	
	//registration By Active By Email
	
			@RequestMapping(value="{companyUserName}-{companyClientId}/registro-activacion-email/",method=RequestMethod.GET)
			public String RegisterActiveByEmailInit(Model model){
				
				
				model.addAttribute("typeLogin",gSettings.getTypeLogin());
				
				SaveAppServerClientWithouthLicenseInfo saveWebClient = new SaveAppServerClientWithouthLicenseInfo();
				
				model.addAttribute("saveWebClient",saveWebClient);
				model.addAttribute("getSpecialities",_PLMClientService.getSpecialities( gSettings.getProfesionId() ));
				model.addAttribute("getStates",_PLMClientService.getStatesByCountry( gSettings.getCountryIdClients() ));
				model.addAttribute("urlClient",beanCodePrefix.getUrlClient());
				
				
				return "registrationActiveByEmail";
			}
			
			@RequestMapping(value="{companyUserName}-{companyClientId}/registro-activacion-email/",method=RequestMethod.POST)
			public String RegisterActiveByEmailInitSubmit(@Valid @ModelAttribute("saveWebClient") SaveAppServerClientWithouthLicenseInfo saveWebClient, BindingResult result,ModelMap model){
				
				
				if(result.hasErrors()) {
					
					model.addAttribute("erroFormlogin","Verifique sus Datos *");
					
					model.addAttribute("typeLogin",gSettings.getTypeLogin());

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
			
			
	
	
	/*registro por codigo */
	@RequestMapping(value="/{companyUserName}-{companyClientId}/registro-codigo/",method=RequestMethod.GET)
	public String RegisterInit(@PathVariable("companyUserName") String companyUserName,
			                   @PathVariable("companyClientId") int companyClientId,
			                   Model model){
		
		
		SaveWebClientByPrefixByCode saveWebClient = new SaveWebClientByPrefixByCode();
        saveWebClient.setRegistrationCode("RT8U5I67");
		
		
		model.addAttribute("saveWebClient",saveWebClient);
		model.addAttribute("getSpecialities",_PLMClientService.getSpecialities( gSettings.getProfesionId() ));
		model.addAttribute("getStates",_PLMClientService.getStatesByCountry( gSettings.getCountryIdClients() ));
		
		
		return "registrationByCode";
	}
	
	@RequestMapping(value="/{companyUserName}-{companyClientId}/registro-codigo/",method=RequestMethod.POST)
	public String RegisterInitSubmit(@Valid @ModelAttribute("saveWebClient") SaveWebClientByPrefixByCode saveWebClient, BindingResult result,
										@PathVariable("companyUserName") String companyUserName,
							            @PathVariable("companyClientId") int companyClientId,
										ModelMap model){
		
		
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
	
	/* 
	 * Activación satisfactoria
	 * */
	
	@RequestMapping(value ="{companyUserName}-{companyClientId}/activacion-satisfactoria", method = RequestMethod.GET)
	public String initActiveTrue(@PathVariable("companyUserName") String companyUserName,
                                 @PathVariable("companyClientId") int companyClientId,
                                 @RequestParam(value = "code", required = true) String code,Model model,
                                 HttpServletRequest request,
         			             HttpServletResponse response
                                 ) {
		
		
		String codeString= code;
		
		if(codeString!=null){
			 	
			ActivateCodeStringResult _activeCode=	_PLMClientService.activateClientByCodeString(codeString);
			
			if(_activeCode!=null){
				CustomUser user = new CustomUser();
				
			    user.setUsername(_activeCode.getEmail());
	            user.setFirstName(_activeCode.getFirstName());
	            user.setLastName(_activeCode.getLastName());
	            user.setPassword(_activeCode.getPassword());  
	            
	            int _distributionId=gSettings.getDistribution().get("distributionId");
	    		int _targetId = gSettings.getDistribution().get("targetId");
	    		int _countryId = gSettings.getDistribution().get("countryId");
	            
	            
	            List<GetCodePrefixesByDistributionByCompanyClientResult>  codePrefix= _PLMClientService.getCodePrefixesByDistributionByCountryByCompanyClientId(_distributionId,_targetId,_countryId, companyClientId);
	    	    
	    	    
	    	    if(codePrefix!=null){
	    	    	
	    	    	
	    	    
	    		    beanCodePrefix.setCodePrefix(codePrefix.get(0).getPrefixName());
	         	    beanCodePrefix.setUrlClient(companyUserName+"-"+companyClientId);
	         	    

		       		 Cookie[] cookies = request.getCookies();
		       		 
		       		 if (cookies!=null && cookies.length>1){
		    			  for (Cookie cook : cookies){
		    				  
		    				     if(cook.getName().equals("isCookieListUrlCC")){
		    				    	 
		    				    	   String[] isCookieArray=cook.getValue().split("\\|");
		    				    	   
		    				    	   if( Arrays.asList(isCookieArray).contains(""+companyUserName+"-"+companyClientId+"") ) {
		    				    		   
		    				    		   
		    				    		}else{
		    				    			
		    				    			Cookie cookieURL = new Cookie("isCookieListUrlCC", cook.getValue()+companyUserName+"-"+companyClientId+"|");
				    				           cookieURL.setMaxAge(86400);
				    			           response.addCookie(cookieURL);
		    				    			
		    				    		}
		    				    	
		    				     }
		    			      
		    			  }
		    	     }else if(cookies == null || cookies[0].getName().equals("JSESSIONID")){
		    	    	 
		    	    	  Cookie cookieURL = new Cookie("isCookieListUrlCC", companyUserName+"-"+companyClientId+"|");
				           cookieURL.setMaxAge(86400);
			           response.addCookie(cookieURL);
		    	    	 
		    	     }
	       		 
	       		     
	    	    }
	            
	            
	            _authenticationProvider.autologin(user);
	            
	            return "redirect:/home?activacion=true";
            
			}
          
			
			
		}
		
		return "SuccessfulActivation";
	
	}
	
}
