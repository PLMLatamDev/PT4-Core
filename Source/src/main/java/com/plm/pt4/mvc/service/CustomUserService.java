package com.plm.pt4.mvc.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.plm.pt4.mvc.model.CustomUser;
import com.plm.pt4.mvc.model.RoleUser;



@Service
public class CustomUserService implements UserDetailsService {
    
	
	  @Autowired
	  private SessionRegistry sessionRegistry;
    
   
   public CustomUser loadUserByUsername(String username) throws UsernameNotFoundException {
	   
	   CustomUser user = new CustomUser();
	  
	   
       return user;
   }
   
  
   public int listLoggedInUsers(CustomUser user ,int sessionLimit) {
	   /****
	    * 0 = true
	    * 1 = Se excedio el número de usuarios con esta cuenta 
	    * 2 = Ya hay un sesión abierta con esta cuenta
	    */
	   final List<Object> allPrincipals = sessionRegistry.getAllPrincipals();
	   int count=0;
	   for(final Object principal : allPrincipals) {
		   final CustomUser uservalidate = (CustomUser) principal;
		   if( uservalidate.getUsername().equals(user.getUsername()) ) 
			   count++;
	   }
		   
	   if( count>=sessionLimit ) 
		   return 1;
	   
	   if( allPrincipals.size()>=sessionLimit )
		   return 2;
		      
	   return 0;
   }

}
