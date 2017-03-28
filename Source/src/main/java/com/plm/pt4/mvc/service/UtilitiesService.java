package com.plm.pt4.mvc.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.plm.pt4.mvc.bean.BeanGeneralSettings;
import com.plm.pt4.mvc.model.CustomUser;
import com.plmlatina.dao.manager.ManagerMetadata;
import com.plmlatina.dao.manager.ManagerPLMClients;
import com.plmlatina.dao.manager.ManagerPLMContraindications;
import com.plmlatina.dao.manager.ManagerPLMInteractions;
import com.plmlatina.dao.manager.ManagerPLMUtilities;
import com.plmlatina.dao.manager.ManagerPharmaSearch;
import com.plmlatina.exception.PLMExceptions;
import com.plmlatina.model.GetAddressesByClientResult;
import com.plmlatina.model.GetAllAttributesByProductInfo;
import com.plmlatina.model.GetAllAttributesByProductResult;
import com.plmlatina.model.GetClientDetailCompleteByEmailResult;
import com.plmlatina.model.GetClientResult;
import com.plmlatina.model.GetContraindicationsByProductsInfo;
import com.plmlatina.model.GetDrugShortInformationResult;
import com.plmlatina.model.GetDrugsDetailByTherapeuticResult;
import com.plmlatina.model.GetDrugsShortDetailByICDResult;
import com.plmlatina.model.GetDrugsShortDetailByLabResult;
import com.plmlatina.model.GetDrugsShortDetailBySubstanceResult;
import com.plmlatina.model.GetICDByDrugsResult;
import com.plmlatina.model.GetICDResult;
import com.plmlatina.model.GetIMDDIProductInteractionSubstancesInfo;
import com.plmlatina.model.GetInformationByPrefixByTypeResult;
import com.plmlatina.model.GetInteractionsByEditionProductsInfo;
import com.plmlatina.model.GetMealInteractionsByProductsInfo;
import com.plmlatina.model.GetMedicalGuidelinesByTextResult;
import com.plmlatina.model.GetMedicalPrescriptionResult;
import com.plmlatina.model.GetMedicalPrescriptionsByDateResult;
import com.plmlatina.model.GetReportByIdResult;
import com.plmlatina.model.GetReportsByCodeResult;
import com.plmlatina.model.GetReportsByCompanyResult;
import com.plmlatina.model.GetResultsDetailAndGetMedicalGuidelinesByTextAndGetTherapeuticsInfo;
import com.plmlatina.model.GetResultsDetailResult;
import com.plmlatina.model.GetScientificArticlesResult;
import com.plmlatina.model.MedicalPrescription;
import com.plmlatina.model.SaveClientAddressesInfo;
import com.plmlatina.model.SaveReportInfo;
import com.plmlatina.model.UpdateAddressByClientInfo;
import com.plmlatina.result.ContraindicationsByProductsResponse;
import com.plmlatina.result.GetClientInformationDetailByEmailResponse;
import com.plmlatina.result.GetDrugShortInformationResponse;
import com.plmlatina.result.IMDDIProductInteractionSubstancesResponse;
import com.plmlatina.result.InteractionsByEditionProductsResponse;
import com.plmlatina.result.MealInteractionsByProductsResponse;

@Service
public class UtilitiesService {
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/WEB-INF/spring/spring-import.xml");
	BeanGeneralSettings gSettings = (BeanGeneralSettings) context.getBean("beanGeneralSettings");

	/**** Métodos PharmaSearch ****/

