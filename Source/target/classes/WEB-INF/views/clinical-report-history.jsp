<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<section class="content">
   <div class="row" style="background-color: #ffffff;">
<!--       <div class="col-md-1"></div> -->
     <div class="col-md-1"></div>
     <div class="col-md-10">
      <div class="box box-primary">
         <div class="box-body">
         
          <table id="report-history-table" class="table table-striped">
			  <tr>
			    <th>Expediente</th>
			    <th>Paciente</th>
			    <th>Fecha Última Receta</th>
			    <th>Ver Reporte</th>
			  </tr>
			  
					  <c:forEach items="${reports}" var="item">
					  <tr>
					  
					    <td>${item.getExpedient()}</td>
					    <td>${item.getPatientName()} ${item.getPatientLastName()}</td>
					    <td>${item.getLastUpdate()}</td>
					    <td><a class="btn btn-app" onclick="getClinicalReportById(${item.getReportId()})" style="height: 30px;padding: 0;"><i class="fa fa-search"></i></a></td>
					   
					  </tr>
					  </c:forEach>
				
 			</table>
         </div>
      </div>
     </div>
    </div>
</section> 
         


<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/plm_clinical_report-history.js"></script>