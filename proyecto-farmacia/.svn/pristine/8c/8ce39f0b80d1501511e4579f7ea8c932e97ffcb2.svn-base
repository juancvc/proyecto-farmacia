/**
 * 
 */

var accionRealizar = "";
var codigoRegistro = "";
var llamadoPersonal = "";

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
			elimarApoyoReferencia(codigoRegistro);
			$('#md_confirmacion').modal('hide');
		}else if(accionRealizar == "2" ){
			eliminarCIEX(codigoRegistro);
			$('#md_confirmacion').modal('hide');
		}else if(accionRealizar == "3" ){
			eliminarApoyosDX(codigoRegistro);
			$('#md_confirmacion').modal('hide');
		}
		
	});
});

function arregloEspecialidades() {
	
	
	 alert($("#comboEspecialidad").val()) ;
	var contextPath = $('#contextPathUrl').val();
	var codigo = $('#codigoLengua').val();
	var especialidad = []; 
	var status = '';
	$(".comboEspecialidad").each(function() { 
		especialidad.push($(this).val());
		 
	});
	 
	dirURL = contextPath + "/referenciaController/grabarReferenciaEspecialidad?codigo="
			+ codigo + "&especialidad=" + especialidad;
	$.ajax({

		url : dirURL,
		type : 'POST',
		success : function(data) { 
			console.log("SUCCESS: ", data);
			status = data;
			if (data == "1") {
				msg_exito();
				$('#bootstrap2').modal('show');
				$('#modalLenguaEstructura').modal('hide');
			} else {
				msg_error();
			}
		},
		error : function(request, status, error) {
			alert(error);
		}
	});
}

function show5(){ 
	if (!document.layers&&!document.all) 
	return; 

	var Digital=new Date(); 
	var hours=Digital.getHours(); 
	var minutes=Digital.getMinutes(); 
	var seconds=Digital.getSeconds(); 
	var dn="AM"; 
	if (hours>12){ 
	dn="PM"; 
	hours=hours-12; 
	} 
	if (hours==0) 
	hours=12; 
	if (minutes<=9) 
	minutes="0"+minutes; 
	if (seconds<=9) 
	seconds="0"+seconds; 

	myclock="<font size='5' face='Arial' ><b><font size='2'>Hora Actual: </font>"+hours+":"+minutes+":" 
	+seconds+" "+dn+"</b></font>"; 

	if (document.layers){ 
	document.layers.liveclock.document.write(myclock); 
	document.layers.liveclock.document.close(); 
	} 
	else if (document.all) 
	liveclock.innerHTML=myclock 
	setTimeout("show5()",1000) 
	} 
 
function personaCargarModal() {
	var contextPath = $('#contextPath').val();
	// var codigoLengua = $('#codigoLengua').val(); //
	// document.getElementById("codigoLengua").value;

	path = contextPath + "/referenciaController/personaModal";
	// alert("path " + path)
		$.ajax({
			type : "POST",
			url : path,

			success : function(data) {
				// console.log("SUCCESS: ", data);
				$("#modalPersona").html(data);
				$("#modalPersona").modal('show'); 
			},
			error : function(request, status, error) {
				console.log("ERROR: " + error);
			}
		}); 
}

function personalCargarModal(llamado) {
// debugger;
	var contextPath = $('#contextPath').val();
	// var codigoLengua = $('#codigoLengua').val(); //
	// document.getElementById("codigoLengua").value;
	llamadoPersonal = llamado;
	console.log("llamadoPersonal " + llamadoPersonal);
	path = contextPath + "/referenciaController/personalModal";
	// alert("path " + path)
		$.ajax({
			type : "POST",
			url : path, 
			success : function(data) {
				// console.log("SUCCESS: ", data);
				$("#modalPersonal").html(data);
				$("#tipoLlamdoPersonal").val(llamado);
				$("#modalPersonal").modal('show'); 
				
			},
			error : function(request, status, error) {
				console.log("ERROR: " + error);
			}
		}); 
}


