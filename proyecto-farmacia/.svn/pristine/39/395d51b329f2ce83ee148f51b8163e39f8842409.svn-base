/**
 * 
 */


function convertirFecha(fecha){
	var strFecha="";
	var fecha = new Date(fecha);
		var dia="";
		var mes="";
		if(fecha.getDate().toString().length==1){
				dia="0"+fecha.getDate().toString();
			}else{
				dia=fecha.getDate().toString();
				}
		if(fecha.getMonth().toString().length==1){
			mes="0"+(fecha.getMonth()+1);
		}else{
			mes=fecha.getMonth().toString();
			}
		return strFecha=dia+"/"+mes +"/"+fecha.getFullYear();
}
function fechaCorrecta(fecha1, fecha2){

    //Split de las fechas recibidas para separarlas
    var x = fecha1.split("/");
    var z = fecha2.split("/");

    //Cambiamos el orden al formato americano, de esto dd/mm/yyyy a esto mm/dd/yyyy
    fecha1 = x[1] + "/" + x[0] + "/" + x[2];
    fecha2 = z[1] + "/" + z[0] + "/" + z[2];

    //Comparamos las fechas
    if (Date.parse(fecha1) < Date.parse(fecha2)){
        return false;
    }else{
        return true;
    }
}
	function IsNumeric(valor) {
		var log = valor.length;
		var sw = "S";
		for (x = 0; x < log; x++) {
			v1 = valor.substr(x, 1);
			v2 = parseInt(v1);
			//Compruebo si es un valor numérico
			if (isNaN(v2)) {
				sw = "N";
			}
		}
		if (sw == "S") {
			return true;
		} else {
			return false;
		}
	}
	
var primerslap = false;
var segundoslap = false;

function formateafechaNacimiento(fecha) {
	var fechaActual = new Date();
	var long = fecha.length;
	var dia;
	var mes;
	var ano;
	if ((long >= 2) && (primerslap == false)) {
		dia = fecha.substr(0, 2);
		if ((IsNumeric(dia) == true) && (dia <= 31)
				&& (dia != "00")) {
			fecha = fecha.substr(0, 2) + "/" + fecha.substr(3, 7);
			primerslap = true;
		} else {
			fecha = "";
			primerslap = false;
		}
	} else {
		dia = fecha.substr(0, 1);
		if (IsNumeric(dia) == false) {
			fecha = "";
		}
		if ((long <= 2) && (primerslap = true)) {
			fecha = fecha.substr(0, 1);
			primerslap = false;
		}
	}
	if ((long >= 5) && (segundoslap == false)) {
		mes = fecha.substr(3, 2);
		if ((IsNumeric(mes) == true) && (mes <= 12)
				&& (mes != "00")) {
			fecha = fecha.substr(0, 5) + "/" + fecha.substr(6, 4);
			segundoslap = true;
		} else {
			fecha = fecha.substr(0, 3);
			;
			segundoslap = false;
		}
	} else {
		if ((long <= 5) && (segundoslap = true)) {
			fecha = fecha.substr(0, 4);
			segundoslap = false;
		}
	}
	if (long >= 7) {
		ano = fecha.substr(6, 4);
		if (IsNumeric(ano) == false) {
			fecha = fecha.substr(0, 6);
		} else {
			if (long == 10) {
				if ((ano == 0) || (ano < 1900) || (ano > 2100)) {
					fecha = fecha.substr(0, 6);
				}
			}
		}
	}
	if (long >= 10) {
		fecha = fecha.substr(0, 10);
		dia = fecha.substr(0, 2);
		mes = fecha.substr(3, 2);
		ano = fecha.substr(6, 4);
		// Año no viciesto y es febrero y el dia es mayor a 28
		if ((ano % 4 != 0) && (mes == 02) && (dia > 28)) {
			fecha = fecha.substr(0, 2) + "/";
		}
	}
	if(fecha.length==10){

		console.log(fecha.length);


		if(fechaCorrecta(fecha,convertirFecha(fechaActual))==true){
			fecha = convertirFecha(fechaActual);
			msg_advertencia("La fecha no puede ser mayor a la actual");


		}
	}


	return (fecha);
}


