<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>


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
			<label class="modal-title text-text-bold-600" id="myModalLabel35"><b>APOYO AL DIAGNOSTICO</b></label>
			<button type="button" class="close" data-dismiss="modal"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
		</div>

		<%--<f:form id="frmGuardarInstDirector" class="form-horizontal"
			role="form" method="post"
			 > --%>
			 <div class="form-body">
			<input id="contextPath" type="hidden"
				value="${pageContext.request.contextPath}">
	
				<f:input type="hidden" path="tipoApoyo" id="tipoApoyolstDX"  />

			<div class="modal-body" id="buscarCIE10">
				<div class="row">
					<div class="form-group col-md-8 mb-2 label_control">
						<label for="projectinput1">DESCRIPCION</label>
						<input id="nombreCortoApoyoDX" type="text" class="form-control" />
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-12 text-right" style="margin-bottom: 20px;"> 
						<button class="btn btn-info"
								onclick="buscarEspecialidad()"
								type="button">
						
							<i class="ft-search"></i> BUSCAR
						</button>
					</div>
				</div>
				<div class="row">
					<div class="card-body">
						<div class="table-responsive">
							<!--  --><div id="div1">
								<table class="table  table-bordered" id="dataTable"
									style="overflow-y: scroll">
									<thead class="tabla_th">
										<tr>
											<th width="50">ITEM</th> 
											<th>DESCRIPCION</th>
											<th width="45">ACCION</th>
										</tr>
									</thead>
									<tbody id="idBodyListaApoyos"  class="label_control">
										<c:forEach var="apoyo" items="${lstApoyoDX}"
											varStatus="loop">
											<tr>
												<td>${loop.count}</td> 
												<td>${apoyo.nombreCorto}</td>
												<td><button type="button"
														class="btn btn-outline-success btn-sm"
														data-toggle="tooltip" data-placement="top" title=""
														onclick="llenarApoyoDxREF('${apoyo.nombreCorto}','${apoyo.codReg}','${apoyo.valor1}','${apoyo.valor2}');"
														data-original-title="Seleccionar" 
														id="agregarEspecialidad">
														<i class="icon-check"></i>
													</button></td>
											</tr>
										</c:forEach>
									</tbody>
									
								</table>
							<!--  --></div>
						</div>
					</div>
				</div> 
 
			</div>
			<div class="modal-footer">
				<button type="button" id="btnCerrarmodalApoyoDX" class="btn btn-secondary" data-dismiss="modal"><i class="fa fa-close"></i> CERRAR</button>
			</div>
			</div>
		<%--</f:form>--%>
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
$("#nombreCortoApoyoDX").keyup(function(event) {
    if (event.keyCode === 13) {
    	 buscarEspecialidad();
    }
});
function buscarEspecialidad() {
	
	  var nombreCorto =  $('#nombreCortoApoyoDX').val(); //document.getElementById('nombreCorto').val();
	  var tipoApoyo =  $('#tipoApoyolstDX').val();
	  var contextPath = $('#contextPath').val();
	  var htmlTabla = "";
	  var comilla ="'";
	  var comillaDoble = "'";
	  console.log(nombreCorto+ " / " +tipoApoyo ) ;
	  if ((nombreCorto == null || nombreCorto =="")){
		  msg_advertencia("Ingrese al menos 4 caracteres para iniciar la búsqueda.");  
	  }else if (nombreCorto !="" && nombreCorto.length < 4){
		  msg_advertencia("Ingrese al menos 4 caracteres para iniciar la búsqueda.");  
		  
	  } else { 
	  $.ajax({
	    type: "GET",
	    //data: "entidad=" + entidad,
	   	
	    url: contextPath+"/referenciaController/refrescarListaDX?nombreCorto="+nombreCorto+ "&tipoApoyo=" + tipoApoyo ,
	    	success: function(response){
	    	console.log(response.length);	
	    	if(response.length > 0){
	    		for (var i = 0; i < response.length; i++) {
		    		var item = i+1;
		    		var objEspecialidad = response[i];
		    		htmlTabla += 
		    			"<tr>"+
		    				"<td>"+item +"</td>"+ 
			    			"<td>"+objEspecialidad.nombreCorto.trim()+"</td>"+ 
			    			"<td>"+
					    	 	"<button type='button'"+
					    	 	" class='btn btn-outline-success btn-sm' "+
					    	 	" data-toggle='tooltip'  data-placement='top'"+
					    		"  onclick=\"llenarApoyoDxREF('"+[objEspecialidad.nombreCorto]+"','"+[objEspecialidad.codReg]+"','"+[objEspecialidad.valor1]+"','"+[objEspecialidad.valor2]+"');\""+
					      	 	" data-original-title='Seleccionar'"+
					    	 	" id='agregarEspecialidad'>"+
					    	 	"<i class='icon-check'></i></button>"+
					    		"</td>"+
		    		"</tr>";
				}
	    	}else{
	    		  msg_advertencia("No se encontraron resultados.");  
	    	}
	    	
	    	//console.log(htmlTabla); 
	    	 $('#idBodyListaApoyos').empty(); 
	  	     $('#idBodyListaApoyos').html(htmlTabla);
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
	
		    }
	  });
	 }
}

function vaciar(){
	  $('#idBodyListaEspecialidades').empty();
	}
</script>