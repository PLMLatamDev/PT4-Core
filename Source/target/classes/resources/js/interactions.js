

var prescription = new Prescription();
var _listIM, _listDDI, _listIMA, _listCON, _listPregnancyRiskDrugs, _listDDD, _listIncompatibilities, _listTherapeutic = [];




_createGridPrescriptions();

function _createGridPrescriptions(){
	
	
	$.when(prescription.getSuitabilityGroup()).done(function( listProducts ){
		if( listProducts.selectedDrugs!=null){
			
			var listInteractions = [];
			var gridHtml = "<div class='box-body' id='prescriptionGrid'>"+
								"<div class='renglon' id='tableHeader'>"+
									"<div class='tab-8 head'>Medicamento</div>"+
									"<div class='tab-8 head'>Sustancia</div>"+
									"<div class='tab-8 head'>Forma <br/>Farmacéutica</div>"+
									"<div class='tab-8 head'>Laboratorio</div>"+
									"<div class='tab-8 head'>Idoneidad</div>"+
									"<div class='tab-8 head col-del'></div>"+
								"</div>";
							
	
			$(listProducts.selectedDrugs).each(function(p,product){
				if( p%2==0 )
					gridHtml += "<div class='renglon gris1 renglon-prescription' value='"+product.IPPA+"'>";
				else
					gridHtml += "<div class='renglon gris2 renglon-prescription' value='"+product.IPPA+"'>";
					
					gridHtml += "<div class='tab-8 first'><a class='title-redirec' href='"+urlPath+"/descripcion-medicamento/"+product.DivisionId+"-"+product.CategotyId+"-"+product.ProductId+"-"+product.PharmaFormId+"/0'>"+product.Brand+"</a></div>"+
									"<div class='tab-8'>"+product.Substance+"</div>"+
									"<div class='tab-8'>"+product.PharmaForm+"</div>"+
									"<div class='tab-8 box-divisions' value='"+product.IPPA+"'>"+product.DivisionName+"</div>"+
									"<div class='tab-8 box-interactions' value='"+product.IPPA+"'>"+
										
										//Prescriptions buttons
										"<img class='loader-interactions' id='load-"+product.IPPA+"' value='"+product.IPPA+"' height='30px;' src='"+urlPath+"/resources/images/loaderInteractions.gif'>"+
										
									"</div>"+
									"<div class='tab-8 tab-delete' style='width: 2%;'><i class='fa fa-trash-o fa-delete' value='"+product.IPPA+"'"+
									"style='cursor: pointer; color: #0a3d6b; font-size: 2em;' data-toggle='tooltip' data-placement='top' title='Eliminar Producto' onClick='deleteRenglon(\""+product.IPPA+"\")'></i>"+
									"</div>"+
								"</div>";
				
				listInteractions.push({"CategotyId" : product.CategotyId,"DivisionId" : product.DivisionId,"ProductId" :product.ProductId,"PharmaFormId" :product.PharmaFormId});
				
			});
			gridHtml += "</div>";
			$("#box-prescription").html( gridHtml );
			
			$("#total-prescription").text(listProducts.totalSelectedDrugs);
			
			
			//IM				
			if( listProducts.arrayInteractionsByEditionProductsResponse!=null || listProducts.arrayIMDDIProductInteractionSubstancesResponse!=null ){
//				console.log( listProducts.arrayInteractionsByEditionProductsResponse );
				_listIM = (listProducts.arrayInteractionsByEditionProductsResponse!=null)?listProducts.arrayInteractionsByEditionProductsResponse:[];
				_listDDI = (listProducts.arrayIMDDIProductInteractionSubstancesResponse!=null)?listProducts.arrayIMDDIProductInteractionSubstancesResponse:[];
				var arrayIPP = [];
				var totalInteractions = 0;
				$(listProducts.arrayInteractionsByEditionProductsResponse).each(function(item,im){
					im.IPPA = im.CategoryId+"-"+im.DivisionId+"-"+im.ProductId+"-"+im.PharmaFormId;
					arrayIPP.push(im);
				});
				
				$(listProducts.arrayIMDDIProductInteractionSubstancesResponse).each(function(item,ddi){
					ddi.IPPA = ddi.CategoryId+"-"+ddi.DivisionId+"-"+ddi.ProductId+"-"+ddi.PharmaFormId;
					arrayIPP.push(ddi);
				});
				
				$(arrayIPP).each(function(im,iLaboratory){
					iLaboratory.IPPA = iLaboratory.CategoryId+"-"+iLaboratory.DivisionId+"-"+iLaboratory.ProductId+"-"+iLaboratory.PharmaFormId;

					
					if( iLaboratory.InteractionSubstances.length>0 || iLaboratory.PharmacologicalGroups.length>0 ){
						totalInteractions++;
						$(".renglon-prescription").each(function(){
							if($(this).attr("value")==iLaboratory.IPPA)
								$(this).addClass("interaction-red");
						});
						
						$(".fa-delete").each(function(){
							if($(this).attr("value")==iLaboratory.IPPA)
								$(this).css("color","#ffffff");
							
						});
						
						$(".box-interactions").each(function(){
							var ippa = $(this).attr("value");
							var btn = "";
							if( ippa==iLaboratory.IPPA ){
								var loader = $(this).children();
								$("#"+loader[0].id).hide();
								
								btn+="<div class='btn-group' id='interactionAlertDDI-"+iLaboratory.IPPA+"' data-toggle='tooltip' data-placement='top'"+
								"data-original-title='Interacciones Medicamentosas' style='display: inline-block;'>"+
								"<button class='btn btn-primary btn-im dropdown-toggle latidos' id='btn-im-"+iLaboratory.IPPA+"' style='padding: 3px 9px;width:51px;height:28px;' data-toggle='dropdown'"+
										"value='im-"+iLaboratory.IPPA+"' onClick='showPanelIM(\""+iLaboratory.IPPA+"\")'>IM</button>"+
								"</div>";
								
								if( $("#btn-im-"+iLaboratory.IPPA).length>0==false )
									$(this).append( btn );
							}
						});
						
						
						
					}
						
				});
				if( totalInteractions>0 )
					$("#total-prescription").text(totalInteractions);
			}
			
			
			//DDI
//			if( listProducts.arrayIMDDIProductInteractionSubstancesResponse!=null ){
//				_listDDI = listProducts.arrayIMDDIProductInteractionSubstancesResponse;
//				$(listProducts.arrayIMDDIProductInteractionSubstancesResponse).each(function(i,ddi){
//					ddi.IPPA = ddi.CategoryId+"-"+ddi.DivisionId+"-"+ddi.ProductId+"-"+ddi.PharmaFormId;
//					if( ddi.InteractionSubstances.length>0 ){
//						$(".renglon").each(function(){
//							if($(this).attr("value")==ddi.IPPA)
//								$(this).addClass("interaction-red");
//						});
//						
//						$(".fa-delete").each(function(){
//							if($(this).attr("value")==ddi.IPPA)
//								$(this).css("color","#ffffff");
//							
//						});
//						
//						$(".box-interactions").each(function(){
//							var ippa = $(this).attr("value");
//							var btn="";
//							if( ippa==ddi.IPPA ){
//								var loader = $(this).children();
//								$("#"+loader[0].id).hide();
//								btn+="<div class='btn-group' id='interactionAlertDDI-"+ddi.IPPA+"' data-toggle='tooltip' data-placement='top'"+
//										"data-original-title='Interacciones basadas en Evidencia' style='display: inline-block;'>"+
//						
//											"<button class='btn btn-default btn-ddi dropdown-toggle latidos' id='btn-ddi-"+ddi.IPPA+"' style='padding: 3px 9px;width:51px;height:28px;' data-toggle='dropdown'"+
//											"value='ddi-"+ddi.IPPA+"' onClick='showDDI(\""+ddi.IPPA+"\")'>IMM</button>"+
//					
//									"</div>";
//								if( $("#btn-ddi-"+ddi.IPPA).length>0==false )
//									$(this).append( btn );
//							}
//						});
//					}
//				});
//			}

			
			//IMA
			if( listProducts.arrayMealInteractionsByProductsResponse!=null ){
				_listIMA = listProducts.arrayMealInteractionsByProductsResponse;
				$(listProducts.arrayMealInteractionsByProductsResponse).each(function(p,ima){
					if(ima.MealInteractions.length>0){
						$(ima.Products).each(function(p,product){
							product.IPPA = product.CategoryId+"-"+product.DivisionId+"-"+product.ProductId+"-"+product.PharmaFormId;
							
							$(".box-interactions").each(function(){
								var ippa = $(this).attr("value");
								var btn = "";
								if( ippa==product.IPPA ){
									var loader = $(this).children();
									$("#"+loader[0].id).hide();
									btn+="<div class='btn-group' id='interactionAlertIMA-"+product.IPPA+"' data-toggle='tooltip' data-placement='top'"+
											"data-original-title='Interacciones Medicamento-Alimento'"+
											"style='display: inline-block;'>"+
									
											"<button class='btn btn-warning btn-ima dropdown-toggle' id='btn-ima-"+product.IPPA+"'"+
												"style='padding: 3px 9px;width:51px;height:28px;' data-toggle='dropdown'"+
												"value='ima-"+product.IPPA+"' onClick='showIMA(\""+product.IPPA+"\")'>IMA</button>"+
										
										"</div>";
									if( $("#btn-ima-"+product.IPPA).length>0==false )
										$(this).append( btn );
									
								}
							});
							
						});
						
					}
					
				});
			}
			
			//CON
			if( listProducts.arrayContraindications!=null ){
				_listCON = listProducts.arrayContraindications;
				$(listProducts.arrayContraindications).each(function(p,con){
					con.IPPA = con.CategoryId+"-"+con.DivisionId+"-"+con.ProductId+"-"+con.PharmaFormId;
					$(con.ActiveSubstanceContraindications).each(function(c,itemCON){
						if( itemCON.ActiveSubstanceContraindications.length>0         ||
							itemCON.ContraindicationComments.length>0                 ||
							itemCON.HypersensibilityContraindications.length>0        ||
							itemCON.ICDContraindications.length>0			          ||
							itemCON.OtherContraindications.length>0			          ||
							itemCON.PharmacologicalGroupContraindications.length      ||
							itemCON.PhysiologicalContraindications.length
						){
							$(".box-interactions").each(function(){
								var ippa = $(this).attr("value");
								var btn = "";
								if( ippa==con.IPPA ){
									var loader = $(this).children();
									$("#"+loader[0].id).hide();
									btn+="<div class='btn-group' id='interactionAlertCON-"+con.IPPA+"'"+
											  "data-toggle='tooltip' data-placement='top'"+
											  "data-original-title='Contraindicaciones'"+
											  "style='display: inline-block;'>"+
									
											  "<button class='btn btn-success btn-con dropdown-toggle' id='btn-con-"+con.IPPA+"'"+
											  	"style='padding: 3px 9px;width:51px;height:28px;' data-toggle='dropdown'"+
											  	"value='con-'"+con.IPPA+"' onClick='showCON(\""+con.IPPA+"\")'>CON</button>"+
								
										"</div>";
									if( $("#btn-con-"+con.IPPA).length>0==false )
										$(this).append( btn );
								}
								
							});
						}
					});
					
				});
			}
			
			
//			$.when(prescription.getPregnancyRiskByDrugs(listInteractions)).done(function( listPregnancyRiskDrugs ){
				if( listProducts.arrayPregnancyRisksByDrugs!=null ){
					_listPregnancyRiskDrugs = listProducts.arrayPregnancyRisksByDrugs;
					$(listProducts.arrayPregnancyRisksByDrugs).each(function( p,pregnancy ){
						pregnancy.IPPA = pregnancy.CategoryId+"-"+pregnancy.DivisionId+"-"+pregnancy.ProductId+"-"+pregnancy.PharmaFormId;
						$(".box-interactions").each(function(){
							var ippa = $(this).attr("value");
							var btn = "";
							if( ippa==pregnancy.IPPA ){
								btn+="<div class='btn-group' id='interactionAlertPregnancy-"+pregnancy.IPPA+"'"+
								  "data-toggle='tooltip' data-placement='top'"+
								  "data-original-title='Riesgo en el Embarazo'"+
								  "style='display: inline-block;'>"+
						
								  "<button class='btn btn-default btn-con dropdown-toggle' id='btn-con-"+pregnancy.IPPA+"'"+
								  	"style='color:#FFFFFF;background-color:#5a6e82;padding: 3px 9px;width:51px;height:28px;' data-toggle='dropdown'"+
								  	"value='pregnancy-'"+pregnancy.IPPA+"' onClick='showPregnancy(\""+pregnancy.IPPA+"\")'>RE</button>"+
					
								"</div>";
								if( $("#btn-default-"+pregnancy.IPPA).length>0==false )
									$(this).append( btn );
							}
						});
					});
				}
//			});
//			
//			$.when(prescription.getDefinedDailyDoseByDrugs(listInteractions)).done(function( listDDD ){
//				
				if( listProducts.arrayDefinedDailyDoseByDrugs!=null ){
					_listDDD = listProducts.arrayDefinedDailyDoseByDrugs;
					$(listProducts.arrayDefinedDailyDoseByDrugs).each(function(loop,ddd){
						ddd.IPPA = ddd.CategoryId+"-"+ddd.DivisionId+"-"+ddd.ProductId+"-"+ddd.PharmaFormId;
						$(".box-interactions").each(function(){
							var ippa = $(this).attr("value");
							var btn = "";
							if( ippa==ddd.IPPA ){
								btn+="<div class='btn-group' id='interactionAlertDDD-"+ddd.IPPA+"'"+
								  "data-toggle='tooltip' data-placement='top'"+
								  "data-original-title='Dosis Diaria Definida'"+
								  "style='display: inline-block;'>"+
						
								  "<button class='btn btn-default btn-con dropdown-toggle' id='btn-con-"+ddd.IPPA+"'"+
								  	"style='color:#FFFFFF;background-color:#D81B60;padding: 3px 9px;width:51px;height:28px;' data-toggle='dropdown'"+
								  	"value='pregnancy-'"+ddd.IPPA+"' onClick='showDDD(\""+ddd.IPPA+"\")'>DDD</button>"+
					
								"</div>";
								if( $("#btn-default-"+ddd.IPPA).length>0==false )
									$(this).append( btn );
							}
						});
					});
				}
//			});
//			
//			$.when(prescription.getSubstanceIncompatibilitiesByProducts(listInteractions)).done(function( listIncompatibilities ){
				if( listProducts.arraySubstanceIncompatibilitiesByProductsResponse!=null ){
					_listIncompatibilities = listProducts.arraySubstanceIncompatibilitiesByProductsResponse;
					$(listProducts.arraySubstanceIncompatibilitiesByProductsResponse).each(function( loop,incompatibility ){
						incompatibility.IPPA = incompatibility.CategoryId+"-"+incompatibility.DivisionId+"-"+incompatibility.ProductId+"-"+incompatibility.PharmaFormId;
						$(".box-interactions").each(function(){
							var ippa = $(this).attr("value");
							var btn = "";
							if( ippa==incompatibility.IPPA ){
								var list = incompatibility.SubstanceIncompatibilities.length;
								for(var index=0;index<list;index++){
									if(incompatibility.SubstanceIncompatibilities[index].IncompatibilitySubstances.length>0){									
										btn+="<div class='btn-group' id='interactionAlertDDD-"+incompatibility.IPPA+"'"+
										  "data-toggle='tooltip' data-placement='top'"+
										  "data-original-title='Incompatibilidades Físico Químicas'"+
										  "style='display: inline-block;'>"+
								
										  "<button class='btn btn-default btn-con dropdown-toggle' id='btn-con-"+incompatibility.IPPA+"'"+
										  	"style='color:#FFFFFF;background-color:#605ca8;padding: 3px 9px;width:51px;height:28px;' data-toggle='dropdown'"+
										  	"value='pregnancy-'"+incompatibility.IPPA+"' onClick='showIFQ(\""+incompatibility.IPPA+"\")'>IFQ</button>"+
							
										"</div>";
										if( $("#btn-default-"+incompatibility.IPPA).length>0==false )
											$(this).append( btn );
									}
								}
							}
						});
					});
				}
//			});
//			
//			$.when(prescription.getTherapeuticDoublenessByDrugs(listInteractions)).done(function(listTherapeutic){
//				console.log(listTherapeutic);
				if( listProducts.arrayTherapeuticDoublenessByDrugsResponse!=null ){
					_listTherapeutic = listProducts.arrayTherapeuticDoublenessByDrugsResponse;
					$(listProducts.arrayTherapeuticDoublenessByDrugsResponse).each(function(t,therapeutic){
						if(therapeutic.ATCOMSDoubleness.length>0 ){
							therapeutic.IPPA = therapeutic.CategoryId+"-"+therapeutic.DivisionId+"-"+therapeutic.ProductId+"-"+therapeutic.PharmaFormId;
							$(".box-interactions").each(function(){
								var ippa = $(this).attr("value");
								var btn = "";
								if( ippa==therapeutic.IPPA ){
									btn+="<div class='btn-group' id='interactionAlertDDD-"+therapeutic.IPPA+"'"+
									  "data-toggle='tooltip' data-placement='top'"+
									  "data-original-title='Duplicidad Terapéutica'"+
									  "style='display: inline-block;'>"+
							
									  "<button class='btn btn-default btn-con dropdown-toggle' id='btn-con-"+therapeutic.IPPA+"'"+
									  	"style='color:#FFFFFF;background-color:#39CCCC;padding: 3px 9px;width:51px;height:28px;' data-toggle='dropdown'"+
									  	"value='pregnancy-'"+therapeutic.IPPA+"' onClick='showDT(\""+therapeutic.IPPA+"\")'>DT</button>"+
						
									"</div>";
									if( $("#btn-default-"+therapeutic.IPPA).length>0==false )
										$(this).append( btn );
								}
							});
						}
					});
				}
//			});
			$(listProducts.selectedDrugs).each(function(d,drugs){
			
				$(".loader-interactions").each(function(){
					var ipp = $(this).attr("value");
					if( ipp==drugs.IPPA )
						$(this).hide();
				});
			});
		}
	});
	
	
}

