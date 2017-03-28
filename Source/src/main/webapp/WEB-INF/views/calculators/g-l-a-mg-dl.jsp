<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/calculators/g-l-a-mg-dl.js"></script>

<section class="content">
<div class="row">
<div class="col-md-1"></div>
  <div class="col-md-10" id="conversionMetricaPrincipal">
     <div class="box box-default">
                <div class="box-header with-border">
                  <h3 class="box-title"><strong>Datos</strong></h3>
                </div> <!-- /.box-header -->
                <!-- form start -->
                <form class="form-horizontal" id="conversionMetrica">
                  <div class="box-body">
                    <div class="form-group">
                      <label for="inputEmail3" class="col-sm-2 control-label">Compuesto (g/l)*</label>
                      <div class="col-sm-2">
                        <input type="text" class="form-control"  name="compuestoGL">
                      </div>
                    </div>
                   
                  <blockquote id="resultContent" style="text-align: center; display:none;">
<!--                   <h3 class="box-title"><strong>Resultados</strong></h3> -->
                    <p>Resultado :&nbsp;<span id="conversionMetricaresultado"> </span></p>
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