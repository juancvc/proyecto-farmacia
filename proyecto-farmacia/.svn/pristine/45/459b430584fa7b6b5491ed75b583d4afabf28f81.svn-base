var indexRegistro = "";
var tipoLlamadoEliminar = "";
var reiterativo ="NO";

function confirmar_accion(tipo, index) {
	indexRegistro = index;
	tipoLlamadoEliminar = tipo;
	// alert(codigoReferencia);
	$('#md_confirmacion').modal('show');

}
function agregar_accion() {
	$('#md_reg_confirmacion').modal('show');
}

$(document).ready(function() {
	$("#btnConfirmarGeneric").click(function() {
		if (tipoLlamadoEliminar == "1") {
			eliminarLugarCampania(indexRegistro);
		} else if (tipoLlamadoEliminar == "2") {
			eliminarCampania(indexRegistro);
		} else if (tipoLlamadoEliminar == "3") {
			eliminarPostulante(indexRegistro);
		}

	});
});

function eliminarPostulante(index) {
	var contextPath = $('#contextPath').val();
	$.ajax({
		url : contextPath + "/bancoController/eliminarPostulante?index="
				+ index,
		type : 'GET',
		success : function(data) {
			$('#md_confirmacion').modal('hide');
			msg_exito();
			refrescarListadoPostulante();
		},
		error : function(request, status, error) {
			alert(error);
		}
	});

};
function refrescarListadoPostulante() {
	var contextPath = $('#contextPath').val();
	$.ajax({
		url : contextPath + "/bancoController/listarPostulantes",
		type : 'GET',
	
		success : function(data) {
			//console.log("SUCCESS: ", data);
			$('#listadoDetallePostulante').html(data);
		},
		error : function() {
			//console.log("ERROR: ");
		}
	});
}
/*******
function refrescarListadoPostulante() {
	var contextPath = $('#contextPath').val();
	var item = 0;
	var htmlTabla = "";
	$
			.ajax({
				url : contextPath + "/bancoController/listarPostulantes",
				type : 'GET',

				success : function(data) {
					if (data != null) {

						for (var i = 0; i < data.length; i++) {
							var objeto = data[i];
							item = item + 1;
							htmlTabla += "<tr>" + "<td>"
									+ item
									+ "</td>"
									+ "<td>"
									+ objeto.persona.nombreCompleto
									+ "</td>"
									+ "<td>"
									+ objeto.campania.lugarCampaniaBean.nombre
									+ "</td>"
									+ "</td>"
									+ "<td>"
									+ formatDateHora(objeto.fechaCreacion)
									+ "</td>"
									+ "</td>"
									+ "<td>"
									+ objeto.nombreUsuarioCreacion
									+ "</td>"
									+ "<td>"
									+ "<a title='Modificar' data-placement='top'"
									+ "data-toggle='tooltip' class='btn btn-outline-success btn-sm'"
									+ "onclick=\"javascript:modificarElementoGenerico('/bancoController/modificarPostulante','"
									+ [ i ]
									+ "');\"'"
									+ "href='#'><i class='icon-pencil'></i></a>"

									+ "<button type='button'"
									+ " class='btn btn-outline-danger btn-sm' "
									+ " data-toggle='tooltip'  data-placement='top'  title='Eliminar'"
									+ " onclick=\"confirmar_accion(3,'" + [ i ]
									+ "');\""
									+ " data-original-title='Eliminar'"
									+ " id='eliminarReferencia'" + [ i ] + ">"
									+ "<i class='icon-trash'></i></button>"
									+ "</td>" + "</tr>";

						}
						// console.log(htmlTabla);
					}
					// console.log("SUCCESS: ", data);
					$('#idBodyListaPostulante').empty();
					$('#idBodyListaPostulante').html(htmlTabla);
				},
				error : function() {
					console.log("ERROR: ");
				}
			});
}
*/
function eliminarLugarCampania(index) {
	var contextPath = $('#contextPath').val();
	$.ajax({
		url : contextPath + "/bancoController/eliminarLugarCampania?index="
				+ index,
		type : 'GET',
		success : function(data) {
			$('#md_confirmacion').modal('hide');
			msg_exito();
			refrescarListadoLugarCampania();
		},
		error : function(request, status, error) {
			alert(error);
		}
	});

};
function refrescarListadoLugarCampania() {
	var contextPath = $('#contextPath').val();
	var item = 0;
	var htmlTabla = "";
	$
			.ajax({
				url : contextPath + "/bancoController/listarLugarCampanias",
				type : 'GET',

				success : function(data) {
					if (data != null) {

						for (var i = 0; i < data.length; i++) {
							var objeto = data[i];
							item = item + 1;
							htmlTabla += "<tr>" + "<td>"
									+ item
									+ "</td>"
									+ "<td>"
									+ objeto.nombre
									+ "</td>"
									+ "<td>"
									+ objeto.ubigeoLugar.detalle
									+ "</td>"
									+ "<td>"
									+ "<a title='Modificar' data-placement='top'"
									+ "data-toggle='tooltip' class='btn btn-outline-success btn-sm'"
									+ "onclick=\"javascript:modificarElementoGenerico('/bancoController/modificarLugarCampania','"
									+ [ i ]
									+ "');\"'"
									+ "href='#'><i class='icon-pencil'></i></a>"

									+ "<button type='button'"
									+ " class='btn btn-outline-danger btn-sm' "
									+ " data-toggle='tooltip'  data-placement='top'  title='Eliminar'"
									+ " onclick=\"confirmar_accion(1,'" + [ i ]
									+ "');\""
									+ " data-original-title='Eliminar'"
									+ " id='eliminarReferencia'" + [ i ] + ">"
									+ "<i class='icon-trash'></i></button>"
									+ "</td>" + "</tr>";

						}
						// console.log(htmlTabla);
					}
					// console.log("SUCCESS: ", data);
					$('#idBodyListaCampania').empty();
					$('#idBodyListaCampania').html(htmlTabla);
				},
				error : function() {
					console.log("ERROR: ");
				}
			});
}

