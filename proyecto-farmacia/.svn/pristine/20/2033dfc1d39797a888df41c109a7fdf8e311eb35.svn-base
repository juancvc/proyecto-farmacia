var codigoUsuario = "";
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

function confirmar_accion(codigo) {
	codigoUsuario = codigo;
	 accionRealizar = '1';
	// alert(codigoReferencia);
	$('#md_confirmacion').modal('show');

} 

$(document).ready(function() {
	$("#btnConfirmarGeneric").click(function() {
		if(accionRealizar == '2'){
			eliminar_UsuarioRenaes(codigoRegistro);
		}else{
			eliminar_Usuario(codigoUsuario);
		} 
	
	});
});


function eliminar_Usuario(codigo) { 
	var contextPath = $('#contextPath').val();
	$
			.ajax({
				url :  contextPath+"/usuarioController/eliminar?codigo="
						+ codigo,
				type : 'GET',
				success : function(data) {
					$('#md_confirmacion').modal('hide');
					msg_exito();
					$("#btnRefrescarListaUser").trigger("click");
				},
				error : function(request, status, error) {
					alert(error);
				}
			});

};
function eliminar_UsuarioRenaes(codigo) { 
	
	var contextPath = $('#contextPath').val();
	var codigoUsuario = $('#codigoUsuario').val();
	$
			.ajax({
				url :  contextPath+"/usuarioController/eliminarRenaes?codigo="
						+ codigo,
				type : 'GET',
				success : function(data) {
					$('#md_confirmacion').modal('hide');
					msg_exito(); 
					listUsuarioRenaesBean(codigoUsuario);
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
	} else {
		// console.log("validarDni " + numeroDocumento );

		$
				.ajax({
					type : "GET",
					url : contextPath
							+ "/usuarioController/consultarPorDocumentoPersona?tipoDocumento="
							+ tipoDocumento + "&numero=" + numeroDocumento,

					success : function(persona) {
						if (numeroDocumento.length < 7) {
							msg_advertencia("Número de documento incorrecto.");
						} else {
							document.getElementById("btnAgregarEstabUser").disabled = true;
							document.getElementById("btnRestablecerClaveUser").disabled = true;
							$('#codigoPersonaBean').val("");
							$('#comboPerfil').val("");
							$('#nombreUsuario').val("");
							$('#idpasswordUsuario').val("");
							$('#personaUsuarioNombreCompleto').val(""); 
							$('#idTablaUsuarioRenaes').empty(); 
							if (persona != null) {
								// debugger;
								$('#personaUsuarioNombreCompleto').val(
										persona.nombreCompleto);
								$('#codigoPersonaBean').val(persona.codigo);
								$('#idpasswordUsuario').val(persona.nroDocumento);
								buscarUsuarioPersona(persona.codigo);
								// console.log("personaUsuarioNombreCompleto "
								// + persona.nombreCompleto);
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
	}
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
					document.getElementById("btnAgregarEstabUser").disabled = false;
					document.getElementById("btnRestablecerClaveUser").disabled = false;
					listUsuarioRenaesBean(usuario.codigo);
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

function listUsuarioRenaesBean(codigoUsuario){
	var contextPath = $('#contextPath').val();
	var htmlTabla = "";
	var item = 0; 
	var valida ="0";
	 console.log("codigoUsuario" + codigoUsuario);
	  $.ajax({
		    type: "GET",
		    // data: "entidad=" + entidad,
		   	
		    url: contextPath+"/usuarioController/listUsuarioRenaesBean?codigoUsuario="+codigoUsuario,
		    	success: function(data){ 
		    	if(data!=null){     
			    	 for (var i = 0; i < data.length; i++) {
			    			var objeto = data[i];
			    			item = item + 1;
			    			htmlTabla += 
			    			"<tr>"+
			    				"<td>"+item +"</td>"+
			    				"<td>"+objeto.renaes.codRenaes +"</td>"+ 
				    			"<td>"+objeto.renaes.nomRenaes+"</td>"+ 
				    			"<td>"+objeto.renaes.categoria.nombreCorto+"</td>"+ 
				    			"<td>"+objeto.renaes.red+"</td>"+ 
				    			
				    			"<td>"+
						    	 	"<button type='button'"+
						    	 	" class='btn btn-outline-danger btn-sm' "+
						    	 	" data-toggle='tooltip'  data-placement='top'  title='Eliminar'"+
						    	 	"  onclick=\"confirmar_eliminar('"+[objeto.codigo]+"','2');\""+
						      	 	" data-original-title='Eliminar'"+
						    	 	" id='agregarEspecialidad'>"+
						    	 	"<i class='icon-trash'></i></button>"+
						    		"</td>"+
			    		"</tr>";
			    		
			    	
			    		} 
			    // console.log(htmlTabla);
			    		//$("#idBtnCerrarModalCIEX").trigger("click");
				    	$('#idTablaUsuarioRenaes').empty();  
				  	    $('#idTablaUsuarioRenaes').html(htmlTabla);
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

function ocultarBotones() {
	var codigo = $('#codigoUsuario').val(); 
	if(codigo != "" ){
		document.getElementById("btnAgregarEstabUser").disabled = false;
		document.getElementById("btnRestablecerClaveUser").disabled = false;
	}else{
		document.getElementById("btnAgregarEstabUser").disabled = true;
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
							document.getElementById("btnAgregarEstabUser").disabled = false;
							document.getElementById("btnRestablecerClaveUser").disabled = false;
							listUsuarioRenaesBean(usuario.codigo);
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

function cargarEstablecimientoModal() {
	var contextPath = $('#contextPath').val();
	var cod = $('#codigoUsuario').val() ;
	var codPer = $('#codigoPersonaBean').val() ;
	console.log("cod  " + cod);
	console.log("codPer" + codPer);

	// var codigoLengua = $('#codigoLengua').val(); //
	// document.getElementById("codigoLengua").value;

	path = contextPath + "/usuarioController/establecimientoModal";
	// alert("path " + path)
		$.ajax({
			type : "POST",
			url : path,

			success : function(data) {
				// console.log("SUCCESS: ", data);
				$('#codigoUsuarioReanes').val(cod);
			//	document.getElementById("codigoUsuarioReanes").value = '';
			//	document.getElementById("codigoPersona").value = codPer;
				$('#codigoPersona').val(codPer);
				$("#modalEstablecimiento").html(data);
				$("#modalEstablecimiento").modal('show'); 
			},
			error : function(request, status, error) {
				console.log("ERROR: " + error);
			}
		}); 
}
function modificarElementoGenerico(url, idElemento){
	var contextPath = $('#contextPath').val();
	var urlComplete = contextPath + url;
	doPost(urlComplete, { codigo : idElemento } );
}
function doPost(path, params, method) {
    method = method || "post";

    var form = document.createElement("form");

    form._submit_function_ = form.submit;

    form.setAttribute("method", method);
    form.setAttribute("action", path);

    for(var key in params) {
        var hiddenField = document.createElement("input");
        hiddenField.setAttribute("type", "hidden");
        hiddenField.setAttribute("name", key);
        hiddenField.setAttribute("value", params[key]);

        form.appendChild(hiddenField);
    }

    document.body.appendChild(form);
    form._submit_function_();
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

