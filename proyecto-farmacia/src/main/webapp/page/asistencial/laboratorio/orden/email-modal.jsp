<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<style>
* {
	box-sizing: border-box;
}

body {
	font-family: Cambria;
	font-size: 13px;
}

/*the container must be positioned relative:*/
.autocomplete {
	/*position: relative;*/
	display: inline-block;
}

input {
	border: 1px solid transparent;
	font-size: 13px;
}

input[type=text] {
	width: 100%;
}

.autocomplete-items {
	position: absolute;
	border: 1px solid #d4d4d4;
	border-bottom: none;
	border-top: none;
	z-index: 99;
	/*position the autocomplete items to be the same width as the container:*/
	top: 100%;
	left: 0;
	right: 0;
}

.autocomplete-items div {
	padding: 10px;
	cursor: pointer;
	background-color: #fff;
	border-bottom: 1px solid #d4d4d4;
}

/*when hovering an item:*/
.autocomplete-items div:hover {
	background-color: #e9e9e9;
}

/*when navigating through the items using the arrow keys:*/
.autocomplete-active {
	background-color: DodgerBlue !important;
	color: #ffffff;
}
</style>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/assets/css/datepicker.css">
<link rel="stylesheet" href="form.css">
<div class="modal-dialog modal-lg" role="document">
	<div class="modal-content">
		<div class="modal-header">
			<label class="modal-title text-text-bold-600 label_title" id="myModalLabel35"><b>ENVIO
					DE CORREO CON EL RESULTADO ADJUNTO DEL PACIENTE</b></label>
			<button type="button" class="close" data-dismiss="modal"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
		</div>

		<f:form id="reused_form" class="form-horizontal" role="form"
			method="post" action="" onsubmit="return false">
			<input id="contextPath" type="hidden"
				value="${pageContext.request.contextPath}">
			<f:input type="hidden" class="form-control" id="personaCodigo"
				path="codigo" />
