var accionRealizar = "";
var codigoRegistro = "";

function confirmar_eliminar(codigo,accion) {
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
		if( accionRealizar == "1" ){
			elimarExamen(codigoRegistro);
			$('#md_confirmacion').modal('hide');
		}else if(accionRealizar == "2" ){  
			$('#md_confirmacion').modal('hide');
		}else if(accionRealizar == "3" ){ 
			$('#md_confirmacion').modal('hide');
		}
		
	});
});

function cargarTarifarioModal() {
	var contextPath = $('#contextPath').val();
	// var codigoLengua = $('#codigoLengua').val(); //
	// document.getElementById("codigoLengua").value;

	path = contextPath + "/ordenController/tarifarioModal";
	// alert("path " + path)
		$.ajax({
			type : "POST",
			url : path,

			success : function(data) {
				// console.log("SUCCESS: ", data);
				$("#modalTarifario").html(data); 
				$("#modalTarifario").modal('show'); 
				$("#txtDescripcion").focus(); 
			},
			error : function(request, status, error) {
				console.log("ERROR: " + error);
			}
		}); 
}




function cargarAnalisisModal() {
	var contextPath = $('#contextPath').val();
	// var codigoLengua = $('#codigoLengua').val(); //
	// document.getElementById("codigoLengua").value;

	path = contextPath + "/ordenController/analisisModal";
	// alert("path " + path)
		$.ajax({
			type : "POST",
			url : path,

			success : function(data) {
				// console.log("SUCCESS: ", data);
				$("#modalAnalisis").html(data); 
				$("#modalAnalisis").modal('show'); 
			//	$("#txtDescripcion").focus(); 
			},
			error : function(request, status, error) {
				console.log("ERROR: " + error);
			}
		}); 
}


function cargarEmailModal() {
	var contextPath = $('#contextPath').val();
	// var codigoLengua = $('#codigoLengua').val(); //
	// document.getElementById("codigoLengua").value;

	path = contextPath + "/ordenController/emailModal";
	// alert("path " + path)
		$.ajax({
			type : "POST",
			url : path,

			success : function(data) {
				// console.log("SUCCESS: ", data);
				$("#modalEmail").html(data); 
				$("#modalEmail").modal('show'); 
			//	$("#txtDescripcion").focus(); 
			},
			error : function(request, status, error) {
				console.log("ERROR: " + error);
			}
		}); 
}


