<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
<title>Registro de Perfil</title>
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

			<!-- Icon Cards-->
			<div class="row"></div>
			<!-- Area Chart Example-->
			<div class="card mb-3">
			<div class="divCabecera"> CAMBIO DE CLAVE </div> 
				<f:form class="form-horizontal form-simple" 
						role="form" 
						action="${pageContext.request.contextPath}/usuarioController/cambiarPass" 
						onsubmit="return validar();">
						
                    <input type="text" id="msgError" value="${msgError}" style="display: none !important;">
                	<input id="Mensaje" type="hidden" value="${Mensaje}">

					
					
					<input id="contextPath" type="hidden"
						value="${pageContext.request.contextPath}">
					<div class="card-body ">
						<div class="form-group" style="text-align: center">

							<div class="row">
								<div class="form-group  col-md-8 ">
									<label for="exampleInputName" class="label_control">CONTRASEÑA ACTUAL<span class="required">*</span>
									</label>
									<f:input type="password" required="required" class="form-control form-control-lg input-lg"
										id="textClave" path="passwordUsuario" value ="" />
								</div>
							</div>
							<div class="row">
								<div class="col-md-8">
									<label for="exampleInputName" class="label_control" style="margin-top: 15px;">NUEVA CONTRASEÑA
										<span class="required">*</span>
									</label>
									<f:input type="password" required="required" class="form-control form-control-lg input-lg"
										id="textNewClave" path="newPassword" />
								</div>
							</div>
							<div class="row">
								<div class="col-md-8">
									<label for="exampleInputName" class="label_control" style="margin-top: 15px;">REPITA NUEVA CONTRASEÑA
										<span class="required">*</span>
									</label>
									<input type="password" required="required" class="form-control form-control-lg input-lg"
										id="textReClave" />
								</div>
							</div>
									<f:input type="hidden"  id="codigoUser" path="codigoUsuario" />
									<f:input type="hidden"  id="codigo" path="codigo" />
									<f:input type="hidden"  id="numeroPeriodo" path="numeroPeriodo" />
									<f:input type="hidden"  id="codigoInstitucion" path="codigoInstitucion" />
									<f:input type="hidden"  id="codigoSede" path="codigoSede" />
									<f:input type="hidden"  id="codigoOrganizacion" path="codigoOrganizacion" />
									<f:input type="hidden"  id="numeroVersion" path="numeroVersion" /> 
									<f:input type="hidden"  id="oldPassword" path="oldPassword" /> 
										
							<div class="row">
								<div class="form-group col-md-8 text-right"
									style="margin-top: 20px;">
									<button id="btnResetPass" type="submit"
										class="btn btn-primary btn-lg btn-block">
										<i class="ft-unlock"></i> ACTUALIZAR
									</button>
								</div>
							</div>
							<div class="row">
								<div class="form-group col-md-6 text-center" style="margin-top: 20px;">
							<div id="boxMsgx"></div>
							</div>
							</div> 
						</div>
					</div>
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
	
	<script> 
	$(document).ready(function() {
        var infoHtml = "<div id='boxMsg' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert' aria-hidden='true'>×</button><span class='msgValidar'>Ups Ocurrio un error en JavaScript ponerse en contacto con soporte de imarpe.</span></div>"
		var msgError=document.getElementById('msgError').value;
		if(msgError.length>0){
            //$("#boxMsgx").append(infoHtml);
            $("#boxMsgx").html(infoHtml);
            $("#boxMsg").fadeIn("slow");
            $(".msgValidar").html(msgError);
		}
	});
    </script>
</body>

<script
	src="${pageContext.request.contextPath}/assets/js/page/seguridad/usuario.js"
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

</html>
