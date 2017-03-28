<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<script type="text/javascript">

var _addressesByClient=[];
var _updateAddressesId=0;
 
$(function () {
	
	
	 $('#demo-collapse').collapse('show');
	 $("#row-addresses").hide();
	 
	
	 
	 

	
	$('#consultorioForm').formValidation({
	    framework: 'bootstrap',
	    icon: {
	        valid: 'fa fa-check',
	        invalid: 'fa fa-times',
	        validating: 'fa fa-refresh'
	    },
	    fields: {
	    
	    	 countrId: {
                 validators: {
                     notEmpty: {
                         message: 'Campo requerido'
                     }
                 }
             },
             stateName: {
             	
                 validators: {
                     notEmpty: {
                         message: 'Campo requerido'
                     }
                 }
             },
             location: {
                 validators: {
                     notEmpty: {
                         message: 'Campo requerido'
                     }
                 }
             },
             suburb: {
                 validators: {
                     notEmpty: {
                         message: 'Campo requerido'
                     }
                 }
             },
             zipCode: {
                 validators: {
                     notEmpty: {
                         message: 'Campo requerido'
                     }
                 }
             },
             street: {
                 validators: {
                     notEmpty: {
                         message: 'Campo requerido'
                     }
                 }
             }
	    }
	 }).on('success.form.fv', function(e) {
		 
	      e.preventDefault();
	      
	     
	      arrayAddresses={
	    	   'CountryId':parseInt($("#consultorioForm [name='countryId']").val()),
	    	   'ExternalNumber':$("#consultorioForm [name='externalNumber']").val(),
	    	   'InternalNumber':$("#consultorioForm [name='internalNumber']").val(),
	    	   'Ext':'',
	    	   'Fax':'',
	    	   'Lada':$("#consultorioForm [name='lada']").val(),
	    	   'LocationId':parseInt($("#consultorioForm [name='location']").val().split('%%')[0]),
	    	   'Location':$("#consultorioForm [name='location']").val().split('%%')[1],
	    	   'PhoneOne':$("#consultorioForm [name='phoneOne']").val(),
	    	   'PhoneTwo':$("#consultorioForm [name='phoneTwo']").val(),
	    	   'StateId':parseInt($("#consultorioForm [name='stateName']").val().split('%%')[0]),
	    	   'StateName':$("#consultorioForm [name='stateName']").val().split('%%')[1],
	    	   'Street':$("#consultorioForm [name='street']").val(),
	    	   'SuburbId':parseInt($("#consultorioForm [name='suburb']").val().split('%%')[0]),
	    	   'Suburb':$("#consultorioForm [name='suburb']").val().split('%%')[1],
	    	   'ZipCodeId':parseInt($("#consultorioForm [name='zipCode']").val().split('%%')[0]),
	    	   'ZipCode':$("#consultorioForm [name='zipCode']").val().split('%%')[1]
	      }
	      
	     
	      
	      //save
	      if(_updateAddressesId==0){
	    	  
	    	  $("#loaderView").fadeIn();
		        $.ajax({  
			     type : "POST",   
			     url : urlPath+'/consultorios/SaveClientAddresses', 
			     data : JSON.stringify(arrayAddresses), 
			     contentType: 'application/json',
	    	 	 mimeType: 'application/json',  
			     success : function(response) {  
			    	 
			    	       if(response){
			    	    	   
			    	    	   if (navigator.appName == 'Microsoft Internet Explorer'){
	  		                	 
				    			     window.location.href(urlPath+"/consultorios");
				    	         }
					             else{
					            	 
					            	 window.location.href = urlPath+"/consultorios";
					            		 
					             }  
			    	       }
			    	       
			    	       $("#loaderView").fadeOut();
			    	 
			     },
			     error : function(e) {  
			    	 console.log('Error: ' + e);
			    	 
			    	 $("#loaderView").fadeOut(); 
			    	 
			      
			     }  
			    });
	    	  
	    	  
	    	  
	      }
	      //update
	      else{
	    	  
	    	  arrayAddresses['AddressId']=_updateAddressesId;
	    	  
	    	  console.log(arrayAddresses);
	    	  
	    	  $("#loaderView").fadeIn();
		        $.ajax({  
			     type : "POST",   
			     url : urlPath+'/consultorios/updateAddressByClientInfo', 
			     data : JSON.stringify(arrayAddresses), 
			     contentType: 'application/json',
	    	 	 mimeType: 'application/json',  
			     success : function(response) {  
			    	 
			    	       if(response){
			    	    	   
			    	    	   if (navigator.appName == 'Microsoft Internet Explorer'){
	  		                	 
				    			     window.location.href(urlPath+"/consultorios");
				    	         }
					             else{
					            	 
					            	 window.location.href = urlPath+"/consultorios";
					            		 
					             }  
			    	       }
			    	       
			    	       $("#loaderView").fadeOut();
			    	 
			     },
			     error : function(e) {  
			    	 console.log('Error: ' + e);
			    	 
			    	 $("#loaderView").fadeOut(); 
			    	 
			      
			     }  
			    });
		    	
	    	  
	      }
	    
	      
	      
		 
	 });
	
	
	var arrayAddresses= {};
	
	//getAddressesByClient
	
	  $("#loaderView").fadeIn();
	  $.ajax({  
		     type : "POST",   
		     url : urlPath+'/consultorios/getAddressesByClient',   
		     success : function(response) {  
		    	 
		    	console.log(response);
		    	 	
		    	// arrayAddresses=response;
		    	 
		         if(response.length>0){
		        	 
		        	 
		        	 _addressesByClient=response;
		        	 
		        	 $("#row-addresses").show();
		        	 
		        	  var html = '';
	                  var len = response.length;
	                  for(var i=0; i<len; i++){
	                	  
	                	  html+=	  '<div class="renglon" >'+
								        '<div class="tab-5 head first">'+response[i].StateName+'</div>'+
								        '<div class="tab-5 head">'+response[i].Location+'</div>'+
								        '<div class="tab-5 head">'+response[i].Suburb+'</div>'+
								        '<div class="tab-5 head">'+response[i].Street+' ';
												        if(response[i].ExternalNumber!='' && response[i].ExternalNumber!=null)
								                        	 html+=  '<label>  &nbsp; Ext.'+response[i].ExternalNumber+ '</label>';
								                         if(response[i].InternalNumber!='' && response[i].InternalNumber!=null )
								                        	 html+=  '<label> &nbsp;  Int.'+response[i].InternalNumber+ '</label>';
								                         if(response[i].ZipCode!='')
								                        	 html+=  '<label> &nbsp;  C.P.'+response[i].ZipCode+ '</label>';
					      html+=	    '</div>'+
								        '<div class="tab-5 head">';
								                         if(response[i].PhoneOne!='')
								                        	 html+=  '<label>'+response[i].PhoneOne+'</label>';
								                         if(response[i].PhoneTwo!='')
								                        	 html+=   '<label> - '+response[i].PhoneTwo+'</label>';
			
						  html+=	    '</div>'+
								        '<div class="tab-5 head">'+
								        	//'<span class="label label-danger">Eliminar</span>'+
								        	  '<a class="label label-warning" onclick="javascript:UpdateAddresses(\''+i+'\');">Actualizar</a>'+
								        '</div>'+
							           '</div>';
	                      
	                  } 
	             
	   
	                 $('#row-addresses').append(html);
		        	 
		        	
		         }else{
		        	 
		        	
		        	 
		        	// $('#demo-collapse').collapse('show');
		    
		        	 
		         }
		         
		         $("#loaderView").fadeOut();
		    	 
		     },  
		     error : function(e) {  
		    	 console.log('Error: ' + e);
		    	 
		    	 $("#loaderView").fadeOut();
		    	 
		      
		     }  
		    });
	
	//Events
	
	
	  $('#profileState').change(function(){
	  
		    $('#profileLocation option').not(':first').remove();
		    $('#profileSuburb option').not(':first').remove();
		    $('#profileZipCode option').not(':first').remove();
		    
		    var stateId=$(this).val().split('%%');
		    var selectorHTML=$('#profileLocation').selector;
		   
		    getLocationsByState(stateId[0],selectorHTML);
		
		});
	  
	  
	  $('#profileLocation').change(function(){
		  
		   $('#profileSuburb option').not(':first').remove();
		   $('#profileZipCode option').not(':first').remove();
		   
		    var locationId=$(this).val().split('%%');
		    var selectorHTML=$('#profileSuburb').selector;
		      
		    getSuburbsByLocation(locationId[0],selectorHTML);
		
		});
	  
	  $('#profileSuburb').change(function(){
		  
		   $('#profileZipCode option').not(':first').remove();
		    var suburbId=$(this).val().split('%%');
		    var locationId= $('select[name="location"] option:selected').val().split('%%');
		    var locationSuburb=locationId[0]+'-'+suburbId[0];
		    var selectorHTML=$('#profileZipCode').selector;
	    
		    getSuburbsZipCodeByLocation(locationSuburb,selectorHTML);
		
		});
		
	 	

	
	
	
    $('.collapsed').on('click', function(e) {
    	
 
    	  $(this).find('i')
		   .toggleClass('fa-plus-circle')
		   .toggleClass('fa-minus-circle')
    
    });
    
    
 
});


