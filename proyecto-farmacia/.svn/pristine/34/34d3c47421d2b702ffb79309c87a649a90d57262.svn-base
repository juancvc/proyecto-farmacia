<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="hnch.referencia.core.bean.seguridad.UsuarioBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<ul class="navbar-nav navbar-sidenav" id="exampleAccordion">
	<c:if test="${accesoMenu.menu_Estadisticos}">
		<c:set var="menuInicio"
			value="${pageContext.request.contextPath}/page/inicio.jsp" />
		<li data-toggle="tooltip" data-placement="right" class="nav-item">
			<a class="nav-link"
			href="${pageContext.request.contextPath}/inicioController/portada"><i
				class="fa fa-fw fa-dashboard"> </i><span
				class="nav-link-text label_control_barra"> Inicio</span></a>
		</li>
	</c:if>
	<c:if test="${accesoMenu.menu_Referencia}">
		<c:set var="menuReferencia"
			value="${pageContext.request.contextPath}/page/inicio.jsp" />
		<!-- <li class="nav-item ${pageContext.request.requestURI eq menuReportes ? ' active' : ''}" data-toggle="tooltip" data-placement="right" title="Referencia"> -->
		<li class="nav-item label_control_barra" data-toggle="tooltip"
			data-placement="right" title="Referencia"><a
			class="nav-link nav-link-collapse collapsed" data-toggle="collapse"
			href="#menuReferencia" data-parent="#exampleAccordion"> <i
				class="fa fa-fw fa-table"></i> <span
				class="nav-link-text label_control_barra">Referencia</span>
		</a>
			<ul class="sidenav-second-level collapse" id="menuReferencia">
				<li><a
					href="${pageContext.request.contextPath}/referenciaController/nuevo"><span
						class="label_control_barra">Ficha Registro</span></a></li>
				<li><a
					href="${pageContext.request.contextPath}/referenciaController/listado"><span
						class="label_control_barra">Listado</span></a></li>
				<li><a
					href="${pageContext.request.contextPath}/inicioController/estadisticos"><span
						class="label_control_barra">Estadísticos</span></a></li>
			</ul></li>
	</c:if>
	<c:if test="${accesoMenu.menu_Contrareferencia}">
		<li class="nav-item" data-toggle="tooltip" data-placement="right"
			title="Contra-Referencia"><a class="nav-link" href="#"> <i
				class="fa fa-fw fa-dashboard"></i> <span
				class="nav-link-text label_control_barra">Contrareferencia</span>
		</a></li>
	</c:if>
	<c:if test="${accesoMenu.menu_Citas}">
		<li class="nav-item label_control_barra" data-toggle="tooltip"
			data-placement="right" title="Citas"><a
			class="nav-link nav-link-collapse collapsed" data-toggle="collapse"
			href="#menuCita" data-parent="#exampleAccordion"> <i
				class="fa fa-fw fa-area-chart"></i> <span
				class="nav-link-text label_control_barra ">Citas</span>
		</a>
			<ul class="sidenav-second-level collapse" id="menuCita">
				<li><a
					href="${pageContext.request.contextPath}/citasController/nuevo"><span
						class="label_control_barra">Registro</span></a></li>
				<li><a
					href="${pageContext.request.contextPath}/citasController/listado"><span
						class="label_control_barra">Listado</span></a></li>
			</ul></li>
	</c:if>
	<c:if test="${accesoMenu.menu_BancoSangre}">
		<li class="nav-item" data-toggle="tooltip" data-placement="right"
			title="Banco de Sangre"><a
			class="nav-link nav-link-collapse collapsed" data-toggle="collapse"
			href="#menuBanco" data-parent="#exampleAccordion"> <i
				class="fa fa-fw fa-file"></i> <span
				class="nav-link-text label_control_barra">Banco de Sangre</span>
		</a>
			<ul class="sidenav-second-level collapse" id="menuBanco">
				<c:if test="${accesoMenu.subMenu_banco_postulante.lectura}">
					<li><a href="#collapseDonante"
						class="nav-link-collapse collapsed" data-toggle="collapse">Postulante</a>
						<ul class="sidenav-third-level collapse" id="collapseDonante">
							<li><a
								href="${pageContext.request.contextPath}/bancoController/nuevoPostulante">Registro</a>
							</li>
							<li><a
								href="${pageContext.request.contextPath}/bancoController/listadoPostulante">Listado</a>
							</li>
						</ul></li>
				</c:if>
				<li><a href="#collapseEstadoFisico"
					class="nav-link-collapse collapsed" data-toggle="collapse">Estado
						Físico</a>
					<ul class="sidenav-third-level collapse" id="collapseEstadoFisico">
						<li><a
							href="${pageContext.request.contextPath}/evaluacionController/listaPostulantesEvaluacion">Postulantes</a>
						</li>
						<!-- <li><a
							href="${pageContext.request.contextPath}/evaluacionController/listadoPostulante">Listado</a>
						</li> - -->
					</ul></li>
				<li><a href="#collapseEntrevista"
					class="nav-link-collapse collapsed" data-toggle="collapse">Entrevista</a>
					<ul class="sidenav-third-level collapse" id="collapseEntrevista">
						<li><a
							href="${pageContext.request.contextPath}/entrevistaController/listaPreDonantes">Pre-donantes</a>
						</li>
						<li><a
							href="${pageContext.request.contextPath}/entrevistaController/listadoPostulanteEntrevistados">Entrevistados</a>
						</li>
					</ul></li>
				<c:if test="${accesoMenu.subMenu_banco_campania.lectura}">
					<li><a class="nav-link-collapse collapsed"
						data-toggle="collapse" href="#collapseCampania">Campañas</a>
						<ul class="sidenav-third-level collapse" id="collapseCampania">
							<li><a
								href="${pageContext.request.contextPath}/bancoController/nuevaCampania">Registro</a>
							</li>
							<li><a
								href="${pageContext.request.contextPath}/bancoController/listadoCampania">Listado</a>
							</li>
						</ul></li>
				</c:if>
				<c:if test="${accesoMenu.subMenu_banco_lugarCampania.lectura}">
					<li><a href="#collapseLugarCampania"
						class="nav-link-collapse collapsed" data-toggle="collapse">Lugar
							de Campañas</a>
						<ul class="sidenav-third-level collapse"
							id="collapseLugarCampania">
							<li><a
								href="${pageContext.request.contextPath}/bancoController/nuevoLugarCampania">Registro</a>
							</li>
							<li><a
								href="${pageContext.request.contextPath}/bancoController/listadoLugarCampania">Listado</a>
							</li>
						</ul></li>
				</c:if>
			</ul></li>
	</c:if>
	<c:if test="${accesoMenu.menu_Herramientas}">
		<li class="nav-item" data-toggle="tooltip" data-placement="right"
			title="Herramientas"><a
			class="nav-link nav-link-collapse collapsed" data-toggle="collapse"
			href="#collapseComponents" data-parent="#exampleAccordion"> <i
				class="fa fa-fw fa-wrench"></i> <span
				class="nav-link-text label_control_barra">Herramientas</span>
		</a>
			<ul class="sidenav-second-level collapse" id="collapseComponents">
				<li><a
					href="${pageContext.request.contextPath}/maestraController/listado"><span
						class="label_control_barra">Maestras</span></a></li>
				<!-- <li><a
					href="${pageContext.request.contextPath}/renaesController/listado"><span
						class="label_control_barra">Relacionar Renaes</span></a></li> -->
			</ul></li>
	</c:if>

	<c:if test="${accesoMenu.menu_Seguridad}">
		<li class="nav-item" data-toggle="tooltip" data-placement="right"
			title="Seguridad"><a
			class="nav-link nav-link-collapse collapsed" data-toggle="collapse"
			href="#collapseExamplePages" data-parent="#exampleAccordion"> <i
				class="fa fa-fw fa-file"></i> <span
				class="nav-link-text label_control_barra">Seguridad</span>
		</a>
			<ul class="sidenav-second-level collapse" id="collapseExamplePages">
				<li><a href="#collapseUsuer"
					class="nav-link-collapse collapsed" data-toggle="collapse">Usuario</a>
					<ul class="sidenav-third-level collapse" id="collapseUsuer">
						<li><a
							href="${pageContext.request.contextPath}/usuarioController/nuevo">Registro</a>
						</li>
						<li><a
							href="${pageContext.request.contextPath}/usuarioController/listado">Listado</a>
						</li>
					</ul></li>
				<li><a
					href="${pageContext.request.contextPath}/accesoController/listado"><span
						class="label_control_barra">Accesos</span></a></li>
				<li><a class="nav-link-collapse collapsed"
					data-toggle="collapse" href="#collapseMulti2">Perfil</a>
					<ul class="sidenav-third-level collapse" id="collapseMulti2">
						<li><a
							href="${pageContext.request.contextPath}/perfilController/nuevo">Registro</a>
						</li>
						<li><a
							href="${pageContext.request.contextPath}/perfilController/listado">Listado</a>
						</li>
					</ul></li>
			</ul></li>
	</c:if>

	<c:if test="${accesoMenu.menu_Estadisticos}">
		<li style="display: none" class="nav-item" data-toggle="tooltip"
			data-placement="right" title="Menu Levels"><a
			class="nav-link nav-link-collapse collapsed" data-toggle="collapse"
			href="#collapseMulti" data-parent="#exampleAccordion"> <i
				class="fa fa-fw fa-sitemap"></i> <span class="nav-link-text">Otros</span>
		</a>
			<ul class="sidenav-second-level collapse" id="collapseMulti">
				<li><a href="#">Second Level Item</a></li>
				<li><a href="#">Second Level Item</a></li>
				<li><a href="#">Second Level Item</a></li>
				<li><a class="nav-link-collapse collapsed"
					data-toggle="collapse" href="#collapseMulti2">Third Level</a>
					<ul class="sidenav-third-level collapse" id="collapseMulti2">
						<li><a href="#">Third Level Item</a></li>
						<li><a href="#">Third Level Item</a></li>
						<li><a href="#">Third Level Item</a></li>
					</ul></li>
			</ul></li>
	</c:if>
