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
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/fonts/feather/style.min.css">


<div class="modal-dialog modal-lg" role="document">
	<div class="modal-content">

		<div class="modal-header">
			<label class="modal-title text-text-bold-600" id="myModalLabel35"><b>LISTADO
					DE ESTABLECIMIENTOS</b></label>
			<button type="button" class="close" data-dismiss="modal"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
		</div>

		<f:form id="frmBuscarEstablecimiento" class="form-horizontal"
			role="form" method="post"
			action="establecimientoModal"
			onsubmit="return false">
			<input id="contextPath" type="hidden"
				value="${pageContext.request.contextPath}">

			<f:input id="codigoUsuarioReanes" type="hidden" path="codigoDisa"
				value="" />
			<f:input id="codigoPersona" type="hidden" path="codigoRed" value="" />

			<div class="modal-body" id="buscarCIE10">

				<div class="row">
					<div class="col-md-8">
						<label for="exampleInputName" class="label_control">NOMBRE
							DE ESTABLECIMIENTO</label>
						<f:input type="text" class="form-control" id="nombreEstablecimiento"
							path="nomRenaes" />
					</div>
					<div class="col-md-4 ">
						<label for="exampleInputName" class="label_control">CATEGORIA
						</label>
						<div class="controls">
							<f:select id="comboCategoria" path="categoria.codReg"
								class="form-control">
								<f:option value="" label="Seleccionar" selected="true"
									disabled="disabled" />
								<f:options items="${lstCategoria}" itemValue="codReg"
									itemLabel="nombreCorto" />
							</f:select>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12 text-right ">
						<div class="botonDA" style="margin-top: 20px;margin-bottom: 20px;">
							<button id="btn-save-reg" type="button" class="btn btn-info"
								onclick="listarEstablecimiento()">
								<i class="ft-search"></i> BUSCAR
							</button>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="card-body">
						<div class="table-responsive">
							<div id="div1">
								<table class="table table-bordered" id="dataTable"
									style="overflow-y: scroll">
									<thead class="tabla_th">
										<tr>
											<th width="70">ITEM</th>
											<th>CODIGO</th>
											<th>NOMBRE ESTABLECIMIENTO</th>
											<th>CATEGORIA</th>
											<th>DEPARTAMENTO</th>
											<th>PROVINCIA</th>
											<th>DISTRITO</th>
											<th width="80">ACCION</th>
										</tr>
									</thead>
									<tbody id="idBodyListaEstablecimiento" class="label_control">
										<c:forEach var="renaes" items="${lstRenaesBean}"
											varStatus="loop">
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
														onclick="cargarEstablecimientoUsuario('${renaes.codRenaes}');"
														data-original-title="Seleccionar"
														id="agregarEstablecimiento">
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

				<button type="button" class="btn btn-secondary"
					id="btnCerrarModalEstabUsu" data-dismiss="modal"><i class="fa fa-close"></i> CERRAR</button>

			</div>
		</f:form>
	</div>
</div>

<script>
$("#nombreEstablecimiento").keyup(function(event) {
    if (event.keyCode === 13) {
    	listarEstablecimiento();
    }
});


</script>