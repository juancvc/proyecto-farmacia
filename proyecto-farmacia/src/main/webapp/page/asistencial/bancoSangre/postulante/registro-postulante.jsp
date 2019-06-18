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
<title>Registro de Postulantes</title>
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

<style type="text/css">
.tabla{border-collapse:collapse;border-spacing:0;}
.tabla td{font-size:12px ;border-width:1px;overflow:hidden;word-break:normal;}
.tabla th{font-size:12px; border-width:1px;overflow:hidden;word-break:normal;}
.t2 th{font-size:10px;}
.t3 td{font-size:10px;height:0.5cm;}
.t3 th{font-size:10px;height:0.5cm;}
.inline{float: left;}
.cuerpo{
  font-family: Arial,sans-serif;
  width: 20.9cm !important; 
}

.bold{
  font-weight: bold;
}
.textofantasma{
  color:white;
}
.bordered{
  border: 1px solid #333;
}
.whitetop{
  border-top-color: white;
}
.whitebottom{
  border-bottom-color: white;
}
.whiteleft{
  border-left-color: white;
}
.whiteright{
  border-right-color: white;
}
.center{
  text-align:center;
}
.to-left{
  float: left;
}
.to-right{
  float: right;
}
.vertical-line{
  border-left: 3px dotted #333 !important;
}
.ancho-tabla{ 
  transform: rotate(90deg);
-webkit-transform: rotate(90deg);
-moz-transform: rotate(90deg);
-o-transform: rotate(90deg);
  
}
.ancho-fecha{
  width: 1.6cm !important;
}
#midiv:hover {
transform: rotate(-5deg);
-webkit-transform: rotate(-5deg);
-moz-transform: rotate(-5deg);
-o-transform: rotate(-5deg);
}
</style>
<style>
 

td, th, tr, table {
 /*border-top: 1px solid black;
   border-collapse: collapse;
 */
	
}

td.producto, th.producto { 
	font-size: 10px;
	font-family: Arial,sans-serif;;
}

td.cantidad, th.cantidad {
	width: 40px;
	max-width: 40px;
	word-break: break-all;
	font-size: 13px;
	font-family: Arial,sans-serif;; 
	text-align: center;
	align-content: center;
}
 
.centrado {
	text-align: center;
	align-content: center;
	
}

.ticket {
    text-align: center;
	align-content: center;
	width: 100px;
    max-width: 100px;
    height: 80px;
}



 
.estilo_cajaOrigen {
	font-color: #0A0A0A;
	font-weight: bold;
	font-family: Cambria;
	font-size: 16px;
	background-color: #ECC64F;
	text-align: center;
	valign: center;
} 
.estilo_reactivo {
	font-color: #fdfefe;
	background-color: #cd6155;
}

.estilo_noReactivo {
	font-color: #fdfefe;
	background-color: #5499c7;
}

.barCode {
	border: 1px solid;
	border-color: #CCD1D1;
	border-radius: 4px;
	height: 170px;
	width: 80%
}

.barCode header {
	border-bottom: 1px solid;
	border-color: #CCD1D1;
	height: 20px;
}

.barCode header h5 {
	background: #F7F7F9;
	font-family: Cambria;
	text-align: center;
	font-size: 16px;
}

