$(document).ready(function() {
	
    $('#conversionMetrica').formValidation({
    	framework: 'bootstrap',
//        icon: {
//            valid: 'glyphicon glyphicon-ok',
//            invalid: 'glyphicon glyphicon-remove',
//            validating: 'glyphicon glyphicon-refresh'
//        },
        fields: {
        	compuestoMgDl: {
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
        var mgdl = parseFloat($("input[name=compuestoMgDl]").val());
               
        /*
        Compuesto en (g/l)= Compuesto (X)  en (mg/dl) X 0.01
    */

   result = mgdl * 0.01;
   result = Math.round(result * 100) / 100;

             
        
        $("#conversionMetricaresultado").text(result);
       
        
        $("#resultContent").show();
        

    });
    
});