function buscarPersonal() {

			var contextPath = $('#contextPath').val();
			var numeroDocumento = $('#nroDocumentoPersonal').val(); 
			var tipoDocumento = $('#tipoDocumentoPersonal').val(); 
			
			// console.log("buscarPacienteSISWebService tipoDocumentoPaciente "
			// + tipoDocumentoPaciente);
			if (tipoDocumento == null || tipoDocumento ==""){
			  	msg_advertencia("Seleccione tipo de documento");
			  	return;
			}else if(numeroDocumento == null || numeroDocumento ==""){
				msg_advertencia("Ingrese número de documento");
			  	return;
			}else if (numeroDocumento.length < 7) {
			   	msg_advertencia("Número de documento incorrecto.")
			   	return;
			}else if (tipoDocumento == '000001' && numeroDocumento.length != 8) { 
			   	msg_advertencia("Número de dni debe contener 8 dígitos.")
			   	return;
			}else{
				
			// console.log("validarDni " + numeroDocumento );
			 
			 $.ajax({
			   type: "GET", 
			   url: contextPath+"/referenciaController/consultarPorDocumentoPersona?tipoDocumento="
			   + tipoDocumento+ "&numero=" + numeroDocumento ,
			  
			   success: function(personal){
			   	if (numeroDocumento.length < 7) {
			   	msg_advertencia("Número de documento incorrecto.");
			}else{
			   	
				if(personal!=null ){  
					// debugger;
				   $('#personalNombreCompleto').val(personal.persona.nombreCompleto);
				   $('#personalApellidoPaterno').val(personal.persona.apellidoPaterno);
			       $('#personalApellidoMaterno').val(personal.persona.apellidoMaterno);
			       $('#personalPrimerNombre').val(personal.persona.primerNombre);
			       $('#personalSegundoNombre').val(personal.persona.segundoNombre);
			       
			       $('#personalCodigo').val(personal.persona.codigo); 
			       $('#codigoPersonalSigeho').val(personal.persona.codigoPersonaSigeho); 
	 
			    // $('#tipoDocumentoPaciente').val(paciente.persona.tipoDocumento.codReg);
			       console.log("personal.persona.fechaNac " + personal.persona.fechaNac);
			       var todate = new Date(personal.persona.fechaNac);
			       var dia = todate.getDate();
		            var mes = todate.getMonth()+1; // January is 0!
		            var anio = todate.getFullYear();
		            
		            var nDia = dia.toString().length;
		            console.log(" nDia:: " + nDia);
		            
		            if (dia.toString().length == 1) {
		            	dia = "0"+dia;
					}
		            if (mes.toString().length == 1) {
		            	mes = "0"+mes;
					}
		            console.log("dia/" + dia+"mes "+ mes+" anio " + anio + "todate " + todate);
		            
				   $('#personalFechaNac').val(dia+"/"+mes+"/"+anio); 
			       $('#sexoPersonal').val(personal.persona.sexo.codReg);  
			      
				 }else{
			   	 msg_advertencia("¡No se encontraron registros.!")
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
}

function descartarCargarModal(index) {
	var contextPath = $('#contextPath').val();
	// var codigoLengua = $('#codigoLengua').val(); //
	// document.getElementById("codigoLengua").value;

	path = contextPath + "/referenciaController/modaldescartarReferencia?index=" +index;
	// alert("path " + path)
		$.ajax({
			type : "POST",
			url : path,

			success : function(data) {
				// console.log("SUCCESS: ", data);
				$("#md_descartar-referencia").html(data);
				$("#md_descartar-referencia").modal('show'); 
			},
			error : function(request, status, error) {
				console.log("ERROR: " + error);
			}
		}); 
}


function cargarEstablecimientoModal() {
	var contextPath = $('#contextPath').val();
	// var codigoLengua = $('#codigoLengua').val(); //
	// document.getElementById("codigoLengua").value;

	path = contextPath + "/referenciaController/establecimientoModal";
	// alert("path " + path)
		$.ajax({
			type : "POST",
			url : path,

			success : function(data) {
				// console.log("SUCCESS: ", data);
				$("#modalEstablecimiento").html(data);
				$("#modalEstablecimiento").modal('show'); 
			},
			error : function(request, status, error) {
				console.log("ERROR: " + error);
			}
		}); 
}

function especialidadCargarModal(codigoCIEX) {
	// alert("especialidadCargarModal");
	var contextPath = $('#contextPath').val();
	
	// debugger;
	path = contextPath + "/referenciaController/especialidadesModal";
	// alert("path " + path)
		$.ajax({
			type : "POST",
			url : path,
			
			success : function(data) {
				// console.log("SUCCESS: ", data);
				$("#modalEspecialidad").html(data);
				$("#modalEspecialidad").modal('show'); 
				$("#codigoCIEXAsociado").val(codigoCIEX); 
			},
			error : function(request, status, error) {
				console.log("ERROR: " + error);
			}
		}); 
}

function cie10CargarModal() {
	var contextPath = $('#contextPath').val();
	// var codigoLengua = $('#codigoLengua').val(); //
	// document.getElementById("codigoLengua").value;

	path = contextPath + "/referenciaController/listadoCIEXModal";
	// alert("path " + path)
	// iniciarBloqueo();
	$.ajax({
		type : "POST",
		url : path, 
		success : function(data) {
			$("#modalDXCIEX").html(data);
			$("#modalDXCIEX").modal('show'); 
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


function apoyoDXCargarModal() {
	var contextPath = $('#contextPath').val();
	$('#tipoLlamadoApoyo').val(1);
	var tipoApoyo = $('#comboTipoApoyo').val(); // document.getElementById("codigoLengua").value;
	// console.log("tipoApoyo: ", tipoApoyo);
	if (tipoApoyo.length ==0) {
		msg_advertencia("Seleccione Tipo de Apoyo");
	}else{
	path = contextPath + "/referenciaController/listadoDXModal?tipoApoyo="+tipoApoyo;
	// alert("path " + path)
		$.ajax({
			type : "POST",
			url : path,
			
			success : function(data) { 
				$("#modalApoyoDX").html(data);
				$('#tipoApoyolstDX').val(tipoApoyo);
				$("#modalApoyoDX").modal('show');
				
				
			},
			error : function(request, status, error) {
				console.log("ERROR: " + error);
			}
		}); 
	}
}


function apoyoDXCargarModalSelApoyo() {
	var contextPath = $('#contextPath').val();
	$('#tipoLlamadoApoyo').val("2");
	var tipoApoyo = $('#comboTipoApoyoREFapoyo').val(); // document.getElementById("codigoLengua").value;
	console.log("tipoApoyo: ", tipoApoyo);
	if (tipoApoyo.length ==0) {
		msg_advertencia("Seleccione Tipo de Apoyo");
	}else{
	path = contextPath + "/referenciaController/listadoDXModal?tipoApoyo="+tipoApoyo;
	// alert("path " + path)
		$.ajax({
			type : "POST",
			url : path,
			
			success : function(data) {
				$("#modalApoyoDX").html(data);
				$('#tipoApoyolstDX').val(tipoApoyo);
				// console.log("SUCCESS: ", data);
				
				$("#modalApoyoDX").modal('show');
				
				
			},
			error : function(request, status, error) {
				console.log("ERROR: " + error);
			}
		}); 
	}
}


function buscarPacienteSISWebService() {

			var contextPath = $('#contextPath').val();
			var numeroDocumento = $('#nroDocumentoPaciente').val(); 
			var tipoDocumento = $('#tipoDocumentoPaciente').val(); 
			
			 console.log("buscarPacienteSISWebService tipoDocumentoPaciente "
			 + tipoDocumentoPaciente);
			if (tipoDocumento == null || tipoDocumento ==""){
			  	msg_advertencia("Seleccione tipo de documento");
			  	return;
			}else if(numeroDocumento == null || numeroDocumento ==""){
				msg_advertencia("Ingrese número de documento");
			  	return;
			}else if (numeroDocumento.length < 7) {
			   	msg_advertencia("Número de documento incorrecto.")
			   	return;
			}else if (tipoDocumento == '000002' && numeroDocumento.length != 8) { 
			   	msg_advertencia("Número de dni debe contener 8 dígitos.")
			   	return;
			}else if (tipoDocumento == '000006' && numeroDocumento.length <= 10) { 
			   	msg_advertencia("Número de pasaporte incorrecto.")
			   	return;
			}else{
			// console.log("validarDni " + numeroDocumento );
				iniciarBloqueo();
			 $.ajax({
			   type: "GET", 
			   url: contextPath+"/pacienteController/consultarPorDocumentoPersona?tipoDocumento="
			   + tipoDocumento+ "&numero=" + numeroDocumento ,
			  
			   success: function(paciente){
			   	if (numeroDocumento.length < 7) {
			   	msg_advertencia("Número de documento incorrecto.");
			   	
			   	}else{
			   	
				if(paciente!=null){  
					console.log("paciente.length " + paciente.length);
					// debugger;
					if ( paciente.length != 0) {
						 $('#pacienteNombreCompleto').val(paciente.persona.nombreCompleto);
						   $('#personaApellidoPaterno').val(paciente.persona.apellidoPaterno);
					       $('#personaApellidoMaterno').val(paciente.persona.apellidoMaterno);
					       $('#personaPrimerNombre').val(paciente.persona.primerNombre);
					       $('#personaSegundoNombre').val(paciente.persona.segundoNombre);
					       $('#fotoPaciente').val(paciente.persona.fotoCadena); 
					       $('#personaCodigo').val(paciente.persona.codigo); 
					       $('#codigoPersonaSigeho').val(paciente.persona.codigoPersonaSigeho); 
					       var image = new Image();
					       var src = contextPath + "/assets/img/fotoPersonaGenerico.gif";
					       if (paciente.persona.foto != null){
					    	   src = "data:image/png;base64,"+paciente.persona.foto ; 
					       }  
					       image.src = src;
					       image.alt = "Image"
					   // $('#imgFotoPaciente').append(image);
					       
					       $("#imgFotoPaciente").attr("src", image.src);
					       
					    // $('#tipoDocumentoPaciente').val(paciente.persona.tipoDocumento.codReg);
					       console.log("paciente.persona.fechaNac " + paciente.persona.fechaNac);
					       var todate = new Date(paciente.persona.fechaNac);
					       var dia = todate.getDate();
				           var mes = todate.getMonth()+1; // January is 0!
				           var anio = todate.getFullYear();
				            
				           var nDia = dia.toString().length;
				           console.log(" nDia:: " + nDia);
				            
				           if (dia.toString().length == 1) {
				            	dia = "0"+dia;
							}
				           if (mes.toString().length == 1) {
				            	mes = "0"+mes;
							}
				            console.log("dia/" + dia+"mes "+ mes+" anio " + anio + "todate " + todate);
				           if (paciente.tipoSeguro.codReg) {
							
						}  
						   $('#personaFechaNac').val(dia+"/"+mes+"/"+anio); 
					       $('#sexoPaciente').val(paciente.persona.sexo.codReg); 
					     
					       console.log("paciente.tipoSeguro.codReg " + paciente.tipoSeguro.codReg);
					       if(paciente.tipoSeguro.codReg != null){
					       if  (paciente.tipoSeguro.codReg == '000003') {
					    	   $("#tipoSeguroPaciente option[value='000003']").show();
					    	   $('#categoriaPaciente').val(paciente.categoriaSeguro); 
						       $('#tipoSeguroPaciente').val(paciente.tipoSeguro.codReg);  
						       $('#codigoFiliacionPaciente').val(paciente.codigoFiliacion);  
						       
						       document.getElementById('categoriaPaciente').style.display = 'block';
					    	   document.getElementById('codigoFiliacionPaciente').style.display = 'block';
					    	   document.getElementById('lblcodigoFiliacionPaciente').style.display = 'block';
					    	   document.getElementById('lblcategoriaPaciente').style.display = 'block';
					    	   
					       }  else {
					    	   document.getElementById('tipoSeguroPaciente').disabled = false; 
					    	  // $('#tipoSeguroPaciente
								// option[value=000003]').remove();
					    	   $("#tipoSeguroPaciente option[value='000003']").hide();
					    	   document.getElementById('categoriaPaciente').style.display = 'none';
					    	   document.getElementById('codigoFiliacionPaciente').style.display = 'none';
					    	   document.getElementById('lblcodigoFiliacionPaciente').style.display = 'none';
					    	   document.getElementById('lblcategoriaPaciente').style.display = 'none';
					    	   msg_advertencia("¡Paciente no afiliado al SIS!")
					    	   
					       }
					       }else{
					    	   if(paciente.idErrorWSIS == '6'){
					    		   
					    		   msg_advertencia(paciente.estado);
					    		   $("#tipoSeguroPaciente option[value='000003']").show();
					    		   document.getElementById('categoriaPaciente').style.display = 'block';
						    	   document.getElementById('codigoFiliacionPaciente').style.display = 'block';
						    	   document.getElementById('lblcodigoFiliacionPaciente').style.display = 'block';
						    	   document.getElementById('lblcategoriaPaciente').style.display = 'block';
						    	   
						    	   document.getElementById('tipoSeguroPaciente').disabled = false; 
						    	   document.getElementById('categoriaPaciente').disabled = false; 
						    	   document.getElementById('codigoFiliacionPaciente').disabled = false; 
						    	   document.getElementById('lblcategoriaPaciente').disabled = false; 
						    	   document.getElementById('lblcodigoFiliacionPaciente').disabled = false; 
					    	   }else if(paciente.idErrorWSIS == '14'){
					    		   
					    		   msg_advertencia(paciente.estado);
					    		   $("#tipoSeguroPaciente option[value='000003']").hide();
					    		   document.getElementById('categoriaPaciente').style.display = 'none';
						    	   document.getElementById('codigoFiliacionPaciente').style.display = 'none';
						    	   document.getElementById('lblcodigoFiliacionPaciente').style.display = 'none';
						    	   document.getElementById('lblcategoriaPaciente').style.display = 'none';
						    	   
						    	   document.getElementById('tipoSeguroPaciente').disabled = false;  
					    	   }else if(paciente.idErrorWSIS == 'I'){
					    		   
					    		   msg_advertencia(paciente.estado);
					    		   $("#tipoSeguroPaciente option[value='000003']").hide();
					    		   document.getElementById('categoriaPaciente').style.display = 'none';
						    	   document.getElementById('codigoFiliacionPaciente').style.display = 'none';
						    	   document.getElementById('lblcodigoFiliacionPaciente').style.display = 'none';
						    	   document.getElementById('lblcategoriaPaciente').style.display = 'none';
						    	   
						    	   document.getElementById('tipoSeguroPaciente').disabled = false;  
					    	   }
					       }
					       
					       
					}else{
						 msg_advertencia("¡No se encontraron registros.!") 
						   document.getElementById('tipoSeguroPaciente').disabled = false; 
				    	   document.getElementById('categoriaPaciente').disabled = false; 
				    	   document.getElementById('codigoFiliacionPaciente').disabled = false; 
				    	   document.getElementById('lblcategoriaPaciente').disabled = false; 
				    	   document.getElementById('lblcodigoFiliacionPaciente').disabled = false; 
				    	   document.getElementById('pacienteNombreCompleto').disabled = false; 
				    	   document.getElementById('personaApellidoPaterno').disabled = false; 
				    	   document.getElementById('personaApellidoMaterno').disabled = false; 
				    	   document.getElementById('personaPrimerNombre').disabled = false; 
				    	   document.getElementById('personaSegundoNombre').disabled = false; 
				    	   document.getElementById('personaFechaNac').disabled = false;  
				    	   document.getElementById('sexoPaciente').disabled = false;
					}
				  
				 }else{
			   	 msg_advertencia("¡No se encontraron registros.!")
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
			 finBloqueo();
			}	
}
	function buscarPersonaWebService() {

				 // var tipoDocumento = $('#tipoDocPersona_busqdato').val();
				 var numeroDocumento = $('#numDocPersona_busqdato').val();


				 var contextPath = $('#contextPathUrl').val();
				 
				 var masculino = document.getElementById('male');
				 var femenino = document.getElementById('female');
				 
				 console.log("validarDni");
				 
				 $.ajax({
				   type: "GET",
				   // data: "entidad=" + entidad,
				 // url:
					// contextPath+"/personaController/buscarPacienteReniec2?tipo="+tipoDocumento+"&numero="+numeroDocumento,
				   url: contextPath+"/personaController/consultarPorDocumentoPersona?numero="+numeroDocumento,
				  
				   success: function(response){
				   	if (numeroDocumento.length < 7) {
				   	msg_advertencia("Número de documento incorrecto.");
				}else{
				   	
				   	if(response.codigoDeError == 0000){ 
				  // $('#codigoPersona_instope').val(response.codigo);
				  // $('#nombresPersona_dato').val(response.apPrimer);
				       $('#apellidoPaternoPersona_dato').val(response.apPrimer);
				       $('#apellidoMaternoPersona_dato').val(response.apSegundo);
				       
				       if(response.prenomInscrito.indexOf(" ")>0){ 
				       $('#primerNombrePersona_dato').val(response.prenomInscrito.substring(0,response.prenomInscrito.indexOf(" ")));
				       $('#segundoNombrePersona_dato').val(response.prenomInscrito.substring(response.prenomInscrito.indexOf(" ")+1,response.prenomInscrito.length));
				        }
				     else { 
				     
				     $('#primerNombrePersona_dato').val(response.prenomInscrito.substring(0,response.prenomInscrito.length));
				     $('#segundoNombrePersona_dato').val("");
				       }
				       
				       $('#departamentoPersona_dato').val(response.noDepartamentoDomicilio);
				       $('#distritoPersona_dato').val(response.noDistritoDomicilio);
				       $('#direccion_dato').val(response.noDomicilio);
				   // $('#telefonoPersona_dato').val(response.telefono);
				       $('#sexoPersona_dato').val(response.deGenero);
				       $('#edadPersona_dato').val(response.feNacimiento);
				       $('#edadAnioPersona_dato').val(response.feNacimiento);
				       $('#edadMesPersona_dato').val(response.feNacimiento);
				       $('#edadDiaPersona_dato').val(response.feNacimiento);
				      if(response.deGenero === "1"){  
				      masculino.checked = true;  
				      femenino.checked = false;
				     }
				     else {   
				      masculino.checked = false;  
				      femenino.checked = true;
				     }
				     
				     
				     
				     
				     var stEdad = (response.feNacimiento.substring(6,8)+"-"+response.feNacimiento.substring(4,6)+"-"+response.feNacimiento.substring(0,4));
				     var stEdad2 = (response.feNacimiento.substring(0,4)+"-"+response.feNacimiento.substring(4,6)+"-"+response.feNacimiento.substring(6,8));
				     var anio =(response.feNacimiento.substring(0,4)+"-")
				     var mess =(response.feNacimiento.substring(4,6)+"-")
				     var diaa =(response.feNacimiento.substring(6,8))
				     $('#fechaNac_dato').val(stEdad);
				     $('#fechaNac2_dato').val(stEdad2);
				     
				      var fechaFinal ;
					 fechaFinal = new String(stEdad2);
				  // console.log(validar_fecha(fechaFinal));
				    if(validar_fecha(fechaFinal)==true)
				    {
				        // Si la fecha es correcta, calculamos la edad
				        var values=fechaFinal.split("-");
				        var dia = values[2];
				        var mes = values[1];
				        var ano = values[0];
				 
				        // cogemos los valores actuales
				        var fecha_hoy = new Date();
				        var ahora_ano = fecha_hoy.getYear();
				        var ahora_mes = fecha_hoy.getMonth()+1;
				        var ahora_dia = fecha_hoy.getDate();
				 
				        // realizamos el calculo
				        var edad = (ahora_ano + 1900) - ano;
				        if ( ahora_mes < mes )
				        {
				            edad--;
				        }
				        if ((mes == ahora_mes) && (ahora_dia < dia))
				        {
				            edad--;
				        }
				        if (edad > 1900)
				        {
				            edad -= 1900;
				        }
				 
				        // calculamos los meses
				        var meses=0;
				        if(ahora_mes>mes)
				            meses=ahora_mes-mes;
				        if(ahora_mes<mes)
				            meses=12-(mes-ahora_mes);
				        if(ahora_mes==mes && dia>ahora_dia)
				            meses=11;
				 
				        // calculamos los dias
				        var dias=0;
				        if(ahora_dia>dia)
				            dias=ahora_dia-dia;
				        if(ahora_dia<dia)
				        {
				            ultimoDiaMes=new Date(ahora_ano, ahora_mes, 0);
				            dias=ultimoDiaMes.getDate()-(dia-ahora_dia);
				        }
				         
				       $('#edadAniosPersona_dato').val(edad);
				       $('#edadMesesPersona_dato').val(meses);
				       $ ('#edadDiasPersona_dato').val(dias);
				     
				      }
				  
				  // else{
				   // document.getElementById("result").innerHTML="La fecha
					// "+fecha+" es incorrecta";
				   // }
				     
				     
				     
				     
				     
				     
				     
				   // calcularEdad("stEdad");

					 }else{
				   	 msg_advertencia("¡No se encontraron registros.!")
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
	
	
function nif(dni) {
  numero = dni.substr(0,dni.length-1);
 // let = dni.substr(dni.length-1,1);
  numero = numero % 23;
  letra='TRWAGMYFPDXBNJZSQVHLCKET';
  letra=letra.substring(numero,numero+1);
  if (letra!=let) 
    alert('Dni erroneo');
}

function ocultar(){
	
	document.getElementById('ver').style.display = 'none';
}

function mostrarPorTipo(){
	// alert($("#comboUPS").val()) ;
	
	var codigoUPS = $('#comboUPS').val();
	// console.log("codigoUPS" + codigoUPS);
		if (codigoUPS == "000001") {
			// console.log("000001 es CEX");
		// document.getElementById('datosCEX').style.display = 'block';
			document.getElementById('panelCEX').style.display = 'block';
		// document.getElementById('btnBuscardatosCEX').style.display = 'block';
			
			document.getElementById('panelApoyo').style.display = 'none';
			
			// $("#panelCEX").style= "display=block;";
		}else if (codigoUPS  == "000002") {
		// document.getElementById('datosCEX').style.display = 'none';
			document.getElementById('panelCEX').style.display = 'none';
		// document.getElementById('btnBuscardatosCEX').style.display = 'none';
			
			document.getElementById('panelApoyo').style.display = 'block';
			// $("#panelCEX").style.display = 'block';
			// console.log("000002 es DX");
		}else{
		// document.getElementById('btnBuscardatosCEX').style.display = 'none';
		// document.getElementById('datosCEX').style.display = 'none';
			document.getElementById('panelCEX').style.display = 'none';
			document.getElementById('panelApoyo').style.display = 'none';
		}
}

function llenarEspecialidadREF(codCIEX,nombre,codReg){
 
	$("#btnCerrarmodalEspecialidad").trigger("click");
	$('#nombreEspecialidadREF').val(nombre);
	$('#codRegEspecialidadREF').val(codReg);
	
	var htmlTabla = "";
	var item = 0; 
	
	console.log("codigo " + codCIEX);
	console.log("codigo " + nombre);
	for (var i = 0; i < listadoCIEX.length; i++) {
		var objCIEX = listadoCIEX[i];
		// console.log("objCIEX.codReg " + objCIEX.codReg);
		if(objCIEX.codReg == codCIEX){
		// console.log("objCIEX.codReg/codigo " + codigo);
		// listadoCIEX.splice(i, 1);
			objCIEX.valor5 =nombre;
			objCIEX.valor6 =codReg;
		// listadoCIEX.push(objCIEX);
		}
	} 
	
	for (var i = 0; i < listadoCIEX.length; i++) {
		var objCIEX = listadoCIEX[i];
		item = item + 1;
	htmlTabla += 
		"<tr>"+
			"<td>"+item +"</td>"+
			"<td>"+objCIEX.valor4 +"</td>"+ 
			"<td>"+objCIEX.nombreCorto+"</td>"+  
			"<td><select"+
			" onchange=\"llenarTipoDX('"+objCIEX.valor4+"');\""+
			" name='cboTipoDX"+objCIEX.valor4.trim() + "' id='cboTipoDX"+objCIEX.valor4.trim() +"' class='form-control'>"+
		    "<option value=''>SELECCIONAR</option>"+
		    "<option value='000001' >PRESUNTIVO</option>"+
		    "<option value='000002' >DEFINITIVO</option>"+
		    "<option value='000003' >REPETIDO (CONTROL)</option>"+											  													    
		"</select></td>"+ 
			"<td>"+objCIEX.valor5+"</td>"+ 
			"<td>"+
    			"<button type='button'"+
	    	 	" class='btn btn-outline-success btn-sm' "+
	    	 	" data-toggle='tooltip'  data-placement='top' "+
	    	 	"  onclick=\"especialidadCargarModal('"+[objCIEX.codReg]+"');\""+
	      	 	" data-original-title='Agregar'"+
	    	 	" id='agregarEspecialidad'>"+
	    	 	"<i class='fa fa-plus'></i>Agregar especialidad</button>  "+
	    	 	
	    	 	"<button type='button'"+
	    	 	" class='btn btn-outline-danger btn-sm' "+	    	 	
	    	 	"  onclick=\"confirmar_eliminar('"+[objCIEX.codReg]+"','2');\""+
	      	 	" data-original-title='Eliminar'"+
	    	 	" id='agregarEspecialidad'>"+
	    	 	"<i class='icon-trash'></i></button>"+
	    		"</td>"+
	    "</tr>";
	
	}
	$('#idbodyCIEXref').empty();  
	$('#idbodyCIEXref').html(htmlTabla);
	for (var i = 0; i < listadoCIEX.length; i++) {
		var objCIEX = listadoCIEX[i]; 
			$("#cboTipoDX"+objCIEX.valor4.trim()).val(objCIEX.valor7);
		 
	}
	
	 
}

function eliminarCIEX(codigo){
	var htmlTabla = "";
	var item = 0; 
	
	console.log("codigo " + codigo);
	for (var i = 0; i < listadoCIEX.length; i++) {
		var objCIEX = listadoCIEX[i];
		// console.log("objCIEX.codReg " + objCIEX.codReg);
		if(objCIEX.codReg == codigo){
		// console.log("objCIEX.codReg/codigo " + codigo);
			listadoCIEX.splice(i, 1);
		}
	} 
	// console.log("listadoCIEX.length " + listadoCIEX.length);
	
	for (var i = 0; i < listadoCIEX.length; i++) {
		var objCIEX = listadoCIEX[i];
		item = item + 1;
	htmlTabla += 
		"<tr>"+
			"<td>"+item +"</td>"+
			"<td>"+objCIEX.valor4 +"</td>"+ 
			"<td>"+objCIEX.nombreCorto+"</td>"+ 
			"<td><select"+
			" onchange=\"llenarTipoDX('"+objCIEX.valor4+"');\""+
			" name='cboTipoDX"+objCIEX.valor4.trim() + "' id='cboTipoDX"+objCIEX.valor4.trim() +"' class='form-control'>"+
		    "<option value=''>SELECCIONAR</option>"+
		    "<option value='000001' >PRESUNTIVO</option>"+
		    "<option value='000002' >DEFINITIVO</option>"+
		    "<option value='000003' >REPETIDO (CONTROL)</option>"+											  													    
		"</select></td>"+  
			"<td>"+objCIEX.valor5+"</td>"+ 
			"<td>"+
    			"<button type='button'"+
	    	 	" class='btn btn-outline-success btn-sm' "+
	    	 	" data-toggle='tooltip'  data-placement='top' "+
	    	 	"  onclick=\"especialidadCargarModal('"+[objCIEX.codReg]+"');\""+
	      	 	" data-original-title='Agregar'"+
	    	 	" id='agregarEspecialidad'>"+
	    	 	"<i class='fa fa-plus'></i>Agregar especialidad</button>  "+
			 
	    	 	"<button type='button'"+
	    	 	" class='btn btn-outline-danger btn-sm' "+
	    	 	" data-toggle='tooltip'  data-placement='top'  title='Eliminar'"+
	    	 	"  onclick=\"confirmar_eliminar('"+[objCIEX.codReg]+"','2');\""+
	      	 	" data-original-title='Eliminar'"+
	    	 	" id='agregarEspecialidad'>"+
	    	 	"<i class='icon-trash'></i></button>"+
	    		"</td>"+
	    "</tr>";
	
	}
	$('#idbodyCIEXref').empty();  
	$('#idbodyCIEXref').html(htmlTabla);
	for (var i = 0; i < listadoCIEX.length; i++) {
		var objCIEX = listadoCIEX[i]; 
			$("#cboTipoDX"+objCIEX.valor4.trim()).val(objCIEX.valor7);
		 
	}
}

function llenarEstablecimientoOrigen(nombre,codReg){
	 
	$("#btnCerrarModalEstab").trigger("click");
	$('#nombreEstablecimientoDestino').val(nombre);
	$('#idEstablecimientoDestino').val(codReg);
}

function llenarApoyoDxREF(nombre,codReg,valor1,valor2){
	 var tipoLlamadoApoyo = $('#tipoLlamadoApoyo').val();
	 console.log($('#tipoLlamadoApoyo').val());
	 
	 if (tipoLlamadoApoyo == "1") {
			$("#btnCerrarmodalApoyoDX").trigger("click");
			document.getElementById("nombreApoyoRealizado").value   =nombre.trim();
			// $('#nombreApoyoRealizado').val(nombre.trim());
			$('#codRegApoyoDXrealizadoREF').val(codReg);
			$('#categoriaApoyoRealizado').val(valor1);
			$('#codCategoriaRealizado').val(valor2);
	}else if (tipoLlamadoApoyo == "2"){
			$("#btnCerrarmodalApoyoDX").trigger("click");
			document.getElementById("txtNombreApoyo").value   =nombre.trim();
			// $('#txtNombreApoyo').val(nombre.trim());
			$('#codRegApoyoREF').val(codReg);
			$('#categoriaApoyo').val(valor1);
			$('#codCategoria').val(valor2);
	}

}

function enviarPaciente(){ 
	var numeroDocumento = $('#nroDocumentoPaciente').val(); 
	var tipoDocumento = $('#tipoDocumentoPaciente').val(); 
	var myFormulario = $('#frmGuardarPersona'); 
	
	if(!myFormulario[0].checkValidity()) {
		 msg_advertencia("Debe completar los campos requeridos(*) correctamente");

	}else if($('#tipoSeguroPaciente').val() =='000003'){
		if($('#categoriaPaciente').val().trim() ==''){
			 msg_advertencia("Debe ingresar la categoría del SIS");
		}else if($('#codigoFiliacionPaciente').val().trim() == ''){
			 msg_advertencia("Debe ingresar número de filiación");
		}else{
			
			$("#btnCerrarModalPaciente").trigger("click");
			$("#nombreCompletoPacienteREF").val($('#pacienteNombreCompleto').val());
			$('#tipoSeguroPacienteREF').val($('#tipoSeguroPaciente').val());
			$('#categoriaPacienteREF').val($('#categoriaPaciente').val());
			$('#tipoSeguroPacienteREFER').val($('#tipoSeguroPaciente').val());
			$('#categoriaPacienteREFER').val($('#categoriaPaciente').val());
			$('#codigoFiliacionPacienteREF').val($('#codigoFiliacionPaciente').val());
			$('#codigoFiliacionPacienteREFERENCIA').val($('#codigoFiliacionPaciente').val());
			
			$('#personaApellidoPaternoREF').val($('#personaApellidoPaterno').val());
			$('#personaApellidoMaternoREF').val($('#personaApellidoMaterno').val());
			$('#personaPrimerNombreREF').val($('#personaPrimerNombre').val());
			$('#personaSegundoNombreREF').val($('#personaSegundoNombre').val());
			$('#personaCodigoREF').val($('#personaCodigo').val());
			$('#personaSexoCodigoREF').val($('#sexoPaciente').val());
			$('#codigoPersonaSigehoREF').val($('#codigoPersonaSigeho').val());
			$('#personaFechaNacREF').val($('#personaFechaNac').val());  
			$('#tipoDocumentoPacienteREF').val($('#tipoDocumentoPaciente').val());  
			$('#nroDocumentoPacienteREF').val($('#nroDocumentoPaciente').val());  
		
			var todate = new Date($('#personaFechaNac').val());
			var fechaActual = new Date();
			var anio = todate.getFullYear();
			var anioActual = fechaActual.getFullYear();
			var periodo = $('#personaFechaNac').val().substr(
			$('#personaFechaNac').val().length-4,$('#personaFechaNac').val().length);
			var edad = anioActual - periodo;
			$('#edadPaciente').val(edad);     
	            
		}
	}else{ 
			$("#btnCerrarModalPaciente").trigger("click");
			$("#nombreCompletoPacienteREF").val($('#pacienteNombreCompleto').val());
			$('#tipoSeguroPacienteREF').val($('#tipoSeguroPaciente').val());
			$('#categoriaPacienteREF').val($('#categoriaPaciente').val());
			$('#tipoSeguroPacienteREFER').val($('#tipoSeguroPaciente').val());
			$('#categoriaPacienteREFER').val($('#categoriaPaciente').val());
			$('#codigoFiliacionPacienteREF').val($('#codigoFiliacionPaciente').val());
			$('#codigoFiliacionPacienteREFERENCIA').val($('#codigoFiliacionPaciente').val());
			
			$('#personaApellidoPaternoREF').val($('#personaApellidoPaterno').val());
			$('#personaApellidoMaternoREF').val($('#personaApellidoMaterno').val());
			$('#personaPrimerNombreREF').val($('#personaPrimerNombre').val());
			$('#personaSegundoNombreREF').val($('#personaSegundoNombre').val());
			$('#personaCodigoREF').val($('#personaCodigo').val());
			$('#personaSexoCodigoREF').val($('#sexoPaciente').val());
			$('#codigoPersonaSigehoREF').val($('#codigoPersonaSigeho').val());
			$('#personaFechaNacREF').val($('#personaFechaNac').val());  
			$('#tipoDocumentoPacienteREF').val($('#tipoDocumentoPaciente').val());  
			$('#nroDocumentoPacienteREF').val($('#nroDocumentoPaciente').val());  
		
			    var todate = new Date($('#personaFechaNac').val());
			    var fechaActual = new Date();
	            var anio = todate.getFullYear();
	            var anioActual = fechaActual.getFullYear();
	             
	            var periodo = $('#personaFechaNac').val().substr(
	            		$('#personaFechaNac').val().length-4,$('#personaFechaNac').val().length);
	           // console.log("periodo " + periodo);
	           var edad = anioActual - periodo;
	           // console.log("edad/" + edad);
	         $('#edadPaciente').val(edad);     
	            
	}
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

function modificarElementoGenerico(url, idElemento){
	var contextPath = $('#contextPath').val();
	var urlComplete = contextPath + url;
	doPost(urlComplete, { codigo : idElemento } );
}

function eliminarApoyosDX(codigo){
	
	var htmlTabla = "";
	var item = 0; 
	
	console.log("codigo " + codigo);
	for (var i = 0; i < listadoApoyosDX.length; i++) {
		var objApoyoDX = listadoApoyosDX[i];
		// console.log("objApoyoDX.codReg " + objApoyoDX.codReg);
		if(objApoyoDX.codReg == codigo){
			// console.log("objApoyoDX.codReg/codigo " + codigo);
			listadoApoyosDX.splice(i, 1);
		}
	}
	
	for (var i = 0; i < listadoApoyosDX.length; i++) {
		var objApoyoDX = listadoApoyosDX[i];
		item = item + 1;
		htmlTabla += 
			"<tr>"+
				"<td>"+item +"</td>"+
				"<td>"+objApoyoDX.valor1 +"</td>"+ 
    			"<td>"+objApoyoDX.nombreCorto+"</td>"+ 
    			"<td>"+
		    	 	"<button type='button'"+
		    	 	" class='btn btn-outline-danger btn-sm' "+
		    	 	" data-toggle='tooltip'  data-placement='top'  title='Eliminar'"+
		    	 	"  onclick=\"confirmar_eliminar('"+[objApoyoDX.codReg]+"','3');\""+
		      	 	" data-original-title='Eliminar'"+
		    	 	" id='agregarEspecialidad'>"+
		    	 	"<i class='icon-trash'></i></button>"+
		    		"</td>"+
		     "</tr>"; 
	}   
	// $("#idBtnCerrarModalCIEX").trigger("click");
	$('#idTablaDetalleApoyo').empty();  
	$('#idTablaDetalleApoyo').html(htmlTabla);
	    
	
}
 
function llenarDxIndex(index){
	var contextPath = $('#contextPath').val();
	var htmlTabla = "";
	var item = 0; 
	var valida ="0";
	 console.log("index" + index);
	  $.ajax({
		    type: "GET",
		    // data: "entidad=" + entidad,
		   	
		    url: contextPath+"/referenciaController/refrescarListaCIEXREF?index="+index,
		    	success: function(data){ 
		    	if(data!=null){  
		    		for (var i = 0; i < listadoCIEX.length; i++) {
		    			var objCIEX = listadoCIEX[i]; 
		    			if(objCIEX.codReg == data.codReg){ 
		    				valida = "1";
		    			}
		    		} 
		    		if(valida == "1"){
		    			 msg_advertencia("El diagnóstico ya fue ingresado.");
		    		}else{ 
			    		listadoCIEX.push(data);
			    		// console.log("listadoCIEX " + listadoCIEX);
			    		// console.log("listadoCIEX " + listadoCIEX.length);
			    		for (var i = 0; i < listadoCIEX.length; i++) {
			    			var objCIEX = listadoCIEX[i];
			    			item = item + 1;
			    		htmlTabla += 
			    			"<tr>"+
			    				"<td>"+item +"</td>"+
			    				"<td>"+objCIEX.valor4 +"</td>"+ 
			    				"<td>"+objCIEX.nombreCorto+"</td>"+ 
			    				"<td><select"+
			    				" onchange=\"llenarTipoDX('"+objCIEX.valor4+"');\""+
			    				" name='cboTipoDX"+objCIEX.valor4.trim() + "' id='cboTipoDX"+objCIEX.valor4.trim() +"' class='form-control'>"+
			    			    "<option value=''>SELECCIONAR</option>"+
			    			    "<option value='000001' >PRESUNTIVO</option>"+
			    			    "<option value='000002' >DEFINITIVO</option>"+
			    			    "<option value='000003' >REPETIDO (CONTROL)</option>"+											  													    
			    			"</select></td>"+ 
				    			"<td>"+objCIEX.valor5+"</td>"+ 
				    			"<td>"+
					    			"<button type='button'"+
						    	 	" class='btn btn-outline-success btn-sm' "+
						    	 	" data-toggle='tooltip'  data-placement='top' "+
						    	 	"  onclick=\"especialidadCargarModal('"+[objCIEX.codReg]+"');\""+
						      	 	" data-original-title='Agregar'"+
						    	 	" id='agregarEspecialidad'>"+
						    	 	"<i class='fa fa-plus'></i>Agregar especialidad</button>  "+
						    	 	
						    	 	"<button type='button'"+
						    	 	" class='btn btn-outline-danger btn-sm' "+
						    	 	" data-toggle='tooltip'  data-placement='top'  title='Eliminar'"+
						    	 	"  onclick=\"confirmar_eliminar('"+[objCIEX.codReg]+"','2');\""+
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
				  	    
				  		for (var i = 0; i < listadoCIEX.length; i++) {
				  			var objCIEX = listadoCIEX[i]; 
				  				$("#cboTipoDX"+objCIEX.valor4.trim()).val(objCIEX.valor7);
				  			 
				  		}
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


function R(index){
	var contextPath = $('#contextPath').val();
	var htmlTabla = "";
	var item = 0; 
	console.log("index" + index);
	  $.ajax({
		    type: "GET",
		    // data: "entidad=" + entidad,
		   	
		    url: contextPath+"/referenciaController/refrescarListCIEX",
		    	success: function(data){ 
		    	if(data!=null){  
			    		
			    		listadoCIEX.push(data);
			    		// console.log("listadoCIEX " + listadoCIEX);
			    		// console.log("listadoCIEX " + listadoCIEX.length);
			    		for (var i = 0; i < listadoCIEX.length; i++) {
			    			var objCIEX = listadoCIEX[i];
			    			item = item + 1;
			    		htmlTabla += 
			    			"<tr>"+
			    				"<td>"+item +"</td>"+
			    				"<td>"+objCIEX.valor4 +"</td>"+ 
				    			"<td>"+objCIEX.nombreCorto+"</td>"+ 
				    			"<td>"+
						    	 	"<button type='button'"+
						    	 	" class='btn btn-outline-danger btn-sm' "+
						    	 	" data-toggle='tooltip'  data-placement='top'  title='Eliminar'"+
						    	 	"  onclick=\"confirmar_eliminar('"+[objCIEX.codReg]+"','2');\""+
						      	 	" data-original-title='Eliminar'"+
						    	 	" id='agregarEspecialidad'>"+
						    	 	"<i class='icon-trash'></i></button>"+
						    		"</td>"+
			    		"</tr>";
			    		
			    	
			    		} 
			    // console.log(htmlTabla);
		    	}
		    	$("#idBtnCerrarModalCIEX").trigger("click");
		    	$('#idbodyCIEXref').empty();  
		  	    $('#idbodyCIEXref').html(htmlTabla);
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

function llenarTablaCIE10(){
	var contextPath = $('#contextPath').val();
	var htmlTabla = "";
	var item = 0;  
	console.log("llenarTablaCIE10 ");
	  $.ajax({
		    type: "GET",
		    // data: "entidad=" + entidad,
		   	
		    url: contextPath+"/referenciaController/refrescarListaCIE10",
		    	success: function(data){ 
		     if(data!=null){   
		    	 htmlTabla += 
		    		"<c:forEach var='ciex' items= '${lstCIEX}' varStatus='loop'>"+
		    		 "<tr>"+
	    				"<td>${loop.count}</td>"+
	    				"<td>${ciex.valor4}</td>"+ 
		    			"<td>${ciex.nombreCorto}</td>"+ 
		    			"<td>"+
			    	 	"<button type='button'"+
			    	 	" class='btn btn-outline-success btn-sm' "+
			    	 	" data-toggle='tooltip'  data-placement='top'  title='Seleccionar'"+
			    	 	"  onclick=llenarDxIndex('${loop.index}');"+
			      	 	" data-original-title='Eliminar'"+
			    	 	" id='agregarEspecialidad'>"+
			    	 	"<i class='icon-check'></i></button>"+
			    		"</td>"+
    		"</tr>" +
				"</c:forEach>";
			    	/**
					 * for (var i = 0; i < data.length; i++) { var objCIEX =
					 * data[i]; item = item + 1; htmlTabla += "
					 * <tr>"+ "
					 * <td>"+item +"</td>"+ "
					 * <td>"+objCIEX.valor4 +"</td>"+ "
					 * <td>"+objCIEX.nombreCorto+"</td>"+ "
					 * <td>"+ "<button type='button'"+ " class='btn
					 * btn-outline-success btn-sm' "+ " data-toggle='tooltip'
					 * data-placement='top' title='Seleccionar'"+ "
					 * onclick=llenarDxIndex("+[listadoCIEX.index]+");"+ "
					 * data-original-title='Eliminar'"+ "
					 * id='agregarEspecialidad'>"+ "<i class='icon-check'></i></button>"+ "</td>"+ "</tr>"; }
					 */
			    	console.log(htmlTabla); 
		    	} 
		    	$('#idBodyListaCIEX').empty();  
		  	    $('#idBodyListaCIEX').html(htmlTabla); 
		         
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

function agregarApoyoBD(index){
	var contextPath = $('#contextPath').val();
	var htmlTabla = "";
	var item = 0; 
	console.log("index" + index);
	  $.ajax({
		    type: "GET",
		    // data: "entidad=" + entidad,
		   	
		    url: contextPath+"/referenciaController/refrescarListaApoyoDX?index="+index,
		    	success: function(data){ 
		    	if(data!=null){  
			    		
		    		listadoApoyoDXRealizado.push(data);
	    		// console.log("listadoCIEX " + listadoApoyoDXRealizado);
	    		// console.log("listadoCIEX " + listadoApoyoDXRealizado.length);
	    		for (var i = 0; i < listadoApoyoDXRealizado.length; i++) {
	    			var objApoyoDX = listadoApoyoDXRealizado[i];
	    			item = item + 1;
		    		htmlTabla += 
		    			"<tr>"+
		    				"<td>"+item +"</td>"+
		    				"<td>"+objApoyoDX.valor1 +"</td>"+ 
			    			"<td>"+objApoyoDX.nombreCorto+"</td>"+ 
			    			"<td>"+
					    	 	"<button type='button'"+
					    	 	" class='btn btn-outline-danger btn-sm' "+
					    	 	" data-toggle='tooltip'  data-placement='top'  title='Eliminar'"+
					    	 	"  onclick=confirmar_eliminar("+[objApoyoDX.codReg]+");"+
					      	 	" data-original-title='Eliminar'"+
					    	 	" id='agregarEspecialidad'>"+
					    	 	"<i class='icon-trash'></i></button>"+
					    		"</td>"+
					     "</tr>"; 
	    		} 
			    // console.log(htmlTabla);
		    	}
		    	// $("#idBtnCerrarModalCIEX").trigger("click");
		    	$('#idTablaDetalleDocumentoApoyo').empty();  
		  	    $('#idTablaDetalleDocumentoApoyo').html(htmlTabla);
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


function agregarApoyo(){
	var contextPath = $('#contextPath').val();
	var htmlTabla = "";
	var item = 0; 
	var txtNombreApoyo = $('#txtNombreApoyo').val();
	var codRegApoyoREF = $('#codRegApoyoREF').val();
	var categoriaApoyo = $('#categoriaApoyo').val();
	var codCategoria = $('#codCategoria').val();
	var valida = "0";
	
	if (txtNombreApoyo =="") {
		 msg_advertencia("Seleccione Apoyo al Diagnóstico."); 
		 return;
	}else{
		for (var i = 0; i < listadoApoyosDX.length; i++) {
			console.log(listadoApoyosDX.length);
			console.log(listadoApoyosDX[i]); 
			var obj = listadoApoyosDX[i]// .indexOf("/") ;
			// var codigoReg = listadoApoyosDX[i].substr(0,ind);
			console.log("codigoReg " + obj.codReg);
			if (obj.codReg == codRegApoyoREF) {
				 msg_advertencia("El Apoyo al Diagnóstico ya fue ingresado."); 
				 valida = "1";
				return;
			}
		}
		if ( valida = "0") {
			
			// listadoApoyosDX.push(codRegApoyoREF+"/"+codCategoria);
			  $.ajax({
				    type: "GET",
				    // data: "entidad=" + entidad,
				   	
				    url: contextPath+"/referenciaController/refrescarListaApoyoDX?codReg="+codRegApoyoREF,
				    	success: function(data){ 
				    	if(data!=null){  
					    	 listadoApoyosDX.push(data);
			    		// console.log("listadoApoyosDX " + listadoApoyosDX);
			    		// console.log("listadoApoyosDX.length " +
						// listadoApoyosDX.length);
			    		for (var i = 0; i < listadoApoyosDX.length; i++) {
			    			var objApoyoDX = listadoApoyosDX[i];
			    			item = item + 1;
				    		htmlTabla += 
				    			"<tr>"+
				    				"<td>"+item +"</td>"+
				    				"<td>"+objApoyoDX.valor1 +"</td>"+ 
					    			"<td>"+objApoyoDX.nombreCorto+"</td>"+ 
					    			"<td>"+
							    	 	"<button type='button'"+
							    	 	" class='btn btn-outline-danger btn-sm' "+
							    	 	" data-toggle='tooltip'  data-placement='top'  title='Eliminar'"+
							    	 	"  onclick=\"confirmar_eliminar('"+[objApoyoDX.codReg]+"','3');\""+
							      	 	" data-original-title='Eliminar'"+
							    	 	" id='agregarEspecialidad'>"+
							    	 	"<i class='icon-trash'></i></button>"+
							    		"</td>"+
							     "</tr>"; 
			    		} 
					    // console.log(htmlTabla);
				    	}
				    	// $("#idBtnCerrarModalCIEX").trigger("click");
				    	$('#idTablaDetalleApoyo').empty();  
				  	    $('#idTablaDetalleApoyo').html(htmlTabla);
				  	    $('#txtNombreApoyo').val("");
					  	$('#codRegApoyoREF').val("");
					  	$('#categoriaApoyo').val("");
					  	$('#codCategoria').val("");
					  	$('#comboTipoApoyoREFapoyo').val("");
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
	
	}	
	
	
}

function enviarListado() {
	var contextPath = $('#contextPath').val(); 
	$
			.ajax({
				url : contextPath+"/referenciaController/listado",
				type : 'GET',

				success : function(data) {
					// console.log("SUCCESS: ", data);
					msg_exito("Éxito al realizar proceso");  
				},
				error : function(xhr, status, er) {
					// msg_error();
					console.log("error: " + xhr + " status: " + status + " er:" + er);
				}
			});

}


function cargarReporteReferencia() {
	
	var contextPath = $('#contextPath').val(); 
	$
			.ajax({
				url : contextPath+"/referenciaController/rptReferencia",
				type : 'GET',

				success : function(data) {
				 console.log("SUCCESS: ", data);
				// msg_exito("Éxito al registrar Referencia");
				},
				error : function(xhr, status, er) {
					// msg_error();
					console.log("error: " + xhr + " status: " + status + " er:" + er);
				}
			});

}

function cargarApoyoReferencia() {
	// debugger;
	var contextPath = $('#contextPath').val();
	var htmlTabla = "";
	var item = 0; 
	 
	
	var codRegApoyo = $('#codRegApoyoDXrealizadoREF').val();
	var nombreApoyo = $('#nombreApoyoRealizado').val();
	var codRegTipoApoyo = $('#codCategoriaRealizado').val();
	var nombreTipoApoyo = $('#categoriaApoyoRealizado').val();
	
	
	var inputFileImage 	= document.getElementById('files');
	var files 			= inputFileImage.files[0];  
	
	if (nombreApoyo =="") {
		 msg_advertencia("Seleccione Apoyo al Diagnóstico."); 
		 return;
	}else{
	var data 			= new FormData();
	
	data.append('codRegApoyo',	codRegApoyo);
	data.append('nombreApoyo',	nombreApoyo);
	data.append('codRegTipoApoyo',	codRegTipoApoyo);
	data.append('nombreTipoApoyo',	nombreTipoApoyo);
	
	 if(files!=undefined){  
	 	data.append('files', files); 
	 	 var url = contextPath + "/referenciaController/listarReferenciaApoyoDxResultadoBeanImage";
	}else{
		 var url = contextPath + "/referenciaController/listarReferenciaApoyoDxResultadoBean";
	}  
	// alert("nombreTipoApoyo " + nombreTipoApoyo);
	
	
	 $.ajax({   
		url : url, 
		type : "POST",
		contentType:false,
		data : data,
   		processData:false,
   		cache:false,
		success : function(data) {
		// console.log("SUCCESS: ", data);
			// debugger;
			if (data != null) {
				if(data.length>0) {
				for (var i = 0; i < data.length; i++) {
	    			var objApoyoDX = data[i]; 
	    			item = item + 1;
	    			if(objApoyoDX.nombreDocumentoResultado ==""){
	    				htmlTabla += 
			    			"<tr>"+
			    				"<td>"+item +"</td>"+
			    				"<td>"+objApoyoDX.tipoApoyo.nombreCorto +"</td>"+ 
				    			"<td>"+objApoyoDX.apoyoDX.nombreCorto+"</td>"+ 
				    			"<td>"+objApoyoDX.nombreDocumentoResultado+"</td>"+ 
				    			"<td> </td>"+
				    			"<td>"+
						    	 	"<button type='button'"+
						    	 	" class='btn btn-outline-danger btn-sm' "+
						    	 	" data-toggle='tooltip'  data-placement='top'  title='Eliminar'"+
						    	 	" onclick=\"confirmar_eliminar('"+[objApoyoDX.apoyoDX.codReg]+"',1);\""+
						      	 	" data-original-title='Eliminar'"+
						    	 	" id='agregarEspecialidad'>"+
						    	 	"<i class='icon-trash'></i></button>"+
						    		"</td>"+
						     "</tr>"; 
	    			}else{
	    				htmlTabla += 
			    			"<tr>"+
			    				"<td>"+item +"</td>"+
			    				"<td>"+objApoyoDX.tipoApoyo.nombreCorto +"</td>"+ 
				    			"<td>"+objApoyoDX.apoyoDX.nombreCorto+"</td>"+ 
				    			"<td>"+objApoyoDX.nombreDocumentoResultado+"</td>"+ 
				    			"<td><a title='Descargar' data-placement='top' data-toggle='tooltip' target='_Blank'"+ 
				    			" href='"+contextPath+"/resultados/"+objApoyoDX.apoyoDX.codReg +"_"+objApoyoDX.nombreDocumentoResultado+"'"+ 
				    			" download='"+contextPath+"/resultados/"+objApoyoDX.apoyoDX.codReg+"_"+objApoyoDX.nombreDocumentoResultado+"'"+
				    			" <i class='fa fa-download'></i> Descargar</a> </td>"+
				    			"<td>"+
						    	 	"<button type='button'"+
						    	 	" class='btn btn-outline-danger btn-sm' "+
						    	 	" data-toggle='tooltip'  data-placement='top'  title='Eliminar'"+
						    	 	"  onclick=\"confirmar_eliminar('"+[objApoyoDX.apoyoDX.codReg]+"',1);\""+
						      	 	" data-original-title='Eliminar'"+
						    	 	" id='agregarEspecialidad'>"+
						    	 	"<i class='icon-trash'></i></button>"+
						    		"</td>"+
						     "</tr>"; 
	    			}
		    	
				} 
			
				}else{
					 msg_advertencia("El Apoyo al Diagnóstico ya fue ingresado."); 
					 return;
				}
			}
			$('#idTablaDetalleDocumentoApoyo').empty();
			$('#idTablaDetalleDocumentoApoyo').html(htmlTabla);
		    $('#codRegApoyoDXrealizadoREF').val("");
		  	$('#nombreApoyoRealizado').val("");
		  	$('#codCategoriaRealizado').val("");
		  	$('#categoriaApoyoRealizado').val("");
			$('#files').val("");
		  	$('#comboTipoApoyo').val("");
		   },error : function(xhr, status, er) {
			console.log("error: " + xhr + " status: " + status + " er:" + er);
			if (xhr.status == 500) {
				console.log(er);
				// Error_500(er);
			}
			if (xhr.status == 901) {
				console.log(er);
				// spire_session_901(er);
			}
		}, 
	  });
	}
}


function elimarApoyoReferencia(codigo) {
	// debugger;
	var contextPath = $('#contextPath').val();
	var url = contextPath + "/referenciaController/eliminarApoyoDxResultadoBean?codRegApoyo="+codigo;
	var item = 0;     
	var htmlTabla = "";
	
	 $.ajax({   
		url : url, 
		type : "POST",
		contentType:false, 
   		processData:false,
   		cache:false,
		success : function(data) {
		// console.log("SUCCESS: ", data);
			// debugger;
			if (data != null) {
				if(data.length>0) {
				for (var i = 0; i < data.length; i++) {
	    			var objApoyoDX = data[i]; 
	    			item = item + 1;
	    			if(objApoyoDX.nombreDocumentoResultado ==""){
	    				htmlTabla += 
			    			"<tr>"+
			    				"<td>"+item +"</td>"+
			    				"<td>"+objApoyoDX.tipoApoyo.nombreCorto +"</td>"+ 
				    			"<td>"+objApoyoDX.apoyoDX.nombreCorto+"</td>"+ 
				    			"<td>"+objApoyoDX.nombreDocumentoResultado+"</td>"+ 
				    			"<td> </td>"+
				    			"<td>"+
						    	 	"<button type='button'"+
						    	 	" class='btn btn-outline-danger btn-sm' "+
						    	 	" data-toggle='tooltip'  data-placement='top'  title='Eliminar'"+
						    	 	"  onclick=\"confirmar_eliminar('"+[objApoyoDX.apoyoDX.codReg]+"',1);\""+
						      	 	" data-original-title='Eliminar'"+
						    	 	" id='agregarEspecialidad'>"+
						    	 	"<i class='icon-trash'></i></button>"+
						    		"</td>"+
						     "</tr>"; 
	    			}else{
	    				htmlTabla += 
			    			"<tr>"+
			    				"<td>"+item +"</td>"+
			    				"<td>"+objApoyoDX.tipoApoyo.nombreCorto +"</td>"+ 
				    			"<td>"+objApoyoDX.apoyoDX.nombreCorto+"</td>"+ 
				    			"<td>"+objApoyoDX.nombreDocumentoResultado+"</td>"+ 
				    			"<td><a title='Descargar' data-placement='top' data-toggle='tooltip' target='_Blank'"+ 
				    			" href='"+contextPath+"/resultados/"+objApoyoDX.apoyoDX.codReg +"_"+objApoyoDX.nombreDocumentoResultado+"'"+ 
				    			" download='"+contextPath+"/resultados/"+objApoyoDX.apoyoDX.codReg+"_"+objApoyoDX.nombreDocumentoResultado+"'"+
				    			" <i class='fa fa-download'></i> Descargar</a> </td>"+
				    			"<td>"+
						    	 	"<button type='button'"+
						    	 	" class='btn btn-outline-danger btn-sm' "+
						    	 	" data-toggle='tooltip'  data-placement='top'  title='Eliminar'"+
						    	 	"  onclick=\"confirmar_eliminar('"+[objApoyoDX.apoyoDX.codReg]+"',1);\""+
						      	 	" data-original-title='Eliminar'"+
						    	 	" id='agregarEspecialidad'>"+
						    	 	"<i class='icon-trash'></i></button>"+
						    		"</td>"+
						     "</tr>"; 
	    			 } 
				   } 
				  }
				}
			$('#idTablaDetalleDocumentoApoyo').empty();
			$('#idTablaDetalleDocumentoApoyo').html(htmlTabla);
		    $('#codRegApoyoDXrealizadoREF').val("");
		  	$('#nombreApoyoRealizado').val("");
		  	$('#codCategoriaRealizado').val("");
		  	$('#categoriaApoyoRealizado').val("");
			$('#files').val("");
		  	$('#comboTipoApoyo').val("");
		   },error : function(xhr, status, er) {
			console.log("error: " + xhr + " status: " + status + " er:" + er);
			if (xhr.status == 500) {
				console.log(er);
				// Error_500(er);
			}
			if (xhr.status == 901) {
				console.log(er);
				// spire_session_901(er);
			}
		}, 
	  }); 
}

function descartar(){
	// debugger;
	var htmlTabla = "";
	var item = 0; 
	var myFormulario = $('#frmDescartarReferencia');  
	
	var contextPath = $('#contextPath').val();
	if(!myFormulario[0].checkValidity()) {
		 msg_advertencia("Debe completar los campos requeridos(*) correctamente");
		 
	}else{
		var url = contextPath + "/referenciaController/descartar";
	// iniciarBloqueo();
		$.ajax({
		type : "GET",
		url : url,
		data: $('#frmDescartarReferencia').serialize(),
		success : function(data) {
			   // console.log("SUCCESS: ", data);
			    if (data =! null) {
			    	 msg_exito("Éxito al realizar proceso");
			    	 $("#idBtnCerrarDescartar").trigger("click"); 
			    	 $("#btnListado").trigger("click");
			    	/**
					 * * for (var i = 0; i < data.length; i++) { var referencia =
					 * data[i]; item = item + 1; htmlTabla += "
					 * <tr>"+ "
					 * <td>"+item +"</td>"+ "
					 * <td>"+referencia.paciente.persona.nombreCompleto +"</td>"+ "
					 * <td>"+referencia.tipoSeguro.nombreCorto+"</td>"+ "
					 * <td>"+objApoyoDX.nombreDocumentoResultado+"</td>"+ "
					 * <td fmt:formatDate pattern='dd/MM/yyyy'>"+referencia.fechaIngresoRef+ "</td>"+ "
					 * <td>"+referencia.establecimientoOrige.nomRenaes+"</td>"+ "
					 * <td>"+referencia.servicioUPSReferencia.nombreCorto+"</td>"+ "<c:choose>"+ "<c:when"+
					 * "test='${"+referencia.servicioUPSReferencia.codReg+" ==
					 * '000001'}"+ "
					 * <td>"+ "<button type='button'"+ " class='btn
					 * btn-outline-danger btn-sm' "+ " data-toggle='tooltip'
					 * data-placement='top' title='Eliminar'"+ "
					 * onclick=\"confirmar_eliminar('"+[objApoyoDX.apoyoDX.codReg]+"',1);\""+ "
					 * data-original-title='Eliminar'"+ "
					 * id='agregarEspecialidad'>"+ "<i class='icon-trash'></i></button>"+ "</td>"+ "</tr>"; }
					 * $('#idBodyListaReferencia').empty();
					 * $('#idBodyListaReferencia').html(htmlTabla);
					 */
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
	
/*
 * $.ajax({ url : url, type : "POST", contentType:false, processData:false,
 * cache:false, data: $('#frmDescartarReferencia').serialize(), success :
 * function(data) { // console.log("SUCCESS: ", data); // debugger; if (data !=
 * null) { if(data.length>0) { for (var i = 0; i < data.length; i++) { var
 * objApoyoDX = data[i]; item = item + 1; htmlTabla += "<tr>"+ "<td>"+item +"</td>"+ "<td>"+objApoyoDX.tipoApoyo.nombreCorto +"</td>"+ "<td>"+objApoyoDX.apoyoDX.nombreCorto+"</td>"+ "<td>"+objApoyoDX.nombreDocumentoResultado+"</td>"+ "<td><a
 * title='Descargar' data-placement='top' data-toggle='tooltip'
 * target='_Blank'"+ "
 * href='"+contextPath+"/resultados/"+objApoyoDX.apoyoDX.codReg
 * +"_"+objApoyoDX.nombreDocumentoResultado+"'"+ "
 * download='"+contextPath+"/resultados/"+objApoyoDX.apoyoDX.codReg+"_"+objApoyoDX.nombreDocumentoResultado+"'"+ "
 * <i class='fa fa-download'></i> Descargar</a> </td>"+ "<td>"+ "<button
 * type='button'"+ " class='btn btn-outline-danger btn-sm' "+ "
 * data-toggle='tooltip' data-placement='top' title='Eliminar'"+ "
 * onclick=\"confirmar_eliminar('"+[objApoyoDX.apoyoDX.codReg]+"',1);\""+ "
 * data-original-title='Eliminar'"+ " id='agregarEspecialidad'>"+ "<i
 * class='icon-trash'></i></button>"+ "</td>"+ "</tr>"; } } }
 * $('#idTablaDetalleDocumentoApoyo').empty();
 * $('#idTablaDetalleDocumentoApoyo').html(htmlTabla); },error : function(xhr,
 * status, er) { console.log("error: " + xhr + " status: " + status + " er:" +
 * er); if (xhr.status == 500) { console.log(er); // Error_500(er); } if
 * (xhr.status == 901) { console.log(er); // spire_session_901(er); } }, });
 */
}

function grabarReferencia(){  
	var cie10 = [];
	var apoyoDx = []; 
	var comboUPS = $('#comboUPS').val();
	var nombreEspecialidadREF = $('#nombreEspecialidadREF').val();
	var personaApellidoPaternoREF = $('#personaApellidoPaternoREF').val();
	var idEstablecimientoDestino = $('#idEstablecimientoDestino').val();
	var nroCelularPaciente = $('#nroCelularPaciente').val();
// console.log("nombreCompletoPacienteREF " +nombreCompletoPacienteREF);
	
	for (var i = 0; i < listadoCIEX.length; i++) {
		var objCIEX = listadoCIEX[i];
		
		/*
		 * var objAcceso = { codReg : objCIEX.codReg, valor6 : objCIEX.valor6 };
		 */
		cie10.push(objCIEX.codReg+"/"+objCIEX.valor6+"-"+objCIEX.valor7);
		 // console.log("objCIEX.codReg " + objCIEX.codReg);
		 // console.log("objCIEX.valor6 " + objCIEX.valor6);
	}
	for (var i = 0; i < listadoApoyosDX.length; i++) {
		var objApoyoDX = listadoApoyosDX[i];
		apoyoDx.push(objApoyoDX.codReg+"/"+objApoyoDX.valor2);
		// console.log(objApoyoDX.codReg+"/"+objApoyoDX.valor2);
	}
		var contextPath = $('#contextPath').val(); 
		var actionForm = $('#frmRegistroReferencia').attr("action");
		var url =contextPath+"/referenciaController/grabarReferencia?cie10="+ cie10 
						+ "&apoyoDx=" + apoyoDx ;
		var myFormulario = $('#frmRegistroReferencia'); 
		// console.log("actionForm " + actionForm);
		
		if(!myFormulario[0].checkValidity()) {
			 msg_advertencia("Debe completar los campos requeridos(*) correctamente");

		}else{
			if(comboUPS == "000002"){
				if (listadoApoyosDX.length == 0) {
					 msg_advertencia("Ingrese al menos un Apoyo al Diagnóstico a la lista.");
					 return;
				}
			}
			if(listadoCIEX.length == 0){
				msg_advertencia("Ingrese al menos un Diagnóstico CIE10.");
				return;
			
			
			}else{
				for (var i = 0; i < listadoCIEX.length; i++) {
					var objCIEX = listadoCIEX[i];
					 if(objCIEX.valor7 ==""){
						 msg_advertencia("Seleccione tipo de diagnóstico.");
							return; 
					 } 
				}
			}
			if (comboUPS == "000001") {
				for (var i = 0; i < listadoCIEX.length; i++) {
					var objCIEX = listadoCIEX[i];
					 if(objCIEX.valor6 ==""){
						 msg_advertencia("Ingrese la especialidad asociada al diagnóstico.");
							return; 
					 } 
				}
			}
			 
			
			if (personaApellidoPaternoREF =="") {
				msg_advertencia("Ingrese paciente que será referenciado.");
				$("#idBtnCargarPaciente").trigger("click");
				return;
				
			}
			if (idEstablecimientoDestino =="") {
				msg_advertencia("Ingrese establecimiento de destino."); 
				return;
				
			}
			if (nroCelularPaciente.length < 9) {
				msg_advertencia("Ingrese un número de celular válido."); 
				return;
				
			}
				iniciarBloqueo();
				$.ajax({
				type : "POST",
				url : url, 
				data: $('#frmRegistroReferencia').serialize(),
				success : function(data) {
					   // console.log("SUCCESS: ", data);
					    if (data == "") {
					    	msg_error("Error al registrar Referencia");  
						}else{
						    msg_exito("Éxito al registrar Referencia");  
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


function validar(){
// debugger;
	var fechaDesde = $('#strfechaIngresoRef').val();
	var fechaHasta = $('#fechaHastaReferencia').val();
	
	console.log("fechaDesde " + fechaDesde);
	console.log("fechaHasta " + fechaHasta);
	
	if(fechaDesde != ""){
		if(fechaDesde.length < 10){
			msg_advertencia("Ingrese fecha desde correcta.");
			return false;
		}
	} else if(fechaHasta != ""){
		if(fechaHasta.length < 10){
			msg_advertencia("Ingrese fecha hasta correcta.");
			return false;
		}
	}else{
		return true;
	}
	 
};

function llenarTipoDX(codCIEX){
// console.log("llenarTipoDX "+ codCIEX.trim());
	
// console.log("cboTipoDX "+ $("#cboTipoDX"+codCIEX.trim()).val());
	var codTipoDX = $("#cboTipoDX"+codCIEX.trim()).val();
	for (var i = 0; i < listadoCIEX.length; i++) {
		var objCIEX = listadoCIEX[i]; 
		if(objCIEX.valor4 == codCIEX){ 
			objCIEX.valor7 =codTipoDX; 
		}
	}
	
}


function mensaje(){
	msg_exito();
}