function eliminarCampania(index) {
	var contextPath = $('#contextPath').val();
	$.ajax({
		url : contextPath + "/bancoController/eliminarCampania?index=" + index,
		type : 'GET',
		success : function(data) {
			$('#md_confirmacion').modal('hide');
			msg_exito();
			refrescarListadoCampania();
		},
		error : function(request, status, error) {
			alert(error);
		}
	});

};

function refrescarListadoCampania() {
	var contextPath = $('#contextPath').val();
	var item = 0;
	var htmlTabla = "";
	$
			.ajax({
				url : contextPath + "/bancoController/listarCampanias",
				type : 'GET',

				success : function(data) {
					if (data != null) {

						for (var i = 0; i < data.length; i++) {
							var objeto = data[i];
							var fromDate = new Date(objeto.fechaInicio);
							var fechaInicio = new Date(fromDate)
									.toDateString("dd/MM/yyyy");
							item = item + 1;
							htmlTabla += "<tr>" + "<td>"
									+ item
									+ "</td>"
									+ "<td>"
									+ objeto.lugarCampaniaBean.nombre
									+ "</td>"
									+ "<td>"
									+ formatDate(objeto.fechaInicio)
									+ "</td>"
									+ "<td>"
									+ formatDate(objeto.fechaFin)
									+ "</td>"
									+ "<td>"
									+ objeto.situacion.nombreCorto
									+ "</td>"
									+ "<td>"
									+ "<a title='Modificar' data-placement='top'"
									+ "data-toggle='tooltip' class='btn btn-outline-success btn-sm'"
									+ "onclick=\"javascript:modificarElementoGenerico('/bancoController/modificarCampania','"
									+ [ i ]
									+ "');\"'"
									+ "href='#'><i class='icon-pencil'></i></a>"

									+ "<button type='button'"
									+ " class='btn btn-outline-danger btn-sm' "
									+ " data-toggle='tooltip'  data-placement='top'  title='Eliminar'"
									+ " onclick=\"confirmar_accion(2,'" + [ i ]
									+ "');\""
									+ " data-original-title='Eliminar'"
									+ " id='eliminarReferencia'" + [ i ] + ">"
									+ "<i class='icon-trash'></i></button>"
									+ "</td>" + "</tr>";

						}
						// console.log(htmlTabla);
					}
					// console.log("SUCCESS: ", data);
					$('#idBodyListaCampania').empty();
					$('#idBodyListaCampania').html(htmlTabla);
				},
				error : function() {
					console.log("ERROR: ");
				}
			});
}

