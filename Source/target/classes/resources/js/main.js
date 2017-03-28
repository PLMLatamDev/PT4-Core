$(document).ready(function(){
	
	//Boton Receta y Reporte
	$("#btn-receta").hide();
	$("#btn-reporte").hide();
	
	//Boton Receta y Reporte
	if(location.pathname=="/pt4/interacciones"){
		$(".content-header").css({"text-align":"right"});
		$("#btn-receta").show();
		$("#btn-reporte").show();
	}
	
	//Botón Eliminar todo
	$("#glyphicon-delete-all").hide();
	
	//Ocultar botón Imprimir Enciclopedias
	$("#glyphicon-print-encyclopedia").hide();
	
	$("#banner-down-horizontal").hide();
	if( RestPLMServices.CountryCodes ){
		var url = window.location.pathname;
		var patternDrugs = new RegExp(urlPath+"\/busqueda\/medicamentos-busqueda\/[0-9\/]{1,}");
		var patternDivisions = new RegExp(urlPath+"\/busqueda\/medicamentos-laboratorio/[0-9\/]{1,}");
		var patternSubstance = new RegExp(urlPath+"\/busqueda\/medicamentos-sustancia/[0-9\/]{1,}");
		var patternICD = new RegExp(urlPath+"\/busqueda\/medicamentos-cie/[0-9\/]{1,}");
		var patternATC = new RegExp(urlPath+"\/busqueda\/medicamentos-atc/[0-9\/]{1,}");
		var urlInteractions = urlPath+"\/interacciones";
		if( patternDrugs.test(url) ){
			$("#banner-down-horizontal").show();
		}else if( patternDivisions.test(url) ){
			$("#banner-down-horizontal").show();
		}else if(patternSubstance.test(url)){
			$("#banner-down-horizontal").show();
		}else if( patternICD.test(url) ){
			$("#banner-down-horizontal").show();
		}else if( patternATC.test(url) ){
			$("#banner-down-horizontal").show();
		}else if(url==urlPath+"/busqueda/medicamentos/"){
			$("#banner-down-horizontal").show();
		}
	}
	
	if(window.location.pathname !== urlPath+"/home")
		$("#btn-back").show();
	else
		$("#btn-back").hide();
	
	$(".redirectMedicalPrescription").click(function(){
		$.ajax({  
    		type : "GET",   
			url:urlPath+"/EnginePrescription/getSelectedDrugs",   
			contentType: 'application/json',
   	 	    mimeType: 'application/json',
			success : function(response) {
				
				if(response.selectedDrugs != null){
					window.location.href = urlPath+"/receta/prescripcion";
				}else{
					alertify.error("Debe seleccionar por lo menos un medicamento."); 
				}
			},  
	    	error : function(e) {  
	    		console.log('Error: ' + e);
	    	}  
		});
	});
	$(".redirectClinicalReport").click(function(){
		$.ajax({  
			type : "GET",   
			url:urlPath+"/EnginePrescription/getSelectedDrugs",   
			contentType: 'application/json',
			mimeType: 'application/json',
			success : function(response) {
				
				if(response.selectedDrugs != null){
					window.location.href = urlPath+"/reporte/";
				}else{
					alertify.error("Debe seleccionar por lo menos un medicamento."); 
				}
			},  
			error : function(e) {  
				console.log('Error: ' + e);
			}  
		});
	});
	
	var autocomplete = new Autocomplete( predictive );
	autocomplete.searchByAutocomplete("#txt-general-search");
	autocomplete.searchByClick("#search-general-btn");
	autocomplete.searchBytext("#txt-general-search");
	
	$(".menu-detail").hide();
	
	
	var prescription = new Prescription();
	$.when(prescription.getDrugsCheck()).done(function( listDrugsCheck ){
		$(listDrugsCheck.selectedDrugs).each(function(i,drug){
			$("input[type=checkbox]").each(function(){
				var tmpCheck = $(this).attr('value');
				var ippa = drug.IPPA.replace(/-/g,',')+','+drug.PresentationId;
				if( ippa==tmpCheck ){
					$(this).attr('checked',true);
				}
			});
			
		});
	});
	
	$(".check-prescription").each(function(){
		$(this).attr('value');
	});
	
	$(".check-prescription").change(function(){
		var selector = $(this).attr('value').split(",");
		var json = eval( "("+ $(this).attr('description') +")" );
		json.IPPA = selector[0]+'-'+selector[1]+'-'+selector[2]+'-'+selector[3];
		var start = json.Substance.indexOf(",");
		var end = json.Substance.lastIndexOf(",");
		json.Substance = (start==end)?json.Substance:json.Substance.substring(0,json.Substance.length-1);
		
		if( $(this).is(':checked') ){ 
			var listInteractions = [];
//			listInteractions.push({"CategotyId" : null,"DivisionId" : null,"ProductId" :null,"PharmaFormId" :null});
			$(".loader-interactions").show();
			
			
			$.when(prescription.addCheck( json )).done(function( listResponse ){
				
				$(listResponse.selectedDrugs).each(function(item,product){
						listInteractions.push({"CategotyId":product.CategotyId,"DivisionId":product.DivisionId,"PharmaFormId":product.PharmaFormId,"ProductId":product.ProductId});
				});
				
				sendMessage(listInteractions);

			});
			
			
		}else{
			$.when(prescription.removeProductsCheck( json )).done(function( listResponse ){
				
				console.log( listResponse );
			});
		}	
		
	});
	
	
	_changeSearch();	
	
	
	//Mantiene el buscador general
	function _changeSearch(){
				
		if( window.location.pathname.search(urlPath+"/encyclopedias")!=-1 ){
			
			$("#txt-general-search").hide();
			$("#search-general-btn").hide();
			$("#txt-pubmed-search").hide();
			$("#search-pubmed-btn").hide();
			
			$("#txt-encyclopedias-search").show();
			$("#search-encyclopedias-btn").show();
			
		}else if( window.location.pathname==urlPath+"/e-learning/pubmed" ){
			
			$("#txt-general-search").hide();
			$("#search-general-btn").hide();
			$("#txt-encyclopedias-search").hide();
			$("#search-encyclopedias-btn").hide();
			
			$("#txt-pubmed-search").show();
			$("#search-pubmed-btn").show();
			
		}else{
			
			$("#txt-pubmed-search").hide();
			$("#search-pubmed-btn").hide();
			$("#txt-encyclopedias-search").hide();
			$("#search-encyclopedias-btn").hide();
		
			$("#txt-general-search").show();
			$("#search-general-btn").show();
			
		}
	}
	
	//History back
	function _back(){
		window.history.back();
	}
	
	$(".img-menu-search").click(function(){
		$("#loaderView").fadeIn();
		
	});
	
});


