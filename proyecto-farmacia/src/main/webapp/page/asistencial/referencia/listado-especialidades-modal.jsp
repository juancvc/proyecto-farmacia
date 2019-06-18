<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<link
	href="https://fonts.googleapis.com/css?family=Montserrat:300,300i,400,400i,500,500i%7COpen+Sans:300,300i,400,400i,600,600i,700,700i"
	rel="stylesheet">

<link
	href="${pageContext.request.contextPath}/app-assets/css/estilos-cayetano.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/app-assets/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/fonts/simple-line-icons/style.css">
	
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/fonts/simple-line-icons/style.min.css">
 <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/fonts/feather/style.min.css">		
  <script
			src="${pageContext.request.contextPath}/assets/js/page/asistencial/referencia.js"
			type="text/javascript" charset="utf-8"></script>
<div class="modal-dialog modal-lg" role="document">
	<div class="modal-content">
		<div class="modal-header">
			<label class="modal-title text-text-bold-600" id="myModalLabel35"><b>Listado
					de Especialidades</b></label>
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
			
			<input id="codigoCIEXAsociado" type="hidden" value="">


			<div class="modal-body" id="buscarCIE10">
				<div class="row">
					<div class="form-group col-md-8 mb-2 label_control">
						<label for="projectinput1">Nombre de Especialidad</label>
						<input id="nombreCortoEspecialidad" type="text" class="form-control" />
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-12 text-right"> 
						<button class="btn btn-secondary"
								onclick="buscarEspecialidad()"
								type="button">
						
							<i class="ft-search"></i> Buscar
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
											<th width="70">Item</th>
											<th>Descripción</th>
											<th width="80">Acci&oacute;n</th>
										</tr>
									</thead>
									<tbody id="idBodyListaEspecialidades">
										<c:forEach var="especialidad" items="${lstEspecialidad}"
											varStatus="loop">
											<tr>
												<td>${loop.count}</td>
												<td>${especialidad.nombreCorto}</td>
												<td><button type="button"
														class="btn btn-outline-success btn-sm"
														data-toggle="tooltip" data-placement="top" title=""
														onclick="enviarDatosEspecialidad('${especialidad.nombreCorto}','${especialidad.codReg}');"
														data-original-title="Seleccionar" 
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
				<button type="button" id="btnCerrarmodalEspecialidad" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
			</div>
			</div>
		<%--</f:form>--%>
	</div>
</div>
<script>
$("#nombreCortoEspecialidad").keyup(function(event) {
    if (event.keyCode === 13) {
    	 buscarEspecialidad();
    }
});

function enviarDatosEspecialidad( nombEspecialidad, codEspecialidad){
	 
	var codigoCIEXAsociado = $('#codigoCIEXAsociado').val();
	llenarEspecialidadREF(codigoCIEXAsociado,nombEspecialidad,codEspecialidad);
}

function buscarEspecialidad() {
	
	  var nombreCorto =  $('#nombreCortoEspecialidad').val(); //document.getElementById('nombreCorto').val();
	  var contextPath = $('#contextPath').val();
	  var htmlTabla = "";
	  var comilla ="'";
	  var comillaDoble = "'";
	  console.log(nombreCorto);
	  $.ajax({
	    type: "GET",
	    //data: "entidad=" + entidad,
	   	
	    url: contextPath+"/referenciaController/refrescarListaEspecialidades?nombreCorto="+nombreCorto,
	    	success: function(response){
	    	console.log(response.length);	
	    	for (var i = 0; i < response.length; i++) {
	    		var item = i+1;
	    		var objEspecialidad = response[i];
	    		htmlTabla += 
	    			"<tr>"+
	    				"<td>"+item +"</td>"+
		    			"<td>"+objEspecialidad.nombreCorto+"</td>"+ 
		    			"<td>"+
				    	 	"<button type='button'"+
				    	 	" class='btn btn-outline-success btn-sm' "+
				    	 	" data-toggle='tooltip'  data-placement='top'"+
				    	 	"  onclick=\"enviarDatosEspecialidad('"+[objEspecialidad.nombreCorto]+"','"+[objEspecialidad.codReg]+"');\""+
				      	 	" data-original-title='Seleccionar'"+
				    	 	" id='agregarEspecialidad'>"+
				    	 	"<i class='icon-check'></i></button>"+
				    		"</td>"+
	    		"</tr>";
			}
	    	//console.log(htmlTabla); 
	    	 $('#idBodyListaEspecialidades').empty(); 
	  	     $('#idBodyListaEspecialidades').html(htmlTabla);
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

function vaciar(){
	  $('#idBodyListaEspecialidades').empty();
	}
</script>