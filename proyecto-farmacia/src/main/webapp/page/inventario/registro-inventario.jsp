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

<title>Farmacia - Inventario</title>

<!-- Custom fonts for this template-->
<link
	href="${pageContext.request.contextPath}/app-assets/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/vendors/css/extensions/toastr.css">

<link
	href="${pageContext.request.contextPath}/app-assets/css/sb-admin-2.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/app-assets/css/estilos.css"
	rel="stylesheet">
<!-- Custom styles for this page -->

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
/*the container must be positioned relative:*/
.autocompletePac {
	/*position: relative;*/
	display: inline-block;
}
.autocompletePac-items {
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

.autocompletePac-items div {
	padding: 10px;
	cursor: pointer;
	background-color: #fff;
	border-bottom: 1px solid #d4d4d4;
}

/*when hovering an item:*/
.autocompletePac-items div:hover {
	background-color: #e9e9e9;
}

/*when navigating through the items using the arrow keys:*/
.autocompletePac-active {
	background-color: DodgerBlue !important;
	color: #ffffff;
}

</style>
<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">

		<jsp:include
			page="${pageContext.request.contextPath}/../layout/menu-view.jsp" />

		<!-- End of Sidebar -->

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">

				<!-- Topbar -->
				<jsp:include
					page="${pageContext.request.contextPath}/../layout/head-nav-view.jsp" />
				<!-- End of Topbar -->
				<f:form id="frmRegistrarInventario" role="form" action=""
					onsubmit="return false">
					<input id="contextPath" type="hidden"
						value="${pageContext.request.contextPath}">
					<!-- Begin Page Content -->
					<div class="container-fluid">

						<!-- Page Heading -->
						<div class="tituloForm">INVENTARIO</div>


						<div class="card shadow mb-4">
							<!-- Card Content - Collapse -->
							<div class="collapse show" id="collapseCardExample">
								<div class="card-body">
									<div class="form-group">
										<div class="row">
											<div class="form-group col-md-3 mb-1">
												<label for="exampleInputName" class="label_control">MES
													<span class="required">*</span>
												</label>
												<div class="controls">
													<f:select id="tipoDocumentoPaciente" path="mes.idRegistro"
													    onchange="cambiarNombreDocumento()"
														required="required" class="form-control">
														<f:option value="" label="Seleccione" selected="true"
															disabled="disabled" />
														<f:options items="${lstMes}" itemValue="idRegistro"
															itemLabel="descripcionCorta" />
													</f:select>
												</div>
											</div>
											<div class="form-group col-md-3 mb-2">
												<label for="situacion" class="label_control">PERIODO<span
													class="required">*</span>
												</label>
												<div class="controls">
													<f:select id="tipoDocumentoPaciente"
														path="periodo.idRegistro" 
														onchange="cambiarNombreDocumento()"
														required="required"
														class="form-control">
														<f:option value="" label="Seleccione" selected="true"
															disabled="disabled" />
														<f:options items="${lstPeriodo}" itemValue="idRegistro"
															itemLabel="descripcionCorta" />
													</f:select>
												</div>
											</div>
											<div class="form-group col-md-3 mb-2">
												<label for="nombreCompleto" class="label_control">N°
													DOCUMENTO </label>
												<div class="controls">
													<f:input type="text" class="form-control" disabled="true"
														id="txtAlias" path="nroDocumento" maxlength="15" />
												</div>
											</div>
											<div class="form-group col-md-3 mb-2">
												<label for="nombreCompleto" class="label_control">ALMACEN </label>
												<div class="controls">
													<f:input type="text" class="form-control" disabled="true"
														id="txtAlias" path="almacen.nombreAlmacen" maxlength="35" />
												</div>
											</div>
										</div>
										<div class="row">
											<div class="form-group col-md-6 mb-1">
												<label for="exampleInputName" class="label_control">ENCARGADO
													<span class="required">*</span>
												</label>
												<f:select id="tipoDocumentoPaciente"
													path="personalResponsable.codigo" required="required"
													class="form-control">
													<f:option value="" label="Seleccione" selected="true"
														disabled="disabled" />
													<f:options items="${lstPersonal}" itemValue="codigo"
														itemLabel="persona.nombreCompleto" />
												</f:select>
											</div>
										</div> 
											<br>
										<div class="label_title">
											ARTICULOS <span class="required">*</span>:
										</div>
										 <div id="panelCEX" class="panel_style col-md-12">
											<div class="row">
												<div class="col-md-8 mb-3">
													<label for="nombreCompleto" class="label_control">BUSCAR
														ARTICULO </label>
													<div class="controls">
														<div class="autocomplete" style="width: 100%;">
															<input type="text" value="" placeholder="Buscar..."
																class="form-control"  
																onkeypress="return runIngresarExamen(event)"
																id="txtArticuloNombre" name="txtArticuloNombre" />
														</div>
													</div>
												</div>
												<div class="col-md-4 mb-3" style="margin-top: 30px;">
													<button type="button" style="display: none"
														class="btn btn-outline-success btn-sm"
														data-toggle="tooltip" data-placement="top" title=""
														data-original-title="Agregar" onclick="enviarIndex()"
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
																	<th width="50">LOTE</th>
																	<th width="50">SISMED</th>
																	<th>PRESENTACION</th>
																	<th>STOCK</th>
																	<th width="50">CANTIDAD</th>
																	
																	<th>ACCION</th>
																</tr>
															</thead>
															<tbody id="idbodyStock" class="label_control">
																<c:forEach var="inventario" items="${lstInventarioDetalle}"
																	varStatus="loop">
																	<tr>
																		<td>${loop.count}</td>
																		<td>${inventario.stock.articulo.nombre}</td>
																		<td>${inventario.stock.lote}</td>
																		<td>${inventario.stock.articulo.codigoSismed}</td>
																		<td>${inventario.stock.articulo.tipoPresentacion.descripcionLarga}</td>
																		<td>${inventario.stock.stock}</td>
																		<td>${inventario.cantidad}</td>
																		<c:choose>
																			<c:when test="${codigo==null || codigo==''}">
																				<td></td>
																			</c:when>
																			<c:otherwise>
																				<td><button type='button'
																						class='btn btn-outline-danger btn-sm'
																						data-toggle='tooltip' data-placement='top'
																						title='Eliminar'
																						onclick='confirmar_eliminar(${inventario.stock.codigo})'
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
										<div class="row">
											<div class="form-group col-md-12 text-right"
												style="margin-top: 15px;">
											    <a href="${pageContext.request.contextPath}/inventarioController/listado"
												 class="btn btn-secondary" id="btnListado"> <i class="fa fa-undo"></i>
													<span class="text">CANCELAR</span>
												</a>


												<button type="submit" onclick="grabar()"
													class="btn btn-primary">
													<i class="fa fa-save"></i> GUARDAR
												</button>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div> 
						<div class="card-body">
							<div class="form-group"></div>
						</div>
					</div>

					<input type="hidden" id="txtIndexArticulo" />
				</f:form>
				<!-- /.container-fluid -->

			</div>
			<!-- End of Main Content -->

			<!-- Footer -->
			<jsp:include
				page="${pageContext.request.contextPath}/../layout/footer-view.jsp" />

			<!-- End of Footer -->

		</div>
		<!-- End of Content Wrapper -->

	</div>
	<!-- End of Page Wrapper -->

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>

	<!-- Logout Modal-->
	<jsp:include
		page="${pageContext.request.contextPath}/../layout/confirmacion-modal-view.jsp" />


	<!-- Bootstrap core JavaScript-->
	<script
		src="${pageContext.request.contextPath}/app-assets/vendor/jquery/jquery.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/app-assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script
		src="${pageContext.request.contextPath}/app-assets/vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script
		src="${pageContext.request.contextPath}/app-assets/js/sb-admin-2.min.js"></script>

	<!-- Page level plugins -->
	<script
		src="${pageContext.request.contextPath}/app-assets/vendor/datatables/jquery.dataTables.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/app-assets/vendor/datatables/dataTables.bootstrap4.min.js"></script>

	<!-- Page level custom scripts -->


	<!-- scripts  -->
	<script
		src="${pageContext.request.contextPath}/assets/js/page/inventario/inventario.js"
		type="text/javascript" charset="utf-8"></script>

	<script
		src="${pageContext.request.contextPath}/assets/js/page/util/datepicker.js"
		type="text/javascript" charset="utf-8"></script>

	<script
		src="${pageContext.request.contextPath}/assets/js/page/util/block.js"
		type="text/javascript" charset="utf-8"></script>

	<script
		src="${pageContext.request.contextPath}/assets/js/page/util/datepicker.es.min.js"
		type="text/javascript" charset="utf-8"></script>

	<script
		src="${pageContext.request.contextPath}/assets/js/page/util/utilitarios.js"
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
		document.getElementById('navInventario').className = "nav-item active";
		document.getElementById('enlaceGenerarInventario').className = "collapse-item active";
		document.getElementById('collInventario').className = "nav-link";
		document.getElementById('collapseInventario').className = "collapse show";
	</script>

<script>

function runIngresarExamen(e) {
	var index = $('#txtIndexArticulo').val();
	var examenNombre = $('#txtExamenNombre').val();
	if (e.keyCode == 13) {
		if(examenNombre != ''){
			llenarArticuloIndex(index);
			return false;
		} 
	}
}

function enviarIndex() { 
	var index = $('#txtIndexArticulo').val();
	var examenNombre = $('#txtExamenNombre').val();
		if(examenNombre != ''){
			llenarArticuloIndex(index);
			return false;
		}  
}
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
							/**console.log("arr[i].nombre:: " +arr[i].nombre.substr(0, val.length)
									.toUpperCase());
							console.log("val.toUpperCase():: " +arr[i].nombre.substr(0, val.length)
									.toUpperCase());*/
							/*check if the item starts with the same letters as the text field value:*/
							if ( arr[i].nombre
									.toUpperCase().includes(val.toUpperCase()) ) { 
								/*create a DIV element for each matching element:*/
								b = document.createElement("DIV");
								/*make the matching letters bold:*/
								b.innerHTML = "<strong>"
										+ arr[i].nombre.substr(0, val.length)
										+ "</strong>";
								b.innerHTML += arr[i].nombre
										.substr(val.length);
								/*insert a input field that will hold the current array item's value:*/
								b.innerHTML += "<input type='hidden' id='" + arr[i].codigo + "' value='" + arr[i].nombre + "'>"; 
							
								/*execute a function when someone clicks on the item value (DIV element):*/
								b
										.addEventListener(
												"click",
												function(e) {
													 
												
													console.log("codigo::" +(this
															.getElementsByTagName("input")[0].id));	
															
													inp.value = this
															.getElementsByTagName("input")[0].value;
													
													$("#txtIndexArticulo").val(this
															.getElementsByTagName("input")[0].id);
															
													llenarArticuloIndex(this
															.getElementsByTagName("input")[0].id);		
													
													
													$('#txtArticuloNombre').val("")
													/*
														$("#txtidRegistroUbigeo").val(this
															.getElementsByTagName("input")[0].id)
													close the list of autocompleted values,
													(or any other open lists of autocompleted values:*/
															
													//$("#txtidRegistroUbigeo").val(arr[i].codigoRegistro);
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
var arrayPersonas = [];

<c:forEach var="stock" items="${lstStocks}"
	varStatus="loop">
var objArticulo = {
		codigo : "",
		nombre		: ""
  	}; 
objArticulo.codigo ='${loop.index}'; 
objArticulo.nombre ='${stock.articulo.nombre} - LOTE:${stock.lote}'; 
  arrayMenus.push(objArticulo);
</c:forEach>

/*initiate the autocomplete function on the "myInput" element, and pass along the countries array as possible autocomplete values:*/
autocomplete(document.getElementById("txtArticuloNombre"), arrayMenus);


var  listadoArticulo= []; 
 
</script>


	<div class="modal fade text-xs-left" id="modalPersona" tabindex="-2"
		role="dialog" aria-labelledby="myModalLabel35" data-dismiss="modal"
		aria-hidden="true" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content" id="modalPersonaContent"></div>
		</div>
	</div>
</body>

</html>
