package com.plm.pt4.mvc.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.plmlatina.model.ICD;
import com.plmlatina.model.Lab;
import com.plmlatina.model.Product;
import com.plmlatina.model.ProductInfo;
import com.plmlatina.model.Substance;
import com.plmlatina.model.Substance_;
import com.plmlatina.model.Therapeutic;
import com.plmlatina.result.ContraindicationsByProductsResponse;
import com.plmlatina.result.GetDefinedDailyDoseByDrugsResponse;
import com.plmlatina.result.GetPregnancyRisksByDrugsResponse;
import com.plmlatina.result.GetSubstanceIncompatibilitiesByProductsResponse;
import com.plmlatina.result.GetTherapeuticDoublenessByDrugsResponse;
import com.plmlatina.result.IMDDIProductInteractionSubstancesResponse;
import com.plmlatina.result.InteractionsByEditionProductsResponse;
import com.plmlatina.result.MealInteractionsByProductsResponse;
import com.plmlatina.model.GetMedicalGuidelinesByTextResult;
import com.plmlatina.model.GetScientificArticlesResult;
import com.plmlatina.model.GetTherapeuticsResult;

public class SearchGeneral {

	private List<ProductInfo> productInfo;
	private List<Substance> substances;
	private List<Substance_> substance;
	private List<Lab> labs;
	private List<ICD> icd;
	private List<Therapeutic> atc;
	private List<GetMedicalGuidelinesByTextResult> guides;
	private List<GetTherapeuticsResult> listGetTherapeuticsResult;
	private List<GetScientificArticlesResult> listGetScientificArticlesResult;
	
	
	//Totales
	private int totalProducts;
	private int totalLabs;
	private int totalSubstances;
	private int totalICD;
	private int totalATC;
	private int totalGuideLines;
	private int totalInteractions;
	private int totalDDI;
	private int totalSelectedDrugs;

	//InteractionsByProducts
	private InteractionsByEditionProductsResponse[] ArrayInteractionsByEditionProductsResponse;
	//IMDDIProductInteractionSubstancesResponse
	private IMDDIProductInteractionSubstancesResponse[] ArrayIMDDIProductInteractionSubstancesResponse; 
	//MealInteractions
	private MealInteractionsByProductsResponse[] ArrayMealInteractionsByProductsResponse;
	//Contraindications
	private ContraindicationsByProductsResponse[] ArrayContraindications;
	//PregnancyRisksByDrugs
	private GetPregnancyRisksByDrugsResponse[] ArrayPregnancyRisksByDrugs;
	//DDD
	private GetDefinedDailyDoseByDrugsResponse[] ArrayDefinedDailyDoseByDrugs;
	//SubstanceIncompatibilitiesByProductsResponse
	private GetSubstanceIncompatibilitiesByProductsResponse[] ArraySubstanceIncompatibilitiesByProductsResponse;
	//TherapeuticDoublenessByDrugsResponse
	private GetTherapeuticDoublenessByDrugsResponse[] ArrayTherapeuticDoublenessByDrugsResponse;
	
	// Productos Seleccionados
	private List<SelectedDrugs> selectedDrugs;
	
	private MedicalInteractions medicalInteractions; 
	
	public List<ProductInfo> getProductInfo() {
		return productInfo;
	}
	public void setProductInfo(List<ProductInfo> productInfo) {
		this.productInfo = productInfo;
	}
	public List<Substance> getSubstances() {
		return substances;
	}
	public void setSubstances(List<Substance> substances) {
		this.substances = substances;
	}
	public List<Substance_> getSubstance() {
		return substance;
	}
	public void setSubstance(List<Substance_> substance) {
		this.substance = substance;
	}
	public List<Lab> getLabs() {
		return labs;
	}
	public void setLabs(List<Lab> labs) {
		this.labs = labs;
	}
	public List<ICD> getIcd() {
		return icd;
	}
	public void setIcd(List<ICD> icd) {
		this.icd = icd;
	}
	public List<Therapeutic> getAtc() {
		return atc;
	}
	public void setAtc(List<Therapeutic> atc) {
		this.atc = atc;
	}
	public List<GetMedicalGuidelinesByTextResult> getGuides() {
		return guides;
	}
	public void setGuides(List<GetMedicalGuidelinesByTextResult> guides) {
		this.guides = guides;
	}
	public List<GetTherapeuticsResult> getListGetTherapeuticsResult() {
		return listGetTherapeuticsResult;
	}
	public void setListGetTherapeuticsResult(List<GetTherapeuticsResult> listGetTherapeuticsResult) {
		this.listGetTherapeuticsResult = listGetTherapeuticsResult;
	}
	public List<GetScientificArticlesResult> getListGetScientificArticlesResult() {
		return listGetScientificArticlesResult;
	}
	public void setListGetScientificArticlesResult(List<GetScientificArticlesResult> listGetScientificArticlesResult) {
		this.listGetScientificArticlesResult = listGetScientificArticlesResult;
	}
	
