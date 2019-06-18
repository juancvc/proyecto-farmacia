var codigoPerfil = "";

function confirmar_accion(codigo) {
	codigoPerfil = codigo;
	// alert(codigoReferencia);
	$('#md_confirmacion').modal('show');

}
function agregar_accion() {
	$('#md_reg_confirmacion').modal('show');
}

$(document).ready(function() {
	$("#btnConfirmarGeneric").click(function() {
		eliminarPerfil(codigoPerfil);
	});
});

function eliminarPerfil(codigo) { 
	var contextPath = $('#contextPath').val();
	$
			.ajax({
				url :  contextPath+"/perfilController/eliminar?codigo="
						+ codigo,
				type : 'GET',
				success : function(data) {
					$('#md_confirmacion').modal('hide');
					msg_exito();
					refrescarListado();
				},
				error : function(request, status, error) {
					alert(error);
				}
			});

};

function refrescarListado() {
	var contextPath = $('#contextPath').val();
	var item = 0; 
	var htmlTabla = "";
	$
			.ajax({
				url :  contextPath+"/perfilController/listarPerfiles",
				type : 'GET',

				success : function(data) {
					if (data != null) {

						for (var i = 0; i < data.length; i++) {
							var objeto = data[i];
							item = item + 1;
							htmlTabla += "<tr>" + "<td>"
									+ item
									+ "</td>"
									+ "<td>"
									+ objeto.nombrePerfil
									+ "</td>"
									+ "<td>"
									+ "<a title='Modificar' data-placement='top'"
									+ "data-toggle='tooltip' class='btn btn-outline-success btn-sm'"
									+ "onclick=\"javascript:modificarElementoGenerico('/perfilController/modificar','"+ [ objeto.codigo] + "');\"'"
									+ "href='#'><i class='icon-pencil'></i></a>"
									
									+ "<button type='button'"
									+ " class='btn btn-outline-danger btn-sm' "
									+ " data-toggle='tooltip'  data-placement='top'  title='Eliminar'"
									+ " onclick=\"confirmar_accion('"+ [ objeto.codigo] + "');\""
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

function grabarPerfil(){  
		var contextPath = $('#contextPath').val(); 
		var actionForm = $('#frmRegistroPerfil').attr("action");
		var url =contextPath+"/perfilController/grabarPerfil" ;
		var myFormulario = $('#frmRegistroPerfil'); 
		console.log("actionForm " + actionForm);
		
		if(!myFormulario[0].checkValidity()) {
			 msg_advertencia("Debe completar los campos requeridos(*) correctamente");

		}else{  
				iniciarBloqueo();
				$.ajax({
				type : "POST",
				url : url,
				data: $('#frmRegistroPerfil').serialize(),
				success : function(data) {
					    console.log("SUCCESS: ", data);  
					    if (data == "0") {
					    	msg_error("Error al registrar Perfil");  
						}else{
						    msg_exito("Éxito al registrar Perfil");  
						    //enviarListado();
							 $("#btnListado").trigger("click");
						}

						
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



