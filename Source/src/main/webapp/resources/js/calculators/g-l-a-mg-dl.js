$(document).ready(function() {
	
    $('#conversionMetrica').formValidation({
    	framework: 'bootstrap',
//        icon: {
//            valid: 'glyphicon glyphicon-ok',
//            invalid: 'glyphicon glyphicon-remove',
//            validating: 'glyphicon glyphicon-refresh'
//        },
        fields: {
        	compuestoGL: {
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
        var gl = parseFloat($("input[name=compuestoGL]").val());
               
        /*
            Compuesto  en (mg/dl)= Compuesto (X ) en (g/l) / 0.01  
        */

        result = gl / 0.01;
        result = Math.round(result * 100) / 100;

             
        
        $("#conversionMetricaresultado").text(result);
       
        
        $("#resultContent").show();
        

    });
    
});