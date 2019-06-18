data = ""; 
var medicos = []; 
function listaReferencias() {
	// debugger;
	var contextPath = $('#contextPath').val();
	path = contextPath + "/citasController/referenciasModal";
	// alert("path " + path)
	$.ajax({
		type : "POST",
		url : path,
		success : function(data) {
			// console.log("SUCCESS: ", data);
			$("#modalReferencias").html(data);
			$("#modalReferencias").modal('show');

		},
		error : function(request, status, error) {
			console.log("ERROR: " + error);
		}
	});
}

function llenarRefIndex(index) {
	 
	var contextPath = $('#contextPath').val();
	var htmlTabla = "";
	var item = 0;
	var valida = "0"; 
	$
			.ajax({
				type : "GET",
				// data: "entidad=" + entidad,

				url : contextPath + "/citasController/obtenerReferencia?index="
						+ index,
				success : function(data) {
					if (data != null) {
						$("#idBtnCerrarModalReferencia").trigger("click");
						$('#txtPacienteReferencia').val(data.paciente.persona.nombreCompleto);
						$('#txtTipoPacienteRef').val(data.tipoSeguro.nombreCorto);
						$('#txtNroReferencia').val(data.numeroReferencia);
						$('#txtEstablecimientoOrigenReferencia').val(data.establecimientoOrige.nomRenaes);
						$('#cboEspecialidad').empty();
						
						$('#codPacienteRef').val(data.paciente.codigoPacienteSigeho);
						$('#nroDocumentoRef').val(data.paciente.persona.nroDocumento);
						$('#codigoFinaciadorRef').val(data.paciente.tipoSeguro.codReg);
						$('#cboEspecialidad').append($('<option>', { 
						       	value: "",
						       	text : "Seleccione"
						   	}));
	  					if (data.listEspecialidades != null) {
	  						for (var i = 0; i < data.listEspecialidades.length; i++) {
	  							
	  							$('#cboEspecialidad').append($('<option>', { 
	  						       	value: data.listEspecialidades[i].codReg,
	  						       	text : data.listEspecialidades[i].nombreCorto
	  						   	}));
	  						}
	  					}
	  					for (i = 1; i <= 42; i++) { 
	  						 document.getElementById("calendarContainer-day-num-"+i).className = "";
	  					  
	  					}
	  					/*
							 * else{ $('#cboEspecialidad').append($('<option>', {
							 * value: '0', text : 'Seleccione' })); }
							 */
					}else{
						// console.log("data es null");
					}

				},
				error : function(xhr, status, er) {
					console.log("error: " + xhr + " status: " + status + " er:"
							+ er);
					if (xhr.status == 500) {
						console.log(er);
						// Error_500(er);
					}
					if (xhr.status == 901) {
						console.log(er);
						// spire_session_901(er);
					}

				}
			});
}

var organizer = new Organizer("organizerContainer", calendar);

function cargarModalPaciente (codigoDH, nombreMedico){
//	console.log("cargarModalPaciente");
	
	var contextPath = $('#contextPath').val();
	var dia = calendar.date.getDate();
	var mes = calendar.date.getMonth()+1; // January is 0!
	var anio = calendar.date.getFullYear(); 
	
	if (dia.toString().length == 1) {
		dia = "0"+dia;
	}
	if (mes.toString().length == 1) {
		mes = "0"+mes;
	}
//	console.log("dia/" + dia+"mes "+ mes+" anio " + anio);

	var fecha = dia+"/"+mes+"/"+anio
	$
	.ajax({
		type : "POST",
		// data: "entidad=" + entidad,

		url : contextPath + "/citasController/pacienteCitaModal?codigoDH="+codigoDH,
		success : function(data) { 
			console.log("$('#txtNroReferencia').val()" + $('#txtNroReferencia').val());
			$("#modalPacientes").html(data);
			$("#modalPacientes").modal('show');
			$('#nombrePaciente').val($('#txtPacienteReferencia').val());
			$('#pacnumeroReferencia').val($('#txtNroReferencia').val());
			//$('#txtNroReferencia').val($('#numeroReferencia').val());
			$('#tipoPaciente').val($('#txtTipoPacienteRef').val());
			$('#nombreMedico').val(nombreMedico);
			$('#fechaCita').val(fecha); 
			$('#fechaProgramacion').val(fecha); 
			$('#codPaciente').val($('#codPacienteRef').val());
			$('#nroDocumento').val($('#nroDocumentoRef').val());
			$('#codigoFinaciador').val($('#codigoFinaciadorRef').val());
			
			var el = document.getElementById('cboEspecialidad');
			var text = el.options[el.selectedIndex].innerHTML; 
			$('#especialidad').val(text);
			$('#codEspecialidad').val($('#cboEspecialidad').val());
		},
		error : function(xhr, status, er) {
			console.log("error: " + xhr + " status: " + status + " er:"
					+ er);
			if (xhr.status == 500) {
				console.log(er);
				// Error_500(er);
			}
			if (xhr.status == 901) {
				console.log(er);
				// spire_session_901(er);
			}

		}
	});
}

