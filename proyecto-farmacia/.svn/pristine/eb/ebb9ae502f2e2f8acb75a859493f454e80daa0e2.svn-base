<%@page session="true" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html lang="en" data-textdirection="ltr" class="loading">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <meta name="description" content="Login HNCHReferencia">
    <meta name="keywords" content="login, admin">
    <meta name="author" content="HNCH">
    <title>Login HNCHReferencia</title>

    <link rel="apple-touch-icon" href="${pageContext.request.contextPath}/app-assets/images/ico/apple-icon-120.png">
    <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/app-assets/images/ico/favicon.ico">

    <link href="https://fonts.googleapis.com/css?family=Montserrat:300,300i,400,400i,500,500i%7COpen+Sans:300,300i,400,400i,600,600i,700,700i" rel="stylesheet">
    <!-- BEGIN VENDOR CSS-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/fonts/feather/style.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/fonts/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/fonts/flag-icon-css/css/flag-icon.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/vendors/css/extensions/pace.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/vendors/css/forms/icheck/icheck.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/vendors/css/forms/icheck/custom.css">
    <!-- END VENDOR CSS-->
    <!-- BEGIN STACK CSS-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/bootstrap-extended.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/app.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/colors.css">
    <!-- END STACK CSS-->
    <!-- BEGIN Page Level CSS-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/core/menu/menu-types/vertical-menu.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/core/menu/menu-types/vertical-overlay-menu.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/css/pages/login-register.css">
    <!-- END Page Level CSS-->
    <!-- BEGIN Custom CSS-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/base-natigu.css">
    <!-- END Custom CSS-->

    <style>
        .has-error .form-control {
	    	border-color: #a94442!important;
	    	-webkit-box-shadow: none;
	    	box-shadow: none;
		}
        body{
            background: url(${pageContext.request.contextPath}/assets/img/bg-fondo.jpg);
            background-size: cover;
        }
        #img-logo{
            background: url(${pageContext.request.contextPath}/assets/img/logo_minsa_grande.jpg)no-repeat;
            background-size: cover;
            background-position: center;
            background-origin: border-box;
        }
        #box-main-logo #img-logo{
            position: relative;
        }
        #div-info{
            background: rgba(0,0,0,0.5);
            position: absolute;
            padding: 30px;
            bottom: 0;
            top:0;
        }
        #div-info h3, #div-info p{
            color:#fff;
            text-align: justify;
        }
    </style>

  </head>
  <body data-open="click" data-menu="vertical-menu" data-col="1-column" class="vertical-layout vertical-menu 1-column  blank-page blank-page" onload="nobackbutton();">
    <!-- ////////////////////////////////////////////////////////////////////////////-->
    <div class="app-content content container-fluid">
      <div class="content-wrapper">
        <div class="content-header row">
        </div>
        <div class="content-body"><section class="flexbox-container">
            <div id="box-main-logo" class="box-shadow-2 p-0">
                <div id="img-logo">

                </div>
                <div id="content-logo">
                    <div class="card border-grey border-lighten-3 m-0">
                        <div class="card-header no-border pt-3">
                            <div class="content-ix col-md-6 col-sm-12 pt-2 pb-3">
                                <div class="card-title text-xs-center pb-3">
                                    <div class="p-1"><img src="${pageContext.request.contextPath}/assets/img/LOGODECABECERAWEB.jpg" class="img-fluid" alt="branding logo"></div>
                                </div>
                                <h6 class="card-subtitle line-on-side text-muted text-xs-center font-small-3 mb-0 pb-0 pt-2 ml-2 mr-2"><span>Iniciar sesi&oacute;n </span></h6>
                                <div class="card-body collapse in">
                                    <div class="card-block">
                                        <f:form class="form-horizontal form-simple" role="form" action="${pageContext.request.contextPath}/inicioController/controlAcceso">
                                            <input type="text" id="msgErrorLogin" value="${msgErrorLogin}" style="display: none !important;">
                                            <input id="Mensaje" type="hidden" value="${Mensaje}">
                                            <fieldset class="form-group position-relative has-icon-left mb-0 valid-msg">
                                                <f:input type="text"
                                                         class="form-control form-control-lg input-lg"
                                                         id="textUsuario"
                                                         path="nombreUsuario"
                                                         placeholder="Tu usuario"
                                                         required="true"/>
                                                <div class="form-control-position">
                                                    <i class="ft-user"></i>
                                                </div>
                                            </fieldset>
                                            <fieldset class="form-group position-relative has-icon-left valid-msg">
                                                <f:input type="password"
                                                         class="form-control form-control-lg input-lg"
                                                         id="textClave"
                                                         path="contrasena"
                                                         placeholder="Ingresar contrasena"
                                                         required="true"/>
                                                <div class="form-control-position">
                                                    <i class="fa fa-key"></i>
                                                </div>
                                            </fieldset>

                                            <div id="boxMsgx"></div>

                                            <!-- <a href="inicio.jsp" class="btn btn-primary btn-lg" title=""><i class="ft-unlock"></i> Iniciar</a> -->
                                            <button id="btnIniciarSesion" type="submit" class="btn btn-primary btn-lg btn-block"><i class="ft-unlock"></i> Iniciar</button>
                                        </f:form>
                                    </div>
                                </div>
                            </div>
                            <div id="box-info-kumitsari"  class="content-ix col-md-6 col-sm-12 pt-2 pb-3">
                                <div class="pl-2 pr-2" style="border-left: 1px solid #eee">
                                    <h3 class="text-center mb-1">Bienvenidos al sistema de referencia y Contrarreferencia web del Hospital Cayetano Heredia</h3>
                                    <p class="text-justify">
                         Ingreso de registro de referencia y contrarreferencia en todos los establecimientos que integran la red entidades prestadoras de salud
                                 <!--     Kumitsari es un programa informático que te permite reforzar tus habilidades comunicativas en lengua originaria y castellano. Encontrarás lecciones desde el nivel básico hasta el avanzado y aprenderás jugando. En cada unidad podrás interactuar con tu mascota virtual, quien te ayudará a superar cada ejercicio. Podrás juntar monedas por cada actividad resuelta correctamente y con ellas comprar diversos premios en la tienda virtual.-->
                                    <br>
                                    <br>
                                <!--     Por ello, ¡explora, diviértete y aprende!-->
                                    </p>
                                </div>
                            </div>
                        </div>

                        <div class="card-footer">
                            <div class="">
                                <!-- <p class="float-sm-left text-xs-center m-0"><a href="recordar-contrasenia.jsp" class="card-link">Recuperar contrase&ntilde;a</a></p> -->
                            </div>
                        </div>
                    </div>
                </div>
            </div>
