<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<script type="text/javascript">
 
$(function () {
	
	var subspeciality= $("#formSubspeciality").val();
	
	 if(subspeciality==null || subspeciality==''){
		 
		 $("#subspeciality-show").hide();
	 }

	$('#registerForm').formValidation({
	    framework: 'bootstrap',
	    icon: {
	        valid: 'fa fa-check',
	        invalid: 'fa fa-times',
	        validating: 'fa fa-refresh'
	    },
	    fields: {
	    
	    	firstName: {
                 validators: {
                     notEmpty: {
                         message: 'Campo requerido'
                       
                     }
                    
                 }
	        },
	        lastName: {
                validators: {
                    notEmpty: {
                        message: 'Campo requerido'
                      
                    }
                   
                }
            },
            secondLastName:{
            	
            
            	
            },
            profession: {
                validators: {
                    notEmpty: {
                        message: 'Campo requerido'
                    }
                }
            },
            speciality: {
                validators: {
                    notEmpty: {
                        message: 'Campo requerido'
                      
                    }
                   
                }
            },
            specialityLicense:{
            	validators: {
                    notEmpty: {
                        message: 'Campo requerido'
                      
                    }
                   
                }
            	
            },
            professionLicense: {
                validators: {
                    notEmpty: {
                        message: 'Campo requerido'
                      
                    }
                   
                }
            },
            professionalLicense: {
                validators: {
                    notEmpty: {
                        message: 'Campo requerido'
                      
                    }
                   
                }
            },
            country: {
                validators: {
                    notEmpty: {
                        message: 'Campo requerido'
                    }
                }
            },
            state: {
                validators: {
                    notEmpty: {
                        message: 'Campo requerido'
                      
                    }
                   
                }
            }
           /* location: {
                validators: {
                    notEmpty: {
                        message: 'Campo requerido'
                      
                    }
                   
                }
            },*/

            
            
                  
	    }
	 }).on('success.form.fv', function(e) {
		 
	
		  //e.preventDefault();
		  
		
		  
		  
		  
		 
	});
	
	
	
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
		                       html += '<option value="' + response[i].LocationId + '">' + response[i].LocationName.toUpperCase() + '</option>';
		                   }
		                  $(''+selectorHTML+'').append(html);
		                  
		                  
		                  if(value>0){
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
	
	/* $('#formState').change(function(){
		  
		
	        var stateId=$(this).val();
	        var selectorHTML=$('#formLocation').selector;
	           $('#formLocation option').not(':first').remove();
	           $('#registerForm').formValidation('revalidateField', 'location');      
	        getLocationsByState(stateId,selectorHTML);

	    });
	*/
	 
	 
	 
	 function getSubspecialities(specialityId,selectorHTML,value){
		  $("#loaderView").fadeIn();	
		  $.ajax({  
			     type : "POST",   
			     url : urlPath+'/login/getSubspecialities',   
			     data : "specialityId=" + specialityId ,  
			     success : function(response) {  
			    	 
			    	 
			    	
			    	 	
			    	 if(response.length>0){
			    		 
			    		 
			    		 $("#subspeciality-show").show();
			    		 
			    		  var html = '';
		                  var len = response.length;
		                  for(var i=0; i<len; i++){
		                       html += '<option value="' + response[i].SubspecialityId + '">' + response[i].SubspecialityName.toUpperCase() + '</option>';
		                   }
		                  $(''+selectorHTML+'').append(html);
		                  
		                  
		                  
		                  if(value>0){
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
	
	 $('#formState').change(function(){
		  
		
	       /* var stateId=$(this).val();
	        var selectorHTML=$('#formLocation').selector;
	           $('#formLocation option').not(':first').remove();
	           $('#registerForm').formValidation('revalidateField', 'location');      
	        getLocationsByState(stateId,selectorHTML);
	        */

	    });
	 
	 
	 $('#formSpeciality').change(function(){
		  
			
	        var specialityId=$(this).val();
	        var selectorHTML=$('#formSubspeciality').selector;
	           $('#formSubspeciality option').not(':first').remove();
	           $("#registerForm [name='subspecialityLicense']").val("");
	           $('#registerForm').formValidation('revalidateField', 'speciality');     
	           $('#registerForm').formValidation('revalidateField', 'subspecialityLicense'); 
	           
	           $("#subspeciality-show").hide();
	           getSubspecialities(specialityId,selectorHTML);

	    });
	 
	 
	
	
	

	
});
	 


</script>


<style>

.form-horizontal label{
  font-size: 11.5px;
  color: #0d478f;
  text-align: right;
}


.form-group  i:BEFORE{
	display: none !important;
	}

.has-success .form-control-feedback{
color:#00a65a;

}

.has-error .form-control-feedback{
color:#dd4b39;

}

.login-box-msg{
  color:#367fa9;
  font-weight: bold;
  font-size: 16px;
}

.register-box-body {

    border: 1px dashed #ccc;
 
}

.license .form-control {
    padding-right: 0.1px;
    padding: 5px 5px !important;
}
</style>


<div class="register-box" style="margin: 1% auto;">
     
     
   

      <div class="register-box-body">
          <p class="login-box-msg" style="padding: 0px">Perfil de usuario</p>
          <hr>
        
        <form:form modelAttribute="updateWebClient"   method="post" class="form-horizontal" id="registerForm">
            

     
             <div class="form-group has-feedback">
	             <label for="" class="col-sm-4">Email*</label>
	             <div class="col-sm-8">
		            <form:input type="text" path ="email" name="email" class="form-control input-sm" placeholder="" disabled="true" />
		            <form:input type="hidden" path="email" name="email"  />
		            <span class="glyphicon glyphicon-user form-control-feedback"></span>
		            
		         
	            </div>
	          </div>
         
	          <div class="form-group has-feedback">
	             <label for="" class="col-sm-4">Nombre(s) *</label>
	             <div class="col-sm-8">
		            <form:input type="text" path ="firstName" name="firstName" class="form-control input-sm" placeholder="" disabled="true" />
		            <form:input type="hidden" path="firstName" name="firstName"  />
		            <span class="glyphicon glyphicon-user form-control-feedback"></span>
		            
		         
	            </div>
	          </div>
	          <div class="form-group has-feedback">
	             <label for="" class="col-sm-4">Apellido Paterno *</label>
	             <div class="col-sm-8">
		            <form:input path="lastName" type="text" name="lastName" class="form-control input-sm" placeholder="" disabled="true" />
		             <form:input type="hidden" path="lastName" name="lastName"  />
		            <span class="glyphicon glyphicon-user form-control-feedback"></span>
		             
		           
		         
	            </div>
	          </div>
	          <div class="form-group has-feedback">
	             <label for="" class="col-sm-4">Apellido Materno</label>
	             <div class="col-sm-8">
		            <form:input path="slastName" type="text" name="slastName" class="form-control input-sm" placeholder="" />
		            <span class="glyphicon glyphicon-user form-control-feedback"></span>
		         
	            </div>
	          </div>
	<!--           <div class="form-group "> -->
	<!--              <label for="" class="col-sm-4">Género</label> -->
	<!--              <div class="col-sm-8"> -->
	<%-- 	               <form:radiobutton  path="" value="M"  name="gender"  checked="checked" class="profileGender"     />Masculino &nbsp;&nbsp; --%>
	<%-- 				   <form:radiobutton  path=""  value="F" name="gender" class="profileGender"   />Femenino --%>
		         
	<!--             </div> -->
	<!--           </div> -->
	        
	           <div class="form-group has-feedback">
	             <label for="" class="col-sm-4">Profesión *</label>
	             <div class="col-sm-8">
	              <!-- <input type="text" name="professionId" class="form-control input-sm" placeholder=""> -->
	                   <form:select path="profession"  name="profession"  class="form-control input-sm" >
	                           <form:option value="7">Médico</form:option> 
	                             
		               </form:select>
	                   <!--  <span class="fa fa-user-md form-control-feedback"></span> -->
		
	            </div>
	          </div>
	          <div class="form-group">
	             <label for="" class="col-sm-4">Cédula Profesional *</label>
	             <div class="col-sm-8">
	                   <form:input path="professionLicense" type="text" name="professionLicense" class="form-control input-sm" placeholder="" disabled="true" />
	                    <form:input type="hidden" path="professionLicense" name="professionLicense"  />
	                   <span class="fa fa-user-md form-control-feedback"></span>
		
	            </div>
	          </div>
	          <div class="form-group has-feedback">
	             <label for="" class="col-sm-4">Especialidad Médica *</label>
	             <div class="col-sm-8">
	                  <!--   <input type="text" name="specialityId" class="form-control input-sm" placeholder="">
	                  -->
	                   <form:select path="speciality"  name="speciality"  class="form-control input-sm" id="formSpeciality" disabled="true">
	                           <form:option  value="" >Seleccionar</form:option > 
	                              <c:forEach items="${getSpecialities}" var="speciality">
	                                       <form:option  value="${speciality.specialityId}">${speciality.specialityName}</form:option >
	                              </c:forEach>
		               </form:select >
	                   
	                   
		
	            </div>
	          </div>
	          <div class="form-group has-feedback">
	             <label for="" class="col-sm-4">Cédula de la Especialidad *</label>
	             <div class="col-sm-8">
	                   <form:input path="specialityLicense" type="text" name="specialityLicense" class="form-control input-sm" disabled="true" />
	                   <span class="fa fa-user-md form-control-feedback"></span>
		
	            </div>
	          </div>
	          
	           <div id="subspeciality-show">
	          
		          <div class="form-group has-feedback">
		             <label for="" class="col-sm-4">Subespecialidad </label>
		             <div class="col-sm-8">
		                  <!--   <input type="text" name="specialityId" class="form-control input-sm" placeholder="">
		                  -->
		                   <form:select path="subspeciality"  name="subspeciality"  class="form-control input-sm" id="formSubspeciality">
		                           <form:option  value="" >Seleccionar</form:option > 
		                           <c:forEach items="${getSubSpecialities}" var="subspeciality">
		                                       <form:option  value="${subspeciality.subspecialityId}">${subspeciality.subspecialityName}</form:option >
		                              </c:forEach>
		                              
			               </form:select >
		                   
		                   
			
		            </div>
		          </div>
		          <div class="form-group has-feedback">
		             <label for="" class="col-sm-4">Cédula de la Subespecialidad </label>
		             <div class="col-sm-8">
		                   <form:input path="subspecialityLicense" type="text" name="subspecialityLicense" class="form-control input-sm" placeholder="" />
		                   <span class="fa fa-user-md form-control-feedback"></span>
			
		            </div>
		          </div>
		       </div>
	          
	           <div class="form-group has-feedback">
	             <label for="" class="col-sm-4">País *</label>
	             <div class="col-sm-8">
	                  <!--   <input type="text" name="countryId" class="form-control input-sm" placeholder=""> -->
	                   <form:select path="country"  name="country"  class="form-control input-sm" >
	                           <form:option value="MEX">México</form:option> 
	                             
		               </form:select>
	                   
	                 <!--    <span class="fa fa-globe form-control-feedback"></span>-->
	                   
		
	            </div>
	          </div>
	          <div class="form-group has-feedback">
	             <label for="" class="col-sm-4">Estado *</label>
	             <div class="col-sm-8">
	                    <form:select path="state"  name="state"  class="form-control input-sm"  id="formState">
	                              <form:option value="" >Seleccionar</form:option> 
	                              <c:forEach items="${getStates}" var="states">
	                                       <form:option value="${states.shortName}">${states.stateName}</form:option>
	                              </c:forEach>
		               </form:select>
		               
		
	            </div>
	          </div>
	    <!--  <div class="form-group has-feedback">
	             <label for="" class="col-sm-4">Delegación/Municipio *</label>
	             <div class="col-sm-8">
	                    <form:select path=""  name="location"  class="form-control input-sm" id="formLocation" >
	                              <form:option value="" >Seleccionar</form:option> 
	                              
		               </form:select>
		
	            </div>
	          </div>
	          
	          -->

	         <hr/>
	          <div class="row">
	            <div class="col-xs-8">
	              <div class="checkbox icheck">
	                <label class="">
	                 
	                </label>
	              </div>
	            </div><!-- /.col -->
	            <div class="col-xs-4">
	              <button type="submit" class="btn btn-primary btn-block btn-flat">Actualizar</button>
	            </div><!-- /.col -->
	          </div>
	          
	     
         
        </form:form>

        <div class="social-auth-links text-center">
        
        </div>

      </div><!-- /.form-box -->
    </div>	