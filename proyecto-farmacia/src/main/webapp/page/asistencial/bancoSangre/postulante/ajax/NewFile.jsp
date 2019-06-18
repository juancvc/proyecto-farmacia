<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="es" ng-app="appManifiestoPrint" ng-controller="ManifiestoPrintController as vm">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Manifiesto</title>
  <script src="${pageContext.request.contextPath}/resources/js/angular.js" type="text/javascript"></script>
  <script src="${pageContext.request.contextPath}/resources/js/controller/manifiesto-print.js" charset="UTF-8">></script>
<style type="text/css">
.tabla{border-collapse:collapse;border-spacing:0;}
.tabla td{font-size:12px; border-style:solid;border-width:1px;overflow:hidden;word-break:normal;}
.tabla th{font-size:12px; border-style:solid;border-width:1px;overflow:hidden;word-break:normal;}
.t2 th{font-size:10px;}
.t3 td{font-size:10px;height:0.5cm;}
.t3 th{font-size:10px;height:0.5cm;}
.inline{float: left;}
.cuerpo{
  font-family: Arial,sans-serif;
}

.bold{
  font-weight: bold;
}
.textofantasma{
  color:white;
}
.bordered{
  border: 1px solid #333;
}
.whitetop{
  border-top-color: white;
}
.whitebottom{
  border-bottom-color: white;
}
.whiteleft{
  border-left-color: white;
}
.whiteright{
  border-right-color: white;
}
.center{
  text-align:center;
}
.to-left{
  float: left;
}
.to-right{
  float: right;
}
.vertical-line{
  border-left: 3px dotted #333 !important;
}
.ancho-tabla{
  /*width: 19.9cm;*/
  max-width: 19.9cm !important;
}
.ancho-fecha{
  width: 1.6cm !important;
}

</style>
</head>
<body class="cuerpo">

<div>
<table class="tabla t0" style="">
<colgroup>
<col style="width: 10.0cm">
<col style="width: 1.65cm">
<col style="width: 1.65cm">
<col style="width: 1.65cm">
<col style="width: 5.08cm">
</colgroup>
  <tr>
    <td class="" rowspan="4">
      <div class=" to-left"><img src="${pageContext.request.contextPath}/resources/img/airmajoro_logo.png" id="printlogo" height="79" width="179" /></div>
      <div class=" to-right"></div>
    </td>
    <td class="center" colspan="3" style="height: 0.3cm;"></td>
    <td class="center" rowspan="3" style="font-size: 24px;">{{vm.obj.mancbnserie + ' - '+vm.obj.mancbnforma}}</td>
  </tr>
  <tr class="bold center" style="height: 0.6cm;">
    <td class="center">DIA</td>
    <td class="center">MES</td>
    <td class="center">A&Ntilde;O</td>
  </tr>
  <tr class="center" style="height: 0.8cm;">
    <td class="center">{{vm.obj.fechaemisio.substring(0,2)}}</td>
    <td class="center">{{vm.obj.fechaemisio.substring(3,5)}}</td>
    <td class="center">{{vm.obj.fechaemisio.substring(6)}}</td>
  </tr>
  <tr>
    <td class="center bold" colspan="4">MANIFIESTO</td>
  </tr>
