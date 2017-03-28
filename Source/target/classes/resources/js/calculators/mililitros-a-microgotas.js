$(document).ready(function() {
	
    $('#ml-mg').formValidation({
    	framework: 'bootstrap',
//        icon: {
//            valid: 'glyphicon glyphicon-ok',
//            invalid: 'glyphicon glyphicon-remove',
//            validating: 'glyphicon glyphicon-refresh'
//        },
        fields: {
        	mililitros: {
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
        var mililitros = parseFloat($("input[name=mililitros]").val());
        

		        /*
				 * 1ml = 20 gotas = 60 microgotas
				 */

       result = mililitros * 60;
       result = Math.round(result * 100) / 100;


        
        
        $("#ml-mgresultado").text(result);
        
        $("#resultContent").show();
        

    });
    
});