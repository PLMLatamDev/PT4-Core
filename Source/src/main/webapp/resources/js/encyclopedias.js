
_changeSearch();
var autocomplete = new Autocomplete( encyclopediasPredictive );
autocomplete.searchByAutocomplete("#txt-encyclopedias-search");
autocomplete.searchByClick("#search-encyclopedias-btn");

//Cambia el buscador general por el de encyclopedias
function _changeSearch(){
	$("#txt-general-search").hide();
	$("#search-general-btn").hide();
	$("#txt-pubmed-search").hide();
	$("#search-pubmed-btn").hide();
	
	$("#txt-encyclopedias-search").show();
	$("#search-encyclopedias-btn").show();
}


$(".glyphicon-print").click(function(){
	var array = [];
	$(".context").each(function(){
		var txt = $(this).text().trim();
		txt.replace("\•","\r \•");
		var json={
			NameEncyclopedia:"",
			Content:txt,
			AttributeName:"",
			AttributeId:$(this).attr("id").replace("body-","")
		};
		array.push(json);
	});
	
	$.ajax({
		type:"POST",
		url:urlPath+"/encyclopedias/convert-encyclopedia",
		cache:false,
		data:JSON.stringify(array),
		contentType:"application/json",
		success:function(response){
			window.open(urlPath+"/encyclopedias/print-encyclopedia","_blank");
		},
		error:function(respon){
			console.log(respon);
		}
	});
});