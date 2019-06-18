<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html lang="es" data-textdirection="ltr" class="loading"> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
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
	href="${pageContext.request.contextPath}/app-assets/images/ico/iconHNCH.ico">
<!-- Custom fonts for this template-->
<link
	href="${pageContext.request.contextPath}/app-assets/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<!-- Page level plugin CSS
<link
	href="${pageContext.request.contextPath}/app-assets/vendor/datatables/dataTables.bootstrap4.css"
	rel="stylesheet">


<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/vendors/css/tables/datatable/dataTables.bootstrap4.min.css">
	
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/vendors/css/forms/selects/select2.min.css">
<!-- Custom styles for this template-->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/fonts/simple-line-icons/style.min.css">


<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/fonts/feather/style.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/fonts/font-awesome/css/font-awesome.min.css">
<script
	src="${pageContext.request.contextPath}/assets/js/page/asistencial/referencia.js"
	type="text/javascript" charset="utf-8"></script>

<div class="modal-dialog modal-lg" role="document">
	<div class="modal-content">
		<div class="modal-header">
			<label class="modal-title text-text-bold-600" id="myModalLabel35"><b>LISTA
					DE LUGAR DE CAMPAÑAS</b></label>
			<button type="button" class="close" data-dismiss="modal"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
		</div>

		<f:form id="frmListLugarCampania" class="form-horizontal"
			role="form" method="post" onsubmit="return false" action="">
			<div class="form-body">
				<input id="contextPath" type="hidden"
					value="${pageContext.request.contextPath}">


				<div class="modal-body" id="buscarCIE10">
					<div class="row">
						<div class="col-md-6">
							<label for="exampleInputName" class="label_control">NOMBRE
								CAMPAÑA</label>
							<f:input id="txtNombre" name="txtNombre" type="text"
								class="form-control" path="nombre" />
						</div>

					</div>
					<div class="row">
						<div class="form-group col-md-12 text-right"
							style="margin-top: 20px; margin-bottom: 20px;">
							<button onclick="limpiarForm();" type="button"
								class="btn btn-flat btn-default">
								<i class="fa fa-eraser"></i> LIMPIAR
							</button>
							<button class="btn btn-info" onclick="buscarLugar()"
								type="button">
								<i class="ft-search"></i> BUSCAR
							</button>

						</div>
					</div>
					<div class="row">
						<div class="card-body">
							<div class="table-responsive">
								<!--  -->
								<div id="div1">
									<table class="table  table-bordered" id="dataTable"
										style="overflow-y: scroll">
										<thead class="tabla_th">
											<tr>
												<th width="50">ITEM</th>
												<th>NOMBRE CAMPAÑA</th>
												<th>LUGAR</th>
												<th width="45">ACCION</th>
											</tr>
										</thead>
										<tbody id="idBodyListaLugarCampanias" class="label_control">
											<c:forEach var="campania" items="${lstLugarCampaniaBean}"
												varStatus="loop">
												<tr>
													<td>${loop.count}</td>
													<td>${campania.nombre}</td>
													<td>${campania.ubigeoLugar.detalle}</td>
													<td>
														<button type="button"
															class="btn btn-outline-success btn-sm"
															data-toggle="tooltip" data-placement="top" title=""
															data-original-title="Seleccionar"
															onclick="llenarLugarCampaniaIndex(${loop.index})"
															id="agregarEspecialidad">
															<i class="icon-check"></i>
														</button>
													</td>
												</tr>
											</c:forEach>
										</tbody>

									</table>
									<!--  -->
								</div>
							</div>
						</div>
					</div>

				</div>
				<div class="modal-footer">
					<button type="button" id="btnCerrarmodalApoyoDX"
						class="btn btn-secondary" data-dismiss="modal">
						<i class="fa fa-close"></i> CERRAR
					</button>
				</div>
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
	src="${pageContext.request.contextPath}/assets/js/page/asistencial/referencia.js"
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
$("#txtNombre").keyup(function(event) {
    if (event.keyCode === 13) {
    	 buscarLugar();
    }
}); 
function  limpiarForm(){
	  $("#txtNombre").val(""); 
	  $("#txtNombre").focus(); 
} 

function buscarLugar() {

	  var contextPath = $('#contextPath').val(); 
	  
	  var htmlTabla = "";   
		  $.ajax({
			    type: "GET",
				    url: contextPath+"/bancoController/buscarFiltroLugarCampania" ,
				    data: $('#frmListLugarCampania').serialize(), 
			    	success: function(response){
			    	console.log(response.length);	
			    	
			    	if(response.length > 0){
			    	for (var i = 0; i < response.length; i++) {
			    		var item = i+1;
			    		var campania = response[i];
			    		htmlTabla += 
			    			"<tr>"+
			    				"<td>"+item +"</td>"+
			    				"<td>"+campania.nombre+"</td>"+ 
				    			"<td>"+campania.ubigeoLugar.detalle+"</td>"+ 
				    			"<td>"+
						    	 	"<button type='button'"+
						    	 	" class='btn btn-outline-success btn-sm' "+
						    	 	" data-toggle='tooltip'  data-placement='top'"+
						    		"  onclick=llenarLugarCampaniaIndex("+i+");"+
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
			    	 $('#idBodyListaLugarCampanias').empty(); 
			  	     $('#idBodyListaLugarCampanias').html(htmlTabla);
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