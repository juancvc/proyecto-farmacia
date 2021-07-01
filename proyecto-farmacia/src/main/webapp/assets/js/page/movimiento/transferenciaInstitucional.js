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
			anularVenta(codigoRegistro);
		}else{
			console.log("eliminarArticulo :: " + codigoRegistro );
			eliminarArticulo(codigoRegistro);
		}
		
		$('#md_confirmacion').modal('hide');
	});
});

function llenarArticuloIndex(index) {
	
	var contextPath = $('#contextPath').val();
	var htmlTabla = "";
	var item = 0;
	var valida = "0";
	console.log("index:::" + index);
	$
			.ajax({
				type : "GET",
				// data: "entidad=" + entidad,

				url : contextPath
						+ "/movimientoAlmacenController/refrescarListaArticulosTransferencia?index="
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
										+ " required='required' autocomplete='off' "
										+ "value ='"
										+ objVentaItem.stock.lote
										+ "' onchange = 'calculaSubTotal(); ' "
										+ "maxlength='15'/>"
										+ "</td>"
										+ "<td><input type='text' class='form-control' "
										+ "id="
										+ [ objVentaItem.stock.articulo.codigo ]
										+ " required='required' onchange = 'calculaSubTotal(); ' "
										+ "placeholder='DD/MM/YYYY'"
										+ "maxlength='10'  autocomplete='off'"
										+ "value ='"
										+ objVentaItem.stock.sFechaVencimiento
										+ "' "
										+ "onkeyup='this.value=formateafecha(this.value);' />"
										+ "</td>"
										+ "<td><input type='text' class='form-control' "
										+ "id="
										+ [ objVentaItem.stock.articulo.codigo ]
										+ " required='required' onchange = 'calculaSubTotal(); ' "
										+ "value ='"
										+ objVentaItem.stock.nroRegistroSanitario
										+ "' "
										+ "maxlength='100'  autocomplete='off'/>"
										+ "</td>"
										+ "<td><input type='text' class='form-control' "
										+ "id="
										+ [ objVentaItem.stock.articulo.codigo ]
										+ " required='required' onkeypress= 'return decimales(event,this); '"
										+ "value ='"
										+ objVentaItem.stock.precioCompra
										+ "' "
										+ "onchange = 'calculaSubTotal(); ' "
										+ "maxlength='100'  autocomplete='off'/>"
										+ "</td>"
										+ "<td><input type='text' class='form-control' "
										+ "id="
										+ [ objVentaItem.stock.articulo.codigo ]
										+ " required='required' onchange = 'calculaSubTotal(); ' "
										+ "value ='"
										+ objVentaItem.stock.precioVenta
										+ "' onkeypress= 'return decimales(event,this); '"
										+ "maxlength='100' autocomplete='off'/>"
										+ "</td>"
										+ "<td> <input type='text' class='form-control' "
										+ "id="
										+ [ objVentaItem.stock.articulo.codigo ]
										+ " required='required' "
										+ "value ='"
										+ objVentaItem.cantidad
										+ "' "
										+ "maxlength='5' onkeypress= 'return soloNumeros(event); '"
										+ "onkeypress= 'return soloNumeros(event);'" 
										+ "onchange = 'calculaSubTotal(); '  /></td>"
										+ "<td>"
										+ "<label for='nombreCompleto' class='label_control' id="
										+ [ objVentaItem.stock.articulo.codigo ]
								        + " >" + objVentaItem.subtotal
										+ "</label>" 
										+ "</td>"
										+ "<td>"
										+ "<button type='button'"
										+ " class='btn btn-outline-danger btn-sm' "
										+ " data-toggle='tooltip'  data-placement='top'  title='Eliminar'"
										+ "  onclick=\"confirmar_eliminar('"
										+ [ objVentaItem.stock.articulo.codigo ]
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
        	if(index2 == 2 ){ // Columna lote
        		input    = $(this).children("input");
        		idAcceso = $(input).val();
  	   			idCompo  = $(input).attr("id");
				for (var i = 0; i < listadoArticulo.length; i++) {
					var objVentaItemN = listadoArticulo[i];
					if (objVentaItemN.stock.articulo.codigo == idCompo) {
						objVentaItemN.stock.lote =  $(input).val(); 
					}
				}
        	}
        	if(index2 == 3 ){ // Columna fechaVencimiento
        		input    = $(this).children("input");
        		idAcceso = $(input).val();
  	   			idCompo  = $(input).attr("id");
  	   			 
				for (var i = 0; i < listadoArticulo.length; i++) {
					var objVentaItemN = listadoArticulo[i];
					if (objVentaItemN.stock.articulo.codigo == idCompo) {
						objVentaItemN.stock.sFechaVencimiento =  $(input).val(); 
					}
				}
        	}
        	if(index2 == 4 ){ // Columna registroSanitario
        		input    = $(this).children("input");
        		idAcceso = $(input).val();
  	   			idCompo  = $(input).attr("id");
  	   			 
				for (var i = 0; i < listadoArticulo.length; i++) {
					var objVentaItemN = listadoArticulo[i];
					if (objVentaItemN.stock.articulo.codigo == idCompo) {
						objVentaItemN.stock.nroRegistroSanitario =  $(input).val(); 
					}
				} 
        	}
        	if(index2 == 5 ){ // Columna precio costo
        		input    = $(this).children("input");
        		idAcceso = $(input).val();
  	   			idCompo  = $(input).attr("id"); 
  	   			
				for (var i = 0; i < listadoArticulo.length; i++) {
					var objVentaItemN = listadoArticulo[i];
					if (objVentaItemN.stock.articulo.codigo == idCompo) {
						objVentaItemN.stock.precioCompra =  $(input).val(); 
					}
				}
        	}
        	if(index2 == 6 ){ // Columna precio venta
        		input    = $(this).children("input");
        		idAcceso = $(input).val();
  	   			idCompo  = $(input).attr("id");
  	   			
  	   			console.log("idCompo " + idCompo);
  	   			
				for (var i = 0; i < listadoArticulo.length; i++) {{
					var objVentaItemN = listadoArticulo[i];
					if (objVentaItemN.stock.articulo.codigo == idCompo) {
						if ($("#chkDonacion").is(":checked")) { 
							objVentaItemN.stock.precioVenta =  objVentaItemN.stock.precioCompra;  
						  } else { 
							objVentaItemN.stock.precioVenta =  objVentaItemN.stock.precioCompra * 1.25; 
						  } 
					}
					$(input).val(objVentaItemN.stock.precioVenta)
	  	   			
					//objVentaItemN.stock.precioVenta =  $(input).val(); 
					}
				}
        	}
        	if(index2 == 7 ){ // Columna cantidad
        		input    = $(this).children("input");
        		idAcceso = $(input).val();
  	   			idCompo  = $(input).attr("id"); 
  	   		    console.log("cantidad :::: "+ $(input).val());
  	   		    
				for (var i = 0; i < listadoArticulo.length; i++) {
					var objVentaItemN = listadoArticulo[i];
					if (objVentaItemN.stock.articulo.codigo == idCompo) {
						objVentaItemN.cantidad =  $(input).val(); 
						console.log("cantidad :: "+ $(input).val());
					}
				}
        	}
        	if(index2 == 8 ){ // Columna sub total
        		input    = $(this).children("label");
        		idAcceso = $(input).val();
  	   			idCompo  = $(input).attr("id"); 
  	   			
				for (var i = 0; i < listadoArticulo.length; i++) {
					var objVentaItemN = listadoArticulo[i];
					if (objVentaItemN.stock.articulo.codigo == idCompo) {
						objVentaItemN.subtotal =  objVentaItemN.cantidad * objVentaItemN.stock.precioCompra;
						console.log("objVentaItemN.subtotal " + objVentaItemN.subtotal);
						$(input).html(objVentaItemN.subtotal);
					}
				}
	        	
        	}
        })
        arrayComprasItem.push(objCompraItem);
    })	
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
			objVentaItem.subtotal = (objVentaItem.precioCompra * cantidad).toFixed(2);
			//objVentaItem.sImporte = (objVentaItem.precioCompra * cantidad).toFixed(2);
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
		+ "maxlength='5'/>"
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
		+ " required='required' onkeypress= 'return decimales(event,this); '"
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
		+ "maxlength='5' onkeypress= 'return decimales(event,this); '"
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
	$('#idbodyStock').empty();
	$('#idbodyStock').html(htmlTabla);

}
   
