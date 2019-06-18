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
<title>Entrevista pre-donantes</title>
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

<style>
.estilo_cajaResultado {
	font-color: #0A0A0A;
	font-weight: bold;
	font-family: Cambria;
	font-size: 16px;
	background-color: #ECC64F;
	text-align: center;
	valign: center;
}
</style>

</head>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">
	<!-- Navigation-->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top"
		id="mainNav">
		<a class="navbar-brand label_control_hade" href="#"> SIGEHO WEB </a>
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
			<div class="tituloForm">ENTREVISTA PRE-DONANTES</div>

			<f:form id="frmGuardarEntrevista" class="form-horizontal"
				role="form" method="post" action="" onsubmit="return false">
				<div class="card mb-3">

					<f:input type="hidden" id="codigoPostulante"
						path="postulanteBean.codigo" />
					<f:input type="hidden" id="estadoFisicoBeancodigo"
						path="postulanteBean.estadoFisicoBean.codigo" />
					<f:input type="hidden" id="estadoFisicoBeanCodigoOrganizacion"
						path="postulanteBean.estadoFisicoBean.codigoOrganizacion" />
					<f:input type="hidden" id="estadoFisicoBeanCodigoInstitucion"
						path="postulanteBean.estadoFisicoBean.codigoInstitucion" />
					<f:input type="hidden" id="estadoFisicoBeanCodigoSede"
						path="postulanteBean.estadoFisicoBean.codigoSede" />
						
					<f:input type="hidden" id="postulantenumeroPeriodo"
						path="postulanteBean.numeroPeriodo" />
						
					<f:input type="hidden" id="estadoFisicoBeannumeroPeriodo"
						path="postulanteBean.estadoFisicoBean.numeroPeriodo" />
					<f:input type="hidden" id="estadoFisicoBeannumeroVersion"
						path="postulanteBean.estadoFisicoBean.numeroVersion" />
					<f:input type="hidden" id="estadoFisicopersonaCodigo"
						path="postulanteBean.estadoFisicoBean.personaBean.codigo" />

					<input id="contextPath" type="hidden"
						value="${pageContext.request.contextPath}">
					<f:input type="hidden" class="form-control" id="personaCodigo"
						path="postulanteBean.persona.codigo" />
					<f:input type="hidden" class="form-control"
						id="personaCodigoSigeho"
						path="postulanteBean.persona.codigoPersonaSigeho" />
					<div class="card-body">
						<div class="form-group">


							<div class="panel panel-default">
								<div class="panel-heading">
									<ul class="nav nav-tabs label_tabs">
										<li class="active"><a class="nav-link active"
											id="base-tab11" data-toggle="tab" aria-controls="tab1"
											href="#tab1default" aria-expanded="true">CONSULTA</a></li>

										<li class="nav-item"><a class="nav-link" id="base-tab2"
											data-toggle="tab" aria-controls="tab12" href="#tab2default"
											aria-expanded="false">ENTREVISTA</a></li>

									</ul>
								</div>
								<div class="panel-body">
									<div class="tab-content">
										<div class="tab-pane active" id="tab1default"> 
											<div class="form-group">
												<br>
												<div class="label_title">DATOS DEL POSTULANTE :</div>
												<div class="row">
													<div class="form-group col-md-3 mb-1">
														<label for="situacion" class="label_control">TIPO
															DOCUMENTO </label>
														<div class="controls">
															<f:select id="tipoDocumentoPaciente" disabled="true"
																path="postulanteBean.persona.tipoDocumento.codReg"
																required="required" class="form-control" >
																<f:options items="${lstDocumento}" itemValue="codReg"
																	itemLabel="nombreCorto" />
															</f:select>
															<f:input type="hidden" id="tipoDocumentoPersona"
																path="postulanteBean.persona.tipoDocumento.codReg" />
														</div>
													</div>
													<div class="form-group col-md-3 mb-1">
														<label for="exampleInputName" class="label_control">N°
															DOCUMENTO </label>
														<div class="position-relative has-icon-left">
															<input id="contextPath" type="hidden"
																value="${pageContext.request.contextPath}">
															<div class="controls">
																<f:input type="text" class="form-control"
																	required="required" maxlength="12"
																	id="nroDocumentoPaciente" disabled="true"
																	path="postulanteBean.persona.nroDocumento"
																	onkeypress="return runScript(event)" />
																<f:input type="hidden" id="nroDocumentoPersona"
																	path="postulanteBean.persona.nroDocumento" />
															</div>
														</div>
													</div>
													<div class="form-group col-md-3 mb-1">
														<label for="nombreCompleto" class="label_control">APELLIDO
															PATERNO </label>
														<div class="controls">
															<f:input type="text" class="form-control"
																required="required"
																onkeyup="javascript:this.value=this.value.toUpperCase();"
																id="personaApellidoPaterno" disabled="true"
																path="postulanteBean.persona.apellidoPaterno" />

														</div>
													</div>
													<div class="form-group col-md-3 mb-1">
														<label for="nombreCompleto" class="label_control">APELLIDO
															MATERNO </label>
														<div class="controls">
															<f:input type="text" class="form-control"
																onkeyup="javascript:this.value=this.value.toUpperCase();"
																id="personaApellidoMaterno" disabled="true"
																path="postulanteBean.persona.apellidoMaterno" />

														</div>
													</div>

												</div>
												<div class="row">
													<div class="form-group col-md-3 mb-1">
														<label for="nombreCompleto" class="label_control">PRIMER
															NOMBRE </label>
														<div class="controls">
															<f:input type="text" class="form-control"
																required="required"
																onkeyup="javascript:this.value=this.value.toUpperCase();"
																id="personaPrimerNombre" disabled="true"
																path="postulanteBean.persona.primerNombre" />

														</div>
													</div>
													<div class="form-group col-md-3">
														<label for="nombreCompleto" class="label_control">SEGUNDO
															NOMBRE </label>
														<div class="controls">
															<f:input type="text" class="form-control"
																onkeyup="javascript:this.value=this.value.toUpperCase();"
																id="personaSegundoNombre" disabled="true"
																path="postulanteBean.persona.segundoNombre" />
														</div>
													</div>
													<div class="col-md-3">
														<label for="situacion" class="label_control">SEXO</label>
														<div class="controls">
															<f:select id="sexoPaciente"
																path="postulanteBean.persona.sexo.codReg"
																disabled="true" class="form-control" required="required">
																<f:option value="" label="Seleccionar" selected="true"
																	disabled="disabled" />
																<f:options items="${lstSexo}" itemValue="codReg"
																	itemLabel="nombreCorto" />
															</f:select>
														</div>
													</div>
													<div class="col-md-3">
														<label for="lbltipoSeguroPaciente" class="label_control">ESTADO
															CIVIL </label>
														<div class="controls">
															<f:select id="estadoCivilPersona"
																path="postulanteBean.persona.estadoCivil.codReg"
																disabled="true" class="form-control" required="required">
																<f:option value="" label="Seleccionar" selected="true"
																	disabled="disabled" />
																<f:options items="${lstEstadoCivil}" itemValue="codReg"
																	itemLabel="nombreCorto" />
															</f:select>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="form-group col-md-3 mb-1">
														<label for="exampleInputName" class="label_control">FECHA
															NACIMIENTO <span class="required">*</span>
														</label>
														<div class="controls">
															<fmt:formatDate value="${fechaHasta}" var="dateString"
																pattern="dd/MM/yyyy" />
															<f:input id="personaFechaNac" name="fecha" type="text"
																class="form-control"
																path="postulanteBean.persona.fechaNacStr"
																disabled="true" value="${dateString}" size="10"
																maxlength="10" required="required"
																onkeyup="this.value=formateafechaNacimiento(this.value);" />
														</div>
													</div>
													<div class="col-md-3">
														<label for="lbltipoSeguroPaciente" class="label_control">NACIONALIDAD</label>
														<div class="controls">
															<f:select id="personaNacionalidad"
																path="postulanteBean.persona.nacionalidad.codReg"
																disabled="true" class="form-control" required="required">
																<f:option value="" label="Seleccionar" selected="true"
																	disabled="disabled" />
																<f:options items="${lstNacionalidad}" itemValue="codReg"
																	itemLabel="nombreCorto" />
															</f:select>
														</div>
													</div>
													<div class="col-md-3">
														<label for="nombreCompleto" class="label_control">CORREO
														</label>
														<div class="controls">
															<f:input type="email" class="form-control" id="correo"
																path="postulanteBean.persona.correo" disabled="true" />

														</div>
													</div>
													<div class="col-md-3">
														<label for="nombreCompleto" class="label_control">TELEFONO
														</label>
														<div class="controls">
															<f:input type="text" class="form-control"
																required="required"
																onKeyPress="return soloNumeros(event)" maxlength="9"
																id="telefono" disabled="true"
																path="postulanteBean.persona.telefonoNumero" />

														</div>
													</div>
												</div>
												<div class="row">
													<div class=" col-md-3">
														<img id="imgFotoPostulante"
															src="${pageContext.request.contextPath}/assets/img/fotoPersonaGenerico.gif"
															height="75%" width="55%" />

													</div>
													<div class=" col-md-6">
														<label for="nombreCompleto" class="label_control">UBIGEO
															DIRECCION </label>
														<div class="controls">
															<f:input type="text" disabled="true" value=""
																class="form-control" required="required"
																id="nombreUbigeoDireccion"
																path="postulanteBean.persona.ubigeoDireccion.nombreUbigeo" />

														</div>
													</div>
													<div class=" col-md-3 ">
														<label for="nombreCompleto" class="label_control">DIRECCION
														</label>
														<div class="controls">
															<f:input type="text" class="form-control"
																required="required" disabled="true"
																id="personaDireccion"
																path="postulanteBean.persona.direccion" />

														</div>
													</div>
												</div>
											</div>
											<div class="label_title">DONACION DIRIGIDA Y EVALUACION
												FISICA :</div>
											<div class="form-group">
												<div class="table-responsive">
													<table class="table table-bordered" id="dataTable">
														<thead class="tabla_th">
															<tr>
																<th>ITEM</th>
																<th>NRO. POSTULANTE</th>
																<th>FECHA</th>
																<th>TIPO DONACION</th>
																<th>PARENTESCO</th>
																<th>DNI PAC.</th>
																<th>NOMBRE PACIENTE</th>
																<th>HTCO</th>
																<th>GRUPO</th>
																<th>FACTOR</th>
																<th>OBSERVACION</th>
																<th>EVAL. FISICA</th>
																<th>ENTREVISTA</th>
																<th>FLEBOTOMIA</th>
																<th>VOLUMEN</th>
															</tr>
														</thead>
														<tbody id="idBodyListaPostulante">
										<c:forEach var="preDonante" items="${lstResultadosPreDonanteBean}" varStatus="loop">
											<tr> 
												<td>${loop.count}</td> 
												<td>${preDonante.postulanteBean.codigo}</td> 
												<td><fmt:formatDate pattern="dd/MM/yyyy" value="${preDonante.postulanteBean.fecha}" /></td>  
												<td>${preDonante.postulanteBean.tipoPostulate.nombreCorto}</td>
												<td>${preDonante.postulanteBean.tipoParentescoPaciente.nombreCorto}</td>
												<td>${preDonante.postulanteBean.paciente.persona.nroDocumento}</td>   
												<td>${preDonante.postulanteBean.paciente.persona.nombreCompleto}</td>
												<td>${preDonante.postulanteBean.estadoFisicoBean.htco}</td>
												<td>${preDonante.postulanteBean.estadoFisicoBean.grupoSanguineo.nombreLargo}</td>
												<td>${preDonante.postulanteBean.estadoFisicoBean.factor.nombreLargo}</td>
												<td>${preDonante.postulanteBean.estadoFisicoBean.observacion}</td>
												<td>${preDonante.postulanteBean.estadoFisicoBean.calificacion.nombreCorto}</td>
												<td>${preDonante.resultado.nombreCorto}</td>
												<td>${preDonante.postulanteBean.flebotomiaBean.resultado.nombreCorto}</td>
												<td>${preDonante.postulanteBean.flebotomiaBean.volumenSangre}</td>	
											</tr>
										</c:forEach>
									</tbody>
													</table>
												</div>
											</div>
											
											
										</div>
										<div class="tab-pane fade" id="tab2default">
											<br>
											<div class="form-group">
												<div class="table-responsive">
													<!--  -->
													<div id="div1">
														<table class="table  table-bordered" id="dataTableEntrevista"
															style="overflow-y: scroll">
															<thead class="tabla_th">
																<tr>
																	<th width="50">ITEM</th>
																	<th>CODIGO</th>
																	<th>PREGUNTA</th>
																	<th>SI</th>
																	<th>NO</th>
																	<th width="400">OBSERVACION (Redactar)</th>
																</tr>
															</thead>
															<tbody id="idBodyListaApoyos" class="label_control">
																<c:forEach var="pregunta" items="${lstPreguntas}"
																	varStatus="loop">
																	<tr>
																		<td>${loop.count}</td>
																		<td>${pregunta.codReg}</td>
																		<td>${pregunta.nombreCorto}</td>
																		<td><input type="checkbox" onclick="cambiarRespuestas('${pregunta.codReg}','SI');"
																			value="${pregunta.codReg}"
																			id="${pregunta.codReg}"  />
																		</td>
																		<td><input type="checkbox"  onclick="cambiarRespuestas('${pregunta.codReg}','NO');"
																			value="${pregunta.codReg}"
																			id="NO_${pregunta.codReg}" checked="checked" /></td>
																		<td><input type="text" class="form-control"
																				id="txtObservacion${pregunta.codReg}" /></td>
																	</tr>
																</c:forEach>
															</tbody>

														</table>
														<!--  -->
													</div>
												</div>
												<div class="row" style="margin-top: 15px;">
													<div class="col-md-3 mb-2">
														<label for="exampleInputName" class="label_control">PESO
															<span class="required">*</span>
														</label>
														<div class="position-relative has-icon-left">
															<div class="controls">
																<f:input type="text" class="form-control"
																	id="pesoPostulante" required="required"
																	maxlength="3" path="preDonanteBean.peso"
																	onkeypress="return soloNumeros(event);"
																	onchange = "calculaIMC(); " />
															</div>
														</div>
													</div>
													<div class="col-md-3 mb-2">
														<label for="exampleInputName" class="label_control">TALLA
															<span class="required">*</span>
														</label>
														<div class="position-relative has-icon-left">
															<div class="controls">
																<f:input type="text" class="form-control"
																	id="tallaPostulante" required="required"
																	maxlength="3" path="preDonanteBean.talla"
																	onkeypress="return soloNumeros(event); "
																	onchange = "calculaIMC(); "  />
															</div>
														</div>
													</div>
													<div class="col-md-3">
														<label for="exampleInputName" class="label_control">TEMPERATURA
															<span class="required">*</span>
														</label>
														<div class="position-relative has-icon-left">

															<div class="controls">
																<f:input type="text" class="form-control"
																	id="temperaturaPostulante" required="required"
																	path="preDonanteBean.temperatura" maxlength="4"
																	onkeypress="return decimales(event,this);" />
															</div>
														</div>
													</div>
													<div class="col-md-3 mb-2">
														<label for="exampleInputName" class="label_control">MASA
															CORPORAL </label>
														<div class="position-relative has-icon-left">
															<div class="controls">
																<f:input type="text"
																	class="form-control  estilo_cajaResultado"
																	id="imcPostulante" maxlength="4" disabled="true"
																	path="preDonanteBean.masaCorporal" />
																	
																	<f:input type="hidden"  id="codigoIMCPostulante" path="preDonanteBean.masaCorporal" />
															</div>
														</div>
													</div>
												</div>
												<div class="row">

													<div class="col-md-3">
														<label for="exampleInputName" class="label_control">PRESION
															ARTERIAL <span class="required">*</span>
														</label>
														<div class="position-relative has-icon-left">

															<div class="controls">
																<f:input type="text" class="form-control"
																	id="presionArterial" required="required"
																	path="preDonanteBean.presionArterial" maxlength="7"
																	onkeypress="return fracciones(event,this);" />
															</div>
														</div>
													</div>
													<div class="col-md-3">
														<label for="exampleInputName" class="label_control">PULSO<span
															class="required"> *</span>
														</label>
														<div class="position-relative has-icon-left">

															<div class="controls">
																<f:input type="text" class="form-control"
																	id="pulsoPostulante" required="required"
																	maxlength="4" path="preDonanteBean.pulso"
																	onkeypress="return decimales(event,this);" />
															</div>
														</div>
													</div>
													<div class="col-md-3">
														<label for="situacion" class="label_control">ACCESO
															VENOSO  <span class="required">*</span></label>
														<div class="controls">
															<f:select id="cboAccesoVenosoPostulante"
																path="preDonanteBean.accesoVenoso.codReg"
																class="form-control" required="required">
																<f:option value="" label="Seleccionar" selected="true"
																	disabled="disabled" />
																<f:options items="${lstEstadoVenoso}" itemValue="codReg"
																	itemLabel="nombreCorto" />
															</f:select>
														</div>
													</div>
													<div class="col-md-3">
														<label for="exampleInputName" class="label_control">VOLUMEN
															SANG. TOTAL </label>
														<div class="position-relative has-icon-left">

															<div class="controls">
																<f:input type="text"
																	class="form-control estilo_cajaResultado"
																	id="volumenSangrePostulante"
																	disabled="true" path="preDonanteBean.volumenSangreTotal"   />
																	
																	<f:input type="hidden" id="regVolumenSangrePostulante"  path="preDonanteBean.volumenSangreTotal"   />
															</div>
														</div>
													</div>
												</div>
												<div class="row"></div>
												<div class="row">
													<div class="col-md-3  mt-2">
														<label for="situacion" class="label_control">RESULTADO   <span class="required">*</span></label></label>
														<div class="controls">
															<f:select id="cboResultadoEntrevista"
																path="preDonanteBean.resultado.codReg"
																class="form-control" required="required">
																<f:option value="" label="Seleccionar" selected="true"
																	disabled="disabled" />
																<f:options items="${lstCalificacion}" itemValue="codReg"
																	itemLabel="nombreCorto" />
															</f:select>
														</div>
													</div>
													<div class="col-sm-9  mt-2">
														<label for="timesheetinput7" class="label_control">OBSERVACION
														</label>
														<div class="position-relative has-icon-left">
															<f:textarea id="observacionPostulante" rows="3"
																class="form-control" path="preDonanteBean.observacion"
																maxlength="350"></f:textarea>

														</div>
													</div>
												</div>
												<div class="form-group text-right"
													style="margin-top: 10px; margin-bottom: 0px;">
													<a
														href="${pageContext.request.contextPath}/entrevistaController/buscarPreDonantes"
														class="btn btn-secondary" title=""> REGRESAR </a>

													<button type="submit" onclick="registrarEntrevista()"
														class="btn btn-primary">
														<i class="fa fa-floppy-o"></i> GUARDAR
													</button>
												</div>
											</div>


										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				
			</f:form>
		
			<f:form id="frmRegistro" class="form-horizontal" role="form"
				method="POST"
				action="${pageContext.request.contextPath}/entrevistaController/buscarPreDonantes">
				<button type="submit" style="display: none"
					id="btnListadoEntrevista">Click me</button>
			</f:form>

			<div class="modal fade text-xs-left" id="modalUbigeo" tabindex="-2"
				role="dialog" aria-labelledby="myModalLabel35" data-dismiss="modal"
				aria-hidden="true" aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content" id="modalPersonaContent"></div>
				</div>
			</div>

			<div class="modal fade text-xs-left" id="modalCampania" tabindex="-2"
				role="dialog" aria-labelledby="myModalLabel35" data-dismiss="modal"
				aria-hidden="true" aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content" id="modalmodalCampania"></div>
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



		<!-- Bootstrap core JavaScript-->
		<script
			src="${pageContext.request.contextPath}/app-assets/vendor/jquery/jquery.min.js"></script>


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
	</div>
