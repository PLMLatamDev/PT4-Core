<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/libraries/moment/moment.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/libraries/bootstrap-timepicker/daterangepicker.js"></script>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap-datetimepicker/daterangepicker.css" >

<script type="text/javascript">


//var patientId=${patientInfo.patientId};
  
  $(function () {

	 $("#result-description").stacktable();
	  // init PrescriptionBrands
	  var  SelectorHTML_Prescription = $('#result-description tbody').selector;
	  var typeId=2;
	  
	//Unidades ->prescripciones anteriores
	  //$.ECE.layout.getQuantityUnits();
	  
	 // $.ECE.layout.getPatientPrescriptionBrands(patientId,typeId,SelectorHTML_Prescription);
	  
	  
	  $('input[name="daterange"]').daterangepicker({
		  
		    maxDate: moment(),
	        ranges: {

	           'Esta Semana': [moment().subtract(6, 'days'), moment()],
	           'Este Mes': [moment().subtract(29, 'days'), moment()],
	        },
	        startDate: moment().subtract(29, 'days'),
	        endDate: moment()
		  
	  });
	  
	  
	  
	  
	  // Form search Prescription By Range
	  $('#searchPrescriptionsByRangeDate').formValidation({
	         framework: 'bootstrap',
	         icon: {
	             valid: 'fa fa-check',
	             invalid: 'fa fa-times',
	             validating: 'fa fa-refresh'
	         },
	         fields: {
	        	 daterange: {
		                    validators: {
		                        notEmpty: {
		                            message: 'Campo requerido'
		                        }
		                    }
		                }
	         }
	 	  }).on('success.form.fv', function(e) {
	          
		 		 e.preventDefault();
		 		 
		 		 var rangeDate=$("#searchPrescriptionsByRangeDate [name='daterange']").val();
		 		 
		 		 // var  SelectorHTML_Prescription = $('#result-description tbody').selector;
		 		 $.ajax({  
					     type : "POST",   
					     url : urlPath+'/receta/buscador/rangos',   
					     data : "dateInRanges=" + rangeDate ,  
					     success : function(response) {  
					    	 console.log(response);
					    	 var html="";
			                 for(var i=0; i<response.length;i++){
			                	 html += '<tr>'+
								    '<td>'+response[i].Expedient+'</td>'+
								    '<td>'+response[i].PatientName+" "+response[i].PatientLastName+'</td>'+
								    '<td>'+response[i].ReportDate+'</td>'+
								    '<td><a class="btn btn-app" onclick="getMedicalPrescriptionById('+response[i].ReportId+')" style="height: 30px;padding: 0;"><i class="fa fa-search"></i></a></td>'+
								  '</tr>'; 
			                 }   
			                 $('#result-description tbody').html(html);
	
					     },  
					     error : function(e) {  
					    	 console.log('Error: ' + e);
					    	 
					    	 				    	 
					      
					     }  
					    }); 
		 		  //$.ECE.layout.getPatientPrescriptionBrandsByDate(patientId,rangeDate,SelectorHTML_Prescription);
		 		  
		 		 $('#searchPrescriptionsByRangeDate').data('formValidation').resetForm();
		 		  
		 		 
		
		     });
	  
	  
	    //Modal  PDF Receta

	 	$('#modalClinicHistoryPDF').on('show.bs.modal', function(e) {
	 		

	 	});
	 	
	 	$('#modalClinicHistoryPDF').on('hidden.bs.modal', function () {
	 		
	 	

	 	});
	  
  });
  //Modal  PDF Receta
  function getMedicalPrescriptionById(id){
	  $('#modalPrescriptionPDF').modal('show');
		 $('#modalPrescriptionPDF').modal({backdrop:'static'});
		 $("#modal-body-content-pdf iframe" ).remove();
		 $('#modalPrescriptionPDF').modal('show');
		$("#modal-body-content-pdf" ).append('<iframe name="abc_frame" id="abc_frame" src='+urlPath+"/receta/reimpresion/receta-"+id+' width="100%" height="540" ></iframe>');
		$('#modalClinicHistoryPDF').modal('show');
	        }

</script>

<style>

#result-description span {
    font-weight: 700;
}

#searchPrescriptionsByRangeDate .form-control-feedback{
	             margin: 2px 60px;
	}
	
</style>
<section class="content">
<div class="row">
 <div class="col-md-1">
 </div>
  
 <div class="col-md-10">
 
   <div class="box box-primary">
                
  
			    <div class="box-body">
			        <div class="row">
	                    <div class="col-sm-6">
					             
							   <form method="POST" id="searchPrescriptionsByRangeDate">
							      <div class="form-group"> 
								       <label>Buscar receta(s) por fecha</label>
					                    <div class="input-group input-group-sm ">                       
					                    <input type="text"  class="form-control" name="daterange"/>
					                    <span class="input-group-btn">
					                      <button class="btn btn-primary btn-flat" type="submit">Buscar</button>
					                    </span>
					                  </div>
				                 </div>
				                 
				                </form>
				                 
				                 

					            
				         </div>
				    </div>
				    
				    <hr>

		              <div class="col-sm-10">
					        <table class="table table-striped" id="result-description">
			                  <thead>
			                    <tr >
			                      <th>Expediente</th>
			                      <th>Paciente</th>
			                      <th>Fecha Última Receta</th>
			                      <th>Ver Receta</th>
			                    </tr>
			                  </thead>
			                  <tbody>
			                  
			                     <c:forEach items="${medicalPrescriptions}" var="medicalPrescription">
			                      <tr>
								    <td>${medicalPrescription.getExpedient()}</td>
								    <td>${medicalPrescription.getPatientName()} ${medicalPrescription.getPatientLastName()}</td>
								    <td>${medicalPrescription.getReportDate()}</td>
								    <td><a class="btn btn-app" onclick="getMedicalPrescriptionById(${medicalPrescription.getReportId()})" style="height: 30px;padding: 0;"><i class="fa fa-search"></i></a></td>
								  </tr>   
			                     </c:forEach>
			                      
	                          </tbody>
	                        </table>
					  </div>
				    		    
			    
			    
			    </div>
   </div>
  
 </div>
 
 
  <!-- Modal  -->
			<div aria-hidden="true" class="modal fade" id="modalClinicHistoryPDF" tabindex="-1" role="dialog" aria-labelledby="modalClinicHistoryPDF" >
			    <div class="modal-dialog" style="width:70%;min-height:650px;overflow-y: hidden;">
			        <div class="modal-content">
			            <div class="modal-header">
			                <h3 class="modal-title">Receta</h3>
			            </div>
			
			            <div class="modal-body" id="modal-body-content-pdf">
			               
			            </div>
			
			            <div class="modal-footer">
			                      <button type="button" class="btn btn-primary" id="" data-dismiss="modal" >Cerrar</button>
			                <!--  <button type="button" class="btn btn-default" id="disagreeButton" data-dismiss="modal">Cerrar</button> -->
			            </div>
			        </div>
			    </div>
			</div>
			</div>
			</section>