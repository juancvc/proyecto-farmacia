<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="hnch.referencia.core.bean.seguridad.UsuarioBean"%>
<ul class="nav navbar-nav">
  <li class="nav-item hidden-sm-down"><a href="#" class="nav-link nav-menu-main menu-toggle hidden-xs"><i class="ft-menu"></i></a></li>
  <li class="nav-item hidden-sm-down"><a href="#" class="nav-link nav-link-expand"><i class="ficon ft-maximize"></i></a></li>
</ul>
<ul class="nav navbar-nav float-xs-right">

  
  <li class="nav-item">
  	<c:set var="listaPerfilesUsu" value="${usuarioSesion.lstUsuarioPerfil}"/>
  	<c:choose>
		<c:when test="${(totalPerfiles>0) and (totalPerfiles==1)}">
			<%-- <span class="form-control"
				  style="margin-top: 12px;margin-right: 10px;border: 0px;font-weight: bold;">
				  ${listaPerfilesUsu[0].perfil.nombrePerfil}
			</span> --%>
			<div style="padding: 20px 10px;font-weight: bold;">${listaPerfilesUsu[0].perfil.nombrePerfil}</div>
		</c:when>
		<c:otherwise>
			<select id="cboPerfilSesionActual"
					name="cboPerfilSesionActual"
					class="form-control"
					style="margin-top: 10px;margin-right: 10px"
					onchange="obtenerAccesos()">
		        <c:forEach var="usuarioPerfil" items="${listaPerfilesUsu}">
		        	<option <c:if test="${usuarioPerfil.perfil.codigoPerfil==usuarioSesion.codPerfilUsuSelec}">selected</c:if>
				            value="${usuarioPerfil.perfil.codigoPerfil}">
				            ${usuarioPerfil.perfil.nombrePerfil}
		        	</option>
		        </c:forEach>
		    </select>
		</c:otherwise>
	</c:choose>
  </li>
	
	

  <li class="dropdown dropdown-user nav-item">
    <a href="#" data-toggle="dropdown" class="dropdown-toggle nav-link dropdown-user-link">
      <span class="avatar avatar-online"><img src="../app-assets/images/portrait/small/avatar-s-1.png" alt="avatar"><i></i></span>
      <span class="user-name">${usuarioSesion.persona.nombreCompleto}</span>
    </a>
    <div class="dropdown-menu dropdown-menu-right">
    <!-- <a href="#" class="dropdown-item"><i class="ft-user"></i> Modificar Perfil</a> -->
    <a href="${pageContext.request.contextPath}/usuarioController/cambiarPassUsuario" class="dropdown-item"><i class="fa fa-key"></i> Cambiar Contrase&ntilde;a</a>
      <div class="dropdown-divider"></div>
      <a onclick="javascript:confirmarSalirSistema('¿Desea cerrar sesión?','${pageContext.request.contextPath}/logoutController/cerrarSesion')" href="#" class="dropdown-item"><i class="ft-power"></i> Cerrar Sesi&oacute;n</a>
      <!-- <a href="login-admin.jsp" class="dropdown-item"><i class="ft-power"></i> Cerrar Sesi&oacute;n</a> -->
    </div>
  </li>
</ul>
<input type="hidden" id="url_base-proyecto" value="${pageContext.request.contextPath}">
<script type="text/javascript" charset="utf-8" >

	function confirmarSalirSistema(msg,url) {

		window.location.href=url;

	};

	function obtenerAccesos() {

		var codperfil = $('#cboPerfilSesionActual').val();

		  $.ajax({
		    type: "GET",
		    url: "${pageContext.request.contextPath}/inicioController/obtenerAccesos?codperfil="+codperfil,
		    success: function(){
		    	//location.reload();
		    	location.href='${pageContext.request.contextPath}/inicioController/listar';
		    },error: function(xhr,status,er) {
	            console.log("error: " + xhr + " status: " + status + " er:" + er);
			    if(xhr.status==500) {
			    	console.log(er);
			    	//Error_500(er);
			    }
			    if(xhr.status==901) {
		    		console.log(er);
		    		//spire_session_901(er);
     			}
		    }
		  });
	}

	function doPost(path, params, method) {
        method = method || "post";

        var form = document.createElement("form");

        form._submit_function_ = form.submit;

        form.setAttribute("method", method);
        form.setAttribute("action", path);

        for(var key in params) {
            var hiddenField = document.createElement("input");
            hiddenField.setAttribute("type", "hidden");
            hiddenField.setAttribute("name", key);
            hiddenField.setAttribute("value", params[key]);

            form.appendChild(hiddenField);
        }

        document.body.appendChild(form);
        form._submit_function_();
    }

	function modificarElementoGenerico(url, idElemento){
		var urlComplete = document.getElementById('url_base-proyecto').value + url;
		doPost(urlComplete, { codigo : idElemento } );
	}

</script>