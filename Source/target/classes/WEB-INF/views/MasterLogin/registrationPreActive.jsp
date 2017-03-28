<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">

</script>

<style>
   .lockscreen-image{
   
    font-size: 40px !important;
    color:#053168;
    top: -16px !important;
        padding: 5px 12px !important;
   
   }
   
   .form-control[disabled]{
     background-color: #fff;
   
   }
</style>

 <!-- Automatic element centering -->
    <div class="lockscreen-wrapper">
      <div class="lockscreen-logo">
	        <div class="login-logo" style="font-size: 28px;">
	        <a> <strong><img alt="" src="<c:url value="/resources/images/LogotipoPLM.png"/>" height="40px"></strong> | <b>Prescripción </b>Total <b>4.0</b> </a>
	      </div><!-- /.login-logo -->
      </div>
      <!-- User name -->
      
      <div class="lockscreen-name" style="text-align:center;">Estimado(a) Dr.(a)</div>
      
      <br/>

      <!-- START LOCK SCREEN ITEM -->
      <div class="lockscreen-item">
        <!-- lockscreen image -->
        <div class="lockscreen-image">
          <i class="fa fa-lg fa-user-md"></i>
        </div>
        <!-- /.lockscreen-image -->

        <!-- lockscreen credentials (contains the form) -->
        <form class="lockscreen-credentials">
          <div class="input-group" style="width: 100%;">
            <input type="text" class="form-control" value="${clientName}" disabled="disabled">
            
          </div>
        </form><!-- /.lockscreen credentials -->

      </div><!-- /.lockscreen-item -->
      
   
     
      <div class="lockscreen-footer text-center">
        Agradecemos su preferencia y nos permitimos informarle que: <br><br>
        
        <label>Su registro ha sido satisfactorio !!!.</label><br>
        En breve recibirá un correo a <b>${clientEmail }</b> con las 
        instrucciones para activar su cuenta. 

      </div>
      
    </div><!-- /.center -->