	// Busqueda por medicamento
	public GetDrugShortInformationResult pharmaSearchGetDrugShortInformation(int divisionId, int categoryId,
			int pharmaFormId, int drugId) {

		CustomUser userDetails = (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		GetDrugShortInformationResult resultDrugShortInformation = null;
		try {
			ManagerPharmaSearch managerPharmaSearch = context.getBean(ManagerPharmaSearch.class);
			resultDrugShortInformation = managerPharmaSearch.getDrugShortInformation(userDetails.getCodeString(),
					gSettings.getCountryIdPharma(), gSettings.getEditionId(), divisionId, categoryId, pharmaFormId,
					drugId);
			return resultDrugShortInformation;
		} catch (PLMExceptions e) {
			e.getErrorMessage();
			return resultDrugShortInformation;
		}

	}

	// Busqueda por Sustancia
	public List<GetDrugsShortDetailBySubstanceResult> pharmaSearchGetDrugsShortDetailBySubstance(int substanceId) {
		CustomUser userDetails = (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<GetDrugsShortDetailBySubstanceResult> listDrugsShortDetailBySubstance = new ArrayList<GetDrugsShortDetailBySubstanceResult>();
		try {
			ManagerPharmaSearch managerPharmaSearch = context.getBean(ManagerPharmaSearch.class);
			listDrugsShortDetailBySubstance = managerPharmaSearch.getDrugsShortDetailBySubstance(
					userDetails.getCodeString(), gSettings.getCountryIdPharma(), gSettings.getEditionId(), substanceId);
			return listDrugsShortDetailBySubstance;
		} catch (PLMExceptions e) {
			e.getErrorMessage();
			return listDrugsShortDetailBySubstance;
		}
	}

	// Busqueda por Laboratorio
	public List<GetDrugsShortDetailByLabResult> pharmaSearchGetDrugsShortDetailByLab(int labId) {
		CustomUser userDetails = (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<GetDrugsShortDetailByLabResult> listDrugsShortDetailByLab = new ArrayList<GetDrugsShortDetailByLabResult>();
		try {
			ManagerPharmaSearch managerPharmaSearch = context.getBean(ManagerPharmaSearch.class);
			listDrugsShortDetailByLab = managerPharmaSearch.getDrugsShortDetailByLab(userDetails.getCodeString(),
					gSettings.getCountryIdPharma(), gSettings.getEditionId(), labId);
			return listDrugsShortDetailByLab;
		} catch (PLMExceptions e) {
			e.getErrorMessage();
			return listDrugsShortDetailByLab;
		}
	}

	// Busqueda por cie-10
	public List<GetDrugsShortDetailByICDResult> pharmaSearchGetDrugsShortDetailByICD(int icdId) {
		CustomUser userDetails = (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<GetDrugsShortDetailByICDResult> listDrugsShortDetailByICDResult = new ArrayList<GetDrugsShortDetailByICDResult>();
		try {
			ManagerPharmaSearch managerPharmaSeacrh = context.getBean(ManagerPharmaSearch.class);
			listDrugsShortDetailByICDResult = managerPharmaSeacrh.getDrugsShortDetailByICD(userDetails.getCodeString(),
					gSettings.getCountryIdPharma(), gSettings.getEditionId(), icdId);
			return listDrugsShortDetailByICDResult;
		} catch (PLMExceptions e) {
			e.getErrorMessage();
			return listDrugsShortDetailByICDResult;
		}
	}

	// Obtiene Descripción del cie-10
	public GetICDResult pharmaSearchGetICD(int icdId) {
		CustomUser userDetails = (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		GetICDResult icdResult = null;
		try {
			ManagerPharmaSearch managerPharmaSeacrh = context.getBean(ManagerPharmaSearch.class);
			icdResult = managerPharmaSeacrh.getICD(userDetails.getCodeString(), icdId);
			return icdResult;
		} catch (PLMExceptions e) {
			e.getErrorMessage();
			return icdResult;
		}
	}

	// Busqueda por ATC
	public List<GetDrugsDetailByTherapeuticResult> pharmaSeacrhGetDrugsDetailByTherapeutic(int therapeuticId) {
		CustomUser userDetails = (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<GetDrugsDetailByTherapeuticResult> listGetDrugsDetailByTherapeuticResult = new ArrayList<GetDrugsDetailByTherapeuticResult>();
		try {
			ManagerPharmaSearch managerPharmaSearch = context.getBean(ManagerPharmaSearch.class);
			listGetDrugsDetailByTherapeuticResult = managerPharmaSearch.getDrugsDetailByTherapeutic(
					userDetails.getCodeString(), gSettings.getCountryIdPharma(), gSettings.getEditionId(),
					therapeuticId);
			return listGetDrugsDetailByTherapeuticResult;
		} catch (PLMExceptions e) {
			e.getErrorMessage();
			return listGetDrugsDetailByTherapeuticResult;
		}

	}

	// Busqueda por palabra y por Guías Clínicas
	public GetResultsDetailAndGetMedicalGuidelinesByTextAndGetTherapeuticsInfo pharmaSearchGetResultDetail(
			String searchText) {
		CustomUser userDetails = (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		GetResultsDetailAndGetMedicalGuidelinesByTextAndGetTherapeuticsInfo resultDetail = null;
		try {
			ManagerPharmaSearch managerPharmaSearch = context.getBean(ManagerPharmaSearch.class);
			resultDetail = managerPharmaSearch.getResultsDetailAndGetMedicalGuidelinesByTextAndGetTherapeutics(
					userDetails.getCodeString(), gSettings.getCountryIdPharma(), gSettings.getEditionId(), searchText,
					gSettings.getPrefix());
			return resultDetail;
		} catch (PLMExceptions e) {
			e.getErrorMessage();
			return resultDetail;
		}

	}

	// Detalle del producto Atributos
	public GetAllAttributesByProductResult pharmaGetAllAttributesByProductResult(int divisionId, int categoryId,
			int productId, int pharmaFormId) {
		CustomUser userDetails = (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		GetAllAttributesByProductResult getAllAttributesByProductResult = null;
		try {
			ManagerPharmaSearch managerPharmaSearch = context.getBean(ManagerPharmaSearch.class);
			GetAllAttributesByProductInfo getAllAttributesByProductInfo = new GetAllAttributesByProductInfo();

			getAllAttributesByProductInfo.setCode(userDetails.getCodeString());
			getAllAttributesByProductInfo.setCountryId(gSettings.getCountryIdPharma());
			getAllAttributesByProductInfo.setEditionId(gSettings.getEditionId());
			getAllAttributesByProductInfo.setDivisionId(divisionId);
			getAllAttributesByProductInfo.setCategoryId(categoryId);
			getAllAttributesByProductInfo.setProductId(productId);
			getAllAttributesByProductInfo.setPharmaFormId(pharmaFormId);
			getAllAttributesByProductInfo.setResolutionKey(gSettings.getResolutionKey());

			getAllAttributesByProductResult = managerPharmaSearch
					.getAllAttributesByProduct(getAllAttributesByProductInfo);
			return getAllAttributesByProductResult;
		} catch (PLMExceptions e) {
			e.getErrorMessage();
			return getAllAttributesByProductResult;
		}

	}

	// Detalle del producto ICD
	public List<GetICDByDrugsResult> pharmaGetICDByDrugs(int productId) {
		CustomUser userDetails = (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<GetICDByDrugsResult> listICDDrugs = new ArrayList<GetICDByDrugsResult>();
		try {
			ManagerPharmaSearch managerPharmaSearch = context.getBean(ManagerPharmaSearch.class);
			listICDDrugs = managerPharmaSearch.getICDByDrugs(userDetails.getCodeString(), gSettings.getEditionId(),
					productId);
			return listICDDrugs;
		} catch (PLMExceptions e) {
			e.getErrorMessage();
			return listICDDrugs;
		}

	}

	/**** Métodos MetadataService ****/

	// Pubmed
	public List<GetScientificArticlesResult> metadataServiceGetScientificArticles(String substance) {
		CustomUser userDetails = (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<GetScientificArticlesResult> listScientificArticles = new ArrayList<GetScientificArticlesResult>();
		try {
			ManagerMetadata pt4ServicesConfig = context.getBean(ManagerMetadata.class);
			listScientificArticles = pt4ServicesConfig.getScientificArticles(userDetails.getCodeString(), substance,
					gSettings.getValuePubMed());
			return listScientificArticles;
		} catch (final Exception ex) {
			ex.printStackTrace();
			return listScientificArticles;
		}

	}

	/**** Métodos Clients ****/

	// Busqueda Guía Clínica
	public List<GetMedicalGuidelinesByTextResult> plmClientsGetMedicalGuideLines(String text) {
		List<GetMedicalGuidelinesByTextResult> listResultGuides = new ArrayList<GetMedicalGuidelinesByTextResult>();
		try {
			ManagerPLMClients pt4ServicesConfig = context.getBean(ManagerPLMClients.class);
			listResultGuides = pt4ServicesConfig.getMedicalGuidelinesByText("MEDPLMMED", text);
			return listResultGuides;
		} catch (final Exception ex) {
			ex.printStackTrace();
			return listResultGuides;
		}
	}

	// Método Abstracts
	public List<GetInformationByPrefixByTypeResult> getInformationByPrefixByType() {
		List<GetInformationByPrefixByTypeResult> listGetInformationByPrefixByTypeResult = null;
		try {
			ManagerPLMClients managerPLMClients = context.getBean(ManagerPLMClients.class);
			listGetInformationByPrefixByTypeResult = managerPLMClients.getInformationByPrefixByType(
					gSettings.getPrefix(), gSettings.getTargetId(), gSettings.getInformationTypeId(),
					gSettings.getCountry());
			return listGetInformationByPrefixByTypeResult;
		} catch (PLMExceptions e) {
			e.getErrorMessage();
			return listGetInformationByPrefixByTypeResult;
		}

	}

	/**** Método Contraindicaciones ****/

	// Contraindications
	public ContraindicationsByProductsResponse[] plmContraindications(
			List<GetContraindicationsByProductsInfo> listGetContraindicationsByProductsInfo) {
		CustomUser userDetails = (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		ContraindicationsByProductsResponse[] contraIndicationsResult = null;
		try {
			ManagerPLMContraindications managerPLMInteractions = context.getBean(ManagerPLMContraindications.class);
			return contraIndicationsResult = managerPLMInteractions.getContraindicationsByProducts(
					userDetails.getCodeString(), gSettings.getCountryIdPharma(), gSettings.getEditionId(),
					listGetContraindicationsByProductsInfo);
		} catch (PLMExceptions ex) {
			ex.getErrorMessage();
			return contraIndicationsResult;
		}
	}

	/**** Métodos PLMInteractions ****/

	// InteractionsByEditionProducts
	public InteractionsByEditionProductsResponse[] plmInteractionsByproducts(
			List<GetInteractionsByEditionProductsInfo> listGetInteractionsByEditionProductsInfo) {
		CustomUser userDetails = (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		InteractionsByEditionProductsResponse[] interactionByProductResult = null;
		try {
			ManagerPLMInteractions managerPLMInteractions = context.getBean(ManagerPLMInteractions.class);
			return interactionByProductResult = managerPLMInteractions.getInteractionsByEditionProducts(
					userDetails.getCodeString(), gSettings.getCountryIdPharma(), gSettings.getEditionId(),
					listGetInteractionsByEditionProductsInfo);
		} catch (PLMExceptions ex) {
			ex.getErrorMessage();
			return interactionByProductResult;
		}
	}

	// IMDDIProductInteractionSubstances
	public IMDDIProductInteractionSubstancesResponse[] plmInteractionsProductInteractionSubstances(
			List<GetIMDDIProductInteractionSubstancesInfo> listGetIMDDIProductInteractionSubstancesInfo) {
		CustomUser userDetails = (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		IMDDIProductInteractionSubstancesResponse[] ddiResult = null;
		try {
			ManagerPLMInteractions managerPLMInteractions = context.getBean(ManagerPLMInteractions.class);
			return ddiResult = managerPLMInteractions.getIMDDIProductInteractionSubstances(userDetails.getCodeString(),
					gSettings.getCountryIdPharma(), gSettings.getEditionId(),
					listGetIMDDIProductInteractionSubstancesInfo);
		} catch (PLMExceptions ex) {
			ex.getErrorMessage();
			return ddiResult;
		}
	}

	// MealInteractions
	public MealInteractionsByProductsResponse[] plmInteractionsMealInteractions(
			List<GetMealInteractionsByProductsInfo> listGetMealInteractionsByProductsInfo) {
		CustomUser userDetails = (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		MealInteractionsByProductsResponse[] mealInteractionsResult = null;
		try {
			ManagerPLMInteractions managerPLMInteractions = context.getBean(ManagerPLMInteractions.class);
			return mealInteractionsResult = managerPLMInteractions.getMealInteractionsByProducts(
					userDetails.getCodeString(), gSettings.getCountryIdPharma(), gSettings.getEditionId(),
					listGetMealInteractionsByProductsInfo);
		} catch (PLMExceptions ex) {
			ex.getErrorMessage();
			return mealInteractionsResult;
		}
	}

	// Obtener direccion
	public List<GetAddressesByClientResult> getAddressesByClient(int clientId) {

		try {
			ManagerPLMClients managerPLMClients = context.getBean(ManagerPLMClients.class);
			return managerPLMClients.getAddressesByClient(clientId);
		} catch (PLMExceptions ex) {
			ex.getErrorMessage();
			return null;
		}
	}

	public boolean updateAddressInfo(UpdateAddressByClientInfo updateAddressByClientInfo) {

		try {
			ManagerPLMClients managerPLMClients = context.getBean(ManagerPLMClients.class);
			boolean updateOk = managerPLMClients.updateAddressInfo(updateAddressByClientInfo);

			return updateOk;

		} catch (PLMExceptions e) {

			e.getErrorMessage();
			return false;

		}
	}

	public boolean saveClientAddresses(SaveClientAddressesInfo saveClientAddressesInfo) {

		boolean saveAddresses = false;

		try {
			ManagerPLMClients managerPLMClients = context.getBean(ManagerPLMClients.class);
			saveAddresses = managerPLMClients.saveClientAddresses(saveClientAddressesInfo);

			return saveAddresses;

		} catch (PLMExceptions ex) {

			ex.getErrorMessage();
			return saveAddresses;
		}
	}

	// Obtener cliente
	public GetClientResult getClient(int clientId) {

		try {
			ManagerPLMClients managerPLMClients = context.getBean(ManagerPLMClients.class);
			return managerPLMClients.getClient(clientId);
		} catch (PLMExceptions ex) {
			ex.getErrorMessage();
			return null;
		}
	}

	// Obtener detalle completo del cliente
	public GetClientDetailCompleteByEmailResult getClientDetailCompleteByEmail(String email) {

		try {
			ManagerPLMClients managerPLMClients = context.getBean(ManagerPLMClients.class);
			return managerPLMClients.getClientDetailCompleteByEmail(email);
		} catch (PLMExceptions ex) {
			ex.getErrorMessage();
			return null;
		}
	}

	public GetClientInformationDetailByEmailResponse getClientInformationDetailByEmail(String email) {

		try {
			ManagerPLMClients managerPLMClients = context.getBean(ManagerPLMClients.class);
			return managerPLMClients.getClientInformationDetailByEmail(email);
		} catch (PLMExceptions ex) {
			ex.getErrorMessage();
			return null;
		}
	}

	public boolean saveMedicalPrescription(String codeString, MedicalPrescription medicalPrescription) {

		try {
			ManagerPLMUtilities managerPLMUtilities = context.getBean(ManagerPLMUtilities.class);
			return managerPLMUtilities.saveMedicalPrescription(codeString, medicalPrescription);
		} catch (PLMExceptions ex) {
			ex.getErrorMessage();
			return false;
		} catch (Exception e) {

			e.getMessage();
			return false;
		}
	}

	public List<GetMedicalPrescriptionsByDateResult> getMedicalPrescriptionsByDate(String codeString, String date) {

		try {
			ManagerPLMUtilities managerPLMUtilities = context.getBean(ManagerPLMUtilities.class);
			return managerPLMUtilities.getMedicalPrescriptionsByDate(codeString, date);
		} catch (PLMExceptions ex) {
			ex.getErrorMessage();
			return null;
		}
	}

	public List<GetMedicalPrescriptionsByDateResult> getMedicalPrescriptionsByRangeDate(String codeString,
			String initialDate, String finalDate) {

		try {
			ManagerPLMUtilities managerPLMUtilities = context.getBean(ManagerPLMUtilities.class);
			return managerPLMUtilities.getMedicalPrescriptionsByRangeDate(codeString, initialDate, finalDate);
		} catch (PLMExceptions ex) {
			ex.getErrorMessage();
			return null;
		}
	}

	public GetMedicalPrescriptionResult getMedicalPrescripcion(int prescriptionId) {
		try {
			ManagerPLMUtilities managerPLMUtilities = context.getBean(ManagerPLMUtilities.class);
			return managerPLMUtilities.getMedicalPrescription(prescriptionId);
		} catch (PLMExceptions ex) {
			ex.getErrorMessage();
			return null;
		}
	}

	public boolean saveReport(SaveReportInfo saveReportInfo, String codeString, int type) {
		try {
			ManagerPLMUtilities managerPLMUtilities = context.getBean(ManagerPLMUtilities.class);
			return managerPLMUtilities.saveReport(saveReportInfo, codeString, type);
		} catch (PLMExceptions ex) {
			ex.getErrorMessage();
			return false;
		}
	}

	// REPORT
	public List<GetReportsByCompanyResult> getReportsByCompany(int companyClientId) throws PLMExceptions {
		try {
			ManagerPLMUtilities managerPLMUtilities = context.getBean(ManagerPLMUtilities.class);
			return managerPLMUtilities.getReportsByCompany(companyClientId);
		} catch (PLMExceptions ex) {
			ex.getErrorMessage();
			return null;
		}
	}

	public GetReportByIdResult getReportById(int reportId) throws PLMExceptions {
		try {
			ManagerPLMUtilities managerPLMUtilities = context.getBean(ManagerPLMUtilities.class);
			return managerPLMUtilities.getReportById(reportId);
		} catch (PLMExceptions ex) {
			ex.getErrorMessage();
			return null;
		}
	}
	public List<GetReportsByCodeResult> getReportsByCode(String code) throws PLMExceptions {
		try {
			ManagerPLMUtilities managerPLMUtilities = context.getBean(ManagerPLMUtilities.class);
			return managerPLMUtilities.getReportsByCode(code);
		} catch (PLMExceptions ex) {
			ex.getErrorMessage();
			return null;
		}
	}
	
	public boolean updateReport(SaveReportInfo saveReportInfo, String codeString, int type) {
		try {
			ManagerPLMUtilities managerPLMUtilities = context.getBean(ManagerPLMUtilities.class);
			return managerPLMUtilities.updateReport(saveReportInfo, codeString, type);
		} catch (PLMExceptions ex) {
			ex.getErrorMessage();
			return false;
		}
	}

	public int getOld(String birthday) {

		String[] fulldate = birthday.replace("/Date(", "").replace(")/", "").split("-");
		Long dateFromClient = Long.parseLong(fulldate[0]);
		Date fechaNac = null;
		try {
			fechaNac = new Date(dateFromClient);
			// fechaNac = new SimpleDateFormat("yyyy-MM-dd").parse(fechita);
			System.out.println(fechaNac.toString());
		} catch (Exception ex) {
			System.out.println("Error:" + ex);
		}
		Calendar fechaNacimiento = Calendar.getInstance();
		// Se crea un objeto con la fecha actual
		Calendar fechaActual = Calendar.getInstance();
		// Se asigna la fecha recibida a la fecha de nacimiento.
		fechaNacimiento.setTime(fechaNac);
		// Se restan la fecha actual y la fecha de nacimiento
		int anio = fechaActual.get(Calendar.YEAR) - fechaNacimiento.get(Calendar.YEAR);
		int mes = fechaActual.get(Calendar.MONTH) - fechaNacimiento.get(Calendar.MONTH);
		int dia = fechaActual.get(Calendar.DATE) - fechaNacimiento.get(Calendar.DATE);
		// Se ajusta el año dependiendo el mes y el día
		if (mes < 0 || (mes == 0 && dia < 0)) {
			anio--;
		}
		// Regresa la edad en base a la fecha de nacimiento
		return anio;
	}
	
	public String getDate(String dateInString) {

		String[] fulldate = dateInString.replace("/Date(", "").replace(")/", "").split("-");
		Long dateFromClient = Long.parseLong(fulldate[0]);
		Date date = null;
		try {
			date = new Date(dateFromClient);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			return calendar.get(Calendar.DATE) + "/" + (calendar.get(Calendar.MONTH) + 1) + "/"
					+ calendar.get(Calendar.YEAR);
		} catch (Exception ex) {
			System.out.println("Error:" + ex);
			return null;
		}

	}
}
