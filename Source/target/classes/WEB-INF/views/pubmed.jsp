<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/pubmed_predictive.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/pubmed.js"></script>

<script type="text/javascript">
 	$(document).ready(function () {
		_pubmedTracking();
	});
 	
</script>

<div class="container container-general" id="grid-pubmed">
	<c:if test="${listPubmed==null}">
		<div id="logo-pubmed">
			<img width="100%" style="margin-left:8%;" src="<c:url value="/resources/images/pubmed-logo.png"/>">
		</div>
	</c:if>

	<c:if test="${listPubmed!=null}">
		<div class='col-md-12' style='padding-left: 10px; padding-right: 0px;'>
			<div class='box-body' id='prescriptionGrid'>
				<div class="renglon" id="tableHeader">
					<div class="tab-8 head">Referencia</div>
				</div>
				<c:forEach var="article" items="${listPubmed}" varStatus="loop">
					<c:if test="${loop.index%2==0}">
						<div class='renglon gris1' id='editable'>
							
							<a href="${article.getURL()}${article.getLinkpubmed()}" class="description-pubmed" 
								target='_blank'>
								<div class='tab-pubmed-1' id="article-${loop.index}"
								value="{'JSONFormat':{'Title':'${article.getTitle()}'}}" 
								style="text-align: justify;">
									<i class="fa fa-comment"></i>&nbsp;&nbsp;&nbsp;${article.getTitle()};</div>
							</a>
						</div>
					</c:if>
					<c:if test="${loop.index%2!=0}">
						<div class='renglon gris2' id='editable'>
							
							<a href="${article.getURL()}${article.getLinkpubmed()}" class="description-pubmed"
								target='_blank'>
								<div class='tab-pubmed-1' id="article-${loop.index}"
								value="{'JSONFormat':{'Title':'${article.getTitle()}'}}"
								style='text-align: justify;'>
									<i class="fa fa-comment"></i>&nbsp;&nbsp;&nbsp;${article.getTitle()};</div>
							</a>
						</div>
					</c:if>
				</c:forEach>
			</div>
		</div>
	</c:if>
</div>


