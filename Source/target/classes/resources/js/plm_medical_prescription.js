var drugsArray = null;

$(function () {
	
	
//	$("#datepicker").datepicker({
//		format: 'dd/mm/yyyy',
//		autoclose: 1,
//		lenguage:'es',
//		forceParse: 0
//    }).on('changeDate', function(e) {// Revalidate the date field
//        
//        $('#formPrescription').formValidation('revalidateField', 'birthday');
//        $('#crecimiento').formValidation('revalidateField', 'birthday');
//    });
	
	var _date = new Date();
	
	$("#datepicker").datepicker({
	    changeMonth: true,
	      changeYear: true,
	      dateFormat: 'dd/mm/yy',
	      yearRange: '1900:_date.getFullYear()',
	      onSelect: function() {
	    	    $(this).change();
	    	    $('#formPrescription').formValidation('revalidateField', 'birthday');
	    	  }
	}).on('changeDate', function(e) {// Revalidate the date field
      
      $('#crecimiento').formValidation('revalidateField', 'birthday');
	});
	
	$("#newPrescripcion").click(function(){
		deleteAllDrugs();
	});
	
	

	$('#attributeForm').formValidation();
	
        $('#formPrescription').formValidation({
    	framework: 'bootstrap',
//        icon: {
//            valid: 'glyphicon glyphicon-ok',
//            invalid: 'glyphicon glyphicon-remove',
//            validating: 'glyphicon glyphicon-refresh'
//        },
        fields: {
//        	expedient: {
//                validators: {
//                    notEmpty: {
//                        message: 'Campo requerido'
//                    }
//                }
//            },
            name: {
                validators: {
                    notEmpty: {
                        message: 'Campo requerido'
                    }
                }
            },
            apellidos: {
                validators: {
                    notEmpty: {
                        message: 'Campo requerido'
                    }
                }
            },
					            peso : {
						validators : {
							numeric : {
								message : 'Numero incorrecto.',
								thousandsSeparator : '',
								decimalSeparator : '.'
							}
						}
					},
					talla : {
						validators : {
							numeric : {
								message : 'Numero incorrecto.',
								thousandsSeparator : '',
								decimalSeparator : '.'
							}
						}
					},
					fc : {
						validators : {
							numeric : {
								message : 'Numero incorrecto.',
								thousandsSeparator : '',
								decimalSeparator : '.'
							}
						}
					},
					fr : {
						validators : {
							numeric : {
								message : 'Numero incorrecto.',
								thousandsSeparator : '',
								decimalSeparator : '.'
							}
						}
					},
					pa : {
						validators : {
							callback: {
		                    	message: 'Presión arterial incorrecto',
		                        callback: function(value, validator) {
		                        	if(value.indexOf("/")!= -1){
		                        		value = value.trim();
		                        		var integers = value.split("/");
		                        		if(integers.length>1){
		                        			var lista = integers.length;
		                        				for(var i = 0; i<lista; i++){
		                        					var expresion = new RegExp("[0-9]");
		                        					if( !expresion.test(integers[i]) ){
		                        						return false;
		                        					}
		                        			   }
		                        				return true;
		                        		}else{
		                        			return false;
		                        		}
		                        	}else if(value.length==0){
		                        		return true;
		                        	}else{
		                        		
		                        		return false;
		                        	}
		                        }
		                    }
						}
					},
//					sexo : {
//						validators : {
//							notEmpty : {
//								message : 'Campo requerido'
//							}
//						}
//					},
					idx : {
						validators : {
							stringLength : {
								max : 800,
								min : 1,
								message : 'maximo de caracteres superado'
							}
						}
					},
            birthday	: {
                validators: {
                    notEmpty: {
                        message: 'Campo requerido'
                    },
                    date: {
                        format: 'DD/MM/YYYY',
                        message: 'fecha no valida'
                    }
                }
            }
        }
        
        }).on('success.form.fv', function(e) {
    	// Prevent form submission
        e.preventDefault(); 
// $('#attributeForm').formValidation('validateField', 'dosis')
// .formValidation('validateField', 'administracion')
// .formValidation('validateField', 'duracion');
       var stopProcess = false;
        $("#attributeForm").find(':input').each(function() {
            var elemento= this;
           if($("#"+elemento.id).length>0){
            
            if($("#"+elemento.id).val().length!= undefined&&$("#"+elemento.id).val().length==0){
            	console.log("true");
            	$("#"+elemento.id).css("border-color", "red");
            	stopProcess = true;
            }else{
            	$("#"+elemento.id).css("border-color", "#d2d6de");
            }
        }
           // console.log("elemento.id="+ elemento.id + ", elemento.value=" + elemento.value); 
           });
       if(stopProcess == false){
    	   $("#loaderView").fadeIn();
        var $form =  $(e.target).data('formValidation');
        var button = $form.$submitButton[0].id;
        var url = null;
//        var expedient = $("input[name=expedient]").val();
        var expedient = "";
        var name = $("input[name=name]").val();
        var lastname = $("input[name=apellidos]").val();
        var weight = $("input[name=peso]").val();
        var height = $("input[name=talla]").val();
        var heartRate  = $("input[name=fc]").val();
        var respiratoryRate = $("input[name=fr]").val();
        var bloodPressure = $("input[name=pa]").val();
        var gender = $("input[name=sexo]:checked").val();
        var idx = $("textarea[name=idx]").val();
        var Birthdays = $("input[name=birthday]").val();
        var toDay = new Date();
        var ReportDate= toDay.getTime();
        
        var myDate = new Date(Date.parse(Birthdays));
        if(myDate=="Invalid Date"){
            
            var date=   Birthdays;
            var daux=date.split("/");
            fgo=daux[1]+","+daux[0]+","+daux[2]; 
            d1 = new Date(''+fgo+'');

             var n1 = d1.toLocaleDateString();
             var formatBirthday = d1.getTime();

         }else{
        	 var formatBirthday = myDate.getTime();
         }
        
 
       
        var productJson={
                "Products":[],
                "Recommendations": $("textarea[name=Recommendations]").val(),
                "Idx":idx
              }; 
      console.log("sustancias");
        console.log(drugsArray);
        for(var i = 0; i<drugsArray.length;i++){
        	
        	drugsArray[i].PresentationId = 2;
        	
        	productJson.Products.push({

                'CategotyId': drugsArray[i].CategotyId,
                'DivisionId': drugsArray[i].DivisionId,
                'ProductId':drugsArray[i].ProductId,
                'PharmaFormId': drugsArray[i].PharmaFormId,
                'CategoryName':"",
                'DivisionShortName':"",
                'PharmaForm': drugsArray[i].PharmaForm,
                'Brand': drugsArray[i].Brand,
                'PresentationId':drugsArray[i].PresentationId,
                'Presentation':drugsArray[i].Presentation,
                'Substances':drugsArray[i].Substance,
                'Dose':$("#dosis-"+drugsArray[i].IPPA).val(),
                'AdministrationRoute':$("#administracion-"+drugsArray[i].IPPA).val(),
                'Time':$("#duracion-"+drugsArray[i].IPPA).val(),
                'IPP':drugsArray[i].DivisionId+'-'+drugsArray[i].CategotyId+'-'+drugsArray[i].ProductId+'-'+drugsArray[i].PharmaFormId+'-'+drugsArray[i].PresentationId,
                'IPPA':drugsArray[i].IPPA
                      
            });
        }
        if(gender==1){
        	gender = "M";
        }else{
        	gender = "F";
        }
        
        
        

        var bookData = {
                            	"Active": true,
                            	"Birthday": "\/Date("+formatBirthday+")\/",
                            	"BloodPressure": ""+bloodPressure+"",
                            	"ClientId": 0,
                            	"CodeId": 0,
                            	"DeviceId": 0,
                            	"Expedient": expedient,
                            	"Gender": gender,
                            	"HeartRate": heartRate,
                            	"Height": height,
                            	"JSONContent": ""+JSON.stringify(productJson)+"",
                            	"Months": 0,
                            	"PatientLastName": lastname,
                            	"PatientName": name,
                            	"ReportDate": "\/Date("+ReportDate+")\/",
                            	"ReportId": 0,
                            	"RespiratoryRate": respiratoryRate,
                            	"TargetId": 0,
                            	"Weight": weight,
                            	"Years": 0
                            
                          };  


                          console.log(JSON.stringify(bookData));

                          	url = "/receta/guardar";
                          	$.ajax({
              					url : urlPath+url,
              					type : "POST",
              					data : JSON.stringify(bookData),
              					contentType: 'application/json',
              					success : function(drug) {
              						$("#loaderView").fadeOut();
              						if(drug==true){
              							
              							alertify.success("¡Receta guardada satisfactoriamente.!");
              						}else{
              							
              							alertify.error("¡Error al guardar receta.!"); 
              						}
              					},  
              			    	error : function(e) {  
              			    		alertify.error("¡Error al guardar receta.!"); 
              			    	} 
                          	});
                          	url = "/receta/imprimir";
                          	$.ajax({  
                	    		type : "POST",   
                				url:urlPath+url,   
                				data : JSON.stringify(bookData),
                				contentType: 'application/json',
       	            	 	    //mimeType: 'application/json', 
                				success : function(data) {
                					$("#loaderView").fadeOut();
                					$('#modalClinicHistoryPDF').modal('show');
//                					 window.location.href=urlPath+"/receta/pdf";
                				},  
                		    	error : function(e) {  
                		    		console.log( e);
                		    		
                		    		
                		    	}  
                			});

  

                          

        }

			}).on('success.field.fv', function(e, data) {
	            // e, data parameters are the same as in err.field.fv event handler
	            // Despite that the field is valid, by default, the submit button will be disabled if all the following conditions meet
	            // - The submit button is clicked
	            // - The form is invalid
	            data.fv.disableSubmitButtons(false);
	        });
$('#modalClinicHistoryPDF').on('show.bs.modal', function(e) {
	$('#modalPrescriptionPDF').modal('show');
	 $('#modalPrescriptionPDF').modal({backdrop:'static'});
	 $("#modal-body-content-pdf iframe" ).remove();
	 $('#modalPrescriptionPDF').modal('show')
	$("#modal-body-content-pdf" ).append('<iframe name="abc_frame" id="abc_frame" src='+urlPath+"/receta/pdf"+' width="100%" height="540" ></iframe>');
	

	 	});
	 	
	 	$('#modalClinicHistoryPDF').on('hidden.bs.modal', function () {
	 		
	 	

	 	});
	  
	
	 	$("#btn-close-prescription").click(function(){
	 		deleteAllDrugs();
	 		window.location.href= urlPath;
	 	});
});



	
        function initPrescripcion(){
        	 $.ajax({  
	    		type : "GET",   
				url:urlPath+"/EnginePrescription/getSelectedDrugs",   
				contentType: 'application/json',
	   	 	    mimeType: 'application/json',
				success : function(response) {
					var drug = response.selectedDrugs;
					if(drug==null){
						
		        		window.location.href=urlPath+"/";
		        		
		        	}
					console.log(drug);
					//console.log(drug);
					 var html = "";
						if(drug.length > 0){
					for (var i = 0; i<drug.length;i++) {
			        	  if(i == 0){
			        		  html +=getHtml(drug, i);
			        	    $("#attributeForm").html(html);
			        	  }else{
			        		  html =getHtml(drug, i);
			        	    $("#attributeForm").append(html);
			        	  }
			        	                
			           }
					
				}else{
	        		 $("#attributeForm").html("");
	        	 }
						
				},  
		    	error : function(e) {  
		    		console.log('Error: ' + e);
		    	}  
			});
        }
        
        function deleteDrug(IPPA){
        	//console.log(IPPA);
        	
        	$.ajax({  
        		type : "GET",   
    			url:urlPath+"/EnginePrescription/deleteSelectedDrugs/"+IPPA,   
    			contentType: 'application/json',
       	 	    mimeType: 'application/json',
				success : function(response) {
					console.log(response);
					var listInteractions = [];
					
					var drug = response.selectedDrugs;
					if(drug==null){
						
		        		window.location.href=urlPath+"/";
		        		
		        	}
					$(response.selectedDrugs).each(function(item,product){
						listInteractions.push({"CategotyId":product.CategotyId,"DivisionId":product.DivisionId,"PharmaFormId":product.PharmaFormId,"ProductId":product.ProductId});
				});
				
				sendMessage(listInteractions);
					 var html = "";
					if(drug.length > 0){
        	 for (var i = 0; i<drug.length;i++) {

        	  if(i == 0){
        		  html +=getHtml(drug, i);
        	    $("#attributeForm").html(html);
        	  }else{
        		  html =getHtml(drug, i);
        	    $("#attributeForm").append(html);
        	  }
        	                
           }
        	 
        	 }else{
        		 $("#attributeForm").html("");
        	 }
				},error : function(e) {  
		    		console.log('Error: ' + e);
		    	} 
        	});  
        }
        
        function deleteAllDrugs(){
        	$.ajax({  
        		type : "GET",   
    			url:urlPath+"/EnginePrescription/deleteAllSelectedDrugs",   
    			contentType: 'application/json',
       	 	    mimeType: 'application/json',
				success : function(drug) {
					 var html = "";
				
        		 $("#attributeForm").html(html);
        		 window.location.href=urlPath+"/";
        	
				},error : function(e) {  
		    		console.log('Error: ' + e);
		    	} 
        	}); 
        }
        
        function getHtml(drug, i){
        	
        	drugsArray = drug;
        	var html = "";
        	html ='  <div class="box-body box-profile">'+
            '<a style="cursor:pointer;" id="deleteDrug" onclick="deleteDrug(\''+drug[i].IPPA+'\')" class="pull-right"><i class="fa fa-times" style="color:red;"></i></a>'+
            '<h3 class="profile-username" style="color:red;">'+drug[i].Substance+'</h3>'+
            '<p class="text-muted " ><strong style="color:#1e5197;">'+drug[i].Brand+'</strong>&nbsp;&nbsp;<strong style="color:#fcbc09;">'+drug[i].Presentation+ '</strong></p>'+
             '<ul class="list-group list-group-unbordered">'+
              '<li class="list-group-item">'+
              '<div class="form-group">'+
         '<label>Dosis</label>'+
         '<input type="text" id="dosis-'+drug[i].IPPA+'" class="form-control" placeholder="" name="dosis'+i+'" data-fv-notempty="true" data-fv-notempty-message="Campo requerido">'+
    '</div>'+
    '<div class="form-group">'+
         '<label>Vía de Administración</label>'+
         '<input type="text" id="administracion-'+drug[i].IPPA+'" class="form-control" placeholder="" name="administracion'+i+'" data-fv-notempty="true" data-fv-notempty-message="Campo requerido">'+
    '</div>'+
    '<div class="form-group">'+
         '<label>Duración del tratamiento</label>'+
         '<input type="text" id="duracion-'+drug[i].IPPA+'" class="form-control" placeholder="" name="duracion'+i+'" data-fv-notempty="true" data-fv-notempty-message="Campo requerido"><br/>'+
    '</div>'+
                
            
                '</li>'+
             
            '</ul>'+
          '</div>';
        	return html;
        }
        
        function parseDate(myDate){
            var parts, date, time, dt, ms;

            parts = myDate.toString().split(/[T ]/); // Split on `T` or a space to get date and time
            date = parts[0];
            time = parts[1];

            dt = new Date();

            parts = date.toString().split(/[-\/]/);  // Split date on - or /
            dt.setFullYear(parseInt(parts[0], 10));
            dt.setMonth(parseInt(parts[1], 10) - 1); // Months start at 0 in JS
            dt.setDate(parseInt(parts[2], 10));

//            parts = time.toString().split("/:/");    // Split time on :
//            dt.setHours(parseInt(parts[0], 10));
//            dt.setMinutes(parseInt(parts[1], 10));
//            dt.setSeconds(parseInt(parts[2], 10));

            ms = dt.getTime();
            return ms;
        }
        
        initPrescripcion(); 
