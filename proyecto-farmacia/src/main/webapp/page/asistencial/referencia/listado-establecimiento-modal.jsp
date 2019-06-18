<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>


<link
	href="https://fonts.googleapis.com/css?family=Montserrat:300,300i,400,400i,500,500i%7COpen+Sans:300,300i,400,400i,600,600i,700,700i"
	rel="stylesheet">

<link
	href="${pageContext.request.contextPath}/app-assets/css/estilos-cayetano.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/app-assets/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/fonts/simple-line-icons/style.css">
	
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/fonts/simple-line-icons/style.min.css">
 <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/fonts/feather/style.min.css">		
 

<div class="modal-dialog modal-lg" role="document">
	<div class="modal-content">
		<div class="modal-header">
			<label class="modal-title text-text-bold-600" id="myModalLabel35"><b>Listado
					de Establecimientos</b></label>
			<button type="button" class="close" data-dismiss="modal"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
		</div>

		<f:form id="frmGuardarInstDirector" class="form-horizontal"
			role="form" method="post"
			action="${pageContext.request.contextPath}/personaController/guardar">
			<input id="contextPath" type="hidden"
				value="${pageContext.request.contextPath}">


			<div class="modal-body" id="buscarCIE10">
				<div class="row">
					<div class="card-body">
						<div class="table-responsive">
						<div id="div1">
							<table class="table table-bordered" id="dataTable" style="overflow-y: scroll">
								<thead class="tabla_th">
									<tr>
										<th width="70">Item</th>
										<th>Código</th>
										<th>Nombre Establecimientos</th>
										<th>Categoría</th>
										<th>Departamento</th>
										<th>Provincia</th>
										<th>Distrito</th>
										<th width="80">Acci&oacute;n</th>
									</tr>
								</thead>
								<tbody id="idBodyListaInstLengua" class="label_control"> 
									<c:forEach var="renaes"
											items="${lstRenaesBean}" varStatus="loop">
											<tr>
											<td>${loop.count}</td>
											<td>${renaes.codigoRenaes}</td>
											<td>${renaes.nomRenaes}</td>
											<td>${renaes.categoria.nombreCorto}</td>
											<td>${renaes.deptRenaes}</td>
											<td>${renaes.provRenaes}</td>
											<td>${renaes.distrRenaes}</td>
											<td><button type="button"
													class="btn btn-outline-success btn-sm"
													data-toggle="tooltip" data-placement="top" title=""
													onclick="llenarEstablecimientoOrigen('${renaes.nomRenaes}','${renaes.codRenaes}');"
													data-original-title="Seleccionar" id="agregarEstablecimiento">
													<i class="icon-check"></i>
												</button></td>
										</tr>

										</c:forEach> 
								</tbody>
							</table>
						  </div>
						</div>
					</div>
				</div>
			</div>
			<div class="modal-footer">

				<button type="button" class="btn btn-secondary" id="btnCerrarModalEstab" data-dismiss="modal">Cerrar</button>
				<button type="button" class="btn btn-primary">Aceptar</button>
			</div>
		</f:form>
	</div>
</div> 