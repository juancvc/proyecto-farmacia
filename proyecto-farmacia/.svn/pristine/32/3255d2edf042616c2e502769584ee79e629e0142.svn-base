<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="es" data-textdirection="ltr" class="loading">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description"
	content="Stack admin is super flexible, powerful, clean &amp; modern responsive bootstrap 4 admin template with unlimited possibilities.">
<meta name="author" content="">
<title>Registro de Donantes</title>
<!-- Bootstrap core CSS-->

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

<style>
.estilo_cajaOrigen{
	font-color: #0A0A0A;
	font-weight: bold;
	font-family: Cambria;
	font-size: 16px;
	background-color: #ECC64F;
	text-align: center;
	valign:center;
}

</style>

</head>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">
	<!-- Navigation-->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top"
		id="mainNav">
		<a class="navbar-brand label_control_hade" href="#"> SIGEHO WEB </a>
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
			<div class="tituloForm">REGISTRO DE DONANTE VOLUNTARIO</div>

			<f:form id="frmGuardarDonante" class="form-horizontal" role="form"
				method="post" action="" onsubmit="return false">
				<div class="card mb-3">

					<input id="contextPath" type="hidden"
						value="${pageContext.request.contextPath}">

					<f:input class="form-control" type="hidden"
						id="pacienteNombreCompleto" path="persona.nombreCompleto" />


					<f:input type="hidden" class="form-control" id="personaCodigo"
						path="persona.codigo" />
					<f:input type="hidden" class="form-control"
						id="personaCodigoSigeho" path="persona.codigoPersonaSigeho" />
					<div class="card-body">
						<div class="form-group">
							<div class="label_title">DATOS DE CAMPAÑA :</div>
							<div class="row">
								<div class="form-group col-md-3 mb-2">
									<label for="nombreCompleto"  class="label_control">CODIGO CAMPAÑA
									</label>
									<div class="controls">
										<f:input type="text" class="form-control" disabled="true" required="required"
											id="campaniaCodigo" path="campania.codigo" />

									</div>
								</div>
								<div class="col-md-1">
									<button id="idBtnCargarPaciente" type="button"
										style="margin-top: 30px;"
										onclick="buscarCampania()"
										class="form-control btn btn-info">
										<i class="ft-search"></i> BUSCAR
									</button>
								</div>
								<div class="form-group col-md-8 mb-2">
									<label for="nombreCompleto" class="label_control">NOMBRE CAMPAÑA </label>
									<div class="controls">
										<f:input type="text" class="form-control" disabled="true" required="required"
											id="campaniaNombre" path="campania.nombre" />

									</div>
								</div>

								 
							</div>
							<div class="label_title">DATOS DEL DONANTE :</div>
							<div class="row">
								<div class="form-group col-md-3 mb-2">
									<label for="situacion" class="label_control">TIPO
										DOCUMENTO<span class="required">*</span>
									</label>
									<div class="controls">
										<f:select id="tipoDocumentoPaciente"
											path="persona.tipoDocumento.codReg" required="required"
											class="form-control"  onchange="limpiarPorTipo()">
											<f:options items="${lstDocumento}" itemValue="codReg"
												itemLabel="nombreCorto" />
										</f:select>
									</div>
								</div>
								<div class="form-group col-md-3 mb-2">
									<label for="exampleInputName" class="label_control">N°
										DOCUMENTO <span class="required">*</span>
									</label>
									<div class="position-relative has-icon-left">
										<f:input type="hidden" path="codigo" id="codigoReferenciaBean"
											val="" />
										<input id="contextPath" type="hidden"
											value="${pageContext.request.contextPath}">
										<div class="controls">
											<f:input type="text" class="form-control" required="required"
												maxlength="12" id="nroDocumentoPaciente"
												path="persona.nroDocumento"
												onkeypress="return runScript(event)" />
										</div>
									</div>
								</div>
								<div class="col-md-3">
									<button id="idBtnCargarPaciente" type="button"
										style="margin-top: 30px;"
										onclick="buscarPersonaWebService()"
										class="form-control btn btn-info">
										<i class="ft-search"></i> BUSCAR
									</button>
								</div> 
								<div class="col-md-3 mb-2">
									<label for="nombreCompleto" class="label_control">ORIGEN DATOS  
									</label>
									<div class="controls">
										<f:input type="text" class="estilo_cajaOrigen"  
											id="origenDatos" disabled="true"  path="persona.origenDatos" />

									</div>
								</div>
							</div>
							<div class="row">
								<div class="form-group col-md-3 mb-2">
									<label for="nombreCompleto" class="label_control">APELLIDO
										PATERNO <span class="required">*</span>
									</label>
									<div class="controls">
										<f:input type="text" class="form-control" required="required"
											id="personaApellidoPaterno" disabled="true"  path="persona.apellidoPaterno" />

									</div>
								</div>
								<div class="form-group col-md-3 mb-2">
									<label for="nombreCompleto" class="label_control">APELLIDO
										MATERNO </label>
									<div class="controls">
										<f:input type="text" class="form-control"
											id="personaApellidoMaterno" disabled="true"  path="persona.apellidoMaterno" />

									</div>
								</div>
								<div class="form-group col-md-3 mb-2">
									<label for="nombreCompleto" class="label_control">PRIMER
										NOMBRE <span class="required">*</span>
									</label>
									<div class="controls">
										<f:input type="text" class="form-control" required="required"
											id="personaPrimerNombre" disabled="true"  path="persona.primerNombre" />

									</div>
								</div>
								<div class="form-group col-md-3 mb-2">
									<label for="nombreCompleto" class="label_control">SEGUNDO
										NOMBRE </label>
									<div class="controls">
										<f:input type="text" class="form-control"
											id="personaSegundoNombre" disabled="true"  path="persona.segundoNombre" />
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-3 mb-3">
									<label for="situacion" class="label_control">SEXO <span
										class="required">*</span></label>
									<div class="controls">
										<f:select id="sexoPaciente" path="persona.sexo.codReg" disabled="true" 
											class="form-control" required="required">
											<f:option value="" label="Seleccionar" selected="true"
												disabled="disabled" />
											<f:options items="${lstSexo}" itemValue="codReg"
												itemLabel="nombreCorto" />
										</f:select>
									</div>
								</div>
								<div class="col-md-3">
									<label for="lbltipoSeguroPaciente" class="label_control">ESTADO
										CIVIL<span class="required">*</span>
									</label>
									<div class="controls">
										<f:select id="estadoCivilPersona" path="persona.estadoCivil.codReg" disabled="true" 
											class="form-control" required="required">
											<f:option value="" label="Seleccionar" selected="true"
												disabled="disabled" />
											<f:options items="${lstEstadoCivil}" itemValue="codReg"
												itemLabel="nombreCorto" />
										</f:select>
									</div>
								</div>
								<div class="col-md-3 mb-2">
									<label for="exampleInputName" class="label_control">FECHA
										NACIMIENTO <span class="required">*</span>
									</label>
									<div class="controls">
										<fmt:formatDate value="${fechaHasta}" var="dateString"
											pattern="dd/MM/yyyy" />
										<f:input id="personaFechaNac" name="fecha" type="text"
											class="form-control" path="persona.fechaNac" disabled="true" 
											value="${dateString}" size="10" maxlength="10"
											required="required"
											onkeyup="this.value=formateafechaNacimiento(this.value);" />
									</div>
								</div>
								<div class="form-group col-md-3 mb-2">
									<label for="nombreCompleto" class="label_control">EDAD
									</label>
									<div class="controls">
										<f:input type="text" class="form-control" required="required"
											disabled="true" id="edadPersona"
											path="persona.edad" />

									</div>
								</div>
							</div>

							<div class="row">
								<div class="form-group col-md-3 mb-2">
									<label for="lbltipoSeguroPaciente" class="label_control">NACIONALIDAD<span
										class="required"> *</span></label>
									<div class="controls">
										<f:select id="personaNacionalidad" path="persona.nacionalidad.codReg" disabled="true" 
											class="form-control" required="required">
											<f:option value="" label="Seleccionar" selected="true"
												disabled="disabled" />
											<f:options items="${lstNacionalidad}" itemValue="codReg"
												itemLabel="nombreCorto" />
										</f:select>
									</div>
								</div>
								<div class="col-md-3">
									<label for="lbltipoSeguroPaciente" class="label_control">GRADO
										INSTRUCCION<span class="required"> *</span>
									</label>
									<div class="controls">
										<f:select id="personaNivelInstrucion" path="persona.nivelInstrucion.codReg"
											class="form-control" required="required" >
											<f:option value="" label="Seleccionar" selected="true"
												disabled="disabled" />
											<f:options items="${lstNivelInstrucion}" itemValue="codReg"
												itemLabel="nombreCorto" />
										</f:select>
									</div>
								</div>
								<div class="col-md-3">
									<label for="lbltipoSeguroPaciente" class="label_control">OCUPACION<span
										class="required"> *</span></label>
									<div class="controls">
										<f:select id="personaOcupacion" path="persona.ocupacion.codReg"
											class="form-control" required="required" >
											<f:option value="" label="Seleccionar" selected="true"
												disabled="disabled" />
											<f:options items="${lstOcupacion}" itemValue="codReg"
												itemLabel="nombreCorto" />
										</f:select>
									</div>
								</div>
								<div class="col-md-3">
									<label for="exampleInputName" id="lblcodigoFiliacionPaciente"
										class="label_control">ULTIMA FECHA DE DONACION</label>
									<f:input type="text" class="form-control" disabled="true"
										id="ultimaFechaDonancion" path="codigo" />
								</div>
							</div>

							<div class="row">
								<div class="form-group col-md-2 mb-2">
									<label for="nombreCompleto" class="label_control">UBIGEO
										NACIMIENTO </label>
									<div class="controls">
										<f:input type="text" class="form-control" required="required" disabled="true" 
											id="ubigeoNacimientoCodigoUbigeo" path="persona.ubigeoNacimiento.codigoUbigeo" />

									</div>
								</div>
								<div class="col-md-1">
									<button id="btnBuscarUbigeoNaciemiento" type="button" disabled="true" 
										style="margin-top: 30px;" 
										onclick="ubigeoCargarModal(1)"
										class="form-control btn btn-info">
										<i class="ft-search"></i> BUSCAR
									</button>
								</div>
								<div class="form-group col-md-6 mb-2">
									<label for="nombreCompleto" class="label_control">DEPARTAMENTO
										/ PROVINCIA / DISTRITO </label>
									<div class="controls">
										<f:input type="text" disabled="true" 
											value=""
											class="form-control" required="required"
											id="nombreUbigeoNacimiento" path="persona.ubigeoNacimiento.nombreUbigeo" />

									</div>
								</div>
								<div class="form-group col-md-3 mb-2">
									<label for="nombreCompleto" class="label_control">TELEFONO
									</label>
									<div class="controls">
										<f:input type="text" class="form-control" required="required"
											id="telefono" path="persona.apellidoPaterno" />

									</div>
								</div>
							</div>
							<div class="row">
								<div class="form-group col-md-2 mb-2">
									<label for="nombreCompleto" class="label_control">UBIGEO
										DIRECCION </label>
									<div class="controls">
										<f:input type="text" class="form-control" required="required" disabled="true" 
											id="ubigeoDireccion" path="persona.ubigeoDireccion.codigoUbigeo" />

									</div>
								</div>
								<div class="col-md-1">
									<button id="btnBuscarUbigeoDireccion" type="button"
										style="margin-top: 30px;" disabled="true" 
										onclick="ubigeoCargarModal(2)"
										class="form-control btn btn-info">
										<i class="ft-search"></i> BUSCAR
									</button>
								</div>
								<div class="form-group col-md-6 mb-2">
									<label for="nombreCompleto" class="label_control">DEPARTAMENTO
										/ PROVINCIA / DISTRITO </label>
									<div class="controls">
										<f:input type="text" disabled="true" 
											value=""
											class="form-control" required="required"
											id="nombreUbigeoDireccion" path="persona.ubigeoDireccion.nombreUbigeo" />

									</div>
								</div>
								<div class="form-group col-md-3 mb-2">
									<label for="nombreCompleto" class="label_control">CORREO  
									</label>
									<div class="controls">
										<f:input type="email" class="form-control" 
											id="correo" path="persona.apellidoPaterno" />

									</div>
								</div>
							</div>  
							<div class="row">
								<div class="form-group col-md-3 mb-2">
									<img id="imgFotoPaciente" style="margin-top: 10px;"
										src="${pageContext.request.contextPath}/assets/img/fotoPersonaGenerico.gif"
										height="75%" width="55%" />
								</div>
								<div class="form-group col-md-6 mb-2">
									<label for="nombreCompleto" class="label_control">DIRECCION
									</label>
									<div class="controls">
										<f:input type="text" class="form-control" required="required" disabled="true" 
											id="personaDireccion" path="persona.direccion" />

									</div>
								</div>
							</div>
							<div class="form-group text-right"
								style="margin-top: 0px; margin-bottom: 0px;">
								<a
									href="${pageContext.request.contextPath}/bancoController/nuevoDonante"
									class="btn btn-secondary" title=""> <i class="fa icon-plus"></i>
									NUEVO
								</a>

								<button type="submit" onclick="guardarDonante()"
									class="btn btn-primary">
									<i class="fa fa-floppy-o"></i> GUARDAR
								</button>
							</div>
						</div>
					</div>
				</div>
			</f:form>

			<f:form id="frmRegistro" class="form-horizontal" role="form"
				method="POST"
				action="${pageContext.request.contextPath}/perfilController/listado">
				<button type="submit" style="display: none" id="btnListado">Click
					me</button>
			</f:form>
			
		<div class="modal fade text-xs-left" id="modalUbigeo" tabindex="-2"
			role="dialog" aria-labelledby="myModalLabel35" data-dismiss="modal"
			aria-hidden="true" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content" id="modalPersonaContent"></div>
			</div>
		</div>

		<div class="modal fade text-xs-left" id="modalCampania" tabindex="-2"
			role="dialog" aria-labelledby="myModalLabel35" data-dismiss="modal"
			aria-hidden="true" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content" id="modalmodalCampania"></div>
			</div>
		</div>
		
			<!-- Example DataTables Card-->

		</div>
		<!-- /.container-fluid-->
		<!-- /.content-wrapper-->
		<jsp:include
			page="${pageContext.request.contextPath}/../layout/footer-view.jsp" />
		<!-- Scroll to Top Button-->
		<a class="scroll-to-top rounded" href="#page-top"> <i
			class="fa fa-angle-up"></i>
		</a>



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
			src="${pageContext.request.contextPath}/assets/js/page/util/utilitarios.js"
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
			src="${pageContext.request.contextPath}/app-assets/js/sb-admin-datatables.min.js"></script>
		<!-- Custom scripts for all pages-->
		<script src="http://malsup.github.io/jquery.blockUI.js"></script>
	</div>
</body>

<script
			src="${pageContext.request.contextPath}/assets/js/page/asistencial/banco.js"
			type="text/javascript" charset="utf-8"></script>
<script
	src="${pageContext.request.contextPath}/app-assets/vendors/js/extensions/toastr.min.js"
	type="text/javascript"></script>

<script
	src="${pageContext.request.contextPath}/app-assets/vendors/js/extensions/sweetalert.min.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath}/app-assets/js/scripts/extensions/sweet-alerts.js"
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/js/scripts.js"
	type="text/javascript"></script>

<script>
$(document).ready(function(){
	$("#nroDocumentoPaciente").focus();
});
 
$(document).ready(function(){
	//limpiarPorTipo();
	
});

function runScript(e) {
    //See notes about 'which' and 'key'
    if (e.keyCode == 13) { 
    	buscarPersonaWebService(); 
        return false;
    }
}

</script>
</html>










