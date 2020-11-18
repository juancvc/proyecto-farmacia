<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

	
	<div id="politicaDialog">
    <div id="menus" style="margin-bottom:10px">
        <div id="menuGrid" class="menuBar cornerAll">
            <div>
                <ul>
                    <li style="float:left;" id="li_volver"><a href="#" title="<fmt:message key="comun.volver" />" onclick="politicaDialogo.dialog('close');" class="volver cornerAll"></a></li>
                </ul>
                <ul>
                    <li style="float:right; margin-right:5px;" id="li_imprimir"><a class="imprimir cornerAll" onclick="$('#politicaContent').printThis();" title="Imprimir" href="#"></a></li>
                </ul>
            </div>
            <div class="limpiar"></div>
        </div>
    </div>
    <div id="politicaContent" style="border:1px solid #AAAAAA; margin: 5px; padding: 0.2em">
    </div>
</div>						
<script type="text/javascript">

    var politicaDialogo;

    var w = 800;
    if (($(window).width()-40)<w){
        w=$(window).width()-40;
    }
    var h = 1000;
    if (($(window).height()-40)<h){
        h=$(window).height()-40;
    }

    $(document).ready(function(){
        politicaDialogo=$("#politicaDialog").dialog({
            width: w,
            height: h,
            modal: true,
            autoOpen: false,
            closeOnEscape: false,
            resizable: false,
            title: '<fmt:message key="comun.dialogo.politica" />',
            close: function(event, ui) {
                politicaDialogo.hide();
            }
        });

        //Esto se pone porque en alguna ocasion el dialog aparece directamente abierto
        politicaDialogo.dialog('close');
    });


    function mostrarPolitica(tpproceso) {
        console.log("Estoy aqui");
        $.post("politica.html",
            { action: 'mostrarPolitica', tpProceso: tpproceso, osc: Math.random()},
                function(respuesta) {
                    if (respuesta.error){
                        alert('<fmt:message key="comun.error.cargar" />');
                    }
                    else{
                        //$("#politicaContent").html(respuesta.content);
                    }                   
                }
            , "json"
        );
        document.getElementById('politicaDialog').style.display="block";
        politicaDialogo.dialog('open');
    };  

</script>	
 