function grabarCampania() {
	// debugger;

	var contextPath = $('#contextPath').val();
	var fecha = $('#date').val();
	var fechaHasta = $('#dateHasta').val();
	var actionForm = $('#frmGuardarCampania').attr("action");
	var url = contextPath + "/bancoController/grabarCampania";
	var myFormulario = $('#frmGuardarCampania');

	array_fecha = fecha.split("/")
	var dia = array_fecha[0]
	var mes = (array_fecha[1])
	var ano = (array_fecha[2])

	array_fechaF = fechaHasta.split("/")
	var diaf = array_fechaF[0]
	var mesf = (array_fechaF[1])
	var anof = (array_fechaF[2])

	var fechaIni = new Date(ano, mes, dia)

	var fechaFin = new Date(anof, mesf, diaf)

	// console.log("fechaIni " + fechaIni);
	// console.log("fechaFin " + fechaFin);

	if (!myFormulario[0].checkValidity()) {
		msg_advertencia("Debe completar los campos requeridos(*) correctamente");

	}else if($('#lugarcampaniaCodigo').val()== null || $('#lugarcampaniaCodigo').val() ==''){
		
		msg_advertencia("Debe ingresar lugar de campaña.");
	
	} else if (Date.parse(fechaIni) > fechaFin) {

		msg_advertencia("La fecha de inicio no puede ser mayor a la final.");

	} else {
		iniciarBloqueo();
		$.ajax({
			type : "POST",
			url : url,
			data : $('#frmGuardarCampania').serialize(),
			success : function(data) {
				console.log("SUCCESS: ", data);
				if (data == "") {
					msg_error("Error al registrar Campaña");
				} else {
					msg_exito("Éxito al registrar Campaña");
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

function modificarElementoGenerico(url, idElemento) {
	var contextPath = $('#contextPath').val();
	var urlComplete = contextPath + url;
	doPost(urlComplete, {
		codigo : idElemento
	});
}

function doPost(path, params, method) {
	method = method || "post";

	var form = document.createElement("form");

	form._submit_function_ = form.submit;

	form.setAttribute("method", method);
	form.setAttribute("action", path);

	for ( var key in params) {
		var hiddenField = document.createElement("input");
		hiddenField.setAttribute("type", "hidden");
		hiddenField.setAttribute("name", key);
		hiddenField.setAttribute("value", params[key]);

		form.appendChild(hiddenField);
	}

	document.body.appendChild(form);
	form._submit_function_();
}

function formatDate(date) {
	var d = new Date(date), 
	month = '' + (d.getMonth() + 1), 
	day = '' + d.getDate(), 
	year = d.getFullYear();

	if (month.length < 2)
		month = '0' + month;
	if (day.length < 2)
		day = '0' + day;

	return [ day, month, year ].join('/');
}


function formatDateHora(date) {
	var d = new Date(date), 
	month = '' + (d.getMonth() + 1), 
	day = '' + d.getDate(), 
	year = d.getFullYear() +' '+ d.getHours()+':'+ d.getMinutes();

	if (month.length < 2)
		month = '0' + month;
	if (day.length < 2)
		day = '0' + day;

	return [ day, month, year ].join('/');
}

function buscarPersonaWebService() {

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
	} else if (tipoDocumento == '000002' && numeroDocumento.trim().length != 8) {
		msg_advertencia("Número de dni debe contener 8 dígitos.")
		return;
	} else if (tipoDocumento == '000006' && numeroDocumento.trim().length < 9) {
		msg_advertencia("Número de pasaporte incorrecto.")
		return;
	} else if (tipoDocumento == '000004' && numeroDocumento.trim().length < 9) {
		msg_advertencia("Número de carnet de extranjería incorrecto.")
		return;
	} else {
		// console.log("validarDni " + numeroDocumento );
		iniciarBloqueo();
		$
				.ajax({
					type : "GET",
					url : contextPath
							+ "/bancoController/consultarPersonaPorDocumento?tipoDocumento="
							+ tipoDocumento + "&numero=" + numeroDocumento,

					success : function(persona) {
						if (numeroDocumento.length < 7) {
							msg_advertencia("Número de documento incorrecto.");

						} else {

							if (persona != null) {
								console.log("persona.length " + persona.length);
								 
								if (persona.length != 0) {
									$('#personaApellidoPaterno').val(
											persona.apellidoPaterno);
									$('#personaApellidoMaterno').val(
											persona.apellidoMaterno);
									$('#personaPrimerNombre').val(
											persona.primerNombre);
									$('#personaSegundoNombre').val(
											persona.segundoNombre);
									$('#fotoPaciente').val(persona.fotoCadena);
									$('#foto').val(persona.foto);
									$('#personaCodigo').val(persona.codigo);
									$('#codigoPersonaSigeho').val(
											persona.codigoPersonaSigeho);
									var image = new Image();
									var src = contextPath
											+ "/assets/img/fotoPersonaGenerico.gif";
									if (persona.foto != null) {
										src = "data:image/png;base64,"
												+ persona.foto;
									}
									image.src = src;
									image.alt = "Image"
									// $('#imgFotoPaciente').append(image);

									$("#imgFotoPaciente")
											.attr("src", image.src);

									// $('#tipoDocumentoPaciente').val(persona.tipoDocumento.codReg);
									console.log("persona.fechaNac "
											+ persona.fechaNac);
									var todate = new Date(persona.fechaNac);
									var dia = todate.getDate();
									var mes = todate.getMonth() + 1; // January
																		// is 0!
									var anio = todate.getFullYear();

									var nDia = dia.toString().length;
									console.log(" nDia:: " + nDia);

									if (dia.toString().length == 1) {
										dia = "0" + dia;
									}
									if (mes.toString().length == 1) {
										mes = "0" + mes;
									}
									console.log("dia/" + dia + "mes " + mes
											+ " anio " + anio + "todate "
											+ todate);

									var fechaActual = new Date();

									var anioActual = fechaActual.getFullYear();
									var edad = anioActual - anio;
									$('#edadPersona').val(edad);

									$('#personaFechaNac').val(
											dia + "/" + mes + "/" + anio);
									
									$('#personaFechaNacimiento').val(
											dia + "/" + mes + "/" + anio);
									$('#sexoPaciente').val(persona.sexo.codReg);
									$('#personaDireccion').val(
											persona.direccion);
									$('#estadoCivilPersona').val(
											persona.estadoCivil.codReg);
									$('#personaOcupacion').val(
											persona.ocupacion.codReg);
									$('#personaNivelInstrucion').val(
											persona.nivelInstrucion.codReg);
									$('#personaNacionalidad').val(
											persona.nacionalidad.codReg);
									
									if (persona.ubigeoDireccion.codigoUbigeo != "") {
										$('#ubigeoDireccion').val(persona.ubigeoDireccion.codigoUbigeo);
										$('#codigoRegistroUbigeoDireccion').val(persona.ubigeoDireccion.codigoRegistro);
										$('#nombreUbigeoDireccion').val(persona.ubigeoDireccion.nombreUbigeo);
									}else{
										document
										.getElementById('btnBuscarUbigeoDireccion').disabled = false;
										document
										.getElementById('personaDireccion').disabled = false;
									}
							
									
									
									$('#ubigeoNacimientoCodigoUbigeo')
											.val(
													persona.ubigeoNacimiento.codigoUbigeo);
									$('#codigoRegistroUbigeoNacimiento').val( persona.ubigeoNacimiento.codigoRegistro);
									$('#nombreUbigeoNacimiento')
											.val(
													persona.ubigeoNacimiento.nombreUbigeo);
									$('#ultimaFechaDonancion').val(
											persona.ultimaFechaDonacion);
									$('#origenDatos').val(persona.origenDatos);

									$('#correo').val(persona.correo);
									$('#telefono').val(persona.telefonoNumero);
									$('#codigoCorreo').val(persona.codigoCorreo);
									$('#codigoDireccion').val(persona.codigoDireccion);
									$('#codigoTelefono').val(persona.codigoTelefono);
										if (persona.codigo.length != 0) { 
											$
											.ajax({
												type : "GET",
												url : contextPath
														+ "/bancoController/listarEstadoFisicoPersona?codigoPersona="
														+ persona.codigo,
											
												success : function(data) { 
												 
													if (data != null) {
														if(data.length > 0){
															msg_advertencia("¡Verificar resultado de Tamizaje.")
															document.getElementById('idBtnTamizaje').disabled = false;
															$('#idlistadoDetallePostulanteEstadoFisico').html(data); 
														} 
													}  
												},
												error : function(xhr, status, er) {
													console.log("error: " + xhr + " status: " + status
															+ " er:" + er);
													if (xhr.status == 500) {
														console.log(er); 
													}
													if (xhr.status == 901) {
														console.log(er); 
													} 
												}
											}); 
										}
								} else {

									if (tipoDocumento == '000006' || tipoDocumento == '000004') {
										msg_advertencia("¡No se encontraron registros con ése número de Documento!, ingrese de manera manual.")
										limpiarPorTipo();
										document
												.getElementById('personaApellidoPaterno').disabled = false;
										document
												.getElementById('personaApellidoMaterno').disabled = false;
										document
												.getElementById('personaPrimerNombre').disabled = false;
										document
												.getElementById('personaSegundoNombre').disabled = false;
										document
												.getElementById('personaFechaNac').disabled = false;
										document.getElementById('sexoPaciente').disabled = false;
										document
												.getElementById('personaDireccion').disabled = false;
										document
												.getElementById('estadoCivilPersona').disabled = false;
										document
												.getElementById('personaOcupacion').disabled = false;
										document
												.getElementById('personaNivelInstrucion').disabled = false;
										document
												.getElementById('personaNacionalidad').disabled = false;
										document
												.getElementById('ubigeoDireccion').disabled = false;
										document
												.getElementById('ubigeoNacimientoCodigoUbigeo').disabled = false;
										//document.getElementById('ultimaFechaDonancion').disabled = false;
										document.getElementById('correo').disabled = false;
										document.getElementById('telefono').disabled = false;
										document
												.getElementById('btnBuscarUbigeoNaciemiento').disabled = false;
										document
												.getElementById('btnBuscarUbigeoDireccion').disabled = false;
									} else {
										msg_advertencia("¡No se encontraron registros con ése número de DNI!, corrija.")
										limpiarPorTipo();
									}
								}

							} else {
								msg_advertencia("¡No se encontraron registros.!")
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

function foto(tipoDoc, dni){
	var contextPath = $('#contextPath').val();
	
	$
	.ajax({
		type : "GET",
		url : contextPath
				+ "/bancoController/obtenerFotoPostulante?tipoDocumento="
				+ tipoDoc + "&numero=" + dni,

		success : function(persona) { 

				if (persona != null) {
					if (persona.length != 0) {  
						var image = new Image();
						var src = contextPath
								+ "/assets/img/fotoPersonaGenerico.gif";
						if (persona.foto != null) {
							src = "data:image/png;base64,"
									+ persona.foto;
						}
						image.src = src;
						image.alt = "Image"
						// $('#imgFotoPaciente').append(image);

						$("#imgFotoPaciente")
								.attr("src", image.src);

						// $('#tipoDocumentoPaciente').val(persona.tipoDocumento.codReg); 
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
	
	
}
function ubigeoCargarModal(tipoLlamado) {
	var contextPath = $('#contextPath').val();
	// var codigoLengua = $('#codigoLengua').val(); //
	// document.getElementById("codigoLengua").value;

	path = contextPath + "/ubigeoController/listadoUbigeoModal";
	// alert("path " + path)
	iniciarBloqueo();
	$.ajax({
		type : "POST",
		url : path,

		success : function(data) {
			// console.log("SUCCESS: ", data);
			$("#modalUbigeo").html(data);
			$('#tipoLlamado').val(tipoLlamado);
			$("#modalUbigeo").modal('show');
		},
		error : function(request, status, error) {
			console.log("ERROR: " + error);
		}
	});
	finBloqueo();
}


function buscarTamizaje() {
	var contextPath = $('#contextPath').val();
	var personaCodigo = $('#personaCodigo').val();
	var numeroDocumento = $('#nroDocumentoPaciente').val();
	
	path = contextPath + "/bancoController/buscarTamizaje?codigoPerso="+personaCodigo
	+"&nroDocumento="+numeroDocumento;
	// alert("path " + path) 
	$.ajax({
		type : "POST",
		url : path,

		success : function(data) {
			// console.log("SUCCESS: ", data);
			$("#modalTamizaje").html(data); 
			$("#modalTamizaje").modal('show');
		},
		error : function(request, status, error) {
			console.log("ERROR: " + error);
		}
	}); 
}

function buscarCampania(situacion) {
	var contextPath = $('#contextPath').val();
	path = contextPath + "/bancoController/campaniasModal?codigoSitu="+situacion;
	// iniciarBloqueo();
	$.ajax({
		type : "POST",
		url : path,

		success : function(data) {
			// console.log("SUCCESS: ", data);
			$("#modalCampania").html(data);
			$("#modalCampania").modal('show');
		},
		error : function(request, status, error) {
			console.log("ERROR: " + error);
		}
	});
	// finBloqueo();
}

function llenarCampaniaIndex(index) {
	var contextPath = $('#contextPath').val();
	path = contextPath + "/bancoController/enviarcampania?index=" + index;
	iniciarBloqueo();
	$.ajax({
		type : "GET",
		url : path,

		success : function(data) {
			// console.log("SUCCESS: ", data);
			$("#campaniaCodigo").val(data.codigo);
			$("#campaniaNombre").val(data.lugarCampaniaBean.nombre);
			$("#nombreCampaniaBean").val(data.lugarCampaniaBean.nombre);
			$("#campaniaCodigoRegistro").val(data.codigo);
			$("#campaniaPeriodo").val(data.numeroPeriodo);
			$("#campaniaVersion").val(data.numeroVersion);
			
			$('#modalCampania').modal('hide');
			
			$("#btnBuscarPostulantes").trigger("click");
		},
		error : function(request, status, error) {
			console.log("ERROR: " + error);
		}
	});
	finBloqueo();
}


function llenarLugarCampaniaIndex(index) {
	var contextPath = $('#contextPath').val();
	path = contextPath + "/bancoController/enviarLugarcampania?index=" + index;
	iniciarBloqueo();
	$.ajax({
		type : "GET",
		url : path,

		success : function(data) {
			// console.log("SUCCESS: ", data);
			$("#lugarcampaniaCodigo").val(data.codigo);
			$("#lugarcampaniaCodigoRegistro").val(data.codigo);
			$("#lugarcampaniaNombre").val(data.nombre);
			$('#modalCampania').modal('hide');
		},
		error : function(request, status, error) {
			console.log("ERROR: " + error);
		}
	});
	finBloqueo();
}


function llenarUbigeoIndex(index) {
	var contextPath = $('#contextPath').val();
	var tipoLlamado = $('#tipoLlamado').val();
	path = contextPath + "/ubigeoController/enviarUbigeo?index=" + index
			+ "&tipo=" + tipoLlamado;
	iniciarBloqueo();
	$.ajax({
		type : "GET",
		url : path,

		success : function(data) {
			if (tipoLlamado == 1) {
				$('#ubigeoNacimientoCodigoUbigeo').val(data.codigoUbigeo);
				$('#nombreUbigeoNacimiento').val(data.detalle);
				$('#codigoRegistroUbigeoNacimiento').val(data.codigoRegistro);
			} else {
				$('#ubigeoDireccion').val(data.codigoUbigeo);
				$('#nombreUbigeoDireccion').val(data.detalle);
				$('#codigoRegistroUbigeoDireccion').val(data.codigoRegistro);

			}

			$('#modalUbigeo').modal('hide');
		},
		error : function(request, status, error) {
			console.log("ERROR: " + error);
		}
	});
	finBloqueo();
}

function limpiarPorTipo() {
	var contextPath = $('#contextPath').val();
	$('#personaApellidoPaterno').val("");
	$('#personaApellidoMaterno').val("");
	$('#personaPrimerNombre').val("");
	$('#personaSegundoNombre').val("");
	$('#fotoPaciente').val("");
	$('#personaCodigo').val("");
	$('#codigoPersonaSigeho').val("");
	$('#personaFechaNac').val("");
	$('#sexoPaciente').val("");
	$('#personaDireccion').val("");
	$('#estadoCivilPersona').val("");
	$('#personaOcupacion').val("");
	$('#personaNivelInstrucion').val("");
	$('#personaNacionalidad').val("");
	$('#ubigeoDireccion').val("");
	$('#nombreUbigeoDireccion').val("");
	$('#ubigeoNacimientoCodigoUbigeo').val("");
	$('#nombreUbigeoNacimiento').val("");
	$('#ultimaFechaDonancion').val("");
	$('#correo').val("");
	$('#telefono').val("");
	$('#edadPersona').val("");
	$('#origenDatos').val("");
	var image = new Image();
	var src = contextPath + "/assets/img/fotoPersonaGenerico.gif";
	image.src = src;
	image.alt = "Image"
	$("#imgFotoPaciente").attr("src", image.src);
	$("#nroDocumentoPaciente").focus();

	var tipoDocumento = $('#tipoDocumentoPaciente').val();

	if (tipoDocumento == '000006' || tipoDocumento == '000004') {
		document.getElementById('personaNacionalidad').disabled = false;
		$('#codigoRegistroUbigeoNacimiento').val("002086");
		$('#ubigeoNacimientoCodigoUbigeo').val("999999");
		$('#nombreUbigeoNacimiento').val(" /  / PROCEDENCIA EXTRANJERA");
	} else {
		document.getElementById('personaNacionalidad').disabled = true;
	}
	document.getElementById('personaApellidoPaterno').disabled = true;
	document.getElementById('personaApellidoMaterno').disabled = true;
	document.getElementById('personaPrimerNombre').disabled = true;
	document.getElementById('personaSegundoNombre').disabled = true;
	document.getElementById('personaFechaNac').disabled = true;
	document.getElementById('sexoPaciente').disabled = true;
	document.getElementById('personaDireccion').disabled = true;
	document.getElementById('estadoCivilPersona').disabled = true;
	document.getElementById('ubigeoDireccion').disabled = true;
	document.getElementById('nombreUbigeoDireccion').disabled = true;
	document.getElementById('ubigeoNacimientoCodigoUbigeo').disabled = true;
	document.getElementById('nombreUbigeoNacimiento').disabled = true;
	//document.getElementById('ultimaFechaDonancion').disabled = true;
	document.getElementById('btnBuscarUbigeoNaciemiento').disabled = true;
	document.getElementById('btnBuscarUbigeoDireccion').disabled = true;
}

function guardarPostulante() {
	// debugger;
	var htmlTabla = "";
	var contextPath = $('#contextPath').val();
	var actionForm = $('#frmGuardarDonante').attr("action");
	var url = contextPath + "/bancoController/grabarPostulante";
	var myFormulario = $('#frmGuardarDonante');
	var telefono = $('#telefono').val();
	var codigoRegistroUbigeoDireccion = $('#codigoRegistroUbigeoDireccion').val();
	
	// console.log("fechaIni " + fechaIni);
	// console.log("fechaFin " + fechaFin);

	if (!myFormulario[0].checkValidity()) {
		msg_advertencia("Debe completar los campos requeridos(*) correctamente");

	} else if(telefono.length < 7){
		msg_advertencia("Ingrese número de celular correcto.");
		
	}else if(codigoRegistroUbigeoDireccion.length == 0){
		msg_advertencia("Ingrese ubigeo de dirección.");
		
	}else {
		iniciarBloqueo();
		$.ajax({
			type : "POST",
			url : url,
			data : $('#frmGuardarDonante').serialize(),
			success : function(data) {
				console.log("SUCCESS: ", data);
				if (data == "") {
					msg_error("Error al registrar postulante");
				} else {
					msg_exito("Éxito al registrar postulante");
				 
				 /**   const button = document.createElement('input');
				    button.type = 'button';
				    button.innerText = 'Haz Click';
				    button.id ="btnLlamarModificar"; 
				 //   button.attachEvent('onclick', 'javascript:modificarElementoGenerico(/bancoController/modificarPostulante,'+ data.index + ')');
				    document.body.appendChild(button);
				    if (button.addEventListener)

				    {

				    	button.addEventListener('click', mifuncion(data.index),false);

				    } else { 

				    	button.attachEvent('onclick', mifuncion(data.index));

				    }
				 //   agregarBoton('btnLlamarModificar','modificar','javascript:modificarElementoGenerico(/bancoController/modificarPostulante,'+ data.index + ')');
				    */
				    var inputTag = document.createElement("div");              
				    inputTag.innerHTML = 
				    	"<input type = 'button' id='btnLlamarModificar' value = 'oooh'"+
				    	"onClick =javascript:modificarElementoGenerico(\'/bancoController/modificarPostulante\',\'"+ data.index +"\');>";    
				    	
				    document.body.appendChild(inputTag);
				  //  "onclick=\"especialidadCargarModal('"+[objCIEX.codReg]+"');\""+
					$("#btnLlamarModificar").trigger("click");
					
		/**			document.getElementById('btnGuardarPostulante').disabled = true;
					document.getElementById('btnImprimirTicket').disabled = false;
					// enviarListado();
				//	$("#btnListado").trigger("click");
					console.log("codigo data " + data.numeroPostulante);
					
					htmlTabla += "<tr>" + "<td class='centrado'  colspan='2'><img id='barcode1'/>"
					+ "</td></tr>"
					+ "<tr>" + 
						"<td class='cantidad'>POSTULANTE</td>"+ 
						"<td class='producto'>"+ data.persona.nombreCompleto+"</td>"
					+ "</tr>"
					+ "<tr>" + 
					"<td class='cantidad'>N° DOCUMENTO</td>"+ 
					"<td class='producto'>"+ data.persona.nroDocumento+"</td>"
				+ "</tr>"
					JsBarcode("#barcode1", data.numeroPostulante);
					$('#idBodyTicket').empty();
					$('#idBodyTicket').html(htmlTabla);
					*/
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

function mifuncion(index)

{

	'javascript:modificarElementoGenerico(/bancoController/modificarPostulante,'+ index + ')';

// alert("se ha realizado click" + index);

}
function agregarBoton(htmlID, texto, funcion) {
	var o=document.getElementById(htmlID);
	o.html+='<input type="button" value="'+texto+'" onclick="'+funcion+'">';
}
 
function grabarLugarCampania() {
	// debugger;

	var contextPath = $('#contextPath').val();
	var actionForm = $('#frmGuardarLugarCampania').attr("action");
	var url = contextPath + "/bancoController/grabarLugarCampania";
	var myFormulario = $('#frmGuardarLugarCampania');

	if (!myFormulario[0].checkValidity()) {
		msg_advertencia("Debe completar los campos requeridos(*) correctamente");

	}else if($('#ubigeoNacimientoCodigoUbigeo').val()== null || $('#ubigeoNacimientoCodigoUbigeo').val() ==''){
		msg_advertencia("Debe ingresar el ubigeo.");
	}else {

		$.ajax({
			type : "GET",
			data : $('#frmGuardarLugarCampania').serialize(),
			url : contextPath + "/bancoController/validarExisteLugarCampania",
			success : function(data) {
				console.log("SUCCESS: ", data);
				if (data == "1") {
					msg_advertencia("El lugar de campaña ya fue registrado.");
				} else {
					iniciarBloqueo();
					$.ajax({
						type : "POST",
						url : url,
						data : $('#frmGuardarLugarCampania').serialize(),
						success : function(data) {
							console.log("SUCCESS: ", data);
							if (data == "") {
								msg_error("Error al registrar lugar de campaña");
							} else {
								msg_exito("Éxito al registrar lugar de Campaña");
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
			},

			error : function(xhr, status, er) {
				console.log("error: " + xhr + " status: " + status + " er:"
						+ er); 

			},
			complete : function() {
			}
		}); 
	}
}

function buscarLugarCampania() {
	var contextPath = $('#contextPath').val();
	path = contextPath + "/bancoController/lugarCampaniasModal";
	// iniciarBloqueo();
	$.ajax({
		type : "POST",
		url : path,

		success : function(data) {
			// console.log("SUCCESS: ", data);
			$("#modalCampania").html(data);
			$("#modalCampania").modal('show');
		},
		error : function(request, status, error) {
			console.log("ERROR: " + error);
		}
	});
	// finBloqueo();
}

function guardarEstadoFisico() {
	// debugger;

	var contextPath = $('#contextPath').val();
	var fecha = $('#date').val();
	var fechaHasta = $('#dateHasta').val();
	var actionForm = $('#frmGuardarEstadoFisico').attr("action");
	var url = contextPath + "/evaluacionController/updateEstadoFisico";
	var myFormulario = $('#frmGuardarEstadoFisico'); 

	if (!myFormulario[0].checkValidity()) {
		msg_advertencia("Debe completar los campos requeridos(*) correctamente");

	} else {
		iniciarBloqueo();
		$.ajax({
			type : "POST",
			url : url,
			data : $('#frmGuardarEstadoFisico').serialize(),
			success : function(data) {
				console.log("SUCCESS: ", data);
				if (data == "") {
					msg_error("Error al registrar Evaluación");
				} else {
					msg_exito("Éxito al registrar Evaluación");
					// enviarListado();
					$("#btnListadoEvaluacion").trigger("click");
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
/**********************PRE DONANTE**************************/



function calculaIMC(){  
	  //declaramos las variables
	  var peso, altura, imc , valorIMC , vts, MC, imcDescripcion; 
	  peso = $('#pesoPostulante').val();
	//  console.log("pesoPostulante " + document.getElementById("pesoPostulante").value );
	  altura =  $('#tallaPostulante').val();
	  //comprobamos que los campos
	  //no vengan vacíos
	  if(peso!=""){
		  vts = peso*10
		    $('#volumenSangrePostulante').val(vts); //document.getElementById("imcPostulante").value=imc.toFixed(2);
		    $('#regVolumenSangrePostulante').val(vts);
	  }else{ 
		    $('#volumenSangrePostulante').val(""); //document.getElementById("imcPostulante").value=imc.toFixed(2);
		    $('#regVolumenSangrePostulante').val("");
	  }
	  if(peso!="" && altura!=""){
	    //aplicamos la fórmula
		    altura = parseInt(altura)/100;
		    imc=peso/(altura*altura);
		    console.log("imc " + imc.toFixed(2));
		    MC = imc.toFixed(2);
			if(MC<18){
				imcDescripcion = "BAJO DE PESO";														
			}else if(MC>=18 && MC<=24.9){
				imcDescripcion = "NORMAL";			
			}else if(MC>=25 && MC<=26.9){
				imcDescripcion = "SOBREPESO";			
			}else if(MC>=27 && MC<=29.9){
				imcDescripcion = "OBESIDAD LEVE";			
			}else if(MC>=30 && MC<=39.9){
				imcDescripcion ="OBESIDAD MODERADA";			
			}else if(MC>=40){
				imcDescripcion = "OBESIDAD SEVERA";			
			}else{
				imcDescripcion = "DATOS NO CORRECTOS";		
			}
			
		    $('#imcPostulante').val(imcDescripcion); //document.getElementById("imcPostulante").value=imc.toFixed(2);
		    $('#codigoIMCPostulante').val(imcDescripcion);
	  }else{
		    $('#imcPostulante').val(""); //document.getElementById("imcPostulante").value=imc.toFixed(2);
		    $('#codigoIMCPostulante').val("");
	  }
	}


function grabarRespuestas(){
	console.log("grabarRespuestas");
	var codigoPost = $('#codigoPostulante').val();
	var codPersoPost =$('#personaCodigo').val();
	var contextPath = $('#contextPath').val(); 
	  var arrayMenus = [];
		
		/** RECORRER MENU **/
	    $("#dataTable tbody tr").each(function (index) 
	    {
	    	var rptPregunta,input,idAcceso,idRegistro, obs;
	    	
	    	var objPreguntas = {
	    	  		codReg : 0	
	    	  	};
	    	var objPersona = {
	    			codigo : codPersoPost	
	    	  	};
	    	var objPostulante = {
	    	  		codigo : codigoPost	,
	    	  		persona : objPersona
	    	  	};
	    	
			var objAcceso = {
				item 		: 0,
				codigo		: 0,
				respuesta	: 'NO',
				observacion	: '',
				postulanteBean	: objPostulante,
				pregunta	: objPreguntas
		  	};
			
	        $(this).children("td").each(function (index2) 
	        {
	        	//debugger;
	        	if(index2 == 3 ){ // Columna Asignado
	        		input    = $(this).children("input"); //document.getElementById("SI_"+codigoReg); //
	        		idAcceso = $(input).val();
	        		idRegistro  = $(input).attr("id"); 
	        		
	        		objPreguntas.codReg 	= idRegistro;
	        		
	      	   		if($(input).is(':checked')) {
	      	   			if(idRegistro == "000001"){
	      	   				reiterativo ="SI"	
	      	   			}
	      	   			rptPregunta = 'SI';
	           	    }else {
	           	    	rptPregunta = 'NO';
	           	    }
	      	   		
	          	  	objAcceso.item 			= index;
	          	  	objAcceso.codigo  		= idRegistro;
	          	  	objAcceso.respuesta		= rptPregunta;
	          	    objAcceso.pregunta		= objPreguntas
	          	  // 	objAcceso.observacion	= '';
	        	}
	        	if(index2 == 5 ){ // Columna Asignado
	        		input    = $(this).children("input"); //document.getElementById("SI_"+codigoReg); //
	        		obs = $(input).val();
	        		idRegistro  = $(input).attr("id");
	          	  	objAcceso.observacion	= obs;
	        	}
	        })
	        arrayMenus.push(objAcceso);
	        
	        console.log("arrayMenus.length:: " +arrayMenus.length);
	        console.log(arrayMenus);

	    })  
	    arrayMenus.shift();
	    iniciarBloqueo();
	    $.ajax({
	 		   contentType: "application/json",
	           type: "POST",
	           data: JSON.stringify(arrayMenus),
	           url: contextPath+"/entrevistaController/grabarRespuestas",
	           success: function(data)
	           {	
	        	  /**
	        	    if (data == "") { 
	        	    	msg_error("Error al registrar Entrevista");
					} else { 
						console.log("data " + data);
						//registrarEntrevista();
					}
		   	    	*/
	           },
			   error: function(xhr,status,er) {
				   msg_error();
				   console.log("error: " + xhr + " status: " + status + " er:" + er);
				   if(xhr.status==500) {
					   console.log(er);
				 //    Error_500(er);
				   }
				   if(xhr.status==901) {
					   console.log(er);
			    //	   spire_session_901(er);
	    		   }
			   },
			   complete: function(){  
				   finBloqueo();
			   }
	         });


}

function registrarEntrevista() {
	// debugger;
	//grabarRespuestas();
	console.log("reiterativo " + reiterativo);
	var contextPath = $('#contextPath').val(); 
	var actionForm = $('#frmGuardarEntrevista').attr("action");
 	 

	  var combo = document.getElementById("cboResultadoEntrevista");
      var descripcionresultado = combo.options[combo.selectedIndex].text; 
     
  //   console.log("descripcionresultado " + descripcionresultado);
     
	var url = contextPath + "/entrevistaController/registrarEntrevista?resultado="+descripcionresultado+
	"&reiterativo="+reiterativo;
	var myFormulario = $('#frmGuardarEntrevista'); 

	  
	  
	if (!myFormulario[0].checkValidity()) {
		msg_advertencia("Debe completar los campos requeridos(*) correctamente");

	} else {
		 
		
		var codigoPost = $('#codigoPostulante').val();
		var codPersoPost =$('#personaCodigo').val();
	//	var contextPath = $('#contextPath').val(); 
		  var arrayMenus = [];
			
			/** RECORRER MENU **/
		    $("#dataTableEntrevista tbody tr").each(function (index) 
		    {
		    	var rptPregunta,input,idAcceso,idRegistro, obs;
		    	
		    	var objPreguntas = {
		    	  		codReg : 0	
		    	  	};
		    	var objPersona = {
		    			codigo : codPersoPost	
		    	  	};
		    	var objPostulante = {
		    	  		codigo : codigoPost	,
		    	  		persona : objPersona
		    	  	};
		    	
				var objAcceso = {
					item 		: 0,
					codigo		: 0,
					respuesta	: 'NO',
					observacion	: '',
					postulanteBean	: objPostulante,
					pregunta	: objPreguntas
			  	};
				
		        $(this).children("td").each(function (index2) 
		        {
		        	//debugger;
		        	if(index2 == 3 ){ // Columna Asignado
		        		input    = $(this).children("input"); //document.getElementById("SI_"+codigoReg); //
		        		idAcceso = $(input).val();
		        		idRegistro  = $(input).attr("id"); 
		        		
		        		objPreguntas.codReg 	= idRegistro;
		        		
		      	   		if($(input).is(':checked')) {
		      	   			if(idRegistro == "000001"){
		      	   				reiterativo ="SI"	
		      	   			}
		      	   			rptPregunta = 'SI';
		           	    }else {
		           	    	rptPregunta = 'NO';
		           	    }
		      	   		
		          	  	objAcceso.item 			= index;
		          	  	objAcceso.codigo  		= idRegistro;
		          	  	objAcceso.respuesta		= rptPregunta;
		          	    objAcceso.pregunta		= objPreguntas
		          	  // 	objAcceso.observacion	= '';
		        	}
		        	if(index2 == 5 ){ // Columna Asignado
		        		input    = $(this).children("input"); //document.getElementById("SI_"+codigoReg); //
		        		obs = $(input).val();
		        		idRegistro  = $(input).attr("id");
		          	  	objAcceso.observacion	= obs;
		        	}
		        })
		        arrayMenus.push(objAcceso);
		        
		     //   console.log("arrayMenus.length:: " +arrayMenus.length);
		     //   console.log(arrayMenus);

		    })  
		 //   arrayMenus.shift();
		    iniciarBloqueo();
		    $.ajax({
		 		   contentType: "application/json",
		           type: "POST",
		           data: JSON.stringify(arrayMenus),
		           url: contextPath+"/entrevistaController/grabarRespuestas",
		           success: function(data)
		           {	
		        		$.ajax({
		        			type : "POST",
		        			url : url,
		        			data : $('#frmGuardarEntrevista').serialize(),
		        			success : function(data) {
		        				console.log("SUCCESS: ", data);
		        					
		        					msg_exito("Éxito al registrar Entrevista"); 
		        				
		        			},

		        			error : function(xhr, status, er) {
		        				console.log("error: " + xhr + " status: " + status + " er:"
		        						+ er);
		        				// msg_error();

		        			},
		        			complete : function() {
		        			//	finBloqueo();
		        				
		        			}
		        		});
		           },
				   error: function(xhr,status,er) {
					   msg_error();
					   console.log("error: " + xhr + " status: " + status + " er:" + er);
					   if(xhr.status==500) {
						   console.log(er);
					 //    Error_500(er);
					   }
					   if(xhr.status==901) {
						   console.log(er);
				    //	   spire_session_901(er);
		    		   }
				   },
				   complete: function(){ 
					   finBloqueo();
					   $("#btnListadoEntrevista").trigger("click"); 
				   }
		         });
		
		
		
	/***	$.ajax({
			type : "POST",
			url : url,
			data : $('#frmGuardarEntrevista').serialize(),
			success : function(data) {
				console.log("SUCCESS: ", data);
					
					msg_exito("Éxito al registrar Entrevista");
					// enviarListado();
					
			/***	    $.ajax({
				 		   contentType: "application/json",
				           type: "GET",
				           data:  $('#frmGuardarEntrevista').serialize(),
				           url: contextPath+"/entrevistaController/rptFichaPostulanteGrabar",
				           success: function(data)
				           {	  
				           },
						   error: function(xhr,status,er) {
							   msg_error();
							   console.log("error: " + xhr + " status: " + status + " er:" + er);
							   if(xhr.status==500) {
								   console.log(er); 
							   }
							   if(xhr.status==901) {
								   console.log(er); 
				    		   }
						   },
						   complete: function(){ 
							   finBloqueo();
						   }
				         });*/ 
				
	/*		},

			error : function(xhr, status, er) {
				console.log("error: " + xhr + " status: " + status + " er:"
						+ er);
				// msg_error();

			},
			complete : function() {
				finBloqueo();
				$("#btnListadoEntrevista").trigger("click");
			}
		}); */
	}
}

function cambiarRespuestas(codigoReg, rpt){
	 
	//console.log("cambiarRespuestas" + codigoReg +"--"+rpt );
	 var respuesta = document.getElementById(rpt+"_"+codigoReg);
	 // if (respuesta.checked){
		  if(rpt =="SI"){
			  document.getElementById("NO_"+codigoReg).checked = false; 
			  document.getElementById(codigoReg).checked = true; 
		  }else{
			  document.getElementById("NO_"+codigoReg).checked = true; 
			  document.getElementById(codigoReg).checked = false; 
		  }
	/*  }else{
		  
	  }*/   
		    
}

function vistaTicket() {
	var contextPath = $('#contextPath').val();
	var personaCodigo = $('#personaCodigo').val();
	var numeroDocumento = $('#nroDocumentoPaciente').val();
	
	path = contextPath + "/bancoController/imprimirTicket";
	// alert("path " + path) 
	$.ajax({
		type : "POST",
		url : path,

		success : function(data) {
			// console.log("SUCCESS: ", data);
			$("#modalTicket").html(data); 
			$("#modalTicket").modal('show');
		},
		error : function(request, status, error) {
			console.log("ERROR: " + error);
		}
	}); 
}

function verTicket(){
	var contextPath = $('#contextPath').val();
    var url = contextPath +'/bancoController/imprimirTicket';
   // localStorage.setItem("mfData", JSON.stringify(reg.opermanifcb));
   // localStorage.setItem("mfItemsData", JSON.stringify(reg.lstManifiestoPasajeros));
    $('#iframe-manifiesto').html('<div class="icon-spinner"><i class="fa fa-refresh fa-spin fa-3x fa-fw margin-bottom"></i></div>');
 //   $scope.showModalManifiesto = !$scope.showModalManifiesto;
    var $frame = $('<iframe id="iframe-bp" name="frmPrintManifiesto" scrolling="yes" frameborder="0" style="width:100%; height:450px;" src='+url+'></iframe>');
 //   document.getElementsByClassName("modal-hijo")[1].style.width = '850px';
    setTimeout(function(){ 
        $('#iframe-manifiesto').html($frame);
        $("<div class='center-element'><button type='button' onclick='imprimirManifiesto()'>IMPRIMIR</button><div>").appendTo('#iframe-manifiesto');
    },100);
};
