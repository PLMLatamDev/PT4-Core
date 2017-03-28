<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Prescripción Total 4.0</title>
	<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
	
	<link rel="icon" href="${pageContext.request.contextPath}/resources/images/favicon.ico">
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/images/favicon.ico" type="image/x-icon">
	
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/normalize.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/AdminLTE.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/skins/_all-skins.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/jquery-ui.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/formValidation.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/estilos.css">
	
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/alertify/alertify.default.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/alertify/alertify.core.css">
	
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/advertising.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/stackable/stacktable.css" />
	
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	
	<!-- libs -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/plm_predictive_243.js"></script>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/libraries/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/libraries/jquery-ui.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/libraries/bootstrap.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/libraries/lodash.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/libraries/app.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/libraries/knob/jquery.knob.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/libraries/formValidation.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/libraries/formValidation.Framework.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/libraries/jquery.mark.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/libraries/bootstrap-hover-dropdown.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/libraries/moment/moment.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/libraries/plm-calendar-1.0.0.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/libraries/alertify/alertify.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/libraries/modernizr.custom.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/libraries/stackable/stacktable.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/libraries/sockjs.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/libraries/stomp.min.js"></script>
	
	<!-- js -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/global_variables.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/prescriptionRest.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/main.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/autocomplete.js"></script>

</head>

<script type="text/javascript">
	var urlPath = "${pageContext.request.contextPath}";
	function goBack() {
		window.history.back();
	}

	var urlLogs = "${gSettings.getUrlPLMLogs()}";
	var RestPLMServices = {};
	RestPLMServices.CodeString = "${totalResult.getCodeString()}"; 
	RestPLMServices.EntityId = ${gSettings.getLogEntityId()};
	RestPLMServices.ISBN = "${gSettings.getIsbnMed()}";
	RestPLMServices.SearchTypeId = ${gSettings.getLogSearchTypeId()};
	RestPLMServices.TrackId = ${gSettings.getTargetId()};
	RestPLMServices.LogSourceId = ${gSettings.getLogSourceId()};
	RestPLMServices.LogPubMedEntity = ${gSettings.getLogPubMedEntityId()};
	RestPLMServices.LogSearchTypeId = ${gSettings.getLogSearchTypeId()};
	RestPLMServices.SourceId = ${gSettings.getLogSourceId()};
	RestPLMServices.EditionId = ${gSettings.getEditionId()};
	RestPLMServices.CountryIdPharma = ${gSettings.getCountryIdPharma()};
	RestPLMServices.UUID = "${uuid}";
	
	RestPLMServices.IMVisibility = ${gSettings.getInteracciones().get("im")};
	RestPLMServices.DDIVisibility = ${gSettings.getInteracciones().get("ddi")};
	RestPLMServices.IMAVisibility = ${gSettings.getInteracciones().get("ima")};
	RestPLMServices.CONVisibility = ${gSettings.getInteracciones().get("con")};
	RestPLMServices.Prescription = ${gSettings.isPrescription()};
	RestPLMServices.CountryCodes = ${gSettings.isCountryCodes()};
	
	RestPLMServices.MedicalPrescription = ${gSettings.isMedicalPrescription()};
	RestPLMServices.ClinicalReport = ${gSettings.isClinicalReport()};
	
	/*
	(function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
		(i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
			m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
	})(window,document,'script','https://www.google-analytics.com/analytics.js','ga');

	ga('create', 'UA-22228735-17', 'auto');
	ga('send', 'pageview');
	*/

	
	
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/webSocketPT4.js"></script>

