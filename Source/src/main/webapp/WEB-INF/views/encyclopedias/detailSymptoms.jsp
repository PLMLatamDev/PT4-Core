<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/encyclopedias_predictive.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/encyclopedias.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#glyphicon-print-encyclopedia").show();
	});
</script>

<div class="row">
	<section class="col-lg-12">
		<div class="box-body text-center">
<%-- 			<img src="<c:url value="${getAllAttributesByProductResult.getBaseUrl()}${getAllAttributesByProductResult.getProductShot()}"/>"> --%>
			<img style="width:50%;height:252px;" src="<c:url value="http://www.plmconnection.com/plmservices/EncyclopediaSearchEngine/EncyclopediaImages/detalle/${detailEncyclopedia.getEncyclopediaImage()}"/>">
		</div>
	</section>
</div>
	
<div class="row">
	<div class="col-lg-12">
		<div class="box box-solid">
			<!-- /.box-header -->
			<div class="box-body">
				<div class="box-group" id="accordion">
					<!-- we are adding the .panel class so bootstrap.js collapse plugin detects it -->
					<c:forEach var="attribute" items="${listSymptoms}" varStatus="loop">
						<div class="panel" style="margin-bottom:0px;">
							<div class="box-header" style="background-color:#d9edf7;">
								<div class="row">
									<div class="col-md-6">
										<h6 class="box-title" name="ipp" id="header-${attribute.getAttributeId()}" style="font-weight: bold;font-size: 14px;line-height: 2;"
											value="">
												<a style="color:#115ca0;" aria-expanded="true" class="attribute-acordeon" data-toggle="collapse"
													data-parent="#accordion" href="#collapse-<c:out value="${attribute.getAttributeId()}"/>"> 
														${attribute.getDescription()}
												</a>
										</h6>
									</div>
								</div>
									
							</div>
							<div style="" aria-expanded="true" id="collapse-<c:out value="${attribute.getAttributeId()}"/>"
								class="panel-collapse collapse">
									<div class="box-body context" style="border:1px solid #d9edf7;" id="body-${attribute.getAttributeId()}">
										${attribute.getPlainContent()}
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