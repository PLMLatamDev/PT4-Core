<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
	mark{
		background-color:orange;
		color:black;
	}
	
	@media only screen and (min-width : 320px) {
		.title-module{
			margin-bottom:1%;
		}
		.menu-detail{
			float:left;
		}
		.img-menu-search{
			width: 85px;
	    	margin-top: -5px;
		}
		
	}
	
	@media only screen and (min-width : 480px) {
		.title-module{
			margin-bottom:1%;
		}
		.menu-detail{
			float:left;
		}
		.img-menu-search{
			width: 85px;
	    	margin-top: -5px;
		}
	}
	
	
	@media (max-width: 767px){
		.title-module{
			margin-bottom:1%;
		}
		
		.menu-detail{
			float:left;
		}
		.img-menu-search{
			width: 75px;
	    	margin-top: -5px;
		}
	}
	
	
	
	@media only screen and (min-width : 992px) {
		
		.title-module{
			margin-bottom:-2%;
		}
		.menu-detail{
			float:right;
		}
		.img-menu-search{
			width: 75px;
	    	margin-top: -5px;
		}
		
	}
	
	
</style>

	<div class="row">
		<section class="col-lg-12">
			<div class="box-body text-center">
				<img src="<c:url value="${getAllAttributesByProductResult.getBaseUrl()}${getAllAttributesByProductResult.getProductShot()}"/>">
			</div>
		</section>
	</div>
	
	<div class="row">
		<div class="col-lg-12">
			<div class="box box-solid">
				<!-- <div class="box-header with-border">
					<h3 class="box-title">Collapsible Accordion</h3>
				</div>-->
				<!-- /.box-header -->
				<div class="box-body">
					<div class="box-group" id="accordion">
						<!-- we are adding the .panel class so bootstrap.js collapse plugin detects it -->
						<c:forEach var="attribute" items="${getAllAttributesByProductResult.getAttributes()}" varStatus="loop">
							<div class="panel" style="margin-bottom:0px;">
								<div class="box-header" style="background-color:#d9edf7;">
									
									<div class="row">
										<div class="col-md-6" onselectstart="return false;" ondragstart="return false;" onmousedown="return false;">
											<h6 class="box-title" name="ipp" id="header-${attribute.getAttributeId()}" style="font-weight: bold;font-size: 14px;line-height: 2;"
												value="{'groupKey':'${attribute.getAttributeGroupKey()}','divisionId':${attribute.getDivisionId()},'categoryId':${attribute.getCategoryId()},'productId':${attribute.getProductId()},'pharmaFormId':${attribute.getPharmaFormId()}}">
												<a style="color:#115ca0;" aria-expanded="true" class="attribute-acordeon" data-toggle="collapse"
													data-parent="#accordion" href="#collapse-<c:out value="${attribute.getAttributeId()}"/>"> 
														${attribute.getAttributeName()}
													</a>
											</h6>
										</div>
										<div class="col-md-6">
											<div class="txt-detail" style="float:left;text-align:justify;width:100%;" value="btn-${attribute.getAttributeId()}" id="botonera-<c:out value="${attribute.getAttributeId()}"/>">
												<input type="text" class="txt-attribute" id="txt-<c:out value="${attribute.getAttributeId()}"/>" placeholder=" Buscador de palabras" class="keyword">
											</div>
										</div>
									</div>
									
								</div>
								<div style="" aria-expanded="true" id="collapse-<c:out value="${attribute.getAttributeId()}"/>"
									class="panel-collapse collapse" onselectstart="return false;" ondragstart="return false;" onmousedown="return false;">
									<div class="box-body context" style="border:1px solid #d9edf7;" id="body-${attribute.getAttributeId()}">
										${attribute.getHTMLContent()}
									</div>
								</div>	
							</div>
						</c:forEach>
					</div>
				</div>
				<!-- /.box-body -->
			</div>
			<!-- /.box -->
		</div>




</div>


<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/productDetail.js"></script>