function showPanelIM( btnIM ){
	
	var lista = _listIM.length;
	var step = true;
	for( var item=0;item<lista;item++ ){
		if( _listIM[item].IPPA==btnIM && (_listIM[item].InteractionSubstances.length>0|| _listIM[item].PharmacologicalGroups!=null) ){
			
			showIM( btnIM );
			step = false;
			break;
		}
	}

	if( step ){
		$(_listDDI).each(function(im,drugs){
			if( drugs.IPPA==btnIM ){
				showDDI( btnIM );
			}
		});
	}

}


function showIM( btnIM ){
	var conHTML = "";
	$( _listIM ).each(function(i,itemIM){
		if( itemIM.IPPA==btnIM ){
			
			conHTML +="<ul class='nav nav-tabs'>"+
							"<li class='active li-tab li-im'><a class='panel-select' onClick='showIM(\""+btnIM+"\")'><div class='tab-layout-IM' value='im-"+btnIM+"'>Interacciones basadas en información del fabricante</div></a></li>";
							$(_listDDI).each(function(item,ddi){
								if( ddi.IPPA==btnIM && ddi.InteractionSubstances.length>0 )
									conHTML += "<li class='li-tab'><a class='panel-select' onClick='showDDI(\""+btnIM+"\")'><div class='tab-layout-DDI' value='ddi-"+btnIM+"'>Interacciones basadas en evidencia</div></a></li>";								
							});
			conHTML +="</ul>"+
			
			
			"<div class='box box-solid prescription'"+
				"value='im-"+itemIM.CategoryId+"-"+itemIM.DivisionId+"-"+itemIM.ProductId+"-"+itemIM.PharmaFormId+"'>"+

				"<div class='box-header with-border' style='background-color: #3a6f9f; color: white;'>"+
					"<h3 class='box-title' style='float:left;font-weight:700;'>"+itemIM.Brand+
						"<span style='font-style:italic;'> "+itemIM.PharmaForm+"</span></h3>"+
						"<button onClick='redirectIPPA(\""+itemIM.PISubstances+" && "+ itemIM.PIGroups +" && "+ itemIM.DivisionId+"-"+itemIM.CategoryId+"-"+itemIM.ProductId+"-"+itemIM.PharmaFormId+"\")'"+
						" style='float:left;margin-left:3%;margin-bottom:0;background-color: #1c8fc7; height: 23px; color: white; border-color: transparent; font-weight: bold;margin-top:-5px;font-size:12px;'>"+
						"IPPA</button>"+

				"</div>"+

				"<h3 class='box-title style='font-size: 14px; color: #3c8dbc; font-weight: bold; text-align: justify;'>Interacciones Medicamentosas</h3>"+
				" <div class='box-body'>";
					if( itemIM.InteractionSubstances.length>0 || itemIM.PharmacologicalGroups.length>0){
					
						conHTML += "<dl>"+
							"<dt>Sustancias con las que hace interacción :</dt>"+
							"<dd style='font-size: 11.5px;font-family: Verdana,Arial,sans-serif;'>"+itemIM.PISubstances+"</dd>"+
							"<dt>Grupos con los que hace interacción :</dt>"+
							"<dd style='font-size: 11.5px;font-family: Verdana,Arial,sans-serif;'>"+itemIM.PIGroups+"</dd>"+
							"<dt>Otras interacciones :</dt>"+
							"<dd style='font-size: 11.5px;font-family: Verdana,Arial,sans-serif;'>";
								$( itemIM.OtherInteractions ).each(function(o,other){
									conHTML += "<li>"+other.ElementName+"</li>";
								});
								conHTML += "</dd>"+
						"</dl>";
					}

					if( itemIM.InteractionSubstances.length>0 ){
						conHTML += "<div class='renglon' id='tableHeader'>"+
							"<div class='tab-5 head'>Sustancia Activa</div>"+
							"<div class='tab-5 head'>Medicamento</div>"+
							"<div class='tab-5 head'>Sustancia de Interacción</div>"+
							"<div class='tab-5 head'>Forma Farmacéutica</div>"+
							"<div class='tab-5 head'>Laboratorio</div>"+
						"</div>";
	
						$( itemIM.InteractionSubstances ).each(function(loop,tab){
							if( loop%2==0 ){
								conHTML += "<div class='renglon gris1' id='editable'>"+
									"<div class='tab-5 first'>"+tab.ActiveSubstance+"</div>"+
									"<div class='tab-5'>"+tab.IBrand+"</div>"+
									"<div class='tab-5'>"+tab.IActiveSubstance+"</div>"+
									"<div class='tab-5'>"+tab.IPharmaForm.toUpperCase()+"</div>"+
									"<div class='tab-5'>"+tab.IDivisionShortName+"</div>"+
								"</div>";
							}
							if( loop%2!=0 ){
								conHTML += "<div class='renglon' id='editable'>"+
									"<div class='tab-5 first'>"+tab.ActiveSubstance+"</div>"+
									"<div class='tab-5'>"+tab.IBrand+"</div>"+
									"<div class='tab-5'>"+tab.IActiveSubstance+"</div>"+
									"<div class='tab-5'>"+tab.IPharmaForm.toUpperCase()+"</div>"+
									"<div class='tab-5'>"+tab.IDivisionShortName+"</div>"+
								"</div>";
							}
						});
					}
					
					if( itemIM.PharmacologicalGroups.length>0 ){
						conHTML += "<div style='margin-top:3%;' class='renglon' id='tableHeader'>"+
							"<div class='tab-5 head'>Grupo Farmacológico</div>"+
							"<div class='tab-5 head'>Sustancia</div>"+
							"<div class='tab-5 head'>Medicamento</div>"+
							"<div class='tab-5 head'>Forma Farmacéutica</div>"+
						"</div>";
						$( itemIM.PharmacologicalGroups ).each(function(loop,tab){
							if( loop%2==0 ){
								conHTML += "<div class='renglon gris1' id='editable'>"+
									"<div class='tab-5 first'>"+tab.GroupName+"</div>"+
									"<div class='tab-5'>"+tab.IActiveSubstance+"</div>"+
									"<div class='tab-5'>"+tab.IBrand+"</div>"+
									"<div class='tab-5'>"+tab.IPharmaForm.toUpperCase()+"</div>"+
								"</div>";
							}
							if( loop%2!=0 ){
								conHTML += "<div class='renglon' id='editable'>"+
									"<div class='tab-5 first'>"+tab.GroupName+"</div>"+
									"<div class='tab-5'>"+tab.IActiveSubstance+"</div>"+
									"<div class='tab-5'>"+tab.IBrand+"</div>"+
									"<div class='tab-5'>"+tab.IPharmaForm.toUpperCase()+"</div>"+
								"</div>";
							}
						});
					}
				conHTML += "</div>"+
			"</div>";

		}
	});
	
	$("#body-content-prescription").html( conHTML );
}

