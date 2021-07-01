var codigoUsuario = "";
var accionRealizar = "";
var index =0;
var validaExisteAlmacen = "0";

function confirmar_eliminar(codigo,accion) {
	index = codigo;
	accionRealizar = accion;
	// alert(codigoReferencia);
	$('#md_confirmacion').modal('show');

}


$(document).ready(function() {
	$("#btnConfirmarGeneric").click(function() {
		if(accionRealizar == '1'){
			eliminar_UsuarioAlmacen(index);
		}else{
			eliminar_Usuario(index);
		} 
	
	});
});


function eliminar_Usuario(index) { 
	var contextPath = $('#contextPath').val();
	$
			.ajax({
				url :  contextPath+"/usuarioController/eliminar?index="
						+ index,
				type : 'GET',
				success : function(data) {
					$('#md_confirmacion').modal('hide');
					msg_exito();
					$("#btnBuscar").trigger("click");
				},
				error : function(request, status, error) {
					alert(error);
				}
			});

};
function eliminar_UsuarioAlmacen(codigo) { 
	
	var contextPath = $('#contextPath').val();
	var codigoUsuario = $('#codigoUsuario').val();
	$
			.ajax({
				url :  contextPath+"/usuarioController/eliminarAlmacen?codigo="
						+ codigo,
				type : 'GET',
				success : function(data) {
					$('#md_confirmacion').modal('hide');
					msg_exito(); 
					listUsuarioAlmacen(codigoUsuario);
				},
				error : function(request, status, error) { ;
				}
			});

};
function cargarEstablecimientoUsuario(codigoRenaes){
	var contextPath = $('#contextPath').val();
	var codigoUsuario = $('#codigoUsuario').val();
	var codigoPersona = $('#codigoPersonaBean').val(); 
	
	
	var url =contextPath+"/usuarioController/doGrabarUsuarioRenaes?codigoUsuario="+ codigoUsuario 
							+ "&codigoRenaes=" + codigoRenaes
							+ "&codigoPersona=" + codigoPersona;
	
	console.log("codigoRenaes " + codigoRenaes);
//	iniciarBloqueo();
	$.ajax({
	type : "GET",
	url : url,
	//data: $('#frmRegistroReferencia').serialize(),
	success : function(data) {
		   // console.log("SUCCESS: ", data);
		    if (data == "") {
		    	msg_error("Error al realizar proceso");  
			}else{
			    msg_exito("Éxito al realizar proceso");  
			    // enviarListado();
				 $("#btnCerrarModalEstabUsu").trigger("click");
				 listUsuarioRenaesBean(codigoUsuario);
				 
			}
	},
	
	error : function(xhr, status, er) { 
	        console.log("error: " + xhr + " status: " + status + " er:" + er);
				// msg_error();

			},
  			complete: function()
		{
		//	finBloqueo();

	}
});
	
}

function seleccionarPersonaUsuario() {
	$('#idUlContentTab #base-tab12').trigger("click");
	$('#idUlContentTab .nav-item .nav-link').removeClass("active");
	$('#idUlContentTab #base-tab12').css("display", "block");
	$('#idUlContentTab #base-tab12').addClass("active");
}

function limpiarDatoPersonaBusqueda() {
	$('#formularioPersona').find('input').each(function() {
		switch (this.type) {
		// case 'password':
		case 'text':
			$(this).val('');
			break;
		case 'hidden':
			$(this).val(0);
			break;
		// case 'checkbox':
		// case 'radio':
		// this.checked = false;
		}
	});

	$('#formularioPersona #tipoDocumento').val(1);
	$('#idUlContentTab #base-tab12').css("display", "none");
}

