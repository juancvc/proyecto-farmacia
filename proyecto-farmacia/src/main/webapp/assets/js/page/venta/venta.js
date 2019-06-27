function cargarPersonaModal() {
	var contextPath = $('#contextPath').val();
	path = contextPath + "/ventaController/personaModal";
		$.ajax({
			type : "POST",
			url : path,

			success : function(data) {
				$("#modalPersona").html(data);
				$("#modalPersona").modal('show'); 
			},
			error : function(request, status, error) {
				console.log("ERROR: " + error);
			}
		}); 
}