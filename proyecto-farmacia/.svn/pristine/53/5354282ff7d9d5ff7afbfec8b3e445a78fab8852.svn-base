
<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page import="hnch.referencia.core.bean.seguridad.UsuarioBean"%>

<!------ Include the above in your HEAD tag ---------->

<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>Registro de Citas</title>
<!-- Bootstrap core CSS-->
<link
	href="${pageContext.request.contextPath}/app-assets/vendor/bootstrap/css/bootstrap.min.css"
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
	href="${pageContext.request.contextPath}/app-assets/vendors/css/extensions/toastr.css">
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
<!-- Page level plugin CSS-->
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
</head>
<body class="fixed-nav sticky-footer bg-dark" id="page-top">
	<!-- Navigation-->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top"
		id="mainNav">
		<a class="navbar-brand label_control_hade" href="#"> HCH WEB </a>
		<button class="navbar-toggler navbar-toggler-right" type="button"
			data-toggle="collapse" data-target="#navbarResponsive"
			aria-controls="navbarResponsive" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>


		<div class="collapse navbar-collapse" id="navbarResponsive">
			<jsp:include
				page="${pageContext.request.contextPath}/../layout/menu-view.jsp" />
		</div>
	</nav>

	<div class="content-wrapper">
		<div class="container-fluid">
			<!-- Breadcrumbs
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="#">Citas</a></li>
				<li class="breadcrumb-item active">Registro de Citas</li>
			</ol>-->

			<div class="tituloForm" >REGISTRO DE CITAS</div>
			<!-- Area Chart Example-->  
				<f:form id="frmRegistroCitas" role="form"
					action="${pageContext.request.contextPath}/referenciaController/lista"
					onsubmit="return validar();">
					<input id="contextPath" type="hidden"
						value="${pageContext.request.contextPath}">
					<div class="card-body">
						<div class="row">
							<div class="col-md-2">
								<label for="exampleInputName" class="label_control">N°
									REFERENCIA</label>

								<f:input id="txtNroReferencia" name="txtDatosReferencia"
									type="text" class="form-control"
									path="referenciaBean.paciente.persona.nombreCompleto" size="7"
									maxlength="7" disabled="true" />

								<f:input id="txtNroReferenciaRef" name="txtDatosReferencia"
									type="hidden" class="form-control"
									path="referenciaBean.paciente.persona.nombreCompleto" size="7"
									maxlength="7" />
								<f:input type="hidden" id="codPacienteRef"
									path="referenciaBean.paciente.codigo" />
								<f:input type="hidden" id="nroDocumentoRef"
									path="referenciaBean.paciente.persona.nroDocumento" />
								<f:input type="hidden" id="codigoFinaciadorRef"
									path="referenciaBean.paciente.persona.nroDocumento" />
							</div>
							<div class="col-md-4">
								<label for="exampleInputName" class="label_control">PACIENTE
								</label>
								<f:input id="txtPacienteReferencia" name="txtDatosReferencia"
									type="text" class="form-control"
									path="referenciaBean.paciente.persona.nombreCompleto"
									size="150" maxlength="150" disabled="true" />

								<input id="txtTipoPacienteRef" name="txtTipoPacienteRef"
									type="hidden" class="form-control" />
							</div>
							<div class="col-md-2" id="btnBuscarReferencias">
								<div class="botonDA" style="margin-top: 30px;">
									<button class=" form-control btn btn-info"
										onclick="listaReferencias()" id="Button3" type="button">
										<i class="ft-search"></i> BUSCAR
									</button>
								</div>

							</div>
							<div class="col-md-2" id="btnBuscarReferencias">
								<div class="" style="margin-top: 30px;">
									<button class="btn btn-flat" onclick="limpiarFormulario()"
										type="button">
										<i class="fa fa-eraser"></i> LIMPIAR
									</button>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<label for="exampleInputName" class="label_control">ESTABLECIMIENTO
									ORIGEN </label>
								<f:input id="txtEstablecimientoOrigenReferencia"
									name="txtEstablecimientoOrigenReferencia" type="text"
									class="form-control"
									path="referenciaBean.establecimientoOrige.nomRenaes" size="150"
									maxlength="150" disabled="true" />

								<input id="txtTipoPacienteRef" name="txtTipoPacienteRef"
									type="hidden" class="form-control" />
							</div>
						</div>
						<div class="row">
							<div class="col-md-2">
								<label for="exampleInputName" class="label_control">ESPECIALIDAD</label>
								<f:select id="cboEspecialidad" required="required"
									path="referenciaBean.servicioUPSReferencia.codReg"
									class="form-control" onchange="mostrarCalendarioEspecialidad()">
									<f:option value="" label="Seleccionar" selected="true"
										disabled="disabled" />
									<f:options items="${lstEspecialidad}" itemValue="codReg"
										itemLabel="nombreCorto" />
								</f:select>
								<!-- <input type="text" value="Cardiología" class="form-control"
										disabled="true" id="Especialidad" /> -->
							</div>

						</div>
						<!--	<div class="col-md-2" id="btnBuscardatosCEX">
									<div class="botonDA" style="margin-top: 30px;">
										<button class=" form-control btn btn-info"
											onclick="buscarPersona()" id="Button3" type="button">
											<i class="ft-search"></i> Buscar
										</button>
									</div>
								</div>
								
								<div class="row">
								<div class="col-md-6">
									<label for="exampleInputName" class="label_control">Médico</label>

									<input type="text" value="" disabled="true"
										class="form-control" id="Especialidad" />
								</div>
								<div class="col-md-2" id="btnBuscardatosCEX">
									<div class="botonDA" style="margin-top: 30px;">
										<button class=" form-control btn btn-info"
											onclick="buscarPersona()" id="Button3" type="button">
											<i class="ft-search"></i> Buscar
										</button>
									</div>
								</div>
							</div>  -->
						<br>
						<div><jsp:include
								page="${pageContext.request.contextPath}/../page/asistencial/citas/calendario.jsp" /></div>

					</div>

				</f:form> 

		</div>
		<!-- /.container-fluid-->
		<!-- /.content-wrapper-->
		<jsp:include
			page="${pageContext.request.contextPath}/../layout/footer-view.jsp" />
		<!-- Scroll to Top Button-->
		<a class="scroll-to-top rounded" href="#page-top"> <i
			class="fa fa-angle-up"></i>
		</a>

		<script>
			function cie10CargarModalInterno() {

				$("#modalCIEX").modal('show');
			}
		</script>

		<script>
			function limpiarFormulario() {
				//alert();
				$("#txtNroReferencia").val("");
				$("#txtNroReferenciaRef").val("");
				$("#txtPacienteReferencia").val("");
				$("#txtEstablecimientoOrigenReferencia").val("");
				$('#cboEspecialidad').empty();
				$('#cboEspecialidad').append($('<option>', { 
			       	value: "",
			       	text : "Seleccione"
			   	}));
				limpiarCalendario();
				document.getElementById("organizerContainer-list").innerHTML ="";
			}
		</script>

		<!-- Bootstrap core JavaScript-->
		<script
			src="${pageContext.request.contextPath}/app-assets/vendor/jquery/jquery.min.js"></script>


		<!-- Page level plugin JavaScript-->
		<!-- Custom scripts for all pages-->

		<!-- Custom scripts for this page-->
		<script
			src="${pageContext.request.contextPath}/app-assets/js/sb-admin-datatables.min.js"></script>
		<!-- Custom scripts for this page-->

		<!-- Core plugin JavaScript-->

		<script
			src="${pageContext.request.contextPath}/assets/js/page/asistencial/citas.js"
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
		<!-- Page level plugin JavaScript-->
		<script
			src="${pageContext.request.contextPath}/app-assets/vendor/datatables/jquery.dataTables.js"></script>
		<script
			src="${pageContext.request.contextPath}/app-assets/vendor/datatables/dataTables.bootstrap4.js"></script>
		<!-- Custom scripts for all pages-->
		<script
			src="${pageContext.request.contextPath}/app-assets/js/sb-admin.min.js"></script>
		<!-- Custom scripts for this page-->
		<script
			src="${pageContext.request.contextPath}/app-assets/vendors/js/extensions/sweetalert.min.js"
			type="text/javascript"></script>
		<script
			src="${pageContext.request.contextPath}/app-assets/js/scripts/extensions/sweet-alerts.js"
			type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/assets/js/scripts.js"
			type="text/javascript"></script>
		<script
			src="${pageContext.request.contextPath}/app-assets/vendors/js/extensions/toastr.min.js"
			type="text/javascript"></script>
		<script
			src="${pageContext.request.contextPath}/assets/js/page/util/utilitarios.js"
			type="text/javascript" charset="utf-8"></script>

		<!-- Custom scripts for all pages-->
	</div>
	<div class="modal fade text-xs-left" id="md_descartar-referencia"
		tabindex="-1" role="dialog" aria-labelledby="myModalLabel19"
		aria-hidden="true"></div>
	<div class="modal fade text-xs-left" id="modalReferencias"
		tabindex="-1" role="dialog" aria-labelledby="myModalLabel35"
		data-dismiss="modal" aria-hidden="true" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content" id="modalReferenciasContent"></div>
		</div>
	</div>

	<div class="modal fade text-xs-left" id="modalPacientes" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel35" data-dismiss="modal"
		aria-hidden="true" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content" id="modalPacientesContent"></div>
		</div>
	</div>

</body>
</html>

