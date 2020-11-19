/**
 * 
 */

function generarICImensual(){  
		var contextPath = $('#contextPath').val(); 
		var actionForm = $('#frmGenerarVenta').attr("action");
		var url =contextPath+"/movimientoAlmacenController/llenarICI" ;
		var myFormulario = $('#frmGenerarVenta'); 
		console.log("actionForm " + actionForm);
		
		if(!myFormulario[0].checkValidity()) {
			 msg_advertencia("Debe completar los campos requeridos(*) correctamente");

		}else{  
				$.ajax({
				type : "GET",
				url : url,
				data: $('#frmGenerarVenta').serialize(),
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