package com.plm.pt4.mvc.authentication;


import java.util.ArrayList;
import java.util.Collection;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.plm.pt4.mvc.bean.BeanGeneralSettings;
import com.plm.pt4.mvc.model.CustomUser;
import com.plm.pt4.mvc.model.RoleUser;
import com.plm.pt4.mvc.service.CustomUserService;
import com.plm.pt4.mvc.service.PLMClientService;


@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
	
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/WEB-INF/spring/spring-import.xml");
	BeanGeneralSettings gSettings = (BeanGeneralSettings) context.getBean("beanGeneralSettings");
	
	@Autowired
	private PLMClientService _PLMClientService;
	
	@Autowired
	private CustomUserService customUserService;
	
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
          String username = authentication.getName();
          String password = (String) authentication.getCredentials();
     
          	
            CustomUser user = ( gSettings.getTypeLogin()!=5 )?_PLMClientService.loadUserByUsernameByPassword(username,password):_PLMClientService.getPharmacyUser(username,password);
     
            if (user == null || !user.getUsername().equalsIgnoreCase(username)) {
                throw new BadCredentialsException("El usuario o la contraseña  no existen");
            }
            
            /*if (!customUserService.listLoggedInUsers(user,2)) {
//                throw new BadCredentialsException("Ya hay un sesión abierta con esta cuenta !!");
                throw new BadCredentialsException("Se excedio el número de usuarios con esta cuenta !!");
            }
            
            int resultUser = customUserService.listLoggedInUsers( user,gSettings.getSessionLimit() );
            if( resultUser==1 )
            	throw new BadCredentialsException("Se excedio el número de usuarios con esta cuenta !!");
            if( resultUser==2 )
            	throw new BadCredentialsException("Ya hay un sesión abierta con esta cuenta !!");
            	
            	*/
            
     
            Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
     
            return new UsernamePasswordAuthenticationToken(user, password, authorities);
    }
    
    public boolean supports(Class<?> arg0) {
        return true;
    }
    
    public void autologin(CustomUser customUser) {
        
      
         
    	CustomUser user = _PLMClientService.loadUserByUsernameByPassword(customUser.getUsername(),customUser.getPassword());
  
         Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
  
         UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken= new  UsernamePasswordAuthenticationToken(user, user.getPassword(), authorities);
         
         if (usernamePasswordAuthenticationToken.isAuthenticated()) {
               
               SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
               
              
           }

        
     }
    
    public void NoUserRegistration(CustomUser user){
    	
  	  RoleUser r = new RoleUser();
        r.setName("ROLE_USER");
        List<RoleUser> roles = new ArrayList<RoleUser>();
        roles.add(r);
        user.setAuthorities(roles);
       
  	
	  	Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
	  	  
	      UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken= new  UsernamePasswordAuthenticationToken(user, user.getPassword(), authorities);
	      
	      if (usernamePasswordAuthenticationToken.isAuthenticated()) {
	            
	            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
	            
	           
	        }
	  	
	  	
	  }
	
	
	

}
