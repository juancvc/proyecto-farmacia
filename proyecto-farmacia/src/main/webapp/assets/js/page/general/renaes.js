
function cargarEstablecimientoModal() {
	var contextPath = $('#contextPath').val();
	var cod = $('#codigoUsuario').val() ;
	var codPer = $('#codigoPersonaBean').val() ;
	console.log("cod  " + cod);
	console.log("codPer" + codPer);

	// var codigoLengua = $('#codigoLengua').val(); //
	// document.getElementById("codigoLengua").value;

	path = contextPath + "/usuarioController/establecimientoModal";
	// alert("path " + path)
		$.ajax({
			type : "POST",
			url : path,

			success : function(data) {
				// console.log("SUCCESS: ", data);
				$('#codigoUsuarioReanes').val(cod);
			//	document.getElementById("codigoUsuarioReanes").value = '';
			//	document.getElementById("codigoPersona").value = codPer;
				$('#codigoPersona').val(codPer);
				$("#modalEstablecimiento").html(data);
				$("#modalEstablecimiento").modal('show'); 
			},
			error : function(request, status, error) {
				console.log("ERROR: " + error);
			}
		}); 
}