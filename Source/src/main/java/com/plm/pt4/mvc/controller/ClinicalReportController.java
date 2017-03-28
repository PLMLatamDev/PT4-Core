package com.plm.pt4.mvc.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.plm.pt4.mvc.model.CustomUser;
import com.plm.pt4.mvc.model.SearchGeneral;
import com.plm.pt4.mvc.bean.BeanGeneralSettings;
import com.plm.pt4.mvc.model.ClinicalReportInfo;
import com.plm.pt4.mvc.service.UtilitiesService;
import com.plmlatina.exception.PLMExceptions;
import com.plmlatina.model.ATCOMSDoubleness;
import com.plmlatina.model.ActiveSubstanceContraindication;
import com.plmlatina.model.GetReportByIdResult;
import com.plmlatina.model.GetReportsByCodeResult;
import com.plmlatina.model.GetReportsByCompanyResult;
import com.plmlatina.model.IMDDIReference;
import com.plmlatina.model.InteractionSubstance;
import com.plmlatina.model.MealInteraction;
import com.plmlatina.model.PharmacologicalGroup;
import com.plmlatina.model.Product;
import com.plmlatina.model.SaveReportInfo;
import com.plmlatina.model.Severities;
import com.plmlatina.result.ContraindicationsByProductsResponse;
import com.plmlatina.result.GetDefinedDailyDoseByDrugsResponse;
import com.plmlatina.result.GetPregnancyRisksByDrugsResponse;
import com.plmlatina.result.GetSubstanceIncompatibilitiesByProductsResponse;
import com.plmlatina.result.GetTherapeuticDoublenessByDrugsResponse;
import com.plmlatina.result.IMDDIProductInteractionSubstancesResponse;
import com.plmlatina.result.InteractionsByEditionProductsResponse;
import com.plmlatina.result.MealInteractionsByProductsResponse;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import com.plm.pt4.mvc.model.SelectedDrugs;
import com.plm.pt4.mvc.model.report.IContraindication;
import com.plm.pt4.mvc.model.report.IIMDDIinteractions;
import com.plm.pt4.mvc.model.report.IMeal;
import com.plm.pt4.mvc.model.report.IPharmacologicalGroups;
import com.plm.pt4.mvc.model.report.ISubstances;
import com.plm.pt4.mvc.model.report.ITherapeuticDoubleness;

@Controller
@RequestMapping(value = "/reporte")
public class ClinicalReportController {
	
	@Autowired
	UtilitiesService uService;
	
	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/WEB-INF/spring/spring-import.xml");
    BeanGeneralSettings gSettings = (BeanGeneralSettings) context.getBean("beanGeneralSettings");
	
