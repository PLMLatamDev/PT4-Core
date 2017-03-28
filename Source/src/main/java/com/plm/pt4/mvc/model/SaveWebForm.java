package com.plm.pt4.mvc.model;

import com.plmlatina.model.SaveWebClientByPrefixByCode;

public class SaveWebForm extends SaveWebClientByPrefixByCode {
	
	private String confirmPassword;

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	

}
