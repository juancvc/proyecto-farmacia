<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="proyect.core.bean.seguridad.UsuarioBean"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

	pageEncoding="ISO-8859-1"%>
 
   
   
   <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

      <!-- Sidebar - Brand -->
      <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.html">
        <div class="sidebar-brand-icon rotate-n-15">
        
        </div>
        <!--   <i class="fas fa-laugh-wink"></i> <div class="sidebar-brand-text mx-3">SB Admin <sup>2</sup></div> -->
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
      <div class="sidebar-heading">
        SALIDAS
      </div>

      <!-- Nav Item - Pages Collapse Menu -->
      <li id ="navVentas" class="nav-item">
        <a id="collVentas" class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseVentas" aria-expanded="true" aria-controls="collapseVentas">
          <i class="fas fa-fw fa-cog"></i>
          <span>Ventas</span>
        </a> 
        <div id="collapseVentas" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
          <!-- <h6 class="collapse-header">Custom Components:</h6> -->  
            <a id ="enlaceGenerarVenta" class="collapse-item" href="${pageContext.request.contextPath}/ventaController/nuevo">Generar</a>
            <a id ="enlaceAnularVenta" class="collapse-item"  href="${pageContext.request.contextPath}/ventaController/anular">Anular</a>
            <a id ="enlaceDevolucionVenta" class="collapse-item" href="${pageContext.request.contextPath}/ventaController/devolucion">Devoluciones</a>
          </div>
        </div>
      </li>
  
  <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseInventario" aria-expanded="true" aria-controls="collapseInventario">
          <i class="fas fa-fw fa-cog"></i>
          <span>Inventario</span>
        </a> 
        <div id="collapseInventario" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
          <!-- <h6 class="collapse-header">Custom Components:</h6> -->  
            <a class="collapse-item" href="#">Generar</a>
          </div>
        </div>
      </li>

  <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseMovimiento" aria-expanded="true" aria-controls="collapseMovimiento">
          <i class="fas fa-fw fa-cog"></i>
          <span>Movimiento</span>
        </a> 
        <div id="collapseMovimiento" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
          <!-- <h6 class="collapse-header">Custom Components:</h6> -->  
            <a class="collapse-item" href="#">Kárdex</a>
          </div>
        </div>
      </li>
       <li class="nav-item">
        <a class="nav-link" href="tables.html">
          <i class="fas fa-fw fa-table"></i>
          <span>Transferencia Inst.</span></a>
      </li>
       
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
      <div class="sidebar-heading">
        MANTENIMIENTOS
      </div>

      <!-- Nav Item - Pages Collapse Menu -->
      <li id="navMantenimiento" class="nav-item">
        <a id="CollMantenimiento"  class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseMantenimiento" aria-expanded="true" aria-controls="collapseMantenimiento">
         <i class="fas fa-fw fa-wrench"></i>
          <span>Mantenimientos</span>
        </a>
        <div id="collapseMantenimiento" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
             <!-- <h6 class="collapse-header">Login Screens:</h6> -->
            <a id="enlaceArticulo" class="collapse-item" href="${pageContext.request.contextPath}/articuloController/listado">Artículo</a>
            <a class="collapse-item" href="#">Almacén</a>
            <a class="collapse-item" href="#">Personal</a>
            <a class="collapse-item" href="#">Stock</a>
          
            <a class="collapse-item" href="#">Laboratorios</a>
             <a class="collapse-item" href="#">Tipo Movimientos</a>
              <a class="collapse-item" href="#">Catálogos</a>
          </div>
        </div>
      </li>
      
       <div class="sidebar-heading">
        REPORTES
      </div>

      <!-- Nav Item - Pages Collapse Menu -->
      <li id="navReporteVenta" class="nav-item">
        <a id="CollReporteVenta"  class="nav-link collapsed" href="#" data-toggle="collapse" 
        		data-target="#collapseReporteVenta" aria-expanded="true" aria-controls="collapseReporteVenta">
          <i class="fas fa-fw fa-chart-area"></i>
          <span>Ventas</span>
        </a>
        <div id="collapseReporteVenta" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
             <!-- <h6 class="collapse-header">Login Screens:</h6> -->
            <a id="enlaceArticulo" class="collapse-item" href="${pageContext.request.contextPath}/articuloController/listado">Ventas diarias</a>
            <a class="collapse-item" href="#">Anuladas</a>
            <a class="collapse-item" href="#">Por tipo de paciente</a>
            <a class="collapse-item" href="#">Devoluciones</a>
          </div>
        </div>
      </li>
      <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseReporteIci" aria-expanded="true" aria-controls="collapseReporteIci">
           <i class="fas fa-fw fa-chart-area"></i>
          <span>ICI</span>
        </a> 
        <div id="collapseReporteIci" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
          <!-- <h6 class="collapse-header">Custom Components:</h6> -->  
            <a class="collapse-item" href="#">Diario</a>
             <a class="collapse-item" href="#">Mensual</a>
          </div>
        </div>
      </li>
        <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseReporteArticulo" aria-expanded="true" aria-controls="collapseReporteArticulo">
           <i class="fas fa-fw fa-chart-area"></i>
          <span>Artículos</span>
        </a> 
        <div id="collapseReporteArticulo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
          <!-- <h6 class="collapse-header">Custom Components:</h6> -->  
            <a class="collapse-item" href="#">Por vencer</a>
             <a class="collapse-item" href="#">Vencidos</a>
          </div>
        </div>
      </li>
 <div class="sidebar-heading">
        SEGURIDAD
      </div>

      <!-- Nav Item - Pages Collapse Menu -->
     <li class="nav-item">
        <a class="nav-link" href="tables.html">
          <i class="fas fa-fw fa-user"></i>
          <span>Usuarios</span></a>
      </li>
		<li class="nav-item">
        <a class="nav-link" href="tables.html">
          <i class="fas fa-fw fa-table"></i>
          <span>Accesos</span></a>
      </li>

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