</ul>
<ul class="navbar-nav sidenav-toggler">
	<li class="nav-item"><a class="nav-link text-center"
		id="sidenavToggler"> <i class="fa fa-fw fa-angle-left"></i>
	</a></li>
</ul>
<ul class="navbar-nav ml-auto">
	<li class="nav-item dropdown"><a href="#" data-toggle="dropdown"
		class="dropdown-toggle nav-link dropdown-user-link"> <!--  <span class="avatar avatar-online"><img src="../app-assets/images/portrait/small/avatar-s-1.png" alt="avatar"><i></i></span> -->
			<span class="user-name">${usuarioSesion.persona.nombreCompleto}</span>
	</a>
		<div class="dropdown-menu dropdown-menu-right">
			<!-- <a href="#" class="dropdown-item"><i class="ft-user"></i> Modificar Perfil</a> -->
			<a
				href="${pageContext.request.contextPath}/usuarioController/cambiarPassUsuario"
				class="dropdown-item"><i class="fa fa-key"></i> Cambiar
				Contrase&ntilde;a</a>
			<!--  <a href="#" class="dropdown-item"><i class="fa fa-key"></i> Cambiar Contrase&ntilde;a</a>-->
			<div class="dropdown-divider"></div>
			<a
				onclick="javascript:confirmarSalirSistema('¿Desea cerrar sesión?','${pageContext.request.contextPath}/logoutController/cerrarSesion')"
				href="#" class="dropdown-item"> <i class="fa fa-fw fa-sign-out"></i>
				Cerrar Sesi&oacute;n
			</a>
			<!-- <a href="login-admin.jsp" class="dropdown-item"><i class="ft-power"></i> Cerrar Sesi&oacute;n</a> -->
		</div></li>
