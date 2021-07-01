<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Farmacia - Catálogos</title>

<!-- Custom styles for this template-->

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/vendors/css/extensions/toastr.css">

<!-- Custom fonts for this template-->
<link
	href="${pageContext.request.contextPath}/app-assets/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link
	href="${pageContext.request.contextPath}/app-assets/css/sb-admin-2.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/app-assets/css/estilos.css"
	rel="stylesheet">
<!-- Custom styles for this page -->
<link
	href="${pageContext.request.contextPath}/app-assets/vendor/datatables/dataTables.bootstrap4.min.css"
	rel="stylesheet">
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
				<f:form id="frmListadoArticulo" role="form"
					action="${pageContext.request.contextPath}/catalogoController/buscar">
					<!-- Begin Page Content -->
					<div class="container-fluid">

						<!-- Page Heading -->
						<div class="tituloForm">LISTADO DE CATÁLOGOS</div>


						<div class="card shadow mb-2">
							<!-- Card Header - Accordion -->
							<a href="#collapseCardExample" class="d-block card-header py-3"
								data-toggle="collapse" role="button" aria-expanded="true"
								aria-controls="collapseCardExample"> <span
								class="label_filtro">FILTROS</span>
							</a>
							<!-- Card Content - Collapse -->
							<div class="collapse show" id="collapseCardExample">
								<div class="card-body">
									<div class="row">

										<div class="col-md-4">
											<label for="exampleInputName" class="label_control"> NOMBRE DE LA TABLA</label>
											<div class="controls">
												<f:select id="cbotablas" path="idCatalogo"
													      class="form-control">
													<f:option value="" label="Seleccionar" selected="true"
														disabled="disabled" />
													<f:options items="${lstcatalogos}" itemValue="idCatalogo"
														itemLabel="descripcionCorta" />
												</f:select>
											</div>
										</div>
										<div class="col-md-4">
											<label for="exampleInputName" class="label_control">NOMBRE
												CORTO </label>
											<f:input type="text" class="form-control"
												id="descripcionCorta" path="descripcionCorta"
												maxlength="150" />
										</div>
									</div>
									<div class="row">
										<div class="form-group col-md-12 text-right"
											style="margin-top: 15px;">
											<button id="btnBuscar" class="btn btn-success" type="submit">
												<i class="fa fa-search"> </i> BUSCAR
											</button>
											<button
												onclick="limpiarForm();$('#dataTable').dataTable().fnClearTable();"
												type="button" class="btn btn-flat btn-secondary ">
												<i class="fa fa-eraser"></i> LIMPIAR
											</button>
											<a
												href="${pageContext.request.contextPath}/catalogoController/nuevo"
												class="btn btn-info"> <i class="fa fa-file"></i> <span
												class="text"> NUEVO</span>
											</a>
										</div>
									</div>

								</div>
							</div>
						</div>

						<div class="card shadow mb-4">
							<!-- Card Content - Collapse -->
							<div class="collapse show" id="collapseCardExample">
								<div class="card-body">
									<div class="form-group">

										<div class="table-responsive">
											<table class="table table-bordered" id="dataTable"
												width="100%" cellspacing="0">
												<thead>
													<tr class="tabla_th">
														<th width="30">ITEM</th>
														<th>CATALOGO</th>
														<th>NOMBRE REGISTRO</th>
														<th width="50">ACCIONES</th>
													</tr>
												</thead>
												<tfoot>
												<tbody id="idBodyListaCIEX"  class="tabla_td">
													<c:forEach var="tabla" items="${lstcatalogosRegistros}"
														varStatus="loop">
														<tr>
															<td>${loop.count}</td>
															<td>${tabla.nombreCatalogo}</td>
															<td>${tabla.descripcionCorta}</td>
															<td><a title="Modificar" data-placement="top"
																data-toggle="tooltip"
																class="btn btn-outline-success btn-sm"
																onclick="javascript:modificarElementoGenerico('/catalogoController/modificar','${loop.index}')"
																href="#"><i class="fas fa-pencil-alt"></i></a>

																<button type='button'
																	class='btn btn-outline-danger btn-sm'
																	data-toggle='tooltip' data-placement='top'
																	title='Eliminar'
																	onclick="confirmar_accion(${loop.index});"
																	data-original-title='Eliminar' id='agregarEspecialidad'>
																	<i class='fas fa-trash'></i>
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
					<a style="display: none;"
						href="${pageContext.request.contextPath}/catalogoController/listado"
						class="btn btn-secondary" id="btnListado"></a>
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


	<input id="contextPath" type="hidden"
		value="${pageContext.request.contextPath}">
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
	<script
		src="${pageContext.request.contextPath}/app-assets/js/demo/datatables-demo.js"></script>

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
		src="${pageContext.request.contextPath}/assets/js/page/mantenimiento/catalogo.js"
		type="text/javascript"></script>
	<script>
	 
	 	document.getElementById('navMantenimiento').className = "nav-item active";
	 	document.getElementById('enlaceCatalogo').className = "collapse-item active";
	 	document.getElementById('CollMantenimiento').className = "nav-link";
	 	document.getElementById('collapseMantenimiento').className = "collapse show";
	</script>

	<jsp:include
		page="${pageContext.request.contextPath}/../layout/confirmacion-modal-view.jsp" />

 
</body>

</html>