</body>
<script
	src="${pageContext.request.contextPath}/assets/js/page/asistencial/banco.js"
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
	$(document).ready(function() {
		$("#nroDocumentoPaciente").focus();
		
		$("#pesoPostulante").keyup(function(event) {
		    if (event.keyCode === 13) {
		    	calculaIMC();
		    	$("#tallaPostulante").focus();
		    }
		});
		$("#tallaPostulante").keyup(function(event) {
		    if (event.keyCode === 13) {
		    	calculaIMC();
		    	$("#temperaturaPostulante").focus();
		    }
		});
	
		$("#temperaturaPostulante").keyup(function(event) {
		    if (event.keyCode === 13) { 
		    	$("#presionArterial").focus();
		    }
		});
		
	//	$("#presionArterial").keyup(function(event) {
	//	    if (event.keyCode === 13) { 
	//	    	$("#pulsoPostulante").focus();
	//	    }
	//	});
// 		$("#pulsoPostulante").keyup(function(event) {
// 		    if (event.keyCode === 13) { 
// 		    	$("#cboAccesoVenosoPostulante").focus();
// 		    }
// 		});
// 		$("#cboAccesoVenosoPostulante").keyup(function(event) {
// 		    if (event.keyCode === 13) { 
// 		    	$("#cboResultadoEntrevista").focus();
// 		    }
// 		});
// 		$("#cboResultadoEntrevista").keyup(function(event) {
// 		    if (event.keyCode === 13) { 
// 		    	$("#observacionPostulante").focus();
// 		    }
// 		}); 
		
	});
	
	$(document).ready(function() {

		var codigoPostulante = $("#codigoPostulante").val();
		if (codigoPostulante.length > 0) {
			var dni = $("#nroDocumentoPersona").val();
			var tipoDoc = $("#tipoDocumentoPersona").val();
			console.log("dni " + dni);
			console.log("tipoDoc " + tipoDoc);
			fotoPostulante(tipoDoc, dni);
		}

	});

	function fotoPostulante(tipoDoc, dni) {
		var contextPath = $('#contextPath').val();

		$
				.ajax({
					type : "GET",
					url : contextPath
							+ "/entrevistaController/obtenerFotoPostulante?tipoDocumento="
							+ tipoDoc + "&numero=" + dni,

					success : function(persona) {

						if (persona != null) {
							if (persona.length != 0) {
								var image = new Image();
								var src = contextPath
										+ "/assets/img/fotoPersonaGenerico.gif";
								if (persona.foto != null) {
									src = "data:image/png;base64,"
											+ persona.foto;
								}
								image.src = src;
								image.alt = "Image"
								// $('#imgFotoPaciente').append(image);

								$("#imgFotoPostulante").attr("src", image.src);

								// $('#tipoDocumentoPaciente').val(persona.tipoDocumento.codReg); 
							}

						}
					},
					error : function(xhr, status, er) {
						console.log("error: " + xhr + " status: " + status
								+ " er:" + er);
						if (xhr.status == 500) {
							console.log(er);
							// Error_500(er);
						}
						if (xhr.status == 901) {
							console.log(er);
							// spire_session_901(er);
						}

					}
				});

	} 
	
</script>
</html>