function UpdateAddresses(i){
	
	 console.log(_addressesByClient);
	  //$('#demo-collapse').collapse('show');
	  
	  $("#submitAdrress").text("Actualizar datos");
	  
	  _updateAddressesId=_addressesByClient[i].AddressId;
	
	
	  /*State */ 
	  $('#consultorioForm [name="stateName"]').val(_addressesByClient[i].StateId+'%%'+_addressesByClient[i].StateName);

	 
	 
	    $('#profileLocation option').not(':first').remove();
	    $('#profileSuburb option').not(':first').remove();
	    $('#profileZipCode option').not(':first').remove();
	   
	  /*Location*/  
	  
	    var stateId=_addressesByClient[i].StateId;
	    var selectorHTML=$('#profileLocation').selector;
	    var valueLocation= _addressesByClient[i].LocationId+'%%'+_addressesByClient[i].Location.toUpperCase();
	   
	    getLocationsByState(stateId,selectorHTML,valueLocation);
	    
	/* Suburb */
	
		var locationId=_addressesByClient[i].LocationId;
		var selectorHTML=$('#profileSuburb').selector;
		var valueSuburb= _addressesByClient[i].SuburbId+'%%'+_addressesByClient[i].Suburb.toUpperCase();
		      
		getSuburbsByLocation(locationId,selectorHTML,valueSuburb);
		
   /* ZipCode */

		var suburbId=_addressesByClient[i].SuburbId;
	    var locationId= _addressesByClient[i].LocationId
	    var locationSuburb=locationId+'-'+suburbId;
	    var selectorHTML=$('#profileZipCode').selector;
	    var valueZipcode=_addressesByClient[i].ZipCodeId+'%%'+_addressesByClient[i].ZipCode;
    
	    getSuburbsZipCodeByLocation(locationSuburb,selectorHTML,valueZipcode);
	    
    /*Los demas */
    
                
   	   $("#consultorioForm [name='externalNumber']").val(_addressesByClient[i].ExternalNumber);
   	   $("#consultorioForm [name='internalNumber']").val(_addressesByClient[i].InternalNumber);
   	   $("#consultorioForm [name='lada']").val();
   	   $("#consultorioForm [name='phoneOne']").val(_addressesByClient[i].PhoneOne);
   	   $("#consultorioForm [name='phoneTwo']").val(_addressesByClient[i].PhoneTwo),
   	   $("#consultorioForm [name='street']").val(_addressesByClient[i].Street);
}