</ul>
<!-- 
      <ul class="navbar-nav ml-auto">
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle mr-lg-2" id="messagesDropdown" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fa fa-fw fa-envelope"></i>
            <span class="d-lg-none">Messages
              <span class="badge badge-pill badge-primary">12 New</span>
            </span>
            <span class="indicator text-primary d-none d-lg-block">
              <i class="fa fa-fw fa-circle"></i>
            </span>
          </a>
          <div class="dropdown-menu" aria-labelledby="messagesDropdown">
            <h6 class="dropdown-header">New Messages:</h6>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="#">
              <strong>David Miller</strong>
              <span class="small float-right text-muted">11:21 AM</span>
              <div class="dropdown-message small">Hey there! This new version of SB Admin is pretty awesome! These messages clip off when they reach the end of the box so they don't overflow over to the sides!</div>
            </a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="#">
              <strong>Jane Smith</strong>
              <span class="small float-right text-muted">11:21 AM</span>
              <div class="dropdown-message small">I was wondering if you could meet for an appointment at 3:00 instead of 4:00. Thanks!</div>
            </a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="#">
              <strong>John Doe</strong>
              <span class="small float-right text-muted">11:21 AM</span>
              <div class="dropdown-message small">I've sent the final files over to you for review. When you're able to sign off of them let me know and we can discuss distribution.</div>
            </a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item small" href="#">View all messages</a>
          </div>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle mr-lg-2" id="alertsDropdown" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fa fa-fw fa-bell"></i>
            <span class="d-lg-none">Alerts
              <span class="badge badge-pill badge-warning">6 New</span>
            </span>
            <span class="indicator text-warning d-none d-lg-block">
              <i class="fa fa-fw fa-circle"></i>
            </span>
          </a>
          <div class="dropdown-menu" aria-labelledby="alertsDropdown">
            <h6 class="dropdown-header">New Alerts:</h6>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="#">
              <span class="text-success">
                <strong>
                  <i class="fa fa-long-arrow-up fa-fw"></i>Status Update</strong>
              </span>
              <span class="small float-right text-muted">11:21 AM</span>
              <div class="dropdown-message small">This is an automated server response message. All systems are online.</div>
            </a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="#">
              <span class="text-danger">
                <strong>
                  <i class="fa fa-long-arrow-down fa-fw"></i>Status Update</strong>
              </span>
              <span class="small float-right text-muted">11:21 AM</span>
              <div class="dropdown-message small">This is an automated server response message. All systems are online.</div>
            </a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="#">
              <span class="text-success">
                <strong>
                  <i class="fa fa-long-arrow-up fa-fw"></i>Status Update</strong>
              </span>
              <span class="small float-right text-muted">11:21 AM</span>
              <div class="dropdown-message small">This is an automated server response message. All systems are online.</div>
            </a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item small" href="#">View all alerts</a>
          </div>
        </li>
        <li class="nav-item">
          <form class="form-inline my-2 my-lg-0 mr-lg-2">
            <div class="input-group">
              <input class="form-control" type="text" placeholder="Search for...">
              <span class="input-group-append">
                <button class="btn btn-primary" type="button">
                  <i class="fa fa-search"></i>
                </button>
              </span>
            </div>
          </form>
        </li>
        <li class="nav-item">
          <a class="nav-link" data-toggle="modal" data-target="#exampleModal">
            <i class="fa fa-fw fa-sign-out"></i>Logout</a>
        </li>
      </ul>
      -->

<script type="text/javascript" charset="utf-8">
	function confirmarSalirSistema(msg, url) {

		window.location.href = url;

	};
</script>