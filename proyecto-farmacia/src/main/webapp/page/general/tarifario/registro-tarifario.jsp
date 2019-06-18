<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="es" data-textdirection="ltr" class="loading">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description"
	content="Stack admin is super flexible, powerful, clean &amp; modern responsive bootstrap 4 admin template with unlimited possibilities.">
<meta name="author" content="">
<title>Registro de Tarifario</title>
<!-- Bootstrap core CSS-->

<link
	href="https://fonts.googleapis.com/css?family=Montserrat:300,300i,400,400i,500,500i%7COpen+Sans:300,300i,400,400i,600,600i,700,700i"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/fonts/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/css/plugins/forms/validation/form-validation.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/css/plugins/forms/switch.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/vendors/css/extensions/toastr.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/css/plugins/forms/extended/form-extended.css">
<link
	href="${pageContext.request.contextPath}/app-assets/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Custom fonts for this template-->
<link
	href="${pageContext.request.contextPath}/app-assets/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<!-- Page level plugin CSS-->
<!-- Custom styles for this template-->
<link
	href="${pageContext.request.contextPath}/app-assets/css/sb-admin.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/app-assets/css/estilos-cayetano.css"
	rel="stylesheet">

<link rel="shortcut icon" type="image/x-icon"
	href="${pageContext.request.contextPath}/app-assets/images/ico/logoLabico.ico">
<!-- Custom fonts for this template-->
<link
	href="${pageContext.request.contextPath}/app-assets/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<!-- Page level plugin CSS-->
<link
	href="${pageContext.request.contextPath}/app-assets/vendor/datatables/dataTables.bootstrap4.css"
	rel="stylesheet">


<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/vendors/css/tables/datatable/dataTables.bootstrap4.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/vendors/css/forms/selects/select2.min.css">
<!-- Custom styles for this template-->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/fonts/simple-line-icons/style.min.css">


<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/fonts/feather/style.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/fonts/font-awesome/css/font-awesome.min.css">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css" />


<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>


