<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="es">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Farmacia - Usuarios</title>

<!-- Custom fonts for this template-->
<link
	href="${pageContext.request.contextPath}/app-assets/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/app-assets/vendors/css/extensions/toastr.css">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/app-assets/vendors/js/extensions/toastr.min.js">

<link
	href="${pageContext.request.contextPath}/app-assets/css/sb-admin-2.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/app-assets/css/estilos.css"
	rel="stylesheet">

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/assets/css/datepicker.css">

</head>

<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">

		<jsp:include
			page="${pageContext.request.contextPath}/../layout/menu-view.jsp" />

		<!-- End of Sidebar -->

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">

				<!-- Topbar -->
				<jsp:include
					page="${pageContext.request.contextPath}/../layout/head-nav-view.jsp" />
				<!-- End of Topbar -->
				<f:form id="frmRegistroUsuario" class="form-horizontal" role="form"
					method="post" onsubmit="return false" action="">
					<input id="contextPath" type="hidden"
						value="${pageContext.request.contextPath}">

					<div class="container-fluid">

						<!-- Page Heading -->
						<div class="tituloForm">USUARIO</div>
						<div class="card shadow mb-4">
							<!-- Card Content - Collapse -->
							<div class="collapse show" id="collapseCardExample">

								<div class="card-body">
									<div class="form-group">
										<div class="row">
											<div class="col-md-3">
												<label for="tipoDocumento" class="label_control">TIPO
													DOCUMENTO <span class="required">*</span>
												</label>

												<div class="controls">
													<f:select id="tipoDocumentoUsuario"
														path="persona.tipoDocumento.idRegistro"
														required="required" class="form-control">

														<f:options items="${lstDocumento}" itemValue="idRegistro"
															itemLabel="descripcionCorta" />
													</f:select>
												</div>
											</div>
											<div class="col-md-3">
												<label for="exampleInputName" class="label_control">N°
													DOCUMENTO </label>
												<f:input type="text" onkeypress="return soloNumeros(event);"
													required="required" maxlength="12" class="form-control"
													id="nroDocumentoUsuario" path="persona.nroDocumento" />

												<f:input type="hidden" class="form-control"
													id="numeroPeriodo" path="numeroPeriodo" />
											</div>
											<div class="col-md-2" id="btnBuscardatosCEX">
												<div class="botonDA" style="margin-top: 30px;">
													<button class=" form-control btn btn-info"
														onclick="buscarPersona()" id="Button3" type="button">
														<i class="ft-search"></i> BUSCAR
													</button>
												</div>
											</div>
										</div>
									</div>
									<div class="form-group">
										<div class="row">
											<div class="col-md-6">
												<label for="exampleInputName" class="label_control">APELLIDOS
													Y NOMBRES <span class="required">*</span>
												</label>
												<f:input type="text" required="required"
													class="form-control" id="personaUsuarioNombreCompleto"
													path="persona.nombreCompleto" disabled="true" />
											</div>
											<div class="col-md-2">
												<label for="exampleInputName" class="label_control">PERFIL
													<span class="required">*</span>
												</label>
												<div class="controls">
													<f:select id="comboPerfil" path="perfil.codigo"
														required="required" class="form-control">
														<f:option value="" label="Seleccionar" selected="true"
															disabled="disabled" />
														<f:options items="${lstPerfiles}" itemValue="codigo"
															itemLabel="nombrePerfil" />
													</f:select>
												</div>
											</div>

										</div>
									</div>
									<div class="form-body">
										<div class="row">
											<div class="col-md-6">
												<label for="exampleInputName" class="label_control">NOMBRE
													USUARIO <span class="required">*</span>
												</label>
												<f:input type="text" required="required"
													class="form-control" id="nombreUsuario"
													path="nombreUsuario" disabled="true" />
												<f:input type="hidden" path="persona.codigo"
													id="codigoPersonaBean" val="" />
												<f:input type="hidden" path="codigo" id="codigoUsuario" />
												<f:input type="hidden" path="passwordUsuario"
													id="idpasswordUsuario" val="" />
											</div>

										</div>
									</div>
									<div class="form-body">
										<div class="row">
											<div class="col-md-4">
												<label for="exampleInputName" class="label_control">CORREO
												</label>
												<f:input type="email" class="form-control" maxlength="120"
													id="correoUsuario" path="correo" />
											</div>
											<div class="col-md-4">
												<label for="exampleInputName2" class="label_control">
													CELULAR </label>
												<f:input type="text" class="form-control"
													id="celularUsuario" path="nroCelular" maxlength="9" />

											</div>
										</div>
									</div>

									<div class="row">
										<div class="form-group col-md-8 text-right"
											style="margin-top: 15px;">
											<button type="button" class="btn btn-secondary mr-1"
												id="btnRestablecerClaveUser" disabled="true"
												onclick="enviar_ajaxv2('${pageContext.request.contextPath}/usuarioController/resetPassword','POST','#frmRegistroUsuario')">
												<i class="fa fa-key"></i> RESTABLECER CONTRASEÑA
											</button>
											<a href="nuevo" class="btn btn-secondary" title=""> <i
												class="fa fa-eraser"></i> NUEVO
											</a>

											<button id="btn-save-reg" type="submit"
												class="btn btn-flat btn-primary"
												onclick="grabarUsuario('${pageContext.request.contextPath}/usuarioController/','#frmRegistroUsuario')">
												<i class="fa fa-floppy-o"></i> GUARDAR
											</button>
										</div>
									</div> 
									<div class="label_title">
										ASIGNAR ACCESO ALMACEN <span class="required">*</span>:
									</div>
									<div id="panelCEX" class="panel_style col-md-8">
										<div class="row">
											<div class="form-group col-md-3 mb-1">
												<label for="situacion" class="label_control">ALMACEN<span
													class="required">*</span>
												</label>
												<div class="controls">
													<f:select id="cboAlmacen" path="almacen.codigo"
														class="form-control">
														<f:option value="" label="Seleccionar" selected="true"
															disabled="disabled" />
														<f:options items="${lstAlmacen}" itemValue="codigo"
															itemLabel="nombreAlmacen" />
													</f:select>
												</div>
											</div>
											<div class="col-md-4 mb-3" style="margin-top: 25px;">
												<button type="button" id="btnAgregarAlmacen"
													title='Confirmar' disabled="true"
													onclick="asignarAlmacen()" class="btn btn-outline-success">
													<i class="fa fa-check">ASIGNAR</i>
												</button>
											</div>
										</div>
										<div class="row">
											<div class="col-md-12">
												<div class="table-responsive">
													<table id="dataTable" class="table table-bordered">
														<thead class="tabla_th">
															<tr>
																<th width="30">ITEM</th>
																<th>ALMACEN</th>
																<th width="200">ACCION</th>
															</tr>
														</thead>
														<tbody id="idbodyTabla" class="label_control">
															<c:forEach var="usuarioAlmacen"
																items="${lstUsuarioAlmacen}" varStatus="loop">
																<tr>
																	<td>${loop.count}</td>
																	<td><label for='idAlmacen' class='label_control'
																		id="${usuarioAlmacen.almacen.codigo}">
																			${usuarioAlmacen.almacen.nombreAlmacen}</label></td>
																	<td><button type='button'
																			class='btn btn-outline-danger btn-sm'
																			data-toggle='tooltip' data-placement='top'
																			title='Eliminar'
																			onclick="confirmar_eliminar(${loop.count},'1');"
																			data-original-title='Eliminar'
																			id='agregarEspecialidad'>
																			<i class='fas fa-trash'></i>
																		</button>
																		<button type='button'
																			class='btn btn-outline-success btn-sm'
																			data-toggle='tooltip' data-placement='top'
																			title='Turno'
																			onclick="asignarTurno(${loop.index});"
																			data-original-title='Turno'
																			id='agregarEspecialidad'>
																			<i class='fas fa-clock-o'> Turno</i>
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
							</div>
						</div>
					</div>
				</f:form>
				<!-- /.container-fluid -->

			</div>
			<!-- End of Main Content -->

			<!-- Footer -->
			<jsp:include
				page="${pageContext.request.contextPath}/../layout/footer-view.jsp" />

			<!-- End of Footer -->

		</div>
		<!-- End of Content Wrapper -->

	</div>
	<!-- End of Page Wrapper -->

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>

	<!-- Logout Modal-->
	<jsp:include
		page="${pageContext.request.contextPath}/../layout/confirmacion-modal-view.jsp" />


	<!-- Bootstrap core JavaScript-->
	<script
		src="${pageContext.request.contextPath}/app-assets/vendor/jquery/jquery.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/app-assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script
		src="${pageContext.request.contextPath}/app-assets/vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script
		src="${pageContext.request.contextPath}/app-assets/js/sb-admin-2.min.js"></script>

	<!-- Page level plugins -->
	<script
		src="${pageContext.request.contextPath}/app-assets/vendor/datatables/jquery.dataTables.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/app-assets/vendor/datatables/dataTables.bootstrap4.min.js"></script>

	<!-- Page level custom scripts -->


	<!-- scripts  -->

	<script
		src="${pageContext.request.contextPath}/assets/js/page/util/datepicker.js"
		type="text/javascript" charset="utf-8"></script>

	<script
		src="${pageContext.request.contextPath}/assets/js/page/util/block.js"
		type="text/javascript" charset="utf-8"></script>

	<script
		src="${pageContext.request.contextPath}/assets/js/page/util/datepicker.es.min.js"
		type="text/javascript" charset="utf-8"></script>

	<script
		src="${pageContext.request.contextPath}/assets/js/page/util/utilitarios.js"
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

	<script
		src="${pageContext.request.contextPath}/assets/js/page/seguridad/usuario.js"
		type="text/javascript"></script>


	<script>
		
		$(document).ready(
				function() {
					var codigo =  $('#codigoUsuario').val();
					console.log("codigo " + codigo);
					if(codigo != ''){ 
						console.log("ingresa activa botones ");
						document.getElementById("btnAgregarAlmacen").disabled = false;
						document.getElementById("btnRestablecerClaveUser").disabled = false;
					}
				})
		</script>

	<script>
		document.getElementById('navConfiguracion').className = "nav-item active";
		document.getElementById('enlaceUsuario').className = "collapse-item active";
		document.getElementById('collAccesos').className = "nav-link";
		document.getElementById('collapseAccesos').className = "collapse show";
		
		
	
	</script>
 
	<div class="modal fade text-xs-left" id="modalTurno" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel35" data-dismiss="modal"
		aria-hidden="true" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content" id="modalArticuloContent"></div>
		</div>
	</div>

</body>

</html>
