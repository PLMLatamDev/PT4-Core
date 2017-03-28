(function(){
	console.log("#");
	$("#report-history-table").stacktable();
	
})();
var prescription = new Prescription();
function getClinicalReportById(reportId){
	$("#loaderView").fadeIn();
	url = "/reporte/getReportById";
	$.ajax({
		url : urlPath+url,
		type : "POST",
		data : "reportId="+reportId,
		success : function(response) {
//		console.log(JSON.parse(response.JsonContent));
			var productsJson = JSON.parse(response.JsonContent);
			
			$(productsJson.Products).each(function(i,item){
				var substances = "";
			if(typeof item.Substances === 'string'){
				substances = item.Substances ;
			}else{
				var array  = item.Substances.length;
				for(var i = 0; i<array;i++){
					if(i==array-1){
						substances += item.Substances[i].Description;
					}else{
						substances += item.Substances[i].Description+", ";
					}
				}
			}
			
             var json = {
            		 Brand:item.Brand,
            		 CategotyId:item.CategotyId,
            		 DivisionId:item.DivisionId,
            		 DivisionName:item.DivisionName,
            		 IPPA:item.IPPA,
            		 PharmaForm:item.PharmaForm,
            		 PharmaFormId:item.PharmaFormId,
            		 Presentation:item.Presentation,
            		 PresentationId:item.PresentationId,
            		 ProductId:item.ProductId,
            		 Substance: substances
             }; 
			
            $.when(prescription.addCheck( json )).done(function( listResponse ){
				
           	if(i == productsJson.Products.length-1){
           		
           		window.location.href = urlPath+"/interacciones?reporte=true"; 
				
          	}
                
			});
		});
			
		},  
		error : function(e) {  
			$("#loaderView").fadeOut();
			alertify.error("¡Error al abrir reporte.!");
		} 
	});
}
