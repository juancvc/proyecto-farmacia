<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<link
	href="https://fonts.googleapis.com/css?family=Montserrat:300,300i,400,400i,500,500i%7COpen+Sans:300,300i,400,400i,600,600i,700,700i"
	rel="stylesheet">

<link
	href="https://fonts.googleapis.com/css?family=Montserrat:300,300i,400,400i,500,500i%7COpen+Sans:300,300i,400,400i,600,600i,700,700i"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/fonts/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/css/plugins/forms/validation/form-validation.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/css/plugins/forms/switch.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/css/plugins/extensions/toastr.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/css/plugins/forms/extended/form-extended.css">
<link
	href="${pageContext.request.contextPath}/app-assets/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Custom fonts for this template-->
<link
	href="${pageContext.request.contextPath}/app-assets/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<!-- Page level plugin CSS-->
<!-- Custom styles for this template-->
<link
	href="${pageContext.request.contextPath}/app-assets/css/sb-admin.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/app-assets/css/estilos-cayetano.css"
	rel="stylesheet">

<link rel="shortcut icon" type="image/x-icon"
	href="${pageContext.request.contextPath}/app-assets/images/ico/logoLabico.ico">
<!-- Custom fonts for this template-->
<link
	href="${pageContext.request.contextPath}/app-assets/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/fonts/simple-line-icons/style.min.css">


<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/fonts/feather/style.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/fonts/font-awesome/css/font-awesome.min.css">

<div class="modal-dialog modal-lg" role="document">
	<div class="modal-content">
		<div class="modal-header">
			<label class="modal-title text-text-bold-600" id="myModalLabel35"><b>LISTADO DE EXÁMENES
			</b></label>
			<button type="button" class="close" data-dismiss="modal"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
		</div>

		<f:form id="frmlistarCIE10" class="form-horizontal" role="form"
			method="post" onsubmit="return false" action="">
			<input id="contextPath" type="hidden"
				value="${pageContext.request.contextPath}">

			<div class="modal-body" id="buscarCIE10">
				<div class="row"> 
					<div class="col-md-8">
						<label for="exampleInputName" class="label_control">DESCRIPCIÓN</label>
						<f:input type="text" class="form-control" id="txtDescripcion" autofocus="true"
							autocomplete="off" path="descripcion" />
					</div>
					<div class="col-md-4">
						<label for="exampleInputName" class="label_control">TIPO</label>

						<div class="controls">
							<f:select id="cboTipoExamen" path="tipo.codReg"  class="form-control"
								onchange="buscarPorTipo()">
								<f:option value="" label="Todos" selected="true"
									disabled="disabled" />
								<f:options items="${lstTipoExamen}" itemValue="codReg"
									itemLabel="nombreCorto" />
							</f:select>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-12 text-right"
						style="margin-top: 20px; margin-bottom: 20px;">
						<button onclick="limpiarForm();" type="button"
							class="btn btn-flat btn-default">
							<i class="fa fa-eraser"></i> LIMPIAR
						</button>
						<button class="btn btn-info" onclick="buscarPorTipo()"
							type="button">
							<i class="ft-search"></i> BUSCAR
						</button>

					</div>
				</div>
				<div class="row">
					<div class="card-body">
						<div class="table-responsive">
							<div id="div1">
								<table class="table table-bordered" id="dataTable"
									style="overflow-y: scroll">
									<thead class="tabla_th">
										<tr>
											<th width="50">ITEM</th>
											<th>DESCRIPCION</th>
											<th>TIPO</th>
											<th>SUBTIPO</th>
											<th width="90">PRECIO (S/.)</th>
											<th width="45">ACCION</th>
										</tr>
									</thead>
									<tbody id="idBodyListaExamenes" class="label_control">

										<c:forEach var="ciex" items="${lstTarifarioBean}"
											varStatus="loop">
											<tr>
												<td>${loop.count}</td>
												<td>${ciex.descripcion}</td>
												<td>${ciex.tipo.nombreCorto}</td>
												<td>${ciex.subtipo}</td>
												<td>${ciex.sPrecio}</td>
												<td><button type="button"
														class="btn btn-outline-success btn-sm"
														data-toggle="tooltip" data-placement="top" title=""
														data-original-title="Seleccionar"
														onclick="llenarExamenIndex(${loop.index})"
														id="agregarEspecialidad">
														<i class="icon-check"></i>
													</button></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="modal-footer">

				<button type="button" id="idBtnCerrarModalCIEX"
					class="btn btn-secondary" data-dismiss="modal">
					<i class="fa fa-close"></i> CERRAR
				</button>

			</div>
		</f:form>
	</div>
</div>

<script
	src="${pageContext.request.contextPath}/app-assets/vendor/jquery/jquery.min.js"></script>


<!-- Page level plugin JavaScript-->
<!-- Custom scripts for all pages-->

