<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/encyclopedias_predictive.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/encyclopedias.js"></script>
<style>
	.col-encyclopedias{
		text-align:center;
		font-size: 14px;
    	font-weight: bold;
    	-webkit-border-radius: 10px;
		-moz-border-radius: 10px;
		border-radius: 10px;
		margin-top:3%;
		color:#808080;
		
		background-color:#DCDCDC;
		padding: 2% 0 2%;
		margin-right: 3%;
		width: 30%;
		
	}
	
	.icon-encylcopedia{
		width: 50%;
	}
	
	.row-down{
		margin-left:16%;
	}
	
	#title-short{
		padding-bottom:5%;
	}
	
	.title-encyclopedia{
		padding-bottom: 5%;
	}
	
/********************
	Medias Querys
*********************/

	@media only screen and (min-width : 320px) {
		.title-encyclopedia{
			padding-bottom: 1%;
		}
	}

	@media only screen and (min-width : 480px) {
		.title-encyclopedia{
			padding-bottom: 1%;
		}
	}
	
	@media (max-width: 768px){
		.col-encyclopedias{
			text-align:center;
			font-size: 14px;
	    	font-weight: bold;
			border:none;
			margin-top:2px;
			-webkit-border-radius: 0px;
			-moz-border-radius: 0px;
			border-radius: 0px;

			padding: 2% 0 2%;
			margin-right: 0;
			width: 100%;
			
		}
		
		.row-down{
			margin-left:0;
		}
		
		.icon-encylcopedia{
			width: 30%;
		}
	}
	
		
	@media only screen and (min-width : 1024px) {
		#title-short{
			padding-bottom:11%;
		}
	}
	
	
	@media only screen and (min-width : 1048px) {
		#title-short{
			padding-bottom:2%;
		}
	}
	
	
</style>
<div class="row" style="padding-left: 12%;padding-right: 8%;">
	
	<a href="${pageContext.request.contextPath}/encyclopedias/estudios-de-laboratorio-a">
		<div class="col-md-3 col-encyclopedias">
			<div class="col-md-12 title-encyclopedia">Estudios de laboratorio</div>
			<div class="col-md-12"><img class="icon-encylcopedia" src="/pt4/resources/images/encyclopedias/tool.png"></div>
		</div>
	</a>
	<a href="${pageContext.request.contextPath}/encyclopedias/enfermedades-a">
		<div class="col-md-3 col-encyclopedias">
			<div class="col-md-12 title-encyclopedia">Enfermedades</div>
			<div class="col-md-12"><img class="icon-encylcopedia" src="/pt4/resources/images/encyclopedias/medical.png"></div>
		</div>
	</a>
	<a href="${pageContext.request.contextPath}/encyclopedias/sintomas-a">
		<div class="col-md-3 col-encyclopedias">
			<div class="col-md-12 title-encyclopedia">Síntomas</div>
			<div class="col-md-12"><img class="icon-encylcopedia" src="/pt4/resources/images/encyclopedias/medical-1.png"></div>
		</div>
	</a>
	
	<a href="${pageContext.request.contextPath}/encyclopedias/cirugias-y-procedimientos-a">
		<div class="col-md-3 col-encyclopedias row-down">
			<div class="col-md-12 title-encyclopedia">Cirugias y otros procedimientos</div>
			<div class="col-md-12"><img class="icon-encylcopedia" src="/pt4/resources/images/encyclopedias/medical-2.png"></div>
		</div>
	</a>
	
	<a href="${pageContext.request.contextPath}/encyclopedias/mejora-tu-salud-a">
		<div class="col-md-3 col-encyclopedias">
			<div class="col-md-12" id="title-short">Mejora tu salud</div>
			<div class="col-md-12"><img class="icon-encylcopedia" src="/pt4/resources/images/encyclopedias/graphic.png"></div>
		</div>
	</a>
</div>

