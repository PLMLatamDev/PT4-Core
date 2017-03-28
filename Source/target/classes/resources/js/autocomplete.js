var Autocomplete = function( predictive ){
	this.productSelectJson = null;

	$.widget( "custom.catcomplete", $.ui.autocomplete, {
		_create: function() {
			this._super();
			this.widget().menu( "option", "items", "> :not(.ui-autocomplete-category)" );
		},
		_renderMenu: function( ul, items ) {
			var that = this,
			currentCategory = "";
			$.each( items, function( index, item ) {
				var li;
				if ( item.category != currentCategory ) {
					ul.append( "<li class='ui-autocomplete-category'>" + item.category + "</li>" );
					currentCategory = item.category;
				}
				li = that._renderItemData( ul, item );
				if ( item.category ) {
					li.attr( "aria-label", item.category + " : " + item.label );
				}
			});
		}
	});

	//Buscador por Autocomplete 
	this.searchByAutocomplete = function( identifier ){
		$(identifier).catcomplete({
			delay: 2,
			source: predictive,
			minLength: 3,
			select: function( event, ui ) {
				if(ui.item!=null){
					searchGo(ui.item);
					return false;
				}else {
					$(this).trigger("change");
					return false;
				}
				
				function searchGo( text ){
					if(text.autocomplete=="pubmed"){
						var searchReg = new RegExp("^[a-z]{3,}?");
						var pub = new Object();
						var sus = (text.label != null )? text.englishDescription.toLowerCase(): text.toLowerCase();
						if(searchReg.test(sus) == true ){
							 $("#loaderView").fadeIn();
							substanceName = sus.trim();
							substanceName = substanceName.replace(/á/g,'a');
							substanceName = substanceName.replace(/é/g,'e');
							substanceName = substanceName.replace(/í/g,'i');
							substanceName = substanceName.replace(/ó/g,'o');
							substanceName = substanceName.replace(/ú/g,'u');
							substanceName = substanceName.replace(/ñ/g,'n');
							substanceName = substanceName.replace(/,/g,'');
							
							$.ajax({  
								type : "POST",   
								url:urlPath+'/e-learning/articulos',
								data : "substance=" + substanceName,  
								success : function(response) {
									window.location.href = urlPath+"/e-learning/pubmed";
								},  
								error : function(e) {
									console.log('Error: ' + e);
								}  
							});  

						}
					}else if(text.autocomplete=="encyclopedias"){
						var typeE = text.key.split("/");
						if(text.category=="Enfermedades"){
							var tmp = urlPath+"/encyclopedias/"+cleanUrl(text.label)+"-".replace("--","-");
							window.location.href = tmp+typeE[1];
						}
						if(text.category=="Síntomas"){
							var tmp = urlPath+"/encyclopedias/"+cleanUrl(text.label)+"-".replace("--","-");
							window.location.href = tmp+typeE[1];
						}
						if(text.category=="Estudios de Laboratorio"){
							var tmp = urlPath+"/encyclopedias/"+cleanUrl(text.label)+"-".replace("--","-");
							window.location.href = tmp+typeE[1];
						}
						if(text.category=="Mejora tu Salud"){
							var tmp = urlPath+"/encyclopedias/"+cleanUrl(text.label)+"-".replace("--","-");
							window.location.href = tmp+typeE[1];							
						}
						if(text.category=="Cirugías y otros procedimientos"){
							var tmp = urlPath+"/encyclopedias/"+cleanUrl(text.label)+"-".replace("--","-");
							window.location.href = tmp+typeE[1];
						}
						if(text.category=="Términos relacionados"){
							var tmp = urlPath+"/encyclopedias/"+cleanUrl(text.label)+"-".replace("--","-");
							window.location.href = tmp+typeE[1];							
						}
					}else{
						$("#loaderView").fadeIn();
						
						if(text.category=='Medicamentos'){
							window.location.href = urlPath+"/busqueda/medicamentos-busqueda/"+text.Key;
						}else if(text.category=='Sustancias'){
						    window.location.href = urlPath+"/busqueda/medicamentos-sustancia/"+text.Key;
						}else if(text.category=='Laboratorios'){
							window.location.href = urlPath+"/busqueda/medicamentos-laboratorio/"+text.Key;
						}else if(text.category=='CIE-10'){
							window.location.href = urlPath+"/busqueda/medicamentos-cie/"+text.Key;
						}else if(text.category=='ATC'){
							window.location.href = urlPath+"/busqueda/medicamentos-atc/"+text.Key;
						}else if(text.category=='Guías Clínicas'){
							var sspp = text.label.split("-");
							var cad = sspp[1].toLowerCase();
							cad = cad.trim();
							var tmp = cad.split(" ");
							var r = tmp[0];
						    r = r.replace("á","a");
						    r = r.replace("é","e");
						    r = r.replace("í","i");
						    r = r.replace("ó","o");
						    r = r.replace("ú","u");
						    r = r.replace("ñ","n");
						    r = r.replace("º","");
						    
						    window.location.href = urlPath+"/busqueda/guias-clinicas-busqueda/"+r+"/"+text.Key;
						}
					}
					
					function cleanUrl(url){
					    var clean = url.toLowerCase();
					    clean = clean.replace(new RegExp(/[àáâãäå]/g),"a");
					    clean = clean.replace(new RegExp(/[èéêë]/g),"e");
					    clean = clean.replace(new RegExp(/[ìíîï]/g),"i");
					    clean = clean.replace(new RegExp(/[òóôõö]/g),"o");
					    clean = clean.replace(new RegExp(/[ùúûü]/g),"u");
					    clean = clean.replace(new RegExp(/[\s]/g),"-");
					    return clean;
					}
					
				}

			}
		});
	}

	//Buscador por Click
	this.searchByClick = function( identifier ){
		$(identifier).click(function(){
			console.log( this.productSelectJson );
		});
	}
	
	//Buscador por teclado
	this.searchBytext = function(identifier){
		$(identifier).keypress(function(e){
			var p = e.which;
			if( p==13 ){
				var d= $(identifier).val(); 
				if(d.length>2){
					$(".ui-autocomplete").hide();
					$("#loaderView").fadeIn();
					
					var r = d.toLowerCase();
					r = r.trim();
                    r = r.replace("á","a");
                    r = r.replace("é","e");
                    r = r.replace("í","i");
                    r = r.replace("ó","o");
                    r = r.replace("ú","u");
                    r = r.replace("ñ","n");
                    $(identifier).value='';
            	                       
                    window.location = urlPath+"/busqueda/buscador/"+r;
		            
				}else{

					$rootScope.isLengthMin='Ingresar mínimo 3 caracteres';

				}

				$(identifier).val('');
			}  

		});
	}

}