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

body {
font-family: Cambria;
font-size: 13px;  
}

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

/*the container must be positioned relative:*/
.autocomplete {
	/*position: relative;*/
	display: inline-block;
}


input {
	border: 1px solid transparent; 
	font-size: 13px;
}

input[type=text] {
	width: 100%;
}

.autocomplete-items {
	position: absolute;
	border: 1px solid #d4d4d4;
	border-bottom: none;
	border-top: none;
	z-index: 99;
	/*position the autocomplete items to be the same width as the container:*/
	top: 100%;
	left: 0;
	right: 0;
}

.autocomplete-items div {
	padding: 10px;
	cursor: pointer;
	background-color: #fff;
	border-bottom: 1px solid #d4d4d4;
}

/*when hovering an item:*/
.autocomplete-items div:hover {
	background-color: #e9e9e9;
}

/*when navigating through the items using the arrow keys:*/
.autocomplete-active {
	background-color: DodgerBlue !important;
	color: #ffffff;
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
				<f:form id="frmGuardarOrden" class="form-horizontal" role="form"
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
								<div class="col-md-3">
									<button id="idBtnCargarPaciente" type="button"
										<c:choose>
									<c:when test="${ordenBean.codigo==null || ordenBean.codigo==''}"> 
									</c:when>
									<c:otherwise>
										disabled ="true"
									</c:otherwise>
								</c:choose>
										style="margin-top: 30px;" onclick="buscarPersonaNroDoc()"
										class="form-control btn btn-outline-success">
										<i class="ft-search"></i> BUSCAR
									</button>
								</div>
								<div class="col-md-3">
									<button id="idBtnCargarPaciente" type="button"
										<c:choose>
									<c:when test="${ordenBean.codigo==null || ordenBean.codigo==''}"> 
									</c:when>
									<c:otherwise>
										disabled ="true"
									</c:otherwise>
								</c:choose>
										style="margin-top: 30px;" onclick="cargarPersonaModal()"
										class="form-control btn btn-outline-primary">
										<i class="fa icon-plus"></i> NUEVO
									</button>
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
								<div class="row"  style="display: none">
									<div class="col-md-12 text-right " style="margin-bottom: 20px;">
										<button id="btn-save-reg" type="button" class="btn btn-info"
											<c:choose>
									<c:when test="${ordenBean.codigo==null || ordenBean.codigo==''}"> 
									</c:when>
									<c:otherwise>
										disabled ="true"
									</c:otherwise>
								</c:choose>
											onclick="cargarTarifarioModal()">
											<i class="fa fa-plus"></i> AGREGAR EXAMEN
										</button>

									</div>
								</div>
								<div class="row">
									<div class="col-md-8 mb-3">
										<label for="nombreCompleto" class="label_control">BUSCAR EXAMEN </label>
										<div class="controls">
											<div class="autocomplete" style="width:100%;">   
												<input type="text" value="" placeholder="Buscar..."
													class="form-control" required="required" onkeypress="return runIngresarExamen(event)" 
													id="txtExamenNombre" name="txtExamenNombre"  />
											</div>
				
				
										</div>
									</div>
									<div class="col-md-4 mb-3" style="margin-top: 30px;" >
										<button type="button" style="display: none"
											class="btn btn-outline-success btn-sm"
											data-toggle="tooltip" data-placement="top" title=""
											data-original-title="Agregar"
											onclick="enviarIndex()"
											id="agregarEspecialidad">
											<i class="icon-check"> AGREGAR</i> 
										</button> 
								  </div>   
								</div> 
								<div class="row">
									<div class="col-md-12">
										<div class="table-responsive">
											<table class="table table-bordered">
												<thead class="tabla_th">
													<tr>
														<th width="30">ITEM</th>
														<th>DESCRIPCION</th>
														<th>TIPO</th>
														<th width="50">CANTIDAD</th>
														<th>PRECIO UNITARIO</th>
														<th>IMPORTE</th>
														<th>ACCION</th>
													</tr>
												</thead>
												<tbody id="idbodyCIEXref" class="label_control">
													<c:forEach var="orden" items="${lstOrdenDetalleBean}"
														varStatus="loop">
														<tr>
															<td>${loop.count}</td>
															<td>${orden.examen.descripcion}</td>
															<td>${orden.examen.tipo.nombreCorto}</td>
															<td>${orden.cantidad}</td>
															<td>${orden.examen.sPrecio}</td>
															<td>${orden.sImporte}</td>
															<c:choose>
																<c:when test="${codigo==null || codigo==''}">
																	<td></td>
																</c:when>
																<c:otherwise>
																	<td><button type='button'
																			class='btn btn-outline-danger btn-sm'
																			data-toggle='tooltip' data-placement='top'
																			title='Eliminar'
																			onclick='confirmar_eliminar(${ciex.examen.codigo})'
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
						</div>

						<div class="row">
							<div class="form-group col-md-12 text-right"
								style="margin-top: 15px;">
								<a
									href="${pageContext.request.contextPath}/ordenController/nuevo"
									class="btn btn-secondary" title=""> <i class="fa icon-plus"></i>
									NUEVO
								</a>

								<button type="submit" onclick="grabarOrden()"
									<c:choose>
									<c:when test="${ordenBean.codigo==null || ordenBean.codigo==''}"> 
									</c:when>
									<c:otherwise>
										disabled ="true"
									</c:otherwise>
								</c:choose>
									class="btn btn-primary">
									<i class="fa fa-floppy-o"></i> GUARDAR
								</button>
							</div>
						</div>
					</div>

		<input type="hidden"  id="txtIndexExamen"  />
				
				</f:form>
				<f:form id="frmRegistro" class="form-horizontal" role="form"
					method="POST"
					action="${pageContext.request.contextPath}/ordenController/listado">
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

			<div class="modal fade text-xs-left" id="modalPersona" tabindex="-2"
				role="dialog" aria-labelledby="myModalLabel35" data-dismiss="modal"
				aria-hidden="true" aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content" id="modalPersonaContent"></div>
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
		<script src="${pageContext.request.contextPath}/assets/js/scripts.js"
			type="text/javascript"></script>

		<!-- Include Date Range Picker -->

		<script type="text/javascript"
			src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>

		<script
			src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/locales/bootstrap-datepicker.es.min.js"></script>



<script type="text/javascript">  
  
function runIngresarExamen(e) {
	var index = $('#txtIndexExamen').val();
	var examenNombre = $('#txtExamenNombre').val();
	console.log("examenNombre runIngresarExamen" + examenNombre);
	console.log("index runIngresarExamen" + index);
	console.log("e.keyCode:::" +e.keyCode);
	if (e.keyCode == 13) {
		if(examenNombre != ''){
			llenarExamenIndex(index);
			return false;
		} 
	}
}

function enviarIndex() { 
	var index = $('#txtIndexExamen').val();
	var examenNombre = $('#txtExamenNombre').val();
	console.log("examenNombre" + examenNombre);
	console.log("index" + index);
		if(examenNombre != ''){
			llenarExamenIndex(index);
			return false;
		}  
}

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
<script>
		function autocomplete(inp, arr) {
			/*the autocomplete function takes two arguments,
			the text field element and an array of possible autocompleted values:*/
			var currentFocus;
			var codigoRegistro;
			/*execute a function when someone writes in the text field:*/
			inp
					.addEventListener(
							"input",
							function(e) {
								var a, b, i, val = this.value;
								/*close any already open lists of autocompleted values*/
								closeAllLists();
								if (!val) {
									return false;
								}
								currentFocus = -1;
								/*create a DIV element that will contain the items (values):*/
								a = document.createElement("DIV");
								a.setAttribute("id", this.id
										+ "autocomplete-list");
								a.setAttribute("class", "autocomplete-items");
								/*append the DIV element as a child of the autocomplete container:*/
								this.parentNode.appendChild(a);
								/*for each item in the array...*/
								for (i = 0; i < arr.length; i++) {
									/**console.log("arr[i].detalle:: " +arr[i].detalle.substr(0, val.length)
											.toUpperCase());
									console.log("val.toUpperCase():: " +arr[i].detalle.substr(0, val.length)
											.toUpperCase());*/
									/*check if the item starts with the same letters as the text field value:*/
									if ( arr[i].detalle
											.toUpperCase().includes(val.toUpperCase()) ) { 
										/*create a DIV element for each matching element:*/
										b = document.createElement("DIV");
										/*make the matching letters bold:*/
										b.innerHTML = "<strong>"
												+ arr[i].detalle.substr(0, val.length)
												+ "</strong>";
										b.innerHTML += arr[i].detalle
												.substr(val.length);
										/*insert a input field that will hold the current array item's value:*/
										b.innerHTML += "<input type='hidden' id='" + arr[i].codigoRegistro + "' value='" + arr[i].detalle + "'>"; 
									
										/*execute a function when someone clicks on the item value (DIV element):*/
										b
												.addEventListener(
														"click",
														function(e) {
															 
														
															console.log("codigo::" +(this
																	.getElementsByTagName("input")[0].id));	
																	
															inp.value = this
																	.getElementsByTagName("input")[0].value;
															
															$("#txtIndexExamen").val(this
																	.getElementsByTagName("input")[0].id);
																	
															llenarExamenIndex(this
																	.getElementsByTagName("input")[0].id);		
															
															
															$('#txtExamenNombre').val("")
															/*
																$("#txtCodRegUbigeo").val(this
																	.getElementsByTagName("input")[0].id)
																	
																	
															close the list of autocompleted values,
															(or any other open lists of autocompleted values:*/
																	
															//$("#txtCodRegUbigeo").val(arr[i].codigoRegistro);
															closeAllLists();
														});
										a.appendChild(b);
									}
								}
							});
			/*execute a function presses a key on the keyboard:*/
			inp.addEventListener("keydown", function(e) {
				var x = document.getElementById(this.id + "autocomplete-list");
				if (x)
					x = x.getElementsByTagName("div");
				if (e.keyCode == 40) {
					/*If the arrow DOWN key is pressed,
					increase the currentFocus variable:*/
					currentFocus++;
					/*and and make the current item more visible:*/
					addActive(x);
				} else if (e.keyCode == 38) { //up
					/*If the arrow UP key is pressed,
					decrease the currentFocus variable:*/
					currentFocus--;
					/*and and make the current item more visible:*/
					addActive(x);
				} else if (e.keyCode == 13) {
					/*If the ENTER key is pressed, prevent the form from being submitted,*/
					e.preventDefault();
					if (currentFocus > -1) {
						/*and simulate a click on the "active" item:*/
						if (x)
							x[currentFocus].click();
					}
				}
			});
			function addActive(x) {
				/*a function to classify an item as "active":*/
				if (!x)
					return false;
				/*start by removing the "active" class on all items:*/
				removeActive(x);
				if (currentFocus >= x.length)
					currentFocus = 0;
				if (currentFocus < 0)
					currentFocus = (x.length - 1);
				/*add class "autocomplete-active":*/
				x[currentFocus].classList.add("autocomplete-active");
			}
			function removeActive(x) {
				/*a function to remove the "active" class from all autocomplete items:*/
				for (var i = 0; i < x.length; i++) {
					x[i].classList.remove("autocomplete-active");
				}
			}
			function closeAllLists(elmnt) {
				/*close all autocomplete lists in the document,
				except the one passed as an argument:*/
				var x = document.getElementsByClassName("autocomplete-items");
				for (var i = 0; i < x.length; i++) {
					if (elmnt != x[i] && elmnt != inp) {
						x[i].parentNode.removeChild(x[i]);
					}
				}
			}
			/*execute a function when someone clicks in the document:*/
			document.addEventListener("click", function(e) {
				closeAllLists(e.target);
			});
		}
		
		var arrayMenus = [];
		
		
		<c:forEach var="examen" items="${lstTarifarioBean}"
			varStatus="loop">
		var objUbigeo = {
				codigoRegistro : "",
				detalle		: ""
		  	};
			objUbigeo.codigoRegistro ='${loop.index}'; 
			objUbigeo.detalle ='${examen.descripcion}'; 
			  arrayMenus.push(objUbigeo);
		</c:forEach>
		
		/*initiate the autocomplete function on the "txtExamenNombre" element, and pass along the countries array as possible autocomplete values:*/
		autocomplete(document.getElementById("txtExamenNombre"), arrayMenus);
	
		
		
		</script>
	</div>
</body>

</html>