function redirectIPPA( parameter ){
	var arrayP = parameter.split("&&");
	var json = {
		substances:arrayP[0].trim(),
		pharmacologicalGroup:arrayP[1].trim()
	};
	$.ajax({  
		type : "POST",   
		url:urlPath+"/descripcion-medicamento/"+arrayP[2].trim()+"/2",
		data:JSON.stringify( json ),
		contentType: 'application/json',
	 	mimeType: 'application/json',
		success : function(response) {
			console.log(response);
			window.location.href = urlPath+"/descripcion-medicamento/"+arrayP[2].trim()+"/2";
		},  
    	error : function(e) {  
    		
    		window.location.href = urlPath+"/descripcion-medicamento/"+arrayP[2].trim()+"/2";
    	}  
	});
}

function showDDI( btnDDI ){
	var conHTML = "";
	$( _listDDI ).each(function(d,itemDDI){
		if( itemDDI.IPPA==btnDDI ){
			conHTML +="<ul class='nav nav-tabs'>";
				$(_listIM).each(function(item,im){
					if( im.IPPA==btnDDI && (im.InteractionSubstances.length>0 || im.PharmacologicalGroups.length>0 ) )
						conHTML += "<li class='li-tab'><a class='panel-select' onClick='showIM(\""+btnDDI+"\")'><div class='tab-layout-IM' value='im-"+btnDDI+"'>Interacciones basadas en información del fabricante</div></a></li>";
				});
			conHTML +="<li class='active li-tab li-ddi'><a class='panel-select' onClick='showDDI(\""+btnDDI+"\")'><div class='tab-layout-DDI' value='ddi-"+btnDDI+"'>Interacciones basadas en evidencia</div></a></li>"+
			"</ul>"+

			"<div class='box box-solid prescription' value='ddi-"+itemDDI.CategoryId+"-"+itemDDI.DivisionId+"-"+itemDDI.ProductId+"-"+itemDDI.PharmaFormId+"'>"+

				"<div class='box-header with-border' style='background-color: #3a6f9f; color: white;'>"+
					"<h3 class='box-title' style='float:left;font-weight:700;'>"+itemDDI.Brand+
						"<span style='font-style:italic;'> "+itemDDI.PharmaForm+"</span></h3>"+
				"</div>"+
				"<h3 class='box-title' style='font-size: 14px; color: #3c8dbc; font-weight: bold; text-align: justify;'>Interacciones Basadas en evidencia</h3>"+
				
				"<div class='box-body'>"+
					"<dl class='dl-horizontal'>";
						$( itemDDI.InteractionSubstances ).each(function(i,ddi){
							$(ddi.Severities).each(function(s,sev){

								conHTML += "<dt style='text-align:center;white-space: normal;font-family: Verdana,Arial,sans-serif;font-size: 12px;'>"+
									ddi.ActiveSubstance +"-"+ ddi.IActiveSubstance+"<br/>";
									if( sev.ColorSemaphore=="Rojo" ){
										conHTML += "<i class='fa fa-circle text-red'></i>"+
										"<br />"+
										sev.IMDDISeverityLevel+"<br/>"+
										sev.ColorSemaphore;
									}
									if( sev.ColorSemaphore=="Amarillo" ){
										conHTML += "<i class='fa fa-circle text-yellow'></i>"+
										"<br />"+
										sev.IMDDISeverityLevel+"<br/>"+
										sev.ColorSemaphore;
									}
									if( sev.ColorSemaphore=="Gris" ){
										conHTML += "<i class='fa fa-circle'></i>"+
										"<br />"+
										sev.IMDDISeverityLevel+"<br/>"+
										sev.ColorSemaphore;
									}
									if( sev.ColorSemaphore=="Negro" ){
										conHTML += "<i class='fa fa-circle text-black'></i>"+
										"<br />"+
										sev.IMDDISeverityLevel+"<br/>"+
										sev.ColorSemaphore;
									}
									if( sev.ColorSemaphore=="Verde" ){
										conHTML += "<i class='fa fa-circle text-green'></i>"+
										"<br />"+
										sev.IMDDISeverityLevel+"<br/>"+
										sev.ColorSemaphore;
									}
									if( sev.ColorSemaphore=="Blanco" ){
										conHTML += "<i class='fa fa-circle'></i>"+
										"<br />"+
										sev.IMDDISeverityLevel+"<br />"+
										sev.ColorSemaphore;
									}
									conHTML += "</dt>"+
								"<dd class='dd-prescription'>";
									$(sev.IMDDIReferences).each(function(loop,ddiReference){
										conHTML += "<li>";
										ddiReference.ClinicalReference = ddiReference.ClinicalReference.replace(ddiReference.ReferenceSource,'');
										conHTML += ddiReference.ClinicalReference;
										conHTML += "<br/>"+
											"<a href='"+ddiReference.ReferenceSource+"' target='_blank'>"+
												ddiReference.ReferenceSource+
											"</a>"+
											"<br>"+
										"</li>";
										
									});
									conHTML += "</dd>"+
								"<hr style='border-top: 2px solid #3c8dbc;'>";
							});
						});
						conHTML += "</dl>"+
				"</div>"+
			"</div>";
		}		
	});
	$("#body-content-prescription").html( conHTML );
}

