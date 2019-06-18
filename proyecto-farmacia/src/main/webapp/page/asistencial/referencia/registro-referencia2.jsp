<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<!DOCTYPE html>
<html lang="en" data-textdirection="ltr" class="loading">
<head>
<meta http-equiv="Content-Type" content="text/html" ; charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
<meta name="description"
	content="Stack admin is super flexible, powerful, clean &amp; modern responsive bootstrap 4 admin template with unlimited possibilities.">
<meta name="keywords"
	content="admin template, stack admin template, dashboard template, flat admin template, responsive admin template, web app">
<meta name="author" content="PIXINVENT">
<title>Referencia</title>
<link
	href="https://fonts.googleapis.com/css?family=Montserrat:300,300i,400,400i,500,500i%7COpen+Sans:300,300i,400,400i,600,600i,700,700i"
	rel="stylesheet">
<!-- BEGIN VENDOR CSS-->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/css/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/fonts/feather/style.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/fonts/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/fonts/flag-icon-css/css/flag-icon.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/vendors/css/extensions/pace.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/vendors/css/extensions/sweetalert.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/vendors/css/tables/datatable/dataTables.bootstrap4.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/vendors/css/forms/selects/select2.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/vendors/css/extensions/toastr.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/vendors/css/tables/extensions/responsive.dataTables.min.css">
<!-- END VENDOR CSS-->
<!-- BEGIN STACK CSS-->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/css/bootstrap-extended.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/css/app.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/css/colors.css">
<!-- END STACK CSS-->
<!-- BEGIN Page Level CSS-->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/css/core/menu/menu-types/vertical-menu.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/css/core/menu/menu-types/vertical-overlay-menu.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/fonts/simple-line-icons/style.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/fonts/font-awesome/css/font-awesome.min.css">
<!-- END Page Level CSS-->
<!-- BEGIN Custom CSS-->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/assets/css/base-natigu.css">

<link
	href="${pageContext.request.contextPath}/app-assets/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Custom fonts for this template-->
<link
	href="${pageContext.request.contextPath}/app-assets/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<!-- Page level plugin CSS-->
<link
	href="${pageContext.request.contextPath}/app-assets/vendor/datatables/dataTables.bootstrap4.css"
	rel="stylesheet">
<!-- Custom styles for this template-->
<link
	href="${pageContext.request.contextPath}/app-assets/css/sb-admin.css"
	rel="stylesheet">

<link rel="shortcut icon" type="image/x-icon"
	href="${pageContext.request.contextPath}/app-assets/images/ico/iconHNCH.ico">
</head>
<script>
function horaDinamica(){
var fecha= new Date();
var horas= fecha.getHours();
var minutos = fecha.getMinutes();
var segundos = fecha.getSeconds();
document.getElementById('contenedor').innerHTML=''+horas+':'+minutos+':'+Segundos+'';
setTimeout('horaDinamica()',1000);


}
</script>

<script language="JavaScript"> 

function show5(){ 
if (!document.layers&&!document.all) 
return; 

var Digital=new Date(); 
var hours=Digital.getHours(); 
var minutes=Digital.getMinutes(); 
var seconds=Digital.getSeconds(); 
var dn="AM"; 
if (hours>12){ 
dn="PM"; 
hours=hours-12; 
} 
if (hours==0) 
hours=12; 
if (minutes<=9) 
minutes="0"+minutes; 
if (seconds<=9) 
seconds="0"+seconds; 

myclock="<font size='5' face='Arial' ><b><font size='2'>Hora Actual: </font>"+hours+":"+minutes+":" 
+seconds+" "+dn+"</b></font>"; 

if (document.layers){ 
document.layers.liveclock.document.write(myclock); 
document.layers.liveclock.document.close(); 
} 
else if (document.all) 
liveclock.innerHTML=myclock 
setTimeout("show5()",1000) 
} 


</script>

