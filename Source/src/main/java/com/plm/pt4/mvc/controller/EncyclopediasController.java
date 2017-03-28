package com.plm.pt4.mvc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.plm.pt4.mvc.model.encyclopedia.AssociatedEncyclopedia;
import com.plm.pt4.mvc.model.encyclopedia.Attribute;
import com.plm.pt4.mvc.model.encyclopedia.AttributesBySymptomResult;
import com.plm.pt4.mvc.model.encyclopedia.EncyclopediaDetail;
import com.plm.pt4.mvc.model.encyclopedia.EncyclopediaTest;
import com.plm.pt4.mvc.model.encyclopedia.GeneralEncyclopedias;
import com.plm.pt4.mvc.model.encyclopedia.GetAttributesBySymptomResult;
import com.plm.pt4.mvc.model.encyclopedia.GetEncyclopediaAttributesByProductsEditionResult;
import com.plm.pt4.mvc.model.encyclopedia.GetEncyclopediasByTypeByTextResult;
import com.plm.pt4.mvc.model.encyclopedia.GetSymptomsByEditionResult;
import com.plm.pt4.mvc.model.encyclopedia.SymptomsByEditionResult;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Controller
@RequestMapping(value="/encyclopedias")
public class EncyclopediasController {
	
	private List<GeneralEncyclopedias> listEncyclopedias;
	
	@RequestMapping(value="/encyclopedias-home" ,method=RequestMethod.GET)
	public String allEncyclopedias(Model model){
		model.addAttribute("contentHeaderTitle", "Enciclopedia de la Salud");
		return "menu-encyclopedias";
	}
	
	@RequestMapping(value="/estudios-de-laboratorio-{letter}" ,method=RequestMethod.GET)
	public String getLaboratoryStudies(@PathVariable("letter") String letter, Model model) throws IOException{		
		int encyclopediaType = 4;
		List<GetEncyclopediasByTypeByTextResult> listSymtoms = (List<GetEncyclopediasByTypeByTextResult>) getEncyclopedias( encyclopediaType,letter );
		model.addAttribute("contentHeaderTitle", "Enciclopedia de la Salud");
		model.addAttribute("contentHeaderSubtitle", "Estudios de laboratorio");
		model.addAttribute("listSymtoms",listSymtoms);
		model.addAttribute("encyclopediaName","estudios-de-laboratorio");

    	return "all-encyclopedias";
	}
	
	@RequestMapping(value="/enfermedades-{letter}" ,method=RequestMethod.GET)
	public String getDiseases(@PathVariable("letter") String letter, Model model) throws IOException{
	    int encyclopediaType = 1;
	    List<GetEncyclopediasByTypeByTextResult> listSymtoms = (List<GetEncyclopediasByTypeByTextResult>) getEncyclopedias( encyclopediaType,letter );
	    model.addAttribute("contentHeaderTitle", "Enciclopedia de la Salud");
		model.addAttribute("contentHeaderSubtitle", "Enfermedades");
		model.addAttribute("listSymtoms",listSymtoms);
		model.addAttribute("encyclopediaName","enfermedades");
    	
    	return "all-encyclopedias";
	}
	
	@RequestMapping(value="/sintomas-{letter}" ,method=RequestMethod.GET)
	public String getSyntomps(@PathVariable("letter") String letter, Model model) throws IOException{
    	int encyclopediaType = 2;
    	List<GetEncyclopediasByTypeByTextResult> listSymtoms = (List<GetEncyclopediasByTypeByTextResult>) getEncyclopedias( encyclopediaType,letter );
	    model.addAttribute("contentHeaderTitle", "Enciclopedia de la Salud");
		model.addAttribute("contentHeaderSubtitle", "Síntomas");
		model.addAttribute("listSymtoms",listSymtoms);
		model.addAttribute("encyclopediaName","sintomas");
    	
    	return "all-encyclopedias";
	}
	
	@RequestMapping(value="/cirugias-y-procedimientos-{letter}" ,method=RequestMethod.GET)
	public String getSurgeries(@PathVariable("letter") String letter, Model model) throws IOException{
		int encyclopediaType = 3;
		List<GetEncyclopediasByTypeByTextResult> listSymtoms = (List<GetEncyclopediasByTypeByTextResult>) getEncyclopedias( encyclopediaType,letter );
	    model.addAttribute("contentHeaderTitle", "Enciclopedia de la Salud");
		model.addAttribute("contentHeaderSubtitle", "Cirugias y otros procedimientos");
		model.addAttribute("listSymtoms",listSymtoms);
		model.addAttribute("encyclopediaName","cirugias-y-procedimientos");
    	return "all-encyclopedias";
	}
	
	@RequestMapping(value="/mejora-tu-salud-{letter}",method=RequestMethod.GET)
	public String getImproveHealth(@PathVariable("letter") String  letter, Model model) throws IOException{
		int editionId = 157;
		List<GetSymptomsByEditionResult> listHealth = (List<GetSymptomsByEditionResult>) getListImproveHealth(editionId, letter);
		model.addAttribute("contentHeaderTitle", "Enciclopedia de la Salud");
		model.addAttribute("contentHeaderSubtitle", "Mejora tu Salud");
		model.addAttribute("listHealth",listHealth);
		model.addAttribute("encyclopediaName","mejora-tu-salud");
		return "all-encyclopedias";
	}

