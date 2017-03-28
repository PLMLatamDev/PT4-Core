/*
 * plm-calendar-1.0.0.js
 * plantillas para bootstrap
 * <div class="form-group">
                <label>DateTime Picking</label>
                <div class="input-group date form_datetime" data-date="1979-09-16T05:25:07Z" data-date-format="dd MM yyyy - HH:ii p" data-link-field="dtp_input1">
                    <input class="form-control" size="16" type="text" value="" readonly>
                    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
					<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                </div>
				<input type="hidden" id="dtp_input1" value="" /><br/>
            </div>    
 * <div class="form-group">
                <label for="dtp_input2" class="col-md-2 control-label">Date Picking</label>
                <div class="input-group date form_date col-md-5" data-date="" data-date-format="dd MM yyyy" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
                    <input class="form-control" size="16" type="text" value="" readonly>
                    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
					<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
                </div>
				<input type="hidden" id="dtp_input2" value="" /><br/>
            </div>
*		<div class="form-group">
                <label for="dtp_input3" class="col-md-2 control-label">Time Picking</label>
                <div class="input-group date form_time col-md-5" data-date="" data-date-format="hh:ii" data-link-field="dtp_input3" data-link-format="hh:ii">
                    <input class="form-control" size="16" type="text" value="" readonly>
                    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
					<span class="input-group-addon"><span class="glyphicon glyphicon-time"></span></span>
                </div>
				<input type="hidden" id="dtp_input3" value="" /><br/>
            </div>
 * */

//$(function () {
//	
//                $('.form_datetime').datetimepicker({
//                    language:  'es',
//                    weekStart: 1,
//                    todayBtn:  1,
//            		autoclose: 1,
//            		todayHighlight: 1,
//            		startView: 2,
//            		forceParse: 0,
//                    showMeridian: 1
//                }).on('changeDate', function(e) {// Revalidate the date field
//                	
//                    $('#formPrescription').formValidation('revalidateField', 'birthday');
//                    $('#crecimiento').formValidation('revalidateField', 'birthday');
//                });
//                $('.form_date').datetimepicker({
//                    language:  'es',
//                    //locale:'es',
//                    weekStart: 1,
//                    todayBtn:  1,
//            		autoclose: 1,
//            		todayHighlight: 1,
//            		startView: 2,
//            		minView: 2,
//            		forceParse: 0
//                }).on('changeDate', function(e) {// Revalidate the date field
//               
//                    $('#formPrescription').formValidation('revalidateField', 'birthday');
//                    $('#crecimiento').formValidation('revalidateField', 'birthday');
//                });
//            	$('.form_time').datetimepicker({
//                    language:  'es',
//                    weekStart: 1,
//                    todayBtn:  1,
//            		autoclose: 1,
//            		todayHighlight: 1,
//            		startView: 1,
//            		minView: 0,
//            		maxView: 1,
//            		forceParse: 0
//                }).on('changeDate', function(e) {// Revalidate the date field
//                	
//                    $('#formPrescription').formValidation('revalidateField', 'birthday');
//                    $('#crecimiento').formValidation('revalidateField', 'birthday');
//                });
//                
//});
var DateValidatorBeta = function(dateInString) {

	 this.date = dateInString;

	 this.isValid = function() {
	  var myDate = new Date(Date.parse(this.date));
	  if (myDate == "Invalid Date") {

	   var date = this.date;
	   var daux = date.split("/");
	   fgo = daux[1] + "," + daux[0] + "," + daux[2];
	   d1 = new Date('' + fgo + '');
	   if (dl != "Invalid Date") {
	    return false
	   } else {
	    return true;
	   }


	  } else {
	   return true;
	  }

	 }

	 this.getTime = function() {
		
//	  var myDate = new Date(Date.parse(this.date));
//	  if (myDate == "Invalid Date") {

	   var date = this.date;
	   var daux = date.split("/");
	   var fgo = daux[1] + "," + daux[0] + "," + daux[2];
	   var d1 = new Date('' + fgo + '');
	   if (d1 == "Invalid Date") {
	    return "Invalid Date";
	   } else {
	    var n1 = d1.toLocaleDateString();
	    return d1.getTime();
	   }


//	  } else {
//	   return myDate.getTime();
//	  }
	 }

	 this.isAfter = function(dateToValidate) {
	  var daux = this.date.split("/");
	  var dateToValidateAux = dateToValidate.split("/");

	  var dateStart = new Date(daux[2], (daux[1] - 1), daux[0]);
	  var dateEnd = new Date(dateToValidateAux[2], (dateToValidateAux[1] - 1), dateToValidateAux[0]);
	  if (dateStart > dateEnd) {
	   return true;
	  }
	  return false;
	 }
	 this.isBefore = function(dateToValidate) {
	  var daux = this.date.split("/");
	  var dateToValidateAux = dateToValidate.split("/");

	  var dateStart = new Date(daux[2], (daux[1] - 1), daux[0]);
	  var dateEnd = new Date(dateToValidateAux[2], (dateToValidateAux[1] - 1), dateToValidateAux[0]);
	  if (dateStart < dateEnd) {
	   return true;
	  }
	  return false;
	 }
	 this.inDays = function(d2) {
	   var t2 = d2.getTime();
	   var t1 = this.getTime();

	   return parseInt((t2 - t1) / (24 * 3600 * 1000));
	  },

	  this.inWeeks = function(d2) {
	   var t2 = d2.getTime();
	   var t1 = this.getTime();;

	   return parseInt((t2 - t1) / (24 * 3600 * 1000 * 7));
	  },

	  this.inMonths = function(d2) {
	   var daux = this.date.split("/");
	   var d1 = new Date(daux[2], (daux[1] - 1), daux[0]);
	   var d1Y = d1.getFullYear();
	   var d2Y = d2.getFullYear();
	   var d1M = d1.getMonth();
	   var d2M = d2.getMonth();
       console.log((d2M + 12 * d2Y) - (d1M + 12 * d1Y));
	   return (d2M + 12 * d2Y) - (d1M + 12 * d1Y);
	  },

	  this.inYears = function(d2) {
	   var d1 = new Date(Date.parse(this.date));
	   return d2.getFullYear() - d1.getFullYear();
	  }
	}











