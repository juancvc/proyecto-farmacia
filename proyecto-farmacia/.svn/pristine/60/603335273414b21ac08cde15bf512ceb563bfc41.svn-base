<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-assets/vendors/css/forms/selects/select2.min.css">





</head>
<body>
<form>             
<select  name="selection[]" class="selection" multiple ="multiple" style="width: 509px; height: 26px">
	<option value="AN">ANESTESIOLOGIA</option>
	<option value="CA">CARDIOLOGIA</option>
	<option value="RE">REUMATOLOGIA</option>
	<option value="MF">MEDICINA FISICA</option>
	<option value="MG">MEDICINA GENERAL</option>
	<option value="NE">NEFROLOGIA</option>
					</select>
 </form> 
   <div class="form-group col-md-6 mb-2">
		                                                <label for="cboInstRptInscr">Instituci&oacute;n</label>
		                                                <select id="cboInstRptInscr" class="form-control select-del">
															<option value="0" label="Seleccionarr" />
															<c:forEach var="item" items="${lstMaestra}">
                                                            	<option value="${item.valor4}" label="${item.nombreLargo}"/>
                                                            </c:forEach>
														</select>
		                                            </div>

     <script src="${pageContext.request.contextPath}/app-assets/vendors/js/tables/jquery-3.2.1.min.js" type="text/javascript"></script>
     <script src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/select/select2.min.js" type="text/javascript"></script>
     <script type="text/javascript"> $(".selection").select2();</script>
     <div class="container">
     <table border="1">
    <thead >
      <tr >
        <th class="col-xs-3" style="width: 372px; ">Descripción</th>
        <th class="col-xs-3" style="width: 65px; ">Siglas</th>
        <th class="col-xs-3" style="width: 168px; ">unidad de Medida</th>
        <th class="col-xs-3" style="width: 171px; ">Valor Obtenido</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td class="col-xs-2" value="000001" style="width: 276px; ">PESO</td>
        <td class="col-xs-3">W</td>
        <td class="col-xs-3"align="center" style="width: 149px; ">KG</td>
        <td class="col-xs-3" style="width: 162px; "> <input type="text" name="user_date" id="user_date" />
      </tr>    
 
      <tr>
        <td class="col-xs-3"value="000002">TALLA</td>
        <td class="col-xs-3">T</td>
        <td class="col-xs-6"align="center">CM</td>
        <td class="col-xs-3"> <input type="text" name="user_date" id="user_date" />
      </tr>
      
        <tr>
        <td class="col-xs-3"value="000003">PRESION ARTERIAL</td>
        <td class="col-xs-3">PA</td>
        <td class="col-xs-6"align="center">mmHg</td>
        <td class="col-xs-3"> <input type="text" name="user_date" id="user_date" />
      </tr>
    
          <tr>
        <td class="col-xs-3"value="000004">PRESION ARTERIAL MEDIA</td>
        <td class="col-xs-3">PAM</td>
        <td class="col-xs-6"align="center">mmHg</td>
        <td class="col-xs-3"> <input type="text" name="user_date" id="user_date" />
      </tr>
      
          <tr>
        <td class="col-xs-3"value="000005">FRECUENCIA CARDIACA</td>
        <td class="col-xs-3">FC</td>
        <td class="col-xs-6"align="center">LATIDOS X MIN</td>
        <td class="col-xs-3"> <input type="text" name="user_date" id="user_date" />
      </tr>
        <tr>
        <td class="col-xs-3"value="000006">FRECUENCIA RESPIRATORIA</td>
        <td class="col-xs-3">FR</td>
        <td class="col-xs-6"align="center">RESP X MIN</td>
        <td class="col-xs-3"> <input type="text" name="user_date" id="user_date" />
      </tr>
      
        <tr>
        <td class="col-xs-3"value="000007">TEMPERATURA</td>
        <td class="col-xs-3">TEMP</td>
        <td class="col-xs-6" align="center">°C</td>
        <td class="col-xs-3"> <input type="text" name="user_date" id="user_date" />
      </tr>
 
         <tr>
        <td class="col-xs-3"value="000008">FRACCION INSPIRATORIA DE OXIGENO</td>
        <td class="col-xs-3">FIO2</td>
        <td class="col-xs-6" align="center">%</td>
        <td class="col-xs-3"> <input type="text" name="user_date" id="user_date" />
      </tr>
       <tr>
        <td class="col-xs-3"value="000009">SATURACION OXIGENO</td>
        <td class="col-xs-3">SAT02</td>
        <td class="col-xs-6" align="center">%</td>
        <td class="col-xs-3"> <input type="text" name="user_date" id="user_date" />
      </tr>
      
      <tr>
        <td class="col-xs-3"value="000010">PRESION ARTERIAL DE OXIGENO</td>
        <td class="col-xs-3">PA02</td>
        <td class="col-xs-6" align="center">mmHg</td>
        <td class="col-xs-3"> <input type="text" name="user_date" id="user_date" />
      </tr>
      
          <tr>
        <td class="col-xs-3"value="000011">PRESION VENOSA CENTRAL</td>
        <td class="col-xs-3">PVC</td>
        <td class="col-xs-6" align="center">mmHg</td>
        <td class="col-xs-3"> <input type="text" name="user_date" id="user_date" />
      </tr>
      
         <tr>
        <td class="col-xs-3"value="000012">FLUJO URINARIO</td>
        <td class="col-xs-3">FU</td>
        <td class="col-xs-6" align="center">ml/min</td>
        <td class="col-xs-3"> <input type="text" name="user_date" id="user_date" />
      </tr>
      
        <tr>
        <td class="col-xs-3"value="000013">PRESION ARTERIAL SISTÓLICA</td>
        <td class="col-xs-3">PA SIS</td>
        <td class="col-xs-6" align="center">mmHg</td>
        <td class="col-xs-3"> <input type="text" name="user_date" id="user_date" />
      </tr>
       <tr>
        <td class="col-xs-3"value="000013">PRESION ARTERIAL DIASTÓLICA</td>
        <td class="col-xs-3">PA DIA</td>
        <td class="col-xs-6" align="center">mmHg</td>
        <td class="col-xs-3"> <input type="text" name="user_date" id="user_date" />
      </tr>
      
    </tbody>
  </table>
     </div>
</body>
</html>