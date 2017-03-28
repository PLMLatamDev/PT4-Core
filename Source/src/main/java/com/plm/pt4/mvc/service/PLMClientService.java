package com.plm.pt4.mvc.service;

import java.util.List;

import com.plm.pt4.mvc.model.CustomUser;
import com.plmlatina.model.ActivateCodeStringResult;
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



public interface PLMClientService {
	
   CustomUser loadUserByUsernameByPassword(String email,String password);
   
   //Nuevo   
   CustomUser getPharmacyUser(String email,String password);
   
   List<GetStateByCountryInfo> getStatesByCountry(int countryId);
   List<GetSpecialitiesInfo> getSpecialities(int professionId);
   SaveWebClientByPrefixByCodeResult SaveWebClientByPrefixByCode(SaveWebClientByPrefixByCode saveWebClientByPrefixByCode);
   List<GetLocationsByStateInfo> getLocationsByState(int stateId);
   List<GetSuburbsByLocationInfo> getSuburbsByLocation(int locationId);
   List<GetSuburbsZipCodeByLocationInfo> getSuburbsZipCodeByLocation(int locationId, int suburbId );
   List<GetSubspecialitiesResult> getSubspecialities(int specialityId);
   SaveAppServerClientResponse saveAppServerClient(SaveAppServerClientInfo saveAppServerClientInfo );
   String recoveryClientPassword(String email);
   boolean updateAppServerClient(UpdateAppServerClientInfo updateAppServerClientInfo );
   public String saveAppLicenseServerClient(SaveAppServerClientWithouthLicenseInfo saveAppServerClientWithouthLicenseInfo );
   public ActivateCodeStringResult activateClientByCodeString(String codeString );
   
   public List<GetCodePrefixesByDistributionByCompanyClientResult> getCodePrefixesByDistributionByCountryByCompanyClientId	(int distributionId,int targetId,int countryId, int companyClientId);

   
	

}