function grabar(){  
		var contextPath = $('#contextPath').val(); 
		var actionForm = $('#frmRegistrarCompra').attr("action");
		var url =contextPath+"/movimientoAlmacenController/llenarCompra" ;
		var myFormulario = $('#frmRegistrarCompra'); 
		console.log("actionForm " + actionForm);
		var fechaActual = new Date();
		
		if(!myFormulario[0].checkValidity()) {
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
				}else if (objExamen.fechaVencimiento <= fechaActual) {
					msg_advertencia("La fecha de vencimiento no puede ser menor a la actual");
					return;
				}
			}
			iniciarBloqueo();
				$.ajax({
				type : "GET",
				url : url,
				data: $('#frmRegistrarCompra').serialize(),
				success : function(data) { 
						    grabarDetalle()  
						    $("#btnListado").trigger("click");
				},
				
				error : function(xhr, status, er) { 
				        console.log("error: " + xhr + " status: " + status + " er:" + er);
							//msg_error();
	
						},
			  			complete: function()	
	  			{ 
			  				finBloqueo();
				}
		});
	}
}

function grabarDetalle(){  
	//debugger;
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
        	
        	if(index2 == 2 ){ // Columna lote
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
        	if(index2 == 8 ){ // Columna sub total
        		input    = $(this).children("label");
        		idAcceso = $(input).val();
  	   			idCompo  = $(input).attr("id");
  	   			
  	   			objCompraItem.codigo = idCompo; 
  	   		    $(input).html(objCompraItem.cantidad * objCompraItem.precioCompra);
  	   		    
  	   		    console.log("objCompraItem.cantidad " + objCompraItem.cantidad);
  	   		    console.log("objCompraItem.precioCompra " + objCompraItem.precioCompra);
  	   		    
				objCompraItem.item 			= index+1;
				objCompraItem.codigo 		= idAcceso;
				objCompraItem.subtotal	= objCompraItem.cantidad * objCompraItem.precioCompra;
				console.log("objCompraItem.subtotal " + objCompraItem.subtotal);
				
	        	
	        	//subTotal = subTotal +  objCompraItem.subtotal;
	        	//console.log("subTotal " +  subTotal);
	        	
        	}
        })
        arrayComprasItem.push(objCompraItem);
    })	 
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
		+ "maxlength='5'/>"
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
		+ " required='required' onkeypress= 'return decimales(event,this); '"
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
		+ "maxlength='5' onkeypress= 'return decimales(event,this); '"
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

