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
					DE PERSONA</b></label>
			<button type="button" class="close" data-dismiss="modal"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
		</div>

		<f:form id="frmGuardarPersonal" class="form-horizontal"
			role="form" method="post"
			action=""
			onsubmit="return false">
			<input id="contextPath" type="hidden"
				value="${pageContext.request.contextPath}">

			<f:input class="form-control" type="hidden"
				id="personalNombreCompleto" path="persona.nombreCompleto" /> 
				
			<f:input type="hidden" class="form-control" id="personalCodigo"
				path="persona.codigo" /> 
			
			<input type="hidden" class="form-control" id="tipoLlamdoPersonal"  /> 
					
			<div class="modal-body" id="buscaPersonal">
				<div class="row">
					<div class="form-group col-md-4 mb-2">
						<label for="situacion" class="label_control">TIPO
							DOCUMENTO <span class="required">*</span> </label>
						<div class="controls">
							<f:select id="tipoDocumentoPersonal"
								path="persona.tipoDocumento.codReg" 
								required="required" 
								class="form-control">
								<f:option value="" label="Seleccionar" selected="true"
									disabled="disabled" />
								<f:options items="${lstDocumento}" itemValue="codReg"
									itemLabel="nombreCorto" />
							</f:select>
						</div>
					</div>
					<div class="form-group col-md-4 mb-2">
						<label for="exampleInputName" class="label_control">N°
							DOCUMENTO  <span class="required">*</span></label>
						<div class="position-relative has-icon-left">
							<f:input type="hidden" path="codigo" id="codigoReferenciaBean"
								val="" />
							<input id="contextPath" type="hidden"
								value="${pageContext.request.contextPath}">
							<div class="controls">
								<f:input type="text" class="form-control" required="required"  maxlength="12"
									id="nroDocumentoPersonal" path="persona.nroDocumento" />
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<br>
						<button id="idBtnCargarPersonal" type="button" style="margin-top: 5px;"
							onclick="buscarPersonal()"
							class="form-control btn btn-secondary"><i class="ft-search"></i> BUSCAR</button>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-5 mb-2">
						<label for="nombreCompleto" class="label_control">APELLIDO
							PATERNO <span class="required">*</span></label>
						<div class="controls">
							<f:input type="text" class="form-control" required="required" 
								id="personalApellidoPaterno" path="persona.apellidoPaterno" />

						</div>
					</div>
					<div class="form-group col-md-5 mb-2">
						<label for="nombreCompleto" class="label_control">APELLIDO
							MATERNO </label>
						<div class="controls">
							<f:input type="text" class="form-control"
								id="personalApellidoMaterno" path="persona.apellidoMaterno" />

						</div>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-5 mb-2">
						<label for="nombreCompleto" class="label_control">PRIMER
							NOMBRE <span class="required">*</span></label>
						<div class="controls">
							<f:input type="text" class="form-control" required="required"
								id="personalPrimerNombre" path="persona.primerNombre" />

						</div>
					</div>
					<div class="form-group col-md-5 mb-2">
						<label for="nombreCompleto" class="label_control">SEGUNDO
							NOMBRE </label>
						<div class="controls">
							<f:input type="text" class="form-control"
								id="personalSegundoNombre" path="persona.segundoNombre" />

						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-5 mb-2">
						<label for="situacion" class="label_control">SEXO <span class="required">*</span></label>
						<div class="controls">
							<f:select id="sexoPersonal" path="persona.sexo.codReg"
								class="form-control" required="required">
								<f:option value="" label="Seleccionar" selected="true"
									disabled="disabled" />
								<f:options items="${lstSexo}" itemValue="codReg"
									itemLabel="nombreCorto" />
							</f:select>
						</div>
					</div>
					<div class="col-md-5 mb-2">
						<label for="exampleInputName" class="label_control">FECHA
							NACIMIENTO </label>
						<div class="controls">
							<fmt:formatDate value="${fechaHasta}" var="dateString"
								pattern="dd/MM/yyyy" />
							<f:input id="personalFechaNac" name="fecha" type="text"
								class="form-control" path="persona.fechaNac" value="${dateString}"
								size="10" maxlength="10"
								onkeyup="this.value=formateafechaNacimiento(this.value);" />
						</div>
					</div>
				</div> 
			</div>
			<div class="modal-footer">

				<button type="button" id="btnCerrarModalPersonal"
					class="btn btn-secondary" data-dismiss="modal"><i class="fa fa-close"></i> CERRAR</button>
				<button type="submit" onclick="enviarPersonal()"
					class="btn btn-primary">ACEPTAR</button>
			</div>
		</f:form>
	</div>
</div>
<script
	src="${pageContext.request.contextPath}/assets/js/page/asistencial/referencia.js"
	type="text/javascript" charset="utf-8"></script>
<script 
	src="${pageContext.request.contextPath}/assets/js/page/util/utilitarios.js"
	type="text/javascript" charset="utf-8"></script>
	
	<script>

	function enviarPersonal(){   
		var contextPath = $('#contextPath').val();
		var myFormulario = $('#frmGuardarPersonal'); 
		var personalFechaNac = $('#personalFechaNac').val(); 
		var llamadoPersonal = $('#tipoLlamdoPersonal').val(); 
		
		if(!myFormulario[0].checkValidity()) {
					 msg_advertencia("Debe completar los campos requeridos(*) correctamente");
					 return;
		} else 	if(personalFechaNac != ""){
				if(personalFechaNac.length < 10){
					 msg_advertencia("Ingrese fecha de nacimiento correcta."); 
					 return;
				}
		} 
		
		console.log("llenarPersonal " + llamadoPersonal);
			var url = contextPath + "/referenciaController/llenarPersonal?tipo="+llamadoPersonal;
			//	iniciarBloqueo();
				$.ajax({
				type : "GET",
				url : url,
				data: $('#frmGuardarPersonal').serialize(),
				success : function(data) {
					if(llamadoPersonal == 1){
						$('#nombreCompletoResponsableEstablecimiento').val(data.persona.nombreCompleto);
					}else{
						$('#nombreCompletoPersonalAcompanante').val(data.persona.nombreCompleto);
					}
					 $("#btnCerrarModalPersonal").trigger("click");
				},error: function(xhr,status,er) {
		        console.log("error: " + xhr + " status: " + status + " er:" + er);
			    if(xhr.status==500) {
			    	console.log(er);
			    	// Error_500(er);
			    }
			    if(xhr.status==901) {
		    	console.log(er);
		    	// spire_session_901(er);  
			    		}
					}
			    });
			 
	}

	
	</script>		
			
			