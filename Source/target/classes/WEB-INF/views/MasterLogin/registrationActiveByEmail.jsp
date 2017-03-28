<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<script type="text/javascript">
 
$(function () {
	
	
	$("#hide-form").hide();
	$("#subspeciality-show").hide();
	$("#speciality-show").show();

	
	$('#getClientByEmail').formValidation({
	    framework: 'bootstrap',
	    icon: {
	        valid: 'fa fa-check',
	        invalid: 'fa fa-times',
	        validating: 'fa fa-refresh'
	    },
	    fields: {
	    	  email: {
	                validators: {
	                    notEmpty: {
	                        message: 'Campo requerido'
	                      
	                    },
	                    emailAddress: {
	                        message: 'Correo no valido'
	                    }
	                    
	                   
	                }
	            }
	    }
	    
	}).on('success.form.fv', function(e) {
		 

		  e.preventDefault();
		 
		  var email= $("#getClientByEmail [name='email']").val();
		  	$("#loaderView").fadeIn();
			$.ajax({  
			     type : "POST",   
			     url : urlPath+'/login/getClientInformationDetailByEmail',   
			     data : "email=" + email ,  
			     success : function(response) {  
			    	 
			    	 
			    	 console.log(response);
			    	 
			    	 response=response.getClientInformationDetailByEmailResult;
			    	 
			    	 $("#registerForm [name='specialityName']").val("");
			    	 $("#registerForm [name='state']").val("");
			    	 
			    	  if(response!=null){
			    		  
			    		  $("#registerForm [name='firstName']").val(response.FirstName);
			    		  $("#registerForm [name='lastName']").val(response.LastName);
			    		  $("#registerForm [name='slastName']").val(response.SecondLastName);
			    		  
			    		  
			    		  if(response.Profession!=null){
			    			  
			    			  $("#registerForm [name='professionLicense']").val(response.Profession.ProfessionalLicense);
			    			  
			    			  
			    		  }
			    		  
			    		  if(response.Speciality!=null){
			    			
			    			if(response.Speciality.SpecialityId==58){
			    				
			    				$("#speciality-show").hide();
			    				
			    			}
			    			  
			    		    $("#registerForm [name='speciality']").val(response.Speciality.SpecialityId);
			    		    $("#registerForm [name='specialityLicense']").val(response.Speciality.ProfessionalLicense);
			    		    var selectorHTML=$('#formSubspeciality').selector;
			    		    
			    		    if(response.Subspeciality!=null){
			    		    	
			    		    	 $("#subspeciality-show").show();
				    			  
				    			  
				    			  $("#registerForm [name='subspecialityLicense']").val(response.Subspeciality.SubspecialityLicense);
				    			  getSubspecialities(response.Speciality.SpecialityId,selectorHTML,response.Subspeciality.SubspecialityId);
				    			  
				    		  }else{
				    			  
				    			  getSubspecialities(response.Speciality.SpecialityId,selectorHTML);
				    		  }
			    		    
			    		   
			    		    
			    		    
			    		    
			    		    
			    		  }
			    		  
			    		
			    		  
			    		  if(response.State!=null){
			    		     $("#registerForm [name='state']").val(response.State.ShortName);
			    		     var selectorHTML=$('#formLocation').selector;
			    		    
			    		    //  getLocationsByState(response.StateId,selectorHTML,response.LocationId);
					    		   
			    		     
			    		     
			    		  }
			    		 
			    		  
			    		  
			    		  
			    	  }
			    	 
	    	 
			    	  $("#loaderView").fadeOut(); 

			     },  
			     error : function(e) {  
			    	 console.log('Error: ' + e);
			    	 
			    	 $("#loaderView").fadeOut(); 
			    	 
			      
			     }  
			    });
			
		  $("#hide-form").show();
		  

	});

	$('#registerForm').formValidation({
	    framework: 'bootstrap',
	    icon: {
	        valid: 'fa fa-check',
	        invalid: 'fa fa-times',
	        validating: 'fa fa-refresh'
	    },
	    fields: {
	    	registrationCode:{
	    		
	    		validators: {
                    notEmpty: {
                        message: 'Campo requerido'
                      
                    }
                   
                }
	    		
	    	},
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
            },
           /* location: {
                validators: {
                    notEmpty: {
                        message: 'Campo requerido'
                      
                    }
                   
                }
            },*/
           
            password: {
                validators: {
                    notEmpty: {
                        message: 'Campo requerido'
                    },
                    stringLength: {
                        min: 6,
                        message: 'Mínimo 6 caracteres '
                    }
                }
            },
            confirmPassword: {
                validators: {
                    notEmpty: {
                        message: 'Campo requerido'
                    },
                    identical: {
                        field: 'password',
                        message: 'Las contrase&ntilde;as no son iguales'
                    }
                }
            },
            terms: {
                validators: {
                    notEmpty: {
                        message: 'Campo requerido'
                    }
                }
            },
            privacy: {
                validators: {
                    notEmpty: {
                        message: 'Campo requerido'
                    }
                }
            }
            
            
                  
	    }
	 }).on('success.form.fv', function(e) {
		 
	
		  //e.preventDefault();
		  var emailHiddenVal= $("#getClientByEmail [name='email']").val();
		  $('#emailHidden').val(emailHiddenVal);
		  

		  
		 
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
		  $("#subspeciality-show").hide();
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

	 
	 
	 $('#formSpeciality').change(function(){
		  
			
	        var specialityId=$(this).val();
	        
	        console.log(specialityId);
	        
	        if(specialityId==58){
	        	
	        	$("#speciality-show").hide();
	        }else{
	        	$("#speciality-show").show();
	        	
	        }
	        	
	            var selectorHTML=$('#formSubspeciality').selector;
		           $('#formSubspeciality option').not(':first').remove();
		           $('#registerForm').formValidation('revalidateField', 'speciality');      
		           getSubspecialities(specialityId,selectorHTML);
	        	
	        
	        
	    

	    });
	 
	 
	//Términos y condiciones
     
     var showType=0;
     
	     $('#termsModal').on('show.bs.modal', function(e) {
	         
	    	 var name = $(e.relatedTarget).data('title');
		 	    $(".modal-title").html(name);
		 	  
		 	     showType= $(e.relatedTarget).data('book-id');
		 	    
			 	   if(showType==1){
		  
			    	    $("#modal-body-content" ).load( "../../resources/terms.html", function() {
			    		 
			    		});
			 	   }
		 	   
			 	  if(showType==2){
			 		  
			 		 $("#modal-body-content" ).load( "../../resources/privacity.html", function() {
			    		 
			    		});
			 		  
			 	  }
	    	 
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

.checkbox label a{
font-weight: 700;

}

	@media (min-width: 768px){
	 	#termsModal .modal-dialog {
		    width: 720px;
		    margin: 30px auto;
		}
	}
	@media (max-width: 767px){
	 	#termsModal .modal-dialog {
		    width: 100%;
		    margin: 30px auto;
		}
	}

</style>


<div class="register-box" style="margin: 1% auto;">
      <div class="login-logo" style="font-size: 28px;">
        <a> <strong><img alt="" src="<c:url value="/resources/images/LogotipoPLM.png"/>" height="40px"></strong> | <b>Prescripción </b>Total <b>4.0</b> </a>
      </div><!-- /.login-logo -->

      <div class="register-box-body">
         <div class="pull-right">
         	<c:if test='${gSettings.getCountry()=="MEX"}'>
				<img src="<c:url value="/resources/images/BanderaMEX.png"/>" height="40px">
			</c:if>
			<c:if test='${gSettings.getCountry()=="COL"}'>
				<img src="<c:url value="/resources/images/BanderaCOL.png"/>" height="40px">
			</c:if>
			<c:if test='${gSettings.getCountry()=="CAD"}'>
				<img src="<c:url value="/resources/images/BanderaCAD.png"/>" height="40px">
			</c:if>
			<c:if test='${gSettings.getCountry()=="ECU"}'>
				<img src="<c:url value="/resources/images/BanderaECU.png"/>" height="40px">
			</c:if>
			
			
       	</div>
        <p class="login-box-msg">Registro de nuevo usuario</p>
        
        <hr/>
        
        <form class="form-horizontal" id="getClientByEmail" >
        
          <div class="form-group has-feedback">
          
                <label  class="col-sm-4">Correo Electronico *</label>
	            <div class="col-sm-8">
		            <div class="input-group input-group-sm">
                    <input type="text" class="form-control" name=email>
                    <span class="input-group-btn">
                      <button class="btn btn-primary btn-flat" type="submit">Buscar</button>
                    </span>
                  </div>
		       
		         
	            </div>
            
          </div>
        
        </form>
        
        <form:form modelAttribute="saveWebClient"   method="post" class="form-horizontal" id="registerForm">
        
          <div id="hide-form">
        
         
	          <div class="form-group has-feedback">
	             <label for="" class="col-sm-4">Nombre(s) *</label>
	             <div class="col-sm-8">
		            <form:input type="text" path ="firstName" name="firstName" class="form-control input-sm" placeholder="" />
		            <span class="glyphicon glyphicon-user form-control-feedback"></span>
		            
		         
	            </div>
	          </div>
	          <div class="form-group has-feedback">
	             <label for="" class="col-sm-4">Apellido Paterno *</label>
	             <div class="col-sm-8">
		            <form:input path="lastName" type="text" name="lastName" class="form-control input-sm" placeholder="" />
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
	                   <form:input path="professionLicense" type="text" name="professionLicense" class="form-control input-sm" placeholder="" />
	                   <span class="fa fa-user-md form-control-feedback"></span>
		
	            </div>
	          </div>
	          <div class="form-group has-feedback">
	             <label for="" class="col-sm-4">Especialidad Médica *</label>
	             <div class="col-sm-8">
	                  <!--   <input type="text" name="specialityId" class="form-control input-sm" placeholder="">
	                  -->
	                   <form:select path="speciality"  name="speciality"  class="form-control input-sm" id="formSpeciality">
	                           <form:option  value="" >Seleccionar</form:option > 
	                              <c:forEach items="${getSpecialities}" var="speciality">
	                                       <form:option  value="${speciality.specialityId}">${speciality.specialityName}</form:option >
	                              </c:forEach>
		               </form:select >
	                   
	                   
		
	            </div>
	          </div>
	          <div class="form-group has-feedback" id="speciality-show">
	             <label for="" class="col-sm-4">Cédula de la Especialidad *</label>
	             <div class="col-sm-8">
	                   <form:input path="specialityLicense" type="text" name="specialityLicense" class="form-control input-sm" placeholder="" />
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
	 
	          
	          <!-- hidden -->

	          <form:hidden path="email" name="email" id="emailHidden"  />
	          
	          
	          <div class="form-group has-feedback">
	             <label for="" class="col-sm-4">Contraseña *</label>
	             <div class="col-sm-8">
	                   <form:input type="password" path="password" name="password" class="form-control input-sm" placeholder="" />
	                   <span class="glyphicon glyphicon-lock form-control-feedback"></span>
		
	            </div>
	          </div>
	          <div class="form-group has-feedback">
	             <label for="" class="col-sm-4">Confirmar Contraseña *</label>
	             <div class="col-sm-8">
	                   <form:input path="" type="password" name="confirmPassword" class="form-control input-sm" placeholder="" />
	                   <span class="glyphicon glyphicon-log-in form-control-feedback"></span>
		
	            </div>
	          </div>
	          
	            <div class="form-group has-feedback">
	                 <label for="" class="col-sm-4"></label>
	                 <div class="col-sm-8">
                      <div class="checkbox">
                        <label>
                          <input  type="checkbox" name="terms">
                            <a href="#" data-toggle="modal" data-target="#termsModal"  data-title="Términos y condiciones" data-book-id="1">Aceptar Términos y Condiciones</a>
                        </label>
                      </div>
                     </div>
              </div>
              <div class="form-group has-feedback">
	                 <label for="" class="col-sm-4"></label>
	                 <div class="col-sm-8">
                      <div class="checkbox">
                        <label>
                          <input type="checkbox" name="privacy">
                            <a href="#" data-toggle="modal" data-target="#termsModal" data-title="Aviso de Privacidad" data-book-id="2">Aceptar Aviso de Privacidad </a>
                        </label>
                      </div>
                     </div>
              </div>
	      
	         <hr/>
	          <div class="row">
	            <div class="col-xs-8">
	              <div class="checkbox icheck">
	                <label class="">
	                 
	                </label>
	              </div>
	            </div><!-- /.col -->
	            <div class="col-xs-4">
	              <button type="submit" class="btn btn-primary btn-block btn-flat">Registrar</button>
	            </div><!-- /.col -->
	          </div>
	          
	      </div>
         
        </form:form>

        <div class="social-auth-links text-center">
        
        </div>
        <hr>
        
        <c:if test="${typeLogin==4}">
        	<a  href="<c:url value="/cliente/${urlClient}"/>" class="text-center">Ya me he registrado</a>
        </c:if>

      </div><!-- /.form-box -->
    </div>	
    
    <!-- Terms and conditions modal -->
	<div class="modal fade" id="termsModal" tabindex="-1" role="dialog" aria-labelledby="Terms and conditions" aria-hidden="true">
	    <div class="modal-dialog">
	        <div class="modal-content">
	            <div class="modal-header" style=" background-color: #367fa9;color: #FFF;padding: 10px;">
	                <h3 class="modal-title"></h3>
	            </div>
	
	            <div class="modal-body" id="modal-body-content">
	               
	            </div>
	
	            <div class="modal-footer">
	                <button type="button" class="btn btn-primary" id="printButton" >Imprimir</button>
	                <button type="button" class="btn btn-default" id="disagreeButton" data-dismiss="modal">Cerrar</button>
	            </div>
	        </div>
	    </div>
	</div>