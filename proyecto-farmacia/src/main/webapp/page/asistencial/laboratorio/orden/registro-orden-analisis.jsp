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
<title>Registro de Orden</title>
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
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/vendors/css/forms/selects/select2.min.css">
<!-- Custom styles for this template-->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/fonts/simple-line-icons/style.min.css">


<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/fonts/feather/style.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/fonts/font-awesome/css/font-awesome.min.css">


</head>

<style>
#datepicker {
	width: 180px;
	margin: 0 20px 20px 20px;
}

#datepicker>span:hover {
	cursor: pointer;
}

#txtCajaImporteTotal:disabled {
	font-color: #0A0A0A;
	font-weight: plain;
	font-family: Cambria;
	font-size: 16px;
	background-color: #DCE8EC;
	text-align: right;
	valign: center;
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
			<div class="tituloForm">REGISTRO DE ORDEN</div>
			<div class="card mb-3">
				<f:form id="frmActualizarResultadoOrden" class="form-horizontal" role="form"
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
					<f:input type="hidden" id="personaCodigo"
						path="pacienteBean.persona.codigo" />
					<div class="card-body">
						<div class="form-group">
							<div class="label_title">DATOS DEL SOLICITANTE :</div>
							<div class="row">
								<div class="form-group col-md-3 mb-1">
									<label for="situacion" class="label_control">TIPO
										DOCUMENTO <span class="required">*</span>
									</label>
									<div class="controls">
										<f:select id="tipoDocumentoPaciente"
											path="pacienteBean.persona.tipoDocumento.codReg"
											required="required" class="form-control"
											onchange="limpiarPorTipo()">
											<f:options items="${lstDocumento}" itemValue="codReg"
												itemLabel="nombreCorto" />
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
											<f:input type="text" class="form-control" required="required"
												maxlength="12" id="nroDocumentoPaciente"
												path="pacienteBean.persona.nroDocumento"
												onkeypress="return runScript(event)" />
										</div>
									</div>
								</div>
						
							
							</div>
							<div class="row">
								<div class="form-group col-md-3 mb-1">
									<label for="nombreCompleto" class="label_control">APELLIDO
										PATERNO </label>
									<div class="controls">
										<f:input type="text" class="form-control" required="required"
											onkeyup="javascript:this.value=this.value.toUpperCase();"
											id="personaApellidoPaterno" disabled="true"
											path="pacienteBean.persona.apellidoPaterno" />

									</div>
								</div>
								<div class="form-group col-md-3 mb-1">
									<label for="nombreCompleto" class="label_control">APELLIDO
										MATERNO </label>
									<div class="controls">
										<f:input type="text" class="form-control"
											onkeyup="javascript:this.value=this.value.toUpperCase();"
											id="personaApellidoMaterno" disabled="true"
											path="pacienteBean.persona.apellidoMaterno" />

									</div>
								</div>
								<div class="form-group col-md-3 mb-1">
									<label for="nombreCompleto" class="label_control">PRIMER
										NOMBRE </label>
									<div class="controls">
										<f:input type="text" class="form-control" required="required"
											onkeyup="javascript:this.value=this.value.toUpperCase();"
											id="personaPrimerNombre" disabled="true"
											path="pacienteBean.persona.primerNombre" />

									</div>
								</div>
								<div class="form-group col-md-3 mb-1">
									<label for="nombreCompleto" class="label_control">SEGUNDO
										NOMBRE </label>
									<div class="controls">
										<f:input type="text" class="form-control"
											onkeyup="javascript:this.value=this.value.toUpperCase();"
											id="personaSegundoNombre" disabled="true"
											path="pacienteBean.persona.segundoNombre" />
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-3 mb-1">
									<label for="situacion" class="label_control">SEXO </label>
									<div class="controls">
										<f:select id="sexoPaciente"
											path="pacienteBean.persona.sexo.codReg" disabled="true"
											class="form-control" required="required">
											<f:option value="" label="Seleccionar" selected="true"
												disabled="disabled" />
											<f:options items="${lstSexo}" itemValue="codReg"
												itemLabel="nombreCorto" />
										</f:select>
									</div>
								</div>
								<div class="form-group col-md-3 mb-1">
									<label for="nombreCompleto" class="label_control">EDAD
									</label>
									<div class="controls">
										<f:input type="text" class="form-control" required="required"
											disabled="true" id="edadPersona"
											path="pacienteBean.persona.edad" />

									</div>
								</div>
								<div class="form-group col-md-6 mb-2">
									<label for="nombreCompleto" class="label_control">DIRECCIÓN
									</label>
									<div class="controls">
										<f:input type="text" class="form-control" required="required"
											disabled="true" id="personaDireccion"
											path="pacienteBean.persona.direccion" />

									</div>
								</div>
							</div>

							<div class="label_title">
								ORDEN(ES) <span class="required">*</span>:
							</div>
							<div id="panelCEX" class="panel_style col-md-12">
						
								<div class="row">
									<div class="col-md-12">
										<div class="table-responsive">
											<table class="table table-bordered">
												<thead class="tabla_th">
													<tr>
														<th width="30">ITEM</th>
														<th>DESCRIPCION</th>
														<th>TIPO</th>
														<th width="45">CANTIDAD</th>
														<th>PRECIO UNITARIO</th>
														<th>IMPORTE</th>
														<th>RESULTADO</th>
														<th>ACCION</th>
													</tr>
												</thead>
												<tbody id="idbodyCIEXref" class="label_control">
													<c:forEach var="orden" items="${lstOrdenDetalleBean}"
														varStatus="loop">
					<f:input type="hidden" id="codigo" value="${orden.codigo}" path="lstOrdenDetalleBean[${loop.index}].codigo" />
					
					<f:input type="hidden" id="numeroVersion" value="${orden.numeroVersion}" path="lstOrdenDetalleBean[${loop.index}].numeroVersion" />
					<f:input type="hidden" id="numeroPeriodo" value="${orden.numeroPeriodo}" path="lstOrdenDetalleBean[${loop.index}].numeroPeriodo" />
					<f:input type="hidden" id="codigoOrganizacion" value="${orden.codigoOrganizacion}" path="lstOrdenDetalleBean[${loop.index}].codigoOrganizacion" />
					<f:input type="hidden" id="codigoSede" value="${orden.codigoSede}" path="lstOrdenDetalleBean[${loop.index}].codigoSede" />
					<f:input type="hidden" id="codigoInstitucion" value="${orden.codigoInstitucion}" path="lstOrdenDetalleBean[${loop.index}].codigoInstitucion" />
														<tr>
															<td>${loop.count}</td>
															<td>${orden.examen.descripcion}</td>
															<td>${orden.examen.tipo.nombreCorto}</td>
															<td>${orden.cantidad}</td>
															<td>${orden.examen.sPrecio}</td>
															<td>${orden.sImporte}</td>
															<td>
															<c:choose>
															<c:when test="${orden.resultado==null || orden.resultado==''}">
															
																	<f:input type="text" min="1" maxlength="50"
																		class="form-control" required="required"
																		id="tarifarioUnidades" path="lstOrdenDetalleBean[${loop.index}].resultado" />
																
																
																</c:when> 
																<c:otherwise>
																${orden.resultado}
																</c:otherwise>
																</c:choose>
															</td>
															
															
															
															<c:choose>
																<c:when test="${orden.resultado==null || orden.resultado==''}">
																	<td>
																	<button type='button'
																			class='btn btn-outline-danger btn-sm'
																			data-toggle='tooltip' data-placement='top'
																			title='Agregar Resultado'
																			onclick=''
																			data-original-title='Agregar' id='agregarResultado'>
																			<i class='icon-plus'></i>
																		</button>
																	
																	</td>
																</c:when> 
																<c:otherwise>
																	<td><button type='button'
																			class='btn btn-outline-danger btn-sm'
																			data-toggle='tooltip' data-placement='top'
																			title='Elminar'
																			onclick='confirmar_eliminar(${ciex.examen.codigo})'
																			data-original-title='Eliminar' id='eliminarDX'>
																			<i class='icon-plus'></i>
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
										<f:input type="text" path="sImporteTotal" class="form-control"
											id="txtCajaImporteTotal" readonly="true" maxlength="10" />

										<f:input type="hidden" path="importeTotal"
											id="txtCajaImporteTotalHidden" />
									</div>
								</div>
								
							</div>
					
						<div class="row">
							<div class="form-group col-md-12 text-right" 
								style="margin-top: 15px;">
										<button type="submit" onclick="actualizarResultadoOrdenDetalle()"
										<c:choose>
										   <c:when test="${ordenBean.situacion.codReg=='000001'}"> 
										</c:when>
										<c:otherwise>
											disabled ="true"
										</c:otherwise>
									</c:choose>
									class="btn btn-primary">
									<i class="fa fa-floppy-o"></i> GUARDAR RESULTADOS
								</button>
								<a
									href="${pageContext.request.contextPath}/ordenController/nuevo"
									class="btn btn-secondary" title=""> <i class="fa icon-plus"></i>
									NUEVO
								</a>
									<a
									href="#" onclick="cargarEmailModal()"
									class="btn btn-secondary" title=""> <i class="fa fa-envelope-open-o"></i>
									CORREO
								</a>
								
									<a
									href="${pageContext.request.contextPath}/ordenController/rptFichaREsultados"
									class="btn btn-secondary" title=""> <i class="fa fa-print"></i>
									IMPRIMIR
								</a>
							

							
							</div>
						</div>
					</div>

				</f:form>
				<f:form id="frmRegistro" class="form-horizontal" role="form"
					method="POST"
					action="${pageContext.request.contextPath}/ordenController/listado">
					<button type="submit" style="display: none" id="btnListado">Click
						me</button>
				</f:form>
			</div>
				
		<div class="modal fade text-xs-left" id="modalAnalisis" tabindex="-2"
				role="dialog" aria-labelledby="myModalLabel35" data-dismiss="modal"
				aria-hidden="true" aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content" id="modalAnalisisContent"></div>
				</div>
			</div>

			<div class="modal fade text-xs-left" id="modalTarifario"
				tabindex="-1" role="dialog" aria-labelledby="myModalLabel35"
				data-dismiss="modal" aria-hidden="true" aria-hidden="true">
				<div class="modal-dialog modal-lg" role="document">
					<div class="modal-content" id="modalEstablecimientoContent"></div>
				</div>
			</div>

			<div class="modal fade text-xs-left" id="modalPersona" tabindex="-2"
				role="dialog" aria-labelledby="myModalLabel35" data-dismiss="modal"
				aria-hidden="true" aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content" id="modalPersonaContent"></div>
				</div>
			</div>
				<div class="modal fade text-xs-left" id="modalEmail" tabindex="-2"
				role="dialog" aria-labelledby="myModalLabel35" data-dismiss="modal"
				aria-hidden="true" aria-hidden="true">
				<div class="modal-dialog-centered" role="document">
					<div class="modal-content" id="modalEmailContent"></div>
				</div>
			</div>

			<div class="modal fade text-xs-left" id="md_confirmacion"
				tabindex="-1" role="dialog" aria-labelledby="myModalLabel19"
				aria-hidden="true">
				<div class="modal-dialog modal-sm" role="document">
					<div class="modal-content">
						<div class="label_title_modal modal-header">

							<h4 class="label_title" id="myModalLabel19">CONFIRMAR ACCION</h4>
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
								data-dismiss="modal">Cerrar</button>
							<button id="btnConfirmarGeneric" type="button"
								class="btn btn-outline-primary">Confirmar</button>
						</div>
					</div>
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
		<!-- Custom scripts for all pages-->
		<script src="http://malsup.github.io/jquery.blockUI.js"></script>

		<script
			src="${pageContext.request.contextPath}/assets/js/page/asistencial/laboratorio.js"
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
		<script 
		    src="${pageContext.request.contextPath}/assets/js/scripts.js"
			type="text/javascript"></script>

		<!-- Include Date Range Picker -->

		<script type="text/javascript"
			src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>

		<script
			src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/locales/bootstrap-datepicker.es.min.js"></script>



		<script type="text/javascript">  
 
	function runScript(e) {
		//See notes about 'which' and 'key'
		console.log(${ordenBean.codigo});
		if (e.keyCode == 13) {
			<c:if test="${ordenBean.codigo==null || ordenBean.codigo==''}">
			buscarPersonaNroDoc(); 
			
			</c:if>
			
			return false;
		}
	}
	
		var  listadoExamenes= []; 
 </script>

	</div>
</body>

</html>










