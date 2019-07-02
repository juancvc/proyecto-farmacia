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

<title>Farmacia - Articulo</title>
 
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
					action="${pageContext.request.contextPath}/articuloController/buscar">
					<!-- Begin Page Content -->
					<div class="container-fluid">

						<!-- Page Heading -->
						<div class="tituloForm">LISTADO DE ARTICULOS</div>


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
										<div class="col-md-6 mb-2">
											<label for="nombreCompleto" class="label_control">NOMBRE
												ARTICULO </label>
											<div class="controls">
												<f:input type="text" class="form-control"
													required="required" id="txtnombre" path="nombre" />

											</div>
										</div>
										<div class="col-md-3 mb-1">
											<label for="lbltipoSeguroPaciente" class="label_control">TIPO</label>
											<div class="controls">
												<f:select id="cboTipoArticulo"
													path="tipoArticulo.idRegistro" class="form-control"
													required="required">
													<f:option value="" label="Seleccionar" selected="true"
														disabled="disabled" />
													<f:options items="${lstTipoArticulo}"
														itemValue="idRegistro" itemLabel="descripcionCorta" />
												</f:select>
											</div>
										</div>
										<div class="col-md-3 mb-1">
											<label for="lbltipoSeguroPaciente" class="label_control">CODIGO
												SISMED</label>
											<div class="controls">
												<f:input type="text" class="form-control"
													required="required" id="txtnombre" path="nombre" />
											</div>
										</div>
									</div>


									<div class="row">
										<div class="form-group col-md-12 text-right"
											style="margin-top: 15px;">
											<button id="btnBuscar" class="btn btn-success"
												type="submit">
												<i class="fa fa-search"> </i> BUSCAR
											</button>
											<button
												onclick="limpiarForm();$('#dataTable').dataTable().fnClearTable();"
												type="button" class="btn btn-flat btn-secondary ">
												<i class="fa fa-eraser"></i> LIMPIAR
											</button> 
											<a href="${pageContext.request.contextPath}/aticuloController/nuevo"
												 class="btn btn-info"> <i class="fa fa-file"></i>
													<span class="text"> NUEVO</span>
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
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                  <thead>
                    <tr>
                      <th>ITEM</th>
                      <th>DESCRIPCION</th>
                      <th>PRESENTACION</th>
                      <th>CONCENTRACION</th>
                      <th>COD SISMED</th>
                      <th>CATEGORIA</th>
                    </tr>
                  </thead>
                  <tfoot>
                    <tr>
                      <th>ITEM</th>
                      <th>DESCRIPCION</th>
                      <th>PRESENTACION</th>
                      <th>CONCENTRACION</th>
                      <th>COD SISMED</th>
                      <th>CATEGORIA</th>
                    </tr>
                  </tfoot>
                  <tbody>
                    	<c:forEach var="articulo" items="${lstArticulos}" varStatus="loop">
						<tr>
							<td>${loop.count}</td>
							<td>${articulo.nombre}</td>
							<td>${loop.count}</td>
							<td>${loop.count}</td>
							<td>${loop.count}</td>
							<td>${loop.count}</td>					
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
	<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
					<button class="close" type="button" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">Ã</span>
					</button>
				</div>
				<div class="modal-body">Select "Logout" below if you are ready
					to end your current session.</div>
				<div class="modal-footer">
					<button class="btn btn-secondary" type="button"
						data-dismiss="modal">Cancel</button>
					<a class="btn btn-primary" href="login.html">Logout</a>
				</div>
			</div>
		</div>
	</div>

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
	<script>
		document.getElementById('navMantenimiento').className = "nav-item active";
		document.getElementById('enlaceArticulo').className = "collapse-item active";
		document.getElementById('CollMantenimiento').className = "nav-link";
		document.getElementById('collapseMantenimiento').className = "collapse show";
	</script>



</body>

</html>
