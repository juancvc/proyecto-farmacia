<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<link
	href="${pageContext.request.contextPath}/app-assets/vendor/datatables/dataTables.bootstrap4.css"
	rel="stylesheet">
 
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/app-assets/vendors/css/tables/datatable/dataTables.bootstrap4.min.css">
	<f:form id="frmListadoDetalle" class="form-horizontal" role="form"
					method="post" action="" onsubmit="return false">
	
<div class="table-responsive_">
											<table id ="tabla"  class="table table-bordered">
												<thead class="tabla_th">
													<tr>
														<th width="70">ITEM</th>
														<th>UNIDAD</th>
														<th>OBSERVACION</th>
														<th>VALOR INICIAL</th>
														<th>VALOR FINAL</th>
														<th width="60">ACCION</th>
													</tr>
												</thead>
												<tbody id="idbodyCIEXref" class="label_control">
													<c:forEach var="tabla" items="${lstTarifarioDetalleBean}"
														varStatus="loop">
														<tr>
															<td>${loop.count}</td>
															<td><div class="controls">
																	<f:input type="text" min="1" maxlength="20"  required="required"
																		class="form-control" value="${tabla.unidades}"
																		id="tarifarioUnidades${loop.index}" path="lstTarifarioDetalleBean[${loop.index}].unidades" />

																</div></td>
															<td><div class="controls">
																	<f:input type="text" min="1" maxlength="20"
																		class="form-control" value="${tabla.observacion}"
																		id="tarifarioUnidades${loop.index}" path="lstTarifarioDetalleBean[${loop.index}].observacion" />

																</div></td>
															<td><div class="controls">
																	<f:input type="text" maxlength="30"
																		class="form-control" required="required" value="${tabla.valoresRefIni}"
																		id="tarifarioValorInicial${loop.index}" path="lstTarifarioDetalleBean[${loop.index}].valoresRefIni" />

																</div></td>
															<td><div class="controls">
																	<f:input type="text" maxlength="30"
																		class="form-control" required="required" value="alicia"
																		id="tarifarioValorFinal${loop.index}" path="lstTarifarioDetalleBean[${loop.index}].valoresRefFin" />

																</div></td> 
																	<td><button type='button'
																			class='btn btn-outline-danger btn-sm'
																			data-toggle='tooltip' data-placement='top'
																			title='Eliminar'
																			onclick='confirmar_eliminar(${loop.index})'
																			data-original-title='Eliminar' id='eliminarDX'>
																			<i class='icon-trash'></i>
																		</button></td> 
														</tr>
													</c:forEach>
												</tbody>
											</table>
										</div>
	</f:form>
<script
	src="${pageContext.request.contextPath}/app-assets/vendor/datatables/jquery.dataTables.js"></script>
<script
	src="${pageContext.request.contextPath}/app-assets/vendor/datatables/dataTables.bootstrap4.js"></script>
	
<script
	src="${pageContext.request.contextPath}/app-assets/js/sb-admin-datatables.min.js"></script>	