function eventos(){ 
currentDay = calendar.date.getDate(); // used this in order to make anyday
										// today depending on the current today
// console.log("currentDay " + calendar.date);
 
var item = 0; 
var contextPath = $('#contextPath').val();
var cboEspecialidad = $('#cboEspecialidad').val();

var dia = calendar.date.getDate();
var mes = calendar.date.getMonth()+1; // January is 0!
var anio = calendar.date.getFullYear();

var nDia = dia.toString().length;

var content = "";  


console.log(" nDia:: " + nDia);

if (dia.toString().length == 1) {
	dia = "0"+dia;
}
if (mes.toString().length == 1) {
	mes = "0"+mes;
}
console.log("dia/" + dia+"mes "+ mes+" anio " + anio);

var fecha = dia+"/"+mes+"/"+anio
// $('#personalFechaNac').val(dia+"/"+mes+"/"+anio);
var idOrganizador = "organizerContainer";
var cantidad = "0";
// console.log("calendarContainer-day-num-32" +
// document.getElementById("calendarContainer-day-num-32").innerHTML);
content = '<li style="background-color:#808080"><div><span style="color:white" class="organizerContainer time" id="' +   '-list-item-' + i + '-time">' 
		    + 'TURNO </span><span class="' + ' m" id="'  + '-list-item-' + i + '-m">'  
		    + '</span></div><p style="color:white" id="organizerContainer-list-item-0-text">NOMBRE MÉDICO</p></li>';
$
.ajax({
	type : "GET",
	// data: "entidad=" + entidad,

	url : contextPath + "/citasController/obtenerListaMedicos?codigoEspecialidad="
			+ cboEspecialidad + "&fecha=" + fecha,
	success : function(data) {
		if (data != null) {
			
			for (var i = 0; i < data.length; i++) {
					 objMedico = data[i];
					// medicos.push(objMedico);
					// console.log("item " + item);
					// console.log("this.id " + idOrganizador);
					// console.log("objMedico " +
					// objMedico.medico.nombreCompleto);
					    content += "<li onclick=\"cargarModalPaciente('"+objMedico.codigo+"','"+ objMedico.medico.nombreCompleto +"');\" id=" + idOrganizador + '-list-item-' + i 
					    + '"><div ><span class="' + idOrganizador + ' time" id="' + idOrganizador+ '-list-item-' + i + '-time">' + objMedico.horaInicio + ' - ' + objMedico.horaTermino
					    + '</span><span class="' + idOrganizador + ' m" id="' + idOrganizador + '-list-item-' + i + '-m">' + "" 
					    + '</span></div><p id="' + idOrganizador + '-list-item-' + i + '-text">' + objMedico.medico.nombreCompleto + "</p></li>";
					  

					  document.getElementById(idOrganizador + "-list").innerHTML = content;
					 item = item + 1
					 
			}
		}else{
			// console.log("data es null");
		}

	},
	error : function(xhr, status, er) {
		console.log("error: " + xhr + " status: " + status + " er:"
				+ er);
		if (xhr.status == 500) {
			console.log(er);
			// Error_500(er);
		}
		if (xhr.status == 901) {
			console.log(er);
			// spire_session_901(er);
		}

	}
});
data = {
  years: [
  /*
	 * { int: 1999, months: [ { int: 4, days: [ { int: 28, events: [ {
	 * startTime: "6:00", endTime: "6:30", mTime: "pm", text: "Weirdo was born" } ] } ] } ] },
	 */
    {
      int: (new Date().getFullYear()),
      months: [
        {
          int: (new Date().getMonth() + 1),
          days: [
            {
              int: (new Date().getDate()),
              
              events: [
                /*
				 * { startTime: "6:00", endTime: "7:00", mTime: "am", text:
				 * "FERNANDEZ CASAS, JOSE LUIS" },{ startTime: "6:00", endTime:
				 * "7:00", mTime: "am", text: "HUERTAS CASAS, JOSE LUIS" },
				 */
              ]
            }
          ]
        }
      ]
    }
  ]
};
}

