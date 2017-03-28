<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>

<style>
	.tab-layout-IM, .tab-layout-DDI{
	    text-align: center;
	    font-weight: bold;
	    font-size: 11px;
	    width: 70%;
	    height: auto;
	    padding: 4% 0 4% 0;
	    margin-left: 14%;
	}    
	    
	.tab-layout-DDI{
	    word-spacing: 5px;
	}
	
	.panel-select{
		cursor:pointer;
		padding: 0px 11px;
	}
	
	.li-tab{
		border: 1px solid #dbdce0;
		border-radius: 4px 4px 0 0;
	}
	
	.nav > li > a:hover, .nav > li > a:active, .nav > li > a:focus {
    	color: #1c8fc7;
    	background: #f7f7f7;
	}
	
	.nav-tabs>li.li-im>a,.nav-tabs>li.li-im>a:focus,.nav-tabs>li.li-im>a:hover {
		border: none;
    	background-color: #1c8fc7;
    	color: #fff;
	}

	.nav-tabs>li.li-ddi>a,.nav-tabs>li.li-ddi>a:focus,.nav-tabs>li.li-ddi>a:hover {
		border: none;
    	background-color: #1c8fc7;
    	color: #fff;
	}
	
	.content-header{
      text-align:right;
    }
	
	
	
	
	
	/************
	Interactions
	*************/
	
  	
 	
 	@media only screen and (min-width : 320px) {
 		.li-tab{
			width: 50%;
		}
		
 		.tab-layout-DDI{
 			padding:10% 1% 10% 1%;
 		}
 	}
 	
 	@media only screen and (min-width : 480px) {
 		.li-tab{
			width: 50%;
		}
		
 		.tab-layout-IM{
 			width: 76%;
 			padding: 4% 1% 4% 1%; 
 		}
 		
 		.tab-layout-DDI{
 			width: 76%; 	
 		    padding: 4% 0 4% 0;
 		    word-spacing: 20px;
 		}
 	}
	
	@media only screen and (min-width: 768px){
		.li-tab{
			width: 50%;
		}
	
		.tab-layout-IM{   
	 	    width: 76%; 
	 	    padding: 4% 1% 4% 1%; 
 		} 
 		
 		.tab-layout-DDI{
 			padding: 4% 0% 4% 01%;
 		}
	}

	@media only screen and (min-width: 992px){
		.li-tab{
			width: 20%;
		}
	
		.tab-layout-IM, .tab-layout-DDI{   
	 	    width: 76%; 
	 	    padding: 0% 0% 0% 0%;
 		} 
 		
 		.tab-layout-DDI{
 			word-spacing: 16px;
 		}
	}
	
 	
	
	
</style>
<script type="text/javascript">
	$(document).ready(function(){
		//Botón Eliminar todo
		$("#glyphicon-delete-all").show();
		
	});
	
</script>

<div class="col-md-12" style="padding-left: 10px; padding-right: 10px;">
	<div class="box" id="box-prescription">
		
	</div>
</div>

<div class="col-md-12" style="padding-left: 10px; padding-right: 10px;">
	<div class="box">
		<div class="box-body" id="body-content-prescription">
		</div>
	</div>
</div>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/interactions.js"></script>
<c:if test="${param.reporte != null}">

      <script type="text/javascript">
      $(window).load(function(){ 
      (function(){
    	  var listInteractions = [];
     	 $.ajax({  
	    		type : "GET",   
				url:urlPath+"/EnginePrescription/getSelectedDrugs",   
				contentType: 'application/json',
	   	 	    mimeType: 'application/json',
				success : function(listResponse) {
					$(listResponse.selectedDrugs).each(function(item,product){
						listInteractions.push({"CategotyId":product.CategotyId,"DivisionId":product.DivisionId,"PharmaFormId":product.PharmaFormId,"ProductId":product.ProductId});
						
				});
					setTimeout(function(){ 
						sendMessage(listInteractions); 
						}, 2000);
				
				},  
		    	error : function(e) {  
		    		console.log('Error: ' + e);
		    	}  
			});
      })();
      });
      </script>
   </c:if>