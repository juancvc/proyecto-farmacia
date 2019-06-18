<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<link
	href="https://fonts.googleapis.com/css?family=Montserrat:300,300i,400,400i,500,500i%7COpen+Sans:300,300i,400,400i,600,600i,700,700i"
	rel="stylesheet">

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
	href="${pageContext.request.contextPath}/app-assets/css/plugins/extensions/toastr.css">
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
<!-- Page level plugin CSS
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
.estilo_reactivo {
	font-color: #fdfefe;
	background-color: #cd6155;
}

.estilo_noReactivo {
	font-color: #fdfefe;
	background-color: #5499c7;
}
</style>

<div class="modal-dialog modal-lg" role="document">
	<div class="modal-content">
		<div class="modal-header">
			<label class="modal-title text-text-bold-600" id="myModalLabel35"><b>RESULTADO TAMIZAJE</b></label>
			<button type="button" class="close" data-dismiss="modal"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
		</div>

		<f:form id="frmlistarCIE10" class="form-horizontal" role="form"
			method="post" onsubmit="return false" action="">
			<input id="contextPath" type="hidden"
				value="${pageContext.request.contextPath}">

			<div class="modal-body" id="buscarCIE10">
				<div class="row">
					<div class="col-md-5 mb-3">
						<label for="exampleInputName" class="label_control">FECHA</label>
						<f:input type="text" class="form-control" id="nombreCortoDX"
							disabled="true" path="sFecha" />
					</div>
				</div>
				<div class="row">
					<div class="card-body">
						<div class="table-responsive">
							<div id="div1">
								<table class="table table-bordered" id="dataTable"
									style="overflow-y: scroll">
									<thead class="tabla_th">
										<tr>
											<th width="50">ITEM</th>
											<th width="70">CODIGO</th>
											<th>ANALISIS</th>
											<th>RESULTADO</th>
											<th>VALOR INICIAL</th>
											<th>VALOR FINAL</th>
											<th>UNIDADES</th>
											<th>OBSERVACION</th>
										</tr>
									</thead>
									<tbody id="idBodyListaCIEX" class="label_control">
										<c:forEach var="seropositivo" items="${lstSeropositivoBean}"
											varStatus="loop">
											<tr>
												<td>${loop.count}</td>
												<td>${seropositivo.analisisBean.codigo}</td>
												<td>${seropositivo.analisisBean.nombre}</td>
												<td>${seropositivo.resultado}</td>
												<td>${seropositivo.analisisBean.valorInicial}</td>
												<td>${seropositivo.analisisBean.valorFinal}</td>
												<td>${seropositivo.analisisBean.unidades}</td> 
												<c:choose>
													<c:when
														test="${seropositivo.observacion == 'REACTIVO'}">
														<td class="estilo_reactivo">${seropositivo.observacion}</td>
													</c:when>
													<c:when
														test="${seropositivo.observacion == 'NO REACTIVO'}">
														<td class="estilo_noReactivo">${seropositivo.observacion}</td>
													</c:when>
													<c:otherwise>
														<td>${seropositivo.observacion}</td>
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
			</div>
			<div class="modal-footer">

				<button type="button" id="idBtnCerrarModalCIEX"
					class="btn btn-secondary" data-dismiss="modal">
					<i class="fa fa-close"></i> CERRAR
				</button>

			</div>
		</f:form>
	</div>
</div>

<script
	src="${pageContext.request.contextPath}/app-assets/vendor/jquery/jquery.min.js"></script>

<script
	src="${pageContext.request.contextPath}/app-assets/vendor/jquery/jquery.min.js"></script>
<script
	src="${pageContext.request.contextPath}/app-assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- Core plugin JavaScript-->
<script
	src="${pageContext.request.contextPath}/app-assets/vendor/jquery-easing/jquery.easing.min.js"></script>
<!-- Page level plugin JavaScript
		<script
			src="${pageContext.request.contextPath}/app-assets/vendor/datatables/jquery.dataTables.js"></script>
		<script
			src="${pageContext.request.contextPath}/app-assets/vendor/datatables/dataTables.bootstrap4.js"></script>
		<!-- Custom scripts for all pages-->
<script
	src="${pageContext.request.contextPath}/app-assets/js/sb-admin.min.js"></script>
<!-- Custom scripts for this page-->

<script
	src="${pageContext.request.contextPath}/assets/js/page/util/utilitarios.js"
	type="text/javascript" charset="utf-8"></script>

<script
	src="${pageContext.request.contextPath}/app-assets/js/scripts/extensions/block-ui.js"
	type="text/javascript"></script>
<script src="http://malsup.github.io/jquery.blockUI.js"></script>
