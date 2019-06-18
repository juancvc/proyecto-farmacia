function buscarPersonaPorDocumentoOperador() {

 //var tipoDocumento   = $('#tipoDocPersona_busqdato').val();
 var numeroDocumento = $('#numDocPersona_busqdato').val();


 var contextPath = $('#contextPathUrl').val();
 
 var masculino = document.getElementById('male');
 var femenino = document.getElementById('female');
 
 console.log("validarDni");
 
 $.ajax({
   type: "GET",
   //data: "entidad=" + entidad,
 //  url: contextPath+"/personaController/buscarPacienteReniec2?tipo="+tipoDocumento+"&numero="+numeroDocumento,
   url: contextPath+"/personaController/consultarPorDocumentoPersona?numero="+numeroDocumento,
  
   success: function(response){
   	if (numeroDocumento.length < 7) {
   	msg_advertencia("Número de documento incorrecto.");
}else{
   	
   	if(response.codigoDeError == 0000){ 
  //   $('#codigoPersona_instope').val(response.codigo);
  //   $('#nombresPersona_dato').val(response.apPrimer);
       $('#apellidoPaternoPersona_dato').val(response.apPrimer);
       $('#apellidoMaternoPersona_dato').val(response.apSegundo);
       
       if(response.prenomInscrito.indexOf(" ")>0){ 
       $('#primerNombrePersona_dato').val(response.prenomInscrito.substring(0,response.prenomInscrito.indexOf(" ")));
       $('#segundoNombrePersona_dato').val(response.prenomInscrito.substring(response.prenomInscrito.indexOf(" ")+1,response.prenomInscrito.length));
        }
     else { 
     
     $('#primerNombrePersona_dato').val(response.prenomInscrito.substring(0,response.prenomInscrito.length));
     $('#segundoNombrePersona_dato').val("");
       }
       
       $('#departamentoPersona_dato').val(response.noDepartamentoDomicilio);
       $('#distritoPersona_dato').val(response.noDistritoDomicilio);
       $('#direccion_dato').val(response.noDomicilio);
   //  $('#telefonoPersona_dato').val(response.telefono);
       $('#sexoPersona_dato').val(response.deGenero);
       $('#edadPersona_dato').val(response.feNacimiento);
       $('#edadAnioPersona_dato').val(response.feNacimiento);
       $('#edadMesPersona_dato').val(response.feNacimiento);
       $('#edadDiaPersona_dato').val(response.feNacimiento);
      if(response.deGenero === "1"){  
      masculino.checked = true;  
      femenino.checked = false;
     }
     else {   
      masculino.checked = false;  
      femenino.checked = true;
     }
     
     
     
     
     var stEdad = (response.feNacimiento.substring(6,8)+"-"+response.feNacimiento.substring(4,6)+"-"+response.feNacimiento.substring(0,4));
     var stEdad2 = (response.feNacimiento.substring(0,4)+"-"+response.feNacimiento.substring(4,6)+"-"+response.feNacimiento.substring(6,8));
     var anio =(response.feNacimiento.substring(0,4)+"-")
     var mess =(response.feNacimiento.substring(4,6)+"-")
     var diaa =(response.feNacimiento.substring(6,8))
     $('#fechaNac_dato').val(stEdad);
     $('#fechaNac2_dato').val(stEdad2);
     
      var fechaFinal ;
	 fechaFinal = new String(stEdad2);
  //console.log(validar_fecha(fechaFinal));
    if(validar_fecha(fechaFinal)==true)
    {
        // Si la fecha es correcta, calculamos la edad
        var values=fechaFinal.split("-");
        var dia = values[2];
        var mes = values[1];
        var ano = values[0];
 
        // cogemos los valores actuales
        var fecha_hoy = new Date();
        var ahora_ano = fecha_hoy.getYear();
        var ahora_mes = fecha_hoy.getMonth()+1;
        var ahora_dia = fecha_hoy.getDate();
 
        // realizamos el calculo
        var edad = (ahora_ano + 1900) - ano;
        if ( ahora_mes < mes )
        {
            edad--;
        }
        if ((mes == ahora_mes) && (ahora_dia < dia))
        {
            edad--;
        }
        if (edad > 1900)
        {
            edad -= 1900;
        }
 
        // calculamos los meses
        var meses=0;
        if(ahora_mes>mes)
            meses=ahora_mes-mes;
        if(ahora_mes<mes)
            meses=12-(mes-ahora_mes);
        if(ahora_mes==mes && dia>ahora_dia)
            meses=11;
 
        // calculamos los dias
        var dias=0;
        if(ahora_dia>dia)
            dias=ahora_dia-dia;
        if(ahora_dia<dia)
        {
            ultimoDiaMes=new Date(ahora_ano, ahora_mes, 0);
            dias=ultimoDiaMes.getDate()-(dia-ahora_dia);
        }
         
       $('#edadAniosPersona_dato').val(edad);
       $('#edadMesesPersona_dato').val(meses);
       $ ('#edadDiasPersona_dato').val(dias);
     
      }
  
  //  else{
   //     document.getElementById("result").innerHTML="La fecha "+fecha+" es incorrecta";
   // }
     
     
     
     
     
     
     
   //  calcularEdad("stEdad");

	 }else{
   	 msg_advertencia("¡No se encontraron registros.!")
   	 }
}
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

  //   function isValidDate(response.feNacimiento.substring(6,8),response.feNacimiento.substring(4,6),response.feNacimiento.substring(0,4))
   function isValidDate(year,month,day)
{
    var dteDate;

    month=month-1;
    dteDate=new Date(year,month,day);
    return ((day==dteDate.getDate()) && (month==dteDate.getMonth()) && (year==dteDate.getFullYear()));
    
}

 

function validar_fecha(fecha)
{
    var patron=new RegExp("^(19|20)+([0-9]{2})([-])([0-9]{1,2})([-])([0-9]{1,2})$");
 
    if(fecha.search(patron)==0)
    {
        var values=fecha.split("-");
        if(isValidDate(values[2],values[1],values[0]))
        {
            return true;
        }
    }
    return false;
}
 

function calcularEdad(fechaa)
{
     var fechaFinal ;
	 fechaFinal = new String(fechaa);
   // var fecha=document.getElementById("user_date").value;
    if(validate_fecha(fechaFinal)==true)
    {
        // Si la fecha es correcta, calculamos la edad
        var values=fechaFinal.split("-");
        var dia = values[2];
        var mes = values[1];
        var ano = values[0];
 
        // cogemos los valores actuales
        var fecha_hoy = new Date();
        var ahora_ano = fecha_hoy.getYear();
        var ahora_mes = fecha_hoy.getMonth()+1;
        var ahora_dia = fecha_hoy.getDate();
 
        // realizamos el calculo
        var edad = (ahora_ano + 1900) - ano;
        if ( ahora_mes < mes )
        {
            edad--;
        }
        if ((mes == ahora_mes) && (ahora_dia < dia))
        {
            edad--;
        }
        if (edad > 1900)
        {
            edad -= 1900;
        }
 
        // calculamos los meses
        var meses=0;
        if(ahora_mes>mes)
            meses=ahora_mes-mes;
        if(ahora_mes<mes)
            meses=12-(mes-ahora_mes);
        if(ahora_mes==mes && dia>ahora_dia)
            meses=11;
 
        // calculamos los dias
        var dias=0;
        if(ahora_dia>dia)
            dias=ahora_dia-dia;
        if(ahora_dia<dia)
        {
            ultimoDiaMes=new Date(ahora_ano, ahora_mes, 0);
            dias=ultimoDiaMes.getDate()-(dia-ahora_dia);
        }
         
       $('#edadAniosPersona_dato').val(edad);
       $('#edadMesesPersona_dato').val(meses);
       $ ('#edadDiasPersona_dato').val(dias);
         
         
         
   //     document.getElementById("result").innerHTML="Tienes "+edad+" años, "+meses+" meses y "+dias+" días";
    }
  
  //  else{
   //     document.getElementById("result").innerHTML="La fecha "+fecha+" es incorrecta";
   // }
}
     
     
     
     
     
     
     
     
     
     
   	