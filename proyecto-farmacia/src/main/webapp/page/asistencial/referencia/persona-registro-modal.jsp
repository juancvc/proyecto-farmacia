<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/vendors/css/extensions/toastr.css">

<div class="modal-dialog modal-lg" role="document">
	<div class="modal-content">
		<div class="modal-header">
			<label class="modal-title text-text-bold-600" id="myModalLabel35"><b>BUSQUEDA
					DE PACIENTE</b></label>
			<button type="button" class="close" data-dismiss="modal"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
		</div>

		<f:form id="frmGuardarPersona" class="form-horizontal" role="form"
			method="post" action="" onsubmit="return false">
			<input id="contextPath" type="hidden"
				value="${pageContext.request.contextPath}">

			<f:input class="form-control" type="hidden"
				id="pacienteNombreCompleto" path="persona.nombreCompleto" />


			<f:input type="hidden" class="form-control" id="personaCodigo"
				path="persona.codigo" />
			<f:input type="hidden" class="form-control" id="personaCodigoSigeho"
				path="persona.codigoPersonaSigeho" />
			<div class="modal-body" id="buscaPaciente">
				<div class="row">
					<div class="form-group col-md-4 mb-2">
						<label for="situacion" class="label_control">TIPO DOCUMENTO<span class="required">*</span>
						</label>
						<div class="controls">
							<f:select id="tipoDocumentoPaciente"
								path="persona.tipoDocumento.codReg" required="required"
								class="form-control"> 
								<f:options items="${lstDocumento}" itemValue="codReg"
									itemLabel="nombreCorto" />
							</f:select>
						</div>
					</div>
					<div class="form-group col-md-4 mb-2">
						<label for="exampleInputName" class="label_control">N° DOCUMENTO <span class="required">*</span>
						</label>
						<div class="position-relative has-icon-left">
							<f:input type="hidden" path="codigo" id="codigoReferenciaBean"
								val="" />
							<input id="contextPath" type="hidden"
								value="${pageContext.request.contextPath}">
							<div class="controls">
								<f:input type="text" class="form-control" required="required"
									maxlength="12" id="nroDocumentoPaciente"
									path="persona.nroDocumento"
									onkeypress="return runScript(event)" />
							</div>
						</div>
					</div>
					
					<div class="col-md-4">
						<br>
						<button id="idBtnCargarPaciente" type="button"
							style="margin-top: 5px;" onclick="buscarPacienteSISWebService()"
							class="form-control btn btn-info">
							<i class="ft-search"></i> BUSCAR
						</button>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-4 mb-2">
						<label for="nombreCompleto" class="label_control">APELLIDO PATERNO <span class="required">*</span>
						</label>
						<div class="controls">
							<f:input type="text" class="form-control" required="required"
								id="personaApellidoPaterno" path="persona.apellidoPaterno" />

						</div>
					</div>
					<div class="form-group col-md-4 mb-2">
						<label for="nombreCompleto" class="label_control">APELLIDO
							MATERNO </label>
						<div class="controls">
							<f:input type="text" class="form-control"
								id="personaApellidoMaterno" path="persona.apellidoMaterno" />

						</div>
					</div>
					<div class="col-md-4 mb-2">
						<label for="situacion" class="label_control">SEXO <span
							class="required">*</span></label>
						<div class="controls">
							<f:select id="sexoPaciente" path="persona.sexo.codReg"
								class="form-control" required="required">
								<f:option value="" label="Seleccionar" selected="true"
									disabled="disabled" />
								<f:options items="${lstSexo}" itemValue="codReg"
									itemLabel="nombreCorto" />
							</f:select>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-4 mb-2">
						<label for="nombreCompleto" class="label_control">PRIMER
							NOMBRE <span class="required">*</span>
						</label>
						<div class="controls">
							<f:input type="text" class="form-control" required="required"
								id="personaPrimerNombre" path="persona.primerNombre" />

						</div>
					</div>
					<div class="form-group col-md-4 mb-2">
						<label for="nombreCompleto" class="label_control">SEGUNDO
							NOMBRE </label>
						<div class="controls">
							<f:input type="text" class="form-control"
								id="personaSegundoNombre" path="persona.segundoNombre" />

						</div>
					</div>
					<div class="col-md-4 mb-2">
						<label for="exampleInputName" class="label_control">FECHA
							NACIMIENTO <span class="required">*</span>
						</label>
						<div class="controls">
							<fmt:formatDate value="${fechaHasta}" var="dateString"
								pattern="dd/MM/yyyy" />
							<f:input id="personaFechaNac" name="fecha" type="text"
								class="form-control" path="persona.fechaNac"
								value="${dateString}" size="10" maxlength="10"
								required="required"
								onkeyup="this.value=formateafechaNacimiento(this.value);" />
						</div>
					</div>
				</div> 
				<div class="row">
					<div class="col-md-4">
						<label for="lbltipoSeguroPaciente"  class="label_control">FINANCIADOR<span
							class="required">*</span></label>
						<div class="controls">
							<f:select id="tipoSeguroPaciente" path="tipoSeguro.codReg"
								class="form-control" required="required" onchange="validartipoSeguro()">
								<f:option value="" label="Seleccionar" selected="true"
									disabled="disabled" />
								<f:options items="${lstTipoSeguro}" itemValue="codReg"
									itemLabel="nombreCorto" />
							</f:select>
						</div>
					</div>
					<div class="col-md-4">
						<label for="lblcategoriaPaciente" id="lblcategoriaPaciente" class="label_control">CATEGORIA
						</label>
						<f:input type="text" class="form-control" id="categoriaPaciente"
							path="categoriaSeguro" />
					</div>
					<div class="col-md-4">
						<label for="exampleInputName" id="lblcodigoFiliacionPaciente" class="label_control">N°
							AFILIACION </label>
						<f:input type="text" class="form-control"
							id="codigoFiliacionPaciente" path="codigoFiliacion" />
					</div>
				</div> 
				<br>
				<div class="row">
				<div class="col-md-4"> 
				<img id ="imgFotoPaciente" src="${pageContext.request.contextPath}/assets/img/fotoPersonaGenerico.gif"  height="80%" width="80%" class="img-responsive"  /> 
		<!-- 	<c:choose>
				<c:when
					test="${paciente.persona.fotoCadena==null || persona.fotoCadena ==''}"> 
					<img id ="imgFotoPaciente" src="${pageContext.request.contextPath}/assets/img/fotoPersonaGenerico.gif" alt="Image" class="img-responsive">
				</c:when>
				<c:otherwise>
					<img id ="imgFotoPaciente" align="bottom" height="200" width="200" src="data:image/png;base64,${persona.fotoCadena}" /> 
				</c:otherwise>
			</c:choose>
				 -->		
						<!-- <img align="bottom" height="200" width="200" src="c:/filetemerluzasp.jpg"> -->
				</div>
				</div>
			</div>
			<div class="modal-footer"> 
				<button type="button" onclick="limpiar()"
					class="btn btn-default"><i class="fa fa-eraser"></i> LIMPIAR</button>
					
				<button type="button" id="btnCerrarModalPaciente"
					class="btn btn-secondary" data-dismiss="modal"><i class="fa fa-close"></i> CERRAR </button>
					
				<button type="submit" onclick="enviarPaciente()"
					class="btn btn-primary">  ACEPTAR  </button>
			</div>



		</f:form>
	</div>
	<script
	src="${pageContext.request.contextPath}/assets/js/page/asistencial/referencia.js"
	type="text/javascript" charset="utf-8"></script>
