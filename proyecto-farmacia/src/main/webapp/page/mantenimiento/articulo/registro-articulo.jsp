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

<title>Farmacia - Articulo</title>

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
				<f:form id="frmRegistroArticulo" role="form" action=""
					onsubmit="return false">
					<input id="contextPath" type="hidden"
						value="${pageContext.request.contextPath}">
					<!-- Begin Page Content -->
					<div class="container-fluid">

						<!-- Page Heading -->
						<div class="tituloForm">REGISTRO ARTICULO</div>


						<div class="card shadow mb-4">
							<!-- Card Content - Collapse -->
							<div class="collapse show" id="collapseCardExample">
								<div class="card-body">
									<div class="form-group">
										<div class="row">
											<div class="form-group col-md-6 mb-2">
												<label for="nombreCompleto" class="label_control">NOMBRE
													ARTICULO <span class="required">*</span>
												</label>
												<div class="controls">
													<f:input type="text" class="form-control"
														required="required"
														onkeyup="javascript:this.value=this.value.toUpperCase();"
														id="txtNombre" path="nombre" maxlength="250" />

												</div>
											</div>
											<div class="form-group col-md-3 mb-2">
												<label for="nombreCompleto" class="label_control">CODIGO
													SIDMED <span class="required">*</span>
												</label>
												<div class="controls">
													<f:input type="text" class="form-control"
														required="required"
														onkeyup="javascript:this.value=this.value.toUpperCase();"
														id="txtAlias" path="codigoSismed" maxlength="10" />

												</div>
											</div>
											<div class="form-group col-md-3 mb-2">
												<label for="nombreCompleto" class="label_control">CONCENTRACION
													<span class="required">*</span>
												</label>
												<div class="controls">
													<f:input type="text" class="form-control"
														required="required"
														onkeyup="javascript:this.value=this.value.toUpperCase();"
														id="txtAlias" path="concentracion" maxlength="20" />

												</div>
											</div>
										</div>
										<div class="row">
											<div class="form-group col-md-3 mb-2">
												<label for="nombreCompleto" class="label_control">VOLUMEN<span
													class="required">*</span>
												</label>
												<div class="controls">
													<f:input type="text" class="form-control"
														required="required"
														onkeyup="javascript:this.value=this.value.toUpperCase();"
														id="txtAlias" path="volumen" maxlength="20" />
												</div>
											</div>
											<div class="form-group col-md-3 mb-2">
												<label for="nombreCompleto" class="label_control">POSOLOGIA
												</label>
												<div class="controls">
													<f:input type="text" class="form-control"
														onkeyup="javascript:this.value=this.value.toUpperCase();"
														id="txtAlias" path="posologia" maxlength="10" />

												</div>
											</div>
											<div class="form-group col-md-3 mb-2">
												<label for="nombreCompleto" class="label_control">STOCK
													ALERTA<span class="required">*</span>
												</label>
												<div class="controls">
													<f:input type="text" class="form-control"
														required="required"
														onkeyup="javascript:this.value=this.value.toUpperCase();"
														id="txtAlias" path="stockAlerta" maxlength="10" />
												</div>
											</div>
											<div class="form-group col-md-3 mb-2">
												<label for="nombreCompleto" class="label_control">STOCK
													OPTIMO<span class="required">*</span>
												</label>
												<div class="controls">
													<f:input type="text" class="form-control"
														required="required"
														onkeyup="javascript:this.value=this.value.toUpperCase();"
														id="txtAlias" path="stockOptimo" maxlength="10" />
												</div>
											</div>

										</div>
										<div class="row">
											<div class="form-group col-md-3 mb-2">
												<label for="nombreCompleto" class="label_control">CLASE<span
													class="required">*</span>
												</label>
												<div class="controls">
													<f:select id="cboTipoFinanciador" path="clase.idRegistro"
														onchange="cambiarFinanciamiento()" required="required"
														class="form-control">
														<f:option value="" label="Seleccionar" selected="true"
															disabled="disabled" />
														<f:options items="${lstClaseArticulo}"
															itemValue="idRegistro" itemLabel="descripcionCorta" />
													</f:select>
												</div>
											</div>
											<div class="form-group col-md-3 mb-2">
												<label for="nombreCompleto" class="label_control">TIPO<span
													class="required">*</span>
												</label>
												<div class="controls">
													<f:select id="cboTipoFinanciador"
														path="tipoArticulo.idRegistro"
														onchange="cambiarFinanciamiento()" required="required"
														class="form-control">
														<f:option value="" label="Seleccionar" selected="true"
															disabled="disabled" />
														<f:options items="${lstTipoArticulo}"
															itemValue="idRegistro" itemLabel="descripcionCorta" />
													</f:select>
												</div>
											</div>
											<div class="form-group col-md-3 mb-2">
												<label for="nombreCompleto" class="label_control">PRESENTACION<span
													class="required">*</span>
												</label>
												<div class="controls">
													<f:select id="cboTipoFinanciador"
														path="tipoPresentacion.idRegistro"
														onchange="cambiarFinanciamiento()" required="required"
														class="form-control">
														<f:option value="" label="Seleccionar" selected="true"
															disabled="disabled" />
														<f:options items="${lstPresentacion}"
															itemValue="idRegistro" itemLabel="descripcionLarga" />
													</f:select>
												</div>
											</div>
											<div class="form-group col-md-3 mb-2">
												<label for="nombreCompleto" class="label_control">LABORATORIO<span
													class="required">*</span>
												</label>
												<div class="controls">
													<f:select id="cboTipoFinanciador" path="laboratorio.codigo"
														onchange="cambiarFinanciamiento()" required="required"
														class="form-control">
														<f:option value="" label="Seleccionar" selected="true"
															disabled="disabled" />
														<f:options items="${lstLaboratorios}" itemValue="codigo"
															itemLabel="nombre" />
													</f:select>
												</div>
											</div>
										</div>

										<div class="label_title">
											STOCK:
										</div>
										<div id="panelCEX" class="panel_style col-md-12">
											<div class="row">
											<div class="form-group col-md-3 mb-2">
												<label for="nombreCompleto" class="label_control">STOCK ACTUAL<span
													class="required">*</span>
												</label>
												<div class="controls">
													<input type="text" class="form-control" disabled="disabled"
														id="txtAlias" value="${totalStock}" maxlength="10" />
												</div>
											</div>
											</div>
											
											<div class="row">
												<div class="col-md-12">
													<div class="table-responsive">
														<table class="table table-bordered">
															<thead class="tabla_th">
																<tr>
																	<th width="30">ITEM</th>
																	<th>ALMACEN</th>
																	<th># LOTE</th>
																	<th>PRECIO UNITARIO</th>
																	<th>FECHA VENCIMIENTO</th>
																	<th>STOCK</th> 
																</tr>
															</thead>
															<tbody id="idbodyStock" class="label_control">
																<c:forEach var="stock" items="${lstStock}"
																	varStatus="loop">
																	<tr>
																		<td>${loop.count}</td>
																		<td>${stock.almacen.nombreAlmacen}</td>
																		<td>${stock.lote}</td>
																		<td>${stock.precioVenta}</td>
																		<td><fmt:formatDate pattern="dd/MM/yyyy" value="${stock.fechaVencimiento}"/></td>
																		<td>${stock.stock}</td>   
																	</tr>
																</c:forEach>
															</tbody>
														</table>
													</div>
												</div>
											</div>
											
										</div>
										<div class="row">
											<div class="form-group col-md-12 text-right"
												style="margin-top: 15px;">
												<a href="${pageContext.request.contextPath}/articuloController/listado"
												 class="btn btn-secondary" id="btnListado"> <i class="fa fa-undo"></i>
													<span class="text">CANCELAR</span>
												</a>
												<a
													href="${pageContext.request.contextPath}/almacenController/nuevo"
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

	<script
		src="${pageContext.request.contextPath}/assets/js/page/mantenimiento/articulo.js"
		type="text/javascript"></script>

	<script>
		document.getElementById('navInventario').className = "nav-item active";
		document.getElementById('enlaceArticulo').className = "collapse-item active";
		document.getElementById('collInventario').className = "nav-link";
		document.getElementById('collapseInventario').className = "collapse show";
		 
	</script>

</body>

</html>
