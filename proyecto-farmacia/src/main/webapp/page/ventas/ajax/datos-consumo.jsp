<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link
	href="${pageContext.request.contextPath}/app-assets/vendor/datatables/dataTables.bootstrap4.css"
	rel="stylesheet">

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/vendors/css/tables/datatable/dataTables.bootstrap4.min.css">
	
	
<div class="collapse show" id="collapseCardExample">
	<div class="card-body">
		<div class="form-group">
			<div class="table-responsive">
				<table class="table table-bordered" id="dataTable" width="100%"
					cellspacing="0">
					<thead>
						<tr class="tabla_th">
							<th>ITEM</th>
							<th>DESCRIPCION</th>
							<th>CONCENTRACION</th>
							<th>PRESENTACION</th>
							<th>COD SISMED</th>
							<th>ACCIONES</th>
						</tr>
					</thead>
					<tfoot>
					<tbody class="tabla_td">
						<c:forEach var="articulo" items="${lstArticulos}" varStatus="loop">
							<tr>
								<td>${loop.count}</td>
								<td>${articulo.nombre}</td>
								<td>${articulo.concentracion}</td>
								<td>${articulo.tipoPresentacion.descripcionLarga}</td>
								<td>${articulo.codigoSismed}</td>
								<td><a title="Modificar" data-placement="top"
									data-toggle="tooltip" class="btn btn-outline-success btn-sm"
									onclick="javascript:modificarElementoGenerico('/articuloController/modificar','${loop.index}')"
									href="#"><i class="fas fa-pencil-alt"></i></a>

									<button type='button' class='btn btn-outline-danger btn-sm'
										data-toggle='tooltip' data-placement='top' title='Eliminar'
										onclick="confirmar_eliminar(${loop.count});"
										data-original-title='Eliminar' id='agregarEspecialidad'>
										<i class='fas fa-trash'></i>
									</button></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>



<script
	src="${pageContext.request.contextPath}/app-assets/vendor/datatables/jquery.dataTables.js"></script>
<script
	src="${pageContext.request.contextPath}/app-assets/vendor/datatables/dataTables.bootstrap4.js"></script>

<script
	src="${pageContext.request.contextPath}/app-assets/js/sb-admin-datatables.min.js"></script>