function limpiarCalendario(){
	for (i = 1; i <= 42; i++) { 
		 document.getElementById("calendarContainer-day-num-"+i).className = "";
	  
	}
	
}
function mostrarCalendarioEspecialidad(){
	this.date = new Date();
	var mes = calendar.date.getMonth()+1;
	var contextPath = $('#contextPath').val();
	console.log("this.date  " + this.date);
	var cboEspecialidad = $('#cboEspecialidad').val(); 
	lastDay = new Date((this.date.getMonth() + 1 > 11) ? this.date.getFullYear() + 1 : this.date.getFullYear(), (this.date.getMonth() + 1 > 12) ? 0 : this.date.getMonth() + 1, 0).getDate();
	for (i = 1; i <= 42; i++) { 
		 document.getElementById("calendarContainer-day-num-"+i).className = "";
	  
	}
	
	
	iniciarBloqueo();
	
	
	if (cboEspecialidad != "") {
		/**
		  let elm = document.getElementById(calendarContainer + "-day-" + blockId);

	      if(elm.className === 'calendarContainer day diluted'){
	    	  mostrarCalendarioEspecialidad(); 
	    	  console.log("esta bloqueado");
	      } else {
	    	  console.log("No esta bloqueado");
	      }
	      */
		$
		.ajax({
			type : "GET",
			// data: "entidad=" + entidad,

			url : contextPath + "/citasController/obtenerListaMedicos?codigoEspecialidad="
					+ cboEspecialidad + "&fecha=" + "",
			success : function(data) {
				if (data != null) {
					if (data.length == 0) {
						 msg_advertencia("¡No hay cupo disponible para la especialidad!"); 
					}else{ 
								  for (var j = 0; j < data.length; j++) {
									  var programacacion = data[j];
									  var todate = new Date(programacacion.fechaProgramacion);
									  var dia = todate.getDate();  
									  if ((todate.getMonth()+1 ) == mes) { 
										  for (i = 1; i <= 42; i++) { 
											  let elm = document.getElementById("calendarContainer-day-" + i);
										      if(elm.className === 'calendarContainer day'){
										    	  if(document.getElementById("calendarContainer-day-num-"+i).innerHTML == dia){
														 document.getElementById("calendarContainer-day-num-"+i).className = "calendarContainer day programado";
													  } 
										 }  
									  }
								   } 
							    } 
							// }
					}
				}else{
					 msg_advertencia("¡No hay cupo disponible para la especialidad!"); 
				}

			},
			error : function(xhr, status, er) {
				console.log("error: " + xhr + " status: " + status + " er:"
						+ er);
				if (xhr.status == 500) {
					console.log(er);
					// Error_500(er);
				}
				if (xhr.status == 901) {
					console.log(er);
					// spire_session_901(er);
				}

			}
		});
	}
	
	document.getElementById("organizerContainer-list").innerHTML ="";
	
	
	finBloqueo();
}


function showEvents() {
	
  theYear = -1, theMonth = -1, theDay = -1;
  console.log(calendar.date);
  eventos();
  for (i = 0; i < data.years.length; i++) {
    if (calendar.date.getFullYear() == data.years[i].int) {
      theYear = i;
      break;
    }
  }
  if (theYear == -1) return;
  for (i = 0; i < data.years[theYear].months.length; i++) {
    if ((calendar.date.getMonth() + 1) == data.years[theYear].months[i].int) {
      theMonth = i;
      break;
    }
  }
  if (theMonth == -1) return;
  for (i = 0; i < data.years[theYear].months[theMonth].days.length; i++) {
    if (calendar.date.getDate() == data.years[theYear].months[theMonth].days[i].int) {
      theDay = i;
      break;
    }
  }
  if (theDay == -1) return;
  theEvents = data.years[theYear].months[theMonth].days[theDay].events;  
  console.log(theEvents );
  organizer.list(theEvents); // what's responsible for listing
 
}

// showEvents();


organizer.setOnClickListener('day-slider', function () { 

	showEvents(); console.log("Day back slider clicked"); }, 
	function () { 
		showEvents(); console.log("Day next slider clicked"); 
		});

organizer.setOnClickListener('days-blocks', function () { 
	
	showEvents(); 
	console.log("Day block clicked");
	

}, null);
organizer.setOnClickListener('month-slider', function () { showEvents(); console.log("Month back slider clicked"); }, function () { showEvents(); console.log("Month next slider clicked"); });
organizer.setOnClickListener('year-slider', function () { showEvents(); console.log("Year back slider clicked"); }, function () { showEvents(); console.log("Year next slider clicked"); });

