$(document).ready(function() {
	
    $('#mg-ml').formValidation({
    	framework: 'bootstrap',
//        icon: {
//            valid: 'glyphicon glyphicon-ok',
//            invalid: 'glyphicon glyphicon-remove',
//            validating: 'glyphicon glyphicon-refresh'
//        },
        fields: {
        	microgotas: {
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
        var microgotas = parseFloat($("input[name=microgotas]").val());
        

		        /*
				 * 1ml = 20 gotas = 60 microgotas
				 */

    result = microgotas/60;
    result = Math.round(result * 100) / 100;


        
        
        $("#mg-mlresultado").text(result.toFixed(2));
        
        $("#resultContent").show();
        

    });
    
});