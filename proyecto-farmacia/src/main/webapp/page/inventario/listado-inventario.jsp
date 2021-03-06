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

<title>Farmacia - Inventario</title>

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

.situacion {
font-family: Cambria;
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
				<f:form id="frmListadoArticulo" role="form"
					action="${pageContext.request.contextPath}/inventarioController/buscarInventario">
					<!-- Begin Page Content -->
					<div class="container-fluid">

						<!-- Page Heading -->
						<div class="tituloForm">LISTADO INVENTARIO</div>
						<input id="contextPath" type="hidden"
							value="${pageContext.request.contextPath}">

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
										<div class="col-md-3 mb-1">
											<label for="lbltipoSeguroPaciente" class="label_control">ALMACEN</label>
											<div class="controls">
												<f:select id="cboTipoArticulo" path="almacen.codigo"
													class="form-control">
													<f:option value="" label="Seleccione" selected="true"
															disabled="disabled" />
													<f:options items="${lstAlmacen}" itemValue="codigo"
														itemLabel="nombreAlmacen" />
												</f:select>
											</div>
										</div>
										<div class="form-group col-md-3 mb-1">
											<label for="exampleInputName" class="label_control">MES
											</label>
											<div class="controls">
												<f:select id="tipoDocumentoPaciente" path="mes.idRegistro"
													class="form-control">
													<f:option value="" label="Seleccione" selected="true"
														disabled="disabled" />
													<f:options items="${lstMes}" itemValue="idRegistro"
														itemLabel="descripcionCorta" />
												</f:select>
											</div>
										</div>
										<div class="form-group col-md-3 mb-2">
											<label for="situacion" class="label_control">PERIODO
											</label>
											<div class="controls">
												<f:select id="tipoDocumentoPaciente"
													path="periodo.idRegistro" class="form-control">
													<f:option value="" label="Seleccione" selected="true"
														disabled="disabled" />
													<f:options items="${lstPeriodo}" itemValue="idRegistro"
														itemLabel="descripcionCorta" />
												</f:select>
											</div>
										</div>
									</div>
									<div class="row">
										<div class="form-group col-md-5" style="margin-top: 15px;">
										</div>
										<div class="form-group col-md-7 text-right"
											style="margin-top: 15px;">
											<button id="btnBuscar" class="btn btn-success" type="submit">
												<i class="fa fa-search"> </i> BUSCAR
											</button>
											<a
												href="${pageContext.request.contextPath}/inventarioController/nuevo"
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
														<th>ITEM</th>
														<th>FECHA Y HORA</th>
														<th>PERIODO</th>
														<th>ALMACEN</th>
														<th>ESTADO</th>
														<th width="15%">ACCION</th>
													</tr>
												</thead>
												<tfoot>
												<tbody class="tabla_td">
													<c:forEach var="inventario" items="${lstInventarios}"
														varStatus="loop">
														<tr>
															<td>${loop.count}</td>
															<td><fmt:formatDate pattern="dd/MM/yyyy hh:mm a"
																	value="${inventario.fecha}" /></td>
															<td>${inventario.mes.descripcionCorta}-
																${inventario.periodo.idRegistro}</td>
															<td>${inventario.almacen.nombreAlmacen}</td>
															<td>
															<c:choose>
																	<c:when test="${inventario.situacion.idRegistro=='000001'}">
																	<span class="badge badge-pill badge-warning situacion">${inventario.situacion.descripcionCorta}</span>
																	</c:when>
																	<c:when test="${inventario.situacion.idRegistro=='000002'}">
																	
																	<span slot="reference" class="text-white badge  text-white bg-success situacion">${inventario.situacion.descripcionCorta}</span>
																	</c:when>
																	<c:otherwise>
																		<span slot="reference" class="text-white badge  text-white bg-danger situacion">${inventario.situacion.descripcionCorta}</span>
																	</c:otherwise>
																</c:choose>
															
															
															</td>
															<td>
															
															<c:choose>
																	<c:when test="${inventario.situacion.idRegistro=='000001'}">
																	<button type="button" title='Confirmar' onclick="confirmaEjecutar(${loop.index})" 
																	class="btn btn-outline-success">
																	<i class="fa fa-check"></i>
																</button> 
																<a title="Modificar" data-placement="top"
																data-toggle="tooltip"
																class="btn btn-outline-primary btn-sm"
																onclick="javascript:modificarElementoGenerico('/inventarioController/modificar','${loop.index}')"
																href="#"><i class="fas fa-pencil-alt"></i></a>

																<button type='button'
																	class='btn btn-outline-danger btn-sm'
																	data-toggle='tooltip' data-placement='top'
																	title='Eliminar'
																	onclick="confirmar_eliminar(${loop.index});"
																	data-original-title='Eliminar' id='agregarEspecialidad'>
																	<i class='fas fa-trash'></i>
																</button>
																	</c:when>
																	<c:when test="${inventario.situacion.idRegistro=='000003'}">
																	 <a title="Modificar" data-placement="top"
																data-toggle="tooltip"
																class="btn btn-outline-success btn-sm"
																onclick=""
																href="#"><i class="fas fa-pencil-alt"></i></a> 
																	</c:when> 
																</c:choose>
																<a title="Imprimir" data-placement="top"
																data-toggle="tooltip"
																class="btn btn-outline-warning btn-sm"
																href="${pageContext.request.contextPath}/inventarioController/rptInventarioProceso?index=${loop.index}">
																<i class="fa fa-print"></i></a>
																
																	
															</td>
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
	<div class="modal fade text-xs-left" id="md_confirmacionEjecuta"
				tabindex="-1" role="dialog" aria-labelledby="myModalLabel19"
				aria-hidden="true">
				<div class="modal-dialog modal-sm" role="document">
					<div class="modal-content">
						<div class="label_title_modal modal-header">

							<h4 class="label_title" id="myModalLabel19">CONFIRMAR ACTUALIZACION</h4>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body">
							<p id="txt_confir" class="label_control">¿ESTÁ SEGURO DE
								EJECUTAR PROCESO DE ACTUALIZACION DE INVENTARIO?</p>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn grey btn-outline-secondary"
								data-dismiss="modal">CERRAR</button>
							<button id="btnConfirmarProceso" type="button"
								class="btn btn-outline-primary">CONFIRMAR</button>
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
		src="${pageContext.request.contextPath}/assets/js/page/inventario/inventario.js"
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
	document.getElementById('navInventario').className = "nav-item active";
	document.getElementById('enlaceGenerarInventario').className = "collapse-item active";
	document.getElementById('collInventario').className = "nav-link";
	document.getElementById('collapseInventario').className = "collapse show";
	</script>



</body>

</html>
