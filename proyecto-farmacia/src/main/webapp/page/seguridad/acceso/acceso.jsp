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

<title>Farmacia - Accesos</title>

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
				<f:form id="frmListadoPerfil" class="form-horizontal" role="form"
					enctype="multipart/form-data" method="post"
					action="${pageContext.request.contextPath}/accesoController/buscar">
					<input id="contextPath" type="hidden"
						value="${pageContext.request.contextPath}">
					<input type="hidden" id="contextPathUrl"
						value="${pageContext.request.contextPath}">

					<div class="container-fluid">
						<!-- Page Heading -->
						<div class="tituloForm">ACCESO</div>
						<div class="card shadow mb-4">
							<!-- Card Content - Collapse -->
							<div class="collapse show" id="collapseCardExample">

								<div class="card-body">
									<div class="form-group">

										<div class="row">

											<div class="col-md-3 ">
												<label for="exampleInputName" class="label_control">PERFIL
													<span class="required">*</span>
												</label>
												<div class="controls">
													<f:select id="cboPerfil" path="perfil.codigo"
														required="required" class="form-control">
														<f:option value="" label="Seleccionar" selected="true"
															disabled="disabled" />
														<f:options items="${lstPerfil}" itemValue="codigo"
															itemLabel="nombrePerfil" />
													</f:select>
												</div>
											</div>
										</div>
										<div class="row">
										<div class="form-group col-md-12 text-right"
											style="margin-top: 15px;">
											<button id="btnBuscar" class="btn btn-success" type="submit">
												<i class="fa fa-search"> </i> BUSCAR
											</button>
											<button
												onclick="limpiarFormAcceso()"
												type="button" class="btn btn-flat btn-secondary ">
												<i class="fa fa-eraser"></i> LIMPIAR
											</button> 
											</div>
										</div> 
										<div class="row">
											<div class="table-responsive">
												<table class="table table-bordered" id="dataTable">
													<thead class="tabla_th">
														<tr>
															<th width="30">ITEM</th>
															<th>MENU</th>
															<th width="50">ASIGNADO</th>
															<th width="50">ACCION</th>
														</tr>
													</thead>
													<tbody id="idBodyTablaMenus" class="label_control">
														<c:forEach var="acceso" items="${lstAccesoBean}"
															varStatus="loop">
															<tr class="fila_seleccionada"
																id="tr_selecc_${loop.count}">
																<td>${loop.count}</td>
																<td>${acceso.componente.descripcion}</td>
																<td><c:choose>
																		<c:when test="${acceso.flgAsignado=='true'}">
																			<input type="checkbox" value="${acceso.codigo}"
																				id="${acceso.componente.codigo}" checked="checked" />
																		</c:when>
																		<c:otherwise>
																			<input type="checkbox" value="${acceso.codigo}"
																				id="${acceso.componente.codigo}" />
																		</c:otherwise>
																	</c:choose></td>
																<td class="btn-bqd-submenu">
																	<button type="button"
																		class="btn btn-outline-success btn-sm "
																		data-toggle="tooltip" data-original-title="Ver"
																		onclick="verSubMenu('${acceso.componente.codigo}',${loop.count})">
																		<i class="fas fa-search"></i>
																	</button>
																</td> 	
															</tr>
														</c:forEach>
													</tbody>
												</table>
											</div>
										</div>
										<div class="row" id="idRowButtonSaveOnlyMenu">
											<div class="form-group col-md-12 text-right"
												style="margin-top: 15px;">
												<c:if test="${totalMenus>0}">
													<button id="btn-save-only-menu" type="button"
														class="btn btn-flat btn-primary"
														onclick="guardarCambiosAcceso(1)">
														<i class="fa fa-floppy-o"></i> GUARDAR
													</button>
												</c:if>
											</div>
										</div>

										<br>
										<div class="row">
											<div class="form-group col-md-12">
												<div id="contentSubMenuTabla"></div>
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
		src="${pageContext.request.contextPath}/assets/js/page/seguridad/acceso.js"
		type="text/javascript"></script> 

	<script>
		document.getElementById('navConfiguracion').className = "nav-item active";
		document.getElementById('enlaceRoles').className = "collapse-item active";
		document.getElementById('collAccesos').className = "nav-link";
		document.getElementById('collapseAccesos').className = "collapse show";
		
		
	
	</script>



</body>

</html>