<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Theme -->
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
<body class="fixed-nav sticky-footer bg-dark" id="page-top">
	<!-- Navigation-->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top"
		id="mainNav">
		<a class="navbar-brand label_control_hade" href="#"> LABMED </a>
		<button class="navbar-toggler navbar-toggler-right" type="button"
			data-toggle="collapse" data-target="#navbarResponsive"
			aria-controls="navbarResponsive" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>


		<div class="collapse navbar-collapse" id="navbarResponsive">
			<jsp:include
				page="${pageContext.request.contextPath}/../layout/menu-view.jsp" />
		</div>
	</nav>

	<div class="content-wrapper">
		<div class="container-fluid">
			<div class="tituloForm">REGISTRO DE PROCEDIMIENTOS Y TARIFAS</div>
			<div class="card mb-3">
				<f:form id="frmGuardarTarifario" class="form-horizontal" role="form"
					method="post" action="" onsubmit="return false">
					<input id="contextPath" type="hidden"
						value="${pageContext.request.contextPath}">
					<f:input type="hidden" id="codigo" path="codigo" />
					<f:input type="hidden" id="numeroVersion" path="numeroVersion" />
					<f:input type="hidden" id="numeroPeriodo" path="numeroPeriodo" />
					<f:input type="hidden" id="codigoOrganizacion"
						path="codigoOrganizacion" />
					<f:input type="hidden" id="codigoSede" path="codigoSede" />
					<f:input type="hidden" id="codigoInstitucion"
						path="codigoInstitucion" />

					<div class="card-body">
						<div class="form-group">
							<div class="label_title">DATOS DE PROCEDIMIENTO :</div>
							<div class="row">
								<div class="form-group col-md-4 mb-1">
									<label for="situacion" class="label_control">TIPO <span
										class="required">*</span>
									</label>
									<div class="controls">
										<f:select id="tipoTarifario" path="tipo.codReg"
											required="required" class="form-control">
											<f:option value="" label="Seleccionar" selected="true"
												disabled="disabled" />
											<f:options items="${lstAreasLab}" itemValue="codReg"
												itemLabel="nombreCorto" />
										</f:select>
									</div>
								</div>
								<div class="form-group col-md-4 mb-1">
									<label for="situacion" class="label_control">SUB TIPO</label> <span
										class="required">*</span>

									<div class="position-relative has-icon-left">
										<input id="contextPath" type="hidden"
											value="${pageContext.request.contextPath}">
										<div class="controls">
											<f:input type="text" class="form-control" required="required"
												maxlength="20" id="tarifarioSubtipo" path="subtipo" />
										</div>
									</div>
								</div>
								<div class="form-group col-md-4 mb-2">
									<label for="nombreCompleto" class="label_control">PRECIO
										S/. </label>
									<div class="controls">
										<f:input type="text" min="1" maxlength="8"
											onkeypress="return decimales(event,this)"
											class="form-control" required="required" id="tariarioPrecio"
											path="precio" />

									</div>
								</div>
							</div>
							<div class="row">
								<div class="form-group col-md-12 mb-3">
									<label for="nombreCompleto" class="label_control">DESCRIPCION
										<span class="required">*</span>
									</label>
									<div class="controls">
										<f:input type="text" class="form-control" required="required"
											onkeyup="javascript:this.value=this.value.toUpperCase();"
											id="tarifarioDescripcion" path="descripcion" />
									</div>
								</div>
							</div>
							<div class="label_title">
								DETALLE <span class="required">*</span>:
							</div>
							<div id="panelCEX" class="panel_style col-md-12">
								<div class="row">
									<div class="col-md-12 text-right " style="margin-bottom: 20px;">
										<button id="btn-save-reg" type="button" class="btn btn-info"
											onclick="llenarDetalleTarifario()">
											<i class="fa fa-plus"></i> AGREGAR
										</button>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12" id="tblListaDetalle">
										<div class="table-responsive_">
											<table id ="tabla"  class="table table-bordered">
												<thead class="tabla_th">
													<tr> 
														<th>UNIDAD</th>
														<th>OBSERVACION</th>
														<th>VALOR INICIAL</th>
														<th>VALOR FINAL</th>
														<th width="60">ACCION</th>
													</tr>
												</thead>
												<tbody id="idbodyCIEXref" class="label_control">
													<c:forEach var="tabla" items="${lstTarifarioDetalleBean}"
														varStatus="loop">
														<f:input type="text"    value="${tabla.codigo}" path="lstTarifarioDetalleBean[${loop.index}].codigo" />
														<tr id='anterior${loop.index}'> 
															<td><div class="controls"> 
																	<f:input type="hidden" min="1" maxlength="20"  required="required"
																		class="form-control" value="${tabla.unidades}"
																		id="tarifarioUnidades${loop.index}" path="lstTarifarioDetalleBean[${loop.index}].unidades" />

																</div></td>
															<td><div class="controls">
																	<f:input type="text" min="1" maxlength="20"
																		class="form-control" value="${tabla.observacion}"
																		id="tarifarioUnidades${loop.index}" path="lstTarifarioDetalleBean[${loop.index}].observacion" />

																</div></td>
															<td><div class="controls">
																	<f:input type="text" maxlength="30"
																		class="form-control" required="required" value="${tabla.valoresRefIni}"
																		id="tarifarioValorInicial${loop.index}" path="lstTarifarioDetalleBean[${loop.index}].valoresRefIni" />

																</div></td>
															<td><div class="controls">
																	<f:input type="text" maxlength="30"
																		class="form-control" required="required" value="${tabla.valoresRefFin}"
																		id="tarifarioValorFinal${loop.index}" path="lstTarifarioDetalleBean[${loop.index}].valoresRefFin" />

																</div></td> 
																	<td><button type='button'
																			class='btn btn-outline-danger btn-sm'
																			data-toggle='tooltip' data-placement='top'
																			title='Eliminar'
																			onclick='confirmar_eliminar(1,${loop.index})'
																			data-original-title='Eliminar' id='eliminarDX'>
																			<i class='icon-trash'></i>
																		</button></td> 
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
									<a
										href="${pageContext.request.contextPath}/tarifarioController/nuevoTarifario"
										class="btn btn-secondary" title=""> <i
										class="fa icon-plus"></i> NUEVO
									</a>

									<button type="submit" onclick="grabarTarifario()"
										class="btn btn-primary">
										<i class="fa fa-floppy-o"></i> GUARDAR
									</button>  
								</div>
							</div>
						</div>
					</div>
				</f:form>
				<f:form id="frmRegistro" class="form-horizontal" role="form"
					method="POST"
					action="${pageContext.request.contextPath}/tarifarioController/listadoTarifario">
					<button type="submit" style="display: none" id="btnListado">Click
						me</button>
				</f:form>

			</div>
			<div class="modal fade text-xs-left" id="modalTarifario"
				tabindex="-1" role="dialog" aria-labelledby="myModalLabel35"
				data-dismiss="modal" aria-hidden="true" aria-hidden="true">
				<div class="modal-dialog modal-lg" role="document">
					<div class="modal-content" id="modalEstablecimientoContent"></div>
				</div>
			</div>

			<!-- Example DataTables Card-->

		</div>
		<!-- /.container-fluid-->
		<!-- /.content-wrapper-->
		<jsp:include
			page="${pageContext.request.contextPath}/../layout/footer-view.jsp" />
		<!-- Scroll to Top Button-->
		<a class="scroll-to-top rounded" href="#page-top"> <i
			class="fa fa-angle-up"></i>
		</a>
		<!-- Page level plugin JavaScript-->
		<!-- Custom scripts for all pages-->

		<!-- Custom scripts for this page-->
		<script
			src="${pageContext.request.contextPath}/app-assets/js/sb-admin-datatables.min.js"></script>
		<!-- Custom scripts for this page-->

		<!-- Core plugin JavaScript-->
		<script
			src="${pageContext.request.contextPath}/assets/js/page/util/utilitarios.js"
			type="text/javascript" charset="utf-8"></script>
		<!-- Page level plugin JavaScript-->
		<!-- Bootstrap core JavaScript-->
		<script
			src="${pageContext.request.contextPath}/app-assets/vendor/jquery/jquery.min.js"></script>
		<script
			src="${pageContext.request.contextPath}/app-assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
		<!-- Core plugin JavaScript-->
		<script
			src="${pageContext.request.contextPath}/app-assets/vendor/jquery-easing/jquery.easing.min.js"></script>
		<!-- Page level plugin JavaScript-->
		<script
			src="${pageContext.request.contextPath}/app-assets/vendor/datatables/jquery.dataTables.js"></script>
		<script
			src="${pageContext.request.contextPath}/app-assets/vendor/datatables/dataTables.bootstrap4.js"></script>
		<!-- Custom scripts for all pages-->
		<script
			src="${pageContext.request.contextPath}/app-assets/js/sb-admin.min.js"></script>
		<!-- Custom scripts for this page-->
		<script
			src="${pageContext.request.contextPath}/app-assets/js/sb-admin-datatables.min.js"></script>
		<!-- Custom scripts for all pages-->
		<script src="http://malsup.github.io/jquery.blockUI.js"></script> 
		<script
			src="${pageContext.request.contextPath}/assets/js/page/asistencial/tarifario.js"
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


	</div>
</body>
<div class="modal fade text-xs-left" id="md_confirmacion"
			tabindex="-1" role="dialog" aria-labelledby="myModalLabel19"
			aria-hidden="true">
			<div class="modal-dialog modal-sm" role="document">
				<div class="modal-content">
					<div class="label_title_modal modal-header">

						<h4 class="label_title" id="myModalLabel19">CONFIRMA ACCION</h4>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<p id="txt_confir" class="label_control">¿ESTÁ SEGURO DE
							ELIMINAR REGISTRO SELECCIONADO?</p>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn grey btn-outline-secondary"
							data-dismiss="modal">
							<i class="fa fa-close"></i> CERRAR
						</button>
						<button id="btnConfirmarGeneric" type="button"
							class="btn btn-outline-primary">CONFIRMAR</button>
					</div>
				</div>
			</div>
		</div>
<script type="text/javascript">  
	  
		var  listadoDetalleTarifario= [];  
 </script>
</html>










