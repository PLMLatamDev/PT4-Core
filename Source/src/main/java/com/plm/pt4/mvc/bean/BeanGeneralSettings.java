package com.plm.pt4.mvc.bean;

import java.util.HashMap;



public class BeanGeneralSettings {
	
	private int countryIdPharma;
	private int countryIdClients;
	private int editionId;
	private int targetId;
	private int sourceId;
	private int informationTypeId;
	private int informationTypeNews;
	private int valuePubMed;
	private int resolutionKey;
	private int logEntityId;
	private int logNewsEntityId;
	private int logPubMedEntityId;
	private int logGPCEntityId;
	private int logSearchTypeId;
	private int logSourceId;
	

	private String codeDefault;
	private String country;
	private String prefix;
	private String isbn;
	private String isbnMed;
	private String urlPLMLogs;


	private HashMap<String, ?> companyClientInfo;
	
	private HashMap<String, Boolean> interacciones;
	
	private HashMap<String,Integer>  distribution;
	
	private boolean calculadoras;
	private boolean atlas;
	private boolean recursos;
	
	private boolean countryCodes;
	private int carouselInterval;
	private boolean carouselActive;
	private boolean catCarouselActive;
	private boolean carouselWrap;
	private int deviceId;
	
	private int sesionTime;
	
	private boolean guideClinic;
	private boolean abstratcs;
	private boolean pubmed;
	private boolean encyclopedias;
	private boolean icd;
	private boolean atc;
	private boolean eLearning;
	private boolean prescription;
	private boolean farmacovigilancia;
	private boolean colPrice;
	private boolean colBarCode;
	private boolean publicity;
	private int typeLogin;
	private int profesionId;
	private int hwIdentifier;
	private String urlEmailActive;
	private boolean medicalPrescription;
	private boolean clinicalReport;
	private int clinicalReportType;
	
	private int sessionLimit;
	
	
	private String urlPharmacovigilancia;
	