	@RequestMapping(value = "/", method=RequestMethod.GET)
	public String getReport(Model model) {
		
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			CustomUser userDetails = (CustomUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			List<SelectedDrugs> drugs = userDetails.getSelectedDrugs();
			ContraindicationsByProductsResponse[] contraindications = userDetails.getArrayContraindications();
			GetDefinedDailyDoseByDrugsResponse[] DailyDose = userDetails.getArrayDefinedDailyDoseByDrugs();
			IMDDIProductInteractionSubstancesResponse[] IMDDIinteractions = userDetails.getArrayIMDDIProductInteractionSubstancesResponse();
			InteractionsByEditionProductsResponse[] interactions = userDetails.getArrayInteractionsByEditionProductsResponse();
			MealInteractionsByProductsResponse[] mealInteracciones  =  userDetails.getArrayMealInteractionsByProductsResponse();
			GetPregnancyRisksByDrugsResponse[] pregnancyRisk = userDetails.getArrayPregnancyRisksByDrugs();
			GetSubstanceIncompatibilitiesByProductsResponse[] substanceImcopatabilities = userDetails.getArraySubstanceIncompatibilitiesByProductsResponse();
			GetTherapeuticDoublenessByDrugsResponse[] therapeuticDou = userDetails.getArrayTherapeuticDoublenessByDrugsResponse();
            if(IMDDIinteractions != null){
            	for(IMDDIProductInteractionSubstancesResponse IMDD:IMDDIinteractions){
                	for(InteractionSubstance ISubstance: IMDD.getInteractionSubstances()){
                		for(Severities severity: ISubstance.getSeverities()){
                			for(IMDDIReference reference : severity.getIMDDIReferences()){
                				reference.setClinicalReference(reference.getClinicalReference().replace("<a href='"+reference.getReferenceSource()+"' target='_blank'>"+reference.getReferenceSource()+"</a>", reference.getReferenceSource()));
                				reference.setClinicalReference(reference.getClinicalReference().replace(reference.getReferenceSource(), "<a href='"+reference.getReferenceSource()+"' target='_blank'>"+reference.getReferenceSource()+"</a>"));
                			}
                		}
                	}
                }
            }
			
			model.addAttribute("drugs", drugs);
			model.addAttribute("contraindications", contraindications);
			model.addAttribute("DailyDose", DailyDose);
			model.addAttribute("IMDDIinteractions", IMDDIinteractions);
			model.addAttribute("interactions", interactions);
			model.addAttribute("mealInteracciones", mealInteracciones);
			model.addAttribute("pregnancyRisk", pregnancyRisk);
			model.addAttribute("substanceImcopatabilities", substanceImcopatabilities);
			model.addAttribute("therapeuticDou", therapeuticDou);
			model.addAttribute("contentHeaderTitle", "Reporte");
		}
		
		return "clinicalReport";
		
	}
	@RequestMapping(value = "/save", method=RequestMethod.POST)
	public @ResponseBody boolean saveReport(Model model, ModelMap modelMap, @RequestBody SaveReportInfo saveReportInfo) {
		
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			
			CustomUser userDetails = (CustomUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			List<SelectedDrugs> drugs = userDetails.getSelectedDrugs();
			
			boolean isSaved = false;
			if(userDetails.getReport()!=null&&userDetails.getReport().getReportId()>0){
				saveReportInfo.setReportId((int) userDetails.getReport().getReportId());
				isSaved = uService.updateReport(saveReportInfo, userDetails.getCodeString(), gSettings.getClinicalReportType());
			}else{
				isSaved = uService.saveReport(saveReportInfo, userDetails.getCodeString(), gSettings.getClinicalReportType());
			}
			if(!isSaved){
				return false;
			}
			ContraindicationsByProductsResponse[] contraindications = userDetails.getArrayContraindications();
			GetDefinedDailyDoseByDrugsResponse[] DailyDose = userDetails.getArrayDefinedDailyDoseByDrugs();
			IMDDIProductInteractionSubstancesResponse[] IMDDIinteractions = userDetails.getArrayIMDDIProductInteractionSubstancesResponse();
			InteractionsByEditionProductsResponse[] interactions = userDetails.getArrayInteractionsByEditionProductsResponse();
			MealInteractionsByProductsResponse[] mealInteracciones  =  userDetails.getArrayMealInteractionsByProductsResponse();
			GetPregnancyRisksByDrugsResponse[] pregnancyRisk = userDetails.getArrayPregnancyRisksByDrugs();
			GetSubstanceIncompatibilitiesByProductsResponse[] substanceImcopatabilities = userDetails.getArraySubstanceIncompatibilitiesByProductsResponse();
			GetTherapeuticDoublenessByDrugsResponse[] therapeuticDou = userDetails.getArrayTherapeuticDoublenessByDrugsResponse();

			ClinicalReportInfo clinicalReportInfo = null;
			List<ClinicalReportInfo> ClinicalReportInfos = new ArrayList<ClinicalReportInfo>();
			if(drugs != null && drugs.size() > 0){
				for(SelectedDrugs drug : drugs){
					clinicalReportInfo = new ClinicalReportInfo();
					clinicalReportInfo.setBrand(drug.getBrand());
					clinicalReportInfo.setPharmaForm(drug.getPharmaForm());
					clinicalReportInfo.setSubstancesDescription(drug.getSubstance());
					if(interactions != null && interactions.length > 0){
						for(InteractionsByEditionProductsResponse interaction :interactions){
							if(interaction.getProductId()== drug.getProductId() && interaction.getCategoryId() == drug.getCategotyId() && interaction.getDivisionId() == drug.getDivisionId() && interaction.getPharmaFormId() == drug.getPharmaFormId()){
								if(interaction.getInteractionSubstances() != null && interaction.getInteractionSubstances().size() > 0){
									List<ISubstances> isub = new ArrayList<ISubstances>();
									for(InteractionSubstance iSubstance :interaction.getInteractionSubstances()){
										isub.add(new ISubstances(iSubstance.getIBrand(), iSubstance.getIActiveSubstance(), iSubstance.getIPharmaForm(), iSubstance.getIDivisionShortName()));
									}
									clinicalReportInfo.setInteractionSubstances(isub);
								}
								if(interaction.getPharmacologicalGroups() != null && interaction.getPharmacologicalGroups().size()>0){
									List<IPharmacologicalGroups> iPharmaGroups = new ArrayList<IPharmacologicalGroups>();
									for(PharmacologicalGroup pharGroup : interaction.getPharmacologicalGroups()){
										iPharmaGroups.add(new IPharmacologicalGroups(pharGroup.getGroupName(), pharGroup.getIActiveSubstance(), pharGroup.getIBrand(), pharGroup.getIPharmaForm()));
									}
									clinicalReportInfo.setPharmacologicalGroups(iPharmaGroups);
								}
							}
						}
					}
					if(mealInteracciones != null && mealInteracciones.length >0){
						List<IMeal> imeals = new ArrayList<IMeal>();
						for(MealInteractionsByProductsResponse meal :mealInteracciones){
						  for(Product mealproduct : meal.getProducts()){
							if(mealproduct.getProductId()== drug.getProductId() && mealproduct.getCategoryId() == drug.getCategotyId() && mealproduct.getDivisionId() == drug.getDivisionId() && mealproduct.getPharmaFormId() == drug.getPharmaFormId()){
							if(meal.getMealInteractions().size() > 0){
								for(MealInteraction mealInteraction : meal.getMealInteractions()){
									imeals.add(new IMeal(meal.getDescription(), mealInteraction.getMealElementDescription(), mealInteraction.getSeverity().getIMASeverity(), mealInteraction.getClinicalSummary(), mealInteraction.getClinicalReferences() ));
								}
							}
							clinicalReportInfo.setMeals(imeals);
						}
					   }
					  }
					}
					if(contraindications != null && contraindications.length > 0){
						List<IContraindication> icontraindications = new ArrayList<IContraindication>();
						for(ContraindicationsByProductsResponse contraindicationByProduct : contraindications){
							if(contraindicationByProduct.getProductId()== drug.getProductId() && contraindicationByProduct.getCategoryId() == drug.getCategotyId() && contraindicationByProduct.getDivisionId() == drug.getDivisionId() && contraindicationByProduct.getPharmaFormId() == drug.getPharmaFormId()){
								for(ActiveSubstanceContraindication activeSubstanceC : contraindicationByProduct.getActiveSubstanceContraindications()){
									IContraindication iContraindication = new IContraindication();
									iContraindication.setDescription(activeSubstanceC.getDescription());
									if(activeSubstanceC.getICDContraindications().size() > 0){
										iContraindication.setIcdContraindication(activeSubstanceC.getICDContraindications());
									}
									if(activeSubstanceC.getPharmacologicalGroupContraindications().size()>0){
										iContraindication.setPharmaGroup(activeSubstanceC.getPharmacologicalGroupContraindications());
									}
									if(activeSubstanceC.getPhysiologicalContraindications().size()>0){
										iContraindication.setPhysiological(activeSubstanceC.getPhysiologicalContraindications());
									}
									if(activeSubstanceC.getHypersensibilityContraindications().size()>0){
										iContraindication.setHypersensibility(activeSubstanceC.getHypersensibilityContraindications());
									}
									if(activeSubstanceC.getActiveSubstanceContraindications().size()>0){
										iContraindication.setActiveSubstance(activeSubstanceC.getActiveSubstanceContraindications());
									}
									if(activeSubstanceC.getOtherContraindications().size()>0){
										iContraindication.setOther(activeSubstanceC.getOtherContraindications());
									}
									if(activeSubstanceC.getContraindicationComments().size()>0){
										iContraindication.setComment(activeSubstanceC.getContraindicationComments());
									}
									icontraindications.add(iContraindication);
								}
							}
						}
						clinicalReportInfo.setContraindications(icontraindications);
					}
				   if(therapeuticDou!=null && therapeuticDou.length>0){
					   List<ITherapeuticDoubleness> iTherapeuticDoublenesses = new ArrayList<ITherapeuticDoubleness>();
					   for(GetTherapeuticDoublenessByDrugsResponse therapeutic : therapeuticDou){
						   if(drug.getCategotyId() == therapeutic.getCategoryId() && drug.getDivisionId() == therapeutic.getDivisionId() && drug.getPharmaFormId() == therapeutic.getPharmaFormId() && drug.getProductId() == therapeutic.getProductId()){
							   for(ATCOMSDoubleness atcomsDoubleness: therapeutic.getATCOMSDoubleness()){
								   if(atcomsDoubleness.getATCOMSDoublenessProducts().size()>0){
									   
									   iTherapeuticDoublenesses.add(new ITherapeuticDoubleness(atcomsDoubleness.getATCOMSDoublenessProducts(), "Pertenece a "+atcomsDoubleness.getTherapeuticKey()+"-"+atcomsDoubleness.getSpanishDescription()+", podría tratarse de una duplicidad terapéutica."));
								   }else{
									   
									   iTherapeuticDoublenesses.add(new ITherapeuticDoubleness(atcomsDoubleness.getATCOMSDoublenessProducts(), ""));
								   }
									   
							   }
						   }
					   }
					   clinicalReportInfo.setTherapeuticDoubleness(iTherapeuticDoublenesses);
				   }
				   if(IMDDIinteractions!= null&&IMDDIinteractions.length>0){
					   List<IIMDDIinteractions> immddInteractions = new ArrayList<IIMDDIinteractions>();
					   for(IMDDIProductInteractionSubstancesResponse immddInteraction: IMDDIinteractions){
						   if(drug.getCategotyId() == immddInteraction.getCategoryId() && drug.getDivisionId() == immddInteraction.getDivisionId() && drug.getPharmaFormId() == immddInteraction.getPharmaFormId() && drug.getProductId() == immddInteraction.getProductId() ){
							   for(InteractionSubstance interactionSubstance :immddInteraction.getInteractionSubstances()){
								   IIMDDIinteractions iimddIinteractions = new IIMDDIinteractions();
								   for(Severities severities : interactionSubstance.getSeverities()){
									   iimddIinteractions.setBrand(interactionSubstance.getBrand());
									   iimddIinteractions.setActiveSubstance(interactionSubstance.getActiveSubstance());
									   iimddIinteractions.setDivisionShortName(interactionSubstance.getDivisionShortName());
									   iimddIinteractions.setPharmaForm(interactionSubstance.getPharmaForm());
									   iimddIinteractions.setColorSemaphore(severities.getColorSemaphore());
									   for(IMDDIReference reference : severities.getIMDDIReferences()){
			                				reference.setClinicalReference(reference.getClinicalReference().replace("<a href='"+reference.getReferenceSource()+"' target='_blank'>"+reference.getReferenceSource()+"</a>", reference.getReferenceSource()));
			                			}
									   iimddIinteractions.setImddiReferences(severities.getIMDDIReferences());
									   immddInteractions.add(iimddIinteractions);
								   }
							   }
						   }
					   }
					   clinicalReportInfo.setDrugInteractions(immddInteractions);
				   }
				
			
					ClinicalReportInfos.add(clinicalReportInfo);
				}
			}
			String comments = saveReportInfo.getJsonContent();
			int begin = comments.indexOf("\"Comments\":\"");
			if(begin != -1){
				int end = comments.indexOf("\"}", begin+12 );
				if(end != -1){
					comments = comments.substring(begin+12, end);
				}else{
					comments = "";
				}
			}else{
				comments = "";
			}
			JRDataSource ds = new JRBeanCollectionDataSource(ClinicalReportInfos, false);
			 modelMap.addAttribute("datasourceCR", ds);
			 modelMap.addAttribute("format", "pdf");
			 modelMap.addAttribute("expedient", saveReportInfo.getExpedient());
			 modelMap.addAttribute("nameComplete", saveReportInfo.getPatientName() +" "+ saveReportInfo.getPatientLastName());
			 modelMap.addAttribute("weigth", saveReportInfo.getWeight());
			 modelMap.addAttribute("heigth", saveReportInfo.getHeight());
			 modelMap.addAttribute("birthday", uService.getOld(saveReportInfo.getBirthday()));
			 modelMap.addAttribute("comments", comments);
			 userDetails.setModelAndView(new ModelAndView("clinicalReportJ", modelMap));
			 return true;
		}
		return false;
	}
	
