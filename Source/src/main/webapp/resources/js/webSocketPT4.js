            var stompClient = null;
            var id = RestPLMServices.UUID;
            var prescription = new Prescription();
           
             
            function connect() {
                var urlSocket = 'http://184.173.56.78:8090/Suitability/idoneidad';
//                var urlSocket = 'http://195.192.2.19/Suitability/idoneidad';
                var socket = new SockJS(urlSocket);
                stompClient = Stomp.over(socket);  
                stompClient.connect({}, function(frame) {
                	console.log('Connected: ' + frame);
                    stompClient.subscribe("/websocket/contraindicationsByProducts/"+id, function(messageOutput) {
                       var response = JSON.parse(messageOutput.body);
                       $.when(prescription.asyncContraindications( JSON.parse(messageOutput.body))).done(function( listResponse ){
           					console.log( listResponse );
           					if(window.location.pathname == urlPath+"/interacciones"){
           						_createGridPrescriptions();
           					}
           			   });
                       
                    });
                    stompClient.subscribe("/websocket/interactionsByEditionProducts/"+id, function(messageOutput) {
                    	var response = JSON.parse(messageOutput.body);
                    	$.when(prescription.asyncInteractionsByEditionProducts( JSON.parse(messageOutput.body))).done(function( listResponse ){
                    		console.log( listResponse );
                    		if(window.location.pathname == urlPath+"/interacciones"){
                    			_createGridPrescriptions();
                    		}
                    	});
                    	
                    });
                    stompClient.subscribe("/websocket/mealInteractionsByProducts/"+id, function(messageOutput) {
                    	var response = JSON.parse(messageOutput.body);
                    	$.when(prescription.asyncMealInteractionsByProducts( JSON.parse(messageOutput.body))).done(function( listResponse ){
                    		console.log( listResponse );
                    		if(window.location.pathname == urlPath+"/interacciones"){
                    			_createGridPrescriptions();
                    		}
                    	});
                    	
                    });
                    stompClient.subscribe("/websocket/IMDDIProductInteractionSubstances/"+id, function(messageOutput) {
                    	var response = JSON.parse(messageOutput.body);
                    	$.when(prescription.asyncIMDDIProductInteractionSubstances( JSON.parse(messageOutput.body))).done(function( listResponse ){
                    		console.log( listResponse );
                    		if(window.location.pathname == urlPath+"/interacciones"){
                    			_createGridPrescriptions();
                    		}
                    	});
                    	
                    });
                    
                    stompClient.subscribe("/websocket/pregnancyRisksByDrugs/"+id, function(messageOutput) {
                    	var response = JSON.parse(messageOutput.body);
                    	$.when(prescription.asyncPregnancyRiskByDrugs( JSON.parse(messageOutput.body))).done(function( listResponse ){
                    		console.log( listResponse );
                    		if(window.location.pathname == urlPath+"/interacciones"){
                    			_createGridPrescriptions();
                    		}
                    	});
                    	
                    });
                    stompClient.subscribe("/websocket/definedDailyDoseByDrugs/"+id, function(messageOutput) {
                    	var response = JSON.parse(messageOutput.body);
                    	$.when(prescription.asyncDefinedDailyDoseByDrugs( JSON.parse(messageOutput.body))).done(function( listResponse ){
                    		console.log( listResponse );
                    		if(window.location.pathname == urlPath+"/interacciones"){
                    			_createGridPrescriptions();
                    		}
                    	});
                    	
                    });
                    stompClient.subscribe("/websocket/substanceIncompatibilitiesByProducts/"+id, function(messageOutput) {
                    	var response = JSON.parse(messageOutput.body);
                    	$.when(prescription.asyncSubstanceIncompatibilitiesByProducts( JSON.parse(messageOutput.body))).done(function( listResponse ){
                    		console.log( listResponse );
                    		if(window.location.pathname == urlPath+"/interacciones"){
                    			_createGridPrescriptions();
                    		}
                    	});
                    	
                    });
                    stompClient.subscribe("/websocket/therapeuticDoublenessByDrugs/"+id, function(messageOutput) {
                    	var response = JSON.parse(messageOutput.body);
                    	$.when(prescription.asyncTherapeuticDoublenessByDrugs( JSON.parse(messageOutput.body))).done(function( listResponse ){
                    		console.log( listResponse );
                    		if(window.location.pathname == urlPath+"/interacciones"){
                    			_createGridPrescriptions();
                    		}
                    	});
                    	
                    });
                    
                    
                });
            }
             
            function disconnect() {
                if(stompClient != null) {
                    stompClient.disconnect();
                }
               
                console.log("Disconnected");
            }
             
            function sendMessage(json) {
            	stompClient.send("/app/idoneidad/contraindicationsByProducts/"+RestPLMServices.CodeString+"/"+RestPLMServices.CountryIdPharma+"/"+RestPLMServices.EditionId+"/"+id, {}, 
                JSON.stringify(json));        
            	stompClient.send("/app/idoneidad/interactionsByEditionProducts/"+RestPLMServices.CodeString+"/"+RestPLMServices.CountryIdPharma+"/"+RestPLMServices.EditionId+"/"+id, {}, 
            	JSON.stringify(json));        
            	stompClient.send("/app/idoneidad/mealInteractionsByProducts/"+RestPLMServices.CodeString+"/"+RestPLMServices.CountryIdPharma+"/"+RestPLMServices.EditionId+"/"+id, {}, 
            	JSON.stringify(json));        
            	stompClient.send("/app/idoneidad/IMDDIProductInteractionSubstances/"+RestPLMServices.CodeString+"/"+RestPLMServices.CountryIdPharma+"/"+RestPLMServices.EditionId+"/"+id, {}, 
            	JSON.stringify(json));        
            	
            	stompClient.send("/app/idoneidad/pregnancyRisksByDrugs/"+RestPLMServices.CodeString+"/"+RestPLMServices.CountryIdPharma+"/"+RestPLMServices.EditionId+"/"+id, {}, 
            	JSON.stringify(json));        
            	stompClient.send("/app/idoneidad/definedDailyDoseByDrugs/"+RestPLMServices.CodeString+"/"+RestPLMServices.CountryIdPharma+"/"+RestPLMServices.EditionId+"/"+id, {}, 
            	JSON.stringify(json));        
            	stompClient.send("/app/idoneidad/substanceIncompatibilitiesByProducts/"+RestPLMServices.CodeString+"/"+RestPLMServices.CountryIdPharma+"/"+RestPLMServices.EditionId+"/"+id, {}, 
            	JSON.stringify(json));        
            	stompClient.send("/app/idoneidad/therapeuticDoublenessByDrugs/"+RestPLMServices.CodeString+"/"+RestPLMServices.CountryIdPharma+"/"+RestPLMServices.EditionId+"/"+id, {}, 
            	JSON.stringify(json));        
            }
             
          connect();