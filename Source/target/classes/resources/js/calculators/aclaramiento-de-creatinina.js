$(document).ready(function() {
	
    $('#aclaramientocreatinina').formValidation({
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
	        creatinina: {
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
        var creatinina = parseFloat($("input[name=creatinina]").val());
        var sex = $("input[name=sexo]:checked").val();

        /*
        FÃ³rmula Crockcroft y Gault:Para Hombres 
        Aclaramiento Creatinina (ml / min) = 140 - edad x peso (kg) ) /  72 x 
            Creatinina en sangre (mg / dl )

        FÃ³rmula Crockcroft y Gault:                             Para Mujeeres               
        Aclaramiento Creatinina (ml / min) = 140 - edad x peso (kg) ) /  72 x 
            Creatinina en sangre (mg / dl ) x .085

    */
    //         =+( (140-F22) *F23 )/(72*F24)*1
    result = ((140 - edad) * peso) / (72 * creatinina);
    if (sex == 'F')
        result = result * 0.85;

   result = Math.round(result * 100) / 100;

    /*
    =+IF(G21<=100,"FILTRACION GLOMERULAR DISMINUIDA",
       IF(G21<=130,"FILTRACION GLOMERULAR NORMAL",
       "FILTRACION GLOMERULAR ELEVADA"))

    */
    

    if (result <= 100) 
        resultText = 'FILTRACION GLOMERULAR DISMINUIDA';

    else if ($scope.result <= 130)
        resultText = 'FILTRACION GLOMERULAR NORMAL';

    else 
        resultText = '"FILTRACION GLOMERULAR ELEVADA';
       


        
        
        $("#aclaramientocreatininaresultado").text(result);
        $("#textaclaramientocreatinina").text(resultText);
        
        $("#resultContent").show();
        

    });
    
});