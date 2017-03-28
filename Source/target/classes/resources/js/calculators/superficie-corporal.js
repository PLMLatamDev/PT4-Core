$(document).ready(function() {
	
    $('#superficieCorporal').formValidation({
    	framework: 'bootstrap',
//        icon: {
//            valid: 'glyphicon glyphicon-ok',
//            invalid: 'glyphicon glyphicon-remove',
//            validating: 'glyphicon glyphicon-refresh'
//        },
        fields: {
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
	        altura: {
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
        var peso = parseFloat($("input[name=peso]").val());
        var altura = parseFloat($("input[name=altura]").val());
        

       result = Math.sqrt( altura * peso / 3600);
       result = Math.round(result * 100) / 100;

       


        
        
        $("#superficieCorporalresultado").text(result);
        
        $("#resultContent").show();
        

    });
    
});