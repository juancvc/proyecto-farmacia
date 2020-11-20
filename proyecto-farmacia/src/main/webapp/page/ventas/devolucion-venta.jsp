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

<title>Farmacia - Devolución</title>

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

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/app-assets/vendor/bootstrap/css/bootstrap-select.css" />

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/app-assets/vendor/bootstrap/css/bootstrap.min-droop.css">

</head>

<link
	href="${pageContext.request.contextPath}/app-assets/css/estilos.css"
	rel="stylesheet">
	
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
				<f:form id="frmListadoArticulo" role="form" action=""
					onsubmit="return false">
					<input id="contextPath" type="hidden"
						value="${pageContext.request.contextPath}">
					<!-- Begin Page Content -->
					<div class="container-fluid">

						<!-- Page Heading -->
						<div class="tituloForm">CONSUMO POR PACIENTE</div>


						<div class="card shadow mb-2">
							<!-- Card Content - Collapse -->
							<div class="collapse show" id="collapseCardExample">
								<div class="card-body">
									<div class="row"> 
										<div class="form-group col-md-7 mb-2">
											<label for="situacion" class="label_control">PACIENTE
												<span class="required">*</span>
											</label>
											<div class="controls">
												<f:select id="cboPacienteVenta" data-live-search="true"
													title="Seleccionar" class="selectpicker"
													path="persona.codigo" required="required" >
													<f:options items="${lstPersonas}" itemValue="codigo"
														itemLabel="pacienteEpisodio" />
												</f:select>
											</div>
										</div>
										<div class="form-group col-md-2 mb-2" style="margin-top: 25px;">
											<button id="btn-save-reg" type="button" class="btn btn-info"
											onclick="refrescarListadoConsumo()" >
											<i class="fa fa-search"> </i>  CARGAR CONSUMO
										</button>
										</div>
									</div>
									<br>
									<div class="label_title">
										ARTICULOS <span class="required">*</span>:
									</div>
									<div id="panelCEX" class="panel_style col-md-12">
										<div class="row">
											<div class="col-md-12">
												<div class="table-responsive" id ="idTablaDevolucion">
													<table class="table table-bordered">
														<thead class="tabla_th">
															<tr>
																<th width="50">ITEM</th>
																<th>NRO DOCUMENTO</th>
																<th>NOMBRE ARTICULO</th>
																<th>CANTIDAD ADQUIRIDA</th>
																<th>CANTIDAD DEVUELTA</th>
																<th>CANTIDAD CONSUMIDA</th>
																<th width="90">PRECIO (S/.)</th>
																<th width="45">SUB TOTAL</th>
																
															</tr>
														</thead>
														<tbody id="idbodyStock" class="label_control">
															 
														</tbody>
													</table>
												</div>
											</div>
										</div> 
									</div>
									<div class="row">
										<div class="form-group col-md-12 text-right"
											style="margin-top: 15px;">
											<button type="submit" onclick="grabar()"
												class="btn btn-primary">
												<i class="fa fa-save"></i> GUARDAR
											</button>
										</div>
									</div>
								</div> 
							</div>
						</div>

						<div class="card shadow mb-4" id="seccionDatosPaciente"
							style="display: none">


							<!-- Card Content - Collapse -->

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
	<!-- Page level custom scripts -->
	<!-- Page level plugins -->
	<!-- Bootstrap core JavaScript

	<script
		src="${pageContext.request.contextPath}/app-assets/vendor/jquery/jquery.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/app-assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
-->


	<!-- Page level plugins -->
	<script
		src="${pageContext.request.contextPath}/app-assets/vendor/bootstrap/js/jquery.min.droop.js"></script>

	<script
		src="${pageContext.request.contextPath}/app-assets/vendor/bootstrap/js/droop.js"></script>

	<script
		src="${pageContext.request.contextPath}/app-assets/vendor/datatables/jquery.dataTables.min.js"></script>

	<script
		src="${pageContext.request.contextPath}/app-assets/vendor/datatables/dataTables.bootstrap4.min.js"></script>

	<!-- Page level custom scripts -->
	<script
		src="${pageContext.request.contextPath}/app-assets/js/demo/datatables-demo.js"></script>

	<script
		src="${pageContext.request.contextPath}/app-assets/vendors/js/extensions/toastr.min.js"
		type="text/javascript"></script>

	<script
		src="${pageContext.request.contextPath}/app-assets/vendors/js/extensions/sweetalert.min.js"
		type="text/javascript"></script>

	<script
		src="${pageContext.request.contextPath}/app-assets/js/scripts/extensions/sweet-alerts.js"
		type="text/javascript"></script>

	<script
		src="${pageContext.request.contextPath}/app-assets/vendor/bootstrap/js/bootstrap-select.js"></script>

	<script
			src="${pageContext.request.contextPath}/assets/js/page/venta/venta.js"
			type="text/javascript" charset="utf-8"></script>
			
	<script>	
function cargarDatos() {
	
	document.getElementById('seccionDatosPaciente').style.display = 'block';
	idPaciente = $('#cboPaciente').val(); 
	
	
}
	
</script>
	<script>
		document.getElementById('navVentas').className = "nav-item active";
		document.getElementById('enlaceDevolucionVenta').className = "collapse-item active";
		document.getElementById('collVentas').className = "nav-link";
		document.getElementById('collapseVentas').className = "collapse show";
	</script>

</body>

</html>
