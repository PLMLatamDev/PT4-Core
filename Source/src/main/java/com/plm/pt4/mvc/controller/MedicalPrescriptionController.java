package com.plm.pt4.mvc.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.plm.pt4.mvc.bean.BeanGeneralSettings;
import com.plm.pt4.mvc.model.CustomUser;
import com.plm.pt4.mvc.model.ProductByMedicalPrescription;
import com.plm.pt4.mvc.model.ProductsByMedicalPrescription;
import com.plm.pt4.mvc.model.SubstancesByMedicalPrescriptionResponse;
import com.plm.pt4.mvc.service.UtilitiesService;
import com.plmlatina.manager.ManagerUnicodeConverter;
import com.plmlatina.model.FileManagerException;
import com.plmlatina.model.GetAddressesByClientResult;
import com.plmlatina.model.GetClientDetailCompleteByEmailResult;
import com.plmlatina.model.GetMedicalPrescriptionResult;
import com.plmlatina.model.GetMedicalPrescriptionsByDateResult;
import com.plmlatina.model.MedicalPrescription;
import com.plmlatina.model.Substance;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Controller
@SessionAttributes("modeloReceta")
@RequestMapping(value = "/receta")
public class MedicalPrescriptionController {
                @Autowired
                UtilitiesService uService;
                
                Authentication auth = SecurityContextHolder.getContext().getAuthentication();
                ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/WEB-INF/spring/spring-import.xml");
                BeanGeneralSettings gSettings = (BeanGeneralSettings) context.getBean("beanGeneralSettings");
                
