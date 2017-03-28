<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="col-md-12" style="padding-left: 10px; padding-right: 0px;">
	<div class="box-body" id="prescriptionGrid">
		<div class="renglon"  id="tableHeader">
			<div class="tab-9 head">Clave</div>
			<div class="tab-6 head">Nombre</div>
		</div>
		<c:forEach var="atc" items="${atcResult}" varStatus="loop">
			<c:if test="${loop.index%2==0}">
				<div class="renglon gris1">
					<div class="tab-9 first">
						<a href="${pageContext.request.contextPath}/busqueda/medicamentos-atc/${atc.getTherapeuticId()}">
							<span class="img-menu-search">${atc.getTherapeuticKey()}</span>
						</a>
					</div>
					<div class="tab-6" style="text-align:justify;padding: 5px 15px;">
						<a href="${pageContext.request.contextPath}/busqueda/medicamentos-atc/${atc.getTherapeuticId()}">
							<span class="img-menu-search">${atc.getSpanishDescription()}</span>
						</a>
					</div>
				</div>
			</c:if>
			<c:if test="${loop.index%2!=0}">
				<div class="renglon gris2">
					<div class="tab-9 first">
						<a href="${pageContext.request.contextPath}/busqueda/medicamentos-atc/${atc.getTherapeuticId()}">
							<span class="img-menu-search">${atc.getTherapeuticKey()}</span>
						</a>
					</div>
					<div class="tab-6" style="text-align:justify;padding: 5px 15px;">
						<a href="${pageContext.request.contextPath}/busqueda/medicamentos-atc/${atc.getTherapeuticId()}">
							<span class="img-menu-search">${atc.getSpanishDescription()}</span>
						</a>
					</div>
				</div>
			</c:if>
		</c:forEach>
	</div>
</div>