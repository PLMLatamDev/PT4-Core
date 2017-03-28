$(document).ready(function() {
	$("#backGrafic").click(function(){
		hideGrafic();
	});
	
	var _date = new Date();
	
	$("#datepicker").datepicker({
	    changeMonth: true,
	      changeYear: true,
	      dateFormat: 'dd/mm/yy',
	      yearRange: '1900:_date.getFullYear()',
	      onSelect: function() {
	    	    $(this).change();
	    	    $('#crecimiento').formValidation('revalidateField', 'birthday');
	    	  }
    }).on('changeDate', function(e) {// Revalidate the date field
        
        $('#formPrescription').formValidation('revalidateField', 'birthday');
        $('#crecimiento').formValidation('revalidateField', 'birthday');
    });
	
    $('#crecimiento').formValidation({
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
            longitud: {
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
	        sexo: {
                validators: {
                    notEmpty: {
                        message: 'Campo requerido'
                    }
                }
            },
            birthday	: {
                validators: {
                    notEmpty: {
                        message: 'Campo requerido'
                    },
                    date: {
                        format: 'DD/MM/YYYY',
                        message: 'Fecha no valida'
                    },
                    callback: {
                        message: 'La fecha no esta en el rango, la edad máxima es de 5 años',
                        callback: function(value, validator) {

                            var date = new Date(); 
                            var day = date.getDate();
                            var month = date.getMonth();
                            var year = date.getFullYear();
                            var formatDay = day+"/"+(parseInt(month)+1)+"/"+year;
                            var minFormatDay = day+"/"+(parseInt(month)+1)+"/"+(parseInt(year)-5);
                           
                            var dateValidatorBeta = new DateValidatorBeta(value);
                            return dateValidatorBeta.isAfter(minFormatDay) && dateValidatorBeta.isBefore(formatDay);
                        }
                    }
            }
        },
        grafica: {
                validators: {
                    notEmpty: {
                        message: 'Campo requerido'
                    }
                }
            },
            mostrar: {
                validators: {
                    notEmpty: {
                        message: 'Campo requerido'
                    }
                }
            }
        }
    }).on('success.form.fv', function(e) {
    	// Prevent form submission
        e.preventDefault();

        crecimiento();
        
        
//        $("#presionArterialresultado").text(result);
//        $("#textpresionArterial").text(resultText);
//        
//        $("#resultContent").show();
        

    });
    
    
    function crecimiento(){
    	var resultURL = null;
    	var formGrafic = false;
        var resultGrafic = true;
    	var peso= $("input[name=peso]").val();
    	var longitud= $("input[name=longitud]").val();
    	var sexo= $("input[name=sexo]:checked").val();
    	var dateString= $("input[name=birthday]").val();
    	var grafica= $("input[name=grafica]:checked").val();
    	var mostrar= $("input[name=mostrar]:checked").val();
    	
    	
    	var currentDate = new Date();
    	var dateValidatorBeta = new DateValidatorBeta(dateString);

        var diffWeeks = dateValidatorBeta.inWeeks(currentDate);
        var diffYears = dateValidatorBeta.inYears(currentDate);
        var diffMonths = dateValidatorBeta.inMonths(currentDate);
                    
        var pathObject = {
            folderRoot: urlPath+'/resources/js/calculators/crecimientoInfantil/',
            folderSex: '',
            folderGraph: '',
            folderShow: '',
            htmlFile: ''
        }

        if (grafica == 'LONG-ESTA')
            pathObject.folderGraph = 'estatura_edad/';

        else if (grafica == 'PESO-EDAD')
            pathObject.folderGraph = 'peso_edad/';

        else if (grafica == 'PESO-LONG')
            pathObject.folderGraph = 'peso_longitud/';
                   

        if (sexo == 'F')
            pathObject.folderSex = 'ninias/';
        else 
            pathObject.folderSex = 'ninios/';

        if (grafica == 'LONG-ESTA' && mostrar == 'PERC')
            estaturaEdadPercentilesFile(sexo, longitud, diffWeeks, diffYears, diffMonths, pathObject);

        else if (grafica == 'LONG-ESTA' && mostrar == 'PUNT')
            estaturaEdadPuntuacionFile(sexo, longitud, diffWeeks, diffYears, diffMonths, pathObject);

        else if (grafica == 'PESO-EDAD' && mostrar == 'PERC')
            pesoEdadPercentilesFile(sexo, peso, diffWeeks, diffYears, diffMonths, pathObject);

        else if (grafica == 'PESO-EDAD' && mostrar == 'PUNT')
            pesoEdadPuntuacionFile(sexo, peso, diffWeeks, diffYears, diffMonths, pathObject);
                    
        //$scope.resultURL = '/views/testGrafica.html?age=12&length=55';
        if (pathObject.htmlFile) {
             resultURL = pathObject.folderRoot + pathObject.folderGraph + pathObject.folderSex + pathObject.folderShow + pathObject.htmlFile;
             $("#mostrarEnPantalla").attr("href", resultURL);
             $("#iframeCrecimiento").attr("src", resultURL);
             showGrafic();

            console.log(resultURL);
           // tabstrip.select(1);
        }
    	
    }
    var showGrafic =function(){
    	$("#crecimientoPrincipal").hide();
    	$("#crecimientoSecond").show();
    }
    var hideGrafic = function(){
    	$("#crecimientoSecond").hide();
    	$("#crecimientoPrincipal").show();
    }

    var estaturaEdadPercentilesFile = function (creSex, creLongitud, diffWeeks, diffYears, diffMonths, pathObject) {

        if (diffWeeks <= 13) {
            pathObject.folderShow = '1percen_0 _13_sem/';

            if (creSex == 'F')
                pathObject.htmlFile = 'girls-percentiles-0-13-weeks.html';

            else
                pathObject.htmlFile = 'boys-percentiles-0-13-weeks.html';

            pathObject.htmlFile = pathObject.htmlFile + '?age=' + diffWeeks + '&length=' + creLongitud;

        }
        else
            if (diffMonths <= 24) {
                pathObject.folderShow = '2percen_0_2_anios/';

                if (creSex == 'F')
                    pathObject.htmlFile = 'girls-percentiles-0-24-months.html';
                else
                    pathObject.htmlFile = 'boys-percentiles-0-24-months.html';

                pathObject.htmlFile = pathObject.htmlFile + '?age=' + diffMonths + '&length=' + creLongitud;

            }
            else {
                pathObject.folderShow = '3percen_2_5 anios/';

                if (creSex == 'F')
                    pathObject.htmlFile = 'girls-percentiles-24-60-months.html';
                else
                    pathObject.htmlFile = 'boys-percentiles-24-60-months.html';

                pathObject.htmlFile = pathObject.htmlFile + '?age=' + diffMonths + '&length=' + creLongitud;

            }
        
    }

    var estaturaEdadPuntuacionFile = function (creSex, creLongitud, diffWeeks, diffYears, diffMonths, pathObject) {

        if (diffWeeks <= 13) {
            pathObject.folderShow = '1percen_0_13_sem/';

            if (creSex == 'F')
                pathObject.htmlFile = 'girls-scores-0-13-weeks.html';

            else
                pathObject.htmlFile = 'boys-scores-0-13-weeks.html';

            pathObject.htmlFile = pathObject.htmlFile + '?age=' + diffWeeks + '&length=' + creLongitud;

        }
        else
            if (diffMonths <= 24) {
                pathObject.folderShow = '2puntua_0_2_anios/';

                if (creSex == 'F')
                    pathObject.htmlFile = 'girls-scores-0-24-months.html';
                else
                    pathObject.htmlFile = 'boys-scores-0-24-months.html';

                pathObject.htmlFile = pathObject.htmlFile + '?age=' + diffMonths + '&length=' + creLongitud;

            }
            else {
                pathObject.folderShow = '3puntua_2_5_anios/';

                if (creSex == 'F')
                    pathObject.htmlFile = 'girls-scores-24-60-months.html';
                else
                    pathObject.htmlFile = 'boys-scores-24-60-months.html';

                pathObject.htmlFile = pathObject.htmlFile + '?age=' + diffMonths + '&length=' + creLongitud;

            }

    }

    var pesoEdadPercentilesFile = function (creSex, crePeso, diffWeeks, diffYears, diffMonths, pathObject) {

        if (diffWeeks <= 13) {
            pathObject.folderShow = '1percen_0_13_sem/';

            if (creSex == 'F')
                pathObject.htmlFile = 'girls-percentiles-0-13-weeks.html';

            else
                pathObject.htmlFile = 'boys-percentiles-0-13-weeks.html';

            pathObject.htmlFile = pathObject.htmlFile + '?age=' + diffWeeks + '&weight=' + crePeso;

        }
        else
            if (diffMonths <= 20) {
                pathObject.folderShow = '2percen_0_5_anios/';

                if (creSex == 'F')
                    pathObject.htmlFile = 'girls-percentiles-0-20-months.html';
                else
                    pathObject.htmlFile = 'boys-percentiles-0-20-months.html';

                pathObject.htmlFile = pathObject.htmlFile + '?age=' + diffMonths + '&weight=' + crePeso;

            }

            else if (diffMonths <= 40) {
                pathObject.folderShow = '2percen_0_5_anios/';

                if (creSex == 'F')
                    pathObject.htmlFile = 'girls-percentiles-20-40-months.html';
                else
                    pathObject.htmlFile = 'boys-percentiles-20-40-months.html';

                pathObject.htmlFile = pathObject.htmlFile + '?age=' + diffMonths + '&weight=' + crePeso;

            }

            else if (diffMonths <= 60) {
                pathObject.folderShow = '2percen_0_5_anios/';

                if (creSex == 'F')
                    pathObject.htmlFile = 'girls-percentiles-40-60-months.html';
                else
                    pathObject.htmlFile = 'boys-percentiles-40-60-months.html';

                pathObject.htmlFile = pathObject.htmlFile + '?age=' + diffMonths + '&weight=' + crePeso;

            }


    }

    var pesoEdadPuntuacionFile = function (creSex, crePeso, diffWeeks, diffYears, diffMonths, pathObject) {

        if (diffWeeks <= 13) {
            pathObject.folderShow = '1puntua_0_13_sem/';

            if (creSex == 'F')
                pathObject.htmlFile = 'girls-scores-0-13-weeks.html';

            else
                pathObject.htmlFile = 'boys-scores-0-13-weeks.html';

            pathObject.htmlFile = pathObject.htmlFile + '?age=' + diffWeeks + '&weight=' + crePeso;

        }
        else
            if (diffMonths <= 20) {
                pathObject.folderShow = '2puntua_0_5_anios/';

                if (creSex == 'F')
                    pathObject.htmlFile = 'girls-scores-0-20-months.html';
                else
                    pathObject.htmlFile = 'boys-scores-0-20-months.html';

                pathObject.htmlFile = pathObject.htmlFile + '?age=' + diffMonths + '&weight=' + crePeso;

            }
            else if (diffMonths <= 40) {
                pathObject.folderShow = '2puntua_0_5_anios/';

                if (creSex == 'F')
                    pathObject.htmlFile = 'girls-scores-20-40-months.html';
                else
                    pathObject.htmlFile = 'boys-scores-20-40-months.html';

                pathObject.htmlFile = pathObject.htmlFile + '?age=' + diffMonths + '&weight=' + crePeso;

            }
            else if (diffMonths <= 60) {
                pathObject.folderShow = '2puntua_0_5_anios/';

                if (creSex == 'F')
                    pathObject.htmlFile = 'girls-scores-40-60-months.html';
                else
                    pathObject.htmlFile = 'boys-scores-40-60-months.html';

                pathObject.htmlFile = pathObject.htmlFile + '?age=' + diffMonths + '&weight=' + crePeso;

            }


    }
    
});