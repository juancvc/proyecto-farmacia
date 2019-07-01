var accionRealizar = "";
var codigoRegistro = "";

function confirmar_eliminar(codigo, accion) {
	codigoRegistro = codigo;
	accionRealizar = accion;
	// alert(codigoReferencia);
	$('#md_confirmacion').modal('show');

}
function agregar_accion() {
	$('#md_reg_confirmacion').modal('show');
}

$(document).ready(function() {
	$("#btnConfirmarGeneric").click(function() {
		// console.log("accionRealizar " + accionRealizar);
		// console.log("codigoRegistro " + codigoRegistro);
		if (accionRealizar == "1") {
			eliminarArticulo(codigoRegistro);
			$('#md_confirmacion').modal('hide');
		} else if (accionRealizar == "2") {
			$('#md_confirmacion').modal('hide');
		} else if (accionRealizar == "3") {
			$('#md_confirmacion').modal('hide');
		}

	});
});

function cargarPersonaModal() {
	var contextPath = $('#contextPath').val();
	path = contextPath + "/ventaController/personaModal";
	$.ajax({
		type : "POST",
		url : path,

		success : function(data) {
			$("#modalPersona").html(data);
			$("#modalPersona").modal('show');
		},
		error : function(request, status, error) {
			console.log("ERROR: " + error);
		}
	});
}

function grabarPersona() {
	var htmlTabla = "";
	var contextPath = $('#contextPath').val();
	var actionForm = $('#frmGuardarPersona').attr("action");
	var url = contextPath + "/ventaController/grabarPersona";
	var myFormulario = $('#frmGuardarPersona');
	var telefono = $('#telefono').val();
	var codigoRegistroUbigeoDireccion = $('#txtidRegistroUbigeo').val();

	if (!myFormulario[0].checkValidity()) {
		msg_advertencia("Debe completar los campos requeridos(*) correctamente");

	} else if (telefono.length < 7) {
		msg_advertencia("Ingrese número de celular correcto.");

	} else if (codigoRegistroUbigeoDireccion.length == 0) {
		msg_advertencia("Ingrese ubigeo de dirección.");

	} else {
		iniciarBloqueo();
		$.ajax({
			type : "POST",
			url : url,
			data : $('#frmGuardarPersona').serialize(),
			success : function(persona) {
				if (persona == "") {
					msg_error("Error al registrar persona");
				} else {
					msg_exito("Éxito al registrar persona");
					$('#nroDocumentoPaciente').val(persona.nroDocumento);
					$('#tipoDocumentoPaciente').val(
							persona.tipoDocumento.idRegistro);
					$('#personaApellidoPaterno').val(persona.apellidoPaterno);
					$('#personaApellidoMaterno').val(persona.apellidoMaterno);
					$('#personaNombres').val(persona.nombres);
					$('#personaCodigo').val(persona.codigo);
					var todate = new Date(persona.fechaNac);
					var dia = todate.getDate();
					var mes = todate.getMonth() + 1;
					var anio = todate.getFullYear();
					var fechaActual = new Date();
					var anioActual = fechaActual.getFullYear();
					var edad = anioActual - anio;
					$('#edadPersona').val(edad);

					$('#sexoPaciente').val(persona.sexo.codReg);
					$('#personaDireccion').val(persona.direccion);

					if (persona.ubigeoDireccion.codigoUbigeo != "") {
						$('#ubigeoDireccion').val(
								persona.ubigeoDireccion.codigoUbigeo);
						$('#codigoRegistroUbigeoDireccion').val(
								persona.ubigeoDireccion.codigoRegistro);
						$('#nombreUbigeoDireccion').val(
								persona.ubigeoDireccion.nombreUbigeo);
					} else {
					}
					$('#modalPersona').modal('hide');
				}
			},

			error : function(xhr, status, er) {
				console.log("error: " + xhr + " status: " + status + " er:"
						+ er);
			},
			complete : function() {
				finBloqueo();
			}
		});
	}
}

