package proyect.web.test;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;


public class TestFecha {

	/**
	 * Atributo para la hora inicial del Temporizador.
	 */
	private static int HORA_INICIO;

	/**
	 * Atributo para los minutos de inicio del Temporizador.
	 */
	private static int MINUTO_INICIO;

	/**
	 * Atributo para los segundos de inicio del Temporizador.
	 */
	private static int SEGUNDOS_INICIO;
	@Test
	public void test() {
		Calendar calFin = Calendar.getInstance();
		Calendar calendar = Calendar.getInstance();
		Calendar calInicio = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");  
		//Fecha actual
	/***	
		 
		System.out.println("Fecha Actual:" + sdf.format(calendar.getTime()));
/**
		//A la fecha actual le pongo el día 1
		calendar.set(Calendar.DAY_OF_MONTH,1);
		System.out.println("Primer día del mes actual:" + sdf.format(calendar.getTime()));

		//Se le agrega 1 mes 
		calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH)+1);
		System.out.println("Fecha del del siguiente mes:" + sdf.format(calendar.getTime()));
		System.out.println("1-Último día del mes siguiente " + calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
*/
		//Se le quita 1 mes
	/**	calendar.set(Calendar.DAY_OF_MONTH,1);
		calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH)-1);//le quito 2 meses porque ya le había sumado 1 mes
		System.out.println("Fecha del primer día del mes anterior: " + sdf.format(calendar.getTime()));
		 
		calFin.set( Calendar.DAY_OF_YEAR, calendar.get(Calendar.MONTH), 
				calendar.getActualMaximum(calendar.DAY_OF_MONTH));
		
		System.out.println("Fecha del último día del mes anterior: " + sdf.format(calFin.getTime()));
		
		System.out.println("2.- Primer día del mes anterior" + calendar.getActualMinimum(Calendar.DAY_OF_MONTH)); 
		System.out.println("3.- Último día del mes anterior" + calendar.getActualMaximum(Calendar.DAY_OF_MONTH)); 
		 
	 
		 */
		String anioInicio = "2021";
		String mesInicio = "03";
		calInicio.set(Integer.parseInt(anioInicio), Integer.parseInt(mesInicio)-2, 1);  
		calFin.set(Integer.parseInt(anioInicio), 
				   Integer.parseInt(mesInicio)-2, 
				   calInicio.getActualMaximum(calInicio.DAY_OF_MONTH));
		
		System.out.println("fecha de inicio " + sdf.format(calInicio.getTime()));
		System.out.println("fecha de fin " + sdf.format(calFin.getTime()));
		 
		
	}

}
