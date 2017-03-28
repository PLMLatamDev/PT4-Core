$(document).ready(function() {
	
    $('#conCalcio').formValidation({
    	framework: 'bootstrap',
//        icon: {
//            valid: 'glyphicon glyphicon-ok',
//            invalid: 'glyphicon glyphicon-remove',
//            validating: 'glyphicon glyphicon-refresh'
//        },
        fields: {
        	calcio: {
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
            albumina: {
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
	        }
        }
    }).on('success.form.fv', function(e) {
    	// Prevent form submission
        e.preventDefault();

        var result = null;
        var resultText = null;
        var calcio = parseFloat($("input[name=calcio]").val());
        var albumina = parseFloat($("input[name=albumina]").val());

        /*
        ConcentraciÃ³n de calcio total corregida (mg/dl)= 
        Calcio total obtenido (mg/dl) / ConcentraciÃ³n de albÃºmina (g/l) + 4
        */
        result = (calcio / albumina) + 4;

        result = Math.round(result * 100) / 100;
        
        
        $("#conCalcioresultado").text(result);
        
        
        $("#resultContent").show();
        

    });
    
});