/**
 * 
 */
var accionRealizar = "";
var codigoRegistro = "";
var validaClase = "";
var validaStock = "1";
function confirmar_eliminar(codigo, tipo) {
	codigoRegistro = codigo;
	accionRealizar = tipo;
	if (tipo == '3') {
		var myFormulario = $('#frmRegistrarMovimiento');
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
			console.log("eliminarArticulo :: " + codigoRegistro);
			eliminarArticulo(codigoRegistro); 

		$('#md_confirmacion').modal('hide');
	});
});

function generarICImensual() {
	var contextPath = $('#contextPath').val();
	var actionForm = $('#frmReporteICI').attr("action");
	var url = contextPath + "/movimientoAlmacenController/llenarDatosICI";
	var myFormulario = $('#frmReporteICI');
	console.log("actionForm " + actionForm);

	if (!myFormulario[0].checkValidity()) {
		msg_advertencia("Debe completar los campos requeridos(*) correctamente");

	} else {
		$.ajax({
			type : "GET",
			url : url,
			data : $('#frmReporteICI').serialize(),
			success : function(data) {
				document.getElementById("btnGenerar").click();

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

function cambiarMes() {
	var idMes = $('#cboMes').val();
	if (idMes == "1") {
		$('#nombreMes').val("ENERO");
	} else if (idMes == "2") {
		$('#nombreMes').val("FEBRERO");
	} else if (idMes == "3") {
		$('#nombreMes').val("MARZO");
	} else if (idMes == "4") {
		$('#nombreMes').val("ABRIL");
	} else if (idMes == "5") {
		$('#nombreMes').val("MAYO");
	} else if (idMes == "6") {
		$('#nombreMes').val("JUNIO");
	} else if (idMes == "7") {
		$('#nombreMes').val("JULIO");
	} else if (idMes == "8") {
		$('#nombreMes').val("AGOSTO");
	} else if (idMes == "9") {
		$('#nombreMes').val("SETIEMBRE");
	} else if (idMes == "10") {
		$('#nombreMes').val("OCTUBRE");
	} else if (idMes == "11") {
		$('#nombreMes').val("NOVIEMBRE");
	} else if (idMes == "12") {
		$('#nombreMes').val("DICIEMBRE");
	}
 }

function llenarArticuloIndex2(index) {
	// debugger;
	var contextPath = $('#contextPath').val();
	var htmlTabla = "";
	var item = 0;
	var valida = "0";
	console.log("index::>" + index);
	$
			.ajax({
				type : "GET",
				// data: "entidad=" + entidad,

				url : contextPath
						+ "/movimientoAlmacenController/refrescarListaArticulosMov?index="
						+ index,
				success : function(data) { 
					console.log("data " + data);	 

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
 function llenarArticuloIndex(index) {
	 
		var contextPath = $('#contextPath').val();
		var htmlTabla = "";
		var item = 0;
		var valida = "0";
		console.log("index::>" + index);
		$
				.ajax({
					type : "GET",
					// data: "entidad=" + entidad,

					url : contextPath
							+ "/movimientoAlmacenController/refrescarListaArticulos?index="
							+ index,
					success : function(data) { 
						console.log("data " + data);	
						if (data != null) {
							
							for (var i = 0; i < listadoArticulo.length; i++) {
								var objMovimiento = listadoArticulo[i];
								if (objMovimiento.stock.articulo.codigo == data.stock.articulo.codigo) {
									valida = "1";
								}
							}
							if (valida == "1") {
								msg_advertencia("El artículo ya fue ingresado.");
							} else {
								listadoArticulo.push(data);
								for (var i = 0; i < listadoArticulo.length; i++) {
									var objMovimiento = listadoArticulo[i];
									item = item + 1;
									htmlTabla += "<tr>" + "<td>"
											+ item
											+ "</td>"
											+ "<td>"
											+ "<label for='nombreCompleto' class='label_control' id="
											+ [ objMovimiento.stock.codigo ]
											+ " >"
											+ objMovimiento.stock.articulo.nombre
											+ "</label>"
											+ "</td>"
											+ "<td>" 
											+ "<label for='nombreCompleto' class='label_control' id="
											+ [ objMovimiento.stock.lote ]
											+ " >"
											+ objMovimiento.stock.lote
											+ "</label>"
											+ "</td>"
											+ "<td>"
											+ "<label for='nombreCompleto' class='label_control' id="
											+ [ objMovimiento.stock.lote ]
											+ " >"
											+ objMovimiento.stock.sFechaVencimiento
											+ "</label>"
											+ "</td>"
											+ "<td>"
											+ "<label for='stock' class='label_control' id="
											+ [ objMovimiento.stock.codigo ]
											+ " >"
											+ objMovimiento.stock.stock
											+ "</label>"
											+ "</td>"
											+ "<td>"
											+ "<label for='stock' class='label_control' id="
											+ objMovimiento.stock.codigo 
											+ " >"
											+ objMovimiento.stock.precioVenta
											+ "</label>"
											+ "</td>"
											+ "<td> <input type='text' class='form-control' "
											+ "id="
											+ [ objMovimiento.stock.articulo.codigo ]
											+ " required='required' "
											+ "value ='"
											+ objMovimiento.cantidad
											+ "' "
											+ "maxlength='5' onkeypress= 'return soloNumeros(event); '"
											+ "onkeypress= 'return soloNumeros(event);'"
											+ "onchange = 'calculaSubTotal(); '  /></td>"
											+ "<td>"
											+ "<label for='nombreCompleto' class='label_control' id="
											+ [ objMovimiento.stock.articulo.codigo ]
											+ " >"
											+ objMovimiento.subtotal
											+ "</label>"
											+ "</td>"
											+ "<td>"
											+ "<button type='button'"
											+ " class='btn btn-outline-danger btn-sm' "
											+ " data-toggle='tooltip'  data-placement='top'  title='Eliminar'"
											+ "  onclick=\"confirmar_eliminar('"
											+ [ objMovimiento.stock.codigo ]
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

	function calculaSubTotal() {
		var valida = 1;
		var arrayComprasItem = [];
		validaStock = "1";
		/** RECORRER MENU * */
		$("#dataTable tbody tr")
				.each(
						function(index) {
							var asignado, input, idAcceso, idCompo;

							var objStock = {
								codigo : 0,
								lote : '',
								stock : 0
							};

							var objMovimientoAlmacen = {
								item : 0,
								codigo : 0,
								precioCompra : '0',
								precioVenta : 0,
								cantidad : 0,
								subtotal : 0,
								flgExport : false
							};

							$(this)
									.children("td")
									.each(
											function(index2) {
												if (index2 == 2) { // Columna
																	// lote
													input = $(this).children(
															"input");
													idAcceso = $(input).val();
													idCompo = $(input).attr(
															"id");
													for (var i = 0; i < listadoArticulo.length; i++) {
														var objMovimientoN = listadoArticulo[i];
														if (objMovimientoN.stock.articulo.codigo == idCompo) {
															objMovimientoN.stock.lote = $(
																	input)
																	.val();
														}
													}
												}
												if (index2 == 3) { // Columna
																	// fechaVencimiento
													input = $(this).children(
															"input");
													idAcceso = $(input).val();
													idCompo = $(input).attr(
															"id");

													for (var i = 0; i < listadoArticulo.length; i++) {
														var objMovimientoN = listadoArticulo[i];
														if (objMovimientoN.stock.articulo.codigo == idCompo) {
															objMovimientoN.stock.sFechaVencimiento = $(
																	input)
																	.val();
														}
													}
												}
												
												if (index2 == 4) { // Columna  lote
													input    = $(this).children("label");
									        		idAcceso = $(input).val();
									  	   			idCompo  = $(input).attr("id");
									  	   			
									  	   			objStock.stock = $(input).html(); 
													console.log("stock :::: "+ objStock.stock);
													}
												
												if (index2 == 5) { // Columna
																	// precio
																	// Compra
													input = $(this).children("label");
													idAcceso = $(input).val();
													idCompo = $(input).attr("id");

													for (var i = 0; i < listadoArticulo.length; i++) {
														var objMovimientoN = listadoArticulo[i]; 
														if (objMovimientoN.stock.codigo == idCompo) { 
															objMovimientoN.stock.precioVenta = $(input).html();
														}
													}
												} 
												if (index2 == 6) { // Columna
																	// cantidad
													input = $(this).children(
															"input");
													idAcceso = $(input).val();
													idCompo = $(input).attr(
															"id");
													console
															.log("cantidad :::: "
																	+ $(input)
																			.val());

													for (var i = 0; i < listadoArticulo.length; i++) {
														var objMovimientoN = listadoArticulo[i];
														if (objMovimientoN.stock.articulo.codigo == idCompo) {
															objMovimientoN.cantidad = $(input).val(); 
															if(validaClase == "s"){
																console.log("objMovimientoN.cantidad " + objMovimientoN.cantidad);
																console.log("objStock.stock " + objStock.stock);
																if(Number(objMovimientoN.cantidad) > Number(objStock.stock)){
																	msg_advertencia("La cantidad no puede ser mayor al Stock actual");
																	$(input).val(0);
																	valida = 0;
																	validaStock= "0";
																	return;
																}
															}
														}
													}
												}
												if (index2 == 7) { // Columna
																	// sub total
													input = $(this).children(
															"label");
													idAcceso = $(input).val();
													idCompo = $(input).attr(
															"id");

													for (var i = 0; i < listadoArticulo.length; i++) {
														var objMovimientoN = listadoArticulo[i];
														if (objMovimientoN.stock.articulo.codigo == idCompo) {
															objMovimientoN.subtotal = objMovimientoN.cantidad
																	* objMovimientoN.stock.precioVenta;
															console
																	.log("objMovimientoN.subtotal "
																			+ objMovimientoN.subtotal);
															$(input)
																	.html(
																			objMovimientoN.subtotal);
														}
													}

												}
											})
							arrayComprasItem.push(objMovimientoAlmacen);
						})
		var importe = 0.00;
		if(valida == 1){
			for (var i = 0; i < listadoArticulo.length; i++) {
				var objMovimiento = listadoArticulo[i];
				importe = importe + Number(objMovimiento.subtotal);
			}
			$('#txtCajaImporteTotal').val(importe.toFixed(2));
			$('#txtCajaImporteTotalHidden').val(importe.toFixed(2));
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
			var objMovimiento = listadoArticulo[i];
			if (objMovimiento.stock.codigo == objeto) {
				objMovimiento.cantidad = cantidad;
				objMovimiento.subtotal = (objMovimiento.precioCompra * cantidad)
						.toFixed(2);
				// objMovimiento.sImporte = (objMovimiento.precioCompra *
				// cantidad).toFixed(2);
				console.log("objExamen.importe:: " + objMovimiento.subtotal)
			}
		}
		for (var i = 0; i < listadoArticulo.length; i++) {
			var objMovimiento = listadoArticulo[i];
			item = item + 1;
			htmlTabla += "<tr>" + "<td>"
					+ item
					+ "</td>"
					+ "<td>"
					+ "<label for='nombreCompleto' class='label_control' id="
					+ [ objMovimiento.stock.articulo.codigo ]
					+ " >"
					+ objMovimiento.stock.articulo.nombre
					+ "</label>"
					+ "</td>"
					+ "<td><input type='text' class='form-control' "
					+ "id="
					+ [ objMovimiento.stock.articulo.codigo ]
					+ " required='required' "
					+ "value =''"
					+ "maxlength='5'/>"
					+ "</td>"
					+ "<td><input type='text' class='form-control' "
					+ "id="
					+ [ objMovimiento.stock.articulo.codigo ]
					+ " required='required' "
					+ "placeholder='DD/MM/YYYY'"
					+ "maxlength='10' "
					+ "onkeyup='this.value=formateafecha(this.value);' />"
					+ "</td>"
					+ "<td><input type='text' class='form-control' "
					+ "id="
					+ [ objMovimiento.stock.articulo.codigo ]
					+ " required='required' "
					+ "value =''"
					+ "maxlength='100'/>"
					+ "</td>"
					+ "<td><input type='text' class='form-control' "
					+ "id="
					+ [ objMovimiento.stock.articulo.codigo ]
					+ " required='required' onkeypress= 'return decimales(event,this); '"
					+ "value ='0' onchange = 'calculaSubTotal(); ' "
					+ "maxlength='100'/>"
					+ "</td>"
					+ "<td><input type='text' class='form-control' "
					+ "id="
					+ [ objMovimiento.stock.articulo.codigo ]
					+ " required='required' "
					+ "value ='0'"
					+ "maxlength='100'/>"
					+ "</td>"
					+ "<td> <input type='text' class='form-control' "
					+ "id="
					+ [ objMovimiento.stock.codigo ]
					+ " required='required' "
					+ "value ='"
					+ objMovimiento.cantidad
					+ "' "
					+ "maxlength='5' onkeypress= 'return decimales(event,this); '"
					+ "onkeypress= 'return soloNumeros(event);'"
					+ "onchange = 'calculaSubTotal(); '  /></td>"
					+ "<td>"
					+ "<label for='nombreCompleto' id="
					+ [ objMovimiento.stock.articulo.codigo ]
					+ "class='label_control'>0"
					+ "</label>"
					+ "</td>"
					+ "<td>"
					+ "<button type='button'"
					+ " class='btn btn-outline-danger btn-sm' "
					+ " data-toggle='tooltip'  data-placement='top'  title='Eliminar'"
					+ "  onclick=\"confirmar_eliminar('"
					+ [ objMovimiento.stock.codigo ] + "','1');\""
					+ " data-original-title='Eliminar'"
					+ " id='agregarEspecialidad'>"
					+ "  <i class='fas fa-trash'></i></button> " + "</td>"
					+ "</tr>";

		}
		$('#idbodyStock').empty();
		$('#idbodyStock').html(htmlTabla);

	}
	 
	function grabar(){  
			var contextPath = $('#contextPath').val(); 
			var actionForm = $('#frmRegistrarMovimiento').attr("action");
			var url =contextPath+"/movimientoAlmacenController/llenarMovimiento" ;
			var myFormulario = $('#frmRegistrarMovimiento'); 
			console.log("actionForm " + actionForm);
			
			var idMovimiento = document.getElementById("cboTipoMovimiento");
			var idFarmaciaDestino = document.getElementById("cboFarmaciaDestino");
			
			 console.log("idMovimiento " + idMovimiento.value);
			 console.log("cboFarmaciaDestino " + idFarmaciaDestino.value);
			 if(idMovimiento.value == "000010") { // distribución
					if (idFarmaciaDestino.value == "") {
						 msg_advertencia("Debe seleccionar farmacia destino para transferir.");
						 return;
					}  
				}
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
					}
				} 
				if(validaStock == "0"){
					msg_advertencia("La cantidad no puede ser mayor al Stock actual");
					return;
				}
				
				iniciarBloqueo();
					$.ajax({
					type : "GET",
					url : url,
					data: $('#frmRegistrarMovimiento').serialize(),
					success : function(data) { 
							    grabarDetalle()  
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
			var objMovimientoAlmacen = {
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
	  	   			
	  	   			objMovimientoAlmacen.codigo = idCompo;
	  	   		    console.log("compra $(input). " + $(input).val());
	  	   		    
					objMovimientoAlmacen.item 		= index+1;
					//objArticulo.codigo 	= idCompo; 
					objStock.codigo = idCompo;
					
					objMovimientoAlmacen.stock = objStock;
	        	}
	        	
	        	if(index2 == 2 ){ // Columna lote
	        		input    = $(this).children("input");
	        		idAcceso = $(input).val();
	  	   			idCompo  = $(input).attr("id");
	  	   			
	  	   			objMovimientoAlmacen.codigo = idCompo;
	  	   		    console.log("compra $(input). " + $(input).val());
	  	   		    
					objMovimientoAlmacen.item 			= index+1;
					objMovimientoAlmacen.codigo 		= idAcceso;
					objStock.lote	= $(input).val();
					
					objMovimientoAlmacen.stock = objStock;
	        	}
	        	if(index2 == 3 ){ // Columna fechaVencimiento
	        		input    = $(this).children("label");
	        		idAcceso = $(input).val();
	  	   			idCompo  = $(input).attr("id");
	  	   			
	  	   			objMovimientoAlmacen.codigo = idCompo;
	  	   		    console.log("compra $(sFechaVencimiento). " + $(input).val());
	  	   		    
					objMovimientoAlmacen.item 			= index+1;
					objMovimientoAlmacen.codigo 		= idAcceso;
					objStock.sFechaVencimiento	= $(input).val();
					objMovimientoAlmacen.stock = objStock;
	        	}
	        	if(index2 == 4 ){ // Columna stock
	        		input    = $(this).children("label");
	        		idAcceso = $(input).val();
	  	   			idCompo  = $(input).attr("id");
	  	   			
	  	   			objMovimientoAlmacen.codigo = idCompo;
	  	   		    console.log("compra $(input). " + $(input).val());
	  	   		    
					objMovimientoAlmacen.item 			= index+1;
					objMovimientoAlmacen.codigo 		= idAcceso;
					objStock.stock	= $(input).val();
					objMovimientoAlmacen.stock = objStock;
	        	}
	        	if(index2 == 5 ){ // Columna precio venta
	        		input    = $(this).children("input");
	        		idAcceso = $(input).val();
	  	   			idCompo  = $(input).attr("id");
	  	   			
	  	   			objMovimientoAlmacen.codigo = idCompo;
	  	   		    console.log("venta $(input). " + $(input).val());
	  	   		    
					objMovimientoAlmacen.item 			= index+1;
					objMovimientoAlmacen.codigo 		= idAcceso;
					objStock.precioVenta	= $(input).val();
					
					objMovimientoAlmacen.stock = objStock;
	        	}
	        	if(index2 == 6 ){ // Columna cantidad
	        		input    = $(this).children("input");
	        		idAcceso = $(input).val();
	  	   			idCompo  = $(input).attr("id");
	  	   			
	  	   			objMovimientoAlmacen.codigo = idCompo;
	  	   		    console.log("venta $(input). " + $(input).val());
	  	   		    
					objMovimientoAlmacen.item 			= index+1;
					objMovimientoAlmacen.codigo 		= idAcceso;
					objMovimientoAlmacen.cantidad	= $(input).val();
	        	}
	        	if(index2 == 7 ){ // Columna sub total
	        		input    = $(this).children("label");
	        		idAcceso = $(input).val();
	  	   			idCompo  = $(input).attr("id");
	  	   			
	  	   			objMovimientoAlmacen.codigo = idCompo; 
	  	   		    $(input).html(objMovimientoAlmacen.cantidad * objMovimientoAlmacen.precioCompra);
	  	   		    
	  	   		    
					objMovimientoAlmacen.item 			= index+1;
					objMovimientoAlmacen.codigo 		= idAcceso;
					objMovimientoAlmacen.subtotal	= objMovimientoAlmacen.cantidad * objMovimientoAlmacen.precioCompra;
					console.log("objMovimientoAlmacen.subtotal " + objMovimientoAlmacen.subtotal);
					
		        	
		        	//subTotal = subTotal +  objMovimientoAlmacen.subtotal;
		        	//console.log("subTotal " +  subTotal);
		        	
	        	}
	        })
	        arrayComprasItem.push(objMovimientoAlmacen);
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
	           url: contextPath+"/movimientoAlmacenController/asignarMovimiento",
	           success: function(data)
	           {	
	        	    msg_exito();
	        	    document.getElementById("btnNuevo").click(); 
		   	    	
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
			var objMovimiento = listadoArticulo[i];
			if (objMovimiento.stock.codigo == codigo) {
				console.log("objVentaItem.stock.codigo "
						+ objMovimiento.stock.codigo);
				listadoArticulo.splice(i, 1);
			}
		}
		for (var i = 0; i < listadoArticulo.length; i++) {
			var objMovimiento = listadoArticulo[i];
			item = item + 1;
			htmlTabla += "<tr>" + "<td>"
			+ item
			+ "</td>"
			+ "<td>"
			+ "<label for='nombreCompleto' class='label_control' id="
			+ [ objMovimiento.stock.codigo ]
			+ " >"
			+ objMovimiento.stock.articulo.nombre
			+ "</label>"
			+ "</td>"
			+ "<td>" 
			+ "<label for='nombreCompleto' class='label_control' id="
			+ [ objMovimiento.stock.lote ]
			+ " >"
			+ objMovimiento.stock.lote
			+ "</label>"
			+ "</td>"
			+ "<td>"
			+ "<label for='nombreCompleto' class='label_control' id="
			+ [ objMovimiento.stock.lote ]
			+ " >"
			+ objMovimiento.stock.sFechaVencimiento
			+ "</label>"
			+ "</td>"
			+ "<td>"
			+ "<label for='stock' class='label_control' id="
			+ [ objMovimiento.stock.codigo ]
			+ " >"
			+ objMovimiento.stock.stock
			+ "</label>"
			+ "</td>"
			+ "<td><input type='text' class='form-control' "
			+ "id="
			+ [ objMovimiento.stock.articulo.codigo ]
			+ " required='required' onchange = 'calculaSubTotal(); ' "
			+ "value ='"
			+ objMovimiento.stock.precioVenta
			+ "' onkeypress= 'return decimales(event,this); '"
			+ "maxlength='100' autocomplete='off'/>"
			+ "</td>"
			+ "<td> <input type='text' class='form-control' "
			+ "id="
			+ [ objMovimiento.stock.articulo.codigo ]
			+ " required='required' "
			+ "value ='"
			+ objMovimiento.cantidad
			+ "' "
			+ "maxlength='5' onkeypress= 'return soloNumeros(event); '"
			+ "onkeypress= 'return soloNumeros(event);'"
			+ "onchange = 'calculaSubTotal(); '  /></td>"
			+ "<td>"
			+ "<label for='nombreCompleto' class='label_control' id="
			+ [ objMovimiento.stock.articulo.codigo ]
			+ " >"
			+ objMovimiento.subtotal
			+ "</label>"
			+ "</td>"
			+ "<td>"
			+ "<button type='button'"
			+ " class='btn btn-outline-danger btn-sm' "
			+ " data-toggle='tooltip'  data-placement='top'  title='Eliminar'"
			+ "  onclick=\"confirmar_eliminar('"
			+ [ objMovimiento.stock.codigo ]
			+ "','1');\""
			+ " data-original-title='Eliminar'"
			+ " id='agregarEspecialidad'>"
			+ "  <i class='fas fa-trash'></i></button> "
			+ "</td>" + "</tr>";
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

	function cambiarTipoMovimiento() { 
		var contextPath = $('#contextPath').val();
		var index = document.getElementById("cboTipoMovimiento").selectedIndex;
		console.log("index " + index);
		$.ajax({
			contentType : "application/json",
			type : "GET",
			url : contextPath
					+ "/movimientoAlmacenController/llenarTipoMovimiento?index="
					+ index,

			success : function(data) {
				if(data.clase.idRegistro == "000001"){ // ingreso
					validaClase ="i";
				}else{
					validaClase ="s";
				}
				console.log("data.codigo " + data.codigo);
				if(data.codigo == "000010"){ // ingreso x distribución farmacia
					document.getElementById('divAlmacenDestino').style.display = 'block';
				}else{
					document.getElementById('divAlmacenDestino').style.display = 'none';
				}
			},

			error : function(xhr, status, er) {
				console.log("error: " + xhr + " status: " + status + " er:" + er);

			},
			complete : function() {
			}
		});
	}