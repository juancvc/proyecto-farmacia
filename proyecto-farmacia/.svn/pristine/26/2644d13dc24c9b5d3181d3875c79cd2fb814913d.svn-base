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

<div class="modal-dialog modal-lg" role="document">
	<div class="modal-content">
		<div class="modal-header">
			<label class="modal-title text-text-bold-600" id="myModalLabel35"><b>CONFIRMAR
					EMISION DE CITA</b></label>
			<button type="button" class="close" data-dismiss="modal"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
		</div>

		<f:form id="frmGrabarCitaPaciente" class="form-horizontal" role="form"
			method="post" onsubmit="return false" action="">
			<input id="contextPath" type="hidden"
				value="${pageContext.request.contextPath}">

	<f:input type="hidden"  id="codigoDH" path="programacionMedicoCitaBean.codigoProgramacionDH"  />
	<f:input type="hidden"  id="nroPeriodoDH" path="programacionMedicoCitaBean.nroPeriodoDH"  />
	<f:input type="hidden"  id="codServicio" path="programacionMedicoCitaBean.servicio.codReg"  />
	<f:input type="hidden"  id="codEspecialidad" path="programacionMedicoCitaBean.especialidad.codReg"  />
	
	<f:input type="hidden"  id="codPaciente" path="pacienteBean.codigo"  />
	<f:input type="hidden"  id="nroDocumento" path="pacienteBean.persona.nroDocumento"  />
	<f:input type="hidden"  id="codEmpleado" path="programacionMedicoCitaBean.medico.codigo"  />
	<f:input type="hidden"  id="codigoFinaciador" path="pacienteBean.tipoSeguro.codReg"  />
	<f:input type="hidden"  id="horaInicio" path="programacionMedicoCitaBean.horaInicio"  />
	
			<div class="modal-body" id="buscarCIE10">
				<div class="form-group">
					<div class="form-body">
						<div class="row">
							<div class="col-md-6">
								<label for="exampleInputName" class="label_control">PACIENTE</label>
								<f:input type="text" class="form-control" id="nombrePaciente"
									path="pacienteBean.persona.nombreCompleto" disabled="true" />
							</div>
							<div class="col-md-3">
								<label for="exampleInputName" class="label_control">FINANCIADO</label>
								<f:input type="text" class="form-control" id="tipoPaciente"
									path="pacienteBean.tipoSeguro.nombreCorto" disabled="true" />
							</div>
							<div class="col-md-3">
								<label for="exampleInputName" class="label_control">N°
									REFERENCIA</label>
								<f:input type="text" class="form-control" id="pacnumeroReferencia"
									path="referenciaDiagnosticoBean.referenciaBean.numeroReferencia" disabled="true" />
							</div>
						</div> 
						<div class="row">
							<div class="col-md-6">
								<label for="exampleInputName" class="label_control">FECHA
									CITA</label>
								<f:input type="text" class="form-control" id="fechaCita"
									path="fechaCita" disabled="true" />
							</div> 
							<div class="col-md-6">
								<label for="exampleInputName" class="label_control">ESPECIALIDAD</label>
								<f:input type="text" class="form-control" id="especialidad"
									path="programacionMedicoCitaBean.especialidad.nombreCorto" disabled="true" />
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<label for="exampleInputName" class="label_control">MEDICO</label>
								<f:input type="text" class="form-control" id="nombreMedico"
									path="programacionMedicoCitaBean.medico.nombreCompleto" disabled="true" />
							</div>
						</div>
					</div>
				</div>
			</div>
				<f:input type="hidden"  id="fechaProgramacion" path="programacionMedicoCitaBean.strFechaProgramacion"  />
			<div class="modal-footer">
				<button type="button" id="idBtnCerrarModalCita"
					class="btn btn-secondary" data-dismiss="modal"><i class="fa fa-close"></i> CERRAR</button>
				<button class="btn btn-primary" onclick="grabarCita()"
					type="button">
					<i class="fa fa-floppy-o"></i> CONFIRMAR CITA
				</button>
			</div>
		</f:form>
	</div>
</div>
<f:form id="frmListadoReferencia" class="form-horizontal"
					role="form" ethod="POST"
					action="${pageContext.request.contextPath}/citasController/buscar">
					<button type="submit" style="display: none" id="btnListado">Click
						me</button>
				</f:form>
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
 

	 function grabarCita(){   
			 
				var contextPath = $('#contextPath').val(); 
				var actionForm = $('#frmGrabarCitaPaciente').attr("action");
				var url =contextPath+"/citasController/grabarCita";
				var myFormulario = $('#frmGrabarCitaPaciente'); 
				 
						iniciarBloqueo();
						$.ajax({
						type : "POST",
						url : url, 
						data: $('#frmGrabarCitaPaciente').serialize(),
						success : function(data) { 
							    if (data.codigo.length == 0) {
							    	msg_error("Error al realizar la cita");  
								}else{
									 if (data.codigo== "00") {
										 msg_advertencia("Existe cita programada en la especilidad y día para el paciente.");   
											 $("#idBtnCerrarModalCita").trigger("click");
									 }else{
										    msg_exito("Éxito al realizar la cita");   
											 $("#idBtnCerrarModalCita").trigger("click"); 
											 $("#btnListado").trigger("click"); 
									 }
								} 
						},
						
						error : function(xhr, status, er) { 
						        console.log("error: " + xhr + " status: " + status + " er:" + er);
									// msg_error();
			
								},
					  			complete: function()
			  			{
			  				finBloqueo();

						}
				});
			} 
</script>