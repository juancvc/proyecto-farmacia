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
				url :  contextPath+"/laboratorioController/eliminar?index="
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
	var actionForm = $('#frmRegistroLaboratorio').attr("action");
	var url =contextPath+"/laboratorioController/grabar" ;
	var myFormulario = $('#frmRegistroLaboratorio'); 
	var ruc = $('#txtRuc').val(); 
	console.log("actionForm " + actionForm);
	
	if(!myFormulario[0].checkValidity()) {
		 msg_advertencia("Debe completar los campos requeridos(*) correctamente");
	     return;
	}
	if (ruc != "" ) {
			if (ruc.length < 11) { 
				msg_advertencia("Debe ingresar un numero de RUC válido.");
				return;
			} 
	}
		
			$.ajax({
			type : "POST",
			url : url,
			data: $('#frmRegistroLaboratorio').serialize(),
			success : function(data) { 
				msg_exito("Éxito al realizar proceso.");
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