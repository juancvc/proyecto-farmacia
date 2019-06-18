<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

 
<style>
* {
	font-size: 12px;
	font-family: 'Times New Roman';
}

td, th, tr, table {
	border-top: 1px solid black;
	border-collapse: collapse;
}

td.producto, th.producto {
	width: 75px;
	max-width: 75px;
}

td.cantidad, th.cantidad {
	width: 40px;
	max-width: 40px;
	word-break: break-all;
}

td.precio, th.precio {
	width: 40px;
	max-width: 40px;
	word-break: break-all;
}

.centrado {
	text-align: center;
	align-content: center;
}

.ticket {
	width: 155px;
	max-width: 155px;
}

img {
	max-width: inherit;
	width: inherit;
}
 
@media print{
  .oculto-impresion, .oculto-impresion *{
    display: none !important;
  }
}
</style>
<div class="modal-dialog modal-lg" role="document">
	<div class="modal-content">
		<div class="modal-header">
			<label class="modal-title text-text-bold-600" id="myModalLabel35"><b>TICKET</b></label>
			<button type="button" class="close" data-dismiss="modal"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
		</div>

		<f:form id="frmGuardarInstDirector" class="form-horizontal"
			role="form" method="post">
			<div class="form-body">
				<input id="contextPath" type="hidden"
					value="${pageContext.request.contextPath}">


				<div class="modal-body" id="buscarCIE10">
					<div class="row">
						<div class="card-body">
							<div class="ticket">
								<img id="barcode1" />
								<p class="centrado">
									APPS PERFECTAS <br>5 de mayo #1006 <br>23/08/2017
									08:22 a.m.
								</p>
								<table>
									<thead>
										<tr>
											<th class="cantidad">CANT</th>
											<th class="producto">PRODUCTO</th>
											<th class="precio">$$</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td class="cantidad">1.00</td>
											<td class="producto">CHEETOS VERDES 80 G</td>
											<td class="precio">$8.50</td>
										</tr>
										<tr>
											<td class="cantidad">2.00</td>
											<td class="producto">KINDER DELICE</td>
											<td class="precio">$10.00</td>
										</tr>
										<tr>
											<td class="cantidad">1.00</td>
											<td class="producto">COCA COLA 600 ML</td>
											<td class="precio">$10.00</td>
										</tr>
										<tr>
											<td class="cantidad"></td>
											<td class="producto">TOTAL</td>
											<td class="precio">$28.50</td>
										</tr>
									</tbody>
								</table>
								<p class="centrado">
									¡GRACIAS POR SU COMPRA! <br>appsperfectas.com
								</p>
							</div>
							<button class="oculto-impresion" onclick="imprimir()">Imprimir</button>
						</div>
					</div>

				</div>
				<div class="modal-footer">
					<button type="button" id="btnCerrarmodalApoyoDX"
						class="btn btn-secondary" data-dismiss="modal">
						<i class="fa fa-close"></i> CERRAR
					</button>
				</div>
			</div>
		</f:form>
	</div>
</div>
 
<script>
	$(document).ready(function() {
		JsBarcode("#barcode1", "BS2018007902");

	});
	
	function imprimir() {
		  window.print();
		}
</script>