<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<header class="main-header">
			<!-- Logo -->
			<div class="logo">
				<span class="logo-mini"><img style="margin-top: 18px;"
					src="<c:url value="/resources/images/PLMLogo-min.png"/>"></span> <span
					class="logo-lg"><img class="icon-plm-main"
					src="<c:url value="/resources/images/PLMLogo.png" />"></span>
			</div>
			<nav class="navbar navbar-static-top" role="navigation">
				<div id="form-search">
					<div class="sidebar-form">
						<div class="input-group">
							<!-- Buscador general -->
							<input type="text" id="txt-general-search"
								class="form-control form-main-search"
								placeholder="aspirina,neuralgia,ácido acetilsalicílico">
							<span class="input-group-btn">
								<button name="search" id="search-general-btn"
									class="btn btn-flat form-main-search">
									<span class="glyphicon glyphicon-search"></span>
								</button>
							</span>

							<!-- Buscador Pubmed -->
							<input type="text" id="txt-pubmed-search"
								class="form-control form-main-search"
								placeholder="Introduzca una sustancia"> <span
								class="input-group-btn">
								<button name="search" id="search-pubmed-btn"
									class="btn btn-flat form-main-search">
									<span class="glyphicon glyphicon-search"></span>
								</button>
							</span>

							<!-- Buscador Encyclopedias -->
							<input type="text" id="txt-encyclopedias-search"
								class="form-control form-main-search"
								placeholder="Introduzca una enciclopedia"> <span
								class="input-group-btn">
								<button name="search" id="search-encyclopedias-btn"
									class="btn btn-flat form-main-search">
									<span class="glyphicon glyphicon-search"></span>
								</button>
							</span>
						</div>
					</div>
				</div>
				<div class="navbar-custom-menu user-sesion">

					<ul class="nav navbar-nav">

						<!-- User Account: style can be found in dropdown.less -->
						<li class="dropdown topbar-user"><a data-hover="dropdown"
							href="#" class="dropdown-toggle"> <!-- <img src="dist/img/user2-160x160.jpg" class="user-image" alt="User Image">-->
								<i class="fa fa-lg fa-user-md"></i> <span class="hidden-xs">${UserNamePrincipal}</span>
						</a>
						<c:if test="${gSettings.getTypeLogin()==2 || gSettings.getTypeLogin()==3 || gSettings.getTypeLogin()==4 || gSettings.getTypeLogin()==5 }">
							<ul class="dropdown-menu dropdown-user pull-right">
								 <c:if test="${gSettings.getTypeLogin()!=5}">
									 <li><a  href="<c:url value="/perfil"   />" ><i class="fa fa-user-md"></i>Perfil</a></li>
								     <li><a href="<c:url value="/consultorios"   />"  ><i class="fa fa-hospital-o"></i>Consultorios</a></li>
								 </c:if>
							     <li><a href="#" data-toggle="modal" data-target="#termsModal"  data-title="Términos y condiciones" data-book-id="1"  ><i class="fa fa-info-circle"></i>Términos y Condiciones</a></li>
							     <li><a href="#" data-toggle="modal" data-target="#termsModal" data-title="Aviso de Privacidad" data-book-id="2" ><i class="fa fa-bell-o"></i>Aviso de Privacidad</a></li>
								 <li class="divider"></li>

								<li><a href="<c:url value="/cliente/${isUrlcompanyClient}?logout"/>"><i
										class="fa fa-power-off"></i>Cerrar Sesión</a></li>
							</ul>
						</c:if>
					 </li>

					


					</ul>
					
					
				</div>
				
				

			</nav>
			<nav class="navbar navbar-static-top" role="navigation">
				<div class="navbar-custom-menu" style="float: left;">
					<ul class="nav navbar-nav">
						<!-- Messages: style can be found in dropdown.less-->
						<li class="dropdown notifications-menu"><a href="#"
							title="Menú" class="dropdown-toggle" data-toggle="offcanvas"> <span
								class="glyphicon glyphicon-menu-hamburger menu-toggle"></span>
						</a></li>
						<li class="dropdown notifications-menu"><a
							title="Home" href="${pageContext.request.contextPath}/home"
							class="dropdown-toggle"> <span
								class="glyphicon glyphicon-home"></span>
						</a></li>
						<li class="dropdown notifications-menu" onclick="goBack()"
							style="cursor: pointer;" id="btn-back"><a class="dropdown-toggle"
							title="Atras" data-toggle="dropdown"> <span
								class="glyphicon glyphicon glyphicon-circle-arrow-left"></span>
						</a></li>
						
						<c:if test="${gSettings.isMedicalPrescription()}">
							<li class="dropdown notifications-menu"><a
								title="Historial de Recetas" href="${pageContext.request.contextPath}/receta/buscador"
								class="dropdown-toggle"> <span
									class="glyphicon glyphicon-folder-open"></span>
							</a></li>
						</c:if>
						<c:if test="${gSettings.isClinicalReport()}">
							<li class="dropdown notifications-menu"><a
								title="Historial de reportes" href="${pageContext.request.contextPath}/reporte/historial"
								class="dropdown-toggle"> <span
									class="glyphicon glyphicon-folder-open"></span>
							</a></li>
						</c:if>
						
						<c:if test="${gSettings.isMedicalPrescription()}">
							<li class="dropdown notifications-menu redirectMedicalPrescription" style="cursor: pointer;">
								<a style="cursor: pointer;" title="Receta">
									<span class="glyphicon glyphicon-list-alt"></span>
								</a>
							</li>
						</c:if>
						<c:if test="${gSettings.isClinicalReport()}">
							<li class="dropdown notifications-menu redirectClinicalReport" style="cursor: pointer;">
								<a style="cursor: pointer;" title="Reporte Clínico">
									<span class="glyphicon glyphicon-list-alt"></span>
								</a>
							</li>
						</c:if>
						<li class="dropdown notifications-menu"
							id="glyphicon-delete-all" style="cursor: pointer;">
							<a style="cursor: pointer;" title="Eliminar Todo">
								<span class="glyphicon glyphicon-trash"></span>
							</a>
						</li>
						
						<c:if test="${isAddAddres==false}">
							<c:if test="${gSettings.getTypeLogin()==4}">
								<!-- User Account: style can be found in dropdown.less -->
								<li class="dropdown notifications-menu" 
									id="icon-responsive-user" style="cursor: pointer;">
									<a data-hover="dropdown" href="#" class="dropdown-toggle">
										<i class="fa fa-bell-o"></i> <span class="label label-warning">1</span>
									</a>
								
									<ul class="dropdown-menu dropdown-user pull-right">
									    <li><a href="<c:url value="/consultorios"   />"  ><i class="fa fa-hospital-o"></i>Agregar Consultorio</a></li>
									</ul>
		
							 	</li>
							 </c:if>
			
						</c:if>
						
						
						<c:if test="${gSettings.isEncyclopedias()}">
							<li class="dropdown notifications-menu"
								id="glyphicon-print-encyclopedia" style="cursor: pointer;">