function showIMA( btnIMA ){
	console.log( btnIMA );
	var conHTML = "";
	$( _listIMA ).each(function(loop,itemBrand){
		
		$(itemBrand.Products).each(function(p,productIma){
			if(btnIMA==productIma.IPPA){
				conHTML += "<div class='box box-primary prescription'"+
					" value='ima-"+productIma.CategoryId+"-"+productIma.DivisionId+"-"+productIma.ProductId+"-"+productIma.PharmaFormId+"'>"+
					"<div class='box-header with-border'"+
						"style='background-color: #3a6f9f; color: white;'>"+
						"<h3 class='box-title' style='float:left;font-weight:700;'>"+productIma.Brand+
							"<span style='font-style:italic;'> "+productIma.PharmaForm+"</span></h3>"+
					"</div>"+
					"<h3 class='box-title' style='font-size: 14px; color: #3c8dbc; font-weight: bold; text-align: justify;'> Interacciones Medicamento-Alimento </h3>"+
					
					"<div class='box-body'>";
						$( itemBrand.MealInteractions ).each(function(m,meal){
	
							conHTML += "<dl class='dl-horizontal'>"+
								"<dt style='text-align:center;white-space: normal;font-family: Verdana,Arial,sans-serif;font-size: 12px;'>"+
									"<span>"+itemBrand.Description+"</span><br /> <span>"+meal.MealElementDescription+"</span>"+
									"<br /> <span>"+meal.Severity.IMASeverity+"</span><br />";
									if( meal.Severity.IMASeverity == "Verde"            || 
										meal.Severity.IMASeverity == "Verde|Sugerencia" ||
										meal.Severity.IMASeverity == "Verde|Espaciar"
									){
										conHTML += "<i class='fa fa-circle text-green'></i>";
									}
									if( meal.Severity.IMASeverity=="Rojo" ){
										conHTML += "<i class='fa fa-circle text-red'></i>";
									}
	
								conHTML += "</dt>"+
								"<dd class='dd-prescription'>"+
									meal.ClinicalSummary+
									"<hr><ul>";
									$( meal.ClinicalReferences ).each(function(r,references){
	
										conHTML += "<li><a href='"+references.ReferenceSource+"' target='_blank'>"+
											"<h6 style='font-family: Verdana,Arial,sans-serif;font-size: 11px;'>"+references.ClinicalReference+"</h6>"+
										"</a></li>";
									});
									conHTML += "</ul></dd>"+
							"</dl>"+
							"<hr style='border-top: 2px solid #3c8dbc;'>";
						});
						conHTML += "</div>"+
	
				"</div>";
			}
		});

	});
	$("#body-content-prescription").html( conHTML );
}

