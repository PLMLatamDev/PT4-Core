<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/calculators/superficie-corporal.js"></script>

<section class="content">
<div class="row">
<div class="col-md-1"></div>
  <div class="col-md-10" id="superficieCorporalPrincipal">
     <div class="box box-default">
                <div class="box-header with-border">
                  <h3 class="box-title"><strong>Datos</strong></h3>
                </div> <!-- /.box-header -->
                <!-- form start -->
                <form class="form-horizontal" id="superficieCorporal">
                  <div class="box-body">
                    <div class="form-group">
                      <label for="inputEmail3" class="col-sm-2 control-label">Peso (kg)*</label>
                      <div class="col-sm-2">
                        <input type="text" class="form-control"  name="peso">
                      </div>
                    </div>
                    <div class="form-group">
                      <label for="inputEmail3" class="col-sm-2 control-label">Altura (cm)*</label>
                      <div class="col-sm-2">
                        <input type="text" class="form-control"  name="altura">
                      </div>
                    </div>
                   
                  <blockquote id="resultContent" style="text-align: center; display:none;">
<!--                   <h3 class="box-title"><strong>Resultados</strong></h3> -->
                    <p>Superficie corporal :&nbsp;<span id="superficieCorporalresultado"> </span>&nbsp; m<sup>2</sup></p>
                    <p><span id="textOP"> </span></p>
                 
                    
                  </div><!-- /.box-body -->
                  <div class="box-footer text-center">
                   
                    <button type="submit" class="btn btn-primary">Calcular</button>
                      
                  </div><!-- /.box-footer -->
                </form>
              </div>
  </div>



</div>
   
</section>