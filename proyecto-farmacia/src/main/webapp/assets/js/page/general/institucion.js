/**
 * 
 */

function grabar(){  
	var contextPath = $('#contextPath').val(); 
	var actionForm = $('#frmRegistroInstitucion').attr("action");
	var url =contextPath+"/institucionController/grabar" ;
	var myFormulario = $('#frmRegistroInstitucion'); 
	console.log("actionForm " + actionForm);
	
	if(!myFormulario[0].checkValidity()) {
		 msg_advertencia("Debe completar los campos requeridos(*) correctamente");

	}else{  
			$.ajax({
			type : "POST",
			url : url,
			data: $('#frmRegistroInstitucion').serialize(),
			success : function(data) { 
				msg_exito(); 
			},
			
			error : function(xhr, status, er) { 
			        console.log("error: " + xhr + " status: " + status + " er:" + er);
						 msg_error(); 
					},
		  			complete: function()
  			{ 
			}
	});
}
}