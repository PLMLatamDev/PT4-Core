package com.plm.pt4.mvc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.plm.pt4.mvc.bean.BeanCodePrefix;
import com.plm.pt4.mvc.bean.BeanGeneralSettings;
import com.plm.pt4.mvc.model.CustomUser;
import com.plm.pt4.mvc.model.RoleUser;
import com.plm.pt4.mvc.model.encyclopedia.EncyclopediaTest;
import com.plm.pt4.mvc.model.encyclopedia.GetEncyclopediasByTypeByTextResult;
import com.plm.pt4.mvc.model.typeLogin.GetPharmacyUserResponse;
import com.plm.pt4.mvc.model.typeLogin.GetPharmacyUserResult;
import com.plmlatina.dao.manager.ManagerPLMClients;
import com.plmlatina.exception.PLMExceptions;
import com.plmlatina.model.ActivateCodeStringResult;
import com.plmlatina.model.GetAddressesByClientResult;
import com.plmlatina.model.GetClientByEmailByPasswordByPrefixResult;
import com.plmlatina.model.GetCodePrefixesByDistributionByCompanyClientResult;
import com.plmlatina.model.SaveAppServerClientInfo;
import com.plmlatina.model.SaveAppServerClientWithouthLicenseInfo;
import com.plmlatina.model.SaveWebClientByPrefixByCode;
import com.plmlatina.model.SaveWebClientByPrefixByCodeResult;
import com.plmlatina.model.UpdateAppServerClientInfo;
import com.plmlatina.model.catalog.GetLocationsByStateInfo;
import com.plmlatina.model.catalog.GetSpecialitiesInfo;
import com.plmlatina.model.catalog.GetStateByCountryInfo;
import com.plmlatina.model.catalog.GetSubspecialitiesResult;
import com.plmlatina.model.catalog.GetSuburbsByLocationInfo;
import com.plmlatina.model.catalog.GetSuburbsZipCodeByLocationInfo;
import com.plmlatina.result.SaveAppServerClientResponse;


@Service
public class PLMClientServiceImp implements PLMClientService {
	
	
	@Autowired
	BeanCodePrefix beanCodePrefix;
	
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/WEB-INF/spring/spring-import.xml");
    BeanGeneralSettings gSettings = (BeanGeneralSettings) context.getBean("beanGeneralSettings");
    ManagerPLMClients  managerClients = context.getBean(ManagerPLMClients.class);
	
	
    public CustomUser loadUserByUsernameByPassword(String username,String password) throws UsernameNotFoundException {
 	   
 	   CustomUser user = new CustomUser();
 	   
 	  String codePrefixByCompanyClient= beanCodePrefix.getCodePrefix();
 	   
 	   try{
 		   
            GetClientByEmailByPasswordByPrefixResult getClient = managerClients.getClientByEmailByPasswordByPrefix(username, password, codePrefixByCompanyClient);
            
            
            if(getClient!=null){
            	String uuid = java.util.UUID.randomUUID().toString();
            	user.setUuid(uuid);
	            user.setUsername(getClient.getEmail());
	            user.setFirstName(getClient.getFirstName());
	            user.setLastName(getClient.getLastName());
	            user.setPassword(getClient.getPassword());
	            user.setCodeString(getClient.getCodestring());
	            user.setCodeId( (int)getClient.getCodeId() );
	            user.setClientId((int)getClient.getClientId());
	            
	            
               //companyClient
	            
	            user.setUrlCompanyClient(beanCodePrefix.getUrlClient());
	            user.setCodePrefixCompanyClient(beanCodePrefix.getCodePrefix());
	            
	            
	            RoleUser r = new RoleUser();
	            r.setName("ROLE_USER");
	            List<RoleUser> roles = new ArrayList<RoleUser>();
	            roles.add(r);
	            user.setAuthorities(roles);
	           
	            return user;
            	
            }
            
            return null;
            
            
 			}catch(PLMExceptions e){
 			           e.getErrorMessage();
 			           return null;
 			         
 		  }
 	 
    }
    
