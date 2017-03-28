$(document).ready(function() {
	
    $('#excrecionCreatinina').formValidation({
    	framework: 'bootstrap',
//        icon: {
//            valid: 'glyphicon glyphicon-ok',
//            invalid: 'glyphicon glyphicon-remove',
//            validating: 'glyphicon glyphicon-refresh'
//        },
        fields: {
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
            imc: {
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
        var imc = parseFloat($("input[name=imc]").val());
        var edad = parseFloat($("input[name=edad]").val());
        var sex = $("input[name=sexo]:checked").val();

        /*
        Mujeres: Exc_cre = (22 - Edad / 9) x IMC
        Hombres: Exc_cre = (28 - Edad / 6) x IMC                
    */

    result = 0;

    if (sex == 'F')
        result = (22 - edad / 9) * imc
    else
        result = (28 - edad / 6) * imc

    result = Math.round(result * 100) / 100;

        
        
        $("#excrecionCreatininaresultado").text(result);
       
        
        $("#resultContent").show();
        

    });
    
});