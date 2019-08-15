<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="proyect.core.bean.seguridad.UsuarioBean"%>


   <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

          <!-- Sidebar Toggle (Topbar) -->
          <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
            <i class="fa fa-bars"></i>
          </button>

          <!-- Topbar Search -->
          <form class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
            <div class="input-group">
              <!-- <input type="text" class="form-control bg-light border-0 small"
               placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2">
              <div class="input-group-append">
                <button class="btn btn-primary" type="button">
                  <i class="fas fa-search fa-sm"></i>
                </button>
              </div>-->
            </div>
          </form>

          <!-- Topbar Navbar -->
          <ul class="navbar-nav ml-auto">

            <!-- Nav Item - Search Dropdown (Visible Only XS) -->
            <li class="nav-item dropdown no-arrow d-sm-none">
              <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <i class="fas fa-search fa-fw"></i>
              </a>
              <!-- Dropdown - Messages -->
              <div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in" aria-labelledby="searchDropdown">
                <form class="form-inline mr-auto w-100 navbar-search">
                  <div class="input-group">
                    <input type="text" class="form-control bg-light border-0 small" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2">
                    <div class="input-group-append">
                      <button class="btn btn-primary" type="button">
                        <i class="fas fa-search fa-sm"></i>
                      </button>
                    </div>
                  </div>
                </form>
              </div>
            </li>
 <%-- Nav Item - Alerts
            <!-- Nav Item - Alerts -->
            <li class="nav-item dropdown no-arrow mx-1">
              <a class="nav-link dropdown-toggle" href="#" id="alertsDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <i class="fas fa-bell fa-fw"></i>
                <!-- Counter - Alerts -->
                <span class="badge badge-danger badge-counter">3+</span>
              </a>
              <!-- Dropdown - Alerts -->
              <div class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="alertsDropdown">
                <h6 class="dropdown-header">
                  Alerts Center
                </h6>
                <a class="dropdown-item d-flex align-items-center" href="#">
                  <div class="mr-3">
                    <div class="icon-circle bg-primary">
                      <i class="fas fa-file-alt text-white"></i>
                    </div>
                  </div>
                  <div>
                    <div class="small text-gray-500">December 12, 2019</div>
                    <span class="font-weight-bold">A new monthly report is ready to download!</span>
                  </div>
                </a>
                <a class="dropdown-item d-flex align-items-center" href="#">
                  <div class="mr-3">
                    <div class="icon-circle bg-success">
                      <i class="fas fa-donate text-white"></i>
                    </div>
                  </div>
                  <div>
                    <div class="small text-gray-500">December 7, 2019</div>
                    $290.29 has been deposited into your account!
                  </div>
                </a>
                <a class="dropdown-item d-flex align-items-center" href="#">
                  <div class="mr-3">
                    <div class="icon-circle bg-warning">
                      <i class="fas fa-exclamation-triangle text-white"></i>
                    </div>
                  </div>
                  <div>
                    <div class="small text-gray-500">December 2, 2019</div>
                    Spending Alert: We've noticed unusually high spending for your account.
                  </div>
                </a>
                <a class="dropdown-item text-center small text-gray-500" href="#">Show All Alerts</a>
              </div>
            </li>

            <!-- Nav Item - Messages -->
            <li class="nav-item dropdown no-arrow mx-1">
              <a class="nav-link dropdown-toggle" href="#" id="messagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <i class="fas fa-envelope fa-fw"></i>
                <!-- Counter - Messages -->
                <span class="badge badge-danger badge-counter">7</span>
              </a>
              <!-- Dropdown - Messages -->
              <div class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="messagesDropdown">
                <h6 class="dropdown-header">
                  Message Center
                </h6>
                <a class="dropdown-item d-flex align-items-center" href="#">
                  <div class="dropdown-list-image mr-3">
                    <img class="rounded-circle" src="https://source.unsplash.com/fn_BT9fwg_E/60x60" alt="">
                    <div class="status-indicator bg-success"></div>
                  </div>
                  <div class="font-weight-bold">
                    <div class="text-truncate">Hi there! I am wondering if you can help me with a problem I've been having.</div>
                    <div class="small text-gray-500">Emily Fowler 路 58m</div>
                  </div>
                </a>
                <a class="dropdown-item d-flex align-items-center" href="#">
                  <div class="dropdown-list-image mr-3">
                    <img class="rounded-circle" src="https://source.unsplash.com/AU4VPcFN4LE/60x60" alt="">
                    <div class="status-indicator"></div>
                  </div>
                  <div>
                    <div class="text-truncate">I have the photos that you ordered last month, how would you like them sent to you?</div>
                    <div class="small text-gray-500">Jae Chun 路 1d</div>
                  </div>
                </a>
                <a class="dropdown-item d-flex align-items-center" href="#">
                  <div class="dropdown-list-image mr-3">
                    <img class="rounded-circle" src="https://source.unsplash.com/CS2uCrpNzJY/60x60" alt="">
                    <div class="status-indicator bg-warning"></div>
                  </div>
                  <div>
                    <div class="text-truncate">Last month's report looks great, I am very happy with the progress so far, keep up the good work!</div>
                    <div class="small text-gray-500">Morgan Alvarez 路 2d</div>
                  </div>
                </a>
                <a class="dropdown-item d-flex align-items-center" href="#">
                  <div class="dropdown-list-image mr-3">
                    <img class="rounded-circle" src="https://source.unsplash.com/Mv9hjnEUHR4/60x60" alt="">
                    <div class="status-indicator bg-success"></div>
                  </div>
                  <div>
                    <div class="text-truncate">Am I a good boy? The reason I ask is because someone told me that people say this to all dogs, even if they aren't good...</div>
                    <div class="small text-gray-500">Chicken the Dog 路 2w</div>
                  </div>
                </a>
                <a class="dropdown-item text-center small text-gray-500" href="#">Read More Messages</a>
              </div>
            </li>
 --%>
 
  <li class="nav-item dropdown no-arrow mx-1">
            <a class="nav-link dropdown-toggle" href="#" id="messagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              
                <!-- Counter - Messages -->
                <span class="mr-2 d-none d-lg-inline text-gray-600 small">${usuarioSesion.almacen.nombreAlmacen}</span>
              </a> 
             
            </li>
            
            
            <div class="topbar-divider d-none d-sm-block"></div>

            <!-- Nav Item - User Information -->
            <li class="nav-item dropdown no-arrow">
              <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <span class="mr-2 d-none d-lg-inline text-gray-600 small">${usuarioSesion.persona.nombreCompleto}</span>
                 <!-- <img class="img-profile rounded-circle" src="https://source.unsplash.com/QAB-WJcbgJk/60x60">-->
              </a>
              <!-- Dropdown - User Information -->
              <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="userDropdown">
                <a class="dropdown-item" href="#">
                  <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                  Cambiar contrase馻
                </a>
                <!--  <a class="dropdown-item" href="#">
                  <i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
                  Settings
                </a>
                <a class="dropdown-item" href="#">
                  <i class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i>
                  Activity Log
                </a>-->
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                  <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                  Cerrar sesi髇
                </a>
              </div>
            </li>

          </ul>

        </nav>
        
        
        
        
   	<%--     
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
		<%--  		<div style="padding: 20px 10px;font-weight: bold;">${listaPerfilesUsu[0].perfil.nombrePerfil}</div>
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
      <a onclick="javascript:confirmarSalirSistema('緿esea cerrar sesi髇?','${pageContext.request.contextPath}/logoutController/cerrarSesion')" href="#" class="dropdown-item"><i class="ft-power"></i> Cerrar Sesi&oacute;n</a>
      <!-- <a href="login-admin.jsp" class="dropdown-item"><i class="ft-power"></i> Cerrar Sesi&oacute;n</a> -->
    </div>
  </li>
</ul>--%>
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