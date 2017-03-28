<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/calculators/fraccion-de-excrecion-de-sodio.js"></script>

<section class="content">
<div class="row">
<div class="col-md-1"></div>
  <div class="col-md-10" id="fraccionPrincipal">
     <div class="box box-default">
                <div class="box-header with-border">
                  <h3 class="box-title"><strong>Datos</strong></h3>
                </div> <!-- /.box-header -->
                <!-- form start -->
                <form class="form-horizontal" id="fraccion">
                  <div class="box-body">
                    <div class="form-group">
                      <label for="inputEmail3" class="col-sm-2 control-label">(Sodio Urinario) U Na (mmol/L)*</label>
                      <div class="col-sm-2">
                        <input type="text" class="form-control"  name="una">
                      </div>
                    </div>
                    <div class="form-group">
                      <label for="inputEmail3" class="col-sm-2 control-label">(Creatinina Sérica) P Cr (mg/dl)*</label>
                      <div class="col-sm-2">
                        <input type="text" class="form-control"  name="pcr">
                      </div>
                    </div>
                    <div class="form-group">
                      <label for="inputEmail3" class="col-sm-2 control-label">(Sodio Sérico) P Na (mmol/L)*</label>
                      <div class="col-sm-2">
                        <input type="text" class="form-control"  name="pna">
                      </div>
                    </div>
                    <div class="form-group">
                      <label for="inputEmail3" class="col-sm-2 control-label">(Creatinina Urinaria) U Cr (mg/dl)*</label>
                      <div class="col-sm-2">
                        <input type="text" class="form-control"  name="ucr">
                      </div>
                    </div>
                   
                  <blockquote id="resultContent" style="text-align: center; display:none;">
<!--                   <h3 class="box-title"><strong>Resultados</strong></h3> -->
                    <p>FENa  :&nbsp;<span id="fraccionresultado"></span>&nbsp;%</p>
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