<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="es">
	<head>
		 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    	<title>Prescripción Total 4.0</title>
    	<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    	<link rel="icon" href="${pageContext.request.contextPath}/resources/images/favicon.ico">
    	<link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/images/favicon.ico" type="image/x-icon">
    	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"> 
    	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css">
    	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/AdminLTE.min.css">
    	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/formValidation.css">
    	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css">
    	
    	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/libraries/jquery.min.js"></script>
    	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/libraries/formValidation.min.js"></script>
	    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/libraries/formValidation.Framework.js"></script>
	      <script type="text/javascript" src="${pageContext.request.contextPath}/resources/libraries/bootstrap.min.js"></script>
    	
	</head>
	
	<script type="text/javascript">
  		var urlPath= "${pageContext.request.contextPath}";
  		function goBack(){
  			window.history.back();
  		}
   	</script>
	
  	<body class="hold-transition login-page" style="background:#e7ebef">
    	<div class="wrapper">
		
     				<!-- Content Wrapper. Contains page content -->
     			
     					
				        
       					<tiles:insertAttribute name="bodySite"></tiles:insertAttribute>	
     			
     			   
     			   
   		</div>
   		<!-- ******************************* BLOQUEADOR ********************************* -->
		<div id="loaderView" class="display_loader text-center">
			
			<i class="fa fa-spinner fa-pulse"></i>&nbsp;&nbsp;<span>Cargando...</span>
			
			
		</div>
		<!-- *******************************FIN BLOQUEADOR ****************************** -->
   		
		   		
  </body>
</html>
