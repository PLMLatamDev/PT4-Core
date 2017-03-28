<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/encyclopedias_predictive.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/encyclopedias.js"></script>


<div class="col-md-12" style="padding-left: 10px; padding-right: 0px;">
	<div class="box-body" id="prescriptionGrid">
		<div class="renglon" style="background-color:#3a6f9f;color:#FFF;font-weight:600;">
			<div class="tab-6 head">
			
				<a style="color:#FFFFFF;" href="${pageContext.request.contextPath}/encyclopedias/${encyclopediaName}-a">A</a>
				<a style="color:#FFFFFF;margin-left:2.5%;" href="${pageContext.request.contextPath}/encyclopedias/${encyclopediaName}-b">B</a>
				<a style="color:#FFFFFF;margin-left:2.5%;" href="${pageContext.request.contextPath}/encyclopedias/${encyclopediaName}-c">C</a>
				<a style="color:#FFFFFF;margin-left:2.5%;" href="${pageContext.request.contextPath}/encyclopedias/${encyclopediaName}-d">D</a>
				<a style="color:#FFFFFF;margin-left:2.5%;" href="${pageContext.request.contextPath}/encyclopedias/${encyclopediaName}-e">E</a>
				<a style="color:#FFFFFF;margin-left:2.5%;" href="${pageContext.request.contextPath}/encyclopedias/${encyclopediaName}-f">F</a>
				<a style="color:#FFFFFF;margin-left:2.5%;" href="${pageContext.request.contextPath}/encyclopedias/${encyclopediaName}-g">G</a>
				<a style="color:#FFFFFF;margin-left:2.5%;" href="${pageContext.request.contextPath}/encyclopedias/${encyclopediaName}-h">H</a>
				<a style="color:#FFFFFF;margin-left:2.5%;" href="${pageContext.request.contextPath}/encyclopedias/${encyclopediaName}-i">I</a>
				<a style="color:#FFFFFF;margin-left:2.5%;" href="${pageContext.request.contextPath}/encyclopedias/${encyclopediaName}-j">J</a>
				<a style="color:#FFFFFF;margin-left:2.5%;" href="${pageContext.request.contextPath}/encyclopedias/${encyclopediaName}-k">K</a>
				<a style="color:#FFFFFF;margin-left:2.5%;" href="${pageContext.request.contextPath}/encyclopedias/${encyclopediaName}-l">L</a>
				<a style="color:#FFFFFF;margin-left:2.5%;" href="${pageContext.request.contextPath}/encyclopedias/${encyclopediaName}-m">M</a>
				<a style="color:#FFFFFF;margin-left:2.5%;" href="${pageContext.request.contextPath}/encyclopedias/${encyclopediaName}-n">N</a>
				<a style="color:#FFFFFF;margin-left:2.5%;" href="${pageContext.request.contextPath}/encyclopedias/${encyclopediaName}-ñ">Ñ</a>
				<a style="color:#FFFFFF;margin-left:2.5%;" href="${pageContext.request.contextPath}/encyclopedias/${encyclopediaName}-o">O</a>
				<a style="color:#FFFFFF;margin-left:2.5%;" href="${pageContext.request.contextPath}/encyclopedias/${encyclopediaName}-p">P</a>
				<a style="color:#FFFFFF;margin-left:2.5%;" href="${pageContext.request.contextPath}/encyclopedias/${encyclopediaName}-q">Q</a>
				<a style="color:#FFFFFF;margin-left:2.5%;" href="${pageContext.request.contextPath}/encyclopedias/${encyclopediaName}-r">R</a>
				<a style="color:#FFFFFF;margin-left:2.5%;" href="${pageContext.request.contextPath}/encyclopedias/${encyclopediaName}-s">S</a>
				<a style="color:#FFFFFF;margin-left:2.5%;" href="${pageContext.request.contextPath}/encyclopedias/${encyclopediaName}-t">T</a>
				<a style="color:#FFFFFF;margin-left:2.5%;" href="${pageContext.request.contextPath}/encyclopedias/${encyclopediaName}-u">U</a>
				<a style="color:#FFFFFF;margin-left:2.5%;" href="${pageContext.request.contextPath}/encyclopedias/${encyclopediaName}-v">V</a>
				<a style="color:#FFFFFF;margin-left:2.5%;" href="${pageContext.request.contextPath}/encyclopedias/${encyclopediaName}-w">W</a>
				<a style="color:#FFFFFF;margin-left:2.5%;" href="${pageContext.request.contextPath}/encyclopedias/${encyclopediaName}-x">X</a>
				<a style="color:#FFFFFF;margin-left:2.5%;" href="${pageContext.request.contextPath}/encyclopedias/${encyclopediaName}-y">Y</a>
				<a style="color:#FFFFFF;margin-left:2.5%;" href="${pageContext.request.contextPath}/encyclopedias/${encyclopediaName}-z">Z</a>

			</div>
		</div>

		<div class="row" style="padding-right: 15px;padding-left: 1px;">
			<c:if test="${listSymtoms!=null}">
				<c:forEach var="encyclopedia" items="${listSymtoms}" varStatus="loop">
					<div class="col-md-4">
						<c:set  var="nameE" value="${encyclopedia.getEncyclopediaName().split('¬¬')}" />
						<a href="${pageContext.request.contextPath}/encyclopedias/${nameE[1]}${encyclopedia.getEncyclopediaId()}"> 
							<div class="tab-5 head-izq" style="font-size:smaller;width: 14%;">
								<img width="25%" src="<c:url value="/resources/images/encyclopedias/enciclopedia.png"/>">
								<div class="shotsAbbot">${nameE[0]}</div> 
							</div>
						</a>
					</div>
				</c:forEach>
			</c:if>
			<c:if test="${listHealth!=null}">
				<c:forEach var="encyclopedia" items="${listHealth}" varStatus="loop">
					<div class="col-md-4">
						<a href="${pageContext.request.contextPath}/encyclopedias/${encyclopediaName}/${encyclopedia.getUrl()}-${encyclopedia.getSymptomId()}"> 
							<div class="tab-5 head-izq" style="font-size:smaller;width: 14%;">
								<img width="25%" src="<c:url value="/resources/images/encyclopedias/enciclopedia.png"/>">
								<div class="shotsAbbot">${encyclopedia.getSymptomName()}</div> 
							</div>
						</a>
					</div>
				</c:forEach>
			</c:if>			
		</div>
		
	</div>
</div>