function llenarExamenIndex(index){
	var contextPath = $('#contextPath').val();
	var htmlTabla = "";
	var item = 0; 
	var valida ="0";
	 console.log("index" + index);
	  $.ajax({
		    type: "GET",
		    // data: "entidad=" + entidad,
		   	
		    url: contextPath+"/ordenController/refrescarListaOrden?index="+index,
		    	success: function(data){ 
		    	if(data!=null){  
		    		for (var i = 0; i < listadoExamenes.length; i++) {
		    			var objOrdenDetalle = listadoExamenes[i]; 
		    			if(objOrdenDetalle.examen.codigo == data.examen.codigo){ 
		    				valida = "1";
		    			}
		    		} 
		    		if(valida == "1"){
		    			 msg_advertencia("El exámen ya fue ingresado.");
		    		}else{ 
			    		listadoExamenes.push(data);
			    		// console.log("listadoExamenes " + listadoExamenes);
			    		// console.log("listadoExamenes " + listadoExamenes.length);
			    		for (var i = 0; i < listadoExamenes.length; i++) {
			    			var objOrdenDetalle = listadoExamenes[i];
			    			item = item + 1;
			    		htmlTabla += 
			    			"<tr>"+
			    				"<td>"+item +"</td>"+
			    				"<td>"+objOrdenDetalle.examen.descripcion +"</td>"+ 
			    				"<td>"+objOrdenDetalle.examen.tipo.nombreCorto+"</td>"+ 
			    				"<td> <input type='text' class='form-control' "+
										"id="+[objOrdenDetalle.examen.codigo]+" required='required' "+
										"value = '1' " +
										"maxlength='3' "+
										"onkeypress= 'return soloNumeros(event);' "+
										"oninput=\"cambiarCantidad('"+[objOrdenDetalle.examen.codigo]+"');\" /></td>"+ 
				    			"<td>"+objOrdenDetalle.examen.sPrecio+"</td>"+ 
				    			"<td>"+objOrdenDetalle.sImporte+"</td>"+ 
				    			"<td>"+ 
						    	 	"<button type='button'"+
						    	 	" class='btn btn-outline-danger btn-sm' "+
						    	 	" data-toggle='tooltip'  data-placement='top'  title='Eliminar'"+
						    	 	"  onclick=\"confirmar_eliminar('"+[objOrdenDetalle.examen.codigo]+"','1');\""+
						      	 	" data-original-title='Eliminar'"+
						    	 	" id='agregarEspecialidad'>"+
						    	 	"<i class='icon-trash'></i></button> "+ 
						    		"</td>"+
			    		"</tr>";  
			    		} 
			    // console.log(htmlTabla);
			    		$("#idBtnCerrarModalCIEX").trigger("click");
				    	$('#idbodyCIEXref').empty();  
				  	    $('#idbodyCIEXref').html(htmlTabla);
				  	    var importe = 0.00;
				  		for (var i = 0; i < listadoExamenes.length; i++) {
				  			var objOrdenDetalle = listadoExamenes[i]; 
				  			importe = importe + objOrdenDetalle.importe; 
				  			//	$("#cboTipoDX"+objOrdenDetalle.valor4.trim()).val(objOrdenDetalle.valor7);
				  			 
				  		}
				  		 $('#txtCajaImporteTotal').val(importe.toFixed(2)); 
				  		$('#txtCajaImporteTotalHidden').val(importe.toFixed(2)); 
		    		}
		    	}
		    
			    },error: function(xhr,status,er) {
		         console.log("error: " + xhr + " status: " + status + " er:" + er);
					    if(xhr.status==500) {
					    	console.log(er);
					    	// Error_500(er);
					    }
					    if(xhr.status==901) {
				    	console.log(er);
				    	// spire_session_901(er);
		 			}
		
			    }
		  });
}

