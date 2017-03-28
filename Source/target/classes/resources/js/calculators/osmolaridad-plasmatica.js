$(document).ready(function() {
	$("#End").click(function(){
		location.reload();
	});
    $('#OP').formValidation({
    	framework: 'bootstrap',
//        icon: {
//            valid: 'glyphicon glyphicon-ok',
//            invalid: 'glyphicon glyphicon-remove',
//            validating: 'glyphicon glyphicon-refresh'
//        },
        fields: {
        	na: {
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
            glucemia: {
                validators: {
                	notEmpty: {
                        message: 'Campo requerido'
                    },
                    numeric: {
                        message: 'Numero incorrecto.',
                        // The default separators
                        thousandsSeparator: '',
                        decimalSeparator: '.'
                    }
                }
            },
            uremia: {
                validators: {
                	notEmpty: {
                        message: 'Campo requerido'
                    },
                    numeric: {
                        message: 'Numero incorrecto.',
                        // The default separators
                        thousandsSeparator: '',
                        decimalSeparator: '.'
                    }
                }
            }
        }
    }).on('success.form.fv', function(e) {
    	// Prevent form submission
        e.preventDefault();
        
        var op = null;
        var result = null;
        var na = parseFloat($("input[name=na]").val());
        var glucemia = parseFloat($("input[name=glucemia]").val());
        var uremia = parseFloat($("input[name=uremia]").val());
        
        result = (2*na) + glucemia + uremia;
        result = Math.round(result * 100) / 100;

        /*
            Osmolalidad Plamatica valores 
            normales 280 a 295 mOsm/kg Osmolalidad PlasmÃ¡tica BAJA           
        */

        if (isNaN(result)) 
           result = '';

        else if (result >= 280 && result <= 295)
            op = 'Osmolalidad Plasmática Normal';

        else
            op = 'Osmolalidad Plasmática Baja';
        
        
        $("#resultadoOP").text(result.toFixed(2));
        $("#textOP").text(op);
        $("#OPSecond").show();
        $("#OPPrincipal").hide();
        
        
        
        
        
        
    });
    
});