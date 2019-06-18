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
			<div class="tituloForm">EVALUACIÓN FISICA DE POSTULANTE VOLUNTARIO</div>

			<f:form id="frmGuardarEstadoFisico" class="form-horizontal" role="form"
				method="post" action="" onsubmit="return false">
				<div class="card mb-3">
				
<f:input type="hidden"  id="codigoPostulante" path="codigo" />
<f:input type="hidden"  id="estadoFisicoBeancodigo" path="estadoFisicoBean.codigo" />
<f:input type="hidden"  id="estadoFisicoBeanCodigoOrganizacion" path="estadoFisicoBean.codigoOrganizacion" />
<f:input type="hidden"  id="estadoFisicoBeanCodigoInstitucion" path="estadoFisicoBean.codigoInstitucion" />
<f:input type="hidden"  id="estadoFisicoBeanCodigoSede" path="estadoFisicoBean.codigoSede" />
<f:input type="hidden"  id="estadoFisicoBeannumeroPeriodo" path="estadoFisicoBean.numeroPeriodo" />
<f:input type="hidden"  id="estadoFisicoBeannumeroVersion" path="estadoFisicoBean.numeroVersion" />
<f:input type="hidden"  id="estadoFisicopersonaCodigo" path="estadoFisicoBean.personaBean.codigo" />

					<input id="contextPath" type="hidden"
						value="${pageContext.request.contextPath}">
					<f:input type="hidden" class="form-control" id="personaCodigo"
						path="persona.codigo" />
					<f:input type="hidden" class="form-control"
						id="personaCodigoSigeho" path="persona.codigoPersonaSigeho" />
					<div class="card-body">
						<div class="form-group">
							 
							 
							<div class="label_title">DATOS DEL POSTULANTE :</div>
							<div class="row">
								<div class="form-group col-md-3 mb-2">
									<label for="situacion" class="label_control">TIPO
										DOCUMENTO 
									</label>
									<div class="controls">
										<f:select id="tipoDocumentoPaciente"  disabled="true" 
											path="persona.tipoDocumento.codReg" required="required"
											class="form-control"  onchange="limpiarPorTipo()">
											<f:options items="${lstDocumento}" itemValue="codReg"
												itemLabel="nombreCorto" />
										</f:select>
										<f:input type="hidden" id="tipoDocumentoPersona"  path="persona.tipoDocumento.codReg" />	
									</div>
								</div>
								<div class="form-group col-md-3 mb-2">
									<label for="exampleInputName" class="label_control">N°
										DOCUMENTO 
									</label>
									<div class="position-relative has-icon-left">
										<input id="contextPath" type="hidden"
											value="${pageContext.request.contextPath}">
										<div class="controls">
											<f:input type="text" class="form-control" required="required"
												maxlength="12" id="nroDocumentoPaciente"  disabled="true" 
												path="persona.nroDocumento"
												onkeypress="return runScript(event)" />
											<f:input type="hidden" id="nroDocumentoPersona"  path="persona.nroDocumento" />	
										</div>
									</div>
								</div>
								 	<div class="form-group col-md-3 mb-2">
									<label for="nombreCompleto" class="label_control">APELLIDO
										PATERNO 
									</label>
									<div class="controls">
										<f:input type="text" class="form-control" required="required"
											onkeyup="javascript:this.value=this.value.toUpperCase();" id="personaApellidoPaterno" disabled="true"  path="persona.apellidoPaterno" />

									</div>
								</div>
								<div class="form-group col-md-3 mb-2">
									<label for="nombreCompleto" class="label_control">APELLIDO
										MATERNO </label>
									<div class="controls">
										<f:input type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"
											id="personaApellidoMaterno" disabled="true"  path="persona.apellidoMaterno" />

									</div>
								</div>
								 
							</div>
							<div class="row"> 
								<div class="form-group col-md-3 mb-2">
									<label for="nombreCompleto" class="label_control">PRIMER
										NOMBRE
									</label>
									<div class="controls">
										<f:input type="text" class="form-control" required="required" onkeyup="javascript:this.value=this.value.toUpperCase();"
											id="personaPrimerNombre" disabled="true"  path="persona.primerNombre" />

									</div>
								</div>
								<div class="form-group col-md-3">
									<label for="nombreCompleto" class="label_control">SEGUNDO
										NOMBRE </label>
									<div class="controls">
										<f:input type="text" class="form-control" onkeyup="javascript:this.value=this.value.toUpperCase();"
											id="personaSegundoNombre" disabled="true"  path="persona.segundoNombre" />
									</div>
								</div>
									<div class="col-md-3">
									<label for="situacion" class="label_control">SEXO</label>
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
										CIVIL
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
							</div>
							<div class="row"> 
								<div class="form-group col-md-3 mb-2">
									<label for="exampleInputName" class="label_control">FECHA
										NACIMIENTO <span class="required">*</span>
									</label>
									<div class="controls">
										<fmt:formatDate value="${fechaHasta}" var="dateString"
											pattern="dd/MM/yyyy" />
										<f:input id="personaFechaNac" name="fecha" type="text"
											class="form-control" path="persona.fechaNacStr" disabled="true" 
											value="${dateString}" size="10" maxlength="10"
											required="required"
											onkeyup="this.value=formateafechaNacimiento(this.value);" />
									</div>
								</div>
								<div class="col-md-3">
									<label for="lbltipoSeguroPaciente" class="label_control">NACIONALIDAD</label>
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
									<label for="nombreCompleto" class="label_control">CORREO 
									</label>
									<div class="controls">
										<f:input type="email" class="form-control" 
											id="correo" path="persona.correo"  disabled="true" />

									</div>
								</div>
							 <div class="col-md-3">
									<label for="nombreCompleto" class="label_control">TELEFONO   
									</label>
									<div class="controls">
										<f:input type="text" class="form-control" required="required"  onKeyPress="return soloNumeros(event)" maxlength="9"
											id="telefono" disabled="true"  path="persona.telefonoNumero" />

									</div>
								</div>
							</div>  
							<div class="row">
								<div class=" col-md-3">
                                    <img id="imgFotoPostulante"
										src="${pageContext.request.contextPath}/assets/img/fotoPersonaGenerico.gif"
										height="75%" width="55%" /> 
										
								</div>
								<div class=" col-md-6">
									<label for="nombreCompleto" class="label_control">UBIGEO DIRECCION </label>
									<div class="controls">
										<f:input type="text" disabled="true" 
											value=""
											class="form-control" required="required"
											id="nombreUbigeoDireccion" path="persona.ubigeoDireccion.nombreUbigeo" />

									</div>
								</div>
								<div class=" col-md-3 ">
									<label for="nombreCompleto" class="label_control">DIRECCION  
									</label>
									<div class="controls">
										<f:input type="text" class="form-control" required="required" disabled="true" 
											id="personaDireccion" path="persona.direccion" />

									</div>
								</div>
								
							</div>
							<div class="label_title">DATOS DE LA EVALUACION :</div>
							<div class="row"> 
								<div class="form-group col-md-3 mb-2">
									<label for="exampleInputName" class="label_control">HTCO <span class="required">*</span>
									</label>
									<div class="controls">
										<f:input id="personaFechaNac" name="fecha" type="text"
											class="form-control" path="estadoFisicoBean.htco" size="2" maxlength="2"
											required="required"
											 />
									</div>
								</div>
								<div class="col-md-3">
									<label for="lbltipoSeguroPaciente" class="label_control">GRUPO <span class="required">*</span></label>
									<div class="controls">
										<f:select id="personaNacionalidad" path="estadoFisicoBean.grupoSanguineo.codReg" 
											class="form-control" required="required">
											<f:option value="" label="Seleccionar" selected="true"
												disabled="disabled" />
											<f:options items="${lstGrupoSangre}" itemValue="codReg"
												itemLabel="nombreLargo" />
										</f:select>
									</div>
								</div>
								 <div class="col-md-3">
									<label for="nombreCompleto" class="label_control">FACTOR RH <span class="required">*</span>
									</label>
									<div class="controls">
										<f:select id="personaNacionalidad" path="estadoFisicoBean.factor.codReg" 
											class="form-control" required="required">
											<f:option value="" label="Seleccionar" selected="true"
												disabled="disabled" />
											<f:options items="${lstFactor}" itemValue="codReg"
												itemLabel="nombreLargo" />
										</f:select>
									</div>
								</div>
							 <div class="col-md-3">
									<label for="nombreCompleto" class="label_control">CALIFICACION <span class="required">*</span>   
									</label>
									<div class="controls">
									<f:select id="personaNacionalidad" path="estadoFisicoBean.calificacion.codReg" 
											class="form-control" required="required">
											<f:option value="" label="Seleccionar" selected="true"
												disabled="disabled" />
											<f:options items="${lstCalificacion}" itemValue="codReg"
												itemLabel="nombreCorto" />
										</f:select>
									</div>
								</div>
							</div>  
							<div class="row">
								<div class="col-md-12">
									<label for="situacion" class="label_control">OBSERVACION</label>
									<div class="position-relative has-icon-left">
										<f:textarea id="descripcion" rows="3" class="form-control"  maxlength="350"
											path="estadoFisicoBean.observacion"></f:textarea>

									</div>
								</div>
							</div>
							<div class="form-group text-right"
								style="margin-top: 10px; margin-bottom: 0px;">
								<a
									href="${pageContext.request.contextPath}/evaluacionController/buscarPostulanteEvaluacion"
									class="btn btn-secondary" title="">
									REGRESAR
								</a>

								<button type="submit" onclick="guardarEstadoFisico()"
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
				action="${pageContext.request.contextPath}/evaluacionController/buscarPostulanteEvaluacion">
				<button type="submit" style="display: none" id="btnListadoEvaluacion">Click
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
<!-- <script
	src="${pageContext.request.contextPath}/assets/js/page/asistencial/banco.js"
	type="text/javascript" charset="utf-8"></script>
	 -->

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
	
	var codigoPostulante =$("#codigoPostulante").val();
	if (codigoPostulante.length > 0) {
		var dni =$("#nroDocumentoPersona").val();
		var tipoDoc =$("#tipoDocumentoPersona").val();
		console.log("dni " + dni);
		console.log("tipoDoc "+ tipoDoc);
		fotoPostulante(tipoDoc,dni);
	}

});

