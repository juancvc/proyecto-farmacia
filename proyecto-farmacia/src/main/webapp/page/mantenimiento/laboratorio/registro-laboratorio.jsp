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

<title>Farmacia - Laboratorio</title>

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
				<f:form id="frmRegistroLaboratorio" role="form" action=""
					onsubmit="return false">
					<input id="contextPath" type="hidden"
						value="${pageContext.request.contextPath}">
					<!-- Begin Page Content -->
					<div class="container-fluid">

						<!-- Page Heading -->
						<div class="tituloForm">REGISTRO LABORATORIO</div>


						<div class="card shadow mb-4">
							<!-- Card Content - Collapse -->
							<div class="collapse show" id="collapseCardExample">
								<div class="card-body">
									<div class="form-group">
										<div class="row">
											<div class="form-group col-md-6 mb-2">
												<label for="nombreCompleto" class="label_control">NOMBRE LABORATORIO <span class="required">*</span>
												</label>
												<div class="controls">
													<f:input type="hidden" class="form-control" id="codigo"
														path="codigo" />
													<f:input type="text" class="form-control"
														required="required"
														onkeyup="javascript:this.value=this.value.toUpperCase();"
														id="txtNombreAlmacen" path="nombre" maxlength="50"/>

												</div>
											</div>
											<div class="form-group col-md-4 mb-2">
												<label for="nombreCompleto" class="label_control">RUC
												</label>
												<div class="controls">
													<f:input type="text" class="form-control"
														onkeypress="return soloNumeros(event);"
														id="txtRuc" path="ruc" maxlength="11"/>

												</div>
											</div>
										</div>
									<div class="row">
											<div class="form-group col-md-10 mb-2">
												<label for="nombreCompleto" class="label_control">DESCRIPCION 
												</label>
												<div class="controls">
												 <f:textarea class="form-control"
												 id="descripcion" path="descripcion" rows="3" maxlength="350"/>  
												</div>
											</div>
											 
										</div> 
										<div class="row">
											<div class="form-group col-md-12 text-right"
												style="margin-top: 15px;">
												<a href="${pageContext.request.contextPath}/laboratorioController/listado"
												 class="btn btn-secondary" id="btnListado"> <i class="fa fa-undo"></i>
													<span class="text">CANCELAR</span>
												</a>
												<a
													href="${pageContext.request.contextPath}/laboratorioController/nuevo"
													class="btn btn-info"> <i class="fa fa-file"></i> <span
													class="text">NUEVO</span>
												</a>


												<button type="submit" onclick="grabar()"
													class="btn btn-primary">
													<i class="fa fa-save"></i> GUARDAR
												</button>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>


						<input id="contextPath" type="hidden"
							value="${pageContext.request.contextPath}">
						<div class="card-body">
							<div class="form-group"></div>
						</div>
					</div>

					<input type="hidden" id="txtIndexArticulo" />
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

	<script src="${pageContext.request.contextPath}/assets/js/page/mantenimiento/laboratorio.js"
		type="text/javascript"></script>
		
	<script>
		document.getElementById('navMantenimiento').className = "nav-item active";
		document.getElementById('enlaceLaboratorio').className = "collapse-item active";
		document.getElementById('CollMantenimiento').className = "nav-link";
		document.getElementById('collapseMantenimiento').className = "collapse show"; 
	</script>


	 
</body>

</html>
