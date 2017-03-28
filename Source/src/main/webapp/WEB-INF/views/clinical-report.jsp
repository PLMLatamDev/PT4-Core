<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style>
  .sizeFontLetter{
  font-family: 'Source Sans Pro', sans-serif;font-size: 14px;
  }
  .sizeFontLetter2{
  font-family: 'Source Sans Pro', sans-serif;font-size: 12px;
  }
  .text-muted-opacity{
  color:rgba(119,119,123,0.8);
  }
  .row-component{
        margin-right: 2px !important;
    margin-left: 0px !important;
    font-size: 12px;
  }
  .row-component-header{
      background-color: #3A6F9F;
    color: #FFFFFF;
    text-align: center;
    font-weight: bold;
  }
  .row-component-colum-principal{
      
    text-align: center;
    font-weight: bold;
  }
  .row-component-colum{
      border-left: 1px solid rgb(210, 214, 222);
      border-bottom: 1px solid rgb(210, 214, 222);
      border-right: 1px solid rgb(210, 214, 222);

   
  }
  #txtArea, #txtArea2 {
    width: 100%;
    height: 80px;
    resize: none;
        border-radius: 0;
    box-shadow: none;
    border-color: #d2d6de;
}
  .stickyfloat_element {
  right: 0;
  top:152px;
  text-align: center;
  position: fixed;
  width: auto;
  height: 50px;
  line-height: 50px;
 
 
}
  
  .row-component-simple-colum{
  border-left: 1px solid rgb(210, 214, 222);
  }
</style>
<section class="content">
   <div class="row" style="background-color: #ffffff;">