<body onLoad="myOnLoad()" data-open="click" data-menu="vertical-menu"
	data-col="2-columns"
	class="vertical-layout vertical-menu 2-columns  fixed-navbar">

	<!-- navbar-fixed-top-->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top"
		id="mainNav">
		<a class="navbar-brand" href="index.html">SISREFCON</a>
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
				<ol class="breadcrumb">
				        <li class="breadcrumb-item">
				          <a href="#">Dashboard</a>
				        </li>
				        <li class="breadcrumb-item active">My Dashboard</li>
				      </ol>
				      <!-- Icon Cards-->
				      <div class="row">
						<div class="breadcrumb-wrapper col-xs-12">

							<table
								style="text-align: left; margin-left: auto; margin-right: auto;"
								width="100%" cellpadding="0" cellspacing="0">
								<tbody>
									<tr>
										<td><a
											src="${pageContext.request.contextPath}/assets/img/logo_salud_norte.png"
											imageanchor="1"><img border="0" height="50"
												src="${pageContext.request.contextPath}/assets/img/logo_salud_norte.png"
												width="350" /></a></td>
										<td><a
											src="${pageContext.request.contextPath}/assets/img/palabra_hoja_ref.png"
											imageanchor="1"><img border="0" height="40"
												src="${pageContext.request.contextPath}/assets/img/palabra_hoja_ref.png"
												width="300" /></a></td>
										<td style="border-style: solid;" width="200">
											<H1>0113908</H1>
										</td>
									</tr>
								</tbody>
							</table>


							<div>

								<ol class="breadcrumb">
									<h6
										class="card-subtitle line-on-side text-muted text-xs-center font-small-3 mb-0 pb-0 pt-2 ml-2 mr-2">
										<span>
											<DIV ALIGN=left>
												<strong>1.-DATOS GENERALES </strong>
										</span>
									</h6>
									<br>

									<table
										style="text-align: left; margin-left: auto; margin-right: auto;"
										width="100%" cellpadding="0" cellspacing="0">
										<tbody>
											<tr>
												<td width="33%" align="center"><b class="TituloTexto">Fecha:</b><br>
													<script>var f = new Date();
			document.write(f.getDate() + "/" + (f.getMonth() +1) + "/" + f.getFullYear());</script>
												</td>
												<td><span width="33%" align="center"> <b
														class="TituloTexto">Hora </b><br> <input
														id="contenedor" name="contenedor" size="1" title="Hora"
														style="width: 35px;">
												</span></td>
												<td style="width: 179px;"><span width="33%"
													align="center"> <b class="TituloTexto">
															Asegurado </b><br>
														<form style="width: 111px;">
															<label class="radio-inline"> <input
																class="custom-control custom-radio" type="radio"
																name="optradio">Si
															</label> <label class="radio-inline"> <input
																class="custom-control custom-radio" type="radio"
																name="optradio">No
															</label>
															</div>
															</div>

														</form>
												</span></td>
												<td width="33%" align="center" style="width: 232px;"><b
													class="TituloTexto">Tipo de Seguro:</b><br> <select
													class="form-control" name="td" size="1" width="180"
													style="width: 199px;">
														<option value=0>SELECCIONE

															<option value=1>SIS Gratuito
														
														<option value=2>SIS Micro-Empresas
														
														<option value=3>SIS Emprendedor
														
														<option value=4>SIS Independiente
												
												</select></td>
												<td style="width: 179px;"><span width="33%"
													align="center"> <b class="TituloTexto"> Planes
															de Atención SIS</b><br>
														<form style="width: 111px;">
															<label class="radio-inline"> <input
																class="custom-control custom-radio" type="radio"
																name="optradio">A
															</label> <label class="radio-inline"> <input
																class="custom-control custom-radio" type="radio"
																name="optradio">B
															</label> <label class="radio-inline"> <input
																class="custom-control custom-radio" type="radio"
																name="optradio">C
															</label> <label class="radio-inline"> <input
																class="custom-control custom-radio" type="radio"
																name="optradio">D
															</label> <label class="radio-inline"> <input
																class="custom-control custom-radio" type="radio"
																name="optradio">E
															</label>

														</form>
												</span></td>
											</tr>
										</tbody>
									</table>

									<div class="card-body">

										<h6
											class="card-subtitle line-on-side text-muted text-xs-center font-small-3 mb-0 pb-0 pt-2 ml-2 mr-2">
											<span>
												<DIV ALIGN=left>
													<strong>2.-IDENTIFICACIÓN DEL USUARIO </strong>
											
											</span>
										</h6>
										<br>
										<div class="row">

											<div class="input-group">
												<label for="name">Establecimiento de Origen :</label> <span
													class="input-group-btn"> <input type="text"
													class="form-control" style="width: 105px;">
												</span> <input type="text" class="form-control"
													style="width: 339px;"> <span
													class="input-group-btn">
													<button class="btn btn-secondary" type="button">Buscar</button>
												</span>
											</div>

										</div>
									</div>

									<div class="card-body">
										<div class="row">
											<div class="input-group">
												<label for="name">Establecimiento de Destino :</label> <span
													class="input-group-btn"> <input type="text"
													name="00007633" value="00007633" class="form-control"
													style="width: 99px;">
												</span> <input type="text" class="form-control"
													value="NACIONAL CAYETANO HEREDIA" style="width: 339px;">
												<span class="input-group-btn">
													<button class="btn btn-secondary" id="Button3"
														type="button">Buscar</button>
												</span>
											</div>

										</div>
									</div>



								</ol>
								<ol>
									<h6
										class="card-subtitle line-on-side text-muted text-xs-center font-small-3 mb-0 pb-0 pt-2 ml-2 mr-2">
										<span>
											<DIV ALIGN=left>
												<strong>2.-IDENTIFICACIÓN DEL USUARIO </strong>
										
										</span>
									</h6>
									<br>

									<table
										style="text-align: left; margin-left: auto; margin-right: auto;"
										width="100%" cellpadding="0" cellspacing="0">
										<tbody>
											<tr>
												<td width="33%" align="center" style="width: 232px;"><b
													class="TituloTexto">Tipo de Documento:</b><br> <select
													class="form-control" name="td" size="1" width="180"
													style="width: 199px;">
														<option value=0>SELECCIONE
														
														<option value=1>DNI
														
														<option value=2>Carnet de Extranjer&iacute;a
												
												</select></td>
												<td style="width: 262px;"><span width="38%"
													align="center"> <b class="TituloTexto">Nro Doc.
													</b><br> <input type="text" id="numDocPersona_busqdato"
														name="numDocPersona_busqdato" pattern="[0-9]{8}"
														maxlength="8" class="form-control form-control-lg"
														name="nd" size="50" title="Nro Documento"
														style="width: 190px;">
														<button class="btn btn-secondary" id="Button3"
															onclick="javascript:buscarPersonaPorDocumentoOperador();"
															type="button">Buscar</button>
												</span></td>
												<td style="width: 222px;"><span width="38%"
													align="center"> <b class="TituloTexto">
															Afiliación SIS </b><br> <input type="text"
														id="edadAniosPersona_dato" name="edadAniosPersona_dato"
														onblur="nif(this.value)"
														class="form-control form-control-lg" name="codAfSIS"
														size="75" title="CodigoAfiSIS" style="width: 211px;">
												</span></td>
												<td style="width: 235px;"><span width="38%"
													align="center"> <b class="TituloTexto">Nro. HC </b><br>
														<input type="text" id="fechaNac2_dato"
														name="fechaNac2_dato" class="form-control form-control-lg"
														name="nroHC" size="45" title="NroHistoria"
														style="width: 195px;">
												</span></td>
											</tr>
										</tbody>
									</table>

									<table
										style="text-align: left; margin-left: auto; margin-right: auto;"
										width="100%" cellpadding="0" cellspacing="0">
										<tbody>
											<tr>
												<td width="33%" align="center"><b class="TituloTexto">Apellido
														Paterno:</b><br> <input type="text"
													id="apellidoPaternoPersona_dato"
													name="apellidoPaternoPersona_dato"
													class="form-control form-control-lg" size="25"
													title="Apellido paterno"></td>
												<td><span width="33%" align="center"> <b
														class="TituloTexto">Apellido Materno </b><br> <input
														type="text" id="apellidoMaternoPersona_dato"
														name="apellidoMaternoPersona_dato"
														class="form-control form-control-lg" name="Apemat"
														size="25" title="Apellido Materno">
												</span></td>
												<td><span width="33%" align="center"> <b
														class="TituloTexto">Primer Nombre </b><br> <input
														type="text" id="primerNombrePersona_dato"
														name="primerNombrePersona_dato"
														class="form-control form-control-lg" name="PrimNom"
														size="25" title="Primer Nombre">
												</span></td>
												<td><span width="33%" align="center"> <b
														class="TituloTexto">Segundo Nombre </b><br> <input
														type="text" id="segundoNombrePersona_dato"
														name="segundoNombrePersona_dato"
														class="form-control form-control-lg" name="SeguNom"
														size="25" title="Segundo Nombre">
												</span></td>
											</tr>
											<tr>
												<td><span width="33%" align="center"> <b
														class="TituloTexto">Sexo </b><br>
														<form>
															<label class="radio-inline"> <input type="radio"
																name="optradio" id="male">Masculino
															</label> <label class="radio-inline"> <input type="radio"
																name="optradio" id="female">Femenino
															</label>

														</form>
												</span></td>
												<td><b class="TituloTexto">Edad </b> <br> <span
													width="30%" align="center"> <b class="TituloTexto">Años
													</b> <input type="text" id="edadAniosPersona_dato"
														name="edadAniosPersona_dato" size="1" title="Edad">
												</span> <span width="30%" align="center"> <b
														class="TituloTexto">Mes </b> <input type="text"
														id="edadMesesPersona_dato" name="edadMesesPersona_dato"
														size="1" title="EdadMeses">
												</span> <span width="30%" align="center"> <b
														class="TituloTexto">Dias </b> <input type="text"
														id="edadDiasPersona_dato" name="edadDiasPersona_dato"
														size="1" title="EdadDias">
												</span></td>
												<td colspan="2"><span width="33%" align="center">
														<b class="TituloTexto">Dirección </b><br> <input
														type="text" id="direccion_dato" name="direccion_dato"
														class="form-control form-control-lg" name="direccion"
														size="50" title="Direccion" style="width: 398px;">
												</span></td>
											</tr>
											<tr>
												<td colspan="2"><span width="33%" align="center">
														<b class="TituloTexto">Distrito </b><br> <input
														type="text" id="distritoPersona_dato"
														name="distritoPersona_dato"
														class="form-control form-control-lg" name="distrito"
														size="50" title="Distrito" style="width: 398px;">
												</span></td>
												<td colspan="2"><span width="33%" align="center">
														<b class="TituloTexto">Departamento </b><br> <input
														type="text" id="departamentoPersona_dato"
														name="departamentoPersona_dato"
														class="form-control form-control-lg" name="departamento"
														size="50" title="Departamento" style="width: 398px;">
												</span></td>
											</tr>
										</tbody>
									</table>


								</ol>



								<div class="row">


									<ol class="breadcrumb">

										<h6
											class="card-subtitle line-on-side text-muted text-xs-center font-small-3 mb-0 pb-0 pt-2 ml-2 mr-2">
											<span>
												<DIV ALIGN=left>
													<strong>3.-RESUMEN DE HISTORIA CLÍNICA </strong>
											
											</span>
										</h6>


										<h6>
											<span> <strong>Anamnesis</strong>
											</span>
											<TEXTAREA NAME="textareaAnamnesis" ROWS="4"
												style="width: 696px; height: 66px"></TEXTAREA>
										</h6>
										<h6>
											<span> <strong>Exámen Físico</strong>
											</span>
											<TEXTAREA NAME="textareaExamenFisico" ROWS="4"
												style="width: 683px; height: 66px"></TEXTAREA>
										</h6>
										<h6>
											<span> <strong>Exámenes Auxiliares</strong>
											</span>
											<TEXTAREA NAME="textareaExamenesAuxiliares" ROWS="4"
												style="width: 685px; height: 68px"></TEXTAREA>
										</h6>
										<h6>
											<span> <strong>Diagnóstico</strong>
											</span>
											<TEXTAREA NAME="textareaExamenesAuxiliares" ROWS="2"
												style="width: 502px; height: 68px"></TEXTAREA>
										</h6>
										<br>
										<h6>
											<span> <strong>Diagnóstico</strong>
											</span> <select name="diagnostico" id="diagnostico"
												class="selection" multiple="multiple"
												style="width: 509px; height: 26px">
												<option>Seleccione</option>
											</select>
										</h6>
										<h6>
											<span> <strong>Tratamiento</strong>
											</span>
											<TEXTAREA NAME="textareaExamenesAuxiliares" ROWS="2"
												style="width: 502px; height: 68px"></TEXTAREA>
										</h6>

									</ol>





									<div class="row">


										<ol class="breadcrumb">

											<h6
												class="card-subtitle line-on-side text-muted text-xs-center font-small-3 mb-0 pb-0 pt-2 ml-2 mr-2">
												<span>
													<DIV ALIGN=left>
														<strong>3.-RESUMEN DE HISTORIA CLÍNICA </strong>
												
												</span>
											</h6>

											<h6>
												<span> <strong>Anamnesis</strong>
												</span>
												<TEXTAREA NAME="textareaAnamnesis" ROWS="4"
													style="width: 696px; height: 66px"></TEXTAREA>
											</h6>
											<span> <strong>Exámen Físico</strong>
											</span>
											<div class="container" style="width: 918px;">
												<table class="table table-bordered" cellspacing=0
													cellpadding=0 style="width: 1312px;">
													<thead style="width: 1320px;">
														<tr style="width: 1299px;">
															<th style="width: 288px;">Descripción</th>
															<th style="width: 65px;">Siglas</th>
															<th style="width: 168px;">unidad de Medida</th>
															<th style="width: 171px;">Valor Obtenido</th>
														</tr>
													</thead>
													<tbody>
														<tr>
															<td value="000001" style="width: 276px;">PESO</td>
															<td>W</td>
															<td align="center" style="width: 149px;">KG</td>
															<td style="width: 162px;"><input type="text"
																name="user_date" id="user_date" />
														
														</tr>

														<tr>
															<td value="000002">TALLA</td>
															<td>T</td>
															<td align="center">CM</td>
															<td><input type="text" name="user_date"
																id="user_date" />
														
														</tr>

														<tr>
															<td value="000003">PRESION ARTERIAL</td>
															<td>PA</td>
															<td align="center">mmHg</td>
															<td><input type="text" name="user_date"
																id="user_date" />
														
														</tr>

														<tr>
															<td value="000004">PRESION ARTERIAL MEDIA</td>
															<td>PAM</td>
															<td align="center">mmHg</td>
															<td><input type="text" name="user_date"
																id="user_date" />
														
														</tr>

														<tr>
															<td value="000005">FRECUENCIA CARDIACA</td>
															<td>FC</td>
															<td align="center">LATIDOS X MIN</td>
															<td><input type="text" name="user_date"
																id="user_date" />
														
														</tr>
														<tr>
															<td value="000006">FRECUENCIA RESPIRATORIA</td>
															<td>FR</td>
															<td align="center">RESP X MIN</td>
															<td><input type="text" name="user_date"
																id="user_date" />
														
														</tr>

														<tr>
															<td value="000007">TEMPERATURA</td>
															<td>TEMP</td>
															<td align="center">°C</td>
															<td><input type="text" name="user_date"
																id="user_date" />
														
														</tr>

														<tr>
															<td value="000008">FRACCION INSPIRATORIA DE OXIGENO</td>
															<td>FIO2</td>
															<td align="center">%</td>
															<td><input type="text" name="user_date"
																id="user_date" />
														
														</tr>
														<tr>
															<td value="000009">SATURACION OXIGENO</td>
															<td>SAT02</td>
															<td align="center">%</td>
															<td><input type="text" name="user_date"
																id="user_date" />
														
														</tr>

														<tr>
															<td value="000010">PRESION ARTERIAL DE OXIGENO</td>
															<td>PA02</td>
															<td align="center">mmHg</td>
															<td><input type="text" name="user_date"
																id="user_date" />
														
														</tr>

														<tr>
															<td value="000011">PRESION VENOSA CENTRAL</td>
															<td>PVC</td>
															<td align="center">mmHg</td>
															<td><input type="text" name="user_date"
																id="user_date" />
														
														</tr>

														<tr>
															<td value="000012">FLUJO URINARIO</td>
															<td>FU</td>
															<td align="center">ml/min</td>
															<td><input type="text" name="user_date"
																id="user_date" />
														
														</tr>

														<tr>
															<td value="000013">PRESION ARTERIAL SISTÓLICA</td>
															<td>PA SIS</td>
															<td align="center">mmHg</td>
															<td><input type="text" name="user_date"
																id="user_date" />
														
														</tr>
														<tr>
															<td value="000014">PRESION ARTERIAL DIASTÓLICA</td>
															<td>PA DIA</td>
															<td align="center">mmHg</td>
															<td><input type="text" name="user_date"
																id="user_date" />
														
														</tr>

													</tbody>
												</table>
											</div>
											<h6>
												<span> <strong>Exámenes Auxiliares</strong>
												</span>
												<TEXTAREA NAME="textareaExamenesAuxiliares" ROWS="4"
													style="width: 685px; height: 68px"></TEXTAREA>
											</h6>
											<h6>
												<span> <strong>Diagnóstico</strong>
												</span>
												<TEXTAREA NAME="textareaExamenesAuxiliares" ROWS="2"
													style="width: 502px; height: 68px"></TEXTAREA>
											</h6>
											<br>
											<h6>
												<span> <strong>Diagnóstico</strong>
												</span> <select name="diagnostico" id="diagnostico"
													class="selection" multiple="multiple"
													style="width: 509px; height: 26px">
													<option>Seleccione</option>
												</select>
											</h6>
											<h6>
												<span> <strong>Tratamiento</strong>
												</span>
												<TEXTAREA NAME="textareaExamenesAuxiliares" ROWS="2"
													style="width: 502px; height: 68px"></TEXTAREA>
											</h6>

										</ol>





									</div>




									<h6
										class="card-subtitle line-on-side text-muted text-xs-center font-small-3 mb-0 pb-0 pt-2 ml-2 mr-2">
										<span>
											<DIV ALIGN=left>
												<strong>4.-DATOS DE LA REFERENCIA </strong>
										
										</span>
									</h6>
									<br>

									<table
										style="text-align: left; margin-left: auto; margin-right: auto;"
										width="100%" cellpadding="0" cellspacing="0">
										<tbody>
											<tr>
												<td style="width: 610px;"><span width="33%"
													align="center"> <b class="TituloTexto"> UPS
															destino de la Referencia </b><br>
														<form style="width: 600px; height: 54px">
															<label class="radio-inline"> <input
																class="custom-control custom-radio" type="radio"
																name="optradio">Emergencia
															</label> <label class="radio-inline"> <input
																class="custom-control custom-radio" type="radio"
																name="optradio">Consulta Externa
															</label> <label class="radio-inline"> <input
																class="custom-control custom-radio" type="radio"
																name="optradio">Apoyo al Diagnóstico
															</label>
														</form>
												</span></td>
												<td width="33%" align="center" style="width: 505px;"><b
													class="TituloTexto">Especialidad</b><br>
													<form>
														<select name="selection[]" class="selection"
															multiple="multiple" style="width: 509px; height: 26px">
															<option value="300101">ANESTESIOLOGIA</option>
															<option value="300201">CARDIOLOGIA</option>
															<option value="300301">CIRUGIA</option>
															<option value="300501">CIRUGIA ONCOLOGICA</option>
															<option value="300602">CIRUGIA RECONSTRUCTIVA</option>
															<option value="300701">CIRUGIA PEDIATRICA</option>
															<option value="300803">CIRUGIA TORACICA Y
																CARDIOVASCULAR</option>
															<option value="300901">DERMATOLOGIA</option>
															<option value="301001">ENDOCRINOLOGIA</option>
															<option value="301101">ENFERMEDADES INFECCIOSAS
																/ INFECTOLOGIA</option>
															<option value="301104">MEDICINA TROPICAL</option>
															<option value="301204">INMUNIZACIONES</option>
															<option value="301302">GASTROENTEROLOGIA</option>
															<option value="301502">GERIATRIA</option>
															<option value="301605">GINECOLOGIA</option>
															<option value="301607">GINECOLOGÍA Y OBSTETRICIA</option>
															<option value="301608">GINECOLOGIA Y OBSTETRICIA
																DE LA NIÑA Y LA ADOLESCENTE</option>
															<option value="302102">MEDICINA DE FAMILIA</option>
															<option value="302201">MEDICINA REHABILITACION</option>
															<option value="302401">MEDICINA INTERNA</option>
															<option value="302601">MEDICINA ONCOLOGICA</option>
															<option value="302701">NEFROLOGIA</option>
															<option value="302803">NEUMOLOGIA</option>
															<option value="302903">NEUROCIRUGIA</option>
															<option value="303008">NEUROLOGIA</option>
															<option value="303101">NUTRICION</option>
															<option value="303203">OBSTETRICIA</option>
															<option value="303304">ODONTOLOGIA GENERAL</option>
															<option value="303305">ODONTOLOGIA PEDIATRICA</option>
															<option value="303306">CIRUGIA BUCO MAXILOFACIAL</option>
															<option value="303311">MEDICINA Y PATOLOGIA
																ESTOMATOLOGICA</option>
															<option value="303312">ATENCION ODONTOLOGICA DE
																PACIENTES ESPECIALES</option>
															<option value="303408">OFTALMOLOGIA</option>
															<option value="303507">ORTOPEDIA</option>
															<option value="303510">TRAUMATOLOGIA</option>
															<option value="303603">OTORRINOLARINGOLOGIA</option>
															<option value="303701">CARDIOLOGIA PEDIATRICA</option>
															<option value="303703">ENDOCRINOLOGIA PEDIATRICA</option>
															<option value="303704">GASTROENTEROLOGIA
																PEDIATRICA</option>
															<option value="303705">INFECTOLOGIA PEDIATRICA</option>
															<option value="303706">NEFROLOGIA PEDIATRICA</option>
															<option value="303707">NEONATOLOGIA</option>
															<option value="303708">NEUMOLOGIA PEDIATRICA</option>
															<option value="303709">NEUROLOGIA PEDIATRICA</option>
															<option value="303710">ONCOLOGIA PEDIATRICA</option>
															<option value="303712">PEDIATRIA</option>
															<option value="303802">PSICOLOGIA</option>
															<option value="303901">PSIQUIATRIA</option>
															<option value="304001">REUMATOLOGIA</option>
															<option value="303704">GASTROENTEROLOGIA
																PEDIATRICA</option>
															<option value="304101">UROLOGIA</option>
															<option value="420102">HEMATOLOGIA</option>
															<option value="430103">GENETICA PEDIATRICA
																(GENETICA)</option> =======
															</div> >>>>>>> .r1825

															<h6
																class="card-subtitle line-on-side text-muted text-xs-center font-small-3 mb-0 pb-0 pt-2 ml-2 mr-2">
																<span>
																	<DIV ALIGN=left>
																		<strong>4.-DATOS DE LA REFERENCIA </strong>
																
																</span>
															</h6>
															<br>

															<table
																style="text-align: left; margin-left: auto; margin-right: auto;"
																width="100%" cellpadding="0" cellspacing="0">
																<tbody>
																	<tr>
																		<td style="width: 610px;"><span width="33%"
																			align="center"> <b class="TituloTexto">
																					UPS destino de la Referencia </b><br>
																				<form style="width: 600px; height: 54px">
																					<label class="radio-inline"> <input
																						class="custom-control custom-radio" type="radio"
																						name="optradio">Emergencia
																					</label> <label class="radio-inline"> <input
																						class="custom-control custom-radio" type="radio"
																						name="optradio">Consulta Externa
																					</label> <label class="radio-inline"> <input
																						class="custom-control custom-radio" type="radio"
																						name="optradio">Apoyo al Diagnóstico
																					</label>
																				</form>
																		</span></td>
																		<td width="33%" align="center" style="width: 505px;"><b
																			class="TituloTexto">Especialidad</b><br>
																			<form>
																				<select name="selection[]" class="selection"
																					onkeypress="pulsar(event)" id="comboEspecialidad"
																					multiple="multiple"
																					style="width: 509px; height: 26px">
																					<option value="300101">ANESTESIOLOGIA</option>
																					<option value="300201">CARDIOLOGIA</option>
																					<option value="300301">CIRUGIA</option>
																					<option value="300501">CIRUGIA ONCOLOGICA</option>
																					<option value="300602">CIRUGIA
																						RECONSTRUCTIVA</option>
																					<option value="300701">CIRUGIA PEDIATRICA</option>
																					<option value="300803">CIRUGIA TORACICA Y
																						CARDIOVASCULAR</option>
																					<option value="300901">DERMATOLOGIA</option>
																					<option value="301001">ENDOCRINOLOGIA</option>
																					<option value="301101">ENFERMEDADES
																						INFECCIOSAS / INFECTOLOGIA</option>
																					<option value="301104">MEDICINA TROPICAL</option>
																					<option value="301204">INMUNIZACIONES</option>
																					<option value="301302">GASTROENTEROLOGIA</option>
																					<option value="301502">GERIATRIA</option>
																					<option value="301605">GINECOLOGIA</option>
																					<option value="301607">GINECOLOGÍA Y
																						OBSTETRICIA</option>
																					<option value="301608">GINECOLOGIA Y
																						OBSTETRICIA DE LA NIÑA Y LA ADOLESCENTE</option>
																					<option value="302102">MEDICINA DE FAMILIA</option>
																					<option value="302201">MEDICINA
																						REHABILITACION</option>
																					<option value="302401">MEDICINA INTERNA</option>
																					<option value="302601">MEDICINA ONCOLOGICA</option>
																					<option value="302701">NEFROLOGIA</option>
																					<option value="302803">NEUMOLOGIA</option>
																					<option value="302903">NEUROCIRUGIA</option>
																					<option value="303008">NEUROLOGIA</option>
																					<option value="303101">NUTRICION</option>
																					<option value="303203">OBSTETRICIA</option>
																					<option value="303304">ODONTOLOGIA GENERAL</option>
																					<option value="303305">ODONTOLOGIA
																						PEDIATRICA</option>
																					<option value="303306">CIRUGIA BUCO
																						MAXILOFACIAL</option>
																					<option value="303311">MEDICINA Y
																						PATOLOGIA ESTOMATOLOGICA</option>
																					<option value="303312">ATENCION
																						ODONTOLOGICA DE PACIENTES ESPECIALES</option>
																					<option value="303408">OFTALMOLOGIA</option>
																					<option value="303507">ORTOPEDIA</option>
																					<option value="303510">TRAUMATOLOGIA</option>
																					<option value="303603">OTORRINOLARINGOLOGIA</option>
																					<option value="303701">CARDIOLOGIA
																						PEDIATRICA</option>
																					<option value="303703">ENDOCRINOLOGIA
																						PEDIATRICA</option>
																					<option value="303704">GASTROENTEROLOGIA
																						PEDIATRICA</option>
																					<option value="303705">INFECTOLOGIA
																						PEDIATRICA</option>
																					<option value="303706">NEFROLOGIA
																						PEDIATRICA</option>
																					<option value="303707">NEONATOLOGIA</option>
																					<option value="303708">NEUMOLOGIA
																						PEDIATRICA</option>
																					<option value="303709">NEUROLOGIA
																						PEDIATRICA</option>
																					<option value="303710">ONCOLOGIA
																						PEDIATRICA</option>
																					<option value="303712">PEDIATRIA</option>
																					<option value="303802">PSICOLOGIA</option>
																					<option value="303901">PSIQUIATRIA</option>
																					<option value="304001">REUMATOLOGIA</option>
																					<option value="303704">GASTROENTEROLOGIA
																						PEDIATRICA</option>
																					<option value="304101">UROLOGIA</option>
																					<option value="420102">HEMATOLOGIA</option>
																					<option value="430103">GENETICA PEDIATRICA
																						(GENETICA)</option>

																				</select>
																				<button type="button"
																					onclick="arregloEspecialidades()">verificar</button>
																			</form></td>
																	</tr>
																</tbody>
															</table>

															<ol class="breadcrumb">
																<div class="btn-group btn-group-lg" role="group"
																	aria-label="Basic example">
																	<button type="button" class="btn btn-secondary">
																		<span class="glyphicon glyphicon-floppy-save"></span>Guardar
																	</button>
																	<button type="button" class="btn btn-secondary">Modificar</button>
																	<button type="button" class="btn btn-secondary">Imprimir</button>
																</div>
															</ol>


															</div>
															</div>
															</div>
															<div class="content-body">
																<!-- Analytics spakline & chartjs  -->
															<section id="configuration">
																<div class="row">
																		<div class="col-xs-12">
																			<div class="card">
																				<div class="card-header">
																					<h4 class="card-title">Indicadores</h4>
																					<a class="heading-elements-toggle"><i
																					class="fa fa-ellipsis-v font-medium-3"></i></a>
																					<div class="heading-elements">
																						<ul class="list-inline mb-0">
																							<li><a data-action="collapse"><i
																								class="ft-minus"></i></a></li>
																							<li><a data-action="reload"><i
																								class="ft-rotate-cw"></i></a></li>
																							<li><a data-action="expand"><i
																								class="ft-maximize"></i></a></li>
																						</ul>
																					</div>
																				</div>
																				<div class="card-body collapse in">
																					<div class="card-block card-dashboard">
																						<f:input type="hidden"
																						path="referenciaBean.codigo" id="codigoReferencia"
																						val="" />
																						<input type="hidden" id="contextPathUrl"
																						value="${pageContext.request.contextPath}">
																						<input type="hidden" id="idInstitucionUsu"
																						value="${idInstitucion}">
																						<ul
																						class="nav nav-tabs nav-top-border no-hover-bg">
																							<li class="nav-item"><a
																							class="nav-link active" id="base-tab11"
																							data-toggle="tab" aria-controls="tab11"
																							href="#tab11" aria-expanded="true">Inscripciones</a></li>
																							<li class="nav-item"><a class="nav-link"
																							id="base-tab12" onclick="selectTabSeg()"
																							data-toggle="tab" aria-controls="tab12"
																							href="#tab12" aria-expanded="false">Seguimiento</a>
																							</li>
																						</ul>

																						<div class="tab-content px-1 pt-1">
																							<div role="tabpanel" class="tab-pane active"
																							id="tab11" aria-expanded="true"
																							aria-labelledby="base-tab11">
																								<f:form class="form mt-1"
																								id="formBusqInscripcion">
																									<div class="form-body">
																										<div class="row">
																											<div class="form-group col-md-6 mb-2">
																												<label for="cboInstRptInscr">Instituci&oacute;n</label>
																												<select id="cboInstRptInscr"
																												class="form-control select-del">
																													<option value="0" label="Seleccionar" />
																													<c:forEach var="inst"
																													items="${lstInstitucionBean}">
																														<option value="${inst.codigo}"
																														label="${inst.nombreInstitucion}" />
																													</c:forEach>
																												</select>
																											</div>

																											<div class="form-group col-md-4 mb-2">
																												<label for="cboSitRptInscr">Situaci&oacute;n</label>
																												<select id="cboSitRptInscr"
																												class="form-control select-del">
																													<option value="0" label="Seleccionar" />
																													<c:forEach var="situacion"
																													items="${lstSituacion}">
																														<option
																														value="${situacion.codigoRegistro}"
																														label="${situacion.nombreCorto}" />
																													</c:forEach>
																												</select>
																											</div>
																										</div>

																										<div class="row">
																											<div class="form-group col-md-12 text-right">
																												<button
																												onclick="limpiarFiltros('#formBusqInscripcion')"
																												type="button" class="btn btn-secondary mt-2">
																													<i class="fa fa-eraser"></i> Limpiar
																												</button>
																												<button
																												class="btn btn-flat btn-primary mt-2"
																												type="button"
																												onclick="reporteInscripciones()">
																													<i class="ft-search"></i> Buscar
																												</button>
																											</div>
																										</div>
																									</div>
																								</f:form>

																								<div class="row">
																									<div class="col-xs-12">
																										<table id="tablaRpti"
																										class="table table-striped table-bordered zero-configuration">
																											<thead>
																												<tr>
																													<th width="40">Item</th>
																													<th>Instituci&oacute;n</th>
																													<th width="70">Per&iacute;odo -
																														Semestre</th>
																													<th width="70">Fecha Reg.</th>
																													<th width="120">Fecha Sincr.</th>
																													<th width="70">Situaci&oacute;n</th>
																												</tr>
																											</thead>
																											<tbody id="tbodyReportInscr"></tbody>
																											<tfoot>
																												<tr>
																													<th>Item</th>
																													<th>Instituci&oacute;n</th>
																													<th>Per&iacute;odo - Semestre</th>
																													<th>Fecha Reg.</th>
																													<th>Fecha Sincr.</th>
																													<th>Situaci&oacute;n</th>
																												</tr>
																											</tfoot>
																										</table>
																									</div>
																								</div>

																							</div>
																							<div class="tab-pane" id="tab12"
																							aria-labelledby="base-tab12">

																								<f:form id="frmBuscarSeguimientoAlumno"
																								class="form" role="form" method="post"
																								action="buscar" onsubmit="return false">
																									<div class="form-body">
																										<div class="row">
																											<div class="form-group col-md-4 mb-2">
																												<label for="lblInstitu">Instituci&oacute;n</label>
																												<div class="controls">
																													<select id="lblInstitu"
																													class="form-control select-del"
																													onchange="buscarLengua()">
																														<option value="0" label="Seleccionar" />
																														<c:forEach var="inst"
																														items="${lstInstitucionBean}">
																															<option value="${inst.codigo}"
																															label="${inst.nombreInstitucion}" />
																														</c:forEach>
																													</select>
																												</div>
																											</div>
																											<div class="form-group col-md-2 mb-2">
																												<label for="lblLengua">Lengua</label>
																												<div class="controls">
																													<select id="lblLengua"
																													class="form-control select-del"
																													onchange="buscarDocente(0)">
																														<option value="0" label="Seleccionar" />
																													</select>
																												</div>
																											</div>
																											<div class="form-group col-md-3 mb-2">
																												<label for="lblDocente">Docente</label>
																												<div class="controls">
																													<select id="lblDocente"
																													class="form-control select-del">
																														<option value="0" label="Todos" />
																													</select>
																												</div>
																											</div>
																											<div class="form-group col-md-3 mb-2">
																												<label for="lblNivel">Nivel</label> <select
																												id="lblNivel"
																												class="form-control select-del">
																													<option value="0" label="Todos" />
																													<c:forEach var="nivel" items="${lstnivel}">
																														<option value="${nivel.codigoRegistro}"
																														label="${nivel.nombreCorto}" />
																													</c:forEach>
																												</select>
																											</div>

																											<div class="row"></div>
																											<div class="form-group col-md-2 mb-2">
																												<label for="lblPeriodo">Periodo</label> <select
																												id="lblPeriodo"
																												class="form-control select-del">
																													<option value="0" label="Todos" />
																													<c:forEach var="periodo"
																													items="${lstPeriodo}">
																														<option value="${periodo.codigoRegistro}"
																														label="${periodo.nombreCorto}" />
																													</c:forEach>
																												</select>
																											</div>
																											<div class="form-group col-md-2 mb-2">
																												<label for="lblSituacion">Situaci&oacute;n</label>
																												<select id="lblSituacion"
																												class="form-control select-del">
																													<option value="0" label="Todos" />
																													<c:forEach var="situacion"
																													items="${lstSituacion}">
																														<option
																														value="${situacion.codigoRegistro}"
																														label="${situacion.nombreCorto}" />
																													</c:forEach>
																												</select>
																											</div>

																											<div class="form-group col-md-8 text-right">
																												<button
																												onclick="limpiarFiltros('#frmBuscarSeguimientoAlumno')"
																												type="button" class="btn btn-secondary mt-2">
																													<i class="fa fa-eraser"></i> Limpiar
																												</button>
																												<button type="button"
																												onclick="reporteSeguimiento()"
																												class="btn btn-primary  mt-2">
																													<i class="ft-search"></i> Buscar
																												</button>
																											</div>
																										</div>

																									</div>
																								</f:form>

																							</div>
																						</div>

																					</div>
																				</div>
																			</div>
																		</div>
																	</div>
																</section>
															
														</div>
															
								</div>
															</div>
															</select></form>
															
															
															</td>
															</tr>
															</tbody>
															</table>
															</div>
															</div>							
															</div>
															</div>
															</div>
															</div>
															</div>
															
																							<!-- ////////////////////////////////////////////////////////////////////////////-->


			<jsp:include
								page="${pageContext.request.contextPath}/../layout/footer-view.jsp" />

															<!-- BEGIN VENDOR JS-->
															<!--  <script src="${pageContext.request.contextPath}/app-assets/vendors/js/vendors.min.js" type="text/javascript"></script>-->
															<!-- BEGIN VENDOR JS-->
															<!-- BEGIN PAGE VENDOR JS-->
															<!--   <script src="${pageContext.request.contextPath}/app-assets/vendors/js/tables/jquery.dataTables.min.js" type="text/javascript"></script>-->
															<script
								src="${pageContext.request.contextPath}/app-assets/vendors/js/tables/jquery-3.2.1.min.js"
								type="text/javascript"></script>
															<!--  <script src="${pageContext.request.contextPath}/app-assets/vendors/js/tables/datatable/dataTables.bootstrap4.min.js" type="text/javascript"></script>-->
															<!-- <script src="${pageContext.request.contextPath}/app-assets/vendors/js/tables/datatable/dataTables.responsive.min.js" type="text/javascript"></script>-->
															<!-- <script src="${pageContext.request.contextPath}/app-assets/vendors/js/tables/buttons.colVis.min.js" type="text/javascript"></script>-->
															<!--  <script src="${pageContext.request.contextPath}/app-assets/vendors/js/tables/datatable/dataTables.colReorder.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/tables/datatable/dataTables.buttons.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/tables/datatable/buttons.bootstrap4.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/tables/datatable/dataTables.fixedHeader.min.js" type="text/javascript"></script>-->

															<script
								src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/select/select2.min.js"
								type="text/javascript"></script>

															<script
								src="${pageContext.request.contextPath}/app-assets/vendors/js/extensions/toastr.min.js"
								type="text/javascript"></script>
															<!-- END PAGE VENDOR JS-->
															<!-- BEGIN STACK JS-->
															<script
								src="${pageContext.request.contextPath}/app-assets/js/core/app-menu.js"
								type="text/javascript"></script>
															<!--  <script src="${pageContext.request.contextPath}/app-assets/js/core/app.js" type="text/javascript"></script>-->
															<!-- END STACK JS-->
															<!-- BEGIN PAGE LEVEL JS-->
															<script
								src="${pageContext.request.contextPath}/app-assets/js/scripts/tables/datatables/datatable-basic.js"
								type="text/javascript"></script>
															<!-- END PAGE LEVEL JS-->
															<!--  <script src="${pageContext.request.contextPath}/app-assets/vendors/js/extensions/sweetalert.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/js/scripts/extensions/sweet-alerts.js" type="text/javascript"></script>-->
															<script
								src="${pageContext.request.contextPath}/app-assets/js/scripts/forms/select/form-select2.js"
								type="text/javascript"></script>
															<!-- BEGIN SCRIPT PERSONALIZADO -->
															<script
								src="${pageContext.request.contextPath}/assets/js/page/indicadores-script.js"
								type="text/javascript" charset="utf-8"></script>
															<script
								src="${pageContext.request.contextPath}/assets/js/page/listadiagnostico2-script.js"
								type="text/javascript" charset="utf-8"></script>
															<script
								src="${pageContext.request.contextPath}/assets/js/page/validarDni.js"
								type="text/javascript" charset="utf-8"></script>
															<script
								src="${pageContext.request.contextPath}/assets/js/scripts.js"
								type="text/javascript"></script>
															<script type="text/javascript"> $(".selection").select2();</script>

															<script
								src="${pageContext.request.contextPath}/assets/js/page/asistencial/referencia.js"
								type="text/javascript"></script>
															<!-- END SCRIPT PERSONALIZADO -->

															<script type="text/javascript">
		//initDataTable('#tablaRptInscripcion');
		/*$('.dataex-res-controlright').DataTable({
	        responsive: {
	            details: {
	                type: 'column',
	                target: -1
	            }
	        },
	        columnDefs: [{
	            className: 'control',
	            orderable: false,
	            targets: -1
	        }]
	    });*/
	</script>


															<script>