function getLocationsByState(stateId,selectorHTML,value){
	
	
	$("#loaderView").fadeIn();
	  $.ajax({  
		     type : "POST",   
		     url : urlPath+'/login/getLocationsByState',   
		     data : "stateId=" + stateId ,  
		     success : function(response) {  
		    	 
		    	
		    	
		    	 if(response.length>0){
		    		 
		    		  var html = '';
	                  var len = response.length;
	                  for(var i=0; i<len; i++){
	                       html += '<option value="' + response[i].LocationId + '%%'+response[i].LocationName.toUpperCase() +'">' + response[i].LocationName.toUpperCase() + '</option>';
	                   }
	                  $(''+selectorHTML+'').append(html);
	                  
	                  
	                  if(value!=null){
	                    $(''+selectorHTML+'').val(''+value+'');
	                  }
		    	 }
		    	 
		    	 $("#loaderView").fadeOut();
		    	 
		     },  
		     error : function(e) {  
		    	 console.log('Error: ' + e);
		    	 
		    	 $("#loaderView").fadeOut();
		    	 
		      
		     }  
		    });
	

}

function getSuburbsByLocation(locationId,selectorHTML,value){
	
	
	
	  $("#loaderView").fadeIn();
	  $.ajax({  
		     type : "POST",   
		     url : urlPath+'/login/getSuburbsByLocation',   
		     data : "locationId=" + locationId ,  
		     success : function(response) {  
		    	 	
		    	 if(response.length>0){
		    		 
		    		  var html = '';
	                  var len = response.length;
	                  for(var i=0; i<len; i++){
	                       html += '<option value="' + response[i].SuburbId + '%%'+ response[i].SuburbName.toUpperCase() +'">' + response[i].SuburbName.toUpperCase() + '</option>';
	                   }
	                  $(''+selectorHTML+'').append(html);
	                  
	                  
	                  if(value!=null){
	                    $(''+selectorHTML+'').val(''+value+'');
	                  }
		    	 }
		    	 
		    	 $("#loaderView").fadeOut();
		    	 
		     },  
		     error : function(e) {  
		    	 console.log('Error: ' + e);
		    	 
		    	 $("#loaderView").fadeOut();
		    	 
		      
		     }  
		    });
	

}

