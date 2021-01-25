<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

 
	<table class="table table-bordered" id="dataTable">
								<thead class="tabla_th">
									<tr>
										<th width="50">ITEM</th>
										<th>NRO DOCUMENTO</th>
										<th>FECHA EMISION</th>
										<th width="200">NOMBRE ARTICULO</th>
										<th width="50"># LOTE</th>
										<th width="50">CANTIDAD ADQUIRIDA</th>
										<th width="50">CANTIDAD DEVUELTA</th>
										<th width="50">CANTIDAD CONSUMIDA</th>
										<th>PRECIO (S/.)</th>
										<th>SUB TOTAL</th>
									</tr>
								</thead>
								<tbody id="idBodyListaCIEX" class="label_control">
									<c:forEach var="objVentaItem" items="${lstVentasItemDevolucion}"
										varStatus="loop">
										<tr>
											<td>${loop.count}</td>
											<td><span id="${objVentaItem.venta.codigo}"> ${objVentaItem.venta.numero} </span></td>
											<td><fmt:formatDate pattern="dd/MM/yyyy" value="${objVentaItem.venta.fechaEmision}"/></td>
											<td><span  id="${objVentaItem.stock.codigo}" >
											 ${objVentaItem.stock.articulo.nombre}</span></td>
											 <td><span>${objVentaItem.stock.lote}</span></td>
											<td><input type='text' class='form-control' id="txtAdquirida${objVentaItem.codigo}"
												 required='required' value ='${objVentaItem.cantidad}' 
												 maxlength='3' onkeypress="return soloNumeros(event);" 
												 disabled="disabled"/></td>
											<td><input type='text' class='form-control' id="txtDevolucion${objVentaItem.codigo}"
												 required='required' value ='0' 
												 maxlength='3' onkeypress="return soloNumeros(event);" />
											</td>
											<td><input type='text' class='form-control' id="txtConsumo${objVentaItem.codigo}"
												 required='required' value ='${objVentaItem.cantidadConsumida}' 
												 maxlength='3' onkeypress="return soloNumeros(event);" 
												 disabled="disabled"/></td>
											<td><span>${objVentaItem.stock.sPrecio}</span></td>	
											<td>${objVentaItem.sSubTotal}</td> 
										</tr>
									</c:forEach>
								</tbody>
							</table>
	