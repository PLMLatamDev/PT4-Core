<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/calculators/indice-Masa-Corporal.js"></script>

<section class="content">
<div class="row">
<div class="col-md-1"></div>
  <div class="col-md-10" id="MassIndexPrincipal">
     <div class="box box-default">
                <div class="box-header with-border">
                  <h3 class="box-title"><strong>Datos</strong></h3>
                </div> <!-- /.box-header -->
                <!-- form start -->
                <form class="form-horizontal" id="MassIndex">
                  <div class="box-body">
                    <div class="form-group">
                      <label for="inputEmail3" class="col-sm-2 control-label">Peso (kg)*</label>
                      <div class="col-sm-2">
                        <input type="text" class="form-control"  name="height">
                      </div>
                    </div>
                    <div class="form-group">
                      <label for="inputPassword3" class="col-sm-2 control-label">Estatura (mts)*</label>
                      <div class="col-sm-2">
                        <input type="text" class="form-control" name="weight">
                      </div>
                    </div>
                    
                  </div><!-- /.box-body -->
                  <div class="box-footer text-center">
                   
                    <button type="submit" class="btn btn-primary">Calcular</button>
                      <blockquote style="text-align: left;">
                    <p>Referencia:</p>
                    <small>Tapia-Conyer R. et. al. Guía de detección integrada de obesidad, diabetes e hipertensión arterial.  Secretaria de Salud, México 2002, p. 19.</small>
                  </blockquote>
                  </div><!-- /.box-footer -->
                </form>
              </div>
  </div>
  <div class="col-md-10" id="MassIndexSecond" style="display:none;">
    <div class="box box-default">
           <div class="box-header with-border">
                  <h3 class="box-title"><strong>Resultados</strong></h3>
                  <blockquote style="text-align: center;">
                    <p>IMC =&nbsp;<span id="imc"> </span></p>
                    <p>Clasificación del IMC =&nbsp;<span id="cimc"> </span></p>
                 
           </div> <!-- /.box-header -->
           <div class="box-footer text-center">
                   
                    <button id="imcEnd" type="submit" class="btn btn-primary">Finalizar</button>
                       </blockquote>
                   <blockquote style="text-align: left;">
                    <p>Referencia:</p>
                    <small>Tapia-Conyer R. et. al. Guía de detección integrada de obesidad, diabetes e hipertensión arterial.  Secretaria de Salud, México 2002, p. 19.</small>
                  </blockquote>
                  </div><!-- /.box-footer -->
     </div>
  </div>


</div>
   
</section>