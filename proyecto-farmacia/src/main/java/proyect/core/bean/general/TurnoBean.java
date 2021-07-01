package proyect.core.bean.general;
 

import proyect.base.bean.BaseBean; 

public class TurnoBean  extends BaseBean{
	 
	private String nombreTurno; 
	private String horaInicio; 
	private String horaTermino;  
	
	
	
	
	public String getNombreTurno() {
		return nombreTurno;
	}
	public void setNombreTurno(String nombreTurno) {
		this.nombreTurno = nombreTurno;
	}
	public String getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}
	public String getHoraTermino() {
		return horaTermino;
	}
	public void setHoraTermino(String horaTermino) {
		this.horaTermino = horaTermino;
	} 
	@Override
	public String toString() {
		return "TurnoBean [nombreTurno=" + nombreTurno + ", horaInicio=" + horaInicio + ", horaTermino=" + horaTermino
				 +"]";
	} 
	
}
