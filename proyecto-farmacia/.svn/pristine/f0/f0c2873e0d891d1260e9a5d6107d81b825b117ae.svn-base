<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="es">

<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>Registro de Referencia</title>
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
	href="${pageContext.request.contextPath}/app-assets/images/ico/iconHNCH.ico">
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



</head>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">
	<!-- Navigation-->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top"
		id="mainNav">
		<a class="navbar-brand label_control_hade" href="#"> HCH WEB </a>
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
			<!-- Breadcrumbs
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="#">Referencia</a></li>
				<li class="breadcrumb-item active">Registro de Referencia</li>
			</ol>-->
			<!--  
			<div class="modal fade text-xs-left" id="modalCIEX" tabindex="-2"
				role="dialog" aria-labelledby="myModalLabel35" data-dismiss="modal"
				aria-hidden="true" aria-hidden="true">

				<div class="modal-dialog modal-lg" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<label class="modal-title text-text-bold-600" id="myModalLabel35"><b>Listado
									de diagnósticos CIEX</b></label>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<input id="contextPath" type="hidden"
							value="${pageContext.request.contextPath}">

						<div class="modal-body" id="buscarCIE10">
							<div class="row">
								<div class="card-body">
									<div class="table-responsive">
										<table class="table table-bordered" id="dataTable">
											<thead class="tabla_th">
												<tr>
													<th width="50">ITEM</th>
													<th width="70">CIEX</th>
													<th>DESCRIPCION</th>
													<th width="45">Acci&oacute;n</th>
												</tr>
											</thead>
											<tbody id="idBodyListaCIEX">
												<c:forEach var="ciex" items="${lstCIEX}" varStatus="loop">
													<tr>
														<td>${loop.count}</td>
														<td>${ciex.valor4}</td>
														<td>${ciex.nombreCorto}</td>
														<td><button type="button"
																class="btn btn-outline-success btn-sm"
																data-toggle="tooltip" data-placement="top" title=""
																data-original-title="Seleccionar"
																onclick="llenarDxIndex(${loop.index})"
																id="agregarEspecialidad">
																<i class="icon-check"></i>
															</button></td>
													</tr>
												</c:forEach> 
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
						<div class="modal-footer">

							<button id="idBtnCerrarModalCIEX" type="button"
								class="btn btn-info" data-dismiss="modal">Cerrar</button>

						</div>
					</div>
				</div>
			</div>
			
			-->
			<!-- Icon Cards-->
			<div class="tituloForm">REGISTRO DE REFERENCIA</div>
			<!-- Area Chart Example-->
			<div class="card mb-3">
				<div class="divCabeceraPanel">I. DATOS GENERALES
				</div>
				<f:form id="frmRegistroReferencia" class="form-horizontal"
					role="form" enctype="multipart/form-data" method="post"
					action="${pageContext.request.contextPath}/referenciaController/grabarReferencia"
					onsubmit="return false">
					<div class="form-group">
					<div class="card-body">
						<div class="form-body">
							<div class="row">
								<div class="col-md-3">
									<label for="exampleInputName" class="label_control">FECHA
										<span class="required">*</span>
									</label>
									<div class="position-relative has-icon-left">
										<f:input type="hidden" path="referenciaBean.codigo"
											id="codigoReferenciaBean" val="" />
										<input id="contextPath" type="hidden"
											value="${pageContext.request.contextPath}">
										<div class="controls">
											<fmt:formatDate
												value="${referenciaForm.referenciaBean.fechaIngresoRef}"
												var="dateString" pattern="dd/MM/yyyy" />
											<f:input id="strfechaIngresoRef" name="fecha" type="text"
												class="form-control" path="referenciaBean.fechaIngresoRef"
												value="${dateString}" size="10" maxlength="10"
												disabled="true"
												onkeyup="this.value=formateafecha(this.value);"
												required="required" />
										</div>
									</div>
								</div>
								<div class="col-md-3">
									<label for="exampleInputName" class="label_control">HORA
										<span class="required">*</span>
									</label>
									<div class="controls">
										<f:input id="strHoraReferencia" name="fecha" type="text"
											class="form-control" path="referenciaBean.horaIngresoRef"
											size="5" maxlength="5" required="required" disabled="true" />
									</div>
								</div>
								<div class="col-md-3">
									<label for="exampleInputName" class="label_control">N° REFERENCIA. 
									</label>
									<div class="controls">
										<f:input id="strHoraReferencia" name="fecha" type="text"
											class="form-control" path="referenciaBean.numeroReferencia"
											size="5" maxlength="5" disabled="true" />
									</div>
								</div>
								<div class="col-md-3">
									<label for="situacion" class="label_control">PLAN DE ATENCION
									</label>
									<div class="controls">
										<f:select id="documento"
											path="referenciaBean.planAtenSIS.codReg" class="form-control">
											<f:option value="" label="Seleccionar" selected="true"
												disabled="disabled" />
											<f:options items="${lstPlanAtencion}" itemValue="codReg"
												itemLabel="nombreCorto" />
										</f:select>
									</div>
								</div>
								</div>
								<div class="row">
								<div class="col-md-6">
									<label for="exampleInputName" class="label_control">ESTABLECIMIENTO
										ORIGEN<span class="required">*</span>
									</label>
									<div class="controls">
										<f:select id="cboEstablecimientoOrigen"
											path="referenciaBean.establecimientoOrige.codRenaes"
											required="required"
											class="form-control">
											<!--
											<f:option value="" label="Seleccionar" selected="true"
												disabled="disabled" />-->
												
												
											<f:options items="${lstUsuarioRenaesBean}" itemValue="renaes.codigo"
												itemLabel="renaes.nomRenaes" />
										</f:select>
									</div>
								<!-- <f:input value="5793 - TUPAC AMARU " disabled="true"
										type="text" class="form-control" id="establecimientoOrige"
										path="referenciaBean.establecimientoOrige.nomRenaes"
										required="required" />

									<f:input type="hidden"
										path="referenciaBean.establecimientoOrige.codRenaes"
										id="idestablecimientoOrige" value="005788" /> -->

								</div> 
								<div class="col-md-6">
									<label for="exampleInputName" class="label_control">ESTABLECIMIENTO
										DESTINO <span class="required">*</span>
									</label>
									<f:input disabled="true" type="text" class="form-control"
										id="nombreEstablecimientoDestino"
										value="NACIONAL CAYETANO HEREDIA"
										path="referenciaBean.establecimientoDestino.nomRenaes"
										required="required" />
									<f:input type="hidden" id="idEstablecimientoDestino"
										value="007431"
										path="referenciaBean.establecimientoDestino.codRenaes" />
								</div>
								<div class="col-md-1" style="display: none">
									<label for="exampleInputName" class="label_control"></label>
									<button class=" form-control btn btn-info" id="Button3"
										onclick="cargarEstablecimientoModal()" type="button">
										<i class="ft-search"></i> BUSCAR
									</button>
								</div>
							</div>
						</div>
					</div> 
						<div class="divCabeceraPanel">II. DATOS DEL PACIENTE</div> 
					<div class="card-body">
						<div class="form-body">
							<div class="row">
								<div class="col-md-6">
									<f:input type="hidden" class="form-control"
										id="personaCodigoREF"
										path="referenciaBean.paciente.persona.codigo" />
									<f:input type="hidden" class="form-control"
										id="personaCodigoSigehoREF"
										path="referenciaBean.paciente.persona.codigoPersonaSigeho" />
									<f:input type="hidden" class="form-control"
										id="personaApellidoPaternoREF"
										path="referenciaBean.paciente.persona.apellidoPaterno" />
									<f:input type="hidden" class="form-control"
										id="personaApellidoMaternoREF"
										path="referenciaBean.paciente.persona.apellidoMaterno" />
									<f:input type="hidden" class="form-control"
										id="personaPrimerNombreREF"
										path="referenciaBean.paciente.persona.primerNombre" />
									<f:input type="hidden" class="form-control"
										id="personaSegundoNombreREF"
										path="referenciaBean.paciente.persona.segundoNombre" />

									<f:input type="hidden" class="form-control"
										id="personaSexoCodigoREF"
										path="referenciaBean.paciente.persona.sexo.codReg" />
									<f:input type="hidden" class="form-control"
										id="personaFechaNacREF"
										path="referenciaBean.paciente.persona.fechaNac"
										value="01/01/1900" />
									<f:input type="hidden" class="form-control"
										id="tipoDocumentoPacienteREF"
										path="referenciaBean.paciente.persona.tipoDocumento.codReg" />
									<f:input type="hidden" class="form-control"
										id="nroDocumentoPacienteREF"
										path="referenciaBean.paciente.persona.nroDocumento" />

									<f:input type="hidden" class="form-control"
										id="tipoSeguroPacienteREF"
										path="referenciaBean.paciente.tipoSeguro.codReg" />
									<f:input type="hidden" class="form-control"
										id="categoriaPacienteREF"
										path="referenciaBean.paciente.categoriaSeguro" />
									
									<f:input type="hidden" class="form-control"
										id="codigoFiliacionPacienteREFERENCIA" 
										path="referenciaBean.paciente.codigoFiliacion" />
										
									<label for="nombreCompleto" class="label_control">NOMBRE
										PACIENTE <span class="required">*</span>
									</label>
									<div class="controls">
										<f:input disabled="true" type="text" class="form-control"
											id="nombreCompletoPacienteREF"
											path="referenciaBean.paciente.persona.nombreCompleto" />

									</div>

								</div>
								<div class="col-md-2">
									<label for="nroHC" class="label_control">EDAD (Años)</label>
									<div class="controls">
										<f:input type="text" class="form-control" id="edadPaciente"
											path="referenciaBean.paciente.persona.edad"
											disabled="true"
											onKeyPress="return soloNumeros(event)" />
									</div>
								</div>
								<div class="col-md-2">
									<label for="nroHC" class="label_control">HC</label>
									<div class="controls">
										<f:input type="text" class="form-control" id="nroHC"
											path="referenciaBean.paciente.nroHC"
											maxlength="10"
											onKeyPress="return soloNumeros(event)" />
									</div>
								</div>
								<div class="col-md-2">
									<br>
									<button id="idBtnCargarPaciente" type="button"
										onclick="personaCargarModal()"
										class="form-control btn btn-info">
										<i class="ft-search"></i> BUSCAR
									</button>
								</div>
							</div> 
							<div class="row">
								<div class="col-md-2">
									<label for="situacion" class="label_control">FINANCIADOR <span class="required">*</span>
									</label>
									<div class="controls">
										<f:select id="tipoSeguroPacienteREFER" disabled="true"
											path="referenciaBean.paciente.tipoSeguro.codReg"
											class="form-control">
											<f:option value="" label="Seleccionar" selected="true"
												disabled="disabled" />
											<f:options items="${lstTipoSeguro}" itemValue="codReg"
												itemLabel="nombreCorto" />
										</f:select>
									</div>
								</div>
								<div class="col-md-2">
									<label for="exampleInputName" class="label_control">CATEGORIA
									</label>
									<f:input type="text" class="form-control"
										id="categoriaPacienteREFER" disabled="true"
										path="referenciaBean.paciente.categoriaSeguro" />
								</div>
								<div class="col-md-2">
									<label for="exampleInputName" class="label_control">N° AFILIACION </label>
									<f:input type="text" class="form-control"
										id="codigoFiliacionPacienteREF" disabled="true"
										maxlength="20"
										path="referenciaBean.paciente.codigoFiliacion" />
								</div>
								<div class="col-md-2">
									<label for="exampleInputName" class="label_control">CELULAR<span class="required">*</span></label>
									<f:input type="text" class="form-control"
										id="nroCelularPaciente"
										required="required"
										onKeyPress="return soloNumeros(event)"
										maxlength="9"
										path="referenciaBean.paciente.persona.telfCelu" />
								</div>
								
							</div>
						</div>
					</div>
					<div class="divCabeceraPanel">III. DATOS CLÍNICOS</div> 
					<div class="card-body">
						<div class="form-group"> 
							<div class="row">
								<div class="col-md-3">
									<label for="servicioUPSReferencia" class="label_control">UPS
										DESTINO <span class="required">*</span>
									</label>
									<div class="controls">
										<f:select id="comboUPS" required="required"
											path="referenciaBean.servicioUPSReferencia.codReg"
											class="form-control" onchange="mostrarPorTipo()">
											<f:option value="" label="Seleccionar" selected="true"
												disabled="disabled" />
											<f:options items="${lstUpsDestino}" itemValue="codReg"
												itemLabel="nombreCorto" />
										</f:select>
									</div>
								</div>
								
								<div class="col-md-7 " id="datosCEX" style="display: none">
									<label for="exampleInputName" class="label_control">ESPECIFICAR</label>
									<f:input type="hidden" id="codRegEspecialidadREF"
										path="referenciaBean.especialidad.codReg" class="form-control" />
									<f:input disabled="true" type="text" class="form-control"
										id="nombreEspecialidadREF"
										path="referenciaBean.especialidad.nombreCorto" />
								</div>
								<div class="col-md-1" id="btnBuscardatosCEX"
									style="display: none">
									<label for="exampleInputName" class="label_control"></label>
									<button class=" form-control btn btn-info"
										onclick="especialidadCargarModal()" id="Button3" type="button">
										<i class="ft-search"></i> BUSCAR
									</button>
								</div>
							</div>
								<br>
							<div id="panelCEX" class="panel_style col-md-12"
								style="display: none">
								<f:form id="frmRegistroRegistro" class="form-horizontal"
									method="post" action="" onsubmit="return false"
									enctype="multipart/form-data">
									<label for="exampleInputName" class="label_title">APOYO(S) AL DX REALIZADO(S) :</label>

									<div class="row">
										<div class="col-md-2 ">
											<label for="exampleInputName" class="label_control">TIPO APOYO</label>
											<div class="controls">
												<f:select id="comboTipoApoyo"
													path="referenciaApoyoDxResultadosBean.tipoApoyo.codReg"
													class="form-control">
													<f:option value="" label="Seleccionar" selected="true"
														disabled="disabled" />
													<f:options items="${lstTipoApoyoDX}" itemValue="codReg"
														itemLabel="nombreCorto" />
												</f:select>
											</div>
										</div>
										<div class="col-md-6 ">
											<label for="exampleInputName" class="label_control">APOYO AL DX</label>
											<f:input disabled="true" type="text" class="form-control"
												id="nombreApoyoRealizado"
												path="referenciaApoyoDxResultadosBean.apoyoDX.nombreCorto" />
											<f:input type="hidden" id="codRegApoyoDXrealizadoREF"
												path="referenciaBean.especialidad.codReg"
												class="form-control" />
											<input type="hidden" id="codRegApoyoREFRealizado" value=""
												class="form-control" /> <input type="hidden"
												id="categoriaApoyoRealizado" value="" class="form-control" />
											<input type="hidden" id="codCategoriaRealizado" value=""
												class="form-control" />
										</div>
										<div class="col-md-1 ">
											<div class="botonDA" style="margin-top: 30px;">
												<button class=" form-control btn btn-info"
													id="btnapoyoDXCargarModal" onclick="apoyoDXCargarModal()"
													type="button">
													<i class="ft-search"></i> BUSCAR
												</button>
											</div>
										</div>
										<div class="col-md-3">
											<label class="label_control">ADJUNTAR RESULTADOS </label> <input
												type="file" name="files" id="files" class="form-control" />
										</div>
									</div>
									<div class="row">
										<div class="col-md-12 text-right ">
											<div class="botonDA" style="margin-top: 30px;">
												<button id="btn-save-reg" type="button" class="btn btn-info"
													onclick="cargarApoyoReferencia()">
													<i class="fa fa-plus"></i> AGREGAR
												</button>
											</div>
										</div>
									</div>

								</f:form>
								<br>
								<div class="row">
									<div class="col-md-12" id="listadoDetalleDocumentoInscripcion">
										<table class="table table-bordered">
											<thead class="tabla_th">

												<tr>
													<th>ITEM</th>
													<th>TIPO APOYO</th>
													<th>NOMBRE DE APOYO AL DX</th>
													<th>NOMBRE ARCHIVO</th>
													<th>DESCARGAR</th>
													<th>ACCION</th>
												</tr>

											</thead>
											<tbody id="idTablaDetalleDocumentoApoyo"
												class="label_control">
												<c:forEach var="apoyo"
													items="${lstReferenciaApoyoResultadoBean}" varStatus="loop">
													<tr>
														<td>${loop.count}</td>
														<td>${apoyo.tipoApoyo.nombreCorto}</td>
														<td>${apoyo.apoyoDX.nombreCorto}</td>
														<td>${apoyo.nombreDocumentoResultado}</td>

														<c:choose>
															<c:when
																test="${apoyo.nombreDocumentoResultado==null || apoyo.nombreDocumentoResultado==''}">
																<td></td>
															</c:when>
															<c:otherwise>
																<td><a title="Descargar" data-placement="top"
																	data-toggle="tooltip" target="_Blank"
																	href="${pageContext.request.contextPath}/resultados/${apoyo.apoyoDX.codReg}_${apoyo.nombreDocumentoResultado}"
																	download="${pageContext.request.contextPath}/resultados/${apoyo.apoyoDX.codReg}_${apoyo.nombreDocumentoResultado}"><i
																		class="fa fa-download"></i> DESCARGAR</a></td>

															</c:otherwise>
														</c:choose>
														<c:choose>
															<c:when test="${codigo==null || codigo==''}">
																<td></td>
															</c:when>
															<c:otherwise>
																<td><button type='button'
																		class='btn btn-outline-danger btn-sm'
																		data-toggle='tooltip' data-placement='top'
																		title='Eliminar'
																		onclick='confirmar_eliminar(${loop.index})'
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
							<div id="panelApoyo" class="panel_style_dx col-md-12"
								style="display: none">
								<input id="tipoLlamadoApoyo" type="hidden" value="0">
								<div class="form-group">
									<div class="row">
										<div class="col-md-2 ">
											<label for="exampleInputName" class="label_control">TIPO APOYO</label>
											<div class="controls">
												<f:select id="comboTipoApoyoREFapoyo"
													path="referenciaApoyoDxBean.tipoApoyo.codReg"
													class="form-control">
													<f:option value="" label="Seleccionar" selected="true"
														disabled="disabled" />
													<f:options items="${lstTipoApoyoDX}" itemValue="codReg"
														itemLabel="nombreCorto" />
												</f:select>
											</div>
										</div>
										<div class="col-md-6 ">
											<input type="hidden" id="codRegApoyoREF" value=""
												class="form-control" /> <input type="hidden"
												id="categoriaApoyo" value="" class="form-control" /> <input
												type="hidden" id="codCategoria" value=""
												class="form-control" /> <label for="exampleInputName"
												class="label_control">ESPECIFICAR APOYO</label>
											<f:input disabled="true" type="text" class="form-control"
												id="txtNombreApoyo"
												path="referenciaApoyoDxBean.apoyoDX.nombreCorto" />
										</div>
										<div class="col-md-2">
											<div class="botonDA" style="margin-top: 30px;">
												<button class=" form-control btn btn-info" id="Button3"
													onclick="apoyoDXCargarModalSelApoyo()" type="button">
													<i class="ft-search"></i> BUSCAR
												</button>
											</div>
										</div>
										<div class="col-md-2">
											<div class="botonDA" style="margin-top: 30px;">
												<button id="btn-save-reg" type="button" class="btn btn-info"
													onclick="agregarApoyo()">
													<i class="fa fa-plus"></i> AGREGAR
												</button>
											</div>
										</div>
									</div>
									<br>
									<div class="row">
										<div class="col-md-10" id="listadoDetalleApoyo">
											<table class="table table-bordered">
												<thead class="tabla_th">

													<tr>
														<th>ITEM</th>
														<th>TIPO APOYO</th>
														<th>NOMBRE APOYO AL DX</th>
														<th>ACCION</th>
													</tr>

												</thead>
												<tbody id="idTablaDetalleApoyo" class="label_control">
													<c:forEach var="apoyo" items="${lstReferenciaApoyoDxBean}"
														varStatus="loop">
														<tr>
															<td>${loop.count}</td>
															<td>${apoyo.tipoApoyo.nombreCorto}</td>
															<td>${apoyo.apoyoDX.nombreCorto}</td>
															<c:choose>
																<c:when test="${codigo==null || codigo==''}">
																	<td></td>
																	<br />
																</c:when>
																<c:otherwise>
																	<td><button type='button'
																			class='btn btn-outline-danger btn-sm'
																			data-toggle='tooltip' data-placement='top'
																			title='Eliminar'
																			onclick='confirmar_eliminar(${loop.index})'
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
							</div>  
							<div class="label_title">ANAMNESIS :</div> 
							<div class="row">
								<div class="col-md-3">
									<label for="nroHC" class="label_control">TIEMPO DE ENFERMEDAD
									</label>
									<div class="controls">
										<f:input type="text" class="form-control"
											id="tiempoEnfermedad"
											maxlength="3"
											path="referenciaBean.cantTiempoEnfermedad"
											onKeyPress="return soloNumeros(event)" />
									</div>
								</div>
								<div class="col-md-3">
									<label for="tiempoEnfermedad" class="label_control">TIEMPO 
									</label>
									<div class="controls">
										<f:select id="documento"
											path="referenciaBean.tiempoEnfermedad.codReg"
											class="form-control">
											<f:option value="" label="Seleccionar" selected="true"
												class="label_control" disabled="disabled" />
											<f:options items="${lstTiempoEnfermedad}"
												class="label_control" itemValue="codReg"
												itemLabel="nombreCorto" />
										</f:select>
									</div>
								</div>
								<div class="col-md-3">
									<label for="situacion" class="label_control">FORMA DE INICIO
									</label>
									<div class="controls">
										<f:select id="documento"
											path="referenciaBean.formaInicio.codReg" class="form-control">
											<f:option value="" label="Seleccionar" selected="true"
												disabled="disabled" />
											<f:options items="${lstFormaInicio}" itemValue="codReg"
												itemLabel="nombreCorto" />
										</f:select>
									</div>
								</div>
								<div class="col-md-3">
									<label for="situacion" class="label_control">CURSO</label>
									<div class="controls">
										<f:select id="documento" path="referenciaBean.curso.codReg"
											 class="form-control">
											<f:option value="" label="Seleccionar" selected="true"
												disabled="disabled" />
											<f:options items="${lstCurso}" itemValue="codReg"
												itemLabel="nombreCorto" />
										</f:select>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-12  mt-2">
									<label for="timesheetinput7" class="label_control">SINTOMAS Y SIGNOS PRINCIPALES<span class="required">*</span>
									</label>
									<div class="position-relative has-icon-left">
										<f:textarea id="descripcion" rows="3"
										    class="form-control"
										    maxlength="350"
											path="referenciaBean.sintomas" 
											required="required"></f:textarea>

									</div>
								</div>
							</div> 
							<div class="label_title">EXAMEN FISICO:</div> 
							<div class="row">
								<div class="col-md-3">
									<label for="exampleInputName" class="label_control">TEMPERATURA
										<span class="required">*</span>
									</label>
									<div class="position-relative has-icon-left">

										<div class="controls">
											<f:input type="text" class="form-control" id="nroDocumento"
												required="required" path="referenciaBean.temperatura"
												maxlength="4"
												onkeypress="return decimales(event,this);" />
										</div>
									</div>
								</div>
								<div class="col-md-3">
									<label for="exampleInputName" class="label_control">PRESION ARTERIAL
										<span class="required">*</span>
									</label>
									<div class="position-relative has-icon-left">

										<div class="controls">
											<f:input type="text" class="form-control"
												id="presionArterial" required="required"
												path="referenciaBean.presionArterial"
												maxlength="7"
												onkeypress="return fracciones(event,this);" />
										</div>
									</div>
								</div>
								<div class="col-md-3">
									<label for="exampleInputName" class="label_control">FRECUENCIA RESPIRATORIA<span class="required">*</span>
									</label>
									<div class="position-relative has-icon-left">

										<div class="controls">
											<f:input type="text" class="form-control"
												id="frecuenciaRespiratorio" required="required"
												maxlength="4"
												path="referenciaBean.frecuenciaRespiratorio"
												onkeypress="return decimales(event,this);" />
										</div>
									</div>
								</div>
								<div class="col-md-3">
									<label for="exampleInputName" class="label_control">FRECUENCIA CARDIACA<span class="required">*</span>
									</label>
									<div class="position-relative has-icon-left">
										<div class="controls">
											<f:input type="text" class="form-control"
												id="frecuenciaCardiaca" required="required"
												maxlength="4"
												path="referenciaBean.frecuenciaCardiaca"
												onkeypress="return decimales(event,this);" />
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-12  mt-2">
									<label for="timesheetinput7" class="label_control">RELATO
										<span class="required">*</span>
									</label>
									<div class="position-relative has-icon-left">
										<f:textarea id="descripcion" rows="3" class="form-control"
											path="referenciaBean.relato" maxlength="350"
											required="required"></f:textarea>

									</div>
								</div>
							</div> 
							<div class="label_title">EXAMENES AUXILIARES :</div> 
							<div class="row">
								<div class="col-md-12">

									<div class="position-relative has-icon-left">
										<f:textarea id="descripcion" rows="3" class="form-control"
											path="referenciaBean.examenesAuxHC"></f:textarea>

									</div>
								</div>
							</div> 
							<div class="label_title">
								DIAGNOSTICO(S) <span class="required">*</span>:
							</div> 
							<div id="panelCEX" class="panel_style col-md-12" > 
							<div class="row">
								<div class="col-md-12 text-right " style="margin-bottom: 20px;">
									<button id="btn-save-reg" type="button" class="btn btn-info"
										onclick="cie10CargarModal()">
										<i class="fa fa-plus"></i> AGREGAR
									</button>
									 
								</div>
							</div>
							<div class="row">
								<div class="col-md-12">
									<div class="table-responsive_">
										<table class="table table-bordered">
											<thead class="tabla_th">
												<tr>
													<th width="70">ITEM</th>
													<th width="120">CIEX</th>
													<th>DESCRIPCION</th>
													<th>TIPO</th>
													<th>ESPECIALIDAD ASOCIADA</th>
													<th width="220">ACCION</th>
												</tr>
											</thead>
											<tbody id="idbodyCIEXref" class="label_control">
												<c:forEach var="ciex"
													items="${lstReferenciaDiagnosticoBean}" varStatus="loop">
													<tr>
														<td>${loop.count}</td>
														<td>${ciex.diagnostico.valor4}</td>
														<td>${ciex.diagnostico.nombreCorto}</td>
														<td> 
														
														<select name="cboTipoDX" id="cboTipoDX" value="${ciex.tipo.codReg}" class="form-control">
														    <option value="">SELECCIONAR</option>
														    <option value="000001" ${ciex.tipo.codReg == '000001' ? 'selected' : ' '}>PRESUNTIVO</option>
														    <option value="000002" ${ciex.tipo.codReg == '000002' ? 'selected' : ' '}>DEFINITIVO</option>
														    <option value="000003" ${ciex.tipo.codReg == '000003' ? 'selected' : ' '}>REPETIDO (CONTROL)</option>													  													    
														</select>