function showCON( btnCON ){
	var conHTML = "";
	$( _listCON ).each(function(c,con){
		if( con.IPPA==btnCON ){
			conHTML += "<div class='box box-primary prescription'"+
							"value='con-"+con.CategoryId+"-"+con.DivisionId+"-"+con.ProductId+"-"+con.PharmaFormId+"'>"+
	
						"<div class='box-header with-border' style='background-color: #3a6f9f; color: white;'>"+
							"<h3 class='box-title' style='float:left;font-weight:700;'>"+con.Brand+
							"<span style='font-style:italic;'> "+con.PharmaForm+"</span></h3>"+
							"<a style='padding: 0.3% 0.9%;float:left;margin-left:3%;margin-bottom:0;background-color: #1c8fc7; height: 23px; color: white; border-color: transparent; font-weight: bold;margin-top:-5px;font-size:12px;' href='"+urlPath+"/descripcion-medicamento/"+con.DivisionId+"-"+con.CategoryId+"-"+con.ProductId+"-"+con.PharmaFormId+"/1'>IPPA</a>"+
						"</div>"+
			
						"<h3 class='box-title' style='font-size: 14px; color: #3c8dbc; font-weight: bold; text-align: justify;'>Contraindicaciones</h3>";
						
			$(con.ActiveSubstanceContraindications).each(function(i,itemCon){
				conHTML += "<div class='box-body' style='font-family:Verdana,Arial,sans-serif;'>"+

								"<h4 class='box-title' style='font-size:15px;color:#022e60;font-weight:bold;'>"+
									itemCon.Description+
								"</h4>"+
								"<div style='margin-left: 3%'>";
				
									if( itemCon.ICDContraindications.length>0 ){
										conHTML += "<h5 style='font-weight:bold;font-family:Verdana,Arial,sans-serif;'>CIE - 10</h5>";
										$(itemCon.ICDContraindications).each(function(e,icd){
											conHTML += "<li style='margin-left:3%;font-size: 11px;'>"+icd.SpanishDescription+"</li>";
										});
									}

									if( itemCon.PharmacologicalGroupContraindications.length>0 ){
										conHTML += "<h5 style='font-weight:bold;font-family:Verdana,Arial,sans-serif;'>GRUPO FARMACOLÓGICO</h5>";
										$(itemCon.PharmacologicalGroupContraindications).each(function(g,groupContraindications){
											conHTML += "<li style='margin-left:3%;font-size: 11px;'>"+groupContraindications.GroupName+"</li>";
										});
									}

									if( itemCon.PhysiologicalContraindications.length>0 ){
										conHTML += "<h5 style='font-weight:bold;font-family:Verdana,Arial,sans-serif;'>FISIOLÓGICAS</h5>";
										$(itemCon.PhysiologicalContraindications).each(function(p,physiologicalContraindications){
											conHTML += "<li style='margin-left:3%;font-size: 11px;'>"+physiologicalContraindications.PhysContraindicationName+"</li>";
										});
									}

									if( itemCon.HypersensibilityContraindications.length>0 ) {
										conHTML += "<h5 style='font-weight:bold;font-family:Verdana,Arial,sans-serif;'>HIPERSENSIBILIDAD</h5>";
										$(itemCon.HypersensibilityContraindications).each(function(h,hypersensibilityContraindications){
											conHTML += "<li style='margin-left:3%;font-size: 11px;'>"+hypersensibilityContraindications.HypersensibilityName+"</li>";
										});
									}
									conHTML += "</div>"+
								"<hr style='border-top: 2px solid #3c8dbc;'>"+
							"</div>";
			});
			
			conHTML += "</div>";
		}
	});
	
	$("#body-content-prescription").html( conHTML );
}