    public CustomUser getPharmacyUser(String usr, String pwd){
		
		CustomUser user = new CustomUser();
		String url = "http://187.237.235.54/RestPLMClientsEngine/RestPLMClientsEngine.svc/getPharmacyUser?userName="+usr+"&userPassword="+pwd;
		
		GetPharmacyUserResponse response = getRestTemplate().getForObject(url, GetPharmacyUserResponse.class);
		GetPharmacyUserResult userResult = response.getGetPharmacyUserResult();
		
    	if( userResult!=null ){
    		String uuid = java.util.UUID.randomUUID().toString();
        	user.setUuid(uuid);
            user.setUsername(userResult.getUserName());
            user.setFirstName(userResult.getFirstName());
            user.setLastName(userResult.getLastName());
            user.setPassword(userResult.getUserPassword());
            user.setCodeString(userResult.getCodeString());
            user.setCodeId( (int)userResult.getCodeId() );
            user.setClientId((int)userResult.getCompanyClientId());
            
            
            RoleUser r = new RoleUser();
            r.setName("ROLE_USER");
            List<RoleUser> roles = new ArrayList<RoleUser>();
            roles.add(r);
            user.setAuthorities(roles);
    	}else{
    		user = null;
    	}
    	
		return user;
	}
    
    
    public List<GetStateByCountryInfo> getStatesByCountry(int countryId){
    	
    	List<GetStateByCountryInfo> getStates = new ArrayList<GetStateByCountryInfo>();
    	
    	try{
  		   
             
              getStates = managerClients.getStateByCountry(countryId);
              if(getStates.size()>0){
            	  getStates.remove(0);
            	  
              }
            
               return getStates;
	    	}catch(PLMExceptions e){
	    		
	    		e.getErrorMessage();
		           return getStates;
	    		
	    	}
    }
    
 public List<GetLocationsByStateInfo> getLocationsByState(int stateId){
    	
    	List<GetLocationsByStateInfo> getLocations = new ArrayList<GetLocationsByStateInfo>();
    	
    	try{
  		   
             
    		getLocations = managerClients.getLocationsByState(stateId);
              if(getLocations.size()>0){
            	  //getLocations.remove(0);
            	  
              }
            
               return getLocations;
	    	}catch(PLMExceptions e){
	    		
	    		e.getErrorMessage();
		           return getLocations;
	    		
	    	}
    }
 
	 public List<GetSuburbsByLocationInfo> getSuburbsByLocation(int locationId){
	 	
	 	List<GetSuburbsByLocationInfo> getSuburbs = new ArrayList<GetSuburbsByLocationInfo>();
	 	
	 	try{
			   
	          
	 		   getSuburbs = managerClients.getSuburbsByLocation(locationId);
	           if(getSuburbs.size()>0){
	         	  //getLocations.remove(0);
	         	  
	           }
	         
	            return getSuburbs;
		    	}catch(PLMExceptions e){
		    		
		    		e.getErrorMessage();
			           return getSuburbs;
		    		
		    	}
	 }
	 
	 public List<GetSuburbsZipCodeByLocationInfo> getSuburbsZipCodeByLocation(int locationId, int suburbId ){
		 	
		 	List<GetSuburbsZipCodeByLocationInfo> getZipcode = new ArrayList<GetSuburbsZipCodeByLocationInfo>();
		 	
		 	try{
				   
		          
		 		   getZipcode = managerClients.getSuburbsZipCodeByLocation(locationId, suburbId);
		           if(getZipcode.size()>0){
		         	  //getLocations.remove(0);
		         	  
		           }
		         
		            return getZipcode;
			    	}catch(PLMExceptions e){
			    		
			    		e.getErrorMessage();
				           return getZipcode;
			    		
			    	}
		 }
    