<script
	src="${pageContext.request.contextPath}/assets/js/page/util/utilitarios.js"
	type="text/javascript" charset="utf-8"></script>

<script type="text/javascript">

	$(document).ready(function(){
		habilitar();
	});

function habilitar(){ 
	
	document.getElementById('personaApellidoPaterno').disabled = true; 
	document.getElementById('personaApellidoMaterno').disabled = true;
	document.getElementById('sexoPaciente').disabled = true;
	document.getElementById('personaPrimerNombre').disabled = true;
	document.getElementById('personaSegundoNombre').disabled = true;
	document.getElementById('personaFechaNac').disabled = true;
	document.getElementById('tipoSeguroPaciente').disabled = true;
	document.getElementById('categoriaPaciente').disabled = true;
	document.getElementById('codigoFiliacionPaciente').disabled = true;
	 
	 $("#nroDocumentoPaciente").focus(); 
}	

function validartipoSeguro(){
	
	if ($('#tipoSeguroPaciente').val() == '000003') {
	   document.getElementById('categoriaPaciente').style.display = 'block';
  	   document.getElementById('codigoFiliacionPaciente').style.display = 'block';
  	   document.getElementById('lblcodigoFiliacionPaciente').style.display = 'block';
  	   document.getElementById('lblcategoriaPaciente').style.display = 'block';
	}else{
	   document.getElementById('categoriaPaciente').style.display = 'none';
  	   document.getElementById('codigoFiliacionPaciente').style.display = 'none';
  	   document.getElementById('lblcodigoFiliacionPaciente').style.display = 'none';
  	   document.getElementById('lblcategoriaPaciente').style.display = 'none';
		$('#categoriaPaciente').val("");
		$('#codigoFiliacionPaciente').val(""); 
	}
}

function limpiar(){
	 $('#tipoDocumentoPaciente').val("000002");
	 $('#nroDocumentoPaciente').val("");
	 $('#personaApellidoPaterno').val("");
	 $('#personaApellidoMaterno').val("");
	 $('#sexoPaciente').val(""); 
	 $('#personaPrimerNombre').val("");
	 $('#personaSegundoNombre').val("");
	 $('#personaFechaNac').val("");
	 $('#tipoSeguroPaciente').val("");
	 $('#categoriaPaciente').val("");
	 $('#codigoFiliacionPaciente').val(""); 
	 $("#nroDocumentoPaciente").focus(); 
	 
	 var image = new Image();
     var src = "${pageContext.request.contextPath}/assets/img/fotoPersonaGenerico.gif";
     
     image.src = src;
     image.alt = "Image";
     
     $("#imgFotoPaciente").attr("src", image.src);
     
     
}

function runScript(e) {
    //See notes about 'which' and 'key'
    if (e.keyCode == 13) {
    	iniciarBloqueo();
    	buscarPacienteSISWebService();
    	finBloqueo();
        return false;
    }
}


//	$(document).ready(function() {
	//	$("#nroDocumentoPaciente").keyup(function(event) { 
	//		if (event.keyCode === 13) { 
	//			buscarPacienteSISWebService();
	//		}
//		});
//	});
</script>
</div>



