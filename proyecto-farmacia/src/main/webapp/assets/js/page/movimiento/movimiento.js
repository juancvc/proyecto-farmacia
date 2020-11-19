/**
 * 
 */

function generarICImensual(){  
		var contextPath = $('#contextPath').val(); 
		var actionForm = $('#frmReporteICI').attr("action");
		var url =contextPath+"/movimientoAlmacenController/llenarDatosICI" ;
		var myFormulario = $('#frmReporteICI'); 
		console.log("actionForm " + actionForm);
		
		if(!myFormulario[0].checkValidity()) {
			 msg_advertencia("Debe completar los campos requeridos(*) correctamente");

		}else{  
				$.ajax({
				type : "GET",
				url : url,
				data: $('#frmReporteICI').serialize(),
				success : function(data) {
					document.getElementById("btnGenerar").click(); 
					
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

function cambiarMes(){
	var idMes = $('#cboMes').val(); 
	if (idMes == "1") {
		$('#nombreMes').val("ENERO"); 
	}else if (idMes == "2") {
		$('#nombreMes').val("FEBRERO"); 
	}else if (idMes == "3") {
		$('#nombreMes').val("MARZO"); 
	}else if (idMes == "4") {
		$('#nombreMes').val("ABRIL"); 
	}else if (idMes == "5") {
		$('#nombreMes').val("MAYO"); 
	}else if (idMes == "6") {
		$('#nombreMes').val("JUNIO"); 
	}else if (idMes == "7") {
		$('#nombreMes').val("JULIO"); 
	}else if (idMes == "8") {
		$('#nombreMes').val("AGOSTO"); 
	}else if (idMes == "9") {
		$('#nombreMes').val("SETIEMBRE"); 
	}else if (idMes == "10") {
		$('#nombreMes').val("OCTUBRE"); 
	}else if (idMes == "11") {
		$('#nombreMes').val("NOVIEMBRE"); 
	}else if (idMes == "12") {
		$('#nombreMes').val("DICIEMBRE"); 
	}
	
}