    public List<GetSpecialitiesInfo> getSpecialities(int professionId){
    	
    	List<GetSpecialitiesInfo> getSpecialities = new ArrayList<GetSpecialitiesInfo>();
    	
    	try{
    		
    		   getSpecialities = managerClients.getSpecialities(professionId);
    		   
    		   if(getSpecialities.size()>0){
    		    getSpecialities.remove(0);
    		   }
    		   
    		
    		  return getSpecialities;
	    	}catch(PLMExceptions e){
	    		
	    		e.getErrorMessage();
	    		return getSpecialities;
	    	}
    	
    	
    	
    }
    
 public List<GetSubspecialitiesResult> getSubspecialities(int specialityId){
    	
    	List<GetSubspecialitiesResult> getSubspecialities = new ArrayList<GetSubspecialitiesResult>();
    	
    	try{
    		
    		getSubspecialities = managerClients.getSubspecialities(specialityId);
    		   
    		   if(getSubspecialities!=null){
    			   getSubspecialities.remove(0);
    		   }
    		   
    		
    		  return getSubspecialities;
	    	}catch(PLMExceptions e){
	    		
	    		e.getErrorMessage();
	    		return getSubspecialities;
	    	}
    	
    	
    	
    }
    
    public SaveWebClientByPrefixByCodeResult SaveWebClientByPrefixByCode(SaveWebClientByPrefixByCode saveWebClientByPrefixByCode ){
    	
    	 
    	
    	  SaveWebClientByPrefixByCodeResult saveWeb = new SaveWebClientByPrefixByCodeResult();
    	  
    	  try{
    		  
    		  saveWebClientByPrefixByCode.setCodePrefix(gSettings.getPrefix());
    		  saveWebClientByPrefixByCode.setSource(String.valueOf(gSettings.getSourceId()));
    		  saveWebClientByPrefixByCode.setTarget(gSettings.getTargetId());
      		
    		     saveWeb = managerClients.saveWebClientByPrefixByCode(saveWebClientByPrefixByCode);

	   		      return saveWeb;
		    	}catch(PLMExceptions e){
		    		
		    		e.getErrorMessage();
		    		return saveWeb;
		    	}
    	  
    	  
    }
    
    public SaveAppServerClientResponse saveAppServerClient(SaveAppServerClientInfo saveAppServerClientInfo ){
    	
   	 
    	
    	SaveAppServerClientResponse saveApp = new SaveAppServerClientResponse();
  	  
  	  try{
  		  
  		  saveAppServerClientInfo.setTargetOutput(String.valueOf(gSettings.getTargetId()));
  		  saveAppServerClientInfo.setSource(String.valueOf(gSettings.getSourceId()));
  		  saveAppServerClientInfo.setHwIdentifier(String.valueOf( gSettings.getHwIdentifier() ));
  		  saveAppServerClientInfo.setOtherProfession("");
  	  
    		
  	      saveApp = managerClients.saveAppServerClient(saveAppServerClientInfo);

	   		      return saveApp;
		    	}catch(PLMExceptions e){
		    		
		    		e.getErrorMessage();
		    		return saveApp;
		    	}catch(Exception ex){
					  
		    		return saveApp;
				  	
				}
  	  
  	  
  }
    
 public boolean updateAppServerClient(UpdateAppServerClientInfo updateAppServerClientInfo ){
    	
   	 
    	
    	boolean update= false;
  	  
  	           try{
  		       
  	       
    		
  		             update = managerClients.updateAppServerClient(updateAppServerClientInfo);

	   		      return update;
		    	}catch(PLMExceptions e){
		    		
		    		e.getErrorMessage();
		    		return update;
		    	}
  	  
  	  
  }
    
