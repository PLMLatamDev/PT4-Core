var drugsArray = null;
$(function () {
	$("#datepicker").datepicker({
	    changeMonth: true,
	      changeYear: true,
	      dateFormat: 'dd/mm/yy',
	      yearRange: '1900:_date.getFullYear()',
	      onSelect: function() {
              $(this).change();
              $('#formReport').formValidation('revalidateField', 'birthday');
            }

	}).on('changeDate', function(e) {// Revalidate the date field
      
       $('#formReport').formValidation('revalidateField', 'birthday');
//      $('#crecimiento').formValidation('revalidateField', 'birthday');
	});
	
	
	$(".tableresponsiveStackable").stacktable();
	
	
    $('#formReport').formValidation({
    	framework: 'bootstrap',
//        icon: {
//            valid: 'glyphicon glyphicon-ok',
//            invalid: 'glyphicon glyphicon-remove',
//            validating: 'glyphicon glyphicon-refresh'
//        },
        fields: {
            name: {
                validators: {
                    notEmpty: {
                        message: 'Campo requerido'
                    }
                }
            },
            lastname: {
                validators: {
                    notEmpty: {
                        message: 'Campo requerido'
                    }
                }
            },
            weigth: {
                validators: {
                    numeric: {
                        message: 'Numero incorrecto.',
                        thousandsSeparator: '',
                        decimalSeparator: '.'
                    }
                }
            },
            heigth: {
                validators: {
                	callback: {
                        message: 'Estatura incorrecto',
                        callback: function(value, validator) {
                        	if(value.indexOf(".")!= -1){
                                value = value.trim();
                                var integers = value.split(".");
                                if(integers.length>1){
                                      var lista = integers.length;
                                            for(var i = 0; i<lista; i++){
                                            	if(i == 0){
                                            		if(integers[i].length>1){
                                            			return false;
                                            		}
                                            	}
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
        
        var expedient  = $("input[name=expedient]").val();
        var patientName = $("input[name=name]").val();
        var patientLastName = $("input[name=lastname]").val();
        var weigth = $("input[name=weigth]").val(); 
        var heigth = $("input[name=heigth]").val();
        var birthday = $("input[name=birthday]").val();
        var comments = $("textarea[name=comments]").val();
        
        myDate = new Date(birthday);
        var f1 = myDate.getTime();

        if(myDate=="Invalid Date"){
           
            var date=   birthday; // Fecha
            var daux=date.split("/");
            fgo=daux[1]+","+daux[0]+","+daux[2]; 
            d1 = new Date(''+fgo+'');

             var n1 = d1.toLocaleDateString();
             var f1 = d1.getTime();

         }
        
        var goSave={"EditionId":0,
                "CountryId":0,
                "Products":[],
                "Comments":''+comments+''
              };
        for(var i = 0; i<drugsArray.length;i++){
        	goSave.Products.push({

                'CategotyId': drugsArray[i].CategotyId,
                'DivisionId': drugsArray[i].DivisionId,
                'ProductId': drugsArray[i].ProductId,
                'PharmaFormId': drugsArray[i].PharmaFormId,
                'CategoryName':"",
                'DivisionName':drugsArray[i].DivisionName,
                'PharmaForm': drugsArray[i].PharmaForm,
                'Brand': drugsArray[i].Brand,
                'PresentationId':drugsArray[i].PresentationId,
                'Presentation':drugsArray[i].Presentation,
                'Substances':drugsArray[i].Substance,
                'IPP':drugsArray[i].DivisionId+'-'+drugsArray[i].CategotyId+'-'+drugsArray[i].ProductId+'-'+drugsArray[i].PharmaFormId+'-'+drugsArray[i].PresentationId,
                'IPPA':drugsArray[i].IPPA
                      
            });
        }
        
        var bookData = {
                "Birthday":"\/Date("+f1+")\/",
                "Expedient":expedient,
                "Height":heigth,
                "JsonContent":""+JSON.stringify(goSave)+"",
                "PatientLastName":patientLastName,
                "PatientName":patientName,
                "Weight":weigth,
              }; 
        
        
        url = "/reporte/save";
      	$.ajax({
				url : urlPath+url,
				type : "POST",
				data : JSON.stringify(bookData),
				contentType: 'application/json',
				success : function(response) {
					if(response == true){
						alertify.success("¡Reporte guardado satisfactoriamente.!");
						$('#modalClinicHistoryPDF').modal('show');
//						window.location.href=urlPath+"/reporte/imprimir/reporte-clinico";
					}
				},  
		    	error : function(e) {  
		    		alertify.error("¡Error al guardar reporte.!"); 
		    	} 
      	});

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
    	$("#modal-body-content-pdf" ).append('<iframe name="abc_frame" id="abc_frame" src='+urlPath+"/reporte/imprimir/reporte-clinico"+' width="100%" height="540" ></iframe>');
    	

    	 	});
    	 	
    	 	$('#modalClinicHistoryPDF').on('hidden.bs.modal', function () {
    	 		
    	 	

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
			setDrugs(drug);				
		},  
   	error : function(e) {  
   		console.log('Error: ' + e);
   	}  
	});
}

function setDrugs(drugs){
	drugsArray = drugs;
}
initPrescripcion(); 