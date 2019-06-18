var tipo = "";
var codReg = ""; 
function confirmar_accion(codigo) {  
	tipo = "0";
	codReg = codigo;
	$('#md_confirmacion').modal('show');

}

function confirmar_eliminar(index,codigo) { 
	tipo = index
	codReg = codigo;
	$('#md_confirmacion').modal('show');
	console.log("tipo " + tipo);
	console.log("codReg " + codReg);
}

$(document).ready(function() {
	$("#btnConfirmarGeneric").click(function() {
		if(tipo == "0"){
			eliminarRegistro(codReg);
		}else if(tipo == "1"){
			eliminarRegistroDetalle(codReg);
			 $("#anterior" + codReg).remove();
		}else{ 
			console.log("codReg " + codReg);
			 $("#nuevo" + codReg).remove();
			 $('#md_confirmacion').modal('hide');
		}
		
	});
});

 
function eliminarRegistroDetalle(codReg) { 
	var contextPath = $('#contextPath').val();
	$
			.ajax({
				url :  contextPath+"/tarifarioController/eliminarDetalle?index="
						+ codReg,
				type : 'GET',
				success : function(data) {
					$('#md_confirmacion').modal('hide');
					msg_exito();
					refrescarListadoTarifario();
					},
				error : function(request, status, error) {
					alert(error);
				}
			});

};


function eliminarRegistro(codReg) { 
	var contextPath = $('#contextPath').val();
	$
			.ajax({
				url :  contextPath+"/tarifarioController/eliminar?index="
						+ codReg,
				type : 'GET',
				success : function(data) {
					$('#md_confirmacion').modal('hide');
					msg_exito();
					refrescarListadoTarifario();
					},
				error : function(request, status, error) {
					alert(error);
				}
			});

};


