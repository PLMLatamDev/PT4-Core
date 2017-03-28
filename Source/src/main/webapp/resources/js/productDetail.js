$(".banner-navigation").hide();
setTimeout(function(){ 
	$(".menu-detail").show("slow");
}, 1000);



$(".botonera-detail,.txt-detail").hide();

var arrayMark = [];
var promise = $.ajax({  
	type : "GET",   
	url:urlPath+"/descripcion-medicamento/getIPP",
	contentType: 'application/json',
	 	mimeType: 'application/json', 
	success : function(response) {
		return response;
	}
});

var txtCollapse = null;
$.when(promise).done(function(list){
	if(list.substances==="#body-5" || list.pharmacologicalGroup==="#botonera-5"){
		
		var idDiv = "#"+$(list.substances).parent().attr("id");
		$(list.pharmacologicalGroup).show();
		//LLeva hasta las interacciones si hay
		$(idDiv).addClass("in");
		$('html,body').animate({
		    scrollTop: $("#header-5").offset().top
		}, 1000);
		
	}else if( list.substances!=null || list.pharmacologicalGroup!=null ){
		
		var tmp = list.substances+","+list.pharmacologicalGroup;
		var bodyExpanded = "#body-12";
		var boxSearch = "#botonera-12";
		var txtSearch = "#txt-12";
		var idDiv = "#"+$(bodyExpanded).parent().attr("id");
		$(boxSearch).show();
		
		arrayIPP = tmp.split(",");
		$(arrayIPP).each(function(s,substance){
			arrayMark.push( substance.trim() );
		});
		
		//LLeva hasta las interacciones si hay
		$(idDiv).addClass("in");
		$('html,body').animate({
		    scrollTop: $("#header-12").offset().top
		}, 1000);
		
		var mark = function(){
		    $(".context").unmark().mark($(txtSearch).val());
		}
		
		var markIPP = function(){
			var options = {"caseSensitive":true,"accuracy":"exactly","separateWordSearch":false};
		    $(".context").unmark().mark(arrayMark,options);
		}
		
		$("#header-12").on("animate.ipp", markIPP).trigger("animate.ipp");
		$(txtSearch).on("input", markIPP);
		$("#header-12").on("click.ipp", markIPP).trigger("click.ipp");
		$(txtSearch).on("input",mark);
	}
	
});


$(".attribute-acordeon").click(function(){
	
	var attribute = $(this).attr("href");
	var arraySelected = $(this).attr("href").split("-");
	var idBox = "#header-"+arraySelected[1];
	var number = arraySelected[1];
	var boxSearch = "#botonera-"+number;
	var txtSearch = "#txt-"+number;
	
	$(".txt-detail").hide();
	
	if( $(attribute).hasClass("in")==false ){
		_attributeTracking( idBox );
		$(boxSearch).show();
		$(txtSearch).val('');
		$(".context").unmark();
		

		var mark = function(){
		    $(".context").unmark().mark($(txtSearch).val());
		}
		
		//Verifica si el arreglo IPP Contiene sustancias o grupos farmacologicos
		if( (idBox=="#header-12") && arrayMark.length>0 ){
			var markIPP = function(){
				var options = {"caseSensitive":true,"accuracy":"exactly","separateWordSearch":false};
			    $(".context").unmark().mark(arrayMark,options);
			}		
			$(idBox).on("click.ipp", markIPP).trigger("click.ipp");
			$(txtSearch).on("input",mark);
		}else{
			$(txtSearch).on("input", mark);
		}
		
	}
	
});


function _attributeTracking( attribute ){
	var json = eval('('+$(attribute).attr("value")+')');
	var data = '{"AttributeGroupKey":"'+json.groupKey+'","CodeString":"'+RestPLMServices.CodeString+'","EntityId":'+RestPLMServices.EntityId+',"ISBN":"'+RestPLMServices.ISBN+'","JsonFormat":"VALOR NULO","Replicate":'+false+',"SearchParameters":"DivisionId:'+json.divisionId+';CategoryId:'+json.categoryId+';ProductId:'+json.productId+';PharmaFormId:'+json.pharmaFormId+'","SearchTypeId":'+RestPLMServices.SearchTypeId+',"SourceId":'+RestPLMServices.LogSourceId+',"TrackId":0}';
	$.ajax({  
    	type : "POST",   
		url:urlLogs+"/addPLMTrackingActivity",
		contentType: "application/json; charset=utf-8",
		data : data,
		success : function() {
			console.log('ok');
		}
	
	});

}