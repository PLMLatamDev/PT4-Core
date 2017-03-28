<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/calculators/osmolaridad-plasmatica.js"></script>

<section class="content">
<div class="row">
<div class="col-md-1"></div>
  <div class="col-md-10" id="OPPrincipal">
     <div class="box box-default">
                <div class="box-header with-border">
                  <h3 class="box-title"><strong>Datos</strong></h3>
                </div> <!-- /.box-header -->
                <!-- form start -->
                <form class="form-horizontal" id="OP">
                  <div class="box-body">
                    <div class="form-group">
                      <label for="inputEmail3" class="col-sm-2 control-label">Na*[mEq/L]*</label>
                      <div class="col-sm-2">
                        <input type="text" class="form-control"  name="na">
                      </div>
                    </div>
                    <div class="form-group">
                      <label for="inputEmail3" class="col-sm-2 control-label">Glucemia [mg/dl]*</label>
                      <div class="col-sm-2">
                        <input type="text" class="form-control"  name="glucemia">
                      </div>
                    </div>
                    <div class="form-group">
                      <label for="inputPassword3" class="col-sm-2 control-label">Uremia [mmol/L]*</label>
                      <div class="col-sm-2">
                        <input type="text" class="form-control" name="uremia">
                      </div>
                    </div>
                    
                  </div><!-- /.box-body -->
                  <div class="box-footer text-center">
                   
                    <button type="submit" class="btn btn-primary">Calcular</button>
                      <blockquote style="text-align: left;">
                    <p>Referencia:</p>
                    <small>Czerkiewicz I. Trastornos de la Osmolaridad. Interpretaci�n y diagn�stico etiol�gico. Acta Bioqu�m Cl�n latinoam 2004; 38 (2): 203-6       � Formato Documento Electr�nico (Vancouver) : Czerkiewicz I.. Trastornos de la osmolaridad: Interpretaci�n y diagn�stico etiol�gico. Acta bioqu�m. cl�n. latinoam.  [revista en la Internet]. 2004  Jun [citado  2012  Mayo  16] ;  38(2): 203-206. Disponible en: http://www.scielo.org.ar/scielo.php?script=sci_arttext&pid=S0325-29572004000200009&lng=es</small>
                  </blockquote>
                  </div><!-- /.box-footer -->
                </form>
              </div>
  </div>
  <div class="col-md-10" id="OPSecond" style="display:none;">
    <div class="box box-default">
           <div class="box-header with-border">
                  <h3 class="box-title"><strong>Resultados</strong></h3>
                  <blockquote style="text-align: center;">
                    <p>Resultado:&nbsp;<span id="resultadoOP"> </span></p>
                    <p><span id="textOP"> </span></p>
                 
           </div> <!-- /.box-header -->
           <div class="box-footer text-center">
                   
                    <button id="End" type="submit" class="btn btn-primary">Finalizar</button>
                       </blockquote>
                   <blockquote style="text-align: left;">
                    <p>Referencia:</p>
                    <small>Czerkiewicz I. Trastornos de la Osmolaridad. Interpretaci�n y diagn�stico etiol�gico. Acta Bioqu�m Cl�n latinoam 2004; 38 (2): 203-6       � Formato Documento Electr�nico (Vancouver) : Czerkiewicz I.. Trastornos de la osmolaridad: Interpretaci�n y diagn�stico etiol�gico. Acta bioqu�m. cl�n. latinoam.  [revista en la Internet]. 2004  Jun [citado  2012  Mayo  16] ;  38(2): 203-206. Disponible en: http://www.scielo.org.ar/scielo.php?script=sci_arttext&pid=S0325-29572004000200009&lng=es</small>
                  </blockquote>
                  </div><!-- /.box-footer -->
     </div>
  </div>


</div>
   
</section>