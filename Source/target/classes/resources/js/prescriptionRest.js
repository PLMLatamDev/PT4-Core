var Prescription = function(){
	var explorer = ["firefox","chrome","opera","safari"];
	var na = true;
	
	//Verifica el navegador
	$(explorer).each(function(e){
		na = navigator.userAgent.toLowerCase().indexOf(explorer[e]) > -1;
		
	});
	
	//Añade los checks que esten habilitados CategoryId-DivisionId-ProductId-PharmaFormId
	this.addCheck = function(selector){
		
		var listSave = $.ajax({  
	    	type : "POST",   
			url:urlPath+"/EnginePrescription/saveSelected",
			cache: (na)?true:false,
			data : JSON.stringify( selector ),
			contentType: 'application/json',
	   	 	mimeType: 'application/json', 
			success : function(response) {
				
				$(".module-prescription").removeClass("interaction-red");
				$(".txt-prescription").removeClass("interaction-red");
				$("#total-prescription").html("<img class='loader-interactions' style ='height: 14px;' src='"+urlPath+"/resources/images/loaderInteractions.gif'>");
				
				if( $("#icon-prescription").hasClass("fa-prescription-white") ){
					$("#icon-prescription").removeClass("fa-prescription-white");
					$("#icon-prescription").addClass("fa-prescription");
				}
				
				return response;
			},error : function(e) {  
		    	console.log('Error: ' + e);
		    	$("#loaderView").fadeOut();
				alertify.error("¡Error al obtener idoneidad!");
		    }  
		});

		return listSave;
	}
	
	
	//Obtiene los medicamentos que se añadieron en el check
	this.getDrugsCheck = function(){
		var listDrugs = $.ajax({  
    		type : "GET",   
			url:urlPath+"/EnginePrescription/getSelectedDrugs",
			cache: (na)?true:false,
			contentType: 'application/json',
   	 	    mimeType: 'application/json',
			success : function(response) {
				console.log( response );
				if( response.totalInteractions>0 || response.totalDDI>0 ){
					$(".module-prescription").addClass("interaction-red");
					$(".txt-prescription").addClass("interaction-red");
				}else{
					$(".module-prescription").removeClass("interaction-red");	
					$(".txt-prescription").removeClass("interaction-red");
				}
					
				return response;
			},  
	    	error : function(e) {  
	    		console.log('Error: ' + e);
	    	}  
		});
		return listDrugs;
	}	
	
	//Elimina los medicamentos que se añadieron en el check
	this.removeProductsCheck = function( json ){
		var list = $.ajax({  
    		type : "GET",   
			url:urlPath+"/EnginePrescription/deleteSelectedDrugs/"+json.IPPA,   
			cache: (na)?true:false,
			contentType: 'application/json',
   	 	    mimeType: 'application/json',
			success : function(response) {
				$(".module-prescription").removeClass("interaction-red");
				$(".txt-prescription").removeClass("interaction-red");
				$("#total-prescription").text( response.totalSelectedDrugs );
				if( $("#icon-prescription").hasClass("fa-prescription-white") ){
					$("#icon-prescription").removeClass("fa-prescription-white");
					$("#icon-prescription").addClass("fa-prescription");
				}
				
				return response;
			},  
	    	error : function(e) {  
	    		console.log('Error: ' + e);
	    	}  
		});
		return list;
	}
	
	//Elimina todos los medicamentos
	this.removeAllProducts = function( json ){
		var result = $.ajax({
			type:"GET",
			url:urlPath+"/EnginePrescription/deleteAllSelectedDrugs",
			cache: (na)?true:false,
			contentType:'application/json',
			success:function( response ){
				return response;
			}
		});
		return result;
	}
	
/******************************************
 * 
 * NUEVOS
 *****************************************/
	//asyncInteractionsByEditionProducts
	this.asyncInteractionsByEditionProducts = function( json ){
		var result = $.ajax({
			type:"POST",
			url:urlPath+"/EnginePrescription/asyncInteractionsByEditionProducts",
			data: JSON.stringify(json),
			cache: (na)?true:false,
					contentType:'application/json',
					success:function( response ){
						if(response.totalInteractions>0 || response.totalDDI>0){
							$(".module-prescription").addClass("interaction-red");
							$("#icon-prescription").addClass("fa-prescription-white");
							$("#total-prescription").text(response.totalInteractions+response.totalDDI);
						}else{
							$(".module-prescription").removeClass("interaction-red");
							$(".txt-prescription").removeClass("interaction-red");
							$("#total-prescription").text( response.totalSelectedDrugs );
							if( $("#icon-prescription").hasClass("fa-prescription-white") ){
								$("#icon-prescription").removeClass("fa-prescription-white");
								$("#icon-prescription").addClass("fa-prescription");
							}
						}
						return response;
					}
		});
		return result;
	}
	//asyncIMDDIProductInteractionSubstances
	this.asyncIMDDIProductInteractionSubstances = function( json ){
		var result = $.ajax({
			type:"POST",
			url:urlPath+"/EnginePrescription/asyncIMDDIProductInteractionSubstances",
			data: JSON.stringify(json),
			cache: (na)?true:false,
					contentType:'application/json',
					success:function( response ){
						if(response.totalInteractions>0 || response.totalDDI>0){
							$(".module-prescription").addClass("interaction-red");
							$("#icon-prescription").addClass("fa-prescription-white");
							$("#total-prescription").text(response.totalInteractions+response.totalDDI);
						}else{
							$(".module-prescription").removeClass("interaction-red");
							$(".txt-prescription").removeClass("interaction-red");
							$("#total-prescription").text( response.totalSelectedDrugs );
							if( $("#icon-prescription").hasClass("fa-prescription-white") ){
								$("#icon-prescription").removeClass("fa-prescription-white");
								$("#icon-prescription").addClass("fa-prescription");
							}
						}
						return response;
					}
		});
		return result;
	}
	//asyncMealInteractionsByProducts
	this.asyncMealInteractionsByProducts = function( json ){
		var result = $.ajax({
			type:"POST",
			url:urlPath+"/EnginePrescription/asyncMealInteractionsByProducts",
			data: JSON.stringify(json),
			cache: (na)?true:false,
					contentType:'application/json',
					success:function( response ){
						if(response.totalInteractions>0 || response.totalDDI>0){
							$(".module-prescription").addClass("interaction-red");
							$("#icon-prescription").addClass("fa-prescription-white");
							$("#total-prescription").text(response.totalInteractions+response.totalDDI);
						}else{
							$(".module-prescription").removeClass("interaction-red");
							$(".txt-prescription").removeClass("interaction-red");
							$("#total-prescription").text( response.totalSelectedDrugs );
							if( $("#icon-prescription").hasClass("fa-prescription-white") ){
								$("#icon-prescription").removeClass("fa-prescription-white");
								$("#icon-prescription").addClass("fa-prescription");
							}
						}
						return response;
					}
		});
		return result;
	}
	//asyncContraindicationsByProducts
	this.asyncContraindications = function( json ){
		var result = $.ajax({
			type:"POST",
			url:urlPath+"/EnginePrescription/asyncContraindicationsByProducts",
			data: JSON.stringify(json),
			cache: (na)?true:false,
					contentType:'application/json',
					success:function( response ){
						if(response.totalInteractions>0 || response.totalDDI>0){
							$(".module-prescription").addClass("interaction-red");
							$("#icon-prescription").addClass("fa-prescription-white");
							$("#total-prescription").text(response.totalInteractions+response.totalDDI);
						}else{
							$(".module-prescription").removeClass("interaction-red");
							$(".txt-prescription").removeClass("interaction-red");
							$("#total-prescription").text( response.totalSelectedDrugs );
							if( $("#icon-prescription").hasClass("fa-prescription-white") ){
								$("#icon-prescription").removeClass("fa-prescription-white");
								$("#icon-prescription").addClass("fa-prescription");
							}
						}
						return response;
					}
		});
		return result;
	}
	
	
	//PregnancyRiskByDrugs
	this.asyncPregnancyRiskByDrugs = function( json ){
		var listPregnancyRiskByDrugs = $.ajax({
			type : "POST",      
			url:urlPath+"/EnginePrescription/PregnancyRiskByDrugs",   
			cache: (na)?true:false,
			data : JSON.stringify( json ),
			contentType: 'application/json',
		 	mimeType: 'application/json', 
			success : function(response) {
				
				return response;
			},  
	    	error : function(e) {  
	    		console.log('Error: ' + e);
	    	}
		});
		return listPregnancyRiskByDrugs;
	}
	//DDD
	this.asyncDefinedDailyDoseByDrugs = function( json ){
		var listDefinedDailyByDrugs = $.ajax({
			type : "POST",   
			url:urlPath+"/EnginePrescription/DefinedDailyDoseByDrugs",   
			cache: (na)?true:false,
			data : JSON.stringify( json ),
			contentType: 'application/json',
		 	mimeType: 'application/json', 
			success : function(response) {
				
				return response;
			},  
	    	error : function(e) {  
	    		console.log('Error: ' + e);
	    	}
		});
		return listDefinedDailyByDrugs;
	}
	
	//SubstanceIncompatibilitiesByProducts
	this.asyncSubstanceIncompatibilitiesByProducts = function( json ){
		var listIncompatibilitiesByProducts = $.ajax({
			type : "POST",
			url:urlPath+"/EnginePrescription/SubstanceIncompatibilitiesByProducts",
			cache: (na)?true:false,
			data : JSON.stringify( json ),
			contentType: 'application/json',
		 	mimeType: 'application/json', 
			success : function(response) {
				
				return response;
			},  
	    	error : function(e) {  
	    		console.log('Error: ' + e);
	    	}
		});
		return listIncompatibilitiesByProducts;
	}
	//TherapeuticDoublenessByDrugs
	this.asyncTherapeuticDoublenessByDrugs = function( json ){
		var listIncompatibilitiesByProducts = $.ajax({
			type : "POST",
			url:urlPath+"/EnginePrescription/TherapeuticDoublenessByDrugs",
			cache: (na)?true:false,
			data : JSON.stringify( json ),
			contentType: 'application/json',
		 	mimeType: 'application/json', 
			success : function(response) {
				
				return response;
			},  
	    	error : function(e) {  
	    		console.log('Error: ' + e);
	    	}
		});
		return listIncompatibilitiesByProducts;
	}
	//resultInteractions
	this.getSuitabilityGroup = function(){
		var result = $.ajax({
			type:"POST",
			url:urlPath+"/EnginePrescription/getSuitabilityGroup",
			cache: (na)?true:false,
			contentType:'application/json',
			success:function( response ){
				if(response.totalInteractions>0 || response.totalDDI>0){
					$(".module-prescription").addClass("interaction-red");
					$("#icon-prescription").addClass("fa-prescription-white");
					$("#total-prescription").text(response.totalInteractions+response.totalDDI);
				}else{
					$(".module-prescription").removeClass("interaction-red");
					$(".txt-prescription").removeClass("interaction-red");
					$("#total-prescription").text( response.totalSelectedDrugs );
					if( $("#icon-prescription").hasClass("fa-prescription-white") ){
						$("#icon-prescription").removeClass("fa-prescription-white");
						$("#icon-prescription").addClass("fa-prescription");
					}
				}
				return response;
			}
		});
		return result;
	}
}