function fotoPostulante(tipoDoc, dni){
	var contextPath = $('#contextPath').val();
	
	$
	.ajax({
		type : "GET",
		url : contextPath
				+ "/evaluacionController/obtenerFotoPostulante?tipoDocumento="
				+ tipoDoc + "&numero=" + dni,

		success : function(persona) { 

				if (persona != null) {
					if (persona.length != 0) {  
						var image = new Image();
						var src = contextPath
								+ "/assets/img/fotoPersonaGenerico.gif";
						if (persona.foto != null) {
							src = "data:image/png;base64,"
									+ persona.foto;
						}
						image.src = src;
						image.alt = "Image"
						// $('#imgFotoPaciente').append(image);

						$("#imgFotoPostulante")
								.attr("src", image.src);

						// $('#tipoDocumentoPaciente').val(persona.tipoDocumento.codReg); 
					}  

				}   
		},
		error : function(xhr, status, er) {
			console.log("error: " + xhr + " status: " + status
					+ " er:" + er);
			if (xhr.status == 500) {
				console.log(er);
				// Error_500(er);
			}
			if (xhr.status == 901) {
				console.log(er);
				// spire_session_901(er);
			}

		}
	});
	
	
}
function runScript(e) {
    //See notes about 'which' and 'key'
    if (e.keyCode == 13) { 
    	buscarPersonaWebService(); 
        return false;
    }
}

</script>
</html>










