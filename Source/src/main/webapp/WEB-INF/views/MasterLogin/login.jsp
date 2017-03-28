<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">
var typeLoging = ${gSettings.getTypeLogin()};
	if( typeLoging!=5 ){
		usr = {
			validators: {
				notEmpty: {
					message: 'Campo requerido'
                },
                            
                emailAddress: {
					message: 'Correo no valido'
				}
               
            }
        }
		
	}else{
		usr = {
			validators: {
				notEmpty: {
					message: 'Campo requerido'
				}
			}
		}
	}
		
$(function () {
	
	
	$(".alert-success").hide();
	
	$('#loginForm').formValidation({
	    framework: 'bootstrap',
	    icon: {
	        valid: 'fa fa-check',
	        invalid: 'fa fa-times',
	        validating: 'fa fa-refresh'
	    },
	    fields: {
	    	username:usr,
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
              }
	               
	               
	    }
	 }).on('success.form.fv', function(e) {
		
		//  e.preventDefault();
		
		 $(".alert-success").hide();
		  
		  
		
	
	});
	
	
	$('#retrieveform').formValidation({
		  framework: 'bootstrap',
		  icon: {
		      valid: 'fa fa-check',
		      invalid: 'fa fa-times',
		      validating: 'fa fa-refresh'
		  },
		  fields: {
			  emailRetrieve: {
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
			  
		       var email= $("#retrieveform [name='emailRetrieve']").val();
		       $("#loaderView").fadeIn();
				$.ajax({  
				     type : "POST",   
				     url : urlPath+'/login/recoveryClientPassword',   
				     data : "email=" + email ,  
				     success : function(response) {  
				    	 
				    	 if(response!=null){
				    		 
				    		 console.log(response);
				    		 
				    		 $('#retrieveform').data('formValidation').resetForm();
							  $("#retrieveform [name='emailRetrieve']").val("");
							  
							  setTimeout(function(){
							        $("#myModal").hide();
							        $(".modal-backdrop").remove();
							    }, 1000);
							  
							  
							  $(".alert-success").show();
							  $(".alert-success").html(response);
				    		 
				    	 }
				    	 
				    	 $("#loaderView").fadeOut();
				    	 
				     },  
				     error : function(e) {  
				    	 console.log('Error: ' + e);
				    	 
				    	 $("#loaderView").fadeOut();
				    	 
				      
				     }  
				    });
				
		});


});

</script>

<style>
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

.login-box-body {

    border: 1px dashed #ccc;
 
}
</style>

<div class="login-box">
      
    <!--    <img alt="" src="<c:url value="/resources/images/LogotipoPLM.png"/>" height="50px">-->

      <div class="login-logo" style="font-size: 28px;">
<%--         <a> <strong><img alt="" src="<c:url value="/resources/images/LogotipoPLM.png"/>" height="40px"></strong> | <b>Prescripción </b>Total <b>4.0</b> </a> --%>
        <a> <strong><img alt="" src="<c:url value="/resources/images/PT4-Login.png"/>" style="width: 58%;"></a>
      </div><!-- /.login-logo -->
      <div class="login-box-body">
      <div class="pull-right">
       	<c:if test='${country=="COL"}'>
			<img src="<c:url value="/resources/images/BanderaCOL.png"/>" height="40px">
		</c:if>
       	<c:if test='${country=="MEX"}'>
			<img src="<c:url value="/resources/images/BanderaMEX.png"/>" height="40px">
		</c:if>
       	<c:if test='${country=="CAD"}'>
			<img src="<c:url value="/resources/images/BanderaCAD.png"/>" height="40px">
		</c:if>
       	<c:if test='${country=="ECU"}'>
			<img src="<c:url value="/resources/images/BanderaECU.png"/>" height="40px">
		</c:if>
      </div>
        <p class="login-box-msg">Iniciar Sesión</p>
        
       <hr/>
        <form action="${pageContext.request.contextPath}/loginProcessing" method="post" id="loginForm" >
          <div class="form-group has-feedback">
          	<c:if test="${typeLogin==5}">
            	<input type="text"  name="username" class="form-control" placeholder="Email">
            </c:if>
            <c:if test="${typeLogin!=5}">
            	<input type="email"  name="username" class="form-control" placeholder="Email">
            </c:if>
            <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
          </div>
          <div class="form-group has-feedback">
            <input type="password" name="password" class="form-control" placeholder="Contraseña">
            <span class="glyphicon glyphicon-lock form-control-feedback"></span>
          </div>
          
          <hr/>
          <div class="row">
            <div class="col-xs-8">
              <div class="checkbox icheck">
                <label>
                
                </label>
              </div>
            </div><!-- /.col -->
            <div class="col-xs-4">
              <button type="submit" value="Submit" class="btn btn-primary btn-block btn-flat">Entrar</button>
            </div><!-- /.col -->
          </div>
        </form>
        
        <c:if test="${'fail' eq param.auth}">
                <p>
                <div class="alert alert-danger">
                  ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}</div>
        </c:if>
        
        <div class="alert alert-success">
     
        </div>

        <div class="social-auth-links text-center">
          
        </div>
     
     	<c:if test="${typeLogin==2}">
        	<a  href="<c:url value="/login/registro-codigo/"/>" class="text-center">¿Aún no tiene una cuenta?</a>
        </c:if>
        
        <c:if test="${typeLogin==3}">
        	<a  href="<c:url value="/login/registro-licencia/"/>" class="text-center">¿Aún no tiene una cuenta?</a>
        </c:if>
        
          
        <c:if test="${typeLogin==4}">
        	<a  href="<c:url value="/cliente/${urlClient}/registro-activacion-email/"/>" class="text-center">¿Aún no tiene una cuenta?</a>
        </c:if>
        
         <br/>
         <c:if test="${typeLogin!=5}">
        	<a  data-toggle="modal" href="#myModal" class="text-center">Recuperar contraseña</a>
        </c:if>

      </div><!-- /.login-box-body -->
    </div>
    
       <!-- Modal -->
		          <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal" class="modal fade">
		              <div class="modal-dialog">
		                  <div class="modal-content">
		                     <form id="retrieveform">
			                      <div class="modal-header" style="    background-color: #367fa9;color: #FFF;">
			                          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			                          <h4 class="modal-title"> ¿Olvidó su contraseña?</h4>
			                      </div>
			                      <div class="modal-body">
			                      
                                          
			                          <p>Introduzca su dirección de correo electrónico para restablecer la contraseña.</p>
			                          
			                          <div class="form-group">
						                   <label class=""></label>
			                               <input type="text" name="emailRetrieve" placeholder="Email"  class="form-control">
			                           </div>
			                      </div>
			                      <div class="modal-footer">
			                          <button data-dismiss="modal" class="btn btn-default" type="button">Cancelar</button>
			                          <button class="btn btn-primary"  type="submit" id="retrieveMedicalButton">Enviar</button>
			                      </div>
		                      </form>
		                  </div>
		              </div>
		          </div>
		          <!-- modal -->