<%-- 								<a href="${pageContext.request.contextPath}/encyclopedias/print-encyclopedia" target="_blank" style="cursor: pointer;" title="Imprimir Encilopedia"> --%>
<!-- 									<span class="glyphicon glyphicon-print"></span> -->
<!-- 								</a> -->
								<a style="cursor: pointer;" title="Imprimir Encilopedia">
									<span class="glyphicon glyphicon-print"></span>
								</a>
							</li>
						</c:if>
						

					</ul>
				</div>
				<div class="navbar-custom-menu" id="icon-responsive-user">

					<ul class="nav navbar-nav">

						<!-- User Account: style can be found in dropdown.less -->
						<li class="dropdown topbar-user"><a data-hover="dropdown"
							href="#" class="dropdown-toggle"> <!-- <img src="dist/img/user2-160x160.jpg" class="user-image" alt="User Image">-->
								<i class="fa fa-lg fa-user-md"></i> <span class="hidden-xs">${UserNamePrincipal}</span>
						</a>

                            <c:if test="${gSettings.getTypeLogin()==2 || gSettings.getTypeLogin()==3 || gSettings.getTypeLogin()==4 || gSettings.getTypeLogin()==5 }">
								<ul class="dropdown-menu dropdown-user pull-right">
									<c:if test="${gSettings.getTypeLogin()!=5}">
									 	<li><a  href="<c:url value="/perfil"   />" ><i class="fa fa-user-md"></i>Perfil</a></li>
								     	<li><a href="<c:url value="/consultorios"   />"  ><i class="fa fa-hospital-o"></i>Consultorios</a></li>
								    </c:if>
								    <li><a href="#" data-toggle="modal" data-target="#termsModal"  data-title="Términos y condiciones" data-book-id="1"  ><i class="fa fa-info-circle"></i>Términos y Condiciones</a></li>
							     	<li><a href="#" data-toggle="modal" data-target="#termsModal" data-title="Aviso de Privacidad" data-book-id="2" ><i class="fa fa-bell-o"></i>Aviso de Privacidad</a></li>
									<li class="divider"></li>
	
									<li><a href="<c:url value="/cliente/${isUrlcompanyClient}?logout"/>"><i
										class="fa fa-power-off"></i>Cerrar Sesión</a></li>
								</ul>
							</c:if>
						</li>
					</ul>
				</div>
				
				<c:if test="${isAddAddres==false}">
					<c:if test="${gSettings.getTypeLogin()==4}">
						<div class="navbar-custom-menu user-sesion">
		
							<ul class="nav navbar-nav" id="add-address-info">
		
								<!-- User Account: style can be found in dropdown.less -->
								<li class="dropdown topbar-user"><a data-hover="dropdown"
									href="#" class="dropdown-toggle"> <!-- <img src="dist/img/user2-160x160.jpg" class="user-image" alt="User Image">-->
										<i class="fa fa-bell-o"></i> <span class="label label-warning">1</span>
								</a>
								
									<ul class="dropdown-menu dropdown-user pull-right">
										
									     <li><a href="<c:url value="/consultorios"   />"  ><i class="fa fa-hospital-o"></i>Agregar Consultorio</a></li>
			
									</ul>
		
							 </li>
		
		
							</ul>
						</div>
					</c:if>
				</c:if>
			</nav>

			<!-- ******************************* BLOQUEADOR ********************************* -->
			<div id="loaderView" class="display_loader text-center">
				<i class="fa fa-spinner fa-pulse"></i>&nbsp;&nbsp;<span>Cargando...</span>
			</div>
			<!-- *******************************FIN BLOQUEADOR ****************************** -->


		</header>
		<!-- Left side column. contains the logo and sidebar -->
		<aside class="main-sidebar">
			<!-- sidebar: style can be found in sidebar.less -->
			<section class="sidebar">
				<!-- Sidebar user panel -->
				<div class="user-panel" c style="background: #3a6f9f;"></div>
				
				<ul class="sidebar-menu">
					<c:if test="${gSettings.isRecursos()}">
						<li class="header">Recursos</li>
						<c:if test="${gSettings.isELearning()}">
							<li class="treeview"><a href="#"> <i class="fa fa-cloud"
								style="color: #86868a;"></i> <span>E-Learning</span> <i
								class="fa fa-angle-left pull-right"></i>
								</a>
									<ul class="treeview-menu">
										<c:if test="${gSettings.isAbstratcs()}">
											<li>
												<a href="${pageContext.request.contextPath}/e-learning/abstracts">
													Abstratcs
												</a>
											</li>
										</c:if>
										<c:if test="${gSettings.isAtlas()}">
											<li>
												<a href="#">
													Atlas
												</a>
											</li>
										</c:if>
										<c:if test="${gSettings.isPubmed()}">
											<li>
												<a href="${pageContext.request.contextPath}/e-learning/pubmed">
													Pubmed
												</a>
											</li>
										</c:if>
										<c:if test="${gSettings.isEncyclopedias()}">
											<li>
												<a href="${pageContext.request.contextPath}/encyclopedias/encyclopedias-home">
													Enciclopedia de la Salud
												</a>
											</li>
										</c:if>
									</ul></li>
						</c:if>
						<c:if test="${gSettings.isCalculadoras()}">
							<li class="treeview"><a href="" id="calculatorsClicked"> <i
									class="fa fa-th" style="color: #86868a;"></i> <span>Calculadoras</span>
									<i class="fa fa-angle-left pull-right"></i>
							</a> <!-- Calculadoras -->
								<ul id="calculatorByCategory" class="treeview-menu">
									<%-- <li><a href="${pageContext.request.contextPath}/calculadoras/indice-de-masa-corporal/1/1"><i class="fa fa-circle-o"></i>Indice de Masa Corporal<br>(IMC)</a></li>
									<li><a href="${pageContext.request.contextPath}/calculadoras/osmolaridad-plasmatica/1/2"><i class="fa fa-circle-o"></i>Osmolaridad Plasmática</a></li>
				 --%>
									<c:forEach items="${calculators}" var="calculator">
		
										<c:if test="${calculator.isShowBycategory() == true}">
											<ul>${calculator.getCategoryName()}
												<c:forEach items="${calculator.getCalculators()}"
													var="calculatorByCategory">
													<li><a style="font-size: 12px;"
														href="${pageContext.request.contextPath}/calculadoras/${calculator.getCategoryName()}/${calculatorByCategory.getPath()}/${calculator.getCategoryId()}/${calculatorByCategory.getId()}"><dl
																class="dl-horizontal">
																<dt
																	style="text-align: left !important; font-weight: normal;">
																	<i class="fa fa-circle-o"></i>&nbsp;${calculatorByCategory.getName()}
																</dt>
															</dl></a></li>
												</c:forEach>
											</ul>
										</c:if>
										<c:if test="${calculator.isShowBycategory() == false}">
		
											<c:forEach items="${calculator.getCalculators()}"
												var="calculatorByCategory">
												<li><a style="font-size: 12px;"
													href="${pageContext.request.contextPath}/calculadoras/${calculatorByCategory.getPath()}/${calculator.getCategoryId()}/${calculatorByCategory.getId()}">
														<dl class="dl-horizontal">
															<dt
																style="text-align: left !important; font-weight: normal; border-bottom: 1px solid rgba(13, 31, 41, 0.4);"
																class="toolExpand">
																&nbsp;${calculatorByCategory.getName()}</dt>
														</dl>
												</a></li>
											</c:forEach>
		
										</c:if>
									</c:forEach>
								</ul></li>
						</c:if>	
						<c:if test="${gSettings.isFarmacovigilancia()}">
							<li>
								<a class="pt-menu"
									
									href="${pageContext.request.contextPath}/farmacovigilance">
										<i class="fa fa-list-alt" style="color: #86868a;"></i>&nbsp;<span>Farmacovigilancia</span>
								</a>
							</li>
						</c:if>
					</c:if>
					<li class="header">Resultados de la Busqueda</li>
					
					<c:if test='${gSettings.getInteracciones().get("prescription")}'>
						<c:if test="${totalResult.getTotalInteractions()>0 || totalResult.getTotalDDI()>0}">
							<li class="module-prescription">
								<a style="border-left: 8px solid #002e6c;" class="module-prescription interaction-red"
									href="${pageContext.request.contextPath}/interacciones"> 
									<i class="fa fa-prescription-white" id="icon-prescription"></i> <span>
										<span class="txt-prescription interaction-red">Prescripción</span>
										<span class="badge" id="total-prescription"
											style="background-color: #ffffff; color: gray; float: right; margin-right: 5%; width: 40px; position: absolute; top: 46%; right: 10px; margin-top: -7px; font-size: 1em;">
											${totalResult.getTotalInteractions()+totalResult.getTotalDDI()}
										</span>
								</span>
							</a></li>
						</c:if>
						<c:if test='${totalResult.getTotalSelectedDrugs()>=0 && totalResult.getTotalInteractions()<1 && totalResult.getTotalDDI()<1}'>

							<li class="module-prescription">
								<a style="border-left: 8px solid #002e6c;" class="module-prescription" href="${pageContext.request.contextPath}/interacciones"> 
									<i class="fa fa-prescription" id="icon-prescription"></i> 
									<span class="module-prescription"> 
										<span class="txt-prescription">Prescripción </span> 
										<span class="badge" id="total-prescription"
											style="background-color: #ffffff; color: gray; float: right; margin-right: 5%; width: 40px; position: absolute; top: 46%; right: 10px; margin-top: -7px; font-size: 1em;">
											${totalResult.getTotalSelectedDrugs()} 
										</span>
									</span>
								</a>
							</li>
						</c:if>
					</c:if>
					
					<li><a style="border-left: 8px solid #57585a;" class="pt-menu"
						href="${pageContext.request.contextPath}/busqueda/medicamentos/">
							<div class="fa fa-drugs"></div> <span> Medicamentos <span
								class="badge"
								style="background-color: #ffffff; color: gray; float: right; margin-right: 5%; width: 40px; position: absolute; top: 46%; right: 10px; margin-top: -7px; font-size: 1em;">
									${totalResult.getTotalProducts()} </span>
						</span>
					</a></li>
					<li><a style="border-left: 8px solid #ffb600;"
						href="${pageContext.request.contextPath}/busqueda/sustancias/">
							<i class="fa fa-substances"></i> <span> Sustancias <span
								class="badge"
								style="background-color: #ffffff; color: gray; float: right; margin-right: 5%; width: 40px; position: absolute; top: 46%; right: 10px; margin-top: -7px; font-size: 1em;">
									${totalResult.getTotalSubstances()} </span>
						</span>
					</a></li>
					<li><a style="border-left: 8px solid #d50f67;"
						href="${pageContext.request.contextPath}/busqueda/laboratorios/">
							<i class="fa fa-divisions"></i> <span> Laboratorios <span
								class="badge"
								style="background-color: #ffffff; color: gray; float: right; margin-right: 5%; width: 40px; position: absolute; top: 46%; right: 10px; margin-top: -7px; font-size: 1em;">
									${totalResult.getTotalLabs()} </span>
						</span>
					</a></li>
					<c:if test="${gSettings.isIcd()}">
						<li><a style="border-left: 8px solid #662e6b;" href="${pageContext.request.contextPath}/busqueda/cie/">
								<i class="fa fa-cie"></i> <span> CIE 10 <span
									class="badge"
									style="background-color: #ffffff; color: gray; float: right; margin-right: 5%; width: 40px; position: absolute; top: 46%; right: 10px; margin-top: -7px; font-size: 1em;">
										${totalResult.getTotalICD()} </span>
							</span>
						</a></li>
					</c:if>
					<c:if test="${gSettings.isAtc()}">
						<li><a style="border-left: 8px solid #0070cd;" href="${pageContext.request.contextPath}/busqueda/atc/">
								<i class="fa fa-atc"></i> <span> ATC <span class="badge"
									style="background-color: #ffffff; color: gray; float: right; margin-right: 5%; width: 40px; position: absolute; top: 46%; right: 10px; margin-top: -7px; font-size: 1em;">
										${totalResult.getTotalATC()} </span>
							</span>
						</a></li>
					</c:if>
					<!-- Guías Clínicas -->
					<c:if test="${gSettings.isGuideClinic()}">
						<li>
			            	<a style="border-left: 8px solid #00833d;" href="${pageContext.request.contextPath}/busqueda/guias-clinicas/">
			            		<i class="fa fa-guides"></i> 
			            		<span>
			            			Guías Clínicas
			            			<span class="badge" style="background-color: #ffffff;color: gray;float: right;margin-right: 5%;width: 40px;position: absolute;top: 46%;right: 10px;margin-top: -7px;font-size: 1em;">
			            				${totalResult.getTotalGuideLines()}
			            			</span>
			            		</span>
			            	</a>
			            </li>
			        </c:if>

					
				</ul>
			</section>
			<!-- /.sidebar -->
		</aside>
		<!-- Content Wrapper. Contains page content -->
		<!-- <div class="content-wrapper" style="overflow-y: auto;">-->
		<div class="content-wrapper" style="background-color: #f6f6f6;">
			
			<c:if test="${gSettings.isPublicity()==true}">
				<section class="content-header" style="text-align:center;">
					<h4><img src="<c:url value="/resources/images/def/bayer.png"/>"></h4>
				</section>
				<section style="padding-left:18px;padding-right: 18px;">
					<c:if test="${contentHeaderTitle!=null}">
						<h4 class="title-module">
							${contentHeaderTitle} <small>${contentHeaderSubtitle} </small>
						</h4>
					</c:if>
					<c:if test="${contentHeaderTitle==null}">
						<h1 style="color: transparent;">PLM
						</h1>
					</c:if>
					<div class="menu-detail">
						<c:if test="${getICDByDrugsResult.size()>0}">
							<a href="${pageContext.request.contextPath}/busqueda/cie/"> <img
								class="img-menu-search"
								src="<c:url value="/resources/images/cie10.png"/>">
							</a>
						</c:if>
						<c:if test="${atcResult.size()>0}">
							<a href="${pageContext.request.contextPath}/busqueda/atc/"
								class="dropdown-toggle"> <img class="img-menu-search"
								src="<c:url value="/resources/images/atc.png"/>">
							</a>
						</c:if>
						<c:if test="${substancesResult.size()>0}">
							<a href="${pageContext.request.contextPath}/busqueda/sustancias/"
								class="dropdown-toggle"> <img class="img-menu-search"
								src="<c:url value="/resources/images/sustancia.png"/>">
							</a>
						</c:if>
					</div>
				</section>
			</c:if>
			
			<c:if test="${gSettings.isPublicity()==false}">
				<section class="content-header">
					
					<c:if test="${contentHeaderTitle!=null}">
						
						<h4>
							<c:if test="${contentHeaderTitle=='Para inciar, teclee la sustancia activa en el buscador en la parte superior'}">
								<i class="fa fa-arrow-up"></i>							
							</c:if>	
							${contentHeaderTitle} <small>${contentHeaderSubtitle} </small>
						</h4>
					</c:if>
					<c:if test="${contentHeaderTitle==null}">
						<h1 style="color: transparent;">PLM
						</h1>
					</c:if>
					<div class="menu-detail">
						<c:if test="${getICDByDrugsResult.size()>0}">
							<a href="${pageContext.request.contextPath}/busqueda/cie/"> <img
								class="img-menu-search"
								src="<c:url value="/resources/images/cie10.png"/>">
							</a>
						</c:if>
						<c:if test="${atcResult.size()>0}">
							<a href="${pageContext.request.contextPath}/busqueda/atc/"
								class="dropdown-toggle"> <img class="img-menu-search"
								src="<c:url value="/resources/images/atc.png"/>">
							</a>
						</c:if>
						<c:if test="${substancesResult.size()>0}">
							<a href="${pageContext.request.contextPath}/busqueda/sustancias/"
								class="dropdown-toggle"> <img class="img-menu-search"
								src="<c:url value="/resources/images/sustancia.png"/>">
							</a>
						</c:if>
					</div>
					
					<c:if test="${urlIntrecations=='/interacciones'}">
                                   <c:if test="${gSettings.isMedicalPrescription()}">
                                         <button id="btn-receta" class="btn btn-info redirectMedicalPrescription">
                                               Ver Receta
                                         </button>
                                   </c:if>
                                   <c:if test="${gSettings.isClinicalReport()}">
                                         <button id="btn-reporte" class="redirectClinicalReport">
                                               Reporte Clínico
                                         </button>
                                   </c:if>
                    </c:if>
                    
                    <c:if test="${urlIntrecations=='/interacciones'}">
                                   <c:if test="${gSettings.isMedicalPrescription()}">
                                         <button id="btn-receta" class="btn btn-info redirectMedicalPrescription">
                                               Ver Receta
                                         </button>
                                   </c:if>
                                   <c:if test="${gSettings.isClinicalReport()}">
                                         <button id="btn-reporte" class="redirectClinicalReport">
                                               Reporte Clínico
                                         </button>
                                   </c:if>
                    </c:if>
                    
                    
                    
				</section>
				
				
				
				
			</c:if>
			
			<section class="content">
				<div class="row">
					<tiles:insertAttribute name="bodySite"></tiles:insertAttribute>
				</div>
			</section>
			
		</div>
		<footer class="main-footer">
			<b>Versión</b> 4.0.33
			<div class="pull-right">
				<c:if test='${gSettings.getCountry()=="COL"}'>
					<img src="<c:url value="/resources/images/BanderaCOL.png"/>" style="width: 45%;">
				</c:if>
				<c:if test='${gSettings.getCountry()=="MEX"}'>
					<img src="<c:url value="/resources/images/BanderaMEX.png"/>" style="width: 45%;">
				</c:if>	
				<c:if test='${gSettings.getCountry()=="CAD"}'>
					<img src="<c:url value="/resources/images/BanderaCAD.png"/>" style="width: 45%;">
				</c:if>	
				<c:if test='${gSettings.getCountry()=="ECU"}'>
					<img src="<c:url value="/resources/images/BanderaECU.png"/>" style="width: 45%;">
				</c:if>				
			</div>
		</footer>
		<aside class="control-sidebar control-sidebar-dark"></aside>
		<div class="control-sidebar-bg"></div>

	</div>
	   <!-- Terms and conditions modal -->
	<div class="modal fade" id="termsModal" tabindex="-1" role="dialog" aria-labelledby="Terms and conditions" aria-hidden="true">
	    <div class="modal-dialog">
	        <div class="modal-content">
	            <div class="modal-header" style=" background-color: #367fa9;color: #FFF;padding: 10px;">
	                <h3 class="modal-title"></h3>
	            </div>
	
	            <div class="modal-body" id="modal-body-content">
	               
	            </div>
	
	            <div class="modal-footer">
	                <button type="button" class="btn btn-primary" id="printButton" >Imprimir</button>
	                <button type="button" class="btn btn-default" id="disagreeButton" data-dismiss="modal">Cerrar</button>
	            </div>
	        </div>
	    </div>
	</div>
	
	<script type="text/javascript">
		 $(document).ready(function() { 
		
		   /* var window_height = $(window).height()-242;
		   $(".content-wrapper, .right-side").css('min-height', window_height - $('.main-footer').outerHeight());
		   */
				//Términos y condiciones
		     
		     var showType=0;
		     
			     $('#termsModal').on('show.bs.modal', function(e) {
			         
			    	 var name = $(e.relatedTarget).data('title');
				 	    $(".modal-title").html(name);
				 	  
				 	     showType= $(e.relatedTarget).data('book-id');
				 	    
					 	   if(showType==1){
				  
					    	    $("#modal-body-content" ).load( "resources/terms.html", function() {
					    		 
					    		});
					 	   }
				 	   
					 	  if(showType==2){
					 		  
					 		 $("#modal-body-content" ).load( "resources/privacity.html", function() {
					    		 
					    		});
					 		  
					 	  }
			    	 
			     });
		
		
		}); 
	</script>

</body>
</html>