var f = new Date();
document.write(f.getDate() + "/" + (f.getMonth() +1) + "/" + f.getFullYear());
</script>
															<script>
 var btn = document.getElementById("Button3");
btn.disabled = false;
</script>
															<script>
			anchors.options.placement = 'left';
			anchors.add('.container h1, .container h2, .container h3, .container h4, .container h5');

			// Set the "bootstrap" theme as the default theme for all Select2
			// widgets.
			//
			// @see https://github.com/select2/select2/issues/2927
			$.fn.select2.defaults.set( "theme", "bootstrap" );

			var placeholder = "Select a State";

			$( ".select2-single, .select2-multiple" ).select2( {
				placeholder: placeholder,
				width: null,
				containerCssClass: ':all:'
			} );

			$( ".select2-allow-clear" ).select2( {
				allowClear: true,
				placeholder: placeholder,
				width: null,
				containerCssClass: ':all:'
			} );

			// @see https://select2.github.io/examples.html#data-ajax
			function formatRepo( repo ) {
				if (repo.loading) return repo.text;

				var markup = "<div class='select2-result-repository clearfix'>" +
					"<div class='select2-result-repository__avatar'><img src='" + repo.owner.avatar_url + "' /></div>" +
					"<div class='select2-result-repository__meta'>" +
						"<div class='select2-result-repository__title'>" + repo.full_name + "</div>";

				if ( repo.description ) {
					markup += "<div class='select2-result-repository__description'>" + repo.description + "</div>";
				}

				markup += "<div class='select2-result-repository__statistics'>" +
							"<div class='select2-result-repository__forks'><span class='glyphicon glyphicon-flash'></span> " + repo.forks_count + " Forks</div>" +
							"<div class='select2-result-repository__stargazers'><span class='glyphicon glyphicon-star'></span> " + repo.stargazers_count + " Stars</div>" +
							"<div class='select2-result-repository__watchers'><span class='glyphicon glyphicon-eye-open'></span> " + repo.watchers_count + " Watchers</div>" +
						"</div>" +
					"</div></div>";

				return markup;
			}

			function formatRepoSelection( repo ) {
				return repo.full_name || repo.text;
			}

			$( ".js-data-example-ajax" ).select2({
				width : null,
				containerCssClass: ':all:',
				ajax: {
					url: "https://api.github.com/search/repositories",
					dataType: 'json',
					delay: 250,
					data: function (params) {
						return {
							q: params.term, // search term
							page: params.page
						};
					},
					processResults: function (data, params) {
						// parse the results into the format expected by Select2
						// since we are using custom formatting functions we do not need to
						// alter the remote JSON data, except to indicate that infinite
						// scrolling can be used
						params.page = params.page || 1;

						return {
							results: data.items,
							pagination: {
								more: (params.page * 30) < data.total_count
							}
						};
					},
					cache: true
				},
				escapeMarkup: function (markup) { return markup; }, // let our custom formatter work
				minimumInputLength: 1,
				templateResult: formatRepo,
				templateSelection: formatRepoSelection
			});

			$( "button[data-select2-open]" ).click( function() {
				$( "#" + $( this ).data( "select2-open" ) ).select2( "open" );
			});

			$( ":checkbox" ).on( "click", function() {
				$( this ).parent().nextAll( "select" ).prop( "disabled", !this.checked );
			});

			// copy Bootstrap validation states to Select2 dropdown
			//
			// add .has-waring, .has-error, .has-succes to the Select2 dropdown
			// (was #select2-drop in Select2 v3.x, in Select2 v4 can be selected via
			// body > .select2-container) if _any_ of the opened Select2's parents
			// has one of these forementioned classes (YUCK! ;-))
			$( ".select2-single, .select2-multiple, .select2-allow-clear, .js-data-example-ajax" ).on( "select2:open", function() {
				if ( $( this ).parents( "[class*='has-']" ).length ) {
					var classNames = $( this ).parents( "[class*='has-']" )[ 0 ].className.split( /\s+/ );

					for ( var i = 0; i < classNames.length; ++i ) {
						if ( classNames[ i ].match( "has-" ) ) {
							$( "body > .select2-container" ).addClass( classNames[ i ] );
						}
					}
				}
			});
		</script>
															<script type="text/javascript">
function nif(dni) {
  numero = dni.substr(0,dni.length-1);
  let = dni.substr(dni.length-1,1);
  numero = numero % 23;
  letra='TRWAGMYFPDXBNJZSQVHLCKET';
  letra=letra.substring(numero,numero+1);
  if (letra!=let) 
    alert('Dni erroneo');
}
</script>



															<%-- 	<script src="${pageContext.request.contextPath}/app-assets/js/scripts/tables/datatables-extensions/datatable-responsive.js" type="text/javascript"></script> --%>

</body>
</html>