                @RequestMapping(value = "/prescripcion", method = RequestMethod.GET)
                public String getPrescriptionView(Model model) {

                               return "medical-prescription";
                }
                @RequestMapping(value = "/buscador", method = RequestMethod.GET)
                public String getPrescriptionSearchView(Model model) {
                               if (!(auth instanceof AnonymousAuthenticationToken)) {
                                               CustomUser userDetails = (CustomUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
                                               
                               Calendar calendar = new GregorianCalendar(); 

                               int year = calendar.get(calendar.YEAR);
                               int month = calendar.get(calendar.MONTH);
                               int day = calendar.get(calendar.DATE);

                               calendar.set(year, month, day);

                               Long timeInMillis = calendar.getTimeInMillis();
                               String date = "/Date("+timeInMillis+")/";
                               List<GetMedicalPrescriptionsByDateResult> GetMedicalPrescriptionsByDateResults = uService.getMedicalPrescriptionsByDate(userDetails.getCodeString(), date);
                               if(GetMedicalPrescriptionsByDateResults !=null){
                               for(int i = 0; i<GetMedicalPrescriptionsByDateResults.size();i++){
                                               String dateInString = getDate(GetMedicalPrescriptionsByDateResults.get(i).getReportDate());
                                               GetMedicalPrescriptionsByDateResults.get(i).setReportDate(dateInString);
                               }
                               }
                               model.addAttribute("medicalPrescriptions", GetMedicalPrescriptionsByDateResults);
                               }
                               return "prescriptionHistory";
                               
                }
                @RequestMapping(value="/buscador/rangos", method = RequestMethod.POST)
                public @ResponseBody List<GetMedicalPrescriptionsByDateResult> getMedicalPrescriptionByRanges(@RequestParam("dateInRanges") String dateRanges, Model model){
                               List<GetMedicalPrescriptionsByDateResult> GetMedicalPrescriptionsByDateResults = null;
                               if (!(auth instanceof AnonymousAuthenticationToken)) {
                                               CustomUser userDetails = (CustomUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
                                               
                               String[] ranges = dateRanges.split("-");
                               
                               Long timeInMillisInit = getDateInMiliseconds(ranges[0]);
                               String initialDate = "/Date("+timeInMillisInit+")/";
                               
                               Long timeInMillisFinal = getDateInMiliseconds(ranges[1]);
                               String finalDate = "/Date("+timeInMillisFinal+")/";
                               GetMedicalPrescriptionsByDateResults = uService.getMedicalPrescriptionsByRangeDate(userDetails.getCodeString(), initialDate, finalDate);
                               if(GetMedicalPrescriptionsByDateResults !=null){
                                               for(int i = 0; i<GetMedicalPrescriptionsByDateResults.size();i++){
                                                               String dateInString = getDate(GetMedicalPrescriptionsByDateResults.get(i).getReportDate());
                                                               GetMedicalPrescriptionsByDateResults.get(i).setReportDate(dateInString);
                                               }
                               }
                               
                               model.addAttribute("medicalPrescriptions", GetMedicalPrescriptionsByDateResults);
                               }
                               return GetMedicalPrescriptionsByDateResults;
                }
                
                @RequestMapping(value = "/reimpresion/receta-{id}", method = RequestMethod.GET)
                public ModelAndView getMedicalPrescriptionById(@PathVariable("id")int id, ModelMap modelMap){
                               if (!(auth instanceof AnonymousAuthenticationToken)) {
                                               GetMedicalPrescriptionResult getMedicalPrescriptionResult = uService.getMedicalPrescripcion(id);
                                               CustomUser userDetails = (CustomUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
                                               getMedicalPrescriptionResult.setDeviceId(gSettings.getDeviceId());
                                               getMedicalPrescriptionResult.setTargetId(gSettings.getTargetId());
                                               getMedicalPrescriptionResult.setCodeId(userDetails.getCodeId());
                                               getMedicalPrescriptionResult.setClientId(userDetails.getClientId());
                               List<GetAddressesByClientResult> addresses = uService.getAddressesByClient((int)getMedicalPrescriptionResult.getClientId());
                               GetClientDetailCompleteByEmailResult client = uService.getClientDetailCompleteByEmail(userDetails.getUsername());
                               
                               if(addresses.size()>0){
                                               String street = addresses.get(0).getStreet()!=null?"calle "+addresses.get(0).getStreet()+", ":"";
                                               String external = addresses.get(0).getExt()!=null?"Exterior "+addresses.get(0).getExt()+", ":"";
                                               String internal = addresses.get(0).getInternalNumber()!=null?"Interior "+addresses.get(0).getInternalNumber()+", ":"";
                                               String suburb = addresses.get(0).getSuburb()!=null?"Col. "+addresses.get(0).getSuburb()+", ":"";
                                               String location = addresses.get(0).getLocation()!=null?addresses.get(0).getLocation()+" ":"";
                                               String state = addresses.get(0).getStateName()!=null?addresses.get(0).getStateName()+", ":"";
                                               String zipCode = addresses.get(0).getZipCode()!=null?addresses.get(0).getZipCode():"";
                                               String address = street+external+internal+suburb+location+state+zipCode;
                                               modelMap.addAttribute("address", address);
                               }
                               ProductsByMedicalPrescription productsByMedicalPrescription = getProducts(getMedicalPrescriptionResult.getJSONContent());
                               
                               JRDataSource ds = new JRBeanCollectionDataSource(productsByMedicalPrescription.getProducts());
                               modelMap.addAttribute("datasource", ds);
                               modelMap.addAttribute("format", "pdf");
                               modelMap.addAttribute("BloodPressure", getMedicalPrescriptionResult.getBloodPressure());
                               //modelMap.addAttribute("Expedient", medicalPrescription.getExpedient());
                               modelMap.addAttribute("Gender", getMedicalPrescriptionResult.getGender());
                               modelMap.addAttribute("HeartRate", getMedicalPrescriptionResult.getHeartRate());
                               modelMap.addAttribute("Height", (long) getMedicalPrescriptionResult.getHeight());
                               //modelMap.addAttribute("Months", medicalPrescription.getMonths());
                               modelMap.addAttribute("PatientLastName", getMedicalPrescriptionResult.getPatientLastName());
                               modelMap.addAttribute("PatientName", getMedicalPrescriptionResult.getPatientName());
                               modelMap.addAttribute("RespiratoryRate", getMedicalPrescriptionResult.getRespiratoryRate());
                               modelMap.addAttribute("Weight", (long) getMedicalPrescriptionResult.getWeight());
                               modelMap.addAttribute("Years", getOld(getMedicalPrescriptionResult.getBirthday()));
                               if(client != null){
                            	   if(client.getCompleteName()!=null){
                            		   modelMap.addAttribute("DoctoName", client.getCompleteName()); 
                            	   }
                            	   
                                   if(client.getSpeciality()!=null){
                                                   modelMap.addAttribute("Speciality", client.getSpeciality().getSpecialityName());
                                                   modelMap.addAttribute("ProfessionalLicense", client.getProfessionalLicense());
                                   }   
                               }
                               
                               
                               modelMap.addAttribute("Recommendations", productsByMedicalPrescription.getRecommendations());
                               modelMap.addAttribute("Idx",productsByMedicalPrescription.getIdx());
                               
                               modelMap.addAttribute("printingDate", getDate(getMedicalPrescriptionResult.getReportDate()));
                               }
                               // Return the View and the Model combined
                               return new ModelAndView("multiReport", modelMap);
                }
                @RequestMapping(value="/guardar", method=RequestMethod.POST)
                public @ResponseBody Boolean saveMedicalPrescription(Model model, @RequestBody MedicalPrescription medicalPrescription){
                	if (!(auth instanceof AnonymousAuthenticationToken)) {
				                        CustomUser userDetails = (CustomUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
				                        ManagerUnicodeConverter managerUnicodeConverter = new ManagerUnicodeConverter();
				                        medicalPrescription.setDeviceId(gSettings.getDeviceId());
				                        medicalPrescription.setTargetId(gSettings.getTargetId());
				                        medicalPrescription.setCodeId(userDetails.getCodeId());
				                        medicalPrescription.setClientId(userDetails.getClientId());
				                        try {
											medicalPrescription.setJSONContent(managerUnicodeConverter.getStringISO(medicalPrescription.getJSONContent()));
										} catch (FileManagerException e) {
											e.printStackTrace();
										}
				        return uService.saveMedicalPrescription(userDetails.getCodeString(), medicalPrescription);
				        }
				        return null;
                }
                
                @RequestMapping(value="/imprimir", method=RequestMethod.POST)
                public @ResponseBody String printMedicalPrescription(Model model, ModelMap modelMap, @RequestBody  MedicalPrescription medicalPrescription){
                               if (!(auth instanceof AnonymousAuthenticationToken)) {
                                               CustomUser userDetails = (CustomUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
                                               medicalPrescription.setDeviceId(gSettings.getDeviceId());
                                               medicalPrescription.setTargetId(gSettings.getTargetId());
                                               medicalPrescription.setCodeId(userDetails.getCodeId());
                                               medicalPrescription.setClientId(userDetails.getClientId());
                               List<GetAddressesByClientResult> addresses = uService.getAddressesByClient((int)medicalPrescription.getClientId());
                               GetClientDetailCompleteByEmailResult client = uService.getClientDetailCompleteByEmail(userDetails.getUsername());
                               
                               if(addresses.size()>0){
                                               String street = addresses.get(0).getStreet()!=null?"calle "+addresses.get(0).getStreet()+", ":"";
                                               String external = addresses.get(0).getExt()!=null?"Exterior "+addresses.get(0).getExt()+", ":"";
                                               String internal = addresses.get(0).getInternalNumber()!=null?"Interior "+addresses.get(0).getInternalNumber()+", ":"";
                                               String suburb = addresses.get(0).getSuburb()!=null?"Col. "+addresses.get(0).getSuburb()+", ":"";
                                               String location = addresses.get(0).getLocation()!=null?addresses.get(0).getLocation()+" ":"";
                                               String state = addresses.get(0).getStateName()!=null?addresses.get(0).getStateName()+", ":"";
                                               String zipCode = addresses.get(0).getZipCode()!=null?addresses.get(0).getZipCode():"";
                                               String address = street+external+internal+suburb+location+state+zipCode;
                                               modelMap.addAttribute("address", address);
                               }
                               ProductsByMedicalPrescription productsByMedicalPrescription = getProducts(medicalPrescription.getJSONContent());
                               
                               JRDataSource ds = new JRBeanCollectionDataSource(productsByMedicalPrescription.getProducts());
                               modelMap.addAttribute("datasource", ds);
                               modelMap.addAttribute("format", "pdf");
                               modelMap.addAttribute("BloodPressure", medicalPrescription.getBloodPressure());
                               //modelMap.addAttribute("Expedient", medicalPrescription.getExpedient());
                               modelMap.addAttribute("Gender", medicalPrescription.getGender());
                               modelMap.addAttribute("HeartRate", medicalPrescription.getHeartRate());
                               modelMap.addAttribute("Height", medicalPrescription.getHeight());
                               //modelMap.addAttribute("Months", medicalPrescription.getMonths());
                               modelMap.addAttribute("PatientLastName", medicalPrescription.getPatientLastName());
                               modelMap.addAttribute("PatientName", medicalPrescription.getPatientName());
                               modelMap.addAttribute("RespiratoryRate", medicalPrescription.getRespiratoryRate());
                               modelMap.addAttribute("Weight", medicalPrescription.getWeight());
                               modelMap.addAttribute("Years", getOld(medicalPrescription.getBirthday()));
                               if(client!= null){
                            	   if(client.getCompleteName()!=null){
                            		   modelMap.addAttribute("DoctoName", client.getCompleteName());
                            	   }
                                   if(client.getSpeciality()!=null){
                                   modelMap.addAttribute("Speciality", client.getSpeciality().getSpecialityName());
                                   modelMap.addAttribute("ProfessionalLicense", client.getProfessionalLicense());
                                   }
                               }
                               
                               modelMap.addAttribute("Recommendations", productsByMedicalPrescription.getRecommendations());
                               modelMap.addAttribute("Idx",productsByMedicalPrescription.getIdx());
                               
                
                               // Return the View and the Model combined
                               model.addAttribute("modeloReceta", modelMap);
                               }
                               return "todo bien";
                                               
                               
                }
                @RequestMapping(value="/pdf", method=RequestMethod.GET)
                public ModelAndView views(@ModelAttribute("modeloReceta")ModelMap modelMap){
                               return new ModelAndView("multiReport", modelMap);
                }
                
                
                //METODOS
                
                
                private ProductsByMedicalPrescription getProducts(String jsonContent){
                               ObjectMapper mapper = new ObjectMapper();
                               ProductsByMedicalPrescription productsByMedicalPrescription= null;
                               int begin = -1;
                               int end = -1;
                               String substances = null;
                               SubstancesByMedicalPrescriptionResponse[] substance = null;
                               
                               try {
                            	      begin = jsonContent.indexOf("\"Substances\":[");
                            	      if(begin> -1){
                            	    	  end = jsonContent.indexOf("],", begin);
                            	    	  if(end >-1){
                            	    		  substances = jsonContent.substring(begin+13, end+1);
                            	    		  substance = mapper.readValue(substances, SubstancesByMedicalPrescriptionResponse[].class);
                            	    		  if(substance != null && substance.length>0){
                            	    			  substances = "";
                            	    			  int i = 0;
                            	    			  for(SubstancesByMedicalPrescriptionResponse subsRsp : substance){
                            	    				  if(i==substance.length-1){
                            	    					  substances+= subsRsp.getDescription();
                            	    				  }else{
                            	    					  substances+= subsRsp.getDescription()+", ";
                            	    					  
                            	    				  }
                            	    			  }
                            	    			  jsonContent = jsonContent.substring(0, begin) + "\"Substances\":\""+ substances+"\""+ jsonContent.substring(end+1, jsonContent.length());
                            	    		  }
                            	    	  }
                            	    	  
                            	      }
                            	      
                                               productsByMedicalPrescription = mapper.readValue(jsonContent, ProductsByMedicalPrescription.class);
                                               List<ProductByMedicalPrescription> products =  productsByMedicalPrescription.getProducts();
//                                           for(int i=0; i<products.size();i++){
//                                                           String sustances= "";
//                                                           
//                                                           productsByMedicalPrescription.getProducts().get(i).setSubstancesInString(sustances);
//                                                                                                                         
//                                           }
                                               return productsByMedicalPrescription;
                               } catch (Exception e) {
                                               // TODO: handle exception
                                               return null;
                               }
                }
                

private String getDate(String dateInString){
                               
                                String[] fulldate =  dateInString.replace("/Date(", "").replace(")/", "").split("-");
                               Long dateFromClient = Long.parseLong(fulldate[0]);
                     Date date=null;
        try {
                date = new Date(dateFromClient);
                Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            return calendar.get(Calendar.DATE)+"/"+(calendar.get(Calendar.MONTH)+1)+"/"+calendar.get(Calendar.YEAR);
        } catch (Exception ex) {
            System.out.println("Error:"+ex);
            return null;
        }
       
        
 }
private Long getDateInMiliseconds(String dateInString){
                try {
                                               Date date = new SimpleDateFormat("yyyy/MM/dd").parse(dateInString);
                                               
                                               Calendar calendar = Calendar.getInstance();
                                               calendar.setTime(date);
                                               
                                               Date pruebadate = new Date(calendar.getTimeInMillis());
                                                               return calendar.getTimeInMillis();
                               } catch (ParseException e) {
                                               // TODO Auto-generated catch block
                                               e.printStackTrace();
                                               return null;
                               }
                
 }
                
                private int getOld(String birthday){
                               
                                String[] fulldate =  birthday.replace("/Date(", "").replace(")/", "").split("-");
                               Long dateFromClient = Long.parseLong(fulldate[0]);
                     Date fechaNac=null;
        try {
                fechaNac = new Date(dateFromClient);
            //fechaNac = new SimpleDateFormat("yyyy-MM-dd").parse(fechita);
            System.out.println(fechaNac.toString());
        } catch (Exception ex) {
            System.out.println("Error:"+ex);
        }
        Calendar fechaNacimiento = Calendar.getInstance();
        //Se crea un objeto con la fecha actual
        Calendar fechaActual = Calendar.getInstance();
        //Se asigna la fecha recibida a la fecha de nacimiento.
        fechaNacimiento.setTime(fechaNac);
        //Se restan la fecha actual y la fecha de nacimiento
        int anio = fechaActual.get(Calendar.YEAR)- fechaNacimiento.get(Calendar.YEAR);
        int mes =fechaActual.get(Calendar.MONTH)- fechaNacimiento.get(Calendar.MONTH);
        int dia = fechaActual.get(Calendar.DATE)- fechaNacimiento.get(Calendar.DATE);
        //Se ajusta el año dependiendo el mes y el día
        if(mes<0 || (mes==0 && dia<0)){
            anio--;
        }
        //Regresa la edad en base a la fecha de nacimiento
                return anio;
}
                
         
    }
