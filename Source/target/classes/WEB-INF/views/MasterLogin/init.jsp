<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<script type="text/javascript">


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
	    	username: {
	                   validators: {
	                       notEmpty: {
	                           message: 'Campo requerido'
	                         
	                       },
	                     
	                      
	                   }
	               },
	          
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
        <a> <strong><img alt="" src="<c:url value="/resources/images/LogotipoPLM.png"/>" height="40px"></strong> | <b>Prescripción </b>Total <b>4.0</b> </a>
      </div><!-- /.login-logo -->
  
   <c:if test="${getUrlClients!=null}">
	       
	        
			      <div class="form-group">
			                  <label>Seleccionar URL del cliente</label>
			                  <select class="form-control" onChange="window.location.href=this.value">
											<option value="">Seleccionar</option>
											<c:forEach items="${getUrlClients}" var="item">
											    
											        <option value="${pageContext.request.contextPath}/cliente/${item}/">${pageContext.request.contextPath}/cliente/${item}</option>	
											        																				
											</c:forEach>
										</select>
			                  
			      </div>
	      
	</c:if>
        
  

      
    </div>