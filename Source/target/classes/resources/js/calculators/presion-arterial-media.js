$(document).ready(function() {
	
    $('#presionArterial').formValidation({
    	framework: 'bootstrap',
//        icon: {
//            valid: 'glyphicon glyphicon-ok',
//            invalid: 'glyphicon glyphicon-remove',
//            validating: 'glyphicon glyphicon-refresh'
//        },
        fields: {
        	sistolica: {
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
            diastolica: {
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
        var sistolica = parseFloat($("input[name=sistolica]").val());
        var diastolica = parseFloat($("input[name=diastolica]").val());

        /*
        PresiÃ³n Arterial Media = (PresiÃ³n SistÃ³lica + (PresiÃ³n DiastÃ³lica x 2))/3.
        =+(F69+(F70*2))/3
    */

    result =  (sistolica + (diastolica * 2) ) / 3;
    result = Math.round(result * 100) / 100;

   
    /*
        =+IF(
        F68<=70,"PAM DISMINUIDA",
        IF(F68<=105,"PAM NORMAL",
        "PAM ELEVADA"))
    */

    

    if (result <= 70)
        resultText = 'PAM DISMINUIDA';

    else if (result <= 105)
        resultText = 'PAM NORMAL';

    else
        resultText = 'PAM ELEVADA';
        
        
        $("#presionArterialresultado").text(result);
        $("#textpresionArterial").text(resultText);
        
        $("#resultContent").show();
        

    });
    
});