function getSuburbsZipCodeByLocation(locationSuburb,selectorHTML,value){
	
	
	
	  $("#loaderView").fadeIn();
	  $.ajax({  
		     type : "POST",   
		     url : urlPath+'/login/getSuburbsZipCodeByLocation',   
		     data : "locationSuburb=" + locationSuburb,  
		     success : function(response) {  
		    	 	
		    	 if(response.length>0){
		    		 
		    		  var html = '';
	                  var len = response.length;
	                  for(var i=0; i<len; i++){
	                       html += '<option value="' + response[i].ZipCodeId + '%%'+response[i].Zipcode+'">' + response[i].Zipcode + '</option>';
	                   }
	                  $(''+selectorHTML+'').append(html);
	                  
	                  
	                  if(value!=null){
	                    $(''+selectorHTML+'').val(''+value+'');
	                  }
		    	 }
		    	 $("#loaderView").fadeOut();
		    	 
		     },  
		     error : function(e) {  
		    	 console.log('Error: ' + e);
		    	 
		    	 $("#loaderView").fadeOut();
		    	 
		      
		     }  
		    });
	

}


</script> 


<style>
 label {
 font-weight: 500;
 }
 
 .btn-collapsed {
    color: #337ab7 !important;
    font-size: 26px;
    font-weight: bold;
    cursor: pointer;
}

.row {
    margin-right: 15px;
    margin-left: 15px;
}

