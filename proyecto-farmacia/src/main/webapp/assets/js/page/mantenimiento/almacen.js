var codReg = "";
function confirmar_accion(codigo) { 
	codReg = codigo;
	$('#md_confirmacion').modal('show');

}

$(document).ready(function() {
	$("#btnConfirmarGeneric").click(function() {
		eliminarRegistro(codReg);
	});
});

function eliminarRegistro(index) { 
	var contextPath = $('#contextPath').val();
	$
			.ajax({
				url :  contextPath+"/almacenController/eliminar?index="
						+ index,
				type : 'GET',
				success : function(data) {
					$('#md_confirmacion').modal('hide');
					msg_exito();
					document.getElementById("btnListado").click(); 
				},
				error : function(request, status, error) {
					alert(error);
				}
			});

};
 
function grabar(){  
	var contextPath = $('#contextPath').val(); 
	var actionForm = $('#frmRegistroAlmacen').attr("action");
	var url =contextPath+"/almacenController/grabar" ;
	var myFormulario = $('#frmRegistroAlmacen'); 
	console.log("actionForm " + actionForm);
	
	if(!myFormulario[0].checkValidity()) {
		 msg_advertencia("Debe completar los campos requeridos(*) correctamente");

	}else{  
			$.ajax({
			type : "POST",
			url : url,
			data: $('#frmRegistroAlmacen').serialize(),
			success : function(data) { 
				msg_exito("Éxito al registrar almacén");
				document.getElementById("btnListado").click(); 
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