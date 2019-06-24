package proyect.core.bean.general;
 

import proyect.base.bean.BaseBean; 

public class TurnoBean  extends BaseBean{
	 
	private String nombre; 
	private String horaInicio; 
	private String horaTermino; 
	private CatalogoBean tipoTurno;
	
	
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	public CatalogoBean getTipoTurno() {
		return tipoTurno;
	}
	public void setTipoTurno(CatalogoBean tipoTurno) {
		this.tipoTurno = tipoTurno;
	}
	@Override
	public String toString() {
		return "TurnoBean [nombre=" + nombre + ", horaInicio=" + horaInicio + ", horaTermino=" + horaTermino
				+ ", tipoTurno=" + tipoTurno + "]";
	}
	 
	
	
}
