/**
 * 
 */

var autocomplete = new Autocomplete( pubmedSubstances );
autocomplete.searchByAutocomplete("#txt-pubmed-search");
autocomplete.searchByClick("#search-pubmed-btn");



function _pubmedTracking(){
	$(".description-pubmed").click(function(){
		var child = "#"+$(this).children()[0].id;
		var json = eval('('+$(child).attr("value")+')');
		var data = '{"CodeString":"'+RestPLMServices.CodeString+'","EntityId":'+RestPLMServices.LogPubMedEntity+',"JSONFormat":"{\'Title\':\''+json.JSONFormat.Title+'\'}","Replicate":false,"SearchParameters":"","SearchTypeId":'+RestPLMServices.SearchTypeId+',"SourceId":'+RestPLMServices.SourceId+'}';
		$.ajax({  
	    	type : "POST",   
			url:urlLogs+"/addTrackingActivity",
			contentType: "application/json; charset=utf-8",
			data : data,
			success : function() {
				console.log('ok');
			}
		});

	});
}