	//Detalle Encyclopedia
	@RequestMapping(value="{encyclopediaName}-{idEnciclopedy}", method=RequestMethod.GET)
	public String getAttributes(@PathVariable("encyclopediaName") String categoryName,@PathVariable("encyclopediaName") String encyclopediaName,@PathVariable("idEnciclopedy") int idEnciclopedy, Model model) throws IOException{
		String url = "http://187.237.235.54/RestEncyclopediaSearchEngine/RestEncyclopediaSearchEngine.svc/getEncyclopediaAttributesByProductsEdition?code=5vEhdJ*C1Uvi*RMLARwCw6z/A2k=&encyclopediaId="+idEnciclopedy+"&isbn=E-ENCICLOPEDIA 2014&productsEditionId=157&country=MEX&clientLatitude=&clientLongitude=&resolutionKey=320";
		EncyclopediaDetail response = getRestTemplate().getForObject(url, EncyclopediaDetail.class);
		GetEncyclopediaAttributesByProductsEditionResult detailEncyclopedia = response.getGetEncyclopediaAttributesByProductsEditionResult();
		detailEncyclopedia.setEncyclopediaImage( "PLM0"+(int) Math.ceil((Math.random()*(720-710+1)+710))+".png");
		List<GeneralEncyclopedias> encyclopediasCollection = new ArrayList<GeneralEncyclopedias>();
		
		for( Attribute attribute:detailEncyclopedia.getAttributes() ){
			GeneralEncyclopedias ge = new GeneralEncyclopedias();
			for( AssociatedEncyclopedia associated:detailEncyclopedia.getAssociatedEncyclopedias() ){
				String tmp = associated.getEncyclopediaName().toLowerCase()+"-";
				tmp = tmp.replace(" ", "-");
				tmp = tmp.replace(":", "");
				tmp = tmp.replace(",", "");
				tmp = tmp.replace(";", "");
				tmp = tmp.replace(")", "");
				tmp = tmp.replace("(", "");
				tmp = tmp.replace("á", "a");
				tmp = tmp.replace("é", "e");
				tmp = tmp.replace("í", "i");
				tmp = tmp.replace("ó", "o");
				tmp = tmp.replace("ú", "u");
				tmp = tmp.replace("--","-");
				
				String aux = attribute.getContent().replace( associated.getPLMCode(),associated.getEncyclopediaName() );
				attribute.setContent( attribute.getContent().replace( associated.getPLMCode(), "<a href=\""+tmp+associated.getEncyclopediaId()+"\">"+associated.getEncyclopediaName()+"</a>" ) );
			}
				ge.setAttributeId(attribute.getAttributeId());
				ge.setNameEncyclopedia( detailEncyclopedia.getEncyclopediaName() );
				ge.setAttributeName( attribute.getAttributeName() );
				ge.setContent( attribute.getContent() );
				encyclopediasCollection.add( ge );
		}
		
		
		
		setEncyclopedias( encyclopediasCollection );
		model.addAttribute("detailEncyclopedia",detailEncyclopedia);
		model.addAttribute("contentHeaderTitle",detailEncyclopedia.getEncyclopediaName());
		return "detail-encyclopedia";
	}
	
	//Detalle síntomas
	@RequestMapping(value="/mejora-tu-salud/{encyclopediaName}-{idEncyclopedia}", method=RequestMethod.GET)
	public String getAttributesSymptom(@PathVariable("encyclopediaName") String encyclopdiaName, @PathVariable("idEncyclopedia") String idEncyclopedia,Model model){
		
		String url ="http://187.237.235.54/RestPharmaSearchEngine/RestPharmaSearchEngine.svc/getAttributesBySymptom?code=5vEhdJ*C1Uvi*RMLARwCw6z/A2k=&editionId=157&symptomId="+idEncyclopedia;
		AttributesBySymptomResult response = getRestTemplate().getForObject(url,AttributesBySymptomResult.class);
		List<GetAttributesBySymptomResult> listSymptoms = response.getGetAttributesBySymptomResult();
		List<GeneralEncyclopedias> encyclopediasCollection = new ArrayList<GeneralEncyclopedias>();
		
		for( GetAttributesBySymptomResult encyclopedia:listSymptoms ){
			GeneralEncyclopedias tmp = new GeneralEncyclopedias();
			tmp.setAttributeId( encyclopedia.getAttributeId() );
			tmp.setNameEncyclopedia( encyclopedia.getSymptomName() );
			tmp.setAttributeName( encyclopedia.getDescription() );
			tmp.setContent( encyclopedia.getContent() );
			encyclopediasCollection.add( tmp );
		}
		setEncyclopedias(encyclopediasCollection);
		
		
		model.addAttribute("listSymptoms",listSymptoms);
		return "attribute-symptom";
	}
	