function cambiarDonacion() {
	  if ($("#chkDonacion").is(":checked")) {
		  $('#txtSwDonacion').val("1"); 
		  obtenerValorCompra("1");
	  } else {
		  $('#txtSwDonacion').val("0"); 
		  obtenerValorCompra("0");
	  }
	}

function obtenerValorCompra(tipo){  
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
  	   			console.log("tipo " + tipo);
				for (var i = 0; i < listadoArticulo.length; i++) {
					var objVentaItemN = listadoArticulo[i];
					if (objVentaItemN.stock.articulo.codigo == idCompo) {
						objVentaItemN.stock.precioCompra =  $(input).val(); 
						if (tipo = "1") {
							objVentaItemN.stock.precioVenta =  objVentaItemN.stock.precioCompra; 
						}else{
							objVentaItemN.stock.precioVenta =  objVentaItemN.stock.precioCompra * 1.25; 
						} 
						console.log("objVentaItemN.stock.precioVenta ::" + objVentaItemN.stock.precioVenta);
						$(idCompo).html(objVentaItemN.stock.precioVenta);
					}
				}
        	}
        	if(index2 == 6 ){ // Columna precio Venta
        		input    = $(this).children("input");
        		idAcceso = $(input).val();
  	   			idCompo  = $(input).attr("id");
  	   			console.log("idAcceso ::" + idAcceso);
  	   			console.log("input ::" + input);
  	   			console.log("idCompo ::" + idCompo);
				for (var i = 0; i < listadoArticulo.length; i++) {
					var objVentaItemN = listadoArticulo[i];
					if (objVentaItemN.stock.articulo.codigo == idCompo) {
						console.log("COSTO ::" + objVentaItemN.stock.precioCompra * 1.25);
						console.log("Venta ::" + objVentaItemN.stock.precioVenta);
						$(idCompo).val("13.50");
					}
				}
        	}
        	if(index2 == 7 ){ // Columna cantidad
        		input    = $(this).children("input");
        		idAcceso = $(input).val();
  	   			idCompo  = $(input).attr("id"); 
  	   		    
				for (var i = 0; i < listadoArticulo.length; i++) {
					var objVentaItemN = listadoArticulo[i];
					if (objVentaItemN.stock.articulo.codigo == idCompo) {
						objVentaItemN.cantidad =  $(input).val(); 
					}
				}
        	}
        	if(index2 == 8 ){ // Columna sub total
        		input    = $(this).children("label");
        		idAcceso = $(input).val();
  	   			idCompo  = $(input).attr("id"); 
  	   			
				for (var i = 0; i < listadoArticulo.length; i++) {
					var objVentaItemN = listadoArticulo[i];
					if (objVentaItemN.stock.articulo.codigo == idCompo) {
						objVentaItemN.subtotal =  objVentaItemN.cantidad * objVentaItemN.stock.precioCompra;
						console.log("objVentaItemN.subtotal " + objVentaItemN.subtotal);
						$(input).html(objVentaItemN.subtotal);
					}
				}
	        	
        	}
        })
        arrayComprasItem.push(objCompraItem);
    })	
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
