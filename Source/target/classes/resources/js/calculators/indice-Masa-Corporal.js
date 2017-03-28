$(document).ready(function() {
	$("#imcEnd").click(function(){
		location.reload();
	});
    $('#MassIndex').formValidation({
    	framework: 'bootstrap',
        icon: {
//            valid: 'glyphicon glyphico',
//            invalid: 'glyphicon glyphicon-remove',
//            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	height: {
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
            weight: {
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
        
        var imc = null;
        var result = null;
        var weight = parseFloat($("input[name=weight]").val());
        var height = parseFloat($("input[name=height]").val());
        
        result = height / ( weight * weight );
       
        if(result.toFixed(1)<=18.5){
        	imc = "Bajo peso";
        }else if(result.toFixed(1)>=18.6 && result.toFixed(1)<=25){
        	imc = "Peso Normal";
        }else if(result.toFixed(1)>=25.1 && result.toFixed(1)<=30){
        	imc = "Sobrepeso";
        }else if(result.toFixed(1)>=30.1 && result.toFixed(1)<=35){
        	imc = "Obesidad I";
        }else if(result.toFixed(1)>=35.1 && result.toFixed(1)<=40){
        	imc = "Obesidad II";
        }else if(result.toFixed(1)>40){
        	imc = "Obesidad III";
        }
        
        
        $("#imc").text(result.toFixed(2));
        $("#cimc").text(imc);
        $("#MassIndexSecond").show();
        $("#MassIndexPrincipal").hide();
        
        
        
        
        
        
    });
    
});