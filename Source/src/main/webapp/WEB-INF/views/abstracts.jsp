<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="row">
  <section class="col-lg-12">
    <div class="box box-primary">
                <div class="box-header" >
                  <i class="ion ion-clipboard"></i>
                  
                </div><!-- /.box-header -->
                <div class="box-body">
                  <ul class="todo-list">
					<c:forEach items="${GetInformationByPrefixByTypeResult}" var="informationByPrefixByTypeResult">
						<li class="">
                      <a href="${informationByPrefixByTypeResult.link}"  target="_blank" style="width:100%; height:100%;">
                      <!-- todo text -->
                      <i class="fa fa-external-link" style="color:red;"></i>
                      <span class="text"> ${informationByPrefixByTypeResult.electronicTitle }</span>
                      
                      <!-- General tools such as edit or delete-->
                      <!-- <div class="tools"> -->
                        
                      <!-- </div> -->
                      </a>
                    </li>
					</c:forEach>
					
              
                  </ul>
                </div><!-- /.box-body -->
                
              </div>
  </section>
</div>