<!-- Custom scripts for this page
		<script
			src="${pageContext.request.contextPath}/app-assets/js/sb-admin-datatables.min.js"></script>
		<!-- Custom scripts for this page-->

<!-- Core plugin JavaScript-->

<script
	src="${pageContext.request.contextPath}/assets/js/page/asistencial/laboratorio.js"
	type="text/javascript" charset="utf-8"></script>
<!-- Page level plugin JavaScript-->
<!-- Bootstrap core JavaScript-->
<script
	src="${pageContext.request.contextPath}/app-assets/vendor/jquery/jquery.min.js"></script>
<script
	src="${pageContext.request.contextPath}/app-assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- Core plugin JavaScript-->
<script
	src="${pageContext.request.contextPath}/app-assets/vendor/jquery-easing/jquery.easing.min.js"></script>
<!-- Page level plugin JavaScript
		<script
			src="${pageContext.request.contextPath}/app-assets/vendor/datatables/jquery.dataTables.js"></script>
		<script
			src="${pageContext.request.contextPath}/app-assets/vendor/datatables/dataTables.bootstrap4.js"></script>
		<!-- Custom scripts for all pages-->
<script
	src="${pageContext.request.contextPath}/app-assets/js/sb-admin.min.js"></script>
<!-- Custom scripts for this page-->

<script
	src="${pageContext.request.contextPath}/assets/js/page/util/utilitarios.js"
	type="text/javascript" charset="utf-8"></script>

<script
	src="${pageContext.request.contextPath}/app-assets/js/scripts/extensions/block-ui.js"
	type="text/javascript"></script>
<script src="http://malsup.github.io/jquery.blockUI.js"></script>

<script> 


$(document).ready(function(){
	
	//document.getElementById("txtDescripcion").focus();
	
  $("#txtDescripcion").on("keyup", function() {
    var value = $(this).val().toLowerCase();
    $("#idBodyListaExamenes tr").filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });
  });
  
  document.getElementById("txtDescripcion").focus();
});

function  limpiarForm(){
	$("#cboTipoExamen").val("");
	$("#txtDescripcion").val(""); 
	$("#idBodyListaExamenes tr").remove(); 
	// $("#txtDescripcion").focus(); 
   	} 
    
$("#txtDescripcion").keyup(function(event) {
    if (event.keyCode === 13) {
    	buscarPorTipo();
    }
});	 


 
function buscarPorTipo() {
//debugger;
	  var contextPath = $('#contextPath').val();
	  var descripcion = $('#txtDescripcion').val().trim();
	  var tipo = $('#cboTipoExamen').val().trim();
	  
	  var htmlTabla = "";  
	  var url = contextPath+"/laboratorioController/refrescarListTarifario?tipo="+tipo+ "&descripcion=" +descripcion;   
	  console.log("descripcion " + descripcion);
	  console.log("tipo " + tipo);
	    
	  $.ajax({
	        type: "GET",
	     //   data: $('#frmlistarCIE10').serialize(), 
	    	url : url, 
	    	success: function(response){
	    	console.log(response.length);	
	    	if(response.length > 0){
	    	for (var i = 0; i < response.length; i++) {
	    		var item = i+1;
	    		var ciex = response[i];
	    		htmlTabla += 
	    			"<tr>"+
	    				"<td>"+item +"</td>"+
	    				"<td>"+ciex.descripcion+"</td>"+ 
		    			"<td>"+ciex.tipo.nombreCorto+"</td>"+ 
		    			"<td>"+ciex.subtipo+"</td>"+ 
		    			"<td>"+ciex.sPrecio+"</td>"+ 
		    			"<td>"+
				    	 	"<button type='button'"+
				    	 	" class='btn btn-outline-success btn-sm' "+
				    	 	" data-toggle='tooltip'  data-placement='top'"+
				    		"  onclick=llenarExamenIndex("+i+");"+
				      	 	" data-original-title='Seleccionar' title='Seleccionar'"+
				    	 	" id='agregarEspecialidad'>"+
				    	 	"<i class='icon-check'></i></button>"+
				    		"</td>"+
	    		"</tr>";
	    	}
			}else{
	    		  msg_advertencia("No se encontraron resultados.");  
	    	}
	    	
	    	//console.log(htmlTabla); 
	    	 $('#idBodyListaExamenes').empty(); 
	  	     $('#idBodyListaExamenes').html(htmlTabla);
		    },error: function(xhr,status,er) {
	         console.log("error: " + xhr + " status: " + status + " er:" + er);
				    if(xhr.status==500) {
				    	console.log(er);
				    	//Error_500(er);
				    }
				    if(xhr.status==901) {
			    	console.log(er);
			    	//spire_session_901(er);
	 			}
	
		    }, 
		    complete: function()
			{
				//finBloqueo();
			}
	  });
}

</script>