function llenarArticuloIndex(index) {
	var contextPath = $('#contextPath').val();
	var htmlTabla = "";
	var item = 0;
	var valida = "0";
	console.log("index" + index);
	$
			.ajax({
				type : "GET",
				// data: "entidad=" + entidad,

				url : contextPath
						+ "/ventaController/refrescarListaArticulos?index="
						+ index,
				success : function(data) {
					if (data != null) {
						for (var i = 0; i < listadoArticulo.length; i++) {
							var objVentaItem = listadoArticulo[i];
							if (objVentaItem.stock.articulo.codigo == data.stock.articulo.codigo) {
								valida = "1";
							}
						}
						if (valida == "1") {
							msg_advertencia("El exámen ya fue ingresado.");
						} else {
							listadoArticulo.push(data);
							for (var i = 0; i < listadoArticulo.length; i++) {
								var objVentaItem = listadoArticulo[i];
								item = item + 1;
								htmlTabla += "<tr>" + "<td>"
										+ item
										+ "</td>"
										+ "<td>"
										+ objVentaItem.stock.articulo.nombre
										+ "</td>"
										+ "<td>"
										+ objVentaItem.stock.articulo.tipoPresentacion.descripcionLarga
										+ "</td>"
										+ "<td>"
										+ objVentaItem.stock.stock
										+ "</td>"
										+ "<td> <input type='text' class='form-control' "
										+ "id="
										+ [ objVentaItem.stock.codigo ]
										+ " required='required' "
										+ "value ='"
										+ objVentaItem.cantidad
										+ "' "
										+ "maxlength='3' "
										+ "onkeypress= 'return soloNumeros(event);' "
										+ "oninput=\"cambiarCantidad('"
										+ [ objVentaItem.stock.codigo ]
										+ "');\" /></td>"
										+ "<td>"
										+ objVentaItem.cantidadFaltante
										+ "</td>"
										+ "<td>"
										+ objVentaItem.stock.sPrecio
										+ "</td>"
										+ "<td>"
										+ objVentaItem.sImporte
										+ "</td>"
										+ "<td>"
										+ "<button type='button'"
										+ " class='btn btn-outline-danger btn-sm' "
										+ " data-toggle='tooltip'  data-placement='top'  title='Eliminar'"
										+ "  onclick=\"confirmar_eliminar('"
										+ [ objVentaItem.stock.codigo ]
										+ "','1');\""
										+ " data-original-title='Eliminar'"
										+ " id='agregarEspecialidad'>"
										+ "  <i class='fas fa-trash'></i></button> "
										+ "</td>" + "</tr>";
							}
							// console.log(htmlTabla);
							// $("#idBtnCerrarModalCIEX").trigger("click");
							$('#idbodyStock').empty();
							$('#idbodyStock').html(htmlTabla);
							var importe = 0.00;
							for (var i = 0; i < listadoArticulo.length; i++) {
								var objVentaItem = listadoArticulo[i];
								importe = importe
										+ Number(objVentaItem.subtotal);
							}
							$('#txtCajaImporteTotal').val(importe.toFixed(2));
							$('#txtCajaImporteTotalHidden').val(
									importe.toFixed(2));
						}
					}

				},
				error : function(xhr, status, er) {
					console.log("error: " + xhr + " status: " + status + " er:"
							+ er);
					if (xhr.status == 500) {
						console.log(er);
						// Error_500(er);
					}
					if (xhr.status == 901) {
						console.log(er);
						// spire_session_901(er);
					}

				}
			});
}

function buscarPersonaNroDoc() {

	var contextPath = $('#contextPath').val();
	var numeroDocumento = $('#nroDocumentoPaciente').val();
	var tipoDocumento = $('#tipoDocumentoPaciente').val();
	var htmlTabla = "";
	console.log("consultarPersonaPorDocumento tipoDocumentoPaciente "
			+ tipoDocumentoPaciente);
	if (tipoDocumento == null || tipoDocumento == "") {
		msg_advertencia("Seleccione tipo de documento");
		return;
	} else if (numeroDocumento == null || numeroDocumento.trim() == "") {
		msg_advertencia("Ingrese número de documento");
		return;
	} else if (tipoDocumento == '000001' && numeroDocumento.trim().length != 8) {
		msg_advertencia("Número de dni debe contener 8 dígitos.")
		return;
	} else if (tipoDocumento == '000002' && numeroDocumento.trim().length < 9) {
		msg_advertencia("Número de pasaporte incorrecto.")
		return;
	} else {
		// console.log("validarDni " + numeroDocumento );
		iniciarBloqueo();
		$
				.ajax({
					type : "GET",
					url : contextPath
							+ "/ventaController/consultarPersonaPorDocumento?tipoDocumento="
							+ tipoDocumento + "&numero=" + numeroDocumento,

					success : function(persona) {
						if (numeroDocumento.length < 7) {
							msg_advertencia("Número de documento incorrecto.");

						} else {

							if (persona != null) {
								console.log("persona.length " + persona.length);

								if (persona.length != 0) {
									$('#nroDocumentoPaciente').val(
											persona.nroDocumento);
									$('#tipoDocumentoPaciente').val(
											persona.tipoDocumento.idRegistro);
									$('#personaApellidoPaterno').val(
											persona.apellidoPaterno);
									$('#personaApellidoMaterno').val(
											persona.apellidoMaterno);
									$('#personaNombres').val(persona.nombres);
									$('#personaCodigo').val(persona.codigo);
									/*
									 * var todate = new Date(persona.fechaNac);
									 * var dia = todate.getDate(); var mes =
									 * todate.getMonth() + 1; var anio =
									 * todate.getFullYear(); var fechaActual =
									 * new Date(); var anioActual =
									 * fechaActual.getFullYear(); var edad =
									 * anioActual - anio;
									 * $('#edadPersona').val(edad);
									 * 
									 * $('#sexoPaciente').val(persona.sexo.codReg);
									 * $('#personaDireccion').val(
									 * persona.direccion);
									 * 
									 * if (persona.ubigeoDireccion.codigoUbigeo !=
									 * "") {
									 * $('#ubigeoDireccion').val(persona.ubigeoDireccion.codigoUbigeo);
									 * $('#codigoRegistroUbigeoDireccion').val(persona.ubigeoDireccion.codigoRegistro);
									 * $('#nombreUbigeoDireccion').val(persona.ubigeoDireccion.nombreUbigeo);
									 * }else{ }
									 * 
									 */
								} else {
									msg_advertencia("¡La persona no se encuentra registrada!")
									limpiarPersona();
								}

							} else {
								msg_advertencia("¡No se encontraron registros.!")
								limpiarPersona();
							}
						}
					},
					error : function(xhr, status, er) {
						console.log("error: " + xhr + " status: " + status
								+ " er:" + er);
						if (xhr.status == 500) {
							console.log(er);
							// Error_500(er);
						}
						if (xhr.status == 901) {
							console.log(er);
							// spire_session_901(er);
						}

					}
				});
		finBloqueo();
	}
}

