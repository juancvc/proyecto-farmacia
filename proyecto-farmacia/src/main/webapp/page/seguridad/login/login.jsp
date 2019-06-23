<%@page session="true"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Farmacia - Login</title>

  <!-- Custom fonts for this template-->
  <link href="${pageContext.request.contextPath}/app-assets/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="${pageContext.request.contextPath}/app-assets/css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body class="bg-gradient-primary">

  <div class="container">

    <!-- Outer Row -->
    <div class="row justify-content-center">

      <div class="col-xl-10 col-lg-12 col-md-9">

        <div class="card o-hidden border-0 shadow-lg my-5">
          <div class="card-body p-0">
            <!-- Nested Row within Card Body -->
            <div class="row">
              <div class="col-lg-6 d-none d-lg-block">
              <img id="imgFotoPaciente" 
				src="${pageContext.request.contextPath}/assets/img/segu/LogoFarmaciaUsu.PNG" />
              </div>
              <div class="col-lg-6">
                <div class="p-5">
                  <div class="text-center">
                    <h1 class="h4 text-gray-900 mb-4">Bienvenido(a)!</h1>
                  </div> 
                  <f:form class="user" role="form"
					action="${pageContext.request.contextPath}/inicioController/controlAcceso"> 
                    <div class="form-group">
                      <f:input  id="textUsuario"
							path="nombreUsuario" type="text" class="form-control form-control-user" aria-describedby="emailHelp" placeholder="Ingrese usuario..."/>
                    </div>
                    <div class="form-group">
                      <f:input type="password" class="form-control form-control-user" id="textPassword" path="contrasena"
							placeholder="Password"/>
                    </div>
                    <div class="form-group">
                      <div class="custom-control custom-checkbox small">
                        <input type="checkbox" class="custom-control-input" id="customCheck">
                        <label class="custom-control-label" for="customCheck">Recordarme</label>
                      </div>
                    </div>
                   <button id="btnIniciarSesion" type="submit"
						class="btn btn-primary btn-user btn-block"> Login
					</button> 
                 	</f:form>
                  <hr>
                  <!-- 
                  
                   <div class="text-center">
                    <a class="small" href="forgot-password.html">Forgot Password?</a>
                  </div>
                  <div class="text-center">
                    <a class="small" href="register.html">Create an Account!</a>
                  </div>
                  
                   -->
                 
                </div>
              </div>
            </div>
          </div>
        </div>

      </div>

    </div>

  </div>

  <!-- Bootstrap core JavaScript-->
  <script src="${pageContext.request.contextPath}/app-assets/vendor/jquery/jquery.min.js"></script>
  <script src="${pageContext.request.contextPath}/app-assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="${pageContext.request.contextPath}/app-assets/vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="${pageContext.request.contextPath}/app-assets/js/sb-admin-2.min.js"></script>


<script type="text/javascript" charset="utf-8">
		var infoHtml = "<div id='boxMsg' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert' aria-hidden='true'>×</button><span class='msgValidar'>Ha ocurrido un error en JavaScript ponerse en contacto con soporte.</span></div>";

		$("#textUsuario, #textClave").keyup(
				function() {
					if ($("#textUsuario").val() == "") {
						$("#textUsuario").focus();
						var contentInput = $("#textUsuario").parents(
								".valid-msg");
						$(contentInput).addClass("has-error");
						//$("#boxMsgx").append(infoHtml);
						$("#boxMsgx").html(infoHtml);
						$("#boxMsg").fadeIn("slow");
						$(".msgValidar").html(
								"Por favor, ingrese el nombre de usuario");
					} else {
						$("#textUsuario").parents(".valid-msg").removeClass(
								"has-error");
						$("#boxMsg").fadeOut();
					}
				});

		$("#textClave").keyup(
				function() {
					if ($("#textClave").val() == "") {
						$("#textClave").focus();
						var contentInput = $("#textClave")
								.parents(".valid-msg");
						$(contentInput).addClass("has-error");
						//$("#boxMsgx").append(infoHtml);
						$("#boxMsgx").html(infoHtml);
						$("#boxMsg").fadeIn("slow");
						$(".msgValidar").html(
								"Por favor, ingrese su contrase&ntilde;a");
					} else {
						$("#textClave").parents(".valid-msg").removeClass(
								"has-error");
						$("#boxMsg").fadeOut();
					}
				});

		$("#btnIniciarSesion")
				.click(
						function() {
							var infoHtml = "<div id='boxMsg' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert' aria-hidden='true'>×</button><span class='msgValidar'>Ha ocurrido un error en JavaScript ponerse en contacto con soporte.</span></div>";

							var txtUsuario = $("#textUsuario").val();
							var txtClave = $("#textClave").val();

							if (txtUsuario == "") {
								$("#textUsuario").focus();
								var contentInput = $("#textUsuario").parents(
										".valid-msg");
								$(contentInput).addClass("has-error");
								//$("#boxMsgx").append(infoHtml);
								$("#boxMsgx").html(infoHtml);
								$("#boxMsg").fadeIn("slow");
								$(".msgValidar")
										.html(
												"Por favor, ingrese el nombre de usuario");
								return false;
							}

							if (txtUsuario != "") {
								$("#textUsuario").parents(".valid-msg")
										.removeClass("has-error");
								$("#boxMsg").fadeOut();
							}

							if (txtClave == "") {
								$("#textClave").focus();
								var contentInput = $("#textClave").parents(
										".valid-msg");
								$(contentInput).addClass("has-error");
								//$("#boxMsgx").append(infoHtml);
								$("#boxMsgx").html(infoHtml);
								$("#boxMsg").fadeIn("slow");
								$(".msgValidar")
										.html(
												"Por favor, ingrese su contrase&ntilde;a");
								return false;
							}

							if (txtClave != "") {
								$("#textClave").parents("valid-msg")
										.removeClass("has-error");
								$("#boxMsg").fadeOut();
							}

						});

		$(document)
				.ready(
						function() {
							var infoHtml = "<div id='boxMsg' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert' aria-hidden='true'>×</button><span class='msgValidar'>Ups Ocurrio un error en JavaScript ponerse en contacto con soporte de imarpe.</span></div>"
							var msgErrorLogin = document
									.getElementById('msgErrorLogin').value;
							if (msgErrorLogin.length > 0) {
								//console.log("msgErrorLogin" + msgErrorLogin);
								document.getElementById('msgErrorLogin').style.display = 'block';
								//msg_advertencia(msgErrorLogin);
								//$("#boxMsgx").append(infoHtml);
								$("#boxMsgx").html(infoHtml);
								$("#boxMsg").fadeIn("slow");
								$(".msgValidar").html(msgErrorLogin);
							}
						});

		function nobackbutton() {

			window.location.hash = "no-back-button";
			window.location.hash = "Again-No-back-button"
			window.onhashchange = function() {
				window.location.hash = "no-back-button";
			}
			//window.location.hash = "";
			//window.location.hash = "";
			//window.onhashchange  = function(){window.location.hash="";}
		}
	</script>
</body>

</html>
