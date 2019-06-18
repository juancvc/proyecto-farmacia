<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
<title>Registro de Establecimientos</title>
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
			<!-- Breadcrumbs-->
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="#">Seguridad / Usuario</a></li>
				<li class="breadcrumb-item active">Registro de Usuario</li>
			</ol>

			<!-- Icon Cards-->
			<div class="row"></div>
			<!-- Area Chart Example-->
			<div class="card mb-3">
				<div class="card-header">
					<i class="fa fa-area-chart"></i>REGISTRO DE USUARIO
				</div>
				<f:form id="frmRegistroUsuario" class="form-horizontal" role="form"
					method="post" onsubmit="return false" action="">
					<input id="contextPath" type="hidden"
						value="${pageContext.request.contextPath}">
					<div class="card-body">

						<div class="row">
							<div class="col-md-2">
								<label for="exampleInputName" class="label_control">Código
									Renaes <span class="required">*</span>
								</label>
								<f:input type="text"  
									class="form-control" 
									id="idEstablecimientoDestino"
									value="" path="codRenaes"
									disabled="true"  />
							</div>
							<div class="col-md-4">
								<label for="exampleInputName" class="label_control">Nombre
									establecimiento <span class="required">*</span>
								</label>
								<f:input disabled="true" type="text" class="form-control"
									id="nombreEstablecimientoDestino"
									value="" 
									path="nomRenaes"
									required="required" />


							</div>
							<div class="col-md-1"> 
								<div class="botonDA" style="margin-top: 30px;">
								<button class=" form-control btn btn-secondary" id="Button3"
									onclick="cargarEstablecimientoModal()" type="button">
									<i class="ft-search"></i> Buscar
								</button>
								</div>
							</div>
						</div>
						<br>
						<div class="row">
							<div class="col-md-7 text-right ">
								<button id="btnAgregarEstabUser" type="button" disabled="true"
									class="btn btn-info" onclick="cargarEstablecimientoModal()">
									<i class="fa fa-plus"></i> Agregar establecimiento(s) destino
								</button>
							</div>
						</div>
						<br>
						<div class="form-body">
							<div class="row">
								<div class="col-md-7" id="listEstablecimientoUser">
									<table class="table table-bordered">
										<thead class="tabla_th">
											<tr>
												<th>Item</th>
												<th>Código Establecimiento</th>
												<th>Nombre de Establecimiento</th>
												<th>Categoría</th>
												<th>Red</th>
												<th>Acción</th>
											</tr>
										</thead>
										<tbody id="idTablaUsuarioRenaes" class="label_control">
											<c:forEach var="obj" items="${lstUsuarioRenaes}"
												varStatus="loop">
												<tr>
													<td>${loop.count}</td>
													<td>${obj.renaes.codRenaes}</td>
													<td>${obj.renaes.nomRenaes}</td>
													<td>${obj.renaes.categoria.nombreCorto}</td>
													<td>${obj.renaes.red}</td>
													<td><button type='button'
															class='btn btn-outline-danger btn-sm'
															data-toggle='tooltip' data-placement='top'
															title='Eliminar'
															onclick="confirmar_eliminar('${obj.codigo}','2')"
															data-original-title='Eliminar' id='eliminarUserRenaes'>
															<i class='icon-trash'></i>
														</button></td>

												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>

						</div>

						<div class="row">
							<div class="form-group col-md-7 text-right"
								style="margin-top: 15px;">
								<button id="btn-save-reg" type="submit"
									class="btn btn-flat btn-primary"
									onclick="grabarUsuario('${pageContext.request.contextPath}/usuarioController/','#frmRegistroUsuario')">
									<i class="fa fa-floppy-o"></i> Guardar
								</button>

								<a href="nuevo" class="btn btn-secondary" title=""> <i
									class="fa fa-eraser"></i> Nuevo
								</a>
							</div>
						</div>
					</div>
				</f:form>
				<f:form id="frmRegistro" class="form-horizontal" role="form"
					method="POST"
					action="${pageContext.request.contextPath}/perfilController/lista">
					<button type="submit" style="display: none" id="btnListado">Click
						me</button>
				</f:form>
			</div>

			<!-- Example DataTables Card-->

		</div>
		<div class="modal fade text-xs-left" id="md_confirmacion"
			tabindex="-1" role="dialog" aria-labelledby="myModalLabel19"
			aria-hidden="true">
			<div class="modal-dialog modal-sm" role="document">
				<div class="modal-content">
					<div class="label_title_modal modal-header">

						<h4 class="label_title" id="myModalLabel19">Confirma
							Acci&oacute;n</h4>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<p id="txt_confir" class="label_control">¿Está seguro de
							eliminar registro seleccionado?</p>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn grey btn-outline-secondary"
							data-dismiss="modal">Cerrar</button>
						<button id="btnConfirmarGeneric" type="button"
							class="btn btn-outline-primary">Confirmar</button>
					</div>
				</div>
			</div>
		</div>

		<div class="modal fade text-xs-left" id="modalEstablecimiento"
			tabindex="-1" role="dialog" aria-labelledby="myModalLabel35"
			data-dismiss="modal" aria-hidden="true" aria-hidden="true">
			<div class="modal-dialog modal-lg" role="document">
				<div class="modal-content" id="modalEstablecimientoContent"></div>
			</div>
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
		<script
			src="${pageContext.request.contextPath}/app-assets/vendors/js/extensions/toastr.min.js"
			type="text/javascript"></script>
		<script
			src="${pageContext.request.contextPath}/app-assets/vendors/js/ui/blockUI.min.js"
			type="text/javascript"></script>
		<script
			src="${pageContext.request.contextPath}/app-assets/js/scripts/extensions/block-ui.min.js"
			type="text/javascript"></script>
		<script
			src="${pageContext.request.contextPath}/app-assets/vendors/js/extensions/sweetalert.min.js"
			type="text/javascript"></script>
		<script
			src="${pageContext.request.contextPath}/app-assets/js/scripts/extensions/sweet-alerts.js"
			type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/assets/js/scripts.js"
			type="text/javascript"></script>
		<script
			src="${pageContext.request.contextPath}/assets/js/page/seguridad/usuario.js"
			type="text/javascript" charset="utf-8"></script>


		<script src="http://malsup.github.io/jquery.blockUI.js"></script>
	</div>
</body>

<script type="text/javascript">
	ocultarBotones();

	function runScript(e) {
		//See notes about 'which' and 'key'
		if (e.keyCode == 13) {
			buscarPersona();
			return false;
		}
	}
</script>
</html>
