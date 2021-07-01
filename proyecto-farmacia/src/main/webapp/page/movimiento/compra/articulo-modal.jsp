<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<style>
* {
	box-sizing: border-box;
}

body {
font-family: Cambria;
font-size: 13px;  
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

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/vendors/css/extensions/toastr.css">

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/assets/css/datepicker.css">	
	
<div class="modal-dialog modal-lg" role="document">
	<div class="modal-content">
	
		<div class="modal-header">
			<label class="modal-title text-text-bold-600" id="myModalLabel35"><b>AGREGAR ARTICULOS COMPRA</b></label>
			<button type="button" class="close" data-dismiss="modal"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
		</div>

		<f:form id="frmAgregarArticulos" class="form-horizontal" role="form"
			method="post" action="" onsubmit="return false">
			<input id="contextPath" type="hidden"
				value="${pageContext.request.contextPath}">
				  
			<div class="modal-body" id="buscaPaciente">
				<div class="row">
					<div class="col-md-6 mb-1"> 
						<label for="nombreCompleto" class="label_control">BUSCAR
							ARTICULO </label>
						<div class="controls" > 
							<f:select id="cboProductos" 
								title="Seleccionar" style="width: 90%;" class="form-control"
								path="stock.articulo.nombre" required="required" >
								<f:options items="${lstArticulos}" itemValue="codigo"
									itemLabel="nombreArticuloSismed" />
							</f:select>
							<!-- <div class="autocomplete" style="width: 100%;">
								<input type="text" value="" placeholder="Buscar..."
									class="form-control"  required="required"
									onkeypress="return runIngresarExamen(event)" autocomplete="off"
									id="txtArticuloNombre" name="txtArticuloNombre" />
							</div> -->
						</div>
					</div>
					<div class="form-group col-md-3 mb-2">
						<label for="situacion" class="label_control"># LOTE<span class="required">*</span>
						</label>
						<div class="controls">
							<f:input type="text" class="form-control" required="required"
								id="txtLote" path="stock.lote" autocomplete="off" maxlength="15" />
						</div> 
					</div>
					<div class="form-group col-md-3 mb-2">
						<label for="exampleInputName" class="label_control">F. VENCIMIENTO <span class="required">*</span>
						</label>
						<div class="position-relative has-icon-left"> 
							<input id="contextPath" type="hidden"
								value="${pageContext.request.contextPath}">
							<div class="controls">
								<f:input class="form-control" id="dateVence" name="dateVence" maxlength="10" 
									required="required" placeholder="DD/MM/YYYY" type="text"  autocomplete="off" 
									path="stock.sFechaVencimiento" onkeyup="this.value=formateafechaVencimiento(this.value);"/> 

							</div>
						</div>
					</div> 
				</div> 
				<div class="row">
				<div class="form-group col-md-3 mb-2">
					<label for="situacion" class="label_control">REG. SANITARIO<span class="required">*</span>
					</label>
					<div class="controls">
						<f:input type="text" class="form-control" required="required"
							id="txtRegSanitario" path="stock.nroRegistroSanitario" autocomplete="off" maxlength="15" />
					</div> 
				</div> 
				<div class="form-group col-md-3 mb-2">
						<label for="situacion" class="label_control">PRECIO COSTO<span class="required">*</span>
						</label>
						<div class="controls">
							<f:input type="text" class="form-control" required="required" id="txtprecioCompra" onchange = 'calcularPrecioVenta(); ' 
							 onkeypress= 'return decimales(event,this);' path="stock.precioCompra" autocomplete="off" maxlength="11" />
						</div> 
					</div>
				<div class="form-group col-md-3 mb-2">
					<label for="situacion" class="label_control">PRECIO VENTA<span class="required">*</span>
					</label>
					<div class="controls">
						<f:input type="text" class="form-control" required="required" id="txtPrecioVenta"
						onkeypress= 'return decimales(event,this);' path="stock.precioVenta" autocomplete="off" maxlength="11" />
					</div> 
				</div>
				<div class="form-group col-md-3 mb-2">
					<label for="situacion" class="label_control">CANTIDAD<span class="required">*</span>
					</label>
					<div class="controls">
						<f:input type="text" class="form-control" required="required" onkeypress= 'return decimales(event,this);' 
							id="txtCantidad" path="cantidad" autocomplete="off" maxlength="15" onchange = 'calcularSubTotal(); '  />
					</div> 
				</div>
				<f:input type="hidden" path="stock.articulo.codigo" id="txtIndexArticulo" />
				<f:input type="hidden" path="compra.porcentajeVenta" id="txtPorcentajeCostoVenta" />
			</div>
			<div class="row">
			<div class="form-group col-md-9 text-right"
				style="margin-top: 2px;"></div>
			<div class="form-group col-md-3 text-right" style="margin-top: 15px;">
					<label for="situacion" class="label_control">SUB TOTAL S/.
					</label>
					<div class="controls">
						<f:input type="text" class="form-control" required="required" readonly="true"
							id="txtSubTotal" path="subtotal" autocomplete="off" maxlength="15" />
					</div> 
				</div>
			</div>
			</div>
			<div class="modal-footer">
				<button type="button" id="btnCerrarModalPaciente"
					class="btn btn-secondary" data-dismiss="modal">
					<i class="fa fa-close"></i> CERRAR
				</button>

				<button type="button" onclick="limpiar()" class="btn btn-default">
					<i class="fa fa-eraser"></i> LIMPIAR
				</button>

				<button type="submit" onclick="llenarDatos()"
					class="btn btn-primary">
					<i class="fa fa-check"></i> AGREGAR
				</button>
			</div>



		</f:form>
	</div>
	<script
			src="${pageContext.request.contextPath}/assets/js/page/movimiento/compra.js"
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
	
	
		$(document).ready(
				function() {
					var date_input = $('input[id="dateVence"]'); //our date input has the name "date"
					var container = $('.bootstrap-iso form').length > 0 ? $(
							'.bootstrap-iso form').parent() : "body";
					date_input.datepicker({
						format : 'dd/mm/yyyy',
						container : container,
						todayHighlight : true,
						autoclose : true,
						language : 'es'

					})
				})
				
		function llenarDatos() { 
			var myFormulario = $('#frmAgregarArticulos'); 
			var actionForm = $('#frmAgregarArticulos').attr("action");
			//var index = $('#txtIndexArticulo').val();  
			var fechaVencimiento = $('#dateVence').val(); 
			var cantidad = $('#txtCantidad').val(); 
			
			var idArticulo = $('#cboProductos').val();
			console.log("idArticulo " + idArticulo);
			var index = document.getElementById("cboProductos").selectedIndex;
			console.log("index " + index);
			$('#txtIndexArticulo').val(index);
			
			console.log("actionForm " + actionForm);
			console.log("index " + index);
			console.log("fechaVencimiento " + fechaVencimiento); 
			
			var fechaActual = new Date();
			console.log("convertirFecha(fechaActual) " + convertirFecha(fechaActual));
			if(!myFormulario[0].checkValidity()) {
				 msg_advertencia("Debe completar los campos requeridos(*) correctamente");
			//}else if(index == "") {
				// msg_advertencia("Seleccione un artículo de la lista");
				// $("#txtArticuloNombre").focus();
			}else if(fechaVenceCorrecta(fechaVencimiento,convertirFecha(fechaActual))==true){
				msg_advertencia("La fecha de vencimiento no puede ser menor a la actual.");
			}else if(cantidad == 0){
				msg_advertencia("La cantidad no puede ser 0.");
			} else { 
				llenarDatosItem(index); 
				msg_exito("Item agregado correctamente.");
				limpiar();
			} 
		}	
		
		 function calcularPrecioVenta(){
			var porcentaje = 0.00;
			var precioCompra = 0.00;
			var precioVenta = 0.00;
			var swDonacion = $('#txtSwDonacion').val();
			precioCompra = $('#txtprecioCompra').val();
			porcentaje = $('#txtPorcentajeCostoVenta').val();
			porcentaje = porcentaje / 100;
			console.log("$('#txtSwDonacion').val();" + $('#txtSwDonacion').val());
		
			if(swDonacion == "1"){
				 $('#txtPrecioVenta').val(precioCompra);
			}else{
				precioVenta = Number(precioCompra) + Number(precioCompra * porcentaje);
				 $('#txtPrecioVenta').val(precioVenta.toFixed(2));
			}
			calcularSubTotal();
		}

		function calcularSubTotal(){
			var importe = 0.00;
			var cantidad = $('#txtCantidad').val();
			var precioCompra = $('#txtprecioCompra').val();
		 
			importe = cantidad * precioCompra ;
			 $('#txtSubTotal').val(importe.toFixed(2));
			
		}

	</script>
  
	<script>
		function habilitar() {

			document.getElementById('personaApellidoPaterno').disabled = true;
			document.getElementById('personaApellidoMaterno').disabled = true;
			document.getElementById('sexoPaciente').disabled = true;
			document.getElementById('personanombres').disabled = true;
			document.getElementById('personanombres').disabled = true;
			document.getElementById('personaFechaNac').disabled = true;

			$("#nroDocumentoPaciente").focus();
		}

		function limpiar() {
			$('#txtLote').val("");
			$('#date').val("");
			$('#txtRegSanitario').val("");
			$('#txtprecioCompra').val("0.0");
			$('#txtPrecioVenta').val("0.0");
			$('#txtIndexArticulo').val(""); 
			$('#txtCantidad').val("0"); 
			$('#txtSubTotal').val("0"); 
			$("#txtArticuloNombre").val("");
			$("#txtArticuloNombre").focus();
		}

		function runScript(e) {
			//See notes about 'which' and 'key'
			if (e.keyCode == 13) {
				iniciarBloqueo();
				finBloqueo();
				return false;
			}
		}
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
															
												/*	llenarArticuloIndex(this
															.getElementsByTagName("input")[0].id);		
													*/
													
													//$('#txtArticuloNombre').val("")
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

<c:forEach var="articulo" items="${lstArticulos}"
	varStatus="loop">
var objArticulo = {
		codigo : "",
		nombre		: ""
  	}; 
objArticulo.codigo ='${loop.index}'; //'${articulo.codigo}';//
objArticulo.nombre ='${articulo.nombre}'; 
  arrayMenus.push(objArticulo);
</c:forEach>

/*initiate the autocomplete function on the "myInput" element, and pass along the countries array as possible autocomplete values:*/
autocomplete(document.getElementById("txtArticuloNombre"), arrayMenus);


var  listadoArticulo= []; 
 
</script>
</div>



