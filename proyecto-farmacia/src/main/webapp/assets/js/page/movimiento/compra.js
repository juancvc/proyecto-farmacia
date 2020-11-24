var accionRealizar = "";
var codigoRegistro = "";

function confirmar_eliminar(codigo, tipo) {
	codigoRegistro = codigo;
	accionRealizar = tipo;
	$('#md_confirmacion').modal('show');

}
function agregar_accion() {
	$('#md_reg_confirmacion').modal('show');
}

$(document).ready(function() {
	$("#btnConfirmarGeneric").click(function() {
		if (accionRealizar == 3) {
			console.log("anularVenta :: " + codigoRegistro );
			anularVenta(codigoRegistro);
		}else{
			console.log("eliminarArticulo :: " + codigoRegistro );
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
						+ "/compraController/refrescarListaArticulos?index="
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
										+ "<label for='nombreCompleto' class='label_control' id="
										+ [ objVentaItem.stock.articulo.codigo ]
								        + " >" + objVentaItem.stock.articulo.nombre
										+ "</label>" 
										+ "</td>"
										+ "<td><input type='text' class='form-control' "
										+ "id="
										+ [ objVentaItem.stock.articulo.codigo ]
										+ " required='required' "
										+ "value =''"
										+ "maxlength='5' "
										+ "onkeypress= 'return soloNumeros(event);' />"
										+ "</td>"
										+ "<td><input type='text' class='form-control' "
										+ "id="
										+ [ objVentaItem.stock.articulo.codigo ]
										+ " required='required' "
										+ "placeholder='DD/MM/YYYY'"
										+ "maxlength='10' "
										+ "onkeyup='this.value=formateafecha(this.value);' />"
										+ "</td>"
										+ "<td><input type='text' class='form-control' "
										+ "id="
										+ [ objVentaItem.stock.articulo.codigo ]
										+ " required='required' "
										+ "value =''"
										+ "maxlength='100'/>"
										+ "</td>"
										+ "<td><input type='text' class='form-control' "
										+ "id="
										+ [ objVentaItem.stock.articulo.codigo ]
										+ " required='required' "
										+ "value ='0' onchange = 'calculaSubTotal(); ' "
										+ "maxlength='100'/>"
										+ "</td>"
										+ "<td><input type='text' class='form-control' "
										+ "id="
										+ [ objVentaItem.stock.articulo.codigo ]
										+ " required='required' "
										+ "value ='0'"
										+ "maxlength='100'/>"
										+ "</td>"
										+ "<td> <input type='text' class='form-control' "
										+ "id="
										+ [ objVentaItem.stock.codigo ]
										+ " required='required' "
										+ "value ='"
										+ objVentaItem.cantidad
										+ "' "
										+ "maxlength='5' "
										+ "onkeypress= 'return soloNumeros(event);'" 
										+ "onchange = 'calculaSubTotal(); '  /></td>"
										+ "<td>"
										+ "<label for='nombreCompleto' id="
										+ [ objVentaItem.stock.articulo.codigo ]
								        + "class='label_control'>0" 
										+ "</label>"
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

function calculaSubTotal(){  
	var arrayComprasItem = [];
	/** RECORRER MENU **/
    $("#dataTable tbody tr").each(function (index) 
    {
    	var asignado,input,idAcceso,idCompo;
    	
    	var objCompra = {
	  		codigo : 0	
	  	};
	    	
		var objCompraItem = {
			item 		: 0,
			codigo		: 0,
			precioCompra : '0',
			precioVenta	: 0,
			cantidad 	: 0,
			subtotal 	: 0,
			flgExport 	: false
	  	};
    	
        $(this).children("td").each(function (index2) 
        {
        	if(index2 == 5 ){ // Columna precio Compra
        		input    = $(this).children("input");
        		idAcceso = $(input).val();
  	   			idCompo  = $(input).attr("id");
  	   			
  	   		    objCompra.codigo = idCompo;
  	   		    console.log("compra $(input). " + $(input).val());
  	   		    
				objCompraItem.item 			= index+1;
				objCompraItem.codigo 		= idAcceso;
				objCompraItem.precioCompra	= $(input).val();
        	}
        	if(index2 == 6 ){ // Columna precio Compra
        		input    = $(this).children("input");
        		idAcceso = $(input).val();
  	   			idCompo  = $(input).attr("id");
  	   			
  	   		    objCompra.codigo = idCompo;
  	   		    console.log("venta $(input). " + $(input).val());
  	   		    
				objCompraItem.item 			= index+1;
				objCompraItem.codigo 		= idAcceso;
				objCompraItem.precioVenta	= $(input).val();
        	}
        	if(index2 == 7 ){ // Columna precio Compra
        		input    = $(this).children("input");
        		idAcceso = $(input).val();
  	   			idCompo  = $(input).attr("id");
  	   			
  	   		    objCompra.codigo = idCompo;
  	   		    console.log("venta $(input). " + $(input).val());
  	   		    
				objCompraItem.item 			= index+1;
				objCompraItem.codigo 		= idAcceso;
				objCompraItem.cantidad	= $(input).val();
        	}
        	if(index2 == 8 ){ // Columna precio Compra
        		input    = $(this).children("label");
        		idAcceso = $(input).val();
  	   			idCompo  = $(input).attr("id");
  	   			
  	   		    objCompra.codigo = idCompo; 
  	   		    $(input).html(objCompraItem.cantidad * objCompraItem.precioCompra);
  	   		    
  	   		    
				objCompraItem.item 			= index+1;
				objCompraItem.codigo 		= idAcceso;
				objCompraItem.subtotal	= objCompraItem.cantidad * objCompraItem.precioCompra;
				console.log("objCompraItem.subtotal " + objCompraItem.subtotal);
				
	        	var subTotal = 0.0;
	        	subTotal = $('#txtCajaImporteTotal').html();
	        	console.log("subTotal " +  subTotal);
	        	$('#txtCajaImporteTotal').val(subTotal + objCompraItem.subtotal);
        	}
        })
        arrayComprasItem.push(objCompraItem);
    })	
	
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
		+ "<td><input type='text' class='form-control' "
		+ "id="
		+ [ objVentaItem.stock.articulo.codigo ]
		+ " required='required' "
		+ "value =''"
		+ "maxlength='5' "
		+ "onkeypress= 'return soloNumeros(event);' />"
		+ "</td>"
		+ "<td>"
		+ objVentaItem.stock.articulo.codigoSismed
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
		+ "maxlength='5' "
		+ "onkeypress= 'return soloNumeros(event);'/></td>"
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
	$('#idbodyStock').empty();
	$('#idbodyStock').html(htmlTabla);

}
  
function cargarPersona() {
	var personaCodigo = $('#personaCodigo').val();
	var contextPath = $('#contextPath').val();
	var htmlTabla = "";
	console.log("personaCodigo " + personaCodigo );
	if (personaCodigo == null || personaCodigo == "") { 
		return;
	} else {
		 
		//iniciarBloqueo();
		$
				.ajax({
					type : "GET",
					url : contextPath
							+ "/ventaController/cargarPersona?codigo="
							+ personaCodigo,

					success : function() {

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
		//finBloqueo();
	}
}


function grabar(){  
		var contextPath = $('#contextPath').val(); 
		var actionForm = $('#frmRegistrarCompra').attr("action");
		var url =contextPath+"/compraController/llenarCompra" ;
		var myFormulario = $('#frmRegistrarCompra'); 
		console.log("actionForm " + actionForm);
		
		if(!myFormulario[0].checkValidity()) {
			 msg_advertencia("Debe completar los campos requeridos(*) correctamente");

		}else{  
				$.ajax({
				type : "GET",
				url : url,
				data: $('#frmRegistrarCompra').serialize(),
				success : function(data) { 
						    grabarDetalle()  
				},
				
				error : function(xhr, status, er) { 
				        console.log("error: " + xhr + " status: " + status + " er:" + er);
							//msg_error();
	
						},
			  			complete: function()
	  			{ 
				}
		});
	}
}

function grabarDetalle(){  
	debugger;
	/** RECORRER MENU **/
	var arrayComprasItem = [];
	var subTotal = 0.0;
	
    $("#dataTable tbody tr").each(function (index) 
    {
    	var asignado,input,idAcceso,idCompo;
    	var objArticulo = {
    	  		codigo : ""	
    	  	};
    	var objStock = {
	  		codigo : ""	,
	  		articulo : objArticulo,
			sFechaVencimiento : "",
			nroRegistroSanitario : "",
			lote : "", 
			precioCompra : 0,
			precioVenta	: 0
	  	};
	    	
		var objCompraItem = {
			item 		: 0,
			codigo		: "",
			stock : objStock,
			cantidad 	: 0,
			subtotal 	: 0
	  	};
    	
        $(this).children("td").each(function (index2) 
        {
        	
        	if(index2 == 1 ){ // Columna idArticulo
        		input    = $(this).children("label");
        		idAcceso = $(input).val();
  	   			idCompo  = $(input).attr("id");
  	   			
  	   			objCompraItem.codigo = idCompo;
  	   		    console.log("compra $(input). " + $(input).val());
  	   		    
				objCompraItem.item 		= index+1;
				objArticulo.codigo 	= idCompo; 
				objStock.articulo = objArticulo;
				
				objCompraItem.stock = objStock;
        	}
        	
        	if(index2 == 2 ){ // Columna precio Compralote
        		input    = $(this).children("input");
        		idAcceso = $(input).val();
  	   			idCompo  = $(input).attr("id");
  	   			
  	   			objCompraItem.codigo = idCompo;
  	   		    console.log("compra $(input). " + $(input).val());
  	   		    
				objCompraItem.item 			= index+1;
				objCompraItem.codigo 		= idAcceso;
				objStock.lote	= $(input).val();
				
				objCompraItem.stock = objStock;
        	}
        	if(index2 == 3 ){ // Columna fechaVencimiento
        		input    = $(this).children("input");
        		idAcceso = $(input).val();
  	   			idCompo  = $(input).attr("id");
  	   			
  	   			objCompraItem.codigo = idCompo;
  	   		    console.log("compra $(sFechaVencimiento). " + $(input).val());
  	   		    
				objCompraItem.item 			= index+1;
				objCompraItem.codigo 		= idAcceso;
				objStock.sFechaVencimiento	= $(input).val();
				objCompraItem.stock = objStock;
        	}
        	if(index2 == 4 ){ // Columna registroSanitario
        		input    = $(this).children("input");
        		idAcceso = $(input).val();
  	   			idCompo  = $(input).attr("id");
  	   			
  	   			objCompraItem.codigo = idCompo;
  	   		    console.log("compra $(input). " + $(input).val());
  	   		    
				objCompraItem.item 			= index+1;
				objCompraItem.codigo 		= idAcceso;
				objStock.nroRegistroSanitario	= $(input).val();
				objCompraItem.stock = objStock;
        	}
        	if(index2 == 5 ){ // Columna precio Compra
        		input    = $(this).children("input");
        		idAcceso = $(input).val();
  	   			idCompo  = $(input).attr("id");
  	   			
  	   			objCompraItem.codigo = idCompo;
  	   		    console.log("compra $(input). " + $(input).val());
  	   		    
				objCompraItem.item 			= index+1;
				objCompraItem.codigo 		= idAcceso;
				objStock.precioCompra	= $(input).val();
				objCompraItem.stock = objStock;
        	}
        	if(index2 == 6 ){ // Columna precio Compra
        		input    = $(this).children("input");
        		idAcceso = $(input).val();
  	   			idCompo  = $(input).attr("id");
  	   			
  	   			objCompraItem.codigo = idCompo;
  	   		    console.log("venta $(input). " + $(input).val());
  	   		    
				objCompraItem.item 			= index+1;
				objCompraItem.codigo 		= idAcceso;
				objStock.precioVenta	= $(input).val();
				
				objCompraItem.stock = objStock;
        	}
        	if(index2 == 7 ){ // Columna precio Compra
        		input    = $(this).children("input");
        		idAcceso = $(input).val();
  	   			idCompo  = $(input).attr("id");
  	   			
  	   			objCompraItem.codigo = idCompo;
  	   		    console.log("venta $(input). " + $(input).val());
  	   		    
				objCompraItem.item 			= index+1;
				objCompraItem.codigo 		= idAcceso;
				objCompraItem.cantidad	= $(input).val();
        	}
        	if(index2 == 8 ){ // Columna precio Compra
        		input    = $(this).children("label");
        		idAcceso = $(input).val();
  	   			idCompo  = $(input).attr("id");
  	   			
  	   			objCompraItem.codigo = idCompo; 
  	   		    $(input).html(objCompraItem.cantidad * objCompraItem.precioCompra);
  	   		    
  	   		    
				objCompraItem.item 			= index+1;
				objCompraItem.codigo 		= idAcceso;
				objCompraItem.subtotal	= objCompraItem.cantidad * objCompraItem.precioCompra;
				console.log("objCompraItem.subtotal " + objCompraItem.subtotal);
				
	        	
	        	subTotal = subTotal +  objCompraItem.subtotal;
	        	console.log("subTotal " +  subTotal);
	        	
        	}
        })
        arrayComprasItem.push(objCompraItem);
    })	
    $('#txtCajaImporteTotal').val(subTotal);
    enviarDatosAccesoAjax(arrayComprasItem);
}

function enviarDatosAccesoAjax(arrayComprasItem){
	
	var contextPath = $('#contextPath').val();
    var htmlTabla="";
    
    iniciarBloqueo();
    
 	$.ajax({
 		   contentType: "application/json",
           type: "POST",
           data: JSON.stringify(arrayComprasItem),
           url: contextPath+"/compraController/asignarCompra",
           success: function(data)
           {	
        	    msg_exito();
        	     
	   	    	
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
			   $('#contentSubMenuTabla').empty();
			   finBloqueo();
		   }
         });
    return false;
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
		+ "<td><input type='text' class='form-control' "
		+ "id="
		+ [ objVentaItem.stock.articulo.codigo ]
		+ " required='required' "
		+ "value =''"
		+ "maxlength='5' "
		+ "onkeypress= 'return soloNumeros(event);' />"
		+ "</td>"
		+ "<td>"
		+ objVentaItem.stock.articulo.codigoSismed
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
		+ "maxlength='5' "
		+ "onkeypress= 'return soloNumeros(event);' /></td>"
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
	$('#idbodyStock').empty();
	$('#idbodyStock').html(htmlTabla);

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
				       	value: objSerie.codigo,
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

function limpiarPorTipo(){
	
}


function limpiarPersona() {
	$('#personaApellidoPaterno').val("");
	$('#personaApellidoMaterno').val("");
	$('#personaNombres').val("");
	$('#personaCodigo').val("");
}

/**
 * Función para imprimir ticket
 */
function imprimirIndividual(){
	var contextPath = $('#contextPath').val();
	var x = window.open(contextPath+"/"+"ticketVenta.jsp","toolbar=0,width=780,height=550");
	return true;	
	 			
}

function verTicket() {

	$("#txt_confir_Vd").html("Ticket de Venta");
	$("#dataInfoModal").empty();

	//$('#modalVerdocumento').modal('show');

	var object = "<object type='application/pdf' width='100%' height='450px'>"+"</object>";

	$( "#onshow #dataInfoModal" ).empty();
	$( "#onshow #dataInfoModal" ).append( object );
}

function refrescarListadoConsumo() {
	var contextPath = $('#contextPath').val();
	var idEpisodio  = $('#cboPacienteVenta').val();
	console.log("idEpisodio "+ idEpisodio);
	
	$.ajax({
		url : contextPath + "/ventaController/listarDevolucion?idEpisodio="+idEpisodio,
		type : 'GET',
	
		success : function(data) {
			//console.log("SUCCESS: ", data);
			$('#idTablaDevolucion').html(data);
		},
		error : function() {
			//console.log("ERROR: ");
		}
	});
}

function buscarDocumento() {
	var contextPath = $('#contextPath').val();
	var nroSerie  = $('#nroSerie').val();
	var idVenta  = $('#idVenta').val();
	var numeroPeriodo  = $('#numeroPeriodo').val();
	
	$.ajax({
		url : contextPath + "/ventaController/buscarVentaPorNumeroDocumento?nroSerie="+nroSerie
						  + "&idVenta=" + idVenta + "&numeroPeriodo=" + numeroPeriodo,
		type : 'GET',	
		success : function(venta) {
			console.log("venta::" + venta);
			if(venta !=""){
				var todate = new Date(venta.fechaEmision);
				var dia = todate.getDate();
				var mes = todate.getMonth() + 1;
				var anio = todate.getFullYear(); 
				
				if (dia.toString().length == 1) {
					dia = "0"+dia;
				}
				if (mes.toString().length == 1) {
					mes = "0"+mes;
				}

				var fecha = dia+"/"+mes+"/"+anio 
				 $('#personaNombres').val(venta.persona.nombreCompleto);
				 $('#personaNroDocumento').val(venta.persona.nroDocumento);
				 $('#txtEpisodio').val(venta.episodio.codigo);
				 $('#txtTipoSeguro').val(venta.tipoFinanciador.descripcionCorta);
				 $('#txtFechaEmision').val(fecha+ " "+ venta.hora);
				 $('#txtUsuarioEmitio').val(venta.usuarioRegistro); 
				 $('#txtIdVenta').val(venta.codigo);
				 $('#txtNumeroPeriodo').val(venta.numeroPeriodo);
				 $('#txtMonto').val("S/. " +venta.importe);
				 $('#txtNumero').val(venta.serie.nroSerie + "-" + venta.codigo);
				
			}else{
				msg_advertencia("No se encontraron resultados");
			}
			
		},
		error : function() {
		}
	});
}

function anularVenta(codigoRegistro){
	var contextPath = $('#contextPath').val();
	var idVenta  = $('#txtIdVenta').val();
	var numeroPeriodo  = $('#txtNumeroPeriodo').val();
	var numeroDocu  = $('#txtNumero').val();
	
	$.ajax({
		url : contextPath + "/ventaController/anularVenta?idVenta="+idVenta
			+ "&numeroPeriodo=" + numeroPeriodo + "&numeroDocu=" + numeroDocu,
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
			}else{
				msg_error("Error al anular venta");	
			}
		},
		error : function() {
		}
	});
}