</table>

    <table class="tabla t1 ancho-tabla">
      <tr class="center bold">
        <td class="" style="width: 2.0cm;">VUELO N&#186;</td>
        <td class="" style="width: 4.4cm;">ORIGEN</td>
        <td class="" style="width: 3.5cm;">DESTINO</td>
        <td class="" style="width: 2.2cm;">AVION</td>
        <td class="" style="width: 4cm;">PILOTO</td>
        <td class="" style="width: 3.7cm;">COPILOTO</td>
      </tr>
      <tr class="center">
        <td class="">{{vm.obj.mancbnumvue}}</td>
        <td class="">{{vm.obj.nomlugorige}}</td>
        <td class="">{{vm.obj.nomlugdesti}}</td>
        <td class="" style="font-size: 9px;">{{vm.obj.aenavnomcom}}</td>
        <td class="">{{vm.obj.nombrepilot}}</td>
        <td class="">{{vm.obj.nombrecopil}}</td>
      </tr>
    </table>
    <table class="tabla t2 ancho-tabla">
      <thead>
        <tr>
          <th class="center" colspan="11" style="font-size: 20px;letter-spacing: 8px;font-weight: 500;">PASAJEROS</th>
        </tr>
        <tr class="center bold">
          <th class="" style="width: 8cm;" rowspan="3">APELLIDOS Y NOMBRES</th>
          <th class="" style="width: 2.60cm;" rowspan="3">DOC. IDENTIDAD</th>
          <th class="" style="width: 0.80cm;" rowspan="3">EDAD</th>
          <th class="" style="width: 0.80cm;font-stretch: condensed;" rowspan="3">PESO PSJRO</th>
          <th class="" style="width: 0.80cm;font-stretch: condensed;" rowspan="3">PESO EQUIP</th>
          <th class="" style="" colspan="5">N&#186; PASAJE</th>
          <th class="" style="width: 1.15cm;" rowspan="3">DESTINO</th>
        </tr>
        <tr class="center bold">
          <th class="" style="width: 1.45cm;" rowspan="2">N&#186; PASAJE</th>
          <th class="" style="width: 0.8cm;" rowspan="2">COD</th>
          <th class="" style="" colspan="2">IMPORTE</th>
          <th class="" style="width: 0.95cm;" rowspan="2">EMIS</th>
        </tr>
        <tr class="center bold">
          <th class="" style="width: 0.95cm;">CONT.</th>
          <th class="" style="width: 0.95cm;">CRED.</th>
        </tr>
      </thead>
      <tbody>
        <tr ng-repeat="item in vm.objLst" style="height: 17px;max-height: 17px;">
          <td class="" style="">{{$index+1}}   {{item.nompasajero}}</td>
          <td class="" style="">{{item.docpasajero}}</td>
          <td class="" style="">{{item.pasjeedadac}}</td>
          <td class="" style="">{{item.pasjepespsj}}</td>
          <td class="" style="">{{item.pasjepesequ}}</td>
          <td class="" style="font-size: 9px;">{{item.dorefnforma}}</td>
          <td class="" style="">{{item.t01tipopago}}</td>
          <td class="" style="">{{item.mandtimpcon}}</td>
          <td class="" style="">{{item.mandtimpcre}}</td>
          <td class="" style="">{{item.nomlugorige}}</td>
          <td class="" style="">{{item.nomlugdesti}}</td>
        </tr>
        <tr>
          <td class="center" colspan="3">TOTALES</td>
          <td class="" style=""></td>
          <td class="" style=""></td>
          <td class="" style=""></td>
          <td class="" style=""></td>
          <td class="" style=""></td>
          <td class="" style=""></td>
          <td class="" style=""></td>
          <td class="" style=""></td>
        </tr>
      </tbody>
    </table>
    <table class="ancho-tabla" style="border: 1px solid;width: 19.9cm;">
    <tr>
    <td>
    <!-- <div class="resumenInferior ancho-tabla" style="margin-top: 0.1cm;"> --><!-- style="margin-top: 12.1cm;" -->
      <div class=" to-left" style="margin-left: 0.1cm;margin-top: 0.55cm;">
        <table class="tabla t3">
          <tr>
            <th class="" colspan="5">RESUMEN</th>
          </tr>
          <tr style="height: 0.5cm;">
            <th class="" colspan="2">PESO</th>
            <th class="" colspan="3">IMPORTE</th>
          </tr>
          <tr>
            <td class="" style="width: ">PASAJERO</td>
            <td class="" style="width: 2.2cm;">193</td>
            <td class=""></td>
            <td class="" style="width: 2.0cm;">MN.</td>
            <td class="" style="width: 2.0cm;">ME.</td>
          </tr>
          <tr>
            <td class="" style="width: 2.2cm;">EQUIPAJE</td>
            <td class="" style="width: 2.2cm;">17</td>
            <td class="" style="width: 2.3cm;">TOTAL</td>
            <td class="" style="width: 2.0cm;"></td>
            <td class="" style="width: 2.0cm;"></td>
          </tr>
          <tr>
            <td class="" style="width: 2.2cm;">CARGA</td>
            <td class="" style="width: 2.2cm;">02</td>
            <td class="" style="width: 2.3cm;">COMISION</td>
            <td class="" style="width: 2.0cm;"></td>
            <td class="" style="width: 2.0cm;"></td>
          </tr>
          <tr>
            <td class="" style="width: 2.2cm;">TOTAL KG.</td>
            <td class="" style="width: 2.2cm;">217</td>
            <td class="" style="width: 2.3cm;">TOT. CREDITOS</td>
            <td class="" style="width: 2.0cm;"></td>
            <td class="" style="width: 2.0cm;"></td>
          </tr>
          <tr>
            <td class="" colspan="2"></td>
            <td class="" style="width: 2.3cm;">TOT. COMPANIA</td>
            <td class="" style="width: 2.0cm;"></td>
            <td class="" style="width: 2.0cm;"></td>
          </tr>
        </table>  
      </div>
      <div class=" to-right" style="margin-left: 0.2cm;margin-top: 0.7cm;">
        <div class="contadocredito" style="font-size: 9px;">
          <div class="inline" style="width: 1.73cm;">CONTADO S/. </div>
          <div class="inline bold center" style="width: 2.6cm;border-bottom: 1px solid;">{{vm.obj.importconta}}</div>
          <div class="inline" style="width: 1.61cm;">CREDITO S/. </div>
          <div class="inline bold center" style="width: 2.2cm;border-bottom: 1px solid;">{{vm.obj.importcredi}}</div>
        </div>
        <div class="horaoperacion" style="margin-top: 0.5cm;">
          <table class="center" style="font-size: 10px;border-collapse: collapse;">
            <tr>
              <td class="" style="width: 3.9cm;height: 0.35cm;border:1px solid;">HORA SALIDA</td>
              <td class="" style="width: 3.9cm;height: 0.35cm;border:1px solid;">HORA LLEGADA</td>
            </tr>
            <tr style="height:0.6cm;">
              <td style="border:1px solid;">{{vm.obj.horaopesali}}</td>
              <td style="border:1px solid;">{{vm.obj.horaopelleg}}</td>
            </tr>
          </table>
        </div>
        <div class="firma" style="margin-top: 0.9cm;font-size: 10px;">
          <div class="inline bold center" style="width: 3.6cm;border-top: 1px solid;">PILOTO</div>
          <div class="inline bold center" style="width: 3.6cm;border-top: 1px solid;margin-left: 0.8cm;">HECHO POR</div>
        </div>
        <div class="realizadopor">
          
        </div>
      </div>
    <!-- </div> -->
    </td>
    </tr>
    </table>
  </div>
</body>
<script type="text/javascript">
  function printThis(){
    window.print();
  }
</script>
</html>