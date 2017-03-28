<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="col-md-12" style="padding-left: 10px; padding-right: 0px;">
	<div class="box-body" id="prescriptionGrid">
		<div class="renglon" id="tableHeader">
			<div class="tab-1 head">Nombre</div>
		</div>
		<c:forEach var="lab" items="${labsResult}" varStatus="loop">
			<c:if test="${loop.index%2==0}">
				<div class="renglon gris1">
					<div class="tab-1">
						<a href="${pageContext.request.contextPath}/busqueda/medicamentos-laboratorio/${lab.getDivisionId()}">${lab.getShortName()}</a>
					</div>
				</div>
			</c:if>
			<c:if test="${loop.index%2!=0}">
				<div class="renglon gris2">
					<div class="tab-1">
						<a href="${pageContext.request.contextPath}/busqueda/medicamentos-laboratorio/${lab.getDivisionId()}">${lab.getShortName()}</a>
					</div>
				</div>
			</c:if>
		</c:forEach>
	</div>
</div>