function buscarPersonaNroDoc(){

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
							+ "/ordenController/consultarPersonaPorDocumento?tipoDocumento="
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
									$('#personaDireccion').val(
											persona.direccion);
								 
									if (persona.ubigeoDireccion.codigoUbigeo != "") {
										$('#ubigeoDireccion').val(persona.ubigeoDireccion.codigoUbigeo);
										$('#codigoRegistroUbigeoDireccion').val(persona.ubigeoDireccion.codigoRegistro);
										$('#nombreUbigeoDireccion').val(persona.ubigeoDireccion.nombreUbigeo);
									}else{ 
									}
							
								  
								}else {
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

function limpiarPersona(){  
	$('#personaApellidoPaterno').val("");
	$('#personaApellidoMaterno').val("");
	$('#personaPrimerNombre').val("");
	$('#personaSegundoNombre').val(""); 
	$('#personaCodigo').val("");  
	$('#ubigeoDireccion').val("");
	$('#edadPersona').val(""); 
	$('#sexoPaciente').val("");
	$('#personaDireccion').val("");
	$('#codigoRegistroUbigeoDireccion').val("");
	$('#nombreUbigeoDireccion').val("");
}

function grabarOrden(){   
		var personaCodigo = $('#personaCodigo').val();   
		var contextPath = $('#contextPath').val(); 
		var actionForm = $('#frmGuardarOrden').attr("action");
		
		if (personaCodigo =="") {
			msg_advertencia("Debe ingresar una persona para lo Orden."); 
			return;
			
		} 
		console.log("personaCodigo:: " + personaCodigo) ; 
		var myFormulario = $('#frmGuardarOrden');  
		
		if(!myFormulario[0].checkValidity()) {
			 msg_advertencia("Debe completar los campos requeridos(*) correctamente");

		}else{ 
			if(listadoExamenes.length == 0){
				msg_advertencia("Ingrese al menos una Orden de exámen.");
				return;
			
			
			}  
			
			for (var i = 0; i < listadoExamenes.length; i++) {
				var objExamen= listadoExamenes[i];
				// console.log("objCIEX.codReg " + objCIEX.codReg);
				if(objExamen.cantidad == '' || objExamen.cantidad == '0'){  
					msg_advertencia("Ingrese cantidad mayor a 0");
					return;
				}
			} 
				iniciarBloqueo();
				$.ajax({
				contentType: "application/json",
				type: "POST",
				data: JSON.stringify(listadoExamenes),
				url : contextPath+"/ordenController/grabarOrden",  
		       
				success : function(data) {
					   // console.log("SUCCESS: ", data);
					    if (data == "") {
					    	msg_error("Error al registrar Orden");  
						}else{
						    msg_exito("Éxito al registrar Orden");  
						    // enviarListado();
							 $("#btnListado").trigger("click");
						}
 
				},
				
				error : function(xhr, status, er) { 
				        console.log("error: " + xhr + " status: " + status + " er:" + er);
							// msg_error();
	
						},
			  			complete: function()
	  			{
	  				finBloqueo();

				}
		});
	}
}

function elimarExamen(codigo){
	var htmlTabla = "";
	var item = 0; 
	
	console.log("codigo " + codigo);
	for (var i = 0; i < listadoExamenes.length; i++) {
		var objOrdenDetalle = listadoExamenes[i];
		if(objOrdenDetalle.examen.codigo == codigo){ 
			  console.log("objOrdenDetalle.examen.codReg " + objOrdenDetalle.examen.codigo);
			listadoExamenes.splice(i, 1);
		}
	}  
	for (var i = 0; i < listadoExamenes.length; i++) {
		var objOrdenDetalle = listadoExamenes[i];
		item = item + 1;
		htmlTabla += 
				"<tr>"+
				"<td>"+item +"</td>"+
				"<td>"+objOrdenDetalle.examen.descripcion +"</td>"+ 
				"<td>"+objOrdenDetalle.examen.tipo.nombreCorto+"</td>"+ 
				"<td> <input type='text' class='form-control' "+
						"id="+[objOrdenDetalle.examen.codigo]+" required='required' "+
						"value = '1' " +
						"maxlength='3' "+
						"onkeypress= 'return soloNumeros(event);' "+
						"oninput=\"cambiarCantidad('"+[objOrdenDetalle.examen.codigo]+"');\" /></td>"+ 
				"<td>"+objOrdenDetalle.examen.sPrecio+"</td>"+ 
				"<td>"+objOrdenDetalle.sImporte+"</td>"+ 
				"<td>"+ 
		    	 	"<button type='button'"+
		    	 	" class='btn btn-outline-danger btn-sm' "+
		    	 	" data-toggle='tooltip'  data-placement='top'  title='Eliminar'"+
		    	 	"  onclick=\"confirmar_eliminar('"+[objOrdenDetalle.examen.codigo]+"','1');\""+
		      	 	" data-original-title='Eliminar'"+
		    	 	" id='agregarEspecialidad'>"+
		    	 	"<i class='icon-trash'></i></button> "+ 
		    		"</td>"+
		"</tr>";
	
	}
	$('#idbodyCIEXref').empty();  
	$('#idbodyCIEXref').html(htmlTabla);
		var importe = 0.00;
		for (var i = 0; i < listadoExamenes.length; i++) {
			var objOrdenDetalle = listadoExamenes[i]; 
			importe = importe + objOrdenDetalle.importe; 
			//	$("#cboTipoDX"+objOrdenDetalle.valor4.trim()).val(objOrdenDetalle.valor7);
			 
		}
		 $('#txtCajaImporteTotal').val(importe.toFixed(2)); 
		$('#txtCajaImporteTotalHidden').val(importe.toFixed(2)); 
}

function cambiarCantidad(objeto){
	//debugger;
	var nombreObjet = "#"+objeto+""
	console.log("nombreObjet "+ nombreObjet);
	var cantidad = $(nombreObjet).val(); 
	var htmlTabla = "";
	var item = 0; 
	console.log("cantidad "+ cantidad);
	
	for (var i = 0; i < listadoExamenes.length; i++) {
		var objExamen= listadoExamenes[i];
		// console.log("objCIEX.codReg " + objCIEX.codReg);
		if(objExamen.examen.codigo == objeto){ 
			objExamen.cantidad = cantidad; 
			objExamen.importe = (objExamen.precio * cantidad).toFixed(2);
			objExamen.sImporte = (objExamen.precio * cantidad).toFixed(2);
			console.log( "objExamen.importe:: " + objExamen.importe )
		}
	} 

	for (var i = 0; i < listadoExamenes.length; i++) {
		var objOrdenDetalle = listadoExamenes[i];
		item = item + 1;
		htmlTabla += 
				"<tr>"+
				"<td>"+item +"</td>"+
				"<td>"+objOrdenDetalle.examen.descripcion +"</td>"+ 
				"<td>"+objOrdenDetalle.examen.tipo.nombreCorto+"</td>"+ 
				"<td> <input type='text' class='form-control' "+
						"id="+[objOrdenDetalle.examen.codigo]+" required='required' "+
						"value ='"+objOrdenDetalle.cantidad+"' " +
						"maxlength='3' "+
						"onkeypress= 'return soloNumeros(event);' "+
						"oninput=\"cambiarCantidad('"+[objOrdenDetalle.examen.codigo]+"');\" /></td>"+ 
				"<td>"+objOrdenDetalle.examen.sPrecio+"</td>"+ 
				"<td>"+objOrdenDetalle.sImporte+"</td>"+ 
				"<td>"+ 
		    	 	"<button type='button'"+
		    	 	" class='btn btn-outline-danger btn-sm' "+
		    	 	" data-toggle='tooltip'  data-placement='top'  title='Eliminar'"+
		    	 	"  onclick=\"confirmar_eliminar('"+[objOrdenDetalle.examen.codigo]+"','1');\""+
		      	 	" data-original-title='Eliminar'"+
		    	 	" id='agregarEspecialidad'>"+
		    	 	"<i class='icon-trash'></i></button> "+ 
		    		"</td>"+
		"</tr>";
	
	}
	$('#idbodyCIEXref').empty();  
	$('#idbodyCIEXref').html(htmlTabla);
	
	var importe = 0.00;
	for (var i = 0; i < listadoExamenes.length; i++) {
		var objOrdenDetalle = listadoExamenes[i]; 
		importe = importe + Number(objOrdenDetalle.importe); 
		//	$("#cboTipoDX"+objOrdenDetalle.valor4.trim()).val(objOrdenDetalle.valor7);
		 
	}
	$('#txtCajaImporteTotal').val(importe.toFixed(2)); 
	$('#txtCajaImporteTotalHidden').val(importe.toFixed(2));  
}

function cargarPersonaModal() {
	var contextPath = $('#contextPath').val();
	path = contextPath + "/ordenController/personaModal";
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

function grabarPersona(){
	var htmlTabla = "";
	var contextPath = $('#contextPath').val();
	var actionForm = $('#frmGuardarPersona').attr("action");
	var url = contextPath + "/ordenController/grabarPersonaLaboratorio";
	var myFormulario = $('#frmGuardarPersona');
	var telefono = $('#telefono').val();
	var codigoRegistroUbigeoDireccion = $('#txtCodRegUbigeo').val();
	
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
			data : $('#frmGuardarPersona').serialize(),
			success : function(data) { 
				if (data == "") {
					msg_error("Error al registrar persona");
				} else {
					msg_exito("Éxito al registrar persona");
					
					var numeroDocumento = $('#nroDocumentoPersona').val();
					var tipoDocumento = $('#tipoDocumentoPersona').val();
					
					$('#nroDocumentoPaciente').val(numeroDocumento);
					$('#tipoDocumentoPaciente').val(tipoDocumento);
					buscarPersonaNroDoc();
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

function anularCargarModal(index) {
	var contextPath = $('#contextPath').val();
	// var codigoLengua = $('#codigoLengua').val(); //
	// document.getElementById("codigoLengua").value;

	path = contextPath + "/ordenController/modalAnularOrden?index=" +index;
	// alert("path " + path)
		$.ajax({
			type : "POST",
			url : path,

			success : function(data) {
				// console.log("SUCCESS: ", data);
				$("#md_anular-orden").html(data);
				$("#md_anular-orden").modal('show'); 
			},
			error : function(request, status, error) {
				console.log("ERROR: " + error);
			}
		}); 
}


function anularOrden(){
	// debugger;
	var htmlTabla = "";
	var item = 0; 
	var myFormulario = $('#frmAnularOrden');  
	
	var contextPath = $('#contextPath').val();
	if(!myFormulario[0].checkValidity()) {
		 msg_advertencia("Debe completar los campos requeridos(*) correctamente");
		 
	}else{
		var url = contextPath + "/ordenController/anularOrden";
	// iniciarBloqueo();
		$.ajax({
		type : "GET",
		url : url,
		data: $('#frmAnularOrden').serialize(),
		success : function(data) {
			   // console.log("SUCCESS: ", data);
			    if (data =! null) {
			    	 msg_exito("Éxito al realizar proceso");
			    	 $("#idBtnCerrarDescartar").trigger("click"); 
			    	 $("#btnListado").trigger("click");
			    	 
			    	// enviarListado();
				}else{
				    msg_error("Error al realizar proceso");  
				    // enviarListado();
					
				} 
		},
		
		error : function(xhr, status, er) { 
		        console.log("error: " + xhr + " status: " + status + " er:" + er);
					// msg_error();
	
				},
	  			complete: function()
			{
			// finBloqueo();
	
			}
			});
	}
}
function actualizarResultadoOrdenDetalle(){
	// debugger;
	var htmlTabla = "";
	var item = 0; 
	var myFormulario = $('#frmActualizarResultadoOrden');  
	
	var contextPath = $('#contextPath').val();
	if(!myFormulario[0].checkValidity()) {
	//	 msg_advertencia("Debe completar los campos requeridos(*) correctamente");
		 
	}else{
		var url = contextPath + "/ordenController/actualizarResultado";
	// iniciarBloqueo();
		$.ajax({
		type : "GET",
		url : url,
		data: $('#frmActualizarResultadoOrden').serialize(),
		success : function(data) {
			   // console.log("SUCCESS: ", data);
			    if (data =! null) {
			    	 msg_exito("Éxito al registrar resultados");
			   // 	 $("#idBtnCerrarDescartar").trigger("click"); 
			    	 $("#btnListado").trigger("click");
			    	 
			    	// enviarListado();
				}else{
				    msg_error("Error al realizar proceso");  
				    // enviarListado();
					
				} 
		},
		
		error : function(xhr, status, er) { 
		        console.log("error: " + xhr + " status: " + status + " er:" + er);
					// msg_error();
	
				},
	  			complete: function()
			{
			// finBloqueo();
	
			}
			});
	}
}


function enviarRpt(){
	// debugger;
	var htmlTabla = "";
	var item = 0; 
	var myFormulario = $('#frmActualizarResultadoOrden');  
	
	var contextPath = $('#contextPath').val();
	if(!myFormulario[0].checkValidity()) {
	//	 msg_advertencia("Debe completar los campos requeridos(*) correctamente");
		 
	}else{
		var url = contextPath + "/ordenController/rptFichaREsultados";
	// iniciarBloqueo();
		$.ajax({
		type : "GET",
		url : url,
		data: $('#frmActualizarResultadoOrden').serialize(),
		success : function(data) {
			   // console.log("SUCCESS: ", data);
			    if (data =! null) {
			    	 msg_exito("Éxito al registrar resultados");
			   // 	 $("#idBtnCerrarDescartar").trigger("click"); 
			  //  	 $("#btnListado").trigger("click");
			    	 
			    	// enviarListado();
				}else{
				    msg_error("Error al realizar proceso");  
				    // enviarListado();
					
				} 
		},
		
		error : function(xhr, status, er) { 
		        console.log("error: " + xhr + " status: " + status + " er:" + er);
					// msg_error();
	
				},
	  			complete: function()
			{
			// finBloqueo();
	
			}
			});
	}
}