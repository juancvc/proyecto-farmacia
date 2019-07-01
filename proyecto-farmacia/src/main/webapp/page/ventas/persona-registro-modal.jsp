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
			<label class="modal-title text-text-bold-600" id="myModalLabel35"><b>REGISTRO
					DE PERSONA</b></label>
			<button type="button" class="close" data-dismiss="modal"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
		</div>

		<f:form id="frmGuardarPersona" class="form-horizontal" role="form"
			method="post" action="" onsubmit="return false">
			<input id="contextPath" type="hidden"
				value="${pageContext.request.contextPath}">
				 
				
			<f:input class="form-control" type="hidden"
				id="pacienteNombreCompleto" path="nombreCompleto" />


			<f:input type="hidden" class="form-control" id="personaCodigo"
				path="codigo" />
			<f:input type="hidden" class="form-control" id="txtidRegistroUbigeo"
				path="ubigeoDireccion.codigoRegistro" />
			 
			
					
			<f:input type="hidden" class="form-control" id="personaCodigoSigeho"
				path="codigoPersonaSigeho" />
				
			<div class="modal-body" id="buscaPaciente">
				<div class="row">
					<div class="form-group col-md-4 mb-2">
						<label for="situacion" class="label_control">TIPO
							DOCUMENTO<span class="required">*</span>
						</label>
						<div class="controls">
							<f:select id="tipoDocumentoPersona" path="tipoDocumento.idRegistro"
								required="required" class="form-control">
								<f:options items="${lstTipoDocumento}" itemValue="idRegistro"
									itemLabel="descripcionCorta" />
							</f:select>
						</div>
					</div>
					<div class="form-group col-md-4 mb-2">
						<label for="exampleInputName" class="label_control">N°
							DOCUMENTO <span class="required">*</span>
						</label>
						<div class="position-relative has-icon-left"> 
							<input id="contextPath" type="hidden"
								value="${pageContext.request.contextPath}">
							<div class="controls">
								<f:input type="text" class="form-control" required="required"
									maxlength="12" id="nroDocumentoPersona" path="nroDocumento"
									onkeypress="return runScript(event)" />
							</div>
						</div>
					</div> 
				</div>
				<div class="row">
					<div class="form-group col-md-4 mb-2">
						<label for="nombreCompleto" class="label_control">APELLIDO
							PATERNO <span class="required">*</span>
						</label>
						<div class="controls">
							<f:input type="text" class="form-control" required="required"
								onkeyup="javascript:this.value=this.value.toUpperCase();"
								id="personaApellidoPaterno" path="apellidoPaterno" />

						</div>
					</div>
					<div class="form-group col-md-4 mb-2">
						<label for="nombreCompleto" class="label_control">APELLIDO
							MATERNO </label>
						<div class="controls">
							<f:input type="text" class="form-control"
								onkeyup="javascript:this.value=this.value.toUpperCase();"
								id="personaApellidoMaterno" path="apellidoMaterno" />

						</div>
					</div>
					<div class="form-group col-md-4 mb-2">
						<label for="nombreCompleto" class="label_control">NOMBRES <span class="required">*</span>
						</label>
						<div class="controls">
							<f:input type="text" class="form-control" required="required"
								onkeyup="javascript:this.value=this.value.toUpperCase();"
								id="personanombres" path="nombres" />

						</div>
					</div>
					
				</div>
				<div class="row">
					<div class="col-md-4 mb-2">
						<label for="situacion" class="label_control">SEXO <span
							class="required">*</span></label>
						<div class="controls">
							<f:select id="sexoPaciente" path="sexo.idRegistro"
								class="form-control" required="required">
								<f:option value="" label="Seleccionar" selected="true"
									disabled="disabled" />
								<f:options items="${lstSexo}" itemValue="idRegistro"
									itemLabel="descripcionLarga" />
							</f:select>
						</div>
					</div>
					<div class="col-md-4 mb-2">
						<label for="exampleInputName" class="label_control">FECHA
							NACIMIENTO <span class="required">*</span>
						</label>
						<f:input class="form-control" id="date" name="date" maxlength="10" 
							required="required" placeholder="DD/MM/YYYY" type="text"
							path="fechaNacStr" onkeyup="this.value=formateafechaNacimiento(this.value);"/> 
					</div>
					<div class="form-group col-md-4 mb-2">
						<label for="nombreCompleto" class="label_control">TELEFONO
						</label>
						<div class="controls">
							<f:input type="text" class="form-control"
								onKeyPress="return soloNumeros(event)" maxlength="9"
								id="telefono" path="telefonoNumero" />

						</div>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-4 mb-1">
						<label for="lbltipoSeguroPaciente" class="label_control">NACIONALIDAD<span
							class="required"> *</span></label>
						<div class="controls">
							<f:select id="personaNacionalidad" path="nacionalidad.idRegistro"
								class="form-control" required="required">
								<f:option value="" label="Seleccionar" selected="true"
									disabled="disabled" />
								<f:options items="${lstNacionalidad}" itemValue="idRegistro"
									itemLabel="descripcionCorta" />
							</f:select>
						</div>
					</div>

					<div class="col-md-4">
						<label for="lbltipoSeguroPaciente" class="label_control">ESTADO
							CIVIL<span class="required">*</span>
						</label>
						<div class="controls">
							<f:select id="estadoCivilPersona" path="estadoCivil.idRegistro"
								class="form-control" required="required">
								<f:option value="" label="Seleccionar" selected="true"
									disabled="disabled" />
								<f:options items="${lstEstadoCivil}" itemValue="idRegistro"
									itemLabel="descripcionCorta" />
							</f:select>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-7 mb-1">
						<label for="nombreCompleto" class="label_control">DEPARTAMENTO
							/ PROVINCIA / DISTRITO </label>
						<div class="controls">
							<div class="autocomplete" style="width:100%;">   
								<f:input type="text" value="" placeholder="Buscar..."
									class="form-control" required="required"
									id="myInput" name="myCountry" autocomplete="off"
									path="ubigeoDireccion.nombreUbigeo" />
							</div>


						</div>
					</div>
					<div class="col-md-5">
						<label for="nombreCompleto" class="label_control">DIRECCION 
						</label>
						
						<div class="controls">
							<f:input type="text" class="form-control" required="required"
								id="personaDireccion" path="direccion" />

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

				<button type="submit" onclick="grabarPersona()"
					class="btn btn-primary">
					<i class="fa fa-save"></i> GRABAR
				</button>
			</div>



		</f:form>
	</div>
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
					var date_input = $('input[id="date"]'); //our date input has the name "date"
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

		$(document)
				.ready(
						function() {
							var date_inputHasta = $('input[id="dateHasta"]'); //our date input has the name "date"
							var containerHasta = $('.bootstrap-iso form').length > 0 ? $(
									'.bootstrap-iso form').parent()
									: "body";
							date_inputHasta.datepicker({
								format : 'dd/mm/yyyy',
								container : containerHasta,
								todayHighlight : true,
								autoclose : true,
								language : 'es'

							})
						})
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
			$('#tipoDocumentoPaciente').val("000002");
			$('#nroDocumentoPaciente').val("");
			$('#personaApellidoPaterno').val("");
			$('#personaApellidoMaterno').val("");
			$('#sexoPaciente').val("");
			$('#personanombres').val("");
			$('#personanombres').val("");
			$('#personaFechaNac').val("");
			$("#nroDocumentoPaciente").focus();
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
															 
															$("#txtidRegistroUbigeo").val(this
																	.getElementsByTagName("input")[0].id)
															inp.value = this
																	.getElementsByTagName("input")[0].value;
															/*close the list of autocompleted values,
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
		
		
		<c:forEach var="ubigeo" items="${lstUbigeoBean}"
			varStatus="loop">
		var objUbigeo = {
				codigoRegistro : "",
				detalle		: ""
		  	};
		objUbigeo.codigoRegistro ='${ubigeo.codigoRegistro}'; 
		objUbigeo.detalle ='${ubigeo.detalle}'; 
		  arrayMenus.push(objUbigeo);
		</c:forEach>
		
		/*initiate the autocomplete function on the "myInput" element, and pass along the countries array as possible autocomplete values:*/
		autocomplete(document.getElementById("myInput"), arrayMenus);
	
		
		
		</script>
</div>