function refrescarListadoTarifario() {
	var contextPath = $('#contextPath').val();
	$.ajax({
		url : contextPath + "/tarifarioController/listarTarifario",
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

function refrescarListado() {
	var contextPath = $('#contextPath').val();
	var item = 0; 
	var htmlTabla = "";
	$
			.ajax({
				url :  contextPath+"/tarifarioController/refrescarLista",
				type : 'GET',
				data: $('#frmListadoTarifario').serialize(),
				success : function(data) {
					if (data != null) {

						for (var i = 0; i < data.length; i++) {
							var objeto = data[i];
							item = item + 1;
							htmlTabla += "<tr>" + "<td>"
									+ item
									+ "</td>"
									+ "<td>"
									+ objeto.descripcion
									+ "</td>"
									+ "<td>"
									+ objeto.tipo.nombreCorto
									+ "</td>"
									+ "<td>"
									+ objeto.subtipo
									+ "</td>"
									+ "<td>"
									+ objeto.sPrecio
									+ "</td>"
									+ "<td>"
									+ "<a title='Modificar' data-placement='top'"
									+ "data-toggle='tooltip' class='btn btn-outline-success btn-sm'"
									+ "onclick=\"javascript:modificarElementoGenerico('/tarifarioController/modificar','"+ [item] + "'');\"'"
									+ "href='#'><i class='icon-pencil'></i></a>"
									
									+ "<button type='button'"
									+ " class='btn btn-outline-danger btn-sm' "
									+ " data-toggle='tooltip'  data-placement='top'  title='Eliminar'"
									+ " onclick=\"confirmar_accion('"+ item + "');\""
									+ " data-original-title='Eliminar'"
									+ " id='eliminarReferencia'"
									+ [ objeto.codigo] + ">"
									+ "<i class='icon-trash'></i></button>"
									+ "</td>" + "</tr>";

						}
						// console.log(htmlTabla);
					}
					// console.log("SUCCESS: ", data);
					$('#idBodyListaCIEX').empty();
					$('#idBodyListaCIEX').html(htmlTabla);
				},
				error : function() {
					console.log("ERROR: ");
				}
			});
}


function cargarRegistroTarifarioModal() {
	var contextPath = $('#contextPath').val();
	// var codigoLengua = $('#codigoLengua').val(); //
	// document.getElementById("codigoLengua").value;

	path = contextPath + "/laboratorioController/tarifarioRegModal";
	// alert("path " + path)
		$.ajax({
			type : "POST",
			url : path,

			success : function(data) {
				// console.log("SUCCESS: ", data);
				$("#modalTarifario").html(data);
				$("#modalTarifario").modal('show'); 
			},
			error : function(request, status, error) {
				console.log("ERROR: " + error);
			}
		}); 
}

function obtenerID(){
	
	 $("#tabla tbody tr").each(function (index) 
			    { 
		 console.log( $(this).attr("id"));
		 console.log($("#tabla tbody tr").attr("id"));
			    })
	
}

function grabarTarifario(){    
		var contextPath = $('#contextPath').val(); 
		var actionForm = $('#frmGuardarTarifario').attr("action");
		console.log("codigo  :: " + codigo) ; 
		var myFormulario = $('#frmGuardarTarifario');  
		var arrayMenus = [];
			
			/** RECORRER MENU **/
		    $("#tabla tbody tr").each(function (index) 
		    {	console.log($("#tabla tbody tr").attr("id"));
		    console.log("index " + index);
		    var x = index+1;  
		    	if ($(this).attr("id") == "nuevo"+x) {
		    		
		    		console.log("ingresa:: " + x);
			    	var valoresRefIni,valoresRefFin,unidades,observacion,id;
			    	
			    	var objComponente = {
				  		codigo : 0	
				  	};
				    	
			    	var objAcceso = {
			    			item 		: 0,
			    			codigo		: "",
			    			unidades : "",
			    			valoresRefIni 	: "",
			    			valoresRefFin 	: "",
			    			observacion 	: ""
			    	  	};
			    	
			        $(this).children("td").each(function (index2) 
			        { 
			        	if(index2 == 0 ){ // Columna Asignado
			        		input    = $(this).children("input");
			        		unidades = $(input).val();
			  	   			idCompo  = $(input).attr("id"); 
			      	   		
			          	  	objAcceso.item 			= index+1;
			          	  	objAcceso.codigo 		= id;
			          	  	objAcceso.unidades	= unidades; 
			        	}
			        	if(index2 == 1 ){ // Columna Asignado
			        		input    = $(this).children("input");
			        		observacion = $(input).val();
			  	   			idCompo  = $(input).attr("id"); 
			      	   		
			          	  	objAcceso.item 			= index+1;
			          	  	objAcceso.codigo 		= id;
			          	  	objAcceso.observacion	= observacion; 
			        	}
			        	if(index2 == 2 ){ // Columna Asignado
			        		input    = $(this).children("input");
			        		valoresRefIni = $(input).val();
			  	   			idCompo  = $(input).attr("id"); 
			      	   		
			          	  	objAcceso.item 			= index+1;
			          	  	objAcceso.codigo 		= id;
			          	  	objAcceso.valoresRefIni	= valoresRefIni; 
			        	}
			        	if(index2 == 3 ){ // Columna Asignado
			        		input    = $(this).children("input");
			        		valoresRefFin = $(input).val();
			  	   			idCompo  = $(input).attr("id"); 
			      	   		
			          	  	objAcceso.item 			= index+1;
			          	  	objAcceso.codigo 		= id;
			          	  	objAcceso.valoresRefFin	= valoresRefFin; 
			        	}
			        })
			        console.log( "objAcceso" + objAcceso);
			        arrayMenus.push(objAcceso);	
		    	} 
		    })
		    
		  //  console.log( "arrayMenus" + arrayMenus);
		    
		if(!myFormulario[0].checkValidity()) {
			 msg_advertencia("Debe completar los campos requeridos(*) correctamente");

		}else{ 
		/*	 if(arrayMenus.length == 0){
				msg_advertencia("Ingrese al menos un detalle de tarifario.");
				return;
			
			
			}   */
				iniciarBloqueo();
				$.ajax({
				type: "POST",  
				data: $('#frmGuardarTarifario').serialize(),
				url : contextPath+"/tarifarioController/grabarTarifario",  
		       
				success : function(data) {
					   // console.log("SUCCESS: ", data);
					    if (data == "") {
					    	msg_error("Error al registrar Tarifario");  
						}else{
							grabarTarifarioDetalle(arrayMenus);
						    msg_exito("Éxito al registrar Tarifario");  
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



function grabarTarifarioDetalle(arrayMenus){   
	//	var personaCodigo = $('#personaCodigo').val();   
		var contextPath = $('#contextPath').val(); 
		var actionForm = $('#frmGuardarTarifario').attr("action");
	 
	   
				iniciarBloqueo();
				$.ajax({
				type: "POST",
				contentType: "application/json", 
		        data: JSON.stringify(arrayMenus), 
				url : contextPath+"/tarifarioController/grabarTarifarioDetalle",  
		       
				success : function(data) {
					 
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


function llenarDetalleTarifario(){
	var codigo = $('#codigo').val();
	
	//debugger; 
	/***
	var cboTipoResultado = $('#cboTipoResultado').val();
	var contextPath = $('#contextPath').val();
	$.ajax({
		url : contextPath + "/tarifarioController/agregarDetalle",
		type : 'GET',
		data: $('#frmGuardarTarifario').serialize(),
		success : function(data) {
			//console.log("SUCCESS: ", data);
			$('#tblListaDetalle').html(data);
		},
		error : function() {
			//console.log("ERROR: ");
		}
	});
	*/
	
	var nuevaFila ="";
	var fila = $("#tabla tbody tr").length ;
	var nfila = Number(fila) + 1;
	            // añadimos las columnas

	            nuevaFila+="<tr id = 'nuevo"+nfila+"'>"+  
	            		"<td><input id='tarifarioUnidades' type='text' class='form-control' "+ 
	    										"value = '' required='required'></td>" +
	            		"<td><input id='tarifarioObservacion' type='text' class='form-control' "+ 
	    										"value = '' required='required'/></td>" +
	            		"<td><input id='tarifarioValorIni' type='text' class='form-control' "+ 
	    										"value = '' required='required'/></td>" +
	    				"<td><input id='tarifarioValorFin' type='text' class='form-control' "+ 
	    										"value = '' required='required'/></td>" +						
	    				"<td>"+ 
	    		    	 	"<button type='button'"+
	    		    	 	" class='btn btn-outline-danger btn-sm' "+
	    		    	 	" data-toggle='tooltip'  data-placement='top'  title='Eliminar'"+
	    		    	 	"  onclick=\"confirmar_eliminar(2,"+nfila+");\""+
	    		      	 	" data-original-title='Eliminar'"+
	    		    	 	" id='agregarEspecialidad'>"+
	    		    	 	"<i class='icon-trash'></i></button> "+ 
	    				"</td>"
	    		    	 	"</tr>"; 
	    $("#tabla tbody").append(nuevaFila);
	 
}


function modificarElementoGenerico(url, index){
	var contextPath = $('#contextPath').val();
	var urlComplete = contextPath + url;
	doPost(urlComplete, { index : index } );
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