function buscarPersona() {

	var contextPath = $('#contextPath').val();
	var numeroDocumento = $('#nroDocumentoUsuario').val();
	var tipoDocumento = $('#tipoDocumentoUsuario').val();

	if (tipoDocumento == null || tipoDocumento == "") {
		msg_advertencia("Seleccione tipo de documento");
		return;
	}else if  (numeroDocumento == null || numeroDocumento == "") {
		msg_advertencia("Ingrese un número de documento.");
		return;
	 
	}else if (tipoDocumento == "000001") {
		if (numeroDocumento.length < 7) {
			msg_advertencia("Ingrese número de DNI válido.");
			return;
		} 
	}else if (tipoDocumento == "000002") {
		if (numeroDocumento.length < 8) {
			msg_advertencia("Ingrese número de PASAPORTE válido.");
			return;
		} 
	}  
		  console.log("validarDni " + numeroDocumento );

		$
				.ajax({
					type : "GET",
					url : contextPath
							+ "/usuarioController/consultarPorDocumentoPersona?tipoDocumento="
							+ tipoDocumento + "&numero=" + numeroDocumento,

					success : function(persona) {  
							$('#codigoPersonaBean').val("");
							$('#comboPerfil').val("");
							$('#nombreUsuario').val("");
							$('#idpasswordUsuario').val("");
							$('#personaUsuarioNombreCompleto').val(""); 
							$('#celularUsuario').val(""); 
							$('#correoUsuario').val(""); 
							$('#idTablaUsuarioRenaes').empty(); 
							if (persona != null) {
								console.log("persona.codigo " + persona.codigo);
								if(persona.codigo == "" || persona.codigo ==undefined){
									msg_advertencia("¡No se encontraron registros.!")
								}
								// debugger;
								$('#personaUsuarioNombreCompleto').val(
										persona.nombreCompleto);
								$('#celularUsuario').val(
										persona.telfCelu);
								$('#correoUsuario').val(
										persona.correo);
								$('#codigoPersonaBean').val(persona.codigo);
								$('#idpasswordUsuario').val(persona.nroDocumento);
								buscarUsuarioPersona(persona.codigo);
								
								// console.log("personaUsuarioNombreCompleto "
								// + persona.nombreCompleto);
							} else {
								msg_advertencia("¡No se encontraron registros.!")
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

function buscarUsuarioPersona(codigoPersona) {

	var contextPath = $('#contextPath').val();
	$.ajax({
		type : "GET",
		url : contextPath
				+ "/usuarioController/buscarPorCodigoPersona?codigoPersona="
				+ codigoPersona,

		success : function(usuario) {
			 if (usuario != null && usuario.codigo > 0 ) {
					// debugger;
					$('#nombreUsuario').val(usuario.nombreUsuario);
					$('#comboPerfil').val(usuario.perfil.codigo);
					$('#codigoUsuario').val(usuario.codigo);
					$('#idpasswordUsuario').val(usuario.passwordUsuario);
					// console.log("personaUsuarioNombreCompleto "
					// + persona.nombreCompleto);
				//	document.getElementById("btnAgregarEstabUser").disabled = false;
					document.getElementById("btnRestablecerClaveUser").disabled = false;
					listUsuarioAlmacen(usuario.codigo);
				//	listUsuarioRenaesBean(usuario.codigo);
				} 
		},
		error : function(xhr, status, er) {
			console.log("error: " + xhr + " status: " + status + " er:" + er);
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
 
function ocultarBotones() {
	var codigo = $('#codigoUsuario').val(); 
	if(codigo != "" ){
	//	document.getElementById("btnAgregarEstabUser").disabled = false;
		document.getElementById("btnRestablecerClaveUser").disabled = false;
	}else{
	//	document.getElementById("btnAgregarEstabUser").disabled = true;
		document.getElementById("btnRestablecerClaveUser").disabled = true;
	}
}

function listarEstablecimiento(){
	var contextPath = $('#contextPath').val();
	var htmlTabla = "";
	var item = 0; 
	var valida ="0";
	var myFormulario = $('#frmBuscarEstablecimiento'); 
	 console.log("codigoUsuario" + codigoUsuario);
	  $.ajax({
		    type: "GET",
		    url: contextPath+"/usuarioController/listarEstablecimiento",
		    data: $(myFormulario).serialize(),
		    
		    success: function(data){ 
		    	if(data!=null){     
			    	 for (var i = 0; i < data.length; i++) {
			    			var objeto = data[i];
			    			item = item + 1;
			    			htmlTabla += 
			    			"<tr>"+
			    				"<td>"+item +"</td>"+
			    				"<td>"+objeto.codigoRenaes +"</td>"+ 
				    			"<td>"+objeto.nomRenaes+"</td>"+ 
				    			"<td>"+objeto.categoria.nombreCorto+"</td>"+ 
				    			"<td>"+objeto.deptRenaes+"</td>"+ 
				    			"<td>"+objeto.provRenaes+"</td>"+ 
				    			"<td>"+objeto.distrRenaes+"</td>"+ 
				    			
				    			"<td>"+
						    	 	"<button type='button'"+
						    	 	" class='btn btn-outline-success btn-sm' "+
						    	 	" data-toggle='tooltip'  data-placement='top'  title='Asignar'"+
						    	 	"  onclick=\"cargarEstablecimientoUsuario('"+[objeto.codRenaes]+"');\""+
						      	 	" data-original-title='Seleccionar'"+
						    	 	" id='agregarEstablecimiento'>"+
						    	 	"<i class='icon-check'></i></button>"+
						    		"</td>"+
			    		"</tr>";
			    		
			    	
			    		} 
			    // console.log(htmlTabla);
			    		//$("#idBtnCerrarModalCIEX").trigger("click");
				    	$('#idBodyListaEstablecimiento').empty();  
				  	    $('#idBodyListaEstablecimiento').html(htmlTabla);
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

function grabarUsuario(contextController, idForm){   
	 
		var contextPath = $('#contextPath').val(); 
		var actionForm = $('#frmRegistroUsuario').attr("action");
		//var url  = contextPath+"/usuarioController/grabar" ;
		
	//var url = contextController + actionForm;
		var myFormulario = $('#frmRegistroUsuario'); 
		//console.log("actionForm " + actionForm);
		var actionForm = $(idForm).attr("action");
		var url = contextPath + "/usuarioController/grabar";	
		
		
		if(!myFormulario[0].checkValidity()) {
			 msg_advertencia("Debe completar los campos requeridos(*) correctamente");

		}else{
			 
				iniciarBloqueo();
				$.ajax({
				type : "POST",
				url : url,
				data: $(idForm).serialize(),
				success : function(usuario) {
					 if (usuario != null && usuario.codigo > 0 ) {
							// debugger;
						 	msg_exito("Éxito al realizar proceso");  
							$('#nombreUsuario').val(usuario.nombreUsuario);
							$('#comboPerfil').val(usuario.perfil.codigo);
							$('#codigoUsuario').val(usuario.codigo);
							$('#idpasswordUsuario').val(usuario.passwordUsuario);
							// console.log("personaUsuarioNombreCompleto "
							// + persona.nombreCompleto);
							document.getElementById("btnAgregarAlmacen").disabled = false;
							document.getElementById("btnRestablecerClaveUser").disabled = false;
					//		listUsuarioRenaesBean(usuario.codigo);
						}else{
							console.log("error al grabar ");
							msg_error("Error al realizar proceso");  
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

function asignarTurno(index) {
	var contextPath = $('#contextPath').val();
	path = contextPath + "/usuarioController/turnoModal?index="
						+ index;
	// alert("path " + path)
		$.ajax({
			type : "POST",
			url : path,

			success : function(data) {
				$("#modalTurno").html(data);
				$("#modalTurno").modal('show'); 
			},
			error : function(request, status, error) {
				console.log("ERROR: " + error);
			}
		}); 
}

function grabarTurnoAlmacen(index) {
	var contextPath = $('#contextPath').val();
	var idUsuarioAlmacen =  $('#txtIdUsarioAlmacen').val();
	var dia = 0;
	var tarde = 0;
	var noche = 0;
	
	if ($("#chkDia").is(":checked")) { 
		dia = 1;
	}
	if ($("#chkTarde").is(":checked")) { 
		tarde = 1;
		}
	if ($("#chkNoche").is(":checked")) { 
		noche = 1;
	}
	path = contextPath + "/usuarioController/grabarTurnoAlmacen?dia="
					+ dia + "&tarde=" + tarde+ "&noche=" + noche+ "&idUsuarioAlmacen=" + idUsuarioAlmacen;
	// alert("path " + path)
		$.ajax({
			type : "GET",
			url : path,
			success : function(data) { 
				msg_exito();
				$('#modalTurno').modal('hide');
			},
			error : function(request, status, error) {
				console.log("ERROR: " + error);
			}
		}); 
}
 
function enviar_ajaxv2(page,method,form){
		//showLoad_info_ajax();

		 var dirURL = page;
	 	//dirURL += page; // El script a dónde se realizará la petición.
		 iniciarBloqueo();
		    $.ajax({
		           type: method,
		           url: dirURL,
		           data: $(form).serialize(), // Adjuntar los campos del formulario enviado.
		           success: function(data)
		           {	
		        	   if(data =! ""){
		        		   msg_exito();
		        		   $('#idpasswordUsuario').val(data);
		        	   }else{
		        		   msg_error(); 
		        	   }  

		           },
					error: function(xhr,status,er) { 
		        	    msg_error();
				    },
		           complete: function(){
		        	   finBloqueo(); 
		             }
		         }); 
		    return false;  
	}

function stripAccents(input) {
    if (typeof input != "string") {
        return input;
    }
    var ORIGINAL    = "ÁáÉéÍíÓóÚúÑñÜü";
    var REPLACEMENT = "AaEeIiOoUuNnUu";
    var output = "";
    for (i = 0; i < input.length; i++) {
        var c = input[i];
        var pos = ORIGINAL.indexOf(c);
        output += pos > -1 ? REPLACEMENT[pos] : c;
    }
    return output;
}

function validar(){
    var infoHtml = "<div id='boxMsg' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert' aria-hidden='true'>×</button><span class='msgValidar'></span></div>";

    var txtUsuario = $("#textClave").val();
    var txtClave = $("#textNewClave").val();
    var txtReClave = $("#textReClave").val();

   // debugger;
 //   console.log("txtClave " + txtClave +" txtReClave " + txtReClave);
    if( txtUsuario == ""){
        $("#textClave").focus();
        var contentInput = $("#textClave").parents(".valid-msg");
        $(contentInput).addClass("has-error");
        //$("#boxMsgx").append(infoHtml);
        $("#boxMsgx").html(infoHtml);
        $("#boxMsg").fadeIn("slow");
        $(".msgValidar").html("Por favor, ingrese contraseña actual");
        return false;
    }

    if(txtUsuario != ""){
        $("#textClave").parents(".valid-msg").removeClass("has-error");
        $("#boxMsg").fadeOut();
    }


    if(txtClave == ""){
        $("#textNewClave").focus();
        var contentInput = $("#textNewClave").parents(".valid-msg");
        $(contentInput).addClass("has-error");
        //$("#boxMsgx").append(infoHtml);
        $("#boxMsgx").html(infoHtml);
        $("#boxMsg").fadeIn("slow");
        $(".msgValidar").html("Por favor, ingrese su nueva contrase&ntilde;a");
        return false;
    }

    if(txtClave != ""){
        $("#textNewClave").parents("valid-msg").removeClass("has-error");
        $("#boxMsg").fadeOut();
    }

    if(txtReClave == ""){
        $("#textReClave").focus();
        var contentInput = $("#textReClave").parents(".valid-msg");
        $(contentInput).addClass("has-error");
        //$("#boxMsgx").append(infoHtml);
        $("#boxMsgx").html(infoHtml);
        $("#boxMsg").fadeIn("slow");
        $(".msgValidar").html("Por favor, confirme su nueva contrase&ntilde;a");
        return false;
    }

    if(txtReClave != ""){
        $("#textReClave").parents("valid-msg").removeClass("has-error");
        $("#boxMsg").fadeOut();
    }

    if(txtClave != txtReClave){
    	
    	$("#textReClave").focus();
        var contentInput = $("#textReClave").parents(".valid-msg");
        $(contentInput).addClass("has-error");
        //$("#boxMsgx").append(infoHtml);
        $("#boxMsgx").html(infoHtml);
        $("#boxMsg").fadeIn("slow");
        $(".msgValidar").html("La contrase&ntilde;a no coincide");
        return false;
    }else{
    	$("#textReClave").parents("valid-msg").removeClass("has-error");
        $("#boxMsg").fadeOut();
     }
	return true;
};


function listUsuarioAlmacen(codigo){
	var htmlTabla = "";
	var item = 0; 
	var contextPath = $('#contextPath').val();
	
	path = contextPath + "/usuarioController/listarUsuarioAlmacen?codigoUsuario="+codigo;
		$.ajax({
		type : "GET",
		url : path,
		
		success : function(data) { 
		console.log(data)
	//	msg_exito();
			for (var i = 0; i < data.length; i++) {
			var objAlmacenUsu= data[i];
			item = item + 1; 
			htmlTabla += "<tr>" + "<td>"
					+ item
					+ "</td>"
					+ "<td>"
					+ "<label  class='label_control' for='nombreCompleto' id="
					+ [ objAlmacenUsu.almacen.codigo ]
			        + ">"
			        + [ objAlmacenUsu.almacen.nombreAlmacen ]
					+ "</label>"
					+ "<td>"
					+ "<button type='button'"
					+ " class='btn btn-outline-danger btn-sm' "
					+ " data-toggle='tooltip'  data-placement='top'  title='Eliminar'"
					+ "  onclick=\"confirmar_eliminar('"
					+ [ objAlmacenUsu.codigo ]
					+ "','1');\""
					+ " data-original-title='Eliminar'"
					+ " id='agregarEspecialidad'>"
					+ "  <i class='fas fa-trash'></i></button> "
					+ "</td>" + "</tr>";
		} 
		$('#idbodyTabla').empty();
		$('#idbodyTabla').html(htmlTabla);

	},
	error : function(request, status, error) {
	console.log("ERROR: " + error);
	}
 }); 		
}

function asignarAlmacen(){
	var htmlTabla = "";
	var item = 0; 
	var contextPath = $('#contextPath').val();
	var codigoUsuario = $('#codigoUsuario').val() ;
	var codPer = $('#codigoPersonaBean').val() ;
	var idAlmacen = $('#cboAlmacen').val() ;
	console.log("cod  " + codigoUsuario);
	console.log("cboAlmacen" + idAlmacen); 

	if (idAlmacen == null || idAlmacen == "") {
		msg_advertencia("Seleccione almacén a asignar");
		return;
	
	} 
	validarAlmacen(idAlmacen);
	console.log("validaExisteAlmacen " + validaExisteAlmacen);
	if (validaExisteAlmacen == "1") {
		msg_advertencia("El almacén ya se encuentra asignado");
		
		return;
		
	}else{
		path = contextPath + "/usuarioController/asignarAlmacen?codigoUsuario="+codigoUsuario+ 
		 "&idAlmacen=" + idAlmacen;
			$.ajax({
			type : "GET",
			url : path,
			
			success : function(data) { 
			console.log(data)
			msg_exito();
				for (var i = 0; i < data.length; i++) {
				var objAlmacenUsu= data[i];
				item = item + 1; 
				htmlTabla += "<tr>" + "<td>"
						+ item
						+ "</td>"
						+ "<td>"
						+ "<label  class='label_control' for='nombreCompleto' id="
						+ [ objAlmacenUsu.almacen.codigo ]
				        + ">"
				        + [ objAlmacenUsu.almacen.nombreAlmacen ]
						+ "</label>"
						+ "<td>"
						+ "<button type='button'"
						+ " class='btn btn-outline-danger btn-sm' "
						+ " data-toggle='tooltip'  data-placement='top'  title='Eliminar'"
						+ "  onclick=\"confirmar_eliminar('"
						+ [ objAlmacenUsu.codigo ]
						+ "','1');\""
						+ " data-original-title='Turno'"
						+ " id='agregarEspecialidad'>"
						+ "  <i class='fas fa-trash'></i></button> "
						+ "<button type='button'"
						+ " class='btn btn-outline-success btn-sm' "
						+ " data-toggle='tooltip'  data-placement='top'  title='Eliminar'"
						+ "  onclick=\"asignarTurno('"
						+ [ Number(i)]
						+ "','1');\""
						+ " data-original-title='Eliminar'"
						+ " id='agregarEspecialidad'>"
						+ "  <i class='fas fa-clock-o'>Turno</i></button> "
						+ "</td>" + "</tr>";
			} 
			$('#idbodyTabla').empty();
			$('#idbodyTabla').html(htmlTabla);

		},
		error : function(request, status, error) {
		console.log("ERROR: " + error);
		}
	  }); 		
   }
}


function validarAlmacen(idAlmacen){   
	/** RECORRER MENU **/
	validaExisteAlmacen = "0";
    $("#dataTable tbody tr").each(function (index) 
    {
        $(this).children("td").each(function (index2) 
        {
        	console.log("td ");
        	if(index2 == 1 ){ // Columna sub total
        		input    = $(this).children("label");
        		id = $(input).val();
  	   			idCompo  = $(input).attr("id"); 
  	   			console.log("idCompo "+idCompo);
  	   		    console.log("idAlmacen "+idAlmacen);
					if (idCompo == idAlmacen) {
						validaExisteAlmacen = "1";
					}
        	}
        })
    })	
}
