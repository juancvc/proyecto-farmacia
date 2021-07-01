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
	href="${pageContext.request.contextPath}/app-assets/vendors/css/extensions/toastr.css">

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/assets/css/datepicker.css">	
<div class="modal-dialog modal-sm" role="document">
	<div class="modal-content">
	
		<div class="modal-header">
			<label class="modal-title text-text-bold-600" id="myModalLabel35"><b>ASIGNAR TURNO ALMACEN</b></label>
			<button type="button" class="close" data-dismiss="modal"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
		</div>

		<f:form id="frmAgregarArticulos" class="form-horizontal" role="form"
			method="post" action="" onsubmit="return false">
			<input id="contextPath" type="hidden"
				value="${pageContext.request.contextPath}">
				  
			<div class="modal-body" id="buscaPaciente">
				 
			<div class="row">
				<div class="col-md-4 mb-1"> 
				<label for="nombreCompleto" class="label_control">MAÑANA</label> 
				<input type="checkbox"  name="chkDia" id="chkDia"/>
				</div>
				 <div class="col-md-4 mb-1"> 
				<label for="nombreCompleto" class="label_control">TARDE</label> 
				<input type="checkbox"  name="chkTarde" id="chkTarde"/>
				</div>
				<div class="col-md-4 mb-1"> 
				<label for="nombreCompleto" class="label_control">NOCHE</label> 
				<input type="checkbox"  name="chkNoche" id="chkNoche"/>
				</div>
				<f:input type="hidden" path="usuarioAlmacen.codigo" id="txtIdUsarioAlmacen" />
			</div>

			</div>
			<div class="modal-footer">
				<button type="button" id="btnCerrarModalPaciente"
					class="btn btn-secondary" data-dismiss="modal">
					<i class="fa fa-close"></i> CERRAR
				</button>
				<button type="submit" onclick="grabarTurnoAlmacen()"
					class="btn btn-primary">
					<i class="fa fa-check"></i> GRABAR
				</button>
			</div>



		</f:form>
	</div>
		<script
			src="${pageContext.request.contextPath}/assets/js/page/util/datepicker.js"
			type="text/javascript" charset="utf-8"></script>
			
		<script
			src="${pageContext.request.contextPath}/assets/js/page/util/block.js"
			type="text/javascript" charset="utf-8"></script>
				
		<script
			src="${pageContext.request.contextPath}/assets/js/page/util/datepicker.es.min.js"
			type="text/javascript" charset="utf-8"></script>	
			
		<script
			src="${pageContext.request.contextPath}/assets/js/page/util/utilitarios.js"
			type="text/javascript" charset="utf-8"></script>
			
		<script
			src="${pageContext.request.contextPath}/app-assets/vendors/js/extensions/toastr.min.js"
			type="text/javascript"></script>

		<script
			src="${pageContext.request.contextPath}/app-assets/vendors/js/extensions/sweetalert.min.js"
			type="text/javascript"></script>
		<script
			src="${pageContext.request.contextPath}/app-assets/js/scripts/extensions/sweet-alerts.js"
			type="text/javascript"></script>	
		<script src="${pageContext.request.contextPath}/assets/js/scripts.js"
			type="text/javascript"></script>

<script> 
	<c:forEach var="almacen" items="${lstTurnoAlmacen}"
		varStatus="loop">
	var objTurno = {
			codigo : "",
			nombre : ""
	  	}; 
	objTurno.codigo ='${almacen.turno.codigo}';
	if (objTurno.codigo == "0001") {
		document.getElementById("chkDia").checked = true;
	}else if (objTurno.codigo == "0002") {
		document.getElementById("chkTarde").checked = true;
	}else if (objTurno.codigo == "0003") {
		document.getElementById("chkNoche").checked = true;
	}
	
	</c:forEach>
</script> 
	</div>
