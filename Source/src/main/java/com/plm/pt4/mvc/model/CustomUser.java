package com.plm.pt4.mvc.model;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.servlet.ModelAndView;

import com.plmlatina.model.GetReportByIdResult;

public class CustomUser extends SearchGeneral implements UserDetails  {
	
	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
	private String email;
	private String firstName;
	private String lastName;
	private String secondLastName;
	private int clientId;
	private String codeString;
	private int codeId;
	private String uuid;
	private ModelAndView modelAndView;
	
	private boolean addAddres;
	
	private String urlCompanyClient;
	private String codePrefixCompanyClient;
	
	/* Spring Security related fields*/
    private List<RoleUser> authorities;
    private boolean accountNonExpired = true;
    private boolean accountNonLocked = true;
    private boolean credentialsNonExpired = true;
    private boolean enabled = true;
    private GetReportByIdResult report;
    
    
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getSecondLastName() {
		return secondLastName;
	}
	public void setSecondLastName(String secondLastName) {
		this.secondLastName = secondLastName;
	}
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public String getCodeString() {
		return codeString;
	}
	public void setCodeString(String codeString) {
		this.codeString = codeString;
	}
	public List<RoleUser> getAuthorities() {
		return authorities;
	}
	public void setAuthorities(List<RoleUser> authorities) {
		this.authorities = authorities;
	}
	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}
	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}
	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}
	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public int getCodeId() {
		return codeId;
	}
	public void setCodeId(int codeId) {
		this.codeId = codeId;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public boolean isAddAddres() {
		return addAddres;
	}
	public void setAddAddres(boolean addAddres) {
		this.addAddres = addAddres;
	}
    
	public ModelAndView getModelAndView() {
		return modelAndView;
	}
	public void setModelAndView(ModelAndView modelAndView) {
		this.modelAndView = modelAndView;
	}
	public GetReportByIdResult getReport() {
		return report;
	}
	public void setReport(GetReportByIdResult report) {
		this.report = report;
	}
	public String getUrlCompanyClient() {
		return urlCompanyClient;
	}
	public void setUrlCompanyClient(String urlCompanyClient) {
		this.urlCompanyClient = urlCompanyClient;
	}
	public String getCodePrefixCompanyClient() {
		return codePrefixCompanyClient;
	}
	public void setCodePrefixCompanyClient(String codePrefixCompanyClient) {
		this.codePrefixCompanyClient = codePrefixCompanyClient;
	}
	
	

}