	@RequestMapping(value="/print-encyclopedia", method=RequestMethod.GET)
	public ModelAndView printEnciclopedyas(ModelMap modelMap){
		JRDataSource ds = new JRBeanCollectionDataSource( getEncyclopedias() );
        modelMap.addAttribute("datasourceER", ds);
		modelMap.addAttribute("format","pdf");
		modelMap.addAttribute("nameEncyclopedia", getEncyclopedias().get(0).getNameEncyclopedia());
		return new ModelAndView("encyclopediasReport",modelMap);
	}
	
	
	@RequestMapping(value="/convert-encyclopedia", method=RequestMethod.POST)
	public @ResponseBody Boolean convertEnciclopedyas(@RequestBody List<GeneralEncyclopedias> generalEncyclopedias){
		List<GeneralEncyclopedias> list = generalEncyclopedias;
		for(GeneralEncyclopedias e:getEncyclopedias()){
			for( GeneralEncyclopedias item:generalEncyclopedias ){
				if( e.getAttributeId()==item.getAttributeId() ){
					e.setContent(item.getContent());
				}
			}
		}
		
		return true;
	}
	
	public void setEncyclopedias(List<GeneralEncyclopedias> listEncyclopedias){
		this.listEncyclopedias = listEncyclopedias;
	}
	
	public List<GeneralEncyclopedias> getEncyclopedias(){
		return listEncyclopedias;
	}

	private List<HttpMessageConverter<?>> getMessageConverters() {
        List<HttpMessageConverter<?>> converters = new ArrayList<HttpMessageConverter<?>>();
        converters.add(new MappingJackson2HttpMessageConverter());
        return converters;
	}
	
	public RestTemplate getRestTemplate() {
		RestTemplate restTemplate = new RestTemplate();
        restTemplate.setMessageConverters(this.getMessageConverters());
        return restTemplate;
	}
	
	public List<?> getEncyclopedias(int encyclopediaType, String letter){
		List<GetEncyclopediasByTypeByTextResult> listSymtoms = null;
		String url = "http://www.plmconnection.com/plmservices/RestEncyclopediaSearchEngine/RestEncyclopediaSearchEngine.svc/getEncyclopediasByTypeByText?code=F9859FNNMG&searchText="+letter+"&encyclopediaType="+encyclopediaType+"&isbn=E-ENCICLOPEDIA 2014";
		
    	EncyclopediaTest response = getRestTemplate().getForObject(url, EncyclopediaTest.class);
    	listSymtoms = response.getGetEncyclopediasByTypeByTextResult();
    	
    	for( GetEncyclopediasByTypeByTextResult encyclopedia:listSymtoms ){
    		String cleanEncyclopedia = encyclopedia.getEncyclopediaName();
    		cleanEncyclopedia = cleanEncyclopedia.replace(" ", "-");
    		cleanEncyclopedia = cleanEncyclopedia.replace(":", "");
    		cleanEncyclopedia = cleanEncyclopedia.replace(",", "");
    		cleanEncyclopedia = cleanEncyclopedia.replace(";", "");
    		cleanEncyclopedia = cleanEncyclopedia.replace(")", "");
    		cleanEncyclopedia = cleanEncyclopedia.replace("(", "");
    		cleanEncyclopedia = cleanEncyclopedia.replace("á", "a");
    		cleanEncyclopedia = cleanEncyclopedia.replace("é", "e");
    		cleanEncyclopedia = cleanEncyclopedia.replace("í", "i");
    		cleanEncyclopedia = cleanEncyclopedia.replace("ó", "o");
    		cleanEncyclopedia = cleanEncyclopedia.replace("ú", "u");
    		
    		cleanEncyclopedia = cleanEncyclopedia.toLowerCase()+"-";
    		
    		cleanEncyclopedia = cleanEncyclopedia.replace("--","-");
    		encyclopedia.setEncyclopediaName( encyclopedia.getEncyclopediaName()+"¬¬"+cleanEncyclopedia);
    	}
    	
		return listSymtoms;
	}
	
	public List<GetSymptomsByEditionResult> getListImproveHealth(int editionId, String letter){
		List<GetSymptomsByEditionResult> listHealth = null;
		String  url = "http://187.237.235.54/RestPharmaSearchEngine/RestPharmaSearchEngine.svc/getSymptomsByEdition?code=5vEhdJ*C1Uvi*RMLARwCw6z/A2k=&editionId="+editionId+"&symptom="+letter;
		SymptomsByEditionResult response =  getRestTemplate().getForObject(url,SymptomsByEditionResult.class);
		listHealth = response.getGetSymptomsByEditionResult();
		for(GetSymptomsByEditionResult encyclopedia:listHealth){
			String cad = encyclopedia.getSymptomName();
			cad = cad.toLowerCase();
			cad = cad.replace(" ","-");
			cad = cad.replace("á","a");
			cad = cad.replace("é","e");
			cad = cad.replace("í","i");
			cad = cad.replace("ó","o");
			cad = cad.replace("ú","u");
			cad = cad.replace("ñ","n");
			cad = cad.replace("ño","nio");
			encyclopedia.setUrl( cad );
		}
		return  listHealth;
	}
}