	public InteractionsByEditionProductsResponse[] getArrayInteractionsByEditionProductsResponse() {
		return ArrayInteractionsByEditionProductsResponse;
	}
	public void setArrayInteractionsByEditionProductsResponse(
			InteractionsByEditionProductsResponse[] arrayInteractionsByEditionProductsResponse) {
		ArrayInteractionsByEditionProductsResponse = arrayInteractionsByEditionProductsResponse;
	}
	public MealInteractionsByProductsResponse[] getArrayMealInteractionsByProductsResponse() {
		return ArrayMealInteractionsByProductsResponse;
	}
	public IMDDIProductInteractionSubstancesResponse[] getArrayIMDDIProductInteractionSubstancesResponse() {
		return ArrayIMDDIProductInteractionSubstancesResponse;
	}
	public void setArrayIMDDIProductInteractionSubstancesResponse(
			IMDDIProductInteractionSubstancesResponse[] arrayIMDDIProductInteractionSubstancesResponse) {
		ArrayIMDDIProductInteractionSubstancesResponse = arrayIMDDIProductInteractionSubstancesResponse;
	}
	public void setArrayMealInteractionsByProductsResponse(
			MealInteractionsByProductsResponse[] arrayMealInteractionsByProductsResponse) {
		ArrayMealInteractionsByProductsResponse = arrayMealInteractionsByProductsResponse;
	}
	public ContraindicationsByProductsResponse[] getArrayContraindications() {
		return ArrayContraindications;
	}
	public void setArrayContraindications(ContraindicationsByProductsResponse[] arrayContraindications) {
		ArrayContraindications = arrayContraindications;
	}
	public List<SelectedDrugs> getSelectedDrugs() {
		return selectedDrugs;
	}
	public void setSelectedDrugs(List<SelectedDrugs> selectedDrugs) {
		this.selectedDrugs = selectedDrugs;
	}
	
	//Totales
	
	public int getTotalProducts() {
		return totalProducts;
	}
	public void setTotalProducts(int totalProducts) {
		this.totalProducts = totalProducts;
	}
	public int getTotalLabs() {
		return totalLabs;
	}
	public void setTotalLabs(int totalLabs) {
		this.totalLabs = totalLabs;
	}
	public int getTotalSubstances() {
		return totalSubstances;
	}
	public void setTotalSubstances(int totalSubstances) {
		this.totalSubstances = totalSubstances;
	}
	public int getTotalICD() {
		return totalICD;
	}
	public void setTotalICD(int totalICD) {
		this.totalICD = totalICD;
	}
	public int getTotalATC() {
		return totalATC;
	}
	public void setTotalATC(int totalATC) {
		this.totalATC = totalATC;
	}
	public int getTotalGuideLines() {
		return totalGuideLines;
	}
	public void setTotalGuideLines(int totalGuideLines) {
		this.totalGuideLines = totalGuideLines;
	}
	public int getTotalInteractions() {
		return totalInteractions;
	}
	public void setTotalInteractions(int totalInteractions) {
		this.totalInteractions = totalInteractions;
	}
	public int getTotalDDI() {
		return totalDDI;
	}
	public void setTotalDDI(int totalDDI) {
		this.totalDDI = totalDDI;
	}
	public int getTotalSelectedDrugs() {
		return totalSelectedDrugs;
	}
	public void setTotalSelectedDrugs(int totalSelectedDrugs) {
		this.totalSelectedDrugs = totalSelectedDrugs;
	}
	public MedicalInteractions getMedicalInteractions() {
		return medicalInteractions;
	}
	public void setMedicalInteractions(MedicalInteractions medicalInteractions) {
		this.medicalInteractions = medicalInteractions;
	}
	public GetPregnancyRisksByDrugsResponse[] getArrayPregnancyRisksByDrugs() {
		return ArrayPregnancyRisksByDrugs;
	}
	public void setArrayPregnancyRisksByDrugs(GetPregnancyRisksByDrugsResponse[] arrayPregnancyRisksByDrugs) {
		ArrayPregnancyRisksByDrugs = arrayPregnancyRisksByDrugs;
	}
	public GetDefinedDailyDoseByDrugsResponse[] getArrayDefinedDailyDoseByDrugs() {
		return ArrayDefinedDailyDoseByDrugs;
	}
	public void setArrayDefinedDailyDoseByDrugs(GetDefinedDailyDoseByDrugsResponse[] arrayDefinedDailyDoseByDrugs) {
		ArrayDefinedDailyDoseByDrugs = arrayDefinedDailyDoseByDrugs;
	}
	public GetSubstanceIncompatibilitiesByProductsResponse[] getArraySubstanceIncompatibilitiesByProductsResponse() {
		return ArraySubstanceIncompatibilitiesByProductsResponse;
	}
	public void setArraySubstanceIncompatibilitiesByProductsResponse(
			GetSubstanceIncompatibilitiesByProductsResponse[] arraySubstanceIncompatibilitiesByProductsResponse) {
		ArraySubstanceIncompatibilitiesByProductsResponse = arraySubstanceIncompatibilitiesByProductsResponse;
	}
	public GetTherapeuticDoublenessByDrugsResponse[] getArrayTherapeuticDoublenessByDrugsResponse() {
		return ArrayTherapeuticDoublenessByDrugsResponse;
	}
	public void setArrayTherapeuticDoublenessByDrugsResponse(
			GetTherapeuticDoublenessByDrugsResponse[] arrayTherapeuticDoublenessByDrugsResponse) {
		ArrayTherapeuticDoublenessByDrugsResponse = arrayTherapeuticDoublenessByDrugsResponse;
	}
	
	
	
}
