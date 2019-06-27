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

<title>Farmacia - Generar venta</title>

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
					action="${pageContext.request.contextPath}/articuloontroller/buscar">
					<input id="contextPath" type="hidden"
						value="${pageContext.request.contextPath}">
					<!-- Begin Page Content -->
					<div class="container-fluid">

						<!-- Page Heading -->
						<div class="tituloForm">GENERAR VENTA</div>


						<div class="card shadow mb-4">
							<!-- Card Content - Collapse -->
							<div class="collapse show" id="collapseCardExample">
								<div class="card-body">
									<div class="form-group">
										<div class="label_title">DATOS DEL PACIENTE :</div>
										<div class="row">
											<div class="form-group col-md-3 mb-1">
												<label for="situacion" class="label_control">TIPO
													DOCUMENTO <span class="required">*</span>
												</label>
												<div class="controls">
													<f:select id="tipoDocumentoPaciente"
														path="persona.tipoDocumento.idRegistro"
														required="required" class="form-control"
														onchange="limpiarPorTipo()">
														<f:option value="" label="Seleccionar" selected="true"
															disabled="disabled" />
														<f:options items="${lstTipoDocumento}"
															itemValue="idRegistro" itemLabel="descripcionCorta" />
													</f:select>
												</div>
											</div>
											<div class="form-group col-md-3 mb-1">
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
											<div class="col-md-3">
												<button id="idBtnCargarPaciente" type="button"
													style="margin-top: 30px;" onclick="buscarPersonaNroDoc()"
													class="form-control btn btn-outline-success">
													<i class="fa fa-search"></i> BUSCAR
												</button>
											</div>
											<div class="col-md-3">
												<button id="idBtnCargarPaciente" type="button"
													<c:choose>
									<c:when test="${ordenBean.codigo==null || ordenBean.codigo==''}"> 
									</c:when>
									<c:otherwise>
										disabled ="true"
									</c:otherwise>
								</c:choose>
													style="margin-top: 30px;" onclick="cargarPersonaModal()"
													class="form-control btn btn-outline-info">
													<i class="fa fa-plus"></i> NUEVO
												</button>
											</div>
										</div>
										<div class="row">
											<div class="form-group col-md-3 mb-1">
												<label for="nombreCompleto" class="label_control">APELLIDO
													PATERNO </label>
												<div class="controls">
													<f:input type="text" class="form-control"
														required="required"
														onkeyup="javascript:this.value=this.value.toUpperCase();"
														id="personaApellidoPaterno" disabled="true"
														path="persona.apellidoPaterno" />

												</div>
											</div>
											<div class="form-group col-md-3 mb-1">
												<label for="nombreCompleto" class="label_control">APELLIDO
													MATERNO </label>
												<div class="controls">
													<f:input type="text" class="form-control"
														onkeyup="javascript:this.value=this.value.toUpperCase();"
														id="personaApellidoMaterno" disabled="true"
														path="persona.apellidoMaterno" />

												</div>
											</div>
											<div class="form-group col-md-3 mb-1">
												<label for="nombreCompleto" class="label_control">NOMBRES
												</label>
												<div class="controls">
													<f:input type="text" class="form-control"
														required="required"
														onkeyup="javascript:this.value=this.value.toUpperCase();"
														id="personaPrimerNombre" disabled="true"
														path="persona.nombres" />

												</div>
											</div>
											<div class="form-group col-md-3 mb-1">
												<label for="situacion" class="label_control">TIPO
													FINANCIAMIENTO<span class="required">*</span>
												</label>
												<div class="controls">
													<f:select id="tipoDocumentoPaciente"
														path="persona.tipoDocumento.idRegistro"
														required="required" class="form-control"
														onchange="limpiarPorTipo()">
														<f:option value="" label="Seleccionar" selected="true"
															disabled="disabled" />
														<f:options items="${lstTipoFinanciador}"
															itemValue="idRegistro" itemLabel="descripcionCorta" />
													</f:select>
												</div>
											</div>
										</div>
										<br>
										<div class="label_title">
											ARTICULOS <span class="required">*</span>:
										</div>
										<div id="panelCEX" class="panel_style col-md-12">

											<div class="row">
												<div class="col-md-8 mb-3">
													<label for="nombreCompleto" class="label_control">BUSCAR
														ARTICULO </label>
													<div class="controls">
														<div class="autocomplete" style="width: 100%;">
															<input type="text" value="" placeholder="Buscar..."
																class="form-control" required="required"
																onkeypress="return runIngresarExamen(event)"
																id="txtExamenNombre" name="txtExamenNombre" />
														</div>


													</div>
												</div>
												<div class="col-md-4 mb-3" style="margin-top: 30px;">
													<button type="button" style="display: none"
														class="btn btn-outline-success btn-sm"
														data-toggle="tooltip" data-placement="top" title=""
														data-original-title="Agregar" onclick="enviarIndex()"
														id="agregarEspecialidad">
														<i class="icon-check"> AGREGAR</i>
													</button>
												</div>
											</div>
											<div class="row">
												<div class="col-md-12">
													<div class="table-responsive">
														<table class="table table-bordered">
															<thead class="tabla_th">
																<tr>
																	<th width="30">ITEM</th>
																	<th>DESCRIPCION</th>
																	<th>PRESENTACION</th>
																	<th>STOCK</th>
																	<th width="50">CANTIDAD</th>
																	<th width="50">FALTANTE</th>
																	<th>PRECIO UNITARIO</th>
																	<th>IMPORTE</th>
																	<th>ACCION</th>
																</tr>
															</thead>
															<tbody id="idbodyCIEXref" class="label_control">
																<c:forEach var="orden" items="${lstOrdenDetalleBean}"
																	varStatus="loop">
																	<tr>
																		<td>${loop.count}</td>
																		<td>${orden.examen.descripcion}</td>
																		<td>${orden.examen.tipo.descripcionCorta}</td>
																		<td>${orden.cantidad}</td>
																		<td>${orden.examen.sPrecio}</td>
																		<td>${orden.sImporte}</td>
																		<c:choose>
																			<c:when test="${codigo==null || codigo==''}">
																				<td></td>
																			</c:when>
																			<c:otherwise>
																				<td><button type='button'
																						class='btn btn-outline-danger btn-sm'
																						data-toggle='tooltip' data-placement='top'
																						title='Eliminar'
																						onclick='confirmar_eliminar(${ciex.examen.codigo})'
																						data-original-title='Eliminar' id='eliminarDX'>
																						<i class='icon-trash'></i>
																					</button></td>
																			</c:otherwise>
																		</c:choose>

																	</tr>
																</c:forEach>
															</tbody>
														</table>
													</div>
												</div>
											</div>
											<div class="row">
												<div class="form-group col-md-9 text-right"
													style="margin-top: 2px;"></div>
												<div class="form-group col-md-3 text-right"
													style="margin-top: 2px;">
													<label for="nombreCompleto" class="label_control">IMPORTE
														TOTAL S/. </label>
													<f:input type="text" path="sImporte" class="form-control"
														id="txtCajaImporteTotal" readonly="true" maxlength="10" />

													<f:input type="hidden" path="importe"
														id="txtCajaImporteTotalHidden" />
												</div>
											</div>
										</div>
										<div class="row">
											<div class="form-group col-md-12 text-right"
												style="margin-top: 15px;">
												<a href="#" class="btn btn-info"> <i class="fa fa-file"></i>
													<span class="text">NUEVO</span>
												</a>


												<button type="submit" onclick="grabarOrden()"
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

	<!-- scripts  -->
	<script
		src="${pageContext.request.contextPath}/assets/js/page/venta/venta.js"></script>
		
		
	<script>
		document.getElementById('navVentas').className = "nav-item active";
		document.getElementById('enlaceGenerarVenta').className = "collapse-item active";
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