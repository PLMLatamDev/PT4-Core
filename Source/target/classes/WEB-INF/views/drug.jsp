<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style>
	.container-publicity{
		width:100%;
		height:100px;
	}
	
	.banner-countries{
		background-image: url(${pageContext.request.contextPath}/resources/images/lg/BannerPaises.jpg);
		background-repeat: no-repeat;
		width:100%;
		background-size: contain;
	    background-position-x: center;
	    height: inherit;
	    max-height: 100%;
	}
	
	@media only screen and (min-width : 320px) {
		.container-publicity{
			width:100%;
			height:40px;
		}
	}

	@media only screen and (min-width : 480px) {
		.container-publicity{
			width:100%;
			height:49px;
		}
	}
	
	@media only screen and (min-width: 992px){ 
		.container-publicity{
			width:100%;
			height:80px;
		}
 	}
	
	
</style>

<div class="col-md-12" style="padding-left: 10px; padding-right: 0px;">
	<!-- Start Grid Basico -->
	<c:if test="${gSettings.isColPrice()==false && gSettings.isColBarCode()==false && gSettings.isCountryCodes()==false}">
		<div class="box-body" id="prescriptionGrid">
			<div class="renglon" id="tableHeader">
				<div class="tab-6 head">[+] Medicamento</div>
				<div class="tab-6 head">Sustancia</div>
				<div class="tab-6 head">Forma Farmacéutica</div>
				<div class="tab-6 head">Laboratorio</div>	
				<div class="tab-6 head">Presentación</div>
			</div>

		<!-- Objeto que se imprime cuando entra la busqueda sin autocomplete -->
		
			
			<c:set var="row" value="${0}" />
			<c:forEach var="products" items="${productsResult}">
					<c:if test="${products.getPresentations().size()>0}">
						<c:forEach var="presentation" items="${products.getPresentations()}"
							varStatus="loop">
							<c:set var="row" value="${row+1}" />
							<c:if test="${row%2==0}">
													
								<div class="renglon gris1" id="editable">
									<div class="tab-6 first">
										<div class="row">
										
											<c:if test="${gSettings.isPrescription()==true}">
												<div style="float: left;margin-left: 10%;">
													<input type="checkbox"
														value="${products.getCategotyId()},${products.getDivisionId()},${products.getProductId()},${products.getPharmaFormId()},${presentation.getPresentationId()}"
														class="check-prescription"
														description="{'CategotyId':${products.getCategotyId()},'DivisionId':${products.getDivisionId()},'ProductId':${products.getProductId()},'PharmaFormId':${products.getPharmaFormId()},'PresentationId':${presentation.getPresentationId()},'Brand':'${products.getBrand()}','PharmaForm':'${products.getPharmaForm()}','DivisionName':'${products.getDivisionShortName()}','Presentation':'${presentation.getPresentation()}',<c:if test="${products.getSubstances().size()<=1}"><c:forEach var="substance" items="${products.getSubstances()}">'Substance':'${substance.getDescription()}'</c:forEach></c:if><c:if test="${products.getSubstances().size()>=2}">'Substance':'<c:forEach var="substance" items="${products.getSubstances()}">${substance.getDescription()},\n</c:forEach>'</c:if>}">
												</div>
												
												<div  style="float: left;margin-left: 5%;line-height: 2;width: 70%;text-align: left;">
													<a class="first" id="prescription-brand-<c:out value="${row}"/>"
														href="${pageContext.request.contextPath}/descripcion-medicamento/${products.getDivisionId()}-${products.getCategotyId()}-${products.getProductId()}-${products.getPharmaFormId()}/0">
														${products.getBrand()}
													</a>
												</div>
											</c:if>
											<c:if test="${gSettings.isPrescription()==false}">
												<div  style="margin-left: 15%;line-height: 2;width: 70%;text-align: center;">
													<a class="first" id="prescription-brand-<c:out value="${row}"/>"
														href="${pageContext.request.contextPath}/descripcion-medicamento/${products.getDivisionId()}-${products.getCategotyId()}-${products.getProductId()}-${products.getPharmaFormId()}/0">
														${products.getBrand()}
													</a>
												</div>
											</c:if>
											
										</div>
									</div>
									<div class="tab-6"
										id="prescription-substance-<c:out value="${row}"/>">
										<c:if test="${products.getSubstances().size()<=1}">
											<c:forEach var="substance" items="${products.getSubstances()}">
															${substance.getDescription()}
														</c:forEach>
										</c:if>
										<c:if test="${products.getSubstances().size()>=2}">
											<c:forEach var="substance" items="${products.getSubstances()}">	
															${substance.getDescription()},<br />
											</c:forEach>
										</c:if>
									</div>
			
									<div class="tab-6"
										id="prescription-pharmaForm-<c:out value="${row}"/>">${products.getPharmaForm()}</div>
									<div class="tab-6"
										id="prescription-division-<c:out value="${row}"/>">${products.getDivisionShortName()}</div>
																	
									<div class="tab-6" id="prescription-presentation-<c:out value="${row}"/>">
										${presentation.getPresentation()}
									</div>
									
								</div>
								
							</c:if>
							<c:if test="${row%2!=0}">
								<div class="renglon gris2" id="editable">
									<div class="tab-6 first">
										<div class="row">
											<c:if test="${gSettings.isPrescription()==true}">
												<div style="float: left;margin-left: 10%;">
													<input type="checkbox"
														value="${products.getCategotyId()},${products.getDivisionId()},${products.getProductId()},${products.getPharmaFormId()},${presentation.getPresentationId()}"
														class="check-prescription"
														description="{'CategotyId':${products.getCategotyId()},'DivisionId':${products.getDivisionId()},'ProductId':${products.getProductId()},'PharmaFormId':${products.getPharmaFormId()},'PresentationId':${presentation.getPresentationId()},'Brand':'${products.getBrand()}','PharmaForm':'${products.getPharmaForm()}','DivisionName':'${products.getDivisionShortName()}','Presentation':'${presentation.getPresentation()}',<c:if test="${products.getSubstances().size()<=1}"><c:forEach var="substance" items="${products.getSubstances()}">'Substance':'${substance.getDescription()}'</c:forEach></c:if><c:if test="${products.getSubstances().size()>=2}">'Substance':'<c:forEach var="substance" items="${products.getSubstances()}">${substance.getDescription()},\n</c:forEach>'</c:if>}">
												</div>
												<div style="float: left;margin-left: 5%;line-height: 2;width: 70%;text-align: left;">
													<a class="first" id="prescription-brand-<c:out value="${row}"/>"
														href="${pageContext.request.contextPath}/descripcion-medicamento/${products.getDivisionId()}-${products.getCategotyId()}-${products.getProductId()}-${products.getPharmaFormId()}/0">
														${products.getBrand()}
													</a>
												</div>
											</c:if>
											<c:if test="${gSettings.isPrescription()==false}">
												<div style="margin-left: 15%;line-height: 2;width: 70%;text-align: center;">
													<a class="first" id="prescription-brand-<c:out value="${row}"/>"
														href="${pageContext.request.contextPath}/descripcion-medicamento/${products.getDivisionId()}-${products.getCategotyId()}-${products.getProductId()}-${products.getPharmaFormId()}/0">
														${products.getBrand()}
													</a>
												</div>
											</c:if>
										</div>
									</div>
									<div class="tab-6"
										id="prescription-substance-<c:out value="${row}"/>">
										<c:if test="${products.getSubstances().size()<=1}">
											<c:forEach var="substance" items="${products.getSubstances()}">
															${substance.getDescription()}
														</c:forEach>
										</c:if>
										<c:if test="${products.getSubstances().size()>=2}">
											<c:forEach var="substance" items="${products.getSubstances()}">	
															${substance.getDescription()},<br />
											</c:forEach>
										</c:if>
									</div>
			
									<div class="tab-6"
										id="prescription-pharmaForm-<c:out value="${row}"/>">${products.getPharmaForm()}</div>
									<div class="tab-6"
										id="prescription-division-<c:out value="${row}"/>">${products.getDivisionShortName()}</div>

									
									<div class="tab-6" id="prescription-presentation-<c:out value="${row}"/>">
										${presentation.getPresentation()}
									</div>
								
								</div>
							</c:if>
						</c:forEach>
					</c:if>
				
					<c:if test="${products.getPresentations().size()<1}">
						<c:set var="row" value="${row+1}" />
						<c:if test="${row%2==0}">
							<div class="renglon gris1" id="editable">
									<div class="tab-6 first">
										<div class="row">
											<div style="float: left;margin-left: 10%;">
												<input type="checkbox"
													value="${products.getCategotyId()},${products.getDivisionId()},${products.getProductId()},${products.getPharmaFormId()},0"
													class="check-prescription"
													description="{'CategotyId':${products.getCategotyId()},'DivisionId':${products.getDivisionId()},'ProductId':${products.getProductId()},'PharmaFormId':${products.getPharmaFormId()},'PresentationId':null,'Brand':'${products.getBrand()}','PharmaForm':'${products.getPharmaForm()}','DivisionName':'${products.getDivisionShortName()}','Presentation':'${presentation.getPresentation()}',<c:if test="${products.getSubstances().size()<=1}"><c:forEach var="substance" items="${products.getSubstances()}">'Substance':'${substance.getDescription()}'</c:forEach></c:if><c:if test="${products.getSubstances().size()>=2}">'Substance':'<c:forEach var="substance" items="${products.getSubstances()}">${substance.getDescription()},\n</c:forEach>'</c:if>}">
											</div>
											<div  style="float: left;margin-left: 5%;line-height: 2;width: 70%;text-align: left;">
												<a class="first" id="prescription-brand-<c:out value="${row}"/>"
													href="${pageContext.request.contextPath}/descripcion-medicamento/${products.getDivisionId()}-${products.getCategotyId()}-${products.getProductId()}-${products.getPharmaFormId()}/0">
													${products.getBrand()}
												</a>
											</div>
										</div>
									</div>
									<div class="tab-6"
										id="prescription-substance-<c:out value="${row}"/>">
										<c:if test="${products.getSubstances().size()<=1}">
											<c:forEach var="substance" items="${products.getSubstances()}">
															${substance.getDescription()}
														</c:forEach>
										</c:if>
										<c:if test="${products.getSubstances().size()>=2}">
											<c:forEach var="substance" items="${products.getSubstances()}">	
															${substance.getDescription()},<br />
											</c:forEach>
										</c:if>
									</div>
			
									<div class="tab-6"
										id="prescription-pharmaForm-<c:out value="${row}"/>">${products.getPharmaForm()}</div>
									<div class="tab-6"
										id="prescription-division-<c:out value="${row}"/>">${products.getDivisionShortName()}</div>
	
									<div class="tab-6" id="prescription-presentation-<c:out value="${row}"/>">
										Sin Presentación
									</div>
								
							</div>
						</c:if>
						<c:if test="${row%2!=0}">
							<div class="renglon gris2" id="editable">
									<div class="tab-6 first">
										<div class="row">
											<div style="float: left;margin-left: 10%;">
												<input type="checkbox"
													value="${products.getCategotyId()},${products.getDivisionId()},${products.getProductId()},${products.getPharmaFormId()},0"
													class="check-prescription"
													description="{'CategotyId':${products.getCategotyId()},'DivisionId':${products.getDivisionId()},'ProductId':${products.getProductId()},'PharmaFormId':${products.getPharmaFormId()},'PresentationId':null,'Brand':'${products.getBrand()}','PharmaForm':'${products.getPharmaForm()}','DivisionName':'${products.getDivisionShortName()}','Presentation':'${presentation.getPresentation()}',<c:if test="${products.getSubstances().size()<=1}"><c:forEach var="substance" items="${products.getSubstances()}">'Substance':'${substance.getDescription()}'</c:forEach></c:if><c:if test="${products.getSubstances().size()>=2}">'Substance':'<c:forEach var="substance" items="${products.getSubstances()}">${substance.getDescription()},\n</c:forEach>'</c:if>}">
											</div>
											<div  style="float: left;margin-left: 5%;line-height: 2;width: 70%;text-align: left;">
												<a class="first" id="prescription-brand-<c:out value="${row}"/>"
													href="${pageContext.request.contextPath}/descripcion-medicamento/${products.getDivisionId()}-${products.getCategotyId()}-${products.getProductId()}-${products.getPharmaFormId()}/0">
													${products.getBrand()}
												</a>
											</div>
										</div>
									</div>
									<div class="tab-6"
										id="prescription-substance-<c:out value="${row}"/>">
										<c:if test="${products.getSubstances().size()<=1}">
											<c:forEach var="substance" items="${products.getSubstances()}">
															${substance.getDescription()}
														</c:forEach>
										</c:if>
										<c:if test="${products.getSubstances().size()>=2}">
											<c:forEach var="substance" items="${products.getSubstances()}">	
															${substance.getDescription()},<br />
											</c:forEach>
										</c:if>
									</div>
			
									<div class="tab-6"
										id="prescription-pharmaForm-<c:out value="${row}"/>">${products.getPharmaForm()}</div>
									<div class="tab-6"
										id="prescription-division-<c:out value="${row}"/>">${products.getDivisionShortName()}</div>
	
									<div class="tab-6" id="prescription-presentation-<c:out value="${row}"/>">
										Sin Presentación
									</div>
								
							</div>
						</c:if>
					</c:if>
				
			</c:forEach>
		</div>
	</c:if>
	
	<!-- End Grid Basico-->
	
	
	<!-- Start Grid Dinamico -->
	<c:if test="${gSettings.isColPrice()==true || gSettings.isColBarCode()==true || gSettings.isCountryCodes()==true}">
		<div class="box-body" id="prescriptionGrid">
			<div class="renglon" id="tableHeader">
				<div class="tab-7 head">[+] Medicamento</div>
				<div class="tab-7 head">Sustancia</div>
				<div class="tab-7 head">Forma Farmacéutica</div>
				<div class="tab-7 head">Laboratorio</div>
				
				<c:if test="${gSettings.isCountryCodes()}">
					<div class="tab-7 head">Países</div>
				</c:if>
				
				<div class="tab-7 head">Presentación</div>
				
				<c:if test="${gSettings.isColPrice()}">
					<div class="tab-7 head">Precio</div>
				</c:if>
				
				<c:if test="${gSettings.isColBarCode()}">
					<div class="tab-7 head">Código de Barra</div>
				</c:if>
				
			</div>

		<!-- Objeto que se imprime cuando entra la busqueda sin autocomplete -->
		
			<c:set var="row" value="${0}" />
			<c:forEach var="products" items="${productsResult}">
					<c:if test="${products.getPresentations().size()>0}">
						<c:forEach var="presentation" items="${products.getPresentations()}"
							varStatus="loop">
							<c:set var="row" value="${row+1}" />
							<c:if test="${row%2==0}">
													
								<div class="renglon gris1" id="editable">
									<div class="tab-7 first">
										<div class="row">
										
											<c:if test="${gSettings.isPrescription()==true}">
												<div style="float: left;margin-left: 10%;">
													<input type="checkbox"
														value="${products.getCategotyId()},${products.getDivisionId()},${products.getProductId()},${products.getPharmaFormId()},${presentation.getPresentationId()}"
														class="check-prescription"
														description="{'CategotyId':${products.getCategotyId()},'DivisionId':${products.getDivisionId()},'ProductId':${products.getProductId()},'PharmaFormId':${products.getPharmaFormId()},'PresentationId':${presentation.getPresentationId()},'Brand':'${products.getBrand()}','PharmaForm':'${products.getPharmaForm()}','DivisionName':'${products.getDivisionShortName()}','Presentation':'${presentation.getPresentation()}',<c:if test="${products.getSubstances().size()<=1}"><c:forEach var="substance" items="${products.getSubstances()}">'Substance':'${substance.getDescription()}'</c:forEach></c:if><c:if test="${products.getSubstances().size()>=2}">'Substance':'<c:forEach var="substance" items="${products.getSubstances()}">${substance.getDescription()},\n</c:forEach>'</c:if>}">
												</div>
												
												<div  style="float: left;margin-left: 5%;line-height: 2;width: 70%;text-align: left;">
													<a class="first" id="prescription-brand-<c:out value="${row}"/>"
														href="${pageContext.request.contextPath}/descripcion-medicamento/${products.getDivisionId()}-${products.getCategotyId()}-${products.getProductId()}-${products.getPharmaFormId()}/0">
														${products.getBrand()}
													</a>
												</div>
											</c:if>
											<c:if test="${gSettings.isPrescription()==false}">
												<div  style="margin-left: 15%;line-height: 2;width: 70%;text-align: center;">
													<a class="first" id="prescription-brand-<c:out value="${row}"/>"
														href="${pageContext.request.contextPath}/descripcion-medicamento/${products.getDivisionId()}-${products.getCategotyId()}-${products.getProductId()}-${products.getPharmaFormId()}/0">
														${products.getBrand()}
													</a>
												</div>
											</c:if>
											
										</div>
									</div>
									<div class="tab-7"
										id="prescription-substance-<c:out value="${row}"/>">
										<c:if test="${products.getSubstances().size()<=1}">
											<c:forEach var="substance" items="${products.getSubstances()}">
															${substance.getDescription()}
														</c:forEach>
										</c:if>
										<c:if test="${products.getSubstances().size()>=2}">
											<c:forEach var="substance" items="${products.getSubstances()}">	
															${substance.getDescription()},<br />
											</c:forEach>
										</c:if>
									</div>
			
									<div class="tab-7"
										id="prescription-pharmaForm-<c:out value="${row}"/>">${products.getPharmaForm()}</div>
									<div class="tab-7"
										id="prescription-division-<c:out value="${row}"/>">${products.getDivisionShortName()}</div>
										
									<c:if test="${gSettings.isCountryCodes()}">
										<div class="tab-7" id="prescription-countries-<c:out value="${row}"/>">${products.getCountryCodes()}</div>
									</c:if>
		
									<div class="tab-7" id="prescription-presentation-<c:out value="${row}"/>">
										${presentation.getPresentation()}
									</div>
									
									<c:if test="${gSettings.isColPrice()}">
										<div class="tab-7" id="prescription-average-price-<c:out value="${row}"/>">
											<c:forEach var="averagePrices" items="${presentation.getAveragePrices()}" varStatus="loop">
												<c:if test="${loop.index==0}">
													<c:if test="${averagePrices.getAveragePrice().length()>0}">
														$ ${averagePrices.getAveragePrice()}
													</c:if>
												</c:if>
			 								</c:forEach> 
										</div>
									</c:if>
									
									<c:if test="${gSettings.isColBarCode()}">
										<div class="tab-7" id="prescription-barcode-<c:out value="${row}"/>">
											<c:forEach var="averagePrices" items="${presentation.getAveragePrices()}" varStatus="loop">
													<c:if test="${loop.index==0}">
														${averagePrices.getBarCode()}
													</c:if>
											</c:forEach>
										</div>
									</c:if>
									
								</div>
								
							</c:if>
							<c:if test="${row%2!=0}">
								<div class="renglon gris2" id="editable">
									<div class="tab-7 first">
										<div class="row">
											<c:if test="${gSettings.isPrescription()==true}">
												<div style="float: left;margin-left: 10%;">
													<input type="checkbox"
														value="${products.getCategotyId()},${products.getDivisionId()},${products.getProductId()},${products.getPharmaFormId()},${presentation.getPresentationId()}"
														class="check-prescription"
														description="{'CategotyId':${products.getCategotyId()},'DivisionId':${products.getDivisionId()},'ProductId':${products.getProductId()},'PharmaFormId':${products.getPharmaFormId()},'PresentationId':${presentation.getPresentationId()},'Brand':'${products.getBrand()}','PharmaForm':'${products.getPharmaForm()}','DivisionName':'${products.getDivisionShortName()}','Presentation':'${presentation.getPresentation()}',<c:if test="${products.getSubstances().size()<=1}"><c:forEach var="substance" items="${products.getSubstances()}">'Substance':'${substance.getDescription()}'</c:forEach></c:if><c:if test="${products.getSubstances().size()>=2}">'Substance':'<c:forEach var="substance" items="${products.getSubstances()}">${substance.getDescription()},\n</c:forEach>'</c:if>}">
												</div>
												<div style="float: left;margin-left: 5%;line-height: 2;width: 70%;text-align: left;">
													<a class="first" id="prescription-brand-<c:out value="${row}"/>"
														href="${pageContext.request.contextPath}/descripcion-medicamento/${products.getDivisionId()}-${products.getCategotyId()}-${products.getProductId()}-${products.getPharmaFormId()}/0">
														${products.getBrand()}
													</a>
												</div>
											</c:if>
											<c:if test="${gSettings.isPrescription()==false}">
												<div style="margin-left: 15%;line-height: 2;width: 70%;text-align: center;">
													<a class="first" id="prescription-brand-<c:out value="${row}"/>"
														href="${pageContext.request.contextPath}/descripcion-medicamento/${products.getDivisionId()}-${products.getCategotyId()}-${products.getProductId()}-${products.getPharmaFormId()}/0">
														${products.getBrand()}
													</a>
												</div>
											</c:if>
										</div>
									</div>
									<div class="tab-7"
										id="prescription-substance-<c:out value="${row}"/>">
										<c:if test="${products.getSubstances().size()<=1}">
											<c:forEach var="substance" items="${products.getSubstances()}">
															${substance.getDescription()}
														</c:forEach>
										</c:if>
										<c:if test="${products.getSubstances().size()>=2}">
											<c:forEach var="substance" items="${products.getSubstances()}">	
															${substance.getDescription()},<br />
											</c:forEach>
										</c:if>
									</div>
			
									<div class="tab-7"
										id="prescription-pharmaForm-<c:out value="${row}"/>">${products.getPharmaForm()}</div>
									<div class="tab-7"
										id="prescription-division-<c:out value="${row}"/>">${products.getDivisionShortName()}</div>
										
									<c:if test="${gSettings.isCountryCodes()}">
										<div class="tab-7" id="prescription-countries-<c:out value="${row}"/>">${products.getCountryCodes()}</div>
									</c:if>
		
									<div class="tab-7" id="prescription-presentation-<c:out value="${row}"/>">
										${presentation.getPresentation()}
									</div>
									
									<c:if test="${gSettings.isColPrice()}">
										<div class="tab-7" id="prescription-average-price-<c:out value="${row}"/>">
											<c:forEach var="averagePrices" items="${presentation.getAveragePrices()}" varStatus="loop">
												<c:if test="${loop.index==0}">
													<c:if test="${averagePrices.getAveragePrice().length()>0}">
														$ ${averagePrices.getAveragePrice()}
													</c:if>
												</c:if>
			 								</c:forEach> 
										</div>
									</c:if>
		
									<c:if test="${gSettings.isColBarCode()}">
										<div class="tab-7" id="prescription-barcode-<c:out value="${row}"/>">
											<c:forEach var="averagePrices" items="${presentation.getAveragePrices()}" varStatus="loop">
													<c:if test="${loop.index==0}">
														${averagePrices.getBarCode()}
													</c:if>
											</c:forEach>
										</div>
									</c:if>
									
								</div>
							</c:if>
						</c:forEach>
					</c:if>
				
					<c:if test="${products.getPresentations().size()<1}">
						<c:set var="row" value="${row+1}" />
						<c:if test="${row%2==0}">
							<div class="renglon gris1" id="editable">
									<div class="tab-7 first">
										<div class="row">
											<div style="float: left;margin-left: 10%;">
												<input type="checkbox"
													value="${products.getCategotyId()},${products.getDivisionId()},${products.getProductId()},${products.getPharmaFormId()},0"
													class="check-prescription"
													description="{'CategotyId':${products.getCategotyId()},'DivisionId':${products.getDivisionId()},'ProductId':${products.getProductId()},'PharmaFormId':${products.getPharmaFormId()},'PresentationId':null,'Brand':'${products.getBrand()}','PharmaForm':'${products.getPharmaForm()}','DivisionName':'${products.getDivisionShortName()}','Presentation':'${presentation.getPresentation()}',<c:if test="${products.getSubstances().size()<=1}"><c:forEach var="substance" items="${products.getSubstances()}">'Substance':'${substance.getDescription()}'</c:forEach></c:if><c:if test="${products.getSubstances().size()>=2}">'Substance':'<c:forEach var="substance" items="${products.getSubstances()}">${substance.getDescription()},\n</c:forEach>'</c:if>}">
											</div>
											<div  style="float: left;margin-left: 5%;line-height: 2;width: 70%;text-align: left;">
												<a class="first" id="prescription-brand-<c:out value="${row}"/>"
													href="${pageContext.request.contextPath}/descripcion-medicamento/${products.getDivisionId()}-${products.getCategotyId()}-${products.getProductId()}-${products.getPharmaFormId()}/0">
													${products.getBrand()}
												</a>
											</div>
										</div>
									</div>
									<div class="tab-7"
										id="prescription-substance-<c:out value="${row}"/>">
										<c:if test="${products.getSubstances().size()<=1}">
											<c:forEach var="substance" items="${products.getSubstances()}">
															${substance.getDescription()}
														</c:forEach>
										</c:if>
										<c:if test="${products.getSubstances().size()>=2}">
											<c:forEach var="substance" items="${products.getSubstances()}">	
															${substance.getDescription()},<br />
											</c:forEach>
										</c:if>
									</div>
			
									<div class="tab-7"
										id="prescription-pharmaForm-<c:out value="${row}"/>">${products.getPharmaForm()}</div>
									<div class="tab-7"
										id="prescription-division-<c:out value="${row}"/>">${products.getDivisionShortName()}</div>
									
									<c:if test="${gSettings.isCountryCodes()}">
										<div class="tab-7" id="prescription-countries-<c:out value="${row}"/>">1,2,3,4,5,6</div>
									</c:if>
									
									<div class="tab-7" id="prescription-presentation-<c:out value="${row}"/>">
										Sin Presentación
									</div>
									<c:if test="${gSettings.isColPrice()}">
										<div class="tab-7" id="prescription-average-price-<c:out value="${row}"/>">
											&nbsp;
										</div>
									</c:if>
									
									<c:if test="${gSettings.isColBarCode()}">
										<div class="tab-7" id="prescription-barcode-<c:out value="${row}"/>">
											&nbsp;
										</div>
									</c:if>
							</div>
						</c:if>
						<c:if test="${row%2!=0}">
							<div class="renglon gris2" id="editable">
									<div class="tab-7 first">
										<div class="row">
											<div style="float: left;margin-left: 10%;">
												<input type="checkbox"
													value="${products.getCategotyId()},${products.getDivisionId()},${products.getProductId()},${products.getPharmaFormId()},0"
													class="check-prescription"
													description="{'CategotyId':${products.getCategotyId()},'DivisionId':${products.getDivisionId()},'ProductId':${products.getProductId()},'PharmaFormId':${products.getPharmaFormId()},'PresentationId':null,'Brand':'${products.getBrand()}','PharmaForm':'${products.getPharmaForm()}','DivisionName':'${products.getDivisionShortName()}','Presentation':'${presentation.getPresentation()}',<c:if test="${products.getSubstances().size()<=1}"><c:forEach var="substance" items="${products.getSubstances()}">'Substance':'${substance.getDescription()}'</c:forEach></c:if><c:if test="${products.getSubstances().size()>=2}">'Substance':'<c:forEach var="substance" items="${products.getSubstances()}">${substance.getDescription()},\n</c:forEach>'</c:if>}">
											</div>
											<div  style="float: left;margin-left: 5%;line-height: 2;width: 70%;text-align: left;">
												<a class="first" id="prescription-brand-<c:out value="${row}"/>"
													href="${pageContext.request.contextPath}/descripcion-medicamento/${products.getDivisionId()}-${products.getCategotyId()}-${products.getProductId()}-${products.getPharmaFormId()}/0">
													${products.getBrand()}
												</a>
											</div>
										</div>
									</div>
									<div class="tab-7"
										id="prescription-substance-<c:out value="${row}"/>">
										<c:if test="${products.getSubstances().size()<=1}">
											<c:forEach var="substance" items="${products.getSubstances()}">
															${substance.getDescription()}
														</c:forEach>
										</c:if>
										<c:if test="${products.getSubstances().size()>=2}">
											<c:forEach var="substance" items="${products.getSubstances()}">	
															${substance.getDescription()},<br />
											</c:forEach>
										</c:if>
									</div>
			
									<div class="tab-7"
										id="prescription-pharmaForm-<c:out value="${row}"/>">${products.getPharmaForm()}</div>
									<div class="tab-7"
										id="prescription-division-<c:out value="${row}"/>">${products.getDivisionShortName()}</div>
									
									<c:if test="${gSettings.isCountryCodes()}">
										<div class="tab-7" id="prescription-countries-<c:out value="${row}"/>">1,2,3,4,5,6</div>
									</c:if>
									
									<div class="tab-7" id="prescription-presentation-<c:out value="${row}"/>">
										Sin Presentación
									</div>
									<c:if test="${gSettings.isColPrice()}">
										<div class="tab-7" id="prescription-average-price-<c:out value="${row}"/>">
											&nbsp;
										</div>
									</c:if>
									
									<c:if test="${gSettings.isColBarCode()}">
										<div class="tab-7" id="prescription-barcode-<c:out value="${row}"/>">
											&nbsp;
										</div>
									</c:if>
							</div>
						</c:if>
					</c:if>
				
			</c:forEach>
		
		</div>
	</c:if>
	<!-- End Grid Dinamico -->
</div>

<c:if test="${gSettings.isCountryCodes()==true}">
	<nav class="navbar navbar-fixed-bottom" id="banner-down-horizontal" role="navigation">
		<div class="container-publicity">
			<div class="banner-countries"></div>
		</div>
	</nav>
</c:if>

