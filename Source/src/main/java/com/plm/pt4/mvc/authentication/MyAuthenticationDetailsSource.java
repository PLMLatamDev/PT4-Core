package com.plm.pt4.mvc.authentication;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;

@Component
public class MyAuthenticationDetailsSource extends WebAuthenticationDetailsSource {
	
	@Override
	  public WebAuthenticationDetails buildDetails(HttpServletRequest context) {
	    return new MyAuthenticationDetails(context);
	  }

	  @SuppressWarnings("serial")
	  class MyAuthenticationDetails extends WebAuthenticationDetails {

	    private final String referer;

	    public MyAuthenticationDetails(HttpServletRequest request) {
	      super(request);
	      this.referer = request.getHeader("Referer");
	    }

	    public String getReferer() {
	      return referer;
	    }
	  }

}