	@RequestMapping(value = "/imprimir/reporte-clinico", method=RequestMethod.GET)
	public ModelAndView printReport(){
		if (!(auth instanceof AnonymousAuthenticationToken)) {
					
		   CustomUser userDetails = (CustomUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		   return userDetails.getModelAndView();
					
		}
		return null;
	}

	@RequestMapping(value = "/historial", method=RequestMethod.GET)
	public String getClinicalReportHistory(Model model){
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			   CustomUser userDetails = (CustomUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			   List<GetReportsByCompanyResult>  reports = null;
			   List<GetReportsByCodeResult> reportsCode = null;
			try {
				if(Boolean.valueOf((String) gSettings.getCompanyClientInfo().get("active")) == true){
					reports = uService.getReportsByCompany(Integer.valueOf((String) gSettings.getCompanyClientInfo().get("companyClientId")));
				}else{
					reportsCode = uService.getReportsByCode(userDetails.getCodeString());
				}
				if(reports.size()>0){
					for(GetReportsByCompanyResult report: reports){
						report.setLastUpdate(uService.getDate(report.getLastUpdate()));
					}
					model.addAttribute("reports", reports);
				}else if(reportsCode.size()>0){
					for(GetReportsByCodeResult report: reportsCode){
						report.setLastUpdate(uService.getDate(report.getLastUpdate()));
					}
					model.addAttribute("reports", reportsCode);
				}
			} catch (PLMExceptions e) {
				e.printStackTrace();
			}
			   return "clinical-report-history";
		}
		return null;
	}
	
	@RequestMapping(value = "/getReportById", method=RequestMethod.POST)
	public @ResponseBody GetReportByIdResult getClinicalReportById(@RequestParam("reportId") int reportId){
		GetReportByIdResult report = null;
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			   CustomUser userDetails = (CustomUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			   try {
				   report = uService.getReportById(reportId);
				   userDetails.setReport(report);
			} catch (PLMExceptions e) {
				e.printStackTrace();
			}
		}
		
		return report;
	}
	
	
}