function showPregnancy( btnPregnancy ){
	var conHTML = "";
	$( _listPregnancyRiskDrugs ).each(function(p,pregnancy){
		if( pregnancy.IPPA==btnPregnancy ){
			console.log( pregnancy );
			
			conHTML += "<div class='box box-primary prescription'"+
					" value='ima-"+pregnancy.CategoryId+"-"+pregnancy.DivisionId+"-"+pregnancy.ProductId+"-"+pregnancy.PharmaFormId+"'>"+
					"<div class='box-header with-border'"+
						"style='background-color: #3a6f9f; color: white;'>"+
						"<h3 class='box-title' style='float:left;font-weight:700;'>"+pregnancy.Brand+
						"<span style='font-style:italic;'> "+pregnancy.PharmaForm+"</span></h3>"+
					"</div>"+
					"<h3 class='box-title' style='font-size: 14px; color: #3c8dbc; font-weight: bold; text-align: justify;'> Riesgo en el Embarazo </h3>";
				conHTML += "<div class='box-body'>";
				$(pregnancy.SubstancePregnancyRisks).each(function(i,itemPregnancy){
					conHTML += "<div style='width:100%;text-align:center;white-space: normal;font-family: Verdana,Arial,sans-serif;font-size: 12px;font-weight: 700;margin-bottom: 2%;'>"+itemPregnancy.Description+"</div>"+
					"<dl class='dl-horizontal'>";
					$(itemPregnancy.PregnancyRisks).each(function(r,risk){
					
						conHTML += "<dt style='text-align: center;margin-top: 2%;'>"+risk.FDAPregnancyCategory.FDAPregnancyCategory+
										" <i class='fa fa-circle text-yellow'></i><br/>";
										if(risk.PregnancyPeriod!=null)
											conHTML += "<b>Periodo: </b>"+risk.PregnancyPeriod.PregnancyPeriod;
										conHTML += "<dd class='dd-prescription'>"+
											"<b>Riesgo: </b>"+risk.FDAPregnancyCategory.Risk+
											"<hr>"+
										"</dd>"+
										"<dd class='dd-prescription'>"+
											"<b>Justificación:</b> "+risk.FDAPregnancyCategory.Justify+
											"<hr>"+
										"</dd>"+
										
									"</dt>";
						
					});
					conHTML += "<small>Fuente <cite title='Fuente FDA'>\"FDA\"</cite></small></dl><hr style='border-top: 2px solid #3c8dbc;'>";
				});
				conHTML += "</div>";
			conHTML += "</div>";
			
		}
	});
	$("#body-content-prescription").html( conHTML );
}