<!-- 													
<select name="foo" id="foo" value="${myBean.foo}">
    <option value="">ALL</option>
    <c:forEach items="${lstTipoDX}" var="val"> 
        <option value="${val}" ${myBean.foo == val ? 'selected' : ' '}><c:out value="${val}" ></c:out></option>   
    </c:forEach>                     
</select> -->	
																				
														</td>
														<td>${ciex.especialidad.nombreCorto}</td>
														<c:choose>
															<c:when test="${codigo==null || codigo==''}">
																<td></td>
															</c:when>
															<c:otherwise>
																<td><button type='button'
																		class='btn btn-outline-danger btn-sm'
																		data-toggle='tooltip' data-placement='top'
																		title='Eliminar'
																		onclick='confirmar_eliminar(${ciex.diagnostico.valor4})'
																		data-original-title='Eliminar' id='eliminarDX'>
																		<i class='icon-trash'></i>
																	</button>
																	<button id="btn-save-reg" type="button" class="btn btn-info"
																		onclick="especialidadCargarModal()">
																		<i class="fa fa-plus"></i>ESPECIALIDAD
																	</button>
																</td>
															</c:otherwise>
														</c:choose>

													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
								</div>
							</div>
							</div> 
							<div class="label_title">TRATAMIENTO :</div> 
							<div class="row">
								<div class="col-md-12">
									<div class="position-relative has-icon-left">
										<f:textarea id="descripcion" 
										 maxlength="350"
										 rows="3" class="form-control"
											path="referenciaBean.tratamientoHC"></f:textarea>

									</div>
								</div>
							</div>
							<!-- 
									<div class="panel panel-default">
										<div class="panel-heading">
											<ul class="nav nav-tabs">
												<li class="active"><a class="nav-link active"
													id="base-tab11" data-toggle="tab" aria-controls="tab1"
													href="#tab1default" aria-expanded="true">Anamnesis</a></li>

												<li class="nav-item"><a class="nav-link" id="base-tab2"
													data-toggle="tab" aria-controls="tab12" href="#tab2default"
													aria-expanded="false">Exámen Físico</a></li>

												<li class="nav-item"><a class="nav-link" id="base-tab3"
													data-toggle="tab" aria-controls="tab13" href="#tab3default"
													aria-expanded="false">Exámenes Auxiliares</a></li>

												<li class="nav-item"><a onclick="listarLenguaUnidad();"
													class="nav-link" id="base-tab4" data-toggle="tab"
													aria-controls="tab14" href="#tab4default"
													aria-expanded="false">Diagnóstico</a></li>
												<li class="nav-item"><a
													onclick="listarLenguaLeccion();" class="nav-link"
													id="base-tab5" data-toggle="tab" aria-controls="tab15"
													href="#tab5default" aria-expanded="false">Tratamiento</a></li>
											</ul>
										</div>
										<div class="panel-body">
											<div class="tab-content">
												<div class="tab-pane active" id="tab1default">

													<div class="form-group">
														<div class="col-sm-12  mt-2">
															<label for="timesheetinput7" class="label_control">Descripci&oacute;n</label>
															<div class="position-relative has-icon-left">
																<f:textarea id="descripcion" rows="5"
																	class="form-control" path="referenciaBean.anamnesisHC"></f:textarea>
																<div class="form-control-position">
																	<i class="ft-file"></i>
																</div>
															</div>
														</div>
													</div>
												</div>
												<div class="tab-pane fade" id="tab2default">
													<div class="form-group"> 
												          <div class="table-responsive">
												            <table class="table table-bordered" id="dataTable" >
																<thead>
																	<tr>
																		<th>DESCRIPCION</th>
																		<th>Siglas</th>
																		<th>Unidad de Medida</th>
																		<th>Valor Obtenido</th>
																	</tr>
																</thead>
																<tbody>
																	<tr>
																		<td value="000007">Temperarura</td>
																		<td>TEMP</td>
																		<td align="center">°C</td>
																		<td><input type="text" name="user_date"
																			id="user_date" />
																	</tr>
																	<tr>
																		<td value="000004">Presión Arterial</td>
																		<td>PA</td>
																		<td align="center">mmHg</td>
																		<td><input type="text" name="user_date"
																			id="user_date" />
																	</tr>

																	<tr>
																		<td value="000005">Frecuencia Cardiaca</td>
																		<td>FC</td>
																		<td align="center">LATIDOS X MIN</td>
																		<td><input type="text" name="user_date"
																			id="user_date" />
																	</tr>
																	<tr>
																		<td value="000006">Frecuencia Respiratoria</td>
																		<td>FR</td>
																		<td align="center">RESP X MIN</td>
																		<td><input type="text" name="user_date"
																			id="user_date" />
																	</tr>
																</tbody>
															</table>  
													</div>
												</div>

												<div class="tab-pane fade" id="tab3default">Default 3</div>
												<div class="tab-pane fade" id="tab4default">Default 4</div>
												<div class="tab-pane fade" id="tab5default">Default 5</div>
											</div>
										</div>
									</div>
								</div> -->

						</div>
					</div>
					<div class="divCabeceraPanel">IV. DATOS DE LA REFERENCIA</div>
					<div class="card-body">
						<div class="form-group">
							<div class="row">
								<div class="col-md-6">
									<label for="situacion" class="label_control">CONDICION DEL PACIENTE<span class="required">*</span>
									</label>
									<div class="controls">
										<f:select id="documento" required="required"
											path="referenciaBean.condicionPaciente.codReg"
											class="form-control">
											<f:option value="" label="Seleccionar" selected="true"
												disabled="disabled" />
											<f:options items="${lstCondicionPaciente}" itemValue="codReg"
												itemLabel="nombreCorto" />
										</f:select>
									</div>
								</div> 
								<div class="col-md-6">
									<label for="situacion" class="label_control">MOTIVO DE REFERENCIA <span class="required">*</span>
									</label>
									<div class="controls">
										<f:select id="cboMotivoReferencia" required="required"
											path="referenciaBean.motivoReferencia.codReg"
											class="form-control">
											<f:option value="" label="Seleccionar" selected="true"
												disabled="disabled" />
											<f:options items="${lstMotivoReferencia}" itemValue="codReg"
												itemLabel="nombreCorto" />
										</f:select>
									</div>
								</div>
							</div> 
							<div class="row">
								<div class="col-md-12">
									<label for="situacion" class="label_control">DETALLE MOTIVO </label>
									<div class="position-relative has-icon-left">
										<f:textarea id="descripcion" rows="3" class="form-control"  maxlength="350"
											path="referenciaBean.descripcionMotivoReferencia"></f:textarea>

									</div>
								</div>
							</div>

							<div class="row">
								<div class="col-md-4">
									<label for="exampleInputName" class="label_control">RESPONSABLE DE REFERENCIA <span class="required">*</span>
									</label>
									<f:input disabled="true" type="text" class="form-control"
										id="nroDocumento"
										path="referenciaBean.responsableReferencia.persona.nombreCompleto" />
									<f:input type="hidden" id="codigoresponsableReferencia"
										path="referenciaBean.responsableReferencia.persona.codigo" />

								</div>
								<div class="col-md-2">
									<div class="botonDA" style="margin-top: 30px; display: none">
										<button class=" form-control btn btn-info" id="Button3"
											type="button">
											<i class="ft-search"></i> BUSCAR
										</button>
									</div>
								</div>
								<div class="col-md-3">
									<label for="exampleInputName" class="label_control">COLEGIATURA
									</label>
									<f:input type="text" class="form-control" onKeyPress="return soloNumeros(event)"
										id="responsableReferencianroColegiatura"  maxlength="10"
										path="referenciaBean.responsableReferencia.nroColegiatura" />
								</div>
								<div class="col-md-3">
									<label for="situacion" class="label_control">PROFESION
									</label>
									<div class="controls">
										<f:select id="documento"
											path="referenciaBean.responsableReferencia.persona.ocupacion.codReg"
											class="form-control">
											<f:option value="" label="Seleccionar" selected="true"
												disabled="disabled" />
											<f:options items="${lstProfesion}" itemValue="codReg"
												itemLabel="nombreCorto" />
										</f:select>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-4">
									<label for="exampleInputName" class="label_control">RESPONSABLE DE ESTABLECIMIENTO </label>
									<f:input disabled="true" type="text" class="form-control"
										id="nombreCompletoResponsableEstablecimiento"
										path="referenciaBean.responsableEstablecimiento.persona.nombreCompleto" />
									<f:input type="hidden" id="codigoresponsableReferencia"
										path="referenciaBean.responsableEstablecimiento.persona.codigo" />
								</div>
								<div class="col-md-2">
									<div class="botonDA" style="margin-top: 30px;">
										<button class=" form-control btn btn-info"
											onclick="personalCargarModal(1)" id="Button3" type="button">
											<i class="ft-search"></i> BUSCAR
										</button>
									</div>
								</div>
								<div class="col-md-3">
									<label for="exampleInputName" class="label_control">COLEGIATURA
									</label>
									<f:input type="text" class="form-control" 
									    id="nroDocumento" maxlength="10"
									    onKeyPress="return soloNumeros(event)"
										path="referenciaBean.responsableEstablecimiento.nroColegiatura" />
								</div>
								<div class="col-md-3">
									<label for="situacion" class="label_control">PROFESION
									</label>
									<div class="controls">
										<f:select id="documento"
											path="referenciaBean.responsableEstablecimiento.persona.ocupacion.codReg"
											class="form-control">
											<f:option value="" label="Seleccionar" selected="true"
												disabled="disabled" />
											<f:options items="${lstProfesion}" itemValue="codReg"
												itemLabel="nombreCorto" />
										</f:select>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-4">
									<label for="exampleInputName" class="label_control">PERSONAL QUE ACOMPAÑA </label>
									<f:input disabled="true" type="text" class="form-control"
										id="nombreCompletoPersonalAcompanante"
										path="referenciaBean.personalAcompanante.persona.nombreCompleto" />
									<f:input type="hidden" id="codigopersonalAcompanante"
										path="referenciaBean.personalAcompanante.codigo" />
								</div>
								<div class="col-md-2">
									<div class="botonDA" style="margin-top: 30px;">
										<button class=" form-control btn btn-info" id="Button3"
											onclick="personalCargarModal(2)" type="button">
											<i class="ft-search"></i> BUSCAR
										</button>
									</div>
								</div>
								<div class="col-md-3">
									<label for="exampleInputName" class="label_control">COLEGIATURA
									</label>
									<f:input type="text" class="form-control" maxlength="10"
										id="personalAcompanantenroColegiatura" onKeyPress="return soloNumeros(event)"
										path="referenciaBean.personalAcompanante.nroColegiatura" />
								</div>
								<div class="col-md-3">
									<label for="situacion" class="label_control">PROFESION
									</label>
									<div class="controls">
										<f:select id="documento"
											path="referenciaBean.personalAcompanante.persona.ocupacion.codReg"
											class="form-control">
											<f:option value="" label="Seleccionar" selected="true"
												disabled="disabled" />
											<f:options items="${lstProfesion}" itemValue="codReg"
												itemLabel="nombreCorto" />
										</f:select>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="form-group text-right"  style="margin-top: 20px; margin-bottom: 20px;">
						<a
							href="${pageContext.request.contextPath}/referenciaController/nuevo"
							class="btn btn-secondary" title=""> <i class="fa icon-plus"></i>
							NUEVO
						</a>
						<c:choose>
							<c:when test="${referenciaForm.referenciaBean.codigo > 0}">
								<a
									href="${pageContext.request.contextPath}/referenciaController/rptReferencia"
									class="btn btn-info" title=""> <i class="fa fa-print"></i>
									IMPRIMIR
								</a>
							</c:when>
							<c:otherwise>
								<button id="btn-save-reg" type="button" disabled="true"
									id="idbtnGrabarReferencia" class="btn btn-flat btn-primary">
									<i class="fa fa-print"></i> IMPRIMIR
								</button>

							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${referenciaForm.referenciaBean.codigo > 0}">
								<button id="btn-save-reg" type="submit" disabled="true"
									id="idbtnGrabarReferencia" class="btn btn-flat btn-primary"
									onclick="grabarReferencia()">
									<i class="fa fa-floppy-o"></i> GUARDAR
								</button>

							</c:when>
							<c:otherwise>
								<button id="btn-save-reg" type="submit"
									id="idbtnGrabarReferencia" class="btn btn-flat btn-primary"
									onclick="grabarReferencia()">
									<i class="fa fa-floppy-o"></i> GUARDAR
								</button>

							</c:otherwise>
						</c:choose>
					</div>
					</div>
				</f:form>
				<f:form id="frmRegistroReferencia" class="form-horizontal"
					role="form" enctype="multipart/form-data" method="POST"
					action="${pageContext.request.contextPath}/referenciaController/lista">
					<button type="submit" style="display: none" id="btnListado">Click
						me</button>
				</f:form>
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


		<!-- Modales -->
		<div class="modal fade text-xs-left" id="md_confirmacion"
			tabindex="-1" role="dialog" aria-labelledby="myModalLabel19"
			aria-hidden="true">
			<div class="modal-dialog modal-sm" role="document">
				<div class="modal-content">
					<div class="label_title_modal modal-header">

						<h4 class="label_title" id="myModalLabel19">Confirma
							Acci&oacute;n</h4>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<p id="txt_confir" class="label_control">¿Está seguro de
							eliminar registro seleccionado?</p>
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

		<div class="modal fade text-xs-left" id="modalPersona" tabindex="-2"
			role="dialog" aria-labelledby="myModalLabel35" data-dismiss="modal"
			aria-hidden="true" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content" id="modalPersonaContent"></div>
			</div>
		</div>
		<div class="modal fade text-xs-left" id="modalPersonal" tabindex="-1"
			role="dialog" aria-labelledby="myModalLabel35" data-dismiss="modal"
			aria-hidden="true" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content" id="modalPersonalContent"></div>
			</div>
		</div>
		<div class="modal fade text-xs-left" id="modalEstablecimiento"
			tabindex="-1" role="dialog" aria-labelledby="myModalLabel35"
			data-dismiss="modal" aria-hidden="true" aria-hidden="true">
			<div class="modal-dialog modal-lg" role="document">
				<div class="modal-content" id="modalEstablecimientoContent"></div>
			</div>
		</div>
		<div class="modal fade text-xs-left" id="modalEspecialidad"
			tabindex="-2" role="dialog" aria-labelledby="myModalLabel35"
			data-dismiss="modal" aria-hidden="true" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content" id="modalEspecialidadContent"></div>
			</div>
		</div>

		<div class="modal fade text-xs-left" id="modalDXCIEX" tabindex="-1"
			role="dialog" aria-labelledby="myModalLabel35" data-dismiss="modal"
			aria-hidden="true" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content" id="modalDXCIEXContent"></div>
			</div>
		</div>

		<div class="modal fade text-xs-left" id="modalApoyoDX" tabindex="-1"
			role="dialog" aria-labelledby="myModalLabel35" data-dismiss="modal"
			aria-hidden="true" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content" id="modalApoyoDXContent"></div>
			</div>
		</div>

		<script
			src="${pageContext.request.contextPath}/app-assets/vendors/js/vendors.min.js"
			type="text/javascript"></script>


		<script
			src="${pageContext.request.contextPath}/assets/js/page/asistencial/referencia.js"
			type="text/javascript" charset="utf-8"></script>
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
			src="${pageContext.request.contextPath}/app-assets/vendors/js/extensions/sweetalert.min.js"
			type="text/javascript"></script>
		<script
			src="${pageContext.request.contextPath}/app-assets/js/scripts/extensions/sweet-alerts.js"
			type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/assets/js/scripts.js"
			type="text/javascript"></script>
		<script
			src="${pageContext.request.contextPath}/app-assets/vendors/js/extensions/toastr.min.js"
			type="text/javascript"></script>

		<script
			src="${pageContext.request.contextPath}/app-assets/js/core/app.js"
			type="text/javascript"></script>

		<script
			src="${pageContext.request.contextPath}/app-assets/js/core/app-menu.js"
			type="text/javascript"></script>


		<script
			src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/extended/typeahead/typeahead.bundle.min.js"
			type="text/javascript"></script>
		<script
			src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/extended/typeahead/bloodhound.min.js"
			type="text/javascript"></script>
		<script
			src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/extended/typeahead/handlebars.js"
			type="text/javascript"></script>
		<script
			src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/extended/inputmask/jquery.inputmask.bundle.min.js"
			type="text/javascript"></script>
		<script
			src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/extended/maxlength/bootstrap-maxlength.js"
			type="text/javascript"></script>
		<script
			src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/spinner/jquery.bootstrap-touchspin.js"
			type="text/javascript"></script>
		<script
			src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/validation/jqBootstrapValidation.js"
			type="text/javascript"></script>

		<script
			src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/extended/inputmask/jquery.inputmask.bundle.min.js"
			type="text/javascript"></script>
		<script
			src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/extended/maxlength/bootstrap-maxlength.js"
			type="text/javascript"></script>

		<!-- END PAGE VENDOR JS-->
		<script
			src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/validation/jqBootstrapValidation.js"
			type="text/javascript"></script>
		<script
			src="${pageContext.request.contextPath}/app-assets/vendors/js/tables/jquery.dataTables.min.js"
			type="text/javascript"></script>
		<script
			src="${pageContext.request.contextPath}/app-assets/vendors/js/tables/datatable/dataTables.bootstrap4.min.js"
			type="text/javascript"></script>
		<script
			src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/select/select2.full.min.js"
			type="text/javascript"></script>
		<!-- END PAGE VENDOR JS-->
		<!-- BEGIN STACK JS-->

		<script
			src="${pageContext.request.contextPath}/app-assets/js/core/app.js"
			type="text/javascript"></script>
		<!-- END STACK JS-->
		<!-- BEGIN PAGE LEVEL JS-->
		<script
			src="${pageContext.request.contextPath}/app-assets/js/scripts/tables/datatables/datatable-basic.js"
			type="text/javascript"></script>

		<script
			src="${pageContext.request.contextPath}/app-assets/vendors/js/ui/blockUI.min.js"
			type="text/javascript"></script>
		<script
			src="${pageContext.request.contextPath}/app-assets/js/scripts/extensions/block-ui.min.js"
			type="text/javascript"></script>

		<script src="http://malsup.github.io/jquery.blockUI.js"></script>
	</div>
</body>


<script>

function llamar(){
	alert("llamar ");
	mostrarPorTipo();
}
function cie10CargarModalInterno(){
	//llenarTablaCIE10();
	$("#modalCIEX").modal('show'); 
	
}

</script>

<script type="text/javascript">  
		var  listadoCIEX = [];
		var  listadoApoyosDX = [];
		var  listadoApoyoDXRealizado = [];
		
		
		var reloj = new Date() 
		var hora=reloj.getHours();
		var minutos=reloj.getMinutes();
		var segundos=reloj.getSeconds();
		var hora= hora + ":" + minutos; 
		
		$(document).ready(function(){
			mostrarPorTipo();
		});
 </script>


</html>
