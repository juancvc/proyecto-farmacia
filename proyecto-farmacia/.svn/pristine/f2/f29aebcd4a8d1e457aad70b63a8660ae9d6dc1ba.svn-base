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

<div class="modal-dialog modal-sm" role="document">
	<div class="modal-content">
		<f:form id="frmDescartarReferencia" class="form-horizontal"
					role="form" enctype="multipart/form-data" method="post"
					action=""
					onsubmit="return false">
		<input id="contextPath" type="hidden"
						value="${pageContext.request.contextPath}">
		<div class="label_title_modal modal-header">

			<h4 class="label_title" id="myModalLabel19">DESCARTAR REFERENCIA</h4>
			<button type="button" class="close" data-dismiss="modal"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
		</div>
	
		<div class="modal-body">
			<div class="row">
				<div class="col-md-12">
					<label for="situacion" class="label_control">MOTIVO <span class="required">*</span>
					</label>
					<div class="controls">
						<f:select id="documento"
							path="motivoDescarte.codReg"
							required="required" 
							class="form-control">
							<f:option value="" label="Seleccionar" selected="true"
								disabled="disabled" />
							<f:options items="${lstMotivos}"
								itemValue="codReg" itemLabel="nombreCorto" />
						</f:select>
					</div>
				</div>
			</div>	
			<br>
			<div class="row">
				<div class="col-md-12">
					<label for="situacion" class="label_control">DETALLE MOTIVO DESCARTE <span class="required">*</span>
					</label>
					<f:input type="hidden" id="codigo" class="form-control"
								path="codigo" required="required" />
					<f:input type="hidden" id="codigoOrganizacion" class="form-control"
								path="codigoOrganizacion" required="required" />
					<f:input type="hidden" id="codigoInstitucion" class="form-control"
								path="codigoInstitucion" required="required" />
					<f:input type="hidden" id="codigoSede" class="form-control"
								path="codigoSede" required="required" />
					<f:input type="hidden" id="numeroPeriodo" class="form-control"
								path="numeroPeriodo" required="required" />
					<f:input type="hidden" id="numeroVersion" class="form-control"
								path="numeroVersion" required="required" />															
					<div class="position-relative has-icon-left">
							<f:textarea id="descripcion" rows="3" class="form-control"
								path="detalleMotivoDescarte" required="required" ></f:textarea>

						</div>
				</div>
			</div>
		</div>
		<div class="modal-footer">
			<button type="button" id="idBtnCerrarDescartar" class="btn grey btn-outline-secondary"
				data-dismiss="modal"><i class="fa fa-close"></i>CERRAR</button>
			<button id="btnConfirmarGeneric" type="submit"
				class="btn btn-outline-danger"
				onclick="descartar()">DESCARTAR</button>
		</div>
		</f:form>
		<f:form id="frmRegistroReferencia" class="form-horizontal"
					role="form" enctype="multipart/form-data" method="POST"
					action="${pageContext.request.contextPath}/referenciaController/lista">
					<button type="submit" style="display: none" id="btnListado">Click
						me</button>
				</f:form>
	</div>
</div>

<script
	src="${pageContext.request.contextPath}/app-assets/vendor/jquery/jquery.min.js"></script>


<!-- Page level plugin JavaScript-->
<!-- Custom scripts for all pages-->

<!-- Custom scripts for this page
		<script
			src="${pageContext.request.contextPath}/app-assets/js/sb-admin-datatables.min.js"></script>
		<!-- Custom scripts for this page-->

<!-- Core plugin JavaScript-->

<script
	src="${pageContext.request.contextPath}/assets/js/page/asistencial/referencia.js"
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
 