<div class="card-body">
						<div class="form-group">
			<div class="row">

				<div class="form-group col-md-4 mb-2">
					<label for="exampleInputName" class="label_control">CORREO
						REMITENTE <span class="required">*</span>
					</label>

					<div class="position-relative has-icon-left">
						<f:input type="hidden" path="codigo" id="codigoReferenciaBean"
							val="" />
						<input id="contextPath" type="hidden"
							value="${pageContext.request.contextPath}">
						<div class="controls">
							<f:input type="text" class="form-control" required="required"
								disabled="true" maxlength="50" id="nroDocumentoPersona"
								path="correo" onkeypress="return runScript(event)" />
						</div>
					</div>

				</div>


			</div>

			<div class="row">
				<div class="form-group col-md-4 mb-2">
					<label for="email" class="label_control">CORREO A ENVIAR <span
						class="required">*</span>
					</label>
					<div class="controls">
						<input type="email" class="form-control" required="required"
							maxlength="50" id="email" name="email" value="${correoUsuario}" />

					</div>
				</div>

			</div>

			<div class="form-group">
				<label for="name"> MENSAJE</label>
				<textarea class="form-control" type="textarea" name="message"
					id="message" placeholder="Escriba un mensaje" maxlength="6000"
					rows="7"></textarea>
			</div>

			<div id="success_message"
				style="width: 100%; height: 100%; display: none;">
				<h3>Su mensaje se envió con éxito!</h3>
			</div>
			<div id="error_message"
				style="width: 100%; height: 100%; display: none;">
				<h3>Error</h3>
				Lo sentimos, hubo un error al enviar su mensaje.

			</div>
			<br>
			<button type="submit" class="btn btn-lg btn-success btn-block"
				onclick="validarExisteArchivo()" id="btnContactUs">ENVIAR</button>
				
				
					<a id="imprimir"
									href="${pageContext.request.contextPath}/ordenController/rptFichaREsultados"
									class="btn btn-secondary" style="display: none" title=""> <i class="fa fa-print"></i>
									IMPRIMIR
								</a>
				
				<button type="button" id="btnCerrarModalEmail" style="display: none"
					class="btn btn-secondary" data-dismiss="modal">
					<i class="fa fa-close"></i> CERRAR
				</button>
					</div>
	</div>
		</f:form>
		</div>
	
	<script
		src="${pageContext.request.contextPath}/assets/js/page/util/datepicker.js"
		type="text/javascript" charset="utf-8"></script>

	<script
		src="${pageContext.request.contextPath}/assets/js/page/util/datepicker.es.min.js"
		type="text/javascript" charset="utf-8"></script>

	<script
		src="${pageContext.request.contextPath}/assets/js/page/util/utilitarios.js"
		type="text/javascript" charset="utf-8"></script>

	<script>
		$(document).ready(
				function() {
					var date_input = $('input[id="date"]'); //our date input has the name "date"
					var container = $('.bootstrap-iso form').length > 0 ? $(
							'.bootstrap-iso form').parent() : "body";
					date_input.datepicker({
						format : 'dd/mm/yyyy',
						container : container,
						todayHighlight : true,
						autoclose : true,
						language : 'es'

					})
				})

		$(document)
				.ready(
						function() {
							var date_inputHasta = $('input[id="dateHasta"]'); //our date input has the name "date"
							var containerHasta = $('.bootstrap-iso form').length > 0 ? $(
									'.bootstrap-iso form').parent()
									: "body";
							date_inputHasta.datepicker({
								format : 'dd/mm/yyyy',
								container : containerHasta,
								todayHighlight : true,
								autoclose : true,
								language : 'es'

							})
						})
	</script>

	<script>
		function habilitar() {

			document.getElementById('personaApellidoPaterno').disabled = true;
			document.getElementById('personaApellidoMaterno').disabled = true;
			document.getElementById('sexoPaciente').disabled = true;
			document.getElementById('personaPrimerNombre').disabled = true;
			document.getElementById('personaSegundoNombre').disabled = true;
			document.getElementById('personaFechaNac').disabled = true;

			$("#nroDocumentoPaciente").focus();
		}

		function limpiar() {
			$('#tipoDocumentoPaciente').val("000002");
			$('#nroDocumentoPaciente').val("");
			$('#personaApellidoPaterno').val("");
			$('#personaApellidoMaterno').val("");
			$('#sexoPaciente').val("");
			$('#personaPrimerNombre').val("");
			$('#personaSegundoNombre').val("");
			$('#personaFechaNac').val("");
			$("#nroDocumentoPaciente").focus();
		}

		function runScript(e) {
			//See notes about 'which' and 'key'
			if (e.keyCode == 13) {
				iniciarBloqueo();
				finBloqueo();
				return false;
			}
		}
	</script>

	<script>
		$(function() {
			function after_form_submitted(data) {
				if (data.result == 'success') {
					$('form#reused_form').hide();
					$('#success_message').show();
					$('#error_message').hide();
				} else {
					$('#error_message').append('<ul></ul>');

					jQuery.each(data.errors, function(key, val) {
						$('#error_message ul').append(
								'<li>' + key + ':' + val + '</li>');
					});
					$('#success_message').hide();
					$('#error_message').show();

					//reverse the response on the button
					$('button[type="button"]', $form).each(function() {
						$btn = $(this);
						label = $btn.prop('orig_label');
						if (label) {
							$btn.prop('type', 'submit');
							$btn.text(label);
							$btn.prop('orig_label', '');
						}
					});

				}//else
			}

			$('#reused_form').submit(function(e) {
				e.preventDefault();

				$form = $(this);
				//show some response on the button
				$('button[type="submit"]', $form).each(function() {
					$btn = $(this);
					$btn.prop('type', 'button');
					$btn.prop('orig_label', $btn.text());
					$btn.text('enviando ...');
				});

				$.ajax({
					type : "POST",
					url : 'handler.php',
					data : $form.serialize(),
					success : after_form_submitted,
					dataType : 'json'
				});

			});
		});
	</script>

	<script>
	function validarExisteArchivo() {
		var contextPath = $('#contextPath').val();
		var email = $('#email').val();
		var mensaje = $('#message').val();
		var pdf = $('#pdf').val();
		iniciarBloqueo();
		$
				.ajax({
					type : "GET",
					url : contextPath
							+ "/ordenController/validarArchivoExiste",

					success : function(data) {
						if (data == "0") {
							document.getElementById('imprimir').click();
						//	$('#imprimir').trigger("click");
							enviarEmail();
						}else{
							enviarEmail();
						}

					},

					error : function(xhr, status, er) {
						console.log("error: " + xhr + " status: " + status
								+ " er:" + er);
					},
					complete : function() {
						finBloqueo();
					}
				});
		
		
		
		}
	
		function enviarEmail() {
			var contextPath = $('#contextPath').val();
			var email = $('#email').val();
			var mensaje = $('#message').val();
			var pdf = $('#pdf').val();
			iniciarBloqueo();
			$
					.ajax({
						type : "POST",
						url : contextPath
								+ "/ordenController/enviarEmail?mensaje="
								+ mensaje + "&pdf=" + pdf + "&correoDestino="
								+ email,

						success : function(data) {
							if (data == "") {
								msg_error("Error al enviar correo, no ha descargado el archivo a enviar");
							} else {
								msg_exito("El correo fue enviado con exito");
								$('#btnCerrarModalEmail').trigger("click");
								
							}

						},

						error : function(xhr, status, er) {
							console.log("error: " + xhr + " status: " + status
									+ " er:" + er);
						},
						complete : function() {
							finBloqueo();
						}
					});
		}
	</script>

</div>



