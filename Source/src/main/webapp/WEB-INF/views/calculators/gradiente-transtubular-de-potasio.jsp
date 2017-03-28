<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/calculators/gradiente-transtubular-de-potasio.js"></script>

<section class="content">
<div class="row">
<div class="col-md-1"></div>
  <div class="col-md-10" id="gradientePrincipal">
     <div class="box box-default">
                <div class="box-header with-border">
                  <h3 class="box-title"><strong>Datos</strong></h3>
                </div> <!-- /.box-header -->
                <!-- form start -->
                <form class="form-horizontal" id="gradiente">
                  <div class="box-body">
                    <div class="form-group">
                      <label for="inputEmail3" class="col-sm-2 control-label">(Potasio Urinario) U k (mmol/L)*</label>
                      <div class="col-sm-2">
                        <input type="text" class="form-control"  name="uk">
                      </div>
                    </div>
                    <div class="form-group">
                      <label for="inputEmail3" class="col-sm-2 control-label">(Osmolalidad Sérica) P osm (mOsm/L)*</label>
                      <div class="col-sm-2">
                        <input type="text" class="form-control"  name="posm">
                      </div>
                    </div>
                    <div class="form-group">
                      <label for="inputEmail3" class="col-sm-2 control-label">(Potasio Sérico) P k (mmol/L)*</label>
                      <div class="col-sm-2">
                        <input type="text" class="form-control"  name="pk">
                      </div>
                    </div>
                    <div class="form-group">
                      <label for="inputEmail3" class="col-sm-2 control-label">(Osmolalidad Urinaria) U osm (mOsm/L)*</label>
                      <div class="col-sm-2">
                        <input type="text" class="form-control"  name="uosm">
                      </div>
                    </div>
                   
                  <blockquote id="resultContent" style="text-align: center; display:none;">
<!--                   <h3 class="box-title"><strong>Resultados</strong></h3> -->
                    <p>TTKG :&nbsp;<span id="gradienteresultado"></span>&nbsp;%</p>
<!--                     <p><span id="textExcrecionCreatinina"> </span></p> -->
                 
                    
                  </div><!-- /.box-body -->
                  <div class="box-footer text-center">
                   
                    <button type="submit" class="btn btn-primary">Calcular</button>
                      
                  </div><!-- /.box-footer -->
                </form>
              </div>
  </div>



</div>
   
</section>