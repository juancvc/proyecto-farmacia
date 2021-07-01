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

<title>Farmacia - Venta</title>

<!-- Custom styles for this template-->
<link
	href="${pageContext.request.contextPath}/app-assets/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
	
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/vendors/css/extensions/toastr.css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">
<!-- Custom fonts for this template-->
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
<!-- Custom styles for this page -->

<link
	href="${pageContext.request.contextPath}/app-assets/vendor/datatables/dataTables.bootstrap4.min.css"
	rel="stylesheet">
</head>

<style>
#datepicker {
	width: 180px;
	margin: 0 20px 20px 20px;
}

#datepicker>span:hover {
	cursor: pointer;
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
				<f:form id="frmListadoArticulo" role="form"
					action="${pageContext.request.contextPath}/ventaController/recaudacion">
					<!-- Begin Page Content -->
					<div class="container-fluid">

						<!-- Page Heading -->
						<div class="tituloForm">RECAUDACION FARMACIA</div>


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
										<div class="col-md-4 mb-2">
											<label for="exampleInputName" class="label_control">FECHA EMISION DESDE <span class="required">*</span>
											</label>
											<f:input class="form-control" id="dateDesde" name="dateDesde"
												maxlength="10" required="required" placeholder="DD/MM/YYYY"
												type="text" path="fechaEmisionDesde"
												onkeyup="this.value=formateafechaNacimiento(this.value);" />
										</div>
										<div class="col-md-4 mb-2">
											<label for="exampleInputName" class="label_control">FECHA
												EMISION HASTA <span class="required">*</span>
											</label>
											<f:input class="form-control" id="dateHasta" name="dateHasta"
												maxlength="10" required="required" placeholder="DD/MM/YYYY"
												type="text" path="fechaEmisionHasta"
												onkeyup="this.value=formateafechaNacimiento(this.value);" />
										</div>
										 
										
									</div> 
									<div class="row">
									<div class="form-group col-md-3" style="margin-top: 15px;">
											<a
												href="${pageContext.request.contextPath}/ventaController/reporteRecaudacion"
												class="btn btn-info"> <i class="fa fa-file-pdf"></i> GENERAR REPORTE
											</a>
									 
										</div>
										<div class="form-group col-md-9 text-right"
											style="margin-top: 15px;">
											<button id="btnBuscar" class="btn btn-success" type="submit">
												<i class="fa fa-search"> </i> BUSCAR
											</button>
											
											
											<button
												onclick="limpiarForm();$('#dataTable').dataTable().fnClearTable();"
												type="button" class="btn btn-flat btn-secondary ">
												<i class="fa fa-eraser"></i> LIMPIAR
											</button>  
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
														<th>ITEM</th>
														<th>ALMACEN</th>
														<th>CANT. VENTA</th>
														<th>IMPORTE VENTA</th>
														<th>CANT. ANULACION</th>
														<th>IMPORTE ANULACION</th>
														<th>VENTA TOTAL</th>
													</tr>
												</thead>
												<tfoot>
												<tbody class="tabla_td">
													<c:forEach var="venta" items="${lstVentas}"
														varStatus="loop">
														<tr>
															<td>${loop.count}</td>
															<td>${venta.almacen.nombreAlmacen}</td>
															<td>${venta.cantidadTransTotal}</td>
															<td>${venta.importeTotal}</td>
															<td>${venta.cantidadTransAnul}</td>
															<td>${venta.importeAnulacion}</td>
															<td>${venta.importeVenta}</td>
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
					
					<div  id="printarea" style="display: none; width: 200px; height: 170px;"  class="ancho-tabla"> 
					    <table style="width: 200px; height: 170px;"  class="ancho-tabla"> 
					      <tbody id="idBodyTicket">
					       <tr> 
					       		 <td class="centrado"> <div><img  style="width: 190px; height: 163px;"  id="barcode1"/> </div></td> 
					        </tr>
					        
					        <tr> 
					         <td class="producto centrado">SOSO</td>
					        </tr> 
					      </tbody>
					    </table>
					   
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
		$(document).ready(
				function() {
					var date_input = $('input[id="dateDesde"]'); //our date input has the name "date"
					var container = $('.bootstrap-iso form').length > 0 ? $(
							'.bootstrap-iso form').parent() : "body";
					date_input.datepicker({
						format : 'dd/mm/yyyy',
						container : container,
						todayHighlight : true,
						autoclose : true,
						language : 'es'

					})
				})
				
		$(document).ready(
				function() {
					var date_input = $('input[id="dateHasta"]'); //our date input has the name "date"
					var container = $('.bootstrap-iso form').length > 0 ? $(
							'.bootstrap-iso form').parent() : "body";
					date_input.datepicker({
						format : 'dd/mm/yyyy',
						container : container,
						todayHighlight : true,
						autoclose : true,
						language : 'es'

					})
				})
	</script>	
	<script>
		document.getElementById('navReporteVenta').className = "nav-item active";
		document.getElementById('enlaceRecaudacion').className = "collapse-item active";
		document.getElementById('CollReporteVenta').className = "nav-link";
		document.getElementById('collapseReporteVenta').className = "collapse show";
		
	 
		
		function PrintDoc(){
			 
			var toPrint = document.getElementById("printarea");
			var popupWin = window.open("", "_blank", "width=350,height=150,location=no,left=200px");
			popupWin.document.open();
			popupWin.document.write("<html><title>::Preview::</title><link rel='stylesheet' type='text/css' href='print.css' /></head><body onload='window.print()'>")
			//popupWin.document.write("<p>This is 'myWindow'</p>");
			popupWin.document.write(toPrint.innerHTML);
			popupWin.document.write("</html>");
			popupWin.document.close();
			
		 }
			/*--This JavaScript method for Print Preview command--*/
			function printPreview() {
				console.log("PrintPreview");
			 	 	
			var toPrint = document.getElementById("printarea");
			var popupWin = window.open("", "_blank", "width=350,height=450,location=no,left=200px");
			popupWin.document.open();
			 popupWin.document.write("<html><title>::Print Preview::</title><link rel='stylesheet' type='text/css' href='Print.css' media='screen'/></head><body'>");
		//	popupWin.document.write("<p>This is 'myWindow'</p>");
			popupWin.document.write(toPrint.innerHTML);
			popupWin.document.write("</html>");
			popupWin.document.close(); 
			 
			}
	</script>

 	

</body>

</html>
