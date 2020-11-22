// Set new default font family and font color to mimic Bootstrap's default styling
Chart.defaults.global.defaultFontFamily = 'Nunito', '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = '#858796';

function pie(arreglo){ 
	var arrayTipoPaciente = [];
	var arrayCantidad = [];
	for (i = 0; i < arreglo.length; i++) {
		arrayTipoPaciente.push(arreglo[i].tipoPaciente); 
		arrayCantidad.push(arreglo[i].cantidadItems); 
		console.log("arreglo "+ arreglo[i].tipoPaciente);
		console.log("arreglo "+ arreglo[i].cantidadItems);
	}
	
	// Pie Chart Example
	var ctx = document.getElementById("myPieChart");
	var myPieChart = new Chart(ctx, {
	  type: 'doughnut',
	  data: {
	    labels: arrayTipoPaciente,
	    datasets: [{
	      data:arrayCantidad,
	      backgroundColor: ['#4e73df', '#1cc88a', '#36b9cc', '#A9E2F3','#F3E2A9'],
	      hoverBackgroundColor: ['#2e59d9', '#17a673', '#2c9faf', '#2E9AFE','#FACC2E'],
	      hoverBorderColor: "rgba(234, 236, 244, 240, 2,3,1)",
	    }],
	  },
	  options: {
	    maintainAspectRatio: false,
	    tooltips: {
	      backgroundColor: "rgb(255,255,255)",
	      bodyFontColor: "#858796",
	      borderColor: '#dddfeb',
	      borderWidth: 1,
	      xPadding: 15,
	      yPadding: 15,
	      displayColors: false,
	      caretPadding: 10,
	    },
	    legend: {
	      display: false
	    },
	    cutoutPercentage: 80,
	  },
	});
}	

