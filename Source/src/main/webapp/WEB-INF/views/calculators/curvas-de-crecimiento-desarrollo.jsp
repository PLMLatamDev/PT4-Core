<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/calculators/curvas-de-crecimiento-desarrollo.js"></script>

<section class="content">
<div class="row">
<div class="col-md-1"></div>
  <div class="col-md-10" id="crecimientoPrincipal">
     <div class="box box-default">
                <div class="box-header with-border">
                  <h3 class="box-title"><strong>Datos</strong></h3>
                </div> <!-- /.box-header -->
                <!-- form start -->
 
                
                <form class="form-horizontal" id="crecimiento">
                  <div class="box-body">
                    <div class="form-group">
                      <label for="inputEmail3" class="col-sm-2 control-label">Peso (kg)*</label>
                      <div class="col-sm-2">
                        <input type="text" class="form-control"  name="peso">
                      </div>
                    </div>
                    <div class="form-group">
                      <label for="inputEmail3" class="col-sm-2 control-label">Longitud (cm)*</label>
                      <div class="col-sm-2">
                        <input type="text" class="form-control"  name="longitud">
                      </div>
                    </div>
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">Sexo*</label>
							<div class="col-sm-2">
								<div class="col-sm-6">
									<div class="radio">
										<label> <input type="radio" name="sexo" id="sexo"
											value="F"> Mujer
										</label>
									</div>
								</div>
								<div class="col-sm-6">
									<div class="radio">
										<label> <input type="radio" name="sexo" id="sexo"
											value="M"> Hombre
										</label>
									</div>
								</div>
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-2 control-label">Fecha de Nacimiento*</label>
							<div class="col-sm-3">
<!-- 							<div class="input-group date form_date" data-date="" -->
<!-- 								data-date-format="dd/mm/yyyy" data-link-field="dtp_input2" -->
<!-- 								data-link-format="dd/mm/yyyy"> -->
								
<!-- 								<input class="form-control" name="birthday" size="16" -->
<!-- 									type="text" value="" readonly> <span -->
<!-- 									class="input-group-addon"><span -->
<!-- 									class="glyphicon glyphicon-remove"></span></span> <span -->
<!-- 									class="input-group-addon"><span -->
<!-- 									class="glyphicon glyphicon-calendar"></span></span> -->
							
<!-- 							</div> -->
								<input class="form-control" id="datepicker" name="birthday" size="16" type="text" value="" >
				<input type="hidden" id="dtp_input2" value="" /><br/>
							</div>
						</div>
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">Gráfica*</label>
							<div class="col-sm-2">
								<div class="col-sm-12">
									<div class="radio">
										<label> <input type="radio" name="grafica" id="sexo"
											value="LONG-ESTA"> Longitud/Estatura para la edad
										</label>
									</div>
								</div>
								<div class="col-sm-12">
									<div class="radio">
										<label> <input type="radio" name="grafica" id="sexo"
											value="PESO-EDAD"> Peso para la edad
										</label>
									</div>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">Mostrar*</label>
							<div class="col-sm-2">
								<div class="col-sm-12">
									<div class="radio">
										<label> <input type="radio" name="mostrar" id="sexo"
											value="PERC"> Gráfica de percentiles
										</label>
									</div>
								</div>
								<div class="col-sm-12">
									<div class="radio">
										<label> <input type="radio" name="mostrar" id="sexo"
											value="PUNT"> Gráfica de puntuación
										</label>
									</div>
								</div>
							</div>
						</div>


						<blockquote id="resultContent" style="text-align: center; display:none;">
<!--                   <h3 class="box-title"><strong>Resultados</strong></h3> -->
                    <p>Resultado :&nbsp;<span id="crecimientoresultado"> </span></p>
                   <p><span id="textpresionArterial"> </span></p>
                 
                    
                  </div><!-- /.box-body -->
                  <div class="box-footer text-center">
                   
                    <button type="submit" class="btn btn-primary">Calcular</button>
                      
                  </div><!-- /.box-footer -->
                </form>
              </div>
  </div>
    <div class="col-md-12" id="crecimientoSecond" style="display:none;">
    <div class="row">
       <div class="col-md-12">
        <div class="box box-default">
                <div class="box-header with-border">
                <div class="row">
                  <div class="col-md-6">
                   <a href="" id="mostrarEnPantalla" target="_blank" class="btn btn-primary">Mostrar gráfica en ventana completa</a>
                  </div>
                  <div class="col-md-6">
                  
                  <a Style="cursor:pointer;" id="backGrafic" title="Regresar">
                   <span class="glyphicon glyphicon-arrow-left" style="font-size: 202%;color: #001F3F;"></span>
                  </a>
                  </div>
                </div>
                
                </div> <!-- /.box-header -->
                <div class="box-body">
                  <iframe id="iframeCrecimiento" src="" style="width: 100%;height: 100%;"  seamless="seamless"></iframe>
                </div>
        </div>
       </div>
    </div>
  </div>



</div>
   
</section>