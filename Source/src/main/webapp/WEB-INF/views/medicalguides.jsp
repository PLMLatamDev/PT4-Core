<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
	.tab-9 head{
		-webkit-column-width:5.7% !important; /* Chrome, Safari, Opera */
	    -moz-column-width:5.6% !important; /* Firefox */
	    column-width:4.6% !important;
   	}
   	
</style>
<div class="col-md-12" style="padding-left: 10px; padding-right: 0px;">
	<div class="box-body" id="prescriptionGrid">
		<div class="renglon"  id="tableHeader">
			<div class="tab-9-guides head" style="text-align:center;width:4.6%;">Tipo<span style="color:transparent;">__________</span></div>
			<div class="tab-6 head">Nombre</div>
		</div>

		<c:forEach var="guide" items="${resultGuides}" varStatus="loop">
			<c:if test="${loop.index%2==0}">
				<div class="renglon gris1">
					<div class="tab-9-guides first" style="width:4.6%;">
						<a class="first" link href="${guide.getLink()}"  target='_blank'>
							${guide.getElectronicDescription()}
						</a>
							
					</div>
					
	  				<div class="tab-6-guides">
	  					<a link href="${guide.getLink()}"  target='_blank'>${guide.getElectronicTitle()}</a>
	  				</div>
	  			</div>
	  		</c:if>
	  		<c:if test="${loop.index%2!=0}">
				<div class="renglon gris2">
	  				<div class="tab-9-guides first" style="width:4.6%;">
						<a class="first" link href="${guide.getLink()}"  target='_blank'>
							${guide.getElectronicDescription()}<span style="color:transparent;">_________</span>
						</a>
					</div>
					
	  				<div class="tab-6-guides">
	  					<a link href="${guide.getLink()}"  target='_blank'>${guide.getElectronicTitle()}</a>
	  				</div>
	  			</div>
	  		</c:if>
		</c:forEach>
		
	</div>
</div>
