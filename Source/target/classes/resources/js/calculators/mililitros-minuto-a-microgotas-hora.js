$(document).ready(function() {
	
    $('#mlh-mgh').formValidation({
    	framework: 'bootstrap',
//        icon: {
//            valid: 'glyphicon glyphicon-ok',
//            invalid: 'glyphicon glyphicon-remove',
//            validating: 'glyphicon glyphicon-refresh'
//        },
        fields: {
        	mililitrosHora: {
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
        var mililitrosHora = parseFloat($("input[name=mililitrosHora]").val());
        

        result = mililitrosHora * 60;
        result = Math.round(result * 100) / 100;


        
        
        $("#mlh-mghresultado").text(result);
        
        $("#resultContent").show();
        

    });
    
});