	public int getCountryIdPharma() {
		return countryIdPharma;
	}
	public void setCountryIdPharma(int countryIdPharma) {
		this.countryIdPharma = countryIdPharma;
	}
	public int getCountryIdClients() {
		return countryIdClients;
	}
	public void setCountryIdClients(int countryIdClients) {
		this.countryIdClients = countryIdClients;
	}
	public int getEditionId() {
		return editionId;
	}
	public void setEditionId(int editionId) {
		this.editionId = editionId;
	}
	public int getTargetId() {
		return targetId;
	}
	public void setTargetId(int targetId) {
		this.targetId = targetId;
	}
	public int getInformationTypeId() {
		return informationTypeId;
	}
	public void setInformationTypeId(int informationTypeId) {
		this.informationTypeId = informationTypeId;
	}
	public int getInformationTypeNews() {
		return informationTypeNews;
	}
	public void setInformationTypeNews(int informationTypeNews) {
		this.informationTypeNews = informationTypeNews;
	}
	public int getValuePubMed() {
		return valuePubMed;
	}
	public void setValuePubMed(int valuePubMed) {
		this.valuePubMed = valuePubMed;
	}
	public int getResolutionKey() {
		return resolutionKey;
	}
	public void setResolutionKey(int resolutionKey) {
		this.resolutionKey = resolutionKey;
	}
	public int getLogEntityId() {
		return logEntityId;
	}
	public void setLogEntityId(int logEntityId) {
		this.logEntityId = logEntityId;
	}
	public int getLogNewsEntityId() {
		return logNewsEntityId;
	}
	public void setLogNewsEntityId(int logNewsEntityId) {
		this.logNewsEntityId = logNewsEntityId;
	}
	public int getLogPubMedEntityId() {
		return logPubMedEntityId;
	}
	public void setLogPubMedEntityId(int logPubMedEntityId) {
		this.logPubMedEntityId = logPubMedEntityId;
	}
	public int getLogGPCEntityId() {
		return logGPCEntityId;
	}
	public void setLogGPCEntityId(int logGPCEntityId) {
		this.logGPCEntityId = logGPCEntityId;
	}
	public int getLogSearchTypeId() {
		return logSearchTypeId;
	}
	public void setLogSearchTypeId(int logSearchTypeId) {
		this.logSearchTypeId = logSearchTypeId;
	}
	public int getLogSourceId() {
		return logSourceId;
	}
	public void setLogSourceId(int logSourceId) {
		this.logSourceId = logSourceId;
	}
	public String getCodeDefault() {
		return codeDefault;
	}
	public void setCodeDefault(String codeDefault) {
		this.codeDefault = codeDefault;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getIsbnMed() {
		return isbnMed;
	}
	public void setIsbnMed(String isbnMed) {
		this.isbnMed = isbnMed;
	}
	
	public HashMap<String, Boolean> getInteracciones() {
		return interacciones;
	}
	public void setInteracciones(HashMap<String, Boolean> interacciones) {
		this.interacciones = interacciones;
	}
	public boolean isCalculadoras() {
		return calculadoras;
	}
	public void setCalculadoras(boolean calculadoras) {
		this.calculadoras = calculadoras;
	}
	public boolean isAtlas() {
		return atlas;
	}
	public void setAtlas(boolean atlas) {
		this.atlas = atlas;
	}
	public boolean isRecursos() {
		return recursos;
	}
	public void setRecursos(boolean recursos) {
		this.recursos = recursos;
	}
	public boolean isCountryCodes() {
		return countryCodes;
	}
	public void setCountryCodes(boolean countryCodes) {
		this.countryCodes = countryCodes;
	}
	public int getCarouselInterval() {
		return carouselInterval;
	}
	public void setCarouselInterval(int carouselInterval) {
		this.carouselInterval = carouselInterval;
	}
	public boolean isCarouselActive() {
		return carouselActive;
	}
	public void setCarouselActive(boolean carouselActive) {
		this.carouselActive = carouselActive;
	}
	public boolean isCatCarouselActive() {
		return catCarouselActive;
	}
	public void setCatCarouselActive(boolean catCarouselActive) {
		this.catCarouselActive = catCarouselActive;
	}
	public boolean isCarouselWrap() {
		return carouselWrap;
	}
	public void setCarouselWrap(boolean carouselWrap) {
		this.carouselWrap = carouselWrap;
	}
	public int getSesionTime() {
		return sesionTime;
	}
	public void setSesionTime(int sesionTime) {
		this.sesionTime = sesionTime;
	}
	public int getSourceId() {
		return sourceId;
	}
	public void setSourceId(int sourceId) {
		this.sourceId = sourceId;
	}
	public String getUrlPLMLogs() {
		return urlPLMLogs;
	}
	public void setUrlPLMLogs(String urlPLMLogs) {
		this.urlPLMLogs = urlPLMLogs;
	}
	public int getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}
	public boolean isGuideClinic() {
		return guideClinic;
	}
	public void setGuideClinic(boolean guideClinic) {
		this.guideClinic = guideClinic;
	}
	public boolean isAbstratcs() {
		return abstratcs;
	}
	public void setAbstratcs(boolean abstratcs) {
		this.abstratcs = abstratcs;
	}
	public boolean isPubmed() {
		return pubmed;
	}
	public void setPubmed(boolean pubmed) {
		this.pubmed = pubmed;
	}
	public boolean isEncyclopedias() {
		return encyclopedias;
	}
	public void setEncyclopedias(boolean encyclopedias) {
		this.encyclopedias = encyclopedias;
	}
	public boolean isIcd() {
		return icd;
	}
	public void setIcd(boolean icd) {
		this.icd = icd;
	}
	public boolean isAtc() {
		return atc;
	}
	public void setAtc(boolean atc) {
		this.atc = atc;
	}
	public boolean isELearning() {
		return eLearning;
	}
	public void setELearning(boolean eLearning) {
		this.eLearning = eLearning;
	}
	public boolean isPrescription() {
		return prescription;
	}
	public void setPrescription(boolean prescription) {
		this.prescription = prescription;
	}
	public boolean isFarmacovigilancia() {
		return farmacovigilancia;
	}
	public void setFarmacovigilancia(boolean farmacovigilancia) {
		this.farmacovigilancia = farmacovigilancia;
	}
	public boolean isColPrice() {
		return colPrice;
	}
	public void setColPrice(boolean colPrice) {
		this.colPrice = colPrice;
	}
	public boolean isColBarCode() {
		return colBarCode;
	}
	public void setColBarCode(boolean colBarCode) {
		this.colBarCode = colBarCode;
	}
	public boolean isPublicity() {
		return publicity;
	}
	public void setPublicity(boolean publicity) {
		this.publicity = publicity;
	}
	public int getTypeLogin() {
		return typeLogin;
	}
	public void setTypeLogin(int typeLogin) {
		this.typeLogin = typeLogin;
	}
	public int getProfesionId() {
		return profesionId;
	}
	public void setProfesionId(int profesionId) {
		this.profesionId = profesionId;
	}
	public int getHwIdentifier() {
		return hwIdentifier;
	}
	public void setHwIdentifier(int hwIdentifier) {
		this.hwIdentifier = hwIdentifier;
	}
	public String getUrlEmailActive() {
		return urlEmailActive;
	}
	public void setUrlEmailActive(String urlEmailActive) {
		this.urlEmailActive = urlEmailActive;
	}
	public boolean isMedicalPrescription() {
		return medicalPrescription;
	}
	public void setMedicalPrescription(boolean medicalPrescription) {
		this.medicalPrescription = medicalPrescription;
	}
	public boolean isClinicalReport() {
		return clinicalReport;
	}
	public void setClinicalReport(boolean clinicalReport) {
		this.clinicalReport = clinicalReport;
	}
	public HashMap<String, ?> getCompanyClientInfo() {
		return companyClientInfo;
	}
	public void setCompanyClientInfo(HashMap<String, ?> companyClientInfo) {
		this.companyClientInfo = companyClientInfo;
	}
	public int getClinicalReportType() {
		return clinicalReportType;
	}
	public void setClinicalReportType(int clinicalReportType) {
		this.clinicalReportType = clinicalReportType;
	}
	public int getSessionLimit() {
		return sessionLimit;
	}
	public void setSessionLimit(int sessionLimit) {
		this.sessionLimit = sessionLimit;
	}
	public String getUrlPharmacovigilancia() {
		return urlPharmacovigilancia;
	}
	public void setUrlPharmacovigilancia(String urlPharmacovigilancia) {
		this.urlPharmacovigilancia = urlPharmacovigilancia;
	}
	public boolean iseLearning() {
		return eLearning;
	}
	public void seteLearning(boolean eLearning) {
		this.eLearning = eLearning;
	}
	public HashMap<String, Integer> getDistribution() {
		return distribution;
	}
	public void setDistribution(HashMap<String, Integer> distribution) {
		this.distribution = distribution;
	}
	
	
	
	

}