</style>
<section class="content">
<div class="row">
<div class="col-md-1"></div>
  <div class="col-md-10" id="creatininaPrincipal">
     <div class="box box-primary">
                <div class="box-header with-border">
                  <h3 class="box-title"><strong>Consultorio(s)</strong></h3>
                </div> <!-- /.box-header -->
                <!-- form start -->
        
                  <div class="box-body">
                   <div class="row">
	                    <div class="box-tools pull-right">
		                      <!--<button class="btn btn-box-tool" data-widget="collapse"></button>-->
		                     <!-- <div class="btn-collapsed collapsed" data-toggle="collapse" data-target="#demo-collapse"><i class="fa fa-plus-circle"></i></div>-->
		                </div>
	                </div>
	              
	              <form:form modelAttribute="formAddress"   method="post"  id="consultorioForm">   
                  
                  <div id="demo-collapse" class="collapse" >
                 
                
                  
                 
                   <div class="row">
						        
							        <div class="col-sm-6">
							            <div class="form-group">
							                <label class="">País *</label>
							                  <form:select path="countryId"  name="countryId"  class="form-control input-sm" >
							                           <form:option value="1">México</form:option> 
							                             
								               </form:select>
							               
							            </div>	
							        </div>
							        <div class="col-sm-6">
							
							            <div class="form-group">
							                <label class="">Estado *</label>
							                 
							                  <form:select path="stateName" name="stateName"  class="form-control input-sm"   id="profileState" >
								                  <form:option value="" >Seleccionar</form:option> 
										                               <c:forEach items="${getStates}" var="state">
										                                        <form:option value="${state.stateId}%%${state.stateName}">${state.stateName}</form:option>
										                               </c:forEach>
										       </form:select>
							                     
							            </div>
							        </div>
							        
							     </div> 
							     
							      <div class="row">
							        
							        <div class="col-sm-6">
							            <div class="form-group">
							                <label class="">Municipio / Delegación *</label>
							                <form:select path="location" name="location"  class="form-control input-sm"   id="profileLocation" >
								                  <form:option value="" >Seleccionar</form:option> 
										                               
										    </form:select>
							            </div>
							        </div>
							        <div class="col-sm-3">
							
							            <div class="form-group">
							                <label class="">Colonia *</label>
							                <form:select path="suburb" name="suburb"  class="form-control input-sm"   id="profileSuburb" >
								                  <form:option value="" >Seleccionar</form:option> 
										                               
										    </form:select>
							                     
							            </div>
							        </div>
							        <div class="col-sm-3">
							
							            <div class="form-group">
							                <label class="">C.P *</label>
							                 <form:select path="zipCode" name="zipCode"  class="form-control input-sm"   id="profileZipCode" >
								                  <form:option value="" >Seleccionar</form:option> 
										                               
										    </form:select>
							                     
							            </div>
							        </div>
							        
							     </div> 
							     
							      <div class="row">
							        
							        <div class="col-sm-6">
							            <div class="form-group">
							                <label class="">Calle *</label>
							                <form:input  type="text" path="street" class="form-control input-sm" name="street"  maxlength="30"  id="profileStreet" />
							            </div>
							        </div>
							        <div class="col-sm-3">
							
							            <div class="form-group">
							                <label class="">No.Exterior</label>
							                 <form:input  type="text" path="externalNumber" class="form-control input-sm" name="externalNumber"   maxlength="15" id="profileExternalNumber" />
							                     
							            </div>
							        </div>
							        
							        <div class="col-sm-3">
							
							            <div class="form-group">
							                <label class="">No.Interior</label>
							                 <form:input  type="text" path="internalNumber" class="form-control input-sm" name="internalNumber"  maxlength="15"  id="profileInternalNumber" />
							                     
							            </div>
							        </div>
							        
							        
							       </div> 
							       
							     
								     
								     <div class="row">
							        
								        <div class="col-sm-2">
								            <div class="form-group">
								                <label class="">Lada </label>
								                <form:input  type="text" path="lada" class="form-control input-sm" name="lada" maxlength="8"  id="profileLada" />
								            </div>
								        </div>
								        <div class="col-sm-4">
								
								            <div class="form-group">
								                <label class="">Teléfono </label>
								                 <form:input  type="text" path="phoneOne" class="form-control input-sm" name="phoneOne" maxlength="15"  id="profilePhone" />
								                     
								            </div>
								        </div>
								        
								        <div class="col-sm-6">
								
								            <div class="form-group">
								                <label class="">Celular</label>
								                 <form:input  type="text" path="phoneTwo" class="form-control input-sm" name="phoneTwo"  maxlength="15"  />
								                     
								            </div>
								        </div>
								        
								        
								       </div> 
								         <div class="box-footer">
                  
						                    <button type="submit" class="btn btn-success pull-right" id="submitAdrress">Guardar Datos</button>
						                  </div><!-- /.box-footer -->
								       
								      
								   </div>
								   
								   </form:form>
								   
					     <div class="row">
								   
								<div class="form-group" id="row-addresses" >
				                         <div class="renglon renglon-hide" style="border-bottom: #3c8dbc 3px solid;">
									        <div class="tab-5 head">Estado</div>
									        <div class="tab-5 head">Minicipio</div>						        
		    						        <div class="tab-5 head">Colonia</div>
									        <div class="tab-5 head">Calle</div>
									        <div class="tab-5 head">Teléfono(s)</div>
									        <div class="tab-6 head">Acciones</div>
								       </div>
								       
				               </div>
				          </div>
								   
								   
               
                    
                  </div><!-- /.box-body -->
               
                
              </div>
  </div>

</div>
   
</section>