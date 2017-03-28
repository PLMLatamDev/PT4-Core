<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/plm_medical_prescription.js"></script>
<section class="content">
  <div class="row">
    <!-- SECCION DE DATOS -->
    <div class="col-md-4">
      <div class="box box-info">
        <div class="box-header with-border">
          <h4 class="box-title">Datos</h4>
        </div>
        <form role="form" class="text-muted" id="formPrescription">
        <div class="box-body">
<!--            <div class="form-group"> -->
<!--                <label>Expediente</label> -->
<!--                <input type="text" name="expedient" class="form-control" placeholder="..."> -->
<!--            </div> -->
           <div class="form-group">
               <label>Nombre(s) *</label>
               <input type="text" name="name" class="form-control" placeholder="...">
           </div>
           <div class="form-group">
               <label>Apellidos *</label>
               <input type="text" name="apellidos" class="form-control" placeholder="...">
           </div>
           <div class="form-group">
               <label>Peso (kg)</label>
               <input type="text" name="peso" class="form-control" placeholder="60">
           </div>
           <div class="form-group">
               <label>Talla (cm)</label>
               <input type="text" name="talla" class="form-control" placeholder="160">
           </div>
           <div class="form-group">
               <label>Frecuencia Cardiaca (l.p.m)</label>
               <input type="text" name="fc" class="form-control" placeholder="80">
          </div>
          <div class="form-group">
               <label>Frecuencia Respiratoria (r.p.m)</label>
               <input type="text" name="fr" class="form-control" placeholder="20">
           </div>
           <div class="form-group">
               <label>Presión Arterial (mmHg)</label>
               <input type="text" name="pa" class="form-control" placeholder="120/80">
           </div>
           <div class="form-group">
           <label>Sexo</label>
             <div class="row">
               <div class="col-xs-3">
               <div class="radio">
                        <label>
                          <input type="radio" name="sexo" id="optionsRadios1" value="1" checked>
                          Hombre
                        </label>
                      </div>
               </div>
               <div class="col-xs-3">
                <div class="radio">
                        <label>
                          <input type="radio" name="sexo" id="optionsRadios1" value="0">
                          Mujer
                        </label>
                      </div>
               </div>
             </div>
           </div>
          <div class="form-group">
                <label>Fecha de Nacimiento *</label><br/>
<!--                 <div class="input-group date form_date" data-date="" data-date-format="dd/mm/yyyy" data-link-field="dtp_input2" data-link-format="dd/mm/yyyy"> -->
<!--                     <input class="form-control" name="birthday" size="16" type="text" value="" readonly> -->
<!--                     <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span> -->
<!-- 					<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span> -->
<!--                 </div> -->
<!-- 				<input class="form-control" id="datepicker" name="birthday" size="16" type="text" value="" > -->
					<input class="form-control" id="datepicker" name="birthday" size="16" type="text" value="" >
				<input type="hidden" id="dtp_input2" value="" /><br/>
            </div>
            <!-- textarea -->
           <div class="form-group">
                      <label>IDX</label>
                      <textarea class="form-control" name="idx" rows="3" placeholder="" style="resize:none;"></textarea>
           </div>
            
           
        </div>
        <!-- <div class="box-footer">
                    <button type="submit" class="btn btn-primary">Submit</button>
                  </div> -->
                  <button type="submit" class="btn btn-app" id="savePrescripcion">
                    <i class="fa fa-print"></i>Imprimir y Guardar
                  </button>
<!--                   <button type="submit" class="btn btn-app" id="printPrescripcion"> -->
<!--                     <i class="fa fa-print"><i class="fa fa-floppy-o"></i></i> Imprimir -->
<!--                   </button> -->
                  <a class="btn btn-app" id="newPrescripcion" >
                    <i class="fa fa-plus-circle"></i> Nueva Receta
                  </a>
       </form>
      </div>
    </div>
    <!--TERMINA SECCION DE DATOS -->
    <!-- SECCION DE MEDICAMENTOS -->
    <div class="col-md-8">
      <div class="box box-info">
        <div class="box-header with-border">
          <h4 class="box-title">Receta</h4>
        </div>
        <div class="box-body">
           <div class="row">
                <div class="col-md-12">
                 <div class="box box-primary">
               
<!-- CONTENIDO -->               
               
               <form id="attributeForm" method="post" class="text-muted"
					 data-fv-framework="bootstrap"
					    data-fv-message="This value is not valid"
					    data-fv-icon-valid="glyphicon glyphicon-ok"
					    data-fv-icon-invalid="glyphicon glyphicon-remove"
					    data-fv-icon-validating="glyphicon glyphicon-refresh">
					    
					    </form>
               
                <form role="form" class="text-muted">
                 <!-- textarea -->
                <div class="form-group">
                      <label style="color:red;"><strong>Notas / Recomendaciones</strong></label>
                      <textarea name="Recommendations" class="form-control" rows="3" placeholder="" style="resize:none;"></textarea>
                 </div>
                </form>
              </div>
                </div>
             
           </div>
        </div>
      </div>
    </div>
    <!--TERMINA SECCION DE MEDICAMENTOS -->
  </div>
    <!-- Modal  -->
			<div aria-hidden="true" class="modal fade" id="modalClinicHistoryPDF" tabindex="-1" role="dialog" aria-labelledby="modalClinicHistoryPDF" data-backdrop="static" data-keyboard="false">
			    <div class="modal-dialog" style="width:70%;min-height:650px;overflow-y: hidden;">
			        <div class="modal-content">
			            <div class="modal-header">
			                <h3 class="modal-title">Receta</h3>
			            </div>
			
			            <div class="modal-body" id="modal-body-content-pdf">
			               
			            </div>
			
			            <div class="modal-footer">
			                      <button type="button" class="btn btn-primary" id="btn-close-prescription">Cerrar</button>
			                <!--  <button type="button" class="btn btn-default" id="disagreeButton" data-dismiss="modal">Cerrar</button> -->
			            </div>
			        </div>
			    </div>
			</div>
</section>