<!--       <div class="col-md-1"></div> -->
      <div class="col-md-4">
      <div class="box box-solid">
         <div class="box-body">
           <img class="img-responsive" src="${pageContext.request.contextPath}/resources/images/pt-4.jpg" alt="PT4">
         </div>
      </div>
      </div>
      <form role="form" id="formReport">
      <div class="col-md-3">
        <div class="box box-solid">
           
             <div class="box-body">
              <div class="form-group">
                 <label for="inputEmail3" class="control-label">Expediente</label>
                   <input type="text" class="form-control" name="expedient" id="expedient" placeholder="">
               </div>
              <div class="form-group">
                 <label for="inputEmail3" class="control-label">Nombre * </label>
                   <input type="text" class="form-control" name="name" id="name" placeholder="">
               </div>
              <div class="form-group">
                 <label for="inputEmail3" class="control-label">Apellidos *</label>
                   <input type="text" class="form-control" name="lastname" id="lastname" placeholder="">
               </div>
               </div>
           
        </div>
      </div>
      <div class="col-md-3">
         <div class="box box-solid">
           
             <div class="box-body">
              <div class="form-group">
                 <label for="inputEmail3" class="control-label">Peso (kg)</label>
                   <input type="text" class="form-control" name="weigth" id="weigth" placeholder="80">
               </div>
              <div class="form-group">
                 <label for="inputEmail3" class="control-label">Estatura (m)</label>
                   <input type="text" class="form-control" name="heigth" id="heigth" placeholder="1.70">
               </div>
              <div class="form-group">
                <label>Fecha de Nacimiento *</label><br/>
					<input class="form-control" id="datepicker" name="birthday" size="16" type="text" value="" placeholder="02/01/2017" >
				<input type="hidden" id="dtp_input2" value="" /><br/>
            </div>
               </div>
           
        </div>
      </div>
      <div class="col-md-1">
           <div class="box box-solid">
             <div class="box-body">
		       <button type="submit" class="btn btn-app">
                 <i class="fa fa-save" ></i> Guardar
               </button>
            </div>
          </div>
      </div>
      </form>
   </div>
   <div class="row">
    <div class="col-md-12">
      
      <c:forEach items="${drugs}" var="drug" varStatus="status">
       <div class="box box-default">
          <div class="box-header with-border">
                  <h3 class="box-title text-light-blue"><label>${drug.getBrand()}</label> &nbsp;<span class="text-aqua sizeFontLetter">${drug.getPharmaForm()}</span></h3>
                  <br><p class="sizeFontLetter2 text-muted">${drug.getSubstance()}</p>
                </div> 
                <div class="box-body">
                <label class="sizeFontLetter text-red">Interacciones Medicamentosas:</label><br>
                <label class="sizeFontLetter text-muted">Por Sustancia:</label>&nbsp;<span id="interaccion-sustancia-${status.count}" class="sizeFontLetter text-muted-opacity">No reporta interacciones</span><br>
                <c:if test="${interactions != null }">
                   <c:forEach items="${interactions}" var="interactionG">
                     <c:if test="${interactionG.getProductId() == drug.getProductId() && interactionG.getCategoryId()  == drug.getCategotyId() && interactionG.getDivisionId() == drug.getDivisionId() && interactionG.getPharmaFormId() == drug.getPharmaFormId() }">
                       <c:if test="${interactionG.getInteractionSubstances().size() > 0 }">
                        <script type="text/javascript">
                  var identifiyer = ${status.count};
                    $("#interaccion-sustancia-"+identifiyer).hide();
                  </script>
							<table class="table tableresponsiveStackable">
								 <thead>
									<tr>
										<th>MEDICAMENTO</th>
										<th>SUSTANCIA</th>
										<th>FORMA FARMACÉUTICA</th>
										<th>LABORATORIO</th>
									</tr>
								 </thead>
								 <tbody>
									<c:forEach
										items="${interactionG.getInteractionSubstances()}"
										var="interact">

										<tr>
											<td>${interact.getIBrand()}</td>
											<td>${interact.getIActiveSubstance()}</td>
											<td>${interact.getIPharmaForm()}</td>
											<td>${interact.getIDivisionShortName()}</td>
										</tr>
										

									</c:forEach>
								</tbody>
							</table>
						<br>
						</c:if>
                <label class="sizeFontLetter text-muted">Por Grupo Farmacológico:</label>&nbsp;<span id="interaccion-grupo-${status.count}" class="sizeFontLetter text-muted-opacity">No reporta interacciones</span><br>
                <c:if test="${interactionG.getPharmacologicalGroups().size() > 0 }">
                  <script type="text/javascript">
                  var identifiyer = ${status.count};
                  $("#interaccion-grupo-"+identifiyer).hide();
                  </script>
                    <table class="table tableresponsiveStackable">
								 <thead>
									<tr>
										<th>GRUPO FARMACOLÓGICO</th>
										<th>SUSTANCIA</th>
										<th>MEDICAMENTO</th>
										<th>FORMA FARMACÉUTICA</th>
									</tr>
								 </thead>
								 <tbody>
		                <c:forEach items="${interactionG.getPharmacologicalGroups()}" var="interactionGrupo">
		                    <tr>
													<td>${interactionGrupo.getGroupName()}</td>
													<td>${interactionGrupo.getIActiveSubstance()}</td>
													<td>${interactionGrupo.getIBrand()}</td>
													<td>${interactionGrupo.getIPharmaForm()}</td>
												</tr>
		                </c:forEach>
                </tbody>
		     </table>
                </c:if>
                     </c:if>
                   </c:forEach>  
        
				</c:if>
      <label class="sizeFontLetter text-red">Interacciones con Alimentos:</label><br>
      <span id="interaccion-alimento-${status.count}" class="sizeFontLetter text-muted-opacity">No reporta interacciones</span><br>
      <c:if test="${mealInteracciones !=  null }">
								 <c:forEach items="${mealInteracciones}" var="mealinteraction" varStatus="mealCount"> 
								  <c:forEach items="${mealinteraction.getProducts() }" var="productMeal">
                                    <c:if test="${drug.getCategotyId() == productMeal.getCategoryId() && drug.getDivisionId() == productMeal.getDivisionId() && drug.getPharmaFormId() == productMeal.getPharmaFormId() && drug.getProductId() == productMeal.getProductId() }">
       <script type="text/javascript">
	       var identifiyer = ${status.count};
	       $("#interaccion-alimento-"+identifiyer).hide();
       </script>
       <table class="table tableresponsiveStackable">
								 <thead>
									<tr>
										<th>Sustancia</th>
										<th>Resumen / Referencias Clínicas</th>
									</tr>
								 </thead>
								 <tbody>
								     <c:forEach items="${mealinteraction.getMealInteractions()}" var="itemMeal">
								   
		                                       <tr>
													<td>${mealinteraction.getDescription()}&nbsp;,&nbsp;${itemMeal.getMealElementDescription()}<br>
													${itemMeal.getSeverity().getIMASeverity() }<br>
													<c:if test="${itemMeal.getSeverity().getIMASeverity() == 'Verde' ||  itemMeal.getSeverity().getIMASeverity() == 'Verde|Sugerencia' || itemMeal.getSeverity().getIMASeverity() == 'Verde|Espaciar'}">
													    <img  src='${pageContext.request.contextPath}/resources/images/report/s_verde.png' height='20px'/>
													</c:if>
													<c:if test="${itemMeal.getSeverity().getIMASeverity() == 'Rojo'||itemMeal.getSeverity().getIMASeverity() == 'rojo'}">
													    <img  src='${pageContext.request.contextPath}/resources/images/report/s-rojo.png' height='20px'/>
													</c:if>
													 </td> 
													<td>
													  <div class="box box-solid" style="text-align: left;">
													      <div class="box-header with-border">
											                  <p class="box-title" style="font-size: 12px;">${itemMeal.getClinicalSummary()}</p>
											               </div>
											               <div class="box-body">
											                  <ul>
											                    <c:forEach items="${itemMeal.getClinicalReferences() }" var="itemClinical">
											                     <li>${itemClinical.getClinicalReference() }</li>
											                    </c:forEach>
											                  </ul>
											               </div>
													  </div>
													<br></td>
												</tr>
								   </c:forEach>
                </tbody>
		     </table>
                               </c:if>
						   </c:forEach>
		                </c:forEach>
       
          </c:if>
      <label class="sizeFontLetter text-red">Contraindicaciones:</label><br>
      <span id="contraindicaciones-${status.count}" class="sizeFontLetter text-muted-opacity">No reporta contraindicaciones</span><br>
      <c:if test="${contraindications !=  null }">
         <c:forEach items="${contraindications}" var="contraindication">
           <c:if test="${drug.getCategotyId() == contraindication.getCategoryId() && drug.getDivisionId() == contraindication.getDivisionId() && drug.getPharmaFormId() == contraindication.getPharmaFormId() && drug.getProductId() == contraindication.getProductId() }">
              <script type="text/javascript">
			       var identifiyer = ${status.count};
			       $("#contraindicaciones-"+identifiyer).hide();
		       </script>
		       <c:forEach items="${contraindication.getActiveSubstanceContraindications() }" var="activeSubstance">
		       
		       <div class="row row-component">
		          <div class="col-md-12 row-component-header">
		            <p>${activeSubstance.getDescription() }</p>
		          </div>
		          <div class="col-md-12">
		             <div class="row">
		             <c:if test="${activeSubstance.getICDContraindications().size() > 0 }">
		                <div class="col-md-12">
		                   <div class="row row-component-colum">
		                      <div class="col-md-3 row-component-colum-principal">
		                      <p>CIE - 10</p>
		                      </div>
		                      <div class="col-md-9 row-component-simple-colum">
		                       <ul>
		                          <c:forEach items="${activeSubstance.getICDContraindications() }" var="icdContraindications">
		                             <li>${icdContraindications.getSpanishDescription() }</li>
		                          </c:forEach>
		                       </ul>
		                      </div>
		                   </div>
		                </div>
		             </c:if>
		             <c:if test="${activeSubstance.getPharmacologicalGroupContraindications().size() > 0 }">
		                <div class="col-md-12">
		                  <div class="row row-component-colum">
		                      <div class="col-md-3 row-component-colum-principal">
		                        <p>GRUPO FARMACOLÓGICO</p>
		                      </div>
		                      <div class="col-md-9 row-component-simple-colum">
		                        <ul>
		                           <c:forEach items="${activeSubstance.getPharmacologicalGroupContraindications()}" var="groupContraindication">
		                             <li>${groupContraindication.getGroupName() }</li>
		                           </c:forEach>
		                        </ul>
		                      </div>
		                  </div>
		                </div>
		             </c:if>
		             <c:if test="${activeSubstance.getPhysiologicalContraindications().size()>0}">
		                <div class="col-md-12">
		                  <div class="row row-component-colum">
		                      <div class="col-md-3 row-component-colum-principal">
		                      <p>FISIOLÓGICAS</p>
		                      </div>
		                      <div class="col-md-9 row-component-simple-colum">
		                        <ul> 
		                          <c:forEach items="${activeSubstance.getPhysiologicalContraindications() }" var="physioContraindication">
		                             <li>${physioContraindication.getPhysContraindicationName() }</li>
		                          </c:forEach>
		                        
		                        </ul>
		                      </div>
		                  </div>
		                </div>
		             </c:if>
		             <c:if test="${activeSubstance.getHypersensibilityContraindications().size()>0 }">
		                <div class="col-md-12">
		                  <div class="row row-component-colum">
		                      <div class="col-md-3 row-component-colum-principal">
		                      <p>HIPERSENSIBILIDAD</p>
		                      </div>
		                      <div class="col-md-9 row-component-simple-colum">
		                        <ul>
		                          <c:forEach items="${activeSubstance.getHypersensibilityContraindications()}" var="HyperContraindications">
		                            <li>${HyperContraindications.getHypersensibilityName()}</li>
		                          </c:forEach>
		                        </ul>
		                      </div>
		                  </div>
		                </div>
		             </c:if>
		             <c:if test="${activeSubstance.getActiveSubstanceContraindications().size() >0 }">
		                <div class="col-md-12">
		                  <div class="row row-component-colum">
		                      <div class="col-md-3 row-component-colum-principal">
		                      <p>SUSTANCIAS ACTIVAS </p>
		                      </div>
		                      <div class="col-md-9 row-component-simple-colum">
		                        <ul>
		                          <c:forEach items="${activeSubstance.getActiveSubstanceContraindications()}" var="substanceContra">
		                            <li>${substanceContra.getDescription() }</li>
		                          </c:forEach>
		                        </ul>
		                      </div>
		                  </div>
		                </div>
		             </c:if>
		             <c:if test="${activeSubstance.getOtherContraindications().size()>0}">
		                <div class="col-md-12">
		                  <div class="row row-component-colum">
		                      <div class="col-md-3 row-component-colum-principal">
		                      <p>OTRAS</p>
		                      </div>
		                      <div class="col-md-9 row-component-simple-colum">
		                       <ul>
		                         <c:forEach items="${activeSubstance.getOtherContraindications() }" var="otherContraindication">
		                          <li>${otherContraindication.getElementName() }</li>
		                         </c:forEach>
		                       </ul>
		                      </div>
		                  </div>
		                </div>
		             </c:if>
		             <c:if test="${activeSubstance.getContraindicationComments().size()>0}">
		                <div class="col-md-12">
		                  <div class="row row-component-colum">
		                      <div class="col-md-3 row-component-colum-principal">
		                       <p>Comentarios :</p>
		                      </div>
		                      <div class="col-md-9 row-component-simple-colum">
		                       <ul>
		                         <c:forEach items="${activeSubstance.getContraindicationComments()}" var="contraComments">
		                           <li>${contraComments.getComments()}</li>
		                         </c:forEach>
		                       </ul> 
		                      </div>
		                  </div>
		                </div>
		             </c:if>
		                
		             </div>
		          </div>
		       </div>
		       </c:forEach>
		       
           </c:if>
         </c:forEach>
      </c:if>
      <label class="sizeFontLetter text-red">Duplicidad Terapéutica:</label><br>
      <span id="therapeutic-${status.count}" class="sizeFontLetter text-muted-opacity">No reporta Duplicidad Terapéutica</span><br>
      <c:if test="${therapeuticDou !=  null }">
      <c:forEach items="${therapeuticDou }" var="therapeutic">
      <c:if test="${drug.getCategotyId() == therapeutic.getCategoryId() && drug.getDivisionId() == therapeutic.getDivisionId() && drug.getPharmaFormId() == therapeutic.getPharmaFormId() && drug.getProductId() == therapeutic.getProductId() }">
        <c:if test="${therapeutic.getATCOMSDoubleness().size()>0 }">
           <script type="text/javascript">
                  var identifiyer = ${status.count};
                    $("#therapeutic-"+identifiyer).hide();
                  </script>
							<table class="table tableresponsiveStackable">
								 <thead>
									<tr>
										<th>Medicamento(s)</th>
										<th>ATC (OMS)</th>
									</tr>
								 </thead>
								 <tbody>
								 <c:forEach items="${therapeutic.getATCOMSDoubleness()}" var="ATCCOMSDOU">
								 
								   <tr>
								   <td>
								   <c:forEach items="${ATCCOMSDOU.getATCOMSDoublenessProducts()}" var="atccomsdouProducts">
											${atccomsdouProducts.getBrand()}<br>
											
								   </c:forEach>
								   </td>
								   <c:if test="${ATCCOMSDOU.getATCOMSDoublenessProducts().size()>0 }">
								   <td>Pertenecen a <strong>${ATCCOMSDOU.getTherapeuticKey()}-${ ATCCOMSDOU.getSpanishDescription() }</strong>, podría tratarse de una duplicidad terapéutica.</td>
								   </c:if>
										</tr>
								 </c:forEach>
								 </tbody>
								 </table>
					
        </c:if>
      </c:if>
      </c:forEach>
      </c:if>
      <label class="sizeFontLetter text-red">Interacción Medicamento - Medicamento:</label><br>
      <span id="interac-medi-medi-${status.count}" class="sizeFontLetter text-muted-opacity">No reporta interacción</span><br>
      <c:if test="${IMDDIinteractions !=  null }">
        <c:forEach items="${IMDDIinteractions }" var="IMDDIinteraction">
          <c:if test="${drug.getCategotyId() == IMDDIinteraction.getCategoryId() && drug.getDivisionId() == IMDDIinteraction.getDivisionId() && drug.getPharmaFormId() == IMDDIinteraction.getPharmaFormId() && drug.getProductId() == IMDDIinteraction.getProductId() }">
             <c:if test="${IMDDIinteraction.getInteractionSubstances().size()>0 }">
                <script type="text/javascript">
                  var identifiyer = ${status.count};
                    $("#interac-medi-medi-"+identifiyer).hide();
                  </script>
                  
                         <table class="table tableresponsiveStackable">
								 <thead>
									<tr>
										<th style="min-width: 205px;">DESCRIPCIÓN MEDICAMENTO</th>
										<th>REFERENCIAS</th>
									</tr>
								 </thead>
								 <tbody>
								     <c:forEach items="${IMDDIinteraction.getInteractionSubstances()}" var="itemISubtance">
								       <c:forEach items="${itemISubtance.getSeverities() }" var="severity">
								   
		                                       <tr style="min-width: 205px;">
													<td>${itemISubtance.getIBrand()}<br/>${itemISubtance.getIActiveSubstance()}<br>
													${itemISubtance.getIPharmaForm()}<br>${itemISubtance.getIDivisionShortName() }<br/> Gravedad<br/>
													
													<c:if test="${severity.getColorSemaphore() == 'Verde'}">
													    <img  src='${pageContext.request.contextPath}/resources/images/report/s_verde.png' height='20px'/><br>${severity.getColorSemaphore()}
													</c:if>
													<c:if test="${severity.getColorSemaphore() == 'Rojo'}">
													    <img  src='${pageContext.request.contextPath}/resources/images/report/s_rojo.png' height='20px'/><br>${severity.getColorSemaphore()}
													</c:if>
													<c:if test="${severity.getColorSemaphore() == 'Amarillo'}">
													    <img  src='${pageContext.request.contextPath}/resources/images/report/s_amarillo.png' height='20px'/><br>${severity.getColorSemaphore()}
													</c:if>
													<c:if test="${severity.getColorSemaphore() == 'Gris'}">
													    <img  src='${pageContext.request.contextPath}/resources/images/report/s_gris.png' height='20px'/><br>${severity.getColorSemaphore()}
													</c:if>
													<c:if test="${severity.getColorSemaphore() == 'Negro'}">
													    <img  src='${pageContext.request.contextPath}/resources/images/report/s_negro.png' height='20px'/><br>${severity.getColorSemaphore()}
													</c:if>
													<c:if test="${severity.getColorSemaphore() == 'Blanco'}">
													    <img  src='${pageContext.request.contextPath}/resources/images/report/s_blanco.png' height='20px'/><br>${severity.getColorSemaphore()}
													</c:if>
													 </td> 
													<td>
													  <div class="box box-solid" style="text-align: left;">
											               <div class="box-body">
											                  <ul>
											                    <c:forEach items="${severity.getIMDDIReferences() }" var="IMDDIReference">
											                     <li>${IMDDIReference.getClinicalReference()}</li>
											                    </c:forEach>
											                  </ul>
											               </div>
													  </div>
													<br></td>
												</tr>
								       </c:forEach>
								   </c:forEach>
                </tbody>
		     </table>
              </c:if>
          </c:if>
        </c:forEach>
      </c:if>
                </div>
       </div>
      </c:forEach>
    </div>
   </div>
   <div class="row" style="background-color: #ffffff;">
      <div class="col-md-12">
         <div class="box box-solid">
            <div class="box-header with-border">
               <label class=" text-red sizeFontLetter">Comentarios Generales:</label>
            </div>
            <div class="box-body">
              <textarea id="txtArea" name="comments"></textarea>
            </div>
         </div>
      </div>
   </div>
   
       <!-- Modal  -->
			<div aria-hidden="true" class="modal fade" id="modalClinicHistoryPDF" tabindex="-1" role="dialog" aria-labelledby="modalClinicHistoryPDF" >
			    <div class="modal-dialog" style="width:70%;min-height:650px;overflow-y: hidden;">
			        <div class="modal-content">
			            <div class="modal-header">
			                <h3 class="modal-title">Reporte Clinico</h3>
			            </div>
			
			            <div class="modal-body" id="modal-body-content-pdf">
			               
			            </div>
			
			            <div class="modal-footer">
			                      <button type="button" class="btn btn-primary" id="" data-dismiss="modal" >Cerrar</button>
			                <!--  <button type="button" class="btn btn-default" id="disagreeButton" data-dismiss="modal">Cerrar</button> -->
			            </div>
			        </div>
			    </div>
			</div>
</section>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/plm_clinical_report.js"></script>