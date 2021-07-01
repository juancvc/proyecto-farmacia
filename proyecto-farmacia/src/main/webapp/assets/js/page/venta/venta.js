var accionRealizar = "";
var codigoRegistro = "";
var swValidaSoloNumero= 1;

function confirmar_eliminar(codigo, tipo) {
	codigoRegistro = codigo;
	accionRealizar = tipo;
	if (tipo == '3') {
		var myFormulario = $('#frmGenerarVenta');
		if (!myFormulario[0].checkValidity()) {
			msg_advertencia("Debe completar los campos requeridos(*) correctamente");

		} else {
			$('#md_confirmacion').modal('show');
		}
	} else {
		$('#md_confirmacion').modal('show');
	}
}

function agregar_accion() {
	$('#md_reg_confirmacion').modal('show');
}

$(document).ready(function() {
	$("#btnConfirmarGeneric").click(function() {
		if (accionRealizar == 3) {
			console.log("anularVenta :: " + codigoRegistro);
			anularVenta(codigoRegistro);
		} else {
			console.log("eliminarArticulo :: " + codigoRegistro);
			eliminarArticulo(codigoRegistro);
		}

		$('#md_confirmacion').modal('hide');
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

	} else if(telefono.length != 0){
		if(telefono.length > 9){
			msg_advertencia("Ingrese número de celular correcto.");
		} 
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
							if (objVentaItem.stock.codigo == data.stock.codigo) {
								valida = "1";
							}
						}
						if (valida == "1") {
							msg_advertencia("El artículo ya fue ingresado.");
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
										+ "onchange=\"cambiarCantidad('"
										+ [ objVentaItem.stock.codigo ]
										+ "');\" /></td>"
										+ "<td>"
										+ objVentaItem.stock.articulo.codigoSismed
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
		msg_advertencia("Seleccione tipo de documento.");
		return;
	} else if (numeroDocumento == null || numeroDocumento.trim() == "") {
		msg_advertencia("Ingrese número de documento.");
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
				+ "onchange=\"cambiarCantidad('"
				+ [ objVentaItem.stock.codigo ]
				+ "');\" /></td>"
				+ "<td>"
				+ objVentaItem.stock.articulo.codigoSismed
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

function cargarPersona() {
	var personaCodigo = $('#personaCodigo').val();
	var contextPath = $('#contextPath').val();
	var htmlTabla = "";
	console.log("personaCodigo " + personaCodigo);
	if (personaCodigo == null || personaCodigo == "") {
		return;
	} else {

		// iniciarBloqueo();
		$.ajax({
			type : "GET",
			url : contextPath + "/ventaController/cargarPersona?codigo="
					+ personaCodigo,

			success : function() {

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
		// finBloqueo();
	}
}
 
 
function grabar() {
	var contextPath = $('#contextPath').val();
	var actionForm = $('#frmGenerarVenta').attr("action");
	var url = contextPath + "/ventaController/llenarVenta";
	var myFormulario = $('#frmGenerarVenta');
	var estadoCuenta = $('#txtEstadoCuenta').val();
	console.log("actionForm " + actionForm);

	if (!myFormulario[0].checkValidity()) {
		msg_advertencia("Debe completar los campos requeridos(*) correctamente");

	}else if (estadoCuenta == 'LIQUIDADO') {
		msg_advertencia("La cuenta se encuentra liquidada, no se puede realizar la carga.");

	}else {
		$.ajax({
			type : "GET",
			url : url,
			data : $('#frmGenerarVenta').serialize(),
			success : function(data) {
				grabarDetalle()
			},

			error : function(xhr, status, er) {
				console.log("error: " + xhr + " status: " + status + " er:"
						+ er);
				// msg_error();

			},
			complete : function() {
			}
		});
	}
}

function grabarDetalle() {
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
			}else{
				console.log("objExamen.cantidad " + objExamen.cantidad);
				validarSoloNumeros(objExamen.cantidad);
				if(swValidaSoloNumero == 0){
					msg_advertencia("Sólo se permite valores numéricos en cantidad.");
					return;
				}
			}
		}
		iniciarBloqueo();
		$.ajax({
			contentType : "application/json",
			type : "POST",
			data : JSON.stringify(listadoArticulo),
			url : contextPath + "/ventaController/grabarVenta",

			success : function(venta) {
				 console.log("SUCCESS: ", venta.codigo);
				if (venta.valida == 0) {
				//	msg_advertencia("Sin Stock suficiente"); 
					$("#md_Error").modal('show');
					$("#labelTituloError").html("SIN STOCK SUFICIENTE");
					$("#txt_detalleError").html(venta.error);
					//alert("");
				}else if (venta.valida == 3) {
				//	msg_advertencia("Sin Stock suficiente"); 
					$("#md_Error").modal('show');
					$("#labelTituloError").html("MONTO TOPE INSUFICIENTE");
					$("#txt_detalleError").html(venta.error);
					//alert("");
				}else if (venta.valida == 1){
					msg_exito("Éxito al registrar venta");
					// enviarListado();
					// verTicket();
					//document.getElementById("btnNuevo").click();
				}else{
					msg_error("Error al registrar venta");
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
				+ "onchange=\"cambiarCantidad('"
				+ [ objVentaItem.stock.codigo ]
				+ "');\" /></td>"
				+ "<td>"
				+ objVentaItem.stock.articulo.codigoSismed
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

function cambiarTipoComprobante() {
	tipoComprobante = $('#cboTipoComprobante').val();
	var contextPath = $('#contextPath').val();
	$.ajax({
		contentType : "application/json",
		type : "GET",
		url : contextPath
				+ "/ventaController/cambiarTipoComprobante?idTipoComprobante="
				+ tipoComprobante,

		success : function(data) {
			$('#cboSerie').empty();
			for (var i = 0; i < data.length; i++) {
				objSerie = data[i];
				$('#cboSerie').append($('<option>', {
					value : objSerie.codigo,
					text : objSerie.nroSerie
				}));

			}
		},

		error : function(xhr, status, er) {
			console.log("error: " + xhr + " status: " + status + " er:" + er);

		},
		complete : function() {
		}
	});
}

function limpiarPersona() {
	$('#nroDocumentoPaciente').val("");
	$('#nombrePaciente').val("");
	$('#nroHC').val("");
	$('#cboTipoFinanciador').val(""); 
	$('#personaCodigo').val("");
	$('#descripcionTipoCuenta').val("");
	$('#txtEstadoCuenta').val("");
	
}

/**
 * Función para imprimir ticket
 */
function imprimirIndividual() {
	var contextPath = $('#contextPath').val();
	var x = window.open(contextPath + "/" + "ticketVenta.jsp",
			"toolbar=0,width=780,height=550");
	return true;

}

function verTicket() {

	$("#txt_confir_Vd").html("Ticket de Venta");
	$("#dataInfoModal").empty();

	// $('#modalVerdocumento').modal('show');

	var object = "<object type='application/pdf' width='100%' height='450px'>"
			+ "</object>";

	$("#onshow #dataInfoModal").empty();
	$("#onshow #dataInfoModal").append(object);
}

function buscarDocumento() {
	var contextPath = $('#contextPath').val();
	var nroSerie = $('#nroSerie').val();
	var idVenta = $('#idVenta').val();
	var numeroPeriodo = $('#numeroPeriodo').val();

	$
			.ajax({
				url : contextPath
						+ "/ventaController/buscarVentaPorNumeroDocumento?nroSerie="
						+ nroSerie + "&idVenta=" + idVenta + "&numeroPeriodo="
						+ numeroPeriodo,
				type : 'GET',
				success : function(venta) {
					console.log("venta::" + venta);
					if (venta != "") {
						var todate = new Date(venta.fechaEmision);
						var dia = todate.getDate();
						var mes = todate.getMonth() + 1;
						var anio = todate.getFullYear();

						if (dia.toString().length == 1) {
							dia = "0" + dia;
						}
						if (mes.toString().length == 1) {
							mes = "0" + mes;
						}

						var fecha = dia + "/" + mes + "/" + anio
						$('#personaNombres').val(venta.persona.nombreCompleto);
						$('#personaNroDocumento').val(
								venta.persona.nroDocumento);
						$('#txtEpisodio').val(venta.episodio.codigo);
						$('#txtTipoSeguro').val(
								venta.tipoFinanciador.descripcionCorta);
						$('#txtFechaEmision').val(fecha + " " + venta.hora);
						$('#txtUsuarioEmitio').val(venta.usuarioRegistro);
						$('#txtIdVenta').val(venta.codigo);
						$('#txtNumeroPeriodo').val(venta.numeroPeriodo);
						$('#txtMonto').val("S/. " + venta.importe);
						$('#txtNumero').val(
								venta.serie.nroSerie + "-" + venta.codigo);

					} else {
						msg_advertencia("No se encontraron resultados");
					}

				},
				error : function() {
				}
			});
}

/** *** ANULAR ********* */
function anularVenta(codigoRegistro) {
	var contextPath = $('#contextPath').val();
	var idVenta = $('#txtIdVenta').val();
	var numeroPeriodo = $('#txtNumeroPeriodo').val();
	var numeroDocu = $('#txtNumero').val();
	var motivo = $('#txtMotivo').val();

	$.ajax({
		url : contextPath + "/ventaController/anularVenta?idVenta=" + idVenta
				+ "&numeroPeriodo=" + numeroPeriodo + "&numeroDocu="
				+ numeroDocu + "&motivo=" + motivo,
		type : 'GET',
		success : function(data) {
			if (data == "1") {
				msg_exito("Éxito al anular venta");
				$('#personaNombres').val("");
				$('#personaNroDocumento').val("");
				$('#txtEpisodio').val("");
				$('#txtTipoSeguro').val("");
				$('#txtFechaEmision').val("");
				$('#txtUsuarioEmitio').val("");
				$('#txtIdVenta').val("");
				$('#txtNumeroPeriodo').val("");
				$('#nroSerie').val("");
				$('#idVenta').val("");
				$('#txtMonto').val("");
				$('#txtNumero').val("");
				$('#txtMotivo').val("");
			} else {
				msg_error("Error al anular venta");
			}
		},
		error : function() {
		}
	});
}
/** *** DEVOLUCION ********* */

function refrescarListadoConsumo() {
	var contextPath = $('#contextPath').val();
	var idEpisodio = $('#cboPacienteVenta').val();
	console.log("idEpisodio " + idEpisodio);
	var index = document.getElementById("cboPacienteVenta").selectedIndex;
	console.log("index " + index);
	$.ajax({
		url : contextPath + "/ventaController/listarDevolucion?idEpisodio="
				+ idEpisodio + "&index=" + index,
		type : 'GET',

		success : function(data) {
			// console.log("SUCCESS: ", data);
			$('#idTablaDevolucion').html(data);
		},
		error : function() {
			// console.log("ERROR: ");
		}
	});
}

function grabarDevolucion() {
	var contextPath = $('#contextPath').val();
	var actionForm = $('#frmGenerarDevolucion').attr("action");
	var url = contextPath + "/ventaController/llenarDevolucionCabecera";
	var myFormulario = $('#frmGenerarDevolucion');
	var cantidadAdquirida = 0;
	var cantidadDevuelta = 0;
	var validaCantidad = 0;
	console.log("actionForm " + actionForm);

	if (!myFormulario[0].checkValidity()) {
		msg_advertencia("Debe completar los campos requeridos(*) correctamente");

	} else {

		$("#dataTable tbody tr").each(function(index) {
			$(this).children("td").each(function(index2) {
				if (index2 == 5) {
					input = $(this).children("input");
					cantidadAdquirida = $(input).val();
				}
				if (index2 == 6) {
					input = $(this).children("input");
					cantidadDevuelta = $(input).val();
					
					console.log("cantidadAdquirida " + cantidadAdquirida);
					console.log("cantidadDevuelta " + cantidadDevuelta);

					if (cantidadDevuelta > cantidadAdquirida) {
						console.log("acá mayor ");
						validaCantidad = 1;
						return;
					}
				}
				
			})
		})
		console.log("validaCantidad " + validaCantidad);
		if (validaCantidad == 1) {
			msg_advertencia("La cantidad devuelta no puede ser mayor a la adquirida.");
			return;
		}

		// iniciarBloqueo();
		$.ajax({
			type : "GET",
			url : url,
			data : $('#frmGenerarDevolucion').serialize(),
			success : function(data) {
				grabarDetalleDevolucion()
			},

			error : function(xhr, status, er) {
				console.log("error: " + xhr + " status: " + status + " er:"
						+ er);
				// msg_error();

			},
			complete : function() {
				// finBloqueo();
			}
		});
	}
}

function grabarDetalleDevolucion() {
	// debugger;
	/** RECORRER MENU * */
	var arrayVentasItem = [];
	var subTotal = 0.0; 
	$("#dataTable tbody tr").each(function(index) {
		var asignado, input, idAcceso, idCompo;
		var objArticulo = {
			codigo : ""
		};
		var objStock = {
			codigo : "",
			articulo : objArticulo, 
			lote : "" 
		};

		var objVentaItem = {
			item : 0,
			codigo : "",
			stock : objStock,
			cantidad : 0,
			subtotal : 0,
			precio   : 0,
			venta : objVenta
		};

		var objVenta = {
			codigo : "",
			numero : ""
		};

		$(this).children("td").each(function(index2) {

			if (index2 == 1) { // Columna documento
				input = $(this).children("span");
				objVenta.numero = $(input).html();
				objVenta.codigo  = $(input).attr("id"); 
				console.log("objVenta.codigo " + objVenta.codigo);
				objVentaItem.venta = objVenta; 
			}
			if (index2 == 3) { // Columna articulo
				input = $(this).children("span");
				objStock.codigo  = $(input).attr("id"); 
				objVentaItem.stock = objStock;
			}
			if (index2 == 4) { // Columna lote
				input = $(this).children("span"); 
				objStock.lote = $(input).html();
				console.log("objArticulo.lote " + objStock.lote); 
				objVentaItem.stock = objStock;
			}
			if (index2 == 6) { // Columna cantidad devuelta
				input = $(this).children("input"); 
				objVentaItem.cantidad = $(input).val(); 
			}
			if (index2 == 8) { // Columna cantidad devuelta
				input = $(this).children("span"); 
				objVentaItem.precio = $(input).html(); 
			}
		})
		arrayVentasItem.push(objVentaItem);
	})
	enviarDatosAccesoAjax(arrayVentasItem);
}

function enviarDatosAccesoAjax(arrayVentasItem) {

	var contextPath = $('#contextPath').val();
	var htmlTabla = "";

	// iniciarBloqueo();

	$.ajax({
		contentType : "application/json",
		type : "POST",
		data : JSON.stringify(arrayVentasItem),
		url : contextPath + "/ventaController/asignarDevolucion",
		success : function(data) {
			msg_exito();
			refrescarListadoConsumo();

		},
		error : function(xhr, status, er) {
			msg_error();
			console.log("error: " + xhr + " status: " + status + " er:" + er);
			if (xhr.status == 500) {
				console.log(er);
			}
			if (xhr.status == 901) {
				console.log(er);
			}
		},
		complete : function() {
			$('#contentSubMenuTabla').empty();
			// finBloqueo();
		}
	});
	return false;
}

function tiene_letras(texto){
	   texto = texto.toLowerCase();
	   for(i=0; i<texto.length; i++){
	      if (letras.indexOf(texto.charAt(i),0)!=-1){
	         return 1;
	      }
	   }
	   return 0;
	}

function buscarNroEpisodio(e){
	
	var contextPath = $('#contextPath').val();
	var numeroDocumento = $('#nroDocumento').val(); 
	var htmlTabla = "";
	  
	if (e.keyCode == 13) {
			console.log("consultarPersonaPorDocumento numeroDocumento "
					+ numeroDocumento );
			if (numeroDocumento == null || numeroDocumento.trim() == "") {
				msg_advertencia("Ingrese un número de documento.");
				return;
			
			} else {
				// console.log("validarDni " + numeroDocumento );
				iniciarBloqueo();
				$
						.ajax({
							type : "GET",
							url : contextPath
									+ "/ventaController/consultarCtaCorriente?numero=" + numeroDocumento,

							success : function(cuenta) {
								 if (cuenta != null) {
										console.log("persona.length " + cuenta.length);

										if (cuenta.length != 0) {
											$('#nroDocumentoEpisodio').val(
													cuenta.episodio.numeroEpisodio);
											$('#nroDocumento').val(
													cuenta.episodio.paciente.nroDocumento);
											$('#nombrePaciente').val(
													cuenta.episodio.paciente.nombreCompleto);
											$('#nroHC').val(
													cuenta.episodio.paciente.nroHC);
											console.log("cuenta.episodio.tipoPaciente.idRegistro::" + cuenta.episodio.tipoPaciente.idRegistro)
											$('#cboTipoFinanciador').val(
													cuenta.episodio.tipoPaciente.idRegistro); 
											$('#personaCodigo').val(cuenta.episodio.paciente.codigo);
											$('#descripcionTipoCuenta').val(cuenta.tipoCuentaCorriente.descripcionCorta);
											if(cuenta.sFechaLiquidacion != null){
												$("#md_Error").modal('show');
												$("#labelTituloError").html("CUENTA CORRIENTE LIQUIDADO");
												$("#txt_detalleError").html("La cuenta a sido liquidada el "+ cuenta.sFechaLiquidacion+
														", no se puede cargar consumo en farmacia.");
												$("#txtEstadoCuenta").val("LIQUIDADO");
											}else{
												$("#txtEstadoCuenta").val("ACTIVO");
											}
										} else {
											msg_advertencia("¡La persona no se encuentra registrada!")
											limpiarPersona();
										}

									} else {
										msg_advertencia("¡No se encontraron resultados.!")
										limpiarPersona();
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
}

function validarSoloNumeros(dato){ 
	if( dato != ""){
	   var valoresAceptados = /^[0-9]+$/;
	   try {
		   if (dato.match(valoresAceptados)){
	    	   swValidaSoloNumero = 1; 
	       } else {
	    	   swValidaSoloNumero = 0; 
	      }
		} catch (e) {
			console.log("Error al validar solo número");
			// TODO: handle exception
		}
	      
	}
}

function validarGenerar(){
	var contextPath = $('#contextPath').val();
	path = contextPath + "/ventaController/validarGenerar";
    console.log("ram pam")
	// iniciarBloqueo();

	$.ajax({ 		
		url : path,
		type : 'GET',
		success : function(data) {
			if(data == ""){
				 msg_advertencia("No se encontraron registros para generar archivo.");
			}else{
				document.getElementById("btnGenerar").click();
			}

		},
		error : function(xhr, status, er) {
			msg_error();
			console.log("error: " + xhr + " status: " + status + " er:" + er);
		 
		},
		complete : function() { 
		}
	});
    
}

