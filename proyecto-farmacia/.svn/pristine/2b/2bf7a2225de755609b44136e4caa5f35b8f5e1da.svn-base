<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link
	href="${pageContext.request.contextPath}/app-assets/vendor/datatables/dataTables.bootstrap4.css"
	rel="stylesheet">
 
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/vendors/css/tables/datatable/dataTables.bootstrap4.min.css">
	
	
	<table class="table table-bordered" id="dataTable">
									<thead class="tabla_th">
										<tr>
											<th width="30">ITEM</th>
											<th>CODIGO</th>
											<th>NOMBRE POSTULANTE</th>
											<th>NOMBRE CAMPAÑA</th>
											<th>FECHA/HORA REGISTRO</th> 
											<th>USUARIO REGISTRO</th>
											<th>ACCIONES</th>
										</tr>
									</thead>
									<tbody id="idBodyListaPostulante">
										<c:forEach var="postulante" items="${lstPostulanteBean}" varStatus="loop">
											<tr>
												<td>${loop.count}</td>
												<td>${postulante.codigo}</td>
												<td>${postulante.persona.nombreCompleto}</td>
												<td>${postulante.campania.lugarCampaniaBean.nombre}</td>
												<td><fmt:formatDate pattern="dd/MM/yyyy HH:mm" value="${postulante.fechaCreacion}" /></td> 
												<td>${postulante.nombreUsuarioCreacion}</td>
												<td><a title="Modificar" data-placement="top"
														data-toggle="tooltip"
														class="btn btn-outline-success btn-sm"
														onclick="javascript:modificarElementoGenerico('/bancoController/modificarPostulante','${loop.index}')"
														href="#"><i class="icon-pencil"></i></a> <!--   <a title="Eliminar" data-placement="top" data-toggle="tooltip"
                                                         class="btn btn-outline-danger btn-sm" href="eliminar?codigo=${lenguaBean.codigo}"><i class="icon-trash"></i></a> -->

														<button type="button"
															class="btn btn-outline-danger btn-sm eliminarPerfil"
															data-toggle="tooltip" data-placement="top" title=""
															onclick="confirmar_accion(3,'${loop.index}')"
															data-original-title="Eliminar"
															id="eliminarPerfil${loop.index}">
															<i class="icon-trash"></i>
												</button></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
	
<script
	src="${pageContext.request.contextPath}/app-assets/vendor/datatables/jquery.dataTables.js"></script>
<script
	src="${pageContext.request.contextPath}/app-assets/vendor/datatables/dataTables.bootstrap4.js"></script>
	
<script
	src="${pageContext.request.contextPath}/app-assets/js/sb-admin-datatables.min.js"></script>	