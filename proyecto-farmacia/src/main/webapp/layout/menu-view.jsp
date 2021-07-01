<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="proyect.core.bean.seguridad.UsuarioBean"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<link
	href="${pageContext.request.contextPath}/app-assets/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">


<ul
	class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
	id="accordionSidebar">

	<!-- Sidebar - Brand -->
	<a
		class="sidebar-brand d-flex align-items-center justify-content-center"
		href="${pageContext.request.contextPath}/inicioController/portada">
		<div class="sidebar-brand-icon rotate-n-15"></div> <!--   <i class="fas fa-laugh-wink"></i> <div class="sidebar-brand-text mx-3">SB Admin <sup>2</sup></div> -->
		<div class="sidebar-brand-text mx-3">FARMACIA</div>
	</a>

	<!-- Divider -->
	<hr class="sidebar-divider my-0">

	<!-- Nav Item - Dashboard 
      <li class="nav-item active">
        <a class="nav-link" href="index.html">
          <i class="fas fa-fw fa-tachometer-alt"></i>
          <span>Dashboard</span></a>
      </li>
	-->
	<!-- Divider -->
	<hr class="sidebar-divider">

	<!-- Heading -->
	<li class="nav-item" data-toggle="tooltip" data-placement="right"
		title="Dashboard"><a class="nav-link"
		href="${pageContext.request.contextPath}/inicioController/portada">
			<i class="fa fa-dashboard"></i> <span class="nav-link-text">Dashboard</span>
	</a></li>
	<div class="sidebar-heading">SALIDAS</div>

	<!-- Nav Item - Pages Collapse Menu -->
	<c:if test="${accesoMenu.menu_Venta}">
		<li id="navVentas" class="nav-item"><a id="collVentas"
			class="nav-link collapsed" href="#" data-toggle="collapse"
			data-target="#collapseVentas" aria-expanded="true"
			aria-controls="collapseVentas"> <i class="fas fa-fw fa-cog"></i>
				<span>Ventas</span>
		</a>
			<div id="collapseVentas" class="collapse"
				aria-labelledby="headingTwo" data-parent="#accordionSidebar">
				<div class="bg-white py-2 collapse-inner rounded">
					<!-- <h6 class="collapse-header">Custom Components:</h6> -->
					<c:if test="${accesoMenu.subMenu_venta_generar.lectura}">
						<a id="enlaceGenerarVenta" class="collapse-item"
							href="${pageContext.request.contextPath}/ventaController/nuevo">Generar</a>
					</c:if>
					<c:if test="${accesoMenu.subMenu_venta_listar.lectura}">
						<a id="enlaceListadoVenta" class="collapse-item"
							href="${pageContext.request.contextPath}/ventaController/listado">Listado</a>
					</c:if>
					<c:if test="${accesoMenu.subMenu_venta_paciente.lectura}">
						<a id="enlacePacienteVenta" class="collapse-item"
							href="${pageContext.request.contextPath}/ventaController/consumoPaciente">Paciente</a>
					</c:if>
					<c:if test="${accesoMenu.subMenu_venta_anular.lectura}">
						<a id="enlaceAnularVenta" class="collapse-item"
							href="${pageContext.request.contextPath}/ventaController/anular">Anular</a>
					</c:if>
					<c:if test="${accesoMenu.subMenu_venta_devolucion.lectura}">
						<a id="enlaceDevolucionVenta" class="collapse-item"
							href="${pageContext.request.contextPath}/ventaController/devolucion">Devolución</a>
					</c:if>
				</div>
			</div></li>
	</c:if>
	<c:if test="${accesoMenu.menu_Inventario}">
		<li id="navInventario" class="nav-item"><a id="collInventario"
			class="nav-link collapsed" href="#" data-toggle="collapse"
			data-target="#collapseInventario" aria-expanded="true"
			aria-controls="collapseInventario"> <i class="fas fa-fw fa-cog"></i>
				<span>Inventario</span>
		</a>
			<div id="collapseInventario" class="collapse"
				aria-labelledby="headingTwo" data-parent="#accordionSidebar">
				<div class="bg-white py-2 collapse-inner rounded">
					<!-- <h6 class="collapse-header">Custom Components:</h6> -->
					<c:if test="${accesoMenu.subMenu_inventario_articulo.lectura}">
						<a id="enlaceArticulo" class="collapse-item"
							href="${pageContext.request.contextPath}/articuloController/listado">Artículos</a>
					</c:if>
					<c:if test="${accesoMenu.subMenu_inventario_almacen.lectura}">
						<a id="enlaceAlmacen" class="collapse-item"
							href="${pageContext.request.contextPath}/almacenController/listado">Almacenes</a>
					</c:if>
					<!--	<a id="enlaceListaPrecio" class="collapse-item"
					href="${pageContext.request.contextPath}/precioController/listado">Lista
					de Precios</a> -->
					<c:if test="${accesoMenu.subMenu_inventario_consultar.lectura}">
						<a id="enlaceConsultarInventario" class="collapse-item"
							href="${pageContext.request.contextPath}/inventarioController/consultarInventario">Consultar
							Inventario</a>
					</c:if>
					<c:if test="${accesoMenu.subMenu_inventario_generar.lectura}">
						<a id="enlaceGenerarInventario" class="collapse-item"
							href="${pageContext.request.contextPath}/inventarioController/listado">Inventario</a>
					</c:if>
				</div>
			</div></li>
	</c:if>
	<c:if test="${accesoMenu.menu_Movimiento}">
	<li id="navMovimiento" class="nav-item"><a
		class="nav-link collapsed" id="collMovimiento" href="#"
		data-toggle="collapse" data-target="#collapseMovimiento"
		aria-expanded="true" aria-controls="collapseMovimiento"> <i
			class="fas fa-fw fa-cog"></i> <span>Movimiento</span>
	</a>
		<div id="collapseMovimiento" class="collapse"
			aria-labelledby="headingTwo" data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				<!-- <h6 class="collapse-header">Custom Components:</h6> -->
				<!--<a id="enlaceMovimiento" class="collapse-item"
					href="${pageContext.request.contextPath}/movimientoAlmacenController/listado">Movimientos</a>-->
				<c:if test="${accesoMenu.subMenu_movimiento_compra.lectura}">
				<a id="enlaceCompras" class="collapse-item"
					href="${pageContext.request.contextPath}/compraController/listado">Compras</a>
				</c:if>
				<c:if test="${accesoMenu.subMenu_movimiento_ingresoSalida.lectura}">
				<a id="enlaceMovimiento" class="collapse-item"
					href="${pageContext.request.contextPath}/movimientoAlmacenController/movimiento">Ingreso/Salida</a>
				</c:if>
				<c:if test="${accesoMenu.subMenu_movimiento_ingresoSalida.lectura}">
				<a id="enlaceTransferenciaInsti" class="collapse-item"
					href="${pageContext.request.contextPath}/movimientoAlmacenController/listadoTransferencia">Transferencia Insticional</a>
				</c:if>
				<c:if test="${accesoMenu.subMenu_movimiento_kardex.lectura}">
				<a id="enlaceReporteKardex" class="collapse-item"
					href="${pageContext.request.contextPath}/movimientoAlmacenController/reporteKardex">Reporte
					de Kardex</a>
				</c:if>	
			</div>
		</div>
	</li>
	</c:if>	
		
	<!-- <li id ="navVentas" class="nav-item">
        <a id="collVentas" class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseVentas" aria-expanded="true" aria-controls="collapseVentas">
          <i class="fas fa-fw fa-cog"></i>
          <span>Transferencia</span>
        </a> 
        <div id="collapseVentas" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
        
            <a id ="enlaceGenerarVenta" class="collapse-item" href="${pageContext.request.contextPath}/ventaController/nuevo">Transferencia Inst</a>
            <a class="collapse-item" href="#">Anular</a>
            <a class="collapse-item" href="#">Devoluciones</a>
          </div>
        </div>
      </li>-->

	<!-- Nav Item - Utilities Collapse Menu 
      <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities" aria-expanded="true" aria-controls="collapseUtilities">
          <i class="fas fa-fw fa-wrench"></i>
          <span>Utilities</span>
        </a>
        <div id="collapseUtilities" class="collapse" aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            <h6 class="collapse-header">Custom Utilities:</h6>
            <a class="collapse-item" href="utilities-color.html">Colors</a>
            <a class="collapse-item" href="utilities-border.html">Borders</a>
            <a class="collapse-item" href="utilities-animation.html">Animations</a>
            <a class="collapse-item" href="utilities-other.html">Other</a>
          </div>
        </div>
      </li>-->

	<!-- Divider -->
	<hr class="sidebar-divider">

	<!-- Heading -->
	<c:if test="${accesoMenu.menu_Mantenimiento}">
	<div class="sidebar-heading">MANTENIMIENTOS</div>

	<!-- Nav Item - Pages Collapse Menu -->
	<li id="navMantenimiento" class="nav-item"><a
		id="CollMantenimiento" class="nav-link collapsed" href="#"
		data-toggle="collapse" data-target="#collapseMantenimiento"
		aria-expanded="true" aria-controls="collapseMantenimiento"> <i
			class="fas fa-fw fa-wrench"></i> <span>Mantenimientos</span>
	</a>
		<div id="collapseMantenimiento" class="collapse"
			aria-labelledby="headingPages" data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				<!-- <h6 class="collapse-header">Login Screens:</h6> -->
				<c:if test="${accesoMenu.subMenu_mantenimiento_personal.lectura}">
				<a class="collapse-item" href="#">Personal</a> 
				</c:if>
				<c:if test="${accesoMenu.subMenu_mantenimiento_stock.lectura}">	
				<a class="collapse-item" href="#">Stock</a>
				</c:if>
				<c:if test="${accesoMenu.subMenu_mantenimiento_laboratorio.lectura}">	
				 <a id="enlaceLaboratorio"
					class="collapse-item"
					href="${pageContext.request.contextPath}/laboratorioController/listado">Laboratorios</a>
				</c:if>	 
				<!--<a class="collapse-item" href="#">Tipo Movimientos</a>  -->
				<c:if test="${accesoMenu.subMenu_mantenimiento_catalogos.lectura}">
				<a id="enlaceCatalogo" class="collapse-item"
					href="${pageContext.request.contextPath}/catalogoController/listado">Catálogos</a>
				</c:if>	 	
			</div>
		</div>
	 </li>
    </c:if>	
    
	<div class="sidebar-heading">REPORTES</div>

	<c:if test="${accesoMenu.menu_RptVenta}">
	<!-- Nav Item - Pages Collapse Menu -->
	<li id="navReporteVenta" class="nav-item"><a id="CollReporteVenta"
		class="nav-link collapsed" href="#" data-toggle="collapse"
		data-target="#collapseReporteVenta" aria-expanded="true"
		aria-controls="collapseReporteVenta"> <i
			class="fas fa-fw fa-chart-area"></i> <span>Ventas</span>
	</a>
		<div id="collapseReporteVenta" class="collapse"
			aria-labelledby="headingPages" data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				<c:if test="${accesoMenu.subMenu_ventaRpt_recaudacion.lectura}">
				<a id="enlaceRecaudacion" class="collapse-item"
					href="${pageContext.request.contextPath}/ventaController/recaudacion">Recaudacion</a>
				</c:if>	
				<c:if test="${accesoMenu.subMenu_ventaRpt_diario.lectura}">	
				<a id="enlaceArticulo" class="collapse-item"
					href="${pageContext.request.contextPath}/articuloController/listado">Ventas
					diarias</a> 
				</c:if>	
				<c:if test="${accesoMenu.subMenu_ventaRpt_anulaciones.lectura}">
				<a class="collapse-item"
					href="${pageContext.request.contextPath}/almacenController/listado">Anuladas</a>
				</c:if>
				<c:if test="${accesoMenu.subMenu_ventaRpt_tipoPaciente.lectura}"> 
				<a class="collapse-item" href="#">Por tipo de paciente</a> 
				</c:if>	
				<a class="collapse-item" href="#">Devoluciones</a>
			</div>
		</div>
	</li>
	</c:if>		
	<c:if test="${accesoMenu.menu_RptICI}">		
	<li id="navICI" class="nav-item"><a id="CollReporteICI"
		class="nav-link collapsed" href="#" data-toggle="collapse"
		data-target="#collapseReporteIci" aria-expanded="true"
		aria-controls="collapseReporteIci"> <i
			class="fas fa-fw fa-chart-area"></i> <span>ICI</span>
	</a>
		<div id="collapseReporteIci" class="collapse"
			aria-labelledby="headingTwo" data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				<!-- <h6 class="collapse-header">Custom Components:</h6> -->
				<a class="collapse-item" href="#">Diario</a> <a
					id="enlaceListadoICIMensual" class="collapse-item"
					href="${pageContext.request.contextPath}/movimientoAlmacenController/listadoICIMensual">Mensual</a>

			</div>
		</div></li>
	</c:if>		
	<c:if test="${accesoMenu.menu_RptArticulo}">	
	<li class="nav-item"><a class="nav-link collapsed" href="#"
		data-toggle="collapse" data-target="#collapseReporteArticulo"
		aria-expanded="true" aria-controls="collapseReporteArticulo"> <i
			class="fas fa-fw fa-chart-area"></i> <span>Artículos</span>
	</a>
		<div id="collapseReporteArticulo" class="collapse"
			aria-labelledby="headingTwo" data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				<!-- <h6 class="collapse-header">Custom Components:</h6> -->
				<a class="collapse-item" href="#">Por vencer</a> <a
					class="collapse-item" href="#">Vencidos</a>
			</div>
		</div></li>
	</c:if>
		
	<div class="sidebar-heading">SEGURIDAD</div>
	<c:if test="${accesoMenu.menu_Seguridad}">
	<!-- Nav Item - Pages Collapse Menu -->
	<li class="nav-item" id="navConfiguracion"><a id="collAccesos"
		class="nav-link collapsed" href="#" data-toggle="collapse"
		data-target="#collapseAccesos" aria-expanded="true"
		aria-controls="collapseAccesos"> <i class="fas fa-fw fa-cog"></i>
			<span>Seguridad</span>
	</a>
		<div id="collapseAccesos" class="collapse"
			aria-labelledby="headingTwo" data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				<!-- <h6 class="collapse-header">Custom Components:</h6> -->
				<a id="enlaceUsuario" class="collapse-item"
					href="${pageContext.request.contextPath}/usuarioController/listado">Usuarios</a>
				<a id="enlaceRoles" class="collapse-item"
					href="${pageContext.request.contextPath}/accesoController/listado">Roles
					y Permisos</a>
				<a id="enlacePefil" class="collapse-item"
					href="${pageContext.request.contextPath}/perfilController/listado">Perfil</a>
			</div>
		</div></li>
	</c:if>	
	<c:if test="${accesoMenu.menu_Configuracion}">
	<li class="nav-item" id="navConfiguracion"><a
		id="collConfiguracion" class="nav-link collapsed" href="#"
		data-toggle="collapse" data-target="#collapseConfiguracion"
		aria-expanded="true" aria-controls="collapseConfiguracion"> <i
			class="fas fa-fw fa-cog"></i> <span>Configuración</span>
	</a>
		<div id="collapseConfiguracion" class="collapse"
			aria-labelledby="headingTwo" data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				<!-- <h6 class="collapse-header">Custom Components:</h6> -->
				<a id="enlaceInstitucion" class="collapse-item"
					href="${pageContext.request.contextPath}/institucionController/nuevo">Institución</a>
				<a id="enlaceConfInventario" class="collapse-item"
					href="${pageContext.request.contextPath}/inventarioController/configuracion">Parametros</a>
			</div>
		</div></li>
	</c:if>	
	<!-- Nav Item - Charts 
      <li class="nav-item">
        <a class="nav-link" href="charts.html">
          <i class="fas fa-fw fa-chart-area"></i>
          <span>Charts</span></a>
      </li>
-->
	<!-- Divider -->
	<hr class="sidebar-divider d-none d-md-block">

	<!-- Sidebar Toggler (Sidebar) -->
	<div class="text-center d-none d-md-inline">
		<button class="rounded-circle border-0" id="sidebarToggle"></button>
	</div>

</ul>
<!-- End of Sidebar -->

<script type="text/javascript" charset="utf-8">
	function confirmarSalirSistema(msg, url) {

		window.location.href = url;

	};
</script>