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

<!-- Custom fonts for this template-->
<link
	href="${pageContext.request.contextPath}/app-assets/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/vendors/css/extensions/toastr.css">
	
<link
	href="${pageContext.request.contextPath}/app-assets/css/sb-admin-2.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/app-assets/css/estilos.css"
	rel="stylesheet">
<!-- Custom styles for this page -->
 
</head>


<style>

body {
/*font-family: Cambria;*/
font-size: 13px;  
}
 
</style>
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
				<f:form id="frmGenerarVenta" role="form"
					action=""  onsubmit="return false">
					<input id="contextPath" type="hidden"
						value="${pageContext.request.contextPath}">
					<!-- Begin Page Content -->
					<div class="container-fluid">

						<!-- Page Heading -->
						<div class="tituloForm">DEVOLUCIÓN</div> 
						<div class="card shadow mb-4">
							<!-- Card Content - Collapse -->
							<div class="collapse show" id="collapseCardExample">
								<div class="card-body">
									<div class="form-group">
									<div class="row">
											<div class="form-group col-md-2 mb-2">
												<label for="situacion" class="label_control">TIPO
													DOCUMENTO <span class="required">*</span>
												</label>
												<div class="controls">
													<f:select id="tipoDocumentoPaciente"
														path="persona.tipoDocumento.idRegistro"
														required="required" class="form-control"
														onchange="limpiarPorTipo()">
														<f:options items="${lstTipoDocumento}"
															itemValue="idRegistro" itemLabel="descripcionCorta" />
													</f:select>
												</div>
											</div>
											<div class="form-group col-md-2 mb-1">
												<label for="exampleInputName" class="label_control">N°
													DOCUMENTO <span class="required">*</span>
												</label>
												<div class="position-relative has-icon-left">
													<input id="contextPath" type="hidden"
														value="${pageContext.request.contextPath}">
													<div class="controls">
														<f:input type="text" class="form-control"
															required="required" maxlength="12"
															id="nroDocumentoPaciente" path="persona.nroDocumento"
															onkeypress="return runScript(event)" />
													</div>
												</div>
											</div>
											<div class="col-md-2">
												<button id="idBtnCargarPaciente" type="button"
													style="margin-top: 30px;" onclick="buscarPersonaNroDoc()"
													class="form-control btn btn-outline-success">
													<i class="fa fa-search"></i> BUSCAR
												</button>
											</div>
											 <div class="form-group col-md-6 mb-3">
												<label for="nombreCompleto" class="label_control">APELLIDOS Y NOMBRES </label>
												<div class="controls">
													<f:input type="text" class="form-control"
														required="required"
														onkeyup="javascript:this.value=this.value.toUpperCase();"
														id="personaApellidoPaterno" disabled="true"
														path="persona.apellidoPaterno" />

												</div>
											</div>
											</div> 
										 
										<div class="label_title">ARTICULOS OBTENIDOS :</div>
										
										<div class="row">
											<div class="form-group col-md-7 mb-1">
												<label for="nombreCompleto" class="label_control">NOMBRES Y APELLIDOS</label>
												<div class="controls">
													<f:input type="text" class="form-control"
														required="required"
														onkeyup="javascript:this.value=this.value.toUpperCase();"
														id="personaApellidoPaterno" disabled="true"
														path="persona.apellidoPaterno" />

												</div>
											</div> 
										</div> 
										<div class="row">
										 
										</div>	
										<div class="row">
											<div class="form-group col-md-12 text-right"
												style="margin-top: 15px;">
												<a href="${pageContext.request.contextPath}/ventaController/listado"
												 class="btn btn-secondary "> <i class="fa fa-step-backward"></i>
													<span class="text">CANCELAR</span>
												</a>


												<button type="submit" onclick="grabar()"
													class="btn btn-success ">
													<i class="fa fa-check"></i> DEVOLVER
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
					
					<input type="hidden"  id="txtIndexArticulo"  />
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
			src="${pageContext.request.contextPath}/assets/js/page/venta/venta.js"
			type="text/javascript" charset="utf-8"></script>
			
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
			
			
			
	<script>
		document.getElementById('navVentas').className = "nav-item active";
		document.getElementById('enlaceDevolucionVenta').className = "collapse-item active";
		document.getElementById('collVentas').className = "nav-link";
		document.getElementById('collapseVentas').className = "collapse show";
		

	</script>




	<div class="modal fade text-xs-left" id="modalPersona" tabindex="-2"
		role="dialog" aria-labelledby="myModalLabel35" data-dismiss="modal"
		aria-hidden="true" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content" id="modalPersonaContent"></div>
		</div>
	</div>
</body>

</html>