    public String recoveryClientPassword(String email){
    	
    	
    	String recov="";
    	
    	try{
    		
    		recov = managerClients.recoveryClientPassword(email);
    		return recov;
    		
    	}catch(PLMExceptions e){
    		
    		
    		e.getErrorMessage();
    		return recov;
    	}
    	
    }
    
    
    public List<GetAddressesByClientResult> getAddressesByClient(int clientId){
    	
    	
    	List<GetAddressesByClientResult> getAddresses= new ArrayList<GetAddressesByClientResult>();
    	
    	try{
    		getAddresses=managerClients.getAddressesByClient(clientId);
    		
    		return getAddresses;
    		
    		
    	}catch(PLMExceptions e){
    		
    		e.getErrorMessage();
    		return getAddresses;
    		
    	}
    }
    
    public String saveAppLicenseServerClient(SaveAppServerClientWithouthLicenseInfo saveAppServerClientWithouthLicenseInfo ){
    	
      	 
    	 String saveApp = "";
       	 
         String codePrefixByCompanyClient= beanCodePrefix.getCodePrefix();
         	  
         	  try{
         		saveAppServerClientWithouthLicenseInfo.setPrefix(codePrefixByCompanyClient);
       	  		saveAppServerClientWithouthLicenseInfo.setTargetOutput(String.valueOf(gSettings.getTargetId()));
       	  		saveAppServerClientWithouthLicenseInfo.setSource(String.valueOf(gSettings.getSourceId()));
       	  		saveAppServerClientWithouthLicenseInfo.setHwIdentifier("1");
       	  		saveAppServerClientWithouthLicenseInfo.setOtherProfession("");
       	  		
       	  		//Url Email
       	  		//saveAppServerClientWithouthLicenseInfo.setRedirectingUrl(gSettings.getUrlEmailActive());
       	  		
       	  	    saveAppServerClientWithouthLicenseInfo.setRedirectingUrl(gSettings.getUrlEmailActive()+"cliente/"+beanCodePrefix.getUrlClient()+"/activacion-satisfactoria?code=");
       	  
         	 
         	    saveApp = managerClients.saveAppServerClient(saveAppServerClientWithouthLicenseInfo);

       	   		      return saveApp;
       		    	}catch(PLMExceptions e){
       		    		
       		    		e.getErrorMessage();
       		    		return saveApp;
       		    		
       		    	}catch(Exception ex){
       					  
       		    		return saveApp;
       				  	
       				}
     	  
     	  
     }

   	public ActivateCodeStringResult activateClientByCodeString(String codeString ){
   		
   	  	
   		
    	  
   	 	  try{
   	 		   
   	 		 ActivateCodeStringResult successfulActive = managerClients.activateCodeString(codeString);
   	
   		   		      return successfulActive;
   		   		      
   			    	}catch(PLMExceptions e){
   			    		
   			    	//	e.getErrorMessage();
   			    		return null;
   			    		
   			    	}catch(Exception ex){
   						  
   			    		return null;
   					  	
   					}
   	 	  

   	 }
   	
public List<GetCodePrefixesByDistributionByCompanyClientResult>  getCodePrefixesByDistributionByCountryByCompanyClientId(int distributionId,int targetId,int countryId, int companyClientId){
   		
		List<GetCodePrefixesByDistributionByCompanyClientResult>  codePrefix = new ArrayList<GetCodePrefixesByDistributionByCompanyClientResult>();
   		
   		try{
	 		   
   			  codePrefix = managerClients.getCodePrefixesByDistributionByCompanyClient(distributionId, targetId, countryId, companyClientId);

	          return codePrefix;
	    	}catch(PLMExceptions e){
	    		
	    		
	    		e.getErrorMessage();
	    		return codePrefix;
	    		
	    	}catch(Exception ex){
				  
	    		return codePrefix;
			  	
			}
}
   
	
	public RestTemplate getRestTemplate() {
		RestTemplate restTemplate = new RestTemplate();
        restTemplate.setMessageConverters(this.getMessageConverters());
        return restTemplate;
	}
	
	private List<HttpMessageConverter<?>> getMessageConverters() {
        List<HttpMessageConverter<?>> converters = new ArrayList<HttpMessageConverter<?>>();
        converters.add(new MappingJackson2HttpMessageConverter());
        return converters;
	}


}
