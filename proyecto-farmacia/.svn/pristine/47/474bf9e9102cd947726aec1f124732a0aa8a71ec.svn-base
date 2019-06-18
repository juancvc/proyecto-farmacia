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
<title>SIGEHO WEB</title>
<!-- Bootstrap core CSS-->
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
		<a class="navbar-brand label_control_hade" href="#l"> SIGEHO
			WEB</a>
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
				<li class="breadcrumb-item"><a href="#">Inicio</a></li>
				<li class="breadcrumb-item active">Estadísticos</li>
			</ol>
			-->
			<!-- Area Chart Example-->
			<f:form id="frmInicio" role="form"  
					method="post"
					onsubmit="return validar();"
					action="${pageContext.request.contextPath}/inicioController/listado" >

				<div class="card mb-1">
					<div class="divCabecera"> DATOS ESTADISTICOS
					</div>
					<div class="card-body">
						<!-- <canvas id="myAreaChart" width="100%" height="30"></canvas> -->
						<div class="row">
							<div class="col-md-2">
								<label for="exampleInputName" class="label_control">FECHA
									DESDE </label>
								<div class="position-relative has-icon-left">
									<f:input type="hidden" path="codigo" id="fechaDesdeReferencia"
										val="" />
									<input id="contextPath" type="hidden"
										value="${pageContext.request.contextPath}">
									<div class="controls">
										<fmt:formatDate value="${fechaDesde}" var="dateString"
											pattern="dd/MM/yyyy" />
										<f:input id="strfechaIngresoRef" name="fecha" type="text"
											class="form-control" path="fechaDesde" value="${dateString}"
											size="10" maxlength="10"
											onkeyup="this.value=formateafecha(this.value);" />
									</div>
								</div>
							</div>
							<div class="col-md-2">
								<label for="exampleInputName" class="label_control">FECHA
									HASTA </label>
								<div class="controls">
									<fmt:formatDate value="${fechaHasta}" var="dateString"
										pattern="dd/MM/yyyy" />
									<f:input id="fechaHastaReferencia" name="fecha" type="text"
										class="form-control" path="fechaHasta" value="${dateString}"
										size="10" maxlength="10"
										onkeyup="this.value=formateafecha(this.value);" />
								</div>
							</div>
							<div class="col-md-4">
								<label for="exampleInputName" class="label_control">ESTABLECIMIENTO
									DESTINO</label>
								<f:input type="text" value="NACIONAL CAYETANO HEREDIA"
									class="form-control" id="nroDocumento" maxlength="150"
									path="establecimientoDestino.nomRenaes" disabled="true" />
							</div>
							<div class="col-md-4">
								<label for="exampleInputName" class="label_control">ESTABLECIMIENTO
									ORIGEN</label>
								<f:input type="text" class="form-control" id="establecimientoOrigen"
									path="establecimientoOrige.nomRenaes" maxlength="150"/>
							</div>
						</div>
						<div class="row">
							<div class="col-md-4" style="margin-top: 15px;">
									<label for="exampleInputName" class="label_control">PACIENTE</label>
									<f:input type="text" class="form-control" id="nombrePaciente"
										path="paciente.persona.nombreCompleto" maxlength="150"/>
							</div>
							<div class="col-md-2" style="margin-top: 15px;">
								<label for="situacion" class="label_control">FINANCIADOR</label>
								<div class="controls">
									<f:select id="comboTipoSeguro"
										path="paciente.tipoSeguro.codReg" class="form-control">
										<f:option value="" label="Todos" selected="true"
											disabled="disabled" />
										<f:options items="${lstTipoPaciente}" itemValue="codReg"
											itemLabel="nombreCorto" />
									</f:select>
								</div>
							</div>
							<div class="col-md-2" style="margin-top: 15px;">
								<label for="situacion" class="label_control">SITUACION </label>
								<div class="controls">
									<f:select id="comboSituacion" 
										path="situacion.codReg" class="form-control">
										<f:option value="" label="Todos" selected="true"
											disabled="disabled" />
										<f:options items="${lstSituacion}" itemValue="codReg"
											itemLabel="nombreCorto" />
									</f:select>
								</div>
							</div>
							
						</div>

						<div class="row">
							<div class="form-group col-md-12 text-right"
								style="margin-top: 10px;">
								 <button onclick="limpiarForm();$('#dataTable').dataTable().fnClearTable();" type="button" class="btn btn-flat btn-default">
                                                    <i class="fa fa-eraser"></i> LIMPIAR
                                                </button>
								<button class="btn btn-info" type="submit">
									<i class="ft-search"></i> BUSCAR
								</button>
							</div>
						</div>
						<br>
						<div class="row">
							<div class="table-responsive">
								<table class="table table-bordered" id="dataTable">
									<thead class="tabla_th">
										<tr>
											<th width="30">ITEM</th>
											<th>PACIENTE</th>
											<th >FINANCIADOR</th>
											<th>FECHA</th>
											<th>MEDICO REFERENCIA</th>
											<th>ESTABLECIMIENTO ORIGEN</th>
											<th>ESTABLECIMIENTO DESTINO</th> 
											<th>SITUACION</th>
										</tr>
									</thead>
									<tbody id="idBodyListaReferencia" class="tabla_td"> 
										<c:forEach var="referencia" items="${lstReferenciaBean}"
											varStatus="loop">
											<tr >
												<td>${loop.count}</td>
												<td>${referencia.paciente.persona.nombreCompleto}</td>
												<td>${referencia.tipoSeguro.nombreCorto}</td>
												<td><fmt:formatDate pattern="dd/MM/yyyy"
														value="${referencia.fechaIngresoRef}" /></td>
												
												<td>${referencia.responsableReferencia.persona.nombreCompleto}</td>
												<td>${referencia.establecimientoOrige.nomRenaes}</td>
												<td>${referencia.establecimientoDestino.nomRenaes}</td>
												
												<c:choose>
													<c:when
														test="${referencia.situacion.codReg =='000001'}"> 
														<td align="center"><img title="${referencia.situacion.nombreCorto}" id ="imgFotoPaciente" src="${pageContext.request.contextPath}/assets/img/situ/pendiente.png" ></td>
													</c:when>
													<c:when
														test="${referencia.situacion.codReg =='000002'}"> 
														<td align="center"><img  title="${referencia.situacion.nombreCorto}" id ="imgFotoPaciente" src="${pageContext.request.contextPath}/assets/img/situ/atendido.png" ></td>
													</c:when>
													<c:when
														test="${referencia.situacion.codReg =='000004'}"> 
														<td align="center"><img  title="${referencia.situacion.nombreCorto}" id ="imgFotoPaciente" src="${pageContext.request.contextPath}/assets/img/situ/citaProgramada.png" ></td>
													</c:when>
													<c:otherwise>
														<td align="center"><img  title="${referencia.situacion.nombreCorto}" id ="imgFotoPaciente" src="${pageContext.request.contextPath}/assets/img/situ/descarto.png" ></td>
													</c:otherwise>
												</c:choose>
			
												<!-- <td>${referencia.situacion.nombreCorto}</td> -->
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
					 
				</div>
			</f:form>

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
		<!-- Logout Modal-->
		<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Ready to
							Leave?</h5>
						<button class="close" type="button" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">Ã</span>
						</button>
					</div>
					<div class="modal-body">Select "Logout" below if you are
						ready to end your current session.</div>
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
			src="${pageContext.request.contextPath}/assets/js/page/asistencial/referencia.js"
			type="text/javascript" charset="utf-8"></script>
		<script
			src="${pageContext.request.contextPath}/assets/js/page/util/utilitarios.js"
			type="text/javascript" charset="utf-8"></script>	
	</div>
</body>

<script>
	function  limpiarForm(){
		$("#fechaHastaReferencia").val("");
		$("#strfechaIngresoRef").val("");
		$("#comboSituacion").val("");
		$("#comboTipoSeguro").val("");
		$("#establecimientoOrigen").val("");
		$("#nombrePaciente").val("");
       	}
</script>

</html>