function showDDD( btnIPPA ){
	var conHTML = "";
	$( _listDDD ).each(function(loop,ddd){
		if( ddd.IPPA==btnIPPA ){
			console.log( ddd );
			
			
			conHTML += "<div class='box box-primary prescription'"+
			" value='ima-"+ddd.CategoryId+"-"+ddd.DivisionId+"-"+ddd.ProductId+"-"+ddd.PharmaFormId+"'>"+
			"<div class='box-header with-border'"+
				"style='background-color: #3a6f9f; color: white;'>"+
				"<h3 class='box-title' style='float:left;font-weight:700;'>"+ddd.Brand+
				"<span style='font-style:italic;'> "+ddd.PharmaForm+"</span></h3>"+
			"</div>"+
			"<h3 class='box-title' style='font-size: 14px; color: #3c8dbc; font-weight: bold; text-align: justify;'> Dosis Diaria Definida </h3>";
			conHTML += "<div class='box-body'>";
			$(ddd.DDDSubstances).each(function(loop,substance){
				conHTML += "<dl><dt>"+substance.Description+"</dt>";
				$(substance.DDDSubstanceTherapeutics).each(function(s,admin){
					conHTML += "<dd>"+admin.AdministrationRoute.RouteName+"/"+admin.Quantity+" "+admin.DosageUnit.DosageUnit+"</dd>";
				});
			});
			
			
			conHTML+="<dd style='font-size: 11.5px;font-family: Verdana,Arial,sans-serif;'>"+
			"La dosis diaria definida es una medida que se usa para fines de investigación en la comparación de la utilización de medicamentos. Es la dosis promedio de mantenimiento diario para cualquier medicamento que se usa para su indicación principal en adultos."+
			"</dd>" +
			"</dl>"+
			"<small>Fuente <cite title='Fuente OMS'>\"OMS\"</cite></small>"+
			"</div>";
		}
	});
	$("#body-content-prescription").html( conHTML );
	
}

