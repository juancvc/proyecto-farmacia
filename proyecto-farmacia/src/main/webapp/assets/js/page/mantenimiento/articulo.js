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
				url :  contextPath+"/articuloController/eliminar?index="
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

function refrescarListado() {
	var contextPath = $('#contextPath').val();
	var item = 0; 
	var htmlTabla = "";
	$
			.ajax({
				url :  contextPath+"/maestraController/refrescarLista",
				type : 'GET',
				data: $('#frmListadoMaestra').serialize(),
				success : function(data) {
					if (data != null) {

						for (var i = 0; i < data.length; i++) {
							var objeto = data[i];
							item = item + 1;
							htmlTabla += "<tr>" + "<td>"
									+ item
									+ "</td>"
									+ "<td>"
									+ objeto.nombreCorto
									+ "</td>"
									+ "<td>"
									+ objeto.valor1
									+ "</td>"
									+ "<td>"
									+ objeto.valor2
									+ "</td>"
									+ "<td>"
									+ objeto.valor3
									+ "</td>"
									+ "<td>"
									+ "<a title='Modificar' data-placement='top'"
									+ "data-toggle='tooltip' class='btn btn-outline-success btn-sm'"
									+ "onclick=\"javascript:modificarElementoGenericoTabla('/perfilController/modificar','"+ [ objeto.tabla] + "','"+ [ objeto.codReg] + "');\"'"
									+ "href='#'><i class='icon-pencil'></i></a>"
									
									+ "<button type='button'"
									+ " class='btn btn-outline-danger btn-sm' "
									+ " data-toggle='tooltip'  data-placement='top'  title='Eliminar'"
									+ " onclick=\"confirmar_accion('"+ [ objeto.tabla] + "','"+ [ objeto.codReg] + "');\""
									+ " data-original-title='Eliminar'"
									+ " id='eliminarReferencia'"
									+ [ objeto.codReg] + ">"
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

function grabar(){  
	var contextPath = $('#contextPath').val(); 
	var actionForm = $('#frmRegistroArticulo').attr("action");
	var url =contextPath+"/articuloController/grabar" ;
	var myFormulario = $('#frmRegistroArticulo'); 
	console.log("actionForm " + actionForm);
	
	if(!myFormulario[0].checkValidity()) {
		 msg_advertencia("Debe completar los campos requeridos(*) correctamente");

	}else{  
			$.ajax({
			type : "POST",
			url : url,
			data: $('#frmRegistroArticulo').serialize(),
			success : function(data) { 
				msg_exito("Éxito al registrar artículo");
				document.getElementById("btnListado").click(); 
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