function cambiarCantidad(objeto) {
	// debugger;
	var nombreObjet = "#" + objeto + ""
	console.log("nombreObjet " + nombreObjet);
	var cantidad = $(nombreObjet).val();
	var htmlTabla = "";
	var item = 0;
	console.log("cantidad " + cantidad);

	for (var i = 0; i < listadoArticulo.length; i++) {
		var objVentaItem = listadoArticulo[i];
		if (objVentaItem.stock.codigo == objeto) {
			objVentaItem.cantidad = cantidad;
			objVentaItem.subtotal = (objVentaItem.precio * cantidad).toFixed(2);
			objVentaItem.sImporte = (objVentaItem.precio * cantidad).toFixed(2);
			console.log("objExamen.importe:: " + objVentaItem.subtotal)
		}
	}
	for (var i = 0; i < listadoArticulo.length; i++) {
		var objVentaItem = listadoArticulo[i];
		item = item + 1;
		htmlTabla += "<tr>" + "<td>"
				+ item
				+ "</td>"
				+ "<td>"
				+ objVentaItem.stock.articulo.nombre
				+ "</td>"
				+ "<td>"
				+ objVentaItem.stock.articulo.tipoPresentacion.descripcionLarga
				+ "</td>"
				+ "<td>"
				+ objVentaItem.stock.stock
				+ "</td>"
				+ "<td> <input type='text' class='form-control' "
				+ "id="
				+ [ objVentaItem.stock.codigo ]
				+ " required='required' "
				+ "value ='"
				+ objVentaItem.cantidad
				+ "' "
				+ "maxlength='3' "
				+ "onkeypress= 'return soloNumeros(event);' "
				+ "oninput=\"cambiarCantidad('"
				+ [ objVentaItem.stock.codigo ]
				+ "');\" /></td>"
				+ "<td>"
				+ objVentaItem.cantidadFaltante
				+ "</td>"
				+ "<td>"
				+ objVentaItem.stock.sPrecio
				+ "</td>"
				+ "<td>"
				+ objVentaItem.sImporte
				+ "</td>"
				+ "<td>"
				+ "<button type='button'"
				+ " class='btn btn-outline-danger btn-sm' "
				+ " data-toggle='tooltip'  data-placement='top'  title='Eliminar'"
				+ "  onclick=\"confirmar_eliminar('"
				+ [ objVentaItem.stock.codigo ] + "','1');\""
				+ " data-original-title='Eliminar'"
				+ " id='agregarEspecialidad'>"
				+ "  <i class='fas fa-trash'></i></button> " + "</td>"
				+ "</tr>";

	}
	$('#idbodyStock').empty();
	$('#idbodyStock').html(htmlTabla);

	var importe = 0.00;
	for (var i = 0; i < listadoArticulo.length; i++) {

		var objVentaItem = listadoArticulo[i];
		importe = importe + Number(objVentaItem.subtotal);
	}

	$('#txtCajaImporteTotal').val(importe.toFixed(2));
	$('#txtCajaImporteTotalHidden').val(importe.toFixed(2));
}

