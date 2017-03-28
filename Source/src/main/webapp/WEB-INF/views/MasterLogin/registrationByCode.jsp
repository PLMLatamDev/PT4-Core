<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<script type="text/javascript">
 
$(function () {
	
	


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
            email: {
                validators: {
                    notEmpty: {
                        message: 'Campo requerido'
                      
                    },
                    emailAddress: {
                        message: 'Correo no valido'
                    }
                    
                   
                }
            },
            profession: {
                validators: {
                    notEmpty: {
                        message: 'Campo requerido'
                    }
                }
            },
            specialityName: {
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
            password: {
                validators: {
                    notEmpty: {
                        message: 'Campo requerido'
                    },
                    stringLength: {
                        min: 5,
                        message: 'Contraseña mínimo 6 caracteres'
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
            }
            
            
                  
	    }
	 }).on('success.form.fv', function(e) {
		 
	
		
		//  e.preventDefault();
		  
		  
		
	
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
</style>


<div class="register-box" style="margin: 1% auto;">
      <div class="login-logo" style="font-size: 28px;">
        <a> <strong><img alt="" src="<c:url value="/resources/images/LogotipoPLM.png"/>" height="40px"></strong> | <b>Prescripción </b>Total <b>4.0</b> </a>
      </div><!-- /.login-logo -->

      <div class="register-box-body">
         <div class="pull-right">
         	
         	<c:if test='${gSettings.getCountry()=="COL"}'>
				<img src="<c:url value="/resources/images/BanderaCOL.png"/>" height="40px">
			</c:if>
         	<c:if test='${gSettings.getCountry()=="MEX"}'>
				<img src="<c:url value="/resources/images/BanderaMEX.png"/>" height="40px">
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
        
        <form:form modelAttribute="saveWebClient"   method="post" class="form-horizontal" id="registerForm">
         
          <div class="form-group has-feedback">
            <label for="code" class="col-sm-4">Código de registro *</label>
            <div class="col-sm-8">
	            <form:input type="text" path="registrationCode" name="registrationCode" class="form-control input-sm" placeholder="" />
	            <span class="fa fa-qrcode form-control-feedback"></span>
	      
            </div>
          </div>
          <div class="form-group has-feedback">
             <label for="code" class="col-sm-4">Nombre(s) *</label>
             <div class="col-sm-8">
	            <form:input type="text" path ="firstName" name="firstName" class="form-control input-sm" placeholder="" />
	            <span class="glyphicon glyphicon-user form-control-feedback"></span>
	            
	         
            </div>
          </div>
          <div class="form-group has-feedback">
             <label for="code" class="col-sm-4">Apellido Paterno *</label>
             <div class="col-sm-8">
	            <form:input path="lastName" type="text" name="lastName" class="form-control input-sm" placeholder="" />
	            <span class="glyphicon glyphicon-user form-control-feedback"></span>
	             
	           
	         
            </div>
          </div>
          <div class="form-group has-feedback">
             <label for="code" class="col-sm-4">Apellido Materno</label>
             <div class="col-sm-8">
	            <form:input path="slastName" type="text" name="secondLasName" class="form-control input-sm" placeholder="" />
	            <span class="glyphicon glyphicon-user form-control-feedback"></span>
	         
            </div>
          </div>
<!--           <div class="form-group "> -->
<!--              <label for="code" class="col-sm-4">Género</label> -->
<!--              <div class="col-sm-8"> -->
<%-- 	               <form:radiobutton  path="" value="M"  name="gender"  checked="checked" class="profileGender"     />Masculino &nbsp;&nbsp; --%>
<%-- 				   <form:radiobutton  path=""  value="F" name="gender" class="profileGender"   />Femenino --%>
	         
<!--             </div> -->
<!--           </div> -->
          <div class="form-group has-feedback">
             <label for="code" class="col-sm-4">Correo Electrónico *</label>
             <div class="col-sm-8">
                   <form:input type="email" path="email" name="email" class="form-control input-sm" placeholder="" />
                   <span class="glyphicon glyphicon-envelope form-control-feedback"></span>       
            </div>
          </div>
           <div class="form-group has-feedback">
             <label for="code" class="col-sm-4">Profesión *</label>
             <div class="col-sm-8">
              <!-- <input type="text" name="professionId" class="form-control input-sm" placeholder=""> -->
                   <form:select path="profession"  name="profession"  class="form-control input-sm" >
                           <form:option value="7">Médico</form:option> 
                             
	               </form:select>
                   <!--  <span class="fa fa-user-md form-control-feedback"></span> -->
	
            </div>
          </div>
          <div class="form-group has-feedback">
             <label for="code" class="col-sm-4">Especialidad Médica *</label>
             <div class="col-sm-8">
                  <!--   <input type="text" name="specialityId" class="form-control input-sm" placeholder="">
                  -->
                   <form:select path="specialityName"  name="specialityName"  class="form-control input-sm">
                           <form:option  value="" >Seleccionar</form:option > 
                              <c:forEach items="${getSpecialities}" var="speciality">
                                       <form:option  value="${speciality.specialityName}%%${speciality.specialityId}">${speciality.specialityName}</form:option >
                              </c:forEach>
	               </form:select >
                   
                   
	
            </div>
          </div>
          <div class="form-group">
             <label for="code" class="col-sm-4">Matrícula/Tarjeta Profesional *</label>
             <div class="col-sm-8">
                   <form:input path="professionalLicense" type="text" name="professionalLicense" class="form-control input-sm" placeholder="" />
                   <span class="fa fa-user-md form-control-feedback"></span>
	
            </div>
          </div>
           <div class="form-group has-feedback">
             <label for="code" class="col-sm-4">País *</label>
             <div class="col-sm-8">
                  <!--   <input type="text" name="countryId" class="form-control input-sm" placeholder=""> -->
                   <form:select path="country"  name="country"  class="form-control input-sm" >
                           <form:option value="2">Colombia</form:option> 
                             
	               </form:select>
                   
                 <!--    <span class="fa fa-globe form-control-feedback"></span>-->
                   
	
            </div>
          </div>
          <div class="form-group has-feedback">
             <label for="code" class="col-sm-4">Provincia</label>
             <div class="col-sm-8">
                   <!--  <input type="text" name="locationId" class="form-control input-sm" placeholder="">-->
                    <form:select path="state"  name="state"  class="form-control input-sm" >
                              <form:option value="" >Seleccionar</form:option> 
                              <c:forEach items="${getStates}" var="states">
                                       <form:option value="${states.stateId}">${states.stateName}</form:option>
                              </c:forEach>
	               </form:select>
	
            </div>
          </div>
          
          <div class="form-group has-feedback">
             <label for="code" class="col-sm-4">Contraseña *</label>
             <div class="col-sm-8">
                   <form:input type="password" path="password" name="password" class="form-control input-sm" placeholder="" />
                   <span class="glyphicon glyphicon-lock form-control-feedback"></span>
	
            </div>
          </div>
          <div class="form-group has-feedback">
             <label for="code" class="col-sm-4">Confirmar Contraseña *</label>
             <div class="col-sm-8">
                   <form:input path="" type="password" name="confirmPassword" class="form-control input-sm" placeholder="" />
                   <span class="glyphicon glyphicon-log-in form-control-feedback"></span>
	
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
        </form:form>

        <div class="social-auth-links text-center">
        
        </div>

        <a href="<c:url value="/login/"/>" class="text-center">Ya me he registrado</a>
      </div><!-- /.form-box -->
    </div>