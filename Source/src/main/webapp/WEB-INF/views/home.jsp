<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style>
	  .carousel-inner > .item > img,
	  .carousel-inner > .item > a > img {
	      width: 282px;
	      margin: auto;
	      margin-top:5%;
	  }
	  .backBoxFooter{
	      background: #59AC7E !important;
	  }
	  .img-heigth{
	        min-height: 143px;
	  }
</style>

<section class="content">
   <div class="row">
      <div class="col-md-3">

      </div>
      <div class="col-md-6">
        <div class="row">
           <div class="col-md-12" style="margin-bottom:3%;">
              <c:if test="${gSettings.carouselActive}">
				<div id="myCarousel" class="carousel slide" data-ride="carousel" data-interval="${gSettings.carouselInterval}" data-wrap="${gSettings.carouselWrap}" style="background-color: #ffffff;">
					<!-- Indicators -->
					<ol class="carousel-indicators">
					  <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
					  <li data-target="#myCarousel" data-slide-to="1"></li>
					  <li data-target="#myCarousel" data-slide-to="2"></li>
					  <li data-target="#myCarousel" data-slide-to="3"></li>
					</ol>
					
					<!-- Wrapper for slides -->
					<div class="carousel-inner" role="listbox">
						<div class="item active">
						  <img src="<c:url value="/resources/images/carrusel/alcohol-LaSante.png"/>">
						</div>
				
					    <div class="item">
					      <img src="<c:url value="/resources/images/carrusel/cromoglicato4-LaSante.png"/>">
					    </div>
				
					    <div class="item">
					      <img src="<c:url value="/resources/images/carrusel/dorzolamida20-LaSante.png"/>">
					    </div>
				
					    <div class="item">
					      <img src="<c:url value="/resources/images/carrusel/sulfacetamida10-LaSante.png"/>">
					    </div>
					</div>
				
					<!-- Left and right controls -->
					<a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
						<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
					    <span class="sr-only">Previous</span>
					</a>
					<a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
					    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
					    <span class="sr-only">Next</span>
					</a>
				</div>
			</c:if>
           </div>
           
         <div class="row">
          <div class="col-md-1"></div>
           <div class="col-md-10">
              <img class="img-responsive pad" style="margin: 55px auto;" alt="PLM" src="${pageContext.request.contextPath}/resources/images/PLM-LogotipoAzul.png">
           </div>
         </div>
             
        </div>
      
      </div>
      <div class="col-md-3">

      </div>
   </div>
</section>

<c:if test="${successfulActivation!=null}">
	<script type="text/javascript">
	    $(window).load(function(){
	        $('#myModalActive').modal('show');
	    });
	</script>
</c:if>

    <!-- Modal -->
		          <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModalActive" class="modal">
		              <div class="modal-dialog">
		                  <div class="modal-content">
		                     <form id="retrieveform">
			                      <div class="modal-header" style="    background-color: #367fa9;color: #FFF;">
			                          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			                          <h4 class="modal-title">Cuenta Activada</h4>
			                      </div>
			                      <div class="modal-body">
			                      
                                          
			                          <p>Tu cuenta ha sido activada correctamente. Ahora podrás acceder al sitio con el correo y contraseña provista 
			                             en el proceso de registro.</p>
			                          
			                          
			                      </div>
			                      <div class="modal-footer">
			                          <button data-dismiss="modal" class="btn btn-default" type="button">Cerrar</button>
			                          
			                      </div>
		                      </form>
		                  </div>
		              </div>
		          </div>
<!-- modal -->