function formateafecha(fecha) {
	var fechaActual = new Date();
	var long = fecha.length;
	var dia;
	var mes;
	var ano;
	if ((long >= 2) && (primerslap == false)) {
		dia = fecha.substr(0, 2);
		if ((IsNumeric(dia) == true) && (dia <= 31)
				&& (dia != "00")) {
			fecha = fecha.substr(0, 2) + "/" + fecha.substr(3, 7);
			primerslap = true;
		} else {
			fecha = "";
			primerslap = false;
		}
	} else {
		dia = fecha.substr(0, 1);
		if (IsNumeric(dia) == false) {
			fecha = "";
		}
		if ((long <= 2) && (primerslap = true)) {
			fecha = fecha.substr(0, 1);
			primerslap = false;
		}
	}
	if ((long >= 5) && (segundoslap == false)) {
		mes = fecha.substr(3, 2);
		if ((IsNumeric(mes) == true) && (mes <= 12)
				&& (mes != "00")) {
			fecha = fecha.substr(0, 5) + "/" + fecha.substr(6, 4);
			segundoslap = true;
		} else {
			fecha = fecha.substr(0, 3);
			;
			segundoslap = false;
		}
	} else {
		if ((long <= 5) && (segundoslap = true)) {
			fecha = fecha.substr(0, 4);
			segundoslap = false;
		}
	}
	if (long >= 7) {
		ano = fecha.substr(6, 4);
		if (IsNumeric(ano) == false) {
			fecha = fecha.substr(0, 6);
		} else {
			if (long == 10) {
				if ((ano == 0) || (ano < 1900) || (ano > 2100)) {
					fecha = fecha.substr(0, 6);
				}
			}
		}
	}
	if (long >= 10) {
		fecha = fecha.substr(0, 10);
		dia = fecha.substr(0, 2);
		mes = fecha.substr(3, 2);
		ano = fecha.substr(6, 4);
		// Año no viciesto y es febrero y el dia es mayor a 28
		if ((ano % 4 != 0) && (mes == 02) && (dia > 28)) {
			fecha = fecha.substr(0, 2) + "/";
		}
	} 
	return (fecha);
}


function decimales(evt,input){ 
    // Backspace = 8, Enter = 13, ‘0′ = 48, ‘9′ = 57, ‘.’ = 46, ‘-’ = 43
    var key = window.Event ? evt.which : evt.keyCode;    
    var chark = String.fromCharCode(key);
    var tempValue = input.value+chark;
    if(key >= 48 && key <= 57){
        if(filter(tempValue)=== false){
            return false;
        }else{       
            return true;
        }
    }else{
          if(key == 8 || key == 13 || key == 0) {     
              return true;              
          }else if(key == 46){
                if(filter(tempValue)=== false){
                    return false;
                }else{       
                    return true;
                }
          }else{
              return false;
          }
    }
}

function fracciones(evt,input){
	//debugger;
    // Backspace = 8, Enter = 13, ‘0′ = 48, ‘9′ = 57, ‘.’ = 46, ‘-’ = 43
    var key = window.Event ? evt.which : evt.keyCode;    
    var chark = String.fromCharCode(key);
    var tempValue = input.value+chark;
    if(key >= 48 && key <= 57){
        if(filterFracciones(tempValue)=== false){
            return false;
        }else{       
            return true;
        }
    }else{
          if(key == 8 || key == 13 || key == 0) {     
              return true;              
          }else if(key == 46 || key == 47){
                if(filterFracciones(tempValue)=== false){
                    return false;
                }else{       
                    return true;
                }
          }else{
              return false;
          }
    }
}
function filterFracciones(__val__){
	
    var preg = /^([0-9]+\/?[0-9]{0,2})$/; 
    if(preg.test(__val__) === true){
        return true;
    }else{
       return false;
    }
    
}
function filter(__val__){
    var preg = /^([0-9]+\.?[0-9]{0,2})$/; 
    if(preg.test(__val__) === true){
        return true;
    }else{
       return false;
    }
    
}

function soloNumeros(e){

	var key = window.Event ? e.which : e.keyCode

	return (key >= 48 && key <= 57 )

}
 
