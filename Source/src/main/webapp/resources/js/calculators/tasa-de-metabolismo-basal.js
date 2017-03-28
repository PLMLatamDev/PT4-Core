$(document).ready(function() {
	
    $('#metabolismo').formValidation({
    	framework: 'bootstrap',
//        icon: {
//            valid: 'glyphicon glyphicon-ok',
//            invalid: 'glyphicon glyphicon-remove',
//            validating: 'glyphicon glyphicon-refresh'
//        },
        fields: {
        	peso: {
                validators: {
                	notEmpty: {
                        message: 'Campo requerido'
                    },
                    numeric: {
                        message: 'Numero incorrecto.',
                        thousandsSeparator: '',
                        decimalSeparator: '.'
                    }
                }
            },
            talla: {
	            validators: {
	            	notEmpty: {
	                    message: 'Campo requerido'
	                },
	                numeric: {
	                    message: 'Numero incorrecto.',
	                    thousandsSeparator: '',
	                    decimalSeparator: '.'
	                }
	            }
	        },
	        edad: {
	            validators: {
	            	notEmpty: {
	                    message: 'Campo requerido'
	                },
	                numeric: {
	                    message: 'Numero incorrecto.',
	                    thousandsSeparator: '',
	                    decimalSeparator: '.'
	                }
	            }
	        },
	        sexo: {
	            validators: {
	            	notEmpty: {
	                    message: 'Campo requerido'
	                },
	                
	            }
	        }
        }
    }).on('success.form.fv', function(e) {
    	// Prevent form submission
        e.preventDefault();

        var result = null;
        var resultText = null;
        var peso = parseFloat($("input[name=peso]").val());
        var edad = parseFloat($("input[name=edad]").val());
        var talla = parseFloat($("input[name=talla]").val());
        var sex = $("input[name=sexo]:checked").val();


       

        /*
        Hombres: TMB = 66 + [13.7 x P (kg)] + [5 x T (cm)] - [6.8 x edad (aÃ±os)]
                     =+(66+(13.7*F56))+(5*F57)-(6.8*F58)

        Mujeres: TMB = 655 + [9.6 x P (kg)] + [1.8 x T (cm)] - [4.7 x edad (aÃ±os)]                             
                     =+(655+(9.6*F63))+(1.8*F64)-(4.7*F65)
    */


    if (sex == 'F') {
        //TMB = 655 + [9.6 x P (kg)] + [1.8 x T (cm)] - [4.7 x edad (aÃ±os)]                             
        result = (655 + (9.6 * peso)) + (1.8 * talla) - (4.7 * edad);
    }
    else {
        //TMB = 66 + [13.7 x P (kg)] + [5 x T (cm)] - [6.8 x edad (aÃ±os)]
        result = (66 + (13.7 * peso)) + (5 * talla) - (6.8 * edad);
    }

    result = Math.round(result * 100) / 100;
        
        
        $("#metabolismoresultado").text(result);
        
        
        $("#resultContent").show();
        

    });
    
});