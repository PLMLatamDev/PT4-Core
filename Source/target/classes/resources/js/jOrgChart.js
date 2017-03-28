jQuery(document).ready(function() {
	
        $("#org").jOrgChart({
            chartElement : '#chart',
            dragAndDrop  : false,
            depth      : -1,
        });
    });

$(document).ready(function() {


        $(".jOrgChart .level-0").find("tr:gt(0)").hide();


           $(".jOrgChart .node-cells").click(function(){

              var $this = $(this);


              var $tr = $this.closest("tr");
               
              var $prev= $(this).parent().parent(); //Tabla superior
              var $chil=$prev.find("table");        //Tabla inferior

             
              if ($chil.is(':hidden')){
                
                  $prev.find("tr:gt(0)").show(); 
                  $chil.find("tr:gt(0)").hide();

              }else{
              
                $prev.find("tr:gt(0)").hide();
           

              }



              /* optener td */
              var $tdSuperior=$prev.parent();  
              var idImg = $tdSuperior.attr('id')

              /* recorrer tr */

              var $trSuperior=$tdSuperior.parent().children();
            
               $trSuperior.each(function( index ) {

                      var $this2= $(this);
                      var IdImgSelect=$this2.attr('id');

                      if(idImg==IdImgSelect){

                       

                      }else{

                        // cuando el(los) nive(s) sea(n) diferente(s) al(los) seleccionados(s) cerrar
                         var $tr2=$this2.find("table");
                          $tr2.find("tr:gt(0)").hide();
                      }

               });

               /*** recursividad 1 **/

                var IdNodoSelect = $tr.attr('id');
  
                   if(IdNodoSelect=='recursivo1'){


                    $recursivo1Parent=$tr.parent().closest('table').parent().closest('table').parent().closest('table').parent().closest('table');
                    var $recursivo1ParentInferior=$recursivo1Parent.find("table:gt(0)");        //Tabla inferior

                     $recursivo1Parent.find("tr:gt(0)").show();

                     $recursivo1ParentInferior.find("tr:gt(0)").hide();


                   }

                   if(IdNodoSelect=='recursivo2'){


                    $recursivo1Parent=$tr.parent().closest('table').parent().closest('table').parent().closest('table');
                    var $recursivo1ParentInferior=$recursivo1Parent.find("table:gt(0)");        //Tabla inferior

                     $recursivo1Parent.find("tr:gt(0)").show();

                     $recursivo1ParentInferior.find("tr:gt(0)").hide();

                   }







        });
});