</section>

        </div>
      </div>
    </div>
    <!-- ////////////////////////////////////////////////////////////////////////////-->

    <!-- BEGIN VENDOR JS-->
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/vendors.min.js" type="text/javascript"></script>
    <!-- BEGIN VENDOR JS-->
    <!-- BEGIN PAGE VENDOR JS-->
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/icheck/icheck.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/validation/jqBootstrapValidation.js" type="text/javascript"></script>
    <!-- END PAGE VENDOR JS-->
    <!-- BEGIN STACK JS-->
    <script src="${pageContext.request.contextPath}/app-assets/js/core/app-menu.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/app-assets/js/core/app.js" type="text/javascript"></script>
    <!-- END STACK JS-->
    <!-- BEGIN PAGE LEVEL JS-->
    <script src="${pageContext.request.contextPath}/app-assets/js/scripts/forms/form-login-register.js" type="text/javascript"></script>
    <!-- END PAGE LEVEL JS-->


    <script type="text/javascript" charset="utf-8">
        var infoHtml = "<div id='boxMsg' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert' aria-hidden='true'>×</button><span class='msgValidar'>Ha ocurrido un error en JavaScript ponerse en contacto con soporte.</span></div>";

        $("#textUsuario, #textClave").keyup(function(){
            if( $("#textUsuario").val() == "" ){
                $("#textUsuario").focus();
                var contentInput = $("#textUsuario").parents(".valid-msg");
                $(contentInput).addClass("has-error");
                //$("#boxMsgx").append(infoHtml);
                $("#boxMsgx").html(infoHtml);
                $("#boxMsg").fadeIn("slow");
                $(".msgValidar").html("Por favor, ingrese el nombre de usuario");
            }else{
                $("#textUsuario").parents(".valid-msg").removeClass("has-error");
                $("#boxMsg").fadeOut();
            }
        });

        $("#textClave").keyup(function(){
            if( $("#textClave").val() == "" ){
                $("#textClave").focus();
                var contentInput = $("#textClave").parents(".valid-msg");
                $(contentInput).addClass("has-error");
                //$("#boxMsgx").append(infoHtml);
                $("#boxMsgx").html(infoHtml);
                $("#boxMsg").fadeIn("slow");
                $(".msgValidar").html("Por favor, ingrese su contrase&ntilde;a");
            }else{
                $("#textClave").parents(".valid-msg").removeClass("has-error");
                $("#boxMsg").fadeOut();
            }
        });

        $("#btnIniciarSesion").click(function (){
            var infoHtml = "<div id='boxMsg' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert' aria-hidden='true'>×</button><span class='msgValidar'>Ha ocurrido un error en JavaScript ponerse en contacto con soporte.</span></div>";

            var txtUsuario = $("#textUsuario").val();
            var txtClave = $("#textClave").val();

            if( txtUsuario == ""){
                $("#textUsuario").focus();
                var contentInput = $("#textUsuario").parents(".valid-msg");
                $(contentInput).addClass("has-error");
                //$("#boxMsgx").append(infoHtml);
                $("#boxMsgx").html(infoHtml);
                $("#boxMsg").fadeIn("slow");
                $(".msgValidar").html("Por favor, ingrese el nombre de usuario");
                return false;
            }

            if(txtUsuario != ""){
                $("#textUsuario").parents(".valid-msg").removeClass("has-error");
                $("#boxMsg").fadeOut();
            }


            if(txtClave == ""){
                $("#textClave").focus();
                var contentInput = $("#textClave").parents(".valid-msg");
                $(contentInput).addClass("has-error");
                //$("#boxMsgx").append(infoHtml);
                $("#boxMsgx").html(infoHtml);
                $("#boxMsg").fadeIn("slow");
                $(".msgValidar").html("Por favor, ingrese su contrase&ntilde;a");
                return false;
            }

            if(txtClave != ""){
                $("#textClave").parents("valid-msg").removeClass("has-error");
                $("#boxMsg").fadeOut();
            }

        });

		$(document).ready(function() {
            var infoHtml = "<div id='boxMsg' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert' aria-hidden='true'>×</button><span class='msgValidar'>Ups Ocurrio un error en JavaScript ponerse en contacto con soporte de imarpe.</span></div>"
			var msgErrorLogin=document.getElementById('msgErrorLogin').value;
			if(msgErrorLogin.length>0){
                //$("#boxMsgx").append(infoHtml);
                $("#boxMsgx").html(infoHtml);
                $("#boxMsg").fadeIn("slow");
                $(".msgValidar").html(msgErrorLogin);
			}
		});

		function nobackbutton(){

		    window.location.hash = "no-back-button";
		    window.location.hash = "Again-No-back-button"
		    window.onhashchange  = function(){window.location.hash="no-back-button";}
			//window.location.hash = "";
			//window.location.hash = "";
		    //window.onhashchange  = function(){window.location.hash="";}
		}

	</script>

  </body>
</html>