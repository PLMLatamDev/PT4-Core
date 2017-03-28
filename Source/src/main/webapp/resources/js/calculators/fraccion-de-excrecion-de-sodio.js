$(document).ready(function() {
	
    $('#fraccion').formValidation({
    	framework: 'bootstrap',
//        icon: {
//            valid: 'glyphicon glyphicon-ok',
//            invalid: 'glyphicon glyphicon-remove',
//            validating: 'glyphicon glyphicon-refresh'
//        },
        fields: {
        	una: {
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
            pcr: {
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
            pna: {
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
            ucr: {
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
        var una = parseFloat($("input[name=una]").val());
        var pcr = parseFloat($("input[name=pcr]").val());
        var pna = parseFloat($("input[name=pna]").val());
        var ucr = parseFloat($("input[name=ucr]").val());
        /*
        FENa = (UNa x PCr) / (PNa x UCr) x 100
    */

    result = (una * pcr)  / ( pna * ucr) * 100;
    result = Math.round(result * 100) / 100;

             
        
        $("#fraccionresultado").text(result);
       
        
        $("#resultContent").show();
        

    });
    
});