.barCode div {
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
			<div class="tituloForm">REGISTRO DE POSTULANTE VOLUNTARIO</div>

			<f:form id="frmGuardarDonante" class="form-horizontal" role="form"
				method="post" action="" onsubmit="return false">
				<div class="card mb-3">
					<f:input type="hidden" id="codigoPostulante" path="codigo" />
					<f:input type="hidden" id="codigoCorreo"
						path="persona.codigoCorreo" />
					<f:input type="hidden" id="codigoDireccion"
						path="persona.codigoDireccion" />
					<f:input type="hidden" id="codigoTelefono"
						path="persona.codigoTelefono" />

					<input id="contextPath" type="hidden"
						value="${pageContext.request.contextPath}">
					<f:input type="hidden" class="form-control" id="personaCodigo"
						path="persona.codigo" />
					<f:input type="hidden" class="form-control"
						id="personaCodigoSigeho" path="persona.codigoPersonaSigeho" />
					<div class="card-body">
						<div class="form-group">
							<div class="label_title">DATOS DE CAMPAÑA :</div>
							<div class="row">
								<div class="form-group col-md-3 mb-1">
									<label for="nombreCompleto" class="label_control">CODIGO
										CAMPAÑA <span class="required">*</span>
									</label>
									<div class="controls">
										<f:input type="text" class="form-control" disabled="true"
											required="required" id="campaniaCodigo"
											path="campania.codigo" />
										<f:input type="hidden" id="campaniaCodigoRegistro"
											path="campania.codigo" />
										<f:input type="hidden" id="campaniaPeriodo"
											path="campania.numeroPeriodo" />
										<f:input type="hidden" id="campaniaVersion"
											path="campania.numeroVersion" />

									</div>
								</div>
								<div class="col-md-1">
									<button id="idBtnCargarPaciente" type="button"
										style="margin-top: 30px;" onclick="buscarCampania('000001')"
										class="form-control btn btn-info">
										<i class="ft-search"></i> BUSCAR
									</button>
								</div>
								<div class="form-group col-md-8 mb-1">
									<label for="nombreCompleto" class="label_control">NOMBRE
										CAMPAÑA </label>
									<div class="controls">
										<f:input type="text" class="form-control" disabled="true"
											required="required" id="campaniaNombre"
											path="campania.lugarCampaniaBean.nombre" />

									</div>
								</div>


							</div>
							<div class="label_title">DATOS DEL POSTULANTE :</div>
							<div class="row">
								<div class="form-group col-md-3 mb-1">
									<label for="situacion" class="label_control">TIPO
										DOCUMENTO <span class="required">*</span>
									</label>
									<div class="controls">
										<f:select id="tipoDocumentoPaciente"
											path="persona.tipoDocumento.codReg" required="required"
											class="form-control" onchange="limpiarPorTipo()">
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
												path="persona.nroDocumento"
												onkeypress="return runScript(event)" />
										</div>
									</div>
								</div>
								<div class="col-md-3">
									<button id="idBtnCargarPaciente" type="button"
										style="margin-top: 30px;" onclick="buscarPersonaWebService()"
										class="form-control btn btn-info">
										<i class="ft-search"></i> BUSCAR
									</button>
								</div>
								<div class="col-md-2">
									<label for="nombreCompleto" class="label_control">ORIGEN
										DATOS </label>
									<div class="controls">
										<f:input type="text" class="form-control estilo_cajaOrigen"
											id="origenDatos" path="persona.origenDatos" />

									</div>
								</div>

								<div class="col-md-1">
									<button id="idBtnTamizaje" type="button"
										style="margin-top: 30px;" onclick="buscarTamizaje()"
										disabled="true" class="form-control btn btn-danger">
										<i class="ft-search"></i> TAMIZAJE
									</button>
								</div>

							</div>
							<div class="row">
								<div class="form-group col-md-3 mb-1">
									<label for="nombreCompleto" class="label_control">APELLIDO
										PATERNO <span class="required">*</span>
									</label>
									<div class="controls">
										<f:input type="text" class="form-control" required="required"
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
									<label for="nombreCompleto" class="label_control">PRIMER
										NOMBRE <span class="required">*</span>
									</label>
									<div class="controls">
										<f:input type="text" class="form-control" required="required"
											onkeyup="javascript:this.value=this.value.toUpperCase();"
											id="personaPrimerNombre" disabled="true"
											path="persona.primerNombre" />

									</div>
								</div>
								<div class="form-group col-md-3 mb-1">
									<label for="nombreCompleto" class="label_control">SEGUNDO
										NOMBRE </label>
									<div class="controls">
										<f:input type="text" class="form-control"
											onkeyup="javascript:this.value=this.value.toUpperCase();"
											id="personaSegundoNombre" disabled="true"
											path="persona.segundoNombre" />
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-3 mb-1">
									<label for="situacion" class="label_control">SEXO <span
										class="required">*</span></label>
									<div class="controls">
										<f:select id="sexoPaciente" path="persona.sexo.codReg"
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
										CIVIL<span class="required">*</span>
									</label>
									<div class="controls">
										<f:select id="estadoCivilPersona"
											path="persona.estadoCivil.codReg" disabled="true"
											class="form-control" required="required">
											<f:option value="" label="Seleccionar" selected="true"
												disabled="disabled" />
											<f:options items="${lstEstadoCivil}" itemValue="codReg"
												itemLabel="nombreCorto" />
										</f:select>
									</div>
								</div>
								<div class="col-md-3 mb-1">
									<label for="exampleInputName" class="label_control">FECHA
										NACIMIENTO <span class="required">*</span>
									</label>
									<div class="controls">
										<fmt:formatDate value="${fechaHasta}" var="dateString"
											pattern="dd/MM/yyyy" />
										<f:input id="personaFechaNac" name="fecha" type="text"
											class="form-control" path="persona.fechaNacStr"
											disabled="true" value="${dateString}" size="10"
											maxlength="10" required="required"
											onkeyup="this.value=formateafechaNacimiento(this.value);" />


									</div>
								</div>
								<div class="form-group col-md-3 mb-1">
									<label for="nombreCompleto" class="label_control">EDAD
									</label>
									<div class="controls">
										<f:input type="text" class="form-control" required="required"
											disabled="true" id="edadPersona" path="persona.edad" />

									</div>
								</div>
							</div>

							<div class="row">
								<div class="form-group col-md-3 mb-1">
									<label for="lbltipoSeguroPaciente" class="label_control">NACIONALIDAD<span
										class="required"> *</span></label>
									<div class="controls">
										<f:select id="personaNacionalidad"
											path="persona.nacionalidad.codReg" disabled="true"
											class="form-control" required="required">
											<f:option value="" label="Seleccionar" selected="true"
												disabled="disabled" />
											<f:options items="${lstNacionalidad}" itemValue="codReg"
												itemLabel="nombreCorto" />
										</f:select>
									</div>
								</div>
								<div class="col-md-3">
									<label for="lbltipoSeguroPaciente" class="label_control">GRADO
										INSTRUCCION<span class="required"> *</span>
									</label>
									<div class="controls">
										<f:select id="personaNivelInstrucion"
											path="persona.nivelInstrucion.codReg" class="form-control"
											required="required">
											<f:option value="" label="Seleccionar" selected="true"
												disabled="disabled" />
											<f:options items="${lstNivelInstrucion}" itemValue="codReg"
												itemLabel="nombreCorto" />
										</f:select>
									</div>
								</div>
								<div class="col-md-3">
									<label for="lbltipoSeguroPaciente" class="label_control">OCUPACION<span
										class="required"> *</span></label>
									<div class="controls">
										<f:select id="personaOcupacion"
											path="persona.ocupacion.codReg" class="form-control"
											required="required">
											<f:option value="" label="Seleccionar" selected="true"
												disabled="disabled" />
											<f:options items="${lstOcupacion}" itemValue="codReg"
												itemLabel="nombreCorto" />
										</f:select>
									</div>
								</div>
								<div class="form-group col-md-3 mb-1">
									<label for="nombreCompleto" class="label_control">TELEFONO
										<span class="required">*</span>
									</label>
									<div class="controls">
										<f:input type="text" class="form-control" required="required"
											onKeyPress="return soloNumeros(event)" maxlength="9"
											id="telefono" path="persona.telefonoNumero" />

									</div>
								</div>
							</div>

							<div class="row">
								<div class="form-group col-md-2 mb-1">
									<label for="nombreCompleto" class="label_control">UBIGEO
										NACIMIENTO <span class="required">*</span>
									</label>
									<div class="controls">
										<f:input type="text" class="form-control" required="required"
											disabled="true" onKeyPress="return soloNumeros(event)"
											maxlength="6" id="ubigeoNacimientoCodigoUbigeo"
											path="persona.ubigeoNacimiento.codigoUbigeo" />

										<f:input type="hidden" id="codigoRegistroUbigeoNacimiento"
											path="persona.ubigeoNacimiento.codigoRegistro" />
									</div>
								</div>
								<div class="col-md-1">
									<button id="btnBuscarUbigeoNaciemiento" type="button"
										disabled="true" style="margin-top: 30px;"
										onclick="ubigeoCargarModal(1)"
										class="form-control btn btn-info">
										<i class="ft-search"></i> BUSCAR
									</button>
								</div>
								<div class="form-group col-md-6 mb-1">
									<label for="nombreCompleto" class="label_control">DEPARTAMENTO
										/ PROVINCIA / DISTRITO </label>
									<div class="controls">
										<f:input type="text" disabled="true" value=""
											class="form-control" required="required"
											id="nombreUbigeoNacimiento"
											path="persona.ubigeoNacimiento.nombreUbigeo" />

									</div>
								</div>
								<div class="form-group col-md-3 mb-1">
									<label for="nombreCompleto" class="label_control">CORREO
										<span class="required">*</span>
									</label>
									<div class="controls">
										<f:input type="email" class="form-control" id="correo"
											path="persona.correo" />

									</div>
								</div>
							</div>
							<div class="row">
								<div class="form-group col-md-2 mb-3">
									<label for="nombreCompleto" class="label_control">UBIGEO
										DIRECCION <span class="required">*</span>
									</label>
									<div class="controls">
										<f:input type="text" class="form-control" required="required"
											disabled="true" id="ubigeoDireccion"
											path="persona.ubigeoDireccion.codigoUbigeo"
											onKeyPress="return soloNumeros(event)" maxlength="6" />

										<f:input type="hidden" id="codigoRegistroUbigeoDireccion"
											path="persona.ubigeoDireccion.codigoRegistro" />
									</div>
								</div>
								<div class="col-md-1">
									<button id="btnBuscarUbigeoDireccion" type="button"
										style="margin-top: 30px;" disabled="true"
										onclick="ubigeoCargarModal(2)"
										class="form-control btn btn-info">
										<i class="ft-search"></i> BUSCAR
									</button>
								</div>
								<div class="form-group col-md-6 mb-1">
									<label for="nombreCompleto" class="label_control">DEPARTAMENTO
										/ PROVINCIA / DISTRITO </label>
									<div class="controls">
										<f:input type="text" disabled="true" value=""
											class="form-control" required="required"
											id="nombreUbigeoDireccion"
											path="persona.ubigeoDireccion.nombreUbigeo" />

									</div>
								</div>
								<div class="col-md-3">
									<label for="nombreCompleto" class="label_control">DIRECCION
										<span class="required">*</span>
									</label>
									<div class="controls">
										<f:input type="text" class="form-control" required="required"
											disabled="true" id="personaDireccion"
											path="persona.direccion" />

									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-2">
									<f:input type="hidden" id="foto" path="persona.foto" />
									<!-- <img id="imgFotoPostulante"  src="data:image/jpg;base64,${postulanteBean.persona.foto}" height="75%" width="55%" alt="Image"/> -->

									<img id="imgFotoPaciente"
										style="width: 200px; height: 200px; cursor: pointer;"
										src="${pageContext.request.contextPath}/assets/img/fotoPersonaGenerico.gif" />

								</div>
								<div class="col-md-3">
									<div class="barCode">
										<header>
											<h5>CODIGO</h5>
										</header>
										<!-- <div id="barcode" 
									style="margin-top:20px; justify-content: center;align-items: center;" 
									width="145" height="100"> 
									</div> -->
										<div class="centrado">
											<img id="barcode1" class="centrado"/>

										</div>

									</div>

								</div>
								<div class="col-md-5" id="listadoDetallePostulanteEstadoFisico">
									<div class="label_title">ULTIMA DONACION FISICA DEL
										POSTULANTE :</div>
									<div class="table-responsive">
										<table class="table table-bordered" id="dataTable">
											<thead class="tabla_th">
												<tr>
													<th>N° POSTULANTE</th>
													<th>RESULTADO</th>
													<th>FECHA</th>
													<th>HTCO</th>
													<th width="80">GF</th>
													<th>TIPO DONACION</th>
													<th>PARENTESCO</th>
													<th>NOMBRE PACIENTE</th>
													<th>OBS. FISICA</th>
													<th>OBS. ENTREVISTA</th>
													<th>OBS. FLEBOTOMIA</th>
												</tr>
											</thead>
											<tbody id="idlistadoDetallePostulanteEstadoFisico"
												class="label_control">

											</tbody>
										</table>
									</div>
								</div>
								<div class="col-md-2">
									<label for="exampleInputName" id="lblcodigoFiliacionPaciente"
										class="label_control">ULTIMA FECHA DE DONACION</label>
									<f:input type="text" class="form-control" disabled="true"
										id="ultimaFechaDonancion" path="persona.ultimaFechaDonacion" />
								</div>
							</div>
							<div class="text-right"
								style="margin-top: 0px; margin-bottom: 0px;">
								<button id="btnImprimirTicket" type="button"
									onclick="printDiv('areaImprimir')" class="btn btn-outline-dark:hover"
									disabled="true">
									<i class="fa fa-print"></i> IMPRIMIR TICKET
								</button>
								<a
									href="${pageContext.request.contextPath}/bancoController/nuevoPostulante"
									class="btn btn-secondary" title=""> <i class="fa icon-plus"></i>
									NUEVO
								</a>

								<button id="btnGuardarPostulante" type="submit"
									onclick="guardarPostulante()" class="btn btn-primary">
									<i class="fa fa-floppy-o"></i> GUARDAR
								</button>
							 
							</div>
						</div>
					</div>
				</div>
				 
				<div  id="areaImprimir" style="display: none; width: 200px; height: 170px;"  class="ancho-tabla"> 
					    <table style="width: 200px; height: 170px;"  class="ancho-tabla"> 
					      <tbody id="idBodyTicket">
					       <tr> 
					       		 <td class="centrado"> <div><img  style="width: 190px; height: 163px;"  id="barcode1"/> </div></td> 
					        </tr>
					        
					        <tr> 
					         <td class="producto centrado">${postulanteBean.persona.apellidoPaterno} ${postulanteBean.persona.apellidoMaterno} ${postulanteBean.persona.primerNombre}</td>
					        </tr> 
					      </tbody>
					    </table>
					   
					  </div>   
					 
			</f:form>
			<f:form id="frmRegistro" class="form-horizontal" role="form"
				method="POST"
				action="${pageContext.request.contextPath}/bancoController/listadoPostulante"> 
				<button type="submit" style="display: none" id="btnListado">Click
					me</button>
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

			<div class="modal fade text-xs-left" id="modalTamizaje" tabindex="-2"
				role="dialog" aria-labelledby="myModalLabel35" data-dismiss="modal"
				aria-hidden="true" aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content" id="modalmodalTamizaje"></div>
				</div>
			</div>

			<div class="modal fade text-xs-left" id="modalTicket" tabindex="-2"
				role="dialog" aria-labelledby="myModalLabel35" data-dismiss="modal"
				aria-hidden="true" aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content" id="modalmodalTicket"></div>
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
		<!-- Page level plugin JavaScript
		<script
			src="${pageContext.request.contextPath}/app-assets/vendor/datatables/jquery.dataTables.js"></script>
		<script
			src="${pageContext.request.contextPath}/app-assets/vendor/datatables/dataTables.bootstrap4.js"></script>
			
		<script
			src="${pageContext.request.contextPath}/app-assets/js/sb-admin-datatables.min.js"></script>	
		
		<script type="text/javascript" 
 				src="${pageContext.request.contextPath}/app-assets/js/scripts/barcode/jquery-barcode.min.js"></script>
 					
		<!-- Custom scripts for all pages-->
		<script
			src="${pageContext.request.contextPath}/app-assets/js/sb-admin.min.js"></script>
		<!-- Custom scripts for this page-->

		<!-- Custom scripts for all pages-->
		<script src="http://malsup.github.io/jquery.blockUI.js"></script>

		<script
			src="${pageContext.request.contextPath}/app-assets/js/scripts/dist/JsBarcode.all.js"></script>
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
function crearBoton(){
	
	  var inputTag = document.createElement("div");              
	    inputTag.innerHTML = 
	    	"<input type = 'button' id='btnLlamarModificar' value = 'oooh'"+
	    	"onClick =javascript:modificarElementoGenerico(\'/bancoController/modificarPostulante\',\'20\');>";    
	    	
	    document.body.appendChild(inputTag);
	  //  "onclick=\"especialidadCargarModal('"+[objCIEX.codReg]+"');\""+
		$("#btnLlamarModificar").trigger("click");
}
function printDiv(nombreDiv) {
	
	
    var contenido= document.getElementById(nombreDiv).innerHTML;
    var contenidoOriginal= document.body.innerHTML;

    document.body.innerHTML = contenido;

    window.print();

    document.body.innerHTML = contenidoOriginal;
    
    var codigoPostulante = $("#codigoPostulante").val();
    var dni = $("#nroDocumentoPaciente").val();
	if (codigoPostulante.length > 0) {
		
	}
    
}

	Number.prototype.zeroPadding = function() {
		var ret = "" + this.valueOf();
		return ret.length == 1 ? "0" + ret : ret;
	};

	$(document).ready(function() {
		$("#nroDocumentoPaciente").focus();

		var codigoPostulante = $("#codigoPostulante").val();
		if (codigoPostulante.length > 0) {
			document.getElementById('btnImprimirTicket').disabled = false;
			
			JsBarcode("#barcode1", codigoPostulante);
			var dni = $("#nroDocumentoPaciente").val();
			var tipoDoc = $("#tipoDocumentoPaciente").val();
			console.log(dni);
			foto(tipoDoc, dni);
		}

	});

	function runScript(e) {
		//See notes about 'which' and 'key'
		if (e.keyCode == 13) {
			buscarPersonaWebService();
			return false;
		}
	}

	$.fn.delayPasteKeyUp = function(fn, ms) {
		var timer = 0;
		$(this).on("propertychange input", function() {
			clearTimeout(timer);
			timer = setTimeout(fn, ms);
		});
	};

	$(document).ready(
			function() {
				$("#nroDocumentoPaciente").delayPasteKeyUp(
						function() {
							$("#respuesta").append(
									"Producto registrado: "
											+ $("#nroDocumentoPaciente").val()
											+ "");

						}, 200);
			});
</script>



</html>