function showIFQ( btnIPPA ){
	var conHTML = "";
	$(_listIncompatibilities).each(function(loop,incompatibilities){
		if( incompatibilities.IPPA==btnIPPA ){
			conHTML += "<div class='box box-primary prescription'"+
				" value='ima-"+incompatibilities.CategoryId+"-"+incompatibilities.DivisionId+"-"+incompatibilities.ProductId+"-"+incompatibilities.PharmaFormId+"'>"+
				"<div class='box-header with-border'"+
					"style='background-color: #3a6f9f; color: white;'>"+
					"<h3 class='box-title' style='float:left;font-weight:700;'>"+incompatibilities.Brand+
					"<span style='font-style:italic;'> "+incompatibilities.PharmaForm+"</span></h3>"+
				"</div>"+
				"<h3 class='box-title' style='font-size: 14px; color: #3c8dbc; font-weight: bold; text-align: justify;'> Incompatibilidades Físico Químicas </h3>";
				conHTML += "<div class='box-body'>"+
				"<div class='renglon' id='tableHeader'>"+
					"<div class='tab-5 head'>Sustancia</div>" +
					"<div class='tab-5 head'>Sustancia/Marca</div>" +
					"<div class='tab-5 head'>Tipo</div>"+
				"</div>";
				$(incompatibilities.SubstanceIncompatibilities).each(function(index,substance){
					$(substance.IncompatibilitySubstances).each(function(item,is){
						conHTML += "<div class='renglon gris1' id='editable'>"+
						"<div class='tab-5 first'>"+substance.Description+"</div>"+
						"<div class='tab-5'>"+is.Description+"<ul>";
						$(is.IncompatibilityProducts).each(function(i,ip){
							conHTML += "<li style='padding-top: 5px'>"+
							"<strong style='font-style: italic;font-size:10px;color:#662e6b'>"+ip.Brand + "</strong> <br/></li>";
						});
						conHTML += "</ul></div>"+
						"<div class='tab-5'><ul style='list-style: none;'>";
						$(is.Incompatibilities).each(function(c,ic){						
							conHTML += "<li>"+ic.IncompatibilityType.IncompatibilityName+"</li>";
							if(ic.Incompatibility.ShortName=='V')
								conHTML += "<i class='fa fa-circle text-yellow'></i>";
							else if(ic.Incompatibility.ShortName=='C')
								conHTML += "<i class='fa fa-circle text-green'></i>";
							else
								conHTML += "<i class='fa fa-circle text-red'></i>";
							conHTML += "<li>"+ic.Incompatibility.IncompatibilityName+"</li>";
						});
						conHTML += "</ul></div>"+
						"</div>";
					});
				});
				
				"</div>";
			conHTML += "</div>";	
		}
	});
	
	$("#body-content-prescription").html( conHTML );
	
}

function showDT( btnIPPA ){
	var conHTML = "";
	$(_listTherapeutic).each(function(t,therapeutic){
		if(btnIPPA==therapeutic.IPPA){
			conHTML += "<div class='box box-primary prescription'"+
			" value='ima-"+therapeutic.CategoryId+"-"+therapeutic.DivisionId+"-"+therapeutic.ProductId+"-"+therapeutic.PharmaFormId+"'>"+
			"<div class='box-header with-border'"+
				"style='background-color: #3a6f9f; color: white;'>"+
				"<h3 class='box-title' style='float:left;font-weight:700;'>"+therapeutic.Brand+
				"<span style='font-style:italic;'> "+therapeutic.PharmaForm+"</span></h3>"+
			"</div>"+
			"<h3 class='box-title' style='font-size: 14px; color: #3c8dbc; font-weight: bold; text-align: justify;'> Duplicidad Terapéutica </h3>";
			conHTML += "<div class='box-body'>";
			$(therapeutic.ATCOMSDoubleness).each(function(loop,atcCOM){
				console.log(atcCOM);
				conHTML += "<dl class='dl-horizontal'><dt style='text-align:center;white-space: normal;font-family: Verdana,Arial,sans-serif;font-size: 12px;'>"+
				"<span>Medicamentos</span><br>";
				$(atcCOM.ATCOMSDoublenessProducts).each(function(p,products){
					conHTML += "<span>"+products.Brand+"</span><br> ";
				});
				conHTML += "</dt>"+
				"<dd class='dd-prescription'>ATC (OMS)"+
				"<hr><ul><li>"+
				"<h6 style='font-family: Verdana,Arial,sans-serif;font-size: 11px;'>"+
				
				"<b>"+atcCOM.TherapeuticKey+"</b> "+atcCOM.SpanishDescription+", podría tratarse de una duplicidad terapéutica.";
				
				"</h6></li></ul></dd></dl>";
			});
			conHTML += "</div>";
		}
	});
	$("#body-content-prescription").html( conHTML );
}

function deleteRenglon( btnIPPA ){
	var json = {IPPA:btnIPPA};
	var listInteractions = [];
	$(".loader-interactions").show();
	$.when( prescription.removeProductsCheck(json )).done(function( listResponse ){
		$("#loaderView").fadeIn();
		
		
		$(listResponse.selectedDrugs).each(function(item,product){
			listInteractions.push({"CategotyId":product.CategotyId,"DivisionId":product.DivisionId,"PharmaFormId":product.PharmaFormId,"ProductId":product.ProductId});
		});
		sendMessage( listInteractions );
		if( listResponse.selectedDrugs!=null ){	
			$("#loaderView").fadeOut();
			$("#body-content-prescription").empty();
			_createGridPrescriptions();
		}else{
			window.location.href=urlPath+"/home";
		}
	});
}


//Eliminar Todos los medicamentos
$("#glyphicon-delete-all").click(function(){
	$.when(prescription.removeAllProducts()).done(function( response ){
		if( response )
			window.location.href=urlPath+"/home";
	});
});