function grabar() {
	var personaCodigo = $('#personaCodigo').val();
	var contextPath = $('#contextPath').val();
	var actionForm = $('#frmGenerarVenta').attr("action");

	if (personaCodigo == "") {
		msg_advertencia("Debe ingresar una persona.");
		return;
	}
	console.log("personaCodigo:: " + personaCodigo);
	var myFormulario = $('#frmGenerarVenta');

	if (!myFormulario[0].checkValidity()) {
		msg_advertencia("Debe completar los campos requeridos(*) correctamente");

	} else {
		if (listadoArticulo.length == 0) {
			msg_advertencia("Ingrese al menos una artículo.");
			return;
		}

		for (var i = 0; i < listadoArticulo.length; i++) {
			var objExamen = listadoArticulo[i];
			if (objExamen.cantidad == '' || objExamen.cantidad == '0') {
				msg_advertencia("Ingrese cantidad mayor a 0");
				return;
			}
		}
		iniciarBloqueo();
		$.ajax({
			contentType : "application/json",
			type : "POST",
			data : JSON.stringify(listadoArticulo),
			url : contextPath + "/ventaController/grabarVenta",

			success : function(data) {
				// console.log("SUCCESS: ", data);
				if (data == "") {
					msg_error("Error al registrar venta");
				} else {
					msg_exito("Éxito al registrar venta");
					// enviarListado();
					$("#btnListado").trigger("click");
				}

			},

			error : function(xhr, status, er) {
				console.log("error: " + xhr + " status: " + status + " er:"
						+ er);
				// msg_error();

			},
			complete : function() {
				finBloqueo();

			}
		});
	}
}

function eliminarArticulo(codigo) {
	var htmlTabla = "";
	var item = 0;

	console.log("codigo " + codigo);
	for (var i = 0; i < listadoArticulo.length; i++) {
		var objVentaItem = listadoArticulo[i];
		if (objVentaItem.stock.codigo == codigo) {
			console.log("objVentaItem.stock.codigo "
					+ objVentaItem.stock.codigo);
			listadoArticulo.splice(i, 1);
		}
	}
	for (var i = 0; i < listadoArticulo.length; i++) {
		var objVentaItem = listadoArticulo[i];
		item = item + 1;
		htmlTabla += "<tr>" + "<td>"
				+ item
				+ "</td>"
				+ "<td>"
				+ objVentaItem.stock.articulo.nombre
				+ "</td>"
				+ "<td>"
				+ objVentaItem.stock.articulo.tipoPresentacion.descripcionLarga
				+ "</td>"
				+ "<td>"
				+ objVentaItem.stock.stock
				+ "</td>"
				+ "<td> <input type='text' class='form-control' "
				+ "id="
				+ [ objVentaItem.stock.codigo ]
				+ " required='required' "
				+ "value ='"
				+ objVentaItem.cantidad
				+ "' "
				+ "maxlength='3' "
				+ "onkeypress= 'return soloNumeros(event);' "
				+ "oninput=\"cambiarCantidad('"
				+ [ objVentaItem.stock.codigo ]
				+ "');\" /></td>"
				+ "<td>"
				+ objVentaItem.cantidadFaltante
				+ "</td>"
				+ "<td>"
				+ objVentaItem.stock.sPrecio
				+ "</td>"
				+ "<td>"
				+ objVentaItem.sImporte
				+ "</td>"
				+ "<td>"
				+ "<button type='button'"
				+ " class='btn btn-outline-danger btn-sm' "
				+ " data-toggle='tooltip'  data-placement='top'  title='Eliminar'"
				+ "  onclick=\"confirmar_eliminar('"
				+ [ objVentaItem.stock.codigo ] + "','1');\""
				+ " data-original-title='Eliminar'"
				+ " id='agregarEspecialidad'>"
				+ "  <i class='fas fa-trash'></i></button> " + "</td>"
				+ "</tr>";
	}
	$('#idbodyStock').empty();
	$('#idbodyStock').html(htmlTabla);
	var importe = 0.00;
	for (var i = 0; i < listadoArticulo.length; i++) {
		var objVentaItem = listadoArticulo[i];
		importe = importe + Number(objVentaItem.subtotal);
	}
	$('#txtCajaImporteTotal').val(importe.toFixed(2));
	$('#txtCajaImporteTotalHidden').val(importe.toFixed(2));
}

function cambiarFinanciamiento() {
	tipoFinanciador = $('#cboTipoFinanciador').val();

	$.ajax({
		contentType : "application/json",
		type : "GET",
		url : contextPath
				+ "/ventaController/cambiarFinanciamiento?financiador="
				+ tipoFinanciador,

		success : function(data) {

		},

		error : function(xhr, status, er) {
			console.log("error: " + xhr + " status: " + status + " er:" + er);

		},
		complete : function() {
		}
	});
}

function limpiarPorTipo(){
	
}
function limpiarPersona() {
	$('#personaApellidoPaterno').val("");
	$('#personaApellidoMaterno').val("");
	$('#personaNombres').val("");
	$('#personaCodigo').val("");
}
